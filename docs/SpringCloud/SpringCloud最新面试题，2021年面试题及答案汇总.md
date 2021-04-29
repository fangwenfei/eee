# SpringCloud最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cloud 和dubbo区别?

**1、** 服务调用方式：dubbo是RPC springcloud Rest Api

**2、** 注册中心：dubbo 是zookeeper springcloud是eureka，也可以是zookeeper

**3、** 服务网关，dubbo本身没有实现，只能通过其他第三方技术整合，springcloud有Zuul路由网关，作为路由服务器，进行消费者的请求分发,springcloud支持断路器，与git完美集成配置文件支持版本控制，事物总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素。


### 2、什么是Spring Cloud Bus?

spring cloud bus 将分布式的节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。

如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件。

**使用:**

**1、** 添加依赖

**2、** 配置rabbimq


### 3、SpringCloud主要项目

Spring Cloud的子项目，大致可分成两类，一类是对现有成熟框架"SpringBoot化"的封装和抽象，也是数量最多的项目；第二类是开发了一部分分布式系统的基础设施的实现，如Spring Cloud Stream扮演的就是Kafka, ActiveMQ这样的角色。


### 4、在使用微服务架构时，您面临哪些挑战？

开发一些较小的微服务听起来很容易，但开发它们时经常遇到的挑战如下。

自动化组件：难以自动化，因为有许多较小的组件。因此，对于每个组件，我们必须遵循Build，Deploy和Monitor的各个阶段。

易感性：将大量组件维护在一起变得难以部署，维护，监控和识别问题。它需要在所有组件周围具有很好的感知能力。

配置管理：有时在各种环境中维护组件的配置变得困难。

调试：很难找到错误的每一项服务。维护集中式日志记录和仪表板以调试问题至关重要。


### 5、什么是Spring Cloud？

在微服务中，SpringCloud是一个提供与外部系统集成的系统。它是一个敏捷的框架，可以短平快构建应用程序。与有限数量的数据处理相关联，它在微服务体系结构中起着非常重要的作用。 **以下为 Spring Cloud 的核心特性**：

**1、** 版本化/分布式配置。

**2、** 服务注册和发现。

**3、** 服务和服务之间的调用。

**4、** 路由。

**5、** 断路器和负载平衡。

**6、** 分布式消息传递。


### 6、Spring Cloud Sleuth

Spring Cloud应用程序的分布式请求链路跟踪，支持使用Zipkin、HTrace和基于日志（例如ELK）的跟踪。


### 7、什么是Hystrix断路器？我们需要它吗？

由于某些原因，employee-consumer公开服务会引发异常。在这种情况下使用Hystrix我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_4.png#alt=img%5C_4.png)

如果firstPage method() 中的异常继续发生，则Hystrix电路将中断，并且员工使用者将一起跳过firtsPage方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_5.png#alt=img%5C_5.png)


### 8、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？

**1、** RoundRobinRule:轮询策略，Ribbon以轮询的⽅式选择服务器，这个是默认值。所以示例中所启动的两个服务会被循环访问;

**2、** RandomRule:随机选择，也就是说Ribbon会随机从服务器列表中选择⼀个进⾏访问;

**3、** BestAvailableRule:最⼤可⽤策略，即先过滤出故障服务器后，选择⼀个当前并发请求数最⼩的;

**4、** WeightedResponseTimeRule:带有加权的轮询策略，对各个服务器响应时间进⾏加权处理，然后在采⽤轮询的⽅式来获取相应的服务器;

**5、** AvailabilityFilteringRule:可⽤过滤策略，先过滤出故障的或并发请求⼤于阈值⼀部分服务实例，然后再以线性轮询的⽅式从过滤后的实例清单中选出⼀个;

**6、** ZoneAvoidanceRule:区域感知策略，先使⽤主过滤条件（区域负载器，选择最优区域）对所有实例过滤并返回过滤后的实例清单，依次使⽤次过滤条件列表中的过滤条件对主过滤条件的结果进⾏过滤，判断最⼩过滤数（默认1）和最⼩过滤百分⽐（默认0），最后对满⾜条件的服务器则使⽤RoundRobinRule(轮询⽅式)选择⼀个服务器实例。


### 9、使用 SpringBoot 开发分布式微服务时，我们面临什么问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。


### 10、什么是断路器

当一个服务调用另一个服务由于网络原因或自身原因出现问题，调用者就会等待被调用者的响应 当更多的服务请求到这些资源导致更多的请求等待，发生连锁效应（雪崩效应）

**断路器有三种状态**

**1、** 打开状态：一段时间内 达到一定的次数无法调用 并且多次监测没有恢复的迹象 断路器完全打开 那么下次请求就不会请求到该服务

**2、** 半开状态：短时间内 有恢复迹象 断路器会将部分请求发给该服务，正常调用时 断路器关闭

**3、** 关闭状态：当服务一直处于正常状态 能正常调用


### 11、SpringCloud的优缺点
### 12、什么是金丝雀释放？
### 13、ZuulFilter常用有那些方法
### 14、微服务有什么特点？
### 15、Spring Cloud 是什么
### 16、为什么在微服务中需要Reports报告和Dashboards仪表板？
### 17、分布式配置中心有那些框架？
### 18、什么是服务熔断
### 19、什么是双因素身份验证？
### 20、如何实现动态Zuul网关路由转发
### 21、什么是持续监测？
### 22、微服务测试的主要障碍是什么？
### 23、什么是Spring Cloud Config?
### 24、什么是领域驱动设计？
### 25、eureka的缺点：
### 26、Spring Cloud OpenFeign
### 27、为什么我们需要微服务容器？
### 28、Spring Cloud Gateway
### 29、双因素身份验证的凭据类型有哪些？
### 30、DiscoveryClient的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
