# SpringBoot最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 Spring Data ?

Spring Data 是 Spring 的一个子项目。用于简化数据库访问，支持NoSQL 和 关系数据存储。其主要目标是使数据库的访问变得方便快捷。Spring Data 具有如下特点：

**SpringData 项目支持 NoSQL 存储：**

**1、** MongoDB （文档数据库）

**2、** Neo4j（图形数据库）

**3、** Redis（键/值存储）

**4、** Hbase（列族数据库）


### 2、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？

配置变更

JDK 版本升级

第三方类库升级

响应式 Spring 编程支持

HTTP/2 支持

配置属性绑定

更多改进与加强…


### 3、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？

启动类上面的注解是@SpringBootApplication，它也是 SpringBoot 的核心注解，主要组合包含了以下 3 个注解：

@SpringBootConfiguration：组合了 [@Configuration ](/Configuration ) 注解，实现配置文件的功能。

@EnableAutoConfiguration：打开自动配置的功能，也可以关闭某个自动配置的选项，如关闭数据源自动配置功能： [@SpringBootApplication(exclude ](/SpringBootApplication(exclude ) = { DataSourceAutoConfiguration.class }。

@ComponentScan：Spring组件扫描


### 4、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的org.springframework.data.domain.Pageable传递给存储库方法。


### 5、SpringBoot Starter 的工作原理是什么？

SpringBoot 在启动的时候会干这几件事情：

**1、** SpringBoot 在启动时会去依赖的 Starter 包中寻找 resources/META-INF/spring.factories 文件，然后根据文件中配置的 Jar 包去扫描项目所依赖的 Jar 包。

**2、** 根据 spring.factories 配置加载 AutoConfigure 类

**3、** 根据 [@Conditional ](/Conditional ) 注解的条件，进行自动配置并将 Bean 注入 Spring Context

总结一下，其实就是 SpringBoot 在启动的时候，按照约定去读取 SpringBoot Starter 的配置信息，再根据配置信息对资源进行初始化，并注入到 Spring 容器中。这样 SpringBoot 启动完毕后，就已经准备好了一切资源，使用过程中直接注入对应 Bean 资源即可。

这只是简单的三连环问答，不知道有多少同学能够完整的回答出来。

其实 SpringBoot 中有很多的技术点可以挖掘，今天给大家整理了十个高频 SpringBoot 面试题，希望可以在后期的面试中帮助到大家。


### 6、SpringBoot 有哪几种读取配置的方式？

SpringBoot 可以通过 @PropertySource,@Value,@Environment, @ConfigurationProperties 来绑定变量


### 7、什么是自动配置？

Spring 和 SpringMVC 的问题在于需要配置大量的参数。

我们能否带来更多的智能？当一个 MVC JAR 添加到应用程序中的时候，我们能否自动配置一些 beans？

Spring 查看（CLASSPATH 上可用的框架）已存在的应用程序的配置。在此基础上，SpringBoot 提供了配置应用程序和框架所需要的基本配置。这就是自动配置。


### 8、SpringBoot 可以兼容老 Spring 项目吗，如何做？

可以兼容，使用 [@ImportResource ](/ImportResource ) 注解导入老 Spring 项目配置文件。


### 9、Spring Initializr 是创建 SpringBoot Projects 的唯一方法吗？

不是的。

Spring Initiatlizr 让创建 SpringBoot 项目变的很容易，但是，你也可以通过设置一个 maven 项目并添加正确的依赖项来开始一个项目。

在我们的 Spring 课程中，我们使用两种方法来创建项目。

第一种方法是 start.spring.io 。

另外一种方法是在项目的标题为“Basic Web Application”处进行手动设置。

手动设置一个 maven 项目

**这里有几个重要的步骤：**

**1、** 在 Eclipse 中，使用文件 - 新建 Maven 项目来创建一个新项目

**2、** 添加依赖项。

**3、** 添加 maven 插件。

**4、** 添加 SpringBoot 应用程序类。

到这里，准备工作已经做好！


### 10、什么是SpringBoot？

用来简化spring应用的初始搭建以及开发过程，使用特定的方式来进行配置（`properties`或`yml`文件）创建独立的spring引用程序 main方法运行，嵌入的Tomcat 无需部署war文件，简化maven配置，自动配置spring添加对应功能starter自动化配置


### 11、SpringBoot 自动配置原理是什么？
### 12、SpringBoot 常用的 Starter 有哪些？
### 13、什么是starter?
### 14、什么是YAML？
### 15、SpringBoot 实现热部署有哪几种方式？
### 16、JPA 和 Hibernate 有哪些区别？
### 17、SpringBoot 实现热部署有哪几种方式？
### 18、SpringBoot的启动器有哪几种?
### 19、SpringBoot 有哪几种读取配置的方式？
### 20、SpringBoot性能如何优化
### 21、YAML 配置的优势在哪里 ?
### 22、RequestMapping 和 GetMapping 的不同之处在哪里？
### 23、SpringBoot 中的 starter 到底是什么 ?
### 24、SpringBoot 自动配置原理是什么？
### 25、如何实现 SpringBoot应用程序的安全性?
### 26、JPA 和 Hibernate 有哪些区别？JPA 可以支持动态 SQL 吗？
### 27、SpringBoot 中如何解决跨域问题 ?
### 28、如何使用 SpringBoot 部署到不同的服务器？
### 29、YAML 配置的优势在哪里 ?
### 30、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？
### 31、SpringBoot Starter的工作原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
