# SpringBoot最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?

是的，更改端口是可行的。可以使用application.properties文件更改端口。但需要提到“server.port”（即server.port=8081）。确保项目类路径中有application.properties；后续工作将由REST Spring框架接手。如果提到server.port=0，那么它将自动分配任何可用的端口。


### 2、SpringBoot有哪些优点？

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 3、SpringBoot 实现热部署有哪几种方式？

主要有两种方式：

**1、** Spring Loaded

**2、** Spring-boot-devtools


### 4、SpringBoot 自动配置原理是什么？

注解 @EnableAutoConfiguration, @Configuration, [@ConditionalOnClass ](/ConditionalOnClass ) 就是自动配置的核心，首先它得是一个配置文件，其次根据类路径下是否有这个类去自动配置。


### 5、SpringBoot 中的 starter 到底是什么 ?

首先，这个 Starter 并非什么新的技术点，基本上还是基于 Spring 已有功能来实现的。首先它提供了一个自动化配置类，一般命名为 `XXXAutoConfiguration` ，在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，然后通过类型安全的属性(spring、factories)注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。正因为如此，很多第三方框架，我们只需要引入依赖就可以直接使用了。当然，开发者也可以自定义 Starter


### 6、在 Spring Initializer 中，如何改变一个项目的包名字？

好消息是你可以定制它。点击链接“转到完整版本”。你可以配置你想要修改的包名称！


### 7、什么是SpringBoot

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置


### 8、SpringBoot 是否可以使用 XML 配置 ?

SpringBoot 推荐使用 Java 配置而非 XML 配置，但是 SpringBoot 中也可以使用 XML 配置，通过 [@ImportResource ](/ImportResource ) 注解可以引入一个 XML 配置。


### 9、创建一个 SpringBoot Project 的最简单的方法是什么？

Spring Initializer 是创建 SpringBoot Projects 的一个很好的工具


### 10、什么是starter?

Starter主要是用来简化maven依赖


### 11、SpringBoot 有哪几种读取配置的方式？
### 12、我们如何监视所有SpringBoot微服务？
### 13、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 14、SpringBoot 提供了哪些核心功能？
### 15、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 16、什么是 SpringBoot？
### 17、如何实现 SpringBoot 应用程序的安全性？
### 18、SpringBoot 实现热部署有哪几种方式？
### 19、如何实现SpringBoot应用程序的安全性？
### 20、SpringBoot 如何设置支持跨域请求？
### 21、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 22、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 23、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?
### 24、SpringBoot Starter 的工作原理是什么？
### 25、微服务中如何实现 session 共享 ?
### 26、JPA 和 Hibernate 有哪些区别？
### 27、什么是 JavaConfig？
### 28、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 29、什么是 Spring Data？
### 30、什么是JavaConfig？
### 31、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
