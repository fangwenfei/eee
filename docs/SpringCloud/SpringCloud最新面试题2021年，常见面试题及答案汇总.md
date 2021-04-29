# SpringCloud最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是SpringBoot？

Spring boot是微服务面试问题的主要话题。 随着新功能的加入，Spring变得越来越复杂。无论何时启动新项目，都必须添加新的构建路径或Maven依赖项。简而言之，你需要从头开始做每件事。SpringBoot是一种帮助您避免所有代码配置的解决方案。


### 2、第⼀层缓存：

readOnlyCacheMap，本质上是ConcurrentHashMap：这是⼀个JVM的CurrentHashMap只读缓存，这个主要是为了供客户端获取注册信息时使⽤，其缓存更新，依赖于定时器的更新，通过和readWriteCacheMap 的值做对⽐，如果数据不⼀致，则以readWriteCacheMap 的数据为准。readOnlyCacheMap 缓存更新的定时器时间间隔，默认为30秒

#
### 3、如何覆盖SpringBoot项目的默认属性？

这可以通过在application.properties文件中指定属性来完成。 例如，在Spring MVC应用程序中，您必须指定后缀和前缀。这可以通过在application.properties文件中输入下面提到的属性来完成。

```
对于后缀 - spring.mvc.view.suffix: .jsp
对于前缀 - spring.mvc.view.prefix: /WEB-INF/
```


### 4、Spring Cloud Sleuth

在微服务中，通常根据业务模块分服务，项目中前端发起一个请求，后端可能跨几个服务调用才能完成这个请求（如下图）。如果系统越来越庞大，服务之间的调用与被调用关系就会变得很复杂，假如一个请求中需要跨几个服务调用，其中一个服务由于网络延迟等原因挂掉了，那么这时候我们需要分析具体哪一个服务出问题了就会显得很困难。Spring Cloud Sleuth服务链路跟踪功能就可以帮助我们快速的发现错误根源以及监控分析每条请求链路上的性能等等。 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/023/45/68_1.png#alt=68%5C_1.png)


### 5、Spring Cloud Config

Config能够管理所有微服务的配置文件

集中配置管理工具，分布式系统中统一的外部配置管理，默认使用Git来存储配置，可以支持客户端配置的刷新及加密、解密操作。


### 6、网关的作用是什么

统一管理微服务请求，权限控制、负载均衡、路由转发、监控、安全控制黑名单和白名单等


### 7、Ribbon和Feign的区别？

**1、** Ribbon都是调用其他服务的，但方式不同。

**2、** 启动类注解不同，Ribbon是[@RibbonClient ](/RibbonClient ) feign的是[@EnableFeignClients ](/EnableFeignClients )

**3、** 服务指定的位置不同，Ribbon是在@RibbonClient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明。

**4、** 调用方式不同，Ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。Feign需要将调用的方法定义成抽象方法即可。


### 8、什么是网关?

网关相当于一个网络服务架构的入口，所有网络请求必须通过网关转发到具体的服务。


### 9、微服务架构有哪些优势？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_2.png#alt=img%5C_2.png)

图2：微服务的 优点 – 微服务访谈问题

独立开发 – 所有微服务都可以根据各自的功能轻松开发

独立部署 – 基于其服务，可以在任何应用程序中单独部署它们

故障隔离 – 即使应用程序的一项服务不起作用，系统仍可继续运行

混合技术堆栈 – 可以使用不同的语言和技术来构建同一应用程序的不同服务

粒度缩放 – 单个组件可根据需要进行缩放，无需将所有组件缩放在一起


### 10、Eureka如何 保证AP

Eureka看明⽩了这⼀点，因此在设计时就优先保证可⽤性。Eureka各个节点都是平等的，⼏个节点挂掉不会影响正常节点的⼯作，剩余的节点依然可以提供注册和查询服务。⽽Eureka的客户端在向某个Eureka注册或如果发现连接失败，则会⾃动切换⾄其它节点，只要有⼀台Eureka还在，就能保证注册服务可⽤(保证可⽤性)，只不过查到的信息可能不是最新的(不保证强⼀致性)。除此之外，Eureka还有⼀种⾃我保护机制，如果在15分钟内超过85%的节点都没有正常的⼼跳，那么Eureka就认为客户端与注册中⼼出现了⽹络故障，此时会出现以下⼏种情况：

**1、** Eureka不再从注册列表中移除因为⻓时间没收到⼼跳⽽应该过期的服务

**2、** Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可⽤)

**3、** 当⽹络稳定时，当前实例新的注册信息会被同步到其它节点中

因此， Eureka可以很好的应对因⽹络故障导致部分节点失去联系的情况，⽽不会像zookeeper那样使整个注册服务瘫痪。


### 11、如何配置SpringBoot应用程序日志记录？
### 12、您对Distributed Transaction有何了解？
### 13、什么是Spring引导的执行器？
### 14、您将如何在微服务上执行安全测试？
### 15、什么是客户证书？
### 16、什么是Hystrix?
### 17、服务降级底层是如何实现的？
### 18、什么是持续集成（CI）？
### 19、Docker的目的是什么？
### 20、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 21、Ribbon和Feign调用服务的区别
### 22、Container在微服务中的用途是什么？
### 23、Nginx与Ribbon的区别
### 24、什么是Eureka的自我保护模式，
### 25、Ribbon是什么？
### 26、什么是 Hystrix？
### 27、什么是凝聚力？
### 28、什么是耦合和凝聚力？
### 29、Ribbon底层实现原理
### 30、Spring Cloud Bus




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
