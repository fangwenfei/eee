# SpringCloud最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringCloud由什么组成

这就有很多了，我讲几个开发中最重要的

**1、** Spring Cloud Eureka：服务注册与发现

**2、** Spring Cloud Zuul：服务网关

**3、** Spring Cloud Ribbon：客户端负载均衡

**4、** Spring Cloud Feign：声明性的Web服务客户端

**5、** Spring Cloud Hystrix：断路器

**6、** Spring Cloud Config：分布式统一配置管理

**7、** 等20几个框架，开源一直在更新


### 2、Spring Cloud 和dubbo区别?

**1、** 服务调用方式：dubbo是RPC springcloud Rest Api

**2、** 注册中心：dubbo 是zookeeper springcloud是eureka，也可以是zookeeper

**3、** 服务网关，dubbo本身没有实现，只能通过其他第三方技术整合，springcloud有Zuul路由网关，作为路由服务器，进行消费者的请求分发,springcloud支持断路器，与git完美集成配置文件支持版本控制，事物总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素。


### 3、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？

**1、** zookeeper 是CP原则，强一致性和分区容错性。

**2、** eureka 是AP 原则 可用性和分区容错性。

**3、** zookeeper当主节点故障时，zk会在剩余节点重新选择主节点，耗时过长，虽然最终能够恢复，但是选取主节点期间会导致服务不可用，这是不能容忍的。

**4、** eureka各个节点是平等的，一个节点挂掉，其他节点仍会正常保证服务。


### 4、使用Spring Cloud有什么优势？

使用SpringBoot开发分布式微服务时，我们面临以下问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。

**6、** 部署复杂性-Devops技能的要求。


### 5、微服务架构有哪些优势？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_2.png#alt=img%5C_2.png)

图2：微服务的 优点 – 微服务访谈问题

独立开发 – 所有微服务都可以根据各自的功能轻松开发

独立部署 – 基于其服务，可以在任何应用程序中单独部署它们

故障隔离 – 即使应用程序的一项服务不起作用，系统仍可继续运行

混合技术堆栈 – 可以使用不同的语言和技术来构建同一应用程序的不同服务

粒度缩放 – 单个组件可根据需要进行缩放，无需将所有组件缩放在一起


### 6、Spring Cloud Sleuth

在微服务中，通常根据业务模块分服务，项目中前端发起一个请求，后端可能跨几个服务调用才能完成这个请求（如下图）。如果系统越来越庞大，服务之间的调用与被调用关系就会变得很复杂，假如一个请求中需要跨几个服务调用，其中一个服务由于网络延迟等原因挂掉了，那么这时候我们需要分析具体哪一个服务出问题了就会显得很困难。Spring Cloud Sleuth服务链路跟踪功能就可以帮助我们快速的发现错误根源以及监控分析每条请求链路上的性能等等。 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/023/45/68_1.png#alt=68%5C_1.png)


### 7、什么是Feign？

**1、** Feign 是一个声明web服务客户端，这使得编写web服务客户端更容易

**2、** 他将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 8、eureka服务注册与发现原理

**1、** 每30s发送⼼跳检测重新进⾏租约，如果客户端不能多次更新租约，它将在90s内从服务器注册中⼼移除。

**2、** 注册信息和更新会被复制到其他Eureka 节点，来⾃任何区域的客户端可以查找到注册中⼼信息，每30s发⽣⼀次复制来定位他们的服务，并进⾏远程调⽤。

**3、** 客户端还可以缓存⼀些服务实例信息，所以即使Eureka全挂掉，客户端也是可以定位到服务地址的。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_4.png#alt=45%5C_4.png)


### 9、什么是Spring Cloud Bus?

spring cloud bus 将分布式的节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。

如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件。

**使用:**

**1、** 添加依赖

**2、** 配置rabbimq


### 10、什么是不同类型的双因素身份认证？

执行双因素身份验证需要三种类型的凭据：

**1、** 一件你知道的事情——比如密码、密码或屏幕锁定模式。

**2、** 您拥有的物理凭证，如OTP、电话或ATM卡，换句话说，您在外部或第三方设备中拥有的任何类型的凭证。

**3、** 您的物理身份–如语音认证或生物特征安全，如指纹或眼睛扫描仪。


### 11、什么是Eureka的自我保护模式，
### 12、康威定律是什么？
### 13、架构师在微服务架构中的角色是什么？
### 14、分布式配置中心有那些框架？
### 15、什么是Semantic监控？
### 16、Spring Cloud Config
### 17、Spring Cloud Config
### 18、Spring Cloud Zookeeper
### 19、Spring Cloud Bus
### 20、双因素身份验证的凭据类型有哪些？
### 21、第⼆层缓存：
### 22、ZuulFilter常用有那些方法
### 23、如何设计一套API接口
### 24、什么是Spring引导的执行器？
### 25、如何设置服务发现？
### 26、什么是Spring Cloud？
### 27、为什么要选择微服务架构？
### 28、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 29、Spring Cloud Netflix(重点，这些组件用的最多)
### 30、什么是 Hystrix 断路器？我们需要它吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
