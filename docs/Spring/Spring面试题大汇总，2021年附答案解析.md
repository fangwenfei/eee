# Spring面试题大汇总，2021年附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、spring-boot-starter-parent有什么用？

我们都知道，新建一个SpringBoot项目，默认都是由parent的，这个parent就是spring-boot-starter-parent，spring-boot-starter-parent主要有以下作用：

**1、** 定义了Java编译版本为1.8

**2、** 使用UTF-8格式编码

**3、** 继承自spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所有我们在写依赖时才不需要写版本号。

**4、** 针对application.propertiess和application.yml的资源过滤，包括通过profile定义的不同环境的配置文件，例如application-dev.properties和application-dev.yml。


### 2、SpringBoot、Spring MVC 和 Spring 有什么区别

**1、** Spring 是一个“引擎”，

**2、** Spring MVC是基于Spring的一个 MVC 框架，

**3、** SpringBoot是基于 Spring的一套快速开发整合包


### 3、如何在 spring 中启动注解装配？

默认情况下，Spring 容器中未打开注解装配。因此，要使用基于注解装配，我们必须通过配置 `<context：annotation-config/>` 元素在 Spring 配置文件中启用它。


### 4、[@RequestMapping ](/RequestMapping ) 注解有什么用？

[@RequestMapping ](/RequestMapping ) 注解用于将特定 HTTP 请求方法映射到将处理相应请求的控制器中的特定类/方法。

**此注解可应用于两个级别：**

类级别： 映射请求的 URL

方法级别： 映射 URL 以及 HTTP 请求方法


### 5、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在发布它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 6、微服务之间是如何独⽴通讯的

**1、** Dubbo 使⽤的是 RPC 通信，⼆进制传输，占⽤带宽⼩；

**2、** Spring Cloud 使⽤的是 HTTP RESTFul ⽅式。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_2.png#alt=45%5C_2.png)


### 7、你如何理解 SpringBoot 中的 Starters？

Starters可以理解为启动器，它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成 Spring 及其他技术，而不需要到处找示例代码和依赖包。如你想使用 Spring JPA 访问数据库，只要加入 spring-boot-starter-data-jpa 启动器依赖就能使用了。


### 8、@ResponseBody注解的作用

**作用：**

该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。

**使用时机：**

返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；


### 9、使用 Spring 有哪些方式？

**使用 Spring 有以下方式：**

**1、** 作为一个成熟的 Spring Web 应用程序。

**2、** 作为第三方 Web 框架，使用 Spring Frameworks 中间层。

**3、** 用于远程使用。

**4、** 作为企业级 Java Bean，它可以包装现有的 POJO（Plain Old Java Objects）。


### 10、SOA和微服务架构之间的主要区别是什么？

SOA和微服务之间的主要区别如下：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_8.png#alt=img%5C_8.png)


### 11、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter
### 12、什么是通知（Advice）？
### 13、什么是 Spring IOC 容器？
### 14、负载均衡的意义是什么?
### 15、什么是Eureka
### 16、Spring由哪些模块组成?
### 17、XMLBeanFactory
### 18、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?
### 19、请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？
### 20、解释Spring支持的几种bean的作用域。
### 21、列举 IoC 的一些好处
### 22、22。你能否给出关于休息和微服务的要点？
### 23、PACT在微服务架构中的用途是什么？
### 24、SpringBoot和springcloud认识
### 25、怎么设计无状态服务？
### 26、什么是 Spring Data ?
### 27、springcloud如何实现服务的注册?
### 28、SpringBoot 自动配置原理
### 29、SpringBoot运行项目的几种方式？
### 30、什么是FreeMarker模板？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
