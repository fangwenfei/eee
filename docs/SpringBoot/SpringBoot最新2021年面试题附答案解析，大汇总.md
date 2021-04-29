# SpringBoot最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Swagger？你用SpringBoot实现了它吗？

Swagger广泛用于可视化API，使用Swagger UI为前端开发人员提供在线沙箱。Swagger是用于生成RESTful Web服务的可视化表示的工具，规范和完整框架实现。它使文档能够以与服务器相同的速度更新。当通过Swagger正确定义时，消费者可以使用最少量的实现逻辑来理解远程服务并与其进行交互。因此，Swagger消除了调用服务时的猜测。


### 2、你如何理解 SpringBoot 配置加载顺序？

在 SpringBoot 里面，可以使用以下几种方式来加载配置。

**1、** properties文件；

**2、** YAML文件；

**3、** 系统环境变量；

**4、** 命令行参数；

等等……


### 3、为什么我们不建议在实际的应用程序中使用 Spring Data Rest?

我们认为 Spring Data Rest 很适合快速原型制造！在大型应用程序中使用需要谨慎。

通过 Spring Data REST 你可以把你的数据实体作为 RESTful 服务直接。

当你设计 RESTful 服务器的时候，最佳实践表明，你的接口应该考虑到两件重要的事情：

你的模型范围。

你的客户。

通过 With Spring Data REST，你不需要再考虑这两个方面，只需要作为 TEST 服务实体。

这就是为什么我们建议使用 Spring Data Rest 在快速原型构造上面，或者作为项目的初始解决方法。对于完整演变项目来说，这并不是一个好的注意。


### 4、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

传递给存储库方法。


### 5、spring boot 核心的两个配置文件：

**1、** bootstrap (.yml 或.properties)：boostrap 由父 ApplicationContext 加载的，比 applicaton 优先加载，配置在应用程序上下文的引导阶段生效。一般来说我们在 Spring Cloud Config 或者 Nacos 中会用到它。且 boostrap 里面的属性不能被覆盖；

**2、** application (. yml 或者 . properties)：由ApplicatonContext 加载，用于 spring boot 项目的自动化配置。


### 6、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

**1、** `@SpringBootConfiguration`：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

**2、** `@EnableAutoConfiguration`：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能。

**3、** `@ComponentScan`：Spring组件扫描。


### 7、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？

因为 SpringBoot 是自动配置的。

**下面是我们添加的依赖项:**

spring-boot-stater-data-jpa 对于 Hibernate 和 JPA 有过渡依赖性。

当 SpringBoot 在类路径中检测到 Hibernate 中，将会自动配置它为默认的 JPA 实现。


### 8、SpringBoot 提供了哪些核心功能？

**1、** 独立运行 Spring 项目

**2、** 内嵌 Servlet 容器

SpringBoot 可以选择内嵌 Tomcat、Jetty 或者 Undertow，这样我们无须以 war 包形式部署项目。

**3、** 提供 Starter 简化 Maven 配置

例如，当你使用了 spring-boot-starter-web ，会自动加入如下依赖：`spring-boot-starter-web` 的 pom 文件

**4、** 自动配置 Spring Bean

SpringBoot 检测到特定类的存在，就会针对这个应用做一定的配置，进行自动配置 Bean ，这样会极大地减少我们要使用的配置。

**5、** 准生产的应用监控

SpringBoot 提供基于 HTTP、JMX、SSH 对运行时的项目进行监控。

**6、** 无代码生成和 XML 配置

SpringBoot 没有引入任何形式的代码生成，它是使用的 Spring 4.0 的条件 [@Condition ](/Condition ) 注解以实现根据条件进行配置。同时使用了 Maven /Gradle 的依赖传递解析机制来实现 Spring 应用里面的自动配置。


### 9、SpringBoot自动配置的原理

在spring程序main方法中 添加@SpringBootApplication或者@EnableAutoConfiguration

会自动去maven中读取每个starter中的spring.factories文件 该文件里配置了所有需要被创建spring容器中的bean


### 10、SpringData 项目所支持的关系数据存储技术：

**1、** JDBC

**2、** JPA

Spring Data Jpa 致力于减少数据访问层 (DAO) 的开发量. 开发者唯一要做的，就是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！Spring Data JPA 通过规范方法的名字，根据符合规范的名字来确定方法需要实现什么样的逻辑。


### 11、什么是 JavaConfig？
### 12、是否可以在SpringBoot中覆盖或替换嵌入式Tomcat？
### 13、Spring 、SpringBoot 和 Spring Cloud 的关系?
### 14、SpringBoot中的监视器是什么？
### 15、SpringBoot 有哪几种读取配置的方式？
### 16、微服务中如何实现 session 共享 ?
### 17、如何实现 SpringBoot 应用程序的安全性？
### 18、spring-boot-starter-parent有什么用？
### 19、你如何理解 SpringBoot 配置加载顺序？
### 20、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 21、什么是Spring Profiles？
### 22、什么是 SpringBoot？
### 23、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 24、为什么我们需要 spring-boot-maven-plugin?
### 25、什么是 WebSockets？
### 26、什么是Apache Kafka？
### 27、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 28、什么是JavaConfig？
### 29、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 30、如何使用 SpringBoot 自动重装我的应用程序？
### 31、SpringBoot 中的 starter 到底是什么 ?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
