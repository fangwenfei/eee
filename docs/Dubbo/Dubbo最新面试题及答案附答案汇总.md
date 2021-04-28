# Dubbo最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、RPC使用了哪些关键技术，服务调用

B机器进行本地调用（通过代理Proxy和反射调用）之后得到了返回值，此时还需要再把返回值发送回A机器，同样也需要经过序列化操作，然后再经过网络传输将二进制数据发送回A机器，而当A机器接收到这些返回值之后，则再次进行反序列化操作，恢复为内存中的表达方式，最后再交给A机器上的应用进行相关处理（一般是业务逻辑处理操作）。

通常，经过以上四个步骤之后，一次完整的RPC调用算是完成了，另外可能因为网络抖动等原因需要重试等。

### 2、RPC使用了哪些关键技术，RPC的实现原理架构图

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/026/54/80_5.png#alt=80%5C_5.png)

也就是说两台服务器A，B，一个应用部署在A服务器上，想要调用B服务器上应用提供的函数/方法，由于不在一个内存空间，不能直接调用，需要通过网络来表达调用的语义和传达调用的数据。

比如说，A服务器想调用B服务器上的一个方法：


### 3、注册了多个同一样的服务，如果测试指定的某一个服务呢？

可以配置环境点对点直连，绕过注册中心，将以服务接口为单位，忽略注册中心的提供者列表。


### 4、RPC使用了哪些关键技术，Thrift

是一种可伸缩的跨语言服务的软件框架。它拥有功能强大的代码生成引擎，无缝地支持C + +，C#，Java，Python和PHP和Ruby。thrift允许你定义一个描述文件，描述数据类型和服务接口。依据该文件，编译器方便地生成RPC客户端和服务器通信代码。

最初由facebook开发用做系统内个语言之间的RPC通信，2007年由facebook贡献到apache基金 ，现在是apache下的opensource之一 。支持多种语言之间的RPC方式的通信：php语言client可以构造一个对象，调用相应的服务方法来调用java语言的服务，跨越语言的C/S RPC调用。底层通讯基于SOCKET。


### 5、默认使用什么序列化框架，你知道的还有哪些？

默认使用Hessian序列化，还有Duddo、FastJson、Java自带序列化。


### 6、服务上线怎么兼容旧版本？

可以用版本号（version）过渡，多个不同版本的服务注册到注册中心，版本号不同的服务相互间不引用。这个和服务分组的概念有一点类似。


### 7、RPC框架需要解决的问题？

**1、** 如何确定客户端和服务端之间的通信协议？

**2、** 如何更高效地进行网络通信？

**3、** 服务端提供的服务如何暴露给客户端？

**4、** 客户端如何发现这些暴露的服务？

**5、** 如何更高效地对请求对象和响应结果进行序列化和反序列化操作？


### 8、RPC和SOA、SOAP、REST的区别

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


### 9、Dubbo 配置文件是如何加载到Spring中的？

Spring容器在启动的时候，会读取到Spring默认的一些schema以及Dubbo自定义的schema，每个schema都会对应一个自己的NamespaceHandler，NamespaceHandler里面通过BeanDefinitionParser来解析配置信息并转化为需要加载的bean对象！


### 10、默认使用的是什么通信框架，还有别的选择吗?

默认也推荐使用netty框架，还有mina。


### 11、一般使用什么注册中心？还有别的选择吗？
### 12、RPC使用了哪些关键技术，Hessian
### 13、服务提供者能实现失效踢出是什么原理？
### 14、Dubbo telnet 命令能做什么？
### 15、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？
### 16、Dubbo集群提供了哪些负载均衡策略？
### 17、如何解决服务调用链过长的问题？
### 18、Dubbo 的注册中心集群挂掉，者和订阅者之间还能通信么？
### 19、RPC的实现基础？
### 20、Dubbo 和 Spring Cloud 有什么哪些区别？
### 21、说说 Dubbo 服务暴露的过程。
### 22、Dubbo 在安全机制方面是如何解决？
### 23、RPC使用了哪些关键技术，建立通信
### 24、如何解决服务调用链过长的问题？
### 25、dubbo 连接注册中心和直连的区别
### 26、Dubbo 可以对结果进行缓存吗？
### 27、Dubbo 支持服务降级吗？
### 28、你还了解别的分布式框架吗？
### 29、同一个服务多个注册的情况下可以直连某一个服务吗？
### 30、当一个服务接口有多种实现时怎么做？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
