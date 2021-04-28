# Spring最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、[@Autowired ](/Autowired ) 注解有什么用？

[@Autowired ](/Autowired ) 可以更准确地控制应该在何处以及如何进行自动装配。此注解用于在 setter 方法，构造函数，具有任意名称或多个参数的属性或方法上自动装配 bean。默认情况下，它是类型驱动的注入。

```
public class Employee {
    private String name;
    @Autowired
    public void setName(String name) {
        this.name=name;
    }
    public string getName(){
        return name;
    }
}
```


### 2、[@Qualifier ](/Qualifier ) 注解有什么用？

当您创建多个相同类型的 bean 并希望仅使用属性装配其中一个 bean 时，您可以使用[@Qualifier ](/Qualifier ) 注解和 [@Autowired ](/Autowired ) 通过指定应该装配哪个确切的 bean 来消除歧义。


### 3、微服务设计的基础是什么？

这可能是最常见的微服务面试问题之一。在回答这个问题时，你需要记住以下内容：

**1、** 定义范围。

**2、** 结合低耦合和高内聚。

**3、** 创建一个有唯一标识的服务，唯一标识将充当识别源，非常像数据库表中的唯一键。

**4、** 创建正确的API并在集成过程中特别注意。

**5、** 限制对数据的访问并将其限制到所需级别。

**6、** 在请求和响应之间保持顺畅的流程。

**7、** 自动化大多数流程，以减少时间复杂性。

**8、** 将表的数量保持在最低水平，以减少空间复杂性。

**9、** 不断监控架构，发现缺陷及时修复。

**10、**  每个微服务的数据存储应该分开。

**11、**  对于每个微服务，都应该有一个独立的构建。

**12、**  将微服务部署到容器中。

**13、**  服务器应被视为无状态。


### 4、SpringBoot 实现热部署有哪几种方式？

主要有两种方式：

**1、** Spring Loaded

**2、** Spring-boot-devtools


### 5、有哪些不同类型的IOC（依赖注入）方式？

**1、** 构造器依赖注入：构造器依赖注入通过容器触发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖。

**2、** Setter方法注入：Setter方法注入是容器通过调用无参构造器或无参static工厂 方法实例化bean之后，调用该bean的setter方法，即实现了基于setter的依赖注入。


### 6、你所知道微服务的技术栈有哪些？列举一二

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/010/39/49_2.png#alt=49%5C_2.png)


### 7、SpringBoot运行项目的几种方式？

打包用命令或者放到容器中运行

**1、** 打成jar包，使用java -jar xxx.jar运行

**2、** 打成war包，放到tomcat里面运行

直接用maven插件运行   maven spring-boot：run

直接执行main方法运行


### 8、Spring Cloud OpenFeign

基于Ribbon和Hystrix的声明式服务调用组件，可以动态创建基于Spring MVC注解的接口实现用于服务调用，在Spring Cloud 2.0中已经取代Feign成为了一等公民。

Spring Cloud的版本关系

Spring Cloud是一个由许多子项目组成的综合项目，各子项目有不同的发布节奏。为了管理Spring Cloud与各子项目的版本依赖关系，发布了一个清单，其中包括了某个Spring Cloud版本对应的子项目版本。

为了避免Spring Cloud版本号与子项目版本号混淆，Spring Cloud版本采用了名称而非版本号的命名，这些版本的名字采用了伦敦地铁站的名字，根据字母表的顺序来对应版本时间顺序，例如Angel是第一个版本，Brixton是第二个版本。

当Spring Cloud的发布内容积累到临界点或者一个重大BUG被解决后，会发布一个"service releases"版本，简称SRX版本，比如Greenwich.SR2就是Spring Cloud发布的Greenwich版本的第2个SRX版本。目前Spring Cloud的最新版本是Hoxton。


### 9、使用 Spring 有哪些方式？

**使用 Spring 有以下方式：**

**1、** 作为作为一个成熟的 Spring Web 应用程序。

**2、** 作为第三方 Web 框架，使用 Spring Frameworks 中间层。

**3、** 用于远程使用。

**4、** 作为企业级 Java Bean，它可以包装现有的 POJO（Plain Old Java Objects）。 Bean，它可以包装现有的 POJO（Plain Old Java Objects）。


### 10、SpringBoot 提供了哪些核心功能？

**1、** 独立运行 Spring 项目

**2、** 内嵌 Servlet 容器

SpringBoot 可以选择内嵌 Tomcat、Jetty 或者 Undertow，这样我们无须以 war 包形式部署项目。

**3、** 提供 Starter 简化 Maven 配置

例如，当你使用了 spring-boot-starter-web ，会自动加入如下依赖：`spring-boot-starter-web` 的 pom 文件

**4、** 自动配置 Spring Bean

SpringBoot 检测到特定类的存在，就会针对这个应用做一定的配置，进行自动配置 Bean ，这样会极大地减少我们要使用的配置。

**5、** 准生产的应用监控

SpringBoot 提供基于 HTTP、JMX、SSH 对运行时的项目进行监控。

**6、** 无代码生成和 XML 配置

SpringBoot 没有引入任何形式的代码生成，它是使用的 Spring 4.0 的条件 [@Condition ](/Condition ) 注解以实现根据条件进行配置。同时使用了 Maven /Gradle 的依赖传递解析机制来实现 Spring 应用里面的自动配置。


### 11、什么是Spring MVC框架的控制器？
### 12、哪些是重要的bean生命周期方法？你能重载它们吗？
### 13、Spring由哪些模块组成?
### 14、服务注册和发现是什么意思？Spring Cloud如何实现？
### 15、Spring Cloud 和dubbo区别?
### 16、什么是Hystrix断路器？我们需要它吗？
### 17、eureka缓存机制：
### 18、熔断的原理，以及如何恢复？
### 19、如何在 spring 中启动注解装配？
### 20、什么是DispatcherServlet
### 21、什么是金丝雀释放？
### 22、什么是 AOP 通知
### 23、解释不同方式的自动装配 。
### 24、什么是 Spring Profiles？
### 25、SpringBoot 自动配置原理是什么？
### 26、什么是Eureka
### 27、可以在SpringBoot application中禁用默认的Web服务器吗？
### 28、XMLBeanFactory
### 29、双因素身份验证的凭据类型有哪些？
### 30、SpringBoot 有哪几种读取配置的方式？
### 31、22。你能否给出关于休息和微服务的要点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
