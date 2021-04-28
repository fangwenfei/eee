# SpringBoot最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、SpringBoot 的配置文件有哪几种格式？它们有什么区别？

.properties 和 .yml，它们的区别主要是书写格式不同。

**1、** properties

```
app.user.name = javastack
```

**2、** yml

```
app:
 user:
 name: javastack
```

另外，.yml 格式不支持 [@PropertySource ](/PropertySource ) 注解导入配置。


### 2、什么是SpringBoot ？

**1、** 用来简化spring应用的初始搭建以及开发过程 使用特定的方式来进行配置（properties或yml文件）

**2、** 创建独立的spring引用程序 main方法运行

**3、** 嵌入的Tomcat 无需部署war文件

**4、** 简化maven配置

**5、** 自动配置spring添加对应功能starter自动化配置

**6、** spring boot来简化spring应用开发，约定大于配置，去繁从简，just run就能创建一个独立的，产品级别的应用


### 3、什么是 Spring Batch?

`SpringBoot Batch`提供可重用的函数，这些函数在处理大量记录时非常重要；包括日志/跟踪，事务管理，作业处理统计信息，作业重新启动，跳过和资源管理。它还提供了更先进的技术服务和功能，通过优化和分区技术，可以实现极高批量和高性能批处理作业。简单以及复杂的大批量批处理作业可以高度可扩展的方式利用框架处理重要大量的信息。



### 4、什么是 Swagger？你用 SpringBoot 实现了它吗？

Swagger 广泛用于可视化 API，使用 Swagger UI 为前端开发人员提供在线沙箱。Swagger 是用于生成 RESTful Web 服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过 Swagger 正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。


### 5、什么是执行器停机？

关机是允许应用程序正常关机的端点。默认情况下，此功能不启用。你可以在应用程序属性文件中使用management . endpoint . shut down . enabled = true来启用此选项。但是该方法请谨慎使用。


### 6、如何使用 SpringBoot 实现全局异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。 我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 7、什么是Spring Initializer?

这个问题并不难，但面试官总是以此测试候选人的专业知识。

Spring Initializer是一个网络应用程序，它可以生成一个SpringBoot项目，包含快速启动所需的一切。和往常一样，我们需要一个好的项目框架；它有助于你正确创建项目结构/框架。


### 8、@SpringBootApplication注释在内部有什么用处?

作为Spring引导文档，@SpringBootApplication注释等同于同时使用@Configuration、@EnableAutoConfiguration和@ComponentScan及其默认属性。SpringBoot允许开发人员使用单个注释而不是多个注释。但是，众所周知，Spring提供了松散耦合的特性，我们可以根据项目需要为每个注释使用这些特性。


### 9、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？

如果你使用 Eclipse IDE，Eclipse maven 插件确保依赖项或者类文件的改变一经添加，就会被编译并在目标文件中准备好！在这之后，就和其它的 Java 应用程序一样了。

当你启动 java 应用程序的时候，spring boot 自动配置文件就会魔法般的启用了。

当 SpringBoot 应用程序检测到你正在开发一个 web 应用程序的时候，它就会启动 tomcat。


### 10、SpringBoot 自动配置原理是什么？

注解 @EnableAutoConfiguration, @Configuration, [@ConditionalOnClass ](/ConditionalOnClass ) 就是自动配置的核心，

@EnableAutoConfiguration 给容器导入META-INF/spring.factories 里定义的自动配置类。

筛选有效的自动配置类。

每一个自动配置类结合对应的 xxxProperties.java 读取配置文件进行自动配置功能


### 11、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 12、SpringBoot性能如何优化
### 13、SpringBoot读取配置文件的方式
### 14、如何使用SpringBoot实现分页和排序？
### 15、开启 SpringBoot 特性有哪几种方式？
### 16、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 17、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 18、保护 SpringBoot 应用有哪些方法？
### 19、什么是 JavaConfig？
### 20、如何使用SpringBoot实现异常处理?
### 21、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 22、您使用了哪些starter maven依赖项？
### 23、@RestController和@Controller的区别
### 24、SpringBoot需要独立的容器运行？
### 25、SpringBoot有哪些优点？
### 26、什么是 YAML？
### 27、什么是 SpringBoot？
### 28、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 29、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 30、SpringBoot中的监视器是什么?
### 31、如何实现 SpringBoot应用程序的安全性?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
