# Spring高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、spring 支持集中 bean scope？

**Spring bean 支持 5 种 scope：**

**1、** Singleton - 每个 Spring IoC 容器仅有一个单实例。

**2、** Prototype - 每次请求都会产生一个新的实例。

**3、** Request - 每一次 HTTP 请求都会产生一个新的实例，并且该 bean 仅在当前 HTTP 请求内有效。

**4、** Session - 每一次 HTTP 请求都会产生一个新的 bean，同时该 bean 仅在当前 HTTP session 内有效。

**5、** Global-session - 类似于标准的 HTTP Session 作用域，不过它仅仅在基于 portlet 的 web 应用中才有意义。 Portlet 规范定义了全局 Session 的概念，它被所有构成某个 portlet web 应用的各种不同的 portlet 所共享。 在 global session 作用域中定义的 bean 被限定于全局 portlet Session 的生命周期范围内。 如果你在 web 中使用 global session 作用域来标识 bean，那么 web 会自动当成 session 类型来使用。

**6、** 仅当用户使用支持 Web 的 ApplicationContext 时，最后三个才可用。


### 2、SpringBoot 配置加载顺序?

**1、** properties文件 2、YAML文件 3、系统环境变量 4、命令行参数


### 3、为什么需要学习Spring Cloud

**1、** 首先springcloud基于spingboot的优雅简洁，可还记得我们被无数xml支配的恐惧？可还记得springmvc，mybatis错综复杂的配置，有了spingboot，这些东西都不需要了，spingboot好处不再赘诉，springcloud就基于SpringBoot把市场上优秀的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理

**2、** 什么叫做开箱即用？即使是当年的黄金搭档dubbo+zookeeper下载配置起来也是颇费心神的！而springcloud完成这些只需要一个jar的依赖就可以了！

**3、** springcloud大多数子模块都是直击痛点，像zuul解决的跨域，fegin解决的负载均衡，hystrix的熔断机制等等等等


### 4、自动装配有什么局限？

**1、** 覆盖的可能性 - 您始终可以使用 和 设置指定依赖项，这将覆盖自动装配。

**2、** 基本元数据类型 - 简单属性（如原数据类型，字符串和类）无法自动装配。

**3、** 令人困惑的性质 - 总是喜欢使用明确的装配，因为自动装配不太精确。

###你用过哪些重要的 Spring 注解

**1、** [@Controller ](/Controller ) - 用于 Spring MVC 项目中的控制器类。

**2、** [@Service ](/Service ) - 用于服务类。

**3、** [@RequestMapping ](/RequestMapping ) - 用于在控制器处理程序方法中配置 URI 映射。

**4、** [@ResponseBody ](/ResponseBody ) - 用于发送 Object 作为响应，通常用于发送 XML 或 JSON 数据作为响应。

**5、** [@PathVariable ](/PathVariable ) - 用于将动态值从 URI 映射到处理程序方法参数。

**6、** [@Autowired ](/Autowired ) - 用于在 spring bean 中自动装配依赖项。

**7、** [@Qualifier ](/Qualifier ) - 使用 [@Autowired ](/Autowired ) 注解，以避免在存在多个 bean 类型实例时出现混淆。

**8、** [@Scope ](/Scope ) - 用于配置 spring bean 的范围。

**9、** @Configuration，[@ComponentScan ](/ComponentScan ) 和 [@Bean ](/Bean ) - 用于基于 java 的配置。

**10、** @Aspect，@Before，@After，@Around，[@Pointcut ](/Pointcut ) - 用于切面编程（AOP）


### 5、Bean 工厂和 Application contexts 有什么区别？

Application contexts提供一种方法处理文本消息，一个通常的做法是加载文件资源（比如镜像），它们可以向注册为监听器的bean事件。另外，在容器或容器内的对象上执行的那些不得不由bean工厂以程序化方式处理的操作，可以在Application contexts中以声明的方式处理。Application contexts实现了MessageSource接口，该接口的实现以可插拔的方式提供获取本地化消息的方法。


### 6、什么是 Spring Profiles？

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 7、Ribbon底层实现原理

Ribbon使用discoveryClient从注册中心读取目标服务信息，对同一接口请求进行计数，使用%取余算法获取目标服务集群索引，返回获取到的目标服务信息。


### 8、怎样在方法里面得到Request,或者Session？



直接在方法的形参中声明request,Spring MVC就自动把request对象传入。


### 9、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？

path- 这个资源要导出的路径段。

collectionResourceRel- 生成指向集合资源的链接时使用的 rel 值。在生成 HATEOAS 链接时使用。


### 10、Nginx与Ribbon的区别

Nginx是反向代理同时可以实现负载均衡，nginx拦截客户端请求采用负载均衡策略根据upstream配置进行转发，相当于请求通过nginx服务器进行转发。Ribbon是客户端负载均衡，从注册中心读取目标服务器信息，然后客户端采用轮询策略对服务直接访问，全程在客户端操作。


### 11、什么是Spring Cloud Bus？我们需要它吗？
### 12、使用Spring Cloud有什么优势？
### 13、如何在 SpringBoot 中添加通用的 JS 代码？
### 14、什么是 Aspect？
### 15、为什么我们需要 spring-boot-maven-plugin?
### 16、SpringBoot微服务中如何实现 session 共享 ?
### 17、SpringBoot的自动配置原理是什么
### 18、微服务之间是如何独立通讯的?
### 19、什么是Netflix Feign？它的优点是什么？
### 20、接⼝限流⽅法？
### 21、康威定律是什么？
### 22、运行 SpringBoot 有哪几种方式？
### 23、@Controller注解的作用
### 24、Spring Cloud Stream
### 25、bootstrap.yml和application.yml有什么区别?
### 26、什么是feigin？它的优点是什么？
### 27、SpringBoot 有哪几种读取配置的方式？
### 28、你怎样定义类的作用域?
### 29、SpringBoot 最大的优势是什么呢？
### 30、什么是 AOP 连接点




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
