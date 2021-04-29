# SpringCloud最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？

zookeeper 是CP原则，强一致性和分区容错性。

eureka 是AP 原则 可用性和分区容错性。

zookeeper当主节点故障时，zk会在剩余节点重新选择主节点，耗时过长，虽然最终能够恢复，但是选取主节点期间会导致服务不可用，这是不能容忍的。

eureka各个节点是平等的，一个节点挂掉，其他节点仍会正常保证服务。


### 2、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston |  |



### 3、设计微服务的最佳实践是什么？

以下是设计微服务的最佳实践：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_4.png#alt=img%5C_4.png)

图4：设计微服务的最佳实践 – 微服务访谈问题


### 4、什么是Semantic监控？

它结合了对整个应用程序的监控以及自动化测试。语义监控的主要好处是找出对您的业务更有利可图的因素。 从业务角度来看，语义监控以及服务层监控可以监控微服务。一旦检测到问题，它们就可以实现更快的隔离和 错误分类，从而减少修复所需的主要时间。它对服务层和事务层进行分类，以确定受可用性或性能不佳影响的事务。


### 5、什么是Feign？

**1、** Feign 是一个声明web服务客户端，这使得编写web服务客户端更容易

**2、** 他将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 6、微服务架构的优缺点是什么？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_6.png#alt=img%5C_6.png)


### 7、架构师在微服务架构中的角色是什么？

微服务架构中的架构师扮演以下角色：

决定整个软件系统的布局。

帮助确定组件的分区。因此，他们确保组件相互粘合，但不紧密耦合。

与开发人员共同编写代码，了解日常生活中面临的挑战。

为开发微服务的团队提供某些工具和技术的建议。

提供技术治理，以便技术开发团队遵循微服务原则。


### 8、SpringBoot和SpringCloud的区别？

**1、** SpringBoot专注于快速方便的开发单个个体微服务。

**2、** SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，

**3、** 为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务

**4、** SpringBoot可以离开SpringCloud独立使用开发项目， 但是SpringCloud离不开SpringBoot ，属于依赖的关系

**5、** SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。


### 9、如何设计一套API接口

考虑到API接口的分类可以将API接口分为开发API接口和内网API接口，内网API接口用于局域网，为内部服务器提供服务。开放API接口用于对外部合作单位提供接口调用，需要遵循Oauth2.0权限认证协议。同时还需要考虑安全性、幂等性等问题。


### 10、什么是端到端微服务测试？

端到端测试验证了工作流中的每个流程都正常运行。这可确保系统作为一个整体协同工作并满足所有要求。

通俗地说，你可以说端到端测试是一种测试，在特定时期后测试所有东西。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_17.png#alt=img%5C_17.png)

图14：测试层次 – 微服务面试问题


### 11、在微服务中，如何保护服务?
### 12、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 13、Spring Cloud Config
### 14、Spring Cloud Consul
### 15、链路跟踪Sleuth
### 16、微服务架构如何运作？
### 17、微服务之间是如何独立通讯的
### 18、Spring Cloud的版本关系
### 19、Web，RESTful API在微服务中的作用是什么？
### 20、Spring Cloud Netflix(重点，这些组件用的最多)
### 21、Spring Cloud Zookeeper
### 22、我们如何在测试中消除非决定论？
### 23、什么是服务降级
### 24、spring cloud 和dubbo区别?
### 25、为什么需要学习Spring Cloud
### 26、什么是Eureka
### 27、什么是Oauth？
### 28、微服务之间是如何独⽴通讯的
### 29、Spring Cloud Security
### 30、什么是Spring Cloud？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
