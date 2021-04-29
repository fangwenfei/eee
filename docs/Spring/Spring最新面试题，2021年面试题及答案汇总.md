# Spring最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、创建一个 SpringBoot Project 的最简单的方法是什么？

Spring Initializr是启动 SpringBoot Projects 的一个很好的工具。

**我们需要做一下几步：**

**1、** 登录 Spring Initializr，按照以下方式进行选择：

**2、** 选择 com.in28minutes.SpringBoot 为组

**3、** 选择 studet-services 为组件

**4、** 选择下面的依赖项

Web

Actuator

DevTools

**5、** 点击生 GenerateProject

**6、** 将项目导入 Eclipse。文件 - 导入 - 现有的 Maven 项目


### 2、使用 Spring 访问 Hibernate 的方法有哪些？

我们可以通过两种方式使用 Spring 访问 Hibernate：

**1、** 使用 Hibernate 模板和回调进行控制反转

**2、** 扩展 HibernateDAOSupport 并应用 AOP 拦截器节点


### 3、spring 提供了哪些配置方式？

基于 xml 配置

bean 所需的依赖项和服务在 XML 格式的配置文件中指定。这些配置文件通常包含许多 bean 定义和特定于应用程序的配置选项。它们通常以 bean 标签开头。例如：

```
<bean id="studentbean" class="org.edureka.firstSpring.StudentBean">
 <property name="name" value="Edureka"></property>
</bean>
```

基于注解配置

您可以通过在相关的类，方法或字段声明上使用注解，将 bean 配置为组件类本身，而不是使用 XML 来描述 bean 装配。默认情况下，Spring 容器中未打开注解装配。因此，您需要在使用它之前在 Spring 配置文件中启用它。例如：

```
<beans>
<context:annotation-config/>
<!-- bean definitions go here -->
</beans>
```

基于 Java API 配置

Spring 的 Java 配置是通过使用 [@Bean ](/Bean ) 和 [@Configuration ](/Configuration ) 来实现。

**1、**   [@Bean ](/Bean ) 注解扮演与 `<bean/>` 元素相同的角色。

**2、**   [@Configuration ](/Configuration ) 类允许通过简单地调用同一个类中的其他 [@Bean ](/Bean ) 方法来定义 bean 间依赖关系。

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


### 4、您使用了哪些starter maven依赖项？

使用了下面的一些依赖项

```
spring-boot-starter-activemq
spring-boot-starter-security
```

这有助于增加更少的依赖关系，并减少版本的冲突。


### 5、什么是持续集成（CI）？

持续集成（CI）是每次团队成员提交版本控制更改时自动构建和测试代码的过程。这鼓励开发人员通过在每个小任务完成后将更改合并到共享版本控制存储库来共享代码和单元测试。


### 6、保护 SpringBoot 应用有哪些方法？

**1、** 在生产中使用HTTPS

**2、** 使用Snyk检查你的依赖关系

**3、** 升级到最新版本

**4、** 启用CSRF保护

**5、** 使用内容安全策略防止XSS攻击


### 7、一个Spring的应用看起来象什么？

**1、** 一个定义了一些功能的接口。

**2、** 这实现包括属性，它的Setter ， getter 方法和函数等。

**3、** Spring AOP

**4、** Spring 的XML 配置文件

**5、** 使用以上功能的客户端程序


### 8、什么是执行器停机？

关机是允许应用程序正常关机的端点。默认情况下，此功能不启用。你可以在应用程序属性文件中使用management . endpoint . shut down . enabled = true来启用此选项。但是该方法请谨慎使用。


### 9、你可以在Spring中注入一个null 和一个空字符串吗？

可以。


### 10、SpringBoot 还提供了其它的哪些 Starter Project Options？

SpringBoot 也提供了其它的启动器项目包括，包括用于开发特定类型应用程序的典型依赖项。

**1、** spring-boot-starter-web-services - SOAP Web Services；

**2、** spring-boot-starter-web - Web 和 RESTful 应用程序；

**3、** spring-boot-starter-test - 单元测试和集成测试；

**4、** spring-boot-starter-jdbc - 传统的 JDBC；

**5、** spring-boot-starter-hateoas - 为服务添加 HATEOAS 功能；

**6、** spring-boot-starter-security - 使用 SpringSecurity 进行身份验证和授权；

**7、** spring-boot-starter-data-jpa - 带有 Hibeernate 的 Spring Data JPA；

**8、** spring-boot-starter-data-rest - 使用 Spring Data REST 公布简单的 REST 服务；


### 11、什么是CSRF攻击？
### 12、怎么样把ModelMap里面的数据放入Session里面？
### 13、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 14、AOP 有哪些实现方式？
### 15、Async异步调用方法
### 16、解释不同方式的自动装配 。
### 17、spring JDBC API 中存在哪些类？
### 18、Spring Cloud OpenFeign
### 19、什么是 Apache Kafka？
### 20、Spring Cloud Task
### 21、SpringBoot 有哪些优点？
### 22、什么是YAML？
### 23、一个Spring的应用看起来象什么？
### 24、SpringBoot常用的starter有哪些？
### 25、微服务中如何实现 session 共享 ?
### 26、什么是Spring Cloud Config?
### 27、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 28、Spring Cloud Zookeeper
### 29、SpringBoot 有哪几种读取配置的方式？
### 30、什么是自动配置？
### 31、如何通过HibernateDaoSupport将Spring和Hibernate结合起来？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
