# Spring最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是依赖注入？

在依赖注入中，您不必创建对象，但必须描述如何创建它们。 您不是直接在代码中将组件和服务连接在一起，而是描述配置文件中哪些组件需要哪些服务。 由 IoC 容器将它们装配在一起。


### 2、列举 IoC 的一些好处。

**IoC 的一些好处是：**

**1、** 它将最小化应用程序中的代码量。

**2、** 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。

**3、** 它以最小的影响和最少的侵入机制促进松耦合。

**4、** 它支持即时的实例化和延迟加载服务。


### 3、spring boot 核心的两个配置文件：

**1、** bootstrap (.yml 或.properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud Config 或者 Nacos 中会用到它。且 boostrap 里面的属性不能被覆盖；

**2、** application (. yml 或者 . properties)：由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 4、解释Spring支持的几种bean的作用域。

**Spring框架支持以下五种bean的作用域：**

**1、** singleton : bean在每个Spring ioc 容器中只有一个实例。

**2、** prototype：一个bean的定义可以有多个实例。

**3、** request：每次http请求都会创建一个bean，该作用域仅在基于web的Spring ApplicationContext情形下有效。

**4、** session：在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

**5、** global-session：在一个全局的HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

缺省的Spring bean 的作用域是Singleton.


### 5、什么是Spring Initializer?

这个问题并不难，但面试官总是以此测试候选人的专业知识。

Spring Initializer是一个网络应用程序，它可以生成一个SpringBoot项目，包含快速启动所需的一切。和往常一样，我们需要一个好的项目框架；它有助于你正确创建项目结构/框架。


### 6、服务雪崩效应产生的原因

因为Tomcat默认情况下只有一个线程池来维护客户端发送的所有的请求，这时候某一接口在某一时刻被大量访问就会占据tomcat线程池中的所有线程，其他请求处于等待状态，无法连接到服务接口。


### 7、如何在 SpringBoot 中添加通用的 JS 代码？

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


### 8、什么是SpringBoot？

用来简化spring应用的初始搭建以及开发过程，使用特定的方式来进行配置（`properties`或`yml`文件）创建独立的spring引用程序 main方法运行，嵌入的Tomcat 无需部署war文件，简化maven配置，自动配置spring添加对应功能starter自动化配置


### 9、SpringBoot 日志框架：

SpringBoot选用 SLF4j和logback;

如何让系统中所有的日志都统一到slf4j;

**1、** 将系统中其他日志框架先排除出去;

**2、** 用中间包来替换原有的日志框架;

**3、** 我们导入slf4j其他的实现

SpringBoot能自动适配所有的日志，而且底层使用slf4j+logback的方式记录日志


### 10、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别

**1、** ZooKeeper中的节点服务挂了就要选举 在选举期间注册服务瘫痪,虽然服务最终会恢复,但是选举期间不可用的， 选举就是改微服务做了集群，必须有一台主其他的都是从

**2、** Eureka各个节点是平等关系,服务器挂了没关系，只要有一台Eureka就可以保证服务可用，数据都是最新的。 如果查询到的数据并不是最新的，就是因为Eureka的自我保护模式导致的

**3、** Eureka本质上是一个工程,而ZooKeeper只是一个进程

**4、** Eureka可以很好的应对因网络故障导致部分节点失去联系的情况,而不会像ZooKeeper 一样使得整个注册系统瘫痪

**5、** ZooKeeper保证的是CP，Eureka保证的是AP

**CAP：**

**1、** C：一致性>Consistency; 取舍：(强一致性、单调一致性、会话一致性、最终一致性、弱一致性)

**2、** A：可用性>Availability;

**3、** P：分区容错性>Partition tolerance;


### 11、Spring IoC 的实现机制。
### 12、SpringBoot常用的starter有哪些?
### 13、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？
### 14、你如何理解 SpringBoot 中的 Starters？
### 15、运行 SpringBoot 有哪几种方式？
### 16、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 17、指出在 spring aop 中 concern 和 cross-cutting concern 的不同之处。
### 18、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 19、我们如何监视所有 SpringBoot 微服务？
### 20、Spring MVC常用的注解有哪些？
### 21、SpringBoot多数据源事务如何管理
### 22、[@Required ](/Required ) 注解有什么用？
### 23、什么是客户证书？
### 24、有哪些不同类型的IOC（依赖注入）方式？
### 25、如何在 spring 中启动注解装配？
### 26、SpringBoot 中如何实现定时任务 ?
### 27、YAML 配置的优势在哪里 ?
### 28、您对Mike Cohn的测试金字塔了解多少？
### 29、springcloud和dubbo有哪些区别
### 30、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 31、微服务的端到端测试意味着什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
