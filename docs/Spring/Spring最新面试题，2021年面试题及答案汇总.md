# Spring最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何解决POST请求中文乱码问题，GET的又如何处理呢？

**解决post请求乱码问题：**

在web.xml中配置一个CharacterEncodingFilter过滤器，设置成utf-8；

```
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

**get请求中文参数出现乱码解决方法有两个：**

修改tomcat配置文件添加编码与工程编码一致，如下：

```
<ConnectorURIEncoding="utf-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
```

**另外一种方法对参数进行重新编码：**

String userName = new String(request.getParamter(“userName”).getBytes(“ISO8859-1”),“utf-8”)

ISO8859-1是tomcat默认编码，需要将tomcat编码后的内容按utf-8编码。


### 2、什么是Oauth？

开放授权协议，这允许通过在HTTP服务上启用客户端应用程序（例如第三方提供商Facebook，GitHub等）来访问资源所有者的资源。因此，您可以在不使用其凭据的情况下与另一个站点共享存储在一个站点上的资源。

OAuth允许像Facebook这样的第三方使用最终用户的帐户信息，同时保证其安全（不使用或暴露用户的密码）。它更像是代表用户的中介，同时为服务器提供访问所需信息的令牌。


### 3、什么是 Spring 配置文件？

Spring 配置文件是 XML 文件。该文件主要包含类信息。它描述了这些类是如何配置以及相互引入的。但是，XML 配置文件冗长且更加干净。如果没有正确规划和编写，那么在大项目中管理变得非常困难。


### 4、什么是Spring Cloud Zuul（服务网关）

Zuul是对SpringCloud提供的成熟对的路由方案，他会根据请求的路径不同，网关会定位到指定的微服务，并代理请求到不同的微服务接口，他对外隐蔽了微服务的真正接口地址。

三个重要概念：动态路由表，路由定位，反向代理：

**1、** 动态路由表：Zuul支持Eureka路由，手动配置路由，这俩种都支持自动更新

**2、** 路由定位：根据请求路径，Zuul有自己的一套定位服务规则以及路由表达式匹配

**3、** 反向代理：客户端请求到路由网关，网关受理之后，在对目标发送请求，拿到响应之后在 给客户端它可以和Eureka,Ribbon,Hystrix等组件配合使用，

**Zuul的应用场景：**

对外暴露，权限校验，服务聚合，日志审计等


### 5、什么是Spring IOC 容器？

Spring IOC 负责创建对象，管理对象（通过依赖注入（DI），装配对象，配置对象，并且管理这些对象的整个生命周期。


### 6、服务注册和发现是什么意思？Spring Cloud 如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。 Eureka 服务注册和发现可以在这种情况下提供帮助。由于所有服务都在 Eureka 服务器上注册并通过调用 Eureka 服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 7、什么是 AOP？

AOP(Aspect-Oriented Programming), 即 面向切面编程, 它与 OOP( Object-Oriented Programming, 面向对象编程) 相辅相成, 提供了与 OOP 不同的抽象软件结构的视角、在 OOP 中, 我们以类(class)作为我们的基本单元, 而 AOP 中的基本单元是 Aspect(切面)


### 8、什么是断路器

当一个服务调用另一个服务由于网络原因或自身原因出现问题，调用者就会等待被调用者的响应 当更多的服务请求到这些资源导致更多的请求等待，发生连锁效应（雪崩效应）

**断路器有三种状态**

**1、** 打开状态：一段时间内 达到一定的次数无法调用 并且多次监测没有恢复的迹象 断路器完全打开 那么下次请求就不会请求到该服务

**2、** 半开状态：短时间内 有恢复迹象 断路器会将部分请求发给该服务，正常调用时 断路器关闭

**3、** 关闭状态：当服务一直处于正常状态 能正常调用


### 9、如何实现 SpringBoot应用程序的安全性?

使用 `spring--startersecurityboot`--依赖项，并且必须添加安全配置。配置类将必须扩展 `WebSecurityConfigurerAdapter`并覆盖其方法。


### 10、SpringCloud 和 Dubbo 有哪些区别?

首先，他们都是分布式管理框架。

dubbo 是二进制传输，占用带宽会少一点。SpringCloud是http 传输，带宽会多一点，同时使用http协议一般会使用JSON报文，消耗会更大。

dubbo 开发难度较大，所依赖的 jar 包有很多问题大型工程无法解决。SpringCloud 对第三方的继承可以一键式生成，天然集成。

SpringCloud 接口协议约定比较松散，需要强有力的行政措施来限制接口无序升级。

最大的区别:


### 11、有哪些不同类型的IOC（依赖注入）方式？
### 12、什么是 Spring 配置文件？
### 13、我们如何在测试中消除非决定论？
### 14、微服务之间如何独立通讯的?
### 15、什么是消费者驱动的合同（CDC）？
### 16、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 17、如何配置SpringBoot应用程序日志记录？
### 18、什么是feigin？它的优点是什么？
### 19、spring-boot-starter-parent 有什么用 ?
### 20、什么是Swagger？你用SpringBoot实现了它吗？
### 21、你对SpringBoot有什么了解？
### 22、什么是Spring Initializer?
### 23、Spring对DAO的支持
### 24、服务降级底层是如何实现的？
### 25、如何使用SpringBoot实现分页和排序？
### 26、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 27、什么是Spring Batch？
### 28、Spring Framework 有哪些不同的功能？
### 29、微服务的端到端测试意味着什么？
### 30、使用 Spring 有哪些方式？
### 31、什么是 Spring Framework？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
