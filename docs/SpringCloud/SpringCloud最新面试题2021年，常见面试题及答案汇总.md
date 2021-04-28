# SpringCloud最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、微服务之间是如何独立通讯的?

**1、** 远程调用，比如feign调用，直接通过远程过程调用来访问别的service。 2.消息中间件


### 2、SpringBoot和springcloud认识

**1、** SpringBoot 是 Spring 的⼀套快速配置脚⼿架，可以基于SpringBoot 快速开发单个微服务，Spring Cloud是⼀个基于SpringBoot实现的云应⽤开发⼯具；

**2、** SpringBoot专注于快速、⽅便集成的单个微服务个体，Spring Cloud关注全局的服务治理框架；

**3、** SpringBoot使⽤了默认⼤于配置的理念，很多集成⽅案已经帮你选择好了，能不配置就不配置；

**4、** Spring Cloud很⼤的⼀部分是基于SpringBoot来实现，可以不基于SpringBoot吗？不可以。


### 3、负载均衡的意义是什么?

在计算中，负载均衡可以改善跨计算机，计算机集群，网络链接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载均衡旨在优化资源使用，最大吞吐量，最小响应时间并避免任何单一资源的过载。使用多个组件进行负载均衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载平衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务进程。


### 4、接⼝限流⽅法？

**限制 总并发数（⽐如 数据库连接池、线程池）**

**1、** 限制 瞬时并发数（如 nginx 的 limit_conn 模块，⽤来限制 瞬时并发连接数）

**2、** 限制 时间窗⼝内的平均速率（如 Guava 的 RateLimiter、nginx 的 limit_req模块，限制每秒的平均速率）

**3、** 限制 远程接⼝ 调⽤速率

**4、** 限制 MQ 的消费速率

**5、** 可以根据⽹络连接数、⽹络流量、CPU或内存负载等来限流



### 5、Spring Cloud Task

Spring Cloud Task的目标是为SpringBoot应用程序提供创建短运行期微服务的功能。在Spring Cloud Task中，我们可以灵活地动态运行任何任务，按需分配资源并在任务完成后检索结果。Tasks是Spring Cloud Data Flow中的一个基础项目，允许用户将几乎任何SpringBoot应用程序作为一个短期任务执行。


### 6、Spring Cloud Zookeeper

SpringCloud支持三种注册方式Eureka， Consul(go语言编写)，zookeeper

Spring Cloud Zookeeper是基于Apache Zookeeper的服务治理组件。


### 7、您对微服务有何了解？

微服务，又称微服务架构，是一种架构风格，它将应用程序构建为以业务领域为模型的小型自治服务集合 。

通俗地说，你必须看到蜜蜂如何通过对齐六角形蜡细胞来构建它们的蜂窝状物。他们最初从使用各种材料的小部分开始，并继续从中构建一个大型蜂箱。这些细胞形成图案，产生坚固的结构，将蜂窝的特定部分固定在一起。这里，每个细胞独立于另一个细胞，但它也与其他细胞相关。这意味着对一个细胞的损害不会损害其他细胞，因此，蜜蜂可以在不影响完整蜂箱的情况下重建这些细胞。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_1.png#alt=img%5C_1.png)

图1：微服务的蜂窝表示 – 微服务访谈问题

请参考上图。这里，每个六边形形状代表单独的服务组件。与蜜蜂的工作类似，每个敏捷团队都使用可用的框架和所选的技术堆栈构建单独的服务组件。就像在蜂箱中一样，每个服务组件形成一个强大的微服务架构，以提供更好的可扩展性。此外，敏捷团队可以单独处理每个服务组件的问题，而对整个应用程序没有影响或影响最小。


### 8、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 9、PACT在微服务架构中的用途是什么？

PACT是一个开源工具，允许测试服务提供者和消费者之间的交互，与合同隔离，从而提高微服务集成的可靠性。

微服务中的用法

用于在微服务中实现消费者驱动的合同。

测试微服务的消费者和提供者之间的消费者驱动的合同。

查看即将到来的批次


### 10、eureka的缺点：

某个服务不可⽤时，各个Eureka Client不能及时的知道，需要1~3个⼼跳周期才能感知，但是，由于基于Netflix的服务调⽤端都会使⽤Hystrix来容错和降级，当服务调⽤不可⽤时Hystrix也能及时感知到，通过熔断机制来降级服务调⽤，因此弥补了基于客户端服务发现的时效性的缺点。


### 11、什么是客户证书？
### 12、我们如何进行跨功能测试？
### 13、Spring Cloud的版本关系
### 14、为什么要使用 Spring Cloud 熔断器？
### 15、什么是 Hystrix？
### 16、什么是微服务架构
### 17、dubbo服务注册与发现原理
### 18、什么是消费者驱动的合同（CDC）？
### 19、什么是Spring Cloud Gateway?
### 20、SpringBoot支持哪些嵌入式容器？
### 21、链路跟踪Sleuth
### 22、Ribbon和Feign的区别？
### 23、spring cloud 断路器的作用是什么？
### 24、使⽤中碰到的坑
### 25、什么是不同类型的微服务测试？
### 26、Ribbon是什么？
### 27、什么是无所不在的语言？
### 28、什么是持续监测？
### 29、缓存机制：
### 30、分布式配置中心的作用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
