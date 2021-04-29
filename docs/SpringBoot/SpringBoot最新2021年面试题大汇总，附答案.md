# SpringBoot最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何在自定义端口上运行SpringBoot应用程序？

为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。

```
 server.port = 8090
```


### 2、SpringBoot 自动配置原理是什么？

注解 @EnableAutoConfiguration, @Configuration, [@ConditionalOnClass ](/ConditionalOnClass ) 就是自动配置的核心，首先它得是一个配置文件，其次根据类路径下是否有这个类去自动配置。


### 3、SpringBoot如何配置log4j？

在引用log4j之前，需要先排除项目创建时候带的日志，因为那个是Logback，然后再引入log4j的依赖，引入依赖之后，去src/main/resources目录下的log4j-spring.properties配置文件，就可以开始对应用的日志进行配置使用。


### 4、SpringBoot常用的starter有哪些?

**1、** `spring-boot-starter-web` (嵌入tomcat和web开发需要servlet与jsp支持)

**2、** `spring-boot-starter-data-jpa` (数据库支持)

**3、** `spring-boot-starter-data-Redis` (Redis数据库支持)

**4、** `spring-boot-starter-data-solr` (solr搜索应用框架支持)

**5、** `mybatis-spring-boot-starter` (第三方的mybatis集成starter)


### 5、SpringBoot的缺点

我觉得是为难人，SpringBoot在目前我觉得没有什么缺点，非要找一个出来我觉得就是

由于不用自己做的配置，报错时很难定位。


### 6、如何在 SpringBoot 中禁用 Actuator 端点安全性？

默认情况下，所有敏感的 HTTP 端点都是安全的，只有具有 ACTUATOR 角色的用户才能访问它们。安全性是使用标准的 HttpServletRequest.isUserInRole 方法实施的。我们可以使用来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 7、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用

依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 8、SpringBoot 配置文件的加载顺序
### 9、在 Spring Initializer 中，如何改变一个项目的包名字？
### 10、SpringBoot 实现热部署有哪几种方式？
### 11、什么是 SpringBoot？
### 12、为什么要用SpringBoot
### 13、spring-boot-starter-parent有什么用？
### 14、什么是SpringBoot？
### 15、SpringBoot 还提供了其它的哪些 Starter Project Options？
### 16、如何使用 SpringBoot 实现全局异常处理？
### 17、什么是SpringBoot
### 18、运行 SpringBoot 有哪几种方式？
### 19、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 20、SpringBoot 日志框架：
### 21、SpringBoot如何实现打包
### 22、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 23、如何在自定义端口上运行 SpringBoot应用程序?
### 24、如何实现 SpringBoot应用程序的安全性?
### 25、什么是 Spring Batch？
### 26、你如何理解 SpringBoot 中的 Starters？
### 27、如何启用/禁用执行器？
### 28、如何实现SpringBoot应用程序的安全性？
### 29、YAML 配置的优势在哪里 ?
### 30、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 31、什么是Swagger？你用SpringBoot实现了它吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
