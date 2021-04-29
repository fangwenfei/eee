# SpringBoot最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何在自定义端口上运行 SpringBoot应用程序?

在 `application.properties`中指定端口`serverport=8090`。


### 2、什么是 YAML？

YAML 是一种人类可读的数据序列化语言。它通常用于配置文件。与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML 文件就更加结构化，而且更少混淆。可以看出 YAML 具有分层配置数据。


### 3、如何使用 SpringBoot 实现异常处理？

Spring 提供了一种使用 ControllerAdvice 处理异常的非常有用的方法。我们通过实现一个 ControlerAdvice 类，来处理控制器类抛出的所有异常。


### 4、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？

SpringBoot支持Java Util Logging，Log4J2，Lockback作为日志框架，如果你使用Starters启动器，SpringBoot将使用Logback作为默认日志框架


### 5、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）

**1、** 继承Spring-boot-start-parent项目

**2、** 导入Spring-boot-dependencies项目依赖


### 6、您使用了哪些 starter maven 依赖项？

**使用了下面的一些依赖项**

**1、**  spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、**  spring-boot-starter-data-jpa 数据库支持

**3、**  spring-boot-starter-data-Redis Redis数据库支持

**4、**  spring-boot-starter-data-solr solr支持

**5、**  mybatis-spring-boot-starter 第三方的mybatis集成starter

自定义的starter(如果自己开发过就可以说出来)


### 7、SpringBoot有哪些优点？

**SpringBoot的优点有：**

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 8、SpringBoot集成mybatis的过程

添加mybatis的starter maven依赖

```
<dependency>
    <groupId>org.mybatis.spring.boot</groupId>
    <artifactId>mybatis-spring-boot-starter</artifactId>
    <version>1.3.2</version>
</dependency>
```

在mybatis的接口中 添加@Mapper注解

在application.yml配置数据源信息


### 9、如何使用 SpringBoot 生成一个 WAR 文件？

推荐阅读:

[https://spring.io/guides/gs/convert-jar-to-war/](https://spring.io/guides/gs/convert-jar-to-war/)

下面有 spring 说明文档直接的链接地址：

```
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging
```


### 10、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？

如果你使用 Eclipse IDE，Eclipse maven 插件确保依赖项或者类文件的改变一经添加，就会被编译并在目标文件中准备好！在这之后，就和其它的 Java 应用程序一样了。

当你启动 java 应用程序的时候，spring boot 自动配置文件就会魔法般的启用了。

当 SpringBoot 应用程序检测到你正在开发一个 web 应用程序的时候，它就会启动 tomcat。


### 11、什么是SpringBoot ？
### 12、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 13、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 14、SpringBoot 如何设置支持跨域请求？
### 15、可以在SpringBoot application中禁用默认的Web服务器吗？
### 16、SpringBoot 中的监视器是什么？
### 17、什么是Spring Batch？
### 18、如何集成SpringBoot和ActiveMQ？
### 19、创建一个 SpringBoot Project 的最简单的方法是什么？
### 20、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 21、SpringBoot的配置文件有哪几种格式？区别是什么？
### 22、什么是YAML？
### 23、SpringBoot常用的starter有哪些？
### 24、spring-boot-starter-parent 有什么用 ?
### 25、SpringBoot读取配置文件的方式
### 26、项目中前后端分离部署，所以需要解决跨域的问题。
### 27、什么是SpringBoot？
### 28、SpringBoot多数据源拆分的思路
### 29、各服务之间通信，对Restful和Rpc这2种方式如何做选择？
### 30、如何实现SpringBoot应用程序的安全性？
### 31、SpringBoot 最大的优势是什么呢？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
