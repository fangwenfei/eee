# SpringCloud最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Idempotence以及它在哪里使用？

幂等性是能够以这样的方式做两次事情的特性，即最终结果将保持不变，即好像它只做了一次。

用法：在远程服务或数据源中使用 Idempotence，这样当它多次接收指令时，它只处理指令一次。


### 2、什么是Spring Cloud？

在微服务中，SpringCloud是一个提供与外部系统集成的系统。它是一个敏捷的框架，可以短平快构建应用程序。与有限数量的数据处理相关联，它在微服务体系结构中起着非常重要的作用。 **以下为 Spring Cloud 的核心特性**：

**1、** 版本化/分布式配置。

**2、** 服务注册和发现。

**3、** 服务和服务之间的调用。

**4、** 路由。

**5、** 断路器和负载平衡。

**6、** 分布式消息传递。


### 3、设计微服务的最佳实践是什么？

以下是设计微服务的最佳实践：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_4.png#alt=img%5C_4.png)

图4：设计微服务的最佳实践 – 微服务访谈问题


### 4、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？

**1、** zookeeper 是CP原则，强一致性和分区容错性。

**2、** eureka 是AP 原则 可用性和分区容错性。

**3、** zookeeper当主节点故障时，zk会在剩余节点重新选择主节点，耗时过长，虽然最终能够恢复，但是选取主节点期间会导致服务不可用，这是不能容忍的。

**4、** eureka各个节点是平等的，一个节点挂掉，其他节点仍会正常保证服务。


### 5、为什么我们需要微服务容器？

要管理基于微服务的应用程序，容器是最简单的选择。它帮助用户单独部署和开发。您还可以使用Docker将微服务封装到容器的镜像中。没有任何额外的依赖或工作，微服务可以使用这些元素。


### 6、分布式配置中心的作用？

动态变更项目配置信息而不必重新部署项目。


### 7、Spring Cloud 实现服务注册和发现的原理是什么？

**1、** 服务在发布时指定对应的服务名（服务名包括了 IP 地址和端口）将服务注册到注册中心（Eureka 或者 Zookeeper）这一过程是 Spring Cloud 自动实现的，只需要在 main 方法添加 @EnableDisscoveryClient 即可，同一个服务修改端口就可以启动多个实例。

**2、** 调用方法：传递服务名称通过注册中心获取所有的可用实例，通过负载均衡策略调用（Ribbon 和 Feign）对应的服务。


### 8、DiscoveryClient的作用
### 9、什么是幂等性?它是如何使用的？
### 10、SpringBoot和SpringCloud的区别？
### 11、22。你能否给出关于休息和微服务的要点？
### 12、什么是微服务中的反应性扩展？
### 13、Spring Cloud Gateway
### 14、服务注册和发现是什么意思？Spring Cloud如何实现？
### 15、你所知道微服务的技术栈有哪些？列举一二
### 16、您对Distributed Transaction有何了解？
### 17、Ribbon底层实现原理
### 18、Spring Cloud Config
### 19、Spring Cloud Sleuth
### 20、如何设置服务发现？
### 21、Spring Cloud Security
### 22、PACT如何运作？
### 23、什么是Spring Cloud？
### 24、什么是Spring Cloud Bus?
### 25、微服务的缺点：
### 26、谈一下领域驱动设计
### 27、您对微服务架构中的语义监控有何了解？
### 28、Spring Cloud Zookeeper
### 29、Zuul与Nginx有什么区别？
### 30、Spring Cloud Consul




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
