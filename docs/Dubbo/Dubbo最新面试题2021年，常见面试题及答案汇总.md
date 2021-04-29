# Dubbo最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Dubbo 和 Spring Cloud 有什么哪些区别？

Dubbo 底层是使用 Netty 这样的 NIO 框架，是基于 TCP 协议传输的，配合以 Hession 序列化完成 RPC 通信。

Spring Cloud 是基于 Http 协议 Rest 接口调用远程过程的通信，相对来说 Http 请求会有更大的报文，占的带宽也会更多。但是 REST 相比 RPC 更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更为合适，至于注重通信速度还是方便灵活性，具体情况具体考虑。


### 2、Dubbo 是什么？

Dubbo 是一个分布式、高性能、透明化的 RPC 服务框架，提供服务自动注册、自动发现等高效服务治理方案， 可以和Spring 框架无缝集成


### 3、Dubbo 可以对结果进行缓存吗？

为了提高数据访问的速度。Dubbo 提供了声明式缓存，以减少用户加缓存的工作量<dubbo:reference cache=“true” />

其实比普通的配置文件就多了一个标签 cache=“true”


### 4、一般使用什么注册中心？还有别的选择吗？

推荐使用zookeeper注册中心，还有Redis等不推荐。


### 5、画一画服务注册与发现的流程图？

![](http://dubbo.apache.org/img/architecture.png#alt=)


### 6、Dubbo 服务降级，失败重试怎么做？

可以通过dubbo:reference 中设置 mock="return null"。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑


### 7、Dubbo 使用过程中都遇到了些什么问题？

在注册中心找不到对应的服务,检查 service 实现类是否添加了[@service ](/service ) 注解无法连接到注册中心,检查配置文件中的对应的测试 ip 是否正确


### 8、Dubbo 服务降级，失败重试怎么做？

可以通过 dubbo:reference 中设置 mock=“return null”。mock 的值也可以修改为 true，然后再跟接口同一个路径下实现一个 Mock 类，命名规则是 “接口名称+Mock” 后缀。然后在 Mock 类里实现自己的降级逻辑


### 9、你还了解别的分布式框架吗？

别的还有spring的spring cloud，facebook的thrift，twitter的finagle等。


### 10、你觉得用 Dubbo 好还是 Spring Cloud 好？

扩展性的问题，没有好坏，只有适合不适合，不过我好像更倾向于使用 Dubbo, Spring Cloud 版本升级太快，组件更新替换太频繁，配置太繁琐，还有很多我觉得是没有 Dubbo 顺手的地方。


### 11、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 12、Dubbo 的使用场景有哪些？
### 13、说说核心的配置有哪些？
### 14、Dubbo telnet 命令能做什么？
### 15、dubbo 通信协议 dubbo 协议为什么不能传大包；
### 16、dubbo 推荐用什么协议？
### 17、服务提供者能实现失效踢出的是什么原理？
### 18、Dubbo的管理控制台能做什么？
### 19、注册了多个同一样的服务，如果测试指定的某一个服务呢？
### 20、Dubbo支持服务多协议吗？
### 21、如何解决服务调用链过长的问题？
### 22、同一个服务多个注册的情况下可以直连某一个服务吗？
### 23、默认使用什么序列化框架，你知道的还有哪些？
### 24、为什么要有RPC
### 25、集群容错怎么做？
### 26、Dubbo 在安全机制方面是如何解决的
### 27、dubbo能做什么
### 28、Dubbo 支持分布式事务吗？
### 29、默认使用的是什么通信框架，还有别的选择吗?
### 30、Dubbo 和 Spring Cloud 有什么哪些区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
