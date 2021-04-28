# Spring面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、SpringBoot 的自动配置是如何实现的？

SpringBoot 项目的启动注解是：@SpringBootApplication，其实它就是由下面三个注解组成的：

**1、** [@Configuration ](/Configuration )

**2、** [@ComponentScan ](/ComponentScan )

**3、** @EnableAutoConfiguration

其中 @EnableAutoConfiguration 是实现自动配置的入口，该注解又通过 [@Import ](/Import ) 注解导入了AutoConfigurationImportSelector，在该类中加载 META-INF/spring.factories 的配置信息。然后筛选出以 EnableAutoConfiguration 为 key 的数据，加载到 IOC 容器中，实现自动配置功能！


### 2、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？

path- 这个资源要导出的路径段。

collectionResourceRel- 生成指向集合资源的链接时使用的 rel 值。在生成 HATEOAS 链接时使用。


### 3、创建一个 SpringBoot Project 的最简单的方法是什么？

Spring Initializr是启动 SpringBoot Projects 的一个很好的工具。

**我们需要做一下几步：**

**1、** 登录 Spring Initializr，按照以下方式进行选择：

**2、** 选择 com.in28minutes.SpringBoot 为组

**3、** 选择 studet-services 为组件

**4、** 选择下面的依赖项

Web

Actuator

DevTools

**5、** 点击生 GenerateProject

**6、** 将项目导入 Eclipse。文件 - 导入 - 现有的 Maven 项目


### 4、SpringBoot 实现热部署有哪几种方式？

主要有两种方式：

**1、** Spring Loaded

**2、** Spring-boot-devtools



### 5、什么是 AOP 代理?

代理是通知目标对象后创建的对象。从客户端的角度看，代理对象和目标对象是一样的。


### 6、SpringBoot如何实现打包

进入项目目录在控制台输入mvn clean package，clean是清空已存在的项目包，package进行打包

或者点击左边选项栏中的Mavne，先点击clean在点击package


### 7、Mock或Stub有什么区别？

存根

一个有助于运行测试的虚拟对象。

在某些可以硬编码的条件下提供固定行为。

永远不会测试存根的任何其他行为。

例如，对于空堆栈，您可以创建一个只为empty（）方法返回true的存根。因此，这并不关心堆栈中是否存在元素。

嘲笑

一个虚拟对象，其中最初设置了某些属性。

此对象的行为取决于set属性。

也可以测试对象的行为。

例如，对于Customer对象，您可以通过设置名称和年龄来模拟它。您可以将age设置为12，然后测试isAdult（）方法，该方法将在年龄大于18时返回true。因此，您的Mock Customer对象适用于指定的条件。


### 8、如何给Spring 容器提供配置元数据?

这里有三种重要的方法给Spring 容器提供配置元数据。

**1、** XML配置文件。

**2、** 基于注解的配置。

**3、** 基于java的配置。


### 9、一个Spring的应用看起来象什么？

**1、** 一个定义了一些功能的接口。

**2、** 这实现包括属性，它的Setter ， getter 方法和函数等。

**3、** Spring AOP。

**4、** Spring 的XML 配置文件。

**5、** 使用以上功能的客户端程序。


### 10、什么是耦合？

组件之间依赖关系强度的度量被认为是耦合。一个好的设计总是被认为具有高内聚力和低耦合性。


### 11、解释JDBC抽象和DAO模块。
### 12、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 13、spring JDBC API 中存在哪些类？
### 14、SpringBoot 有哪几种读取配置的方式？
### 15、核心容器（应用上下文) 模块。
### 16、Async异步调用方法
### 17、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 18、在Spring AOP 中，关注点和横切关注的区别是什么？
### 19、过渡到微服务时的常见错误
### 20、Spring AOP and AspectJ AOP 有什么区别？
### 21、使用Spring通过什么方式访问Hibernate?
### 22、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 23、什么是 AOP什么是引入?
### 24、[@Required ](/Required ) 注解有什么用？
### 25、哪些是重要的bean生命周期方法？ 你能重载它们吗？
### 26、eureka和zookeeper都可以提供服务注册与发现的功能，请说说两个的区别？
### 27、DispatcherServlet
### 28、什么是YAML？
### 29、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 30、你更倾向用那种事务管理类型？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
