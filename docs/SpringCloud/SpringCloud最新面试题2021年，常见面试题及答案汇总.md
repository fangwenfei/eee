# SpringCloud最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、我们如何在测试中消除非决定论？

非确定性测试（NDT）基本上是不可靠的测试。所以，有时可能会发生它们通过，显然有时它们也可能会失败。当它们失败时，它们会重新运行通过。

从测试中删除非确定性的一些方法如下：

**1、**   隔离

**2、**   异步

**3、**   远程服务

**4、**   隔离

**5、**   时间

**6、**   资源泄漏


### 2、Eureka如何 保证AP

Eureka看明⽩了这⼀点，因此在设计时就优先保证可⽤性。Eureka各个节点都是平等的，⼏个节点挂掉不会影响正常节点的⼯作，剩余的节点依然可以提供注册和查询服务。⽽Eureka的客户端在向某个Eureka注册或如果发现连接失败，则会⾃动切换⾄其它节点，只要有⼀台Eureka还在，就能保证注册服务可⽤(保证可⽤性)，只不过查到的信息可能不是最新的(不保证强⼀致性)。除此之外，Eureka还有⼀种⾃我保护机制，如果在15分钟内超过85%的节点都没有正常的⼼跳，那么Eureka就认为客户端与注册中⼼出现了⽹络故障，此时会出现以下⼏种情况：

**1、** Eureka不再从注册列表中移除因为⻓时间没收到⼼跳⽽应该过期的服务

**2、** Eureka仍然能够接受新服务的注册和查询请求，但是不会被同步到其它节点上(即保证当前节点依然可⽤)

**3、** 当⽹络稳定时，当前实例新的注册信息会被同步到其它节点中

因此， Eureka可以很好的应对因⽹络故障导致部分节点失去联系的情况，⽽不会像zookeeper那样使整个注册服务瘫痪。


### 3、Spring Cloud Zookeeper

基于Apache Zookeeper的服务治理组件。


### 4、我们可以用微服务创建状态机吗？

我们知道拥有自己的数据库的每个微服务都是一个可独立部署的程序单元，这反过来又让我们可以创建一个状态机。因此，我们可以为特定的微服务指定不同的状态和事件。

例如，我们可以定义Order微服务。订单可以具有不同的状态。Order状态的转换可以是Order微服务中的独立事件。


### 5、谈谈服务降级、熔断、服务隔离

**1、** 服务降级：当客户端请求服务器端的时候，防止客户端一直等待，不会处理业务逻辑代码，直接返回一个友好的提示给客户端。

**2、** 服务熔断是在服务降级的基础上更直接的一种保护方式，当在一个统计时间范围内的请求失败数量达到设定值（requestVolumeThreshold）或当前的请求错误率达到设定的错误率阈值（errorThresholdPercentage）时开启断路，之后的请求直接走fallback方法，在设定时间（sleepWindowInMilliseconds）后尝试恢复。

**3、** 服务隔离就是Hystrix为隔离的服务开启一个独立的线程池，这样在高并发的情况下不会影响其他服务。服务隔离有线程池和信号量两种实现方式，一般使用线程池方式。


### 6、使⽤中碰到的坑

**1、** 超时：确保Hystrix超时时间配置为⻓于配置的Ribbon超时时间

**2、** feign path：feign客户端在部署时若有contextpath应该设置 path="/***"来匹配你的服务名。

**3、** 版本：SpringBoot和springcloud版本要兼容。


### 7、Spring Cloud Task

用于快速构建短暂、有限数据处理任务的微服务框架，用于向应用中添加功能性和非功能性的特性。


### 8、REST 和RPC对比

**1、** RPC主要的缺陷是服务提供方和调用方式之间的依赖太强，需要对每一个微服务进行接口的定义，并通过持续继承发布，严格版本控制才不会出现冲突。

**2、** REST是轻量级的接口，服务的提供和调用不存在代码之间的耦合，只需要一个约定进行规范。


### 9、如何配置SpringBoot应用程序日志记录？

SpringBoot附带了对Log4J2，Java Util Logging和Logback的支持。它通常预先配置为控制台输出。可以通过仅在application.properties文件中指定logging.level来配置它们。

```
logging.level.spring.framework=Debug
```


### 10、Spring Cloud解决了哪些问题？

在使用SpringBoot开发分布式微服务时，我们面临的问题很少由Spring Cloud解决。

与分布式系统相关的复杂性 – 包括网络问题，延迟开销，带宽问题，安全问题。

处理服务发现的能力 – 服务发现允许集群中的进程和服务找到彼此并进行通信。

解决冗余问题 – 冗余问题经常发生在分布式系统中。

负载平衡 – 改进跨多个计算资源（例如计算机集群，网络链接，中央处理单元）的工作负载分布。

减少性能问题 – 减少因各种操作开销导致的性能问题。


### 11、我们如何进行跨功能测试？
### 12、Spring Cloud Gateway
### 13、链路跟踪Sleuth
### 14、为什么我们需要微服务容器？
### 15、什么是Eureka的自我保护模式，
### 16、如何覆盖SpringBoot项目的默认属性？
### 17、Spring Cloud Netflix
### 18、Spring Cloud和SpringBoot版本对应关系
### 19、接⼝限流⽅法？
### 20、微服务之间如何独立通讯的?
### 21、什么是feigin？它的优点是什么？
### 22、Spring Cloud Bus
### 23、什么是双因素身份验证？
### 24、Spring Cloud Gateway
### 25、为什么要使用 Spring Cloud 熔断器？
### 26、什么是SpringBoot？
### 27、ZuulFilter常用有那些方法
### 28、什么是Spring引导的执行器？
### 29、spring cloud 和dubbo区别?
### 30、@LoadBalanced注解的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
