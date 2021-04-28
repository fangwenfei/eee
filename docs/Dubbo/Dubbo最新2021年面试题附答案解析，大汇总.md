# Dubbo最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、dubbo 在安全机制方面如何解决的？

dubbo 通过 token 令牌防止用户绕过注册中心直连，然后在注册中心管理授权，dubbo 提供了黑白名单，控制服务所允许的调用方。


### 2、Dubbo必须依赖的包有哪些？

Dubbo 必须依赖 JDK，其他为可选。


### 3、Dubbo可以对结果进行缓存吗？

可以，Dubbo 提供了声明式缓存，用于加速热门数据的访问速度，以减少用户加缓存的工作量


### 4、Dubbo 支持哪些协议，它们的优缺点有哪些？

**1、** Dubbo： 单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步 Hessian 序列化。Dubbo推荐使用dubbo协议。

**2、** RMI： 采用 JDK 标准的 RMI 协议实现，传输参数和返回参数对象需要实现 Serializable 接口，使用 Java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。 多个短连接 TCP 协议传输，同步传输，适用常规的远程服务调用和 RMI 互操作。在依赖低版本的 Common-Collections 包，Java 序列化存在安全漏洞。

**3、** WebService：基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用。

**4、** HTTP： 基于 Http 表单提交的远程调用协议，使用 Spring 的 HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用。

**5、** Hessian：集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务，Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输，Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件。

**6、** Memcache：基于 Memcache实现的 RPC 协议。

**7、** Redis：基于 Redis 实现的RPC协议。


### 5、Dubbo 使用的是什么通信框架?

默认使用 Netty 作为通讯框架。


### 6、Dubbo Monitor 实现原理？

Consumer端在发起调用之前会先走filter链；provider端在接收到请求时也是先走filter链，然后才进行真正的业务逻辑处理。

默认情况下，在consumer和provider的filter链中都会有Monitorfilter。

**1、** MonitorFilter向DubboMonitor发送数据

**2、** DubboMonitor将数据进行聚合后（默认聚合1min中的统计数据）暂存到ConcurrentMap<Statistics, AtomicReference> statisticsMap，然后使用一个含有3个线程（线程名字：DubboMonitorSendTimer）的线程池每隔1min钟，调用SimpleMonitorService遍历发送statisticsMap中的统计数据，每发送完毕一个，就重置当前的Statistics的AtomicReference

**3、** SimpleMonitorService将这些聚合数据塞入BlockingQueue queue中（队列大写为100000）

**4、** SimpleMonitorService使用一个后台线程（线程名为：DubboMonitorAsyncWriteLogThread）将queue中的数据写入文件（该线程以死循环的形式来写）

**5、** SimpleMonitorService还会使用一个含有1个线程（线程名字：DubboMonitorTimer）的线程池每隔5min钟，将文件中的统计数据画成图表


### 7、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。Dubbo 是基于 NIO 的非阻塞实现并行调用，客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，异步调用会返回一个 Future 对象。


### 8、Dubbo 服务降级，失败重试怎么做？

可以通过 dubbo:reference 中设置 mock=“return null”。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑


### 9、dubbo 通信协议 dubbo 协议为什么采用异步单一长连接

因为服务的现状大都是服务提供者少，通常只有几台机器，而服务的消费者多，可能整个网站都在访问该服务，比如 Morgan 的提供者只有 6 台提供者，却有上百台消费者，每天有 1.5 亿次调用，如果采用常规的 hessian 服务，服务提供者很容易就被压跨，通过单一连接，保证单一消费者不会压死提供者，长连接，减少连接握手验证等，并使用异步 IO，复用线程池，防止 C10K 问题。


### 10、Dubbo 服务器注册与发现的流程？

**1、** Provider（提供者）绑定指定端口并启动服务。

**2、** 提供者连接注册中心，并发本机 IP、端口、应用信息和提供服务信息发送至注册中心存储。

**3、** Consumer（消费者），连接注册中心 ，并发送应用信息、所求服务信息至注册中心。

**4、** 注册中心根据消费者所求服务信息匹配对应的提供者列表发送至 Consumer 应用缓存。

**5、** Consumer 在发起远程调用时基于缓存的消费者列表择其一发起调用。

**6、** Provider 状态变更会实时通知注册中心、在由注册中心实时推送至 Consumer。


### 11、Dubbo 服务注册与发现的流程？
### 12、Dubbo 是什么？
### 13、Dubbo 集群提供了哪些负载均衡策略？
### 14、Dubbo 和 Spring Cloud 的区别？
### 15、Dubbo 与 Spring 的关系？
### 16、Dubbo 必须依赖的包有哪些？
### 17、Dubbo 有哪些注册中心？
### 18、Dubbo 的整体架构设计有哪些分层?
### 19、为什么要有RPC
### 20、Dubbo 集群的负载均衡有哪些策略
### 21、Dubbo 可以对结果进行缓存吗？
### 22、同一个服务多个注册的情况下可以直连某一个服务吗？
### 23、dubbo和dubbox之间的区别？
### 24、Dubbo 的主要应用场景？
### 25、Dubbo 和 Spring Cloud 有什么关系？
### 26、Dubbo 类似的分布式框架还有哪些？
### 27、Dubbo 推荐用什么协议？
### 28、Dubbo 在安全机制方面是如何解决的
### 29、Dubbo 核心组件有哪些？
### 30、dubbo 通信协议 dubbo 协议适用范围和适用场景
### 31、Dubbo 服务降级，失败重试怎么做？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
