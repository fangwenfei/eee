# Dubbo最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、RPC使用了哪些关键技术，服务注册中心

可选：Redis、Zookeeper、Consul 、Etcd。一般使用ZooKeeper提供服务注册与发现功能，解决单点故障以及分布式部署的问题(注册中心)。


### 2、Dubbo服务降级，失败重试怎么做？

可以通过dubbo:reference 中设置mock="return null"。mock的值也可以修改为true，然后在跟接口同一个路径下实现一个Mock类，命名规则是"接口名称+Mock"后缀。然后在Mock类里实现自己的降级逻辑。



### 3、服务上线怎么不影响旧版本？

采用多版本开发，不影响旧版本。


### 4、Dubbo 支持哪些协议，它们的优缺点有哪些？

**1、** Dubbo： 单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步 Hessian 序列化。

**2、** RMI： 采用 JDK 标准的 RMI 协议实现，传输参数和返回参数对象需要实现 Serializable 接口，使用 Java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。 多个短连接 TCP 协议传输，同步传输，适用常规的远程服务调用和 RMI 互操作。在依赖低版本的 Common-Collections 包，Java 序列化存在安全漏洞。

**3、** WebService：基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用。

**4、** HTTP： 基于 Http 表单提交的远程调用协议，使用 Spring 的 HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用。

**5、** Hessian：集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务，Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输，Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件。

**6、** Memcache：基于 Memcache实现的 RPC 协议。

**7、** Redis：基于 Redis 实现的RPC协议。


### 5、服务调用超时问题怎么解决？

dubbo 在调用服务不成功时，默认是会重试两次的。


### 6、Dubbo 支持分布式事务吗？

目前暂时不支持，可与通过 tcc-transaction框架实现

介绍：tcc-transaction是开源的TCC补偿性分布式事务框架

Git地址：[https://github.com/changmingxie/tcc-transaction](https://github.com/changmingxie/tcc-transaction)

TCC-Transaction 通过 Dubbo 隐式传参的功能，避免自己对业务代码的入侵。


### 7、Dubbo 支持哪些序列化方式？

默认使用 Hessian 序列化，还有 Duddo、FastJson、Java 自带序列化。


### 8、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。


### 9、画一画服务注册与发现的流程图？

![](http://dubbo.apache.org/img/architecture.png#alt=)


### 10、dubbo 服务负载均衡策略？

**Random LoadBalance**

随机，按权重设置随机概率。在一个截面上碰撞的概率高，但调用量越大分布越均匀，而且按概率使用权重后也比较均匀，有利于动态调整提供者权重。(权重可以在 dubbo 管控台配置)

**RoundRobin LoadBalance**

轮循，按公约后的权重设置轮循比率。存在慢的提供者累积请求问题，比如：第二台机器很慢，但没挂，当请求调到第二台时就卡在那，久而久之，所有请求都卡在调到第二台上。

**LeastActive LoadBalance**

最少活跃调用数，相同活跃数的随机，活跃数指调用前后计数差。使慢的提供者收到更少请求，因为越慢的提供者的调用前后计数差会越大。

**ConsistentHash LoadBalance**

一致性 Hash，相同参数的请求总是发到同一提供者。当某一台提供者挂时，原本发往该提供者的请求，基于虚拟节点，平摊到其它提供者，不会引起剧烈变动。缺省只对第一个参数 Hash，如果要修改，请配置

```
<dubbo:parameter key="hash.arguments" value="0,1" />
```

缺省用 160 份虚拟节点，如果要修改，请配置

```
<dubbo:parameter key="hash.nodes" value="320" />
```


### 11、Dubbo 超时时间怎样设置？
### 12、dubbo 通信协议 dubbo 协议为什么不能传大包；
### 13、dubbo推荐用什么协议？
### 14、Dubbo 和 Dubbox 之间的区别？
### 15、Dubbo有哪几种集群容错方案，默认是哪种？
### 16、在使用过程中都遇到了些什么问题？ 如何解决的？
### 17、默认使用什么序列化框架，你知道的还有哪些？
### 18、服务调用超时问题怎么解决
### 19、Dubbo 的使用场景有哪些？
### 20、同一个服务多个注册的情况下可以直连某一个服务吗？
### 21、RPC使用了哪些关键技术，RMI
### 22、Dubbo 有哪些注册中心？
### 23、集群容错怎么做？
### 24、Dubbo 使用的是什么通信框架?
### 25、RPC使用了哪些关键技术，序列化和反序列化
### 26、RPC使用了哪些关键技术，protobuf-rpc-pro
### 27、Dubbo集群提供了哪些负载均衡策略？
### 28、Dubbo 如何优雅停机？
### 29、dubbo 通信协议 dubbo 协议为什么要消费者比提供者个数多？
### 30、Dubbo Monitor 实现原理？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
