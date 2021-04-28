# Spring最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、springcloud如何实现服务的注册?

**1、** 服务发布时，指定对应的服务名,将服务注册到 注册中心(eureka zookeeper)

**2、** 注册中心加@EnableEurekaServer,服务用@EnableDiscoveryClient，然后用ribbon或feign进行服务直接的调用发现。


### 2、Spring Cloud Zookeeper

基于Apache Zookeeper的服务治理组件。


### 3、微服务架构如何运作？

微服务架构具有以下组件：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_5.png#alt=img%5C_5.png)

图5：微服务 架构 – 微服务面试问题

客户端 – 来自不同设备的不同用户发送请求。

身份提供商 – 验证用户或客户身份并颁发安全令牌。

API网关 – 处理客户端请求。

静态内容 – 容纳系统的所有内容。

管理 – 在节点上平衡服务并识别故障。

服务发现 – 查找微服务之间通信路径的指南。

内容交付网络 – 代理服务器及其数据中心的分布式网络。

远程服务 – 启用驻留在IT设备网络上的远程访问信息。


### 4、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息； 一些固定的不能被覆盖的属性；一些加密/解密的场景


### 5、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？

SpringBoot支持Java Util Logging，Log4J2，Lockback作为日志框架，如果你使用Starters启动器，SpringBoot将使用Logback作为默认日志框架


### 6、SpringBoot 可以兼容老 Spring 项目吗，如何做？

可以兼容，使用 [@ImportResource ](/ImportResource ) 注解导入老 Spring 项目配置文件。


### 7、Spring Cloud Security

安全工具包，他可以对

**1、** 对Zuul代理中的负载均衡从前端到后端服务中获取SSO令牌

**2、** 资源服务器之间的中继令牌

**3、** 使Feign客户端表现得像`OAuth2RestTemplate`（获取令牌等）的拦截器

**4、** 在Zuul代理中配置下游身份验证

Spring Cloud Security提供了一组原语，用于构建安全的应用程序和服务，而且操作简便。可以在外部（或集中）进行大量配置的声明性模型有助于实现大型协作的远程组件系统，通常具有中央身份管理服务。它也非常易于在Cloud Foundry等服务平台中使用。在SpringBoot和Spring Security OAuth2的基础上，可以快速创建实现常见模式的系统，如单点登录，令牌中继和令牌交换。


### 8、可以通过多少种方式完成依赖注入？

通常，依赖注入可以通过三种方式完成，即：

**1、** 构造函数注入

**2、** setter 注入

**3、** 接口注入

在 Spring Framework 中，仅使用构造函数和 setter 注入。


### 9、架构师在微服务架构中的角色是什么？

微服务架构中的架构师扮演以下角色：

决定整个软件系统的布局。

帮助确定组件的分区。因此，他们确保组件相互粘合，但不紧密耦合。

与开发人员共同编写代码，了解日常生活中面临的挑战。

为开发微服务的团队提供某些工具和技术的建议。

提供技术治理，以便技术开发团队遵循微服务原则。


### 10、您使用了哪些 starter maven 依赖项？

**使用了下面的一些依赖项**

**1、**  spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、**  spring-boot-starter-data-jpa 数据库支持

**3、**  spring-boot-starter-data-Redis Redis数据库支持

**4、**  spring-boot-starter-data-solr solr支持

**5、**  mybatis-spring-boot-starter 第三方的mybatis集成starter

自定义的starter(如果自己开发过就可以说出来)


### 11、服务雪崩效应产生的原因
### 12、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？
### 13、什么是 WebSockets？
### 14、Spring Cloud Config
### 15、spring boot 核心的两个配置文件：
### 16、@RequestMapping注解的作用
### 17、什么是Hystrix断路器？我们需要它吗？
### 18、如何在不使用BasePACKAGE过滤器的情况下排除程序包？
### 19、什么是Hystrix?
### 20、您使用了哪些starter maven依赖项？
### 21、SpringBoot 有哪几种读取配置的方式？
### 22、列举微服务技术栈
### 23、什么是 CSRF 攻击？
### 24、Spring Cloud和SpringBoot版本对应关系
### 25、运行 SpringBoot 有哪几种方式？
### 26、微服务有哪些特点？
### 27、负载平衡的意义什么？
### 28、微服务之间是如何独⽴通讯的
### 29、如何禁用特定的自动配置类？
### 30、为什么我们需要微服务容器？
### 31、您对微服务架构中的语义监控有何了解？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
