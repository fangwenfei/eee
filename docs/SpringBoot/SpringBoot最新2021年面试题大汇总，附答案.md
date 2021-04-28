# SpringBoot最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何集成 SpringBoot 和 ActiveMQ？

对于集成 SpringBoot 和 ActiveMQ，我们使用依赖关系。它只需要很少的配置，并且不需要样板代码。


### 2、SpringBoot 自动配置原理是什么？

注解 @EnableAutoConfiguration, @Configuration, [@ConditionalOnClass ](/ConditionalOnClass ) 就是自动配置的核心，

@EnableAutoConfiguration 给容器导入META-INF/spring.factories 里定义的自动配置类。

筛选有效的自动配置类。

每一个自动配置类结合对应的 xxxProperties.java 读取配置文件进行自动配置功能


### 3、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。

安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用management.security.enabled = false 来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。

如何在自定义端口上运行SpringBoot应用程序？ 为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。 server.port = 8090


### 4、如何在自定义端口上运行SpringBoot应用程序？

为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。

```
 server.port = 8090
```


### 5、微服务同时调用多个接口，怎么支持事务的啊？

支持分布式事务，可以使用SpringBoot集成 Aatomikos来解决，但是我一般不建议这样使用，因为使用分布式事务会增加请求的响应时间，影响系统的TPS。一般在实际工作中，会利用消息的补偿机制来处理分布式的事务。


### 6、SpringBoot事物的使用

SpringBoot的事物很简单，首先使用注解EnableTransactionManagement开启事物之后，然后在Service方法上添加注解Transactional便可。


### 7、SpringBoot常用的starter有哪些?

**1、** `spring-boot-starter-web` (嵌入tomcat和web开发需要servlet与jsp支持)

**2、** `spring-boot-starter-data-jpa` (数据库支持)

**3、** `spring-boot-starter-data-Redis` (Redis数据库支持)

**4、** `spring-boot-starter-data-solr` (solr搜索应用框架支持)

**5、** `mybatis-spring-boot-starter` (第三方的mybatis集成starter)


### 8、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。

GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


### 9、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用

来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 10、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 11、为什么我们需要 spring-boot-maven-plugin?
### 12、您使用了哪些 starter maven 依赖项？
### 13、什么是SpringBoot？
### 14、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 15、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 16、创建一个 SpringBoot Project 的最简单的方法是什么？
### 17、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？
### 18、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 19、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 20、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？
### 21、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 22、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 23、SpringBoot 中如何解决跨域问题 ?
### 24、可以在SpringBoot application中禁用默认的Web服务器吗？
### 25、spring boot 核心的两个配置文件：
### 26、前后端分离，如何维护接口文档 ?
### 27、SpringBoot 实现热部署有哪几种方式？
### 28、什么是Swagger？你用SpringBoot实现了它吗？
### 29、SpringBoot的配置文件有哪几种格式？区别是什么？
### 30、如何使用SpringBoot实现分页和排序？
### 31、Springboot 有哪些优点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
