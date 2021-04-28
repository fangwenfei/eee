# SpringBoot最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是Spring Profiles？

Spring Profiles允许用户根据配置文件（dev，test，prod等）来注册bean。因此，当应用程序在开发中运行时，只有某些bean可以加载，而在PRODUCTION中，某些其他bean可以加载。假设我们的要求是Swagger文档仅适用于QA环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot使得使用配置文件非常简单。


### 2、什么是SpringBoot？

用来简化spring应用的初始搭建以及开发过程，使用特定的方式来进行配置（`properties`或`yml`文件）创建独立的spring引用程序 main方法运行，嵌入的Tomcat 无需部署war文件，简化maven配置，自动配置spring添加对应功能starter自动化配置


### 3、什么是 SpringBoot 启动类注解：

@SpringBootConfiguration:SpringBoot的配置类; 标注在某个类上，表示这是一个SpringBoot的配置类; @Configuration:配置类上来标注这个注解;配置类 ----- 配置文件;配置类也是容器中的一个组件;[@Component ](/Component )

@EnableAutoConfiguration:开启自动配置功能;

以前我们需要配置的东西，SpringBoot帮我们自动配置;@EnableAutoConfiguration告诉SpringBoot开启自动配置功能;这样自动配置才能生效;

SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就失效，帮我们进行自动配置工作


### 4、如何使用 SpringBoot 部署到不同的服务器？

你需要做下面两个步骤：

在一个项目中生成一个 war 文件。

将它部署到你最喜欢的服务器（websphere 或者 Weblogic 或者 Tomcat and so on）。

**第一步：**这本入门指南应该有所帮助：

[https://spring.io/guides/gs/convert-jar-to-war/](https://spring.io/guides/gs/convert-jar-to-war/)

**第二步：**取决于你的服务器。


### 5、如何使用 SpringBoot 实现分页和排序？

使用 SpringBoot 实现分页非常简单。使用 Spring Data-JPA 可以实现将可分页的传递给存储库方法。


### 6、如何实现SpringBoot应用程序的安全性？

为了实现SpringBoot的安全性，我们使用 spring-boot-starter-security依赖项，并且必须添加安全配置。它只需要很少的代码。配置类将必须扩展WebSecurityConfigurerAdapter并覆盖其方法。


### 7、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 8、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** Spring

Spring最重要的特征是依赖注入。所有 SpringModules 不是依赖注入就是 IOC 控制反转。

当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC

Spring MVC 提供了一种分离式的方法来开发 Web 应用。通过运用像 DispatcherServelet，MoudlAndView 和 ViewResolver 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** SpringBoot

Spring 和 SpringMVC 的问题在于需要配置大量的参数。

SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 9、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?

SpringBoot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 java -jar xxx.jar 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

SpringBoot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 SpringBoot 打包成的可执行 jar 解压后，在 \BOOT-INF\classes 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom.xml 文件中增加配置，将 SpringBoot 项目打包成两个 jar ，一个可执行，一个可引用。


### 10、SpringBoot 中的 starter 到底是什么 ?

首先，这个 Starter 并非什么新的技术点，基本上还是基于 Spring 已有功能来实现的。首先它提供了一个自动化配置类，一般命名为 XXXAutoConfiguration ，在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，然后通过类型安全的属性注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。正因为如此，很多第三方框架，我们只需要引入依赖就可以直接使用了。当然，开发者也可以自定义 Starter


### 11、什么是FreeMarker模板？
### 12、SpringBoot 自动配置原理是什么？
### 13、如何在SpringBoot中禁用Actuator端点安全性？
### 14、Springboot 有哪些优点？
### 15、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 16、什么是 SpringBoot Stater ？
### 17、创建一个 SpringBoot Project 的最简单的方法是什么？
### 18、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 19、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 20、开启 SpringBoot 特性有哪几种方式？
### 21、什么是JavaConfig？
### 22、什么是starter?
### 23、创建一个 SpringBoot Project 的最简单的方法是什么？
### 24、SpringBoot 实现热部署有哪几种方式？
### 25、我们如何监视所有SpringBoot微服务？
### 26、什么是JavaConfig？
### 27、为什么我们需要 spring-boot-maven-plugin?
### 28、SpringBoot 有哪几种读取配置的方式？
### 29、spring boot初始化环境变量流程?
### 30、什么是执行器停机？
### 31、什么是 Spring Batch？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
