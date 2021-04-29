# Spring最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

传递给存储库方法。


### 2、在微服务中，如何保护服务?

一般使用使用Hystrix框架，实现服务隔离来避免出现服务的雪崩效应，从而达到保护服务的效果。当微服务中，高并发的数据库访问量导致服务线程阻塞，使单个服务宕机，服务的不可用会蔓延到其他服务，引起整体服务灾难性后果，使用服务降级能有效为不同的服务分配资源,一旦服务不可用则返回友好提示，不占用其他服务资源，从而避免单个服务崩溃引发整体服务的不可用.


### 3、什么是REST / RESTful以及它的用途是什么？

Representational State Transfer（REST）/ RESTful Web服务是一种帮助计算机系统通过Internet进行通信的架构风格。这使得微服务更容易理解和实现。

微服务可以使用或不使用RESTful API实现，但使用RESTful API构建松散耦合的微服务总是更容易。


### 4、什么是幂等性?它是如何使用的？

幂等性指的是这样一种场景:您重复执行一项任务，但最终结果保持不变或类似。 幂等性主要用作数据源或远程服务，当它接收一组以上指令时，它只处理一组指令。



### 5、如何设置服务发现？

有多种方法可以设置服务发现。我将选择我认为效率最高的那个，Netflix的Eureka。这是一个简单的程序，不会对应用程序造成太大影响。此外，它支持多种类型的Web应用程序。 Eureka配置包括两个步骤 - 客户端配置和服务器配置。

使用属性文件可以轻松完成客户端配置。在clas spath中，Eureka搜索一个eureka-client.properties文件。它还搜索由特定于环境的属性文件中的环境引起的覆盖。

对于服务器配置，您必须首先配置客户端。完成后，服务器启动一个客户端，该客户端用于查找其他服务器。。默认情况下，Eureka服务器使用客户端配置来查找对等服务器。


### 6、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

**1、** SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

**2、** application 配置文件这个容易了解，主要用于 SpringBoot 项目的自动化配置。

**3、** bootstrap 配置文件有以下几个应用场景。

**4、** 使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中增加连接到配置中心的配置属性来加载外部配置中心的配置信息；

**5、** 少量固定的不能被覆盖的属性；

**6、** 少量加密/解密的场景；


### 7、eureka服务注册与发现原理

**1、** 每30s发送⼼跳检测重新进⾏租约，如果客户端不能多次更新租约，它将在90s内从服务器注册中⼼移除。

**2、** 注册信息和更新会被复制到其他Eureka 节点，来⾃任何区域的客户端可以查找到注册中⼼信息，每30s发⽣⼀次复制来定位他们的服务，并进⾏远程调⽤。

**3、** 客户端还可以缓存⼀些服务实例信息，所以即使Eureka全挂掉，客户端也是可以定位到服务地址的。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_4.png#alt=45%5C_4.png)


### 8、MVC是什么？MVC设计模式的好处有哪些

mvc是一种设计模式（设计模式就是日常开发中编写代码的一种好的方法和经验的总结）。模型（model）-视图（view）-控制器（controller），三层架构的设计模式。用于实现前端页面的展现与后端业务数据处理的分离。

**mvc设计模式的好处**

**1、** 分层设计，实现了业务系统各个组件之间的解耦，有利于业务系统的可扩展性，可维护性。

**2、** 有利于系统的并行开发，提升开发效率。


### 9、什么是 Spring Data REST?

Spring Data TEST 可以用来关于 Spring 数据库的 HATEOAS RESTful 资源。

不需要写太多代码，我们可以关于 Spring 数据库的 RESTful API。

**下面展示的是一些关于 TEST 服务器的例子**

```
POST:
URL:http：//localhost：8080/todos
Use Header:Content-Type:Type:application/json
Request Content
```


### 10、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。

安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用management.security.enabled = false 来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。

如何在自定义端口上运行SpringBoot应用程序？ 为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。 server.port = 8090


### 11、SpringBoot Starter 的工作原理是什么？
### 12、SpringBoot 实现热部署有哪几种方式？
### 13、谈谈服务雪崩效应
### 14、什么是Eureka
### 15、如何在 spring 中启动注解装配？
### 16、SpringBoot需要独立的容器运行？
### 17、服务注册和发现是什么意思？Spring Cloud如何实现？
### 18、一个Spring的应用看起来象什么？
### 19、什么是 Apache Kafka？
### 20、什么是客户证书？
### 21、康威定律是什么？
### 22、Spring MVC与Struts2区别
### 23、什么是Semantic监控？
### 24、什么是 JavaConfig？
### 25、核心容器（应用上下文) 模块。
### 26、您对Distributed Transaction有何了解？
### 27、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 28、什么是微服务架构
### 29、如何在SpringBoot中禁用Actuator端点安全性？
### 30、为什么要用SpringBoot
### 31、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
