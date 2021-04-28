# Dubbo最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Dubbo 与 Spring 的关系？

Dubbo 采用全 Spring 配置方式，透明化接入应用，对应用没有任何API 侵入，只需用 Spring 加载 Dubbo 的配置即可， Dubbo 基于Spring 的 Schema 扩展进行加载。


### 2、画一画服务注册与发现的流程图？

![](http://dubbo.apache.org/img/architecture.png#alt=)


### 3、Dubbo 类似的分布式框架还有哪些？

比较著名的就是 Spring Cloud。


### 4、dubbo 通信协议 dubbo 协议为什么不能传大包；

因 dubbo 协议采用单一长连接，如果每次请求的数据包大小为 500KByte，假设网络为千兆网卡(1024Mbit=128MByte)，每条连接最大 7MByte(不同的环境可能不一样，供参考)，单个服务提供者的 TPS(每秒处理事务数)最大为：128MByte / 500KByte = 262。

单个消费者调用单个服务提供者的 TPS(每秒处理事务数)最大为：7MByte / 500KByte = 14。

如果能接受，可以考虑使用，否则网络将成为瓶颈。


### 5、说说核心的配置有哪些？
| 配置 | 配置说明 |
| --- | --- |
| dubbo:service | 服务配置 |
| dubbo:reference | 引用配置 |
| dubbo:protocol | 协议配置 |
| dubbo:application | 应用配置 |
| dubbo:module | 模块配置 |
| dubbo:registry | 注册中心配置 |
| dubbo:monitor | 监控中心配置 |
| dubbo:provider | 提供方配置 |
| dubbo:consumer | 消费方配置 |
| dubbo:method | 方法配置 |
| dubbo:argument | 参数配置 |



### 6、同一个服务多个注册的情况下可以直连某一个服务吗？

可以直连，修改配置即可，也可以通过telnet直接某个服务。


### 7、Dubbo集群提供了哪些负载均衡策略？

**1、** Random LoadBalance: 随机选取提供者策略，有利于动态调整提供者权重。截面碰撞率高，调用次数越多，分布越均匀。

**2、** RoundRobin LoadBalance: 轮循选取提供者策略，平均分布，但是存在请求累积的问题。

**3、** LeastActive LoadBalance: 最少活跃调用策略，解决慢提供者接收更少的请求。

**4、** ConstantHash LoadBalance: 一致性 Hash 策略，使相同参数请求总是发到同一提供者，一台机器宕机，可以基于虚拟节点，分摊至其他提供者，避免引起提供者的剧烈变动。

`默认为 Random 随机调用。`


### 8、dubbo 在安全机制方面如何解决的？

dubbo 通过 token 令牌防止用户绕过注册中心直连，然后在注册中心管理授权，dubbo 提供了黑白名单，控制服务所允许的调用方。


### 9、Dubbo有哪几种集群容错方案，默认是哪种？

**1、** Failover Cluster 失败自动切换，自动重试其他服务器(默认)

**2、** Failfast Cluster 快速失败，立即报错，只发起一次调用

**3、** Failsafe Cluster 失败安全，出现异常时，直接忽略

**4、** Failback Cluster 失败自动回复，记录失败请求，定时请求

**5、** Forking Cluster  并行调用多个服务器，只要一个成功即返回

**6、** Broadcast Cluster 广播逐个调用所有提供者，任意一个报错则报错


### 10、同一个服务多个注册的情况下可以直连某一个服务吗？

可以点对点直连，修改配置即可，也可以通过telnet直接某个服务。


### 11、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 12、Dubbo 的主要应用场景？
### 13、Dubbo 可以对结果进行缓存吗？
### 14、说说 Dubbo 服务暴露的过程。
### 15、你还了解别的分布式框架吗？
### 16、Dubbo 支持服务降级吗？
### 17、RPC使用了哪些关键技术，Thrift
### 18、默认使用什么序列化框架，你知道的还有哪些？
### 19、如何解决服务调用链过长的问题？
### 20、Dubbo 的注册中心集群挂掉，者和订阅者之间还能通信么？
### 21、Dubbo 服务降级，失败重试怎么做？
### 22、服务调用超时问题怎么解决？
### 23、Dubbo 配置文件是如何加载到Spring中的？
### 24、Dubbo 默认采用注册中心？
### 25、Dubbo 使用的是什么通信框架?
### 26、Dubbo 支持哪些序列化方式？
### 27、dubbo 推荐用什么协议？
### 28、Dubbo 支持分布式事务吗？
### 29、默认使用什么序列化框架，你知道的还有哪些？
### 30、Dubbo 和 Spring Cloud 的关系？
### 31、Dubbo 核心组件有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
