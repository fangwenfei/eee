# Spring最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是微服务中的反应性扩展？

Reactive Extensions也称为Rx。这是一种设计方法，我们通过调用多个服务来收集结果，然后编译组合响应。这些调用可以是同步或异步，阻塞或非阻塞。Rx是分布式系统中非常流行的工具，与传统流程相反。

希望这些微服务面试问题可以帮助您进行微服务架构师访谈。

翻译来源：[https://www.edureka.co/blog/interview-questions/microservices-interview-questions/](https://www.edureka.co/blog/interview-questions/microservices-interview-questions/)



### 2、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是SpringBoot的核心注解，主要组合包含了以下3个注解：

**1、** @SpringBootConfiguration：组合了@Configuration注解，实现配置文件的功能。

**2、** @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

**3、** @ComponentScan：Spring组件扫描


### 3、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。

org.springframework.boot

spring-boot-devtools

true


### 4、spring-boot-starter-parent 有什么用 ?

我们都知道，新创建一个 SpringBoot 项目，默认都是有 parent 的，这个 parent 就是 spring-boot-starter-parent ，spring-boot-starter-parent 主要有如下作用：

**1、** 定义了 Java 编译版本为 1.8 。

**2、** 使用 UTF-8 格式编码。

**3、** 继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。

**4、** 执行打包操作的配置。

**5、** 自动化的资源过滤。

**6、** 自动化的插件配置。

**7、** 针对 application.properties 和 application.yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev.properties 和 application-dev.yml。


### 5、你更倾向用那种事务管理类型？

大多数Spring框架的用户选择声明式事务管理，因为它对应用代码的影响最小，因此更符合一个无侵入的轻量级容器的思想。声明式事务管理要优于编程式事务管理，虽然比编程式事务管理（这种方式允许你通过代码控制事务）少了一点灵活性。


### 6、Zuul网关如何搭建集群

使用Nginx的upstream设置Zuul服务集群，通过location拦截请求并转发到upstream，默认使用轮询机制对Zuul集群发送请求。


### 7、YAML 配置的优势在哪里 ?

YAML 现在可以算是非常流行的一种配置文件格式了，无论是前端还是后端，都可以见到 YAML 配置。那么 YAML 配置和传统的 properties 配置相比到底有哪些优势呢？

配置有序，在一些特殊的场景下，配置有序很关键

简洁明了，他还支持数组，数组中的元素可以是基本数据类型也可以是对象

相比 properties 配置文件，YAML 还有一个缺点，就是不支持 [@PropertySource ](/PropertySource ) 注解导入自定义的 YAML 配置。


### 8、什么是不同类型的双因素身份认证？
### 9、你如何理解 SpringBoot 配置加载顺序？
### 10、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：
### 11、运行 SpringBoot 有哪几种方式？
### 12、列举 Spring Framework 的优点。
### 13、Zookeeper如何 保证CP
### 14、什么是Spring Batch？
### 15、SpringBoot 有哪些优点？
### 16、描述一下 DispatcherServlet 的工作流程
### 17、什么是 SpringBoot？
### 18、什么是 CSRF 攻击？
### 19、SpringBoot中的监视器是什么？
### 20、如何使用 SpringBoot 生成一个 WAR 文件？
### 21、bootstrap.yml和application.yml有什么区别?
### 22、Spring对DAO的支持
### 23、AOP 有哪些实现方式？
### 24、Mock或Stub有什么区别？
### 25、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 26、什么是 Spring Framework？
### 27、什么是耦合和凝聚力？
### 28、微服务中如何实现 session 共享 ?
### 29、什么是 AOP切点
### 30、如何理解 Spring 中的代理？
### 31、开启 SpringBoot 特性有哪几种方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
