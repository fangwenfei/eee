# Spring面试题及答案整理，2021年最新，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用spring-boot-starter-activemq 依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 2、介绍一下 WebApplicationContext

WebApplicationContext 继承了ApplicationContext 并增加了一些WEB应用必备的特有功能，它不同于一般的ApplicationContext ，因为它能处理主题，并找到被关联的servlet。




### 3、使用Spring通过什么方式访问Hibernate?

**在Spring中有两种方式访问Hibernate：**

控制反转 Hibernate Template和 Callback。

继承 HibernateDAOSupport提供一个AOP 拦截器。


### 4、XMLBeanFactory

最常用的就是org.springframework.beans.factory.xml.XmlBeanFactory ，它根据XML文件中的定义加载beans。该容器从XML 文件读取配置元数据并用它去创建一个完全配置的系统或应用。


### 5、Spring Cloud Security

安全工具包，对Zuul代理中的负载均衡OAuth2客户端及登录认证进行支持。


### 6、@Controller注解的作用

**1、** 在Spring MVC 中，控制器Controller 负责处理由DispatcherServlet 分发的请求，它把用户请求的数据经过业务处理层处理之后封装成一个Model ，然后再把该Model 返回给对应的View 进行展示。在Spring MVC 中提供了一个非常简便的定义Controller 的方法，你无需继承特定的类或实现特定的接口，只需使用[@Controller ](/Controller ) 标记一个类是Controller ，然后使用[@RequestMapping ](/RequestMapping ) 和[@RequestParam ](/RequestParam ) 等一些注解用以定义URL 请求和Controller 方法之间的映射，这样的Controller 就能被外界访问到。此外Controller 不会直接依赖于HttpServletRequest 和HttpServletResponse 等HttpServlet 对象，它们可以通过Controller 的方法参数灵活的获取到。

**2、** [@Controller ](/Controller ) 用于标记在一个类上，使用它标记的类就是一个Spring MVC Controller 对象。分发处理器将会扫描使用了该注解的类的方法，并检测该方法是否使用了[@RequestMapping ](/RequestMapping ) 注解。[@Controller ](/Controller ) 只是定义了一个控制器类，而使用[@RequestMapping ](/RequestMapping ) 注解的方法才是真正处理请求的处理器。单单使用[@Controller ](/Controller ) 标记在一个类上还不能真正意义上的说它就是Spring MVC 的一个控制器类，因为这个时候Spring 还不认识它。那么要如何做Spring 才能认识它呢？这个时候就需要我们把这个控制器类交给Spring 来管理。有两种方式：

**3、** 在Spring MVC 的配置文件中定义MyController 的bean 对象。

**4、** 在Spring MVC 的配置文件中告诉Spring 该到哪里去找标记为[@Controller ](/Controller ) 的Controller 控制器。


### 7、如何在 spring 中启动注解装配？

默认情况下，Spring 容器中未打开注解装配。 因此，要使用基于注解装配，我们必须通过配置 <context： annotation-config /> 元素在 Spring 配置文件中启用它。


### 8、SpringBoot的缺点

我觉得是为难人，SpringBoot在目前我觉得没有什么缺点，非要找一个出来我觉得就是

由于不用自己做的配置，报错时很难定位。


### 9、SpringBoot中的监视器是什么？

Spring boot actuator是spring启动框架中的重要功能之一。Spring boot监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。

有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为HTTP URL访问的REST端点来检查状态。


### 10、Spring Cloud Bus

用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。


### 11、Spring、SpringBoot、SpringMVC的区别？
### 12、什么是 AOP什么是目标对象?
### 13、什么是JavaConfig？
### 14、@LoadBalanced注解的作用
### 15、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 16、SpringBoot中的监视器是什么?
### 17、什么是Apache Kafka？
### 18、解释不同方式的自动装配
### 19、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 20、spring 提供了哪些配置方式？
### 21、@ResponseBody注解的作用
### 22、您对微服务架构中的语义监控有何了解？
### 23、你所知道微服务的技术栈有哪些？列举一二
### 24、Spring Framework 有哪些不同的功能？
### 25、什么是 Spring Data？
### 26、什么是Hystrix断路器？我们需要它吗？
### 27、什么是有界上下文？
### 28、什么是Hystrix?
### 29、双因素身份验证的凭据类型有哪些？
### 30、[@RequestMapping ](/RequestMapping ) 注解有什么用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
