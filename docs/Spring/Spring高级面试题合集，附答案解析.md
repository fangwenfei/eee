# Spring高级面试题合集，附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 Spring Profiles？

在项目的开发中，有些配置文件在开发、测试或者生产等不同环境中可能是不同的，例如数据库连接、Redis的配置等等。那我们如何在不同环境中自动实现配置的切换呢？Spring给我们提供了profiles机制给我们提供的就是来回切换配置文件的功能

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 2、SpringBoot支持哪些嵌入式容器？

无论何时创建Java应用程序，都可以通过两种方法进行部署： 使用外部的应用程序容器。 将容器嵌入jar文件中。 SpringBoot包含Jetty，Tomcat和Undertow服务器，所有服务器都是嵌入式的。 Jetty - 用于大量项目，Eclipse Jetty可以嵌入到框架，应用程序服务器，工具和集群中。 Tomcat - Apache Tomcat是一个开源JavaServer Pages实现，可以很好地与嵌入式系统配合使用。 Undertow - 一个灵活而突出的Web服务器，它使用小型单一处理程序来开发Web服务器。


### 3、什么是 SpringBoot？

SpringBoot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。


### 4、列举 IoC 的一些好处。

**IoC 的一些好处是：**

**1、** 它将最小化应用程序中的代码量。

**2、** 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。

**3、** 它以最小的影响和最少的侵入机制促进松耦合。

**4、** 它支持即时的实例化和延迟加载服务。


### 5、微服务限流 http限流：我们使⽤nginx的limitzone来完成：

```
//这个表示使⽤ip进⾏限流 zone名称为req_one 分配了10m 空间使⽤漏桶算法 每秒钟允许1个请求
limit_req_zone $binary_remote_addr zone=req_one:10m rate=1r/s; //这边burst表示可以瞬间超过20个请求 由于没有noDelay参数因此需要排队 如果超过这20个那么直接返回503
limit_req zone=req_three burst=20;
```


### 6、SpringCloud 和 Dubbo 有哪些区别?

首先，他们都是分布式管理框架。

dubbo 是二进制传输，占用带宽会少一点。SpringCloud是http 传输，带宽会多一点，同时使用http协议一般会使用JSON报文，消耗会更大。

dubbo 开发难度较大，所依赖的 jar 包有很多问题大型工程无法解决。SpringCloud 对第三方的继承可以一键式生成，天然集成。

SpringCloud 接口协议约定比较松散，需要强有力的行政措施来限制接口无序升级。

最大的区别:


### 7、spring 支持集中 bean scope？

Spring bean 支持 5 种 scope：

**Singleton**

**1、** 每个 Spring IoC 容器仅有一个单实例。Prototype

**2、** 每次请求都会产生一个新的实例。Request

**3、** 每一次 HTTP 请求都会产生一个新的实例，并且该 bean 仅在当前 HTTP 请求内有效。Session

**4、** 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前 HTTP session 内有效。Global-session

**5、** 类似于标准的 HTTP Session 作用域，不过它仅仅在基于 portlet 的 web 应用中才有意义。Portlet 规范定义了全局 Session 的概念，它被所有构成某个 portlet web 应用的各种不同的 portlet 所共享。在 global session 作用域中定义的 bean 被限定于全局 portlet Session 的生命周期范围内。如果你在 web 中使用 global session 作用域来标识 bean，那么 web 会自动当成 session 类型来使用。

仅当用户使用支持 Web 的 ApplicationContext 时，最后三个才可用。


### 8、SpringBoot支持什么前端模板，

thymeleaf，freemarker，jsp，官方不推荐JSP会有限制


### 9、什么是YAML?

YAML是一种人类可读的数据序列化语言。它通常用于`配置文件`。 与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有`分层配置数据`。


### 10、指出在 spring aop 中 concern 和 cross-cutting concern 的不同之处。

concern 是我们想要在应用程序的特定模块中定义的行为。它可以定义为我们想要实现的功能。

cross-cutting concern 是一个适用于整个应用的行为，这会影响整个应用程序。例如，日志记录，安全性和数据传输是应用程序几乎每个模块都需要关注的问题，因此它们是跨领域的问题。


### 11、Spring Cloud和SpringBoot版本对应关系
### 12、springcloud和dubbo有哪些区别
### 13、SpringBoot性能如何优化
### 14、Spring Cloud Consul
### 15、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 16、怎样开启注解装配？
### 17、如何实现 SpringBoot 应用程序的安全性？
### 18、spring bean 容器的生命周期是什么样的？
### 19、Spring支持的事务管理类型
### 20、解释基于XML Schema方式的切面实现。
### 21、什么是DispatcherServlet
### 22、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 23、什么是JavaConfig？
### 24、什么是 Spring Data？
### 25、保护 SpringBoot 应用有哪些方法？
### 26、可以通过多少种方式完成依赖注入？
### 27、自动装配有哪些方式？
### 28、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 29、如何给Spring 容器提供配置元数据?
### 30、SpringBoot自动配置的原理是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
