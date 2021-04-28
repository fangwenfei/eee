# Spring高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。


### 2、Spring Framework 有哪些不同的功能？

**1、** 轻量级 - Spring 在代码量和透明度方面都很轻便。

**2、** IOC - 控制反转

**3、** AOP - 面向切面编程可以将应用业务逻辑和系统服务分离，以实现高内聚。

**4、** 容器 - Spring 负责创建和管理对象（Bean）的生命周期和配置。

**5、** MVC - 对 web 应用提供了高度可配置性，其他框架的集成也十分方便。

**6、** 事务管理 - 提供了用于事务管理的通用抽象层。Spring 的事务支持也可用于容器较少的环境。

**7、** JDBC 异常 - Spring 的 JDBC 抽象层提供了一个异常层次结构，简化了错误处理策略。


### 3、什么是 AOP切点

切入点是一个或一组连接点，通知将在这些位置执行。可以通过表达式或匹配的方式指明切入点。


### 4、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

**1、** 依赖 JDK 版本升级：2.x 里面的许多方法应用了 JDK 8 的许多高级新特性，至少需要 JDK 8 的支持；

**2、** 第三方类库升：2.x 对第三方类库升级了所有能升级的稳定版本，例如：Spring Framework 5+、Tomcat 8.5+、Hibernate 5.2+、Thymeleaf 3+；

**3、** 响应式 Spring 编程：2.x 通过启动器和自动配置全面支持 Spring 的响应式编程，响应式编程是完全异步和非阻塞的，它是基于事件驱动模型，而不是传统的线程模型；

**4、** 连接池：2.x 默认使用 HikariCP 连接池；

**5、** json：提供了一个 spring-boot-starter-json 启动器对 JSON 读写的支持；

**6、** Quartz：2.x 提供了一个 spring-boot-starter-quartz 启动器对定时任务框架 Quartz 的支持；

**7、** HTTP/2 支持：提供对HTTP/2 的支持，如：Tomcat, Undertow, Jetty；

**8、** Actuator加强：在 2.x 中，对执行器端点进行了许多改进，所有的 HTTP 执行端点现在都暴露在 /actuator路径下，并对 JSON 结果集也做了改善。


### 5、什么是JavaConfig？

Spring JavaConfig是Spring社区的产品，它提供了配置Spring IoC容器的纯Java方法。因此它有助于避免使用XML配置。使用JavaConfig的优点在于：

面向对象的配置。由于配置被定义为JavaConfig中的类，因此用户可以充分利用Java中的面向对象功能。一个配置类可以继承另一个，重写它的@Bean方法等。

减少或消除XML配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在XML和Java之间来回切换。

JavaConfig为开发人员提供了一种纯Java方法来配置与XML配置概念相似的Spring容器。

从技术角度来讲，只使用JavaConfig配置类来配置容器是可行的，但实际上很多人认为将JavaConfig与XML混合匹配是理想的。

类型安全和重构友好。JavaConfig提供了一种类型安全的方法来配置Spring容器。由于Java 5.0对泛型的支持，现在可以按类型而不是按名称检索bean，不需要任何强制转换或基于字符串的查找


### 6、运行 SpringBoot 有哪几种方式？

**1、** 打包成 Fat Jar ，直接使用 java -jar 运行。目前主流的做法，推荐。

**2、** 在 IDEA 或 Eclipse 中，直接运行应用的 SpringBoot 启动类的 #main(String[] args 启动。适用于开发调试场景。

**3、** 如果是 Web 项目，可以打包成 War 包，使用外部 Tomcat 或 Jetty 等容器。


### 7、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用

依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 8、Spring Cloud Netflix(重点，这些组件用的最多)

Netflix OSS 开源组件集成，包括Eureka、Hystrix、Ribbon、Feign、Zuul等核心组件。

**1、** Eureka：服务治理组件，包括服务端的注册中心和客户端的服务发现机制；

**2、** Ribbon：负载均衡的服务调用组件，具有多种负载均衡调用策略；

**3、** Hystrix：服务容错组件，实现了断路器模式，为依赖服务的出错和延迟提供了容错能力；

**4、** Feign：基于Ribbon和Hystrix的声明式服务调用组件；

**5、** Zuul：API网关组件，对请求提供路由及过滤功能。

`我觉得SpringCloud的福音是Netflix，他把人家的组件都搬来进行封装了，使开发者能快速简单安全的使用`


### 9、您使用了哪些 starter maven 依赖项？

使用了下面的一些依赖项：

spring-boot-starter-activemq

spring-boot-starter-security

这有助于增加更少的依赖关系，并减少版本的冲突。


### 10、如果想在拦截的方法里面得到从前台传入的参数,怎么得到？



直接在形参里面声明这个参数就可以,但必须名字和传过来的参数一样。


### 11、Container在微服务中的用途是什么？
### 12、SpringBoot 需要独立的容器运行吗？
### 13、Spring MVC的异常处理？
### 14、什么是Spring MVC？简单介绍下你对Spring MVC的理解？
### 15、Spring Cloud 是什么
### 16、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 17、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 18、什么是Feign？
### 19、有几种不同类型的自动代理？
### 20、RequestMapping 和 GetMapping 的不同之处在哪里？
### 21、Spring Cloud解决了哪些问题？
### 22、什么是Netflix Feign？它的优点是什么？
### 23、REST 和RPC对比
### 24、在Spring框架中如何更有效地使用JDBC?
### 25、指出在 spring aop 中 concern 和 cross-cutting concern 的不同之处。
### 26、什么是 Spring Data REST?
### 27、解释基于XML Schema方式的切面实现。
### 28、单片，SOA和微服务架构有什么区别？
### 29、常用网关框架有那些？
### 30、使用Spring框架的好处是什么？
### 31、什么是凝聚力？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
