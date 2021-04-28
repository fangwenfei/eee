# Spring面试题大汇总，2021年附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、@SpringBootApplication注释在内部有什么用处?

作为Spring引导文档，@SpringBootApplication注释等同于同时使用@Configuration、@EnableAutoConfiguration和@ComponentScan及其默认属性。SpringBoot允许开发人员使用单个注释而不是多个注释。但是，众所周知，Spring提供了松散耦合的特性，我们可以根据项目需要为每个注释使用这些特性。


### 2、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?

SpringBoot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 java -jar xxx.jar 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

SpringBoot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 SpringBoot 打包成的可执行 jar 解压后，在 \BOOT-INF\classes 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom.xml 文件中增加配置，将 SpringBoot 项目打包成两个 jar ，一个可执行，一个可引用。


### 3、SpringBoot Starter的工作原理

`我个人理解SpringBoot就是由各种Starter组合起来的，我们自己也可以开发Starter`

在sprinBoot启动时由@SpringBootApplication注解会自动去maven中读取每个starter中的spring、factories文件,该文件里配置了所有需要被创建spring容器中的bean，并且进行自动配置把bean注入SpringContext中 //（SpringContext是Spring的配置文件）


### 4、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架。


### 5、Spring由哪些模块组成?

以下是Spring 框架的基本模块：

**1、** Core module

**2、** Bean module

**3、** Context module

**4、** Expression Language module

**5、** JDBC module

**6、** ORM module

**7、** OXM module

**8、** Java Messaging Service(JMS) module

**9、** Transaction module

**10、** Web module

**11、** Web-Servlet module

**12、** Web-Struts module

**13、** Web-Portlet module


### 6、为什么需要学习Spring Cloud

**1、** 首先springcloud基于spingboot的优雅简洁，可还记得我们被无数xml支配的恐惧？可还记得springmvc，mybatis错综复杂的配置，有了spingboot，这些东西都不需要了，spingboot好处不再赘诉，springcloud就基于SpringBoot把市场上优秀的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理

**2、** 什么叫做开箱即用？即使是当年的黄金搭档dubbo+zookeeper下载配置起来也是颇费心神的！而springcloud完成这些只需要一个jar的依赖就可以了！

**3、** springcloud大多数子模块都是直击痛点，像zuul解决的跨域，fegin解决的负载均衡，hystrix的熔断机制等等等等


### 7、如何集成 SpringBoot 和 ActiveMQ？

对于集成 SpringBoot 和 ActiveMQ，我们使用依赖关系。它只需要很少的配置，并且不需要样板代码。


### 8、SpringBoot 实现热部署有哪几种方式？

主要有两种方式：

**1、** Spring Loaded

**2、** Spring-boot-devtools


### 9、解释Spring框架中bean的生命周期。

**1、** Spring容器 从XML 文件中读取bean的定义，并实例化bean。

**2、** Spring根据bean的定义填充所有的属性。

**3、** 如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。

**4、** 如果Bean 实现了 BeanFactoryAware 接口， Spring传递beanfactory 给setBeanFactory 方法。

**5、** 如果有任何与bean相关联的BeanPostProcessors，Spring会在postProcesserBeforeInitialization()方法内调用它们。

**6、** 如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。

**7、** 如果有BeanPostProcessors 和bean 关联，这些bean的postProcessAfterInitialization() 方法将被调用。

**8、** 如果bean实现了 DisposableBean，它将调用destroy()方法。


### 10、服务注册和发现是什么意思？Spring Cloud 如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。 Eureka 服务注册和发现可以在这种情况下提供帮助。由于所有服务都在 Eureka 服务器上注册并通过调用 Eureka 服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 11、什么是Netflix Feign？它的优点是什么？
### 12、什么是Spring Cloud？
### 13、什么是 AOP 切点
### 14、[@Qualifier ](/Qualifier ) 注解有什么用？
### 15、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 16、什么是金丝雀释放？
### 17、缓存机制：
### 18、你怎样定义类的作用域?
### 19、什么是spring?
### 20、可以在SpringBoot application中禁用默认的Web服务器吗？
### 21、列举 spring 支持的事务管理类型
### 22、Spring Cloud解决了哪些问题？
### 23、什么是Spring Cloud Config?
### 24、Docker的目的是什么？
### 25、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 26、什么是持续监测？
### 27、如何在SpringBoot应用程序中实现Spring安全性？
### 28、一个Spring的应用看起来象什么？
### 29、什么是Spring的内部bean？
### 30、如何使用 SpringBoot 部署到不同的服务器？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
