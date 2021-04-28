# Dubbo最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、RPC和SOA、SOAP、REST的区别

**REST**

可以看着是HTTP协议的一种直接应用，默认基于JSON作为传输格式,使用简单,学习成本低效率高,但是安全性较低。

**SOAP**

SOAP是一种数据交换协议规范,是一种轻量的、简单的、基于XML的协议的规范。而SOAP可以看着是一个重量级的协议，基于XML、SOAP在安全方面是通过使用XML-Security和XML-Signature两个规范组成了WS-Security来实现安全控制的,当前已经得到了各个厂商的支持 。

**它有什么优点？简单总结为：易用、灵活、跨语言、跨平台。**

**SOA**

面向服务架构，它可以根据需求通过网络对松散耦合的粗粒度应用组件进行分布式部署、组合和使用。服务层是SOA的基础，可以直接被应用调用，从而有效控制系统中与软件代理交互的人为依赖性。

SOA是一种粗粒度、松耦合服务架构，服务之间通过简单、精确定义接口进行通讯，不涉及底层编程接口和通讯模型。SOA可以看作是B/S模型、XML（标准通用标记语言的子集）/Web Service技术之后的自然延伸。

**REST 和 SOAP、RPC 有何区别呢?**

没什么太大区别，他们的本质都是提供可支持分布式的基础服务，最大的区别在于他们各自的的特点所带来的不同应用场景


### 2、RPC使用了哪些关键技术，主流RPC框架有哪些


### 3、Dubbo支持服务多协议吗？

Dubbo 允许配置多协议，在不同服务上支持不同协议或者同一服务上同时支持多种协议。


### 4、Dubbo 集群提供了哪些负载均衡策略？

**1、** Random LoadBalance: 随机选取提供者策略，有利于动态调整提供者权重。截面碰撞率高，调用次数越多，分布越均匀；

**2、** RoundRobin LoadBalance: 轮循选取提供者策略，平均分布，但是存在请求累积的问题；

**3、** LeastActive LoadBalance: 最少活跃调用策略，解决慢提供者接收更少的请求；

**4、** ConstantHash LoadBalance: 一致性 Hash 策略，使相同参数请求总是发到同一提供者，一台机器宕机，可以基于虚拟节点，分摊至其他提供者，避免引起提供者的剧烈变动；

**5、** 缺省时为 Random 随机调用


### 5、默认使用什么序列化框架，你知道的还有哪些？

默认使用 Hessian 序列化，还有 Duddo、FastJson、Java 自带序列化。 hessian是一个采用二进制格式传输的服务框架，相对传统soap web service，更轻量，更快速。

**Hessian原理与协议简析：**

http的协议约定了数据传输的方式，hessian也无法改变太多：

**1、** hessian中client与server的交互，基于http-post方式。

**2、** hessian将辅助信息，封装在http header中，比如“授权token”等，我们可以基于http-header来封装关于“安全校验”“meta数据”等。hessian提供了简单的”校验”机制。

**3、** 对于hessian的交互核心数据，比如“调用的方法”和参数列表信息，将通过post请求的body体直接发送，格式为字节流。

**4、** 对于hessian的server端响应数据，将在response中通过字节流的方式直接输出。

hessian的协议本身并不复杂，在此不再赘言；所谓协议(protocol)就是约束数据的格式，client按照协议将请求信息序列化成字节序列发送给server端，server端根据协议，将数据反序列化成“对象”，然后执行指定的方法，并将方法的返回值再次按照协议序列化成字节流，响应给client，client按照协议将字节流反序列话成”对象”。


### 6、RPC使用了哪些关键技术，反序列化

当B机器接收到A机器的应用发来的请求之后，又需要对接收到的参数等信息进行反序列化操作（序列化的逆操作），即将二进制信息恢复为内存中的表达方式，然后再找到对应的方法（寻址的一部分）进行本地调用（一般是通过生成代理Proxy去调用, 通常会有JDK动态代理、CGLIB动态代理、Javassist生成字节码技术等），之后得到调用的返回值。


### 7、Dubbo 核心组件有哪些？

**1、** Provider：暴露服务的服务提供方

**2、** Consumer：调用远程服务消费方

**3、** Registry：服务注册与发现注册中心

**4、** Monitor：监控中心和访问调用统计

**5、** Container：服务运行容器


### 8、dubbo 通信协议 dubbo 协议为什么采用异步单一长连接

因为服务的现状大都是服务提供者少，通常只有几台机器，而服务的消费者多，可能整个网站都在访问该服务，比如 Morgan 的提供者只有 6 台提供者，却有上百台消费者，每天有 1.5 亿次调用，如果采用常规的 hessian 服务，服务提供者很容易就被压跨，通过单一连接，保证单一消费者不会压死提供者，长连接，减少连接握手验证等，并使用异步 IO，复用线程池，防止 C10K 问题。


### 9、你还了解别的分布式框架吗？

别的还有spring的spring cloud，facebook的thrift，twitter的finagle等。


### 10、Dubbo有哪几种负载均衡策略，默认是哪种？

**1、** Random LoadBalance 随机。按权重设置随机概率(默认)

**2、** RoundRobin LoadBalance 轮训，按公约后的权重设置轮序比率

**3、** LeastActive LoadBalance 最少活跃调用数，相同活跃数的随机

**4、** ConsistentHash LoadBalance 一致性，相同参数的请求总是发到同意提供者


### 11、Dubbo 使用的是什么通信框架?
### 12、一般使用什么注册中心？还有别的选择吗？
### 13、在使用过程中都遇到了些什么问题？ 如何解决的？
### 14、RPC使用了哪些关键技术，动态代理
### 15、Dubbo 的整体架构设计有哪些分层?
### 16、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 17、Dubbo 必须依赖的包有哪些？
### 18、为什么要用 Dubbo？
### 19、Dubbo 有些哪些注册中心？
### 20、服务上线怎么兼容旧版本？
### 21、服务调用超时会怎么样？
### 22、Dubbo 有哪些注册中心？
### 23、RPC使用了哪些关键技术，服务寻址
### 24、Dubbo SPI 和 Java SPI 区别？
### 25、dubbo是什么
### 26、dubbo 服务集群配置（集群容错模式）
### 27、说说核心的配置有哪些？
### 28、Dubbo 的架构设计
### 29、Dubbo 和 Dubbox 之间的区别？
### 30、Dubbo 配置文件是如何加载到 Spring 中的？
### 31、同一个服务多个注册的情况下可以直连某一个服务吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
