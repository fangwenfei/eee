# SpringBoot最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SpringBoot 中如何解决跨域问题 ?

跨域可以在前端通过 JSONP 来解决，但是 JSONP 只可以发送 GET 请求，无法发送其他类型的请求，在 RESTful 风格的应用中，就显得非常鸡肋，因此我们推荐在后端通过 （CORS，Cross-origin resource sharing） 来解决跨域问题。这种解决方案并非 SpringBoot 特有的，在传统的 SSM 框架中，就可以通过 CORS 来解决跨域问题，只不过之前我们是在 XML 文件中配置 CORS ，现在可以通过实现WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。

```
  @Configuration
  public class CorsConfig implements WebMvcConfigurer {

  @Override
  public void addCorsMappings(CorsRegistry registry) {
  registry、addMapping("/**")
  、allowedOrigins("*")
  、allowCredentials(true)
  、allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
  、maxAge(3600);
  }

  }
```


### 2、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?

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


### 3、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?

思考一下在你的虚拟机上部署应用程序需要些什么。

第一步：安装 Java

第二部：安装 Web 或者是应用程序的服务器（Tomat/Wbesphere/Weblogic 等等）

第三部：部署应用程序 war 包

如果我们想简化这些步骤，应该如何做呢？

让我们来思考如何使服务器成为应用程序的一部分？

你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了，

是不是很爽？

这个想法是嵌入式服务器的起源。

当我们创建一个可以部署的应用程序的时候，我们将会把服务器（例如，tomcat）嵌入到可部署的服务器中。

例如，对于一个 SpringBoot 应用程序来说，你可以生成一个包含 Embedded Tomcat 的应用程序 jar。你就可以像运行正常 Java 应用程序一样来运行 web 应用程序了。

嵌入式服务器就是我们的可执行单元包含服务器的二进制文件（例如，tomcat.jar）。


### 4、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息； 一些固定的不能被覆盖的属性；一些加密/解密的场景


### 5、SpringBoot 中如何实现定时任务 ?

在 SpringBoot 中使用定时任务主要有两种不同的方式，一个就是使用 Spring 中的 [@Scheduled ](/Scheduled ) 注解，另一-个则是使用第三方框架 Quartz。

使用 Spring 中的 [@Scheduled ](/Scheduled ) 的方式主要通过 [@Scheduled ](/Scheduled ) 注解来实现。


### 6、如何重新加载SpringBoot上的更改，而无需重新启动服务器？

这可以使用DEV工具来实现。通过这种依赖关系，您可以节省任何更改，嵌入式tomcat将重新启动。

SpringBoot有一个开发工具（DevTools）模块，它有助于提高开发人员的生产力。Java开发人员面临的一个主要挑战是将文件更改自动部署到服务器并自动重启服务器。

开发人员可以重新加载SpringBoot上的更改，而无需重新启动服务器。这将消除每次手动部署更改的需要。SpringBoot在它的第一个版本时没有这个功能。

这是开发人员最需要的功能。DevTools模块完全满足开发人员的需求。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 7、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是SpringBoot的核心注解，主要组合包含了以下3个注解：

**1、** @SpringBootConfiguration：组合了@Configuration注解，实现配置文件的功能。

**2、** @EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：SpringBootApplication(exclude={DataSourceAutoConfiguration.class})

**3、** @ComponentScan：Spring组件扫描


### 8、如何在 SpringBoot 启动的时候运行一些特定的代码？

可以实现接口 ApplicationRunner 或者 CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个 run 方法，实现上述接口的类加入IOC容器即可生效。


### 9、SpringBoot 配置文件的加载顺序

由jar包外向jar包内进行寻找;

优先加载带profile

jar包外部的application-{profile}.properties或application.yml(带spring.profile配置文件

jar包内部的application-{profile}.properties或application.yml(带spring.profile配置文件

再来加载不带profile

jar包外部的application.properties或application.yml(不带spring.profile配置文件

jar包内部的application.properties或application.yml(不带spring.profile配置文件


### 10、如何给静态变量赋值？

SpringBoot无法通过@Value给静态变量赋值

此时需要给当前类加@Component注解，通过set方法设置@Value注解加载set方法上，set方法的参数可以任意命名，不能同属性名，此后当前工具类下的静态方法可直接使用属性值。



### 11、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 12、你能否举一个以 ReadOnly 为事务管理的例子？
### 13、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 14、开启 SpringBoot 特性有哪几种方式？
### 15、我们如何监视所有 SpringBoot 微服务？
### 16、RequestMapping 和 GetMapping 的不同之处在哪里？
### 17、SpringBoot的缺点
### 18、什么是YAML?
### 19、如何在SpringBoot中禁用Actuator端点安全性？
### 20、Springboot 有哪些优点？
### 21、什么是CSRF攻击？
### 22、如何使用SpringBoot实现异常处理？
### 23、我们如何监视所有SpringBoot微服务？
### 24、@SpringBootApplication注释在内部有什么用处?
### 25、保护 SpringBoot 应用有哪些方法？
### 26、为什么要用SpringBoot
### 27、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 28、@RestController和@Controller的区别
### 29、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 30、什么是 Apache Kafka？
### 31、微服务同时调用多个接口，怎么支持事务的啊？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
