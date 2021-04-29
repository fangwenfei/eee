# Spring最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Netflix Feign？它的优点是什么？

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


### 2、为什么需要学习Spring Cloud

**1、** 首先springcloud基于spingboot的优雅简洁，可还记得我们被无数xml支配的恐惧？可还记得springmvc，mybatis错综复杂的配置，有了spingboot，这些东西都不需要了，spingboot好处不再赘诉，springcloud就基于SpringBoot把市场上优秀的服务框架组合起来，通过SpringBoot风格进行再封装屏蔽掉了复杂的配置和实现原理

**2、** 什么叫做开箱即用？即使是当年的黄金搭档dubbo+zookeeper下载配置起来也是颇费心神的！而springcloud完成这些只需要一个jar的依赖就可以了！

**3、** springcloud大多数子模块都是直击痛点，像zuul解决的跨域，fegin解决的负载均衡，hystrix的熔断机制等等等等


### 3、如果想在拦截的方法里面得到从前台传入的参数,怎么得到？



直接在形参里面声明这个参数就可以,但必须名字和传过来的参数一样。


### 4、什么是有界上下文？

有界上下文是域驱动设计的核心模式。DDD战略设计部门的重点是处理大型模型和团队。DDD通过将大型模型划分为不同的有界上下文并明确其相互关系来处理大型模型。


### 5、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationPropertie注解来绑定变量


### 6、为什么我们需要微服务容器？

要管理基于微服务的应用程序，容器是最简单的选择。它帮助用户单独部署和开发。您还可以使用Docker将微服务封装到容器的镜像中。没有任何额外的依赖或工作，微服务可以使用这些元素。


### 7、你所知道微服务的技术栈有哪些？列举一二

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/010/39/49_2.png#alt=49%5C_2.png)


### 8、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 9、我们如何监视所有 SpringBoot 微服务？

SpringBoot 提供监视器端点以监控各个微服务的度量。这些端点对于获取有关应用程序的信息（如它们是否已启动）以及它们的组件（如数据库等）是否正常运行很有帮助。但是，使用监视器的一个主要缺点或困难是，我们必须单独打开应用程序的知识点以了解其状态或健康状况。想象一下涉及 50 个应用程序的微服务，管理员将不得不击中所有 50 个应用程序的执行终端。为了帮助我们处理这种情况，我们将使用位于的开源项目。它建立在 SpringBoot Actuator 之上，它提供了一个 Web UI，使我们能够可视化多个应用程序的度量。


### 10、spring 中有多少种 IOC 容器？

BeanFactory - BeanFactory 就像一个包含 bean 集合的工厂类。 它会在客户端要求时实例化 bean。

ApplicationContext - ApplicationContext 接口扩展了 BeanFactory 接口。 它在 BeanFactory 基础上提供了一些额外的功能。


### 11、在Spring MVC应用程序中使用WebMvcTest注释有什么用处？
### 12、你可以在Spring中注入一个null 和一个空字符串吗？
### 13、如何配置SpringBoot应用程序日志记录？
### 14、SpringBoot 还提供了其它的哪些 Starter Project Options？
### 15、为什么需要域驱动设计（DDD）？
### 16、什么是 JavaConfig？
### 17、Spring Cloud Netflix
### 18、Spring Cloud OpenFeign
### 19、什么是自动配置？
### 20、我们可以用微服务创建状态机吗？
### 21、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 22、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 23、负载均衡的意义是什么?
### 24、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 25、[@Autowired ](/Autowired ) 注解有什么用？
### 26、什么是耦合和凝聚力？
### 27、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 28、您使用了哪些 starter maven 依赖项？
### 29、什么是 WebSockets？
### 30、运行 SpringBoot 有哪几种方式？
### 31、谈谈服务降级、熔断、服务隔离




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
