# SpringBoot最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）

**1、** 继承Spring-boot-start-parent项目

**2、** 导入Spring-boot-dependencies项目依赖


### 2、你如何理解 SpringBoot 配置加载顺序？

在 SpringBoot 里面，可以使用以下几种方式来加载配置。

**1、** properties文件；

**2、** YAML文件；

**3、** 系统环境变量；

**4、** 命令行参数；


### 3、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用

依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 4、什么是SpringBoot？

用来简化spring应用的初始搭建以及开发过程，使用特定的方式来进行配置（`properties`或`yml`文件）创建独立的spring引用程序 main方法运行，嵌入的Tomcat 无需部署war文件，简化maven配置，自动配置spring添加对应功能starter自动化配置


### 5、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：

[@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 6、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？

让我们以 MySQL 为例来思考这个问题：

**第一步** - 把 MySQL 连接器的依赖项添加至 pom.xml

**第二步** - 从 pom.xml 中移除 H2 的依赖项

或者至少把它作为测试的范围。

**第三步** - 安装你的 MySQL 数据库

更多的来看看这里 -[https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL](https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL)

**第四步** - 配置你的 MySQL 数据库连接

配置 application.properties

```
spring.jpa.hibernate.ddl-auto=none spring.datasource.url=jdbc:MySQL://localhost:3306/todo_example
spring.datasource.username=todouser spring.datasource.password=YOUR_PASSWORD
```

**第五步** - 重新启动，你就准备好了！

就是这么简单！


### 7、什么是 Spring Data REST?

Spring Data TEST 可以用来关于 Spring 数据库的 HATEOAS RESTful 资源。

不需要写太多代码，我们可以关于 Spring 数据库的 RESTful API。

**下面展示的是一些关于 TEST 服务器的例子**

```
POST:
URL:http：//localhost：8080/todos
Use Header:Content-Type:Type:application/json
Request Content
```


### 8、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、**  容易上手，提升开发效率，为 Spring 开发提供一个更快、更简单的开发框架。

**2、**  开箱即用，远离繁琐的配置。

**3、**  提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、**  SpringBoot总结就是使编码变简单、配置变简单、部署变简单、监控变简单等等


### 9、保护 SpringBoot 应用有哪些方法？

**1、** 在生产中使用HTTPS

**2、** 使用Snyk检查你的依赖关系

**3、** 升级到最新版本

**4、** 启用CSRF保护

**5、** 使用内容安全策略防止XSS攻击


### 10、什么是YAML？

YAML是一种人类可读的数据序列化语言。它通常用于配置文件。 与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有分层配置数据。


### 11、SpringBoot性能如何优化
### 12、什么是自动配置？
### 13、SpringBoot 是否可以使用 XML 配置 ?
### 14、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 15、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 16、SpringBoot 的自动配置是如何实现的？
### 17、运行 SpringBoot 有哪几种方式？
### 18、如何实现 SpringBoot 应用程序的安全性？
### 19、如何使用SpringBoot实现分页和排序？
### 20、什么是JavaConfig？
### 21、什么是Spring Initializer?
### 22、什么是YAML?
### 23、如何启用/禁用执行器？
### 24、什么是 FreeMarker 模板？
### 25、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 26、什么是JavaConfig？
### 27、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 28、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 29、SpringBoot常用的starter有哪些？
### 30、如何使用 SpringBoot 实现异常处理？
### 31、什么是SpringBoot？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
