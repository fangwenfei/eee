# Spring最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么要使用 Spring Cloud 熔断器？

当一个服务调用另一个服务，由于网络原因或者自身原因出现问题时 ，调用者就会等待被调者的响应，当更多的服务请求到这些资源时，导致更多的请求等待，这样就会发生连锁效应，断路器就是解决这一问题的。

**断路器的状态有以下几种：**

**1、** 完全打开：一定时间内，达到一定的次数无法调用，并且多次检测没有恢复的迹象，断路器完全打开，那么下次的请求不会请求到该服务。

**2、** 半开：短时间内有恢复迹象，断路器会将部分请求发送给服务，当能正常调用时，断路器关闭。

**3、** 关闭：服务一直处于正常状态，能正常调用，断路器关闭。


### 2、什么是spring?

Spring 是个java企业级应用的开源开发框架。Spring主要用来开发Java应用，但是有些扩展是针对构建J2EE平台的web应用。Spring 框架目标是简化Java企业级应用开发，并通过POJO为基础的编程模型促进良好的编程习惯。


### 3、SpringBoot 的自动配置是如何实现的？

SpringBoot 项目的启动注解是：@SpringBootApplication，其实它就是由下面三个注解组成的：

**1、** [@Configuration ](/Configuration )

**2、** [@ComponentScan ](/ComponentScan )

**3、** @EnableAutoConfiguration

其中 @EnableAutoConfiguration 是实现自动配置的入口，该注解又通过 [@Import ](/Import ) 注解导入了AutoConfigurationImportSelector，在该类中加载 META-INF/spring.factories 的配置信息。然后筛选出以 EnableAutoConfiguration 为 key 的数据，加载到 IOC 容器中，实现自动配置功能！


### 4、描述一下 DispatcherServlet 的工作流程

DispatcherServlet 的工作流程可以用一幅图来说明：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/02/img_7.png#alt=img%5C_7.png)

**1、** 向服务器发送 HTTP 请求，请求被前端控制器 `DispatcherServlet` 捕获。

**2、**  `DispatcherServlet` 根据 -servlet.xml  中的配置对请求的 URL 进行解析，得到请求资源标识符（URI）。然后根据该 URI，调用 `HandlerMapping` 获得该 Handler 配置的所有相关的对象（包括 Handler 对象以及 Handler 对象对应的拦截器），最后以 `HandlerExecutionChain` 对象的形式返回。

**3、**  `DispatcherServlet` 根据获得的 `Handler`，选择一个合适的 `HandlerAdapter`。（附注：如果成功获得 `HandlerAdapter`后，此时将开始执行拦截器的 preHandler(...)方法）。

**4、** 提取 `Request`中的模型数据，填充 `Handler`入参，开始执行 `Handler`（ `Controller`)。在填充 `Handler`的入参过程中，根据你的配置，Spring 将帮你做一些额外的工作：

**1、** HttpMessageConveter：将请求消息（如 Json、xml 等数据）转换成一个对象，将对象转换为指定的响应信息。

**2、** 数据转换：对请求消息进行数据转换。如 `String`转换成 `Integer`、 `Double`等。

**3、** 数据根式化：对请求消息进行数据格式化。如将字符串转换成格式化数字或格式化日期等。

**4、** 数据验证：验证数据的有效性（长度、格式等），验证结果存储到 `BindingResult`或 `Error`中。

**5、** Handler(Controller)执行完成后，向 `DispatcherServlet` 返回一个 `ModelAndView` 对象；

**6、** 根据返回的 `ModelAndView`，选择一个适合的 `ViewResolver`（必须是已经注册到 Spring 容器中的 `ViewResolver`)返回给 `DispatcherServlet`。

**7、**  `ViewResolver` 结合 `Model`和 `View`，来渲染视图。

**8、** 视图负责将渲染结果返回给客户端。


### 5、缓存机制：

设置了⼀个每30秒执⾏⼀次的定时任务，定时去服务端获取注册信息。获取之后，存⼊本地内存。


### 6、如何解决POST请求中文乱码问题，GET的又如何处理呢？

**解决post请求乱码问题：**

在web.xml中配置一个CharacterEncodingFilter过滤器，设置成utf-8；

```
<filter>
    <filter-name>CharacterEncodingFilter</filter-name>
    <filter-class>org.springframework.web.filter.CharacterEncodingFilter</filter-class>
    <init-param>
        <param-name>encoding</param-name>
        <param-value>utf-8</param-value>
    </init-param>
</filter>
<filter-mapping>
    <filter-name>CharacterEncodingFilter</filter-name>
    <url-pattern>/*</url-pattern>
</filter-mapping>
```

**get请求中文参数出现乱码解决方法有两个：**

修改tomcat配置文件添加编码与工程编码一致，如下：

```
<ConnectorURIEncoding="utf-8" connectionTimeout="20000" port="8080" protocol="HTTP/1.1" redirectPort="8443"/>
```

**另外一种方法对参数进行重新编码：**

String userName = new String(request.getParamter(“userName”).getBytes(“ISO8859-1”),“utf-8”)

ISO8859-1是tomcat默认编码，需要将tomcat编码后的内容按utf-8编码。


### 7、什么是客户证书？

客户端系统用于向远程服务器发出经过身份验证的请求的一种数字证书称为**客户端证书**。客户端证书在许多相互认证设计中起着非常重要的作用，为请求者的身份提供了强有力的保证。


### 8、SpringBoot微服务中如何实现 session 共享 ?

在微服务中，一个完整的项目被拆分成多个不相同的独立的服务，各个服务独立部署在不同的服务器上，各自的 session 被从物理空间上隔离开了，但是经常，我们需要在不同微服务之间共享 session ，常见的方案就是 Spring Session + Redis 来实现 session 共享。将所有微服务的 session 统一保存在 Redis 上，当各个微服务对 session 有相关的读写操作时，都去操作 Redis 上的 session 。这样就实现了 session 共享，Spring Session 基于 Spring 中的代理过滤器实现，使得 session 的同步操作对开发人员而言是透明的，非常简便。


### 9、SpringBoot多数据源事务如何管理

第一种方式是在service层的@TransactionManager中使用transactionManager指定DataSourceConfig中配置的事务

第二种是使用jta-atomikos实现分布式事务管理


### 10、链路跟踪Sleuth

当我们项目中引入Spring Cloud Sleuth后，每次链路请求都会添加一串追踪信息，格式是[server-name, main-traceId,sub-spanId,boolean]：

**1、** server-name：服务结点名称。

**2、** main-traceId：一条链路唯一的ID，为TraceID。

**3、** sub-spanId：链路中每一环的ID，为SpanID。

**4、** boolean：是否将信息输出到Zipkin等服务收集和展示。

Sleuth的实现是基于HTTP的，为了在数据的收集过程中不能影响到正常业务，Sleuth会在每个请求的Header上添加跟踪需求的重要信息。这样在数据收集时，只需要将Header上的相关信息发送给对应的图像工具即可，图像工具根据上传的数据，按照Span对应的逻辑进行分析、展示。



### 11、SpringBoot性能如何优化
### 12、如何在 spring 中启动注解装配？
### 13、Spring Cloud Sleuth
### 14、ZuulFilter常用有那些方法
### 15、SpringBoot 中如何实现定时任务 ?
### 16、什么是SpringBoot
### 17、微服务架构如何运作？
### 18、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 19、如何使用SpringBoot实现分页和排序？
### 20、SpingMvc中的控制器的注解一般用哪个,有没有别的注解可以替代？
### 21、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 22、什么是CSRF攻击？
### 23、Spring MVC中函数的返回值是什么？
### 24、什么是不同类型的微服务测试？
### 25、Spring Cloud Consul
### 26、微服务的端到端测试意味着什么？
### 27、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 28、什么是 AOP什么是目标对象?
### 29、Actuator在SpringBoot中的作用
### 30、什么是 Spring Batch？
### 31、有哪些不同类型的IOC（依赖注入）方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
