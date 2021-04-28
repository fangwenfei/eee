# Spring最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、DiscoveryClient的作用

可以从注册中心中根据服务别名获取注册的服务器信息。


### 2、dubbo服务注册与发现原理

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_5.png#alt=45%5C_5.png)

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_6.png#alt=45%5C_6.png)

调⽤关系说明：

**1、** 服务容器负责启动,加载,运⾏服务提供者。

**2、** 服务提供者在启动时,向注册中⼼注册⾃⼰提供的服务。

**3、** 服务消费者在启动时,向注册中⼼订阅⾃⼰所需的服务。

**4、** 注册中⼼返回服务提供者地址列表给消费者,如果有变更,注册中⼼将基于⻓连接推送变更数据给消费者。

**5、** 服务消费者,从提供者地址列表中,基于软负载均衡算法,选⼀台提供者进⾏调⽤,如果调⽤失败,再选另⼀台调⽤。

**6、** 服务消费者和提供者,在内存中累计调⽤次数和调⽤时间,定时每分钟发送⼀次统计数据到监控中⼼。


### 3、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston | 1.5.x |



### 4、既然Nginx可以实现网关？为什么还需要使用Zuul框架

Zuul是SpringCloud集成的网关，使用Java语言编写，可以对SpringCloud架构提供更灵活的服务。


### 5、自动装配有哪些局限性 ?

自动装配的局限性是：

**1、** 重写：你仍需用 和  配置来定义依赖，意味着总要重写自动装配。

**2、** 基本数据类型：你不能自动装配简单的属性，如基本数据类型，String字符串，和类。

**3、** 模糊特性：自动装配不如显式装配精确，如果有可能，建议使用显式装配。


### 6、哪些是重要的bean生命周期方法？你能重载它们吗？

有两个重要的bean 生命周期方法，第一个是setup ， 它是在容器加载bean的时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。

The bean 标签有两个重要的属性（init-method和destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct和@PreDestroy）。


### 7、什么是 spring bean？

**1、** 它们是构成用户应用程序主干的对象。

**2、** Bean 由 Spring IoC 容器管理。

**3、** 它们由 Spring IoC 容器实例化，配置，装配和管理。

**4、** Bean 是基于用户提供给容器的配置元数据创建。


### 8、spring 中有多少种 IOC 容器？

BeanFactory - BeanFactory 就像一个包含 bean 集合的工厂类。 它会在客户端要求时实例化 bean。

ApplicationContext - ApplicationContext 接口扩展了 BeanFactory 接口。 它在 BeanFactory 基础上提供了一些额外的功能。


### 9、如何在 SpringBoot 中添加通用的 JS 代码？

在源文件夹下，创建一个名为 static 的文件夹。然后，你可以把你的静态的内容放在这里面。

例如，myapp.js 的路径是 resources\static\js\myapp.js

**

你可以参考它在 jsp 中的使用方法：**

错误：HAL browser gives me unauthorized error - Full authenticaition is required to access this resource.

该如何来修复这个错误呢？

两种方法：

方法 1：关闭安全验证

application.properties

```
management.security.enabled:FALSE
```

方法二：在日志中搜索密码并传递至请求标头中


### 10、解释JDBC抽象和DAO模块。

通过使用JDBC抽象和DAO模块，保证数据库代码的简洁，并能避免数据库资源错误关闭导致的问题，它在各种不同的数据库的错误信息之上，提供了一个统一的异常访问层。它还利用Spring的AOP 模块给Spring应用中的对象提供事务管理服务。


### 11、[@Qualifier ](/Qualifier ) 注解有什么用？
### 12、微服务测试的主要障碍是什么？
### 13、什么是Spring Profiles？
### 14、SpringBoot事物的使用
### 15、什么是 FreeMarker 模板？
### 16、SpringBoot支持哪些嵌入式容器？
### 17、SpringBoot 的自动配置是如何实现的？
### 18、spring 支持哪些 ORM 框架
### 19、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 20、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 21、如何使用 SpringBoot 生成一个 WAR 文件？
### 22、SpringBoot 配置文件的加载顺序
### 23、使用 Spring 访问 Hibernate 的方法有哪些？
### 24、什么是DispatcherServlet
### 25、一个Spring的应用看起来象什么？
### 26、为什么要选择微服务架构？
### 27、SpringBoot 配置加载顺序?
### 28、如何在自定义端口上运行 SpringBoot应用程序?
### 29、什么是Spring Cloud？
### 30、SpringBoot常用的starter有哪些？
### 31、spring JDBC API 中存在哪些类？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
