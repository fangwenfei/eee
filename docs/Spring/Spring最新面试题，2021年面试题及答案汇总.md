# Spring最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、保护 SpringBoot 应用有哪些方法？

在生产中使用HTTPS 使用Snyk检查你的依赖关系 升级到最新版本 启用CSRF保护 使用内容安全策略防止XSS攻击



### 2、Spring MVC的异常处理？



可以将异常抛给Spring框架，由Spring框架来处理；我们只需要配置简单的异常处理器，在异常处理器中添视图页面即可。


### 3、一个Spring的应用看起来象什么？

**1、** 一个定义了一些功能的接口。

**2、** 这实现包括属性，它的Setter ， getter 方法和函数等。

**3、** Spring AOP

**4、** Spring 的XML 配置文件

**5、** 使用以上功能的客户端程序


### 4、什么是 Hystrix 断路器？我们需要它吗？

由于某些原因，employee-consumer 公开服务会引发异常。在这种情况下使用 Hystrix 我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_13.png#alt=45%5C_13.png)

中断，并且员工使用者将一起跳过 firtsPage 方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_14.png#alt=45%5C_14.png)


### 5、Spring MVC怎么和AJAX相互调用的？

通过Jackson框架就可以把Java里面的对象直接转化成Js可以识别的Json对象。具体步骤如下 ：

**1、** 加入Jackson.jar

**2、** 在配置文件中配置json的映射

**3、** 在接受Ajax方法里面可以直接返回Object,List等,但方法前面要加上@ResponseBody注解。


### 6、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架。


### 7、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

**1、** 配置变更

**2、** JDK 版本升级

**3、** 第三方类库升级

**4、** 响应式 Spring 编程支持

**5、** HTTP/2 支持

**6、** 配置属性绑定

**7、** 更多改进与加强…


### 8、解释基于XML Schema方式的切面实现。

在这种情况下，切面由常规类以及基于XML的配置实现。


### 9、如何在自定义端口上运行SpringBoot应用程序？

为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。

```
 server.port = 8090
```


### 10、SpringBoot常用的starter有哪些？

**1、** spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、** spring-boot-starter-data-jpa 数据库支持

**3、** spring-boot-starter-data-Redis Redis数据库支持

**4、** spring-boot-starter-data-solr solr支持

**5、** mybatis-spring-boot-starter 第三方的mybatis集成starter


### 11、如何覆盖SpringBoot项目的默认属性？
### 12、如何使用SpringBoot实现异常处理?
### 13、@RestController和@Controller的区别
### 14、BeanFactory – BeanFactory 实现举例。
### 15、SpringBoot和SpringCloud的区别？
### 16、解释基于注解的切面实现
### 17、SpringBoot 实现热部署有哪几种方式？
### 18、什么是Idempotence以及它在哪里使用？
### 19、[@Qualifier ](/Qualifier ) 注解
### 20、spring bean 容器的生命周期是什么样的？
### 21、Spring Cloud 实现服务注册和发现的原理是什么？
### 22、什么是幂等性?它是如何使用的？
### 23、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 24、创建一个 SpringBoot Project 的最简单的方法是什么？
### 25、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 26、spring 中有多少种 IOC 容器？
### 27、Spring IoC 的实现机制。
### 28、为什么需要学习Spring Cloud
### 29、您将如何在微服务上执行安全测试？
### 30、Spring Cloud Security
### 31、SpringBoot 实现热部署有哪几种方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
