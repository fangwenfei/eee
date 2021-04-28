# Spring最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、spring boot扫描流程?

**1、** 调用run方法中的`refreshContext`方法

**2、** 用AbstractApplicationContext中的`refresh`方法

**3、** 委托给`invokeBeanFactoryPostProcessors`去处理调用链

**4、** 其中一个方法`postProcessBeanDefinitionRegistry会`去调用`processConfigBeanDefinitions`解析`beandefinitions`

**5、** 在`processConfigBeanDefinitions`中有一个`parse`方法，其中有`componentScanParser.parse`的方法，这个方法会扫描当前路径下所有`Component`组件


### 2、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。 Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 3、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用

来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 4、Spring MVC的优点

**1、** 可以支持各种视图技术,而不仅仅局限于JSP；

**2、** 与Spring框架集成（如IoC容器、AOP等）；

**3、** 清晰的角色分配：前端控制器(dispatcherServlet) , 请求到处理器映射（handlerMapping), 处理器适配器（HandlerAdapter), 视图解析器（ViewResolver）。

**4、** 支持各种请求资源的映射策略。


### 5、YAML 配置的优势在哪里 ?

YAML 现在可以算是非常流行的一种配置文件格式了，无论是前端还是后端，都可以见到 YAML 配置。那么 YAML 配置和传统的 properties 配置相比到底有哪些优势呢？

**1、** 配置有序，在一些特殊的场景下，配置有序很关键

**2、** 支持数组，数组中的元素可以是基本数据类型也可以是对象

3、简洁

相比 properties 配置文件，YAML 还有一个缺点，就是不支持 [@PropertySource ](/PropertySource ) 注解导入自定义的 YAML 配置。


### 6、什么是Spring IOC 容器？

Spring IOC 负责创建对象，管理对象（通过依赖注入（DI），装配对象，配置对象，并且管理这些对象的整个生命周期。


### 7、微服务的优点

**单⼀职责：**

每个微服务仅负责⾃⼰业务领域的功能；

**⾃治：**

⼀个微服务就是⼀个独⽴的实体，它可以独⽴部署、升级，服务与服务之间通过REST等形式的标准接⼝进⾏通信，并且⼀个微服务实例可以被替换成另⼀种实现，⽽对其它的微服务不产⽣影响。

**逻辑清晰：**

微服务单⼀职责特性使微服务看起来逻辑清晰，易于维护。

**简化部署：**

单系统中修改⼀处需要部署整个系统，⽽微服务中修改⼀处可单独部署⼀个服务

**可扩展：**

应对系统业务增⻓的⽅法通常采⽤横向（Scale out）或纵向（Scale up）的⽅向进⾏扩展。分布式系统中通常要采⽤Scale out的⽅式进⾏扩展。

**灵活组合：**

**技术异构：**

不同的服务之间，可以根据⾃⼰的业务特点选择不通的技术架构，如数据库等。


### 8、如何使用 SpringBoot 实现全局异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。 我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 9、什么是bean的自动装配？

Spring 容器能够自动装配相互合作的bean，这意味着容器不需要和配置，能通过Bean工厂自动处理bean之间的协作。


### 10、Spring MVC怎么样设定重定向和转发的？

**转发：**

在返回值前面加"forward:"，譬如"forward:user.do?name=method4"

**重定向：**

在返回值前面加"redirect:"，譬如"redirect:[www.baidu.com](http://www.baidu.com)"


### 11、[@Required ](/Required ) 注解
### 12、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：
### 13、PACT在微服务架构中的用途是什么？
### 14、Spring MVC 框架有什么用？
### 15、列举 IoC 的一些好处
### 16、Ribbon和Feign调用服务的区别
### 17、如何在 SpringBoot中禁用 Actuator端点安全性?
### 18、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 19、什么是SpringBoot？
### 20、SpringBoot和springcloud认识
### 21、哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入？
### 22、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 23、Spring Cloud Zookeeper
### 24、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 25、使用Spring通过什么方式访问Hibernate?
### 26、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 27、Spring Cache 三种常用的缓存注解和意义？
### 28、什么是 spring 的内部 bean？
### 29、Spring Cloud Netflix(重点，这些组件用的最多)
### 30、服务网关的作用
### 31、什么是双因素身份验证？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
