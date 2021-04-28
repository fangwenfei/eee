# Spring面试题及答案整理汇总，2021年最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot需要独立的容器运行？

SpringBoot不需要独立的容器就可以运行，因为在SpringBoot工程发布的jar文件里已经包含了tomcat的jar文件。SpringBoot运行的时候会创建tomcat对象，实现web服务功能。也可以将SpringBoot发布成war文件，放到tomcat文件里面运行


### 2、Spring Cloud Sleuth

在微服务中，通常根据业务模块分服务，项目中前端发起一个请求，后端可能跨几个服务调用才能完成这个请求（如下图）。如果系统越来越庞大，服务之间的调用与被调用关系就会变得很复杂，假如一个请求中需要跨几个服务调用，其中一个服务由于网络延迟等原因挂掉了，那么这时候我们需要分析具体哪一个服务出问题了就会显得很困难。Spring Cloud Sleuth服务链路跟踪功能就可以帮助我们快速的发现错误根源以及监控分析每条请求链路上的性能等等。 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/023/45/68_1.png#alt=68%5C_1.png)


### 3、Spring Cloud和各子项目版本对应关系

**1、** Edgware.SR6：我理解为最低版本号

**2、** Greenwich.SR2 :我理解为最高版本号

**3、** Greenwich.BUILD-SNAPSHOT（快照）：是一种特殊的版本，指定了某个当前的开发进度的副本。不同于常规的版本，几乎每天都要提交更新的版本，如果每次提交都申明一个版本号那不是版本号都不够用？

| Component | Edgware.SR6 | Greenwich.SR2 | Greenwich.BUILD-SNAPSHOT |
| --- | --- | --- | --- |
| spring-cloud-aws | 1.2.4.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-bus | 1.3.4.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-cli | 1.4.1.RELEASE | 2.0.0.RELEASE | 2.0.1.BUILD-SNAPSHOT |
| spring-cloud-commons | 1.3.6.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-contract | 1.2.7.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-config | 1.4.7.RELEASE | 2.1.3.RELEASE | 2.1.4.BUILD-SNAPSHOT |
| spring-cloud-netflix | 1.4.7.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-security | 1.2.4.RELEASE | 2.1.3.RELEASE | 2.1.4.BUILD-SNAPSHOT |
| spring-cloud-cloudfoundry | 1.1.3.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-consul | 1.3.6.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-sleuth | 1.3.6.RELEASE | 2.1.1.RELEASE | 2.1.2.BUILD-SNAPSHOT |
| spring-cloud-stream | Ditmars.SR5 | Fishtown.SR3 | Fishtown.BUILD-SNAPSHOT |
| spring-cloud-zookeeper | 1.2.3.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-boot | 1.5.21.RELEASE | 2.1.5.RELEASE | 2.1.8.BUILD-SNAPSHOT |
| spring-cloud-task | 1.2.4.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-vault | 1.1.3.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-gateway | 1.0.3.RELEASE | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |
| spring-cloud-openfeign | 2.1.2.RELEASE | 2.1.3.BUILD-SNAPSHOT |  |
| spring-cloud-function | 1.0.2.RELEASE | 2.0.2.RELEASE | 2.0.3.BUILD-SNAPSHOT |


### 4、SpringBoot 有哪几种读取配置的方式？

- `@PropertySource`
- `@Value`
- `@Environment`
- `@ConfigurationPropertie`


### 5、如何启用/禁用执行器？

启用/禁用致动器很容易；最简单的方法是使特性能够将依赖项(Maven/Gradle)添加到spring-boot-starter-actuator，即启动器。如果不想启用致动器，那么就不要添加依赖项。

Maven依赖项：

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>
```


### 6、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用

来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 7、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

**1、** 依赖 JDK 版本升级：2.x 里面的许多方法应用了 JDK 8 的许多高级新特性，至少需要 JDK 8 的支持；

**2、** 第三方类库升：2.x 对第三方类库升级了所有能升级的稳定版本，例如：Spring Framework 5+、Tomcat 8.5+、Hibernate 5.2+、Thymeleaf 3+；

**3、** 响应式 Spring 编程：2.x 通过启动器和自动配置全面支持 Spring 的响应式编程，响应式编程是完全异步和非阻塞的，它是基于事件驱动模型，而不是传统的线程模型；

**4、** 连接池：2.x 默认使用 HikariCP 连接池；

**5、** json：提供了一个 spring-boot-starter-json 启动器对 JSON 读写的支持；

**6、** Quartz：2.x 提供了一个 spring-boot-starter-quartz 启动器对定时任务框架 Quartz 的支持；

**7、** HTTP/2 支持：提供对HTTP/2 的支持，如：Tomcat, Undertow, Jetty；

**8、** Actuator加强：在 2.x 中，对执行器端点进行了许多改进，所有的 HTTP 执行端点现在都暴露在 /actuator路径下，并对 JSON 结果集也做了改善。


### 8、Spring MVC用什么对象从后台向前台传递数据的？



通过ModelMap对象,可以在这个对象里面调用put方法,把对象加到里面,前台就可以通过el表达式拿到。


### 9、第⼀层缓存：

readOnlyCacheMap，本质上是ConcurrentHashMap：这是⼀个JVM的CurrentHashMap只读缓存，这个主要是为了供客户端获取注册信息时使⽤，其缓存更新，依赖于定时器的更新，通过和readWriteCacheMap 的值做对⽐，如果数据不⼀致，则以readWriteCacheMap 的数据为准。readOnlyCacheMap 缓存更新的定时器时间间隔，默认为30秒

#
### 10、[@RequestMapping ](/RequestMapping ) 注解

该注解是用来映射一个URL到一个类或一个特定的方处理法上。



### 11、spring cloud 和dubbo区别?
### 12、什么是 SpringBoot？
### 13、什么是SpringBoot ？
### 14、什么是 Spring 配置文件？
### 15、如何实现动态Zuul网关路由转发
### 16、Eureka怎么实现高可用
### 17、PACT如何运作？
### 18、为什么要用SpringBoot
### 19、什么是自动配置？
### 20、微服务之间是如何独立通讯的?
### 21、微服务的缺点：
### 22、什么是端到端微服务测试？
### 23、如何使用 SpringBoot 自动重装我的应用程序？
### 24、什么是 spring bean？
### 25、第⼆层缓存：
### 26、为什么我们需要 spring-boot-maven-plugin?
### 27、SpringBoot自动配置的原理是什么？
### 28、SpringBoot 中的监视器是什么？
### 29、Spring Cloud Task
### 30、什么是编织（Weaving）？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
