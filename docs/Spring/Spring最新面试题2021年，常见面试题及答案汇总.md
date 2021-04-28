# Spring最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Spring框架的事务管理有哪些优点？

**1、** 它为不同的事务API 如 JTA，JDBC，Hibernate，JPA 和JDO，提供一个不变的编程模式。

**2、** 它为编程式事务管理提供了一套简单的API而不是一些复杂的事务API如

**3、** 它支持声明式事务管理。

**4、** 它和Spring各种数据访问抽象层很好得集成。


### 2、spring bean 容器的生命周期是什么样的？

**1、** spring bean 容器的生命周期流程如下：

**2、** Spring 容器根据配置中的 bean 定义中实例化 bean。

**3、** Spring 使用依赖注入填充所有属性，如 bean 中所定义的配置。

**4、** 如果 bean 实现 BeanNameAware 接口，则工厂通过传递 bean 的 ID 来调用 setBeanName()。

**5、** 如果 bean 实现 BeanFactoryAware 接口，工厂通过传递自身的实例来调用 setBeanFactory()。

**6、** 如果存在与 bean 关联的任何 BeanPostProcessors，则调用 preProcessBeforeInitialization() 方法。

**7、** 如果为 bean 指定了 init 方法（ 的 init-method 属性），那么将调用它。

**8、** 最后，如果存在与 bean 关联的任何 BeanPostProcessors，则将调用 postProcessAfterInitialization() 方法。

**9、** 如果 bean 实现 DisposableBean 接口，当 spring 容器关闭时，会调用 destory()。

**10、** 如果为 bean 指定了 destroy 方法（ 的 destroy-method 属性），那么将调用它。

###什么是 spring 的内部 bean？

只有将 bean 用作另一个 bean 的属性时，才能将 bean 声明为内部 bean。 为了定义 bean，Spring 的基于 XML 的配置元数据在 或 中提供了 元素的使用。 内部 bean 总是匿名的，它们总是作为原型。

###什么是 spring 装配

当 bean 在 Spring 容器中组合在一起时，它被称为装配或 bean 装配。

Spring 容器需要知道需要什么 bean 以及容器应该如何使用依赖注入来将 bean 绑定在一起，同时装配 bean。

###自动装配有哪些方式？

Spring 容器能够自动装配 bean。 也就是说，可以通过检查 BeanFactory 的内容让 Spring 自动解析 bean 的协作者。

**自动装配的不同模式：**

**1、** no - 这是默认设置，表示没有自动装配。 应使用显式 bean 引用进行装配。

**2、** byName - 它根据 bean 的名称注入对象依赖项。 它匹配并装配其属性与 XML 文件中由相同名称定义的 bean。

**3、** byType - 它根据类型注入对象依赖项。 如果属性的类型与 XML 文件中的一个 bean 名称匹配，则匹配并装配属性。

**4、** 构造函数 - 它通过调用类的构造函数来注入依赖项。 它有大量的参数。

**5、** autodetect - 首先容器尝试通过构造函数使用 autowire 装配，如果不能，则尝试通过 byType 自动装配。


### 3、如何使用SpringBoot实现异常处理？

Spring提供了一种使用ControllerAdvice处理异常的非常有用的方法。 我们通过实现一个ControlerAdvice类，来处理控制器类抛出的所有异常。


### 4、SpringBoot 的配置文件有哪几种格式？它们有什么区别？

.properties 和 .yml，它们的区别主要是书写格式不同。

**1、** properties

```
app.user.name = javastack
```

**2、** yml

```
app:
 user:
 name: javastack
```

另外，.yml 格式不支持 [@PropertySource ](/PropertySource ) 注解导入配置。


### 5、SpringBoot微服务中如何实现 session 共享 ?

在微服务中，一个完整的项目被拆分成多个不相同的独立的服务，各个服务独立部署在不同的服务器上，各自的 session 被从物理空间上隔离开了，但是经常，我们需要在不同微服务之间共享 session ，常见的方案就是 Spring Session + Redis 来实现 session 共享。将所有微服务的 session 统一保存在 Redis 上，当各个微服务对 session 有相关的读写操作时，都去操作 Redis 上的 session 。这样就实现了 session 共享，Spring Session 基于 Spring 中的代理过滤器实现，使得 session 的同步操作对开发人员而言是透明的，非常简便。


### 6、SpringBoot 的配置文件有哪几种格式？它们有什么区别？

.properties 和 .yml，它们的区别主要是书写格式不同。

**properties**

```
app.user.name = javastack
```

**yml**

```
app:
  user:
    name: javastack
```


### 7、BeanFactory – BeanFactory 实现举例。

Bean 工厂是工厂模式的一个实现，提供了控制反转功能，用来把应用的配置和依赖从正真的应用代码中分离。

最常用的BeanFactory 实现是XmlBeanFactory 类。


### 8、Spring Cloud Gateway

API网关组件，对请求提供路由及过滤功能。


### 9、熔断的原理，以及如何恢复？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_11.png#alt=45%5C_11.png)

**服务的健康状况 = 请求失败数 / 请求总数.**

熔断器开关由关闭到打开的状态转换是通过当前服务健康状况和设定阈值⽐较决定的.

**1、** 当熔断器开关关闭时, 请求被允许通过熔断器、如果当前健康状况⾼于设定阈值, 开关继续保持关闭、如果当前健康状况低于设定阈值, 开关则切换为打开状态.

**2、** 当熔断器开关打开时, 请求被禁⽌通过.

**3、** 当熔断器开关处于打开状态, 经过⼀段时间后, 熔断器会⾃动进⼊半开状态, 这时熔断器只允许⼀个请求通过、当该请求调⽤成功时, 熔断器恢复到关闭状态、若该请求失败, 熔断器继续保持打开状态, 接下来的请求被禁⽌通过.

熔断器的开关能保证服务调⽤者在调⽤异常服务时, 快速返回结果, 避免⼤量的同步等待、并且熔断器能在⼀段时间后继续侦测请求执⾏结果, 提供恢复服务调⽤的可能。


### 10、什么是Idempotence以及它在哪里使用？

幂等性是能够以这样的方式做两次事情的特性，即最终结果将保持不变，即好像它只做了一次。

用法：在远程服务或数据源中使用 Idempotence，这样当它多次接收指令时，它只处理指令一次。


### 11、微服务的优点
### 12、Spring MVC的主要组件？
### 13、康威定律是什么？
### 14、SpringBoot有哪些优点？
### 15、微服务有什么特点？
### 16、什么是 Spring Batch？
### 17、SpringBoot 中的 starter 到底是什么 ?
### 18、为什么在微服务中需要Reports报告和Dashboards仪表板？
### 19、22。你能否给出关于休息和微服务的要点？
### 20、SpringBoot如何实现打包
### 21、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 22、什么是织入。什么是织入应用的不同点？
### 23、如何给静态变量赋值？
### 24、什么是JavaConfig？
### 25、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 26、SpringBoot需要独立的容器运行？
### 27、自动装配有哪些方式？
### 28、如何集成 SpringBoot 和 ActiveMQ？
### 29、注解原理是什么
### 30、SpringBoot自动配置的原理是什么？
### 31、不同版本的 Spring Framework 有哪些主要功能？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
