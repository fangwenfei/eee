# Dubbo最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Dubbo 使用的是什么通信框架?

默认使用 NIO Netty 框架


### 2、Dubbo 集群容错有几种方案？
| 集群容错方案 | 说明 |
| --- | --- |
| Failover Cluster | 失败自动切换，自动重试其它服务器（默认） |
| Failfast Cluster | 快速失败，立即报错，只发起一次调用 |
| Failsafe Cluster | 失败安全，出现异常时，直接忽略 |
| Failback Cluster | 失败自动恢复，记录失败请求，定时重发 |
| Forking Cluster | 并行调用多个服务器，只要一个成功即返回 |
| Broadcast Cluster | 广播逐个调用所有提供者，任意一个报错则报错 |



### 3、Dubbo 推荐用什么协议？

- dubbo://（推荐）
- rmi://
- hessian://
- http://
- webservice://
- thrift://
- Memcached://
- Redis://
- rest://


### 4、Dubbo 超时时间怎样设置？

**Dubbo 超时时间设置有两种方式：**

服务提供者端设置超时时间，在 Dubbo 的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 5、Dubbo 和 Dubbox 之间的区别？

Dubbox 是继 Dubbo 停止维护后，当当网基于 Dubbo 做的一个扩展项目，如加了服务可 Restful 调用，更新了开源组件等。


### 6、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？

**1、** dubbo：单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步， Hessian 序列化；

**2、** rmi：采用 JDK 标准的 rmi 协议实现，传输参数和返回参数对象需要实现Serializable 接口，使用 java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。多个短连接， TCP 协议传输，同步传输，适用常规的远程服务调用和 rmi 互操作。在依赖低版本的 Common-Collections 包， java 序列化存在安全漏洞；

**3、** http：基于 Http 表单提交的远程调用协议，使用 Spring 的 HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用；

**4、** webservice：基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用；

**5、** hessian：集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务，Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输， Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件；

**6、** Redis：基于 Redis 实现的 RPC 协议


### 7、服务提供者能实现失效踢出是什么原理？

服务失效踢出基于 Zookeeper 的临时节点原理


### 8、Dubbo 超时设置有哪些方式？

**Dubbo 超时设置有两种方式：**

服务提供者端设置超时时间，在Dubbo的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 9、服务提供者能实现失效踢出是什么原理？

服务失效踢出基于zookeeper的临时节点原理。


### 10、服务上线怎么兼容旧版本？

可以用版本号（version）过渡，多个不同版本的服务注册到注册中心，版本号不同的服务相互间不引用。这个和服务分组的概念有一点类似。


### 11、服务提供者能实现失效踢出是什么原理？
### 12、Dubbo集群提供了哪些负载均衡策略？
### 13、dubbo推荐用什么协议？
### 14、Dubbo必须依赖的包有哪些？
### 15、为什么要用Dubbo？
### 16、一般使用什么注册中心？还有别的选择吗？
### 17、Dubbo 可以对结果进行缓存吗？
### 18、同一个服务多个注册的情况下可以直连某一个服务吗？
### 19、dubbo 连接注册中心和直连的区别
### 20、Dubbo Monitor 实现原理？
### 21、Dubbo 与 Spring 的关系？
### 22、Dubbo的集群容错方案有哪些？
### 23、RPC使用了哪些关键技术，主流RPC框架有哪些
### 24、Dubbo 集群的负载均衡有哪些策略?
### 25、Dubbo 能集成 SpringBoot 吗？
### 26、Dubbo 有哪些注册中心？
### 27、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？
### 28、为什么需要服务治理？
### 29、Dubbo的集群容错方案有哪些？
### 30、Dubbo 必须依赖的包有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
