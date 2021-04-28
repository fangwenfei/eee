# Spring高级面试题合集，附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架.


### 2、SpringBoot有哪些优点？

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 3、IOC的优点是什么？

IOC 或 依赖注入把应用的代码量降到最低。它使应用容易测试，单元测试不再需要单例和JNDI查找机制。最小的代价和最小的侵入性使松散耦合得以实现。IOC容器支持加载服务时的饿汉式初始化和懒加载。


### 4、什么是代理?

代理是通知目标对象后创建的对象。从客户端的角度看，代理对象和目标对象是一样的。


### 5、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？

SpringBoot 的核心配置文件是 application 和 bootstrap 配置文件。

application 配置文件这个容易理解，主要用于 SpringBoot 项目的自动化配置。

bootstrap 配置文件有以下几个应用场景。

使用 Spring Cloud Config 配置中心时，这时需要在 bootstrap 配置文件中添加连接到配置中心的配置属性来加载外部配置中心的配置信息； 一些固定的不能被覆盖的属性；一些加密/解密的场景


### 6、什么是基于注解的容器配置

不使用 XML 来描述 bean 装配，开发人员通过在相关的类，方法或字段声明上使用注解将配置移动到组件类本身。它可以作为 XML 设置的替代方案。例如：

Spring 的 Java 配置是通过使用 [@Bean ](/Bean ) 和 [@Configuration ](/Configuration ) 来实现。

[@Bean ](/Bean ) 注解扮演与  元素相同的角色。 [@Configuration ](/Configuration ) 类允许通过简单地调用同一个类中的其他 [@Bean ](/Bean ) 方法来定义 bean 间依赖关系。

例如：

```
@Configuration
public class StudentConfig {
    @Bean
    public StudentBean myStudent() {
        return new StudentBean();
    }
}
```


### 7、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？

是的，可以使用starter依赖项将嵌入式Tomcat替换为任何其他服务器。可以根据需要使用SpringBootStarter Jetty或SpringBootStarter作为每个项目的依赖项。


### 8、什么是 SpringBoot Stater ？

启动器是一套方便的依赖没描述符，它可以放在自己的程序中。你可以一站式的获取你所需要的 Spring 和相关技术，而不需要依赖描述符的通过示例代码搜索和复制黏贴的负载。

例如，如果你想使用 Sping 和 JPA 访问数据库，只需要你的项目包含 spring-boot-starter-data-jpa 依赖项，你就可以完美进行。


### 9、微服务架构有哪些优势？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_2.png#alt=img%5C_2.png)

图2：微服务的 优点 – 微服务访谈问题

独立开发 – 所有微服务都可以根据各自的功能轻松开发

独立部署 – 基于其服务，可以在任何应用程序中单独部署它们

故障隔离 – 即使应用程序的一项服务不起作用，系统仍可继续运行

混合技术堆栈 – 可以使用不同的语言和技术来构建同一应用程序的不同服务

粒度缩放 – 单个组件可根据需要进行缩放，无需将所有组件缩放在一起


### 10、你对SpringBoot有什么了解？

事实上，随着新功能的增加，弹簧变得越来越复杂。如果必须启动新的spring项目，则必须添加构建路径或添加maven依赖项，配置应用程序服务器，添加spring配置。所以一切都必须从头开始。

SpringBoot是解决这个问题的方法。使用spring boot可以避免所有样板代码和配置。因此，基本上认为自己就好像你正在烘烤蛋糕一样，春天就像制作蛋糕所需的成分一样，弹簧靴就是你手中的完整蛋糕。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_12.png#alt=img%5C_12.png)

图10：  SpringBoot的因素 – 微服务面试问题


### 11、微服务测试的主要障碍是什么？
### 12、SpringBoot和SpringCloud的区别？
### 13、什么是JavaConfig？
### 14、什么是SpringBoot？
### 15、区分构造函数注入和 setter 注入。
### 16、什么是Hystrix？它如何实现容错？
### 17、如何使用 SpringBoot 实现异常处理？
### 18、什么是JavaConfig？
### 19、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 20、注解原理是什么
### 21、什么是bean装配?
### 22、如何在自定义端口上运行SpringBoot应用程序？
### 23、什么是微服务架构中的DRY？
### 24、有哪些类型的通知（Advice）？
### 25、什么是依赖注入？
### 26、YAML 配置的优势在哪里 ?
### 27、运行 SpringBoot 有哪几种方式？
### 28、如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？
### 29、什么是Spring Cloud？
### 30、SpringBoot集成mybatis的过程




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
