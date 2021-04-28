# Spring最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 2、不同版本的 Spring Framework 有哪些主要功能？
| Version | Feature |
| --- | --- |
| Spring 2.5 | 发布于 2007 年。这是第一个支持注解的版本。 |
| Spring 3.0 | 发布于 2009 年。它完全利用了 Java5 中的改进，并为 JEE6 提供了支持。 |
| Spring 4.0 | 发布于 2013 年。这是第一个完全支持 JAVA8 的版本。 |



### 3、自动装配有哪些局限性 ?

**自动装配的局限性是：**

重写： 你仍需用 和  配置来定义依赖，意味着总要重写自动装配。

基本数据类型：你不能自动装配简单的属性，如基本数据类型，String字符串，和类。

模糊特性：自动装配不如显式装配精确，如果有可能，建议使用显式装配。


### 4、IOC的优点是什么？

IOC 或 依赖注入把应用的代码量降到最低。它使应用容易测试，单元测试不再需要单例和JNDI查找机制。最小的代价和最小的侵入性使松散耦合得以实现。IOC容器支持加载服务时的饿汉式初始化和懒加载。


### 5、什么是基于注解的容器配置?

相对于XML文件，注解型的配置依赖于通过字节码元数据装配组件，而非尖括号的声明。

开发者通过在相应的类，方法或属性上使用注解的方式，直接组件类中进行配置，而不是使用xml表述bean的装配关系。


### 6、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？

在 SpringBoot 项目中，当你确保下面的依赖项都在类路里面的时候，你可以加载 H2 控制台。

web 启动器

h2

jpa 数据启动器

**其它的依赖项在下面：**

需要注意的一些地方：

一个内部数据内存只在应用程序执行期间存在。这是学习框架的有效方式。

这不是你希望的真是世界应用程序的方式。

在问题“如何连接一个外部数据库？”中，我们解释了如何连接一个你所选择的数据库。


### 7、Spring Framework 中有多少个模块，它们分别是什么？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_1.png#alt=img%5C_1.png)

**Spring 核心容器 – 该层基本上是 Spring Framework 的核心。它包含以下模块：**

**1、** Spring Core

**2、** Spring Bean

**3、** SpEL (Spring Expression Language)

**4、** Spring Context

**数据访问/集成 – 该层提供与数据库交互的支持。它包含以下模块：**

**1、** JDBC (Java DataBase Connectivity)

**2、** ORM (Object Relational Mapping)

**3、** OXM (Object XML Mappers)

**4、** JMS (Java Messaging Service)

**5、** Transaction

**Web – 该层提供了创建 Web 应用程序的支持。它包含以下模块：**

**1、** Web

**2、** Web – Servlet

**3、** Web – Socket

**4、** Web – Portlet

**AOP**

该层支持面向切面编程

**Instrumentation**

该层为类检测和类加载器实现提供支持。

**Test**

该层为使用 JUnit 和 TestNG 进行测试提供支持。

**几个杂项模块:**

Messaging – 该模块为 STOMP 提供支持。它还支持注解编程模型，该模型用于从 WebSocket 客户端路由和处理 STOMP 消息。

Aspects – 该模块为与 AspectJ 的集成提供支持。


### 8、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<optional>true</optional>
```


### 9、Spring MVC的优点

**1、** 可以支持各种视图技术,而不仅仅局限于JSP；

**2、** 与Spring框架集成（如IoC容器、AOP等）；

**3、** 清晰的角色分配：前端控制器(dispatcherServlet) , 请求到处理器映射（handlerMapping), 处理器适配器（HandlerAdapter), 视图解析器（ViewResolver）。

**4、** 支持各种请求资源的映射策略。


### 10、PACT如何运作？

PACT是一个开源工具。它有助于测试消费者和服务提供商之间的互动。消费者服务开发人员首先编写一个测试，该测试定义了与服务提供者的交互模式。测试包括提供者的状态，请求正文和预期的响应。基于此，PACT创建了一个针对其执行测试的存根。输出存储在JSON文件中。


### 11、如果在拦截请求中，我想拦截get方式提交的方法,怎么配置
### 12、spring 中有多少种 IOC 容器？
### 13、架构师在微服务架构中的角色是什么？
### 14、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 15、什么是微服务中的反应性扩展？
### 16、spring JDBC API 中存在哪些类？
### 17、SpringData 项目所支持的关系数据存储技术：
### 18、spring 支持集中 bean scope？
### 19、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 20、SpringBoot与SpringCloud 区别
### 21、微服务之间是如何独立通讯的?
### 22、BeanFactory – BeanFactory 实现举例。
### 23、访问RESTful微服务的方法是什么？
### 24、开启 SpringBoot 特性有哪几种方式？
### 25、什么是Oauth？
### 26、Bean 工厂和 Application contexts 有什么区别？
### 27、为什么要用SpringBoot
### 28、服务雪崩效应产生的原因
### 29、JdbcTemplate
### 30、什么是Eureka的自我保护模式，
### 31、SpringCloud有几种调用接口方式




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
