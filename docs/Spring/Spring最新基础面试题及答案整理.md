# Spring最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_13.png#alt=img%5C_13.png)

在测试目标只关注Spring MVC组件的情况下，WebMvcTest注释用于单元测试Spring MVC应用程序。在上面显示的快照中，我们只想启动ToTestController。执行此单元测试时，不会启动所有其他控制器和映射。


### 2、@ResponseBody注解的作用

**作用：**

该注解用于将Controller的方法返回的对象，通过适当的HttpMessageConverter转换为指定格式后，写入到Response对象的body数据区。

**使用时机：**

返回的数据不是html标签的页面，而是其他某种格式的数据时（如json、xml等）使用；


### 3、第⼀层缓存：

readOnlyCacheMap，本质上是ConcurrentHashMap：这是⼀个JVM的CurrentHashMap只读缓存，这个主要是为了供客户端获取注册信息时使⽤，其缓存更新，依赖于定时器的更新，通过和readWriteCacheMap 的值做对⽐，如果数据不⼀致，则以readWriteCacheMap 的数据为准。readOnlyCacheMap 缓存更新的定时器时间间隔，默认为30秒

#
### 4、微服务之间是如何独立通讯的?

**1、** 远程调用，比如feign调用，直接通过远程过程调用来访问别的service。 2.消息中间件


### 5、Bean 工厂和 Application contexts 有什么区别？

Application contexts提供一种方法处理文本消息，一个通常的做法是加载文件资源（比如镜像），它们可以向注册为监听器的bean事件。另外，在容器或容器内的对象上执行的那些不得不由bean工厂以程序化方式处理的操作，可以在Application contexts中以声明的方式处理。Application contexts实现了MessageSource接口，该接口的实现以可插拔的方式提供获取本地化消息的方法。


### 6、什么是Spring beans?

Spring beans 是那些形成Spring应用的主干的java对象。它们被Spring IOC容器初始化，装配，和管理。这些beans通过容器中配置的元数据创建。比如，以XML文件中 的形式定义。

Spring 框架定义的beans都是单件beans。在bean tag中有个属性”singleton”，如果它被赋为TRUE，bean 就是单件，否则就是一个 prototype bean。默认是TRUE，所以所有在Spring框架中的beans 缺省都是单件。


### 7、什么是微服务架构中的DRY？

DRY代表不要重复自己。它基本上促进了重用代码的概念。这导致开发和共享库，这反过来导致紧密耦合。


### 8、Spring Cloud Netflix

Netflix OSS 开源组件集成，包括Eureka、Hystrix、Ribbon、Feign、Zuul等核心组件。

**1、** Eureka：服务治理组件，包括服务端的注册中心和客户端的服务发现机制；

**2、** Ribbon：负载均衡的服务调用组件，具有多种负载均衡调用策略；

**3、** Hystrix：服务容错组件，实现了断路器模式，为依赖服务的出错和延迟提供了容错能力；

**4、** Feign：基于Ribbon和Hystrix的声明式服务调用组件；

**5、** Zuul：API网关组件，对请求提供路由及过滤功能。


### 9、Spring支持的ORM

Spring支持以下ORM：

**1、** Hibernate

**2、** iBatis

**3、** JPA (Java Persistence API)

**4、** TopLink

**5、** JDO (Java Data Objects)

**6、** OJB


### 10、如何设计一套API接口

考虑到API接口的分类可以将API接口分为开发API接口和内网API接口，内网API接口用于局域网，为内部服务器提供服务。开放API接口用于对外部合作单位提供接口调用，需要遵循Oauth2.0权限认证协议。同时还需要考虑安全性、幂等性等问题。


### 11、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？
### 12、什么是Hystrix？它如何实现容错？
### 13、如何使用 SpringBoot 实现全局异常处理？
### 14、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 15、什么是有界上下文？
### 16、SpringBoot集成mybatis的过程
### 17、解释AOP模块
### 18、微服务设计的基础是什么？
### 19、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 20、什么是服务降级
### 21、Spring Cloud 和dubbo区别?
### 22、什么是WebSockets？
### 23、[@Autowired ](/Autowired ) 注解有什么用？
### 24、请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？
### 25、解释Spring支持的几种bean的作用域。
### 26、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 27、什么是Netflix Feign？它的优点是什么？
### 28、spring 支持集中 bean scope？
### 29、创建一个 SpringBoot Project 的最简单的方法是什么？
### 30、SpringBoot 实现热部署有哪几种方式？
### 31、谈一下领域驱动设计




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
