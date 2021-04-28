# SpringBoot最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是YAML？

YAML是一种人类可读的数据序列化语言。它通常用于配置文件。 与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。


### 2、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？

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


### 3、什么是WebSockets？

WebSocket是一种计算机通信协议，通过单个TCP连接提供全双工通信信道。

![img_2.png][img_0826_04_2.png]

**1、** WebSocket是双向的 -使用WebSocket客户端或服务器可以发起消息发送。

**2、** WebSocket是全双工的 -客户端和服务器通信是相互独立的。

**3、** 单个TCP连接 -初始连接使用HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所有未来的通信

**4、** Light -与http相比，WebSocket消息数据交换要轻得多。


### 4、SpringBoot中的监视器是什么?

`Spring boot actuatorspring`是启动框架中的重要功能之一。 Spring boot监视器可访问生产环境中正在运行的应用程序的当前状态。有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为 `http url rest`访问的REST端点来检查状态。


### 5、SpringBoot 配置加载顺序?

**1、** properties文件 2、YAML文件 3、系统环境变量 4、命令行参数


### 6、spring-boot-starter-parent 有什么用 ?

我们都知道，新创建一个 SpringBoot 项目，默认都是有 parent 的，这个 parent 就是 spring-boot-starter-parent ，spring-boot-starter-parent 主要有如下作用：

**1、** 定义了 Java 编译版本为 1.8 。

**2、** 使用 UTF-8 格式编码。

**3、** 继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。

**4、** 执行打包操作的配置。

**5、** 自动化的资源过滤。

**6、** 自动化的插件配置。

**7、** 针对 application.properties 和 application.yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev.properties 和 application-dev.yml。


### 7、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：

[@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 8、SpringBoot 中如何解决跨域问题 ?

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


### 9、什么是执行器停机？

关机是允许应用程序正常关机的端点。默认情况下，此功能不启用。你可以在应用程序属性文件中使用management . endpoint . shut down . enabled = true来启用此选项。但是该方法请谨慎使用。


### 10、如何使用SpringBoot实现异常处理?

`SpringControllerAdvice`提供了一种使用处理异常的非常有用的方法。通过实现一个 `ControllerAdvice`类，来处理控制器类抛出的所有异常。


### 11、bootstrap.yml和application.yml有什么区别?
### 12、Async异步调用方法
### 13、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 14、运行 SpringBoot 有哪几种方式？
### 15、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 16、什么是 CSRF 攻击？
### 17、能否举一个例子来解释更多 Staters 的内容？
### 18、SpringBoot需要独立的容器运行？
### 19、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 20、如何给静态变量赋值？
### 21、开启 SpringBoot 特性有哪几种方式？
### 22、SpringBoot 自动配置原理
### 23、YAML 配置的优势在哪里 ?
### 24、SpringBoot 可以兼容老 Spring 项目吗，如何做？
### 25、如何实现 SpringBoot应用程序的安全性?
### 26、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 27、SpringBoot有哪些优点？
### 28、SpringBoot如何配置log4j？
### 29、你能否举一个以 ReadOnly 为事务管理的例子？
### 30、如何集成SpringBoot和ActiveMQ？
### 31、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
