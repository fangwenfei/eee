# SpringBoot最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架


### 2、什么是Spring Actuator？它有什么优势？

这是SpringBoot中最常见的面试问题之一。根据Spring文件：

执行器是一个制造术语，指的是移动或控制某物的机械装置。执行机构可以从一个小的变化中产生大量的运动。

众所周知，SpringBoot提供了许多自动配置特性，帮助开发人员快速开发生产组件。但是，当考虑调试和如何调试，如果出现问题，总是需要分析日志并挖掘应用程序的数据流，检查问题出在何处。因此，Spring Actuator提供了方便的访问这些类型的途径。它提供了许多特性，例如创建了什么样的bean、控制器中的映射、CPU使用情况等等。它还可以将自动收集和审计健康状况和指标应用到应用程序中。

它提供了一种非常简单的方法来访问少数生产就绪的REST端点，并从Web获取各种信息。但是通过使用这些端点，你可以做很多事情来查看端点文档。没有必要担心安全问题;如果存在Spring Security，则默认使用Spring Security的内容协商策略保护这些端点。或者，可以在RequestMatcher的帮助下配置自定义安全性。


### 3、如何启用/禁用执行器？

启用/禁用致动器很容易；最简单的方法是使特性能够将依赖项(Maven/Gradle)添加到spring-boot-starter-actuator，即启动器。如果不想启用致动器，那么就不要添加依赖项。

Maven依赖项：

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>
```


### 4、如何在 SpringBoot 中添加通用的 JS 代码？

在源文件夹下，创建一个名为 static 的文件夹。然后，你可以把你的静态的内容放在这里面。

例如，myapp.js 的路径是 resources\static\js\myapp.js

**

你可以参考它在 jsp 中的使用方法：**

错误：HAL browser gives me unauthorized error - Full authenticaition is required to access this resource.

该如何来修复这个错误呢？

两种方法：

方法 1：关闭安全验证

application.properties

```
management.security.enabled:FALSE
```

方法二：在日志中搜索密码并传递至请求标头中


### 5、保护 SpringBoot 应用有哪些方法？

**1、**  在生产中使用HTTPS

**2、**  使用Snyk检查你的依赖关系

**3、**  升级到最新版本

**4、**  启用CSRF保护

**5、**  使用内容安全策略防止XSS攻击


### 6、SpringBoot自动配置的原理是什么？

SpringBoot启动的时候通过@EnableAutoConfiguration注解找到META-INF/spring.factories配置文件中所有的自动配置类，并对其进行加载，而这些自动配置类的类名都是以AutoConfiguration结尾来命名的，它实际上就是一个javaConfig形式的Spring容器配置类，它们都有一个@EnableConfigurationPerperties的注解，通过这个注解启动XXXProperties命名的类去加载全局配置中的属性，如server.port,而XXXProperties通过@ConfigurationProperties注解将全局配置文件中的属性与自己的属性进行绑定。


### 7、什么是JavaConfig？

Spring JavaConfig是Spring社区的产品，它提供了配置Spring IoC容器的纯Java方法。因此它有助于避免使用XML配置。使用JavaConfig的优点在于：

面向对象的配置。由于配置被定义为JavaConfig中的类，因此用户可以充分利用Java中的面向对象功能。一个配置类可以继承另一个，重写它的@Bean方法等。

减少或消除XML配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在XML和Java之间来回切换。

JavaConfig为开发人员提供了一种纯Java方法来配置与XML配置概念相似的Spring容器。

从技术角度来讲，只使用JavaConfig配置类来配置容器是可行的，但实际上很多人认为将JavaConfig与XML混合匹配是理想的。

类型安全和重构友好。JavaConfig提供了一种类型安全的方法来配置Spring容器。由于Java 5.0对泛型的支持，现在可以按类型而不是按名称检索bean，不需要任何强制转换或基于字符串的查找。


### 8、什么是 JavaConfig？

**1、** `面向对象的配置`。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** `减少或消除 XML 配置`。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

**3、** `类型安全和重构友好`。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 9、什么是 SpringBoot 启动类注解：

@SpringBootConfiguration:SpringBoot的配置类; 标注在某个类上，表示这是一个SpringBoot的配置类; @Configuration:配置类上来标注这个注解;配置类 ----- 配置文件;配置类也是容器中的一个组件;[@Component ](/Component )

@EnableAutoConfiguration:开启自动配置功能;

以前我们需要配置的东西，SpringBoot帮我们自动配置;@EnableAutoConfiguration告诉SpringBoot开启自动配置功能;这样自动配置才能生效;

SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就失效，帮我们进行自动配置工作


### 10、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

spring-boot:run 运行你的 SpringBooty 应用程序。

spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

spring-boot:build-info 生成执行器可以使用的构造信息。


### 11、什么是 Spring Data？
### 12、SpringBoot中的监视器是什么?
### 13、SpringBoot如何实现打包
### 14、SpringBoot 的自动配置是如何实现的？
### 15、我们如何监视所有 SpringBoot 微服务？
### 16、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 17、如何在自定义端口上运行 SpringBoot 应用程序？
### 18、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 19、如何在不使用BasePACKAGE过滤器的情况下排除程序包？
### 20、SpringBoot中的监视器是什么？
### 21、SpringBoot微服务中如何实现 session 共享 ?
### 22、SpringBoot的自动配置原理是什么
### 23、您使用了哪些starter maven依赖项？
### 24、SpringBoot 有哪几种读取配置的方式？
### 25、创建一个 SpringBoot Project 的最简单的方法是什么？
### 26、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 27、什么是SpringBoot？
### 28、如何在 SpringBoot中禁用 Actuator端点安全性?
### 29、什么是WebSockets？
### 30、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 31、SpringBoot运行项目的几种方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
