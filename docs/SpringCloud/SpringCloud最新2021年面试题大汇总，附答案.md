# SpringCloud最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Docker的目的是什么？

Docker提供了一个可用于托管任何应用程序的容器环境。在此，软件应用程序和支持它的依赖项紧密打包在一起。

因此，这个打包的产品被称为Container，因为它是由Docker完成的，所以它被称为Docker容器！


### 2、接⼝限流⽅法？

**限制 总并发数（⽐如 数据库连接池、线程池）**

**1、** 限制 瞬时并发数（如 nginx 的 limit_conn 模块，⽤来限制 瞬时并发连接数）

**2、** 限制 时间窗⼝内的平均速率（如 Guava 的 RateLimiter、nginx 的 limit_req模块，限制每秒的平均速率）

**3、** 限制 远程接⼝ 调⽤速率

**4、** 限制 MQ 的消费速率

**5、** 可以根据⽹络连接数、⽹络流量、CPU或内存负载等来限流



### 3、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_9.png#alt=45%5C_9.png)

**springcloud由以下⼏个核⼼组件构成：**

**1、** Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从⽽知道其他服务在哪⾥

**2、** Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从⼀个服务的多台机器中选择⼀台

**3、** Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

**4、** Hystrix：发起请求是通过Hystrix的线程池来⾛的，不同的服务⾛不同的线程池，实现了不同服务调⽤的隔离，避免了服务雪崩的问题

**5、** Zuul：如果前端、移动端要调⽤后端系统，统⼀从Zuul⽹关进⼊，由Zuul⽹关转发请求给对应的服务


### 4、如何设计一套API接口

考虑到API接口的分类可以将API接口分为开发API接口和内网API接口，内网API接口用于局域网，为内部服务器提供服务。开放API接口用于对外部合作单位提供接口调用，需要遵循Oauth2.0权限认证协议。同时还需要考虑安全性、幂等性等问题。


### 5、eureka服务注册与发现原理

**1、** 每30s发送⼼跳检测重新进⾏租约，如果客户端不能多次更新租约，它将在90s内从服务器注册中⼼移除。

**2、** 注册信息和更新会被复制到其他Eureka 节点，来⾃任何区域的客户端可以查找到注册中⼼信息，每30s发⽣⼀次复制来定位他们的服务，并进⾏远程调⽤。

**3、** 客户端还可以缓存⼀些服务实例信息，所以即使Eureka全挂掉，客户端也是可以定位到服务地址的。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_4.png#alt=45%5C_4.png)


### 6、REST 和RPC对比

**1、** RPC主要的缺陷是服务提供方和调用方式之间的依赖太强，需要对每一个微服务进行接口的定义，并通过持续继承发布，严格版本控制才不会出现冲突。

**2、** REST是轻量级的接口，服务的提供和调用不存在代码之间的耦合，只需要一个约定进行规范。


### 7、网关的作用是什么

统一管理微服务请求，权限控制、负载均衡、路由转发、监控、安全控制黑名单和白名单等


### 8、什么是Feign？
### 9、服务雪崩效应产生的原因
### 10、架构师在微服务架构中的角色是什么？
### 11、SpringCloud主要项目
### 12、康威定律是什么？
### 13、什么是服务降级
### 14、什么是持续监测？
### 15、什么是 Spring Cloud Bus？
### 16、微服务之间是如何独立通讯的?
### 17、为什么需要域驱动设计（DDD）？
### 18、什么是REST / RESTful以及它的用途是什么？
### 19、什么是Hystrix？它如何实现容错？
### 20、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 21、如何在SpringBoot应用程序中实现Spring安全性？
### 22、第⼀层缓存：
### 23、访问RESTful微服务的方法是什么？
### 24、Spring Cloud Netflix(重点，这些组件用的最多)
### 25、Spring Cloud Netflix
### 26、微服务有什么特点？
### 27、微服务的优点
### 28、Spring Cloud OpenFeign
### 29、我们如何进行跨功能测试？
### 30、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
