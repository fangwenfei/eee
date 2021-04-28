# SpringBoot最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 常用的 Starter 有哪些？

**1、** spring-boot-starter-web ：提供 Spring MVC + 内嵌的 Tomcat 。

**2、** spring-boot-starter-data-jpa ：提供 Spring JPA + Hibernate 。

**3、** spring-boot-starter-data-Redis ：提供 Redis 。

**4、** mybatis-spring-boot-starter ：提供 MyBatis 。


### 2、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 3、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、**  容易上手，提升开发效率，为 Spring 开发提供一个更快、更简单的开发框架。

**2、**  开箱即用，远离繁琐的配置。

**3、**  提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、**  SpringBoot总结就是使编码变简单、配置变简单、部署变简单、监控变简单等等


### 4、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？

是的，可以使用starter依赖项将嵌入式Tomcat替换为任何其他服务器。可以根据需要使用SpringBootStarter Jetty或SpringBootStarter作为每个项目的依赖项。


### 5、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？

让我们以 MySQL 为例来思考这个问题：

**第一步** - 把 MySQL 连接器的依赖项添加至 pom.xml

**第二步** - 从 pom.xml 中移除 H2 的依赖项

或者至少把它作为测试的范围。

**第三步** - 安装你的 MySQL 数据库

更多的来看看这里 -[https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL](https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL)

**第四步** - 配置你的 MySQL 数据库连接

配置 application.properties

```
spring.jpa.hibernate.ddl-auto=none spring.datasource.url=jdbc:MySQL://localhost:3306/todo_example
spring.datasource.username=todouser spring.datasource.password=YOUR_PASSWORD
```

**第五步** - 重新启动，你就准备好了！

就是这么简单！


### 6、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用spring-boot-starter-activemq 依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 7、比较一下 Spring Security 和 Shiro 各自的优缺点 ?

由于 SpringBoot 官方提供了大量的非常方便的开箱即用的 Starter ，包括 Spring Security 的 Starter ，使得在 SpringBoot 中使用 Spring Security 变得更加容易，甚至只需要添加一个依赖就可以保护所有的接口，所以，如果是 SpringBoot 项目，一般选择 Spring Security 。当然这只是一个建议的组合，单纯从技术上来说，无论怎么组合，都是没有问题的。Shiro 和 Spring Security 相比

**主要有如下一些特点：**

**1、** Spring Security 是一个重量级的安全管理框架；Shiro 则是一个轻量级的安全管理框架

**2、** Spring Security 概念复杂，配置繁琐；Shiro 概念简单、配置简单

**3、** Spring Security 功能强大；Shiro 功能简单


### 8、如何给静态变量赋值？

SpringBoot无法通过@Value给静态变量赋值

此时需要给当前类加@Component注解，通过set方法设置@Value注解加载set方法上，set方法的参数可以任意命名，不能同属性名，此后当前工具类下的静态方法可直接使用属性值。



### 9、保护 SpringBoot 应用有哪些方法？

在生产中使用HTTPS 使用Snyk检查你的依赖关系 升级到最新版本 启用CSRF保护 使用内容安全策略防止XSS攻击



### 10、什么是 JavaConfig？

**1、** `面向对象的配置`。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** `减少或消除 XML 配置`。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

**3、** `类型安全和重构友好`。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 11、SpringBoot中的监视器是什么?
### 12、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 13、你如何理解 SpringBoot 配置加载顺序？
### 14、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 15、如何使用 SpringBoot 实现全局异常处理？
### 16、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？
### 17、YAML 配置的优势在哪里 ?
### 18、什么是YAML？
### 19、如何使用SpringBoot实现分页和排序？
### 20、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 21、如何使用SpringBoot实现异常处理?
### 22、我们如何监视所有 SpringBoot 微服务？
### 23、SpringBoot 有哪几种读取配置的方式？
### 24、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 25、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 26、SpringBoot有哪些优点？
### 27、什么是 WebSockets？
### 28、什么是自动配置？
### 29、什么是 YAML？
### 30、运行 SpringBoot 有哪几种方式？
### 31、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
