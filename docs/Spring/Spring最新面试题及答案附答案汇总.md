# Spring最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、设计微服务的最佳实践是什么？

以下是设计微服务的最佳实践：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_4.png#alt=img%5C_4.png)

图4：设计微服务的最佳实践 – 微服务访谈问题


### 2、什么是持续集成（CI）？

持续集成（CI）是每次团队成员提交版本控制更改时自动构建和测试代码的过程。这鼓励开发人员通过在每个小任务完成后将更改合并到共享版本控制存储库来共享代码和单元测试。


### 3、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？

SpringBoot支持Java Util Logging，Log4J2，Lockback作为日志框架，如果你使用Starters启动器，SpringBoot将使用Logback作为默认日志框架


### 4、Spring Cloud Gateway

Spring cloud gateway是spring官方基于Spring 5.0、SpringBoot2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供简单、有效和统一的API路由管理方式，Spring Cloud Gateway作为Spring Cloud生态系统中的网关，目标是替代Netflix Zuul，其不仅提供统一的路由方式，并且还基于Filer链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等。


### 5、spring 提供了哪些配置方式？

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


### 6、SpringBoot有哪些优点？

减少开发，测试时间和努力。

使用JavaConfig有助于避免使用XML。

避免大量的Maven导入和各种版本冲突。

提供意见发展方法。

通过提供默认值快速开始开发。

没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 7、分布式配置中心有那些框架？

Apollo、zookeeper、springcloud config。


### 8、Spring Cloud Zookeeper

SpringCloud支持三种注册方式Eureka， Consul(go语言编写)，zookeeper

Spring Cloud Zookeeper是基于Apache Zookeeper的服务治理组件。


### 9、什么是Spring的依赖注入？

依赖注入，是IOC的一个方面，是个通常的概念，它有多种解释。这概念是说你不用创建对象，而只需要描述它如何被创建。你不在代码里直接组装你的组件和服务，但是要在配置文件里描述哪些组件需要哪些服务，之后一个容器（IOC容器）负责把他们组装起来。


### 10、Ribbon和Feign的区别？

**1、** Ribbon都是调用其他服务的，但方式不同。

**2、** 启动类注解不同，Ribbon是[@RibbonClient ](/RibbonClient ) feign的是[@EnableFeignClients ](/EnableFeignClients )

**3、** 服务指定的位置不同，Ribbon是在@RibbonClient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明。

**4、** 调用方式不同，Ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。Feign需要将调用的方法定义成抽象方法即可。


### 11、dubbo服务注册与发现原理
### 12、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 13、Spring MVC的控制器是不是单例模式,如果是,有什么问题,怎么解决？
### 14、eureka服务注册与发现原理
### 15、解释AOP模块
### 16、SpringBoot Starter 的工作原理是什么？
### 17、SpringBoot 中如何解决跨域问题 ?
### 18、什么是不同类型的微服务测试？
### 19、[@Required ](/Required ) 注解
### 20、ZuulFilter常用有那些方法
### 21、Spring对DAO的支持
### 22、什么是Spring的MVC框架？
### 23、Zookeeper如何 保证CP
### 24、Eureka如何 保证AP
### 25、Spring Cloud Gateway
### 26、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 27、访问RESTful微服务的方法是什么？
### 28、[@Controller ](/Controller ) 注解
### 29、解释AOP
### 30、什么是Feign？
### 31、spring boot初始化环境变量流程?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
