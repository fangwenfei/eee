# Spring高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、在微服务中，如何保护服务?

一般使用使用Hystrix框架，实现服务隔离来避免出现服务的雪崩效应，从而达到保护服务的效果。当微服务中，高并发的数据库访问量导致服务线程阻塞，使单个服务宕机，服务的不可用会蔓延到其他服务，引起整体服务灾难性后果，使用服务降级能有效为不同的服务分配资源,一旦服务不可用则返回友好提示，不占用其他服务资源，从而避免单个服务崩溃引发整体服务的不可用.


### 2、哪些是重要的bean生命周期方法？你能重载它们吗？

有两个重要的bean 生命周期方法，第一个是setup ， 它是在容器加载bean的时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。

The bean 标签有两个重要的属性（init-method和destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct和@PreDestroy）。


### 3、PACT在微服务架构中的用途是什么？

PACT是一个开源工具，允许测试服务提供者和消费者之间的交互，与合同隔离，从而提高微服务集成的可靠性。

微服务中的用法

用于在微服务中实现消费者驱动的合同。

测试微服务的消费者和提供者之间的消费者驱动的合同。

查看即将到来的批次


### 4、谈谈服务降级、熔断、服务隔离

**1、** 服务降级：当客户端请求服务器端的时候，防止客户端一直等待，不会处理业务逻辑代码，直接返回一个友好的提示给客户端。

**2、** 服务熔断是在服务降级的基础上更直接的一种保护方式，当在一个统计时间范围内的请求失败数量达到设定值（requestVolumeThreshold）或当前的请求错误率达到设定的错误率阈值（errorThresholdPercentage）时开启断路，之后的请求直接走fallback方法，在设定时间（sleepWindowInMilliseconds）后尝试恢复。

**3、** 服务隔离就是Hystrix为隔离的服务开启一个独立的线程池，这样在高并发的情况下不会影响其他服务。服务隔离有线程池和信号量两种实现方式，一般使用线程池方式。


### 5、你如何理解 SpringBoot 配置加载顺序？

在 SpringBoot 里面，可以使用以下几种方式来加载配置。

**1、** properties文件；

**2、** YAML文件；

**3、** 系统环境变量；

**4、** 命令行参数；

等等……


### 6、列举 Spring DAO 抛出的异常。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_4.png#alt=img%5C_4.png)


### 7、Spring MVC的主要组件？

**1、** 前端控制器 DispatcherServlet（不需要程序员开发）

**作用：**

接收请求、响应结果，相当于转发器，有了DispatcherServlet 就减少了其它组件之间的耦合度。

**2、** 处理器映射器HandlerMapping（不需要程序员开发）

**作用：**

根据请求的URL来查找Handler

**3、** 处理器适配器HandlerAdapter

**注意：**

在编写Handler的时候要按照HandlerAdapter要求的规则去编写，这样适配器HandlerAdapter才可以正确的去执行Handler。

**4、** 处理器Handler（需要程序员开发）

**5、** 视图解析器 ViewResolver（不需要程序员开发）

**作用：**

进行视图的解析，根据视图逻辑名解析成真正的视图（view）

**6、** 视图View（需要程序员开发jsp）

View是一个接口， 它的实现类支持不同的视图类型（jsp，freemarker，pdf等等）


### 8、什么是 AOP切点

切入点是一个或一组连接点，通知将在这些位置执行。可以通过表达式或匹配的方式指明切入点。


### 9、如何禁用特定的自动配置类？

若发现任何不愿使用的特定自动配置类，可以使用@EnableAutoConfiguration的排除属性。

//By using "exclude"

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

另一方面，如果类别不在类路径上，则可以使用excludeName类注解，并且指定完全限定名。

//By using "excludeName"

@EnableAutoConfiguration(excludeName={Foo.class})

此外，SpringBoot还具有控制排除自动配置类列表的功能，可以通过使用spring.autoconfigure.exclude property来实现。可以将其添加到 propertie应用程序中，并且可以添加逗号分隔的多个类。

//By using property file

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration


### 10、什么是 spring 装配

当 bean 在 Spring 容器中组合在一起时，它被称为装配或 bean 装配。Spring 容器需要知道需要什么 bean 以及容器应该如何使用依赖注入来将 bean 绑定在一起，同时装配 bean。


### 11、什么是 YAML？
### 12、创建一个 SpringBoot Project 的最简单的方法是什么？
### 13、Spring框架中的单例bean是线程安全的吗?
### 14、JdbcTemplate
### 15、什么是微服务架构
### 16、怎样在方法里面得到Request,或者Session？
### 17、服务网关的作用
### 18、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?
### 19、springcloud如何实现服务的注册?
### 20、Springboot 有哪些优点？
### 21、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 22、SpringBoot 实现热部署有哪几种方式？
### 23、什么是 Spring Data ?
### 24、列举 Spring Framework 的优点。
### 25、什么是无所不在的语言？
### 26、开启 SpringBoot 特性有哪几种方式？
### 27、什么是Spring Cloud？
### 28、在 Spring Initializer 中，如何改变一个项目的包名字？
### 29、既然Nginx可以实现网关？为什么还需要使用Zuul框架
### 30、Spring MVC怎么和AJAX相互调用的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
