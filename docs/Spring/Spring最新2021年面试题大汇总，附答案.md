# Spring最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： [@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 2、什么是Spring Cloud？

Spring cloud流应用程序启动器是基于SpringBoot的Spring集成应用程序，提供与外部系统的集成。Spring cloud Task，一个生命周期短暂的微服务框架，用于快速构建执行有限数据处理的应用程序。


### 3、您对微服务架构中的语义监控有何了解？

语义监控，也称为 综合监控， 将自动化测试与监控应用程序相结合，以检测业务失败因素。


### 4、什么是 Spring Data REST?

Spring Data TEST 可以用来关于 Spring 数据库的 HATEOAS RESTful 资源。

不需要写太多代码，我们可以关于 Spring 数据库的 RESTful API。

**下面展示的是一些关于 TEST 服务器的例子**

```
POST:
URL:http：//localhost：8080/todos
Use Header:Content-Type:Type:application/json
Request Content
```


### 5、比较一下 Spring Security 和 Shiro 各自的优缺点 ?

由于 SpringBoot 官方提供了大量的非常方便的开箱即用的 Starter ，包括 Spring Security 的 Starter ，使得在 SpringBoot 中使用 Spring Security 变得更加容易，甚至只需要添加一个依赖就可以保护所有的接口，所以，如果是 SpringBoot 项目，一般选择 Spring Security 。当然这只是一个建议的组合，单纯从技术上来说，无论怎么组合，都是没有问题的。Shiro 和 Spring Security 相比

**主要有如下一些特点：**

**1、** Spring Security 是一个重量级的安全管理框架；Shiro 则是一个轻量级的安全管理框架

**2、** Spring Security 概念复杂，配置繁琐；Shiro 概念简单、配置简单

**3、** Spring Security 功能强大；Shiro 功能简单


### 6、自动装配有什么局限？

覆盖的可能性 - 您始终可以使用 `<constructor-arg>` 和 `<property>` 设置指定依赖项，这将覆盖自动装配。基本元数据类型 - 简单属性（如原数据类型，字符串和类）无法自动装配。令人困惑的性质 - 总是喜欢使用明确的装配，因为自动装配不太精确。


### 7、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

```
<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-devtools</artifactId>
<optional>true</optional>
```


### 8、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；

一些固定的不能被覆盖的属性；

一些加密/解密的场景；


### 9、SpringBoot 怎么用好自动配置，精髓:

**1、** SpringBoot启动会加载大量的自动配置类

**2、** 我们看我们需要的功能有没有SpringBoot默认写好的自动配置类;

**3、** 我们再来看这个自动配置类中到底配置了哪些组件;(只要我们要用的组件有，我们就不需要再来配置了

**4、** 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这 些属性的值;


### 10、SpringBoot 可以兼容老 Spring 项目吗，如何做？

可以兼容，使用 [@ImportResource ](/ImportResource ) 注解导入老 Spring 项目配置文件。


### 11、我们可以用微服务创建状态机吗？
### 12、什么是 AOP 目标对象?
### 13、你所知道微服务的技术栈有哪些？列举一二
### 14、Spring支持的ORM
### 15、什么是YAML？
### 16、SpringBoot有哪些优点？
### 17、哪些是重要的bean生命周期方法？ 你能重载它们吗？
### 18、有哪些类型的通知（Advice）？
### 19、什么是 AOP？
### 20、过渡到微服务时的常见错误
### 21、谈谈服务雪崩效应
### 22、什么是Spring的依赖注入？
### 23、SpringBoot的启动器有哪几种?
### 24、如何实现 SpringBoot应用程序的安全性?
### 25、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 26、spring-boot-starter-parent 有什么用 ?
### 27、什么是Spring Cloud？
### 28、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 29、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 30、如何理解 Spring 中的代理？
### 31、什么是服务熔断




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
