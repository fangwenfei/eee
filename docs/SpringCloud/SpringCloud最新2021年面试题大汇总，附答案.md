# SpringCloud最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何实现动态Zuul网关路由转发

通过path配置拦截请求，通过ServiceId到配置中心获取转发的服务列表，Zuul内部使用Ribbon实现本地负载均衡和转发。


### 2、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？

**1、** zookeeper 是CP原则，强一致性和分区容错性。

**2、** eureka 是AP 原则 可用性和分区容错性。

**3、** zookeeper当主节点故障时，zk会在剩余节点重新选择主节点，耗时过长，虽然最终能够恢复，但是选取主节点期间会导致服务不可用，这是不能容忍的。

**4、** eureka各个节点是平等的，一个节点挂掉，其他节点仍会正常保证服务。


### 3、过渡到微服务时的常见错误

不仅在开发上，而且在方面流程也经常发生错误。一些常见错误是：

**1、** 通常开发人员无法概述当前的挑战。

**2、** 重写已经存在的程序。

**3、** 职责、时间线和界限没有明确定义。

**4、** 未能从一开始就实施和确定自动化的范围。


### 4、Eureka如何 保证AP

Eureka看明⽩了这⼀点，因此在设计时就优先保证可⽤性。Eureka各个节点都是平等的，⼏个节点挂掉不会影响正常节点的⼯作，剩余的节点依然可以提供注册和查询服务。⽽Eureka的客户端在向某个Eureka注册或如果发现连接失败，则会⾃动切换⾄其它节点，只要有⼀台Eureka还在，就能保证注册服务可⽤(保证可⽤性)，只不过查到的信息可能不是最新的(不保证强⼀致性)。除此之外，Eureka还有⼀种⾃我保护机制，如果在15分钟内超过85%的节点都没有正常的⼼跳，那么Eureka就认为客户端与注册中⼼出现了⽹络故障，此时会出现以下⼏种情况：

**1、** Eureka不再从注册列表中移除因为⻓时间没收到⼼跳⽽应该过期的服务

**2、** Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可⽤)

**3、** 当⽹络稳定时，当前实例新的注册信息会被同步到其它节点中

因此， Eureka可以很好的应对因⽹络故障导致部分节点失去联系的情况，⽽不会像zookeeper那样使整个注册服务瘫痪。


### 5、SpringBoot和SpringCloud的区别？

**1、** SpringBoot专注于快速方便的开发单个个体微服务。

**2、** SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，

**3、** 为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务

**4、** SpringBoot可以离开SpringCloud独立使用开发项目， 但是SpringCloud离不开SpringBoot ，属于依赖的关系

**5、** SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。


### 6、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。 Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 7、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston | 1.5.x |



### 8、什么是Eureka

Eureka作为SpringCloud的服务注册功能服务器，他是服务注册中心，系统中的其他服务使用Eureka的客户端将其连接到Eureka Service中，并且保持心跳，这样工作人员可以通过Eureka Service来监控各个微服务是否运行正常。


### 9、Zookeeper如何 保证CP

当向注册中⼼查询服务列表时，我们可以容忍注册中⼼返回的是⼏分钟以前的注册信息，但不能接受服务直接down掉不可⽤。也就是说，服务注册功能对可⽤性的要求要⾼于⼀致性。但是zk会出现这样⼀种情况，当master节点因为⽹络故障与其他节点失去联系时，剩余节点会重新进⾏leader选举。问题在于，选举leader的时间太⻓，30 ~ 120s, 且选举期间整个zk集群都是不可⽤的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因⽹络问题使得zk集群失去master节点是较⼤概率会发⽣的事，虽然服务能够最终恢复，但是漫⻓的选举时间导致的注册⻓期不可⽤是不能容忍的。


### 10、什么是微服务

**1、** 微服务是⼀种架构⻛格，也是⼀种服务；

**2、** 微服务的颗粒⽐较⼩，⼀个⼤型复杂软件应⽤由多个微服务组成，⽐如Netflix⽬前由500多的微服务组成；

**3、** 它采⽤UNIX设计的哲学，每种服务只做⼀件事，是⼀种松耦合的能够被独⽴开发和部署的⽆状态化服务（独⽴扩展、升级和可替换）。


### 11、什么是网关?
### 12、分布式配置中心有那些框架？
### 13、服务雪崩效应产生的原因
### 14、微服务之间是如何独立通讯的?
### 15、Ribbon和Feign的区别？
### 16、微服务之间是如何独立通讯的
### 17、如何配置SpringBoot应用程序日志记录？
### 18、康威定律是什么？
### 19、Mock或Stub有什么区别？
### 20、Spring Cloud 是什么
### 21、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter
### 22、单片，SOA和微服务架构有什么区别？
### 23、spring cloud 和dubbo区别?
### 24、架构师在微服务架构中的角色是什么？
### 25、为什么要选择微服务架构？
### 26、Spring Cloud的版本关系
### 27、eureka缓存机制：
### 28、微服务之间是如何独⽴通讯的
### 29、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 30、在使用微服务架构时，您面临哪些挑战？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
