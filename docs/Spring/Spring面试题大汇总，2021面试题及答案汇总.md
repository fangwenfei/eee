# Spring面试题大汇总，2021面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 AOP 连接点

连接点代表一个应用程序的某个位置，在这个位置我们可以插入一个AOP切面，它实际上是个应用程序执行Spring AOP的位置。


### 2、什么是双因素身份验证？

双因素身份验证为帐户登录过程启用第二级身份验证。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_14.png#alt=img%5C_14.png)

图11： 双因素认证的表示 – 微服务访谈问题

因此，假设用户必须只输入用户名和密码，那么这被认为是单因素身份验证。


### 3、为什么在微服务中需要Reports报告和Dashboards仪表板？

报告和仪表板主要用于监视和维护微服务。有多种工具可以帮助实现此目的。报告 和仪表板可用于： 找出哪些微服务公开了哪些资源。 找出组件发生变化时受影响的服务。 提供一个简单的点，只要需要文档，就可以访问它。 部署的组件的版本。


### 4、如何实现 SpringBoot 应用程序的安全性？

为了实现 SpringBoot 的安全性，我们使用 spring-boot-starter-security 依赖项，并且必须添加安全配置。它只需要很少的代码。配置类将必须扩展WebSecurityConfigurerAdapter 并覆盖其方法。


### 5、我们如何进行跨功能测试？

跨功能测试是对非功能性需求的验证，即那些无法像普通功能那样实现的需求。


### 6、自动装配有哪些方式？

Spring 容器能够自动装配 bean。也就是说，可以通过检查 BeanFactory 的内容让 Spring 自动解析 bean 的协作者。

自动装配的不同模式：

**1、** 这是默认设置，表示没有自动装配。应使用显式 bean 引用进行装配。byName

**2、** 它根据 bean 的名称注入对象依赖项。它匹配并装配其属性与 XML 文件中由相同名称定义的 bean。byType

**3、** 它根据类型注入对象依赖项。如果属性的类型与 XML 文件中的一个 bean 名称匹配，则匹配并装配属性。构造函数

**4、** 它通过调用类的构造函数来注入依赖项。它有大量的参数。autodetect

**5、** 首先容器尝试通过构造函数使用 autowire 装配，如果不能，则尝试通过 byType 自动装配。


### 7、eureka缓存机制：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_10.png#alt=45%5C_10.png)

#
### 8、哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入？

你两种依赖方式都可以使用，构造器注入和Setter方法注入。最好的解决方案是用构造器参数实现强制依赖，setter方法实现可选依赖。


### 9、自动装配有哪些局限性 ?

**自动装配的局限性是：**

重写： 你仍需用 和  配置来定义依赖，意味着总要重写自动装配。

基本数据类型：你不能自动装配简单的属性，如基本数据类型，String字符串，和类。

模糊特性：自动装配不如显式装配精确，如果有可能，建议使用显式装配。


### 10、Spring Cloud Security

安全工具包，他可以对

**1、** 对Zuul代理中的负载均衡从前端到后端服务中获取SSO令牌

**2、** 资源服务器之间的中继令牌

**3、** 使Feign客户端表现得像`OAuth2RestTemplate`（获取令牌等）的拦截器

**4、** 在Zuul代理中配置下游身份验证

Spring Cloud Security提供了一组原语，用于构建安全的应用程序和服务，而且操作简便。可以在外部（或集中）进行大量配置的声明性模型有助于实现大型协作的远程组件系统，通常具有中央身份管理服务。它也非常易于在Cloud Foundry等服务平台中使用。在SpringBoot和Spring Security OAuth2的基础上，可以快速创建实现常见模式的系统，如单点登录，令牌中继和令牌交换。


### 11、spring boot监听器流程?
### 12、SpringBoot 中如何实现定时任务 ?
### 13、什么是 Spring Batch？
### 14、什么是Spring MVC框架的控制器？
### 15、SpringBoot自动配置的原理
### 16、什么是 Aspect 切面
### 17、MVC是什么？MVC设计模式的好处有哪些
### 18、使用 Spring 有哪些方式？
### 19、如何在自定义端口上运行 SpringBoot应用程序?
### 20、什么是Swagger？你用SpringBoot实现了它吗？
### 21、什么是REST / RESTful以及它的用途是什么？
### 22、什么是SpringBoot？
### 23、什么是 Spring Data REST?
### 24、Spring框架的事务管理有哪些优点？
### 25、微服务同时调用多个接口，怎么支持事务的啊？
### 26、如何在SpringBoot中禁用Actuator端点安全性？
### 27、WebApplicationContext
### 28、服务注册和发现是什么意思？Spring Cloud如何实现？
### 29、您使用了哪些 starter maven 依赖项？
### 30、保护 SpringBoot 应用有哪些方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
