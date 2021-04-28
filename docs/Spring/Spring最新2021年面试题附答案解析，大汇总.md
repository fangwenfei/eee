# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、@RequestMapping注解的作用

RequestMapping是一个用来处理请求地址映射的注解，可用于类或方法上。用于类上，表示类中的所有响应请求的方法都是以该地址作为父路径。

RequestMapping注解有六个属性，下面我们把她分成三类进行说明（下面有相应示例）。

**value， method**

**1、** value： 指定请求的实际地址，指定的地址可以是URI Template 模式（后面将会说明）；

**2、** method： 指定请求的method类型， GET、POST、PUT、DELETE等；

**consumes，produces**

**1、** consumes： 指定处理请求的提交内容类型（Content-Type），例如application/json, text/html;

**2、** produces: 指定返回的内容类型，仅当request请求头中的(Accept)类型中包含该指定类型才返回；

**params，headers**

**1、** params： 指定request中必须包含某些参数值是，才让该方法处理。

**2、** headers： 指定request中必须包含某些指定的header值，才能让该方法处理请求。


### 2、什么是Spring Initializer?

这个问题并不难，但面试官总是以此测试候选人的专业知识。

Spring Initializer是一个网络应用程序，它可以生成一个SpringBoot项目，包含快速启动所需的一切。和往常一样，我们需要一个好的项目框架；它有助于你正确创建项目结构/框架。


### 3、SpringBoot 配置加载顺序?

**1、** properties文件 2、YAML文件 3、系统环境变量 4、命令行参数


### 4、Spring MVC用什么对象从后台向前台传递数据的？



通过ModelMap对象,可以在这个对象里面调用put方法,把对象加到里面,前台就可以通过el表达式拿到。


### 5、我们如何监视所有SpringBoot微服务？

SpringBoot提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及50个应用程序的微服务，管理员将不得不击中所有50个应用程序的执行终端。

为了帮助我们处理这种情况，我们将使用位于

的开源项目。 它建立在SpringBoot Actuator之上，它提供了一个Web UI，使我们能够可视化多个应用程序的度量。


### 6、什么是Spring的MVC框架？

Spring 配备构建Web 应用的全功能MVC框架。Spring可以很便捷地和其他MVC框架集成，如Struts，Spring 的MVC框架用控制反转把业务对象和控制逻辑清晰地隔离。它也允许以声明的方式把请求参数和业务对象绑定。


### 7、你可以在Spring中注入一个null 和一个空字符串吗？

可以。


### 8、解释Spring框架中bean的生命周期。

**1、** Spring容器 从XML 文件中读取bean的定义，并实例化bean。

**2、** Spring根据bean的定义填充所有的属性。

**3、** 如果bean实现了BeanNameAware 接口，Spring 传递bean 的ID 到 setBeanName方法。

**4、** 如果Bean 实现了 BeanFactoryAware 接口， Spring传递beanfactory 给setBeanFactory 方法。

**5、** 如果有任何与bean相关联的BeanPostProcessors，Spring会在postProcesserBeforeInitialization()方法内调用它们。

**6、** 如果bean实现IntializingBean了，调用它的afterPropertySet方法，如果bean声明了初始化方法，调用此初始化方法。

**7、** 如果有BeanPostProcessors 和bean 关联，这些bean的postProcessAfterInitialization() 方法将被调用。

**8、** 如果bean实现了 DisposableBean，它将调用destroy()方法。


### 9、[@RequestMapping ](/RequestMapping ) 注解

该注解是用来映射一个URL到一个类或一个特定的方处理法上。



### 10、SpringBoot需要独立的容器运行？

SpringBoot不需要独立的容器就可以运行，因为在SpringBoot工程发布的jar文件里已经包含了tomcat的jar文件。SpringBoot运行的时候会创建tomcat对象，实现web服务功能。也可以将SpringBoot发布成war文件，放到tomcat文件里面运行


### 11、什么是 Aspect 切面
### 12、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 13、可以在SpringBoot application中禁用默认的Web服务器吗？
### 14、Spring Cloud Config
### 15、可以通过多少种方式完成依赖注入？
### 16、SpringCloud 和 Dubbo 有哪些区别?
### 17、SpringBoot 实现热部署有哪几种方式？
### 18、如何使用 SpringBoot 部署到不同的服务器？
### 19、什么是Spring Cloud Config?
### 20、你对SpringBoot有什么了解？
### 21、什么是编织（Weaving）？
### 22、Spring Cloud 和dubbo区别?
### 23、什么是CSRF攻击？
### 24、保护 SpringBoot 应用有哪些方法？
### 25、SpringBoot的启动器有哪几种?
### 26、什么是无所不在的语言？
### 27、什么是不同类型的微服务测试？
### 28、Spring Cloud解决了哪些问题？
### 29、什么是SpringBoot？
### 30、YAML 配置的优势在哪里 ?
### 31、如何重新加载SpringBoot上的更改，而无需重新启动服务器？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
