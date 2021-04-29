# SpringCloud最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是SpringBoot？

Spring boot是微服务面试问题的主要话题。 随着新功能的加入，Spring变得越来越复杂。无论何时启动新项目，都必须添加新的构建路径或Maven依赖项。简而言之，你需要从头开始做每件事。SpringBoot是一种帮助您避免所有代码配置的解决方案。


### 2、服务雪崩效应产生的原因

因为Tomcat默认情况下只有一个线程池来维护客户端发送的所有的请求，这时候某一接口在某一时刻被大量访问就会占据tomcat线程池中的所有线程，其他请求处于等待状态，无法连接到服务接口。


### 3、微服务的缺点：

**1、** 复杂度⾼：服务调⽤要考虑被调⽤⽅故障、过载、消息丢失等各种异常情况，代码逻辑更加复杂；对于微服务间的事务性操作，因为不同的微服务采⽤了不同的数据库，将⽆法利⽤数据库本身的事务机制保证⼀致性，需要引⼊⼆阶段提交等技术。

**2、** 运维复杂：系统由多个独⽴运⾏的微服务构成，需要⼀个设计良好的监控系统对各个微服务的运⾏状态进⾏监控。运维⼈员需要对系统有细致的了解才对够更好的运维系统。

**3、** 通信延迟：微服务之间调⽤会有时间损耗，造成通信延迟。


### 4、Spring Cloud OpenFeign

Feign是一个声明性的Web服务客户端。它使编写Web服务客户端变得更容易。要使用Feign，我们可以将调用的服务方法定义成抽象方法保存在本地添加一点点注解就可以了，不需要自己构建Http请求了，直接调用接口就行了，不过要注意，调用方法要和本地抽象方法的签名完全一致。


### 5、什么是Eureka

Eureka作为SpringCloud的服务注册功能服务器，他是服务注册中心，系统中的其他服务使用Eureka的客户端将其连接到Eureka Service中，并且保持心跳，这样工作人员可以通过Eureka Service来监控各个微服务是否运行正常。


### 6、为什么需要学习Spring Cloud

**1、** 首先springcloud基于spingboot的优雅简洁，可还记得我们被无数xml支配的恐惧？可还记得springmvc，mybatis错综复杂的配置，有了spingboot，这些东西都不需要了，spingboot好处不再赘诉，springcloud就基于SpringBoot把市场上优秀的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理

**2、** 什么叫做开箱即用？即使是当年的黄金搭档dubbo+zookeeper下载配置起来也是颇费心神的！而springcloud完成这些只需要一个jar的依赖就可以了！

**3、** springcloud大多数子模块都是直击痛点，像zuul解决的跨域，fegin解决的负载均衡，hystrix的熔断机制等等等等


### 7、spring cloud 断路器的作用是什么？

在分布式架构中，断路器模式的作用也是类似的，当某个服务单元发生故障（类似用电器发生短路）之后，通过断路器的故障监控（类似熔断保险丝），向调用方返回一个错误响应，而不是长时间的等待。这样就不会使得线程因调用故障服务被长时间占用不释放，避免了故障在分布式系统中的蔓延。


### 8、什么是服务熔断

如果检查出来频繁超时，就把consumer调⽤provider的请求，直接短路掉，不实际调⽤，⽽是直接返回⼀个mock的值。


### 9、熔断的原理，以及如何恢复？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_11.png#alt=45%5C_11.png)

**服务的健康状况 = 请求失败数 / 请求总数.**

熔断器开关由关闭到打开的状态转换是通过当前服务健康状况和设定阈值⽐较决定的.

**1、** 当熔断器开关关闭时, 请求被允许通过熔断器、如果当前健康状况⾼于设定阈值, 开关继续保持关闭、如果当前健康状况低于设定阈值, 开关则切换为打开状态.

**2、** 当熔断器开关打开时, 请求被禁⽌通过.

**3、** 当熔断器开关处于打开状态, 经过⼀段时间后, 熔断器会⾃动进⼊半开状态, 这时熔断器只允许⼀个请求通过、当该请求调⽤成功时, 熔断器恢复到关闭状态、若该请求失败, 熔断器继续保持打开状态, 接下来的请求被禁⽌通过.

熔断器的开关能保证服务调⽤者在调⽤异常服务时, 快速返回结果, 避免⼤量的同步等待、并且熔断器能在⼀段时间后继续侦测请求执⾏结果, 提供恢复服务调⽤的可能。


### 10、如何实现动态Zuul网关路由转发

通过path配置拦截请求，通过ServiceId到配置中心获取转发的服务列表，Zuul内部使用Ribbon实现本地负载均衡和转发。


### 11、微服务有哪些特点？
### 12、分布式配置中心有那些框架？
### 13、如何设置服务发现？
### 14、什么是Spring Cloud？
### 15、服务网关的作用
### 16、Zuul与Nginx有什么区别？
### 17、微服务之间是如何独⽴通讯的
### 18、Spring Cloud 和dubbo区别?
### 19、22。你能否给出关于休息和微服务的要点？
### 20、微服务的优点
### 21、什么是 Hystrix 断路器？我们需要它吗？
### 22、PACT如何运作？
### 23、Spring Cloud Gateway
### 24、您对微服务有何了解？
### 25、什么是无所不在的语言？
### 26、既然Nginx可以实现网关？为什么还需要使用Zuul框架
### 27、Spring Cloud和SpringBoot版本对应关系
### 28、Spring Cloud Config
### 29、常用网关框架有那些？
### 30、Spring Cloud Sleuth




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
