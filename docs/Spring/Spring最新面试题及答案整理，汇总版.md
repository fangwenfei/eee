# Spring最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是耦合？

组件之间依赖关系强度的度量被认为是耦合。一个好的设计总是被认为具有高内聚力和低耦合性。


### 2、SpringBoot 有哪几种读取配置的方式？

- `@PropertySource`
- `@Value`
- `@Environment`
- `@ConfigurationPropertie`


### 3、ZuulFilter常用有那些方法

**1、** Run()：过滤器的具体业务逻辑

**2、** shouldFilter()：判断过滤器是否有效

**3、** filterOrder()：过滤器执行顺序

**4、** filterType()：过滤器拦截位置


### 4、如何覆盖SpringBoot项目的默认属性？

这可以通过在application.properties文件中指定属性来完成。 例如，在Spring MVC应用程序中，您必须指定后缀和前缀。这可以通过在application.properties文件中输入下面提到的属性来完成。

```
对于后缀 - spring.mvc.view.suffix: .jsp
对于前缀 - spring.mvc.view.prefix: /WEB-INF/
```


### 5、Spring Cloud Sleuth

Spring Cloud应用程序的分布式请求链路跟踪，支持使用Zipkin、HTrace和基于日志（例如ELK）的跟踪。


### 6、如何在SpringBoot中禁用Actuator端点安全性？

默认情况下，所有敏感的HTTP端点都是安全的，只有具有ACTUATOR角色的用户才能访问它们。安全性是使用标准的HttpServletRequest.isUserInRole方法实施的。 我们可以使用

来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 7、运行 SpringBoot 有哪几种方式？

**1、** 打包成 Fat Jar ，直接使用 java -jar 运行。目前主流的做法，推荐。

**2、** 在 IDEA 或 Eclipse 中，直接运行应用的 SpringBoot 启动类的 #main(String[] args 启动。适用于开发调试场景。

**3、** 如果是 Web 项目，可以打包成 War 包，使用外部 Tomcat 或 Jetty 等容器。


### 8、什么是 Apache Kafka？
### 9、什么是 spring 的内部 bean？
### 10、什么是Spring Cloud Bus？我们需要它吗？
### 11、spring DAO 有什么用？
### 12、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？
### 13、Nginx与Ribbon的区别
### 14、我们如何进行跨功能测试？
### 15、Spring Cache 三种常用的缓存注解和意义？
### 16、SpringBoot 中如何解决跨域问题 ?
### 17、什么是服务降级
### 18、您对微服务有何了解？
### 19、SpringBoot多数据源事务如何管理
### 20、如何在自定义端口上运行SpringBoot应用程序？
### 21、什么是Idempotence以及它在哪里使用？
### 22、如何在 spring 中启动注解装配？
### 23、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 24、使用 SpringBoot 开发分布式微服务时，我们面临什么问题
### 25、网关的作用是什么
### 26、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 27、服务注册和发现是什么意思？Spring Cloud 如何实现？
### 28、Spring、SpringBoot、SpringMVC的区别？
### 29、spring-boot-starter-parent 有什么用 ?
### 30、如何使用SpringBoot实现异常处理?
### 31、spring bean 容器的生命周期是什么样的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
