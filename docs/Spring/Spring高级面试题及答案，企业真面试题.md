# Spring高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_9.png#alt=45%5C_9.png)

**springcloud由以下⼏个核⼼组件构成：**

**1、** Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从⽽知道其他服务在哪⾥

**2、** Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从⼀个服务的多台机器中选择⼀台

**3、** Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

**4、** Hystrix：发起请求是通过Hystrix的线程池来⾛的，不同的服务⾛不同的线程池，实现了不同服务调⽤的隔离，避免了服务雪崩的问题

**5、** Zuul：如果前端、移动端要调⽤后端系统，统⼀从Zuul⽹关进⼊，由Zuul⽹关转发请求给对应的服务


### 2、使用 SpringBoot 开发分布式微服务时，我们面临什么问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。


### 3、什么是 AOP 代理?

代理是通知目标对象后创建的对象。从客户端的角度看，代理对象和目标对象是一样的。


### 4、微服务有什么特点？

您可以列出微服务的特征，如下所示：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_9.png#alt=img%5C_9.png)

图7：微服务的特征 – 微服务访谈问题


### 5、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 6、AOP 有哪些实现方式？

**实现 AOP 的技术，主要分为两大类：**

**静态代理**

指使用 AOP 框架提供的命令进行编译，从而在编译阶段就可生成 AOP 代理类，因此也称为编译时增强；

编译时编织（特殊编译器实现）

类加载时编织（特殊的类加载器实现）。

**动态代理**

在运行时在内存中“临时”生成 AOP 动态代理类，因此也被称为运行时增强。

**JDK 动态代理**

**CGLIB**


### 7、如何给Spring 容器提供配置元数据?

这里有三种重要的方法给Spring 容器提供配置元数据。

**1、** XML配置文件。

**2、** 基于注解的配置。

**3、** 基于java的配置。


### 8、什么是 Spring Cloud Bus？

**1、** Spring Cloud Bus就像一个分布式执行器，用于扩展的SpringBoot应用程序的配置文件，但也可以用作应用程序之间的通信通道。

**2、** Spring Cloud Bus 不能单独完成通信，需要配合MQ支持

**3、** Spring Cloud Bus一般是配合Spring Cloud Config做配置中心的

**4、** Springcloud config实时刷新也必须采用SpringCloud Bus消息总线


### 9、服务网关的作用

**1、** 简化客户端调用复杂度，统一处理外部请求。

**2、** 数据裁剪以及聚合，根据不同的接口需求，对数据加工后对外。

**3、** 多渠道支持，针对不同的客户端提供不同的网关支持。

**4、** 遗留系统的微服务化改造，可以作为新老系统的中转组件。

**5、** 统一处理调用过程中的安全、权限问题。


### 10、SpringBoot中的监视器是什么？

Spring boot actuator是spring启动框架中的重要功能之一。Spring boot监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。

有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为HTTP URL访问的REST端点来检查状态。


### 11、开启 SpringBoot 特性有哪几种方式？
### 12、Spring Cloud解决了哪些问题？
### 13、什么是 YAML？
### 14、SpringBoot 日志框架：
### 15、什么是微服务架构中的DRY？
### 16、JdbcTemplate
### 17、如何在不使用BasePACKAGE过滤器的情况下排除程序包？
### 18、您对微服务架构中的语义监控有何了解？
### 19、网关的作用是什么
### 20、SpringBoot与SpringCloud 区别
### 21、什么是服务降级
### 22、微服务的端到端测试意味着什么？
### 23、什么是SpringBoot
### 24、列举 Spring Framework 的优点。
### 25、Eureka如何 保证AP
### 26、什么是基于注解的容器配置
### 27、什么是 Spring 配置文件？
### 28、DispatcherServlet
### 29、什么是 Spring IOC 容器？
### 30、第⼆层缓存：
### 31、创建一个 SpringBoot Project 的最简单的方法是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
