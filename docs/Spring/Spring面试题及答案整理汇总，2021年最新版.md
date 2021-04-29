# Spring面试题及答案整理汇总，2021年最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何实现 SpringBoot 应用程序的安全性？

为了实现 SpringBoot 的安全性，我们使用 spring-boot-starter-security 依赖项，并且必须添加安全配置。它只需要很少的代码。配置类将必须扩展WebSecurityConfigurerAdapter 并覆盖其方法。


### 2、一个Spring的应用看起来象什么？

**1、** 一个定义了一些功能的接口。

**2、** 这实现包括属性，它的Setter ， getter 方法和函数等。

**3、** Spring AOP

**4、** Spring 的XML 配置文件

**5、** 使用以上功能的客户端程序


### 3、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？

让我们以 MySQL 为例来思考这个问题：

**第一步** - 把 MySQL 连接器的依赖项添加至 pom.xml

**第二步** - 从 pom.xml 中移除 H2 的依赖项

或者至少把它作为测试的范围。

**第三步** - 安装你的 MySQL 数据库

更多的来看看这里 -[https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL](https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL)

**第四步** - 配置你的 MySQL 数据库连接

配置 application.properties

```
spring.jpa.hibernate.ddl-auto=none spring.datasource.url=jdbc:MySQL://localhost:3306/todo_example
spring.datasource.username=todouser spring.datasource.password=YOUR_PASSWORD
```

**第五步** - 重新启动，你就准备好了！

就是这么简单！


### 4、列举 IoC 的一些好处。

**IoC 的一些好处是：**

**1、** 它将最小化应用程序中的代码量。

**2、** 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。

**3、** 它以最小的影响和最少的侵入机制促进松耦合。

**4、** 它支持即时的实例化和延迟加载服务。


### 5、SpringCloud主要项目

Spring Cloud的子项目，大致可分成两类，一类是对现有成熟框架"SpringBoot化"的封装和抽象，也是数量最多的项目；第二类是开发了一部分分布式系统的基础设施的实现，如Spring Cloud Stream扮演的就是Kafka, ActiveMQ这样的角色。


### 6、我们如何在测试中消除非决定论？

非确定性测试（NDT）基本上是不可靠的测试。所以，有时可能会发生它们通过，显然有时它们也可能会失败。当它们失败时，它们会重新运行通过。

从测试中删除非确定性的一些方法如下：

**1、**   隔离

**2、**   异步

**3、**   远程服务

**4、**   隔离

**5、**   时间

**6、**   资源泄漏


### 7、既然Nginx可以实现网关？为什么还需要使用Zuul框架

Zuul是SpringCloud集成的网关，使用Java语言编写，可以对SpringCloud架构提供更灵活的服务。


### 8、Spring IoC 的实现机制。
### 9、[@Autowired ](/Autowired ) 注解有什么用？
### 10、什么是YAML?
### 11、什么是Spring Cloud？
### 12、服务雪崩？
### 13、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 14、如何在不使用BasePACKAGE过滤器的情况下排除程序包？
### 15、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 16、SpringBoot中的监视器是什么?
### 17、哪些是重要的bean生命周期方法？你能重载它们吗？
### 18、如何实现 SpringBoot应用程序的安全性?
### 19、什么是REST / RESTful以及它的用途是什么？
### 20、spring boot 核心的两个配置文件：
### 21、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 22、什么是 Spring Data ?
### 23、什么是客户证书？
### 24、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 25、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 26、spring-boot-starter-parent有什么用？
### 27、什么是Spring Profiles？
### 28、什么是有界上下文？
### 29、什么是 YAML？
### 30、为什么我们需要 spring-boot-maven-plugin?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
