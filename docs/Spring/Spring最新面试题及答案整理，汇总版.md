# Spring最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、** 容易上手，提升开发效率，为 Spring 开发提供一个更快、更广泛的入门体验。

**2、** 开箱即用，远离繁琐的配置。

**3、** 提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、** 没有代码生成，也不需要XML配置。

**5、** 避免大量的 Maven 导入和各种版本冲突。


### 2、您将如何在微服务上执行安全测试？

您需要独立测试各个部分。有三种常见的程序：

**1、** 代码扫描 - 确保任何代码行都没有错误并且可以复制。

**2、** 灵活性 - 安全解决方案应该是灵活的，以便可以根据系统的要求进行调整。

**3、** 适应性 - 安全协议应该灵活和更新，以应对黑客或安全漏洞的新威胁。


### 3、微服务之间是如何独立通讯的

**1、** 远程过程调用（Remote Procedure Invocation）：也就是我们常说的服务的注册与发现，直接通过远程过程调用来访问别的service。

**优点：**

简单，常见,因为没有中间件代理，系统更简单

**缺点：**

**1、** 只支持请求/响应的模式，不支持别的，比如通知、请求/异步响应、发布/订阅、发布/异步响应

**2、** 降低了可用性，因为客户端和服务端在请求过程中必须都是可用的

**2、** 消息：使用异步消息来做服务间通信。服务间通过消息管道来交换消息，从而通信。

**优点:**

**1、** 把客户端和服务端解耦，更松耦合

**2、** 提高可用性，因为消息中间件缓存了消息，直到消费者可以消费

**3、** 支持很多通信机制比如通知、请求/异步响应、发布/订阅、发布/异步响应

**缺点:**

消息中间件有额外的复杂


### 4、介绍一下 WebApplicationContext

WebApplicationContext 是 ApplicationContext 的扩展。它具有 Web 应用程序所需的一些额外功能。它与普通的 ApplicationContext 在解析主题和决定与哪个 servlet 关联的能力方面有所不同。



### 5、spring 支持集中 bean scope？

Spring bean 支持 5 种 scope：

**Singleton**

**1、** 每个 Spring IoC 容器仅有一个单实例。Prototype

**2、** 每次请求都会产生一个新的实例。Request

**3、** 每一次 HTTP 请求都会产生一个新的实例，并且该 bean 仅在当前 HTTP 请求内有效。Session

**4、** 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前 HTTP session 内有效。Global-session

**5、** 类似于标准的 HTTP Session 作用域，不过它仅仅在基于 portlet 的 web 应用中才有意义。Portlet 规范定义了全局 Session 的概念，它被所有构成某个 portlet web 应用的各种不同的 portlet 所共享。在 global session 作用域中定义的 bean 被限定于全局 portlet Session 的生命周期范围内。如果你在 web 中使用 global session 作用域来标识 bean，那么 web 会自动当成 session 类型来使用。

仅当用户使用支持 Web 的 ApplicationContext 时，最后三个才可用。


### 6、常用网关框架有那些？

Nginx、Zuul、Gateway


### 7、SpringBoot 中如何实现定时任务 ?

在 SpringBoot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 [@Scheduled ](/Scheduled ) 注解，另一-个则是使用第三方框架 Quartz。

使用 Spring 中的 [@Scheduled ](/Scheduled ) 的方式主要通过 [@Scheduled ](/Scheduled ) 注解来实现。


### 8、spring boot 核心的两个配置文件：

**1、** bootstrap (.yml 或.properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud Config 或者 Nacos 中会用到它。且 boostrap 里面的属性不能被覆盖；

**2、** application (. yml 或者 . properties)：由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 9、什么是金丝雀释放？

Canary Releasing是一种降低在生产中引入新软件版本的风险的技术。这是通过将变更缓慢地推广到一小部分用户，然后将其发布到整个基础架构，即将其提供给每个人来完成的。


### 10、Spring Cloud Task

Spring Cloud Task的目标是为SpringBoot应用程序提供创建短运行期微服务的功能。在Spring Cloud Task中，我们可以灵活地动态运行任何任务，按需分配资源并在任务完成后检索结果。Tasks是Spring Cloud Data Flow中的一个基础项目，允许用户将几乎任何SpringBoot应用程序作为一个短期任务执行。


### 11、为什么需要域驱动设计（DDD）？
### 12、什么是耦合和凝聚力？
### 13、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 14、什么是SpringBoot？
### 15、Spring MVC的优点
### 16、什么是Hystrix?
### 17、什么是 Hystrix 断路器？我们需要它吗？
### 18、在Spring AOP 中，关注点和横切关注的区别是什么？
### 19、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 20、什么是Spring Cloud？
### 21、如何配置SpringBoot应用程序日志记录？
### 22、使用Spring框架的好处是什么？
### 23、Zuul网关如何搭建集群
### 24、什么是 YAML？
### 25、微服务有哪些特点？
### 26、什么是SpringBoot？
### 27、解释基于XML Schema方式的切面实现。
### 28、如何实现动态Zuul网关路由转发
### 29、什么是Spring Cloud Zuul（服务网关）
### 30、SpringBoot的缺点
### 31、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
