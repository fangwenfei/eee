# Spring最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、使用 Spring 有哪些方式？

**使用 Spring 有以下方式：**

**1、** 作为作为一个成熟的 Spring Web 应用程序。

**2、** 作为第三方 Web 框架，使用 Spring Frameworks 中间层。

**3、** 用于远程使用。

**4、** 作为企业级 Java Bean，它可以包装现有的 POJO（Plain Old Java Objects）。 Bean，它可以包装现有的 POJO（Plain Old Java Objects）。


### 2、Spring支持的事务管理类型

**Spring支持两种类型的事务管理：**

编程式事务管理：这意味你通过编程的方式管理事务，给你带来极大的灵活性，但是难维护。

声明式事务管理：这意味着你可以将业务代码和事务管理分离，你只需用注解和XML配置来管理事务。


### 3、Spring AOP and AspectJ AOP 有什么区别？

Spring AOP 基于动态代理方式实现；AspectJ 基于静态代理方式实现。Spring AOP 仅支持方法级别的 PointCut；提供了完全的 AOP 支持，它还支持属性级别的 PointCut。


### 4、各服务之间通信，对Restful和Rpc这2种方式如何做选择？

在传统的SOA治理中，使用rpc的居多；Spring Cloud默认使用restful进行服务之间的通讯。rpc通讯效率会比restful要高一些，但是对于大多数公司来讲，这点效率影响甚微。我建议使用restful这种方式，易于在不同语言实现的服务之间通讯。


### 5、解释JDBC抽象和DAO模块。

通过使用JDBC抽象和DAO模块，保证数据库代码的简洁，并能避免数据库资源错误关闭导致的问题，它在各种不同的数据库的错误信息之上，提供了一个统一的异常访问层。它还利用Spring的AOP 模块给Spring应用中的对象提供事务管理服务。


### 6、什么是切点（JoinPoint）

程序运行中的一些时间点, 例如一个方法的执行, 或者是一个异常的处理.

在 Spring AOP 中, join point 总是方法的执行点。


### 7、列举微服务技术栈

**1、** 服务⽹关Zuul

**2、** 服务注册发现Eureka+Ribbon

**3、** 服务配置中⼼Apollo

**4、** 认证授权中⼼Spring Security OAuth2

**5、** 服务框架SpringBoot

**6、** 数据总线Kafka

**7、** ⽇志监控ELK

**8、** 调⽤链监控CAT

**9、** Metrics监控KairosDB

**10、** 健康检查和告警ZMon

**11、** 限流熔断和流聚合Hystrix/Turbine


### 8、SpringBoot和SpringCloud的区别？

**1、** SpringBoot专注于快速方便的开发单个个体微服务。

**2、** SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，

**3、** 为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务

**4、** SpringBoot可以离开SpringCloud独立使用开发项目， 但是SpringCloud离不开SpringBoot ，属于依赖的关系

**5、** SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。


### 9、Spring Cloud Consul

基于Hashicorp Consul的服务治理组件。


### 10、DispatcherServlet

Spring的MVC框架是围绕DispatcherServlet来设计的，它用来处理所有的HTTP请求和响应。


### 11、Springboot 有哪些优点？
### 12、SpringBoot支持哪些嵌入式容器？
### 13、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？
### 14、为什么我们需要微服务容器？
### 15、spring boot扫描流程?
### 16、Spring Cloud Gateway
### 17、服务注册和发现是什么意思？Spring Cloud 如何实现？
### 18、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？
### 19、Spring Cloud Netflix(重点，这些组件用的最多)
### 20、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？
### 21、什么是微服务架构
### 22、什么是消费者驱动的合同（CDC）？
### 23、使⽤中碰到的坑
### 24、[@Controller ](/Controller ) 注解
### 25、SpringBoot读取配置文件的方式
### 26、什么是 Spring Framework？
### 27、PACT如何运作？
### 28、[@Qualifier ](/Qualifier ) 注解有什么用？
### 29、[@Required ](/Required ) 注解
### 30、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 31、什么是 AOP 通知




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
