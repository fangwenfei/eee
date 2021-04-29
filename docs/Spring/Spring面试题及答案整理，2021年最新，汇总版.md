# Spring面试题及答案整理，2021年最新，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？

**1、** @Component： 这将 java 类标记为 bean。 它是任何 Spring 管理组件的通用构造型。 spring 的组件扫描机制现在可以将其拾取并将其拉入应用程序环境中。

**2、** @Controller： 这将一个类标记为 Spring Web MVC 控制器。 标有它的 Bean 会自动导入到 IoC 容器中。

**3、** @Service： 此注解是组件注解的特化。 它不会对 [@Component ](/Component ) 注解提供任何其他行为。 您可以在服务层类中使用 [@Service ](/Service ) 而不是 @Component，因为它以更好的方式指定了意图。

**4、** @Repository： 这个注解是具有类似用途和功能的 [@Component ](/Component ) 注解的特化。 它为 DAO 提供了额外的好处。 它将 DAO 导入 IoC 容器，并使未经检查的异常有资格转换为 Spring DataAccessException。


### 2、第⼆层缓存：

readWriteCacheMap，本质上是Guava缓存：此处存放的是最终的缓存， 当服务下线，过期，注册，状态变更，都会来清除这个缓存⾥⾯的数据。 然后通过CacheLoader进⾏缓存加载，在进⾏readWriteCacheMap.get(key)的时候，⾸先看这个缓存⾥⾯有没有该数据，如果没有则通过CacheLoader的load⽅法去加载，加载成功之后将数据放⼊缓存，同时返回数据。 readWriteCacheMap 缓存过期时间，默认为 180 秒 。

#
### 3、[@Required ](/Required ) 注解有什么用？

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


### 4、SpringBoot常用的starter有哪些？

**1、** spring-boot-starter-web 嵌入tomcat和web开发需要servlet与jsp支持

**2、** spring-boot-starter-data-jpa 数据库支持

**3、** spring-boot-starter-data-Redis Redis数据库支持

**4、** spring-boot-starter-data-solr solr支持

**5、** mybatis-spring-boot-starter 第三方的mybatis集成starter


### 5、SpringBoot 中的 starter 到底是什么 ?

首先，这个 Starter 并非什么新的技术点，基本上还是基于 Spring 已有功能来实现的。首先它提供了一个自动化配置类，一般命名为 `XXXAutoConfiguration` ，在这个配置类中通过条件注解来决定一个配置是否生效（条件注解就是 Spring 中原本就有的），然后它还会提供一系列的默认配置，也允许开发者根据实际情况自定义相关配置，然后通过类型安全的属性(spring、factories)注入将这些配置属性注入进来，新注入的属性会代替掉默认属性。正因为如此，很多第三方框架，我们只需要引入依赖就可以直接使用了。当然，开发者也可以自定义 Starter


### 6、什么是 AOP 切点

切入点是一个或一组连接点，通知将在这些位置执行。可以通过表达式或匹配的方式指明切入点。


### 7、什么是 SpringBoot 启动类注解：

@SpringBootConfiguration:SpringBoot的配置类; 标注在某个类上，表示这是一个SpringBoot的配置类; @Configuration:配置类上来标注这个注解;配置类 ----- 配置文件;配置类也是容器中的一个组件;[@Component ](/Component )

@EnableAutoConfiguration:开启自动配置功能;

以前我们需要配置的东西，SpringBoot帮我们自动配置;@EnableAutoConfiguration告诉SpringBoot开启自动配置功能;这样自动配置才能生效;

SpringBoot在启动的时候从类路径下的META-INF/spring.factories中获取EnableAutoConfiguration指定的值，将这些值作为自动配置类导入到容器中，自动配置类就失效，帮我们进行自动配置工作


### 8、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？
### 9、自动装配有哪些局限性 ?
### 10、什么是 WebSockets？
### 11、什么是织入。什么是织入应用的不同点？
### 12、SpringBoot有哪些优点？
### 13、我们可以用微服务创建状态机吗？
### 14、使用 Spring 有哪些方式？
### 15、什么是Spring beans?
### 16、什么是 spring 装配
### 17、什么是JavaConfig？
### 18、SpringBoot 的核心配置文件有哪几个？它们的区别是什么？
### 19、是否可以在Spring boot中更改嵌入式Tomcat服务器的端口?
### 20、你如何理解 SpringBoot 中的 Starters？
### 21、PACT如何运作？
### 22、Spring Framework 有哪些不同的功能？
### 23、如何通过HibernateDaoSupport将Spring和Hibernate结合起来？
### 24、如何使用SpringBoot实现分页和排序？
### 25、如何在 SpringBoot 中禁用 Actuator 端点安全性？
### 26、Spring Cloud Config
### 27、什么是持续监测？
### 28、在 Spring Initializer 中，如何改变一个项目的包名字？
### 29、什么是Eureka的自我保护模式，
### 30、为什么人们会犹豫使用微服务？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
