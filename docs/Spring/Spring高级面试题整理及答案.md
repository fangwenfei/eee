# Spring高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、注解原理是什么

注解本质是一个继承了Annotation的特殊接口，其具体实现类是Java运行时生成的动态代理类。我们通过反射获取注解时，返回的是Java运行时生成的动态代理对象。通过代理对象调用自定义注解的方法，会最终调用AnnotationInvocationHandler的invoke方法。该方法会从memberValues这个Map中索引出对应的值。而memberValues的来源是Java常量池。


### 2、什么是基于注解的容器配置

不使用 XML 来描述 bean 装配，开发人员通过在相关的类，方法或字段声明上使用注解将配置移动到组件类本身。它可以作为 XML 设置的替代方案。例如：

Spring 的 Java 配置是通过使用 [@Bean ](/Bean ) 和 [@Configuration ](/Configuration ) 来实现。

[@Bean ](/Bean ) 注解扮演与  元素相同的角色。 [@Configuration ](/Configuration ) 类允许通过简单地调用同一个类中的其他 [@Bean ](/Bean ) 方法来定义 bean 间依赖关系。

例如：

```
@Configuration
public class StudentConfig {
    @Bean
    public StudentBean myStudent() {
        return new StudentBean();
    }
}
```


### 3、如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？



直接在方法中声明这个对象,Spring MVC就自动会把属性赋值到这个对象里面。


### 4、如何使用SpringBoot实现分页和排序？

使用SpringBoot实现分页非常简单。使用Spring Data-JPA可以实现将可分页的

传递给存储库方法。


### 5、有哪些不同类型的IOC（依赖注入）方式？

**1、** 构造器依赖注入：构造器依赖注入通过容器触发一个类的构造器来实现的，该类有一系列参数，每个参数代表一个对其他类的依赖。

**2、** Setter方法注入：Setter方法注入是容器通过调用无参构造器或无参static工厂 方法实例化bean之后，调用该bean的setter方法，即实现了基于setter的依赖注入。


### 6、什么是 JavaConfig？

Spring JavaConfig 是 Spring 社区的产品，Spring 3、0引入了他，它提供了配置 Spring IOC 容器的纯Java 方法。因此它有助于避免使用 XML 配置。使用 JavaConfig 的优点在于：

面向对象的配置。由于配置被定义为 JavaConfig 中的类，因此用户可以充分利用 Java 中的面向对象功能。一个配置类可以继承另一个，重写它的[@Bean ](/Bean ) 方法等。

减少或消除 XML 配置。基于依赖注入原则的外化配置的好处已被证明。但是，许多开发人员不希望在 XML 和 Java 之间来回切换。JavaConfig 为开发人员提供了一种纯 Java 方法来配置与 XML 配置概念相似的 Spring 容器。从技术角度来讲，只使用 JavaConfig 配置类来配置容器是可行的，但实际上很多人认为将JavaConfig 与 XML 混合匹配是理想的。

类型安全和重构友好。JavaConfig 提供了一种类型安全的方法来配置 Spring容器。由于 Java 5、0 对泛型的支持，现在可以按类型而不是按名称检索 bean，不需要任何强制转换或基于字符串的查找。

**常用的Java config：**

@Configuration：在类上打上写下此注解，表示这个类是配置类

@ComponentScan：在配置类上添加 [@ComponentScan ](/ComponentScan ) 注解。该注解默认会扫描该类所在的包下所有的配置类，相当于之前的 <context:component-scan >。

@Bean：bean的注入：相当于以前的< bean id="objectMapper" class="org、codehaus、jackson、map、ObjectMapper" />

@EnableWebMvc：相当于xml的<mvc:annotation-driven >

@ImportResource： 相当于xml的 < import resource="applicationContext-cache、xml">


### 7、什么是 Spring Framework？

**1、** Spring 是一个开源应用框架，旨在降低应用程序开发的复杂度。

**2、** 它是轻量级、松散耦合的。

**3、** 它具有分层体系结构，允许用户选择组件，同时还为 J2EE 应用程序开发提供了一个有凝聚力的框架。

**4、** 它可以集成其他框架，如 Structs、Hibernate、EJB 等，所以又称为框架的框架。


### 8、有哪些不同类型的IOC（依赖注入）方式？
### 9、什么是starter?
### 10、您将如何在微服务上执行安全测试？
### 11、什么是 SpringBoot？
### 12、什么是通知（Advice）？
### 13、Docker的目的是什么？
### 14、我们如何监视所有 SpringBoot 微服务？
### 15、你所知道微服务的技术栈有哪些？列举一二
### 16、[@Qualifier ](/Qualifier ) 注解有什么用？
### 17、解释Spring支持的几种bean的作用域。
### 18、SpringBoot 提供了哪些核心功能？
### 19、SpringBoot和SpringCloud的区别？
### 20、怎么设计无状态服务？
### 21、SpringBoot 自动配置原理
### 22、微服务之间是如何独立通讯的?
### 23、Spring Cloud Gateway
### 24、如何在 SpringBoot 中添加通用的 JS 代码？
### 25、SpringBoot自动配置的原理
### 26、Spring Cloud Netflix(重点，这些组件用的最多)
### 27、使用Spring通过什么方式访问Hibernate?
### 28、SpringBoot Starter 的工作原理是什么？
### 29、什么是 Spring 配置文件？
### 30、什么是 Aspect？
### 31、如何给静态变量赋值？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
