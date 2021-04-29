# SpringBoot最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、** 容易上手，提升开发效率，为 Spring 开发提供一个更快、更广泛的入门体验。

**2、** 开箱即用，远离繁琐的配置。

**3、** 提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、** 没有代码生成，也不需要XML配置。

**5、** 避免大量的 Maven 导入和各种版本冲突。


### 2、SpringBoot事物的使用

SpringBoot的事物很简单，首先使用注解EnableTransactionManagement开启事物之后，然后在Service方法上添加注解Transactional便可。


### 3、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，它提供了配置 Spring IoC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

**1、** 面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

**2、** 减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

**3、** 类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5.0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。


### 4、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

spring-boot:run 运行你的 SpringBooty 应用程序。

spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

spring-boot:build-info 生成执行器可以使用的构造信息。


### 5、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

传递给存储库方法。


### 6、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：

[@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 7、您使用了哪些 starter maven 依赖项？

**使用了下面的一些依赖项**

**1、**  spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、**  spring-boot-starter-data-jpa 数据库支持

**3、**  spring-boot-starter-data-Redis Redis数据库支持

**4、**  spring-boot-starter-data-solr solr支持

**5、**  mybatis-spring-boot-starter 第三方的mybatis集成starter

自定义的starter(如果自己开发过就可以说出来)


### 8、SpringBoot Starter 的工作原理是什么？
### 9、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 10、如何使用 SpringBoot 部署到不同的服务器？
### 11、Spring、SpringBoot、SpringMVC的区别？
### 12、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 13、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？
### 14、如何使用SpringBoot实现分页和排序？
### 15、什么是 JavaConfig？
### 16、SpringBoot自动配置的原理
### 17、我们如何监视所有 SpringBoot 微服务？
### 18、SpringBoot中的监视器是什么？
### 19、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 20、SpringBoot 中如何解决跨域问题 ?
### 21、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 22、@RestController和@Controller的区别
### 23、SpringBoot 有哪几种读取配置的方式？
### 24、保护 SpringBoot 应用有哪些方法？
### 25、什么是 Spring Data ?
### 26、为什么我们需要 spring-boot-maven-plugin?
### 27、我们如何监视所有 SpringBoot 微服务？
### 28、SpringBoot 实现热部署有哪几种方式？
### 29、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 30、什么是Spring Actuator？它有什么优势？
### 31、什么是JavaConfig？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
