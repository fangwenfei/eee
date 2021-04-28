# Spring高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Spring Framework 有哪些不同的功能？

**1、** 轻量级 - Spring 在代码量和透明度方面都很轻便。

**2、** IOC - 控制反转

**3、** AOP - 面向切面编程可以将应用业务逻辑和系统服务分离，以实现高内聚。

**4、** 容器 - Spring 负责创建和管理对象（Bean）的生命周期和配置。

**5、** MVC - 对 web 应用提供了高度可配置性，其他框架的集成也十分方便。

**6、** 事务管理 - 提供了用于事务管理的通用抽象层。 Spring 的事务支持也可用于容器较少的环境。

**7、** JDBC 异常 - Spring 的 JDBC 抽象层提供了一个异常层次结构，简化了错误处理策略。4、Spring Framework 中有多少个模块，它们分别是什么？

**1、** Spring 核心容器 – 该层基本上是 Spring Framework 的核心。它包含以下模块：

**2、** Spring Core

**3、** Spring Bean

**4、** SpEL (Spring Expression Language)

**5、** Spring Context

**数据访问/集成 – 该层提供与数据库交互的支持。 它包含以下模块：**

**1、** JDBC (Java DataBase Connectivity)

**2、** ORM (Object Relational Mapping)

**3、** OXM (Object XML Mappers)

**4、** JMS (Java Messaging Service)

**5、** Transaction

**1、** Web – 该层提供了创建 Web 应用程序的支持。它包含以下模块：AOP – 该层支持面向切面编程

**2、** Web

**3、** Web – Servlet

**4、** Web – Socket

**5、** Web – Portlet

**6、** Instrumentation – 该层为类检测和类加载器实现提供支持。

**7、** Test – 该层为使用 JUnit 和 TestNG 进行测试提供支持

**几个杂项模块:**

Messaging – 该模块为 STOMP 提供支持。它还支持注解编程模型，该模型用于从 WebSocket 客户端路由和处理 STOMP 消息。

Aspects – 该模块为与 AspectJ 的集成提供支持。


### 2、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。为了帮助我们处理这种情况，我们将使用位于的开源项目。 它建立在 SpringBoot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。


### 3、什么是YAML？

YAML是一种人类可读的数据序列化语言。它通常用于配置文件。

与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。


### 4、什么是 Spring IOC 容器？

Spring 框架的核心是 Spring 容器。容器创建对象，将它们装配在一起，配置它们并管理它们的完整生命周期。Spring 容器使用依赖注入来管理组成应用程序的组件。容器通过读取提供的配置元数据来接收对象进行实例化，配置和组装的指令。该元数据可以通过 XML，Java 注解或 Java 代码提供。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_2.png#alt=img%5C_2.png)


### 5、什么是断路器

当一个服务调用另一个服务由于网络原因或自身原因出现问题，调用者就会等待被调用者的响应 当更多的服务请求到这些资源导致更多的请求等待，发生连锁效应（雪崩效应）

**断路器有三种状态**

**1、** 打开状态：一段时间内 达到一定的次数无法调用 并且多次监测没有恢复的迹象 断路器完全打开 那么下次请求就不会请求到该服务

**2、** 半开状态：短时间内 有恢复迹象 断路器会将部分请求发给该服务，正常调用时 断路器关闭

**3、** 关闭状态：当服务一直处于正常状态 能正常调用


### 6、怎么设计无状态服务？

对于无状态服务，首先说一下什么是状态：如果一个数据需要被多个服务共享，才能完成一笔交易，那么这1、个数据被称为状态。进而依赖这个“状态”数据的服务被称为有状态服务，反之称为无状态服务。

**2、** 那么这个无状态服务原则并不是说在微服务架构里就不允许存在状态，表达的真实意思是要把有状态的业务服务改变为无状态的计算类服务，那么状态数据也就相应的迁移到对应的“有状态数据服务”中。

**3、** 场景说明：例如我们以前在本地内存中建立的数据缓存、Session缓存，到现在的微服务架构中就应该把这些数据迁移到分布式缓存中存储，让业务服务变成一个无状态的计算节点。迁移后，就可以做到按需动态伸缩，微服务应用在运行时动态增删节点，就不再需要考虑缓存数据如何同步的问题。


### 7、服务降级底层是如何实现的？

Hystrix实现服务降级的功能是通过重写HystrixCommand中的getFallback()方法，当Hystrix的run方法或construct执行发生错误时转而执行getFallback()方法。


### 8、spring DAO 有什么用？

Spring DAO 使得 JDBC，Hibernate 或 JDO 这样的数据访问技术更容易以一种统一的方式工作。 这使得用户容易在持久性技术之间切换。 它还允许您在编写代码时，无需考虑捕获每种技术不同的异常。


### 9、什么是Semantic监控？

它结合了对整个应用程序的监控以及自动化测试。语义监控的主要好处是找出对您的业务更有利可图的因素。 从业务角度来看，语义监控以及服务层监控可以监控微服务。一旦检测到问题，它们就可以实现更快的隔离和 错误分类，从而减少修复所需的主要时间。它对服务层和事务层进行分类，以确定受可用性或性能不佳影响的事务。


### 10、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

org.springframework.data.domain.Pageable

传递给存储库方法。


### 11、什么是WebSockets？
### 12、spring bean 容器的生命周期是什么样的？
### 13、一个 Spring Bean 定义 包含什么？
### 14、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 15、SpingMvc中的控制器的注解一般用哪个,有没有别的注解可以替代？
### 16、自动装配有什么局限？
### 17、什么是 AOP 通知
### 18、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 19、Spring配置文件
### 20、Spring MVC中函数的返回值是什么？
### 21、[@Autowired ](/Autowired ) 注解有什么用？
### 22、如何在 SpringBoot中禁用 Actuator端点安全性?
### 23、SpringBoot事物的使用
### 24、Spring 应用程序有哪些不同组件？
### 25、Spring Cloud Config
### 26、@RequestMapping注解的作用
### 27、SpringBoot的启动器有哪几种?
### 28、SpringBoot的自动配置原理是什么
### 29、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 30、Spring MVC与Struts2区别
### 31、您对微服务有何了解？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
