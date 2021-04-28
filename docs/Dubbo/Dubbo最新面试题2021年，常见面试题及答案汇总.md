# Dubbo最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、集群容错怎么做？

读操作建议使用 Failover 失败自动切换，默认重试两次其他服务器。写操作建议使用 Failfast 快速失败，发一次调用失败就立即报错。


### 2、RPC使用了哪些关键技术，protobuf-rpc-pro

是一个Java类库，提供了基于 Google 的 Protocol Buffers 协议的远程方法调用的框架。基于 Netty 底层的 NIO 技术。支持 TCP 重用/ keep-alive、SSL加密、RPC 调用取消操作、嵌入式日志等功能。


### 3、Dubbo 服务器注册与发现的流程？

**1、** 服务容器Container负责启动，加载，运行服务提供者。

**2、** 服务提供者Provider在启动时，向注册中心注册自己提供的服务。

**3、** 服务消费者Consumer在启动时，向注册中心订阅自己所需的服务。

**4、** 注册中心Registry返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。

**5、** 服务消费者Consumer，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。

**6、** 服务消费者Consumer和提供者Provider，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心Monitor。


### 4、Dubbo有哪几种集群容错方案，默认是哪种？

**1、** Failover Cluster 失败自动切换，自动重试其他服务器(默认)

**2、** Failfast Cluster 快速失败，立即报错，只发起一次调用

**3、** Failsafe Cluster 失败安全，出现异常时，直接忽略

**4、** Failback Cluster 失败自动回复，记录失败请求，定时请求

**5、** Forking Cluster  并行调用多个服务器，只要一个成功即返回

**6、** Broadcast Cluster 广播逐个调用所有提供者，任意一个报错则报错


### 5、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？

**1、** dubbo：单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步， Hessian 序列化；

**2、** rmi：采用 JDK 标准的 rmi 协议实现，传输参数和返回参数对象需要实现 Serializable 接口，使用 java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。多个短连接， TCP 协议传输，同步传输，适用常规的远程服务调用和rmi 互操作。在依赖低版本的 Common-Collections包， java 序列化存在安全漏洞；

**3、** webservice：基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用；

**4、** http：基于 Http 表单提交的远程调用协议，使用 Spring 的HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用；

**5、** hessian：集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务， Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输， Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件；

**6、** memcache：基于 Memcached 实现的 RPC 协议

**7、** Redis：基于 Redis 实现的 RPC 协议


### 6、Dubbo SPI 和 Java SPI 区别？

**JDK SPI：**

JDK 标准的 SPI 会一次性加载所有的扩展实现，如果有的扩展很耗时，但也没用上，很浪费资源。所以只希望加载某个的实现，就不现实了

**DUBBO SPI：**

**1、** 对 Dubbo 进行扩展，不需要改动 Dubbo 的源码

**2、** 延迟加载，可以一次只加载自己想要加载的扩展实现。

**3、** 增加了对扩展点 IOC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。

**4、** Dubbo 的扩展机制能很好的支持第三方 IoC 容器，默认支持 Spring Bean。


### 7、dubbo和dubbox之间的区别？

dubbox是当当网基于dubbo上做了一些扩展，如加了服务可restful调用，更新了开源组件等。


### 8、服务调用超时问题怎么解决？

dubbo 在调用服务不成功时，默认是会重试两次的。


### 9、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？

dubbo： 单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步，Hessian 序列化；

rmi： 采用 JDK 标准的 rmi 协议实现，传输参数和返回参数对象需要实现 Serializable 接口，使用 java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。 多个短连接，TCP 协议传输，同步传输，适用常规的远程服务调用和 rmi 互操作。在依赖低版本的 Common-Collections 包，java 序列化存在安全漏洞；

webservice:基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用；http： 基于 Http 表单提交的远程调用协议，使用 Spring 的 HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用； hessian： 集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务，Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输，Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件；

memcache： 基于 Memcached 实现的 RPC 协议 Redis： 基于 Redis 实现的 RPC 协议


### 10、dubbo推荐用什么协议？

默认使用dubbo协议。


### 11、RPC使用了哪些关键技术，动态代理
### 12、在使用过程中都遇到了些什么问题？ 如何解决的？
### 13、Dubbo的集群容错方案有哪些？
### 14、Dubbo Monitor 实现原理？
### 15、RPC使用了哪些关键技术，服务寻址
### 16、dubbo 通信协议 dubbo 协议为什么采用异步单一长连接
### 17、RPC使用了哪些关键技术，RPC的实现原理架构图
### 18、RPC使用了哪些关键技术，序列化
### 19、RPC使用了哪些关键技术，服务调用
### 20、Dubbo 能集成 SpringBoot 吗？
### 21、Dubbo 集群的负载均衡有哪些策略
### 22、Dubbo服务之间的调用是阻塞的吗？
### 23、你还了解别的分布式框架吗？
### 24、Dubbo 的注册中心集群挂掉，发布者和订阅者之间还能通信么？
### 25、服务调用超时问题怎么解决
### 26、Dubbo 核心功能有哪些？
### 27、Dubbo 核心组件有哪些？
### 28、说说核心的配置有哪些？
### 29、dubbo是什么
### 30、Dubbo 支持哪些序列化方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
