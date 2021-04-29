# SpringBoot最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 Spring Profiles？

在项目的开发中，有些配置文件在开发、测试或者生产等不同环境中可能是不同的，例如数据库连接、Redis的配置等等。那我们如何在不同环境中自动实现配置的切换呢？Spring给我们提供了profiles机制给我们提供的就是来回切换配置文件的功能

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 2、SpringBoot 有哪几种读取配置的方式？

- `@PropertySource`
- `@Value`
- `@Environment`
- `@ConfigurationPropertie`


### 3、spring-boot-starter-parent 有什么用 ?

我们都知道，新创建一个 SpringBoot 项目，默认都是有 parent 的，这个 parent 就是 spring-boot-starter-parent ，spring-boot-starter-parent 主要有如下作用：

**1、**  定义了 Java 编译版本为 1、8 。

**2、**  使用 UTF-8 格式编码。

**3、**  继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。

**4、**  执行打包操作的配置。

**5、**  自动化的资源过滤。

**6、**  自动化的插件配置。

**7、**  针对 application、properties 和 application、yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev、properties 和 application-dev、yml。

总结就是打包用的


### 4、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 5、spring boot扫描流程?

**1、** 调用run方法中的`refreshContext`方法

**2、** 用AbstractApplicationContext中的`refresh`方法

**3、** 委托给`invokeBeanFactoryPostProcessors`去处理调用链

**4、** 其中一个方法`postProcessBeanDefinitionRegistry会`去调用`processConfigBeanDefinitions`解析`beandefinitions`

**5、** 在`processConfigBeanDefinitions`中有一个`parse`方法，其中有`componentScanParser.parse`的方法，这个方法会扫描当前路径下所有`Component`组件


### 6、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?

是的，更改端口是可行的。可以使用application.properties文件更改端口。但需要提到“server.port”（即server.port=8081）。确保项目类路径中有application.properties；后续工作将由REST Spring框架接手。如果提到server.port=0，那么它将自动分配任何可用的端口。


### 7、SpringBoot 最大的优势是什么呢？

SpringBoot 的最大的优势是“约定优于配置“。“约定优于配置“是一种软件设计范式，开发人员按照约定的方式来进行编程，可以减少软件开发人员需做决定的数量，获得简单的好处，而又不失灵活性。

SpringBoot 中 “约定优于配置“的具体产品体现在哪里。

SpringBoot Starter、SpringBoot Jpa 都是“约定优于配置“的一种体现。都是通过“约定优于配置“的设计思路来设计的，SpringBoot Starter 在启动的过程中会根据约定的信息对资源进行初始化；SpringBoot Jpa 通过约定的方式来自动生成 Sql ，避免大量无效代码编写。具体详细可以参考：SpringBoot 为什么这么火？


### 8、YAML 配置的优势在哪里 ?
### 9、如何使用SpringBoot实现异常处理?
### 10、我们如何监视所有 SpringBoot 微服务？
### 11、您使用了哪些 starter maven 依赖项？
### 12、什么是 YAML？
### 13、SpringBoot 中的监视器是什么？
### 14、如何在SpringBoot中禁用Actuator端点安全性？
### 15、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 16、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 17、运行 SpringBoot 有哪几种方式？
### 18、什么是starter?
### 19、您使用了哪些starter maven依赖项？
### 20、SpringBoot 自动配置原理
### 21、如何使用SpringBoot实现分页和排序？
### 22、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?
### 23、SpringBoot有哪些优点？
### 24、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 25、Async异步调用方法
### 26、SpringBoot 怎么用好自动配置，精髓:
### 27、SpringBoot 实现热部署有哪几种方式？
### 28、项目中前后端分离部署，所以需要解决跨域的问题。
### 29、创建一个 SpringBoot Project 的最简单的方法是什么？
### 30、什么是Spring Profiles？
### 31、什么是 SpringBoot 启动类注解：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
