# SpringBoot最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？

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


### 2、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？

**1、**  配置变更

**2、**  JDK 版本升级

**3、**  第三方类库升级

**4、**  响应式 Spring 编程支持

**5、**  HTTP/2 支持

**6、**  配置属性绑定

**7、**  更多改进与加强


### 3、什么是执行器停机？

关机是允许应用程序正常关机的端点。默认情况下，此功能不启用。你可以在应用程序属性文件中使用management . endpoint . shut down . enabled = true来启用此选项。但是该方法请谨慎使用。


### 4、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** Spring

Spring最重要的特征是依赖注入。所有 SpringModules 不是依赖注入就是 IOC 控制反转。

当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC

Spring MVC 提供了一种分离式的方法来开发 Web 应用。通过运用像 DispatcherServelet，MoudlAndView 和 ViewResolver 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** SpringBoot

Spring 和 SpringMVC 的问题在于需要配置大量的参数。

SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 5、如何在 SpringBoot 启动的时候运行一些特定的代码？

可以实现接口 ApplicationRunner 或者 CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个 run 方法


### 6、SpringBoot 还提供了其它的哪些 Starter Project Options？

SpringBoot 也提供了其它的启动器项目包括，包括用于开发特定类型应用程序的典型依赖项。

**1、** spring-boot-starter-web-services - SOAP Web Services；

**2、** spring-boot-starter-web - Web 和 RESTful 应用程序；

**3、** spring-boot-starter-test - 单元测试和集成测试；

**4、** spring-boot-starter-jdbc - 传统的 JDBC；

**5、** spring-boot-starter-hateoas - 为服务添加 HATEOAS 功能；

**6、** spring-boot-starter-security - 使用 SpringSecurity 进行身份验证和授权；

**7、** spring-boot-starter-data-jpa - 带有 Hibeernate 的 Spring Data JPA；

**8、** spring-boot-starter-data-rest - 使用 Spring Data REST 公布简单的 REST 服务；


### 7、spring-boot-starter-parent 有什么用 ?

我们都知道，新创建一个 SpringBoot 项目，默认都是有 parent 的，这个 parent 就是 spring-boot-starter-parent ，spring-boot-starter-parent 主要有如下作用：

**1、**  定义了 Java 编译版本为 1、8 。

**2、**  使用 UTF-8 格式编码。

**3、**  继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。

**4、**  执行打包操作的配置。

**5、**  自动化的资源过滤。

**6、**  自动化的插件配置。

**7、**  针对 application、properties 和 application、yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev、properties 和 application-dev、yml。

总结就是打包用的


### 8、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用

依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 9、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<optional>true</optional>
```


### 10、SpringBoot与SpringCloud 区别

SpringBoot是快速开发的Spring框架，SpringCloud是完整的微服务框架，SpringCloud依赖于SpringBoot。


### 11、spring boot扫描流程?
### 12、SpringBoot 日志框架：
### 13、什么是 JavaConfig？
### 14、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?
### 15、如何使用SpringBoot实现异常处理?
### 16、SpringBoot常用的starter有哪些?
### 17、什么是 SpringBoot Stater ？
### 18、SpringBoot 配置加载顺序?
### 19、如何使用SpringBoot实现分页和排序？
### 20、前后端分离，如何维护接口文档 ?
### 21、什么是 Spring Data REST?
### 22、什么是SpringBoot
### 23、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 24、能否举一个例子来解释更多 Staters 的内容？
### 25、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 26、SpringBoot 怎么用好自动配置，精髓:
### 27、SpringBoot事物的使用
### 28、如何禁用特定的自动配置类？
### 29、SpringBoot有哪些优点？
### 30、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 31、什么是 Spring Batch？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
