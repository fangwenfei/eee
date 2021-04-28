# Spring面试题大汇总，2021年附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、访问RESTful微服务的方法是什么？

另一个经常被问到的微服务面试问题是如何访问RESTful微服务？你可以通过两种方法做到这一点：

**1、** 使用负载平衡的REST模板。

**2、** 使用多个微服务。


### 2、康威定律是什么？

康威定律指出，“设计系统的组织，其产生的设计等同于组织之内、组织之间的沟通结构。” 面试官可能会问反微服务面试问题，比如康威定律与微服务的关系。一些松散耦合的api形成了微服务的体系结构。这种结构非常适合小团队实现自治组件的方式。这种体系结构使组织在重组其工作流程时更加灵活。


### 3、运行 SpringBoot 有哪几种方式？

打包用命令或者放到容器中运行

用 Maven/ Gradle 插件运行

直接执行 main 方法运行


### 4、什么是 spring 装配

当 bean 在 Spring 容器中组合在一起时，它被称为装配或 bean 装配。Spring 容器需要知道需要什么 bean 以及容器应该如何使用依赖注入来将 bean 绑定在一起，同时装配 bean。


### 5、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。为了帮助我们处理这种情况，我们将使用位于的开源项目。它建立在 SpringBoot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。


### 6、SpringBoot 中的 starter 到底是什么 ?

首先，这个 Starter 并非什么新的技术点，基本上还是基于 Spring 已有功能来实现的。首先它提供了一个自动化配置类，一般命名为 `XXXAutoConfiguration` ，在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，然后通过类型安全的属性(spring、factories)注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。正因为如此，很多第三方框架，我们只需要引入依赖就可以直接使用了。当然，开发者也可以自定义 Starter


### 7、如何给Spring 容器提供配置元数据?

这里有三种重要的方法给Spring 容器提供配置元数据。

XML配置文件。

基于注解的配置。

基于java的配置。


### 8、服务网关的作用

**1、** 简化客户端调用复杂度，统一处理外部请求。

**2、** 数据裁剪以及聚合，根据不同的接口需求，对数据加工后对外。

**3、** 多渠道支持，针对不同的客户端提供不同的网关支持。

**4、** 遗留系统的微服务化改造，可以作为新老系统的中转组件。

**5、** 统一处理调用过程中的安全、权限问题。


### 9、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架


### 10、spring 提供了哪些配置方式？

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


### 11、spring DAO 有什么用？
### 12、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？
### 13、什么是微服务
### 14、链路跟踪Sleuth
### 15、SpringBoot和springcloud认识
### 16、PACT如何运作？
### 17、SpringBoot多数据源事务如何管理
### 18、什么是Spring Cloud？
### 19、SpringBoot 中如何解决跨域问题 ?
### 20、spring boot扫描流程?
### 21、微服务中如何实现 session 共享 ?
### 22、运行 SpringBoot 有哪几种方式？
### 23、什么是不同类型的双因素身份认证？
### 24、什么是YAML?
### 25、如何启用/禁用执行器？
### 26、你如何理解 SpringBoot 配置加载顺序？
### 27、SpringBoot的自动配置原理是什么
### 28、什么是SpringBoot ？
### 29、YAML 配置的优势在哪里 ?
### 30、如何重新加载SpringBoot上的更改，而无需重新启动服务器？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
