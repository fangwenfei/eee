# Spring高级面试题及答案，2021版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 Spring IOC 容器？

Spring 框架的核心是 Spring 容器。 容器创建对象，将它们装配在一起，配置它们并管理它们的完整生命周期。 Spring 容器使用依赖注入来管理组成应用程序的组件。 容器通过读取提供的配置元数据来接收对象进行实例化，配置和组装的指令。 该元数据可以通过 XML，Java 注解或 Java 代码提供。


### 2、熔断的原理，以及如何恢复？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_11.png#alt=45%5C_11.png)

**服务的健康状况 = 请求失败数 / 请求总数.**

熔断器开关由关闭到打开的状态转换是通过当前服务健康状况和设定阈值⽐较决定的.

**1、** 当熔断器开关关闭时, 请求被允许通过熔断器、如果当前健康状况⾼于设定阈值, 开关继续保持关闭、如果当前健康状况低于设定阈值, 开关则切换为打开状态.

**2、** 当熔断器开关打开时, 请求被禁⽌通过.

**3、** 当熔断器开关处于打开状态, 经过⼀段时间后, 熔断器会⾃动进⼊半开状态, 这时熔断器只允许⼀个请求通过、当该请求调⽤成功时, 熔断器恢复到关闭状态、若该请求失败, 熔断器继续保持打开状态, 接下来的请求被禁⽌通过.

熔断器的开关能保证服务调⽤者在调⽤异常服务时, 快速返回结果, 避免⼤量的同步等待、并且熔断器能在⼀段时间后继续侦测请求执⾏结果, 提供恢复服务调⽤的可能。


### 3、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，它提供了配置 Spring IoC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

**1、** 面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** 减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

**3、** 类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 4、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

spring-boot:run 运行你的 SpringBooty 应用程序。

spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

spring-boot:build-info 生成执行器可以使用的构造信息。


### 5、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** SpringSpring最重要的特征是依赖注入。所有 `SpringModules` 不是依赖注入就是 IOC 控制反转。当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC提供了一种分离式的方法来开发 Web 应用。通过运用像 `DispatcherServelet`，`MoudlAndView` 和 `ViewResolver` 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** Spring 和 SpringMVC 的问题在于需要配置大量的参数。

**4、** SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 6、使用Spring框架的好处是什么？

**1、** 轻量：Spring 是轻量的，基本的版本大约2MB。

**2、** 控制反转：Spring通过控制反转实现了松散耦合，对象们给出它们的依赖，而不是创建或查找依赖的对象们。

**3、** 面向切面的编程(AOP)：Spring支持面向切面的编程，并且把应用业务逻辑和系统服务分开。

**4、** 容器：Spring 包含并管理应用中对象的生命周期和配置。

**5、** MVC框架：Spring的WEB框架是个精心设计的框架，是Web框架的一个很好的替代品。

**6、** 事务管理：Spring 提供一个持续的事务管理接口，可以扩展到上至本地事务下至全局事务（JTA）。

**7、** 异常处理：Spring 提供方便的API把具体技术相关的异常（比如由JDBC，Hibernate or JDO抛出的）转化为一致的unchecked 异常。


### 7、Spring Cloud 和dubbo区别?

**1、** 服务调用方式：dubbo是RPC springcloud Rest Api

**2、** 注册中心：dubbo 是zookeeper springcloud是eureka，也可以是zookeeper

**3、** 服务网关，dubbo本身没有实现，只能通过其他第三方技术整合，springcloud有Zuul路由网关，作为路由服务器，进行消费者的请求分发,springcloud支持断路器，与git完美集成配置文件支持版本控制，事物总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素。


### 8、SpringBoot 常用的 Starter 有哪些？

**1、** spring-boot-starter-web ：提供 Spring MVC + 内嵌的 Tomcat 。

**2、** spring-boot-starter-data-jpa ：提供 Spring JPA + Hibernate 。

**3、** spring-boot-starter-data-Redis ：提供 Redis 。

**4、** mybatis-spring-boot-starter ：提供 MyBatis 。


### 9、Spring Cloud Zookeeper

基于Apache Zookeeper的服务治理组件。


### 10、什么是OAuth？

OAuth 代表开放授权协议。这允许通过在HTTP服务上启用客户端应用程序（例如第三方提供商Facebook，GitHub等）来访问资源所有者的资源。因此，您可以在不使用其凭据的情况下与另一个站点共享存储在一个站点上的资源。


### 11、我们如何监视所有SpringBoot微服务？
### 12、分布式配置中心的作用？
### 13、如何使用SpringBoot实现分页和排序？
### 14、什么是SpringBoot？
### 15、如何通过HibernateDaoSupport将Spring和Hibernate结合起来？
### 16、SpringBoot 有哪几种读取配置的方式？
### 17、spring 支持集中 bean scope？
### 18、Spring Cloud OpenFeign
### 19、Zuul网关如何搭建集群
### 20、Spring Cloud 实现服务注册和发现的原理是什么？
### 21、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 22、Spring Cloud Bus
### 23、DiscoveryClient的作用
### 24、SpringBoot 提供了哪些核心功能？
### 25、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 26、什么是 AOP？
### 27、负载平衡的意义什么？
### 28、22。你能否给出关于休息和微服务的要点？
### 29、解释基于XML Schema方式的切面实现。
### 30、SpringCloud由什么组成
### 31、什么是网关?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
