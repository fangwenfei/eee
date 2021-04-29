# Spring高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何在自定义端口上运行 SpringBoot应用程序?

在 `application.properties`中指定端口`serverport=8090`。


### 2、如何给Spring 容器提供配置元数据?

这里有三种重要的方法给Spring 容器提供配置元数据。

XML配置文件。

基于注解的配置。

基于java的配置。


### 3、什么是金丝雀释放？

Canary Releasing是一种降低在生产中引入新软件版本的风险的技术。这是通过将变更缓慢地推广到一小部分用户，然后将其发布到整个基础架构，即将其提供给每个人来完成的。


### 4、什么是Netflix Feign？它的优点是什么？

Feign是受到Retrofit，JAXRS-2.0和WebSocket启发的java客户端联编程序。Feign的第一个目标是将约束分母的复杂性统一到http apis，而不考虑其稳定性。在employee-consumer的例子中，我们使用了employee-producer使用REST模板公开的REST服务。

但是我们必须编写大量代码才能执行以下步骤

**1、** 使用功能区进行负载平衡。

**2、** 获取服务实例，然后获取基本URL。

**3、** 利用REST模板来使用服务。 前面的代码如下

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
```

之前的代码，有像NullPointer这样的例外的机会，并不是最优的。我们将看到如何使用Netflix Feign使呼叫变得更加轻松和清洁。如果Netflix Ribbon依赖关系也在类路径中，那么Feign默认也会负责负载平衡。


### 5、WebApplicationContext

WebApplicationContext 继承了ApplicationContext 并增加了一些WEB应用必备的特有功能，它不同于一般的ApplicationContext ，因为它能处理主题，并找到被关联的servlet。


### 6、解释对象/关系映射集成模块。

Spring 通过提供ORM模块，支持我们在直接JDBC之上使用一个对象/关系映射映射(ORM)工具，Spring 支持集成主流的ORM框架，如Hiberate,JDO和 iBATIS SQL Maps。Spring的事务管理同样支持以上所有ORM框架及JDBC。


### 7、谈一下领域驱动设计

主要关注核心领域逻辑。基于领域的模型检测复杂设计。这涉及与公司层面领域方面的专家定期合作，以解决与领域相关的问题并改进应用程序的模型。在回答这个微服务面试问题时，您还需要提及DDD的核心基础知识。他们是：

**1、** DDD主要关注领域逻辑和领域本身。

**2、** 复杂的设计完全基于领域的模型。

**3、** 为了改进模型的设计并解决任何新出现的问题，DDD不断与公司领域方面的专家合作。


### 8、什么是JavaConfig？
### 9、什么是 AOP Aspect 切面
### 10、SpringBoot 中如何实现定时任务 ?
### 11、什么是Spring的MVC框架？
### 12、Spring Cloud Config
### 13、微服务的端到端测试意味着什么？
### 14、为什么要使用 Spring Cloud 熔断器？
### 15、什么是 spring bean？
### 16、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 17、@ResponseBody注解的作用
### 18、Spring Cloud Consul
### 19、Spring Cloud Gateway
### 20、为什么要选择微服务架构？
### 21、SpringBoot的配置文件有哪几种格式？区别是什么？
### 22、什么是JavaConfig？
### 23、[@Autowired ](/Autowired ) 注解有什么用？
### 24、区分 BeanFactory 和 ApplicationContext。
### 25、22。你能否给出关于休息和微服务的要点？
### 26、如何设置服务发现？
### 27、SpringBoot 常用的 Starter 有哪些？
### 28、什么是执行器停机？
### 29、如何在自定义端口上运行 SpringBoot 应用程序？
### 30、Container在微服务中的用途是什么？
### 31、什么是Spring Cloud Gateway?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
