# Spring最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 可以兼容老 Spring 项目吗，如何做？

可以兼容，使用 [@ImportResource ](/ImportResource ) 注解导入老 Spring 项目配置文件。


### 2、什么是Spring IOC 容器？

Spring IOC 负责创建对象，管理对象（通过依赖注入（DI），装配对象，配置对象，并且管理这些对象的整个生命周期。


### 3、为什么需要域驱动设计（DDD）？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_11.png#alt=img%5C_11.png)

图9：我们需要DDD的因素 – 微服务面试问题


### 4、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、**  容易上手，提升开发效率，为 Spring 开发提供一个更快、更简单的开发框架。

**2、**  开箱即用，远离繁琐的配置。

**3、**  提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、**  SpringBoot总结就是使编码变简单、配置变简单、部署变简单、监控变简单等等


### 5、什么是 Spring Framework？

**1、** Spring 是一个开源应用框架，旨在降低应用程序开发的复杂度。

**2、** 它是轻量级、松散耦合的。

**3、** 它具有分层体系结构，允许用户选择组件，同时还为 J2EE 应用程序开发提供了一个有凝聚力的框架。

**4、** 它可以集成其他框架，如 Structs、Hibernate、EJB 等，所以又称为框架的框架。


### 6、在Spring框架中如何更有效地使用JDBC?

使用SpringJDBC 框架，资源管理和错误处理的代价都会被减轻。所以开发者只需写statements 和 queries从数据存取数据，JDBC也可以在Spring框架提供的模板类的帮助下更有效地被使用，这个模板叫JdbcTemplate （例子见这里here）


### 7、SpringBoot 自动配置原理

**1、** SpringBoot启动的时候加载主配置类，开启了自动配置功能 @EnableAutoConfiguration

**2、** @EnableAutoConfiguration 作用:

将类路径下 META-INF/spring.factories 里面配置的所有EnableAutoConfiguration的值加入到了容器中;

每一个这样的 xxxAutoConfiguration类都是容器中的一个组件，都加入到容器中;用他们来做自动配置;

**3、** 每一个自动配置类进行自动配置功能;

根据当前不同的条件判断，决定这个配置类是否生效；

**4、** 一但这个配置类生效;这个配置类就会给容器中添加各种组件;这些组件的属性是从对应的properties类中获取 的，这些类里面的每一个属性又是和配置文件绑定的;

**5、** 所有在配置文件中能配置的属性都是在xxxxProperties类中封装者‘;配置文件能配置什么就可以参照某个功 能对应的这个属性类


### 8、如何使用 SpringBoot 实现分页和排序？

使用 SpringBoot 实现分页非常简单。使用 Spring Data-JPA 可以实现将可分页的传递给存储库方法。


### 9、Spring Cache 三种常用的缓存注解和意义？

**1、** [@Cacheable ](/Cacheable ) ，用来声明方法是可缓存，将结果存储到缓存中以便后续使用相同参数调用时不需执行实际的方法，直接从缓存中取值。

**2、** @CachePut，使用 [@CachePut ](/CachePut ) 标注的方法在执行前，不会去检查缓存中是否存在之前执行过的结果，而是每次都会执行该方法，并将执行结果以键值对的形式存入指定的缓存中。

**3、** @CacheEvict，是用来标注在需要清除缓存元素的方法或类上的，当标记在一个类上时表示其中所有的方法的执行都会触发缓存的清除操作。


### 10、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

[@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude ](/EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能：@SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class })。

@ComponentScan：Spring组件扫描。


### 11、我们如何连接一个像 MySQL 或者Orcale 一样的外部数据库？
### 12、有几种不同类型的自动代理？
### 13、Ribbon底层实现原理
### 14、我们如何在测试中消除非决定论？
### 15、[@Qualifier ](/Qualifier ) 注解有什么用？
### 16、spring 中有多少种 IOC 容器？
### 17、使⽤中碰到的坑
### 18、使用 Spring 有哪些方式？
### 19、SpringBoot 有哪几种读取配置的方式？
### 20、@RestController和@Controller的区别
### 21、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 22、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？
### 23、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 24、解释基于注解的切面实现
### 25、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 26、微服务的优点
### 27、Spring Cloud 是什么
### 28、spring 支持哪些 ORM 框架
### 29、Spring Cloud Stream
### 30、开启 SpringBoot 特性有哪几种方式？
### 31、什么是Spring Cloud Gateway?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
