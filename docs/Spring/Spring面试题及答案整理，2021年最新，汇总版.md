# Spring面试题及答案整理，2021年最新，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring由哪些模块组成?

以下是Spring 框架的基本模块：

**1、** Core module

**2、** Bean module

**3、** Context module

**4、** Expression Language module

**5、** JDBC module

**6、** ORM module

**7、** OXM module

**8、** Java Messaging Service(JMS) module

**9、** Transaction module

**10、** Web module

**11、** Web-Servlet module

**12、** Web-Struts module

**13、** Web-Portlet module


### 2、SpringBoot运行项目的几种方式？

打包用命令或者放到容器中运行

**1、** 打成jar包，使用java -jar xxx.jar运行

**2、** 打成war包，放到tomcat里面运行

直接用maven插件运行   maven spring-boot：run

直接执行main方法运行


### 3、REST 和RPC对比

**1、** RPC主要的缺陷是服务提供方和调用方式之间的依赖太强，需要对每一个微服务进行接口的定义，并通过持续继承发布，严格版本控制才不会出现冲突。

**2、** REST是轻量级的接口，服务的提供和调用不存在代码之间的耦合，只需要一个约定进行规范。


### 4、一个Spring的应用看起来象什么？

**1、** 一个定义了一些功能的接口。

**2、** 这实现包括属性，它的Setter ， getter 方法和函数等。

**3、** Spring AOP。

**4、** Spring 的XML 配置文件。

**5、** 使用以上功能的客户端程序。


### 5、什么是 AOP Aspect 切面

AOP核心就是切面，它将多个类的通用行为封装成可重用的模块，该模块含有一组API提供横切功能。比如，一个日志模块可以被称作日志的AOP切面。根据需求的不同，一个应用程序可以有若干切面。在Spring AOP中，切面通过带有@Aspect注解的类实现。


### 6、@Component, @Controller, @Repository, [@Service ](/Service ) 有何区别？

@Component：这将 java 类标记为 bean。它是任何 Spring 管理组件的通用构造型。spring 的组件扫描机制现在可以将其拾取并将其拉入应用程序环境中。@Controller：这将一个类标记为 Spring Web MVC 控制器。标有它的 Bean 会自动导入到 IoC 容器中。@Service：此注解是组件注解的特化。它不会对 [@Component ](/Component ) 注解提供任何其他行为。您可以在服务层类中使用 [@Service ](/Service ) 而不是 @Component，因为它以更好的方式指定了意图。@Repository：这个注解是具有类似用途和功能的 [@Component ](/Component ) 注解的特化。它为 DAO 提供了额外的好处。它将 DAO 导入 IoC 容器，并使未经检查的异常有资格转换为 Spring DataAccessException。


### 7、负载平衡的意义什么？

**1、** 简单来说： 先将集群，集群就是把一个的事情交给多个人去做，假如要做1000个产品给一个人做要10天，我叫10个人做就是一天，这就是集群，负载均衡的话就是用来控制集群，他把做的最多的人让他慢慢做休息会，把做的最少的人让他加量让他做多点。

**2、** 在计算中，负载平衡可以改善跨计算机，计算机集群，网络链接，中央处理单元或磁盘驱动器等多种计算资源的工作负载分布。负载平衡旨在优化资源使用，最大化吞吐量，最小化响应时间并避免任何单一资源的过载。使用多个组件进行负载平衡而不是单个组件可能会通过冗余来提高可靠性和可用性。负载平衡通常涉及专用软件或硬件，例如多层交换机或域名系统服务器进程。


### 8、开启 SpringBoot 特性有哪几种方式？

继承spring-boot-starter-parent项目

导入spring-boot-dependencies项目依赖


### 9、Spring IoC 的实现机制。

Spring 中的 IoC 的实现原理就是工厂模式加反射机制。

示例：

```
interface Fruit {
     public abstract void eat();
}
class Apple implements Fruit {
    public void eat(){
        System.out.println("Apple");
    }
}
class Orange implements Fruit {
    public void eat(){
        System.out.println("Orange");
    }
}
class Factory {
    public static Fruit getInstance(String ClassName) {
        Fruit f=null;
        try {
            f=(Fruit)Class.forName(ClassName).newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return f;
    }
}
class Client {
    public static void main(String[] a) {
        Fruit f=Factory.getInstance("io.github.dunwu.spring.Apple");
        if(f!=null){
            f.eat();
        }
    }
}
```


### 10、什么是凝聚力？

模块内部元素所属的程度被认为是凝聚力。


### 11、什么是 AOP？
### 12、区分 BeanFactory 和 ApplicationContext。
### 13、什么是bean的自动装配？
### 14、Nginx与Ribbon的区别
### 15、什么是Spring Batch？
### 16、使用 Spring 访问 Hibernate 的方法有哪些？
### 17、SpringBoot 怎么用好自动配置，精髓:
### 18、如何在SpringBoot应用程序中实现Spring安全性？
### 19、如果前台有很多个参数传入,并且这些参数都是一个对象的,那么怎么样快速得到这个对象？
### 20、什么是Spring Cloud Gateway?
### 21、为什么我们需要 spring-boot-maven-plugin?
### 22、DiscoveryClient的作用
### 23、如何实现 SpringBoot应用程序的安全性?
### 24、Spring Cloud Netflix(重点，这些组件用的最多)
### 25、什么是微服务
### 26、介绍一下 WebApplicationContext
### 27、XMLBeanFactory
### 28、spring-boot-starter-parent 有什么用 ?
### 29、列举 Spring Framework 的优点。
### 30、SpringBoot 有哪些优点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
