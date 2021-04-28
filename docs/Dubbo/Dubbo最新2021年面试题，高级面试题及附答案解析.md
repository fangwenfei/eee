# Dubbo最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、RPC使用了哪些关键技术，从服务提供者的角度看：

当服务提供者启动的时候，需要将自己提供的服务注册到指定的注册中心，以便服务消费者能够通过服务注册中心进行查找；

当服务提供者由于各种原因致使提供的服务停止时，需要向注册中心注销停止的服务；

服务的提供者需要定期向服务注册中心发送心跳检测，服务注册中心如果一段时间未收到来自服务提供者的心跳后，认为该服务提供者已经停止服务，则将该服务从注册中心上去掉。


### 2、RPC框架需要解决的问题？

**1、** 如何确定客户端和服务端之间的通信协议？

**2、** 如何更高效地进行网络通信？

**3、** 服务端提供的服务如何暴露给客户端？

**4、** 客户端如何发现这些暴露的服务？

**5、** 如何更高效地对请求对象和响应结果进行序列化和反序列化操作？


### 3、Dubbo 和 Spring Cloud 的区别？

最大的区别：

Dubbo 底层是使用 Netty 这样的 NIO 框架，是基于TCP 协议传输的，配合以 Hession 序列化完成 RPC 通信。

而 SpringCloud 是基于 Http 协议+Rest 接口调用远程过程的通信，相对来说， Http 请求会有更大的报文，占的带宽也会更多。但是REST 相比 RPC 更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖。


### 4、Dubbo的管理控制台能做什么？

管理控制台主要包含：路由规则，动态配置，服务降级，访问控制，权重调整，负载均衡，等管理功能


### 5、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。Dubbo 是基于 NIO 的非阻塞实现并行调用，客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，异步调用会返回一个 Future 对象。


### 6、RPC使用了哪些关键技术，protobuf-rpc-pro

是一个Java类库，提供了基于 Google 的 Protocol Buffers 协议的远程方法调用的框架。基于 Netty 底层的 NIO 技术。支持 TCP 重用/ keep-alive、SSL加密、RPC 调用取消操作、嵌入式日志等功能。


### 7、Dubbo 支持哪些序列化方式？

默认使用 Hessian 序列化，还有 Duddo、 FastJson、 Java 自带序列化。


### 8、如何解决服务调用链过长的问题？

Dubbo 可以使用 Pinpoint 和 Apache Skywalking(Incubator) 实现分布式服务追踪，当然还有其他很多方案。


### 9、默认使用的是什么通信框架，还有别的选择吗?

默认也推荐使用 netty 框架，还有 mina。


### 10、Dubbo Monitor 实现原理？

Consumer 端在发起调用之前会先走 filter 链；provider 端在接收到请求时也是先走 filter 链，然后才进行真正的业务逻辑处理。默认情况下，在 consumer 和 provider 的 filter 链中都会有 Monitorfilter。

**1、** MonitorFilter 向 DubboMonitor 发送数据

**2、** DubboMonitor 将数据进行聚合后（默认聚合 1min 中的统计数据）暂存到ConcurrentMap<Statistics, AtomicReference> statisticsMap，然后使用一个含有 3 个线程（线程名字：DubboMonitorSendTimer）的线程池每隔 1min 钟，调用 SimpleMonitorService 遍历发送 statisticsMap 中的统计数据，每发送完毕一个，就重置当前的 Statistics 的 AtomicReference

**3、** SimpleMonitorService 将这些聚合数据塞入 BlockingQueue queue 中（队列大写为 100000）

**4、** SimpleMonitorService 使用一个后台线程（线程名为：DubboMonitorAsyncWriteLogThread）将 queue 中的数据写入文件（该线程以死循环的形式来写）

**5、** SimpleMonitorService 还会使用一个含有 1 个线程（线程名字：DubboMonitorTimer）的线程池每隔 5min 钟，将文件中的统计数据画成图表


### 11、Dubbo集群提供了哪些负载均衡策略？
### 12、服务读写推荐的容错策略是怎样的？
### 13、dubbo 通信协议 dubbo 协议适用范围和适用场景
### 14、服务提供者能实现失效踢出是什么原理？
### 15、Dubbo Monitor 实现原理？
### 16、集群容错怎么做？
### 17、dubbo 服务负载均衡策略？
### 18、Dubbo 和 Spring Cloud 有什么关系？
### 19、RPC使用了哪些关键技术，服务调用
### 20、RPC使用了哪些关键技术，Hessian
### 21、Dubbo 使用的是什么通信框架?
### 22、Dubbo 有哪些注册中心？
### 23、默认使用什么序列化框架，你知道的还有哪些？
### 24、Dubbo 核心组件有哪些？
### 25、dubbo和dubbox之间的区别？
### 26、Dubbo 可以对结果进行缓存吗？
### 27、dubbo 连接注册中心和直连的区别
### 28、RPC使用了哪些关键技术，序列化和反序列化
### 29、你还了解别的分布式框架吗？
### 30、Dubbo 和 Spring Cloud 有什么哪些区别？
### 31、同一个服务多个注册的情况下可以直连某一个服务吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
