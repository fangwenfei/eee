# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是bean装配?

装配，或bean 装配是指在Spring 容器中把bean组装到一起，前提是容器需要知道bean的依赖关系，如何通过依赖注入来把它们装配到一起。


### 2、什么是不同类型的微服务测试？

在使用微服务时，由于有多个微服务协同工作，测试变得非常复杂。因此，测试分为不同的级别。

在底层，我们有面向技术的测试，如单元测试和性能测试。这些是完全自动化的。

在中间层面，我们进行了诸如压力测试和可用性测试之类的探索性测试。

在顶层， 我们的 验收测试数量很少。这些验收测试有助于利益相关者理解和验证软件功能。


### 3、自动装配有哪些方式？

Spring 容器能够自动装配 bean。也就是说，可以通过检查 BeanFactory 的内容让 Spring 自动解析 bean 的协作者。

自动装配的不同模式：

**1、** 这是默认设置，表示没有自动装配。应使用显式 bean 引用进行装配。byName

**2、** 它根据 bean 的名称注入对象依赖项。它匹配并装配其属性与 XML 文件中由相同名称定义的 bean。byType

**3、** 它根据类型注入对象依赖项。如果属性的类型与 XML 文件中的一个 bean 名称匹配，则匹配并装配属性。构造函数

**4、** 它通过调用类的构造函数来注入依赖项。它有大量的参数。autodetect

**5、** 首先容器尝试通过构造函数使用 autowire 装配，如果不能，则尝试通过 byType 自动装配。


### 4、Spring Cloud Security

安全工具包，对Zuul代理中的负载均衡OAuth2客户端及登录认证进行支持。


### 5、spring 支持集中 bean scope？

**Spring bean 支持 5 种 scope：**

**1、** Singleton - 每个 Spring IoC 容器仅有一个单实例。

**2、** Prototype - 每次请求都会产生一个新的实例。

**3、** Request - 每一次 HTTP 请求都会产生一个新的实例，并且该 bean 仅在当前 HTTP 请求内有效。

**4、** Session - 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前 HTTP session 内有效。

**5、** Global-session - 类似于标准的 HTTP Session 作用域，不过它仅仅在基于 portlet 的 web 应用中才有意义。 Portlet 规范定义了全局 Session 的概念，它被所有构成某个 portlet web 应用的各种不同的 portlet 所共享。 在 global session 作用域中定义的 bean 被限定于全局 portlet Session 的生命周期范围内。 如果你在 web 中使用 global session 作用域来标识 bean，那么 web 会自动当成 session 类型来使用。

**6、** 仅当用户使用支持 Web 的 ApplicationContext 时，最后三个才可用。


### 6、Spring 、SpringBoot 和 Spring Cloud 的关系?

**1、** Spring 最初最核心的两大核心功能 Spring Ioc 和 Spring Aop 成就了 Spring，Spring 在这两大核心的功能上不断的发展，才有了 Spring 事务、Spring Mvc 等一系列伟大的产品，最终成就了 Spring 帝国，到了后期 Spring 几乎可以解决企业开发中的所有问题。

**2、** SpringBoot 是在强大的 Spring 帝国生态基础上面发展而来，发明 SpringBoot 不是为了取代 Spring ,是为了让人们更容易的使用 Spring 。

**3、** Spring Cloud 是一系列框架的有序集合。它利用 SpringBoot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 SpringBoot 的开发风格做到一键启动和部署。

**4、** Spring Cloud 是为了解决微服务架构中服务治理而提供的一系列功能的开发框架，并且 Spring Cloud 是完全基于 SpringBoot 而开发，Spring Cloud 利用 SpringBoot 特性整合了开源行业中优秀的组件，整体对外提供了一套在微服务架构中服务治理的解决方案。

**5、** 用一组不太合理的包含关系来表达它们之间的关系。

**6、** Spring ioc/aop > Spring > SpringBoot > Spring Cloud


### 7、使用Spring Cloud有什么优势？

使用SpringBoot开发分布式微服务时，我们面临以下问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。

**6、** 部署复杂性-Devops技能的要求。


### 8、SpringBoot 最大的优势是什么呢？
### 9、Spring Cloud的版本关系
### 10、SpringBoot 可以兼容老 Spring 项目吗，如何做？
### 11、微服务架构如何运作？
### 12、什么是切点（JoinPoint）
### 13、spring cloud 断路器的作用是什么？
### 14、使用 Spring 访问 Hibernate 的方法有哪些？
### 15、如何给Spring 容器提供配置元数据?
### 16、Spring MVC的控制器是不是单例模式,如果是,有什么问题,怎么解决？
### 17、什么是spring?
### 18、什么是Hystrix?
### 19、什么是微服务
### 20、什么是Spring的依赖注入？
### 21、SpringBoot 自动配置原理是什么？
### 22、Spring框架的事务管理有哪些优点？
### 23、保护 SpringBoot 应用有哪些方法？
### 24、如何实现SpringBoot应用程序的安全性？
### 25、请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？
### 26、SOA和微服务架构之间的主要区别是什么？
### 27、SpringBoot 的自动配置是如何实现的？
### 28、您对Distributed Transaction有何了解？
### 29、列举 Spring Framework 的优点。
### 30、如何在SpringBoot应用程序中实现Spring安全性？
### 31、JdbcTemplate




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
