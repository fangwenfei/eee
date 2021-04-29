# SpringBoot最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、** 容易上手，提升开发效率，为 Spring 开发提供一个更快、更广泛的入门体验。

**2、** 开箱即用，远离繁琐的配置。

**3、** 提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、** 没有代码生成，也不需要XML配置。

**5、** 避免大量的 Maven 导入和各种版本冲突。


### 2、保护 SpringBoot 应用有哪些方法？

**1、** 在生产中使用HTTPS

**2、** 使用Snyk检查你的依赖关系

**3、** 升级到最新版本

**4、** 启用CSRF保护

**5、** 使用内容安全策略防止XSS攻击


### 3、SpringBoot 需要独立的容器运行吗？

可以不需要，内置了 Tomcat/ Jetty 等容器。


### 4、如何使用 SpringBoot 实现全局异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。 我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 5、在 Spring Initializer 中，如何改变一个项目的包名字？

好消息是你可以定制它。点击链接“转到完整版本”。你可以配置你想要修改的包名称！


### 6、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

org.springframework.boot

spring-boot-devtools

true


### 7、SpringBoot有哪些优点？

**1、** 快速创建独立运行的spring项目与主流框架集成

**2、** 使用嵌入式的servlet容器，应用无需打包成war包

**3、** starters自动依赖与版本控制

**4、** 大量的自动配置，简化开发，也可修改默认值

**5、** 准生产环境的运行应用监控

**6、** 与云计算的天然集成


### 8、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。SpringBoot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 SpringBoot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

```
<dependency>
  <groupId>org、springframework、boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```


### 9、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、**  容易上手，提升开发效率，为 Spring 开发提供一个更快、更简单的开发框架。

**2、**  开箱即用，远离繁琐的配置。

**3、**  提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、**  SpringBoot总结就是使编码变简单、配置变简单、部署变简单、监控变简单等等


### 10、SpringBoot 是否可以使用 XML 配置 ?

SpringBoot 推荐使用 Java 配置而非 XML 配置，但是 SpringBoot 中也可以使用 XML 配置，通过 [@ImportResource ](/ImportResource ) 注解可以引入一个 XML 配置。


### 11、运行 SpringBoot 有哪几种方式？
### 12、bootstrap.yml和application.yml有什么区别?
### 13、SpringBoot、Spring MVC 和 Spring 有什么区别
### 14、spring boot初始化环境变量流程?
### 15、如何在自定义端口上运行SpringBoot应用程序？
### 16、你如何理解 SpringBoot 中的 Starters？
### 17、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 18、SpringBoot 中如何实现定时任务 ?
### 19、SpringBoot 自动配置原理
### 20、如何集成SpringBoot和ActiveMQ？
### 21、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 22、如何使用 SpringBoot 实现分页和排序？
### 23、什么是 FreeMarker 模板？
### 24、SpringBoot需要独立的容器运行？
### 25、什么是 Spring Profiles？
### 26、SpringBoot 实现热部署有哪几种方式？
### 27、什么是JavaConfig？
### 28、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 29、Async异步调用方法
### 30、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 31、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
