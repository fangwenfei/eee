# Spring最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston |  |



### 2、什么是持续监测？

持续监控深入监控覆盖范围，从浏览器内前端性能指标，到应用程序性能，再到主机虚拟化基础架构指标。


### 3、如何在自定义端口上运行SpringBoot应用程序？

为了在自定义端口上运行SpringBoot应用程序，您可以在application.properties中指定端口。

```
 server.port = 8090
```


### 4、SpringBoot如何实现打包

进入项目目录在控制台输入mvn clean package，clean是清空已存在的项目包，package进行打包

或者点击左边选项栏中的Mavne，先点击clean在点击package


### 5、服务雪崩？

简介：服务雪崩效应是⼀种因服务提供者的不可⽤导致服务调⽤者的不可⽤,并将不可⽤逐渐放⼤的过程.

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_12.png#alt=45%5C_12.png)

**形成原因**

**1、** 服务提供者不可

**2、** 重试加⼤流量

**3、** 服务调⽤者不可⽤

**采⽤策略**

**1、** 流量控制

**2、** 改进缓存模式

**3、** 服务⾃动扩容

**4、** 服务调⽤者降级服务


### 6、SOA和微服务架构之间的主要区别是什么？

SOA和微服务之间的主要区别如下：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_8.png#alt=img%5C_8.png)


### 7、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，Spring 3、0引入了他，它提供了配置 Spring IOC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5、0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。

**常用的Java config：**

@Configuration：在类上打上写下此注解，表示这个类是配置类

@ComponentScan：在配置类上添加 [@ComponentScan ](/ComponentScan ) 注解。该注解默认会扫描该类所在的包下所有的配置类，相当于之前的 <context:component-scan >。

@Bean：bean的注入：相当于以前的< bean id="objectMapper" class="org、codehaus、jackson、map、ObjectMapper" />

@EnableWebMvc：相当于xml的<mvc:annotation-driven >

@ImportResource： 相当于xml的 < import resource="applicationContext-cache、xml">


### 8、SpringBoot 最大的优势是什么呢？

SpringBoot 的最大的优势是“约定优于配置“。“约定优于配置“是一种软件设计范式，开发人员按照约定的方式来进行编程，可以减少软件开发人员需做决定的数量，获得简单的好处，而又不失灵活性。

SpringBoot 中 “约定优于配置“的具体产品体现在哪里。

SpringBoot Starter、SpringBoot Jpa 都是“约定优于配置“的一种体现。都是通过“约定优于配置“的设计思路来设计的，SpringBoot Starter 在启动的过程中会根据约定的信息对资源进行初始化；SpringBoot Jpa 通过约定的方式来自动生成 Sql ，避免大量无效代码编写。具体详细可以参考：SpringBoot 为什么这么火？


### 9、什么是Hystrix断路器？我们需要它吗？

由于某些原因，employee-consumer公开服务会引发异常。在这种情况下使用Hystrix我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_4.png#alt=img%5C_4.png)

如果firstPage method() 中的异常继续发生，则Hystrix电路将中断，并且员工使用者将一起跳过firtsPage方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_5.png#alt=img%5C_5.png)


### 10、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、**  容易上手，提升开发效率，为 Spring 开发提供一个更快、更简单的开发框架。

**2、**  开箱即用，远离繁琐的配置。

**3、**  提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、**  SpringBoot总结就是使编码变简单、配置变简单、部署变简单、监控变简单等等


### 11、康威定律是什么？
### 12、什么是执行器停机？
### 13、@RequestMapping注解的作用
### 14、什么是 AOP什么是目标对象?
### 15、[@Required ](/Required ) 注解
### 16、@LoadBalanced注解的作用
### 17、什么是Spring的依赖注入？
### 18、SpringBoot默认支持的日志框架有哪些？可以进行哪些设置？
### 19、在 Spring Initializer 中，如何改变一个项目的包名字？
### 20、微服务架构如何运作？
### 21、在Spring AOP 中，关注点和横切关注的区别是什么？
### 22、Spring Cloud Stream
### 23、什么是Spring Cloud？
### 24、SpingMvc中的控制器的注解一般用哪个,有没有别的注解可以替代？
### 25、Spring Cloud Bus
### 26、解释JDBC抽象和DAO模块。
### 27、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？
### 28、spring 支持哪些 ORM 框架
### 29、微服务之间如何独立通讯的?
### 30、spring 提供了哪些配置方式？
### 31、如何在 SpringBoot 启动的时候运行一些特定的代码？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
