# Dubbo最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Dubbo 服务器注册与发现的流程？

**1、** 服务容器Container负责启动，加载，运行服务提供者。

**2、** 服务提供者Provider在启动时，向注册中心注册自己提供的服务。

**3、** 服务消费者Consumer在启动时，向注册中心订阅自己所需的服务。

**4、** 注册中心Registry返回服务提供者地址列表给消费者，如果有变更，注册中心将基于长连接推送变更数据给消费者。

**5、** 服务消费者Consumer，从提供者地址列表中，基于软负载均衡算法，选一台提供者进行调用，如果调用失败，再选另一台调用。

**6、** 服务消费者Consumer和提供者Provider，在内存中累计调用次数和调用时间，定时每分钟发送一次统计数据到监控中心Monitor。


### 2、Dubbo 的使用场景有哪些？

**1、** 透明化的远程方法调用：就像调用本地方法一样调用远程方法，只需简单配置，没有任何API侵入。

**2、** 软负载均衡及容错机制：可在内网替代 F5 等硬件负载均衡器，降低成本，减少单点。

**3、** 服务自动注册与发现：不再需要写死服务提供方地址，注册中心基于接口名查询服务提供者的IP地址，并且能够平滑添加或删除服务提供者。


### 3、在使用过程中都遇到了些什么问题？ 如何解决的？

**同时配置了 XML 和 properties 文件，则 properties 中的配置无效**

只有 XML 没有配置时，properties 才生效。

**dubbo 缺省会在启动时检查依赖是否可用，不可用就抛出异常，阻止 spring 初始化完成，check 属性默认为 true。**

测试时有些服务不关心或者出现了循环依赖，将 check 设置为 false

**为了方便开发测试，线下有一个所有服务可用的注册中心，这时，如果有一个正在开发中的服务提供者注册，可能会影响消费者不能正常运行。**

解决：让服务提供者开发方，只订阅服务，而不注册正在开发的服务，通过直连测试正在开发的服务。设置 dubbo:registry 标签的 register 属性为 false。

**spring 2.x 初始化死锁问题。**

在 spring 解析到 dubbo:service 时，就已经向外暴露了服务，而 spring 还在接着初始化其他 bean，如果这时有请求进来，并且服务的实现类里有调用 applicationContext.getBean() 的用法。getBean 线程和 spring 初始化线程的锁的顺序不一样，导致了线程死锁，不能提供服务，启动不了。

解决：不要在服务的实现类中使用 applicationContext.getBean(); 如果不想依赖配置顺序，可以将 dubbo:provider 的 deplay 属性设置为 - 1，使 dubbo 在容器初始化完成后再暴露服务。

**服务注册不上**

检查 dubbo 的 jar 包有没有在 classpath 中，以及有没有重复的 jar 包

检查暴露服务的 spring 配置有没有加载

在服务提供者机器上测试与注册中心的网络是否通

**出现 RpcException: No provider available for remote service 异常**

表示没有可用的服务提供者，

a、检查连接的注册中心是否正确

b、到注册中心查看相应的服务提供者是否存在

c、检查服务提供者是否正常运行

**出现” 消息发送失败” 异常**

通常是接口方法的传入传出参数未实现 Serializable 接口。


### 4、Dubbo 的整体架构设计有哪些分层?

**接口服务层（Service）**：该层与业务逻辑相关，根据 provider 和 consumer 的业务设计对应的接口和实现

**配置层（Config）**：对外配置接口，以 ServiceConfig 和 ReferenceConfig 为中心

**服务代理层（Proxy）**：服务接口透明代理，生成服务的客户端 Stub 和 服务端的 Skeleton，以 ServiceProxy 为中心，扩展接口为 ProxyFactory

**服务注册层（Registry）**：封装服务地址的注册和发现，以服务 URL 为中心，扩展接口为 RegistryFactory、Registry、RegistryService

**路由层（Cluster）**：封装多个提供者的路由和负载均衡，并桥接注册中心，以Invoker 为中心，扩展接口为 Cluster、Directory、Router和LoadBlancce

**监控层（Monitor）**：RPC调用次数和调用时间监控，以 Statistics 为中心，扩展接口为 MonitorFactory、Monitor和MonitorService

**远程调用层（Protocal）**：封装 RPC 调用，以 Invocation 和 Result 为中心，扩展接口为 Protocal、Invoker和Exporter

**信息交换层（Exchange**）：封装请求响应模式，同步转异步。以 Request 和 Response 为中心，扩展接口为 Exchanger、ExchangeChannel、ExchangeClient和ExchangeServer

**网络传输层（Transport）**：抽象 mina 和 netty 为统一接口，以 Message 为中心，扩展接口为Channel、Transporter、Client、Server和Codec

**数据序列化层（Serialize）**：可复用的一些工具，扩展接口为Serialization、 ObjectInput、ObjectOutput和ThreadPool


### 5、服务上线怎么不影响旧版本？

采用多版本开发，不影响旧版本。


### 6、服务上线怎么不影响旧版本？

采用多版本开发，不影响旧版本。在配置中添加version来作为版本区分


### 7、RPC使用了哪些关键技术，RMI

利用java.rmi包实现，基于Java远程方法协议(Java Remote Method Protocol) 和java的原生序列化。


### 8、RPC使用了哪些关键技术，Hessian

是一个轻量级的remoting onhttp工具，使用简单的方法提供了RMI的功能。 基于HTTP协议，采用二进制编解码。


### 9、dubbo 服务负载均衡策略？

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


### 10、Dubbo 和 Spring Cloud 有什么哪些区别？

Dubbo 底层是使用 Netty 这样的 NIO 框架，是基于 TCP 协议传输的，配合以 Hession 序列化完成 RPC 通信。

Spring Cloud 是基于 Http 协议 Rest 接口调用远程过程的通信，相对来说 Http 请求会有更大的报文，占的带宽也会更多。但是 REST 相比 RPC 更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更为合适，至于注重通信速度还是方便灵活性，具体情况具体考虑。


### 11、Dubbo 服务器注册与发现的流程？
### 12、Dubbo 的整体架构设计有哪些分层?
### 13、一般使用什么注册中心？还有别的选择吗？
### 14、Dubbo 的注册中心集群挂掉，者和订阅者之间还能通信么？
### 15、Dubbo 的注册中心集群挂掉，发布者和订阅者之间还能通信么？
### 16、服务提供者能实现失效踢出是什么原理？
### 17、Dubbo 集群容错有几种方案？
### 18、Dubbo 和 Dubbox 之间的区别？
### 19、Dubbo 和 Dubbox 之间的区别？
### 20、RPC使用了哪些关键技术，服务寻址
### 21、Dubbo 支持哪些序列化方式？
### 22、集群容错怎么做？
### 23、Dubbo服务降级，失败重试怎么做？
### 24、RPC使用了哪些关键技术，从调用者的角度看：
### 25、dubbo 在安全机制方面如何解决的？
### 26、RPC使用了哪些关键技术，序列化
### 27、RPC使用了哪些关键技术，从服务提供者的角度看：
### 28、Dubbo 超时时间怎样设置？
### 29、你还了解别的分布式框架吗？
### 30、Dubbo的集群容错方案有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
