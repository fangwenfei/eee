# SpringBoot最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?

SpringBoot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 java -jar xxx.jar 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

SpringBoot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 SpringBoot 打包成的可执行 jar 解压后，在 \BOOT-INF\classes 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom.xml 文件中增加配置，将 SpringBoot 项目打包成两个 jar ，一个可执行，一个可引用。


### 2、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的org.springframework.data.domain.Pageable传递给存储库方法。


### 3、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在发布它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 4、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？

SpringBoot支持Java Util Logging，Log4J2，Lockback作为日志框架，如果你使用Starters启动器，SpringBoot将使用Logback作为默认日志框架


### 5、SpringBoot 怎么用好自动配置，精髓:

**1、** SpringBoot启动会加载大量的自动配置类

**2、** 我们看我们需要的功能有没有SpringBoot默认写好的自动配置类;

**3、** 我们再来看这个自动配置类中到底配置了哪些组件;(只要我们要用的组件有，我们就不需要再来配置了

**4、** 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这 些属性的值;


### 6、SpringBoot 最大的优势是什么呢？

SpringBoot 的最大的优势是“约定优于配置“。“约定优于配置“是一种软件设计范式，开发人员按照约定的方式来进行编程，可以减少软件开发人员需做决定的数量，获得简单的好处，而又不失灵活性。

SpringBoot 中 “约定优于配置“的具体产品体现在哪里。

SpringBoot Starter、SpringBoot Jpa 都是“约定优于配置“的一种体现。都是通过“约定优于配置“的设计思路来设计的，SpringBoot Starter 在启动的过程中会根据约定的信息对资源进行初始化；SpringBoot Jpa 通过约定的方式来自动生成 Sql ，避免大量无效代码编写。具体详细可以参考：SpringBoot 为什么这么火？


### 7、如何使用 SpringBoot 实现全局异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。 我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 8、SpringBoot、Spring MVC 和 Spring 有什么区别

**1、** Spring 是一个“引擎”，

**2、** Spring MVC是基于Spring的一个 MVC 框架，

**3、** SpringBoot是基于 Spring的一套快速开发整合包


### 9、SpringBoot微服务中如何实现 session 共享 ?

在微服务中，一个完整的项目被拆分成多个不相同的独立的服务，各个服务独立部署在不同的服务器上，各自的 session 被从物理空间上隔离开了，但是经常，我们需要在不同微服务之间共享 session ，常见的方案就是 Spring Session + Redis 来实现 session 共享。将所有微服务的 session 统一保存在 Redis 上，当各个微服务对 session 有相关的读写操作时，都去操作 Redis 上的 session 。这样就实现了 session 共享，Spring Session 基于 Spring 中的代理过滤器实现，使得 session 的同步操作对开发人员而言是透明的，非常简便。


### 10、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，它提供了配置 Spring IoC 容器的纯 Java 方法。因此它有助于避免使用 XML 配置。

**使用 JavaConfig 的优点在于：**

**1、** 面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** 减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将 JavaConfig 与 XML 混合匹配是理想的。

**3、** 类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring 容器。由于Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 11、SpringBoot 中的监视器是什么？
### 12、如何使用 SpringBoot 部署到不同的服务器？
### 13、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？
### 14、SpringBoot 有哪几种读取配置的方式？
### 15、SpringBoot 需要独立的容器运行吗？
### 16、什么是 SpringBoot？
### 17、spring boot监听器流程?
### 18、什么是 JavaConfig？
### 19、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 20、SpringBoot 配置文件的加载顺序
### 21、什么是Spring Profiles？
### 22、SpringBoot常用的starter有哪些？
### 23、@RestController和@Controller的区别
### 24、什么是Spring Actuator？它有什么优势？
### 25、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 26、什么是Spring Batch？
### 27、SpringBoot 还提供了其它的哪些 Starter Project Options？
### 28、如何在 SpringBoot 中添加通用的 JS 代码？
### 29、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 30、SpringBoot Starter的工作原理
### 31、什么是SpringBoot ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
