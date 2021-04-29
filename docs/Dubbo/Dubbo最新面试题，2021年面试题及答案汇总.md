# Dubbo最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、RPC使用了哪些关键技术，动态代理

生成Client Stub（客户端存根）和Server Stub（服务端存根）的时候需要用到Java动态代理技术，可以使用JDK提供的原生的动态代理机制，也可以使用开源的：CGLib代理，Javassist字节码生成技术。


### 2、注册了多个同一样的服务，如果测试指定的某一个服务呢？

可以配置环境点对点直连，绕过注册中心，将以服务接口为单位，忽略注册中心的提供者列表。


### 3、Dubbo可以对结果进行缓存吗？

可以，Dubbo 提供了声明式缓存，用于加速热门数据的访问速度，以减少用户加缓存的工作量


### 4、Dubbo telnet 命令能做什么？

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


### 5、Dubbo服务之间的调用是阻塞的吗？

默认是同步等待结果阻塞的，支持异步调用，Dubbo 是基于 NIO 的非阻塞实现并行调用，客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，异步调用会返回一个 Future 对象。


### 6、Dubbo 在安全方面有哪些措施？

Dubbo 通过 Token 令牌防止用户绕过注册中心直连，然后在注册中心上管理授权。

Dubbo 还提供服务黑白名单，来控制服务所允许的调用方。


### 7、默认使用的是什么通信框架，还有别的选择吗?

默认也推荐使用 netty 框架，还有 mina。


### 8、Dubbo有哪几种负载均衡策略，默认是哪种？
### 9、RPC和SOA、SOAP、REST的区别
### 10、Dubbo 能集成 SpringBoot 吗？
### 11、服务调用超时问题怎么解决？
### 12、Dubbo服务降级，失败重试怎么做？
### 13、服务提供者能实现失效踢出是什么原理？
### 14、dubbo 通信协议 dubbo 协议为什么要消费者比提供者个数多？
### 15、Dubbo SPI 和 Java SPI 区别？
### 16、RPC使用了哪些关键技术，Thrift
### 17、集群容错怎么做？
### 18、什么是RPC
### 19、RPC使用了哪些关键技术，RPC的实现原理架构图
### 20、Dubbo 的集群容错方案有哪些？
### 21、RPC使用了哪些关键技术，从调用者的角度看：
### 22、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 23、Dubbo 配置文件是如何加载到Spring中的？
### 24、Dubbo 使用过程中都遇到了些什么问题？
### 25、dubbo是什么
### 26、Dubbo 的整体架构设计有哪些分层?
### 27、一般使用什么注册中心？还有别的选择吗？
### 28、Dubbo 有哪些注册中心？
### 29、Dubbo 集群提供了哪些负载均衡策略？
### 30、Dubbo 的架构设计




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
