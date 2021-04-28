# Spring最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Zookeeper如何 保证CP

当向注册中⼼查询服务列表时，我们可以容忍注册中⼼返回的是⼏分钟以前的注册信息，但不能接受服务直接down掉不可⽤。也就是说，服务注册功能对可⽤性的要求要⾼于⼀致性。但是zk会出现这样⼀种情况，当master节点因为⽹络故障与其他节点失去联系时，剩余节点会重新进⾏leader选举。问题在于，选举leader的时间太⻓，30 ~ 120s, 且选举期间整个zk集群都是不可⽤的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因⽹络问题使得zk集群失去master节点是较⼤概率会发⽣的事，虽然服务能够最终恢复，但是漫⻓的选举时间导致的注册⻓期不可⽤是不能容忍的。


### 2、什么是Spring Actuator？它有什么优势？

这是SpringBoot中最常见的面试问题之一。根据Spring文件：

执行器是一个制造术语，指的是移动或控制某物的机械装置。执行机构可以从一个小的变化中产生大量的运动。

众所周知，SpringBoot提供了许多自动配置特性，帮助开发人员快速开发生产组件。但是，当考虑调试和如何调试，如果出现问题，总是需要分析日志并挖掘应用程序的数据流，检查问题出在何处。因此，Spring Actuator提供了方便的访问这些类型的途径。它提供了许多特性，例如创建了什么样的bean、控制器中的映射、CPU使用情况等等。它还可以将自动收集和审计健康状况和指标应用到应用程序中。

它提供了一种非常简单的方法来访问少数生产就绪的REST端点，并从Web获取各种信息。但是通过使用这些端点，你可以做很多事情来查看端点文档。没有必要担心安全问题;如果存在Spring Security，则默认使用Spring Security的内容协商策略保护这些端点。或者，可以在RequestMatcher的帮助下配置自定义安全性。


### 3、Spring Cloud Task

Spring Cloud Task的目标是为SpringBoot应用程序提供创建短运行期微服务的功能。在Spring Cloud Task中，我们可以灵活地动态运行任何任务，按需分配资源并在任务完成后检索结果。Tasks是Spring Cloud Data Flow中的一个基础项目，允许用户将几乎任何SpringBoot应用程序作为一个短期任务执行。


### 4、Docker的目的是什么？

Docker提供了一个可用于托管任何应用程序的容器环境。在此，软件应用程序和支持它的依赖项紧密打包在一起。

因此，这个打包的产品被称为Container，因为它是由Docker完成的，所以它被称为Docker容器！


### 5、能否举一个例子来解释更多 Staters 的内容？

让我们来思考一个 Stater 的例子 -SpringBoot Stater Web。

如果你想开发一个 web 应用程序或者是公开 REST 服务的应用程序。SpringBoot Start Web 是首选。让我们使用 Spring Initializr 创建一个 SpringBoot Start Web 的快速项目。

**依赖项可以被分为：**

**1、** Spring - core，beans，context，aop

**2、** Web MVC - （Spring MVC）

**3、** Jackson - for JSON Binding

**4、** Validation - Hibernate,Validation API

**5、** Enbedded Servlet Container - Tomcat

**6、** Logging - logback,slf4j

任何经典的 Web 应用程序都会使用所有这些依赖项。SpringBoot Starter Web 预先打包了这些依赖项。

作为一个开发者，我不需要再担心这些依赖项和它们的兼容版本。


### 6、SpringCloud的优缺点

**优点：**

**1、** 耦合度比较低。不会影响其他模块的开发。

**2、** 减轻团队的成本，可以并行开发，不用关注其他人怎么开发，先关注自己的开发。

**3、** 配置比较简单，基本用注解就能实现，不用使用过多的配置文件。

**4、** 微服务跨平台的，可以用任何一种语言开发。

**5、** 每个微服务可以有自己的独立的数据库也有用公共的数据库。

**6、** 直接写后端的代码，不用关注前端怎么开发，直接写自己的后端代码即可，然后暴露接口，通过组件进行服务通信。

**缺点：**

1、部署比较麻烦，给运维工程师带来一定的麻烦。

2、针对数据的管理比麻烦，因为微服务可以每个微服务使用一个数据库。

3、系统集成测试比较麻烦

4、性能的监控比较麻烦。【最好开发一个大屏监控系统】

总的来说优点大过于缺点，目前看来Spring Cloud是一套非常完善的分布式框架，目前很多企业开始用微服务、Spring Cloud的优势是显而易见的。因此对于想研究微服务架构的同学来说，学习Spring Cloud是一个不错的选择。


### 7、如何使用SpringBoot实现异常处理?

`SpringControllerAdvice`提供了一种使用处理异常的非常有用的方法。通过实现一个 `ControllerAdvice`类，来处理控制器类抛出的所有异常。


### 8、Spring MVC怎么和AJAX相互调用的？

通过Jackson框架就可以把Java里面的对象直接转化成Js可以识别的Json对象。具体步骤如下 ：

**1、** 加入Jackson.jar

**2、** 在配置文件中配置json的映射

**3、** 在接受Ajax方法里面可以直接返回Object,List等,但方法前面要加上@ResponseBody注解。


### 9、Spring Cloud Bus

用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。


### 10、什么是代理?

代理是通知目标对象后创建的对象。从客户端的角度看，代理对象和目标对象是一样的。


### 11、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 12、开启 SpringBoot 特性有哪几种方式？
### 13、SpringBoot 中如何实现定时任务 ?
### 14、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 15、什么是Spring的MVC框架？
### 16、AOP 有哪些实现方式？
### 17、SpringBoot的缺点
### 18、什么是Spring引导的执行器？
### 19、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 20、[@RequestMapping ](/RequestMapping ) 注解
### 21、SpringData 项目所支持的关系数据存储技术：
### 22、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 23、[@RequestMapping ](/RequestMapping ) 注解有什么用？
### 24、如何覆盖SpringBoot项目的默认属性？
### 25、spring JDBC API 中存在哪些类？
### 26、SpringBoot 有哪些优点？
### 27、什么是基于注解的容器配置
### 28、什么是Semantic监控？
### 29、什么是 SpringBoot 启动类注解：
### 30、如何使用SpringBoot实现分页和排序？
### 31、SpringCloud由什么组成




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
