# Spring最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、你更倾向用那种事务管理类型？

大多数Spring框架的用户选择声明式事务管理，因为它对应用代码的影响最小，因此更符合一个无侵入的轻量级容器的思想。声明式事务管理要优于编程式事务管理，虽然比编程式事务管理（这种方式允许你通过代码控制事务）少了一点灵活性。


### 2、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?

SpringBoot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 `java -jar xxx、jar` 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

SpringBoot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 SpringBoot 打包成的可执行 jar 解压后，在 `\BOOT-INF\classes` 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom、xml 文件中增加配置，将 SpringBoot 项目打包成两个 jar ，一个可执行，一个可引用。


### 3、SpringBoot常用的starter有哪些？

**1、** spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、** spring-boot-starter-data-jpa 数据库支持

**3、** spring-boot-starter-data-Redis Redis数据库支持

**4、** spring-boot-starter-data-solr solr支持

**5、** mybatis-spring-boot-starter 第三方的mybatis集成starter


### 4、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？

让我们以 MySQL 为例来思考这个问题：

**第一步** - 把 MySQL 连接器的依赖项添加至 pom.xml

**第二步** - 从 pom.xml 中移除 H2 的依赖项

或者至少把它作为测试的范围。

**第三步** - 安装你的 MySQL 数据库

更多的来看看这里 -[https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL](https://github.com/in28minutes/jpa-with-hibernate#installing-and-setting-up-MySQL)

**第四步** - 配置你的 MySQL 数据库连接

配置 application.properties

```
spring.jpa.hibernate.ddl-auto=none spring.datasource.url=jdbc:MySQL://localhost:3306/todo_example
spring.datasource.username=todouser spring.datasource.password=YOUR_PASSWORD
```

**第五步** - 重新启动，你就准备好了！

就是这么简单！


### 5、什么是 Spring Data ?

Spring Data 是 Spring 的一个子项目。用于简化数据库访问，支持NoSQL 和 关系数据存储。其主要目标是使数据库的访问变得方便快捷。Spring Data 具有如下特点：

**SpringData 项目支持 NoSQL 存储：**

**1、** MongoDB （文档数据库）

**2、** Neo4j（图形数据库）

**3、** Redis（键/值存储）

**4、** Hbase（列族数据库）


### 6、Spring Framework 有哪些不同的功能？

**1、** 轻量级 - Spring 在代码量和透明度方面都很轻便。

**2、** IOC - 控制反转

**3、** AOP - 面向切面编程可以将应用业务逻辑和系统服务分离，以实现高内聚。

**4、** 容器 - Spring 负责创建和管理对象（Bean）的生命周期和配置。

**5、** MVC - 对 web 应用提供了高度可配置性，其他框架的集成也十分方便。

**6、** 事务管理 - 提供了用于事务管理的通用抽象层。Spring 的事务支持也可用于容器较少的环境。

**7、** JDBC 异常 - Spring 的 JDBC 抽象层提供了一个异常层次结构，简化了错误处理策略。


### 7、你对SpringBoot有什么了解？

事实上，随着新功能的增加，弹簧变得越来越复杂。如果必须启动新的spring项目，则必须添加构建路径或添加maven依赖项，配置应用程序服务器，添加spring配置。所以一切都必须从头开始。

SpringBoot是解决这个问题的方法。使用spring boot可以避免所有样板代码和配置。因此，基本上认为自己就好像你正在烘烤蛋糕一样，春天就像制作蛋糕所需的成分一样，弹簧靴就是你手中的完整蛋糕。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_12.png#alt=img%5C_12.png)

图10：  SpringBoot的因素 – 微服务面试问题


### 8、什么是Spring Cloud Zuul（服务网关）

Zuul是对SpringCloud提供的成熟对的路由方案，他会根据请求的路径不同，网关会定位到指定的微服务，并代理请求到不同的微服务接口，他对外隐蔽了微服务的真正接口地址。

三个重要概念：动态路由表，路由定位，反向代理：

**1、** 动态路由表：Zuul支持Eureka路由，手动配置路由，这俩种都支持自动更新

**2、** 路由定位：根据请求路径，Zuul有自己的一套定位服务规则以及路由表达式匹配

**3、** 反向代理：客户端请求到路由网关，网关受理之后，在对目标发送请求，拿到响应之后在 给客户端它可以和Eureka,Ribbon,Hystrix等组件配合使用，

**Zuul的应用场景：**

对外暴露，权限校验，服务聚合，日志审计等


### 9、比较一下 Spring Security 和 Shiro 各自的优缺点 ?

由于 SpringBoot 官方提供了大量的非常方便的开箱即用的 Starter ，包括 Spring Security 的 Starter ，使得在 SpringBoot 中使用 Spring Security 变得更加容易，甚至只需要添加一个依赖就可以保护所有的接口，所以，如果是 SpringBoot 项目，一般选择 Spring Security 。当然这只是一个建议的组合，单纯从技术上来说，无论怎么组合，都是没有问题的。Shiro 和 Spring Security 相比，主要有如下一些特点：

Spring Security 是一个重量级的安全管理框架；Shiro 则是一个轻量级的安全管理框架

Spring Security 概念复杂，配置繁琐；Shiro 概念简单、配置简单

Spring Security 功能强大；Shiro 功能简单


### 10、微服务的缺点：

**1、** 复杂度⾼：服务调⽤要考虑被调⽤⽅故障、过载、消息丢失等各种异常情况，代码逻辑更加复杂；对于微服务间的事务性操作，因为不同的微服务采⽤了不同的数据库，将⽆法利⽤数据库本身的事务机制保证⼀致性，需要引⼊⼆阶段提交等技术。

**2、** 运维复杂：系统由多个独⽴运⾏的微服务构成，需要⼀个设计良好的监控系统对各个微服务的运⾏状态进⾏监控。运维⼈员需要对系统有细致的了解才对够更好的运维系统。

**3、** 通信延迟：微服务之间调⽤会有时间损耗，造成通信延迟。


### 11、JPA 和 Hibernate 有哪些区别？
### 12、SpringBoot有哪些优点？
### 13、如何使用SpringBoot实现分页和排序？
### 14、什么是Feign？
### 15、@PathVariable和@RequestParam的区别
### 16、如何使用 SpringBoot 部署到不同的服务器？
### 17、我们如何进行跨功能测试？
### 18、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 19、Spring Cloud Zookeeper
### 20、开启SpringBoot特性有哪几种方式？（创建SpringBoot项目的两种方式）
### 21、描述一下 DispatcherServlet 的工作流程
### 22、Actuator在SpringBoot中的作用
### 23、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？
### 24、SpringBoot多数据源事务如何管理
### 25、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 26、Spring框架的事务管理有哪些优点？
### 27、Spring Framework 有哪些不同的功能？
### 28、Mock或Stub有什么区别？
### 29、什么是领域驱动设计？
### 30、为什么要使用 Spring Cloud 熔断器？
### 31、您使用了哪些 starter maven 依赖项？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
