# Spring高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是CSRF攻击？

CSRF代表跨站请求伪造。这是一种攻击，迫使最终用户在当前通过身份验证的Web应用程序上执行不需要的操作。CSRF攻击专门针对状态改变请求，而不是数据窃取，因为攻击者无法查看对伪造请求的响应。


### 2、SpringBoot自动配置的原理

在spring程序main方法中 添加@SpringBootApplication或者@EnableAutoConfiguration

会自动去maven中读取每个starter中的spring.factories文件 该文件里配置了所有需要被创建spring容器中的bean


### 3、SpringBoot 中如何实现定时任务 ?

定时任务也是一个常见的需求，SpringBoot 中对于定时任务的支持主要还是来自 Spring 框架。

在 SpringBoot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 [@Scheduled ](/Scheduled ) 注解，另一个则是使用第三方框架 Quartz。

使用 Spring 中的 [@Scheduled ](/Scheduled ) 的方式主要通过 [@Scheduled ](/Scheduled ) 注解来实现。

使用 Quartz ，则按照 Quartz 的方式，定义 Job 和 Trigger 即可。



### 4、SpringCloud的优缺点

**优点：**

**1、** 耦合度比较低。不会影响其他模块的开发。

**2、** 减轻团队的成本，可以并行开发，不用关注其他人怎么开发，先关注自己的开发。

**3、** 配置比较简单，基本用注解就能实现，不用使用过多的配置文件。

**4、** 微服务跨平台的，可以用任何一种语言开发。

**5、** 每个微服务可以有自己的独立的数据库也有用公共的数据库。

**6、** 直接写后端的代码，不用关注前端怎么开发，直接写自己的后端代码即可，然后暴露接口，通过组件进行服务通信。

**缺点：**

1、部署比较麻烦，给运维工程师带来一定的麻烦。

2、针对数据的管理比麻烦，因为微服务可以每个微服务使用一个数据库。

3、系统集成测试比较麻烦

4、性能的监控比较麻烦。【最好开发一个大屏监控系统】

总的来说优点大过于缺点，目前看来Spring Cloud是一套非常完善的分布式框架，目前很多企业开始用微服务、Spring Cloud的优势是显而易见的。因此对于想研究微服务架构的同学来说，学习Spring Cloud是一个不错的选择。


### 5、Spring MVC 框架有什么用？

Spring Web MVC 框架提供 模型-视图-控制器 架构和随时可用的组件，用于开发灵活且松散耦合的 Web 应用程序。MVC 模式有助于分离应用程序的不同方面，如输入逻辑，业务逻辑和 UI 逻辑，同时在所有这些元素之间提供松散耦合。


### 6、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？

在 SpringBoot 项目中，当你确保下面的依赖项都在类路里面的时候，你可以加载 H2 控制台。

web 启动器

h2

jpa 数据启动器

**其它的依赖项在下面：**

需要注意的一些地方：

一个内部数据内存只在应用程序执行期间存在。这是学习框架的有效方式。

这不是你希望的真是世界应用程序的方式。

在问题“如何连接一个外部数据库？”中，我们解释了如何连接一个你所选择的数据库。


### 7、微服务同时调用多个接口，怎么支持事务的啊？

支持分布式事务，可以使用SpringBoot集成 Aatomikos来解决，但是我一般不建议这样使用，因为使用分布式事务会增加请求的响应时间，影响系统的TPS。一般在实际工作中，会利用消息的补偿机制来处理分布式的事务。


### 8、SpringBoot 中的 starter 到底是什么 ?

首先，这个 Starter 并非什么新的技术点，基本上还是基于 Spring 已有功能来实现的。首先它提供了一个自动化配置类，一般命名为 `XXXAutoConfiguration` ，在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，然后通过类型安全的属性(spring、factories)注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。正因为如此，很多第三方框架，我们只需要引入依赖就可以直接使用了。当然，开发者也可以自定义 Starter


### 9、SpringBoot 需要独立的容器运行吗？

可以不需要，内置了 Tomcat/ Jetty 等容器。


### 10、Spring MVC怎么样设定重定向和转发的？

**转发：**

在返回值前面加"forward:"，譬如"forward:user.do?name=method4"

**重定向：**

在返回值前面加"redirect:"，譬如"redirect:[www.baidu.com](http://www.baidu.com)"


### 11、Spring 应用程序有哪些不同组件？
### 12、bootstrap.yml和application.yml有什么区别?
### 13、dubbo服务注册与发现原理
### 14、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 15、如何实现SpringBoot应用程序的安全性？
### 16、Spring MVC的优点
### 17、什么是切点（JoinPoint）
### 18、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 19、哪些是重要的bean生命周期方法？你能重载它们吗？
### 20、如何在自定义端口上运行 SpringBoot 应用程序？
### 21、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 22、Ribbon和Feign的区别？
### 23、创建一个 SpringBoot Project 的最简单的方法是什么？
### 24、如何理解 Spring 中的代理？
### 25、介绍一下 WebApplicationContext
### 26、如何解决POST请求中文乱码问题，GET的又如何处理呢？
### 27、什么是JavaConfig？
### 28、SpringCloud由什么组成
### 29、有几种不同类型的自动代理？
### 30、怎么样把ModelMap里面的数据放入Session里面？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
