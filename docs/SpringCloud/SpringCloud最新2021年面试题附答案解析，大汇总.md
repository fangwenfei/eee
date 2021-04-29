# SpringCloud最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是微服务

**1、** 微服务是⼀种架构⻛格，也是⼀种服务；

**2、** 微服务的颗粒⽐较⼩，⼀个⼤型复杂软件应⽤由多个微服务组成，⽐如Netflix⽬前由500多的微服务组成；

**3、** 它采⽤UNIX设计的哲学，每种服务只做⼀件事，是⼀种松耦合的能够被独⽴开发和部署的⽆状态化服务（独⽴扩展、升级和可替换）。


### 2、什么是feigin？它的优点是什么？

**1、** feign采用的是基于接口的注解

**2、** feign整合了ribbon，具有负载均衡的能力

**3、** 整合了Hystrix，具有熔断的能力

**使用:**

**1、** 添加pom依赖。

**2、** 启动类添加[@EnableFeignClients ](/EnableFeignClients )

**3、** 定义一个接口@FeignClient(name=“xxx”)指定调用哪个服务


### 3、springcloud如何实现服务的注册?

**1、** 服务发布时，指定对应的服务名,将服务注册到 注册中心(eureka zookeeper)

**2、** 注册中心加@EnableEurekaServer,服务用@EnableDiscoveryClient，然后用ribbon或feign进行服务直接的调用发现。


### 4、Spring Cloud解决了哪些问题？

在使用SpringBoot开发分布式微服务时，我们面临的问题很少由Spring Cloud解决。

与分布式系统相关的复杂性 – 包括网络问题，延迟开销，带宽问题，安全问题。

处理服务发现的能力 – 服务发现允许集群中的进程和服务找到彼此并进行通信。

解决冗余问题 – 冗余问题经常发生在分布式系统中。

负载平衡 – 改进跨多个计算资源（例如计算机集群，网络链接，中央处理单元）的工作负载分布。

减少性能问题 – 减少因各种操作开销导致的性能问题。


### 5、微服务之间是如何独⽴通讯的

**1、** Dubbo 使⽤的是 RPC 通信，⼆进制传输，占⽤带宽⼩；

**2、** Spring Cloud 使⽤的是 HTTP RESTFul ⽅式。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_2.png#alt=45%5C_2.png)


### 6、合同测试你懂什么？

根据Martin Flower的说法，合同测试是在外部服务边界进行的测试，用于验证其是否符合消费服务预期的合同。

此外，合同测试不会深入测试服务的行为。更确切地说，它测试该服务调用的输入＆输出包含所需的属性和所述响应延迟，吞吐量是允许的限度内。


### 7、双因素身份验证的凭据类型有哪些？

这三种凭证是：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_15.png#alt=img%5C_15.png)

图12： 双因素认证的证书类型 – 微服务面试问题


### 8、什么是 Hystrix 断路器？我们需要它吗？
### 9、什么是网关?
### 10、SpringCloud 和 Dubbo 有哪些区别?
### 11、熔断的原理，以及如何恢复？
### 12、Web，RESTful API在微服务中的作用是什么？
### 13、我们如何在测试中消除非决定论？
### 14、ZuulFilter常用有那些方法
### 15、SOA和微服务架构之间的主要区别是什么？
### 16、常用网关框架有那些？
### 17、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 18、服务注册和发现是什么意思？Spring Cloud如何实现？
### 19、什么是双因素身份验证？
### 20、谈谈服务降级、熔断、服务隔离
### 21、什么是金丝雀释放？
### 22、什么是凝聚力？
### 23、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 24、Nginx与Ribbon的区别
### 25、单片，SOA和微服务架构有什么区别？
### 26、Spring Cloud Bus
### 27、什么是Netflix Feign？它的优点是什么？
### 28、spring cloud 和dubbo区别?
### 29、PACT在微服务架构中的用途是什么？
### 30、什么是Hystrix?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
