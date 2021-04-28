# Spring高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何使用SpringBoot实现异常处理？

Spring提供了一种使用ControllerAdvice处理异常的非常有用的方法。 我们通过实现一个ControlerAdvice类，来处理控制器类抛出的所有异常。


### 2、@Controller注解的作用

**1、** 在Spring MVC 中，控制器Controller 负责处理由DispatcherServlet 分发的请求，它把用户请求的数据经过业务处理层处理之后封装成一个Model ，然后再把该Model 返回给对应的View 进行展示。在Spring MVC 中提供了一个非常简便的定义Controller 的方法，你无需继承特定的类或实现特定的接口，只需使用[@Controller ](/Controller ) 标记一个类是Controller ，然后使用[@RequestMapping ](/RequestMapping ) 和[@RequestParam ](/RequestParam ) 等一些注解用以定义URL 请求和Controller 方法之间的映射，这样的Controller 就能被外界访问到。此外Controller 不会直接依赖于HttpServletRequest 和HttpServletResponse 等HttpServlet 对象，它们可以通过Controller 的方法参数灵活的获取到。

**2、** [@Controller ](/Controller ) 用于标记在一个类上，使用它标记的类就是一个Spring MVC Controller 对象。分发处理器将会扫描使用了该注解的类的方法，并检测该方法是否使用了[@RequestMapping ](/RequestMapping ) 注解。[@Controller ](/Controller ) 只是定义了一个控制器类，而使用[@RequestMapping ](/RequestMapping ) 注解的方法才是真正处理请求的处理器。单单使用[@Controller ](/Controller ) 标记在一个类上还不能真正意义上的说它就是Spring MVC 的一个控制器类，因为这个时候Spring 还不认识它。那么要如何做Spring 才能认识它呢？这个时候就需要我们把这个控制器类交给Spring 来管理。有两种方式：

**3、** 在Spring MVC 的配置文件中定义MyController 的bean 对象。

**4、** 在Spring MVC 的配置文件中告诉Spring 该到哪里去找标记为[@Controller ](/Controller ) 的Controller 控制器。


### 3、什么是 AOP什么是目标对象?

被一个或者多个切面所通知的对象。它通常是一个代理对象。也指被通知（advised）对象。


### 4、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？

如果你使用 Eclipse IDE，Eclipse maven 插件确保依赖项或者类文件的改变一经添加，就会被编译并在目标文件中准备好！在这之后，就和其它的 Java 应用程序一样了。

当你启动 java 应用程序的时候，spring boot 自动配置文件就会魔法般的启用了。

当 SpringBoot 应用程序检测到你正在开发一个 web 应用程序的时候，它就会启动 tomcat。


### 5、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 6、什么是Idempotence以及它在哪里使用？

幂等性是能够以这样的方式做两次事情的特性，即最终结果将保持不变，即好像它只做了一次。

用法：在远程服务或数据源中使用 Idempotence，这样当它多次接收指令时，它只处理指令一次。


### 7、SpringBoot 中如何解决跨域问题 ?

跨域可以在前端通过 JSONP 来解决，但是 JSONP 只可以发送 GET 请求，无法发送其他类型的请求，在 RESTful 风格的应用中，就显得非常鸡肋，因此我们推荐在后端通过 （CORS，Cross-origin resource sharing） 来解决跨域问题。这种解决方案并非 SpringBoot 特有的，在传统的 SSM 框架中，就可以通过 CORS 来解决跨域问题，只不过之前我们是在 XML 文件中配置 CORS ，现在可以通过实现WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。

[@Configuration ](/Configuration )

public class CorsConfig implements WebMvcConfigurer {

```
@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .maxAge(3600);
}
```

}


### 8、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 9、单片，SOA和微服务架构有什么区别？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_7.png#alt=img%5C_7.png)

图6： 单片SOA和微服务之间的比较 – 微服务访谈问题

单片架构类似于大容器，其中应用程序的所有软件组件组装在一起并紧密封装。

一个面向服务的架构是一种相互通信服务的集合。通信可以涉及简单的数据传递，也可以涉及两个或多个协调某些活动的服务。

微服务架构是一种架构风格，它将应用程序构建为以业务域为模型的小型自治服务集合。


### 10、如何在 spring 中启动注解装配？

默认情况下，Spring 容器中未打开注解装配。 因此，要使用基于注解装配，我们必须通过配置 <context： annotation-config /> 元素在 Spring 配置文件中启用它。


### 11、您对Mike Cohn的测试金字塔了解多少？
### 12、我们可以用微服务创建状态机吗？
### 13、spring 中有多少种 IOC 容器？
### 14、spring cloud 和dubbo区别?
### 15、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 16、eureka的缺点：
### 17、保护 SpringBoot 应用有哪些方法？
### 18、Spring Cloud Security
### 19、什么是 AOP Aspect 切面
### 20、eureka服务注册与发现原理
### 21、Spring Cloud和SpringBoot版本对应关系
### 22、Async异步调用方法
### 23、SpringBoot读取配置文件的方式
### 24、什么是Spring Cloud？
### 25、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 26、你如何理解 SpringBoot 配置加载顺序？
### 27、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 28、什么是双因素身份验证？
### 29、负载平衡的意义什么？
### 30、SpringBoot的自动配置原理是什么
### 31、什么是 Spring Batch?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
