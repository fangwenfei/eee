# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是Spring Cloud Gateway?

Spring Cloud Gateway是Spring Cloud官方推出的第二代网关框架，取代Zuul网关。网关作为流量的，在微服务系统中有着非常作用，网关常见的功能有路由转发、权限校验、限流控制等作用。

使用了一个RouteLocatorBuilder的bean去创建路由，除了创建路由RouteLocatorBuilder可以让你添加各种predicates和filters，predicates断言的意思，顾名思义就是根据具体的请求的规则，由具体的route去处理，filters是各种过滤器，用来对请求做各种判断和修改。


### 2、第⼆层缓存：

readWriteCacheMap，本质上是Guava缓存：此处存放的是最终的缓存， 当服务下线，过期，注册，状态变更，都会来清除这个缓存⾥⾯的数据。 然后通过CacheLoader进⾏缓存加载，在进⾏readWriteCacheMap.get(key)的时候，⾸先看这个缓存⾥⾯有没有该数据，如果没有则通过CacheLoader的load⽅法去加载，加载成功之后将数据放⼊缓存，同时返回数据。 readWriteCacheMap 缓存过期时间，默认为 180 秒 。

#
### 3、什么是 Spring Batch?

`SpringBoot Batch`提供可重用的函数，这些函数在处理大量记录时非常重要；包括日志/跟踪，事务管理，作业处理统计信息，作业重新启动，跳过和资源管理。它还提供了更先进的技术服务和功能，通过优化和分区技术，可以实现极高批量和高性能批处理作业。简单以及复杂的大批量批处理作业可以高度可扩展的方式利用框架处理重要大量的信息。



### 4、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；

一些固定的不能被覆盖的属性；

一些加密/解密的场景；


### 5、什么是 AOP什么是引入?

引入允许我们在已存在的类中增加新的方法和属性。


### 6、[@Autowired ](/Autowired ) 注解

[@Autowired ](/Autowired ) 注解提供了更细粒度的控制，包括在何处以及如何完成自动装配。它的用法和@Required一样，修饰setter方法、构造器、属性或者具有任意名称和/或多个参数的PN方法。


### 7、Spring AOP and AspectJ AOP 有什么区别？

Spring AOP 基于动态代理方式实现；AspectJ 基于静态代理方式实现。Spring AOP 仅支持方法级别的 PointCut；提供了完全的 AOP 支持，它还支持属性级别的 PointCut。


### 8、Spring Framework 有哪些不同的功能？

**1、** 轻量级 - Spring 在代码量和透明度方面都很轻便。

**2、** IOC - 控制反转

**3、** AOP - 面向切面编程可以将应用业务逻辑和系统服务分离，以实现高内聚。

**4、** 容器 - Spring 负责创建和管理对象（Bean）的生命周期和配置。

**5、** MVC - 对 web 应用提供了高度可配置性，其他框架的集成也十分方便。

**6、** 事务管理 - 提供了用于事务管理的通用抽象层。 Spring 的事务支持也可用于容器较少的环境。

**7、** JDBC 异常 - Spring 的 JDBC 抽象层提供了一个异常层次结构，简化了错误处理策略。4、Spring Framework 中有多少个模块，它们分别是什么？

**1、** Spring 核心容器 – 该层基本上是 Spring Framework 的核心。它包含以下模块：

**2、** Spring Core

**3、** Spring Bean

**4、** SpEL (Spring Expression Language)

**5、** Spring Context

**数据访问/集成 – 该层提供与数据库交互的支持。 它包含以下模块：**

**1、** JDBC (Java DataBase Connectivity)

**2、** ORM (Object Relational Mapping)

**3、** OXM (Object XML Mappers)

**4、** JMS (Java Messaging Service)

**5、** Transaction

**1、** Web – 该层提供了创建 Web 应用程序的支持。它包含以下模块：AOP – 该层支持面向切面编程

**2、** Web

**3、** Web – Servlet

**4、** Web – Socket

**5、** Web – Portlet

**6、** Instrumentation – 该层为类检测和类加载器实现提供支持。

**7、** Test – 该层为使用 JUnit 和 TestNG 进行测试提供支持

**几个杂项模块:**

Messaging – 该模块为 STOMP 提供支持。它还支持注解编程模型，该模型用于从 WebSocket 客户端路由和处理 STOMP 消息。

Aspects – 该模块为与 AspectJ 的集成提供支持。


### 9、什么是基于Java的Spring注解配置? 给一些注解的例子.

基于Java的配置，允许你在少量的Java注解的帮助下，进行你的大部分Spring配置而非通过XML文件。

以[@Configuration ](/Configuration ) 注解为例，它用来标记类可以当做一个bean的定义，被Spring IOC容器使用。另一个例子是@Bean注解，它表示此方法将要返回一个对象，作为一个bean注册进Spring应用上下文。


### 10、在 Spring Initializer 中，如何改变一个项目的包名字？

好消息是你可以定制它。点击链接“转到完整版本”。你可以配置你想要修改的包名称！


### 11、SpringBoot 日志框架：
### 12、什么是代理?
### 13、为什么我们需要微服务容器？
### 14、什么是网关?
### 15、什么是starter?
### 16、SpringData 项目所支持的关系数据存储技术：
### 17、介绍一下 WebApplicationContext
### 18、微服务有什么特点？
### 19、spring DAO 有什么用？
### 20、SpringBoot的自动配置原理是什么
### 21、Spring Cloud OpenFeign
### 22、如何禁用特定的自动配置类？
### 23、如何在SpringBoot中禁用Actuator端点安全性？
### 24、什么是 Spring Cloud Bus？
### 25、我们如何在测试中消除非决定论？
### 26、SpringCloud有几种调用接口方式
### 27、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 28、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 29、什么是 Spring Data REST?
### 30、MVC是什么？MVC设计模式的好处有哪些
### 31、什么是依赖注入？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
