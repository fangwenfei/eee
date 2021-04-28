# Spring高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringCloud 和 Dubbo 有哪些区别?

首先，他们都是分布式管理框架。

dubbo 是二进制传输，占用带宽会少一点。SpringCloud是http 传输，带宽会多一点，同时使用http协议一般会使用JSON报文，消耗会更大。

dubbo 开发难度较大，所依赖的 jar 包有很多问题大型工程无法解决。SpringCloud 对第三方的继承可以一键式生成，天然集成。

SpringCloud 接口协议约定比较松散，需要强有力的行政措施来限制接口无序升级。

最大的区别:


### 2、SpringBoot如何配置log4j？

在引用log4j之前，需要先排除项目创建时候带的日志，因为那个是Logback，然后再引入log4j的依赖，引入依赖之后，去src/main/resources目录下的log4j-spring.properties配置文件，就可以开始对应用的日志进行配置使用。


### 3、微服务之间是如何独立通讯的

**1、** 远程过程调用（Remote Procedure Invocation）：也就是我们常说的服务的注册与发现，直接通过远程过程调用来访问别的service。

**优点：**

简单，常见,因为没有中间件代理，系统更简单

**缺点：**

**1、** 只支持请求/响应的模式，不支持别的，比如通知、请求/异步响应、发布/订阅、发布/异步响应

**2、** 降低了可用性，因为客户端和服务端在请求过程中必须都是可用的

**2、** 消息：使用异步消息来做服务间通信。服务间通过消息管道来交换消息，从而通信。

**优点:**

**1、** 把客户端和服务端解耦，更松耦合

**2、** 提高可用性，因为消息中间件缓存了消息，直到消费者可以消费

**3、** 支持很多通信机制比如通知、请求/异步响应、发布/订阅、发布/异步响应

**缺点:**

消息中间件有额外的复杂


### 4、SpringBoot自动配置的原理

在spring程序main方法中 添加@SpringBootApplication或者@EnableAutoConfiguration

会自动去maven中读取每个starter中的spring.factories文件 该文件里配置了所有需要被创建spring容器中的bean


### 5、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？

path- 这个资源要导出的路径段。

collectionResourceRel- 生成指向集合资源的链接时使用的 rel 值。在生成 HATEOAS 链接时使用。


### 6、什么是 SpringBoot 启动类注解：

@SpringBootConfiguration:SpringBoot的配置类; 标注在某个类上，表示这是一个SpringBoot的配置类; @Configuration:配置类上来标注这个注解;配置类 ----- 配置文件;配置类也是容器中的一个组件;[@Component ](/Component )

@EnableAutoConfiguration:开启自动配置功能;

以前我们需要配置的东西，SpringBoot帮我们自动配置;@EnableAutoConfiguration告诉SpringBoot开启自动配置功能;这样自动配置才能生效;

SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就失效，帮我们进行自动配置工作


### 7、什么是feigin？它的优点是什么？

**1、** feign采用的是基于接口的注解

**2、** feign整合了ribbon，具有负载均衡的能力

**3、** 整合了Hystrix，具有熔断的能力

**使用:**

**1、** 添加pom依赖。

**2、** 启动类添加[@EnableFeignClients ](/EnableFeignClients )

**3、** 定义一个接口@FeignClient(name=“xxx”)指定调用哪个服务


### 8、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 9、前后端分离，如何维护接口文档 ?

前后端分离开发日益流行，大部分情况下，我们都是通过 SpringBoot 做前后端分离开发，前后端分离一定会有接口文档，不然会前后端会深深陷入到扯皮中。一个比较笨的方法就是使用 word 或者 md 来维护接口文档，但是效率太低，接口一变，所有人手上的文档都得变。在 SpringBoot 中，这个问题常见的解决方案是 Swagger ，使用 Swagger 我们可以快速生成一个接口文档网站，接口一旦发生变化，文档就会自动更新，所有开发工程师访问这一个在线网站就可以获取到最新的接口文档，非常方便。


### 10、[@Required ](/Required ) 注解有什么用？

[@Required ](/Required ) 应用于 bean 属性 setter 方法。此注解仅指示必须在配置时使用 bean 定义中的显式属性值或使用自动装配填充受影响的 bean 属性。如果尚未填充受影响的 bean 属性，则容器将抛出 BeanInitializationException。

示例：

```
public class Employee {
    private String name;
    @Required
    public void setName(String name){
        this.name=name;
    }
    public string getName(){
        return name;
    }
}
```


### 11、@PathVariable和@RequestParam的区别
### 12、如何在不使用BasePACKAGE过滤器的情况下排除程序包？
### 13、什么是Spring Batch？
### 14、什么是SpringBoot？
### 15、[@Autowired ](/Autowired ) 注解有什么用？
### 16、如何启用/禁用执行器？
### 17、微服务之间如何独立通讯的?
### 18、SpringBoot、Spring MVC 和 Spring 有什么区别
### 19、为什么人们会犹豫使用微服务？
### 20、你如何理解 SpringBoot 配置加载顺序？
### 21、什么是端到端微服务测试？
### 22、微服务的缺点：
### 23、什么是 AOP切点
### 24、什么是 FreeMarker 模板？
### 25、@RequestMapping注解的作用
### 26、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 27、SpringBoot 有哪些优点？
### 28、如何集成 SpringBoot 和 ActiveMQ？
### 29、你对SpringBoot有什么了解？
### 30、Spring Cloud Netflix
### 31、SpringBoot 有哪几种读取配置的方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
