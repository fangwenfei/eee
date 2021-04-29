# Spring最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、缓存机制：

设置了⼀个每30秒执⾏⼀次的定时任务，定时去服务端获取注册信息。获取之后，存⼊本地内存。


### 2、什么是Spring Initializer?

这个问题并不难，但面试官总是以此测试候选人的专业知识。

Spring Initializer是一个网络应用程序，它可以生成一个SpringBoot项目，包含快速启动所需的一切。和往常一样，我们需要一个好的项目框架；它有助于你正确创建项目结构/框架。


### 3、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 4、如何给静态变量赋值？

SpringBoot无法通过@Value给静态变量赋值

此时需要给当前类加@Component注解，通过set方法设置@Value注解加载set方法上，set方法的参数可以任意命名，不能同属性名，此后当前工具类下的静态方法可直接使用属性值。



### 5、架构师在微服务架构中的角色是什么？

微服务架构中的架构师扮演以下角色：

决定整个软件系统的布局。

帮助确定组件的分区。因此，他们确保组件相互粘合，但不紧密耦合。

与开发人员共同编写代码，了解日常生活中面临的挑战。

为开发微服务的团队提供某些工具和技术的建议。

提供技术治理，以便技术开发团队遵循微服务原则。


### 6、你能否举一个以 ReadOnly 为事务管理的例子？

当你从数据库读取内容的时候，你想把事物中的用户描述或者是其它描述设置为只读模式，以便于 Hebernate 不需要再次检查实体的变化。这是非常高效的。


### 7、什么是 Spring Profiles？

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 8、Spring MVC的控制器是不是单例模式,如果是,有什么问题,怎么解决？

****

是单例模式,所以在多线程访问的时候有线程安全问题,不要用同步,会影响性能的,解决方案是在控制器里面不能写字段。


### 9、运行 SpringBoot 有哪几种方式？

打包用命令或者放到容器中运行

用 Maven/ Gradle 插件运行

直接执行 main 方法运行


### 10、分布式配置中心的作用？

动态变更项目配置信息而不必重新部署项目。


### 11、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 12、项目中前后端分离部署，所以需要解决跨域的问题。
### 13、Spring MVC常用的注解有哪些？
### 14、可以通过多少种方式完成依赖注入？
### 15、使用 Spring 有哪些方式？
### 16、什么是编织（Weaving）？
### 17、SpringBoot有哪些优点？
### 18、什么是网关?
### 19、Spring Cloud Task
### 20、什么是 AOP切点
### 21、SpringBoot 中如何解决跨域问题 ?
### 22、SpringCloud Config 可以实现实时刷新吗？
### 23、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 24、SpringCloud限流：
### 25、SpringBoot 有哪几种读取配置的方式？
### 26、什么是断路器
### 27、什么是 AOP 切点
### 28、[@Autowired ](/Autowired ) 注解有什么用？
### 29、链路跟踪Sleuth
### 30、SpringBoot常用的starter有哪些?
### 31、SpringData 项目所支持的关系数据存储技术：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
