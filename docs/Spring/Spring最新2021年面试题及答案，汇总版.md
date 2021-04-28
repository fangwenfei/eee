# Spring最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

spring-boot:run 运行你的 SpringBooty 应用程序。

spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

spring-boot:build-info 生成执行器可以使用的构造信息。


### 2、什么是YAML？

YAML是一种人类可读的数据序列化语言。它通常用于配置文件。 与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。


### 3、列举 spring 支持的事务管理类型

Spring 支持两种类型的事务管理：

**1、** 程序化事务管理：在此过程中，在编程的帮助下管理事务。它为您提供极大的灵活性，但维护起来非常困难。

**2、** 声明式事务管理：在此，事务管理与业务代码分离。仅使用注解或基于 XML 的配置来管理事务。


### 4、什么是Spring的内部bean？

当一个bean仅被用作另一个bean的属性时，它能被声明为一个内部bean，为了定义inner bean，在Spring 的 基于XML的 配置元数据中，可以在 或  元素内使用 元素，内部bean通常是匿名的，它们的Scope一般是prototype。


### 5、什么是YAML？

YAML是一种人类可读的数据序列化语言。它通常用于配置文件。

与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。


### 6、怎么设计无状态服务？

对于无状态服务，首先说一下什么是状态：如果一个数据需要被多个服务共享，才能完成一笔交易，那么这1、个数据被称为状态。进而依赖这个“状态”数据的服务被称为有状态服务，反之称为无状态服务。

**2、** 那么这个无状态服务原则并不是说在微服务架构里就不允许存在状态，表达的真实意思是要把有状态的业务服务改变为无状态的计算类服务，那么状态数据也就相应的迁移到对应的“有状态数据服务”中。

**3、** 场景说明：例如我们以前在本地内存中建立的数据缓存、Session缓存，到现在的微服务架构中就应该把这些数据迁移到分布式缓存中存储，让业务服务变成一个无状态的计算节点。迁移后，就可以做到按需动态伸缩，微服务应用在运行时动态增删节点，就不再需要考虑缓存数据如何同步的问题。


### 7、你如何理解 SpringBoot 中的 Starters？

Starters可以理解为启动器，它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成 Spring 及其他技术，而不需要到处找示例代码和依赖包。如你想使用 Spring JPA 访问数据库，只要加入 spring-boot-starter-data-jpa 启动器依赖就能使用了。


### 8、spring 支持集中 bean scope？

**Spring bean 支持 5 种 scope：**

**1、** Singleton - 每个 Spring IoC 容器仅有一个单实例。

**2、** Prototype - 每次请求都会产生一个新的实例。

**3、** Request - 每一次 HTTP 请求都会产生一个新的实例，并且该 bean 仅在当前 HTTP 请求内有效。

**4、** Session - 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前 HTTP session 内有效。

**5、** Global-session - 类似于标准的 HTTP Session 作用域，不过它仅仅在基于 portlet 的 web 应用中才有意义。 Portlet 规范定义了全局 Session 的概念，它被所有构成某个 portlet web 应用的各种不同的 portlet 所共享。 在 global session 作用域中定义的 bean 被限定于全局 portlet Session 的生命周期范围内。 如果你在 web 中使用 global session 作用域来标识 bean，那么 web 会自动当成 session 类型来使用。

**6、** 仅当用户使用支持 Web 的 ApplicationContext 时，最后三个才可用。


### 9、SpringBoot 是否可以使用 XML 配置 ?

SpringBoot 推荐使用 Java 配置而非 XML 配置，但是 SpringBoot 中也可以使用 XML 配置，通过 [@ImportResource ](/ImportResource ) 注解可以引入一个 XML 配置。


### 10、保护 SpringBoot 应用有哪些方法？

**1、** 在生产中使用HTTPS

**2、** 使用Snyk检查你的依赖关系

**3、** 升级到最新版本

**4、** 启用CSRF保护

**5、** 使用内容安全策略防止XSS攻击


### 11、Spring 应用程序有哪些不同组件？
### 12、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 13、如何在 spring 中启动注解装配？
### 14、如何使用 SpringBoot 实现分页和排序？
### 15、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 16、什么是基于注解的容器配置?
### 17、Web，RESTful API在微服务中的作用是什么？
### 18、什么是 JavaConfig？
### 19、什么是领域驱动设计？
### 20、SpringBoot读取配置文件的方式
### 21、什么是Spring Cloud Gateway?
### 22、spring-boot-starter-parent 有什么用 ?
### 23、什么是SpringBoot？
### 24、为什么要使用 Spring Cloud 熔断器？
### 25、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 26、微服务架构有哪些优势？
### 27、如何集成SpringBoot和ActiveMQ？
### 28、使⽤中碰到的坑
### 29、bootstrap.yml和application.yml有什么区别?
### 30、Spring MVC中函数的返回值是什么？
### 31、[@Autowired ](/Autowired ) 注解有什么用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
