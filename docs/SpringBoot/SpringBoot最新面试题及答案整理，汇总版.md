# SpringBoot最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、spring-boot-starter-parent有什么用？

我们都知道，新建一个SpringBoot项目，默认都是由parent的，这个parent就是spring-boot-starter-parent，spring-boot-starter-parent主要有以下作用：

**1、** 定义了Java编译版本为1.8

**2、** 使用UTF-8格式编码

**3、** 继承自spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所有我们在写依赖时才不需要写版本号。

**4、** 针对application.propertiess和application.yml的资源过滤，包括通过profile定义的不同环境的配置文件，例如application-dev.properties和application-dev.yml。


### 2、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用

来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 3、我们如何监视所有SpringBoot微服务？

SpringBoot提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及50个应用程序的微服务，管理员将不得不击中所有50个应用程序的执行终端。

为了帮助我们处理这种情况，我们将使用位于

的开源项目。 它建立在SpringBoot Actuator之上，它提供了一个Web UI，使我们能够可视化多个应用程序的度量。


### 4、SpringBoot 需要独立的容器运行吗？

可以不需要，内置了 Tomcat/ Jetty 等容器。


### 5、如何在自定义端口上运行SpringBoot应用程序？

为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。

```
 server.port = 8090
```


### 6、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


### 7、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？

这可以使用 DEV 工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat 将重新启动。SpringBoot 有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java 开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。开发人员可以重新加载 SpringBoot 上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot 在发布它的第一个版本时没有这个功能。这是开发人员最需要的功能。DevTools 模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供 H2 数据库控制台以更好地测试应用程序。

```
<dependency>
  <groupId>org、springframework、boot</groupId>
  <artifactId>spring-boot-devtools</artifactId>
</dependency>
```


### 8、什么是 Apache Kafka？

Apache Kafka 是一个分布式发布 - 订阅消息系统。它是一个可扩展的，容错的发布 - 订阅消息系统，它使我们能够构建分布式应用程序。这是一个 Apache 顶级项目。Kafka 适合离线和在线消息消费。


### 9、什么是 Spring Data REST?

Spring Data TEST 可以用来关于 Spring 数据库的 HATEOAS RESTful 资源。

不需要写太多代码，我们可以关于 Spring 数据库的 RESTful API。

**下面展示的是一些关于 TEST 服务器的例子**

```
POST:
URL:http：//localhost：8080/todos
Use Header:Content-Type:Type:application/json
Request Content
```


### 10、项目中前后端分离部署，所以需要解决跨域的问题。

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


### 11、SpringBoot 中的监视器是什么？
### 12、如何在自定义端口上运行 SpringBoot 应用程序？
### 13、如何在 SpringBoot中禁用 Actuator端点安全性?
### 14、SpringBoot需要独立的容器运行？
### 15、什么是YAML?
### 16、SpringBoot的启动器有哪几种?
### 17、Springboot 有哪些优点？
### 18、为什么我们需要 spring-boot-maven-plugin?
### 19、SpringBoot 中如何解决跨域问题 ?
### 20、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 21、如何实现 SpringBoot 应用程序的安全性？
### 22、SpringBoot 中如何实现定时任务 ?
### 23、什么是Spring Initializer?
### 24、你如何理解 SpringBoot 配置加载顺序？
### 25、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 26、SpringBoot的配置文件有哪几种格式？区别是什么？
### 27、spring boot 核心的两个配置文件：
### 28、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 29、SpringBoot微服务中如何实现 session 共享 ?
### 30、什么是 CSRF 攻击？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
