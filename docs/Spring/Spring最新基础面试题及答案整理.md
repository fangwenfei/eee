# Spring最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是Spring引导的执行器？

SpringBoot执行程序提供了restful Web服务，以访问生产环境中运行应用程序的当前状态。在执行器的帮助下，您可以检查各种指标并监控您的应用程序。


### 2、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。


### 3、什么是feigin？它的优点是什么？

**1、** feign采用的是基于接口的注解

**2、** feign整合了ribbon，具有负载均衡的能力

**3、** 整合了Hystrix，具有熔断的能力

**使用:**

**1、** 添加pom依赖。

**2、** 启动类添加[@EnableFeignClients ](/EnableFeignClients )

**3、** 定义一个接口@FeignClient(name=“xxx”)指定调用哪个服务


### 4、什么是Spring MVC？简单介绍下你对Spring MVC的理解？

Spring MVC是一个基于Java的实现了MVC设计模式的请求驱动类型的轻量级Web框架，通过把模型-视图-控制器分离，将web层进行职责解耦，把复杂的web应用分成逻辑清晰的几部分，简化开发，减少出错，方便组内开发人员之间的配合。


### 5、Spring 、SpringBoot 和 Spring Cloud 的关系?

**1、** Spring 最初最核心的两大核心功能 Spring Ioc 和 Spring Aop 成就了 Spring，Spring 在这两大核心的功能上不断的发展，才有了 Spring 事务、Spring Mvc 等一系列伟大的产品，最终成就了 Spring 帝国，到了后期 Spring 几乎可以解决企业开发中的所有问题。

**2、** SpringBoot 是在强大的 Spring 帝国生态基础上面发展而来，发明 SpringBoot 不是为了取代 Spring ,是为了让人们更容易的使用 Spring 。

**3、** Spring Cloud 是一系列框架的有序集合。它利用 SpringBoot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 SpringBoot 的开发风格做到一键启动和部署。

**4、** Spring Cloud 是为了解决微服务架构中服务治理而提供的一系列功能的开发框架，并且 Spring Cloud 是完全基于 SpringBoot 而开发，Spring Cloud 利用 SpringBoot 特性整合了开源行业中优秀的组件，整体对外提供了一套在微服务架构中服务治理的解决方案。

**5、** 用一组不太合理的包含关系来表达它们之间的关系。

**6、** Spring ioc/aop > Spring > SpringBoot > Spring Cloud


### 6、请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/042/38/80_1.png#alt=80%5C_1.png)

**1、** 用户发送请求至前端控制器DispatcherServlet；

**2、** DispatcherServlet收到请求后，调用HandlerMapping处理器映射器，请求获取Handle；

**3、** 处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet；

**4、** DispatcherServlet 调用 HandlerAdapter处理器适配器；

**5、** HandlerAdapter 经过适配调用 具体处理器(Handler，也叫后端控制器)；

**6、** Handler执行完成返回ModelAndView；

**7、** HandlerAdapter将Handler执行结果ModelAndView返回给DispatcherServlet；

**8、** DispatcherServlet将ModelAndView传给ViewResolver视图解析器进行解析；

**9、** ViewResolver解析后返回具体View；

**10、** DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）

**11、** DispatcherServlet响应用户。


### 7、微服务之间是如何独⽴通讯的

**1、** Dubbo 使⽤的是 RPC 通信，⼆进制传输，占⽤带宽⼩；

**2、** Spring Cloud 使⽤的是 HTTP RESTFul ⽅式。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_2.png#alt=45%5C_2.png)


### 8、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用spring-boot-starter-activemq依赖关系。它只需要很少的配置，并且不需要样板代码。


### 9、如何设置服务发现？

有多种方法可以设置服务发现。我将选择我认为效率最高的那个，Netflix的Eureka。这是一个简单的程序，不会对应用程序造成太大影响。此外，它支持多种类型的Web应用程序。 Eureka配置包括两个步骤 - 客户端配置和服务器配置。

使用属性文件可以轻松完成客户端配置。在clas spath中，Eureka搜索一个eureka-client.properties文件。它还搜索由特定于环境的属性文件中的环境引起的覆盖。

对于服务器配置，您必须首先配置客户端。完成后，服务器启动一个客户端，该客户端用于查找其他服务器。。默认情况下，Eureka服务器使用客户端配置来查找对等服务器。


### 10、[@Autowired ](/Autowired ) 注解有什么用？

[@Autowired ](/Autowired ) 可以更准确地控制应该在何处以及如何进行自动装配。此注解用于在 setter 方法，构造函数，具有任意名称或多个参数的属性或方法上自动装配 bean。默认情况下，它是类型驱动的注入。

```
public class Employee {
    private String name;
    @Autowired
    public void setName(String name) {
        this.name=name;
    }
    public string getName(){
        return name;
    }
}
```


### 11、SpringCloud 和 Dubbo 有哪些区别?
### 12、负载均衡的意义是什么?
### 13、ApplicationContext通常的实现是什么?
### 14、什么是服务降级
### 15、SpringBoot支持什么前端模板，
### 16、什么是 spring 的内部 bean？
### 17、如何使用SpringBoot实现分页和排序？
### 18、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 19、Spring由哪些模块组成?
### 20、康威定律是什么？
### 21、SpringBoot、Spring MVC 和 Spring 有什么区别
### 22、如何使用 SpringBoot 实现全局异常处理？
### 23、Spring Cloud Consul
### 24、SpringBoot 自动配置原理是什么？
### 25、合同测试你懂什么？
### 26、JPA 和 Hibernate 有哪些区别？
### 27、如何给Spring 容器提供配置元数据?
### 28、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 29、SpringBoot 中的 starter 到底是什么 ?
### 30、Spring支持的事务管理类型
### 31、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
