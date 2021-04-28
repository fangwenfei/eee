# Dubbo最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、一般使用什么注册中心？还有别的选择吗？

推荐使用 Zookeeper 作为注册中心，还有 Redis、Multicast、Simple 注册中心，但不推荐。


### 2、Dubbo支持服务多协议吗？

Dubbo 允许配置多协议，在不同服务上支持不同协议或者同一服务上同时支持多种协议。


### 3、说说核心的配置有哪些？
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


### 4、RPC使用了哪些关键技术，从调用者的角度看：

服务的调用者启动的时候根据自己订阅的服务向服务注册中心查找服务提供者的地址等信息；

当服务调用者消费的服务上线或者下线的时候，注册中心会告知该服务的调用者；

服务调用者下线的时候，则取消订阅。


### 5、什么是RPC

RPC（Remote Procedure Call Protocol）远程过程调用协议，它是一种通过网络从远程计算机程序上请求服务，而不需要了解底层网络技术的协议。简言之，RPC使得程序能够像访问本地系统资源一样，去访问远端系统资源。比较关键的一些方面包括：通讯协议、序列化、资源（接口）描述、服务框架、性能、语言支持等。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/026/54/80_3.png#alt=80%5C_3.png)

简单的说，RPC就是从一台机器(客户端)上通过参数传递的方式调用另一台机器(服务器)上的一个函数或方法(可以统称为服务)并得到返回的结果。


### 6、Dubbo 的默认集群容错方案？

Failover Cluster


### 7、Dubbo 的架构设计

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


### 8、你还了解别的分布式框架吗？

别的还有spring的spring cloud，facebook的thrift，twitter的finagle等。


### 9、dubbo 和 dubbox 之间的区别？

dubbox 是当当网基于 dubbo 上做了一些扩展，如加了服务可 restful 调用，更新了开源组件等。推荐阅读：厉害了，Dubbo 正式毕业！建议看下它的发展史！


### 10、Dubbo telnet 命令能做什么？

dubbo服务发布之后，我们可以利用telnet命令进行调试、管理。

Dubbo2.0.5以上版本服务提供端口支持telnet命令

**连接服务**

telnet localhost 20880  //键入回车进入Dubbo命令模式。

**查看服务列表**

```
dubbo>ls
com.test.TestService
dubbo>ls com.test.TestService
create
delete
query
```

1. ls (list services and methods)
2. ls : 显示服务列表。
3. ls -l : 显示服务详细信息列表。
4. ls XxxService：显示服务的方法列表。
5. ls -l XxxService：显示服务的方法详细信息列表。


### 11、Dubbo 使用过程中都遇到了些什么问题？
### 12、dubbo是什么
### 13、Dubbo 默认采用注册中心？
### 14、服务调用超时会怎么样？
### 15、默认使用的是什么通信框架，还有别的选择吗?
### 16、默认使用什么序列化框架，你知道的还有哪些？
### 17、说说核心的配置有哪些？
### 18、Dubbo SPI 和 Java SPI 区别？
### 19、在使用过程中都遇到了些什么问题？
### 20、Dubbo的集群容错方案有哪些？
### 21、Dubbo 和 Spring Cloud 的关系？
### 22、Dubbo 集群的负载均衡有哪些策略?
### 23、RPC使用了哪些关键技术，NIO通信
### 24、Dubbo的集群容错方案有哪些？
### 25、Dubbo 能集成 SpringBoot 吗？
### 26、Dubbo服务之间的调用是阻塞的吗？
### 27、RPC使用了哪些关键技术，反序列化
### 28、说说核心的配置有哪些？
### 29、默认使用什么序列化框架，你知道的还有哪些？
### 30、Dubbo的管理控制台能做什么？
### 31、PRC架构组件




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
