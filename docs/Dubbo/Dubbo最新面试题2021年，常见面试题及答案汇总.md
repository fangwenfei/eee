# Dubbo最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、dubbo推荐用什么协议？

默认使用dubbo协议。


### 2、Dubbo 和 Spring Cloud 的关系？

Dubbo 是 SOA 时代的产物，它的关注点主要在于服务的调用，流量分发、流量监控和熔断。而 Spring Cloud 诞生于微服务架构时代，考虑的是微服务治理的方方面面，另外由于依托了 Spirng、Spirng Boot 的优势之上，两个框架在开始目标就不一致， Dubbo定位服务治理、 Spirng Cloud 是一个生态。


### 3、Dubbo 类似的分布式框架还有哪些？

比较著名的就是 Spring Cloud。


### 4、你还了解别的分布式框架吗？

别的还有 Spring cloud、Facebook 的 Thrift、Twitter 的 Finagle 等。


### 5、RPC使用了哪些关键技术，protobuf-rpc-pro

是一个Java类库，提供了基于 Google 的 Protocol Buffers 协议的远程方法调用的框架。基于 Netty 底层的 NIO 技术。支持 TCP 重用/ keep-alive、SSL加密、RPC 调用取消操作、嵌入式日志等功能。


### 6、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？

**1、** dubbo：单一长连接和 NIO 异步通讯，适合大并发小数据量的服务调用，以及消费者远大于提供者。传输协议 TCP，异步， Hessian 序列化；

**2、** rmi：采用 JDK 标准的 rmi 协议实现，传输参数和返回参数对象需要实现Serializable 接口，使用 java 标准序列化机制，使用阻塞式短连接，传输数据包大小混合，消费者和提供者个数差不多，可传文件，传输协议 TCP。多个短连接， TCP 协议传输，同步传输，适用常规的远程服务调用和 rmi 互操作。在依赖低版本的 Common-Collections 包， java 序列化存在安全漏洞；

**3、** http：基于 Http 表单提交的远程调用协议，使用 Spring 的 HttpInvoke 实现。多个短连接，传输协议 HTTP，传入参数大小混合，提供者个数多于消费者，需要给应用程序和浏览器 JS 调用；

**4、** webservice：基于 WebService 的远程调用协议，集成 CXF 实现，提供和原生 WebService 的互操作。多个短连接，基于 HTTP 传输，同步传输，适用系统集成和跨语言调用；

**5、** hessian：集成 Hessian 服务，基于 HTTP 通讯，采用 Servlet 暴露服务，Dubbo 内嵌 Jetty 作为服务器时默认实现，提供与 Hession 服务互操作。多个短连接，同步 HTTP 传输， Hessian 序列化，传入参数较大，提供者大于消费者，提供者压力较大，可传文件；

**6、** Redis：基于 Redis 实现的 RPC 协议


### 7、在使用过程中都遇到了些什么问题？ 如何解决的？

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


### 8、PRC架构组件
### 9、Dubbo 的主要应用场景？
### 10、RPC使用了哪些关键技术，建立通信
### 11、Dubbo 支持哪些协议，每种协议的应用场景，优缺点？
### 12、RPC使用了哪些关键技术，服务寻址
### 13、RPC使用了哪些关键技术，从服务提供者的角度看：
### 14、同一个服务多个注册的情况下可以直连某一个服务吗？
### 15、为什么需要服务治理？
### 16、RPC使用了哪些关键技术，序列化和反序列化
### 17、默认使用什么序列化框架，你知道的还有哪些？
### 18、画一画服务注册与发现的流程图？
### 19、Dubbo 服务器注册与发现的流程？
### 20、Dubbo Monitor 实现原理？
### 21、Dubbo集群提供了哪些负载均衡策略？
### 22、服务提供者能实现失效踢出的是什么原理？
### 23、Dubbo 推荐用什么协议？
### 24、RPC使用了哪些关键技术，服务调用
### 25、Dubbo 超时时间怎样设置？
### 26、dubbo能做什么
### 27、默认使用什么序列化框架，你知道的还有哪些？
### 28、Dubbo的集群容错方案有哪些？
### 29、dubbo 通信协议 dubbo 协议为什么不能传大包；
### 30、RPC使用了哪些关键技术，反序列化




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
