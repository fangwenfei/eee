# Spring最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、接⼝限流⽅法？

**限制 总并发数（⽐如 数据库连接池、线程池）**

**1、** 限制 瞬时并发数（如 nginx 的 limit_conn 模块，⽤来限制 瞬时并发连接数）

**2、** 限制 时间窗⼝内的平均速率（如 Guava 的 RateLimiter、nginx 的 limit_req模块，限制每秒的平均速率）

**3、** 限制 远程接⼝ 调⽤速率

**4、** 限制 MQ 的消费速率

**5、** 可以根据⽹络连接数、⽹络流量、CPU或内存负载等来限流



### 2、设计微服务的最佳实践是什么？

以下是设计微服务的最佳实践：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_4.png#alt=img%5C_4.png)

图4：设计微服务的最佳实践 – 微服务访谈问题


### 3、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。SpringBoot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 SpringBoot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

```
<dependency>
  <groupId>org、springframework、boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```


### 4、SpringBoot 自动配置原理

**1、** SpringBoot启动的时候加载主配置类，开启了自动配置功能 @EnableAutoConfiguration

**2、** @EnableAutoConfiguration 作用:

将类路径下 META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值加入到了容器中;

每一个这样的 xxxAutoConfiguration类都是容器中的一个组件，都加入到容器中;用他们来做自动配置;

**3、** 每一个自动配置类进行自动配置功能;

根据当前不同的条件判断，决定这个配置类是否生效；

**4、** 一但这个配置类生效;这个配置类就会给容器中添加各种组件;这些组件的属性是从对应的properties类中获取 的，这些类里面的每一个属性又是和配置文件绑定的;

**5、** 所有在配置文件中能配置的属性都是在xxxxProperties类中封装者‘;配置文件能配置什么就可以参照某个功 能对应的这个属性类


### 5、什么是 spring bean？

**1、** 它们是构成用户应用程序主干的对象。

**2、** Bean 由 Spring IoC 容器管理。

**3、** 它们由 Spring IoC 容器实例化，配置，装配和管理。

**4、** Bean 是基于用户提供给容器的配置元数据创建。


### 6、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？

不是的。

Spring Initiatlizr 让创建 SpringBoot 项目变的很容易，但是，你也可以通过设置一个 maven 项目并添加正确的依赖项来开始一个项目。

在我们的 Spring 课程中，我们使用两种方法来创建项目。

第一种方法是 start.spring.io 。

另外一种方法是在项目的标题为“Basic Web Application”处进行手动设置。

手动设置一个 maven 项目

**这里有几个重要的步骤：**

**1、** 在 Eclipse 中，使用文件 - 新建 Maven 项目来创建一个新项目

**2、** 添加依赖项。

**3、** 添加 maven 插件。

**4、** 添加 SpringBoot 应用程序类。

到这里，准备工作已经做好！


### 7、什么是Spring Cloud Config?

Spring Cloud Config为分布式系统中的外部配置提供服务器和客户端支持，可以方便的对微服务各个环境下的配置进行集中式管理。Spring Cloud Config分为Config Server和Config Client两部分。Config Server负责读取配置文件，并且暴露Http API接口，Config Client通过调用Config Server的接口来读取配置文件。


### 8、什么是消费者驱动的合同（CDC）？

这基本上是用于开发微服务的模式，以便它们可以被外部系统使用。当我们处理微服务时，有一个特定的提供者构建它，并且有一个或多个使用微服务的消费者。

通常，提供程序在XML文档中指定接口。但在消费者驱动的合同中，每个服务消费者都传达了提供商期望的接口。


### 9、Spring MVC的异常处理？



可以将异常抛给Spring框架，由Spring框架来处理；我们只需要配置简单的异常处理器，在异常处理器中添视图页面即可。


### 10、什么是Spring的MVC框架？

Spring 配备构建Web 应用的全功能MVC框架。Spring可以很便捷地和其他MVC框架集成，如Struts，Spring 的MVC框架用控制反转把业务对象和控制逻辑清晰地隔离。它也允许以声明的方式把请求参数和业务对象绑定。


### 11、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 12、什么是SpringBoot？
### 13、什么是依赖注入？
### 14、如何使用 SpringBoot 自动重装我的应用程序？
### 15、使用Spring框架的好处是什么？
### 16、SpringBoot的缺点
### 17、SpringCloud有几种调用接口方式
### 18、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 19、Spring MVC里面拦截器是怎么写的
### 20、什么是Spring的内部bean？
### 21、什么是无所不在的语言？
### 22、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 23、如何集成SpringBoot和ActiveMQ？
### 24、spring-boot-starter-parent 有什么用 ?
### 25、SpringBoot和springcloud认识
### 26、@RestController和@Controller的区别
### 27、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 28、自动装配有哪些局限性 ?
### 29、Spring Cloud Sleuth
### 30、微服务之间是如何独⽴通讯的
### 31、什么是YAML？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
