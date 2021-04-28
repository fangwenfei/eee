# SpringBoot最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何在自定义端口上运行 SpringBoot应用程序?

在 `application.properties`中指定端口`serverport=8090`。


### 2、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

**1、** SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

**2、** application 配置文件这个容易了解，主要用于 SpringBoot 项目的自动化配置。

**3、** bootstrap 配置文件有以下几个应用场景。

**4、** 使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中增加连接到配置中心的配置属性来加载外部配置中心的配置信息；

**5、** 少量固定的不能被覆盖的属性；

**6、** 少量加密/解密的场景；


### 3、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap、properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。

spring boot 核心的两个配置文件：

bootstrap (、 yml 或者 、 properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud 配置就会使用这个文件。且 boostrap 里面的属性不能被覆盖；

application (、 yml 或者 、 properties)： 由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 4、SpringBoot 是否可以使用 XML 配置 ?

SpringBoot 推荐使用 Java 配置而非 XML 配置，但是 SpringBoot 中也可以使用 XML 配置，通过 [@ImportResource ](/ImportResource ) 注解可以引入一个 XML 配置。


### 5、SpringBoot多数据源事务如何管理

第一种方式是在service层的@TransactionManager中使用transactionManager指定DataSourceConfig中配置的事务

第二种是使用jta-atomikos实现分布式事务管理


### 6、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

org.springframework.data.domain.Pageable

传递给存储库方法。


### 7、你能否举一个以 ReadOnly 为事务管理的例子？

当你从数据库读取内容的时候，你想把事物中的用户描述或者是其它描述设置为只读模式，以便于 Hebernate 不需要再次检查实体的变化。这是非常高效的。


### 8、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、**  容易上手，提升开发效率，为 Spring 开发提供一个更快、更简单的开发框架。

**2、**  开箱即用，远离繁琐的配置。

**3、**  提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、**  SpringBoot总结就是使编码变简单、配置变简单、部署变简单、监控变简单等等


### 9、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是SpringBoot的核心注解，主要组合包含了以下3个注解：

**1、** @SpringBootConfiguration：组合了@Configuration注解，实现配置文件的功能。

**2、** @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

**3、** @ComponentScan：Spring组件扫描


### 10、如何在 SpringBoot中禁用 Actuator端点安全性?

默认情况下，所有敏感的HTTP端点都是安全的，只有具有 `http ACTUATOR`角色的用户才能访问它们。安全性是使用标准的 `httpservletrequest. isuserinrole..isusernrole`方法实施的。可以使用 `management. security. enabled= false`来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 11、SpringBoot集成mybatis的过程
### 12、SpringBoot Starter的工作原理
### 13、SpringBoot 有哪些优点？
### 14、我们如何监视所有 SpringBoot 微服务？
### 15、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 16、SpringBoot 提供了哪些核心功能？
### 17、SpringData 项目所支持的关系数据存储技术：
### 18、什么是Spring Initializer?
### 19、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 20、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 21、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 22、微服务中如何实现 session 共享 ?
### 23、如何禁用特定的自动配置类？
### 24、保护 SpringBoot 应用有哪些方法？
### 25、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 26、什么是SpringBoot
### 27、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 28、如何在SpringBoot中禁用Actuator端点安全性？
### 29、SpringBoot读取配置文件的方式
### 30、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 31、SpringBoot Starter 的工作原理是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
