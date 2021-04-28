# Spring最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是SpringBoot

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置


### 2、链路跟踪Sleuth

当我们项目中引入Spring Cloud Sleuth后，每次链路请求都会添加一串追踪信息，格式是[server-name, main-traceId,sub-spanId,boolean]：

**1、** server-name：服务结点名称。

**2、** main-traceId：一条链路唯一的ID，为TraceID。

**3、** sub-spanId：链路中每一环的ID，为SpanID。

**4、** boolean：是否将信息输出到Zipkin等服务收集和展示。

Sleuth的实现是基于HTTP的，为了在数据的收集过程中不能影响到正常业务，Sleuth会在每个请求的Header上添加跟踪需求的重要信息。这样在数据收集时，只需要将Header上的相关信息发送给对应的图像工具即可，图像工具根据上传的数据，按照Span对应的逻辑进行分析、展示。



### 3、@PathVariable和@RequestParam的区别

请求路径上有个id的变量值，可以通过@PathVariable来获取 [@RequestMapping(value ](/RequestMapping(value ) = “/page/{id}”, method = RequestMethod.GET)

@RequestParam用来获得静态的URL请求入参 spring注解时action里用到。


### 4、我们可以用微服务创建状态机吗？

我们知道拥有自己的数据库的每个微服务都是一个可独立部署的程序单元，这反过来又让我们可以创建一个状态机。因此，我们可以为特定的微服务指定不同的状态和事件。

例如，我们可以定义Order微服务。订单可以具有不同的状态。Order状态的转换可以是Order微服务中的独立事件。


### 5、如何设计一套API接口

考虑到API接口的分类可以将API接口分为开发API接口和内网API接口，内网API接口用于局域网，为内部服务器提供服务。开放API接口用于对外部合作单位提供接口调用，需要遵循Oauth2.0权限认证协议。同时还需要考虑安全性、幂等性等问题。


### 6、Spring Cloud OpenFeign

Feign是一个声明性的Web服务客户端。它使编写Web服务客户端变得更容易。要使用Feign，我们可以将调用的服务方法定义成抽象方法保存在本地添加一点点注解就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 7、[@Autowired ](/Autowired ) 注解

[@Autowired ](/Autowired ) 注解提供了更细粒度的控制，包括在何处以及如何完成自动装配。它的用法和@Required一样，修饰setter方法、构造器、属性或者具有任意名称和/或多个参数的PN方法。


### 8、什么是 AOP 目标对象?

被一个或者多个切面所通知的对象。它通常是一个代理对象。也指被通知（advised）对象。


### 9、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap、properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。

spring boot 核心的两个配置文件：

bootstrap (、 yml 或者 、 properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud 配置就会使用这个文件。且 boostrap 里面的属性不能被覆盖；

application (、 yml 或者 、 properties)： 由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 10、spring-boot-starter-parent 有什么用 ?

我们都知道，新创建一个 SpringBoot 项目，默认都是有 parent 的，这个 parent 就是 spring-boot-starter-parent ，spring-boot-starter-parent 主要有如下作用：

**1、**  定义了 Java 编译版本为 1、8 。

**2、**  使用 UTF-8 格式编码。

**3、**  继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。

**4、**  执行打包操作的配置。

**5、**  自动化的资源过滤。

**6、**  自动化的插件配置。

**7、**  针对 application、properties 和 application、yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev、properties 和 application-dev、yml。

总结就是打包用的


### 11、解释WEB 模块。
### 12、SpringBoot与SpringCloud 区别
### 13、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 14、负载平衡的意义什么？
### 15、什么是Netflix Feign？它的优点是什么？
### 16、前后端分离，如何维护接口文档 ?
### 17、如果想在拦截的方法里面得到从前台传入的参数,怎么得到？
### 18、运行 SpringBoot 有哪几种方式？
### 19、什么是Spring Actuator？它有什么优势？
### 20、[@Qualifier ](/Qualifier ) 注解
### 21、spring-boot-starter-parent 有什么用 ?
### 22、SpringBoot和springcloud认识
### 23、什么是执行器停机？
### 24、SpringCloud限流：
### 25、SpringBoot 如何设置支持跨域请求？
### 26、Spring MVC里面拦截器是怎么写的
### 27、Ribbon和Feign调用服务的区别
### 28、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 29、区分 BeanFactory 和 ApplicationContext。
### 30、什么是DispatcherServlet
### 31、服务注册和发现是什么意思？Spring Cloud如何实现？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
