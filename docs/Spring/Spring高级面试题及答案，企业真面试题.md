# Spring高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在Spring框架中如何更有效地使用JDBC?

使用SpringJDBC 框架，资源管理和错误处理的代价都会被减轻。所以开发者只需写statements 和 queries从数据存取数据，JDBC也可以在Spring框架提供的模板类的帮助下更有效地被使用，这个模板叫JdbcTemplate （例子见这里here）


### 2、spring 提供了哪些配置方式？

bean 所需的依赖项和服务在 XML 格式的配置文件中指定。 这些配置文件通常包含许多 bean 定义和特定于应用程序的配置选项。 它们通常以 bean 标签开头。

**例如：**

```
<bean id="studentbean" class="org.edureka.firstSpring.StudentBean">
     <property name="name" value="Edureka"></property>
</bean>
```

**基于注解配置**

您可以通过在相关的类，方法或字段声明上使用注解，将 bean 配置为组件类本身，而不是使用 XML 来描述 bean 装配。 默认情况下，Spring 容器中未打开注解装配。 因此，您需要在使用它之前在 Spring 配置文件中启用它。 例如：

context:annotation-config/

Spring 的 Java 配置是通过使用[@Bean ](/Bean ) 和 [@Configuration ](/Configuration ) 来实现。

[@Bean ](/Bean ) 注解扮演与 元素相同的角色。 [@Configuration ](/Configuration ) 类允许通过简单地调用同一个类中的其他[@Bean ](/Bean ) 方法来定义 bean 间依赖关系。

**例如：**

```
public class StudentConfig {
    @Bean
    public StudentBean myStudent() {
        return new StudentBean();
    }
}
```


### 3、如何使用 SpringBoot 自动重装我的应用程序？

使用 SpringBoot 开发工具。

把 SpringBoot 开发工具添加进入你的项目是简单的。

把下面的依赖项添加至你的 SpringBoot Project pom.xml 中

重启应用程序，然后就可以了。

同样的，如果你想自动装载页面，有可以看看 FiveReload

```
http://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-live-reload/.
```

在我测试的时候，发现了 LiveReload 漏洞，如果你测试时也发现了，请一定要告诉我们。


### 4、什么是Spring MVC框架的控制器？

控制器提供一个访问应用程序的行为，此行为通常通过服务接口实现。控制器解析用户输入并将其转换为一个由视图呈现给用户的模型。Spring用一个非常抽象的方式实现了一个控制层，允许用户创建多种用途的控制器。


### 5、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

传递给存储库方法。


### 6、什么是bean装配?

装配，或bean 装配是指在Spring 容器中把bean组装到一起，前提是容器需要知道bean的依赖关系，如何通过依赖注入来把它们装配到一起。


### 7、如何禁用特定的自动配置类？

若发现任何不愿使用的特定自动配置类，可以使用@EnableAutoConfiguration的排除属性。

//By using "exclude"

@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})

另一方面，如果类别不在类路径上，则可以使用excludeName类注解，并且指定完全限定名。

//By using "excludeName"

@EnableAutoConfiguration(excludeName={Foo.class})

此外，SpringBoot还具有控制排除自动配置类列表的功能，可以通过使用spring.autoconfigure.exclude property来实现。可以将其添加到 propertie应用程序中，并且可以添加逗号分隔的多个类。

//By using property file

spring.autoconfigure.exclude=org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration


### 8、SpringBoot 提供了哪些核心功能？

**1、** 独立运行 Spring 项目

**2、** 内嵌 Servlet 容器

SpringBoot 可以选择内嵌 Tomcat、Jetty 或者 Undertow，这样我们无须以 war 包形式部署项目。

**3、** 提供 Starter 简化 Maven 配置

例如，当你使用了 spring-boot-starter-web ，会自动加入如下依赖：`spring-boot-starter-web` 的 pom 文件

**4、** 自动配置 Spring Bean

SpringBoot 检测到特定类的存在，就会针对这个应用做一定的配置，进行自动配置 Bean ，这样会极大地减少我们要使用的配置。

**5、** 准生产的应用监控

SpringBoot 提供基于 HTTP、JMX、SSH 对运行时的项目进行监控。

**6、** 无代码生成和 XML 配置

SpringBoot 没有引入任何形式的代码生成，它是使用的 Spring 4.0 的条件 [@Condition ](/Condition ) 注解以实现根据条件进行配置。同时使用了 Maven /Gradle 的依赖传递解析机制来实现 Spring 应用里面的自动配置。


### 9、分布式配置中心有那些框架？

Apollo、zookeeper、springcloud config。


### 10、什么是 SpringBoot 启动类注解：

@SpringBootConfiguration:SpringBoot的配置类; 标注在某个类上，表示这是一个SpringBoot的配置类; @Configuration:配置类上来标注这个注解;配置类 ----- 配置文件;配置类也是容器中的一个组件;[@Component ](/Component )

@EnableAutoConfiguration:开启自动配置功能;

以前我们需要配置的东西，SpringBoot帮我们自动配置;@EnableAutoConfiguration告诉SpringBoot开启自动配置功能;这样自动配置才能生效;

SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就失效，帮我们进行自动配置工作


### 11、Spring Cloud 实现服务注册和发现的原理是什么？
### 12、你对SpringBoot有什么了解？
### 13、什么是 Aspect 切面
### 14、SpringBoot 日志框架：
### 15、什么是Apache Kafka？
### 16、什么是Spring Cloud Gateway?
### 17、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 18、dubbo服务注册与发现原理
### 19、什么是DispatcherServlet
### 20、Spring Cloud和SpringBoot版本对应关系
### 21、架构师在微服务架构中的角色是什么？
### 22、Spring Cloud和SpringBoot版本对应关系
### 23、spring 中有多少种 IOC 容器？
### 24、[@Autowired ](/Autowired ) 注解
### 25、SpringBoot如何配置log4j？
### 26、什么是SpringBoot？
### 27、Spring MVC的异常处理？
### 28、SpringBoot 实现热部署有哪几种方式？
### 29、如何在自定义端口上运行SpringBoot应用程序？
### 30、什么是starter?
### 31、Spring Cloud Sleuth




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
