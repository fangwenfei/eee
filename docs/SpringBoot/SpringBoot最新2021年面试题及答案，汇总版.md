# SpringBoot最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

**1、** 配置变更

**2、** JDK 版本升级

**3、** 第三方类库升级

**4、** 响应式 Spring 编程支持

**5、** HTTP/2 支持

**6、** 配置属性绑定

**7、** 更多改进与加强…


### 2、SpringBoot自动配置的原理是什么？

SpringBoot启动的时候通过@EnableAutoConfiguration注解找到META-INF/spring.factories配置文件中所有的自动配置类，并对其进行加载，而这些自动配置类的类名都是以AutoConfiguration结尾来命名的，它实际上就是一个javaConfig形式的Spring容器配置类，它们都有一个@EnableConfigurationPerperties的注解，通过这个注解启动XXXProperties命名的类去加载全局配置中的属性，如server.port,而XXXProperties通过@ConfigurationProperties注解将全局配置文件中的属性与自己的属性进行绑定。


### 3、SpringBoot 中如何实现定时任务 ?

在 SpringBoot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 [@Scheduled ](/Scheduled ) 注解，另一-个则是使用第三方框架 Quartz。

使用 Spring 中的 [@Scheduled ](/Scheduled ) 的方式主要通过 [@Scheduled ](/Scheduled ) 注解来实现。


### 4、如何使用 SpringBoot 实现异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 5、什么是SpringBoot？

多年来，随着新功能的增加，spring变得越来越复杂。只需访问https://spring.io/projects 页面，我们就会看到可以在我们的应用程序中使用的所有Spring项目的不同功能。如果必须启动一个新的Spring项目，我们必须添加构建路径或添加Maven依赖关系，配置应用程序服务器，添加spring配置。因此，开始一个新的spring项目需要很多努力，因为我们现在必须从头开始做所有事情。

SpringBoot是解决这个问题的方法。SpringBoot已经建立在现有spring框架之上。使用spring启动，我们避免了之前我们必须做的所有样板代码和配置。因此，SpringBoot可以帮助我们以最少的工作量，更加健壮地使用现有的Spring功能。


### 6、你如何理解 SpringBoot 中的 Starters？

Starters可以理解为启动器，它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成 Spring 及其他技术，而不需要到处找示例代码和依赖包。如你想使用 Spring JPA 访问数据库，只要加入 spring-boot-starter-data-jpa 启动器依赖就能使用了。


### 7、什么是 Apache Kafka？

Apache Kafka 是一个分布式发布 - 订阅消息系统。它是一个可扩展的，容错的发布 - 订阅消息系统，它使我们能够构建分布式应用程序。这是一个 Apache 顶级项目。Kafka 适合离线和在线消息消费。


### 8、如何使用 SpringBoot 实现全局异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。 我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 9、spring boot监听器流程?

**1、** 通过`app.addListeners`注册进入 2、初始化一个`SpringApplicationRunListeners`进行处理

**3、** 从`spring.factories`中读取监听器处理类`EventPublishingRunListener`

**4、** 通过`createSpringFactoriesInstances`创建监听器处理类实例

**5、** 调用监听器`listeners.starting()`的方法来启动。

**6、** 底层把事件处理交给`线程池`去处理


### 10、保护 SpringBoot 应用有哪些方法？

**1、**  在生产中使用HTTPS

**2、**  使用Snyk检查你的依赖关系

**3、**  升级到最新版本

**4、**  启用CSRF保护

**5、**  使用内容安全策略防止XSS攻击


### 11、保护 SpringBoot 应用有哪些方法？
### 12、什么是 JavaConfig？
### 13、为什么要用SpringBoot
### 14、SpringBoot的自动配置原理是什么
### 15、如何使用SpringBoot实现分页和排序？
### 16、如何集成SpringBoot和ActiveMQ？
### 17、什么是 Spring Profiles？
### 18、SpringBoot事物的使用
### 19、SpringBoot有哪些优点？
### 20、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 21、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？
### 22、什么是 Spring Batch?
### 23、SpringBoot的启动器有哪几种?
### 24、SpringBoot、Spring MVC 和 Spring 有什么区别
### 25、能否举一个例子来解释更多 Staters 的内容？
### 26、怎么设计无状态服务？
### 27、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 28、我们如何监视所有 SpringBoot 微服务？
### 29、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 30、SpringBoot 的自动配置是如何实现的？
### 31、什么是 YAML？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
