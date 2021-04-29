# SpringCloud最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cloud Bus

用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置信息。

简单来说就是修改了配置文件，发送一次请求，所有客户端便会重新读取配置文件。

需要利用中间插件MQ


### 2、什么是Hystrix断路器？我们需要它吗？

由于某些原因，employee-consumer公开服务会引发异常。在这种情况下使用Hystrix我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_4.png#alt=img%5C_4.png)

如果firstPage method() 中的异常继续发生，则Hystrix电路将中断，并且员工使用者将一起跳过firtsPage方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_5.png#alt=img%5C_5.png)


### 3、Actuator在SpringBoot中的作用

它是最重要的功能之一，可帮助您访问在生产环境中运行的应用程序的当前状态。有多个指标可用于检查当前状态。它们还为RESTful Web服务提供端点，可以简单地用于检查不同的度量标准。


### 4、什么是Spring Cloud？

spring cloud 是一系列框架的有序集合。它利用 spring boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 spring boot 的开发风格做到一键启动和部署。


### 5、什么是Spring Cloud？

根据Spring Cloud的官方网站，Spring Cloud为开发人员提供了快速构建分布式系统中一些常见模式的工具（例如配置管理，服务发现，断路器，智能路由，领导选举，分布式会话，集群状态）。


### 6、在微服务中，如何保护服务?

一般使用使用Hystrix框架，实现服务隔离来避免出现服务的雪崩效应，从而达到保护服务的效果。当微服务中，高并发的数据库访问量导致服务线程阻塞，使单个服务宕机，服务的不可用会蔓延到其他服务，引起整体服务灾难性后果，使用服务降级能有效为不同的服务分配资源,一旦服务不可用则返回友好提示，不占用其他服务资源，从而避免单个服务崩溃引发整体服务的不可用.


### 7、Spring Cloud Config

集中配置管理工具，分布式系统中统一的外部配置管理，默认使用Git来存储配置，可以支持客户端配置的刷新及加密、解密操作。


### 8、Spring Cloud和各子项目版本对应关系
### 9、eureka的缺点：
### 10、Container在微服务中的用途是什么？
### 11、在使用微服务架构时，您面临哪些挑战？
### 12、什么是Oauth？
### 13、什么是Spring Cloud Bus？我们需要它吗？
### 14、Spring Cloud Zookeeper
### 15、什么是Semantic监控？
### 16、什么是耦合？
### 17、什么是Spring Cloud Zuul（服务网关）
### 18、分布式配置中心有那些框架？
### 19、Spring Cloud和SpringBoot版本对应关系
### 20、什么是SpringBoot？
### 21、什么是Netflix Feign？它的优点是什么？
### 22、为什么需要学习Spring Cloud
### 23、Spring Cloud Stream
### 24、SpringCloud Config 可以实现实时刷新吗？
### 25、你对SpringBoot有什么了解？
### 26、如何实现动态Zuul网关路由转发
### 27、什么是消费者驱动的合同（CDC）？
### 28、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？
### 29、什么是持续集成（CI）？
### 30、为什么在微服务中需要Reports报告和Dashboards仪表板？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
