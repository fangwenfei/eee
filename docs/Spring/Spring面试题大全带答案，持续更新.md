# Spring面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 Spring IOC 容器？

Spring 框架的核心是 Spring 容器。容器创建对象，将它们装配在一起，配置它们并管理它们的完整生命周期。Spring 容器使用依赖注入来管理组成应用程序的组件。容器通过读取提供的配置元数据来接收对象进行实例化，配置和组装的指令。该元数据可以通过 XML，Java 注解或 Java 代码提供。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_2.png#alt=img%5C_2.png)


### 2、SpringCloud有几种调用接口方式

**1、** Feign

**2、** RestTemplate


### 3、网关与过滤器有什么区别

网关是对所有服务的请求进行分析过滤，过滤器是对单个服务而言。


### 4、如何使用 SpringBoot 实现异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 5、Spring Cloud Sleuth

在微服务中，通常根据业务模块分服务，项目中前端发起一个请求，后端可能跨几个服务调用才能完成这个请求（如下图）。如果系统越来越庞大，服务之间的调用与被调用关系就会变得很复杂，假如一个请求中需要跨几个服务调用，其中一个服务由于网络延迟等原因挂掉了，那么这时候我们需要分析具体哪一个服务出问题了就会显得很困难。Spring Cloud Sleuth服务链路跟踪功能就可以帮助我们快速的发现错误根源以及监控分析每条请求链路上的性能等等。 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/023/45/68_1.png#alt=68%5C_1.png)


### 6、区分构造函数注入和 setter 注入。
| 构造函数注入 | setter 注入 |
| --- | --- |
| 没有部分注入 | 有部分注入 |
| 不会覆盖 setter 属性 | 会覆盖 setter 属性 |
| 任意修改都会创建一个新实例 | 任意修改不会创建一个新实例 |
| 适用于设置很多属性 | 适用于设置少量属性 |



### 7、您对Mike Cohn的测试金字塔了解多少？

Mike Cohn 提供了一个名为Test Pyramid的模型。这描述了软件开发所需的自动化测试类型。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_19.png#alt=img%5C_19.png)

图16：  Mike Cohn的测试金字塔 – 微服务面试问题

根据金字塔，第一层的测试数量应该最高。在服务层，测试次数应小于单元测试级别，但应大于端到端级别。


### 8、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_9.png#alt=45%5C_9.png)

**springcloud由以下⼏个核⼼组件构成：**

**1、** Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从⽽知道其他服务在哪⾥

**2、** Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从⼀个服务的多台机器中选择⼀台

**3、** Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

**4、** Hystrix：发起请求是通过Hystrix的线程池来⾛的，不同的服务⾛不同的线程池，实现了不同服务调⽤的隔离，避免了服务雪崩的问题

**5、** Zuul：如果前端、移动端要调⽤后端系统，统⼀从Zuul⽹关进⼊，由Zuul⽹关转发请求给对应的服务


### 9、SpringBoot 还提供了其它的哪些 Starter Project Options？

SpringBoot 也提供了其它的启动器项目包括，包括用于开发特定类型应用程序的典型依赖项。

**1、** spring-boot-starter-web-services - SOAP Web Services；

**2、** spring-boot-starter-web - Web 和 RESTful 应用程序；

**3、** spring-boot-starter-test - 单元测试和集成测试；

**4、** spring-boot-starter-jdbc - 传统的 JDBC；

**5、** spring-boot-starter-hateoas - 为服务添加 HATEOAS 功能；

**6、** spring-boot-starter-security - 使用 SpringSecurity 进行身份验证和授权；

**7、** spring-boot-starter-data-jpa - 带有 Hibeernate 的 Spring Data JPA；

**8、** spring-boot-starter-data-rest - 使用 Spring Data REST 公布简单的 REST 服务；


### 10、如何在 SpringBoot中禁用 Actuator端点安全性?

默认情况下，所有敏感的HTTP端点都是安全的，只有具有 `http ACTUATOR`角色的用户才能访问它们。安全性是使用标准的 `httpservletrequest. isuserinrole..isusernrole`方法实施的。可以使用 `management. security. enabled= false`来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 11、我们如何监视所有SpringBoot微服务？
### 12、列举 IoC 的一些好处
### 13、列举 Spring DAO 抛出的异常。
### 14、SpringBoot 怎么用好自动配置，精髓:
### 15、什么是bean装配?
### 16、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 17、Spring Cloud Consul
### 18、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 19、您将如何在微服务上执行安全测试？
### 20、什么是网关?
### 21、Spring Cloud Zookeeper
### 22、Spring由哪些模块组成?
### 23、什么是 JavaConfig？
### 24、SpringBoot、Spring MVC 和 Spring 有什么区别
### 25、SpringBoot如何配置log4j？
### 26、JPA 和 Hibernate 有哪些区别？
### 27、什么是编织（Weaving）？
### 28、什么是 SpringBoot？
### 29、什么是bean的自动装配？
### 30、什么是 Spring Profiles？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
