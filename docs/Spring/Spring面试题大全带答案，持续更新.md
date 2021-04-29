# Spring面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、为什么要用SpringBoot

快速开发，快速整合，配置简化、内嵌服务容器


### 2、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：

[@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 3、什么是不同类型的双因素身份认证？

执行双因素身份验证需要三种类型的凭据：

**1、** 一件你知道的事情——比如密码、密码或屏幕锁定模式。

**2、** 您拥有的物理凭证，如OTP、电话或ATM卡，换句话说，您在外部或第三方设备中拥有的任何类型的凭证。

**3、** 您的物理身份–如语音认证或生物特征安全，如指纹或眼睛扫描仪。


### 4、如何使用 SpringBoot 部署到不同的服务器？

你需要做下面两个步骤：

在一个项目中生成一个 war 文件。

将它部署到你最喜欢的服务器（websphere 或者 Weblogic 或者 Tomcat and so on）。

**第一步：**这本入门指南应该有所帮助：

[https://spring.io/guides/gs/convert-jar-to-war/](https://spring.io/guides/gs/convert-jar-to-war/)

**第二步：**取决于你的服务器。


### 5、解释对象/关系映射集成模块。

Spring 通过提供ORM模块，支持我们在直接JDBC之上使用一个对象/关系映射映射(ORM)工具，Spring 支持集成主流的ORM框架，如Hiberate,JDO和 iBATIS SQL Maps。Spring的事务管理同样支持以上所有ORM框架及JDBC。


### 6、如何给Spring 容器提供配置元数据?

这里有三种重要的方法给Spring 容器提供配置元数据。

**1、** XML配置文件。

**2、** 基于注解的配置。

**3、** 基于java的配置。


### 7、使用Spring通过什么方式访问Hibernate?

**在Spring中有两种方式访问Hibernate：**

控制反转 Hibernate Template和 Callback。

继承 HibernateDAOSupport提供一个AOP 拦截器。


### 8、服务网关的作用

**1、** 简化客户端调用复杂度，统一处理外部请求。

**2、** 数据裁剪以及聚合，根据不同的接口需求，对数据加工后对外。

**3、** 多渠道支持，针对不同的客户端提供不同的网关支持。

**4、** 遗留系统的微服务化改造，可以作为新老系统的中转组件。

**5、** 统一处理调用过程中的安全、权限问题。


### 9、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

org.springframework.data.domain.Pageable

传递给存储库方法。


### 10、Spring Cache 三种常用的缓存注解和意义？

**1、** [@Cacheable ](/Cacheable ) ，用来声明方法是可缓存，将结果存储到缓存中以便后续使用相同参数调用时不需执行实际的方法，直接从缓存中取值。

**2、** @CachePut，使用 [@CachePut ](/CachePut ) 标注的方法在执行前，不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

**3、** @CacheEvict，是用来标注在需要清除缓存元素的方法或类上的，当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。


### 11、如何给静态变量赋值？
### 12、如何使用 SpringBoot 实现异常处理？
### 13、微服务测试的主要障碍是什么？
### 14、SpringBoot 中的 starter 到底是什么 ?
### 15、什么是Hystrix？它如何实现容错？
### 16、什么是 AOP什么是引入?
### 17、什么是双因素身份验证？
### 18、SpringBoot的配置文件有哪几种格式？区别是什么？
### 19、YAML 配置的优势在哪里 ?
### 20、Spring Cloud 是什么
### 21、SpringBoot事物的使用
### 22、SpringBoot自动配置的原理
### 23、如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？
### 24、SpringCloud 和 Dubbo 有哪些区别?
### 25、什么是 AOP 切点
### 26、SpringBoot 实现热部署有哪几种方式？
### 27、什么是 JavaConfig？
### 28、SpringBoot中的监视器是什么?
### 29、前后端分离，如何维护接口文档 ?
### 30、Web，RESTful API在微服务中的作用是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
