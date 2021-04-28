# Spring高级面试题及答案，2021版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、使用Spring通过什么方式访问Hibernate?

在Spring中有两种方式访问Hibernate：

**1、** 控制反转 Hibernate Template和 Callback。

**2、** 继承 HibernateDAOSupport提供一个AOP 拦截器。


### 2、什么是 AOP 通知

通知是个在方法执行前或执行后要做的动作，实际上是程序执行时要通过SpringAOP框架触发的代码段。

Spring切面可以应用五种类型的通知：

**1、** before：前置通知，在一个方法执行前被调用。

**2、** after: 在方法执行之后调用的通知，无论方法执行是否成功。

**3、** after-returning: 仅当方法成功完成后执行的通知。

**4、** after-throwing: 在方法抛出异常退出时执行的通知。

**5、** around: 在方法执行之前和之后调用的通知。


### 3、SpringBoot中的监视器是什么？

Spring boot actuator是spring启动框架中的重要功能之一。Spring boot监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为HTTP URL访问的REST端点来检查状态。


### 4、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

**1、** SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

**2、** application 配置文件这个容易了解，主要用于 SpringBoot 项目的自动化配置。

**3、** bootstrap 配置文件有以下几个应用场景。

**4、** 使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中增加连接到配置中心的配置属性来加载外部配置中心的配置信息；

**5、** 少量固定的不能被覆盖的属性；

**6、** 少量加密/解密的场景；


### 5、SpringBoot性能如何优化

如果项目比较大，类比较多，不使用@SpringBootApplication，采用@Compoment指定扫包范围

在项目启动时设置JVM初始内存和最大内存相同

将SpringBoot内置服务器由tomcat设置为undertow


### 6、你更倾向用那种事务管理类型？

大多数Spring框架的用户选择声明式事务管理，因为它对应用代码的影响最小，因此更符合一个无侵入的轻量级容器的思想。声明式事务管理要优于编程式事务管理，虽然比编程式事务管理（这种方式允许你通过代码控制事务）少了一点灵活性。


### 7、spring 中有多少种 IOC 容器？

BeanFactory - BeanFactory 就像一个包含 bean 集合的工厂类。它会在客户端要求时实例化 bean。

ApplicationContext - ApplicationContext 接口扩展了 BeanFactory 接口。它在 BeanFactory 基础上提供了一些额外的功能。


### 8、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

org.springframework.boot

spring-boot-devtools

true


### 9、使用Spring框架的好处是什么？

**轻量：**Spring 是轻量的，基本的版本大约2MB。

控制反转：Spring通过控制反转实现了松散耦合，对象们给出它们的依赖，而不是创建或查找依赖的对象们。

面向切面的编程(AOP)：Spring支持面向切面的编程，并且把应用业务逻辑和系统服务分开。

**容器：**Spring 包含并管理应用中对象的生命周期和配置。

**MVC框架：**Spring的WEB框架是个精心设计的框架，是Web框架的一个很好的替代品。

**事务管理：**Spring 提供一个持续的事务管理接口，可以扩展到上至本地事务下至全局事务（JTA）。

**异常处理：**Spring 提供方便的API把具体技术相关的异常（比如由JDBC，Hibernate or JDO抛出的）转化为一致的unchecked 异常。


### 10、Spring Cloud Gateway

Spring cloud gateway是spring官方基于Spring 5.0、SpringBoot2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供简单、有效和统一的API路由管理方式，Spring Cloud Gateway作为Spring Cloud生态系统中的网关，目标是替代Netflix Zuul，其不仅提供统一的路由方式，并且还基于Filer链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等。


### 11、Spring MVC 框架有什么用？
### 12、Spring Cloud Security
### 13、SpringBoot与SpringCloud 区别
### 14、Spring AOP and AspectJ AOP 有什么区别？
### 15、Spring Cloud Sleuth
### 16、我们可以用微服务创建状态机吗？
### 17、什么是客户证书？
### 18、什么是Spring Cloud？
### 19、SpringBoot和SpringCloud的区别？
### 20、Spring MVC常用的注解有哪些？
### 21、Bean 工厂和 Application contexts 有什么区别？
### 22、Spring、SpringBoot、SpringMVC的区别？
### 23、什么是OAuth？
### 24、介绍一下 WebApplicationContext
### 25、负载平衡的意义什么？
### 26、什么是 AOP什么是引入?
### 27、描述一下 DispatcherServlet 的工作流程
### 28、什么是 Apache Kafka？
### 29、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 30、什么是Spring Cloud Config?
### 31、如何通过HibernateDaoSupport将Spring和Hibernate结合起来？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
