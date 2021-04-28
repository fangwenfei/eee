# Spring最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 CSRF 攻击？

CSRF 代表跨站请求伪造。这是一种攻击，迫使最终用户在当前通过身份验证的Web 应用程序上执行不需要的操作。CSRF 攻击专门针对状态改变请求，而不是数据窃取，因为攻击者无法查看对伪造请求的响应。


### 2、什么是Spring Profiles？

Spring Profiles允许用户根据配置文件（dev，test，prod等）来注册bean。因此，当应用程序在开发中运行时，只有某些bean可以加载，而在PRODUCTION中，某些其他bean可以加载。假设我们的要求是Swagger文档仅适用于QA环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot使得使用配置文件非常简单。


### 3、什么是 Spring Batch?

`SpringBoot Batch`提供可重用的函数，这些函数在处理大量记录时非常重要；包括日志/跟踪，事务管理，作业处理统计信息，作业重新启动，跳过和资源管理。它还提供了更先进的技术服务和功能，通过优化和分区技术，可以实现极高批量和高性能批处理作业。简单以及复杂的大批量批处理作业可以高度可扩展的方式利用框架处理重要大量的信息。



### 4、什么是starter?

Starter主要是用来简化maven依赖


### 5、Spring MVC 框架有什么用？

Spring Web MVC 框架提供 模型-视图-控制器 架构和随时可用的组件，用于开发灵活且松散耦合的 Web 应用程序。MVC 模式有助于分离应用程序的不同方面，如输入逻辑，业务逻辑和 UI 逻辑，同时在所有这些元素之间提供松散耦合。


### 6、描述一下 DispatcherServlet 的工作流程

DispatcherServlet 的工作流程可以用一幅图来说明：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_7.png#alt=img%5C_7.png)

**1、** 向服务器发送 HTTP 请求，请求被前端控制器 `DispatcherServlet` 捕获。

**2、**  `DispatcherServlet` 根据 -servlet.xml  中的配置对请求的 URL 进行解析，得到请求资源标识符（URI）。然后根据该 URI，调用 `HandlerMapping` 获得该 Handler 配置的所有相关的对象（包括 Handler 对象以及 Handler 对象对应的拦截器），最后以 `HandlerExecutionChain` 对象的形式返回。

**3、**  `DispatcherServlet` 根据获得的 `Handler`，选择一个合适的 `HandlerAdapter`。（附注：如果成功获得 `HandlerAdapter`后，此时将开始执行拦截器的 preHandler(...)方法）。

**4、** 提取 `Request`中的模型数据，填充 `Handler`入参，开始执行 `Handler`（ `Controller`)。在填充 `Handler`的入参过程中，根据你的配置，Spring 将帮你做一些额外的工作：

**1、** HttpMessageConveter：将请求消息（如 Json、xml 等数据）转换成一个对象，将对象转换为指定的响应信息。

**2、** 数据转换：对请求消息进行数据转换。如 `String`转换成 `Integer`、 `Double`等。

**3、** 数据根式化：对请求消息进行数据格式化。如将字符串转换成格式化数字或格式化日期等。

**4、** 数据验证：验证数据的有效性（长度、格式等），验证结果存储到 `BindingResult`或 `Error`中。

**5、** Handler(Controller)执行完成后，向 `DispatcherServlet` 返回一个 `ModelAndView` 对象；

**6、** 根据返回的 `ModelAndView`，选择一个适合的 `ViewResolver`（必须是已经注册到 Spring 容器中的 `ViewResolver`)返回给 `DispatcherServlet`。

**7、**  `ViewResolver` 结合 `Model`和 `View`，来渲染视图。

**8、** 视图负责将渲染结果返回给客户端。


### 7、什么是微服务

**1、** 微服务是⼀种架构⻛格，也是⼀种服务；

**2、** 微服务的颗粒⽐较⼩，⼀个⼤型复杂软件应⽤由多个微服务组成，⽐如Netflix⽬前由500多的微服务组成；

**3、** 它采⽤UNIX设计的哲学，每种服务只做⼀件事，是⼀种松耦合的能够被独⽴开发和部署的⽆状态化服务（独⽴扩展、升级和可替换）。


### 8、你如何理解 SpringBoot 配置加载顺序？

在 SpringBoot 里面，可以使用以下几种方式来加载配置。

**1、** properties文件；

**2、** YAML文件；

**3、** 系统环境变量；

**4、** 命令行参数；


### 9、SOA和微服务架构之间的主要区别是什么？

SOA和微服务之间的主要区别如下：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_8.png#alt=img%5C_8.png)


### 10、什么是Spring beans?

Spring beans 是那些形成Spring应用的主干的java对象。它们被Spring IOC容器初始化，装配，和管理。这些beans通过容器中配置的元数据创建。比如，以XML文件中 的形式定义。

Spring 框架定义的beans都是单件beans。在bean tag中有个属性”singleton”，如果它被赋为TRUE，bean 就是单件，否则就是一个 prototype bean。默认是TRUE，所以所有在Spring框架中的beans 缺省都是单件。


### 11、运行 SpringBoot 有哪几种方式？
### 12、什么是 JavaConfig？
### 13、REST 和RPC对比
### 14、为什么人们会犹豫使用微服务？
### 15、什么是织入。什么是织入应用的不同点？
### 16、如何实现 SpringBoot应用程序的安全性?
### 17、什么是Eureka
### 18、SpringBoot 需要独立的容器运行吗？
### 19、不同版本的 Spring Framework 有哪些主要功能？
### 20、保护 SpringBoot 应用有哪些方法？
### 21、微服务架构的优缺点是什么？
### 22、如何实现SpringBoot应用程序的安全性？
### 23、为什么要选择微服务架构？
### 24、网关的作用是什么
### 25、微服务中如何实现 session 共享 ?
### 26、Web，RESTful API在微服务中的作用是什么？
### 27、在 Spring中如何注入一个java集合？
### 28、SpringBoot 最大的优势是什么呢？
### 29、RequestMapping 和 GetMapping 的不同之处在哪里？
### 30、微服务有哪些特点？
### 31、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
