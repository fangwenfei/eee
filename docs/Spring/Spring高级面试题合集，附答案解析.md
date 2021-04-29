# Spring高级面试题合集，附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：

[@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 2、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 3、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

[@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude ](/EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 4、Spring Cloud Task

Spring Cloud Task的目标是为SpringBoot应用程序提供创建短运行期微服务的功能。在Spring Cloud Task中，我们可以灵活地动态运行任何任务，按需分配资源并在任务完成后检索结果。Tasks是Spring Cloud Data Flow中的一个基础项目，允许用户将几乎任何SpringBoot应用程序作为一个短期任务执行。


### 5、Spring Cloud 是什么

**1、** Spring Cloud是一系列框架的有序集合。它利用SpringBoot的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、智能路由、消息总线、负载均衡、断路器、数据监控等，都可以用SpringBoot的开发风格做到一键启动和部署。

**2、** Spring Cloud并没有重复制造轮子，它只是将各家公司开发的比较成熟、经得起实际考验的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理，最终给开发者留出了一套简单易懂、易部署和易维护的分布式系统开发工具包。


### 6、什么是Oauth？

开放授权协议，这允许通过在HTTP服务上启用客户端应用程序（例如第三方提供商Facebook，GitHub等）来访问资源所有者的资源。因此，您可以在不使用其凭据的情况下与另一个站点共享存储在一个站点上的资源。

OAuth允许像Facebook这样的第三方使用最终用户的帐户信息，同时保证其安全（不使用或暴露用户的密码）。它更像是代表用户的中介，同时为服务器提供访问所需信息的令牌。


### 7、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。SpringBoot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 SpringBoot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

```
<dependency>
    <groupId>org.springframework.boot</groupId>
    <artifactId>spring-boot-devtools</artifactId>
</dependency>
```


### 8、Spring Cloud Zookeeper
### 9、Spring由哪些模块组成?
### 10、[@RequestMapping ](/RequestMapping ) 注解
### 11、第⼀层缓存：
### 12、SpringCloud 和 Dubbo 有哪些区别?
### 13、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 14、什么是无所不在的语言？
### 15、我们如何监视所有SpringBoot微服务？
### 16、如何启用/禁用执行器？
### 17、spring boot监听器流程?
### 18、列举微服务技术栈
### 19、如何在 spring 中启动注解装配？
### 20、Spring Cloud Bus
### 21、什么是 AOP？
### 22、什么是SpringBoot ？
### 23、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 24、@Controller注解的作用
### 25、接⼝限流⽅法？
### 26、[@Required ](/Required ) 注解有什么用？
### 27、什么是 JavaConfig？
### 28、Spring Cloud Consul
### 29、如何使用 SpringBoot 实现分页和排序？
### 30、SpringBoot如何实现打包




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
