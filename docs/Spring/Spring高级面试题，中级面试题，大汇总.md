# Spring高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、eureka的缺点：

某个服务不可⽤时，各个Eureka Client不能及时的知道，需要1~3个⼼跳周期才能感知，但是，由于基于Netflix的服务调⽤端都会使⽤Hystrix来容错和降级，当服务调⽤不可⽤时Hystrix也能及时感知到，通过熔断机制来降级服务调⽤，因此弥补了基于客户端服务发现的时效性的缺点。


### 2、介绍一下 WebApplicationContext

WebApplicationContext 继承了ApplicationContext 并增加了一些WEB应用必备的特有功能，它不同于一般的ApplicationContext ，因为它能处理主题，并找到被关联的servlet。




### 3、@PathVariable和@RequestParam的区别

请求路径上有个id的变量值，可以通过@PathVariable来获取 [@RequestMapping(value ](/RequestMapping(value ) = “/page/{id}”, method = RequestMethod.GET)

@RequestParam用来获得静态的URL请求入参 spring注解时action里用到。


### 4、微服务之间如何独立通讯的?

同步通信：dobbo通过 RPC 远程过程调用、springcloud通过 REST 接口json调用 等。

异步：消息队列，如：RabbitMq、ActiveM、Kafka 等。


### 5、[@Required ](/Required ) 注解有什么用？

[@Required ](/Required ) 应用于 bean 属性 setter 方法。 此注解仅指示必须在配置时使用 bean 定义中的显式属性值或使用自动装配填充受影响的 bean 属性。 如果尚未填充受影响的 bean 属性，则容器将抛出 BeanInitializationException。


### 6、SpringCloud有几种调用接口方式

**1、** Feign

**2、** RestTemplate


### 7、什么是Spring beans?

Spring beans 是那些形成Spring应用的主干的java对象。它们被Spring IOC容器初始化，装配，和管理。这些beans通过容器中配置的元数据创建。比如，以XML文件中 的形式定义。

Spring 框架定义的beans都是单件beans。在bean tag中有个属性”singleton”，如果它被赋为TRUE，bean 就是单件，否则就是一个 prototype bean。默认是TRUE，所以所有在Spring框架中的beans 缺省都是单件。


### 8、可以通过多少种方式完成依赖注入？

通常，依赖注入可以通过三种方式完成，即：

**1、** 构造函数注入

**2、** setter 注入

**3、** 接口注入

在 Spring Framework 中，仅使用构造函数和 setter 注入。


### 9、在 Spring中如何注入一个java集合？

Spring提供以下几种集合的配置元素：

**1、** 类型用于注入一列值，允许有相同的值。

**2、**  类型用于注入一组值，不允许有相同的值。

**3、**  类型用于注入一组键值对，键和值都可以为任意类型。

**4、** 类型用于注入一组键值对，键和值都只能为String类型。


### 10、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？

使用DEV工具来实现。 通过这种依赖关系，可以节省任何更改，嵌入式 tomcat将重新启动。 使用SpringBoot有一个开发工具`Dev Tools`模块，可以重新加载 SpringBoot上的更改，而无需重新启动服务器。消除每次手动部署更改的需要。 SpringBoot在发布它的第一个版本时没有这个功能。该模块将在生产环境中被禁用。它还提供H2数据库控制台以更好地测试应用程序。


### 11、第⼆层缓存：
### 12、Spring框架中的单例bean是线程安全的吗?
### 13、Actuator在SpringBoot中的作用
### 14、[@Autowired ](/Autowired ) 注解有什么用？
### 15、什么是耦合？
### 16、SpringBoot 中的 starter 到底是什么 ?
### 17、BeanFactory – BeanFactory 实现举例。
### 18、运行 SpringBoot 有哪几种方式？
### 19、什么是Spring IOC 容器？
### 20、SpringBoot 需要独立的容器运行吗？
### 21、SpringBoot 有哪几种读取配置的方式？
### 22、什么是 FreeMarker 模板？
### 23、怎样开启注解装配？
### 24、什么是 spring 的内部 bean？
### 25、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 26、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 27、什么是基于注解的容器配置?
### 28、什么是 AOP切点
### 29、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 30、springcloud核⼼组件及其作⽤，以及springcloud⼯作原理：
### 31、IOC的优点是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
