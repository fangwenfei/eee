# Spring最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、SpringBoot常用的starter有哪些？

**1、** spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、** spring-boot-starter-data-jpa 数据库支持

**3、** spring-boot-starter-data-Redis Redis数据库支持

**4、** spring-boot-starter-data-solr solr支持

**5、** mybatis-spring-boot-starter 第三方的mybatis集成starter


### 2、SpringCloud Config 可以实现实时刷新吗？

springcloud config实时刷新采用SpringCloud Bus消息总线。


### 3、什么是Swagger？你用SpringBoot实现了它吗？

Swagger广泛用于可视化API，使用Swagger UI为前端开发人员提供在线沙箱。Swagger是用于生成RESTful Web服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过Swagger正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。


### 4、什么是代理?

代理是通知目标对象后创建的对象。从客户端的角度看，代理对象和目标对象是一样的。


### 5、运行 SpringBoot 有哪几种方式？

**1、** 打包成 Fat Jar ，直接使用 java -jar 运行。目前主流的做法，推荐。

**2、** 在 IDEA 或 Eclipse 中，直接运行应用的 SpringBoot 启动类的 #main(String[] args 启动。适用于开发调试场景。

**3、** 如果是 Web 项目，可以打包成 War 包，使用外部 Tomcat 或 Jetty 等容器。


### 6、如何使用 SpringBoot 实现异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 7、什么是领域驱动设计？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_10.png#alt=img%5C_10.png)

图8：  DDD原理 – 微服务面试问题


### 8、服务雪崩？

简介：服务雪崩效应是⼀种因服务提供者的不可⽤导致服务调⽤者的不可⽤,并将不可⽤逐渐放⼤的过程.

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_12.png#alt=45%5C_12.png)

**形成原因**

**1、** 服务提供者不可

**2、** 重试加⼤流量

**3、** 服务调⽤者不可⽤

**采⽤策略**

**1、** 流量控制

**2、** 改进缓存模式

**3、** 服务⾃动扩容

**4、** 服务调⽤者降级服务


### 9、微服务有哪些特点？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_3.png#alt=img%5C_3.png)

图3：微服务的 特点 – 微服务访谈问题

解耦 – 系统内的服务很大程度上是分离的。因此，整个应用程序可以轻松构建，更改和扩展

组件化 – 微服务被视为可以轻松更换和升级的独立组件

业务能力 – 微服务非常简单，专注于单一功能

自治 – 开发人员和团队可以彼此独立工作，从而提高速度

持续交付 – 通过软件创建，测试和批准的系统自动化，允许频繁发布软件

责任 – 微服务不关注应用程序作为项目。相反，他们将应用程序视为他们负责的产品

分散治理 – 重点是使用正确的工具来做正确的工作。这意味着没有标准化模式或任何技术模式。开发人员可以自由选择最有用的工具来解决他们的问题

敏捷 – 微服务支持敏捷开发。任何新功能都可以快速开发并再次丢弃


### 10、我们如何进行跨功能测试？

跨功能测试是对非功能性需求的验证，即那些无法像普通功能那样实现的需求。


### 11、使用Spring框架的好处是什么？
### 12、什么是DispatcherServlet
### 13、介绍一下 WebApplicationContext
### 14、如何在SpringBoot应用程序中实现Spring安全性？
### 15、你怎样定义类的作用域?
### 16、常用网关框架有那些？
### 17、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 18、如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？
### 19、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 20、列举 IoC 的一些好处。
### 21、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 22、Spring 应用程序有哪些不同组件？
### 23、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 24、负载均衡的意义是什么?
### 25、SpringBoot 有哪几种读取配置的方式？
### 26、为什么我们需要微服务容器？
### 27、Spring Cloud Consul
### 28、SpringBoot的配置文件有哪几种格式？区别是什么？
### 29、Spring MVC 框架有什么用？
### 30、过渡到微服务时的常见错误
### 31、运行 SpringBoot 有哪几种方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
