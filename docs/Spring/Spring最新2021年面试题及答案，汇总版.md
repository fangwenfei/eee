# Spring最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 SpringBoot？

SpringBoot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，使开发者能快速上手。


### 2、Spring MVC中函数的返回值是什么？



返回值可以有很多类型,有String, ModelAndView。ModelAndView类把视图和数据都合并的一起的，但一般用String比较好。


### 3、WebApplicationContext

WebApplicationContext 继承了ApplicationContext 并增加了一些WEB应用必备的特有功能，它不同于一般的ApplicationContext ，因为它能处理主题，并找到被关联的servlet。


### 4、什么是 Spring 配置文件？

Spring 配置文件是 XML 文件。该文件主要包含类信息。它描述了这些类是如何配置以及相互引入的。但是，XML 配置文件冗长且更加干净。如果没有正确规划和编写，那么在大项目中管理变得非常困难。


### 5、Eureka怎么实现高可用

集群吧，注册多台Eureka，然后把SpringCloud服务互相注册，客户端从Eureka获取信息时，按照Eureka的顺序来访问。


### 6、JdbcTemplate

JdbcTemplate 类提供了很多便利的方法解决诸如把数据库数据转变成基本数据类型或对象，执行写好的或可调用的数据库操作语句，提供自定义的数据错误处理。


### 7、运行 SpringBoot 有哪几种方式？

**1、**  打包用命令或者放到容器中运行

**2、**  用 Maven/ Gradle 插件运行

**3、**  直接执行 main 方法运行


### 8、什么是Oauth？

开放授权协议，这允许通过在HTTP服务上启用客户端应用程序（例如第三方提供商Facebook，GitHub等）来访问资源所有者的资源。因此，您可以在不使用其凭据的情况下与另一个站点共享存储在一个站点上的资源。

OAuth允许像Facebook这样的第三方使用最终用户的帐户信息，同时保证其安全（不使用或暴露用户的密码）。它更像是代表用户的中介，同时为服务器提供访问所需信息的令牌。


### 9、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap.properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。


### 10、SpringBoot多数据源拆分的思路

先在properties配置文件中配置两个数据源，创建分包mapper，使用@ConfigurationProperties读取properties中的配置，使用@MapperScan注册到对应的mapper包中


### 11、什么是Spring MVC？简单介绍下你对Spring MVC的理解？
### 12、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 13、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 14、如何在SpringBoot中禁用Actuator端点安全性？
### 15、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 16、SpringBoot 实现热部署有哪几种方式？
### 17、如何集成SpringBoot和ActiveMQ？
### 18、SpringBoot 有哪几种读取配置的方式？
### 19、SpringBoot 是否可以使用 XML 配置 ?
### 20、列举 Spring Framework 的优点。
### 21、SpringCloud主要项目
### 22、什么是Swagger？你用SpringBoot实现了它吗？
### 23、Spring Cloud Zookeeper
### 24、我们如何监视所有SpringBoot微服务？
### 25、我们如何监视所有 SpringBoot 微服务？
### 26、什么是SpringBoot
### 27、负载平衡的意义什么？
### 28、服务雪崩？
### 29、SpringBoot 中如何实现定时任务 ?
### 30、什么是bean的自动装配？
### 31、Spring Cloud Bus




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
