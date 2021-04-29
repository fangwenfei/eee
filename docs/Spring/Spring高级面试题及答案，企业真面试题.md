# Spring高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、DispatcherServlet

Spring的MVC框架是围绕DispatcherServlet来设计的，它用来处理所有的HTTP请求和响应。


### 2、什么是 Spring Data REST?

Spring Data TEST 可以用来关于 Spring 数据库的 HATEOAS RESTful 资源。

不需要写太多代码，我们可以关于 Spring 数据库的 RESTful API。

**下面展示的是一些关于 TEST 服务器的例子**

```
POST:
URL:http：//localhost：8080/todos
Use Header:Content-Type:Type:application/json
Request Content
```


### 3、使用Spring通过什么方式访问Hibernate?

在Spring中有两种方式访问Hibernate：

**1、** 控制反转 Hibernate Template和 Callback。

**2、** 继承 HibernateDAOSupport提供一个AOP 拦截器。


### 4、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_13.png#alt=img%5C_13.png)

在测试目标只关注Spring MVC组件的情况下，WebMvcTest注释用于单元测试Spring MVC应用程序。在上面显示的快照中，我们只想启动ToTestController。执行此单元测试时，不会启动所有其他控制器和映射。


### 5、Spring MVC用什么对象从后台向前台传递数据的？



通过ModelMap对象,可以在这个对象里面调用put方法,把对象加到里面,前台就可以通过el表达式拿到。


### 6、Spring支持的事务管理类型

Spring支持两种类型的事务管理：

**1、** 编程式事务管理：这意味你通过编程的方式管理事务，给你带来极大的灵活性，但是难维护。

**2、** 声明式事务管理：这意味着你可以将业务代码和事务管理分离，你只需用注解和XML配置来管理事务。


### 7、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量


### 8、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？
### 9、什么是 Spring 配置文件？
### 10、什么是幂等性?它是如何使用的？
### 11、什么是端到端微服务测试？
### 12、@LoadBalanced注解的作用
### 13、什么是消费者驱动的合同（CDC）？
### 14、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?
### 15、Spring Cloud Zookeeper
### 16、您使用了哪些 starter maven 依赖项？
### 17、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 18、什么是 Hystrix 断路器？我们需要它吗？
### 19、什么是Hystrix？它如何实现容错？
### 20、如何使用SpringBoot实现分页和排序？
### 21、使用 Spring 有哪些方式？
### 22、开启 SpringBoot 特性有哪几种方式？
### 23、熔断的原理，以及如何恢复？
### 24、哪些是重要的bean生命周期方法？ 你能重载它们吗？
### 25、什么是 Spring Profiles？
### 26、什么是 AOP 代理?
### 27、项目中前后端分离部署，所以需要解决跨域的问题。
### 28、SpringBoot 中的监视器是什么？
### 29、什么是Spring引导的执行器？
### 30、区分构造函数注入和 setter 注入。
### 31、MVC是什么？MVC设计模式的好处有哪些




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
