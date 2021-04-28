# Dubbo最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Dubbo 和 Dubbox 之间的区别？

dubbox 基于 dubbo 上做了一些扩展，如加了服务可 restful 调用，更新了开源组件等。


### 2、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。


### 3、Dubbo 的默认集群容错方案？

Failover Cluster


### 4、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？

**1、** dubbo：单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步， Hessian 序列化；

**2、** rmi：采用 JDK 标准的 rmi 协议实现，传输参数和返回参数对象需要实现Serializable 接口，使用 java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。多个短连接， TCP 协议传输，同步传输，适用常规的远程服务调用和 rmi 互操作。在依赖低版本的 Common-Collections 包， java 序列化存在安全漏洞；

**3、** http：基于 Http 表单提交的远程调用协议，使用 Spring 的 HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用；

**4、** webservice：基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用；

**5、** hessian：集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务，Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输， Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件；

**6、** Redis：基于 Redis 实现的 RPC 协议


### 5、Dubbo 必须依赖的包有哪些？

Dubbo 必须依赖 JDK，其他为可选。


### 6、dubbo 服务集群配置（集群容错模式）

在集群调用失败时， Dubbo 提供了多种容错方案，缺省为 failover 重试。可以自行扩展集群容错策略

l Failover Cluster(默认)

失败自动切换，当出现失败，重试其它服务器。(缺省)通常用于读操作，

但重试会带来更长延迟。可通过 retries="2"来设置重试次数(不含第一次)。

```
<dubbo:service retries="2" cluster="failover"/>或：<dubbo:reference retries="2" cluster="failover"/>cluster="failover"可以不用写,因为默认就是 failover
```

**Failfast Cluster**

快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，

比如新增记录。

```
dubbo:service cluster="failfast" />
```

或：

```
<dubbo:reference cluster="failfast" />

cluster="failfast"和 把 cluster="failover"、 retries="0"是一样的效果,retries="0"就是不重
```

Failsafe Cluster失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。

```
<dubbo:service cluster="failsafe" />
```

或：

```
<dubbo:reference cluster="failsafe" />
```

**Failback Cluster**

失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。

```
<dubbo:service cluster="failback" />
```

或：

```
<dubbo:reference cluster="failback" />
```

Forking Cluster并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读

操作，但需要浪费更多服务资源。可通过 forks="2"来设置最大并行数。

```
<dubbo:service cluster=“forking" forks="2"/>
```

或：

```
<dubbo:reference cluster=“forking" forks="2"/>
```


### 7、Dubbo 默认采用注册中心？

采用 Zookeeper


### 8、说说 Dubbo 服务暴露的过程。

Dubbo 会在 Spring 实例化完 bean 之后，在刷新容器最后一步发布 ContextRefreshEvent 事件的时候，通知实现了 ApplicationListener 的 ServiceBean 类进行回调 onApplicationEvent 事件方法，Dubbo 会在这个方法中调用 ServiceBean 父类 ServiceConfig 的 export 方法，而该方法真正实现了服务的（异步或者非异步）发布。


### 9、Dubbo必须依赖的包有哪些？

Dubbo 必须依赖 JDK，其他为可选。


### 10、一般使用什么注册中心？还有别的选择吗？

推荐使用 zookeeper 注册中心，还有 Multicast注册中心, Redis注册中心, Simple注册中心。

ZooKeeper的节点是通过像树一样的结构来进行维护的，并且每一个节点通过路径来标示以及访问。

除此之外，每一个节点还拥有自身的一些信息，包括：数据、数据长度、创建时间、修改时间等等。


### 11、Dubbo 的架构设计
### 12、RPC使用了哪些关键技术，建立通信
### 13、Dubbo 集群容错有几种方案？
### 14、说说核心的配置有哪些？
### 15、Dubbo的集群容错方案有哪些？
### 16、dubbo 通信协议 dubbo 协议适用范围和适用场景
### 17、Dubbo 类似的分布式框架还有哪些？
### 18、默认使用什么序列化框架，你知道的还有哪些？
### 19、服务调用是阻塞的吗？
### 20、Dubbo 推荐用什么协议？
### 21、Dubbo 支持哪些序列化方式？
### 22、RPC使用了哪些关键技术，序列化和反序列化
### 23、Dubbo可以对结果进行缓存吗？
### 24、RPC使用了哪些关键技术，服务注册中心
### 25、Dubbo 的使用场景有哪些？
### 26、Dubbo 使用过程中都遇到了些什么问题？
### 27、服务上线怎么不影响旧版本？
### 28、Dubbo 在安全方面有哪些措施？
### 29、什么是RPC
### 30、Dubbo 服务降级，失败重试怎么做？
### 31、集群容错怎么做？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
