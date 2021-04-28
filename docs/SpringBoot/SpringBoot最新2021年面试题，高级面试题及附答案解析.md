# SpringBoot最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是CSRF攻击？

CSRF代表跨站请求伪造。这是一种攻击，迫使最终用户在当前通过身份验证的Web应用程序上执行不需要的操作。CSRF攻击专门针对状态改变请求，而不是数据窃取，因为攻击者无法查看对伪造请求的响应。


### 2、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


### 3、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用spring-boot-starter-activemq依赖关系。它只需要很少的配置，并且不需要样板代码。


### 4、SpringBoot 怎么用好自动配置，精髓:

**1、** SpringBoot启动会加载大量的自动配置类

**2、** 我们看我们需要的功能有没有SpringBoot默认写好的自动配置类;

**3、** 我们再来看这个自动配置类中到底配置了哪些组件;(只要我们要用的组件有，我们就不需要再来配置了

**4、** 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这 些属性的值;


### 5、你如何理解 SpringBoot 配置加载顺序？

在 SpringBoot 里面，可以使用以下几种方式来加载配置。

**1、** properties文件；

**2、** YAML文件；

**3、** 系统环境变量；

**4、** 命令行参数；

等等……


### 6、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用spring-boot-starter-activemq 依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 7、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的org.springframework.data.domain.Pageable传递给存储库方法。


### 8、什么是 SpringBoot？

SpringBoot 是 Spring 开源组织下的子项目，是 Spring 组件一站式解决方案，主要是简化了使用 Spring 的难度，简省了繁重的配置，提供了各种启动器，开发者能快速上手。


### 9、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解 主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： [@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 10、spring boot 核心的两个配置文件：

**1、** bootstrap (.yml 或.properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud Config 或者 Nacos 中会用到它。且 boostrap 里面的属性不能被覆盖；

**2、** application (. yml 或者 . properties)：由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 11、spring-boot-starter-parent 有什么用 ?
### 12、开启 SpringBoot 特性有哪几种方式？
### 13、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 14、SpringBoot 自动配置原理
### 15、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？
### 16、您使用了哪些 starter maven 依赖项？
### 17、SpringBoot常用的starter有哪些？
### 18、开启 SpringBoot 特性有哪几种方式？
### 19、SpringBoot支持什么前端模板，
### 20、如何实现 SpringBoot应用程序的安全性?
### 21、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 22、什么是自动配置？
### 23、可以在SpringBoot application中禁用默认的Web服务器吗？
### 24、SpringBoot 配置加载顺序?
### 25、您使用了哪些starter maven依赖项？
### 26、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 27、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？
### 28、什么是 Spring Profiles？
### 29、什么是 JavaConfig？
### 30、SpringBoot与SpringCloud 区别
### 31、SpringBoot 还提供了其它的哪些 Starter Project Options？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
