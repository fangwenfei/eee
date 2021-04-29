# Spring最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Spring MVC？简单介绍下你对Spring MVC的理解？

Spring MVC是一个基于Java的实现了MVC设计模式的请求驱动类型的轻量级Web框架，通过把模型-视图-控制器分离，将web层进行职责解耦，把复杂的web应用分成逻辑清晰的几部分，简化开发，减少出错，方便组内开发人员之间的配合。


### 2、什么是 Aspect 切面

AOP核心就是切面，它将多个类的通用行为封装成可重用的模块，该模块含有一组API提供横切功能。比如，一个日志模块可以被称作日志的AOP切面。根据需求的不同，一个应用程序可以有若干切面。在Spring AOP中，切面通过带有@Aspect注解的类实现。


### 3、使用Spring通过什么方式访问Hibernate?

**在Spring中有两种方式访问Hibernate：**

控制反转 Hibernate Template和 Callback。

继承 HibernateDAOSupport提供一个AOP 拦截器。


### 4、SpringBoot 是否可以使用 XML 配置 ?

SpringBoot 推荐使用 Java 配置而非 XML 配置，但是 SpringBoot 中也可以使用 XML 配置，通过 [@ImportResource ](/ImportResource ) 注解可以引入一个 XML 配置。


### 5、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： [@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 6、微服务的优点

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


### 7、SpringBoot中的监视器是什么?

`Spring boot actuatorspring`是启动框架中的重要功能之一。 Spring boot监视器可访问生产环境中正在运行的应用程序的当前状态。有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为 `http url rest`访问的REST端点来检查状态。


### 8、微服务测试的主要障碍是什么？

说到缺点，这里是另一个微服务面试问题，将围绕测试微服务时面临的挑战。

**1、** 在开始编写集成测试的测试用例之前，测试人员应该全面了解对所有入站和出站过程。

**2、** 当独立的团队正在开发不同的功能时，协作可能会被证明是一项非常困难的任务。很难找到空闲时间窗口来执行完整的回归测试。

**3、** 随着微服务数量的增加，系统的复杂性也随之增加。

**4、** 在从单片架构过渡期间，测试人员必须确保组件之间的内部通信没有中断。


### 9、spring bean 容器的生命周期是什么样的？

spring bean 容器的生命周期流程如下：

**1、** Spring 容器根据配置中的 bean 定义中实例化 bean。

**2、** Spring 使用依赖注入填充所有属性，如 bean 中所定义的配置。

**3、** 如果 bean 实现 BeanNameAware 接口，则工厂通过传递 bean 的 ID 来调用 setBeanName()。

**4、** 如果 bean 实现 BeanFactoryAware 接口，工厂通过传递自身的实例来调用 setBeanFactory()。

**5、** 如果存在与 bean 关联的任何 BeanPostProcessors，则调用 preProcessBeforeInitialization() 方法。

**6、** 如果为 bean 指定了 init 方法（ `<bean>` 的 init-method 属性），那么将调用它。

**7、** 最后，如果存在与 bean 关联的任何 BeanPostProcessors，则将调用 postProcessAfterInitialization() 方法。

**8、** 如果 bean 实现 DisposableBean 接口，当 spring 容器关闭时，会调用 destory()。

**9、** 如果为 bean 指定了 destroy 方法（ `<bean>` 的 destroy-method 属性），那么将调用它。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_3.png#alt=img%5C_3.png)


### 10、SpringBoot的启动器有哪几种?

基本启动器有4种：比如spring-boot-starter、spring-boot-starter-web、spring-boot-starter-aop


### 11、什么是代理?
### 12、WebApplicationContext
### 13、什么是 AOP 通知
### 14、微服务架构有哪些优势？
### 15、SpringBoot 配置文件的加载顺序
### 16、什么是耦合？
### 17、解释对象/关系映射集成模块。
### 18、什么是 Spring Framework？
### 19、解释不同方式的自动装配
### 20、spring 支持集中 bean scope？
### 21、合同测试你懂什么？
### 22、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 23、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 24、您使用了哪些starter maven依赖项？
### 25、什么是 SpringBoot 启动类注解：
### 26、什么是服务熔断
### 27、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？
### 28、SpringBoot、Spring MVC 和 Spring 有什么区别
### 29、[@Qualifier ](/Qualifier ) 注解有什么用？
### 30、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 31、SpringBoot如何配置log4j？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
