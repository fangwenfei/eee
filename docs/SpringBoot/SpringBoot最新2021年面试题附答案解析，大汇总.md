# SpringBoot最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 如何设置支持跨域请求？

现代浏览器出于安全的考虑， HTTP 请求时必须遵守同源策略，否则就是跨域的 HTTP 请求，默认情况下是被禁止的，IP（域名）不同、或者端口不同、协议不同（比如 HTTP、HTTPS）都会造成跨域问题。

**一般前端的解决方案有：**

**1、** 使用 JSONP 来支持跨域的请求，JSONP 实现跨域请求的原理简单的说，就是动态创建`<script>`标签，然后利用`<script>`的 SRC 不受同源策略约束来跨域获取数据。缺点是需要后端配合输出特定的返回信息。

**2、** 利用反应代理的机制来解决跨域的问题，前端请求的时候先将请求发送到同源地址的后端，通过后端请求转发来避免跨域的访问。

后来 HTML5 支持了 CORS 协议。CORS 是一个 W3C 标准，全称是”跨域资源共享”（Cross-origin resource sharing），允许浏览器向跨源服务器，发出 XMLHttpRequest 请求，从而克服了 AJAX 只能同源使用的限制。它通过服务器增加一个特殊的 Header[Access-Control-Allow-Origin]来告诉客户端跨域的限制，如果浏览器支持 CORS、并且判断 Origin 通过的话，就会允许 XMLHttpRequest 发起跨域请求。

前端使用了 CORS 协议，就需要后端设置支持非同源的请求，SpringBoot 设置支持非同源的请求有两种方式。

第一，配置 CorsFilter。

```

@Configuration
public class GlobalCorsConfig {
    @Bean
    public CorsFilter corsFilter() {
        CorsConfiguration config = new CorsConfiguration();
          config.addAllowedOrigin("*");
          config.setAllowCredentials(true);
          config.addAllowedMethod("*");
          config.addAllowedHeader("*");
          config.addExposedHeader("*");

        UrlBasedCorsConfigurationSource configSource = new UrlBasedCorsConfigurationSource();
        configSource.registerCorsConfiguration("/**", config);

        return new CorsFilter(configSource);
    }
}
```

需要配置上述的一段代码。第二种方式稍微简单一些。

第二，在启动类上添加：

```

public class Application extends WebMvcConfigurerAdapter {

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")
                .allowCredentials(true)
                .allowedHeaders("*")
                .allowedOrigins("*")
                .allowedMethods("*");

    }
}
```


### 2、你如何理解 SpringBoot 中的 Starters？

Starters可以理解为启动器，它包含了一系列可以集成到应用里面的依赖包，你可以一站式集成 Spring 及其他技术，而不需要到处找示例代码和依赖包。如你想使用 Spring JPA 访问数据库，只要加入 spring-boot-starter-data-jpa 启动器依赖就能使用了。


### 3、spring-boot-starter-parent 有什么用 ?

我们都知道，新创建一个 SpringBoot 项目，默认都是有 parent 的，这个 parent 就是 spring-boot-starter-parent ，spring-boot-starter-parent 主要有如下作用：

**1、**  定义了 Java 编译版本为 1、8 。

**2、**  使用 UTF-8 格式编码。

**3、**  继承自 spring-boot-dependencies，这个里边定义了依赖的版本，也正是因为继承了这个依赖，所以我们在写依赖时才不需要写版本号。

**4、**  执行打包操作的配置。

**5、**  自动化的资源过滤。

**6、**  自动化的插件配置。

**7、**  针对 application、properties 和 application、yml 的资源过滤，包括通过 profile 定义的不同环境的配置文件，例如 application-dev、properties 和 application-dev、yml。

总结就是打包用的


### 4、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

**1、** SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

**2、** application 配置文件这个容易了解，主要用于 SpringBoot 项目的自动化配置。

**3、** bootstrap 配置文件有以下几个应用场景。

**4、** 使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中增加连接到配置中心的配置属性来加载外部配置中心的配置信息；

**5、** 少量固定的不能被覆盖的属性；

**6、** 少量加密/解密的场景；


### 5、SpringBoot Starter的工作原理

`我个人理解SpringBoot就是由各种Starter组合起来的，我们自己也可以开发Starter`

在sprinBoot启动时由@SpringBootApplication注解会自动去maven中读取每个starter中的spring、factories文件,该文件里配置了所有需要被创建spring容器中的bean，并且进行自动配置把bean注入SpringContext中 //（SpringContext是Spring的配置文件）


### 6、SpringBoot集成mybatis的过程

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


### 7、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?

是的，更改端口是可行的。可以使用application.properties文件更改端口。但需要提到“server.port”（即server.port=8081）。确保项目类路径中有application.properties；后续工作将由REST Spring框架接手。如果提到server.port=0，那么它将自动分配任何可用的端口。


### 8、运行 SpringBoot 有哪几种方式？

**1、**  打包用命令或者放到容器中运行

**2、**  用 Maven/ Gradle 插件运行

**3、**  直接执行 main 方法运行


### 9、如何实现 SpringBoot应用程序的安全性?

使用 `spring--startersecurityboot`--依赖项，并且必须添加安全配置。配置类将必须扩展 `WebSecurityConfigurerAdapter`并覆盖其方法。


### 10、什么是 Swagger？你用 SpringBoot 实现了它吗？

Swagger 广泛用于可视化 API，使用 Swagger UI 为前端开发人员提供在线沙箱。Swagger 是用于生成 RESTful Web 服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过 Swagger 正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。


### 11、SpringBoot 中如何解决跨域问题 ?
### 12、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 13、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 14、SpringBoot 自动配置原理
### 15、SpringData 项目所支持的关系数据存储技术：
### 16、SpringBoot 可以兼容老 Spring 项目吗，如何做？
### 17、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 18、什么是SpringBoot？
### 19、什么是JavaConfig？
### 20、SpringBoot 还提供了其它的哪些 Starter Project Options？
### 21、微服务同时调用多个接口，怎么支持事务的啊？
### 22、创建一个 SpringBoot Project 的最简单的方法是什么？
### 23、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 24、您使用了哪些 starter maven 依赖项？
### 25、SpringBoot如何实现打包
### 26、你能否举一个以 ReadOnly 为事务管理的例子？
### 27、JPA 和 Hibernate 有哪些区别？
### 28、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 29、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 30、如何禁用特定的自动配置类？
### 31、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
