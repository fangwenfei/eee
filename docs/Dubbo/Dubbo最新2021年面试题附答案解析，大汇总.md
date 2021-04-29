# Dubbo最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Dubbo SPI 和 Java SPI 区别？

**JDK SPI**

JDK 标准的 SPI 会一次性加载所有的扩展实现，如果有的扩展吃实话很耗时，但也没用上，很浪费资源。

所以只希望加载某个的实现，就不现实了

**DUBBO SPI**

1，对Dubbo进行扩展，不需要改动Dubbo的源码

2，延迟加载，可以一次只加载自己想要加载的扩展实现。

3，增加了对扩展点 IOC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。

3，Dubbo的扩展机制能很好的支持第三方IoC容器，默认支持Spring Bean。


### 2、说说核心的配置有哪些？
| 标签 | 用途 | 解释 |
| --- | --- | --- |
| [dubbo:service/]() | 服务配置 | 用于暴露一个服务，定义服务的元信息，一个服务可以用多个协议暴露，一个服务也可以注册到多个注册中心 |
| [dubbo:reference/]() | 引用配置 | 用于创建一个远程服务代理，一个引用可以指向多个注册中心 |
| [dubbo:protocol/]() | 协议配置 | 用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受 |
| [dubbo:application/]() | 应用配置 | 用于配置当前应用信息，不管该应用是提供者还是消费者 |
| [dubbo:module/]() | 模块配置 | 用于配置当前模块信息，可选 |
| [dubbo:registry/]() | 注册中心配置 | 用于配置连接注册中心相关信息 |
| [dubbo:monitor/]() | 监控中心配置 | 用于配置连接监控中心相关信息，可选 |
| [dubbo:provider/]() | 提供方配置 | 当 ProtocolConfig 和 ServiceConfig 某属性没有配置时，采用此缺省值，可选 |
| [dubbo:consumer/]() | 消费方配置 | 当 ReferenceConfig 某属性没有配置时，采用此缺省值，可选 |
| [dubbo:method/]() | 方法配置 | 用于 ServiceConfig 和 ReferenceConfig 指定方法级的配置信息 |
| [dubbo:argument]() | 参数配置 | 用于指定方法参数配置 |


`如果是SpringBoot项目就只需要注解，或者开Application配置文件！！！`


### 3、dubbo 通信协议 dubbo 协议适用范围和适用场景

适用范围：传入传出参数数据包较小（建议小于 100K），消费者比提供者个数多，单一消费者无法压满提供者，尽量不要用 dubbo 协议传输大文件或超大字符串。

适用场景：常规远程服务方法调用

dubbo 协议补充：

连接个数：单连接

连接方式：长连接

传输协议：TCP

传输方式：NIO 异步传输

序列化：Hessian 二进制序列化


### 4、服务读写推荐的容错策略是怎样的？

读操作建议使用 Failover 失败自动切换，默认重试两次其他服务器。写操作建议使用 Failfast 快速失败，发一次调用失败就立即报错。


### 5、RPC使用了哪些关键技术，Dubbo

Dubbo是 阿里巴巴公司开源的一个高性能优秀的服务框架，使得应用可通过高性能的 RPC 实现服务的输出和输入功能，可以和 Spring框架无缝集成。


### 6、Dubbo 核心组件有哪些？

**1、** Provider：暴露服务的服务提供方

**2、** Consumer：调用远程服务消费方

**3、** Registry：服务注册与发现注册中心

**4、** Monitor：监控中心和访问调用统计

**5、** Container：服务运行容器


### 7、为什么要用 Dubbo？

随着服务化的进一步发展，服务越来越多，服务之间的调用和依赖关系也越来越复杂，诞生了面向服务的架构体系(SOA)，也因此衍生出了一系列相应的技术，如对服务提供、服务调用、连接处理、通信协议、序列化方式、服务发现、服务路由、日志输出等行为进行封装的服务框架。就这样为分布式系统的服务治理框架就出现了，Dubbo 也就这样产生了。


### 8、Dubbo 的使用场景有哪些？
### 9、当一个服务接口有多种实现时怎么做？
### 10、dubbo 在安全机制方面如何解决的？
### 11、同一个服务多个注册的情况下可以直连某一个服务吗？
### 12、dubbo 和 dubbox 之间的区别？
### 13、你觉得用 Dubbo 好还是 Spring Cloud 好？
### 14、服务调用超时会怎么样？
### 15、Dubbo 默认采用注册中心？
### 16、Dubbo 服务降级，失败重试怎么做？
### 17、Dubbo 和 Spring Cloud 的区别？
### 18、如何解决服务调用链过长的问题？
### 19、在使用过程中都遇到了些什么问题？
### 20、Dubbo 用到哪些设计模式？
### 21、Dubbo 使用的是什么通信框架?
### 22、你还了解别的分布式框架吗？
### 23、Dubbo 是什么？
### 24、Dubbo 在安全机制方面是如何解决的
### 25、一般使用什么注册中心？还有别的选择吗？
### 26、Dubbo 和 Spring Cloud 有什么哪些区别？
### 27、Dubbo 支持哪些序列化方式？
### 28、Dubbo 的整体架构设计有哪些分层?
### 29、Dubbo 支持服务降级吗？
### 30、服务提供者能实现失效踢出是什么原理？
### 31、服务调用是阻塞的吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
