# Spring高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

**1、** SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

**2、** application 配置文件这个容易了解，主要用于 SpringBoot 项目的自动化配置。

**3、** bootstrap 配置文件有以下几个应用场景。

**4、** 使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中增加连接到配置中心的配置属性来加载外部配置中心的配置信息；

**5、** 少量固定的不能被覆盖的属性；

**6、** 少量加密/解密的场景；


### 2、什么是通知（Advice）？

特定 JoinPoint 处的 Aspect 所采取的动作称为 Advice。Spring AOP 使用一个 Advice 作为拦截器，在 JoinPoint “周围”维护一系列的拦截器。


### 3、spring 支持集中 bean scope？

Spring bean 支持 5 种 scope：

**Singleton**

**1、** 每个 Spring IoC 容器仅有一个单实例。Prototype

**2、** 每次请求都会产生一个新的实例。Request

**3、** 每一次 HTTP 请求都会产生一个新的实例，并且该 bean 仅在当前 HTTP 请求内有效。Session

**4、** 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前 HTTP session 内有效。Global-session

**5、** 类似于标准的 HTTP Session 作用域，不过它仅仅在基于 portlet 的 web 应用中才有意义。Portlet 规范定义了全局 Session 的概念，它被所有构成某个 portlet web 应用的各种不同的 portlet 所共享。在 global session 作用域中定义的 bean 被限定于全局 portlet Session 的生命周期范围内。如果你在 web 中使用 global session 作用域来标识 bean，那么 web 会自动当成 session 类型来使用。

仅当用户使用支持 Web 的 ApplicationContext 时，最后三个才可用。


### 4、SpringBoot 中如何解决跨域问题 ?

跨域可以在前端通过 JSONP 来解决，但是 JSONP 只可以发送 GET 请求，无法发送其他类型的请求，在 RESTful 风格的应用中，就显得非常鸡肋，因此我们推荐在后端通过 （CORS，Cross-origin resource sharing） 来解决跨域问题。这种解决方案并非 SpringBoot 特有的，在传统的 SSM 框架中，就可以通过 CORS 来解决跨域问题，只不过之前我们是在 XML 文件中配置 CORS ，现在可以通过实现WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。

```
  @Configuration
  public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
  registry、addMapping("/**")
  、allowedOrigins("*")
  、allowCredentials(true)
  、allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
  、maxAge(3600);
  }

  }
```


### 5、什么是 WebSockets？

WebSocket 是一种计算机通信协议，通过单个 TCP 连接提供全双工通信信道。

**1、** WebSocket 是双向的 -使用 WebSocket 客户端或服务器可以发起消息发送。

**2、** WebSocket 是全双工的 -客户端和服务器通信是相互独立的。

**3、** 单个 TCP 连接 -初始连接使用 HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所有未来的通信

**4、** Light -与 http 相比，WebSocket 消息数据交换要轻得多。


### 6、什么是 AOP 通知

通知是个在方法执行前或执行后要做的动作，实际上是程序执行时要通过SpringAOP框架触发的代码段。

**Spring切面可以应用五种类型的通知：**

before：前置通知，在一个方法执行前被调用。

after: 在方法执行之后调用的通知，无论方法执行是否成功。

after-returning: 仅当方法成功完成后执行的通知。

after-throwing: 在方法抛出异常退出时执行的通知。

around: 在方法执行之前和之后调用的通知。


### 7、什么是基于Java的Spring注解配置? 给一些注解的例子.

基于Java的配置，允许你在少量的Java注解的帮助下，进行你的大部分Spring配置而非通过XML文件。

以[@Configuration ](/Configuration ) 注解为例，它用来标记类可以当做一个bean的定义，被Spring IOC容器使用。另一个例子是@Bean注解，它表示此方法将要返回一个对象，作为一个bean注册进Spring应用上下文。


### 8、SpringBoot如何配置log4j？

在引用log4j之前，需要先排除项目创建时候带的日志，因为那个是Logback，然后再引入log4j的依赖，引入依赖之后，去src/main/resources目录下的log4j-spring.properties配置文件，就可以开始对应用的日志进行配置使用。


### 9、SpringBoot 还提供了其它的哪些 Starter Project Options？

SpringBoot 也提供了其它的启动器项目包括，包括用于开发特定类型应用程序的典型依赖项。

**1、** spring-boot-starter-web-services - SOAP Web Services；

**2、** spring-boot-starter-web - Web 和 RESTful 应用程序；

**3、** spring-boot-starter-test - 单元测试和集成测试；

**4、** spring-boot-starter-jdbc - 传统的 JDBC；

**5、** spring-boot-starter-hateoas - 为服务添加 HATEOAS 功能；

**6、** spring-boot-starter-security - 使用 SpringSecurity 进行身份验证和授权；

**7、** spring-boot-starter-data-jpa - 带有 Hibeernate 的 Spring Data JPA；

**8、** spring-boot-starter-data-rest - 使用 Spring Data REST 公布简单的 REST 服务；


### 10、怎样开启注解装配？

注解装配在默认情况下是不开启的，为了使用注解装配，我们必须在Spring配置文件中配置 [context:annotation-config/]()元素。


### 11、您将如何在微服务上执行安全测试？
### 12、介绍一下 WebApplicationContext
### 13、什么是领域驱动设计？
### 14、怎么样把ModelMap里面的数据放入Session里面？
### 15、如何解决POST请求中文乱码问题，GET的又如何处理呢？
### 16、您使用了哪些starter maven依赖项？
### 17、BeanFactory – BeanFactory 实现举例。
### 18、自动装配有哪些局限性 ?
### 19、什么是 Spring Framework？
### 20、什么是 AOP Aspect 切面
### 21、为什么要使用 Spring Cloud 熔断器？
### 22、[@RequestMapping ](/RequestMapping ) 注解有什么用？
### 23、如何使用 SpringBoot 生成一个 WAR 文件？
### 24、使用 Spring 访问 Hibernate 的方法有哪些？
### 25、SpringCloud有几种调用接口方式
### 26、SpringBoot支持哪些嵌入式容器？
### 27、SpringBoot运行项目的几种方式？
### 28、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 29、什么是FreeMarker模板？
### 30、使用 SpringBoot 开发分布式微服务时，我们面临什么问题
### 31、什么是消费者驱动的合同（CDC）？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
