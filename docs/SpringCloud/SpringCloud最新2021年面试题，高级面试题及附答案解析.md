# SpringCloud最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、接⼝限流⽅法？

**限制 总并发数（⽐如 数据库连接池、线程池）**

**1、** 限制 瞬时并发数（如 nginx 的 limit_conn 模块，⽤来限制 瞬时并发连接数）

**2、** 限制 时间窗⼝内的平均速率（如 Guava 的 RateLimiter、nginx 的 limit_req模块，限制每秒的平均速率）

**3、** 限制 远程接⼝ 调⽤速率

**4、** 限制 MQ 的消费速率

**5、** 可以根据⽹络连接数、⽹络流量、CPU或内存负载等来限流



### 2、SpringBoot和SpringCloud的区别？

**1、** SpringBoot专注于快速方便的开发单个个体微服务。

**2、** SpringCloud是关注全局的微服务协调整理治理框架，它将SpringBoot开发的一个个单体微服务整合并管理起来，

**3、** 为各个微服务之间提供，配置管理、服务发现、断路器、路由、微代理、事件总线、全局锁、决策竞选、分布式会话等等集成服务

**4、** SpringBoot可以离开SpringCloud独立使用开发项目， 但是SpringCloud离不开SpringBoot ，属于依赖的关系

**5、** SpringBoot专注于快速、方便的开发单个微服务个体，SpringCloud关注全局的服务治理框架。


### 3、我们如何在测试中消除非决定论？

非确定性测试（NDT）基本上是不可靠的测试。所以，有时可能会发生它们通过，显然有时它们也可能会失败。当它们失败时，它们会重新运行通过。

从测试中删除非确定性的一些方法如下：

**1、**   隔离

**2、**   异步

**3、**   远程服务

**4、**   隔离

**5、**   时间

**6、**   资源泄漏


### 4、SpringCloud有几种调用接口方式

**1、** Feign

**2、** RestTemplate


### 5、dubbo服务注册与发现原理

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_5.png#alt=45%5C_5.png)

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_6.png#alt=45%5C_6.png)

调⽤关系说明：

**1、** 服务容器负责启动,加载,运⾏服务提供者。

**2、** 服务提供者在启动时,向注册中⼼注册⾃⼰提供的服务。

**3、** 服务消费者在启动时,向注册中⼼订阅⾃⼰所需的服务。

**4、** 注册中⼼返回服务提供者地址列表给消费者,如果有变更,注册中⼼将基于⻓连接推送变更数据给消费者。

**5、** 服务消费者,从提供者地址列表中,基于软负载均衡算法,选⼀台提供者进⾏调⽤,如果调⽤失败,再选另⼀台调⽤。

**6、** 服务消费者和提供者,在内存中累计调⽤次数和调⽤时间,定时每分钟发送⼀次统计数据到监控中⼼。


### 6、eureka缓存机制：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_10.png#alt=45%5C_10.png)

#
### 7、为什么要选择微服务架构？

这是一个非常常见的微服务面试问题，你应该准备好了！微服务架构提供了许多优点。这里有几个：

**1、** 微服务可以轻松适应其他框架或技术。

**2、** 单个进程的失败不会影响整个系统。

**3、** 为大企业和小型团队提供支持。

**4、** 可以在相对较短的时间内独立部署。


### 8、Container在微服务中的用途是什么？

容器是管理基于微服务的应用程序以便单独开发和部署它们的好方法。您可以将微服务封装在容器映像及其依赖项中，然后可以使用它来滚动按需实例的微服务，而无需任何额外的工作。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_18.png#alt=img%5C_18.png)

图15： 容器的表示及其在微服务中的使用方式 – 微服务访谈问题


### 9、Spring Cloud Bus

用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置信息。

简单来说就是修改了配置文件，发送一次请求，所有客户端便会重新读取配置文件。

需要利用中间插件MQ


### 10、Zuul网关如何搭建集群

使用Nginx的upstream设置Zuul服务集群，通过location拦截请求并转发到upstream，默认使用轮询机制对Zuul集群发送请求。


### 11、您对微服务架构中的语义监控有何了解？
### 12、什么是金丝雀释放？
### 13、PACT在微服务架构中的用途是什么？
### 14、springcloud如何实现服务的注册?
### 15、什么是服务降级
### 16、谈谈服务雪崩效应
### 17、为什么要使用 Spring Cloud 熔断器？
### 18、什么是Spring Cloud Zuul（服务网关）
### 19、什么是REST / RESTful以及它的用途是什么？
### 20、Mock或Stub有什么区别？
### 21、eureka服务注册与发现原理
### 22、什么是Oauth？
### 23、在微服务中，如何保护服务?
### 24、Spring Cloud 是什么
### 25、你所知道微服务的技术栈有哪些？列举一二
### 26、使⽤中碰到的坑
### 27、什么是 Spring Cloud Bus？
### 28、如何在SpringBoot应用程序中实现Spring安全性？
### 29、什么是OAuth？
### 30、什么是feigin？它的优点是什么？
### 31、Docker的目的是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
