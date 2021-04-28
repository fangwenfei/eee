# Dubbo最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、默认使用什么序列化框架，你知道的还有哪些？

推荐使用Hessian序列化，还有Dubbo、FastJson、Java自带序列化。


### 2、同一个服务多个注册的情况下可以直连某一个服务吗？

可以直连，修改配置即可，也可以通过telnet直接某个服务。


### 3、Dubbo 有哪些注册中心？

**1、** Multicast 注册中心：Multicast 注册中心不需要任何中心节点，只要广播地址，就能进行服务注册和发现,基于网络中组播传输实现。

**2、** Zookeeper 注册中心：基于分布式协调系统 Zookeeper 实现，采用 Zookeeper 的 watch 机制实现数据变更。

**3、** Redis 注册中心：基于 Redis 实现，采用 key/map 存储，key 存储服务名和类型，map 中 key 存储服务 url，value 服务过期时间。基于 Redis 的发布/订阅模式通知数据变更。

**4、** Simple 注册中心。

**5、** 推荐使用 Zookeeper 作为注册中心


### 4、Dubbo 超时时间怎样设置？

Dubbo 超时时间设置有两种方式：

服务提供者端设置超时时间，在 Dubbo 的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 5、Dubbo 和 Spring Cloud 有什么关系？

Dubbo 是 SOA 时代的产物，它的关注点主要在于服务的调用，流量分发、流量监控和熔断。而 Spring Cloud 诞生于微服务架构时代，考虑的是微服务治理的方方面面，另外由于依托了 Spring、SpringBoot 的优势之上，两个框架在开始目标就不一致，Dubbo 定位服务治理、Spring Cloud 是打造一个生态。


### 6、dubbo 推荐用什么协议？

默认使用 dubbo 协议。


### 7、为什么要用Dubbo？

随着服务化的进一步发展，服务越来越多，服务之间的调用和依赖关系也越来越复杂，诞生了面向服务的架构体系(SOA)，

也因此衍生出了一系列相应的技术，如对服务提供、服务调用、连接处理、通信协议、序列化方式、服务发现、服务路由、日志输出等行为进行封装的服务框架。

就这样为分布式系统的服务治理框架就出现了，Dubbo也就这样产生了。


### 8、Dubbo 和 Spring Cloud 的区别？

根据微服务架构在各方面的要素，看看Spring Cloud和Dubbo都提供了哪些支持。

|  | Dubbo | Spring Cloud |
| --- | --- | --- |
| 服务注册中心 | Zookeeper | Spring Cloud Netflix Eureka |
| 服务调用方式 | RPC | REST API |
| 服务网关 | 无 | Spring Cloud Netflix Zuul |
| 断路器 | 不完善 | Spring Cloud Netflix Hystrix |
| 分布式配置 | 无 | Spring Cloud Config |
| 服务跟踪 | 无 | Spring Cloud Sleuth |
| 消息总线 | 无 | Spring Cloud Bus |
| 数据流 | 无 | Spring Cloud Stream |
| 批量任务 | 无 | Spring Cloud Task |
| …… | …… | …… |


使用Dubbo构建的微服务架构就像组装电脑，各环节我们的选择自由度很高，但是最终结果很有可能因为一条内存质量不行就点不亮了，总是让人不怎么放心，但是如果你是一名高手，那这些都不是问题；而Spring Cloud就像品牌机，在Spring Source的整合下，做了大量的兼容性测试，保证了机器拥有更高的稳定性，但是如果要在使用非原装组件外的东西，就需要对其基础有足够的了解。


### 9、Dubbo 在安全机制方面是如何解决的

Dubbo 通过 Token 令牌防止用户绕过注册中心直连，然后在注册中心上管理授权。Dubbo 还提供服务黑白名单，来控制服务所允许的调用方。


### 10、Dubbo 服务降级，失败重试怎么做？

可以通过dubbo:reference 中设置 mock="return null"。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑


### 11、RPC使用了哪些关键技术，从服务提供者的角度看：
### 12、Dubbo 如何优雅停机？
### 13、服务上线怎么兼容旧版本？
### 14、服务调用超时会怎么样？
### 15、Dubbo 使用过程中都遇到了些什么问题？
### 16、Dubbo 核心组件有哪些？
### 17、dubbo能做什么
### 18、RPC的实现基础？
### 19、服务调用是阻塞的吗？
### 20、Dubbo 和 Spring Cloud 有什么哪些区别？
### 21、如何解决服务调用链过长的问题？
### 22、RPC使用了哪些关键技术，Hessian
### 23、Dubbo 可以对结果进行缓存吗？
### 24、Dubbo 支持服务降级吗？
### 25、Dubbo 和 Spring Cloud 有什么哪些区别？
### 26、同一个服务多个注册的情况下可以直连某一个服务吗？
### 27、Dubbo 用到哪些设计模式？
### 28、dubbo 在安全机制方面如何解决的？
### 29、Dubbo telnet 命令能做什么？
### 30、默认使用的是什么通信框架，还有别的选择吗?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
