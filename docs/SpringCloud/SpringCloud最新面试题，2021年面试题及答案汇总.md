# SpringCloud最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、使用 SpringBoot 开发分布式微服务时，我们面临什么问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。


### 2、SpringCloud由什么组成

这就有很多了，我讲几个开发中最重要的

**1、** Spring Cloud Eureka：服务注册与发现

**2、** Spring Cloud Zuul：服务网关

**3、** Spring Cloud Ribbon：客户端负载均衡

**4、** Spring Cloud Feign：声明性的Web服务客户端

**5、** Spring Cloud Hystrix：断路器

**6、** Spring Cloud Config：分布式统一配置管理

**7、** 等20几个框架，开源一直在更新


### 3、Spring Cloud Zookeeper

SpringCloud支持三种注册方式Eureka， Consul(go语言编写)，zookeeper

Spring Cloud Zookeeper是基于Apache Zookeeper的服务治理组件。


### 4、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别

**1、** ZooKeeper中的节点服务挂了就要选举 在选举期间注册服务瘫痪,虽然服务最终会恢复,但是选举期间不可用的， 选举就是改微服务做了集群，必须有一台主其他的都是从

**2、** Eureka各个节点是平等关系,服务器挂了没关系，只要有一台Eureka就可以保证服务可用，数据都是最新的。 如果查询到的数据并不是最新的，就是因为Eureka的自我保护模式导致的

**3、** Eureka本质上是一个工程,而ZooKeeper只是一个进程

**4、** Eureka可以很好的应对因网络故障导致部分节点失去联系的情况,而不会像ZooKeeper 一样使得整个注册系统瘫痪

**5、** ZooKeeper保证的是CP，Eureka保证的是AP

**CAP：**

**1、** C：一致性>Consistency; 取舍：(强一致性、单调一致性、会话一致性、最终一致性、弱一致性)

**2、** A：可用性>Availability;

**3、** P：分区容错性>Partition tolerance;


### 5、Spring Cloud Security

安全工具包，他可以对

**1、** 对Zuul代理中的负载均衡从前端到后端服务中获取SSO令牌

**2、** 资源服务器之间的中继令牌

**3、** 使Feign客户端表现得像`OAuth2RestTemplate`（获取令牌等）的拦截器

**4、** 在Zuul代理中配置下游身份验证

Spring Cloud Security提供了一组原语，用于构建安全的应用程序和服务，而且操作简便。可以在外部（或集中）进行大量配置的声明性模型有助于实现大型协作的远程组件系统，通常具有中央身份管理服务。它也非常易于在Cloud Foundry等服务平台中使用。在SpringBoot和Spring Security OAuth2的基础上，可以快速创建实现常见模式的系统，如单点登录，令牌中继和令牌交换。


### 6、您对微服务有何了解？

微服务，又称微服务架构，是一种架构风格，它将应用程序构建为以业务领域为模型的小型自治服务集合 。

通俗地说，你必须看到蜜蜂如何通过对齐六角形蜡细胞来构建它们的蜂窝状物。他们最初从使用各种材料的小部分开始，并继续从中构建一个大型蜂箱。这些细胞形成图案，产生坚固的结构，将蜂窝的特定部分固定在一起。这里，每个细胞独立于另一个细胞，但它也与其他细胞相关。这意味着对一个细胞的损害不会损害其他细胞，因此，蜜蜂可以在不影响完整蜂箱的情况下重建这些细胞。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_1.png#alt=img%5C_1.png)

图1：微服务的蜂窝表示 – 微服务访谈问题

请参考上图。这里，每个六边形形状代表单独的服务组件。与蜜蜂的工作类似，每个敏捷团队都使用可用的框架和所选的技术堆栈构建单独的服务组件。就像在蜂箱中一样，每个服务组件形成一个强大的微服务架构，以提供更好的可扩展性。此外，敏捷团队可以单独处理每个服务组件的问题，而对整个应用程序没有影响或影响最小。


### 7、访问RESTful微服务的方法是什么？

另一个经常被问到的微服务面试问题是如何访问RESTful微服务？你可以通过两种方法做到这一点：

**1、** 使用负载平衡的REST模板。

**2、** 使用多个微服务。


### 8、什么是 Spring Cloud Bus？

**1、** Spring Cloud Bus就像一个分布式执行器，用于扩展的SpringBoot应用程序的配置文件，但也可以用作应用程序之间的通信通道。

**2、** Spring Cloud Bus 不能单独完成通信，需要配合MQ支持

**3、** Spring Cloud Bus一般是配合Spring Cloud Config做配置中心的

**4、** Springcloud config实时刷新也必须采用SpringCloud Bus消息总线


### 9、Spring Cloud Task

Spring Cloud Task的目标是为SpringBoot应用程序提供创建短运行期微服务的功能。在Spring Cloud Task中，我们可以灵活地动态运行任何任务，按需分配资源并在任务完成后检索结果。Tasks是Spring Cloud Data Flow中的一个基础项目，允许用户将几乎任何SpringBoot应用程序作为一个短期任务执行。


### 10、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。 Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 11、什么是Oauth？
### 12、为什么需要域驱动设计（DDD）？
### 13、微服务架构如何运作？
### 14、springcloud和dubbo有哪些区别
### 15、为什么人们会犹豫使用微服务？
### 16、什么是REST / RESTful以及它的用途是什么？
### 17、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 18、Spring Cloud Config
### 19、什么是微服务架构
### 20、微服务的端到端测试意味着什么？
### 21、Spring Cloud Netflix(重点，这些组件用的最多)
### 22、网关的作用是什么
### 23、eureka服务注册与发现原理
### 24、网关与过滤器有什么区别
### 25、什么是不同类型的双因素身份认证？
### 26、什么是耦合和凝聚力？
### 27、服务降级底层是如何实现的？
### 28、什么是有界上下文？
### 29、DiscoveryClient的作用
### 30、既然Nginx可以实现网关？为什么还需要使用Zuul框架




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
