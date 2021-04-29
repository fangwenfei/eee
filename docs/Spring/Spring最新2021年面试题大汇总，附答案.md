# Spring最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、eureka服务注册与发现原理

**1、** 每30s发送⼼跳检测重新进⾏租约，如果客户端不能多次更新租约，它将在90s内从服务器注册中⼼移除。

**2、** 注册信息和更新会被复制到其他Eureka 节点，来⾃任何区域的客户端可以查找到注册中⼼信息，每30s发⽣⼀次复制来定位他们的服务，并进⾏远程调⽤。

**3、** 客户端还可以缓存⼀些服务实例信息，所以即使Eureka全挂掉，客户端也是可以定位到服务地址的。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_4.png#alt=45%5C_4.png)


### 2、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。

GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


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


### 4、SpringCloud Config 可以实现实时刷新吗？

springcloud config实时刷新采用SpringCloud Bus消息总线。


### 5、怎么样把ModelMap里面的数据放入Session里面？



可以在类上面加上@SessionAttributes注解,里面包含的字符串就是要放入session里面的key。


### 6、分布式配置中心有那些框架？

Apollo、zookeeper、springcloud config。


### 7、怎样开启注解装配？

注解装配在默认情况下是不开启的，为了使用注解装配，我们必须在Spring配置文件中配置 [context:annotation-config/]()元素。


### 8、SpringBoot的启动器有哪几种?
### 9、微服务之间是如何独⽴通讯的
### 10、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 11、如何使用SpringBoot实现异常处理？
### 12、缓存机制：
### 13、你对SpringBoot有什么了解？
### 14、什么是Swagger？你用SpringBoot实现了它吗？
### 15、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter
### 16、什么是Spring MVC？简单介绍下你对Spring MVC的理解？
### 17、SpringCloud的优缺点
### 18、什么是Spring Cloud Zuul（服务网关）
### 19、SpingMvc中的控制器的注解一般用哪个,有没有别的注解可以替代？
### 20、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 21、保护 SpringBoot 应用有哪些方法？
### 22、SpringBoot、Spring MVC 和 Spring 有什么区别？
### 23、什么是自动配置？
### 24、什么是断路器
### 25、如何配置SpringBoot应用程序日志记录？
### 26、列举 spring 支持的事务管理类型
### 27、如果在拦截请求中，我想拦截get方式提交的方法,怎么配置
### 28、什么是Spring MVC框架的控制器？
### 29、可以在SpringBoot application中禁用默认的Web服务器吗？
### 30、Springboot 有哪些优点？
### 31、SpringBoot性能如何优化




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
