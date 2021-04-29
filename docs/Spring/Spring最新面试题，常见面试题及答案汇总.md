# Spring最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，Spring 3、0引入了他，它提供了配置 Spring IOC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5、0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。

**常用的Java config：**

@Configuration：在类上打上写下此注解，表示这个类是配置类

@ComponentScan：在配置类上添加 [@ComponentScan ](/ComponentScan ) 注解。该注解默认会扫描该类所在的包下所有的配置类，相当于之前的 <context:component-scan >。

@Bean：bean的注入：相当于以前的< bean id="objectMapper" class="org、codehaus、jackson、map、ObjectMapper" />

@EnableWebMvc：相当于xml的<mvc:annotation-driven >

@ImportResource： 相当于xml的 < import resource="applicationContext-cache、xml">


### 2、Spring Framework 有哪些不同的功能？

**1、** 轻量级 - Spring 在代码量和透明度方面都很轻便。

**2、** IOC - 控制反转

**3、** AOP - 面向切面编程可以将应用业务逻辑和系统服务分离，以实现高内聚。

**4、** 容器 - Spring 负责创建和管理对象（Bean）的生命周期和配置。

**5、** MVC - 对 web 应用提供了高度可配置性，其他框架的集成也十分方便。

**6、** 事务管理 - 提供了用于事务管理的通用抽象层。Spring 的事务支持也可用于容器较少的环境。

**7、** JDBC 异常 - Spring 的 JDBC 抽象层提供了一个异常层次结构，简化了错误处理策略。


### 3、双因素身份验证的凭据类型有哪些？

这三种凭证是：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_15.png#alt=img%5C_15.png)

图12： 双因素认证的证书类型 – 微服务面试问题


### 4、Spring MVC用什么对象从后台向前台传递数据的？



通过ModelMap对象,可以在这个对象里面调用put方法,把对象加到里面,前台就可以通过el表达式拿到。


### 5、什么是 Spring Batch?

`SpringBoot Batch`提供可重用的函数，这些函数在处理大量记录时非常重要；包括日志/跟踪，事务管理，作业处理统计信息，作业重新启动，跳过和资源管理。它还提供了更先进的技术服务和功能，通过优化和分区技术，可以实现极高批量和高性能批处理作业。简单以及复杂的大批量批处理作业可以高度可扩展的方式利用框架处理重要大量的信息。



### 6、列举 IoC 的一些好处。

**IoC 的一些好处是：**

**1、** 它将最小化应用程序中的代码量。

**2、** 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。

**3、** 它以最小的影响和最少的侵入机制促进松耦合。

**4、** 它支持即时的实例化和延迟加载服务。


### 7、列举 Spring Framework 的优点。

由于 Spring Frameworks 的分层架构，用户可以自由选择自己需要的组件。Spring Framework 支持 POJO(Plain Old Java Object) 编程，从而具备持续集成和可测试性。由于依赖注入和控制反转，JDBC 得以简化。它是开源免费的。


### 8、什么是SpringBoot？

Spring boot是微服务面试问题的主要话题。 随着新功能的加入，Spring变得越来越复杂。无论何时启动新项目，都必须添加新的构建路径或Maven依赖项。简而言之，你需要从头开始做每件事。SpringBoot是一种帮助您避免所有代码配置的解决方案。


### 9、什么是 AOP 通知

通知是个在方法执行前或执行后要做的动作，实际上是程序执行时要通过SpringAOP框架触发的代码段。

Spring切面可以应用五种类型的通知：

**1、** before：前置通知，在一个方法执行前被调用。

**2、** after: 在方法执行之后调用的通知，无论方法执行是否成功。

**3、** after-returning: 仅当方法成功完成后执行的通知。

**4、** after-throwing: 在方法抛出异常退出时执行的通知。

**5、** around: 在方法执行之前和之后调用的通知。


### 10、第⼀层缓存：

readOnlyCacheMap，本质上是ConcurrentHashMap：这是⼀个JVM的CurrentHashMap只读缓存，这个主要是为了供客户端获取注册信息时使⽤，其缓存更新，依赖于定时器的更新，通过和readWriteCacheMap 的值做对⽐，如果数据不⼀致，则以readWriteCacheMap 的数据为准。readOnlyCacheMap 缓存更新的定时器时间间隔，默认为30秒

#
### 11、如何集成SpringBoot和ActiveMQ？
### 12、SpringBoot 的自动配置是如何实现的？
### 13、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 14、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 15、你能否举一个以 ReadOnly 为事务管理的例子？
### 16、什么是Spring的MVC框架？
### 17、运行 SpringBoot 有哪几种方式？
### 18、如何使用SpringBoot实现分页和排序？
### 19、什么是 JavaConfig？
### 20、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 21、解释AOP
### 22、[@RequestMapping ](/RequestMapping ) 注解
### 23、微服务架构的优缺点是什么？
### 24、服务注册和发现是什么意思？Spring Cloud如何实现？
### 25、什么是织入。什么是织入应用的不同点？
### 26、SpringBoot 自动配置原理是什么？
### 27、spring cloud 和dubbo区别?
### 28、保护 SpringBoot 应用有哪些方法？
### 29、如何给Spring 容器提供配置元数据?
### 30、您对Mike Cohn的测试金字塔了解多少？
### 31、DiscoveryClient的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
