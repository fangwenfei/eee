# Spring面试题大汇总，2021年附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是Hystrix？它如何实现容错？

Hystrix是一个延迟和容错库，旨在隔离远程系统，服务和第三方库的访问点，当出现故障是不可避免的故障时，停止级联故障并在复杂的分布式系统中实现弹性。

通常对于使用微服务架构开发的系统，涉及到许多微服务。这些微服务彼此协作。

思考以下微服务

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_2.png#alt=img%5C_2.png)

假设如果上图中的微服务9失败了，那么使用传统方法我们将传播一个异常。但这仍然会导致整个系统崩溃。

随着微服务数量的增加，这个问题变得更加复杂。微服务的数量可以高达1000.这是hystrix出现的地方 我们将使用Hystrix在这种情况下的Fallback方法功能。我们有两个服务employee-consumer使用由employee-consumer公开的服务。

简化图如下所示

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_3.png#alt=img%5C_3.png)

现在假设由于某种原因，employee-producer公开的服务会抛出异常。我们在这种情况下使用Hystrix定义了一个回退方法。这种后备方法应该具有与公开服务相同的返回类型。如果暴露服务中出现异常，则回退方法将返回一些值。


### 2、解释Spring支持的几种bean的作用域。

**Spring框架支持以下五种bean的作用域：**

**1、** singleton : bean在每个Spring ioc 容器中只有一个实例。

**2、** prototype：一个bean的定义可以有多个实例。

**3、** request：每次http请求都会创建一个bean，该作用域仅在基于web的Spring ApplicationContext情形下有效。

**4、** session：在一个HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

**5、** global-session：在一个全局的HTTP Session中，一个bean定义对应一个实例。该作用域仅在基于web的Spring ApplicationContext情形下有效。

缺省的Spring bean 的作用域是Singleton.


### 3、Spring Cloud Gateway

Spring cloud gateway是spring官方基于Spring 5.0、SpringBoot2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供简单、有效和统一的API路由管理方式，Spring Cloud Gateway作为Spring Cloud生态系统中的网关，目标是替代Netflix Zuul，其不仅提供统一的路由方式，并且还基于Filer链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等。


### 4、如何在自定义端口上运行 SpringBoot应用程序?

在 `application.properties`中指定端口`serverport=8090`。


### 5、微服务限流 http限流：我们使⽤nginx的limitzone来完成：

```
//这个表示使⽤ip进⾏限流 zone名称为req_one 分配了10m 空间使⽤漏桶算法 每秒钟允许1个请求
limit_req_zone $binary_remote_addr zone=req_one:10m rate=1r/s; //这边burst表示可以瞬间超过20个请求 由于没有noDelay参数因此需要排队 如果超过这20个那么直接返回503
limit_req zone=req_three burst=20;
```


### 6、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）

**1、** 继承Spring-boot-start-parent项目

**2、** 导入Spring-boot-dependencies项目依赖


### 7、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量


### 8、服务雪崩效应产生的原因

因为Tomcat默认情况下只有一个线程池来维护客户端发送的所有的请求，这时候某一接口在某一时刻被大量访问就会占据tomcat线程池中的所有线程，其他请求处于等待状态，无法连接到服务接口。


### 9、列举 Spring Framework 的优点。

**1、** 由于 Spring Frameworks 的分层架构，用户可以自由选择自己需要的组件。

**2、** Spring Framework 支持 POJO(Plain Old Java Object) 编程，从而具备持续集成和可测试性。

**3、** 由于依赖注入和控制反转，JDBC 得以简化。

**4、** 它是开源免费的。


### 10、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？

是的，可以使用starter依赖项将嵌入式Tomcat替换为任何其他服务器。可以根据需要使用SpringBootStarter Jetty或SpringBootStarter作为每个项目的依赖项。


### 11、保护 SpringBoot 应用有哪些方法？
### 12、Spring Cloud Security
### 13、使用 SpringBoot 开发分布式微服务时，我们面临什么问题
### 14、什么是Spring Actuator？它有什么优势？
### 15、SpringBoot 配置文件的加载顺序
### 16、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 17、什么是Spring的内部bean？
### 18、什么是FreeMarker模板？
### 19、SOA和微服务架构之间的主要区别是什么？
### 20、Spring Cloud和SpringBoot版本对应关系
### 21、AOP 有哪些实现方式？
### 22、区分 BeanFactory 和 ApplicationContext。
### 23、什么是微服务架构
### 24、微服务测试的主要障碍是什么？
### 25、Spring MVC用什么对象从后台向前台传递数据的？
### 26、什么是 Hystrix？
### 27、服务雪崩？
### 28、bootstrap.yml和application.yml有什么区别?
### 29、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？
### 30、如何实现 SpringBoot应用程序的安全性?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
