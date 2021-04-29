# Spring最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何在 SpringBoot中禁用 Actuator端点安全性?

默认情况下，所有敏感的HTTP端点都是安全的，只有具有 `http ACTUATOR`角色的用户才能访问它们。安全性是使用标准的 `httpservletrequest. isuserinrole..isusernrole`方法实施的。可以使用 `management. security. enabled= false`来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 2、Spring由哪些模块组成?

以下是Spring 框架的基本模块：

**1、** Core module

**2、** Bean module

**3、** Context module

**4、** Expression Language module

**5、** JDBC module

**6、** ORM module

**7、** OXM module

**8、** Java Messaging Service(JMS) module

**9、** Transaction module

**10、** Web module

**11、** Web-Servlet module

**12、** Web-Struts module

**13、** Web-Portlet module


### 3、什么是WebSockets？

WebSocket是一种计算机通信协议，通过单个TCP连接提供全双工通信信道。

![img_2.png][img_0826_04_2.png]

**1、** WebSocket是双向的 -使用WebSocket客户端或服务器可以发起消息发送。

**2、** WebSocket是全双工的 -客户端和服务器通信是相互独立的。

**3、** 单个TCP连接 -初始连接使用HTTP，然后将此连接升级到基于套接字的连接。然后这个单一连接用于所有未来的通信

**4、** Light -与http相比，WebSocket消息数据交换要轻得多。


### 4、SpringBoot Starter的工作原理

`我个人理解SpringBoot就是由各种Starter组合起来的，我们自己也可以开发Starter`

在sprinBoot启动时由@SpringBootApplication注解会自动去maven中读取每个starter中的spring、factories文件,该文件里配置了所有需要被创建spring容器中的bean，并且进行自动配置把bean注入SpringContext中 //（SpringContext是Spring的配置文件）


### 5、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?

单纯做 SpringBoot 开发，可能不太容易遇到 bootstrap、properties 配置文件，但是在结合 Spring Cloud 时，这个配置就会经常遇到了，特别是在需要加载一些远程配置文件的时侯。

spring boot 核心的两个配置文件：

bootstrap (、 yml 或者 、 properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud 配置就会使用这个文件。且 boostrap 里面的属性不能被覆盖；

application (、 yml 或者 、 properties)： 由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 6、负载均衡的意义是什么?

在计算中，负载均衡可以改善跨计算机，计算机集群，网络链接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载均衡旨在优化资源使用，最大吞吐量，最小响应时间并避免任何单一资源的过载。使用多个组件进行负载均衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载平衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务进程。


### 7、什么是Spring Cloud Bus?

spring cloud bus 将分布式的节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。

如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件。

**使用:**

**1、** 添加依赖

**2、** 配置rabbimq


### 8、Spring Cloud OpenFeign
### 9、微服务测试的主要障碍是什么？
### 10、为什么需要域驱动设计（DDD）？
### 11、什么是服务熔断
### 12、什么是 FreeMarker 模板？
### 13、列举 Spring DAO 抛出的异常。
### 14、SpringBoot、Spring MVC 和 Spring 有什么区别
### 15、SpringBoot事物的使用
### 16、Spring MVC的异常处理？
### 17、Spring支持的ORM
### 18、SpringBoot中的监视器是什么？
### 19、SpringBoot有哪些优点？
### 20、spring JDBC API 中存在哪些类？
### 21、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 22、Spring Cloud OpenFeign
### 23、Spring MVC与Struts2区别
### 24、SpringBoot与SpringCloud 区别
### 25、SpringBoot多数据源拆分的思路
### 26、微服务之间是如何独立通讯的
### 27、Bean 工厂和 Application contexts 有什么区别？
### 28、Spring Cloud Stream
### 29、谈谈服务雪崩效应
### 30、什么是基于注解的容器配置?
### 31、SpringBoot如何配置log4j？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
