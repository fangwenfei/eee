# SpringBoot最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 中如何实现定时任务 ?

定时任务也是一个常见的需求，SpringBoot 中对于定时任务的支持主要还是来自 Spring 框架。

在 SpringBoot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 [@Scheduled ](/Scheduled ) 注解，另一个则是使用第三方框架 Quartz。

使用 Spring 中的 [@Scheduled ](/Scheduled ) 的方式主要通过 [@Scheduled ](/Scheduled ) 注解来实现。

使用 Quartz ，则按照 Quartz 的方式，定义 Job 和 Trigger 即可。



### 2、Spring 、SpringBoot 和 Spring Cloud 的关系?

**1、** Spring 最初最核心的两大核心功能 Spring Ioc 和 Spring Aop 成就了 Spring，Spring 在这两大核心的功能上不断的发展，才有了 Spring 事务、Spring Mvc 等一系列伟大的产品，最终成就了 Spring 帝国，到了后期 Spring 几乎可以解决企业开发中的所有问题。

**2、** SpringBoot 是在强大的 Spring 帝国生态基础上面发展而来，发明 SpringBoot 不是为了取代 Spring ,是为了让人们更容易的使用 Spring 。

**3、** Spring Cloud 是一系列框架的有序集合。它利用 SpringBoot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 SpringBoot 的开发风格做到一键启动和部署。

**4、** Spring Cloud 是为了解决微服务架构中服务治理而提供的一系列功能的开发框架，并且 Spring Cloud 是完全基于 SpringBoot 而开发，Spring Cloud 利用 SpringBoot 特性整合了开源行业中优秀的组件，整体对外提供了一套在微服务架构中服务治理的解决方案。

**5、** 用一组不太合理的包含关系来表达它们之间的关系。

**6、** Spring ioc/aop > Spring > SpringBoot > Spring Cloud


### 3、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationPropertie注解来绑定变量


### 4、如何禁用特定的自动配置类？

若发现任何不愿使用的特定自动配置类，可以使用@EnableAutoConfiguration的排除属性。

//By using "exclude"

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

另一方面，如果类别不在类路径上，则可以使用excludeName类注解，并且指定完全限定名。

//By using "excludeName"

@EnableAutoConfiguration(excludeName={Foo.class})

此外，SpringBoot还具有控制排除自动配置类列表的功能，可以通过使用spring.autoconfigure.exclude property来实现。可以将其添加到 propertie应用程序中，并且可以添加逗号分隔的多个类。

//By using property file

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration


### 5、什么是 Spring Profiles？

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 6、什么是SpringBoot？

多年来，随着新功能的增加，spring变得越来越复杂。只需访问https://spring.io/projects 页面，我们就会看到可以在我们的应用程序中使用的所有Spring项目的不同功能。如果必须启动一个新的Spring项目，我们必须添加构建路径或添加Maven依赖关系，配置应用程序服务器，添加spring配置。因此，开始一个新的spring项目需要很多努力，因为我们现在必须从头开始做所有事情。

SpringBoot是解决这个问题的方法。SpringBoot已经建立在现有spring框架之上。使用spring启动，我们避免了之前我们必须做的所有样板代码和配置。因此，SpringBoot可以帮助我们以最少的工作量，更加健壮地使用现有的Spring功能。


### 7、SpringBoot多数据源拆分的思路

先在properties配置文件中配置两个数据源，创建分包mapper，使用@ConfigurationProperties读取properties中的配置，使用@MapperScan注册到对应的mapper包中


### 8、SpringBoot、Spring MVC 和 Spring 有什么区别

**1、** Spring 是一个“引擎”，

**2、** Spring MVC是基于Spring的一个 MVC 框架，

**3、** SpringBoot是基于 Spring的一套快速开发整合包


### 9、如何在不使用BasePACKAGE过滤器的情况下排除程序包？

过滤程序包的方法不尽相同。但是弹簧启动提供了一个更复杂的选项，可以在不接触组件扫描的情况下实现这一点。在使用注释@ SpringBootApplication时，可以使用排除属性。请参阅下面的代码片段：

@SpringBootApplication(exclude= {Employee.class})

public class FooAppConfiguration {}


### 10、如何在自定义端口上运行 SpringBoot应用程序?

在 `application.properties`中指定端口`serverport=8090`。


### 11、如何使用 SpringBoot 实现分页和排序？
### 12、如何集成SpringBoot和ActiveMQ？
### 13、spring-boot-starter-parent 有什么用 ?
### 14、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 15、什么是WebSockets？
### 16、如何实现SpringBoot应用程序的安全性？
### 17、什么是 JavaConfig？
### 18、SpringBoot自动配置的原理
### 19、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 20、运行 SpringBoot 有哪几种方式？
### 21、@RestController和@Controller的区别
### 22、spring boot 核心的两个配置文件：
### 23、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 24、什么是 CSRF 攻击？
### 25、如何使用SpringBoot实现异常处理？
### 26、Spring、SpringBoot、SpringMVC的区别？
### 27、你如何理解 SpringBoot 配置加载顺序？
### 28、SpringBoot 如何设置支持跨域请求？
### 29、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?
### 30、什么是Spring Profiles？
### 31、SpringBoot Starter的工作原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
