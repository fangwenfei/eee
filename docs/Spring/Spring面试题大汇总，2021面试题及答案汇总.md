# Spring面试题大汇总，2021面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、列举 IoC 的一些好处。

**IoC 的一些好处是：**

**1、** 它将最小化应用程序中的代码量。

**2、** 它将使您的应用程序易于测试，因为它不需要单元测试用例中的任何单例或 JNDI 查找机制。

**3、** 它以最小的影响和最少的侵入机制促进松耦合。

**4、** 它支持即时的实例化和延迟加载服务。


### 2、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别

ZooKeeper保证的是CP,Eureka保证的是AP，ZooKeeper在选举期间注册服务瘫痪,虽然服务最终会恢复,但是选举期间不可用的。Eureka各个节点是平等关系,只要有一台Eureka就可以保证服务可用,而查询到的数据并不是最新的自我保护机制会导致Eureka不再从注册列表移除因长时间没收到心跳而应该过期的服务。Eureka仍然能够接受新服务的注册和查询请求,但是不会被同步到其他节点(高可用)。当网络稳定时,当前实例新的注册信息会被同步到其他节点中(最终一致性)。Eureka可以很好的应对因网络故障导致部分节点失去联系的情况,而不会像ZooKeeper一样使得整个注册系统瘫痪。

**1、** ZooKeeper有Leader和Follower角色,Eureka各个节点平等

**2、** ZooKeeper采用过半数存活原则,Eureka采用自我保护机制解决分区问题

**3、** Eureka本质上是一个工程,而ZooKeeper只是一个进程


### 3、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?

我们认为 Spring Data Rest 很适合快速原型制造！在大型应用程序中使用需要谨慎。

通过 Spring Data REST 你可以把你的数据实体作为 RESTful 服务直接。

当你设计 RESTful 服务器的时候，最佳实践表明，你的接口应该考虑到两件重要的事情：

你的模型范围。

你的客户。

通过 With Spring Data REST，你不需要再考虑这两个方面，只需要作为 TEST 服务实体。

这就是为什么我们建议使用 Spring Data Rest 在快速原型构造上面，或者作为项目的初始解决方法。对于完整演变项目来说，这并不是一个好的注意。


### 4、如何在SpringBoot应用程序中实现Spring安全性？

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


### 5、为什么我们需要 spring-boot-maven-plugin?

spring-boot-maven-plugin 提供了一些像 jar 一样打包或者运行应用程序的命令。

**1、** spring-boot:run 运行你的 SpringBooty 应用程序。

**2、** spring-boot：repackage 重新打包你的 jar 包或者是 war 包使其可执行

**3、** spring-boot：start 和 spring-boot：stop 管理 SpringBoot 应用程序的生命周期（也可以说是为了集成测试）。

**4、** spring-boot:build-info 生成执行器可以使用的构造信息。


### 6、谈谈服务降级、熔断、服务隔离

**1、** 服务降级：当客户端请求服务器端的时候，防止客户端一直等待，不会处理业务逻辑代码，直接返回一个友好的提示给客户端。

**2、** 服务熔断是在服务降级的基础上更直接的一种保护方式，当在一个统计时间范围内的请求失败数量达到设定值（requestVolumeThreshold）或当前的请求错误率达到设定的错误率阈值（errorThresholdPercentage）时开启断路，之后的请求直接走fallback方法，在设定时间（sleepWindowInMilliseconds）后尝试恢复。

**3、** 服务隔离就是Hystrix为隔离的服务开启一个独立的线程池，这样在高并发的情况下不会影响其他服务。服务隔离有线程池和信号量两种实现方式，一般使用线程池方式。


### 7、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

org.springframework.data.domain.Pageable

传递给存储库方法。


### 8、PACT在微服务架构中的用途是什么？

PACT是一个开源工具，允许测试服务提供者和消费者之间的交互，与合同隔离，从而提高微服务集成的可靠性。

微服务中的用法

用于在微服务中实现消费者驱动的合同。

测试微服务的消费者和提供者之间的消费者驱动的合同。

查看即将到来的批次


### 9、如果在拦截请求中，我想拦截get方式提交的方法,怎么配置



可以在@RequestMapping注解里面加上method=RequestMethod.GET。


### 10、解释AOP

面向切面的编程，或AOP， 是一种编程技术，允许程序模块化横向切割关注点，或横切典型的责任划分，如日志和事务管理。


### 11、什么是 YAML？
### 12、spring bean 容器的生命周期是什么样的？
### 13、服务注册和发现是什么意思？Spring Cloud如何实现？
### 14、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 15、Eureka如何 保证AP
### 16、SpringBoot Starter的工作原理
### 17、SpringBoot常用的starter有哪些?
### 18、如何在 spring 中启动注解装配？
### 19、Spring MVC用什么对象从后台向前台传递数据的？
### 20、我们如何进行跨功能测试？
### 21、什么是 AOP 引入?
### 22、解释Spring框架中bean的生命周期。
### 23、如何理解 Spring 中的代理？
### 24、什么是 Spring IOC 容器？
### 25、Zuul网关如何搭建集群
### 26、[@Qualifier ](/Qualifier ) 注解
### 27、Spring Cloud OpenFeign
### 28、SpringBoot有哪些优点？
### 29、什么是CSRF攻击？
### 30、Ribbon底层实现原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
