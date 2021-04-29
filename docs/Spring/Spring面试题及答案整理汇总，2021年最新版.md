# Spring面试题及答案整理汇总，2021年最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是SpringBoot？

Spring boot是微服务面试问题的主要话题。 随着新功能的加入，Spring变得越来越复杂。无论何时启动新项目，都必须添加新的构建路径或Maven依赖项。简而言之，你需要从头开始做每件事。SpringBoot是一种帮助您避免所有代码配置的解决方案。


### 2、Zuul与Nginx有什么区别？

Zuul是java语言实现的，主要为java服务提供网关服务，尤其在微服务架构中可以更加灵活的对网关进行操作。Nginx是使用C语言实现，性能高于Zuul，但是实现自定义操作需要熟悉lua语言，对程序员要求较高，可以使用Nginx做Zuul集群。


### 3、解释不同方式的自动装配 。

有五种自动装配的方式，可以用来指导Spring容器用自动装配方式来进行依赖注入。

**1、** no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。

**2、** byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。

**3、** byType:：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。

**4、** constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。

**5、** autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。


### 4、22。你能否给出关于休息和微服务的要点？

虽然您可以通过多种方式实现微服务，但REST over HTTP是实现微服务的一种方式。REST还可用于其他应用程序，如Web应用程序，API设计和MVC应用程序，以提供业务数据。

微服务是一种体系结构，其中系统的所有组件都被放入单独的组件中，这些组件可以单独构建，部署和扩展。微服务的某些原则和最佳实践有助于构建弹性应用程序。

简而言之，您可以说REST是构建微服务的媒介。


### 5、如果在拦截请求中，我想拦截get方式提交的方法,怎么配置



可以在@RequestMapping注解里面加上method=RequestMethod.GET。


### 6、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

**1、** 配置变更

**2、** JDK 版本升级

**3、** 第三方类库升级

**4、** 响应式 Spring 编程支持

**5、** HTTP/2 支持

**6、** 配置属性绑定

**7、** 更多改进与加强…


### 7、什么是 Hystrix 断路器？我们需要它吗？

由于某些原因，employee-consumer 公开服务会引发异常。在这种情况下使用 Hystrix 我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_13.png#alt=45%5C_13.png)

中断，并且员工使用者将一起跳过 firtsPage 方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_14.png#alt=45%5C_14.png)


### 8、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？

**1、** @Component： 这将 java 类标记为 bean。 它是任何 Spring 管理组件的通用构造型。 spring 的组件扫描机制现在可以将其拾取并将其拉入应用程序环境中。

**2、** @Controller： 这将一个类标记为 Spring Web MVC 控制器。 标有它的 Bean 会自动导入到 IoC 容器中。

**3、** @Service： 此注解是组件注解的特化。 它不会对 [@Component ](/Component ) 注解提供任何其他行为。 您可以在服务层类中使用 [@Service ](/Service ) 而不是 @Component，因为它以更好的方式指定了意图。

**4、** @Repository： 这个注解是具有类似用途和功能的 [@Component ](/Component ) 注解的特化。 它为 DAO 提供了额外的好处。 它将 DAO 导入 IoC 容器，并使未经检查的异常有资格转换为 Spring DataAccessException。


### 9、Async异步调用方法

在SpringBoot中使用异步调用是很简单的，只需要在方法上使用@Async注解即可实现方法的异步调用。 注意：需要在启动类加入@EnableAsync使异步调用@Async注解生效。


### 10、解释WEB 模块。

Spring的WEB模块是构建在application context 模块基础之上，提供一个适合web应用的上下文。这个模块也包括支持多种面向web的任务，如透明地处理多个文件上传请求和程序级请求参数的绑定到你的业务对象。它也有对Jakarta Struts的支持。


### 11、如何在 SpringBoot 中添加通用的 JS 代码？
### 12、SpringBoot 实现热部署有哪几种方式？
### 13、SpringBoot 中如何解决跨域问题 ?
### 14、Spring框架中的单例bean是线程安全的吗?
### 15、访问RESTful微服务的方法是什么？
### 16、[@RequestMapping ](/RequestMapping ) 注解
### 17、你如何理解 SpringBoot 配置加载顺序？
### 18、如何在 SpringBoot中禁用 Actuator端点安全性?
### 19、第⼀层缓存：
### 20、什么是OAuth？
### 21、如何使用SpringBoot实现异常处理?
### 22、如何使用 SpringBoot 实现分页和排序？
### 23、不同版本的 Spring Framework 有哪些主要功能？
### 24、Spring支持的事务管理类型
### 25、什么是微服务中的反应性扩展？
### 26、如何使用 SpringBoot 实现全局异常处理？
### 27、保护 SpringBoot 应用有哪些方法？
### 28、你如何理解 SpringBoot 配置加载顺序？
### 29、Eureka怎么实现高可用
### 30、[@RequestMapping ](/RequestMapping ) 注解




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
