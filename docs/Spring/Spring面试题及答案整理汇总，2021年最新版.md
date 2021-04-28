# Spring面试题及答案整理汇总，2021年最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、@Controller注解的作用

**1、** 在Spring MVC 中，控制器Controller 负责处理由DispatcherServlet 分发的请求，它把用户请求的数据经过业务处理层处理之后封装成一个Model ，然后再把该Model 返回给对应的View 进行展示。在Spring MVC 中提供了一个非常简便的定义Controller 的方法，你无需继承特定的类或实现特定的接口，只需使用[@Controller ](/Controller ) 标记一个类是Controller ，然后使用[@RequestMapping ](/RequestMapping ) 和[@RequestParam ](/RequestParam ) 等一些注解用以定义URL 请求和Controller 方法之间的映射，这样的Controller 就能被外界访问到。此外Controller 不会直接依赖于HttpServletRequest 和HttpServletResponse 等HttpServlet 对象，它们可以通过Controller 的方法参数灵活的获取到。

**2、** [@Controller ](/Controller ) 用于标记在一个类上，使用它标记的类就是一个Spring MVC Controller 对象。分发处理器将会扫描使用了该注解的类的方法，并检测该方法是否使用了[@RequestMapping ](/RequestMapping ) 注解。[@Controller ](/Controller ) 只是定义了一个控制器类，而使用[@RequestMapping ](/RequestMapping ) 注解的方法才是真正处理请求的处理器。单单使用[@Controller ](/Controller ) 标记在一个类上还不能真正意义上的说它就是Spring MVC 的一个控制器类，因为这个时候Spring 还不认识它。那么要如何做Spring 才能认识它呢？这个时候就需要我们把这个控制器类交给Spring 来管理。有两种方式：

**3、** 在Spring MVC 的配置文件中定义MyController 的bean 对象。

**4、** 在Spring MVC 的配置文件中告诉Spring 该到哪里去找标记为[@Controller ](/Controller ) 的Controller 控制器。


### 2、什么是Apache Kafka？

Apache Kafka是一个分布式发布 - 订阅消息系统。它是一个可扩展的，容错的发布 - 订阅消息系统，它使我们能够构建分布式应用程序。这是一个Apache顶级项目。Kafka适合离线和在线消息消费。


### 3、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。SpringBoot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 SpringBoot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```


### 4、什么是客户证书？

客户端系统用于向远程服务器发出经过身份验证的请求的一种数字证书称为客户端证书。客户端证书在许多相互认证设计中起着非常重要的作用，为请求者的身份提供了强有力的保证。


### 5、什么是SpringBoot

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置


### 6、什么是金丝雀释放？

Canary Releasing是一种降低在生产中引入新软件版本的风险的技术。这是通过将变更缓慢地推广到一小部分用户，然后将其发布到整个基础架构，即将其提供给每个人来完成的。


### 7、[@RequestMapping ](/RequestMapping ) 注解有什么用？

[@RequestMapping ](/RequestMapping ) 注解用于将特定 HTTP 请求方法映射到将处理相应请求的控制器中的特定类/方法。此注释可应用于两个级别：

类级别：映射请求的 URL方法级别：映射 URL 以及 HTTP 请求方法


### 8、Spring配置文件

Spring配置文件是个XML 文件，这个文件包含了类信息，描述了如何配置它们，以及如何相互调用。


### 9、您对微服务有何了解？

微服务，又称微服务架构，是一种架构风格，它将应用程序构建为以业务领域为模型的小型自治服务集合 。

通俗地说，你必须看到蜜蜂如何通过对齐六角形蜡细胞来构建它们的蜂窝状物。他们最初从使用各种材料的小部分开始，并继续从中构建一个大型蜂箱。这些细胞形成图案，产生坚固的结构，将蜂窝的特定部分固定在一起。这里，每个细胞独立于另一个细胞，但它也与其他细胞相关。这意味着对一个细胞的损害不会损害其他细胞，因此，蜜蜂可以在不影响完整蜂箱的情况下重建这些细胞。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_1.png#alt=img%5C_1.png)

图1：微服务的蜂窝表示 – 微服务访谈问题

请参考上图。这里，每个六边形形状代表单独的服务组件。与蜜蜂的工作类似，每个敏捷团队都使用可用的框架和所选的技术堆栈构建单独的服务组件。就像在蜂箱中一样，每个服务组件形成一个强大的微服务架构，以提供更好的可扩展性。此外，敏捷团队可以单独处理每个服务组件的问题，而对整个应用程序没有影响或影响最小。


### 10、缓存机制：

设置了⼀个每30秒执⾏⼀次的定时任务，定时去服务端获取注册信息。获取之后，存⼊本地内存。


### 11、为什么需要域驱动设计（DDD）？
### 12、什么是 Aspect？
### 13、什么是SpringBoot？
### 14、Spring MVC与Struts2区别
### 15、IOC的优点是什么？
### 16、如何使用 SpringBoot 自动重装我的应用程序？
### 17、Spring Cache 三种常用的缓存注解和意义？
### 18、什么是Eureka
### 19、自动装配有什么局限？
### 20、服务注册和发现是什么意思？Spring Cloud如何实现？
### 21、如何集成SpringBoot和ActiveMQ？
### 22、SpringBoot 中如何实现定时任务 ?
### 23、Eureka怎么实现高可用
### 24、运行 SpringBoot 有哪几种方式？
### 25、什么是 Spring Profiles？
### 26、项目中前后端分离部署，所以需要解决跨域的问题。
### 27、过渡到微服务时的常见错误
### 28、spring cloud 和dubbo区别?
### 29、Mock或Stub有什么区别？
### 30、SpringBoot的启动器有哪几种?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
