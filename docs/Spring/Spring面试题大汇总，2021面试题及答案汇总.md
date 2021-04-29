# Spring面试题大汇总，2021面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?

思考一下在你的虚拟机上部署应用程序需要些什么。

第一步：安装 Java

第二部：安装 Web 或者是应用程序的服务器（Tomat/Wbesphere/Weblogic 等等）

第三部：部署应用程序 war 包

如果我们想简化这些步骤，应该如何做呢？

让我们来思考如何使服务器成为应用程序的一部分？

你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了，

是不是很爽？

这个想法是嵌入式服务器的起源。

当我们创建一个可以部署的应用程序的时候，我们将会把服务器（例如，tomcat）嵌入到可部署的服务器中。

例如，对于一个 SpringBoot 应用程序来说，你可以生成一个包含 Embedded Tomcat 的应用程序 jar。你就可以像运行正常 Java 应用程序一样来运行 web 应用程序了。

嵌入式服务器就是我们的可执行单元包含服务器的二进制文件（例如，tomcat.jar）。


### 2、解释JDBC抽象和DAO模块。

通过使用JDBC抽象和DAO模块，保证数据库代码的简洁，并能避免数据库资源错误关闭导致的问题，它在各种不同的数据库的错误信息之上，提供了一个统一的异常访问层。它还利用Spring的AOP 模块给Spring应用中的对象提供事务管理服务。


### 3、SpringBoot 需要独立的容器运行吗？

可以不需要，内置了 Tomcat/ Jetty 等容器。


### 4、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？

WebMvcTest注释用于单元测试Spring MVC应用程序。我们只想启动ToTestController。执行此单元测试时，不会启动所有其他控制器和映射。

```
@WebMvcTest(value = ToTestController.class, secure = false):
```


### 5、单片，SOA和微服务架构有什么区别？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_7.png#alt=img%5C_7.png)

图6： 单片SOA和微服务之间的比较 – 微服务访谈问题

单片架构类似于大容器，其中应用程序的所有软件组件组装在一起并紧密封装。

一个面向服务的架构是一种相互通信服务的集合。通信可以涉及简单的数据传递，也可以涉及两个或多个协调某些活动的服务。

微服务架构是一种架构风格，它将应用程序构建为以业务域为模型的小型自治服务集合。


### 6、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston | 1.5.x |



### 7、spring 中有多少种 IOC 容器？

BeanFactory - BeanFactory 就像一个包含 bean 集合的工厂类。它会在客户端要求时实例化 bean。

ApplicationContext - ApplicationContext 接口扩展了 BeanFactory 接口。它在 BeanFactory 基础上提供了一些额外的功能。


### 8、自动装配有什么局限？
### 9、Ribbon底层实现原理
### 10、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 11、如何集成SpringBoot和ActiveMQ？
### 12、XMLBeanFactory
### 13、Spring Cloud和SpringBoot版本对应关系
### 14、Async异步调用方法
### 15、微服务架构的优缺点是什么？
### 16、SpringBoot 实现热部署有哪几种方式？
### 17、一个 Spring Bean 定义 包含什么？
### 18、什么是Spring的内部bean？
### 19、PACT在微服务架构中的用途是什么？
### 20、您对微服务架构中的语义监控有何了解？
### 21、Spring Cloud 实现服务注册和发现的原理是什么？
### 22、[@Required ](/Required ) 注解
### 23、在微服务中，如何保护服务?
### 24、Spring AOP and AspectJ AOP 有什么区别？
### 25、什么是领域驱动设计？
### 26、如何使用 SpringBoot 自动重装我的应用程序？
### 27、什么是 AOP 目标对象?
### 28、什么是Spring Initializer?
### 29、什么是Apache Kafka？
### 30、Spring MVC怎么样设定重定向和转发的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
