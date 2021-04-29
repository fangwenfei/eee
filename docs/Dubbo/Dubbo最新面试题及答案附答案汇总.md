# Dubbo最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说说核心的配置有哪些？
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



### 2、服务上线怎么不影响旧版本？

采用多版本开发，不影响旧版本。在配置中添加version来作为版本区分


### 3、Dubbo 超时时间怎样设置？

Dubbo 超时时间设置有两种方式：

服务提供者端设置超时时间，在 Dubbo 的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 4、PRC架构组件

一个基本的RPC架构里面应该至少包含以下4个组件：

**1、** 客户端（Client）:服务调用方（服务消费者）

**2、** 客户端存根（Client Stub）:存放服务端地址信息，将客户端的请求参数数据信息打包成网络消息，再通过网络传输发送给服务端

**3、** 服务端存根（Server Stub）:接收客户端发送过来的请求消息并进行解包，然后再调用本地服务进行处理4、服务端（Server）:服务的真正提供者

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/026/54/80_4.png#alt=80%5C_4.png)

- 具体调用过程：

**1、** 服务消费者（client客户端）通过调用本地服务的方式调用需要消费的服务；

**2、** 客户端存根（client stub）接收到调用请求后负责将方法、入参等信息序列化（组装）成能够进行网络传输的消息体；

**3、** 客户端存根（client stub）找到远程的服务地址，并且将消息通过网络发送给服务端；

**4、** 服务端存根（server stub）收到消息后进行解码（反序列化操作）；

**5、** 服务端存根（server stub）根据解码结果调用本地的服务进行相关处理；

**6、** 本地服务执行具体业务逻辑并将处理结果返回给服务端存根（server stub）；

**7、** 服务端存根（server stub）将返回结果重新打包成消息（序列化）并通过网络发送至消费方；

**8、** 客户端存根（client stub）接收到消息，并进行解码（反序列化）；

**9、** 服务消费方得到最终结果；

`而RPC框架的实现目标则是将上面的第2-10步完好地封装起来，也就是把调用、编码/解码的过程给封装起来，让用户感觉上像调用本地服务一样的调用远程服务。`


### 5、Dubbo 是什么？

Dubbo 是一款高性能、轻量级的开源 RPC 框架，提供服务自动注册、自动发现等高效服务治理方案， 可以和 Spring 框架无缝集成。


### 6、RPC使用了哪些关键技术，反序列化

当B机器接收到A机器的应用发来的请求之后，又需要对接收到的参数等信息进行反序列化操作（序列化的逆操作），即将二进制信息恢复为内存中的表达方式，然后再找到对应的方法（寻址的一部分）进行本地调用（一般是通过生成代理Proxy去调用, 通常会有JDK动态代理、CGLIB动态代理、Javassist生成字节码技术等），之后得到调用的返回值。


### 7、dubbo 服务集群配置（集群容错模式）

在集群调用失败时， Dubbo 提供了多种容错方案，缺省为 failover 重试。可以自行扩展集群容错策略

l Failover Cluster(默认)

失败自动切换，当出现失败，重试其它服务器。(缺省)通常用于读操作，

但重试会带来更长延迟。可通过 retries="2"来设置重试次数(不含第一次)。

```
<dubbo:service retries="2" cluster="failover"/>或：<dubbo:reference retries="2" cluster="failover"/>cluster="failover"可以不用写,因为默认就是 failover
```

**Failfast Cluster**

快速失败，只发起一次调用，失败立即报错。通常用于非幂等性的写操作，

比如新增记录。

```
dubbo:service cluster="failfast" />
```

或：

```
<dubbo:reference cluster="failfast" />

cluster="failfast"和 把 cluster="failover"、 retries="0"是一样的效果,retries="0"就是不重
```

Failsafe Cluster失败安全，出现异常时，直接忽略。通常用于写入审计日志等操作。

```
<dubbo:service cluster="failsafe" />
```

或：

```
<dubbo:reference cluster="failsafe" />
```

**Failback Cluster**

失败自动恢复，后台记录失败请求，定时重发。通常用于消息通知操作。

```
<dubbo:service cluster="failback" />
```

或：

```
<dubbo:reference cluster="failback" />
```

Forking Cluster并行调用多个服务器，只要一个成功即返回。通常用于实时性要求较高的读

操作，但需要浪费更多服务资源。可通过 forks="2"来设置最大并行数。

```
<dubbo:service cluster=“forking" forks="2"/>
```

或：

```
<dubbo:reference cluster=“forking" forks="2"/>
```


### 8、RPC使用了哪些关键技术，动态代理

生成Client Stub（客户端存根）和Server Stub（服务端存根）的时候需要用到Java动态代理技术，可以使用JDK提供的原生的动态代理机制，也可以使用开源的：CGLib代理，Javassist字节码生成技术。


### 9、说说核心的配置有哪些？
| 标签 | 用途 | 解释 |
| --- | --- | --- |
| [dubbo:service/]() | 服务配置 | 用于暴露一个服务，定义服务的元信息，一个服务可以用多个协议暴露，一个服务也可以注册到多个注册中心 |
| [dubbo:reference/]() | 引用配置 | 用于创建一个远程服务代理，一个引用可以指向多个注册中心 |
| [dubbo:protocol/]() | 协议配置 | 用于配置提供服务的协议信息，协议由提供方指定，消费方被动接受 |
| [dubbo:application/]() | 应用配置 | 用于配置当前应用信息，不管该应用是提供者还是消费者 |
| [dubbo:module/]() | 模块配置 | 用于配置当前模块信息，可选 |
| [dubbo:registry/]() | 注册中心配置 | 用于配置连接注册中心相关信息 |
| [dubbo:monitor/]() | 监控中心配置 | 用于配置连接监控中心相关信息，可选 |
| [dubbo:provider/]() | 提供方配置 | 当 ProtocolConfig 和 ServiceConfig 某属性没有配置时，采用此缺省值，可选 |
| [dubbo:consumer/]() | 消费方配置 | 当 ReferenceConfig 某属性没有配置时，采用此缺省值，可选 |
| [dubbo:method/]() | 方法配置 | 用于 ServiceConfig 和 ReferenceConfig 指定方法级的配置信息 |
| [dubbo:argument]() | 参数配置 | 用于指定方法参数配置 |


`如果是SpringBoot项目就只需要注解，或者开Application配置文件！！！`


### 10、Dubbo 默认采用注册中心？

采用 Zookeeper


### 11、RPC框架需要解决的问题？
### 12、服务调用超时会怎么样？
### 13、Dubbo 服务器注册与发现的流程？
### 14、RPC使用了哪些关键技术，protobuf-rpc-pro
### 15、Dubbo有哪几种负载均衡策略，默认是哪种？
### 16、Dubbo中zookeeper做注册中心，如果注册中心集群都挂掉，者和订阅者之间还能通信么？
### 17、服务调用超时问题怎么解决
### 18、Dubbo 支持服务降级吗？
### 19、服务上线怎么不影响旧版本？
### 20、Dubbo 核心组件有哪些？
### 21、Dubbo 的整体架构设计有哪些分层?
### 22、Dubbo有哪几种集群容错方案，默认是哪种？
### 23、你还了解别的分布式框架吗？
### 24、RPC使用了哪些关键技术，NIO通信
### 25、默认使用什么序列化框架，你知道的还有哪些？
### 26、同一个服务多个注册的情况下可以直连某一个服务吗？
### 27、默认使用什么序列化框架，你知道的还有哪些？
### 28、Dubbo服务之间的调用是阻塞的吗？
### 29、RPC使用了哪些关键技术，Hessian
### 30、Dubbo 用到哪些设计模式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
