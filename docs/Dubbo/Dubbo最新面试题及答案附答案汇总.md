# Dubbo最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说说核心的配置有哪些？
| 配置 | 配置说明 |
| --- | --- |
| dubbo:service | 服务配置 |
| dubbo:reference | 引用配置 |
| dubbo:protocol | 协议配置 |
| dubbo:application | 应用配置 |
| dubbo:module | 模块配置 |
| dubbo:registry | 注册中心配置 |
| dubbo:monitor | 监控中心配置 |
| dubbo:provider | 提供方配置 |
| dubbo:consumer | 消费方配置 |
| dubbo:method | 方法配置 |
| dubbo:argument | 参数配置 |



### 2、同一个服务多个注册的情况下可以直连某一个服务吗？

可以直连，修改配置即可，也可以通过 telnet 直接某个服务。


### 3、Dubbo 集群容错有几种方案？
| 集群容错方案 | 说明 |
| --- | --- |
| Failover Cluster | 失败自动切换，自动重试其它服务器（默认） |
| Failfast Cluster | 快速失败，立即报错，只发起一次调用 |
| Failsafe Cluster | 失败安全，出现异常时，直接忽略 |
| Failback Cluster | 失败自动恢复，记录失败请求，定时重发 |
| Forking Cluster | 并行调用多个服务器，只要一个成功即返回 |
| Broadcast Cluster | 广播逐个调用所有提供者，任意一个报错则报错 |



### 4、集群容错怎么做？

读操作建议使用 Failover 失败自动切换，默认重试两次其他服务器。写操作建议使用 Failfast 快速失败，发一次调用失败就立即报错。


### 5、服务上线怎么兼容旧版本？

可以用版本号（version）过渡，多个不同版本的服务注册到注册中心，版本号不同的服务相互间不引用。这个和服务分组的概念有一点类似。


### 6、为什么要用Dubbo？

随着服务化的进一步发展，服务越来越多，服务之间的调用和依赖关系也越来越复杂，诞生了面向服务的架构体系(SOA)，

也因此衍生出了一系列相应的技术，如对服务提供、服务调用、连接处理、通信协议、序列化方式、服务发现、服务路由、日志输出等行为进行封装的服务框架。

就这样为分布式系统的服务治理框架就出现了，Dubbo也就这样产生了。


### 7、如何解决服务调用链过长的问题？

可以结合zipkin实现分布式服务追踪。


### 8、Dubbo 的注册中心集群挂掉，者和订阅者之间还能通信么？
### 9、在使用过程中都遇到了些什么问题？
### 10、你还了解别的分布式框架吗？
### 11、服务调用是阻塞的吗？
### 12、Dubbo 用到哪些设计模式？
### 13、RPC使用了哪些关键技术，NIO通信
### 14、Dubbo 使用过程中都遇到了些什么问题？
### 15、Dubbo 服务器注册与发现的流程？
### 16、Dubbo 核心功能有哪些？
### 17、服务提供者能实现失效踢出是什么原理？
### 18、Dubbo 超时设置有哪些方式？
### 19、Dubbo 推荐什么协议？
### 20、Dubbo 集群的负载均衡有哪些策略
### 21、dubbo和dubbox之间的区别？
### 22、默认使用什么序列化框架，你知道的还有哪些？
### 23、Dubbo 和 Spring Cloud 有什么关系？
### 24、Dubbo的管理控制台能做什么？
### 25、Dubbo支持服务多协议吗？
### 26、Dubbo 支持哪些协议，它们的优缺点有哪些？
### 27、RPC使用了哪些关键技术，服务注册中心
### 28、Dubbo 的默认集群容错方案？
### 29、Dubbo 和 Dubbox 之间的区别？
### 30、Dubbo 如何优雅停机？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
