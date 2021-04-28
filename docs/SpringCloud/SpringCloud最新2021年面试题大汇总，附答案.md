# SpringCloud最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、合同测试你懂什么？

根据Martin Flower的说法，合同测试是在外部服务边界进行的测试，用于验证其是否符合消费服务预期的合同。

此外，合同测试不会深入测试服务的行为。更确切地说，它测试该服务调用的输入＆输出包含所需的属性和所述响应延迟，吞吐量是允许的限度内。


### 2、分布式配置中心的作用？

动态变更项目配置信息而不必重新部署项目。


### 3、Ribbon是什么？

**1、** Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法

**2、** Ribbon客户端组件提供一系列完善的配置项，如连接超时，重试等。简单的说，就是在配置文件中列出后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随即连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。（有点类似Nginx）


### 4、什么是 Hystrix 断路器？我们需要它吗？

由于某些原因，employee-consumer 公开服务会引发异常。在这种情况下使用 Hystrix 我们定义了一个回退方法。如果在公开服务中发生异常，则回退方法返回一些默认值

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_13.png#alt=45%5C_13.png)

中断，并且员工使用者将一起跳过 firtsPage 方法，并直接调用回退方法。 断路器的目的是给第一页方法或第一页方法可能调用的其他方法留出时间，并导致异常恢复。可能发生的情况是，在负载较小的情况下，导致异常的问题有更好的恢复机会 。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_14.png#alt=45%5C_14.png)


### 5、Spring Cloud Consul

基于Hashicorp Consul的服务治理组件。


### 6、单片，SOA和微服务架构有什么区别？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_7.png#alt=img%5C_7.png)

图6： 单片SOA和微服务之间的比较 – 微服务访谈问题

单片架构类似于大容器，其中应用程序的所有软件组件组装在一起并紧密封装。

一个面向服务的架构是一种相互通信服务的集合。通信可以涉及简单的数据传递，也可以涉及两个或多个协调某些活动的服务。

微服务架构是一种架构风格，它将应用程序构建为以业务域为模型的小型自治服务集合。


### 7、负载平衡的意义什么？

**1、** 简单来说： 先将集群，集群就是把一个的事情交给多个人去做，假如要做1000个产品给一个人做要10天，我叫10个人做就是一天，这就是集群，负载均衡的话就是用来控制集群，他把做的最多的人让他慢慢做休息会，把做的最少的人让他加量让他做多点。

**2、** 在计算中，负载平衡可以改善跨计算机，计算机集群，网络链接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载平衡旨在优化资源使用，最大化吞吐量，最小化响应时间并避免任何单一资源的过载。使用多个组件进行负载平衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载平衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务器进程。


### 8、什么是微服务中的反应性扩展？

Reactive Extensions也称为Rx。这是一种设计方法，我们通过调用多个服务来收集结果，然后编译组合响应。这些调用可以是同步或异步，阻塞或非阻塞。Rx是分布式系统中非常流行的工具，与传统流程相反。

希望这些微服务面试问题可以帮助您进行微服务架构师访谈。

翻译来源：[https://www.edureka.co/blog/interview-questions/microservices-interview-questions/](https://www.edureka.co/blog/interview-questions/microservices-interview-questions/)



### 9、微服务的缺点：

**1、** 复杂度⾼：服务调⽤要考虑被调⽤⽅故障、过载、消息丢失等各种异常情况，代码逻辑更加复杂；对于微服务间的事务性操作，因为不同的微服务采⽤了不同的数据库，将⽆法利⽤数据库本身的事务机制保证⼀致性，需要引⼊⼆阶段提交等技术。

**2、** 运维复杂：系统由多个独⽴运⾏的微服务构成，需要⼀个设计良好的监控系统对各个微服务的运⾏状态进⾏监控。运维⼈员需要对系统有细致的了解才对够更好的运维系统。

**3、** 通信延迟：微服务之间调⽤会有时间损耗，造成通信延迟。


### 10、Zuul与Nginx有什么区别？

Zuul是java语言实现的，主要为java服务提供网关服务，尤其在微服务架构中可以更加灵活的对网关进行操作。Nginx是使用C语言实现，性能高于Zuul，但是实现自定义操作需要熟悉lua语言，对程序员要求较高，可以使用Nginx做Zuul集群。


### 11、SpringCloud的优缺点
### 12、Spring Cloud 实现服务注册和发现的原理是什么？
### 13、什么是微服务
### 14、Spring Cloud Sleuth
### 15、SpringBoot支持哪些嵌入式容器？
### 16、什么是凝聚力？
### 17、微服务之间是如何独立通讯的?
### 18、什么是Semantic监控？
### 19、微服务架构有哪些优势？
### 20、PACT在微服务架构中的用途是什么？
### 21、什么是Hystrix？它如何实现容错？
### 22、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。
### 23、什么是服务降级
### 24、双因素身份验证的凭据类型有哪些？
### 25、什么是微服务架构中的DRY？
### 26、您对Distributed Transaction有何了解？
### 27、微服务测试的主要障碍是什么？
### 28、您将如何在微服务上执行安全测试？
### 29、SpringCloud 和 Dubbo 有哪些区别?
### 30、Ribbon和Feign的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
