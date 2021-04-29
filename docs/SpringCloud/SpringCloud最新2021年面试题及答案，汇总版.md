# SpringCloud最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Actuator在SpringBoot中的作用

它是最重要的功能之一，可帮助您访问在生产环境中运行的应用程序的当前状态。有多个指标可用于检查当前状态。它们还为RESTful Web服务提供端点，可以简单地用于检查不同的度量标准。


### 2、过渡到微服务时的常见错误

不仅在开发上，而且在方面流程也经常发生错误。一些常见错误是：

**1、** 通常开发人员无法概述当前的挑战。

**2、** 重写已经存在的程序。

**3、** 职责、时间线和界限没有明确定义。

**4、** 未能从一开始就实施和确定自动化的范围。


### 3、如何配置SpringBoot应用程序日志记录？

SpringBoot附带了对Log4J2，Java Util Logging和Logback的支持。它通常预先配置为控制台输出。可以通过仅在application.properties文件中指定logging.level来配置它们。

```
logging.level.spring.framework=Debug
```


### 4、eureka的缺点：

某个服务不可⽤时，各个Eureka Client不能及时的知道，需要1~3个⼼跳周期才能感知，但是，由于基于Netflix的服务调⽤端都会使⽤Hystrix来容错和降级，当服务调⽤不可⽤时Hystrix也能及时感知到，通过熔断机制来降级服务调⽤，因此弥补了基于客户端服务发现的时效性的缺点。


### 5、Ribbon是什么？

**1、** Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法

**2、** Ribbon客户端组件提供一系列完善的配置项，如连接超时，重试等。简单的说，就是在配置文件中列出后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随即连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。（有点类似Nginx）


### 6、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_9.png#alt=45%5C_9.png)

**springcloud由以下⼏个核⼼组件构成：**

**1、** Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从⽽知道其他服务在哪⾥

**2、** Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从⼀个服务的多台机器中选择⼀台

**3、** Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

**4、** Hystrix：发起请求是通过Hystrix的线程池来⾛的，不同的服务⾛不同的线程池，实现了不同服务调⽤的隔离，避免了服务雪崩的问题

**5、** Zuul：如果前端、移动端要调⽤后端系统，统⼀从Zuul⽹关进⼊，由Zuul⽹关转发请求给对应的服务


### 7、您对Distributed Transaction有何了解？

分布式事务是指单个事件导致两个或多个不能以原子方式提交的单独数据源的突变的任何情况。在微服务的世界中，它变得更加复杂，因为每个服务都是一个工作单元，并且大多数时候多个服务必须协同工作才能使业务成功。


### 8、SpringCloud Config 可以实现实时刷新吗？

springcloud config实时刷新采用SpringCloud Bus消息总线。


### 9、什么是Eureka的自我保护模式，

默认情况下，如果Eureka Service在一定时间内没有接收到某个微服务的心跳，Eureka Service会进入自我保护模式，在该模式下Eureka Service会保护服务注册表中的信息，不在删除注册表中的数据，当网络故障恢复后，Eureka Servic 节点会自动退出自我保护模式


### 10、Web，RESTful API在微服务中的作用是什么？

微服务架构基于一个概念，其中所有服务应该能够彼此交互以构建业务功能。因此，要实现这一点，每个微服务必须具有接口。这使得Web API成为微服务的一个非常重要的推动者。RESTful API基于Web的开放网络原则，为构建微服务架构的各个组件之间的接口提供了最合理的模型。


### 11、Spring Cloud Gateway
### 12、服务降级底层是如何实现的？
### 13、使用Spring Cloud有什么优势？
### 14、什么是Idempotence以及它在哪里使用？
### 15、什么是客户证书？
### 16、网关与过滤器有什么区别
### 17、如何覆盖SpringBoot项目的默认属性？
### 18、您将如何在微服务上执行安全测试？
### 19、什么是Spring Cloud Config?
### 20、SOA和微服务架构之间的主要区别是什么？
### 21、Ribbon和Feign的区别？
### 22、什么是幂等性?它是如何使用的？
### 23、Spring Cloud OpenFeign
### 24、服务注册和发现是什么意思？Spring Cloud 如何实现？
### 25、访问RESTful微服务的方法是什么？
### 26、什么是Semantic监控？
### 27、什么是不同类型的微服务测试？
### 28、微服务设计的基础是什么？
### 29、ZuulFilter常用有那些方法
### 30、微服务之间是如何独立通讯的




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
