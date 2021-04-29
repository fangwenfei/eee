# Dubbo最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Dubbo telnet 命令能做什么？

dubbo 服务发布之后，我们可以利用 telnet 命令进行调试、管理。Dubbo2.0.5 以上版本服务提供端口支持 telnet 命令


### 2、RPC使用了哪些关键技术，Thrift

是一种可伸缩的跨语言服务的软件框架。它拥有功能强大的代码生成引擎，无缝地支持C + +，C#，Java，Python和PHP和Ruby。thrift允许你定义一个描述文件，描述数据类型和服务接口。依据该文件，编译器方便地生成RPC客户端和服务器通信代码。

最初由facebook开发用做系统内个语言之间的RPC通信，2007年由facebook贡献到apache基金 ，现在是apache下的opensource之一 。支持多种语言之间的RPC方式的通信：php语言client可以构造一个对象，调用相应的服务方法来调用java语言的服务，跨越语言的C/S RPC调用。底层通讯基于SOCKET。


### 3、dubbo 通信协议 dubbo 协议为什么不能传大包；

因 dubbo 协议采用单一长连接，如果每次请求的数据包大小为 500KByte，假设网络为千兆网卡(1024Mbit=128MByte)，每条连接最大 7MByte(不同的环境可能不一样，供参考)，单个服务提供者的 TPS(每秒处理事务数)最大为：128MByte / 500KByte = 262。

单个消费者调用单个服务提供者的 TPS(每秒处理事务数)最大为：7MByte / 500KByte = 14。

如果能接受，可以考虑使用，否则网络将成为瓶颈。


### 4、RPC使用了哪些关键技术，建立通信

首先要解决通讯的问题：即A机器想要调用B机器，首先得建立起通信连接。

主要是通过在客户端和服务器之间建立TCP连接，远程过程调用的所有交换的数据都在这个连接里传输。连接可以是按需连接，调用结束后就断掉，也可以是长连接，多个远程过程调用共享同一个连接。

通常这个连接可以是按需连接（需要调用的时候就先建立连接，调用结束后就立马断掉），也可以是长连接（客户端和服务器建立起连接之后保持长期持有，不管此时有无数据包的发送，可以配合心跳检测机制定期检测建立的连接是否存活有效），多个远程过程调用共享同一个连接。


### 5、RPC使用了哪些关键技术，序列化和反序列化

在网络中，所有的数据都将会被转化为字节进行传送，所以为了能够使参数对象在网络中进行传输，需要对这些参数进行序列化和反序列化操作。

序列化：把对象转换为字节序列的过程称为对象的序列化，也就是编码的过程。反序列化：把字节序列恢复为对象的过程称为对象的反序列化，也就是解码的过程。 目前比较高效的开源序列化框架：如Kryo、FastJson和Protobuf等。

反序列化：把字节序列恢复为对象的过程称为对象的反序列化，也就是解码的过程。 目前比较高效的开源序列化框架：如Kryo、FastJson和Protobuf等。


### 6、Dubbo 超时设置有哪些方式？

**Dubbo 超时设置有两种方式：**

服务提供者端设置超时时间，在Dubbo的用户文档中，推荐如果能在服务端多配置就尽量多配置，因为服务提供者比消费者更清楚自己提供的服务特性。

服务消费者端设置超时时间，如果在消费者端设置了超时时间，以消费者端为主，即优先级更高。因为服务调用方设置超时时间控制性更灵活。如果消费方超时，服务端线程不会定制，会产生警告。


### 7、服务提供者能实现失效踢出是什么原理？

服务失效踢出基于zookeeper的临时节点原理。


### 8、Dubbo 支持分布式事务吗？

目前暂时不支持，可与通过 tcc-transaction框架实现

介绍：tcc-transaction是开源的TCC补偿性分布式事务框架

Git地址：[https://github.com/changmingxie/tcc-transaction](https://github.com/changmingxie/tcc-transaction)

TCC-Transaction 通过 Dubbo 隐式传参的功能，避免自己对业务代码的入侵。


### 9、Dubbo 是什么？

Dubbo 是一个分布式、高性能、透明化的 RPC 服务框架，提供服务自动注册、自动发现等高效服务治理方案， 可以和Spring 框架无缝集成


### 10、服务调用是阻塞的吗？

默认是阻塞的，可以异步调用，没有返回值的可以这么做。Dubbo 是基于 NIO 的非阻塞实现并行调用，客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，异步调用会返回一个 Future 对象。


### 11、说说核心的配置有哪些？
### 12、Dubbo 可以对结果进行缓存吗？
### 13、注册了多个同一样的服务，如果测试指定的某一个服务呢？
### 14、为什么要用 Dubbo？
### 15、如何解决服务调用链过长的问题？
### 16、Dubbo 类似的分布式框架还有哪些？
### 17、Dubbo集群提供了哪些负载均衡策略？
### 18、一般使用什么注册中心？还有别的选择吗？
### 19、dubbo 通信协议 dubbo 协议为什么要消费者比提供者个数多？
### 20、Dubbo 和 Spring Cloud 有什么哪些区别？
### 21、RPC使用了哪些关键技术，动态代理
### 22、Dubbo 在安全机制方面是如何解决的
### 23、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 24、Dubbo 和 Spring Cloud 的区别？
### 25、服务上线怎么兼容旧版本？
### 26、Dubbo有哪几种集群容错方案，默认是哪种？
### 27、Dubbo 和 Spring Cloud 的关系？
### 28、Dubbo telnet 命令能做什么？
### 29、Dubbo 如何优雅停机？
### 30、同一个服务多个注册的情况下可以直连某一个服务吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
