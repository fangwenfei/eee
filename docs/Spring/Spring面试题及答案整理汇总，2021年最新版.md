# Spring面试题及答案整理汇总，2021年最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?

SpringBoot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 `java -jar xxx、jar` 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

SpringBoot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 SpringBoot 打包成的可执行 jar 解压后，在 `\BOOT-INF\classes` 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom、xml 文件中增加配置，将 SpringBoot 项目打包成两个 jar ，一个可执行，一个可引用。


### 2、什么是Eureka的自我保护模式，

默认情况下，如果Eureka Service在一定时间内没有接收到某个微服务的心跳，Eureka Service会进入自我保护模式，在该模式下Eureka Service会保护服务注册表中的信息，不在删除注册表中的数据，当网络故障恢复后，Eureka Servic 节点会自动退出自我保护模式


### 3、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

配置变更

JDK 版本升级

第三方类库升级

响应式 Spring 编程支持

HTTP/2 支持

配置属性绑定

更多改进与加强…


### 4、SpringBoot读取配置文件的方式

SpringBoot默认读取配置文件为application.properties或者是application.yml


### 5、开启 SpringBoot 特性有哪几种方式？

**1、**  继承spring-boot-starter-parent项目

**2、**  导入spring-boot-dependencies项目依赖


### 6、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?

是的，更改端口是可行的。可以使用application.properties文件更改端口。但需要提到“server.port”（即server.port=8081）。确保项目类路径中有application.properties；后续工作将由REST Spring框架接手。如果提到server.port=0，那么它将自动分配任何可用的端口。


### 7、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是SpringBoot的核心注解，主要组合包含了以下3个注解：

**1、** @SpringBootConfiguration：组合了@Configuration注解，实现配置文件的功能。

**2、** @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

**3、** @ComponentScan：Spring组件扫描


### 8、什么是Spring引导的执行器？

SpringBoot执行程序提供了restful Web服务，以访问生产环境中运行应用程序的当前状态。在执行器的帮助下，您可以检查各种指标并监控您的应用程序。


### 9、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。

GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


### 10、Spring对DAO的支持

Spring对数据访问对象（DAO）的支持旨在简化它和数据访问技术如JDBC，Hibernate or JDO 结合使用。这使我们可以方便切换持久层。编码时也不用担心会捕获每种技术特有的异常。


### 11、注解原理是什么
### 12、如何使用 SpringBoot 部署到不同的服务器？
### 13、SpringBoot 中如何解决跨域问题 ?
### 14、什么是 SpringBoot？
### 15、什么是 AOP？
### 16、可以通过多少种方式完成依赖注入？
### 17、如何使用SpringBoot实现分页和排序？
### 18、SpringBoot中的监视器是什么?
### 19、什么是执行器停机？
### 20、DispatcherServlet
### 21、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 22、谈谈服务降级、熔断、服务隔离
### 23、过渡到微服务时的常见错误
### 24、您对Distributed Transaction有何了解？
### 25、什么是自动配置？
### 26、spring-boot-starter-parent 有什么用 ?
### 27、为什么我们需要 spring-boot-maven-plugin?
### 28、什么是 SpringBoot Stater ？
### 29、RequestMapping 和 GetMapping 的不同之处在哪里？
### 30、如果想在拦截的方法里面得到从前台传入的参数,怎么得到？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
