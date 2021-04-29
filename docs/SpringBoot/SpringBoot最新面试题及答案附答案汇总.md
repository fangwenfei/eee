# SpringBoot最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。SpringBoot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 SpringBoot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

```
<dependency>
  <groupId>org、springframework、boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```


### 2、bootstrap.yml和application.yml有什么区别?

**1、** Spring Cloud 构建于 SpringBoot 之上，在 SpringBoot 中有两种上下文，一种是 bootstrap，另外一种是 application。

**2、** application 配置文件这个容易理解，主要用于 SpringBoot 项目的`自动化配置`。

**3、** bootstrap 是应用程序的父上下文，也就是说 `bootstrap 加载优先于 applicaton`。

**4、** bootstrap 主要用于从`额外的资源来加载配置信息`，还可以在本地外部配置文件中解密属性。

**5、** 这两个上下文`共用一个环境`，它是任何Spring应用程序的外部属性的来源。

**6、** bootstrap 里面的属性会`优先加载`，它们默认也不能被本地相同配置覆盖。

**7、** boostrap 由父 ApplicationContext 加载，`比 applicaton 优先加载`

**8、** boostrap 里面的属性`不能被覆盖`


### 3、运行 SpringBoot 有哪几种方式？

打包用命令或者放到容器中运行

用 Maven/ Gradle 插件运行

直接执行 main 方法运行


### 4、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在发布它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 5、如何在自定义端口上运行 SpringBoot 应用程序？

为了在自定义端口上运行 SpringBoot 应用程序，您可以在application.properties 中指定端口。server.port = 8090


### 6、什么是 SpringBoot？

SpringBoot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，使开发者能快速上手。


### 7、什么是 Spring Data？

来自：[//projects.spring.io/spring-](//projects.spring.io/spring-) data/

Spring Data 的使命是在保证底层数据存储特殊性的前提下，为数据访问提供一个熟悉的，一致性的，基于 Spring 的编程模型。这使得使用数据访问技术，关系数据库和非关系数据库，map-reduce 框架以及基于云的数据服务变得很容易。

为了让它更简单一些，Spring Data 提供了不受底层数据源限制的 Abstractions 接口。

你可以定义一简单的库，用来插入，更新，删除和检索代办事项，而不需要编写大量的代码。


### 8、SpringBoot有哪些优点？

**1、** 快速创建独立运行的spring项目与主流框架集成

**2、** 使用嵌入式的servlet容器，应用无需打包成war包

**3、** starters自动依赖与版本控制

**4、** 大量的自动配置，简化开发，也可修改默认值

**5、** 准生产环境的运行应用监控

**6、** 与云计算的天然集成


### 9、能否举一个例子来解释更多 Staters 的内容？

让我们来思考一个 Stater 的例子 -SpringBoot Stater Web。

如果你想开发一个 web 应用程序或者是公开 REST 服务的应用程序。SpringBoot Start Web 是首选。让我们使用 Spring Initializr 创建一个 SpringBoot Start Web 的快速项目。

**依赖项可以被分为：**

**1、** Spring - core，beans，context，aop

**2、** Web MVC - （Spring MVC）

**3、** Jackson - for JSON Binding

**4、** Validation - Hibernate,Validation API

**5、** Enbedded Servlet Container - Tomcat

**6、** Logging - logback,slf4j

任何经典的 Web 应用程序都会使用所有这些依赖项。SpringBoot Starter Web 预先打包了这些依赖项。

作为一个开发者，我不需要再担心这些依赖项和它们的兼容版本。


### 10、什么是SpringBoot

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置


### 11、什么是CSRF攻击？
### 12、什么是 JavaConfig？
### 13、保护 SpringBoot 应用有哪些方法？
### 14、什么是SpringBoot ？
### 15、你能否举一个以 ReadOnly 为事务管理的例子？
### 16、SpringBoot 自动配置原理是什么？
### 17、如何使用 SpringBoot 生成一个 WAR 文件？
### 18、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 19、你如何理解 SpringBoot 中的 Starters？
### 20、各服务之间通信，对Restful和Rpc这2种方式如何做选择？
### 21、创建一个 SpringBoot Project 的最简单的方法是什么？
### 22、我们如何监视所有 SpringBoot 微服务？
### 23、SpringBoot的启动器有哪几种?
### 24、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 25、SpringBoot多数据源事务如何管理
### 26、什么是 JavaConfig？
### 27、什么是 SpringBoot Stater ？
### 28、SpringBoot中的监视器是什么？
### 29、SpringBoot 实现热部署有哪几种方式？
### 30、SpringBoot 中如何实现定时任务 ?
### 31、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
