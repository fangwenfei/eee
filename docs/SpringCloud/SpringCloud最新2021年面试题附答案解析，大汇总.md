# SpringCloud最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Spring Cloud Task

Spring Cloud Task的目标是为SpringBoot应用程序提供创建短运行期微服务的功能。在Spring Cloud Task中，我们可以灵活地动态运行任何任务，按需分配资源并在任务完成后检索结果。Tasks是Spring Cloud Data Flow中的一个基础项目，允许用户将几乎任何SpringBoot应用程序作为一个短期任务执行。


### 2、SpringCloud的优缺点

**优点：**

**1、** 耦合度比较低。不会影响其他模块的开发。

**2、** 减轻团队的成本，可以并行开发，不用关注其他人怎么开发，先关注自己的开发。

**3、** 配置比较简单，基本用注解就能实现，不用使用过多的配置文件。

**4、** 微服务跨平台的，可以用任何一种语言开发。

**5、** 每个微服务可以有自己的独立的数据库也有用公共的数据库。

**6、** 直接写后端的代码，不用关注前端怎么开发，直接写自己的后端代码即可，然后暴露接口，通过组件进行服务通信。

**缺点：**

1、部署比较麻烦，给运维工程师带来一定的麻烦。

2、针对数据的管理比麻烦，因为微服务可以每个微服务使用一个数据库。

3、系统集成测试比较麻烦

4、性能的监控比较麻烦。【最好开发一个大屏监控系统】

总的来说优点大过于缺点，目前看来Spring Cloud是一套非常完善的分布式框架，目前很多企业开始用微服务、Spring Cloud的优势是显而易见的。因此对于想研究微服务架构的同学来说，学习Spring Cloud是一个不错的选择。


### 3、Spring Cloud Gateway

Spring cloud gateway是spring官方基于Spring 5.0、SpringBoot2.0和Project Reactor等技术开发的网关，Spring Cloud Gateway旨在为微服务架构提供简单、有效和统一的API路由管理方式，Spring Cloud Gateway作为Spring Cloud生态系统中的网关，目标是替代Netflix Zuul，其不仅提供统一的路由方式，并且还基于Filer链的方式提供了网关基本的功能，例如：安全、监控/埋点、限流等。


### 4、Spring Cloud Task

用于快速构建短暂、有限数据处理任务的微服务框架，用于向应用中添加功能性和非功能性的特性。


### 5、什么是持续集成（CI）？

持续集成（CI）是每次团队成员提交版本控制更改时自动构建和测试代码的过程。这鼓励开发人员通过在每个小任务完成后将更改合并到共享版本控制存储库来共享代码和单元测试。


### 6、Ribbon和Feign调用服务的区别

**1、** 调用方式同：Ribbon需要我们自己构建Http请求，模拟Http请求然后通过RestTemplate发给其他服务，步骤相当繁琐

**2、** 而Feign则是在Ribbon的基础上进行了一次改进，采用接口的形式，将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 7、PACT在微服务架构中的用途是什么？

PACT是一个开源工具，允许测试服务提供者和消费者之间的交互，与合同隔离，从而提高微服务集成的可靠性。

微服务中的用法

用于在微服务中实现消费者驱动的合同。

测试微服务的消费者和提供者之间的消费者驱动的合同。

查看即将到来的批次


### 8、什么是耦合？

组件之间依赖关系强度的度量被认为是耦合。一个好的设计总是被认为具有高内聚力和低耦合性。


### 9、SpringCloud限流：

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


### 10、服务雪崩？

简介：服务雪崩效应是⼀种因服务提供者的不可⽤导致服务调⽤者的不可⽤,并将不可⽤逐渐放⼤的过程.

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_12.png#alt=45%5C_12.png)

**形成原因**

**1、** 服务提供者不可

**2、** 重试加⼤流量

**3、** 服务调⽤者不可⽤

**采⽤策略**

**1、** 流量控制

**2、** 改进缓存模式

**3、** 服务⾃动扩容

**4、** 服务调⽤者降级服务


### 11、服务降级底层是如何实现的？
### 12、什么是Oauth？
### 13、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 14、链路跟踪Sleuth
### 15、SpringCloud有几种调用接口方式
### 16、在微服务中，如何保护服务?
### 17、使用Spring Cloud有什么优势？
### 18、列举微服务技术栈
### 19、Spring Cloud解决了哪些问题？
### 20、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 21、什么是不同类型的微服务测试？
### 22、什么是Semantic监控？
### 23、什么是Hystrix?
### 24、springcloud如何实现服务的注册?
### 25、什么是Feign？
### 26、什么是服务熔断
### 27、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？
### 28、访问RESTful微服务的方法是什么？
### 29、SOA和微服务架构之间的主要区别是什么？
### 30、什么是Spring Cloud？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
