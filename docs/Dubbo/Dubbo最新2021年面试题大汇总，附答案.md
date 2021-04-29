# Dubbo最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、RPC使用了哪些关键技术，服务调用

B机器进行本地调用（通过代理Proxy和反射调用）之后得到了返回值，此时还需要再把返回值发送回A机器，同样也需要经过序列化操作，然后再经过网络传输将二进制数据发送回A机器，而当A机器接收到这些返回值之后，则再次进行反序列化操作，恢复为内存中的表达方式，最后再交给A机器上的应用进行相关处理（一般是业务逻辑处理操作）。

通常，经过以上四个步骤之后，一次完整的RPC调用算是完成了，另外可能因为网络抖动等原因需要重试等。

### 2、Dubbo 集群的负载均衡有哪些策略?

Dubbo 提供了常见的集群策略实现，并预扩展点予以自行实现。

**1、** Random LoadBalance: 随机选取提供者策略，有利于动态调整提供者权重。截面碰撞率高，调用次数越多，分布越均匀；

**2、** RoundRobin LoadBalance: 轮循选取提供者策略，平均分布，但是存在请求累积的问题；

**3、** LeastActive LoadBalance: 最少活跃调用策略，解决慢提供者接收更少的请求；

**4、** ConstantHash LoadBalance: 一致性 Hash 策略，使相同参数请求总是发到同一提供者，一台机器宕机，可以基于虚拟节点，分摊至其他提供者，避免引起提供者的剧烈变动；


### 3、RPC使用了哪些关键技术，protobuf-rpc-pro

是一个Java类库，提供了基于 Google 的 Protocol Buffers 协议的远程方法调用的框架。基于 Netty 底层的 NIO 技术。支持 TCP 重用/ keep-alive、SSL加密、RPC 调用取消操作、嵌入式日志等功能。


### 4、dubbo推荐用什么协议？

默认使用dubbo协议。


### 5、RPC使用了哪些关键技术，Dubbo

Dubbo是 阿里巴巴公司开源的一个高性能优秀的服务框架，使得应用可通过高性能的 RPC 实现服务的输出和输入功能，可以和 Spring框架无缝集成。


### 6、RPC使用了哪些关键技术，NIO通信

出于并发性能的考虑，传统的阻塞式 IO 显然不太合适，因此我们需要异步的 IO，即 NIO。Java 提供了 NIO 的解决方案，Java 7 也提供了更优秀的 NIO.2 支持。可以选择Netty或者MINA来解决NIO数据传输的问题。


### 7、在使用过程中都遇到了些什么问题？

如序列化问题。


### 8、服务调用超时问题怎么解决

dubbo在调用服务不成功时，默认是会重试两次的。这样在服务端的处理时间超过了设定的超时时间时，就会有重复请求，比如在发邮件时，可能就会发出多份重复邮件，执行注册请求时，就会插入多条重复的注册数据，那么怎么解决超时问题呢？如下

对于核心的服务中心，去除dubbo超时重试机制，并重新评估设置超时时间。 业务处理代码必须放在服务端，客户端只做参数验证和服务调用，不涉及业务流程处理 全局配置实例

<dubbo:provider delay="-1" timeout="6000" retries="0"/>

当然Dubbo的重试机制其实是非常好的QOS保证，它的路由机制，是会帮你把超时的请求路由到其他机器上，而不是本机尝试，所以 dubbo的重试机器也能一定程度的保证服务的质量。但是请一定要综合线上的访问情况，给出综合的评估。


### 9、服务提供者能实现失效踢出的是什么原理？

服务失效踢出基于zookeeper的临时节点原理。


### 10、Dubbo 必须依赖的包有哪些？

Dubbo 必须依赖 JDK，其他为可选。


### 11、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 12、Dubbo 服务注册与发现的流程？
### 13、你还了解别的分布式框架吗？
### 14、dubbo 推荐用什么协议？
### 15、一般使用什么注册中心？还有别的选择吗？
### 16、Dubbo 服务降级，失败重试怎么做？
### 17、Dubbo中zookeeper做注册中心，如果注册中心集群都挂掉，者和订阅者之间还能通信么？
### 18、Dubbo 支持服务降级吗？
### 19、集群容错怎么做？
### 20、默认使用的是什么通信框架，还有别的选择吗?
### 21、Dubbo 使用过程中都遇到了些什么问题？
### 22、Dubbo 使用的是什么通信框架?
### 23、dubbo 推荐用什么协议？
### 24、Dubbo 和 Spring Cloud 有什么关系？
### 25、服务调用超时会怎么样？
### 26、RPC的实现基础？
### 27、Dubbo 的主要应用场景？
### 28、RPC使用了哪些关键技术，Avro
### 29、为什么要用Dubbo？
### 30、Dubbo 核心组件有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
