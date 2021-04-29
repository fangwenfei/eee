# Spring高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Container在微服务中的用途是什么？

容器是管理基于微服务的应用程序以便单独开发和部署它们的好方法。您可以将微服务封装在容器映像及其依赖项中，然后可以使用它来滚动按需实例的微服务，而无需任何额外的工作。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/01/img_18.png#alt=img%5C_18.png)

图15： 容器的表示及其在微服务中的使用方式 – 微服务访谈问题


### 2、[@Required ](/Required ) 注解有什么用？

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


### 3、Spring Cloud Task

用于快速构建短暂、有限数据处理任务的微服务框架，用于向应用中添加功能性和非功能性的特性。


### 4、YAML 配置的优势在哪里 ?

YAML 现在可以算是非常流行的一种配置文件格式了，无论是前端还是后端，都可以见到 YAML 配置。那么 YAML 配置和传统的 properties 配置相比到底有哪些优势呢？

**1、** 配置有序，在一些特殊的场景下，配置有序很关键

**2、** 支持数组，数组中的元素可以是基本数据类型也可以是对象

3、简洁

相比 properties 配置文件，YAML 还有一个缺点，就是不支持 [@PropertySource ](/PropertySource ) 注解导入自定义的 YAML 配置。


### 5、什么是Spring引导的执行器？

SpringBoot执行程序提供了restful Web服务，以访问生产环境中运行应用程序的当前状态。在执行器的帮助下，您可以检查各种指标并监控您的应用程序。


### 6、可以在SpringBoot application中禁用默认的Web服务器吗？

Spring的主要优势是提供灵活性来构建松散耦合的应用程序。Spring提供了在快速配置中禁用网络服务器的功能。可以使用应用程序属性来配置网络应用程序类型，例如 spring.main.web-application-type=none.


### 7、请描述Spring MVC的工作流程？描述一下 DispatcherServlet 的工作流程？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/042/38/80_1.png#alt=80%5C_1.png)

**1、** 用户发送请求至前端控制器DispatcherServlet；

**2、** DispatcherServlet收到请求后，调用HandlerMapping处理器映射器，请求获取Handle；

**3、** 处理器映射器根据请求url找到具体的处理器，生成处理器对象及处理器拦截器(如果有则生成)一并返回给DispatcherServlet；

**4、** DispatcherServlet 调用 HandlerAdapter处理器适配器；

**5、** HandlerAdapter 经过适配调用 具体处理器(Handler，也叫后端控制器)；

**6、** Handler执行完成返回ModelAndView；

**7、** HandlerAdapter将Handler执行结果ModelAndView返回给DispatcherServlet；

**8、** DispatcherServlet将ModelAndView传给ViewResolver视图解析器进行解析；

**9、** ViewResolver解析后返回具体View；

**10、** DispatcherServlet对View进行渲染视图（即将模型数据填充至视图中）

**11、** DispatcherServlet响应用户。


### 8、什么是SpringBoot？

多年来，随着新功能的增加，spring变得越来越复杂。只需访问https://spring.io/projects 页面，我们就会看到可以在我们的应用程序中使用的所有Spring项目的不同功能。如果必须启动一个新的Spring项目，我们必须添加构建路径或添加Maven依赖关系，配置应用程序服务器，添加spring配置。因此，开始一个新的spring项目需要很多努力，因为我们现在必须从头开始做所有事情。

SpringBoot是解决这个问题的方法。SpringBoot已经建立在现有spring框架之上。使用spring启动，我们避免了之前我们必须做的所有样板代码和配置。因此，SpringBoot可以帮助我们以最少的工作量，更加健壮地使用现有的Spring功能。


### 9、服务注册和发现是什么意思？Spring Cloud 如何实现？

当我们开始一个项目时，我们通常在属性文件中进行所有的配置。随着越来越多的服务开发和部署，添加和修改这些属性变得更加复杂。有些服务可能会下降，而某些位置可能会发生变化。手动更改属性可能会产生问题。 Eureka 服务注册和发现可以在这种情况下提供帮助。由于所有服务都在 Eureka 服务器上注册并通过调用 Eureka 服务器完成查找，因此无需处理服务地点的任何更改和处理。


### 10、哪些是重要的bean生命周期方法？ 你能重载它们吗？

有两个重要的bean 生命周期方法，第一个是setup ， 它是在容器加载bean的时候被调用。第二个方法是 teardown 它是在容器卸载类的时候被调用。

The bean 标签有两个重要的属性（init-method和destroy-method）。用它们你可以自己定制初始化和注销方法。它们也有相应的注解（@PostConstruct和@PreDestroy）。


### 11、SpringBoot 常用的 Starter 有哪些？
### 12、服务降级底层是如何实现的？
### 13、Web，RESTful API在微服务中的作用是什么？
### 14、Spring MVC用什么对象从后台向前台传递数据的？
### 15、SpringBoot中的监视器是什么？
### 16、Spring Cloud Config
### 17、什么是 FreeMarker 模板？
### 18、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？
### 19、SpringBoot 自动配置原理是什么？
### 20、Springboot 有哪些优点？
### 21、[@RequestMapping ](/RequestMapping ) 注解有什么用？
### 22、SpringBoot 如何设置支持跨域请求？
### 23、spring DAO 有什么用？
### 24、微服务之间是如何独立通讯的?
### 25、什么是 Spring Batch？
### 26、spring boot初始化环境变量流程?
### 27、什么是bean装配?
### 28、@ResponseBody注解的作用
### 29、您对Mike Cohn的测试金字塔了解多少？
### 30、SpringBoot 提供了哪些核心功能？
### 31、什么是持续集成（CI）？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
