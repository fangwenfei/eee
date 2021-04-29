# Spring面试题大汇总，2021面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何集成SpringBoot和ActiveMQ？

对于集成SpringBoot和ActiveMQ，我们使用

依赖关系。 它只需要很少的配置，并且不需要样板代码。


### 2、Spring对DAO的支持

Spring对数据访问对象（DAO）的支持旨在简化它和数据访问技术如JDBC，Hibernate or JDO 结合使用。这使我们可以方便切换持久层。编码时也不用担心会捕获每种技术特有的异常。


### 3、spring JDBC API 中存在哪些类？

**1、** JdbcTemplate

**2、** SimpleJdbcTemplate

**3、** NamedParameterJdbcTemplate

**4、** SimpleJdbcInsert

**5、** SimpleJdbcCall



### 4、注解原理是什么

注解本质是一个继承了Annotation的特殊接口，其具体实现类是Java运行时生成的动态代理类。我们通过反射获取注解时，返回的是Java运行时生成的动态代理对象。通过代理对象调用自定义注解的方法，会最终调用AnnotationInvocationHandler的invoke方法。该方法会从memberValues这个Map中索引出对应的值。而memberValues的来源是Java常量池。


### 5、SpringBoot微服务中如何实现 session 共享 ?

在微服务中，一个完整的项目被拆分成多个不相同的独立的服务，各个服务独立部署在不同的服务器上，各自的 session 被从物理空间上隔离开了，但是经常，我们需要在不同微服务之间共享 session ，常见的方案就是 Spring Session + Redis 来实现 session 共享。将所有微服务的 session 统一保存在 Redis 上，当各个微服务对 session 有相关的读写操作时，都去操作 Redis 上的 session 。这样就实现了 session 共享，Spring Session 基于 Spring 中的代理过滤器实现，使得 session 的同步操作对开发人员而言是透明的，非常简便。


### 6、[@Qualifier ](/Qualifier ) 注解

当有多个相同类型的bean却只有一个需要自动装配时，将[@Qualifier ](/Qualifier ) 注解和[@Autowire ](/Autowire ) 注解结合使用以消除这种混淆，指定需要装配的确切的bean。


### 7、如何集成 SpringBoot 和 ActiveMQ？

对于集成 SpringBoot 和 ActiveMQ，我们使用依赖关系。它只需要很少的配置，并且不需要样板代码。


### 8、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_13.png#alt=img%5C_13.png)

在测试目标只关注Spring MVC组件的情况下，WebMvcTest注释用于单元测试Spring MVC应用程序。在上面显示的快照中，我们只想启动ToTestController。执行此单元测试时，不会启动所有其他控制器和映射。


### 9、SpringBoot有哪些优点？

**1、** 减少开发，测试时间和努力。

**2、** 使用JavaConfig有助于避免使用XML。

**3、** 避免大量的Maven导入和各种版本冲突。

**4、** 提供意见发展方法。

**5、** 通过提供默认值快速开始开发。

**6、** 没有单独的Web服务器需要。这意味着你不再需要启动Tomcat，Glassfish或其他任何东西。

**7、** 需要更少的配置 因为没有web.xml文件。只需添加用@ Configuration注释的类，然后添加用@Bean注释的方法，Spring将自动加载对象并像以前一样对其进行管理。您甚至可以将@Autowired添加到bean方法中，以使Spring自动装入需要的依赖关系中。

**8、** 基于环境的配置 使用这些属性，您可以将您正在使用的环境传递到应用程序：-Dspring.profiles.active = {enviornment}。在加载主应用程序属性文件后，Spring将在（application{environment} .properties）中加载后续的应用程序属性文件。


### 10、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter

**1、** ActiveLimitFilter：

```
@Activate(group = Constants.CONSUMER, value = Constants.ACTIVES_KEY)
```

**作⽤于客户端，主要作⽤是控制客户端⽅法的并发度；**

当超过了指定的active值之后该请求将等待前⾯的请求完成【何时结束呢？依赖于该⽅法的timeout 如果没有设置timeout的话可能就是多个请求⼀直被阻塞然后等待随机唤醒。

**2、** ExecuteLimitFilter：

```
@Activate(group = Constants.PROVIDER, value = Constants.EXECUTES_KEY)
```

作⽤于服务端，⼀旦超出指定的数⽬直接报错 其实是指在服务端的并⾏度【需要注意这些都是指的是在单台服务上⽽不是整个服务集群】

**3、** TPSLimiterFilter：

```
@Activate(group = Constants.PROVIDER, value = Constants.TPS_LIMIT_RATE_KEY)
```

**1、** 作⽤于服务端，控制⼀段时间内的请求数；

**2、** 默认情况下取得tps.interval字段表示请求间隔 如果⽆法找到则使⽤60s 根据tps字段表示允许调⽤次数。

**3、** 使⽤AtomicInteger表示允许调⽤的次数 每次调⽤减少1次当结果⼩于0之后返回不允许调⽤


### 11、SpringBoot 有哪几种读取配置的方式？
### 12、什么是Eureka的自我保护模式，
### 13、什么是Hystrix?
### 14、有哪些类型的通知（Advice）？
### 15、ZuulFilter常用有那些方法
### 16、微服务有哪些特点？
### 17、为什么在微服务中需要Reports报告和Dashboards仪表板？
### 18、Ribbon和Feign调用服务的区别
### 19、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 20、负载平衡的意义什么？
### 21、什么是 JavaConfig？
### 22、spring boot扫描流程?
### 23、我们如何监视所有SpringBoot微服务？
### 24、eureka缓存机制：
### 25、熔断的原理，以及如何恢复？
### 26、Ribbon底层实现原理
### 27、我们如何在测试中消除非决定论？
### 28、什么是 Spring Batch?
### 29、解释Spring支持的几种bean的作用域。
### 30、spring 提供了哪些配置方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
