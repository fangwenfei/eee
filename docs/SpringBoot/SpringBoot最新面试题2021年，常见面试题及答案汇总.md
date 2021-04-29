# SpringBoot最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 实现热部署有哪几种方式？

主要有两种方式：

**1、** Spring Loaded

**2、** Spring-boot-devtools


### 2、SpringBoot有哪些优点？

减少开发，测试时间和努力。

使用JavaConfig有助于避免使用XML。

避免大量的Maven导入和各种版本冲突。

提供意见发展方法。

通过提供默认值快速开始开发。

没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 3、SpringBoot 需要独立的容器运行吗？

可以不需要，内置了 Tomcat/ Jetty 等容器。


### 4、@SpringBootApplication注释在内部有什么用处?

作为Spring引导文档，@SpringBootApplication注释等同于同时使用@Configuration、@EnableAutoConfiguration和@ComponentScan及其默认属性。SpringBoot允许开发人员使用单个注释而不是多个注释。但是，众所周知，Spring提供了松散耦合的特性，我们可以根据项目需要为每个注释使用这些特性。


### 5、运行 SpringBoot 有哪几种方式？

**1、**  打包用命令或者放到容器中运行

**2、**  用 Maven/ Gradle 插件运行

**3、**  直接执行 main 方法运行


### 6、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 7、SpringBoot微服务中如何实现 session 共享 ?

在微服务中，一个完整的项目被拆分成多个不相同的独立的服务，各个服务独立部署在不同的服务器上，各自的 session 被从物理空间上隔离开了，但是经常，我们需要在不同微服务之间共享 session ，常见的方案就是 Spring Session + Redis 来实现 session 共享。将所有微服务的 session 统一保存在 Redis 上，当各个微服务对 session 有相关的读写操作时，都去操作 Redis 上的 session 。这样就实现了 session 共享，Spring Session 基于 Spring 中的代理过滤器实现，使得 session 的同步操作对开发人员而言是透明的，非常简便。


### 8、SpringBoot 还提供了其它的哪些 Starter Project Options？

SpringBoot 也提供了其它的启动器项目包括，包括用于开发特定类型应用程序的典型依赖项。

**1、** spring-boot-starter-web-services - SOAP Web Services；

**2、** spring-boot-starter-web - Web 和 RESTful 应用程序；

**3、** spring-boot-starter-test - 单元测试和集成测试；

**4、** spring-boot-starter-jdbc - 传统的 JDBC；

**5、** spring-boot-starter-hateoas - 为服务添加 HATEOAS 功能；

**6、** spring-boot-starter-security - 使用 SpringSecurity 进行身份验证和授权；

**7、** spring-boot-starter-data-jpa - 带有 Hibeernate 的 Spring Data JPA；

**8、** spring-boot-starter-data-rest - 使用 Spring Data REST 公布简单的 REST 服务；


### 9、什么是 SpringBoot？

SpringBoot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。


### 10、我们如何监视所有SpringBoot微服务？

SpringBoot提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及50个应用程序的微服务，管理员将不得不击中所有50个应用程序的执行终端。

为了帮助我们处理这种情况，我们将使用位于

的开源项目。 它建立在SpringBoot Actuator之上，它提供了一个Web UI，使我们能够可视化多个应用程序的度量。


### 11、如何在 SpringBoot 中添加通用的 JS 代码？
### 12、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 13、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？
### 14、开启 SpringBoot 特性有哪几种方式？
### 15、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？
### 16、SpringBoot 可以兼容老 Spring 项目吗，如何做？
### 17、前后端分离，如何维护接口文档 ?
### 18、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 19、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 20、什么是JavaConfig？
### 21、Springboot 有哪些优点？
### 22、SpringBoot 中的 starter 到底是什么 ?
### 23、spring-boot-starter-parent有什么用？
### 24、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 25、SpringBoot 配置加载顺序?
### 26、SpringBoot 配置文件的加载顺序
### 27、什么是Spring Batch？
### 28、如何给静态变量赋值？
### 29、SpringBoot事物的使用
### 30、SpringBoot集成mybatis的过程
### 31、什么是 Spring Batch？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
