# SpringCloud最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么需要学习Spring Cloud

**1、** 首先springcloud基于spingboot的优雅简洁，可还记得我们被无数xml支配的恐惧？可还记得springmvc，mybatis错综复杂的配置，有了spingboot，这些东西都不需要了，spingboot好处不再赘诉，springcloud就基于SpringBoot把市场上优秀的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理

**2、** 什么叫做开箱即用？即使是当年的黄金搭档dubbo+zookeeper下载配置起来也是颇费心神的！而springcloud完成这些只需要一个jar的依赖就可以了！

**3、** springcloud大多数子模块都是直击痛点，像zuul解决的跨域，fegin解决的负载均衡，hystrix的熔断机制等等等等


### 2、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？

**1、** RoundRobinRule:轮询策略，Ribbon以轮询的⽅式选择服务器，这个是默认值。所以示例中所启动的两个服务会被循环访问;

**2、** RandomRule:随机选择，也就是说Ribbon会随机从服务器列表中选择⼀个进⾏访问;

**3、** BestAvailableRule:最⼤可⽤策略，即先过滤出故障服务器后，选择⼀个当前并发请求数最⼩的;

**4、** WeightedResponseTimeRule:带有加权的轮询策略，对各个服务器响应时间进⾏加权处理，然后在采⽤轮询的⽅式来获取相应的服务器;

**5、** AvailabilityFilteringRule:可⽤过滤策略，先过滤出故障的或并发请求⼤于阈值⼀部分服务实例，然后再以线性轮询的⽅式从过滤后的实例清单中选出⼀个;

**6、** ZoneAvoidanceRule:区域感知策略，先使⽤主过滤条件（区域负载器，选择最优区域）对所有实例过滤并返回过滤后的实例清单，依次使⽤次过滤条件列表中的过滤条件对主过滤条件的结果进⾏过滤，判断最⼩过滤数（默认1）和最⼩过滤百分⽐（默认0），最后对满⾜条件的服务器则使⽤RoundRobinRule(轮询⽅式)选择⼀个服务器实例。


### 3、什么是Hystrix？它如何实现容错？

Hystrix是一个延迟和容错库，旨在隔离远程系统，服务和第三方库的访问点，当出现故障是不可避免的故障时，停止级联故障并在复杂的分布式系统中实现弹性。

通常对于使用微服务架构开发的系统，涉及到许多微服务。这些微服务彼此协作。

思考以下微服务

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_2.png#alt=img%5C_2.png)

假设如果上图中的微服务9失败了，那么使用传统方法我们将传播一个异常。但这仍然会导致整个系统崩溃。

随着微服务数量的增加，这个问题变得更加复杂。微服务的数量可以高达1000.这是hystrix出现的地方 我们将使用Hystrix在这种情况下的Fallback方法功能。我们有两个服务employee-consumer使用由employee-consumer公开的服务。

简化图如下所示

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_3.png#alt=img%5C_3.png)

现在假设由于某种原因，employee-producer公开的服务会抛出异常。我们在这种情况下使用Hystrix定义了一个回退方法。这种后备方法应该具有与公开服务相同的返回类型。如果暴露服务中出现异常，则回退方法将返回一些值。


### 4、Zookeeper如何 保证CP

当向注册中⼼查询服务列表时，我们可以容忍注册中⼼返回的是⼏分钟以前的注册信息，但不能接受服务直接down掉不可⽤。也就是说，服务注册功能对可⽤性的要求要⾼于⼀致性。但是zk会出现这样⼀种情况，当master节点因为⽹络故障与其他节点失去联系时，剩余节点会重新进⾏leader选举。问题在于，选举leader的时间太⻓，30 ~ 120s, 且选举期间整个zk集群都是不可⽤的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因⽹络问题使得zk集群失去master节点是较⼤概率会发⽣的事，虽然服务能够最终恢复，但是漫⻓的选举时间导致的注册⻓期不可⽤是不能容忍的。


### 5、Spring Cloud Consul

基于Hashicorp Consul的服务治理组件。


### 6、Web，RESTful API在微服务中的作用是什么？

微服务架构基于一个概念，其中所有服务应该能够彼此交互以构建业务功能。因此，要实现这一点，每个微服务必须具有接口。这使得Web API成为微服务的一个非常重要的推动者。RESTful API基于Web的开放网络原则，为构建微服务架构的各个组件之间的接口提供了最合理的模型。


### 7、Spring Cloud Security

安全工具包，对Zuul代理中的负载均衡OAuth2客户端及登录认证进行支持。


### 8、什么是Spring Cloud？

根据Spring Cloud的官方网站，Spring Cloud为开发人员提供了快速构建分布式系统中一些常见模式的工具（例如配置管理，服务发现，断路器，智能路由，领导选举，分布式会话，集群状态）。


### 9、什么是服务熔断

如果检查出来频繁超时，就把consumer调⽤provider的请求，直接短路掉，不实际调⽤，⽽是直接返回⼀个mock的值。


### 10、微服务之间如何独立通讯的?

同步通信：dobbo通过 RPC 远程过程调用、springcloud通过 REST 接口json调用 等。

异步：消息队列，如：RabbitMq、ActiveM、Kafka 等。


### 11、Spring Cloud和SpringBoot版本对应关系
### 12、微服务架构如何运作？
### 13、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 14、什么是Oauth？
### 15、SpringCloud的优缺点
### 16、Spring Cloud和SpringBoot版本对应关系
### 17、微服务测试的主要障碍是什么？
### 18、你对SpringBoot有什么了解？
### 19、服务注册和发现是什么意思？Spring Cloud如何实现？
### 20、什么是Netflix Feign？它的优点是什么？
### 21、合同测试你懂什么？
### 22、微服务的优点
### 23、什么是Hystrix?
### 24、eureka缓存机制：
### 25、Spring Cloud Consul
### 26、什么是SpringBoot？
### 27、什么是双因素身份验证？
### 28、微服务设计的基础是什么？
### 29、spring cloud 和dubbo区别?
### 30、什么是凝聚力？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
