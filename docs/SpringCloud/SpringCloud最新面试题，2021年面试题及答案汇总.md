# SpringCloud最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、为什么需要域驱动设计（DDD）？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_11.png#alt=img%5C_11.png)

图9：我们需要DDD的因素 – 微服务面试问题


### 2、缓存机制：

设置了⼀个每30秒执⾏⼀次的定时任务，定时去服务端获取注册信息。获取之后，存⼊本地内存。


### 3、什么是微服务架构

微服务架构就是将单体的应用程序分成多个应用程序，这多个应用程序就成为微服务，每个微服务运行在自己的进程中，并使用轻量级的机制通信。这些服务围绕业务能力来划分，并通过自动化部署机制来独立部署。这些服务可以使用不同的编程语言，不同数据库，以保证最低限度的集中式管理。


### 4、什么是Netflix Feign？它的优点是什么？

Feign是受到Retrofit，JAXRS-2.0和WebSocket启发的java客户端联编程序。Feign的第一个目标是将约束分母的复杂性统一到http apis，而不考虑其稳定性。在employee-consumer的例子中，我们使用了employee-producer使用REST模板公开的REST服务。

**但是我们必须编写大量代码才能执行以下步骤**

使用功能区进行负载平衡。

获取服务实例，然后获取基本URL。

利用REST模板来使用服务。前面的代码如下

```
@Controller
public class ConsumerControllerClient {
@Autowired
private LoadBalancerClient loadBalancer;

public void getEmployee() throws RestClientException, IOException {

    ServiceInstance serviceInstance=loadBalancer.choose("employee-producer");

    System.out.println(serviceInstance.getUri());

    String baseUrl=serviceInstance.getUri().toString();

    baseUrl=baseUrl+"/employee";

    RestTemplate restTemplate = new RestTemplate();
    ResponseEntity<String> response=null;
    try{
    response=restTemplate.exchange(baseUrl,
            HttpMethod.GET, getHeaders(),String.class);
    }catch (Exception ex)
    {
        System.out.println(ex);
    }
    System.out.println(response.getBody());
}
```

之前的代码，有像NullPointer这样的例外的机会，并不是最优的。我们将看到如何使用Netflix Feign使呼叫变得更加轻松和清洁。如果Netflix Ribbon依赖关系也在类路径中，那么Feign默认也会负责负载平衡。


### 5、什么是领域驱动设计？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_10.png#alt=img%5C_10.png)

图8：  DDD原理 – 微服务面试问题


### 6、第⼀层缓存：

readOnlyCacheMap，本质上是ConcurrentHashMap：这是⼀个JVM的CurrentHashMap只读缓存，这个主要是为了供客户端获取注册信息时使⽤，其缓存更新，依赖于定时器的更新，通过和readWriteCacheMap 的值做对⽐，如果数据不⼀致，则以readWriteCacheMap 的数据为准。readOnlyCacheMap 缓存更新的定时器时间间隔，默认为30秒

#
### 7、什么是微服务

**1、** 微服务是⼀种架构⻛格，也是⼀种服务；

**2、** 微服务的颗粒⽐较⼩，⼀个⼤型复杂软件应⽤由多个微服务组成，⽐如Netflix⽬前由500多的微服务组成；

**3、** 它采⽤UNIX设计的哲学，每种服务只做⼀件事，是⼀种松耦合的能够被独⽴开发和部署的⽆状态化服务（独⽴扩展、升级和可替换）。


### 8、Spring Cloud Zookeeper

基于Apache Zookeeper的服务治理组件。


### 9、在使用微服务架构时，您面临哪些挑战？

开发一些较小的微服务听起来很容易，但开发它们时经常遇到的挑战如下。

自动化组件：难以自动化，因为有许多较小的组件。因此，对于每个组件，我们必须遵循Build，Deploy和Monitor的各个阶段。

易感性：将大量组件维护在一起变得难以部署，维护，监控和识别问题。它需要在所有组件周围具有很好的感知能力。

配置管理：有时在各种环境中维护组件的配置变得困难。

调试：很难找到错误的每一项服务。维护集中式日志记录和仪表板以调试问题至关重要。


### 10、Eureka怎么实现高可用

集群吧，注册多台Eureka，然后把SpringCloud服务互相注册，客户端从Eureka获取信息时，按照Eureka的顺序来访问。


### 11、什么是有界上下文？
### 12、Spring Cloud Netflix(重点，这些组件用的最多)
### 13、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 14、什么是Spring Cloud Gateway?
### 15、Spring Cloud Consul
### 16、SpringCloud由什么组成
### 17、Spring Cloud 实现服务注册和发现的原理是什么？
### 18、微服务架构的优缺点是什么？
### 19、什么是Feign？
### 20、微服务有什么特点？
### 21、为什么人们会犹豫使用微服务？
### 22、什么是Spring引导的执行器？
### 23、什么是 Hystrix？
### 24、微服务架构如何运作？
### 25、Spring Cloud Netflix
### 26、什么是双因素身份验证？
### 27、您对Mike Cohn的测试金字塔了解多少？
### 28、SpringCloud限流：
### 29、微服务架构有哪些优势？
### 30、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
