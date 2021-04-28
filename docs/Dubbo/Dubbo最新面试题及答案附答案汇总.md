# Dubbo最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Dubbo 和 Dubbox 之间的区别？

Dubbox 是继 Dubbo 停止维护后，当当网基于 Dubbo 做的一个扩展项目，如加了服务可 Restful 调用，更新了开源组件等。


### 2、Dubbo 是什么？

Dubbo 是一个分布式、高性能、透明化的 RPC 服务框架，提供服务自动注册、自动发现等高效服务治理方案， 可以和Spring 框架无缝集成


### 3、画一画服务注册与发现的流程图？

![](http://dubbo.apache.org/img/architecture.png#alt=)


### 4、RPC使用了哪些关键技术，Avro

出自Hadoop之父Doug Cutting, 在Thrift已经相当流行的情况下推出Avro的目标不仅是提供一套类似Thrift的通讯中间件,更是要建立一个新的，标准性的云计算的数据交换和存储的Protocol。支持HTTP，TCP两种协议。


### 5、Dubbo 用到哪些设计模式？

Dubbo 框架在初始化和通信过程中使用了多种设计模式，可灵活控制类加载、权限控制等功能。

**工厂模式**

Provider 在 export 服务时，会调用 ServiceConfig 的 export 方法。ServiceConfig中有个字段：

```
private static final Protocol protocol =
ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtensi
on();
```

**工厂模式**

Provider 在 export 服务时，会调用 ServiceConfig 的 export 方法。ServiceConfig中有个字段：

```
private static final Protocol protocol =
ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtensi
on();
```

Dubbo 里有很多这种代码。这也是一种工厂模式，只是实现类的获取采用了 JDKSPI 的机制。这么实现的优点是可扩展性强，想要扩展实现，只需要在 classpath下增加个文件就可以了，代码零侵入。另外，像上面的 Adaptive 实现，可以做到调用时动态决定调用哪个实现，但是由于这种实现采用了动态代理，会造成代码调试比较麻烦，需要分析出实际调用的实现类。

**装饰器模式**

Dubbo 在启动和调用阶段都大量使用了装饰器模式。以 Provider 提供的调用链为例，具体的调用链代码是在 ProtocolFilterWrapper 的 buildInvokerChain 完成的，具体是将注解中含有 group=provider 的 Filter 实现，按照 order 排序，最后的调用顺序是：

```
EchoFilter -> ClassLoaderFilter -> GenericFilter -> ContextFilter ->
ExecuteLimitFilter -> TraceFilter -> TimeoutFilter -> MonitorFilter ->
ExceptionFilter
```

更确切地说，这里是装饰器和责任链模式的混合使用。例如，EchoFilter 的作用是判断是否是回声测试请求，是的话直接返回内容，这是一种责任链的体现。而像ClassLoaderFilter 则只是在主功能上添加了功能，更改当前线程的 ClassLoader，这是典型的装饰器模式。

**观察者模式**

Dubbo 的 Provider 启动时，需要与注册中心交互，先注册自己的服务，再订阅自己的服务，订阅时，采用了观察者模式，开启一个 listener。注册中心会每 5 秒定时检查是否有服务更新，如果有更新，向该服务的提供者发送一个 notify 消息，provider 接受到 notify 消息后，运行 NotifyListener 的 notify 方法，执行监听器方法。

**动态代理模式**

Dubbo 扩展 JDK SPI 的类 ExtensionLoader 的 Adaptive 实现是典型的动态代理实现。Dubbo 需要灵活地控制实现类，即在调用阶段动态地根据参数决定调用哪个实现类，所以采用先生成代理类的方法，能够做到灵活的调用。生成代理类的代码是 ExtensionLoader 的 createAdaptiveExtensionClassCode 方法。代理类主要逻辑是，获取 URL 参数中指定参数的值作为获取实现类的 key。


### 6、PRC架构组件

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


### 7、Dubbo 服务器注册与发现的流程？

**1、** Provider（提供者）绑定指定端口并启动服务。

**2、** 提供者连接注册中心，并发本机 IP、端口、应用信息和提供服务信息发送至注册中心存储。

**3、** Consumer（消费者），连接注册中心 ，并发送应用信息、所求服务信息至注册中心。

**4、** 注册中心根据消费者所求服务信息匹配对应的提供者列表发送至 Consumer 应用缓存。

**5、** Consumer 在发起远程调用时基于缓存的消费者列表择其一发起调用。

**6、** Provider 状态变更会实时通知注册中心、在由注册中心实时推送至 Consumer。


### 8、服务上线怎么不影响旧版本？

采用多版本开发，不影响旧版本。在配置中添加version来作为版本区分


### 9、Dubbo Monitor 实现原理？

Consumer端在发起调用之前会先走filter链；provider端在接收到请求时也是先走filter链，然后才进行真正的业务逻辑处理。

默认情况下，在consumer和provider的filter链中都会有Monitorfilter。

**1、** MonitorFilter向DubboMonitor发送数据

**2、** DubboMonitor将数据进行聚合后（默认聚合1min中的统计数据）暂存到ConcurrentMap<Statistics, AtomicReference> statisticsMap，然后使用一个含有3个线程（线程名字：DubboMonitorSendTimer）的线程池每隔1min钟，调用SimpleMonitorService遍历发送statisticsMap中的统计数据，每发送完毕一个，就重置当前的Statistics的AtomicReference

**3、** SimpleMonitorService将这些聚合数据塞入BlockingQueue queue中（队列大写为100000）

**4、** SimpleMonitorService使用一个后台线程（线程名为：DubboMonitorAsyncWriteLogThread）将queue中的数据写入文件（该线程以死循环的形式来写）

**5、** SimpleMonitorService还会使用一个含有1个线程（线程名字：DubboMonitorTimer）的线程池每隔5min钟，将文件中的统计数据画成图表


### 10、Dubbo支持服务多协议吗？

Dubbo 允许配置多协议，在不同服务上支持不同协议或者同一服务上同时支持多种协议。


### 11、RPC使用了哪些关键技术，反序列化
### 12、默认使用什么序列化框架，你知道的还有哪些？
### 13、默认使用什么序列化框架，你知道的还有哪些？
### 14、Dubbo中zookeeper做注册中心，如果注册中心集群都挂掉，者和订阅者之间还能通信么？
### 15、dubbo 连接注册中心和直连的区别
### 16、Dubbo 在安全机制方面是如何解决？
### 17、Dubbo 推荐什么协议？
### 18、Dubbo 使用的是什么通信框架?
### 19、一般使用什么注册中心？还有别的选择吗？
### 20、为什么需要服务治理？
### 21、在使用过程中都遇到了些什么问题？
### 22、RPC使用了哪些关键技术，Thrift
### 23、Dubbo 配置文件是如何加载到Spring中的？
### 24、RPC使用了哪些关键技术，Dubbo
### 25、Dubbo 可以对结果进行缓存吗？
### 26、Dubbo 服务注册与发现的流程？
### 27、你还了解别的分布式框架吗？
### 28、Dubbo 支持服务降级吗？
### 29、Dubbo 使用的是什么通信框架?
### 30、Dubbo 有哪些注册中心？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
