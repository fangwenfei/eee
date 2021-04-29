# SpringBoot最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、您使用了哪些 starter maven 依赖项？

使用了下面的一些依赖项：

spring-boot-starter-activemq

spring-boot-starter-security

这有助于增加更少的依赖关系，并减少版本的冲突。


### 2、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?

我们认为 Spring Data Rest 很适合快速原型制造！在大型应用程序中使用需要谨慎。

通过 Spring Data REST 你可以把你的数据实体作为 RESTful 服务直接。

当你设计 RESTful 服务器的时候，最佳实践表明，你的接口应该考虑到两件重要的事情：

你的模型范围。

你的客户。

通过 With Spring Data REST，你不需要再考虑这两个方面，只需要作为 TEST 服务实体。

这就是为什么我们建议使用 Spring Data Rest 在快速原型构造上面，或者作为项目的初始解决方法。对于完整演变项目来说，这并不是一个好的注意。


### 3、如何在自定义端口上运行SpringBoot应用程序？

为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。

```
 server.port = 8090
```


### 4、SpringBoot Starter 的工作原理是什么？

SpringBoot 在启动的时候会干这几件事情：

**1、** SpringBoot 在启动时会去依赖的 Starter 包中寻找 resources/META-INF/spring.factories 文件，然后根据文件中配置的 Jar 包去扫描项目所依赖的 Jar 包。

**2、** 根据 spring.factories 配置加载 AutoConfigure 类

**3、** 根据 [@Conditional ](/Conditional ) 注解的条件，进行自动配置并将 Bean 注入 Spring Context

总结一下，其实就是 SpringBoot 在启动的时候，按照约定去读取 SpringBoot Starter 的配置信息，再根据配置信息对资源进行初始化，并注入到 Spring 容器中。这样 SpringBoot 启动完毕后，就已经准备好了一切资源，使用过程中直接注入对应 Bean 资源即可。

这只是简单的三连环问答，不知道有多少同学能够完整的回答出来。

其实 SpringBoot 中有很多的技术点可以挖掘，今天给大家整理了十个高频 SpringBoot 面试题，希望可以在后期的面试中帮助到大家。


### 5、SpringBoot与SpringCloud 区别

SpringBoot是快速开发的Spring框架，SpringCloud是完整的微服务框架，SpringCloud依赖于SpringBoot。


### 6、什么是 YAML？

YAML 是一种人类可读的数据序列化语言。它通常用于配置文件。与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML 文件就更加结构化，而且更少混淆。可以看出 YAML 具有分层配置数据。


### 7、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息；

一些固定的不能被覆盖的属性；

一些加密/解密的场景；


### 8、SpringBoot有哪些优点？

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 9、运行 SpringBoot 有哪几种方式？

**1、** 打包成 Fat Jar ，直接使用 java -jar 运行。目前主流的做法，推荐。

**2、** 在 IDEA 或 Eclipse 中，直接运行应用的 SpringBoot 启动类的 #main(String[] args 启动。适用于开发调试场景。

**3、** 如果是 Web 项目，可以打包成 War 包，使用外部 Tomcat 或 Jetty 等容器。


### 10、spring boot监听器流程?

**1、** 通过`app.addListeners`注册进入 2、初始化一个`SpringApplicationRunListeners`进行处理

**3、** 从`spring.factories`中读取监听器处理类`EventPublishingRunListener`

**4、** 通过`createSpringFactoriesInstances`创建监听器处理类实例

**5、** 调用监听器`listeners.starting()`的方法来启动。

**6、** 底层把事件处理交给`线程池`去处理


### 11、SpringBoot的缺点
### 12、什么是执行器停机？
### 13、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 14、RequestMapping 和 GetMapping 的不同之处在哪里？
### 15、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 16、如何集成SpringBoot和ActiveMQ？
### 17、SpringBoot 日志框架：
### 18、SpringBoot的配置文件有哪几种格式？区别是什么？
### 19、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?
### 20、为什么要用SpringBoot
### 21、SpringBoot 中的监视器是什么？
### 22、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 23、SpringBoot有哪些优点？
### 24、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 25、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？
### 26、SpringBoot 中如何解决跨域问题 ?
### 27、如何实现 SpringBoot应用程序的安全性?
### 28、什么是Spring Actuator？它有什么优势？
### 29、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？
### 30、可以在SpringBoot application中禁用默认的Web服务器吗？
### 31、SpringBoot中的监视器是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
