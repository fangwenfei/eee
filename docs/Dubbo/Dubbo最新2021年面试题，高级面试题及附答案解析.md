# Dubbo最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Dubbo 的注册中心集群挂掉，者和订阅者之间还能通信么？

可以的，启动 dubbo 时，消费者会从 zookeeper 拉取注册的生产者的地址接口等数据，缓存在本地。

每次调用时，按照本地存储的地址进行调用。


### 2、RPC使用了哪些关键技术，从服务提供者的角度看：

当服务提供者启动的时候，需要将自己提供的服务注册到指定的注册中心，以便服务消费者能够通过服务注册中心进行查找；

当服务提供者由于各种原因致使提供的服务停止时，需要向注册中心注销停止的服务；

服务的提供者需要定期向服务注册中心发送心跳检测，服务注册中心如果一段时间未收到来自服务提供者的心跳后，认为该服务提供者已经停止服务，则将该服务从注册中心上去掉。


### 3、RPC使用了哪些关键技术，服务注册中心

可选：Redis、Zookeeper、Consul 、Etcd。一般使用ZooKeeper提供服务注册与发现功能，解决单点故障以及分布式部署的问题(注册中心)。


### 4、RPC使用了哪些关键技术，序列化

当A机器上的应用发起一个RPC调用时，调用方法和其入参等信息需要通过底层的网络协议如TCP传输到B机器，由于网络协议是基于二进制的，所有我们传输的参数数据都需要先进行序列化（Serialize）或者编组（marshal）成二进制的形式才能在网络中进行传输。然后通过寻址操作和网络传输将序列化或者编组之后的二进制数据发送给B机器。


### 5、Dubbo 的架构设计

**Dubbo 框架设计一共划分了 10 个层：**

**1、** 服务接口层（ Service） ：该层是与实际业务逻辑相关的，根据服务提供方和服务消费方的业务设计对应的接口和实现。

**2、** 配置层（ Config） ：对外配置接口，以 ServiceConfig 和ReferenceConfig 为中心。

**3、** 服务代理层（ Proxy）：服务接口透明代理，生成服务的客户端 Stub和服务器端 Skeleton

**4、** 服务注册层（ Registry） ：封装服务地址的注册与发现，以服务 URL为中心。

**5、** 集群层（ Cluster） ：封装多个提供者的路由及负载均衡，并桥接注册中心，以 Invoker 为中心。

**6、** 监控层（ Monitor） ：RPC 调用次数和调用时间监控。

**7、** 远程调用层（ Protocol） ：封将 RPC 调用，以 Invocation 和 Result为中心，扩展接口为 Protocol、 Invoker 和 Exporter。

**8、** 信息交换层（ Exchange） ：封装请求响应模式，同步转异步，以Request 和 Response 为中心。

**9、** 网络传输层（ Transport） ：抽象 mina 和 netty 为统一接口，以Message 为中心。


### 6、Dubbo 集群的负载均衡有哪些策略

Dubbo 提供了常见的集群策略实现，并预扩展点予以自行实现。

Random LoadBalance: 随机选取提供者策略，有利于动态调整提供者权重。截面碰撞率高，调用次数越多，分布越均匀；

RoundRobin LoadBalance: 轮循选取提供者策略，平均分布，但是存在请求累积的问题；

LeastActive LoadBalance: 最少活跃调用策略，解决慢提供者接收更少的请求； ConstantHash LoadBalance: 一致性 Hash 策略，使相同参数请求总是发到同一提供者，一台机器宕机，可以基于虚拟节点，分摊至其他提供者，避免引起提供者的剧烈变动；


### 7、RPC使用了哪些关键技术，Avro

出自Hadoop之父Doug Cutting, 在Thrift已经相当流行的情况下推出Avro的目标不仅是提供一套类似Thrift的通讯中间件,更是要建立一个新的，标准性的云计算的数据交换和存储的Protocol。支持HTTP，TCP两种协议。


### 8、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。


### 9、Dubbo 使用过程中都遇到了些什么问题？

在注册中心找不到对应的服务,检查service实现类是否添加了@service注解

无法连接到注册中心,检查配置文件中的对应的测试ip是否正确


### 10、Dubbo 在安全方面有哪些措施？

Dubbo 通过 Token 令牌防止用户绕过注册中心直连，然后在注册中心上管理授权。

Dubbo 还提供服务黑白名单，来控制服务所允许的调用方。


### 11、Dubbo 和 Dubbox 之间的区别？
### 12、dubbo 通信协议 dubbo 协议为什么要消费者比提供者个数多？
### 13、在使用过程中都遇到了些什么问题？ 如何解决的？
### 14、RPC使用了哪些关键技术，服务调用
### 15、Dubbo服务降级，失败重试怎么做？
### 16、Dubbo 服务注册与发现的流程？
### 17、Dubbo SPI 和 Java SPI 区别？
### 18、RPC使用了哪些关键技术，建立通信
### 19、Dubbo 推荐什么协议？
### 20、如何解决服务调用链过长的问题？
### 21、dubbo 通信协议 dubbo 协议适用范围和适用场景
### 22、Dubbo 类似的分布式框架还有哪些？
### 23、Dubbo 核心功能有哪些？
### 24、RPC的实现基础？
### 25、在使用过程中都遇到了些什么问题？
### 26、dubbo 推荐用什么协议？
### 27、服务调用是阻塞的吗？
### 28、Dubbo 和 Spring Cloud 的区别？
### 29、RPC使用了哪些关键技术，服务寻址
### 30、Dubbo telnet 命令能做什么？
### 31、RPC使用了哪些关键技术，RMI




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
