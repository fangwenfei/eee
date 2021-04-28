# Spring高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是 Spring Data ?

Spring Data 是 Spring 的一个子项目。用于简化数据库访问，支持NoSQL 和 关系数据存储。其主要目标是使数据库的访问变得方便快捷。Spring Data 具有如下特点：

**SpringData 项目支持 NoSQL 存储：**

**1、** MongoDB （文档数据库）

**2、** Neo4j（图形数据库）

**3、** Redis（键/值存储）

**4、** Hbase（列族数据库）


### 2、分布式配置中心有那些框架？

Apollo、zookeeper、springcloud config。


### 3、在Spring AOP 中，关注点和横切关注的区别是什么？

关注点是应用中一个模块的行为，一个关注点可能会被定义成一个我们想实现的一个功能。

横切关注点是一个关注点，此关注点是整个应用都会使用的功能，并影响整个应用，比如日志，安全和数据传输，几乎应用的每个模块都需要的功能。因此这些都属于横切关注点。


### 4、SpringBoot 支持哪些日志框架？推荐和默认的日志框架是哪个？

SpringBoot 支持 Java Util Logging, Log4j2, Lockback 作为日志框架，如果你使用 Starters 启动器，SpringBoot 将使用 Logback 作为默认日志框架.


### 5、如何不通过任何配置来选择 Hibernate 作为 JPA 的默认实现？

因为 SpringBoot 是自动配置的。

**下面是我们添加的依赖项:**

spring-boot-stater-data-jpa 对于 Hibernate 和 JPA 有过渡依赖性。

当 SpringBoot 在类路径中检测到 Hibernate 中，将会自动配置它为默认的 JPA 实现。


### 6、eureka缓存机制：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/01/44/45_10.png#alt=45%5C_10.png)

#
### 7、Spring IoC 的实现机制。

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


### 8、Ribbon和Feign的区别？

**1、** Ribbon都是调用其他服务的，但方式不同。

**2、** 启动类注解不同，Ribbon是[@RibbonClient ](/RibbonClient ) feign的是[@EnableFeignClients ](/EnableFeignClients )

**3、** 服务指定的位置不同，Ribbon是在@RibbonClient注解上声明，Feign则是在定义抽象方法的接口中使用@FeignClient声明。

**4、** 调用方式不同，Ribbon需要自己构建http请求，模拟http请求然后使用RestTemplate发送给其他服务，步骤相当繁琐。Feign需要将调用的方法定义成抽象方法即可。


### 9、Zuul与Nginx有什么区别？

Zuul是java语言实现的，主要为java服务提供网关服务，尤其在微服务架构中可以更加灵活的对网关进行操作。Nginx是使用C语言实现，性能高于Zuul，但是实现自定义操作需要熟悉lua语言，对程序员要求较高，可以使用Nginx做Zuul集群。


### 10、微服务之间是如何独立通讯的

**1、** 远程过程调用（Remote Procedure Invocation）：也就是我们常说的服务的注册与发现，直接通过远程过程调用来访问别的service。

**优点：**

简单，常见,因为没有中间件代理，系统更简单

**缺点：**

**1、** 只支持请求/响应的模式，不支持别的，比如通知、请求/异步响应、发布/订阅、发布/异步响应

**2、** 降低了可用性，因为客户端和服务端在请求过程中必须都是可用的

**2、** 消息：使用异步消息来做服务间通信。服务间通过消息管道来交换消息，从而通信。

**优点:**

**1、** 把客户端和服务端解耦，更松耦合

**2、** 提高可用性，因为消息中间件缓存了消息，直到消费者可以消费

**3、** 支持很多通信机制比如通知、请求/异步响应、发布/订阅、发布/异步响应

**缺点:**

消息中间件有额外的复杂


### 11、解释不同方式的自动装配
### 12、SpringBoot自动配置的原理
### 13、创建一个 SpringBoot Project 的最简单的方法是什么？
### 14、为什么人们会犹豫使用微服务？
### 15、在 Spring中如何注入一个java集合？
### 16、spring boot 核心配置文件是什么？bootstrap.properties 和 application.properties 有何区别 ?
### 17、什么是基于Java的Spring注解配置? 给一些注解的例子.
### 18、XMLBeanFactory
### 19、接⼝限流⽅法？
### 20、SpringBoot 有哪几种读取配置的方式？
### 21、什么是 SpringBoot Stater ？
### 22、一个Spring的应用看起来象什么？
### 23、SpringBoot 的核心注解是哪个？它主要由哪几个注解组成的？
### 24、自动装配有哪些局限性 ?
### 25、Spring支持的事务管理类型
### 26、你可以在Spring中注入一个null 和一个空字符串吗？
### 27、使用 Spring 有哪些方式？
### 28、什么是Spring Cloud Bus?
### 29、开启 SpringBoot 特性有哪几种方式？
### 30、保护 SpringBoot 应用有哪些方法？
### 31、什么是耦合和凝聚力？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
