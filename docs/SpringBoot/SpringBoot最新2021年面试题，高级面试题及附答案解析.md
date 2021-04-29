# SpringBoot最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

**1、** `@SpringBootConfiguration`：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

**2、** `@EnableAutoConfiguration`：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能。

**3、** `@ComponentScan`：Spring组件扫描。


### 2、JPA 和 Hibernate 有哪些区别？

简而言之

JPA 是一个规范或者接口

Hibernate 是 JPA 的一个实现

当我们使用 JPA 的时候，我们使用 javax.persistence 包中的注释和接口时，不需要使用 hibernate 的导入包。

我们建议使用 JPA 注释，因为哦我们没有将其绑定到 Hibernate 作为实现。后来（我知道 - 小于百分之一的几率），我们可以使用另一种 JPA 实现。


### 3、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： [@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class }。

@ComponentScan：Spring组件扫描


### 4、SpringData 项目所支持的关系数据存储技术：

**1、** JDBC

**2、** JPA

Spring Data Jpa 致力于减少数据访问层 (DAO) 的开发量. 开发者唯一要做的，就是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！Spring Data JPA 通过规范方法的名字，根据符合规范的名字来确定方法需要实现什么样的逻辑。


### 5、什么是 Spring Batch?

`SpringBoot Batch`提供可重用的函数，这些函数在处理大量记录时非常重要；包括日志/跟踪，事务管理，作业处理统计信息，作业重新启动，跳过和资源管理。它还提供了更先进的技术服务和功能，通过优化和分区技术，可以实现极高批量和高性能批处理作业。简单以及复杂的大批量批处理作业可以高度可扩展的方式利用框架处理重要大量的信息。



### 6、什么是Apache Kafka？

Apache Kafka是一个分布式发布 - 订阅消息系统。它是一个可扩展的，容错的发布 - 订阅消息系统，它使我们能够构建分布式应用程序。这是一个Apache顶级项目。Kafka适合离线和在线消息消费。


### 7、怎么设计无状态服务？

对于无状态服务，首先说一下什么是状态：如果一个数据需要被多个服务共享，才能完成一笔交易，那么这1、个数据被称为状态。进而依赖这个“状态”数据的服务被称为有状态服务，反之称为无状态服务。

**2、** 那么这个无状态服务原则并不是说在微服务架构里就不允许存在状态，表达的真实意思是要把有状态的业务服务改变为无状态的计算类服务，那么状态数据也就相应的迁移到对应的“有状态数据服务”中。

**3、** 场景说明：例如我们以前在本地内存中建立的数据缓存、Session缓存，到现在的微服务架构中就应该把这些数据迁移到分布式缓存中存储，让业务服务变成一个无状态的计算节点。迁移后，就可以做到按需动态伸缩，微服务应用在运行时动态增删节点，就不再需要考虑缓存数据如何同步的问题。


### 8、开启 SpringBoot 特性有哪几种方式？

**1、** 继承spring-boot-starter-parent项目

**2、** 导入spring-boot-dependencies项目依赖


### 9、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** SpringSpring最重要的特征是依赖注入。所有 `SpringModules` 不是依赖注入就是 IOC 控制反转。当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC提供了一种分离式的方法来开发 Web 应用。通过运用像 `DispatcherServelet`，`MoudlAndView` 和 `ViewResolver` 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** Spring 和 SpringMVC 的问题在于需要配置大量的参数。

**4、** SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 10、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、** 容易上手，提升开发效率，为 Spring 开发提供一个更快、更广泛的入门体验。

**2、** 开箱即用，远离繁琐的配置。

**3、** 提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、** 没有代码生成，也不需要XML配置。

**5、** 避免大量的 Maven 导入和各种版本冲突。


### 11、微服务同时调用多个接口，怎么支持事务的啊？
### 12、SpringBoot 提供了哪些核心功能？
### 13、您使用了哪些starter maven依赖项？
### 14、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 15、什么是 WebSockets？
### 16、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？
### 17、如何使用SpringBoot实现异常处理?
### 18、什么是starter?
### 19、SpringBoot 有哪几种读取配置的方式？
### 20、SpringBoot 中如何解决跨域问题 ?
### 21、如何在 SpringBoot中禁用 Actuator端点安全性?
### 22、SpringBoot支持什么前端模板，
### 23、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 24、SpringBoot常用的starter有哪些?
### 25、spring boot扫描流程?
### 26、如何使用 SpringBoot 实现全局异常处理？
### 27、什么是 JavaConfig？
### 28、项目中前后端分离部署，所以需要解决跨域的问题。
### 29、Async异步调用方法
### 30、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 31、SpringBoot如何配置log4j？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
