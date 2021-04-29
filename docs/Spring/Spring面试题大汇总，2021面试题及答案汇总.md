# Spring面试题大汇总，2021面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringCloud由什么组成

这就有很多了，我讲几个开发中最重要的

**1、** Spring Cloud Eureka：服务注册与发现

**2、** Spring Cloud Zuul：服务网关

**3、** Spring Cloud Ribbon：客户端负载均衡

**4、** Spring Cloud Feign：声明性的Web服务客户端

**5、** Spring Cloud Hystrix：断路器

**6、** Spring Cloud Config：分布式统一配置管理

**7、** 等20几个框架，开源一直在更新


### 2、我们如何在测试中消除非决定论？

非确定性测试（NDT）基本上是不可靠的测试。所以，有时可能会发生它们通过，显然有时它们也可能会失败。当它们失败时，它们会重新运行通过。

从测试中删除非确定性的一些方法如下：

**1、**   隔离

**2、**   异步

**3、**   远程服务

**4、**   隔离

**5、**   时间

**6、**   资源泄漏


### 3、为什么要选择微服务架构？

这是一个非常常见的微服务面试问题，你应该准备好了！微服务架构提供了许多优点。这里有几个：

**1、** 微服务可以轻松适应其他框架或技术。

**2、** 单个进程的失败不会影响整个系统。

**3、** 为大企业和小型团队提供支持。

**4、** 可以在相对较短的时间内独立部署。


### 4、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。为了帮助我们处理这种情况，我们将使用位于的开源项目。它建立在 SpringBoot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。


### 5、您使用了哪些 starter maven 依赖项？

使用了下面的一些依赖项：

spring-boot-starter-activemq

spring-boot-starter-security

这有助于增加更少的依赖关系，并减少版本的冲突。


### 6、SpringBoot、Spring MVC 和 Spring 有什么区别？

**1、** SpringSpring最重要的特征是依赖注入。所有 `SpringModules` 不是依赖注入就是 IOC 控制反转。当我们恰当的使用 DI 或者是 IOC 的时候，我们可以开发松耦合应用。松耦合应用的单元测试可以很容易的进行。

**2、** Spring MVC提供了一种分离式的方法来开发 Web 应用。通过运用像 `DispatcherServelet`，`MoudlAndView` 和 `ViewResolver` 等一些简单的概念，开发 Web 应用将会变的非常简单。

**3、** Spring 和 SpringMVC 的问题在于需要配置大量的参数。

**4、** SpringBoot 通过一个自动配置和启动的项来目解决这个问题。为了更快的构建产品就绪应用程序，SpringBoot 提供了一些非功能性特征。


### 7、SpringBoot中的监视器是什么？

Spring boot actuator是spring启动框架中的重要功能之一。Spring boot监视器可帮助您访问生产环境中正在运行的应用程序的当前状态。有几个指标必须在生产环境中进行检查和监控。即使一些外部应用程序可能正在使用这些服务来向相关人员触发警报消息。监视器模块公开了一组可直接作为HTTP URL访问的REST端点来检查状态。


### 8、项目中前后端分离部署，所以需要解决跨域的问题。

我们使用cookie存放用户登录的信息，在spring拦截器进行权限控制，当权限不符合时，直接返回给用户固定的json结果。

当用户登录以后，正常使用；当用户退出登录状态时或者token过期时，由于拦截器和跨域的顺序有问题，出现了跨域的现象。

我们知道一个http请求，先走filter，到达servlet后才进行拦截器的处理，如果我们把cors放在filter里，就可以优先于权限拦截器执行。

```
@Configuration
public class CorsConfig {

    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        corsConfiguration.addAllowedOrigin("*");
        corsConfiguration.addAllowedHeader("*");
        corsConfiguration.addAllowedMethod("*");
        corsConfiguration.setAllowCredentials(true);
        UrlBasedCorsConfigurationSource urlBasedCorsConfigurationSource = new UrlBasedCorsConfigurationSource();
        urlBasedCorsConfigurationSource.registerCorsConfiguration("/**", corsConfiguration);
        return new CorsFilter(urlBasedCorsConfigurationSource);
    }

}
```


### 9、为什么要使用 Spring Cloud 熔断器？

当一个服务调用另一个服务，由于网络原因或者自身原因出现问题时 ，调用者就会等待被调者的响应，当更多的服务请求到这些资源时，导致更多的请求等待，这样就会发生连锁效应，断路器就是解决这一问题的。

**断路器的状态有以下几种：**

**1、** 完全打开：一定时间内，达到一定的次数无法调用，并且多次检测没有恢复的迹象，断路器完全打开，那么下次的请求不会请求到该服务。

**2、** 半开：短时间内有恢复迹象，断路器会将部分请求发送给服务，当能正常调用时，断路器关闭。

**3、** 关闭：服务一直处于正常状态，能正常调用，断路器关闭。


### 10、REST 和RPC对比

**1、** RPC主要的缺陷是服务提供方和调用方式之间的依赖太强，需要对每一个微服务进行接口的定义，并通过持续继承发布，严格版本控制才不会出现冲突。

**2、** REST是轻量级的接口，服务的提供和调用不存在代码之间的耦合，只需要一个约定进行规范。


### 11、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 12、RequestMapping 和 GetMapping 的不同之处在哪里？
### 13、你更倾向用那种事务管理类型？
### 14、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 15、如何在不使用BasePACKAGE过滤器的情况下排除程序包？
### 16、什么是Spring Batch？
### 17、Spring、SpringBoot、SpringMVC的区别？
### 18、如果在拦截请求中，我想拦截get方式提交的方法,怎么配置
### 19、什么是 Hystrix？
### 20、如何在 spring 中启动注解装配？
### 21、Spring框架的事务管理有哪些优点？
### 22、什么是 Spring IOC 容器？
### 23、什么是微服务中的反应性扩展？
### 24、可以在SpringBoot application中禁用默认的Web服务器吗？
### 25、什么是Spring Cloud Bus?
### 26、网关与过滤器有什么区别
### 27、如何设计一套API接口
### 28、如何覆盖SpringBoot项目的默认属性？
### 29、SpringBoot需要独立的容器运行？
### 30、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
