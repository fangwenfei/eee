# Spring最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cloud的版本关系

Spring Cloud是一个由许多子项目组成的综合项目，各子项目有不同的发布节奏。 为了管理Spring Cloud与各子项目的版本依赖关系，发布了一个清单，其中包括了某个Spring Cloud版本对应的子项目版本。 为了避免Spring Cloud版本号与子项目版本号混淆，Spring Cloud版本采用了名称而非版本号的命名，这些版本的名字采用了伦敦地铁站的名字，根据字母表的顺序来对应版本时间顺序，例如Angel是第一个版本，Brixton是第二个版本。 当Spring Cloud的发布内容积累到临界点或者一个重大BUG被解决后，会发布一个"service releases"版本，简称SRX版本，比如Greenwich.SR2就是Spring Cloud发布的Greenwich版本的第2个SRX版本。目前Spring Cloud的最新版本是Hoxton。


### 2、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** SpringSpring最重要的特征是依赖注入。所有 `SpringModules` 不是依赖注入就是 IOC 控制反转。当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC提供了一种分离式的方法来开发 Web 应用。通过运用像 `DispatcherServelet`，`MoudlAndView` 和 `ViewResolver` 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** Spring 和 SpringMVC 的问题在于需要配置大量的参数。

**4、** SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 3、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

org.springframework.boot

spring-boot-devtools

true


### 4、能否举一个例子来解释更多 Staters 的内容？

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


### 5、什么是金丝雀释放？

Canary Releasing是一种降低在生产中引入新软件版本的风险的技术。这是通过将变更缓慢地推广到一小部分用户，然后将其发布到整个基础架构，即将其提供给每个人来完成的。


### 6、什么是 SpringBoot Stater ？

启动器是一套方便的依赖没描述符，它可以放在自己的程序中。你可以一站式的获取你所需要的 Spring 和相关技术，而不需要依赖描述符的通过示例代码搜索和复制黏贴的负载。

例如，如果你想使用 Sping 和 JPA 访问数据库，只需要你的项目包含 spring-boot-starter-data-jpa 依赖项，你就可以完美进行。


### 7、什么是 SpringBoot？

SpringBoot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，使开发者能快速上手。


### 8、SpringBoot事物的使用

SpringBoot的事物很简单，首先使用注解EnableTransactionManagement开启事物之后，然后在Service方法上添加注解Transactional便可。


### 9、过渡到微服务时的常见错误

不仅在开发上，而且在方面流程也经常发生错误。一些常见错误是：

**1、** 通常开发人员无法概述当前的挑战。

**2、** 重写已经存在的程序。

**3、** 职责、时间线和界限没有明确定义。

**4、** 未能从一开始就实施和确定自动化的范围。


### 10、解释Spring框架中bean的生命周期。

**1、** Spring容器 从XML 文件中读取bean的定义，并实例化bean。

**2、** Spring根据bean的定义填充所有的属性。

**3、** 如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。

**4、** 如果Bean 实现了 BeanFactoryAware 接口， Spring传递beanfactory 给setBeanFactory 方法。

**5、** 如果有任何与bean相关联的BeanPostProcessors，Spring会在postProcesserBeforeInitialization()方法内调用它们。

**6、** 如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。

**7、** 如果有BeanPostProcessors 和bean 关联，这些bean的postProcessAfterInitialization() 方法将被调用。

**8、** 如果bean实现了 DisposableBean，它将调用destroy()方法。


### 11、什么是客户证书？
### 12、Spring Cloud和各子项目版本对应关系
### 13、Zuul网关如何搭建集群
### 14、YAML 配置的优势在哪里 ?
### 15、SpringBoot 中如何实现定时任务 ?
### 16、如何通过HibernateDaoSupport将Spring和Hibernate结合起来？
### 17、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 18、什么是 AOP 目标对象?
### 19、PACT如何运作？
### 20、Spring AOP and AspectJ AOP 有什么区别？
### 21、SpringBoot 实现热部署有哪几种方式？
### 22、spring 中有多少种 IOC 容器？
### 23、微服务设计的基础是什么？
### 24、服务雪崩效应产生的原因
### 25、使用 Spring 有哪些方式？
### 26、自动装配有什么局限？
### 27、什么是基于Java的Spring注解配置? 给一些注解的例子.
### 28、Spring由哪些模块组成?
### 29、解释AOP模块
### 30、什么是starter?
### 31、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
