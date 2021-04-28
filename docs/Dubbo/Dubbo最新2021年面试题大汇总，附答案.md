# Dubbo最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Dubbo telnet 命令能做什么？

dubbo 服务发布之后，我们可以利用 telnet 命令进行调试、管理。Dubbo2.0.5 以上版本服务提供端口支持 telnet 命令


### 2、Dubbo 支持分布式事务吗？

**1、** 目前暂时不支持，可与通过 tcc-transaction 框架实现

**2、** 介绍：tcc-transaction 是开源的 TCC 补偿性分布式事务框架

**3、** TCC-Transaction 通过 Dubbo 隐式传参的功能，避免自己对业务代码的入侵。


### 3、服务提供者能实现失效踢出是什么原理？

服务失效踢出基于zookeeper的临时节点原理。


### 4、如何解决服务调用链过长的问题？

可以结合 zipkin 实现分布式服务追踪。


### 5、你还了解别的分布式框架吗？

别的还有spring的spring cloud，facebook的thrift，twitter的finagle等



### 6、Dubbo集群提供了哪些负载均衡策略？

**1、** Random LoadBalance: 随机选取提供者策略，有利于动态调整提供者权重。截面碰撞率高，调用次数越多，分布越均匀。

**2、** RoundRobin LoadBalance: 轮循选取提供者策略，平均分布，但是存在请求累积的问题。

**3、** LeastActive LoadBalance: 最少活跃调用策略，解决慢提供者接收更少的请求。

**4、** ConstantHash LoadBalance: 一致性 Hash 策略，使相同参数请求总是发到同一提供者，一台机器宕机，可以基于虚拟节点，分摊至其他提供者，避免引起提供者的剧烈变动。

默认为 Random 随机调用。


### 7、一般使用什么注册中心？还有别的选择吗？

推荐使用 Zookeeper 作为注册中心，还有 Redis、Multicast、Simple 注册中心，但不推荐。


### 8、RPC使用了哪些关键技术，RMI

利用java.rmi包实现，基于Java远程方法协议(Java Remote Method Protocol) 和java的原生序列化。


### 9、dubbo 和 dubbox 之间的区别？

dubbox 是当当网基于 dubbo 上做了一些扩展，如加了服务可 restful 调用，更新了开源组件等。推荐阅读：厉害了，Dubbo 正式毕业！建议看下它的发展史！


### 10、你觉得用 Dubbo 好还是 Spring Cloud 好？

扩展性的问题，没有好坏，只有适合不适合，不过我好像更倾向于使用 Dubbo, Spring Cloud 版本升级太快，组件更新替换太频繁，配置太繁琐，还有很多我觉得是没有 Dubbo 顺手的地方。


### 11、Dubbo 的集群容错方案有哪些？
### 12、RPC使用了哪些关键技术，从调用者的角度看：
### 13、说说核心的配置有哪些？
### 14、dubbo 服务负载均衡策略？
### 15、RPC使用了哪些关键技术，NIO通信
### 16、Dubbo有哪几种负载均衡策略，默认是哪种？
### 17、服务提供者能实现失效踢出是什么原理？
### 18、Dubbo服务降级，失败重试怎么做？
### 19、同一个服务多个注册的情况下可以直连某一个服务吗？
### 20、RPC框架需要解决的问题？
### 21、注册了多个同一样的服务，如果测试指定的某一个服务呢？
### 22、当一个服务接口有多种实现时怎么做？
### 23、Dubbo的管理控制台能做什么？
### 24、RPC使用了哪些关键技术，主流RPC框架有哪些
### 25、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 26、Dubbo 集群提供了哪些负载均衡策略？
### 27、Dubbo 超时设置有哪些方式？
### 28、Dubbo 集群的负载均衡有哪些策略?
### 29、服务提供者能实现失效踢出是什么原理？
### 30、Dubbo 有些哪些注册中心？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
