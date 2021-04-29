# SpringBoot最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？

因为 SpringBoot 是自动配置的。

**下面是我们添加的依赖项:**

spring-boot-stater-data-jpa 对于 Hibernate 和 JPA 有过渡依赖性。

当 SpringBoot 在类路径中检测到 Hibernate 中，将会自动配置它为默认的 JPA 实现。


### 2、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架，但是不管是那种日志框架他都支持将配置文件输出到控制台或者文件中。


### 3、什么是 SpringBoot Stater ？

启动器是一套方便的依赖没描述符，它可以放在自己的程序中。你可以一站式的获取你所需要的 Spring 和相关技术，而不需要依赖描述符的通过示例代码搜索和复制黏贴的负载。

例如，如果你想使用 Sping 和 JPA 访问数据库，只需要你的项目包含 spring-boot-starter-data-jpa 依赖项，你就可以完美进行。


### 4、如何使用 SpringBoot 自动重装我的应用程序？

使用 SpringBoot 开发工具。

把 SpringBoot 开发工具添加进入你的项目是简单的。

把下面的依赖项添加至你的 SpringBoot Project pom.xml 中

重启应用程序，然后就可以了。

同样的，如果你想自动装载页面，有可以看看 FiveReload

```
http://www.logicbig.com/tutorials/spring-framework/spring-boot/boot-live-reload/.
```

在我测试的时候，发现了 LiveReload 漏洞，如果你测试时也发现了，请一定要告诉我们。


### 5、如何在 SpringBoot中禁用 Actuator端点安全性?

默认情况下，所有敏感的HTTP端点都是安全的，只有具有 `http ACTUATOR`角色的用户才能访问它们。安全性是使用标准的 `httpservletrequest. isuserinrole..isusernrole`方法实施的。可以使用 `management. security. enabled= false`来禁用安全性。只有在执行机构端点在防火墙后访问时，才建议禁用安全性。


### 6、保护 SpringBoot 应用有哪些方法？

**1、**  在生产中使用HTTPS

**2、**  使用Snyk检查你的依赖关系

**3、**  升级到最新版本

**4、**  启用CSRF保护

**5、**  使用内容安全策略防止XSS攻击


### 7、什么是 Spring Data？

来自：[//projects.spring.io/spring-](//projects.spring.io/spring-) data/

Spring Data 的使命是在保证底层数据存储特殊性的前提下，为数据访问提供一个熟悉的，一致性的，基于 Spring 的编程模型。这使得使用数据访问技术，关系数据库和非关系数据库，map-reduce 框架以及基于云的数据服务变得很容易。

为了让它更简单一些，Spring Data 提供了不受底层数据源限制的 Abstractions 接口。

你可以定义一简单的库，用来插入，更新，删除和检索代办事项，而不需要编写大量的代码。


### 8、SpringBoot 有哪些优点？
### 9、path=”users”, collectionResourceRel=”users” 如何与 Spring Data Rest 一起使用？
### 10、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 11、RequestMapping 和 GetMapping 的不同之处在哪里？
### 12、SpringBoot需要独立的容器运行？
### 13、spring-boot-starter-parent 有什么用 ?
### 14、SpringBoot 打成的 jar 和普通的 jar 有什么区别 ?
### 15、运行 SpringBoot 有哪几种方式？
### 16、SpringBoot的核心注解是哪个？它主要由哪几个注解组成的？
### 17、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 18、什么是 Apache Kafka？
### 19、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 20、SpringBoot 的配置文件有哪几种格式？它们有什么区别？
### 21、保护 SpringBoot 应用有哪些方法？
### 22、什么是 Swagger？你用 SpringBoot 实现了它吗？
### 23、你如何理解 SpringBoot 配置加载顺序？
### 24、spring boot监听器流程?
### 25、SpringBoot性能如何优化
### 26、什么是 Spring Data REST?
### 27、shiro和oauth还有cas他们之间的关系是什么？问下您公司权限是如何设计，还有就是这几个概念的区别。
### 28、SpringBoot 需要独立的容器运行吗？
### 29、bootstrap.yml和application.yml有什么区别?
### 30、如何给静态变量赋值？
### 31、SpringBoot自动配置的原理是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
