# Spring最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何在SpringBoot应用程序中实现Spring安全性？

实施需要最少的配置。您需要做的就是spring-boot-starter-security在pom.xml文件中添加starter。您还需要创建一个Spring配置类，它将覆盖所需的方法，同时扩展 WebSecurityConfigurerAdapter 应用程序中的安全性。这是一些示例代码：

```
package com.gkatzioura.security.securityendpoints.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;@
Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {@
    Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        authorizeRequests().
        antMatchers("/welcome").
        permitAll().anyRequest().
        authenticated().and().
        formLogin().
        permitAll().
        and().
        logout().
        permitAll();
    }
}
```


### 2、SpringCloud由什么组成

这就有很多了，我讲几个开发中最重要的

**1、** Spring Cloud Eureka：服务注册与发现

**2、** Spring Cloud Zuul：服务网关

**3、** Spring Cloud Ribbon：客户端负载均衡

**4、** Spring Cloud Feign：声明性的Web服务客户端

**5、** Spring Cloud Hystrix：断路器

**6、** Spring Cloud Config：分布式统一配置管理

**7、** 等20几个框架，开源一直在更新


### 3、什么是Spring Cloud？

在微服务中，SpringCloud是一个提供与外部系统集成的系统。它是一个敏捷的框架，可以短平快构建应用程序。与有限数量的数据处理相关联，它在微服务体系结构中起着非常重要的作用。 **以下为 Spring Cloud 的核心特性**：

**1、** 版本化/分布式配置。

**2、** 服务注册和发现。

**3、** 服务和服务之间的调用。

**4、** 路由。

**5、** 断路器和负载平衡。

**6、** 分布式消息传递。


### 4、Spring Cloud Config

Config能够管理所有微服务的配置文件

集中配置管理工具，分布式系统中统一的外部配置管理，默认使用Git来存储配置，可以支持客户端配置的刷新及加密、解密操作。


### 5、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？

使用DEV工具来实现。 通过这种依赖关系，可以节省任何更改，嵌入式 tomcat将重新启动。 使用SpringBoot有一个开发工具`Dev Tools`模块，可以重新加载 SpringBoot上的更改，而无需重新启动服务器。消除每次手动部署更改的需要。 SpringBoot在发布它的第一个版本时没有这个功能。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 6、负载平衡的意义什么？

在计算中，负载平衡可以改善跨计算机，计算机集群，网络链接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载平衡旨在优化资源使用，最大化吞吐量，最小化响应时间并避免任何单一资源的过载。使用多个组件进行负载平衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载平衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务器进程。


### 7、spring boot 核心的两个配置文件：

**1、** bootstrap (.yml 或.properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud Config 或者 Nacos 中会用到它。且 boostrap 里面的属性不能被覆盖；

**2、** application (. yml 或者 . properties)：由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 8、什么是Spring Cloud？

spring cloud 是一系列框架的有序集合。它利用 spring boot 的开发便利性巧妙地简化了分布式系统基础设施的开发，如服务发现注册、配置中心、消息总线、负载均衡、断路器、数据监控等，都可以用 spring boot 的开发风格做到一键启动和部署。


### 9、JPA 和 Hibernate 有哪些区别？

简而言之

JPA 是一个规范或者接口

Hibernate 是 JPA 的一个实现

当我们使用 JPA 的时候，我们使用 javax.persistence 包中的注释和接口时，不需要使用 hibernate 的导入包。

我们建议使用 JPA 注释，因为哦我们没有将其绑定到 Hibernate 作为实现。后来（我知道 - 小于百分之一的几率），我们可以使用另一种 JPA 实现。


### 10、[@RequestMapping ](/RequestMapping ) 注解有什么用？

[@RequestMapping ](/RequestMapping ) 注解用于将特定 HTTP 请求方法映射到将处理相应请求的控制器中的特定类/方法。

**此注解可应用于两个级别：**

类级别： 映射请求的 URL

方法级别： 映射 URL 以及 HTTP 请求方法


### 11、指出在 spring aop 中 concern 和 cross-cutting concern 的不同之处。
### 12、Eureka如何 保证AP
### 13、@ResponseBody注解的作用
### 14、什么是 Spring IOC 容器？
### 15、自动装配有哪些局限性 ?
### 16、什么是基于注解的容器配置?
### 17、什么是微服务
### 18、使用Spring框架的好处是什么？
### 19、什么是领域驱动设计？
### 20、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?
### 21、什么是JavaConfig？
### 22、运行 SpringBoot 有哪几种方式？
### 23、谈谈服务雪崩效应
### 24、如何使用SpringBoot实现异常处理？
### 25、@SpringBootApplication注释在内部有什么用处?
### 26、如何集成SpringBoot和ActiveMQ？
### 27、Spring Framework 中有多少个模块，它们分别是什么？
### 28、SpringBoot有哪些优点？
### 29、Ribbon和Feign的区别？
### 30、IOC的优点是什么？
### 31、spring 提供了哪些配置方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
