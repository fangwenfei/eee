# Spring最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？

在 SpringBoot 项目中，当你确保下面的依赖项都在类路里面的时候，你可以加载 H2 控制台。

web 启动器

h2

jpa 数据启动器

**其它的依赖项在下面：**

需要注意的一些地方：

一个内部数据内存只在应用程序执行期间存在。这是学习框架的有效方式。

这不是你希望的真是世界应用程序的方式。

在问题“如何连接一个外部数据库？”中，我们解释了如何连接一个你所选择的数据库。


### 2、怎样在方法里面得到Request,或者Session？



直接在方法的形参中声明request,Spring MVC就自动把request对象传入。


### 3、运行 SpringBoot 有哪几种方式？

打包用命令或者放到容器中运行

用 Maven/ Gradle 插件运行

直接执行 main 方法运行


### 4、什么是客户证书？

客户端系统用于向远程服务器发出经过身份验证的请求的一种数字证书称为客户端证书。客户端证书在许多相互认证设计中起着非常重要的作用，为请求者的身份提供了强有力的保证。


### 5、Spring Cloud 和dubbo区别?

**1、** 服务调用方式：dubbo是RPC springcloud Rest Api

**2、** 注册中心：dubbo 是zookeeper springcloud是eureka，也可以是zookeeper

**3、** 服务网关，dubbo本身没有实现，只能通过其他第三方技术整合，springcloud有Zuul路由网关，作为路由服务器，进行消费者的请求分发,springcloud支持断路器，与git完美集成配置文件支持版本控制，事物总线实现配置文件的更新与服务自动装配等等一系列的微服务架构要素。


### 6、eureka的缺点：

某个服务不可⽤时，各个Eureka Client不能及时的知道，需要1~3个⼼跳周期才能感知，但是，由于基于Netflix的服务调⽤端都会使⽤Hystrix来容错和降级，当服务调⽤不可⽤时Hystrix也能及时感知到，通过熔断机制来降级服务调⽤，因此弥补了基于客户端服务发现的时效性的缺点。


### 7、[@RequestMapping ](/RequestMapping ) 注解有什么用？

[@RequestMapping ](/RequestMapping ) 注解用于将特定 HTTP 请求方法映射到将处理相应请求的控制器中的特定类/方法。此注释可应用于两个级别：

类级别：映射请求的 URL方法级别：映射 URL 以及 HTTP 请求方法


### 8、spring 中有多少种 IOC 容器？
### 9、spring bean 容器的生命周期是什么样的？
### 10、如何集成SpringBoot和ActiveMQ？
### 11、使用Spring框架的好处是什么？
### 12、什么是Spring Cloud？
### 13、SpringBoot和springcloud认识
### 14、Spring MVC 框架有什么用？
### 15、Eureka怎么实现高可用
### 16、微服务设计的基础是什么？
### 17、微服务有什么特点？
### 18、Ribbon和Feign调用服务的区别
### 19、SpringBoot有哪些优点？
### 20、Spring MVC里面拦截器是怎么写的
### 21、spring 提供了哪些配置方式？
### 22、[@Autowired ](/Autowired ) 注解
### 23、什么是SpringBoot？
### 24、SpringBoot 实现热部署有哪几种方式？
### 25、微服务的优点
### 26、SpringBoot 配置文件的加载顺序
### 27、列举 IoC 的一些好处
### 28、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 29、Spring Cloud Security
### 30、如何设计一套API接口
### 31、spring boot初始化环境变量流程?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
