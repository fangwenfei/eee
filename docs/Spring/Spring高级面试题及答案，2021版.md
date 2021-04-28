# Spring高级面试题及答案，2021版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、您使用了哪些 starter maven 依赖项？

**使用了下面的一些依赖项**

**1、**  spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、**  spring-boot-starter-data-jpa 数据库支持

**3、**  spring-boot-starter-data-Redis Redis数据库支持

**4、**  spring-boot-starter-data-solr solr支持

**5、**  mybatis-spring-boot-starter 第三方的mybatis集成starter

自定义的starter(如果自己开发过就可以说出来)


### 2、SpringBoot支持哪些嵌入式容器？

无论何时创建Java应用程序，都可以通过两种方法进行部署： 使用外部的应用程序容器。 将容器嵌入jar文件中。 SpringBoot包含Jetty，Tomcat和Undertow服务器，所有服务器都是嵌入式的。 Jetty - 用于大量项目，Eclipse Jetty可以嵌入到框架，应用程序服务器，工具和集群中。 Tomcat - Apache Tomcat是一个开源JavaServer Pages实现，可以很好地与嵌入式系统配合使用。 Undertow - 一个灵活而突出的Web服务器，它使用小型单一处理程序来开发Web服务器。


### 3、创建一个 SpringBoot Project 的最简单的方法是什么？

Spring Initializer 是创建 SpringBoot Projects 的一个很好的工具


### 4、Spring Cloud Zookeeper

基于Apache Zookeeper的服务治理组件。


### 5、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；

一些固定的不能被覆盖的属性；

一些加密/解密的场景；


### 6、JPA 和 Hibernate 有哪些区别？

简而言之

JPA 是一个规范或者接口

Hibernate 是 JPA 的一个实现

当我们使用 JPA 的时候，我们使用 javax.persistence 包中的注释和接口时，不需要使用 hibernate 的导入包。

我们建议使用 JPA 注释，因为哦我们没有将其绑定到 Hibernate 作为实现。后来（我知道 - 小于百分之一的几率），我们可以使用另一种 JPA 实现。


### 7、什么是Hystrix?

Hystrix 是一个延迟和容错库，旨在隔离远程系统，服务和第三方库的访问点，当出现故障是不可避免的故障时，停止级联故障并在复杂的分布式系统中实现弹性。通常对于使用微服务架构开发的系统，涉及到许多微服务，这些微服务彼此协作， 随着微服务数量的增加，这个问题变得更加复杂。我们将使用 Hystrix 的 Fallback 方法来处理，假设由于某种原因，公开的服务接口抛出异常，我们在这种情况下使用 Hystrix 定义一个回退方法。这种后备方法应该具有与公开服务相同的返回类型，如果暴露服务中出现异常，回退方法将返回对应信息。


### 8、什么是 Spring IOC 容器？

Spring 框架的核心是 Spring 容器。 容器创建对象，将它们装配在一起，配置它们并管理它们的完整生命周期。 Spring 容器使用依赖注入来管理组成应用程序的组件。 容器通过读取提供的配置元数据来接收对象进行实例化，配置和组装的指令。 该元数据可以通过 XML，Java 注解或 Java 代码提供。


### 9、自动装配有什么局限？

**1、** 覆盖的可能性 - 您始终可以使用 和 设置指定依赖项，这将覆盖自动装配。

**2、** 基本元数据类型 - 简单属性（如原数据类型，字符串和类）无法自动装配。

**3、** 令人困惑的性质 - 总是喜欢使用明确的装配，因为自动装配不太精确。

###你用过哪些重要的 Spring 注解

**1、** [@Controller ](/Controller ) - 用于 Spring MVC 项目中的控制器类。

**2、** [@Service ](/Service ) - 用于服务类。

**3、** [@RequestMapping ](/RequestMapping ) - 用于在控制器处理程序方法中配置 URI 映射。

**4、** [@ResponseBody ](/ResponseBody ) - 用于发送 Object 作为响应，通常用于发送 XML 或 JSON 数据作为响应。

**5、** [@PathVariable ](/PathVariable ) - 用于将动态值从 URI 映射到处理程序方法参数。

**6、** [@Autowired ](/Autowired ) - 用于在 spring bean 中自动装配依赖项。

**7、** [@Qualifier ](/Qualifier ) - 使用 [@Autowired ](/Autowired ) 注解，以避免在存在多个 bean 类型实例时出现混淆。

**8、** [@Scope ](/Scope ) - 用于配置 spring bean 的范围。

**9、** @Configuration，[@ComponentScan ](/ComponentScan ) 和 [@Bean ](/Bean ) - 用于基于 java 的配置。

**10、** @Aspect，@Before，@After，@Around，[@Pointcut ](/Pointcut ) - 用于切面编程（AOP）


### 10、如何实现 SpringBoot 应用程序的安全性？

为了实现 SpringBoot 的安全性，我们使用 spring-boot-starter-security 依赖项，并且必须添加安全配置。它只需要很少的代码。配置类将必须扩展WebSecurityConfigurerAdapter 并覆盖其方法。


### 11、如何禁用特定的自动配置类？
### 12、Springboot 有哪些优点？
### 13、Spring MVC怎么和AJAX相互调用的？
### 14、使用Spring框架的好处是什么？
### 15、spring boot扫描流程?
### 16、什么是 AOP切点
### 17、spring bean 容器的生命周期是什么样的？
### 18、您对Distributed Transaction有何了解？
### 19、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 20、什么是Spring的依赖注入？
### 21、熔断的原理，以及如何恢复？
### 22、[@Qualifier ](/Qualifier ) 注解
### 23、spring-boot-starter-parent 有什么用 ?
### 24、SpringBoot和SpringCloud的区别？
### 25、微服务之间是如何独⽴通讯的
### 26、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？
### 27、eureka缓存机制：
### 28、什么是WebSockets？
### 29、Spring由哪些模块组成?
### 30、Spring Cloud和各子项目版本对应关系
### 31、什么是持续监测？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
