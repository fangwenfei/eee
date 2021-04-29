# Spring高级面试题及答案，2021版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、为什么我们需要微服务容器？

要管理基于微服务的应用程序，容器是最简单的选择。它帮助用户单独部署和开发。您还可以使用Docker将微服务封装到容器的镜像中。没有任何额外的依赖或工作，微服务可以使用这些元素。


### 2、Spring MVC常用的注解有哪些？

**1、** @RequestMapping：用于处理请求 url 映射的注解，可用于类或方法上。用于类上，则表示类中的所有响应请求的方法都是以该地址作为父路径。

**2、** @RequestBody：注解实现接收http请求的json数据，将json转换为java对象。

**3、** @ResponseBody：注解实现将conreoller方法返回对象转化为json对象响应给客户。

**4、** @Conntroller：控制器的注解，表示是表现层,不能用用别的注解代替


### 3、解释WEB 模块。

Spring的WEB模块是构建在application context 模块基础之上，提供一个适合web应用的上下文。这个模块也包括支持多种面向web的任务，如透明地处理多个文件上传请求和程序级请求参数的绑定到你的业务对象。它也有对Jakarta Struts的支持。


### 4、SpringBoot 怎么用好自动配置，精髓:

**1、** SpringBoot启动会加载大量的自动配置类

**2、** 我们看我们需要的功能有没有SpringBoot默认写好的自动配置类;

**3、** 我们再来看这个自动配置类中到底配置了哪些组件;(只要我们要用的组件有，我们就不需要再来配置了

**4、** 给容器中自动配置类添加组件的时候，会从properties类中获取某些属性。我们就可以在配置文件中指定这 些属性的值;


### 5、SpringBoot支持什么前端模板，

thymeleaf，freemarker，jsp，官方不推荐JSP会有限制


### 6、运行 SpringBoot 有哪几种方式？

**1、** 打包用命令或者放到容器中运行

**2、** 用 Maven/ Gradle 插件运行

**3、** 直接执行 main 方法运行


### 7、负载平衡的意义什么？

**1、** 简单来说： 先将集群，集群就是把一个的事情交给多个人去做，假如要做1000个产品给一个人做要10天，我叫10个人做就是一天，这就是集群，负载均衡的话就是用来控制集群，他把做的最多的人让他慢慢做休息会，把做的最少的人让他加量让他做多点。

**2、** 在计算中，负载平衡可以改善跨计算机，计算机集群，网络链接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载平衡旨在优化资源使用，最大化吞吐量，最小化响应时间并避免任何单一资源的过载。使用多个组件进行负载平衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载平衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务器进程。


### 8、[@RequestMapping ](/RequestMapping ) 注解
### 9、什么是 Spring Cloud Bus？
### 10、SpringBoot 有哪几种读取配置的方式？
### 11、什么是Spring IOC 容器？
### 12、自动装配有什么局限？
### 13、spring boot扫描流程?
### 14、SpringBoot读取配置文件的方式
### 15、在 Spring中如何注入一个java集合？
### 16、我们如何监视所有 SpringBoot 微服务？
### 17、谈谈服务降级、熔断、服务隔离
### 18、spring DAO 有什么用？
### 19、微服务同时调用多个接口，怎么支持事务的啊？
### 20、微服务有哪些特点？
### 21、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？
### 22、什么是Feign？
### 23、Eureka和ZooKeeper都可以提供服务注册与发现的功能,请说说两个的区别
### 24、康威定律是什么？
### 25、前后端分离，如何维护接口文档 ?
### 26、什么是 AOP什么是引入?
### 27、什么是 SpringBoot Stater ？
### 28、微服务限流 http限流：我们使⽤nginx的limitzone来完成：
### 29、为什么我们需要 spring-boot-maven-plugin?
### 30、Actuator在SpringBoot中的作用
### 31、什么是Spring Cloud？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
