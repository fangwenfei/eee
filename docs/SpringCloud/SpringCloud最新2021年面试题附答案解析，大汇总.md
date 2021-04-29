# SpringCloud最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring Cloud Stream

轻量级事件驱动微服务框架，可以使用简单的声明式模型来发送及接收消息，主要实现为Apache Kafka及RabbitMQ。


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


### 3、微服务的端到端测试意味着什么？

端到端测试 验证工作流中的所有流程，以检查一切是否按预期工作。它还确保系统以统一的方式工作，从而满足业务需求。


### 4、Ribbon和Feign调用服务的区别

**1、** 调用方式同：Ribbon需要我们自己构建Http请求，模拟Http请求然后通过RestTemplate发给其他服务，步骤相当繁琐

**2、** 而Feign则是在Ribbon的基础上进行了一次改进，采用接口的形式，将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 5、服务注册和发现是什么意思？Spring Cloud如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。Eureka服务注册和发现可以在这种情况下提供帮助。由于所有服务都在Eureka服务器上注册并通过调用Eureka服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 6、什么是Hystrix?

Hystrix 是一个延迟和容错库，旨在隔离远程系统，服务和第三方库的访问点，当出现故障是不可避免的故障时，停止级联故障并在复杂的分布式系统中实现弹性。通常对于使用微服务架构开发的系统，涉及到许多微服务，这些微服务彼此协作， 随着微服务数量的增加，这个问题变得更加复杂。我们将使用 Hystrix 的 Fallback 方法来处理，假设由于某种原因，公开的服务接口抛出异常，我们在这种情况下使用 Hystrix 定义一个回退方法。这种后备方法应该具有与公开服务相同的返回类型，如果暴露服务中出现异常，回退方法将返回对应信息。


### 7、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？

WebMvcTest注释用于单元测试Spring MVC应用程序。我们只想启动ToTestController。执行此单元测试时，不会启动所有其他控制器和映射。

```
@WebMvcTest(value = ToTestController.class, secure = false):
```


### 8、DiscoveryClient的作用

可以从注册中心中根据服务别名获取注册的服务器信息。


### 9、Spring Cloud Security

安全工具包，他可以对

**1、** 对Zuul代理中的负载均衡从前端到后端服务中获取SSO令牌

**2、** 资源服务器之间的中继令牌

**3、** 使Feign客户端表现得像`OAuth2RestTemplate`（获取令牌等）的拦截器

**4、** 在Zuul代理中配置下游身份验证

Spring Cloud Security提供了一组原语，用于构建安全的应用程序和服务，而且操作简便。可以在外部（或集中）进行大量配置的声明性模型有助于实现大型协作的远程组件系统，通常具有中央身份管理服务。它也非常易于在Cloud Foundry等服务平台中使用。在SpringBoot和Spring Security OAuth2的基础上，可以快速创建实现常见模式的系统，如单点登录，令牌中继和令牌交换。


### 10、谈谈服务降级、熔断、服务隔离

**1、** 服务降级：当客户端请求服务器端的时候，防止客户端一直等待，不会处理业务逻辑代码，直接返回一个友好的提示给客户端。

**2、** 服务熔断是在服务降级的基础上更直接的一种保护方式，当在一个统计时间范围内的请求失败数量达到设定值（requestVolumeThreshold）或当前的请求错误率达到设定的错误率阈值（errorThresholdPercentage）时开启断路，之后的请求直接走fallback方法，在设定时间（sleepWindowInMilliseconds）后尝试恢复。

**3、** 服务隔离就是Hystrix为隔离的服务开启一个独立的线程池，这样在高并发的情况下不会影响其他服务。服务隔离有线程池和信号量两种实现方式，一般使用线程池方式。


### 11、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 12、REST 和RPC对比
### 13、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 14、合同测试你懂什么？
### 15、什么是客户证书？
### 16、你对SpringBoot有什么了解？
### 17、微服务测试的主要障碍是什么？
### 18、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 19、谈一下领域驱动设计
### 20、如何设计一套API接口
### 21、Spring Cloud和SpringBoot版本对应关系
### 22、服务注册和发现是什么意思？Spring Cloud如何实现？
### 23、为什么在微服务中需要Reports报告和Dashboards仪表板？
### 24、什么是Hystrix？它如何实现容错？
### 25、什么是耦合？
### 26、Spring Cloud Config
### 27、Eureka如何 保证AP
### 28、Spring Cloud Bus
### 29、双因素身份验证的凭据类型有哪些？
### 30、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
