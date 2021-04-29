# Spring高级面试题及答案，2021版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot多数据源拆分的思路

先在properties配置文件中配置两个数据源，创建分包mapper，使用@ConfigurationProperties读取properties中的配置，使用@MapperScan注册到对应的mapper包中


### 2、您对微服务有何了解？

微服务，又称微服务架构，是一种架构风格，它将应用程序构建为以业务领域为模型的小型自治服务集合 。

通俗地说，你必须看到蜜蜂如何通过对齐六角形蜡细胞来构建它们的蜂窝状物。他们最初从使用各种材料的小部分开始，并继续从中构建一个大型蜂箱。这些细胞形成图案，产生坚固的结构，将蜂窝的特定部分固定在一起。这里，每个细胞独立于另一个细胞，但它也与其他细胞相关。这意味着对一个细胞的损害不会损害其他细胞，因此，蜜蜂可以在不影响完整蜂箱的情况下重建这些细胞。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_1.png#alt=img%5C_1.png)

图1：微服务的蜂窝表示 – 微服务访谈问题

请参考上图。这里，每个六边形形状代表单独的服务组件。与蜜蜂的工作类似，每个敏捷团队都使用可用的框架和所选的技术堆栈构建单独的服务组件。就像在蜂箱中一样，每个服务组件形成一个强大的微服务架构，以提供更好的可扩展性。此外，敏捷团队可以单独处理每个服务组件的问题，而对整个应用程序没有影响或影响最小。


### 3、Ribbon是什么？

**1、** Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法

**2、** Ribbon客户端组件提供一系列完善的配置项，如连接超时，重试等。简单的说，就是在配置文件中列出后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随即连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。（有点类似Nginx）


### 4、SpringBoot读取配置文件的方式

SpringBoot默认读取配置文件为application.properties或者是application.yml


### 5、Spring Cloud OpenFeign

基于Ribbon和Hystrix的声明式服务调用组件，可以动态创建基于Spring MVC注解的接口实现用于服务调用，在Spring Cloud 2.0中已经取代Feign成为了一等公民。

Spring Cloud的版本关系

Spring Cloud是一个由许多子项目组成的综合项目，各子项目有不同的发布节奏。为了管理Spring Cloud与各子项目的版本依赖关系，发布了一个清单，其中包括了某个Spring Cloud版本对应的子项目版本。

为了避免Spring Cloud版本号与子项目版本号混淆，Spring Cloud版本采用了名称而非版本号的命名，这些版本的名字采用了伦敦地铁站的名字，根据字母表的顺序来对应版本时间顺序，例如Angel是第一个版本，Brixton是第二个版本。

当Spring Cloud的发布内容积累到临界点或者一个重大BUG被解决后，会发布一个"service releases"版本，简称SRX版本，比如Greenwich.SR2就是Spring Cloud发布的Greenwich版本的第2个SRX版本。目前Spring Cloud的最新版本是Hoxton。


### 6、什么是基于注解的容器配置?

相对于XML文件，注解型的配置依赖于通过字节码元数据装配组件，而非尖括号的声明。

开发者通过在相应的类，方法或属性上使用注解的方式，直接组件类中进行配置，而不是使用xml表述bean的装配关系。


### 7、spring JDBC API 中存在哪些类？

**1、** JdbcTemplate

**2、** SimpleJdbcTemplate

**3、** NamedParameterJdbcTemplate

**4、** SimpleJdbcInsert

**5、** SimpleJdbcCall


### 8、什么是Spring IOC 容器？

Spring IOC 负责创建对象，管理对象（通过依赖注入（DI），装配对象，配置对象，并且管理这些对象的整个生命周期。


### 9、SpringBoot 的自动配置是如何实现的？

SpringBoot 项目的启动注解是：@SpringBootApplication，其实它就是由下面三个注解组成的：

**1、** [@Configuration ](/Configuration )

**2、** [@ComponentScan ](/ComponentScan )

**3、** @EnableAutoConfiguration

其中 @EnableAutoConfiguration 是实现自动配置的入口，该注解又通过 [@Import ](/Import ) 注解导入了AutoConfigurationImportSelector，在该类中加载 META-INF/spring.factories 的配置信息。然后筛选出以 EnableAutoConfiguration 为 key 的数据，加载到 IOC 容器中，实现自动配置功能！


### 10、什么是 Aspect？

`aspect` 由 `pointcount` 和 `advice` 组成, 它既包含了横切逻辑的定义, 也包括了连接点的定义、Spring AOP 就是负责实施切面的框架, 它将切面所定义的横切逻辑编织到切面所指定的连接点中、AOP 的工作重心在于如何将增强编织目标对象的连接点上, 这里包含两个工作:

**1、** 如何通过 pointcut 和 advice 定位到特定的 joinpoint 上

**2、** 如何在 advice 中编写切面代码.

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_5.png#alt=img%5C_5.png)

可以简单地认为, 使用 [@Aspect ](/Aspect ) 注解的类就是切面.


### 11、你如何理解 SpringBoot 中的 Starters？
### 12、SpringBoot 配置加载顺序?
### 13、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?
### 14、自动装配有什么局限？
### 15、如何集成SpringBoot和ActiveMQ？
### 16、spring cloud 断路器的作用是什么？
### 17、各服务之间通信，对Restful和Rpc这2种方式如何做选择？
### 18、使⽤中碰到的坑
### 19、springcloud如何实现服务的注册?
### 20、什么是Hystrix？它如何实现容错？
### 21、Spring Cloud Zookeeper
### 22、谈一下领域驱动设计
### 23、Spring MVC的主要组件？
### 24、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?
### 25、如何使用SpringBoot实现分页和排序？
### 26、SpringBoot 自动配置原理是什么？
### 27、什么是spring?
### 28、spring boot 核心的两个配置文件：
### 29、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 30、网关与过滤器有什么区别
### 31、Docker的目的是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
