# Spring高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

**1、** spring-boot:run 运行你的 SpringBooty 应用程序。

**2、** spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

**3、** spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

**4、** spring-boot:build-info 生成执行器可以使用的构造信息。


### 2、列举 IoC 的一些好处。

**IoC 的一些好处是：**

**1、** 它将最小化应用程序中的代码量。

**2、** 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。

**3、** 它以最小的影响和最少的侵入机制促进松耦合。

**4、** 它支持即时的实例化和延迟加载服务。


### 3、可以通过多少种方式完成依赖注入？

通常，依赖注入可以通过三种方式完成，即：

**1、** 构造函数注入

**2、** setter 注入

**3、** 接口注入

在 Spring Framework 中，仅使用构造函数和 setter 注入。


### 4、如何在 SpringBoot 中添加通用的 JS 代码？

在源文件夹下，创建一个名为 static 的文件夹。然后，你可以把你的静态的内容放在这里面。

例如，myapp.js 的路径是 resources\static\js\myapp.js

**

你可以参考它在 jsp 中的使用方法：**

错误：HAL browser gives me unauthorized error - Full authenticaition is required to access this resource.

该如何来修复这个错误呢？

两种方法：

方法 1：关闭安全验证

application.properties

```
management.security.enabled:FALSE
```

方法二：在日志中搜索密码并传递至请求标头中


### 5、Spring MVC常用的注解有哪些？

**1、** @RequestMapping：用于处理请求 url 映射的注解，可用于类或方法上。用于类上，则表示类中的所有响应请求的方法都是以该地址作为父路径。

**2、** @RequestBody：注解实现接收http请求的json数据，将json转换为java对象。

**3、** @ResponseBody：注解实现将conreoller方法返回对象转化为json对象响应给客户。

**4、** @Conntroller：控制器的注解，表示是表现层,不能用用别的注解代替


### 6、什么是SpringBoot ？

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置

**5、** 自动配置spring添加对应功能starter自动化配置

**6、** spring boot来简化spring应用开发，约定大于配置，去繁从简，just run就能创建一个独立的，产品级别的应用


### 7、如何在 SpringBoot 启动的时候运行一些特定的代码？

可以实现接口 ApplicationRunner 或者 CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个 run 方法


### 8、什么是Spring的MVC框架？

Spring 配备构建Web 应用的全功能MVC框架。Spring可以很便捷地和其他MVC框架集成，如Struts，Spring 的MVC框架用控制反转把业务对象和控制逻辑清晰地隔离。它也允许以声明的方式把请求参数和业务对象绑定。


### 9、什么是耦合和凝聚力？

组件之间依赖关系强度的度量被认为是**耦合**。一个好的设计总是被认为具有**高内聚力和低耦合性**。 面试官经常会问起凝聚力。它也是另一个测量单位。更像是一个模块内部的元素保持结合的程度。 必须记住，设计微服务的一个重要关键是低耦合和高内聚的组合。当低耦合时，服务对其他服务的依赖很少。这样可以保持服务的完整性。在高内聚性中，将所有相关逻辑保存在服务中成为可能。否则，服务将尝试彼此通信，从而影响整体性能。


### 10、Spring、SpringBoot、SpringMVC的区别？

**1、** Spring框架就像一个家族，有众多衍生产品，例如boot、mvc、jpa等等。但他们的基础都是Spring的ioc、aop。ioc提供了依赖注入的容器，aop解决了面向横切面编程，然后在此两者的基础上实现了其它延伸产品的高级功能；

**2、** springMVC是基于Servlet的一个MVC框架主要解决WEB开发的问题；

**3、** 为了简化开发的使用，从而创造性地推出了SpringBoot框架，默认优于配置


### 11、Container在微服务中的用途是什么？
### 12、DiscoveryClient的作用
### 13、spring 支持集中 bean scope？
### 14、什么是Feign？
### 15、Spring Cloud和各子项目版本对应关系
### 16、SpringBoot事物的使用
### 17、什么是Spring MVC？简单介绍下你对Spring MVC的理解？
### 18、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 19、网关与过滤器有什么区别
### 20、不同版本的 Spring Framework 有哪些主要功能？
### 21、开启 SpringBoot 特性有哪几种方式？
### 22、什么是Spring Cloud？
### 23、SpringBoot 需要独立的容器运行吗？
### 24、解释对象/关系映射集成模块。
### 25、负载平衡的意义什么？
### 26、什么是Spring Cloud Zuul（服务网关）
### 27、SpringBoot 中如何解决跨域问题 ?
### 28、什么是编织（Weaving）？
### 29、什么是 AOP 代理?
### 30、@Controller注解的作用
### 31、如何使用SpringBoot实现分页和排序？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
