# SpringBoot最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是 Spring Profiles？

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 2、SpringData 项目所支持的关系数据存储技术：

**1、** JDBC

**2、** JPA

Spring Data Jpa 致力于减少数据访问层 (DAO) 的开发量. 开发者唯一要做的，就是声明持久层的接口，其他都交给 Spring Data JPA 来帮你完成！Spring Data JPA 通过规范方法的名字，根据符合规范的名字来确定方法需要实现什么样的逻辑。


### 3、SpringBoot常用的starter有哪些？

**1、** spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、** spring-boot-starter-data-jpa 数据库支持

**3、** spring-boot-starter-data-Redis Redis数据库支持

**4、** spring-boot-starter-data-solr solr支持

**5、** mybatis-spring-boot-starter 第三方的mybatis集成starter


### 4、SpringBoot 中如何解决跨域问题 ?

跨域可以在前端通过 JSONP 来解决，但是 JSONP 只可以发送 GET 请求，无法发送其他类型的请求，在 RESTful 风格的应用中，就显得非常鸡肋，因此我们推荐在后端通过 （CORS，Cross-origin resource sharing） 来解决跨域问题。这种解决方案并非 SpringBoot 特有的，在传统的 SSM 框架中，就可以通过 CORS 来解决跨域问题，只不过之前我们是在 XML 文件中配置 CORS ，现在可以通过实现WebMvcConfigurer接口然后重写addCorsMappings方法解决跨域问题。

[@Configuration ](/Configuration )

public class CorsConfig implements WebMvcConfigurer {

```
@Override
public void addCorsMappings(CorsRegistry registry) {
    registry.addMapping("/**")
            .allowedOrigins("*")
            .allowCredentials(true)
            .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
            .maxAge(3600);
}
```

}


### 5、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?

思考一下在你的虚拟机上部署应用程序需要些什么。

**第一步：**安装 Java

**第二步：**安装 Web 或者是应用程序的服务器（Tomat/Wbesphere/Weblogic 等等）

**第三步：**部署应用程序 war 包

如果我们想简化这些步骤，应该如何做呢？

让我们来思考如何使服务器成为应用程序的一部分？

你只需要一个安装了 Java 的虚拟机，就可以直接在上面部署应用程序了，

这个想法是嵌入式服务器的起源。

当我们创建一个可以部署的应用程序的时候，我们将会把服务器（例如，tomcat）嵌入到可部署的服务器中。

例如，对于一个 SpringBoot 应用程序来说，你可以生成一个包含 Embedded Tomcat 的应用程序 jar。你就可以想运行正常 Java 应用程序一样来运行 web 应用程序了。

嵌入式服务器就是我们的可执行单元包含服务器的二进制文件（例如，tomcat.jar）。


### 6、什么是YAML?

YAML是一种人类可读的数据序列化语言。它通常用于`配置文件`。 与属性文件相比，如果我们想要在配置文件中添加复杂的属性，YAML文件就更加结构化，而且更少混淆。可以看出YAML具有`分层配置数据`。


### 7、SpringBoot 中的 starter 到底是什么 ?

首先，这个 Starter 并非什么新的技术点，基本上还是基于 Spring 已有功能来实现的。首先它提供了一个自动化配置类，一般命名为 `XXXAutoConfiguration` ，在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，然后通过类型安全的属性(spring、factories)注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。正因为如此，很多第三方框架，我们只需要引入依赖就可以直接使用了。当然，开发者也可以自定义 Starter


### 8、使用 SpringBoot 启动连接到内存数据库 H2 的 JPA 应用程序需要哪些依赖项？
### 9、各服务之间通信，对Restful和Rpc这2种方式如何做选择？
### 10、SpringBoot 中如何实现定时任务 ?
### 11、如何使用 SpringBoot 生成一个 WAR 文件？
### 12、spring boot 核心的两个配置文件：
### 13、微服务同时调用多个接口，怎么支持事务的啊？
### 14、微服务中如何实现 session 共享 ?
### 15、SpringBoot 如何设置支持跨域请求？
### 16、SpringBoot 2、X 有什么新特性？与 1、X 有什么区别？
### 17、什么是CSRF攻击？
### 18、如何在 SpringBoot 启动的时候运行一些特定的代码？
### 19、SpringBoot读取配置文件的方式
### 20、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 21、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 22、什么是JavaConfig？
### 23、创建一个 SpringBoot Project 的最简单的方法是什么？
### 24、SpringBoot 有哪几种读取配置的方式？
### 25、SpringBoot 是否可以使用 XML 配置 ?
### 26、spring boot初始化环境变量流程?
### 27、JPA 和 Hibernate 有哪些区别？
### 28、SpringBoot 配置加载顺序?
### 29、什么是嵌入式服务器？我们为什么要使用嵌入式服务器呢?
### 30、Springboot 有哪些优点？
### 31、什么是Spring Batch？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
