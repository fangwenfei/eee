# SpringCloud最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、缓存机制：

设置了⼀个每30秒执⾏⼀次的定时任务，定时去服务端获取注册信息。获取之后，存⼊本地内存。


### 2、使用 SpringBoot 开发分布式微服务时，我们面临什么问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。


### 3、康威定律是什么？

“任何设计系统的组织（广泛定义）都将产生一种设计，其结构是组织通信结构的副本。” –  Mel Conway

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_16.png#alt=img%5C_16.png)

图13：  Conway定律的表示 – 微服务访谈问题

该法律基本上试图传达这样一个事实：为了使软件模块起作用，整个团队应该进行良好的沟通。因此，系统的结构反映了产生它的组织的社会边界。


### 4、什么是客户证书？

客户端系统用于向远程服务器发出经过身份验证的请求的一种数字证书称为**客户端证书**。客户端证书在许多相互认证设计中起着非常重要的作用，为请求者的身份提供了强有力的保证。


### 5、SpringCloud限流：

**1、** 我们可以通过semaphore.maxConcurrentRequests,coreSize,maxQueueSize和queueSizeRejectionThreshold设置信号量模式下的最⼤并发量、线程池⼤⼩、缓冲区⼤⼩和缓冲区降级阈值。

```
#不设置缓冲区，当请求数超过coreSize时直接降级
hystrix.threadpool.userThreadPool.maxQueueSize=-1超时时间⼤于我们的timeout接⼝返回时间
hystrix.command.userCommandKey.execution.isolation.thread.timeoutInMilliseconds=15000
```

这个时候我们连续多次请求/user/command/timeout接⼝，在第⼀个请求还没有成功返回时，查看输出⽇志可以发现只有第⼀个请求正常的进⼊到user-service的接⼝中，其它请求会直接返回降级信息。这样我们就实现了对服务请求的限流。

**2、** 漏桶算法：⽔（请求）先进⼊到漏桶⾥，漏桶以⼀定的速度出⽔，当⽔流⼊速度过⼤会直接溢出，可以看出漏桶算法能强⾏限制数据的传输速率。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_7.png#alt=45%5C_7.png)

**3、** 令牌桶算法：除了要求能够限制数据的平均传输速率外，还要求允许某种程度的突发传输。这时候漏桶算法可能就不合适了，令牌桶算法更为适合。 如图所示，令牌桶算法的原理是系统会以⼀个恒定的速度往桶⾥放⼊令牌，⽽如果请求需要被处理，则需要先从桶⾥获取⼀个令牌，当桶⾥没有令牌可取时，则拒绝服务。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_8.png#alt=45%5C_8.png)


### 6、服务降级底层是如何实现的？

Hystrix实现服务降级的功能是通过重写HystrixCommand中的getFallback()方法，当Hystrix的run方法或construct执行发生错误时转而执行getFallback()方法。


### 7、Zookeeper如何 保证CP

当向注册中⼼查询服务列表时，我们可以容忍注册中⼼返回的是⼏分钟以前的注册信息，但不能接受服务直接down掉不可⽤。也就是说，服务注册功能对可⽤性的要求要⾼于⼀致性。但是zk会出现这样⼀种情况，当master节点因为⽹络故障与其他节点失去联系时，剩余节点会重新进⾏leader选举。问题在于，选举leader的时间太⻓，30 ~ 120s, 且选举期间整个zk集群都是不可⽤的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因⽹络问题使得zk集群失去master节点是较⼤概率会发⽣的事，虽然服务能够最终恢复，但是漫⻓的选举时间导致的注册⻓期不可⽤是不能容忍的。


### 8、Spring Cloud Sleuth
### 9、Spring Cloud 是什么
### 10、Ribbon和Feign调用服务的区别
### 11、什么是无所不在的语言？
### 12、Spring Cloud Consul
### 13、既然Nginx可以实现网关？为什么还需要使用Zuul框架
### 14、服务网关的作用
### 15、为什么要使用 Spring Cloud 熔断器？
### 16、谈谈服务雪崩效应
### 17、什么是微服务架构
### 18、Eureka怎么实现高可用
### 19、SpringCloud由什么组成
### 20、Eureka如何 保证AP
### 21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 22、您对Mike Cohn的测试金字塔了解多少？
### 23、什么是微服务架构中的DRY？
### 24、什么是不同类型的微服务测试？
### 25、什么是Spring Cloud Gateway?
### 26、微服务的端到端测试意味着什么？
### 27、微服务之间是如何独立通讯的
### 28、第⼆层缓存：
### 29、什么是端到端微服务测试？
### 30、微服务设计的基础是什么？
### 31、Spring Cloud的版本关系




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
