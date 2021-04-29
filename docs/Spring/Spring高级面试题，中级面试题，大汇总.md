# Spring高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Spring MVC框架的控制器？

控制器提供一个访问应用程序的行为，此行为通常通过服务接口实现。控制器解析用户输入并将其转换为一个由视图呈现给用户的模型。Spring用一个非常抽象的方式实现了一个控制层，允许用户创建多种用途的控制器。


### 2、eureka的缺点：

某个服务不可⽤时，各个Eureka Client不能及时的知道，需要1~3个⼼跳周期才能感知，但是，由于基于Netflix的服务调⽤端都会使⽤Hystrix来容错和降级，当服务调⽤不可⽤时Hystrix也能及时感知到，通过熔断机制来降级服务调⽤，因此弥补了基于客户端服务发现的时效性的缺点。


### 3、IOC的优点是什么？

IOC 或 依赖注入把应用的代码量降到最低。它使应用容易测试，单元测试不再需要单例和JNDI查找机制。最小的代价和最小的侵入性使松散耦合得以实现。IOC容器支持加载服务时的饿汉式初始化和懒加载。


### 4、如何使用 SpringBoot 生成一个 WAR 文件？

推荐阅读:

[https://spring.io/guides/gs/convert-jar-to-war/](https://spring.io/guides/gs/convert-jar-to-war/)

下面有 spring 说明文档直接的链接地址：

```
https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/#build-tool-plugins-maven-packaging
```


### 5、什么是FreeMarker模板？

FreeMarker是一个基于Java的模板引擎，最初专注于使用MVC软件架构进行动态网页生成。使用Freemarker的主要优点是表示层和业务层的完全分离。程序员可以处理应用程序代码，而设计人员可以处理html页面设计。最后使用freemarker可以将这些结合起来，给出最终的输出页面。


### 6、在使用微服务架构时，您面临哪些挑战？

开发一些较小的微服务听起来很容易，但开发它们时经常遇到的挑战如下。

自动化组件：难以自动化，因为有许多较小的组件。因此，对于每个组件，我们必须遵循Build，Deploy和Monitor的各个阶段。

易感性：将大量组件维护在一起变得难以部署，维护，监控和识别问题。它需要在所有组件周围具有很好的感知能力。

配置管理：有时在各种环境中维护组件的配置变得困难。

调试：很难找到错误的每一项服务。维护集中式日志记录和仪表板以调试问题至关重要。


### 7、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap.properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。


### 8、使用Spring Cloud有什么优势？

使用SpringBoot开发分布式微服务时，我们面临以下问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。

**6、** 部署复杂性-Devops技能的要求。


### 9、列举 Spring DAO 抛出的异常。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_4.png#alt=img%5C_4.png)


### 10、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。为了帮助我们处理这种情况，我们将使用位于的开源项目。 它建立在 SpringBoot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。


### 11、ApplicationContext通常的实现是什么?
### 12、在 Spring中如何注入一个java集合？
### 13、自动装配有哪些局限性 ?
### 14、为什么人们会犹豫使用微服务？
### 15、什么是依赖注入？
### 16、什么是 spring 装配
### 17、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？
### 18、SpringBoot的配置文件有哪几种格式？区别是什么？
### 19、Spring Cache 三种常用的缓存注解和意义？
### 20、什么是feigin？它的优点是什么？
### 21、Spring Cloud Sleuth
### 22、PACT在微服务架构中的用途是什么？
### 23、什么是Spring Cloud？
### 24、什么是Oauth？
### 25、SpringCloud主要项目
### 26、什么是 Hystrix？
### 27、怎么设计无状态服务？
### 28、Spring Cloud Gateway
### 29、微服务架构的优缺点是什么？
### 30、什么是 AOP 通知
### 31、[@Controller ](/Controller ) 注解




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
