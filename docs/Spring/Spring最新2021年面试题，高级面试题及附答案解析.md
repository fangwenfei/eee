# Spring最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何在不使用BasePACKAGE过滤器的情况下排除程序包？

过滤程序包的方法不尽相同。但是弹簧启动提供了一个更复杂的选项，可以在不接触组件扫描的情况下实现这一点。在使用注释@ SpringBootApplication时，可以使用排除属性。请参阅下面的代码片段：

@SpringBootApplication(exclude= {Employee.class})

public class FooAppConfiguration {}


### 2、Spring MVC的异常处理？



可以将异常抛给Spring框架，由Spring框架来处理；我们只需要配置简单的异常处理器，在异常处理器中添视图页面即可。


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


### 4、什么是 Aspect？

`aspect` 由 `pointcount` 和 `advice` 组成, 它既包含了横切逻辑的定义, 也包括了连接点的定义、Spring AOP 就是负责实施切面的框架, 它将切面所定义的横切逻辑编织到切面所指定的连接点中、AOP 的工作重心在于如何将增强编织目标对象的连接点上, 这里包含两个工作:

**1、** 如何通过 pointcut 和 advice 定位到特定的 joinpoint 上

**2、** 如何在 advice 中编写切面代码.

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_5.png#alt=img%5C_5.png)

可以简单地认为, 使用 [@Aspect ](/Aspect ) 注解的类就是切面.


### 5、SpringBoot多数据源拆分的思路

先在properties配置文件中配置两个数据源，创建分包mapper，使用@ConfigurationProperties读取properties中的配置，使用@MapperScan注册到对应的mapper包中


### 6、什么是Spring Cloud Zuul（服务网关）

Zuul是对SpringCloud提供的成熟对的路由方案，他会根据请求的路径不同，网关会定位到指定的微服务，并代理请求到不同的微服务接口，他对外隐蔽了微服务的真正接口地址。

三个重要概念：动态路由表，路由定位，反向代理：

**1、** 动态路由表：Zuul支持Eureka路由，手动配置路由，这俩种都支持自动更新

**2、** 路由定位：根据请求路径，Zuul有自己的一套定位服务规则以及路由表达式匹配

**3、** 反向代理：客户端请求到路由网关，网关受理之后，在对目标发送请求，拿到响应之后在 给客户端它可以和Eureka,Ribbon,Hystrix等组件配合使用，

**Zuul的应用场景：**

对外暴露，权限校验，服务聚合，日志审计等


### 7、什么是 Hystrix 断路器？我们需要它吗？

由于某些原因，employee-consumer 公开服务会引发异常。在这种情况下使用 Hystrix 我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_13.png#alt=45%5C_13.png)

中断，并且员工使用者将一起跳过 firtsPage 方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_14.png#alt=45%5C_14.png)


### 8、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？

使用DEV工具来实现。 通过这种依赖关系，可以节省任何更改，嵌入式 tomcat将重新启动。 使用SpringBoot有一个开发工具`Dev Tools`模块，可以重新加载 SpringBoot上的更改，而无需重新启动服务器。消除每次手动部署更改的需要。 SpringBoot在发布它的第一个版本时没有这个功能。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 9、Spring Cloud的版本关系

Spring Cloud是一个由许多子项目组成的综合项目，各子项目有不同的发布节奏。 为了管理Spring Cloud与各子项目的版本依赖关系，发布了一个清单，其中包括了某个Spring Cloud版本对应的子项目版本。 为了避免Spring Cloud版本号与子项目版本号混淆，Spring Cloud版本采用了名称而非版本号的命名，这些版本的名字采用了伦敦地铁站的名字，根据字母表的顺序来对应版本时间顺序，例如Angel是第一个版本，Brixton是第二个版本。 当Spring Cloud的发布内容积累到临界点或者一个重大BUG被解决后，会发布一个"service releases"版本，简称SRX版本，比如Greenwich.SR2就是Spring Cloud发布的Greenwich版本的第2个SRX版本。目前Spring Cloud的最新版本是Hoxton。


### 10、bootstrap.yml和application.yml有什么区别?

**1、** Spring Cloud 构建于 SpringBoot 之上，在 SpringBoot 中有两种上下文，一种是 bootstrap，另外一种是 application。

**2、** application 配置文件这个容易理解，主要用于 SpringBoot 项目的`自动化配置`。

**3、** bootstrap 是应用程序的父上下文，也就是说 `bootstrap 加载优先于 applicaton`。

**4、** bootstrap 主要用于从`额外的资源来加载配置信息`，还可以在本地外部配置文件中解密属性。

**5、** 这两个上下文`共用一个环境`，它是任何Spring应用程序的外部属性的来源。

**6、** bootstrap 里面的属性会`优先加载`，它们默认也不能被本地相同配置覆盖。

**7、** boostrap 由父 ApplicationContext 加载，`比 applicaton 优先加载`

**8、** boostrap 里面的属性`不能被覆盖`


### 11、各服务之间通信，对Restful和Rpc这2种方式如何做选择？
### 12、SpringCloud Config 可以实现实时刷新吗？
### 13、Spring Framework 中有多少个模块，它们分别是什么？
### 14、spring-boot-starter-parent有什么用？
### 15、常用网关框架有那些？
### 16、您使用了哪些 starter maven 依赖项？
### 17、spring JDBC API 中存在哪些类？
### 18、Spring MVC的优点
### 19、什么是凝聚力？
### 20、在使用微服务架构时，您面临哪些挑战？
### 21、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 22、架构师在微服务架构中的角色是什么？
### 23、使用Spring框架的好处是什么？
### 24、可以通过多少种方式完成依赖注入？
### 25、SpringData 项目所支持的关系数据存储技术：
### 26、什么是 JavaConfig？
### 27、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 28、什么是 Hystrix？
### 29、什么是Spring Batch？
### 30、什么是 Spring Cloud Bus？
### 31、微服务有什么特点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
