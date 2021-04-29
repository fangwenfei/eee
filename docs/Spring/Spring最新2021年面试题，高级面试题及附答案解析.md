# Spring最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量。


### 2、Spring 、SpringBoot 和 Spring Cloud 的关系?

**1、** Spring 最初最核心的两大核心功能 Spring Ioc 和 Spring Aop 成就了 Spring，Spring 在这两大核心的功能上不断的发展，才有了 Spring 事务、Spring Mvc 等一系列伟大的产品，最终成就了 Spring 帝国，到了后期 Spring 几乎可以解决企业开发中的所有问题。

**2、** SpringBoot 是在强大的 Spring 帝国生态基础上面发展而来，发明 SpringBoot 不是为了取代 Spring ,是为了让人们更容易的使用 Spring 。

**3、** Spring Cloud 是一系列框架的有序集合。它利用 SpringBoot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 SpringBoot 的开发风格做到一键启动和部署。

**4、** Spring Cloud 是为了解决微服务架构中服务治理而提供的一系列功能的开发框架，并且 Spring Cloud 是完全基于 SpringBoot 而开发，Spring Cloud 利用 SpringBoot 特性整合了开源行业中优秀的组件，整体对外提供了一套在微服务架构中服务治理的解决方案。

**5、** 用一组不太合理的包含关系来表达它们之间的关系。

**6、** Spring ioc/aop > Spring > SpringBoot > Spring Cloud


### 3、什么是通知（Advice）？

特定 JoinPoint 处的 Aspect 所采取的动作称为 Advice。Spring AOP 使用一个 Advice 作为拦截器，在 JoinPoint “周围”维护一系列的拦截器。


### 4、spring cloud 和dubbo区别?

**1、** 服务调用方式 dubbo是RPC springcloud Rest Api

**2、** 注册中心,dubbo 是zookeeper springcloud是eureka，也可以是zookeeper

**3、** 服务网关,dubbo本身没有实现，只能通过其他第三方技术整合，springcloud有Zuul路由网关，作为路由服务器，进行消费者的请求分发,springcloud支持断路器，与git完美集成配置文件支持版本控制，事物总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素。


### 5、Spring MVC中函数的返回值是什么？



返回值可以有很多类型,有String, ModelAndView。ModelAndView类把视图和数据都合并的一起的，但一般用String比较好。


### 6、Spring Cloud Bus

用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。


### 7、什么是SpringBoot ？

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置

**5、** 自动配置spring添加对应功能starter自动化配置

**6、** spring boot来简化spring应用开发，约定大于配置，去繁从简，just run就能创建一个独立的，产品级别的应用


### 8、如何在 spring 中启动注解装配？

默认情况下，Spring 容器中未打开注解装配。 因此，要使用基于注解装配，我们必须通过配置 <context： annotation-config /> 元素在 Spring 配置文件中启用它。


### 9、什么是JavaConfig？

Spring JavaConfig是Spring社区的产品，它提供了配置Spring IoC容器的纯Java方法。因此它有助于避免使用XML配置。使用JavaConfig的优点在于：

面向对象的配置。由于配置被定义为JavaConfig中的类，因此用户可以充分利用Java中的面向对象功能。一个配置类可以继承另一个，重写它的@Bean方法等。

减少或消除XML配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在XML和Java之间来回切换。

JavaConfig为开发人员提供了一种纯Java方法来配置与XML配置概念相似的Spring容器。

从技术角度来讲，只使用JavaConfig配置类来配置容器是可行的，但实际上很多人认为将JavaConfig与XML混合匹配是理想的。

类型安全和重构友好。JavaConfig提供了一种类型安全的方法来配置Spring容器。由于Java 5.0对泛型的支持，现在可以按类型而不是按名称检索bean，不需要任何强制转换或基于字符串的查找。


### 10、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架，但是不管是那种日志框架他都支持将配置文件输出到控制台或者文件中。


### 11、如何禁用特定的自动配置类？
### 12、什么是Spring Cloud Bus？我们需要它吗？
### 13、有哪些不同类型的IOC（依赖注入）方式？
### 14、Spring Cloud 实现服务注册和发现的原理是什么？
### 15、什么是Idempotence以及它在哪里使用？
### 16、SpringBoot Starter的工作原理
### 17、什么是 Spring IOC 容器？
### 18、什么是Spring Cloud？
### 19、Spring MVC怎么和AJAX相互调用的？
### 20、SpringBoot 中的 starter 到底是什么 ?
### 21、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 22、在Spring框架中如何更有效地使用JDBC?
### 23、什么是 CSRF 攻击？
### 24、什么是端到端微服务测试？
### 25、有哪些不同类型的IOC（依赖注入）方式？
### 26、什么是不同类型的双因素身份认证？
### 27、什么是Spring beans?
### 28、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 29、SpringBoot和SpringCloud的区别？
### 30、为什么我们需要 spring-boot-maven-plugin?
### 31、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
