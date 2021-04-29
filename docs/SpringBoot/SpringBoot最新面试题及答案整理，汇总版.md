# SpringBoot最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot有哪些优点？

减少开发，测试时间和努力。

使用JavaConfig有助于避免使用XML。

避免大量的Maven导入和各种版本冲突。

提供意见发展方法。

通过提供默认值快速开始开发。

没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 2、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 3、SpringBoot支持什么前端模板，

thymeleaf，freemarker，jsp，官方不推荐JSP会有限制


### 4、您使用了哪些 starter maven 依赖项？

使用了下面的一些依赖项：

spring-boot-starter-activemq

spring-boot-starter-security

这有助于增加更少的依赖关系，并减少版本的冲突。


### 5、Spring、SpringBoot、SpringMVC的区别？

**1、** Spring框架就像一个家族，有众多衍生产品，例如boot、mvc、jpa等等。但他们的基础都是Spring的ioc、aop。ioc提供了依赖注入的容器，aop解决了面向横切面编程，然后在此两者的基础上实现了其它延伸产品的高级功能；

**2、** springMVC是基于Servlet的一个MVC框架主要解决WEB开发的问题；

**3、** 为了简化开发的使用，从而创造性地推出了SpringBoot框架，默认优于配置


### 6、Spring Cache 三种常用的缓存注解和意义？

**1、** [@Cacheable ](/Cacheable ) ，用来声明方法是可缓存，将结果存储到缓存中以便后续使用相同参数调用时不需执行实际的方法，直接从缓存中取值。

**2、** @CachePut，使用 [@CachePut ](/CachePut ) 标注的方法在执行前，不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

**3、** @CacheEvict，是用来标注在需要清除缓存元素的方法或类上的，当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。


### 7、SpringBoot 的配置文件有哪几种格式？它们有什么区别？

.properties 和 .yml，它们的区别主要是书写格式不同。

**properties**

```
app.user.name = javastack
```

**yml**

```
app:
  user:
    name: javastack
```


### 8、什么是 Swagger？你用 SpringBoot 实现了它吗？

Swagger 广泛用于可视化 API，使用 Swagger UI 为前端开发人员提供在线沙箱。Swagger 是用于生成 RESTful Web 服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过 Swagger 正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。


### 9、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。

安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用management.security.enabled = false 来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。

如何在自定义端口上运行SpringBoot应用程序？ 为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。 server.port = 8090


### 10、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 11、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?
### 12、什么是 SpringBoot？
### 13、SpringBoot如何配置log4j？
### 14、什么是Spring Initializer?
### 15、什么是FreeMarker模板？
### 16、怎么设计无状态服务？
### 17、如何集成 SpringBoot 和 ActiveMQ？
### 18、运行 SpringBoot 有哪几种方式？
### 19、运行 SpringBoot 有哪几种方式？
### 20、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？
### 21、我们如何监视所有 SpringBoot 微服务？
### 22、开启 SpringBoot 特性有哪几种方式？
### 23、什么是 CSRF 攻击？
### 24、SpringBoot多数据源事务如何管理
### 25、什么是 Spring Profiles？
### 26、什么是 JavaConfig？
### 27、spring boot监听器流程?
### 28、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 29、开启 SpringBoot 特性有哪几种方式？
### 30、什么是 Spring Batch?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
