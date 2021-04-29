# SpringBoot最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cache 三种常用的缓存注解和意义？

**1、** [@Cacheable ](/Cacheable ) ，用来声明方法是可缓存，将结果存储到缓存中以便后续使用相同参数调用时不需执行实际的方法，直接从缓存中取值。

**2、** @CachePut，使用 [@CachePut ](/CachePut ) 标注的方法在执行前，不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

**3、** @CacheEvict，是用来标注在需要清除缓存元素的方法或类上的，当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。


### 2、开启 SpringBoot 特性有哪几种方式？

**1、** 继承spring-boot-starter-parent项目

**2、** 导入spring-boot-dependencies项目依赖


### 3、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量


### 4、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解 主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： [@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 5、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap.properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。


### 6、如何禁用特定的自动配置类？

若发现任何不愿使用的特定自动配置类，可以使用@EnableAutoConfiguration的排除属性。

//By using "exclude"

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

另一方面，如果类别不在类路径上，则可以使用excludeName类注解，并且指定完全限定名。

//By using "excludeName"

@EnableAutoConfiguration(excludeName={Foo.class})

此外，SpringBoot还具有控制排除自动配置类列表的功能，可以通过使用spring.autoconfigure.exclude property来实现。可以将其添加到 propertie应用程序中，并且可以添加逗号分隔的多个类。

//By using property file

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration


### 7、什么是 CSRF 攻击？

CSRF 代表跨站请求伪造。这是一种攻击，迫使最终用户在当前通过身份验证的Web 应用程序上执行不需要的操作。CSRF 攻击专门针对状态改变请求，而不是数据窃取，因为攻击者无法查看对伪造请求的响应。


### 8、如何集成SpringBoot和ActiveMQ？
### 9、SpringBoot有哪些优点？
### 10、SpringBoot支持什么前端模板，
### 11、什么是Spring Initializer?
### 12、SpringBoot、Spring MVC 和 Spring 有什么区别
### 13、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 14、SpringBoot的自动配置原理是什么
### 15、如何使用 SpringBoot 实现异常处理？
### 16、如何集成SpringBoot和ActiveMQ？
### 17、什么是Apache Kafka？
### 18、如何使用SpringBoot实现异常处理？
### 19、SpringBoot 提供了哪些核心功能？
### 20、SpringBoot 中的 starter 到底是什么 ?
### 21、运行 SpringBoot 有哪几种方式？
### 22、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？
### 23、SpringBoot微服务中如何实现 session 共享 ?
### 24、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 25、你如何理解 SpringBoot 配置加载顺序？
### 26、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 27、SpringBoot中的监视器是什么?
### 28、SpringBoot运行项目的几种方式？
### 29、RequestMapping 和 GetMapping 的不同之处在哪里？
### 30、我们如何监视所有SpringBoot微服务？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
