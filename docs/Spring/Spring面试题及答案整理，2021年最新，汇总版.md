# Spring面试题及答案整理，2021年最新，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是微服务中的反应性扩展？

Reactive Extensions也称为Rx。这是一种设计方法，我们通过调用多个服务来收集结果，然后编译组合响应。这些调用可以是同步或异步，阻塞或非阻塞。Rx是分布式系统中非常流行的工具，与传统流程相反。

希望这些微服务面试问题可以帮助您进行微服务架构师访谈。

翻译来源：[https://www.edureka.co/blog/interview-questions/microservices-interview-questions/](https://www.edureka.co/blog/interview-questions/microservices-interview-questions/)



### 2、解释WEB 模块。

Spring的WEB模块是构建在application context 模块基础之上，提供一个适合web应用的上下文。这个模块也包括支持多种面向web的任务，如透明地处理多个文件上传请求和程序级请求参数的绑定到你的业务对象。它也有对Jakarta Struts的支持。


### 3、什么是JavaConfig？

Spring JavaConfig是Spring社区的产品，它提供了配置Spring IoC容器的纯Java方法。因此它有助于避免使用XML配置。使用JavaConfig的优点在于：

**1、** 面向对象的配置。由于配置被定义为JavaConfig中的类，因此用户可以充分利用Java中的面向对象功能。一个配置类可以继承另一个，重写它的@Bean方法等。

**2、** 减少或消除XML配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在XML和Java之间来回切换。JavaConfig为开发人员提供了一种纯Java方法来配置与XML配置概念相似的Spring容器。从技术角度来讲，只使用JavaConfig配置类来配置容器是可行的，但实际上很多人认为将JavaConfig与XML混合匹配是理想的。

**3、** 类型安全和重构友好。JavaConfig提供了一种类型安全的方法来配置Spring容器。由于Java 5.0对泛型的支持，现在可以按类型而不是按名称检索bean，不需要任何强制转换或基于字符串的查找。


### 4、SpringBoot 有哪几种读取配置的方式？

- `@PropertySource`
- `@Value`
- `@Environment`
- `@ConfigurationPropertie`


### 5、[@Qualifier ](/Qualifier ) 注解有什么用？

当您创建多个相同类型的 bean 并希望仅使用属性装配其中一个 bean 时，您可以使用[@Qualifier ](/Qualifier ) 注解和 [@Autowired ](/Autowired ) 通过指定应该装配哪个确切的 bean 来消除歧义。


### 6、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。为了帮助我们处理这种情况，我们将使用位于的开源项目。 它建立在 SpringBoot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。


### 7、eureka服务注册与发现原理

**1、** 每30s发送⼼跳检测重新进⾏租约，如果客户端不能多次更新租约，它将在90s内从服务器注册中⼼移除。

**2、** 注册信息和更新会被复制到其他Eureka 节点，来⾃任何区域的客户端可以查找到注册中⼼信息，每30s发⽣⼀次复制来定位他们的服务，并进⾏远程调⽤。

**3、** 客户端还可以缓存⼀些服务实例信息，所以即使Eureka全挂掉，客户端也是可以定位到服务地址的。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_4.png#alt=45%5C_4.png)


### 8、Spring由哪些模块组成?

以下是Spring 框架的基本模块：

**1、** Core module

**2、** Bean module

**3、** Context module

**4、** Expression Language module

**5、** JDBC module

**6、** ORM module

**7、** OXM module

**8、** Java Messaging Service(JMS) module

**9、** Transaction module

**10、** Web module

**11、** Web-Servlet module

**12、** Web-Struts module

**13、** Web-Portlet module


### 9、有哪些类型的通知（Advice）？

**1、** Before - 这些类型的 Advice 在 joinpoint 方法之前执行，并使用 [@Before ](/Before ) 注解标记进行配置。

**2、** After Returning - 这些类型的 Advice 在连接点方法正常执行后执行，并使用[@AfterReturning ](/AfterReturning ) 注解标记进行配置。

**3、** After Throwing - 这些类型的 Advice 仅在 joinpoint 方法通过抛出异常退出并使用 [@AfterThrowing ](/AfterThrowing ) 注解标记配置时执行。

**4、** After (finally) - 这些类型的 Advice 在连接点方法之后执行，无论方法退出是正常还是异常返回，并使用 [@After ](/After ) 注解标记进行配置。

**5、** Around - 这些类型的 Advice 在连接点之前和之后执行，并使用 [@Around ](/Around ) 注解标记进行配置。


### 10、保护 SpringBoot 应用有哪些方法？

在生产中使用HTTPS 使用Snyk检查你的依赖关系 升级到最新版本 启用CSRF保护 使用内容安全策略防止XSS攻击



### 11、在 Spring Initializer 中，如何改变一个项目的包名字？
### 12、什么是耦合？
### 13、什么是Spring Cloud Bus？我们需要它吗？
### 14、SpringBoot Starter 的工作原理是什么？
### 15、什么是starter?
### 16、什么是通知（Advice）？
### 17、什么是 Spring Batch?
### 18、Spring MVC怎么样设定重定向和转发的？
### 19、各服务之间通信，对Restful和Rpc这2种方式如何做选择？
### 20、SpringBoot有哪些优点？
### 21、网关的作用是什么
### 22、SpringCloud Config 可以实现实时刷新吗？
### 23、SpringBoot 中如何解决跨域问题 ?
### 24、[@RequestMapping ](/RequestMapping ) 注解
### 25、springcloud和dubbo有哪些区别
### 26、如何在自定义端口上运行SpringBoot应用程序？
### 27、什么是 Spring Cloud Bus？
### 28、在使用微服务架构时，您面临哪些挑战？
### 29、什么是依赖注入？
### 30、ApplicationContext通常的实现是什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
