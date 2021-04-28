# Spring最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Ribbon和Feign调用服务的区别

**1、** 调用方式同：Ribbon需要我们自己构建Http请求，模拟Http请求然后通过RestTemplate发给其他服务，步骤相当繁琐

**2、** 而Feign则是在Ribbon的基础上进行了一次改进，采用接口的形式，将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 2、什么是 AOP 切点

切入点是一个或一组连接点，通知将在这些位置执行。可以通过表达式或匹配的方式指明切入点。


### 3、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？

WebMvcTest注释用于单元测试Spring MVC应用程序。我们只想启动ToTestController。执行此单元测试时，不会启动所有其他控制器和映射。

```
@WebMvcTest(value = ToTestController.class, secure = false):
```


### 4、有哪些不同类型的IOC（依赖注入）方式？

构造器依赖注入：构造器依赖注入通过容器触发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖。

Setter方法注入：Setter方法注入是容器通过调用无参构造器或无参static工厂 方法实例化bean之后，调用该bean的setter方法，即实现了基于setter的依赖注入。


### 5、什么是 Spring Framework？

Spring 是一个开源应用框架，旨在降低应用程序开发的复杂度。它是轻量级、松散耦合的。它具有分层体系结构，允许用户选择组件，同时还为 J2EE 应用程序开发提供了一个有凝聚力的框架。它可以集成其他框架，如 Structs、Hibernate、EJB 等，所以又称为框架的框架。


### 6、什么是FreeMarker模板？

FreeMarker是一个基于Java的模板引擎，最初专注于使用MVC软件架构进行动态网页生成。使用Freemarker的主要优点是表示层和业务层的完全分离。程序员可以处理应用程序代码，而设计人员可以处理html页面设计。最后使用freemarker可以将这些结合起来，给出最终的输出页面。


### 7、什么是 AOP什么是目标对象?

被一个或者多个切面所通知的对象。它通常是一个代理对象。也指被通知（advised）对象。


### 8、SpringBoot 自动配置原理

**1、** SpringBoot启动的时候加载主配置类，开启了自动配置功能 @EnableAutoConfiguration

**2、** @EnableAutoConfiguration 作用:

将类路径下 META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值加入到了容器中;

每一个这样的 xxxAutoConfiguration类都是容器中的一个组件，都加入到容器中;用他们来做自动配置;

**3、** 每一个自动配置类进行自动配置功能;

根据当前不同的条件判断，决定这个配置类是否生效；

**4、** 一但这个配置类生效;这个配置类就会给容器中添加各种组件;这些组件的属性是从对应的properties类中获取 的，这些类里面的每一个属性又是和配置文件绑定的;

**5、** 所有在配置文件中能配置的属性都是在xxxxProperties类中封装者‘;配置文件能配置什么就可以参照某个功 能对应的这个属性类


### 9、解释对象/关系映射集成模块。

Spring 通过提供ORM模块，支持我们在直接JDBC之上使用一个对象/关系映射映射(ORM)工具，Spring 支持集成主流的ORM框架，如Hiberate,JDO和 iBATIS SQL Maps。Spring的事务管理同样支持以上所有ORM框架及JDBC。


### 10、什么是 AOP 通知

通知是个在方法执行前或执行后要做的动作，实际上是程序执行时要通过SpringAOP框架触发的代码段。

**Spring切面可以应用五种类型的通知：**

before：前置通知，在一个方法执行前被调用。

after: 在方法执行之后调用的通知，无论方法执行是否成功。

after-returning: 仅当方法成功完成后执行的通知。

after-throwing: 在方法抛出异常退出时执行的通知。

around: 在方法执行之前和之后调用的通知。


### 11、SpringBoot支持什么前端模板，
### 12、什么是幂等性?它是如何使用的？
### 13、列举 Spring Framework 的优点。
### 14、Spring Cloud Consul
### 15、怎么样把ModelMap里面的数据放入Session里面？
### 16、SpingMvc中的控制器的注解一般用哪个,有没有别的注解可以替代？
### 17、列举 Spring Framework 的优点。
### 18、spring-boot-starter-parent有什么用？
### 19、什么是服务熔断
### 20、你如何理解 SpringBoot 配置加载顺序？
### 21、如何给Spring 容器提供配置元数据?
### 22、SpringBoot 自动配置原理是什么？
### 23、@PathVariable和@RequestParam的区别
### 24、[@Required ](/Required ) 注解
### 25、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 26、SpringBoot 最大的优势是什么呢？
### 27、分布式配置中心的作用？
### 28、Spring MVC的控制器是不是单例模式,如果是,有什么问题,怎么解决？
### 29、SpringBoot 自动配置原理是什么？
### 30、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 31、Actuator在SpringBoot中的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
