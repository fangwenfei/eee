# Spring最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Spring框架中的单例bean是线程安全的吗?

不，Spring框架中的单例bean不是线程安全的。


### 2、什么是spring?

Spring 是个java企业级应用的开源开发框架。Spring主要用来开发Java应用，但是有些扩展是针对构建J2EE平台的web应用。Spring 框架目标是简化Java企业级应用开发，并通过POJO为基础的编程模型促进良好的编程习惯。


### 3、Async异步调用方法

在SpringBoot中使用异步调用是很简单的，只需要在方法上使用@Async注解即可实现方法的异步调用。 注意：需要在启动类加入@EnableAsync使异步调用@Async注解生效。


### 4、前后端分离，如何维护接口文档 ?

前后端分离开发日益流行，大部分情况下，我们都是通过 SpringBoot 做前后端分离开发，前后端分离一定会有接口文档，不然会前后端会深深陷入到扯皮中。一个比较笨的方法就是使用 word 或者 md 来维护接口文档，但是效率太低，接口一变，所有人手上的文档都得变。在 SpringBoot 中，这个问题常见的解决方案是 Swagger ，使用 Swagger 我们可以快速生成一个接口文档网站，接口一旦发生变化，文档就会自动更新，所有开发工程师访问这一个在线网站就可以获取到最新的接口文档，非常方便。


### 5、为什么要用SpringBoot

快速开发，快速整合，配置简化、内嵌服务容器


### 6、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?

SpringBoot 项目最终打包成的 jar 是可执行 jar ，这种 jar 可以直接通过 java -jar xxx.jar 命令来运行，这种 jar 不可以作为普通的 jar 被其他项目依赖，即使依赖了也无法使用其中的类。

SpringBoot 的 jar 无法被其他项目依赖，主要还是他和普通 jar 的结构不同。普通的 jar 包，解压后直接就是包名，包里就是我们的代码，而 SpringBoot 打包成的可执行 jar 解压后，在 \BOOT-INF\classes 目录下才是我们的代码，因此无法被直接引用。如果非要引用，可以在 pom.xml 文件中增加配置，将 SpringBoot 项目打包成两个 jar ，一个可执行，一个可引用。


### 7、什么是SpringBoot？

多年来，随着新功能的增加，spring变得越来越复杂。只需访问https://spring.io/projects 页面，我们就会看到可以在我们的应用程序中使用的所有Spring项目的不同功能。如果必须启动一个新的Spring项目，我们必须添加构建路径或添加Maven依赖关系，配置应用程序服务器，添加spring配置。因此，开始一个新的spring项目需要很多努力，因为我们现在必须从头开始做所有事情。

SpringBoot是解决这个问题的方法。SpringBoot已经建立在现有spring框架之上。使用spring启动，我们避免了之前我们必须做的所有样板代码和配置。因此，SpringBoot可以帮助我们以最少的工作量，更加健壮地使用现有的Spring功能。


### 8、哪种依赖注入方式你建议使用，构造器注入，还是 Setter方法注入？

你两种依赖方式都可以使用，构造器注入和Setter方法注入。最好的解决方案是用构造器参数实现强制依赖，setter方法实现可选依赖。


### 9、使用Spring Cloud有什么优势？

使用SpringBoot开发分布式微服务时，我们面临以下问题

**1、** 与分布式系统相关的复杂性-这种开销包括网络问题，延迟开销，带宽问题，安全问题。

**2、** 服务发现-服务发现工具管理群集中的流程和服务如何查找和互相交谈。它涉及一个服务目录，在该目录中注册服务，然后能够查找并连接到该目录中的服务。

**3、** 冗余-分布式系统中的冗余问题。

**4、** 负载平衡 --负载平衡改善跨多个计算资源的工作负荷，诸如计算机，计算机集群，网络链路，中央处理单元，或磁盘驱动器的分布。

**5、** 性能-问题 由于各种运营开销导致的性能问题。

**6、** 部署复杂性-Devops技能的要求。


### 10、什么是SpringBoot？

用来简化spring应用的初始搭建以及开发过程，使用特定的方式来进行配置（`properties`或`yml`文件）创建独立的spring引用程序 main方法运行，嵌入的Tomcat 无需部署war文件，简化maven配置，自动配置spring添加对应功能starter自动化配置


### 11、什么是持续监测？
### 12、SpringBoot 实现热部署有哪几种方式？
### 13、你能否举一个以 ReadOnly 为事务管理的例子？
### 14、spring boot初始化环境变量流程?
### 15、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？
### 16、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 17、什么是 Spring Data？
### 18、什么是Spring MVC框架的控制器？
### 19、spring cloud 断路器的作用是什么？
### 20、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 21、YAML 配置的优势在哪里 ?
### 22、什么是无所不在的语言？
### 23、使用 SpringBoot 开发分布式微服务时，我们面临什么问题
### 24、spring 提供了哪些配置方式？
### 25、如何重新加载 SpringBoot 上的更改，而无需重新启动服务器？SpringBoot项目如何热部署？
### 26、如何重新加载 SpringBoot上的更改，而无需重新启动服务器？
### 27、什么是 JavaConfig？
### 28、比较一下 Spring Security 和 Shiro 各自的优缺点 ?
### 29、Spring支持的事务管理类型
### 30、如何实现SpringBoot应用程序的安全性？
### 31、spring boot 核心配置文件是什么？bootstrap、properties 和 application、properties 有何区别 ?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
