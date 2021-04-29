# Spring最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是代理?

代理是通知目标对象后创建的对象。从客户端的角度看，代理对象和目标对象是一样的。


### 2、Ribbon是什么？

**1、** Ribbon是Netflix发布的开源项目，主要功能是提供客户端的软件负载均衡算法

**2、** Ribbon客户端组件提供一系列完善的配置项，如连接超时，重试等。简单的说，就是在配置文件中列出后面所有的机器，Ribbon会自动的帮助你基于某种规则（如简单轮询，随即连接等）去连接这些机器。我们也很容易使用Ribbon实现自定义的负载均衡算法。（有点类似Nginx）


### 3、什么是Spring Initializer?

这个问题并不难，但面试官总是以此测试候选人的专业知识。

Spring Initializer是一个网络应用程序，它可以生成一个SpringBoot项目，包含快速启动所需的一切。和往常一样，我们需要一个好的项目框架；它有助于你正确创建项目结构/框架。


### 4、什么是幂等性?它是如何使用的？

幂等性指的是这样一种场景:您重复执行一项任务，但最终结果保持不变或类似。 幂等性主要用作数据源或远程服务，当它接收一组以上指令时，它只处理一组指令。



### 5、Spring Cloud Consul

Consul 是 HashiCorp 公司推出的开源工具，用于实现分布式系统的服务发现与配置。与其它分布式服务注册与发现的方案，Consul 的方案更“一站式”，内置了服务注册与发现框架、分布一致性协议实现、健康检查、Key/Value 存储、多数据中心方案，不再需要依赖其它工具（比如 ZooKeeper 等）。使用起来也较为简单。Consul 使用 Go 语言编写，因此具有天然可移植性(支持Linux、windows和Mac OS X)；安装包仅包含一个可执行文件，方便部署，与 Docker 等轻量级容器可无缝配合。


### 6、Spring支持的事务管理类型

Spring支持两种类型的事务管理：

**1、** 编程式事务管理：这意味你通过编程的方式管理事务，给你带来极大的灵活性，但是难维护。

**2、** 声明式事务管理：这意味着你可以将业务代码和事务管理分离，你只需用注解和XML配置来管理事务。


### 7、@LoadBalanced注解的作用

开启客户端负载均衡。


### 8、如何使用SpringBoot实现异常处理？

Spring提供了一种使用ControllerAdvice处理异常的非常有用的方法。 我们通过实现一个ControlerAdvice类，来处理控制器类抛出的所有异常。


### 9、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap、properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。

spring boot 核心的两个配置文件：

bootstrap (、 yml 或者 、 properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud 配置就会使用这个文件。且 boostrap 里面的属性不能被覆盖；

application (、 yml 或者 、 properties)： 由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 10、创建一个 SpringBoot Project 的最简单的方法是什么？

Spring Initializer 是创建 SpringBoot Projects 的一个很好的工具


### 11、Spring 应用程序有哪些不同组件？
### 12、合同测试你懂什么？
### 13、spring bean 容器的生命周期是什么样的？
### 14、spring boot初始化环境变量流程?
### 15、有哪些不同类型的IOC（依赖注入）方式？
### 16、什么是Semantic监控？
### 17、解释Spring框架中bean的生命周期。
### 18、[@Autowired ](/Autowired ) 注解有什么用？
### 19、区分构造函数注入和 setter 注入。
### 20、Spring Framework 有哪些不同的功能？
### 21、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 22、Spring Cloud Security
### 23、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 24、有哪些不同类型的IOC（依赖注入）方式？
### 25、SpringBoot有哪些优点？
### 26、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 27、能否举一个例子来解释更多 Staters 的内容？
### 28、[@Required ](/Required ) 注解有什么用？
### 29、什么是 Spring Batch？
### 30、SpringBoot支持什么前端模板，
### 31、解释AOP模块




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
