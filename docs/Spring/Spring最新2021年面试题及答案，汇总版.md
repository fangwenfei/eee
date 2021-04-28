# Spring最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用

依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 2、什么是CSRF攻击？

CSRF代表跨站请求伪造。这是一种攻击，迫使最终用户在当前通过身份验证的Web应用程序上执行不需要的操作。CSRF攻击专门针对状态改变请求，而不是数据窃取，因为攻击者无法查看对伪造请求的响应。


### 3、什么是Spring Cloud？

根据Spring Cloud的官方网站，Spring Cloud为开发人员提供了快速构建分布式系统中一些常见模式的工具（例如配置管理，服务发现，断路器，智能路由，领导选举，分布式会话，集群状态）。


### 4、什么是 AOP 引入?

引入允许我们在已存在的类中增加新的方法和属性。


### 5、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 6、什么是 Spring Profiles？

在项目的开发中，有些配置文件在开发、测试或者生产等不同环境中可能是不同的，例如数据库连接、Redis的配置等等。那我们如何在不同环境中自动实现配置的切换呢？Spring给我们提供了profiles机制给我们提供的就是来回切换配置文件的功能

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 7、如何在自定义端口上运行 SpringBoot 应用程序？

为了在自定义端口上运行 SpringBoot 应用程序，您可以在application.properties 中指定端口。server.port = 8090


### 8、AOP 有哪些实现方式？

**实现 AOP 的技术，主要分为两大类：**

**静态代理**

指使用 AOP 框架提供的命令进行编译，从而在编译阶段就可生成 AOP 代理类，因此也称为编译时增强；

编译时编织（特殊编译器实现）

类加载时编织（特殊的类加载器实现）。

**动态代理**

在运行时在内存中“临时”生成 AOP 动态代理类，因此也被称为运行时增强。

**JDK 动态代理**

**CGLIB**


### 9、如何给静态变量赋值？

SpringBoot无法通过@Value给静态变量赋值

此时需要给当前类加@Component注解，通过set方法设置@Value注解加载set方法上，set方法的参数可以任意命名，不能同属性名，此后当前工具类下的静态方法可直接使用属性值。



### 10、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston |  |



### 11、Zuul与Nginx有什么区别？
### 12、spring boot扫描流程?
### 13、什么是幂等性?它是如何使用的？
### 14、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 15、服务雪崩？
### 16、如何使用SpringBoot实现异常处理?
### 17、什么是 SpringBoot 启动类注解：
### 18、单片，SOA和微服务架构有什么区别？
### 19、Bean 工厂和 Application contexts 有什么区别？
### 20、SpringBoot 配置加载顺序?
### 21、SpringBoot性能如何优化
### 22、Spring支持的ORM
### 23、您对Distributed Transaction有何了解？
### 24、什么是 SpringBoot？
### 25、列举 Spring Framework 的优点。
### 26、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?
### 27、能否举一个例子来解释更多 Staters 的内容？
### 28、Ribbon是什么？
### 29、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 30、列举微服务技术栈
### 31、Spring支持的事务管理类型




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
