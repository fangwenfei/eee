# SpringBoot最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

**1、** spring-boot:run 运行你的 SpringBooty 应用程序。

**2、** spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

**3、** spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

**4、** spring-boot:build-info 生成执行器可以使用的构造信息。


### 2、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？

JPA本身是一种规范，它的本质是一种ORM规范（不是ORM框架，因为JPA并未提供ORM实现，只是制定了规范）因为JPA是一种规范，所以，只是提供了一些相关的接口，但是接口并不能直接使用，JPA底层需要某种JPA实现，Hibernate 是 JPA 的一个实现集。

JPA 是根据实体类的注解来创建对应的表和字段，如果需要动态创建表或者字段，需要动态构建对应的实体类，再重新调用Jpa刷新整个Entity。动态SQL，mybatis支持的最好，jpa也可以支持，但是没有Mybatis那么灵活。


### 3、你如何理解 SpringBoot 配置加载顺序？

在 SpringBoot 里面，可以使用以下几种方式来加载配置。

**1、** properties文件；

**2、** YAML文件；

**3、** 系统环境变量；

**4、** 命令行参数；


### 4、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，它提供了配置 Spring IoC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

**1、** 面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** 减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

**3、** 类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 5、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?

思考一下在你的虚拟机上部署应用程序需要些什么。

**第一步：**安装 Java

**第二步：**安装 Web 或者是应用程序的服务器（Tomat/Wbesphere/Weblogic 等等）

**第三步：**部署应用程序 war 包

如果我们想简化这些步骤，应该如何做呢？

让我们来思考如何使服务器成为应用程序的一部分？

你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了，

这个想法是嵌入式服务器的起源。

当我们创建一个可以部署的应用程序的时候，我们将会把服务器（例如，tomcat）嵌入到可部署的服务器中。

例如，对于一个 SpringBoot 应用程序来说，你可以生成一个包含 Embedded Tomcat 的应用程序 jar。你就可以想运行正常 Java 应用程序一样来运行 web 应用程序了。

嵌入式服务器就是我们的可执行单元包含服务器的二进制文件（例如，tomcat.jar）。


### 6、SpringBoot 中如何实现定时任务 ?

在 SpringBoot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 [@Scheduled ](/Scheduled ) 注解，另一-个则是使用第三方框架 Quartz。

使用 Spring 中的 [@Scheduled ](/Scheduled ) 的方式主要通过 [@Scheduled ](/Scheduled ) 注解来实现。


### 7、SpringBoot有哪些优点？

**SpringBoot的优点有：**

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 8、SpringData 项目所支持的关系数据存储技术：

**1、** JDBC

**2、** JPA

Spring Data Jpa 致力于减少数据访问层 (DAO) 的开发量. 开发者唯一要做的，就是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！Spring Data JPA 通过规范方法的名字，根据符合规范的名字来确定方法需要实现什么样的逻辑。


### 9、SpringBoot有哪些优点？

**1、** 快速创建独立运行的spring项目与主流框架集成

**2、** 使用嵌入式的servlet容器，应用无需打包成war包

**3、** starters自动依赖与版本控制

**4、** 大量的自动配置，简化开发，也可修改默认值

**5、** 准生产环境的运行应用监控

**6、** 与云计算的天然集成


### 10、SpringBoot自动配置的原理是什么？

SpringBoot启动的时候通过@EnableAutoConfiguration注解找到META-INF/spring.factories配置文件中所有的自动配置类，并对其进行加载，而这些自动配置类的类名都是以AutoConfiguration结尾来命名的，它实际上就是一个javaConfig形式的Spring容器配置类，它们都有一个@EnableConfigurationPerperties的注解，通过这个注解启动XXXProperties命名的类去加载全局配置中的属性，如server.port,而XXXProperties通过@ConfigurationProperties注解将全局配置文件中的属性与自己的属性进行绑定。


### 11、spring-boot-starter-parent 有什么用 ?
### 12、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 13、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 14、SpringBoot自动配置的原理
### 15、您使用了哪些starter maven依赖项？
### 16、如何使用 SpringBoot 实现分页和排序？
### 17、什么是 Spring Profiles？
### 18、SpringBoot性能如何优化
### 19、什么是自动配置？
### 20、怎么设计无状态服务？
### 21、SpringBoot的缺点
### 22、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 23、@SpringBootApplication注释在内部有什么用处?
### 24、什么是JavaConfig？
### 25、SpringBoot多数据源拆分的思路
### 26、SpringBoot 日志框架：
### 27、开启 SpringBoot 特性有哪几种方式？
### 28、Spring、SpringBoot、SpringMVC的区别？
### 29、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 30、SpringBoot与SpringCloud 区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
