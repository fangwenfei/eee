# SpringCloud最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？

**1、** RoundRobinRule:轮询策略，Ribbon以轮询的⽅式选择服务器，这个是默认值。所以示例中所启动的两个服务会被循环访问;

**2、** RandomRule:随机选择，也就是说Ribbon会随机从服务器列表中选择⼀个进⾏访问;

**3、** BestAvailableRule:最⼤可⽤策略，即先过滤出故障服务器后，选择⼀个当前并发请求数最⼩的;

**4、** WeightedResponseTimeRule:带有加权的轮询策略，对各个服务器响应时间进⾏加权处理，然后在采⽤轮询的⽅式来获取相应的服务器;

**5、** AvailabilityFilteringRule:可⽤过滤策略，先过滤出故障的或并发请求⼤于阈值⼀部分服务实例，然后再以线性轮询的⽅式从过滤后的实例清单中选出⼀个;

**6、** ZoneAvoidanceRule:区域感知策略，先使⽤主过滤条件（区域负载器，选择最优区域）对所有实例过滤并返回过滤后的实例清单，依次使⽤次过滤条件列表中的过滤条件对主过滤条件的结果进⾏过滤，判断最⼩过滤数（默认1）和最⼩过滤百分⽐（默认0），最后对满⾜条件的服务器则使⽤RoundRobinRule(轮询⽅式)选择⼀个服务器实例。


### 2、SpringCloud 和 Dubbo 有哪些区别?

首先，他们都是分布式管理框架。

dubbo 是二进制传输，占用带宽会少一点。SpringCloud是http 传输，带宽会多一点，同时使用http协议一般会使用JSON报文，消耗会更大。

dubbo 开发难度较大，所依赖的 jar 包有很多问题大型工程无法解决。SpringCloud 对第三方的继承可以一键式生成，天然集成。

SpringCloud 接口协议约定比较松散，需要强有力的行政措施来限制接口无序升级。

最大的区别:


### 3、Nginx与Ribbon的区别

Nginx是反向代理同时可以实现负载均衡，nginx拦截客户端请求采用负载均衡策略根据upstream配置进行转发，相当于请求通过nginx服务器进行转发。Ribbon是客户端负载均衡，从注册中心读取目标服务器信息，然后客户端采用轮询策略对服务直接访问，全程在客户端操作。


### 4、架构师在微服务架构中的角色是什么？

微服务架构中的架构师扮演以下角色：

决定整个软件系统的布局。

帮助确定组件的分区。因此，他们确保组件相互粘合，但不紧密耦合。

与开发人员共同编写代码，了解日常生活中面临的挑战。

为开发微服务的团队提供某些工具和技术的建议。

提供技术治理，以便技术开发团队遵循微服务原则。


### 5、微服务之间是如何独立通讯的?

**1、** 远程调用，比如feign调用，直接通过远程过程调用来访问别的service。 2.消息中间件


### 6、什么是Spring Cloud Bus？我们需要它吗？

考虑以下情况：我们有多个应用程序使用Spring Cloud Config读取属性，而Spring Cloud Config从GIT读取这些属性。

下面的例子中多个员工生产者模块从Employee Config Module获取Eureka注册的财产。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_6.png#alt=img%5C_6.png)

如果假设GIT中的Eureka注册属性更改为指向另一台Eureka服务器，会发生什么情况。在这种情况下，我们将不得不重新启动服务以获取更新的属性。

还有另一种使用执行器端点/刷新的方式。但是我们将不得不为每个模块单独调用这个url。例如，如果Employee Producer1部署在端口8080上，则调用 http：// localhost：8080 / refresh。同样对于Employee Producer2 http：// localhost：8081 / refresh等等。这又很麻烦。这就是Spring Cloud Bus发挥作用的地方。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_7.png#alt=img%5C_7.png)

Spring Cloud Bus提供了跨多个实例刷新配置的功能。因此，在上面的示例中，如果我们刷新Employee Producer1，则会自动刷新所有其他必需的模块。如果我们有多个微服务启动并运行，这特别有用。这是通过将所有微服务连接到单个消息代理来实现的。无论何时刷新实例，此事件都会订阅到侦听此代理的所有微服务，并且它们也会刷新。可以通过使用端点/总线/刷新来实现对任何单个实例的刷新。


### 7、Spring Cloud Consul

基于Hashicorp Consul的服务治理组件。


### 8、使用 SpringBoot 开发分布式微服务时，我们面临什么问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。


### 9、什么是持续集成（CI）？

持续集成（CI）是每次团队成员提交版本控制更改时自动构建和测试代码的过程。这鼓励开发人员通过在每个小任务完成后将更改合并到共享版本控制存储库来共享代码和单元测试。


### 10、什么是端到端微服务测试？

端到端测试验证了工作流中的每个流程都正常运行。这可确保系统作为一个整体协同工作并满足所有要求。

通俗地说，你可以说端到端测试是一种测试，在特定时期后测试所有东西。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_17.png#alt=img%5C_17.png)

图14：测试层次 – 微服务面试问题


### 11、什么是Netflix Feign？它的优点是什么？
### 12、什么是Hystrix断路器？我们需要它吗？
### 13、康威定律是什么？
### 14、springcloud和dubbo有哪些区别
### 15、什么是持续监测？
### 16、什么是断路器
### 17、什么是耦合和凝聚力？
### 18、我们可以用微服务创建状态机吗？
### 19、SpringBoot支持哪些嵌入式容器？
### 20、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 21、Spring Cloud和各子项目版本对应关系
### 22、SpringBoot和springcloud认识
### 23、Spring Cloud解决了哪些问题？
### 24、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter
### 25、spring cloud 和dubbo区别?
### 26、负载平衡的意义什么？
### 27、微服务之间如何独立通讯的?
### 28、我们如何进行跨功能测试？
### 29、Zookeeper如何 保证CP
### 30、Ribbon底层实现原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
