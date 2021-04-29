# Spring最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Zookeeper如何 保证CP

当向注册中⼼查询服务列表时，我们可以容忍注册中⼼返回的是⼏分钟以前的注册信息，但不能接受服务直接down掉不可⽤。也就是说，服务注册功能对可⽤性的要求要⾼于⼀致性。但是zk会出现这样⼀种情况，当master节点因为⽹络故障与其他节点失去联系时，剩余节点会重新进⾏leader选举。问题在于，选举leader的时间太⻓，30 ~ 120s, 且选举期间整个zk集群都是不可⽤的，这就导致在选举期间注册服务瘫痪。在云部署的环境下，因⽹络问题使得zk集群失去master节点是较⼤概率会发⽣的事，虽然服务能够最终恢复，但是漫⻓的选举时间导致的注册⻓期不可⽤是不能容忍的。


### 2、运行 SpringBoot 有哪几种方式？

**1、**  打包用命令或者放到容器中运行

**2、**  用 Maven/ Gradle 插件运行

**3、**  直接执行 main 方法运行


### 3、如何启用/禁用执行器？

启用/禁用致动器很容易；最简单的方法是使特性能够将依赖项(Maven/Gradle)添加到spring-boot-starter-actuator，即启动器。如果不想启用致动器，那么就不要添加依赖项。

Maven依赖项：

```
<dependencies>
    <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
    </dependency>
</dependencies>
```


### 4、什么是 Spring 配置文件？

Spring 配置文件是 XML 文件。该文件主要包含类信息。它描述了这些类是如何配置以及相互引入的。但是，XML 配置文件冗长且更加干净。如果没有正确规划和编写，那么在大项目中管理变得非常困难。


### 5、什么是 AOP什么是引入?

引入允许我们在已存在的类中增加新的方法和属性。


### 6、你怎样定义类的作用域?

当定义一个 在Spring里，我们还能给这个bean声明一个作用域。它可以通过bean 定义中的scope属性来定义。如，当Spring要在需要的时候每次生产一个新的bean实例，bean的scope属性被指定为prototype。另一方面，一个bean每次使用的时候必须返回同一个实例，这个bean的scope 属性 必须设为 singleton。


### 7、Spring Cloud Security

安全工具包，他可以对

**1、** 对Zuul代理中的负载均衡从前端到后端服务中获取SSO令牌

**2、** 资源服务器之间的中继令牌

**3、** 使Feign客户端表现得像`OAuth2RestTemplate`（获取令牌等）的拦截器

**4、** 在Zuul代理中配置下游身份验证

Spring Cloud Security提供了一组原语，用于构建安全的应用程序和服务，而且操作简便。可以在外部（或集中）进行大量配置的声明性模型有助于实现大型协作的远程组件系统，通常具有中央身份管理服务。它也非常易于在Cloud Foundry等服务平台中使用。在SpringBoot和Spring Security OAuth2的基础上，可以快速创建实现常见模式的系统，如单点登录，令牌中继和令牌交换。


### 8、什么是Spring Cloud Bus?

spring cloud bus 将分布式的节点用轻量的消息代理连接起来，它可以用于广播配置文件的更改或者服务直接的通讯，也可用于监控。

如果修改了配置文件，发送一次请求，所有的客户端便会重新读取配置文件。

**使用:**

**1、** 添加依赖

**2、** 配置rabbimq


### 9、RequestMapping 和 GetMapping 的不同之处在哪里？

RequestMapping 具有类属性的，可以进行 GET,POST,PUT 或者其它的注释中具有的请求方法。

GetMapping 是 GET 请求方法中的一个特例。它只是 ResquestMapping 的一个延伸，目的是为了提高清晰度。


### 10、如何在自定义端口上运行 SpringBoot应用程序?

在 `application.properties`中指定端口`serverport=8090`。


### 11、Spring Cloud Gateway
### 12、Spring Framework 中有多少个模块，它们分别是什么？
### 13、什么是不同类型的微服务测试？
### 14、什么是SpringBoot？
### 15、什么是Spring Profiles？
### 16、SpringBoot有哪些优点？
### 17、当 SpringBoot 应用程序作为 Java 应用程序运行时，后台会发生什么？
### 18、[@Autowired ](/Autowired ) 注解
### 19、什么是Apache Kafka？
### 20、什么是Netflix Feign？它的优点是什么？
### 21、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 22、开启 SpringBoot 特性有哪几种方式？
### 23、spring boot监听器流程?
### 24、什么是Swagger？你用SpringBoot实现了它吗？
### 25、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 26、Bean 工厂和 Application contexts 有什么区别？
### 27、如何使用 SpringBoot 实现异常处理？
### 28、RequestMapping 和 GetMapping 的不同之处在哪里？
### 29、哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入？
### 30、分布式配置中心有那些框架？
### 31、SpringBoot 的配置文件有哪几种格式？它们有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
