# Spring高级面试题及答案，2021版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

[@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude ](/EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 2、什么是Spring Cloud Bus?

spring cloud bus 将分布式的节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。

如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件。

**使用:**

**1、** 添加依赖

**2、** 配置rabbimq


### 3、什么是Semantic监控？

它结合了对整个应用程序的监控以及自动化测试。语义监控的主要好处是找出对您的业务更有利可图的因素。 从业务角度来看，语义监控以及服务层监控可以监控微服务。一旦检测到问题，它们就可以实现更快的隔离和 错误分类，从而减少修复所需的主要时间。它对服务层和事务层进行分类，以确定受可用性或性能不佳影响的事务。


### 4、SpringBoot 自动配置原理

**1、** SpringBoot启动的时候加载主配置类，开启了自动配置功能 @EnableAutoConfiguration

**2、** @EnableAutoConfiguration 作用:

将类路径下 META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值加入到了容器中;

每一个这样的 xxxAutoConfiguration类都是容器中的一个组件，都加入到容器中;用他们来做自动配置;

**3、** 每一个自动配置类进行自动配置功能;

根据当前不同的条件判断，决定这个配置类是否生效；

**4、** 一但这个配置类生效;这个配置类就会给容器中添加各种组件;这些组件的属性是从对应的properties类中获取 的，这些类里面的每一个属性又是和配置文件绑定的;

**5、** 所有在配置文件中能配置的属性都是在xxxxProperties类中封装者‘;配置文件能配置什么就可以参照某个功 能对应的这个属性类


### 5、区分构造函数注入和 setter 注入。
| 构造函数注入 | setter 注入 |
| --- | --- |
| 没有部分注入 | 有部分注入 |
| 不会覆盖 setter 属性 | 会覆盖 setter 属性 |
| 任意修改都会创建一个新实例 | 任意修改不会创建一个新实例 |
| 适用于设置很多属性 | 适用于设置少量属性 |



### 6、Mock或Stub有什么区别？

存根

一个有助于运行测试的虚拟对象。

在某些可以硬编码的条件下提供固定行为。

永远不会测试存根的任何其他行为。

例如，对于空堆栈，您可以创建一个只为empty（）方法返回true的存根。因此，这并不关心堆栈中是否存在元素。

嘲笑

一个虚拟对象，其中最初设置了某些属性。

此对象的行为取决于set属性。

也可以测试对象的行为。

例如，对于Customer对象，您可以通过设置名称和年龄来模拟它。您可以将age设置为12，然后测试isAdult（）方法，该方法将在年龄大于18时返回true。因此，您的Mock Customer对象适用于指定的条件。


### 7、Web，RESTful API在微服务中的作用是什么？

微服务架构基于一个概念，其中所有服务应该能够彼此交互以构建业务功能。因此，要实现这一点，每个微服务必须具有接口。这使得Web API成为微服务的一个非常重要的推动者。RESTful API基于Web的开放网络原则，为构建微服务架构的各个组件之间的接口提供了最合理的模型。


### 8、如何使用 SpringBoot 自动重装我的应用程序？

使用 SpringBoot 开发工具。

把 SpringBoot 开发工具添加进入你的项目是简单的。

把下面的依赖项添加至你的 SpringBoot Project pom.xml 中

重启应用程序，然后就可以了。

同样的，如果你想自动装载页面，有可以看看 FiveReload

```
http://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-live-reload/.
```

在我测试的时候，发现了 LiveReload 漏洞，如果你测试时也发现了，请一定要告诉我们。


### 9、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?

思考一下在你的虚拟机上部署应用程序需要些什么。

**第一步：**安装 Java

**第二步：**安装 Web 或者是应用程序的服务器（Tomat/Wbesphere/Weblogic 等等）

**第三步：**部署应用程序 war 包

如果我们想简化这些步骤，应该如何做呢？

让我们来思考如何使服务器成为应用程序的一部分？

你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了，

这个想法是嵌入式服务器的起源。

当我们创建一个可以部署的应用程序的时候，我们将会把服务器（例如，tomcat）嵌入到可部署的服务器中。

例如，对于一个 SpringBoot 应用程序来说，你可以生成一个包含 Embedded Tomcat 的应用程序 jar。你就可以想运行正常 Java 应用程序一样来运行 web 应用程序了。

嵌入式服务器就是我们的可执行单元包含服务器的二进制文件（例如，tomcat.jar）。


### 10、解释AOP模块

AOP模块用于发给我们的Spring应用做面向切面的开发， 很多支持由AOP联盟提供，这样就确保了Spring和其他AOP框架的共通性。这个模块将元数据编程引入Spring。


### 11、Spring Cloud和SpringBoot版本对应关系
### 12、SpringBoot中的监视器是什么？
### 13、如何实现SpringBoot应用程序的安全性？
### 14、eureka服务注册与发现原理
### 15、使用Spring框架的好处是什么？
### 16、SpringCloud Config 可以实现实时刷新吗？
### 17、什么是 JavaConfig？
### 18、什么是 JavaConfig？
### 19、你怎样定义类的作用域?
### 20、如何配置SpringBoot应用程序日志记录？
### 21、Docker的目的是什么？
### 22、什么是Spring beans?
### 23、Ribbon底层实现原理
### 24、有几种不同类型的自动代理？
### 25、解释JDBC抽象和DAO模块。
### 26、康威定律是什么？
### 27、spring DAO 有什么用？
### 28、一个Spring的应用看起来象什么？
### 29、什么是服务熔断
### 30、Spring MVC与Struts2区别
### 31、有哪些类型的通知（Advice）？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
