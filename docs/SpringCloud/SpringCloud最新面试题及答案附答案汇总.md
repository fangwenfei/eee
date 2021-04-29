# SpringCloud最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cloud抛弃了Dubbo 的RPC通信，采用的是基于HTTP的REST方式。

严格来说，这两种方式各有优劣。虽然在一定程度上来说，后者牺牲了服务调用的性能，但也避免了上面提到的原生RPC带来的问题。而且REST相比RPC更为灵活，服务提供方和调用方的依赖只依靠一纸契约，不存在代码级别的强依赖，这在强调快速演化的微服务环境下，显得更为合适。



### 2、Ribbon是什么？

**1、** Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法

**2、** Ribbon客户端组件提供一系列完善的配置项，如连接超时，重试等。简单的说，就是在配置文件中列出后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随即连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。（有点类似Nginx）


### 3、微服务架构的优缺点是什么？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_6.png#alt=img%5C_6.png)


### 4、springcloud和dubbo有哪些区别

**1、** Dubbo具有调度、发现、监控、治理等功能，⽀持相当丰富的服务治理能⼒。Dubbo架构下，注册中⼼对等集群，并会缓存服务列表已被数据库失效时继续提供发现功能，本身的服务发现结构有很强的可⽤性与健壮性，⾜够⽀持⾼访问量的⽹站。

**2、** 虽然Dubbo ⽀持短连接⼤数据量的服务提供模式，但绝⼤多数情况下都是使⽤⻓连接⼩数据量的模式提供服务使⽤的。所以，对于类似于电商等同步调⽤场景多并且能⽀撑搭建Dubbo 这套⽐较复杂环境的成本的产品⽽⾔，Dubbo 确实是⼀个可以考虑的选择。但如果产品业务中由于后台业务逻辑复杂、时间⻓⽽导致异步逻辑⽐较多的话，可能Dubbo 并不合适。同时，对于⼈⼿不⾜的初创产品⽽⾔，这么重的架构维护起来也不是很⽅便。

**3、** Spring Cloud由众多⼦项⽬组成，如Spring Cloud Config、Spring Cloud Netflix、Spring Cloud Consul 等，提供了搭建分布式系统及微服务常⽤的⼯具，如配置管理、服务发现、断路器、智能路由、微代理、控制总线、⼀次性token、全局锁、选主、分布式会话和集群状态等，满⾜了构建微服务所需的所有解决⽅案。⽐如使⽤Spring Cloud Config 可以实现统⼀配置中⼼，对配置进⾏统⼀管理；使⽤Spring Cloud Netflix 可以实现Netflix 组件的功能 - 服务发现（Eureka）、智能路由（Zuul）、客户端负载均衡（Ribbon）。

**4、** Dubbo 提供了各种 Filter，对于上述中“⽆”的要素，可以通过扩展 Filter 来完善。

**5、** dubbo的开发难度较⼤，原因是dubbo的jar包依赖问题很多⼤型⼯程⽆法解决。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_3.png#alt=45%5C_3.png)


### 5、SpringCloud有几种调用接口方式

**1、** Feign

**2、** RestTemplate


### 6、什么是Spring引导的执行器？

SpringBoot执行程序提供了restful Web服务，以访问生产环境中运行应用程序的当前状态。在执行器的帮助下，您可以检查各种指标并监控您的应用程序。


### 7、为什么人们会犹豫使用微服务？

我见过许多开发者在这个问题上摸索。毕竟，在面试微服务架构师角色时，他们会被问到这个问题，所以承认它的缺点可能有点棘手。以下是一些很好的答案：

它们需要大量协作 - 微服务需要大量的合作。不同的微服务模块，可能分散在不同的团队，团队之间需要始终保持良好的同步。

他们需要建立繁重的架构 - 系统是分布式的，架构涉及很多。 他们需要过多的计划来处理操作开销 - 如果您计划使用微服务架构，则需要为操作开销做好准备。 需要熟练的专业人员，他们可以支持异构分布的微服务。


### 8、Spring Cloud Security
### 9、您对微服务有何了解？
### 10、什么是Spring Cloud Config?
### 11、SpringBoot和springcloud认识
### 12、什么是服务熔断
### 13、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 14、负载平衡的意义什么？
### 15、什么是Eureka的自我保护模式，
### 16、网关与过滤器有什么区别
### 17、链路跟踪Sleuth
### 18、什么是有界上下文？
### 19、什么是耦合和凝聚力？
### 20、SpringBoot支持哪些嵌入式容器？
### 21、什么是 Hystrix？
### 22、spring cloud 断路器的作用是什么？
### 23、负载均衡的意义是什么?
### 24、使用Spring Cloud有什么优势？
### 25、Spring Cloud Gateway
### 26、eureka缓存机制：
### 27、我们可以用微服务创建状态机吗？
### 28、如何覆盖SpringBoot项目的默认属性？
### 29、您将如何在微服务上执行安全测试？
### 30、使⽤中碰到的坑




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
