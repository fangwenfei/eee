# Spring面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot集成mybatis的过程

添加mybatis的starter maven依赖

```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
```

在mybatis的接口中 添加@Mapper注解

在application.yml配置数据源信息


### 2、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationPropertie注解来绑定变量


### 3、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？

path- 这个资源要导出的路径段。

collectionResourceRel- 生成指向集合资源的链接时使用的 rel 值。在生成 HATEOAS 链接时使用。


### 4、如何使用 SpringBoot 部署到不同的服务器？

你需要做下面两个步骤：

在一个项目中生成一个 war 文件。

将它部署到你最喜欢的服务器（websphere 或者 Weblogic 或者 Tomcat and so on）。

**第一步：**这本入门指南应该有所帮助：

[https://spring.io/guides/gs/convert-jar-to-war/](https://spring.io/guides/gs/convert-jar-to-war/)

**第二步：**取决于你的服务器。


### 5、什么是Eureka

Eureka作为SpringCloud的服务注册功能服务器，他是服务注册中心，系统中的其他服务使用Eureka的客户端将其连接到Eureka Service中，并且保持心跳，这样工作人员可以通过Eureka Service来监控各个微服务是否运行正常。


### 6、什么是YAML？

YAML是一种人类可读的数据序列化语言。它通常用于配置文件。

与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。


### 7、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；

一些固定的不能被覆盖的属性；

一些加密/解密的场景；


### 8、什么是基于Java的Spring注解配置? 给一些注解的例子.
### 9、什么是代理?
### 10、SpringBoot的自动配置原理是什么
### 11、什么是YAML？
### 12、链路跟踪Sleuth
### 13、可以通过多少种方式完成依赖注入？
### 14、您使用了哪些 starter maven 依赖项？
### 15、哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入？
### 16、架构师在微服务架构中的角色是什么？
### 17、为什么需要学习Spring Cloud
### 18、SpringBoot 中如何解决跨域问题 ?
### 19、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 20、spring 支持集中 bean scope？
### 21、Ribbon和Feign的区别？
### 22、自动装配有哪些局限性 ?
### 23、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 24、Bean 工厂和 Application contexts 有什么区别？
### 25、Spring MVC的优点
### 26、微服务之间如何独立通讯的?
### 27、@RequestMapping注解的作用
### 28、解释AOP模块
### 29、如何集成 SpringBoot 和 ActiveMQ？
### 30、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
