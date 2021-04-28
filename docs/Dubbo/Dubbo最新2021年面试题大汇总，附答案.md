# Dubbo最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Dubbo 超时设置有哪些方式？

Dubbo 超时设置有两种方式：

**1、** 服务提供者端设置超时时间，在Dubbo的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

**2、** 服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 2、Dubbo 是什么？

Dubbo 是一款高性能、轻量级的开源 RPC 框架，提供服务自动注册、自动发现等高效服务治理方案， 可以和 Spring 框架无缝集成。


### 3、Dubbo 支持服务降级吗？

以通过 dubbo:reference 中设置 mock=“return null”。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑


### 4、同一个服务多个注册的情况下可以直连某一个服务吗？

可以直连，修改配置即可，也可以通过telnet直接某个服务。


### 5、RPC使用了哪些关键技术，主流RPC框架有哪些


### 6、Dubbo 集群容错有几种方案？
| 集群容错方案 | 说明 |
| --- | --- |
| Failover Cluster | 失败自动切换，自动重试其它服务器（默认） |
| Failfast Cluster | 快速失败，立即报错，只发起一次调用 |
| Failsafe Cluster | 失败安全，出现异常时，直接忽略 |
| Failback Cluster | 失败自动恢复，记录失败请求，定时重发 |
| Forking Cluster | 并行调用多个服务器，只要一个成功即返回 |
| Broadcast Cluster | 广播逐个调用所有提供者，任意一个报错则报错 |



### 7、Dubbo 的注册中心集群挂掉，发布者和订阅者之间还能通信么？

可以通讯。启动 Dubbo 时，消费者会从 Zookeeper 拉取注册的生产者的地址接口等数据，缓存在本地。每次调用时，按照本地存储的地址进行调用。


### 8、Dubbo SPI 和 Java SPI 区别？

**JDK SPI**

JDK 标准的 SPI 会一次性加载所有的扩展实现，如果有的扩展吃实话很耗时，但也没用上，很浪费资源。

所以只希望加载某个的实现，就不现实了

**DUBBO SPI**

1，对Dubbo进行扩展，不需要改动Dubbo的源码

2，延迟加载，可以一次只加载自己想要加载的扩展实现。

3，增加了对扩展点 IOC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。

3，Dubbo的扩展机制能很好的支持第三方IoC容器，默认支持Spring Bean。


### 9、Dubbo 和 Spring Cloud 的区别？

最大的区别：

Dubbo 底层是使用 Netty 这样的 NIO 框架，是基于TCP 协议传输的，配合以 Hession 序列化完成 RPC 通信。

而 SpringCloud 是基于 Http 协议+Rest 接口调用远程过程的通信，相对来说， Http 请求会有更大的报文，占的带宽也会更多。但是REST 相比 RPC 更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖。


### 10、dubbo 推荐用什么协议？

默认使用 dubbo 协议


### 11、为什么要用Dubbo？
### 12、你觉得用 Dubbo 好还是 Spring Cloud 好？
### 13、Dubbo 和 Spring Cloud 有什么哪些区别？
### 14、Dubbo 核心组件有哪些？
### 15、一般使用什么注册中心？还有别的选择吗？
### 16、Dubbo 在安全方面有哪些措施？
### 17、Dubbo 用到哪些设计模式？
### 18、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？
### 19、Dubbo 核心功能有哪些？
### 20、说说核心的配置有哪些？
### 21、RPC使用了哪些关键技术，序列化
### 22、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？
### 23、RPC使用了哪些关键技术，服务寻址
### 24、Dubbo 有些哪些注册中心？
### 25、dubbo 推荐用什么协议？
### 26、服务调用是阻塞的吗？
### 27、Dubbo 使用过程中都遇到了些什么问题？
### 28、服务提供者能实现失效踢出的是什么原理？
### 29、Dubbo中zookeeper做注册中心，如果注册中心集群都挂掉，者和订阅者之间还能通信么？
### 30、dubbo能做什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
