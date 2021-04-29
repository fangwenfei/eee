# SpringCloud最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、微服务有哪些特点？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_3.png#alt=img%5C_3.png)

图3：微服务的 特点 – 微服务访谈问题

解耦 – 系统内的服务很大程度上是分离的。因此，整个应用程序可以轻松构建，更改和扩展

组件化 – 微服务被视为可以轻松更换和升级的独立组件

业务能力 – 微服务非常简单，专注于单一功能

自治 – 开发人员和团队可以彼此独立工作，从而提高速度

持续交付 – 通过软件创建，测试和批准的系统自动化，允许频繁发布软件

责任 – 微服务不关注应用程序作为项目。相反，他们将应用程序视为他们负责的产品

分散治理 – 重点是使用正确的工具来做正确的工作。这意味着没有标准化模式或任何技术模式。开发人员可以自由选择最有用的工具来解决他们的问题

敏捷 – 微服务支持敏捷开发。任何新功能都可以快速开发并再次丢弃


### 2、springcloud如何实现服务的注册?

**1、** 服务发布时，指定对应的服务名,将服务注册到 注册中心(eureka zookeeper)

**2、** 注册中心加@EnableEurekaServer,服务用@EnableDiscoveryClient，然后用ribbon或feign进行服务直接的调用发现。


### 3、如何在SpringBoot应用程序中实现Spring安全性？

实施需要最少的配置。您需要做的就是spring-boot-starter-security在pom.xml文件中添加starter。您还需要创建一个Spring配置类，它将覆盖所需的方法，同时扩展 WebSecurityConfigurerAdapter 应用程序中的安全性。这是一些示例代码：

```
package com.gkatzioura.security.securityendpoints.config;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;@
Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {@
    Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
        authorizeRequests().
        antMatchers("/welcome").
        permitAll().anyRequest().
        authenticated().and().
        formLogin().
        permitAll().
        and().
        logout().
        permitAll();
    }
}
```


### 4、谈一下领域驱动设计

主要关注核心领域逻辑。基于领域的模型检测复杂设计。这涉及与公司层面领域方面的专家定期合作，以解决与领域相关的问题并改进应用程序的模型。在回答这个微服务面试问题时，您还需要提及DDD的核心基础知识。他们是：

**1、** DDD主要关注领域逻辑和领域本身。

**2、** 复杂的设计完全基于领域的模型。

**3、** 为了改进模型的设计并解决任何新出现的问题，DDD不断与公司领域方面的专家合作。


### 5、SpringCloud限流：

**1、** 我们可以通过semaphore.maxConcurrentRequests,coreSize,maxQueueSize和queueSizeRejectionThreshold设置信号量模式下的最⼤并发量、线程池⼤⼩、缓冲区⼤⼩和缓冲区降级阈值。

```
#不设置缓冲区，当请求数超过coreSize时直接降级
hystrix.threadpool.userThreadPool.maxQueueSize=-1超时时间⼤于我们的timeout接⼝返回时间
hystrix.command.userCommandKey.execution.isolation.thread.timeoutInMilliseconds=15000
```

这个时候我们连续多次请求/user/command/timeout接⼝，在第⼀个请求还没有成功返回时，查看输出⽇志可以发现只有第⼀个请求正常的进⼊到user-service的接⼝中，其它请求会直接返回降级信息。这样我们就实现了对服务请求的限流。

**2、** 漏桶算法：⽔（请求）先进⼊到漏桶⾥，漏桶以⼀定的速度出⽔，当⽔流⼊速度过⼤会直接溢出，可以看出漏桶算法能强⾏限制数据的传输速率。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_7.png#alt=45%5C_7.png)

**3、** 令牌桶算法：除了要求能够限制数据的平均传输速率外，还要求允许某种程度的突发传输。这时候漏桶算法可能就不合适了，令牌桶算法更为适合。 如图所示，令牌桶算法的原理是系统会以⼀个恒定的速度往桶⾥放⼊令牌，⽽如果请求需要被处理，则需要先从桶⾥获取⼀个令牌，当桶⾥没有令牌可取时，则拒绝服务。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_8.png#alt=45%5C_8.png)


### 6、什么是微服务中的反应性扩展？

Reactive Extensions也称为Rx。这是一种设计方法，我们通过调用多个服务来收集结果，然后编译组合响应。这些调用可以是同步或异步，阻塞或非阻塞。Rx是分布式系统中非常流行的工具，与传统流程相反。

希望这些微服务面试问题可以帮助您进行微服务架构师访谈。

翻译来源：[https://www.edureka.co/blog/interview-questions/microservices-interview-questions/](https://www.edureka.co/blog/interview-questions/microservices-interview-questions/)



### 7、什么是Spring Cloud Zuul（服务网关）

Zuul是对SpringCloud提供的成熟对的路由方案，他会根据请求的路径不同，网关会定位到指定的微服务，并代理请求到不同的微服务接口，他对外隐蔽了微服务的真正接口地址。

三个重要概念：动态路由表，路由定位，反向代理：

**1、** 动态路由表：Zuul支持Eureka路由，手动配置路由，这俩种都支持自动更新

**2、** 路由定位：根据请求路径，Zuul有自己的一套定位服务规则以及路由表达式匹配

**3、** 反向代理：客户端请求到路由网关，网关受理之后，在对目标发送请求，拿到响应之后在 给客户端它可以和Eureka,Ribbon,Hystrix等组件配合使用，

**Zuul的应用场景：**

对外暴露，权限校验，服务聚合，日志审计等


### 8、既然Nginx可以实现网关？为什么还需要使用Zuul框架

Zuul是SpringCloud集成的网关，使用Java语言编写，可以对SpringCloud架构提供更灵活的服务。


### 9、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_9.png#alt=45%5C_9.png)

**springcloud由以下⼏个核⼼组件构成：**

**1、** Eureka：各个服务启动时，Eureka Client都会将服务注册到Eureka Server，并且Eureka Client还可以反过来从Eureka Server拉取注册表，从⽽知道其他服务在哪⾥

**2、** Ribbon：服务间发起请求的时候，基于Ribbon做负载均衡，从⼀个服务的多台机器中选择⼀台

**3、** Feign：基于Feign的动态代理机制，根据注解和选择的机器，拼接请求URL地址，发起请求

**4、** Hystrix：发起请求是通过Hystrix的线程池来⾛的，不同的服务⾛不同的线程池，实现了不同服务调⽤的隔离，避免了服务雪崩的问题

**5、** Zuul：如果前端、移动端要调⽤后端系统，统⼀从Zuul⽹关进⼊，由Zuul⽹关转发请求给对应的服务


### 10、为什么需要域驱动设计（DDD）？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_11.png#alt=img%5C_11.png)

图9：我们需要DDD的因素 – 微服务面试问题


### 11、分布式配置中心的作用？
### 12、Spring Cloud和SpringBoot版本对应关系
### 13、springcloud和dubbo有哪些区别
### 14、Spring Cloud 实现服务注册和发现的原理是什么？
### 15、过渡到微服务时的常见错误
### 16、什么是Idempotence以及它在哪里使用？
### 17、谈谈服务雪崩效应
### 18、@LoadBalanced注解的作用
### 19、您对微服务架构中的语义监控有何了解？
### 20、什么是有界上下文？
### 21、微服务的优点
### 22、微服务设计的基础是什么？
### 23、Actuator在SpringBoot中的作用
### 24、什么是客户证书？
### 25、Spring Cloud Gateway
### 26、熔断的原理，以及如何恢复？
### 27、什么是OAuth？
### 28、什么是耦合？
### 29、负载平衡的意义什么？
### 30、你所知道微服务的技术栈有哪些？列举一二




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
