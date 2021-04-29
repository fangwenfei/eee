# Spring最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring MVC的主要组件？

**1、** 前端控制器 DispatcherServlet（不需要程序员开发）

**作用：**

接收请求、响应结果，相当于转发器，有了DispatcherServlet 就减少了其它组件之间的耦合度。

**2、** 处理器映射器HandlerMapping（不需要程序员开发）

**作用：**

根据请求的URL来查找Handler

**3、** 处理器适配器HandlerAdapter

**注意：**

在编写Handler的时候要按照HandlerAdapter要求的规则去编写，这样适配器HandlerAdapter才可以正确的去执行Handler。

**4、** 处理器Handler（需要程序员开发）

**5、** 视图解析器 ViewResolver（不需要程序员开发）

**作用：**

进行视图的解析，根据视图逻辑名解析成真正的视图（view）

**6、** 视图View（需要程序员开发jsp）

View是一个接口， 它的实现类支持不同的视图类型（jsp，freemarker，pdf等等）


### 2、spring JDBC API 中存在哪些类？

**1、** JdbcTemplate

**2、** SimpleJdbcTemplate

**3、** NamedParameterJdbcTemplate

**4、** SimpleJdbcInsert

**5、** SimpleJdbcCall



### 3、在使用微服务架构时，您面临哪些挑战？

开发一些较小的微服务听起来很容易，但开发它们时经常遇到的挑战如下。

自动化组件：难以自动化，因为有许多较小的组件。因此，对于每个组件，我们必须遵循Build，Deploy和Monitor的各个阶段。

易感性：将大量组件维护在一起变得难以部署，维护，监控和识别问题。它需要在所有组件周围具有很好的感知能力。

配置管理：有时在各种环境中维护组件的配置变得困难。

调试：很难找到错误的每一项服务。维护集中式日志记录和仪表板以调试问题至关重要。


### 4、什么是凝聚力？

模块内部元素所属的程度被认为是凝聚力。


### 5、[@Qualifier ](/Qualifier ) 注解有什么用？

当您创建多个相同类型的 bean 并希望仅使用属性装配其中一个 bean 时，您可以使用[@Qualifier ](/Qualifier ) 注解和 [@Autowired ](/Autowired ) 通过指定应该装配哪个确切的 bean 来消除歧义。

例如，这里我们分别有两个类，Employee 和 EmpAccount。在 EmpAccount 中，使用[@Qualifier ](/Qualifier ) 指定了必须装配 id 为 emp1 的 bean。

Employee.java

```
public class Employee {
    private String name;
    @Autowired
    public void setName(String name) {
        this.name=name;
    }
    public string getName() {
        return name;
    }
}
```

EmpAccount.java

```
public class EmpAccount {
    private Employee emp;

    @Autowired
    @Qualifier(emp1)
    public void showName() {
        System.out.println(“Employee name : ”+emp.getName);
    }
}
```


### 6、什么是 Hystrix？

在分布式系统，我们一定会依赖各种服务，那么这些个服务一定会出现失败的情况，就会导致雪崩，Hystrix就是这样的一个工具，防雪崩利器，它具有服务降级，服务熔断，服务隔离，监控等一些防止雪崩的技术。

**Hystrix有四种防雪崩方式:**

**1、** 服务降级：接口调用失败就调用本地的方法返回一个空

**2、** 服务熔断：接口调用失败就会进入调用接口提前定义好的一个熔断的方法，返回错误信息

**3、** 服务隔离：隔离服务之间相互影响

**4、** 服务监控：在服务发生调用时,会将每秒请求数、成功请求数等运行指标记录下来。


### 7、什么是 AOP 通知

通知是个在方法执行前或执行后要做的动作，实际上是程序执行时要通过SpringAOP框架触发的代码段。

Spring切面可以应用五种类型的通知：

**1、** before：前置通知，在一个方法执行前被调用。

**2、** after: 在方法执行之后调用的通知，无论方法执行是否成功。

**3、** after-returning: 仅当方法成功完成后执行的通知。

**4、** after-throwing: 在方法抛出异常退出时执行的通知。

**5、** around: 在方法执行之前和之后调用的通知。


### 8、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 9、使⽤中碰到的坑
### 10、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？
### 11、指出在 spring aop 中 concern 和 cross-cutting concern 的不同之处。
### 12、DiscoveryClient的作用
### 13、SpringBoot自动配置的原理是什么？
### 14、什么是 AOP 引入?
### 15、Spring框架中的单例bean是线程安全的吗?
### 16、SpringBoot 中的 starter 到底是什么 ?
### 17、SpringData 项目所支持的关系数据存储技术：
### 18、Spring Framework 有哪些不同的功能？
### 19、dubbo服务注册与发现原理
### 20、什么是依赖注入？
### 21、SpringBoot的缺点
### 22、RequestMapping 和 GetMapping 的不同之处在哪里？
### 23、什么是SpringBoot
### 24、如何禁用特定的自动配置类？
### 25、ApplicationContext通常的实现是什么?
### 26、SpringBoot运行项目的几种方式？
### 27、spring cloud 和dubbo区别?
### 28、您对Mike Cohn的测试金字塔了解多少？
### 29、什么是 AOP 通知
### 30、SpringBoot 如何设置支持跨域请求？
### 31、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
