# SpringCloud最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、服务雪崩？

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


### 2、康威定律是什么？

“任何设计系统的组织（广泛定义）都将产生一种设计，其结构是组织通信结构的副本。” –  Mel Conway

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_16.png#alt=img%5C_16.png)

图13：  Conway定律的表示 – 微服务访谈问题

该法律基本上试图传达这样一个事实：为了使软件模块起作用，整个团队应该进行良好的沟通。因此，系统的结构反映了产生它的组织的社会边界。


### 3、Spring Cloud 实现服务注册和发现的原理是什么？

**1、** 服务在发布时指定对应的服务名（服务名包括了 IP 地址和端口）将服务注册到注册中心（Eureka 或者 Zookeeper）这一过程是 Spring Cloud 自动实现的，只需要在 main 方法添加 @EnableDisscoveryClient 即可，同一个服务修改端口就可以启动多个实例。

**2、** 调用方法：传递服务名称通过注册中心获取所有的可用实例，通过负载均衡策略调用（Ribbon 和 Feign）对应的服务。


### 4、什么是客户证书？

客户端系统用于向远程服务器发出经过身份验证的请求的一种数字证书称为客户端证书。客户端证书在许多相互认证设计中起着非常重要的作用，为请求者的身份提供了强有力的保证。


### 5、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston |  |



### 6、谈谈服务降级、熔断、服务隔离

**1、** 服务降级：当客户端请求服务器端的时候，防止客户端一直等待，不会处理业务逻辑代码，直接返回一个友好的提示给客户端。

**2、** 服务熔断是在服务降级的基础上更直接的一种保护方式，当在一个统计时间范围内的请求失败数量达到设定值（requestVolumeThreshold）或当前的请求错误率达到设定的错误率阈值（errorThresholdPercentage）时开启断路，之后的请求直接走fallback方法，在设定时间（sleepWindowInMilliseconds）后尝试恢复。

**3、** 服务隔离就是Hystrix为隔离的服务开启一个独立的线程池，这样在高并发的情况下不会影响其他服务。服务隔离有线程池和信号量两种实现方式，一般使用线程池方式。


### 7、Spring Cloud Consul

基于Hashicorp Consul的服务治理组件。


### 8、什么是端到端微服务测试？

端到端测试验证了工作流中的每个流程都正常运行。这可确保系统作为一个整体协同工作并满足所有要求。

通俗地说，你可以说端到端测试是一种测试，在特定时期后测试所有东西。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_17.png#alt=img%5C_17.png)

图14：测试层次 – 微服务面试问题


### 9、康威定律是什么？

康威定律指出，“设计系统的组织，其产生的设计等同于组织之内、组织之间的沟通结构。” 面试官可能会问反微服务面试问题，比如康威定律与微服务的关系。一些松散耦合的api形成了微服务的体系结构。这种结构非常适合小团队实现自治组件的方式。这种体系结构使组织在重组其工作流程时更加灵活。


### 10、服务降级底层是如何实现的？

Hystrix实现服务降级的功能是通过重写HystrixCommand中的getFallback()方法，当Hystrix的run方法或construct执行发生错误时转而执行getFallback()方法。


### 11、单片，SOA和微服务架构有什么区别？
### 12、Zuul与Nginx有什么区别？
### 13、Spring Cloud Gateway
### 14、使用 SpringBoot 开发分布式微服务时，我们面临什么问题
### 15、网关与过滤器有什么区别
### 16、什么是Spring Cloud Bus?
### 17、为什么要选择微服务架构？
### 18、微服务的端到端测试意味着什么？
### 19、常用网关框架有那些？
### 20、eureka服务注册与发现原理
### 21、微服务的优点
### 22、微服务有什么特点？
### 23、Spring Cloud Netflix(重点，这些组件用的最多)
### 24、Spring Cloud Task
### 25、什么是幂等性?它是如何使用的？
### 26、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 27、什么是双因素身份验证？
### 28、您对Mike Cohn的测试金字塔了解多少？
### 29、@LoadBalanced注解的作用
### 30、什么是Spring Cloud？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
