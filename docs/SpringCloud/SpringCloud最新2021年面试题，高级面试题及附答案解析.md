# SpringCloud最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、微服务架构的优缺点是什么？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_6.png#alt=img%5C_6.png)


### 2、您对Mike Cohn的测试金字塔了解多少？

Mike Cohn 提供了一个名为Test Pyramid的模型。这描述了软件开发所需的自动化测试类型。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_19.png#alt=img%5C_19.png)

图16：  Mike Cohn的测试金字塔 – 微服务面试问题

根据金字塔，第一层的测试数量应该最高。在服务层，测试次数应小于单元测试级别，但应大于端到端级别。


### 3、Spring Cloud Security

安全工具包，他可以对

**1、** 对Zuul代理中的负载均衡从前端到后端服务中获取SSO令牌

**2、** 资源服务器之间的中继令牌

**3、** 使Feign客户端表现得像`OAuth2RestTemplate`（获取令牌等）的拦截器

**4、** 在Zuul代理中配置下游身份验证

Spring Cloud Security提供了一组原语，用于构建安全的应用程序和服务，而且操作简便。可以在外部（或集中）进行大量配置的声明性模型有助于实现大型协作的远程组件系统，通常具有中央身份管理服务。它也非常易于在Cloud Foundry等服务平台中使用。在SpringBoot和Spring Security OAuth2的基础上，可以快速创建实现常见模式的系统，如单点登录，令牌中继和令牌交换。


### 4、为什么我们需要微服务容器？

要管理基于微服务的应用程序，容器是最简单的选择。它帮助用户单独部署和开发。您还可以使用Docker将微服务封装到容器的镜像中。没有任何额外的依赖或工作，微服务可以使用这些元素。


### 5、什么是耦合？

组件之间依赖关系强度的度量被认为是耦合。一个好的设计总是被认为具有高内聚力和低耦合性。


### 6、在微服务中，如何保护服务?

一般使用使用Hystrix框架，实现服务隔离来避免出现服务的雪崩效应，从而达到保护服务的效果。当微服务中，高并发的数据库访问量导致服务线程阻塞，使单个服务宕机，服务的不可用会蔓延到其他服务，引起整体服务灾难性后果，使用服务降级能有效为不同的服务分配资源,一旦服务不可用则返回友好提示，不占用其他服务资源，从而避免单个服务崩溃引发整体服务的不可用.


### 7、Zuul网关如何搭建集群

使用Nginx的upstream设置Zuul服务集群，通过location拦截请求并转发到upstream，默认使用轮询机制对Zuul集群发送请求。


### 8、PACT如何运作？

PACT是一个开源工具。它有助于测试消费者和服务提供商之间的互动。消费者服务开发人员首先编写一个测试，该测试定义了与服务提供者的交互模式。测试包括提供者的状态，请求正文和预期的响应。基于此，PACT创建了一个针对其执行测试的存根。输出存储在JSON文件中。


### 9、什么是金丝雀释放？

Canary Releasing是一种降低在生产中引入新软件版本的风险的技术。这是通过将变更缓慢地推广到一小部分用户，然后将其发布到整个基础架构，即将其提供给每个人来完成的。


### 10、Container在微服务中的用途是什么？

容器是管理基于微服务的应用程序以便单独开发和部署它们的好方法。您可以将微服务封装在容器映像及其依赖项中，然后可以使用它来滚动按需实例的微服务，而无需任何额外的工作。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_18.png#alt=img%5C_18.png)

图15： 容器的表示及其在微服务中的使用方式 – 微服务访谈问题


### 11、SpringCloud 和 Dubbo 有哪些区别?
### 12、访问RESTful微服务的方法是什么？
### 13、使用 SpringBoot 开发分布式微服务时，我们面临什么问题
### 14、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 15、Mock或Stub有什么区别？
### 16、您将如何在微服务上执行安全测试？
### 17、什么是客户证书？
### 18、什么是微服务
### 19、Spring Cloud OpenFeign
### 20、Spring Cloud Task
### 21、21、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 22、为什么需要域驱动设计（DDD）？
### 23、服务降级底层是如何实现的？
### 24、什么是Spring Cloud Zuul（服务网关）
### 25、什么是端到端微服务测试？
### 26、Docker的目的是什么？
### 27、你所知道微服务的技术栈有哪些？列举一二
### 28、SpringCloud主要项目
### 29、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 30、我们如何在测试中消除非决定论？
### 31、springcloud和dubbo有哪些区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
