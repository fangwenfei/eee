# Dubbo最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、dubbo 通信协议 dubbo 协议为什么采用异步单一长连接

因为服务的现状大都是服务提供者少，通常只有几台机器，而服务的消费者多，可能整个网站都在访问该服务，比如 Morgan 的提供者只有 6 台提供者，却有上百台消费者，每天有 1.5 亿次调用，如果采用常规的 hessian 服务，服务提供者很容易就被压跨，通过单一连接，保证单一消费者不会压死提供者，长连接，减少连接握手验证等，并使用异步 IO，复用线程池，防止 C10K 问题。


### 2、dubbo 推荐用什么协议？

默认使用 dubbo 协议


### 3、说说核心的配置有哪些？

dubbo:service

dubbo:reference

dubbo:protocol

dubbo:registry

dubbo:application

dubbo:provider

dubbo:consumer

dubbo:method


### 4、Dubbo 超时时间怎样设置？

**Dubbo 超时时间设置有两种方式：**

服务提供者端设置超时时间，在 Dubbo 的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 5、Dubbo 支持分布式事务吗？

目前暂时不支持，可与通过 tcc-transaction框架实现

介绍：tcc-transaction是开源的TCC补偿性分布式事务框架

Git地址：[https://github.com/changmingxie/tcc-transaction](https://github.com/changmingxie/tcc-transaction)

TCC-Transaction 通过 Dubbo 隐式传参的功能，避免自己对业务代码的入侵。


### 6、Dubbo 和 Dubbox 之间的区别？

Dubbox 是继 Dubbo 停止维护后，当当网基于 Dubbo 做的一个扩展项目，如加了服务可 Restful 调用，更新了开源组件等。


### 7、Dubbo 服务降级，失败重试怎么做？

可以通过dubbo:reference 中设置 mock="return null"。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑


### 8、RPC的实现基础？
### 9、Dubbo 和 Spring Cloud 的区别？
### 10、Dubbo 支持服务降级吗？
### 11、Dubbo 的注册中心集群挂掉，发布者和订阅者之间还能通信么？
### 12、RPC使用了哪些关键技术，主流RPC框架有哪些
### 13、Dubbo 配置文件是如何加载到 Spring 中的？
### 14、Dubbo telnet 命令能做什么？
### 15、Dubbo 服务注册与发现的流程？
### 16、Dubbo 使用的是什么通信框架?
### 17、Dubbo 集群的负载均衡有哪些策略?
### 18、RPC使用了哪些关键技术，序列化
### 19、Dubbo 超时设置有哪些方式？
### 20、Dubbo 有些哪些注册中心？
### 21、Dubbo 必须依赖的包有哪些？
### 22、同一个服务多个注册的情况下可以直连某一个服务吗？
### 23、如何解决服务调用链过长的问题？
### 24、说说 Dubbo 服务暴露的过程。
### 25、服务上线怎么不影响旧版本？
### 26、默认使用什么序列化框架，你知道的还有哪些？
### 27、Dubbo 与 Spring 的关系？
### 28、dubbo 服务负载均衡策略？
### 29、Dubbo集群提供了哪些负载均衡策略？
### 30、服务调用超时问题怎么解决
### 31、RPC使用了哪些关键技术，RMI




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
