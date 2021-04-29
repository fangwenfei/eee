# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、可以通过多少种方式完成依赖注入？

**通常，依赖注入可以通过三种方式完成，即：**

**1、** 构造函数注入

**2、** setter 注入

**3、** 接口注入

在 Spring Framework 中，仅使用构造函数和 setter 注入。


### 2、什么是 Spring Framework？

Spring 是一个开源应用框架，旨在降低应用程序开发的复杂度。它是轻量级、松散耦合的。它具有分层体系结构，允许用户选择组件，同时还为 J2EE 应用程序开发提供了一个有凝聚力的框架。它可以集成其他框架，如 Structs、Hibernate、EJB 等，所以又称为框架的框架。


### 3、解释基于注解的切面实现

在这种情况下(基于@AspectJ的实现)，涉及到的切面声明的风格与带有java5标注的普通java类一致。


### 4、谈一下领域驱动设计

主要关注核心领域逻辑。基于领域的模型检测复杂设计。这涉及与公司层面领域方面的专家定期合作，以解决与领域相关的问题并改进应用程序的模型。在回答这个微服务面试问题时，您还需要提及DDD的核心基础知识。他们是：

**1、** DDD主要关注领域逻辑和领域本身。

**2、** 复杂的设计完全基于领域的模型。

**3、** 为了改进模型的设计并解决任何新出现的问题，DDD不断与公司领域方面的专家合作。


### 5、什么是WebSockets？

WebSocket是一种计算机通信协议，通过单个TCP连接提供全双工通信信道。

![img_2.png][img_0826_04_2.png]

**1、** WebSocket是双向的 -使用WebSocket客户端或服务器可以发起消息发送。

**2、** WebSocket是全双工的 -客户端和服务器通信是相互独立的。

**3、** 单个TCP连接 -初始连接使用HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所有未来的通信

**4、** Light -与http相比，WebSocket消息数据交换要轻得多。


### 6、什么是 AOP什么是目标对象?

被一个或者多个切面所通知的对象。它通常是一个代理对象。也指被通知（advised）对象。


### 7、@RequestMapping注解的作用

RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。

RequestMapping注解有六个属性，下面我们把她分成三类进行说明（下面有相应示例）。

**value， method**

**1、** value： 指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；

**2、** method： 指定请求的method类型， GET、POST、PUT、DELETE等；

**consumes，produces**

**1、** consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;

**2、** produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

**params，headers**

**1、** params： 指定request中必须包含某些参数值是，才让该方法处理。

**2、** headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求。


### 8、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。


### 9、Spring Cloud OpenFeign

基于Ribbon和Hystrix的声明式服务调用组件，可以动态创建基于Spring MVC注解的接口实现用于服务调用，在Spring Cloud 2.0中已经取代Feign成为了一等公民。

Spring Cloud的版本关系

Spring Cloud是一个由许多子项目组成的综合项目，各子项目有不同的发布节奏。为了管理Spring Cloud与各子项目的版本依赖关系，发布了一个清单，其中包括了某个Spring Cloud版本对应的子项目版本。

为了避免Spring Cloud版本号与子项目版本号混淆，Spring Cloud版本采用了名称而非版本号的命名，这些版本的名字采用了伦敦地铁站的名字，根据字母表的顺序来对应版本时间顺序，例如Angel是第一个版本，Brixton是第二个版本。

当Spring Cloud的发布内容积累到临界点或者一个重大BUG被解决后，会发布一个"service releases"版本，简称SRX版本，比如Greenwich.SR2就是Spring Cloud发布的Greenwich版本的第2个SRX版本。目前Spring Cloud的最新版本是Hoxton。


### 10、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 11、springcloud和dubbo有哪些区别
### 12、什么是持续监测？
### 13、如何在自定义端口上运行 SpringBoot应用程序?
### 14、Spring Cloud Sleuth
### 15、Spring MVC常用的注解有哪些？
### 16、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 17、Spring Cloud Bus
### 18、Docker的目的是什么？
### 19、SpringBoot 自动配置原理是什么？
### 20、什么是客户证书？
### 21、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 22、什么是基于Java的Spring注解配置? 给一些注解的例子.
### 23、SpringBoot 配置文件的加载顺序
### 24、SpringBoot如何实现打包
### 25、不同版本的 Spring Framework 有哪些主要功能？
### 26、eureka服务注册与发现原理
### 27、Spring MVC怎么样设定重定向和转发的？
### 28、spring boot监听器流程?
### 29、微服务的缺点：
### 30、指出在 spring aop 中 concern 和 cross-cutting concern 的不同之处。
### 31、什么是服务降级




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
