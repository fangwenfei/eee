# Dubbo最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、你觉得用 Dubbo 好还是 Spring Cloud 好？

扩展性的问题，没有好坏，只有适合不适合，不过我好像更倾向于使用 Dubbo, Spring Cloud 版本升级太快，组件更新替换太频繁，配置太繁琐，还有很多我觉得是没有 Dubbo 顺手的地方。


### 2、RPC使用了哪些关键技术，反序列化

当B机器接收到A机器的应用发来的请求之后，又需要对接收到的参数等信息进行反序列化操作（序列化的逆操作），即将二进制信息恢复为内存中的表达方式，然后再找到对应的方法（寻址的一部分）进行本地调用（一般是通过生成代理Proxy去调用, 通常会有JDK动态代理、CGLIB动态代理、Javassist生成字节码技术等），之后得到调用的返回值。


### 3、Dubbo服务之间的调用是阻塞的吗？

默认是同步等待结果阻塞的，支持异步调用，Dubbo 是基于 NIO 的非阻塞实现并行调用，客户端不需要启动多线程即可完成并行调用多个远程服务，相对多线程开销较小，异步调用会返回一个 Future 对象。


### 4、Dubbo 和 Dubbox 之间的区别？

Dubbox 是继 Dubbo 停止维护后，当当网基于 Dubbo 做的一个扩展项目，如加了服务可 Restful 调用，更新了开源组件等。


### 5、在使用过程中都遇到了些什么问题？

如序列化问题。


### 6、Dubbo 使用过程中都遇到了些什么问题？

在注册中心找不到对应的服务,检查 service 实现类是否添加了[@service ](/service ) 注解无法连接到注册中心,检查配置文件中的对应的测试 ip 是否正确


### 7、你还了解别的分布式框架吗？

别的还有 Spring cloud、Facebook 的 Thrift、Twitter 的 Finagle 等。


### 8、Dubbo 在安全机制方面是如何解决？

Dubbo 通过 Token 令牌防止用户绕过注册中心直连，然后在注册中心上管理授权。Dubbo 还提供服务黑白名单，来控制服务所允许的调用方。


### 9、RPC使用了哪些关键技术，从调用者的角度看：

服务的调用者启动的时候根据自己订阅的服务向服务注册中心查找服务提供者的地址等信息；

当服务调用者消费的服务上线或者下线的时候，注册中心会告知该服务的调用者；

服务调用者下线的时候，则取消订阅。


### 10、Dubbo 推荐用什么协议？

- dubbo://（推荐）
- rmi://
- hessian://
- http://
- webservice://
- thrift://
- Memcached://
- Redis://
- rest://


### 11、Dubbo SPI 和 Java SPI 区别？
### 12、什么是RPC
### 13、Dubbo 和 Spring Cloud 的区别？
### 14、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 15、RPC使用了哪些关键技术，动态代理
### 16、Dubbo SPI 和 Java SPI 区别？
### 17、Dubbo的集群容错方案有哪些？
### 18、一般使用什么注册中心？还有别的选择吗？
### 19、服务提供者能实现失效踢出是什么原理？
### 20、Dubbo 的整体架构设计有哪些分层?
### 21、一般使用什么注册中心？还有别的选择吗？
### 22、Dubbo 是什么？
### 23、RPC使用了哪些关键技术，序列化
### 24、Dubbo 的使用场景有哪些？
### 25、服务上线怎么兼容旧版本？
### 26、说说核心的配置有哪些？
### 27、RPC使用了哪些关键技术，RPC的实现原理架构图
### 28、Dubbo的集群容错方案有哪些？
### 29、Dubbo 和 Dubbox 之间的区别？
### 30、服务调用超时会怎么样？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
