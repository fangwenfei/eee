# SpringCloud最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何在SpringBoot应用程序中实现Spring安全性？

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


### 2、为什么要选择微服务架构？

这是一个非常常见的微服务面试问题，你应该准备好了！微服务架构提供了许多优点。这里有几个：

**1、** 微服务可以轻松适应其他框架或技术。

**2、** 单个进程的失败不会影响整个系统。

**3、** 为大企业和小型团队提供支持。

**4、** 可以在相对较短的时间内独立部署。


### 3、Container在微服务中的用途是什么？

容器是管理基于微服务的应用程序以便单独开发和部署它们的好方法。您可以将微服务封装在容器映像及其依赖项中，然后可以使用它来滚动按需实例的微服务，而无需任何额外的工作。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_18.png#alt=img%5C_18.png)

图15： 容器的表示及其在微服务中的使用方式 – 微服务访谈问题


### 4、Ribbon和Feign调用服务的区别

**1、** 调用方式同：Ribbon需要我们自己构建Http请求，模拟Http请求然后通过RestTemplate发给其他服务，步骤相当繁琐

**2、** 而Feign则是在Ribbon的基础上进行了一次改进，采用接口的形式，将我们需要调用的服务方法定义成抽象方法保存在本地就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 5、谈一下领域驱动设计

主要关注核心领域逻辑。基于领域的模型检测复杂设计。这涉及与公司层面领域方面的专家定期合作，以解决与领域相关的问题并改进应用程序的模型。在回答这个微服务面试问题时，您还需要提及DDD的核心基础知识。他们是：

**1、** DDD主要关注领域逻辑和领域本身。

**2、** 复杂的设计完全基于领域的模型。

**3、** 为了改进模型的设计并解决任何新出现的问题，DDD不断与公司领域方面的专家合作。


### 6、为什么需要学习Spring Cloud

**1、** 首先springcloud基于spingboot的优雅简洁，可还记得我们被无数xml支配的恐惧？可还记得springmvc，mybatis错综复杂的配置，有了spingboot，这些东西都不需要了，spingboot好处不再赘诉，springcloud就基于SpringBoot把市场上优秀的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理

**2、** 什么叫做开箱即用？即使是当年的黄金搭档dubbo+zookeeper下载配置起来也是颇费心神的！而springcloud完成这些只需要一个jar的依赖就可以了！

**3、** springcloud大多数子模块都是直击痛点，像zuul解决的跨域，fegin解决的负载均衡，hystrix的熔断机制等等等等


### 7、设计微服务的最佳实践是什么？

以下是设计微服务的最佳实践：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_4.png#alt=img%5C_4.png)

图4：设计微服务的最佳实践 – 微服务访谈问题


### 8、Spring Cloud Sleuth

在微服务中，通常根据业务模块分服务，项目中前端发起一个请求，后端可能跨几个服务调用才能完成这个请求（如下图）。如果系统越来越庞大，服务之间的调用与被调用关系就会变得很复杂，假如一个请求中需要跨几个服务调用，其中一个服务由于网络延迟等原因挂掉了，那么这时候我们需要分析具体哪一个服务出问题了就会显得很困难。Spring Cloud Sleuth服务链路跟踪功能就可以帮助我们快速的发现错误根源以及监控分析每条请求链路上的性能等等。 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/023/45/68_1.png#alt=68%5C_1.png)


### 9、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston | 1.5.x |



### 10、什么是断路器

当一个服务调用另一个服务由于网络原因或自身原因出现问题，调用者就会等待被调用者的响应 当更多的服务请求到这些资源导致更多的请求等待，发生连锁效应（雪崩效应）

**断路器有三种状态**

**1、** 打开状态：一段时间内 达到一定的次数无法调用 并且多次监测没有恢复的迹象 断路器完全打开 那么下次请求就不会请求到该服务

**2、** 半开状态：短时间内 有恢复迹象 断路器会将部分请求发给该服务，正常调用时 断路器关闭

**3、** 关闭状态：当服务一直处于正常状态 能正常调用


### 11、什么是端到端微服务测试？
### 12、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 13、Spring Cloud Bus
### 14、过渡到微服务时的常见错误
### 15、Spring Cloud Stream
### 16、什么是消费者驱动的合同（CDC）？
### 17、Docker的目的是什么？
### 18、Zuul网关如何搭建集群
### 19、SpringBoot和springcloud认识
### 20、什么是无所不在的语言？
### 21、22。你能否给出关于休息和微服务的要点？
### 22、什么是客户证书？
### 23、微服务架构的优缺点是什么？
### 24、什么是服务熔断
### 25、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 26、Spring Cloud OpenFeign
### 27、什么是Netflix Feign？它的优点是什么？
### 28、PACT如何运作？
### 29、什么是Feign？
### 30、负载均衡的意义是什么?
### 31、Spring Cloud 和dubbo区别?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
