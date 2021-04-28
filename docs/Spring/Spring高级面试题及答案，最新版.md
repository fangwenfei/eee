# Spring高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 Hystrix？

在分布式系统，我们一定会依赖各种服务，那么这些个服务一定会出现失败的情况，就会导致雪崩，Hystrix就是这样的一个工具，防雪崩利器，它具有服务降级，服务熔断，服务隔离，监控等一些防止雪崩的技术。

**Hystrix有四种防雪崩方式:**

**1、** 服务降级：接口调用失败就调用本地的方法返回一个空

**2、** 服务熔断：接口调用失败就会进入调用接口提前定义好的一个熔断的方法，返回错误信息

**3、** 服务隔离：隔离服务之间相互影响

**4、** 服务监控：在服务发生调用时,会将每秒请求数、成功请求数等运行指标记录下来。


### 2、你怎样定义类的作用域?

当定义一个 在Spring里，我们还能给这个bean声明一个作用域。它可以通过bean 定义中的scope属性来定义。如，当Spring要在需要的时候每次生产一个新的bean实例，bean的scope属性被指定为prototype。另一方面，一个bean每次使用的时候必须返回同一个实例，这个bean的scope 属性 必须设为 singleton。


### 3、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，它提供了配置 Spring IoC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

**1、** 面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** 减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

**3、** 类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 4、服务雪崩？

简介：服务雪崩效应是⼀种因服务提供者的不可⽤导致服务调⽤者的不可⽤,并将不可⽤逐渐放⼤的过程.

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_12.png#alt=45%5C_12.png)

**形成原因**

**1、** 服务提供者不可

**2、** 重试加⼤流量

**3、** 服务调⽤者不可⽤

**采⽤策略**

**1、** 流量控制

**2、** 改进缓存模式

**3、** 服务⾃动扩容

**4、** 服务调⽤者降级服务


### 5、解释基于注解的切面实现

在这种情况下(基于@AspectJ的实现)，涉及到的切面声明的风格与带有java5标注的普通java类一致。


### 6、微服务架构的优缺点是什么？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_6.png#alt=img%5C_6.png)


### 7、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


### 8、如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？



直接在方法中声明这个对象,Spring MVC就自动会把属性赋值到这个对象里面。


### 9、spring DAO 有什么用？

Spring DAO 使得 JDBC，Hibernate 或 JDO 这样的数据访问技术更容易以一种统一的方式工作。 这使得用户容易在持久性技术之间切换。 它还允许您在编写代码时，无需考虑捕获每种技术不同的异常。


### 10、自动装配有什么局限？

覆盖的可能性 - 您始终可以使用 `<constructor-arg>` 和 `<property>` 设置指定依赖项，这将覆盖自动装配。基本元数据类型 - 简单属性（如原数据类型，字符串和类）无法自动装配。令人困惑的性质 - 总是喜欢使用明确的装配，因为自动装配不太精确。


### 11、什么是Spring Cloud？
### 12、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 13、什么是Eureka的自我保护模式，
### 14、Spring Cloud和各子项目版本对应关系
### 15、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 16、Springboot 有哪些优点？
### 17、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 18、SpringBoot多数据源拆分的思路
### 19、你所知道微服务的技术栈有哪些？列举一二
### 20、Spring MVC的优点
### 21、SpringBoot 实现热部署有哪几种方式？
### 22、第⼆层缓存：
### 23、Ribbon是什么？
### 24、DispatcherServlet
### 25、微服务的缺点：
### 26、区分 BeanFactory 和 ApplicationContext。
### 27、合同测试你懂什么？
### 28、如何使用 SpringBoot 部署到不同的服务器？
### 29、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 30、Spring Framework 中有多少个模块，它们分别是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
