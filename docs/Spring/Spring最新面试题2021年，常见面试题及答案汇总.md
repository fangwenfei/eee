# Spring最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、康威定律是什么？

“任何设计系统的组织（广泛定义）都将产生一种设计，其结构是组织通信结构的副本。” –  Mel Conway

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_16.png#alt=img%5C_16.png)

图13：  Conway定律的表示 – 微服务访谈问题

该法律基本上试图传达这样一个事实：为了使软件模块起作用，整个团队应该进行良好的沟通。因此，系统的结构反映了产生它的组织的社会边界。


### 2、什么是无所不在的语言？

如果您必须定义泛在语言（UL），那么它是特定域的开发人员和用户使用的通用语言，通过该语言可以轻松解释域。

无处不在的语言必须非常清晰，以便它将所有团队成员放在同一页面上，并以机器可以理解的方式进行翻译。


### 3、JPA 和 Hibernate 有哪些区别？

简而言之

JPA 是一个规范或者接口

Hibernate 是 JPA 的一个实现

当我们使用 JPA 的时候，我们使用 javax.persistence 包中的注释和接口时，不需要使用 hibernate 的导入包。

我们建议使用 JPA 注释，因为哦我们没有将其绑定到 Hibernate 作为实现。后来（我知道 - 小于百分之一的几率），我们可以使用另一种 JPA 实现。


### 4、什么是 SpringBoot Stater ？

启动器是一套方便的依赖没描述符，它可以放在自己的程序中。你可以一站式的获取你所需要的 Spring 和相关技术，而不需要依赖描述符的通过示例代码搜索和复制黏贴的负载。

例如，如果你想使用 Sping 和 JPA 访问数据库，只需要你的项目包含 spring-boot-starter-data-jpa 依赖项，你就可以完美进行。


### 5、Spring Framework 中有多少个模块，它们分别是什么？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_1.png#alt=img%5C_1.png)

**Spring 核心容器 – 该层基本上是 Spring Framework 的核心。它包含以下模块：**

**1、** Spring Core

**2、** Spring Bean

**3、** SpEL (Spring Expression Language)

**4、** Spring Context

**数据访问/集成 – 该层提供与数据库交互的支持。它包含以下模块：**

**1、** JDBC (Java DataBase Connectivity)

**2、** ORM (Object Relational Mapping)

**3、** OXM (Object XML Mappers)

**4、** JMS (Java Messaging Service)

**5、** Transaction

**Web – 该层提供了创建 Web 应用程序的支持。它包含以下模块：**

**1、** Web

**2、** Web – Servlet

**3、** Web – Socket

**4、** Web – Portlet

**AOP**

该层支持面向切面编程

**Instrumentation**

该层为类检测和类加载器实现提供支持。

**Test**

该层为使用 JUnit 和 TestNG 进行测试提供支持。

**几个杂项模块:**

Messaging – 该模块为 STOMP 提供支持。它还支持注解编程模型，该模型用于从 WebSocket 客户端路由和处理 STOMP 消息。

Aspects – 该模块为与 AspectJ 的集成提供支持。


### 6、如何使用 SpringBoot 生成一个 WAR 文件？

推荐阅读:

[https://spring.io/guides/gs/convert-jar-to-war/](https://spring.io/guides/gs/convert-jar-to-war/)

下面有 spring 说明文档直接的链接地址：

```
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging
```


### 7、如果想在拦截的方法里面得到从前台传入的参数,怎么得到？



直接在形参里面声明这个参数就可以,但必须名字和传过来的参数一样。


### 8、保护 SpringBoot 应用有哪些方法？

**1、**  在生产中使用HTTPS

**2、**  使用Snyk检查你的依赖关系

**3、**  升级到最新版本

**4、**  启用CSRF保护

**5、**  使用内容安全策略防止XSS攻击


### 9、SpringBoot 常用的 Starter 有哪些？

**1、** spring-boot-starter-web ：提供 Spring MVC + 内嵌的 Tomcat 。

**2、** spring-boot-starter-data-jpa ：提供 Spring JPA + Hibernate 。

**3、** spring-boot-starter-data-Redis ：提供 Redis 。

**4、** mybatis-spring-boot-starter ：提供 MyBatis 。


### 10、Spring对DAO的支持

Spring对数据访问对象（DAO）的支持旨在简化它和数据访问技术如JDBC，Hibernate or JDO 结合使用。这使我们可以方便切换持久层。编码时也不用担心会捕获每种技术特有的异常。


### 11、负载平衡的意义什么？
### 12、SpringCloud Config 可以实现实时刷新吗？
### 13、什么是编织（Weaving）？
### 14、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 15、如何使用 SpringBoot 实现分页和排序？
### 16、什么是依赖注入？
### 17、描述一下 DispatcherServlet 的工作流程
### 18、什么是 AOP 引入?
### 19、自动装配有哪些局限性 ?
### 20、什么是客户证书？
### 21、既然Nginx可以实现网关？为什么还需要使用Zuul框架
### 22、设计微服务的最佳实践是什么？
### 23、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 24、服务降级底层是如何实现的？
### 25、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 26、什么是领域驱动设计？
### 27、什么是Spring引导的执行器？
### 28、什么是JavaConfig？
### 29、什么是 WebSockets？
### 30、解释WEB 模块。
### 31、如何实现SpringBoot应用程序的安全性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
