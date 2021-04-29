# SpringBoot最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot Starter的工作原理

`我个人理解SpringBoot就是由各种Starter组合起来的，我们自己也可以开发Starter`

在sprinBoot启动时由@SpringBootApplication注解会自动去maven中读取每个starter中的spring、factories文件,该文件里配置了所有需要被创建spring容器中的bean，并且进行自动配置把bean注入SpringContext中 //（SpringContext是Spring的配置文件）


### 2、如何在自定义端口上运行 SpringBoot 应用程序？

为了在自定义端口上运行 SpringBoot 应用程序，您可以在application.properties 中指定端口。server.port = 8090


### 3、SpringBoot有哪些优点？

**SpringBoot的优点有：**

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 4、SpringBoot 的自动配置是如何实现的？

SpringBoot 项目的启动注解是：@SpringBootApplication，其实它就是由下面三个注解组成的：

**1、** [@Configuration ](/Configuration )

**2、** [@ComponentScan ](/ComponentScan )

**3、** @EnableAutoConfiguration

其中 @EnableAutoConfiguration 是实现自动配置的入口，该注解又通过 [@Import ](/Import ) 注解导入了AutoConfigurationImportSelector，在该类中加载 META-INF/spring.factories 的配置信息。然后筛选出以 EnableAutoConfiguration 为 key 的数据，加载到 IOC 容器中，实现自动配置功能！


### 5、如何在不使用BasePACKAGE过滤器的情况下排除程序包？

过滤程序包的方法不尽相同。但是弹簧启动提供了一个更复杂的选项，可以在不接触组件扫描的情况下实现这一点。在使用注释@ SpringBootApplication时，可以使用排除属性。请参阅下面的代码片段：

@SpringBootApplication(exclude= {Employee.class})

public class FooAppConfiguration {}


### 6、如何在 SpringBoot 中添加通用的 JS 代码？

在源文件夹下，创建一个名为 static 的文件夹。然后，你可以把你的静态的内容放在这里面。

例如，myapp.js 的路径是 resources\static\js\myapp.js

**

你可以参考它在 jsp 中的使用方法：**

错误：HAL browser gives me unauthorized error - Full authenticaition is required to access this resource.

该如何来修复这个错误呢？

两种方法：

方法 1：关闭安全验证

application.properties

```
management.security.enabled:FALSE
```

方法二：在日志中搜索密码并传递至请求标头中


### 7、SpringBoot多数据源拆分的思路

先在properties配置文件中配置两个数据源，创建分包mapper，使用@ConfigurationProperties读取properties中的配置，使用@MapperScan注册到对应的mapper包中


### 8、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？
### 9、什么是 FreeMarker 模板？
### 10、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 11、SpringBoot多数据源事务如何管理
### 12、什么是 WebSockets？
### 13、什么是 Spring Batch?
### 14、可以在SpringBoot application中禁用默认的Web服务器吗？
### 15、SpringBoot的启动器有哪几种?
### 16、如何实现 SpringBoot 应用程序的安全性？
### 17、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 18、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 19、什么是执行器停机？
### 20、什么是自动配置？
### 21、SpringBoot与SpringCloud 区别
### 22、如何在SpringBoot中禁用Actuator端点安全性？
### 23、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 24、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？
### 25、什么是 SpringBoot？
### 26、SpringBoot 自动配置原理是什么？
### 27、如何集成 SpringBoot 和 ActiveMQ？
### 28、怎么设计无状态服务？
### 29、什么是 JavaConfig？
### 30、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 31、SpringBoot 中如何实现定时任务 ?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
