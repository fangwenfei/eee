# Spring高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释不同方式的自动装配 。

有五种自动装配的方式，可以用来指导Spring容器用自动装配方式来进行依赖注入。

**1、** no：默认的方式是不进行自动装配，通过显式设置ref 属性来进行装配。

**2、** byName：通过参数名 自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byname，之后容器试图匹配、装配和该bean的属性具有相同名字的bean。

**3、** byType:：通过参数类型自动装配，Spring容器在配置文件中发现bean的autowire属性被设置成byType，之后容器试图匹配、装配和该bean的属性具有相同类型的bean。如果有多个bean符合条件，则抛出错误。

**4、** constructor：这个方式类似于byType， 但是要提供给构造器参数，如果没有确定的带参数的构造器参数类型，将会抛出异常。

**5、** autodetect：首先尝试使用constructor来自动装配，如果无法工作，则使用byType方式。


### 2、什么是耦合和凝聚力？

组件之间依赖关系强度的度量被认为是**耦合**。一个好的设计总是被认为具有**高内聚力和低耦合性**。 面试官经常会问起凝聚力。它也是另一个测量单位。更像是一个模块内部的元素保持结合的程度。 必须记住，设计微服务的一个重要关键是低耦合和高内聚的组合。当低耦合时，服务对其他服务的依赖很少。这样可以保持服务的完整性。在高内聚性中，将所有相关逻辑保存在服务中成为可能。否则，服务将尝试彼此通信，从而影响整体性能。


### 3、spring 中有多少种 IOC 容器？

BeanFactory - BeanFactory 就像一个包含 bean 集合的工厂类。它会在客户端要求时实例化 bean。

ApplicationContext - ApplicationContext 接口扩展了 BeanFactory 接口。它在 BeanFactory 基础上提供了一些额外的功能。


### 4、什么是 Spring Profiles？

Spring Profiles 允许用户根据配置文件（dev，test，prod 等）来注册 bean。因此，当应用程序在开发中运行时，只有某些 bean 可以加载，而在 PRODUCTION中，某些其他 bean 可以加载。假设我们的要求是 Swagger 文档仅适用于 QA 环境，并且禁用所有其他文档。这可以使用配置文件来完成。SpringBoot 使得使用配置文件非常简单。


### 5、如何使用SpringBoot实现异常处理？

Spring提供了一种使用ControllerAdvice处理异常的非常有用的方法。 我们通过实现一个ControlerAdvice类，来处理控制器类抛出的所有异常。


### 6、Spring Cloud和SpringBoot版本对应关系
| Spring Cloud Version | SpringBoot Version |
| --- | --- |
| Hoxton | 2.2.x |
| Greenwich | 2.1.x |
| Finchley | 2.0.x |
| Edgware | 1.5.x |
| Dalston | 1.5.x |



### 7、SpringBoot的配置文件有哪几种格式？区别是什么？

.properties和.yml，它们的区别主要是书写格式不同。yml采取的是缩进的格式 不支持@PerpertySource注解导入配置


### 8、什么是不同类型的双因素身份认证？

执行双因素身份验证需要三种类型的凭据：

**1、** 一件你知道的事情——比如密码、密码或屏幕锁定模式。

**2、** 您拥有的物理凭证，如OTP、电话或ATM卡，换句话说，您在外部或第三方设备中拥有的任何类型的凭证。

**3、** 您的物理身份–如语音认证或生物特征安全，如指纹或眼睛扫描仪。


### 9、如何在 SpringBoot 启动的时候运行一些特定的代码？

可以实现接口 ApplicationRunner 或者 CommandLineRunner，这两个接口实现方式一样，它们都只提供了一个 run 方法，实现上述接口的类加入IOC容器即可生效。


### 10、SpringBoot 有哪些优点？

**SpringBoot 主要有如下优点：**

**1、** 容易上手，提升开发效率，为 Spring 开发提供一个更快、更广泛的入门体验。

**2、** 开箱即用，远离繁琐的配置。

**3、** 提供了一系列大型项目通用的非业务性功能，例如：内嵌服务器、安全管理、运行数据监控、运行状况检查和外部化配置等。

**4、** 没有代码生成，也不需要XML配置。

**5、** 避免大量的 Maven 导入和各种版本冲突。


### 11、RequestMapping 和 GetMapping 的不同之处在哪里？
### 12、Spring Cloud Config
### 13、如何重新加载SpringBoot上的更改，而无需重新启动服务器？
### 14、什么是客户证书？
### 15、什么是切点（JoinPoint）
### 16、SpringBoot常用的starter有哪些？
### 17、SpringBoot 自动配置原理是什么？
### 18、康威定律是什么？
### 19、列举 IoC 的一些好处
### 20、如何配置SpringBoot应用程序日志记录？
### 21、什么是 JavaConfig？
### 22、可以通过多少种方式完成依赖注入？
### 23、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 24、SpringBoot微服务中如何实现 session 共享 ?
### 25、多个消费者调⽤同⼀接⼝，eruka默认的分配⽅式是什么？
### 26、解释对象/关系映射集成模块。
### 27、如果在拦截请求中，我想拦截get方式提交的方法,怎么配置
### 28、微服务架构如何运作？
### 29、微服务之间如何独立通讯的?
### 30、Spring MVC怎么样设定重定向和转发的？
### 31、SpringBoot 2.X 有什么新特性？与 1.X 有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
