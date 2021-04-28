# SpringCloud最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_9.png#alt=45%5C_9.png)

**springcloud由以下⼏个核⼼组件构成：**

**1、** Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从⽽知道其他服务在哪⾥

**2、** Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从⼀个服务的多台机器中选择⼀台

**3、** Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

**4、** Hystrix：发起请求是通过Hystrix的线程池来⾛的，不同的服务⾛不同的线程池，实现了不同服务调⽤的隔离，避免了服务雪崩的问题

**5、** Zuul：如果前端、移动端要调⽤后端系统，统⼀从Zuul⽹关进⼊，由Zuul⽹关转发请求给对应的服务


### 2、SpringCloud Config 可以实现实时刷新吗？

springcloud config实时刷新采用SpringCloud Bus消息总线。


### 3、为什么在微服务中需要Reports报告和Dashboards仪表板？

报告和仪表板主要用于监视和维护微服务。有多种工具可以帮助实现此目的。报告 和仪表板可用于： 找出哪些微服务公开了哪些资源。 找出组件发生变化时受影响的服务。 提供一个简单的点，只要需要文档，就可以访问它。 部署的组件的版本。


### 4、微服务之间是如何独⽴通讯的

**1、** Dubbo 使⽤的是 RPC 通信，⼆进制传输，占⽤带宽⼩；

**2、** Spring Cloud 使⽤的是 HTTP RESTFul ⽅式。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_2.png#alt=45%5C_2.png)


### 5、什么是REST / RESTful以及它的用途是什么？

Representational State Transfer（REST）/ RESTful Web服务是一种帮助计算机系统通过Internet进行通信的架构风格。这使得微服务更容易理解和实现。

微服务可以使用或不使用RESTful API实现，但使用RESTful API构建松散耦合的微服务总是更容易。


### 6、Spring Cloud Gateway

API网关组件，对请求提供路由及过滤功能。


### 7、什么是Idempotence以及它在哪里使用？

幂等性是能够以这样的方式做两次事情的特性，即最终结果将保持不变，即好像它只做了一次。

用法：在远程服务或数据源中使用 Idempotence，这样当它多次接收指令时，它只处理指令一次。


### 8、Ribbon和Feign调用服务的区别

**1、** 调用方式同：Ribbon需要我们自己构建Http请求，模拟Http请求然后通过RestTemplate发给其他服务，步骤相当繁琐

**2、** 而Feign则是在Ribbon的基础上进行了一次改进，采用接口的形式，将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 9、springcloud如何实现服务的注册?

**1、** 服务发布时，指定对应的服务名,将服务注册到 注册中心(eureka zookeeper)

**2、** 注册中心加@EnableEurekaServer,服务用@EnableDiscoveryClient，然后用ribbon或feign进行服务直接的调用发现。


### 10、既然Nginx可以实现网关？为什么还需要使用Zuul框架

Zuul是SpringCloud集成的网关，使用Java语言编写，可以对SpringCloud架构提供更灵活的服务。


### 11、SpringBoot和SpringCloud的区别？
### 12、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 13、网关的作用是什么
### 14、什么是 Spring Cloud Bus？
### 15、什么是Hystrix断路器？我们需要它吗？
### 16、单片，SOA和微服务架构有什么区别？
### 17、Spring Cloud Bus
### 18、熔断的原理，以及如何恢复？
### 19、SOA和微服务架构之间的主要区别是什么？
### 20、Spring Cloud 实现服务注册和发现的原理是什么？
### 21、如何覆盖SpringBoot项目的默认属性？
### 22、什么是Spring Cloud Bus？我们需要它吗？
### 23、什么是领域驱动设计？
### 24、设计微服务的最佳实践是什么？
### 25、为什么人们会犹豫使用微服务？
### 26、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 27、Spring Cloud Gateway
### 28、Spring Cloud和各子项目版本对应关系
### 29、什么是OAuth？
### 30、什么是微服务架构中的DRY？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
