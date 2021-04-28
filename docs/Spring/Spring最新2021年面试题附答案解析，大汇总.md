# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、你能否举一个以 ReadOnly 为事务管理的例子？

当你从数据库读取内容的时候，你想把事物中的用户描述或者是其它描述设置为只读模式，以便于 Hebernate 不需要再次检查实体的变化。这是非常高效的。


### 2、自动装配有什么局限？

覆盖的可能性 - 您始终可以使用 `<constructor-arg>` 和 `<property>` 设置指定依赖项，这将覆盖自动装配。基本元数据类型 - 简单属性（如原数据类型，字符串和类）无法自动装配。令人困惑的性质 - 总是喜欢使用明确的装配，因为自动装配不太精确。


### 3、SpringCloud的优缺点

**优点：**

**1、** 耦合度比较低。不会影响其他模块的开发。

**2、** 减轻团队的成本，可以并行开发，不用关注其他人怎么开发，先关注自己的开发。

**3、** 配置比较简单，基本用注解就能实现，不用使用过多的配置文件。

**4、** 微服务跨平台的，可以用任何一种语言开发。

**5、** 每个微服务可以有自己的独立的数据库也有用公共的数据库。

**6、** 直接写后端的代码，不用关注前端怎么开发，直接写自己的后端代码即可，然后暴露接口，通过组件进行服务通信。

**缺点：**

1、部署比较麻烦，给运维工程师带来一定的麻烦。

2、针对数据的管理比麻烦，因为微服务可以每个微服务使用一个数据库。

3、系统集成测试比较麻烦

4、性能的监控比较麻烦。【最好开发一个大屏监控系统】

总的来说优点大过于缺点，目前看来Spring Cloud是一套非常完善的分布式框架，目前很多企业开始用微服务、Spring Cloud的优势是显而易见的。因此对于想研究微服务架构的同学来说，学习Spring Cloud是一个不错的选择。


### 4、Nginx与Ribbon的区别

Nginx是反向代理同时可以实现负载均衡，nginx拦截客户端请求采用负载均衡策略根据upstream配置进行转发，相当于请求通过nginx服务器进行转发。Ribbon是客户端负载均衡，从注册中心读取目标服务器信息，然后客户端采用轮询策略对服务直接访问，全程在客户端操作。


### 5、Spring Cloud Sleuth

Spring Cloud应用程序的分布式请求链路跟踪，支持使用Zipkin、HTrace和基于日志（例如ELK）的跟踪。


### 6、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？

@Component：这将 java 类标记为 bean。它是任何 Spring 管理组件的通用构造型。spring 的组件扫描机制现在可以将其拾取并将其拉入应用程序环境中。@Controller：这将一个类标记为 Spring Web MVC 控制器。标有它的 Bean 会自动导入到 IoC 容器中。@Service：此注解是组件注解的特化。它不会对 [@Component ](/Component ) 注解提供任何其他行为。您可以在服务层类中使用 [@Service ](/Service ) 而不是 @Component，因为它以更好的方式指定了意图。@Repository：这个注解是具有类似用途和功能的 [@Component ](/Component ) 注解的特化。它为 DAO 提供了额外的好处。它将 DAO 导入 IoC 容器，并使未经检查的异常有资格转换为 Spring DataAccessException。


### 7、spring cloud 断路器的作用是什么？

在分布式架构中，断路器模式的作用也是类似的，当某个服务单元发生故障（类似用电器发生短路）之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个错误响应，而不是长时间的等待。这样就不会使得线程因调用故障服务被长时间占用不释放，避免了故障在分布式系统中的蔓延。


### 8、Spring Cloud Netflix

Netflix OSS 开源组件集成，包括Eureka、Hystrix、Ribbon、Feign、Zuul等核心组件。

**1、** Eureka：服务治理组件，包括服务端的注册中心和客户端的服务发现机制；

**2、** Ribbon：负载均衡的服务调用组件，具有多种负载均衡调用策略；

**3、** Hystrix：服务容错组件，实现了断路器模式，为依赖服务的出错和延迟提供了容错能力；

**4、** Feign：基于Ribbon和Hystrix的声明式服务调用组件；

**5、** Zuul：API网关组件，对请求提供路由及过滤功能。


### 9、Spring Cloud Netflix(重点，这些组件用的最多)

Netflix OSS 开源组件集成，包括Eureka、Hystrix、Ribbon、Feign、Zuul等核心组件。

**1、** Eureka：服务治理组件，包括服务端的注册中心和客户端的服务发现机制；

**2、** Ribbon：负载均衡的服务调用组件，具有多种负载均衡调用策略；

**3、** Hystrix：服务容错组件，实现了断路器模式，为依赖服务的出错和延迟提供了容错能力；

**4、** Feign：基于Ribbon和Hystrix的声明式服务调用组件；

**5、** Zuul：API网关组件，对请求提供路由及过滤功能。

`我觉得SpringCloud的福音是Netflix，他把人家的组件都搬来进行封装了，使开发者能快速简单安全的使用`


### 10、spring bean 容器的生命周期是什么样的？

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


### 11、SpringBoot 是否可以使用 XML 配置 ?
### 12、什么是Idempotence以及它在哪里使用？
### 13、接⼝限流⽅法？
### 14、使用Spring Cloud有什么优势？
### 15、Container在微服务中的用途是什么？
### 16、什么是 FreeMarker 模板？
### 17、谈谈服务雪崩效应
### 18、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 19、Actuator在SpringBoot中的作用
### 20、[@RequestMapping ](/RequestMapping ) 注解
### 21、什么是Eureka的自我保护模式，
### 22、什么是YAML?
### 23、有哪些不同类型的IOC（依赖注入）方式？
### 24、eureka的缺点：
### 25、微服务之间是如何独立通讯的
### 26、Bean 工厂和 Application contexts 有什么区别？
### 27、SpringBoot有哪些优点？
### 28、SpringBoot 中的 starter 到底是什么 ?
### 29、什么是 Apache Kafka？
### 30、Spring Cloud Task
### 31、SpringBoot 怎么用好自动配置，精髓:




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
