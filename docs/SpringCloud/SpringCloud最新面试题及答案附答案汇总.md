# SpringCloud最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Hystrix？它如何实现容错？

Hystrix是一个延迟和容错库，旨在隔离远程系统，服务和第三方库的访问点，当出现故障是不可避免的故障时，停止级联故障并在复杂的分布式系统中实现弹性。

通常对于使用微服务架构开发的系统，涉及到许多微服务。这些微服务彼此协作。

思考以下微服务

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_2.png#alt=img%5C_2.png)

假设如果上图中的微服务9失败了，那么使用传统方法我们将传播一个异常。但这仍然会导致整个系统崩溃。

随着微服务数量的增加，这个问题变得更加复杂。微服务的数量可以高达1000.这是hystrix出现的地方 我们将使用Hystrix在这种情况下的Fallback方法功能。我们有两个服务employee-consumer使用由employee-consumer公开的服务。

简化图如下所示

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_3.png#alt=img%5C_3.png)

现在假设由于某种原因，employee-producer公开的服务会抛出异常。我们在这种情况下使用Hystrix定义了一个回退方法。这种后备方法应该具有与公开服务相同的返回类型。如果暴露服务中出现异常，则回退方法将返回一些值。


### 2、微服务限流 dubbo限流：dubbo提供了多个和请求相关的filter：ActiveLimitFilter ExecuteLimitFilter TPSLimiterFilter

**1、** ActiveLimitFilter：

```
@Activate(group = Constants.CONSUMER, value = Constants.ACTIVES_KEY)
```

**作⽤于客户端，主要作⽤是控制客户端⽅法的并发度；**

当超过了指定的active值之后该请求将等待前⾯的请求完成【何时结束呢？依赖于该⽅法的timeout 如果没有设置timeout的话可能就是多个请求⼀直被阻塞然后等待随机唤醒。

**2、** ExecuteLimitFilter：

```
@Activate(group = Constants.PROVIDER, value = Constants.EXECUTES_KEY)
```

作⽤于服务端，⼀旦超出指定的数⽬直接报错 其实是指在服务端的并⾏度【需要注意这些都是指的是在单台服务上⽽不是整个服务集群】

**3、** TPSLimiterFilter：

```
@Activate(group = Constants.PROVIDER, value = Constants.TPS_LIMIT_RATE_KEY)
```

**1、** 作⽤于服务端，控制⼀段时间内的请求数；

**2、** 默认情况下取得tps.interval字段表示请求间隔 如果⽆法找到则使⽤60s 根据tps字段表示允许调⽤次数。

**3、** 使⽤AtomicInteger表示允许调⽤的次数 每次调⽤减少1次当结果⼩于0之后返回不允许调⽤


### 3、什么是Spring Cloud Bus？我们需要它吗？

考虑以下情况：我们有多个应用程序使用Spring Cloud Config读取属性，而Spring Cloud Config从GIT读取这些属性。

下面的例子中多个员工生产者模块从Employee Config Module获取Eureka注册的财产。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_6.png#alt=img%5C_6.png)

如果假设GIT中的Eureka注册属性更改为指向另一台Eureka服务器，会发生什么情况。在这种情况下，我们将不得不重新启动服务以获取更新的属性。

还有另一种使用执行器端点/刷新的方式。但是我们将不得不为每个模块单独调用这个url。例如，如果Employee Producer1部署在端口8080上，则调用 http：// localhost：8080 / refresh。同样对于Employee Producer2 http：// localhost：8081 / refresh等等。这又很麻烦。这就是Spring Cloud Bus发挥作用的地方。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/02/img_7.png#alt=img%5C_7.png)

Spring Cloud Bus提供了跨多个实例刷新配置的功能。因此，在上面的示例中，如果我们刷新Employee Producer1，则会自动刷新所有其他必需的模块。如果我们有多个微服务启动并运行，这特别有用。这是通过将所有微服务连接到单个消息代理来实现的。无论何时刷新实例，此事件都会订阅到侦听此代理的所有微服务，并且它们也会刷新。可以通过使用端点/总线/刷新来实现对任何单个实例的刷新。


### 4、你对SpringBoot有什么了解？

事实上，随着新功能的增加，弹簧变得越来越复杂。如果必须启动新的spring项目，则必须添加构建路径或添加maven依赖项，配置应用程序服务器，添加spring配置。所以一切都必须从头开始。

SpringBoot是解决这个问题的方法。使用spring boot可以避免所有样板代码和配置。因此，基本上认为自己就好像你正在烘烤蛋糕一样，春天就像制作蛋糕所需的成分一样，弹簧靴就是你手中的完整蛋糕。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_12.png#alt=img%5C_12.png)

图10：  SpringBoot的因素 – 微服务面试问题


### 5、REST 和RPC对比

**1、** RPC主要的缺陷是服务提供方和调用方式之间的依赖太强，需要对每一个微服务进行接口的定义，并通过持续继承发布，严格版本控制才不会出现冲突。

**2、** REST是轻量级的接口，服务的提供和调用不存在代码之间的耦合，只需要一个约定进行规范。


### 6、什么是幂等性?它是如何使用的？

幂等性指的是这样一种场景:您重复执行一项任务，但最终结果保持不变或类似。 幂等性主要用作数据源或远程服务，当它接收一组以上指令时，它只处理一组指令。



### 7、22。你能否给出关于休息和微服务的要点？

虽然您可以通过多种方式实现微服务，但REST over HTTP是实现微服务的一种方式。REST还可用于其他应用程序，如Web应用程序，API设计和MVC应用程序，以提供业务数据。

微服务是一种体系结构，其中系统的所有组件都被放入单独的组件中，这些组件可以单独构建，部署和扩展。微服务的某些原则和最佳实践有助于构建弹性应用程序。

简而言之，您可以说REST是构建微服务的媒介。


### 8、Spring Cloud Bus

用于传播集群状态变化的消息总线，使用轻量级消息代理链接分布式系统中的节点，可以用来动态刷新集群中的服务配置。


### 9、微服务之间是如何独立通讯的?

**1、** 远程调用，比如feign调用，直接通过远程过程调用来访问别的service。 2.消息中间件


### 10、微服务限流 http限流：我们使⽤nginx的limitzone来完成：

```
//这个表示使⽤ip进⾏限流 zone名称为req_one 分配了10m 空间使⽤漏桶算法 每秒钟允许1个请求
limit_req_zone $binary_remote_addr zone=req_one:10m rate=1r/s; //这边burst表示可以瞬间超过20个请求 由于没有noDelay参数因此需要排队 如果超过这20个那么直接返回503
limit_req zone=req_three burst=20;
```


### 11、spring cloud 断路器的作用是什么？
### 12、微服务的端到端测试意味着什么？
### 13、什么是REST / RESTful以及它的用途是什么？
### 14、合同测试你懂什么？
### 15、我们可以用微服务创建状态机吗？
### 16、服务雪崩？
### 17、Spring Cloud Stream
### 18、访问RESTful微服务的方法是什么？
### 19、服务注册和发现是什么意思？Spring Cloud如何实现？
### 20、什么是消费者驱动的合同（CDC）？
### 21、SpringCloud 和 Dubbo 有哪些区别?
### 22、什么是 Spring Cloud Bus？
### 23、负载均衡的意义是什么?
### 24、康威定律是什么？
### 25、列举微服务技术栈
### 26、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 27、什么是微服务
### 28、什么是 Hystrix 断路器？我们需要它吗？
### 29、缓存机制：
### 30、Spring Cloud Security




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
