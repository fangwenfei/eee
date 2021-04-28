# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 Aspect 切面

AOP核心就是切面，它将多个类的通用行为封装成可重用的模块，该模块含有一组API提供横切功能。比如，一个日志模块可以被称作日志的AOP切面。根据需求的不同，一个应用程序可以有若干切面。在Spring AOP中，切面通过带有@Aspect注解的类实现。


### 2、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？

@Component：这将 java 类标记为 bean。它是任何 Spring 管理组件的通用构造型。spring 的组件扫描机制现在可以将其拾取并将其拉入应用程序环境中。@Controller：这将一个类标记为 Spring Web MVC 控制器。标有它的 Bean 会自动导入到 IoC 容器中。@Service：此注解是组件注解的特化。它不会对 [@Component ](/Component ) 注解提供任何其他行为。您可以在服务层类中使用 [@Service ](/Service ) 而不是 @Component，因为它以更好的方式指定了意图。@Repository：这个注解是具有类似用途和功能的 [@Component ](/Component ) 注解的特化。它为 DAO 提供了额外的好处。它将 DAO 导入 IoC 容器，并使未经检查的异常有资格转换为 Spring DataAccessException。


### 3、您对Distributed Transaction有何了解？

分布式事务是指单个事件导致两个或多个不能以原子方式提交的单独数据源的突变的任何情况。在微服务的世界中，它变得更加复杂，因为每个服务都是一个工作单元，并且大多数时候多个服务必须协同工作才能使业务成功。


### 4、一个 Spring Bean 定义 包含什么？

一个Spring Bean 的定义包含容器必知的所有配置元数据，包括如何创建一个bean，它的生命周期详情及它的依赖。


### 5、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。

严格来说，这两种方式各有优劣。虽然在一定程度上来说，后者牺牲了服务调用的性能，但也避免了上面提到的原生RPC带来的问题。而且REST相比RPC更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更为合适。



### 6、解释不同方式的自动装配 。

有五种自动装配的方式，可以用来指导Spring容器用自动装配方式来进行依赖注入。

**1、** no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。

**2、** byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。

**3、** byType:：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。

**4、** constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。

**5、** autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。


### 7、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？

让我们以 MySQL 为例来思考这个问题：

**第一步** - 把 MySQL 连接器的依赖项添加至 pom.xml

**第二步** - 从 pom.xml 中移除 H2 的依赖项

或者至少把它作为测试的范围。

**第三步** - 安装你的 MySQL 数据库

更多的来看看这里 -[https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL](https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL)

**第四步** - 配置你的 MySQL 数据库连接

配置 application.properties

```
spring.jpa.hibernate.ddl-auto=none spring.datasource.url=jdbc:MySQL://localhost:3306/todo_example
spring.datasource.username=todouser spring.datasource.password=YOUR_PASSWORD
```

**第五步** - 重新启动，你就准备好了！

就是这么简单！


### 8、WebApplicationContext

WebApplicationContext 继承了ApplicationContext 并增加了一些WEB应用必备的特有功能，它不同于一般的ApplicationContext ，因为它能处理主题，并找到被关联的servlet。


### 9、怎样开启注解装配？

注解装配在默认情况下是不开启的，为了使用注解装配，我们必须在Spring配置文件中配置 [context:annotation-config/]()元素。


### 10、什么是不同类型的微服务测试？

在使用微服务时，由于有多个微服务协同工作，测试变得非常复杂。因此，测试分为不同的级别。

在底层，我们有面向技术的测试，如单元测试和性能测试。这些是完全自动化的。

在中间层面，我们进行了诸如压力测试和可用性测试之类的探索性测试。

在顶层， 我们的 验收测试数量很少。这些验收测试有助于利益相关者理解和验证软件功能。


### 11、SpringBoot 提供了哪些核心功能？
### 12、开启 SpringBoot 特性有哪几种方式？
### 13、什么是 AOP 代理?
### 14、设计微服务的最佳实践是什么？
### 15、什么是Spring的依赖注入？
### 16、什么是 AOP Aspect 切面
### 17、谈谈服务雪崩效应
### 18、SpringBoot 有哪几种读取配置的方式？
### 19、SpringBoot中的监视器是什么?
### 20、什么是微服务架构
### 21、Spring Cloud Config
### 22、微服务同时调用多个接口，怎么支持事务的啊？
### 23、SpringBoot运行项目的几种方式？
### 24、核心容器（应用上下文) 模块。
### 25、如何设置服务发现？
### 26、如何在SpringBoot中禁用Actuator端点安全性？
### 27、介绍一下 WebApplicationContext
### 28、[@Required ](/Required ) 注解有什么用？
### 29、如何实现动态Zuul网关路由转发
### 30、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 31、SpringBoot、Spring MVC 和 Spring 有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
