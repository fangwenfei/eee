# Spring最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、哪些是重要的bean生命周期方法？ 你能重载它们吗？

有两个重要的bean 生命周期方法，第一个是setup ， 它是在容器加载bean的时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。

The bean 标签有两个重要的属性（init-method和destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct和@PreDestroy）。


### 2、访问RESTful微服务的方法是什么？

另一个经常被问到的微服务面试问题是如何访问RESTful微服务？你可以通过两种方法做到这一点：

**1、** 使用负载平衡的REST模板。

**2、** 使用多个微服务。


### 3、SpringBoot 中的监视器是什么？

Spring boot actuator 是 spring 启动框架中的重要功能之一。Spring boot 监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为 HTTP URL 访问的REST 端点来检查状态。


### 4、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** Spring

Spring最重要的特征是依赖注入。所有 SpringModules 不是依赖注入就是 IOC 控制反转。

当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC

Spring MVC 提供了一种分离式的方法来开发 Web 应用。通过运用像 DispatcherServelet，MoudlAndView 和 ViewResolver 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** SpringBoot

Spring 和 SpringMVC 的问题在于需要配置大量的参数。

SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 5、自动装配有什么局限？

覆盖的可能性 - 您始终可以使用 `<constructor-arg>` 和 `<property>` 设置指定依赖项，这将覆盖自动装配。基本元数据类型 - 简单属性（如原数据类型，字符串和类）无法自动装配。令人困惑的性质 - 总是喜欢使用明确的装配，因为自动装配不太精确。


### 6、什么是不同类型的双因素身份认证？

执行双因素身份验证需要三种类型的凭据：

**1、** 一件你知道的事情——比如密码、密码或屏幕锁定模式。

**2、** 您拥有的物理凭证，如OTP、电话或ATM卡，换句话说，您在外部或第三方设备中拥有的任何类型的凭证。

**3、** 您的物理身份–如语音认证或生物特征安全，如指纹或眼睛扫描仪。


### 7、如何设置服务发现？

有多种方法可以设置服务发现。我将选择我认为效率最高的那个，Netflix的Eureka。这是一个简单的程序，不会对应用程序造成太大影响。此外，它支持多种类型的Web应用程序。 Eureka配置包括两个步骤 - 客户端配置和服务器配置。

使用属性文件可以轻松完成客户端配置。在clas spath中，Eureka搜索一个eureka-client.properties文件。它还搜索由特定于环境的属性文件中的环境引起的覆盖。

对于服务器配置，您必须首先配置客户端。完成后，服务器启动一个客户端，该客户端用于查找其他服务器。。默认情况下，Eureka服务器使用客户端配置来查找对等服务器。


### 8、什么是 Aspect 切面

AOP核心就是切面，它将多个类的通用行为封装成可重用的模块，该模块含有一组API提供横切功能。比如，一个日志模块可以被称作日志的AOP切面。根据需求的不同，一个应用程序可以有若干切面。在Spring AOP中，切面通过带有@Aspect注解的类实现。


### 9、列举微服务技术栈

**1、** 服务⽹关Zuul

**2、** 服务注册发现Eureka+Ribbon

**3、** 服务配置中⼼Apollo

**4、** 认证授权中⼼Spring Security OAuth2

**5、** 服务框架SpringBoot

**6、** 数据总线Kafka

**7、** ⽇志监控ELK

**8、** 调⽤链监控CAT

**9、** Metrics监控KairosDB

**10、** 健康检查和告警ZMon

**11、** 限流熔断和流聚合Hystrix/Turbine


### 10、什么是 Swagger？你用 SpringBoot 实现了它吗？

Swagger 广泛用于可视化 API，使用 Swagger UI 为前端开发人员提供在线沙箱。Swagger 是用于生成 RESTful Web 服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过 Swagger 正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。


### 11、开启 SpringBoot 特性有哪几种方式？
### 12、自动装配有哪些方式？
### 13、Spring支持的事务管理类型
### 14、什么是SpringBoot？
### 15、什么是OAuth？
### 16、请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？
### 17、微服务有哪些特点？
### 18、什么是 spring bean？
### 19、如何给Spring 容器提供配置元数据?
### 20、怎样在方法里面得到Request,或者Session？
### 21、spring JDBC API 中存在哪些类？
### 22、什么是织入。什么是织入应用的不同点？
### 23、spring cloud 和dubbo区别?
### 24、[@Controller ](/Controller ) 注解
### 25、SpringBoot 还提供了其它的哪些 Starter Project Options？
### 26、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 27、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?
### 28、为什么需要域驱动设计（DDD）？
### 29、在微服务中，如何保护服务?
### 30、SpringBoot 如何设置支持跨域请求？
### 31、ApplicationContext通常的实现是什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
