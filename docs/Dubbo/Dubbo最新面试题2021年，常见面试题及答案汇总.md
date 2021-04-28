# Dubbo最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、dubbo推荐用什么协议？

默认使用dubbo协议。


### 2、RPC使用了哪些关键技术，服务调用

B机器进行本地调用（通过代理Proxy和反射调用）之后得到了返回值，此时还需要再把返回值发送回A机器，同样也需要经过序列化操作，然后再经过网络传输将二进制数据发送回A机器，而当A机器接收到这些返回值之后，则再次进行反序列化操作，恢复为内存中的表达方式，最后再交给A机器上的应用进行相关处理（一般是业务逻辑处理操作）。

通常，经过以上四个步骤之后，一次完整的RPC调用算是完成了，另外可能因为网络抖动等原因需要重试等。

### 3、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。


### 4、Dubbo 的主要应用场景？

**1、** 透明化的远程方法调用，就像调用本地方法一样调用远程方法，只需简单配置，没有任何 API 侵入。

**2、** 软负载均衡及容错机制，可在内网替代 F5 等硬件负载均衡器，降低成本，减少单点。

**3、** 服务自动注册与发现，不再需要写死服务提供方地址，注册中心基于接口名查询服务提供者的 IP 地址，并且能够平滑添加或删除服务提供者。

Dubbo 的主要应用场景？

Dubbo 的核心功能？

**主要就是如下 3 个核心功能：**

**1、** Remoting：网络通信框架，提供对多种 NIO 框架抽象封装，包括“同步转异步”和“请求-响应”模式的信息交换方式。

**2、** Cluster：服务框架，提供基于接口方法的透明远程过程调用，包括多协议支持，以及软负载均衡，失败容错，地址路由，动态配置等集群支持。

**3、** Registry：服务注册，基于注册中心目录服务，使服务消费方能动态的查找服务提供方，使地址透明，使服务提供方可以平滑增加或减少机器。


### 5、服务读写推荐的容错策略是怎样的？

读操作建议使用 Failover 失败自动切换，默认重试两次其他服务器。写操作建议使用 Failfast 快速失败，发一次调用失败就立即报错。


### 6、Dubbo 用到哪些设计模式？

Dubbo框架在初始化和通信过程中使用了多种设计模式，可灵活控制类加载、权限控制等功能。

**工厂模式**

Provider在export服务时，会调用ServiceConfig的export方法。ServiceConfig中有个字段：

```java
private static final Protocol protocol = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
```

Dubbo里有很多这种代码。这也是一种工厂模式，只是实现类的获取采用了JDK SPI的机制。这么实现的优点是可扩展性强，想要扩展实现，只需要在classpath下增加个文件就可以了，代码零侵入。另外，像上面的Adaptive实现，可以做到调用时动态决定调用哪个实现，但是由于这种实现采用了动态代理，会造成代码调试比较麻烦，需要分析出实际调用的实现类。

**装饰器模式**

Dubbo在启动和调用阶段都大量使用了装饰器模式。以Provider提供的调用链为例，具体的调用链代码是在ProtocolFilterWrapper的buildInvokerChain完成的，具体是将注解中含有group=provider的Filter实现，按照order排序，最后的调用顺序是：

```java
EchoFilter -> ClassLoaderFilter -> GenericFilter -> ContextFilter -> ExecuteLimitFilter -> TraceFilter -> TimeoutFilter -> MonitorFilter -> ExceptionFilter
```

更确切地说，这里是装饰器和责任链模式的混合使用。例如，EchoFilter的作用是判断是否是回声测试请求，是的话直接返回内容，这是一种责任链的体现。而像ClassLoaderFilter则只是在主功能上添加了功能，更改当前线程的ClassLoader，这是典型的装饰器模式。

**观察者模式**

Dubbo的Provider启动时，需要与注册中心交互，先注册自己的服务，再订阅自己的服务，订阅时，采用了观察者模式，开启一个listener。注册中心会每5秒定时检查是否有服务更新，如果有更新，向该服务的提供者发送一个notify消息，provider接受到notify消息后，即运行NotifyListener的notify方法，执行监听器方法。

**动态代理模式**

Dubbo扩展JDK SPI的类ExtensionLoader的Adaptive实现是典型的动态代理实现。Dubbo需要灵活地控制实现类，即在调用阶段动态地根据参数决定调用哪个实现类，所以采用先生成代理类的方法，能够做到灵活的调用。生成代理类的代码是ExtensionLoader的createAdaptiveExtensionClassCode方法。代理类的主要逻辑是，获取URL参数中指定参数的值作为获取实现类的key。


### 7、默认使用的是什么通信框架，还有别的选择吗?

默认也推荐使用netty框架，还有mina。


### 8、Dubbo SPI 和 Java SPI 区别？

**JDK SPI**

JDK 标准的 SPI 会一次性加载所有的扩展实现，如果有的扩展吃实话很耗时，但也没用上，很浪费资源。

所以只希望加载某个的实现，就不现实了

**DUBBO SPI**

1，对Dubbo进行扩展，不需要改动Dubbo的源码

2，延迟加载，可以一次只加载自己想要加载的扩展实现。

3，增加了对扩展点 IOC 和 AOP 的支持，一个扩展点可以直接 setter 注入其它扩展点。

3，Dubbo的扩展机制能很好的支持第三方IoC容器，默认支持Spring Bean。


### 9、RPC框架需要解决的问题？

**1、** 如何确定客户端和服务端之间的通信协议？

**2、** 如何更高效地进行网络通信？

**3、** 服务端提供的服务如何暴露给客户端？

**4、** 客户端如何发现这些暴露的服务？

**5、** 如何更高效地对请求对象和响应结果进行序列化和反序列化操作？


### 10、服务提供者能实现失效踢出是什么原理？

服务失效踢出基于 zookeeper 的临时节点原理。


### 11、Dubbo 集群容错有几种方案？
### 12、说说 Dubbo 服务暴露的过程。
### 13、Dubbo 类似的分布式框架还有哪些？
### 14、服务调用超时问题怎么解决？
### 15、Dubbo 核心组件有哪些？
### 16、服务调用是阻塞的吗？
### 17、Dubbo 的集群容错方案有哪些？
### 18、一般使用什么注册中心？还有别的选择吗？
### 19、RPC使用了哪些关键技术，从服务提供者的角度看：
### 20、同一个服务多个注册的情况下可以直连某一个服务吗？
### 21、RPC使用了哪些关键技术，从调用者的角度看：
### 22、dubbo 通信协议 dubbo 协议为什么要消费者比提供者个数多？
### 23、Dubbo 支持分布式事务吗？
### 24、Dubbo集群提供了哪些负载均衡策略？
### 25、为什么需要服务治理？
### 26、Dubbo 有哪些注册中心？
### 27、Dubbo 服务降级，失败重试怎么做？
### 28、画一画服务注册与发现的流程图？
### 29、Dubbo 服务降级，失败重试怎么做？
### 30、Dubbo 和 Spring Cloud 有什么哪些区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
