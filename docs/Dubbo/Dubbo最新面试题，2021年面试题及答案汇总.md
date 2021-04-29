# Dubbo最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、RPC使用了哪些关键技术，反序列化

当B机器接收到A机器的应用发来的请求之后，又需要对接收到的参数等信息进行反序列化操作（序列化的逆操作），即将二进制信息恢复为内存中的表达方式，然后再找到对应的方法（寻址的一部分）进行本地调用（一般是通过生成代理Proxy去调用, 通常会有JDK动态代理、CGLIB动态代理、Javassist生成字节码技术等），之后得到调用的返回值。


### 2、你还了解别的分布式框架吗？

别的还有spring的spring cloud，facebook的thrift，twitter的finagle等。


### 3、你觉得用 Dubbo 好还是 Spring Cloud 好？

扩展性的问题，没有好坏，只有适合不适合，不过我好像更倾向于使用 Dubbo, Spring Cloud 版本升级太快，组件更新替换太频繁，配置太繁琐，还有很多我觉得是没有 Dubbo 顺手的地方。


### 4、什么是RPC

RPC（Remote Procedure Call Protocol）远程过程调用协议，它是一种通过网络从远程计算机程序上请求服务，而不需要了解底层网络技术的协议。简言之，RPC使得程序能够像访问本地系统资源一样，去访问远端系统资源。比较关键的一些方面包括：通讯协议、序列化、资源（接口）描述、服务框架、性能、语言支持等。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/026/54/80_3.png#alt=80%5C_3.png)

简单的说，RPC就是从一台机器(客户端)上通过参数传递的方式调用另一台机器(服务器)上的一个函数或方法(可以统称为服务)并得到返回的结果。


### 5、dubbo 和 dubbox 之间的区别？

dubbox 是当当网基于 dubbo 上做了一些扩展，如加了服务可 restful 调用，更新了开源组件等。推荐阅读：厉害了，Dubbo 正式毕业！建议看下它的发展史！


### 6、如何解决服务调用链过长的问题？

Dubbo 可以使用 Pinpoint 和 Apache Skywalking(Incubator) 实现分布式服务追踪，当然还有其他很多方案。


### 7、Dubbo 超时设置有哪些方式？

Dubbo 超时设置有两种方式：

**1、** 服务提供者端设置超时时间，在Dubbo的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

**2、** 服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 8、RPC使用了哪些关键技术，服务注册中心

可选：Redis、Zookeeper、Consul 、Etcd。一般使用ZooKeeper提供服务注册与发现功能，解决单点故障以及分布式部署的问题(注册中心)。


### 9、Dubbo 支持分布式事务吗？

**1、** 目前暂时不支持，可与通过 tcc-transaction 框架实现

**2、** 介绍：tcc-transaction 是开源的 TCC 补偿性分布式事务框架

**3、** TCC-Transaction 通过 Dubbo 隐式传参的功能，避免自己对业务代码的入侵。


### 10、Dubbo 的默认集群容错方案？

Failover Cluster


### 11、说说 Dubbo 服务暴露的过程。
### 12、Dubbo Monitor 实现原理？
### 13、Dubbo 服务降级，失败重试怎么做？
### 14、如何解决服务调用链过长的问题？
### 15、说说核心的配置有哪些？
### 16、Dubbo 配置文件是如何加载到 Spring 中的？
### 17、Dubbo必须依赖的包有哪些？
### 18、RPC框架需要解决的问题？
### 19、Dubbo 用到哪些设计模式？
### 20、说说核心的配置有哪些？
### 21、Dubbo的集群容错方案有哪些？
### 22、Dubbo 集群提供了哪些负载均衡策略？
### 23、Dubbo集群提供了哪些负载均衡策略？
### 24、当一个服务接口有多种实现时怎么做？
### 25、Dubbo 核心功能有哪些？
### 26、Dubbo有哪几种负载均衡策略，默认是哪种？
### 27、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？
### 28、Dubbo SPI 和 Java SPI 区别？
### 29、Dubbo SPI 和 Java SPI 区别？
### 30、Dubbo 使用过程中都遇到了些什么问题？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
