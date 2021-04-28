# Java最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、阻塞队列和非阻塞队列区别

**1、** 当队列阻塞队列为空的时，从队列中获取元素的操作将会被阻塞。

**2、** 或者当阻塞队列是满时，往队列里添加元素的操作会被阻塞。

**3、** 或者试图从空的阻塞队列中获取元素的线程将会被阻塞，直到其他的线程往空的队列插入新的元素。

**4、** 试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，直到其他的线程使队列重新变得空闲起来


### 2、现实生活中的模板方法

**例如：**

去餐厅吃饭，餐厅给我们提供了一个模板就是：看菜单，点菜，吃饭，付款，走人 （这里 “**点菜和付款**” 是不确定的由子类来完成的，其他的则是一个模板。）

- 代码演示

**1、** 先定义一个模板。把模板中的点菜和付款，让子类来实现。

```
package com.lijie;

//模板方法
public abstract class RestaurantTemplate {

    // 1.看菜单
    public void menu() {
        System.out.println("看菜单");
    }

    // 2.点菜业务
    abstract void spotMenu();

    // 3.吃饭业务
    public void havingDinner(){ System.out.println("吃饭"); }

    // 3.付款业务
    abstract void payment();

    // 3.走人
    public void GoR() { System.out.println("走人"); }

    //模板通用结构
    public void process(){
        menu();
        spotMenu();
        havingDinner();
        payment();
        GoR();
    }
}
```

**2、** 具体的模板方法子类 1

```
package com.lijie;

public class RestaurantGinsengImpl extends RestaurantTemplate {

    void spotMenu() {
        System.out.println("人参");
    }

    void payment() {
        System.out.println("5快");
    }
}
```

**3、** 具体的模板方法子类 2

```
package com.lijie;

public class RestaurantLobsterImpl  extends RestaurantTemplate  {

    void spotMenu() {
        System.out.println("龙虾");
    }

    void payment() {
        System.out.println("50块");
    }
}
```

**4、** 客户端测试

```
package com.lijie;

public class Client {

    public static void main(String[] args) {
        //调用第一个模板实例
        RestaurantTemplate restaurantTemplate = new RestaurantGinsengImpl();
        restaurantTemplate.process();
    }
}
```


### 3、如何避免线程死锁

**1、** 避免一个线程同时获得多个锁

**2、** 避免一个线程在锁内同时占用多个资源，尽量保证每个锁只占用一个资源

**3、** 尝试使用定时锁，使用lock.tryLock(timeout)来替代使用内部锁机制


### 4、Java 中能创建 volatile 数组吗？

能，Java 中可以创建 volatile 类型数组，不过只是一个指向数组的引用，而不是整个数组。意思是，如果改变引用指向的数组，将会受到 volatile 的保护，但是如果多个线程同时改变数组的元素，volatile 标示符就不能起到之前的保护作用了。


### 5、32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？

理论上说上 32 位的 JVM 堆内存可以到达 2^32，即 4GB，但实际上会比这个小很多。不同操作系统之间不同，如 Windows 系统大约 1.5 GB，Solaris 大约 3GB。64 位 JVM允许指定最大的堆内存，理论上可以达到 2^64，这是一个非常大的数字，实际上你可以指定堆内存大小到 100GB。甚至有的 JVM，如 Azul，堆内存到 1000G 都是可能的。


### 6、介绍一下 JVM 中垃圾收集器有哪些？ 他们特点分别是什么？

**新生代垃圾收集器**

**Serial 收集器**

特点： Serial 收集器只能使用一条线程进行垃圾收集工作，并且在进行垃圾收集的时候，所有的工作线程都需要停止工作，等待垃圾收集线程完成以后，其他线程才可以继续工作。

**使用算法：复制算法**

**ParNew 收集器**

特点： ParNew 垃圾收集器是Serial收集器的多线程版本。为了利用 CPU 多核多线程的优势，ParNew 收集器可以运行多个收集线程来进行垃圾收集工作。这样可以提高垃圾收集过程的效率。

**使用算法：复制算法**

**Parallel Scavenge 收集器**

特点： Parallel Scavenge 收集器是一款多线程的垃圾收集器，但是它又和 ParNew 有很大的不同点。

Parallel Scavenge 收集器和其他收集器的关注点不同。其他收集器，比如 ParNew 和 CMS 这些收集器，它们主要关注的是如何缩短垃圾收集的时间。而 Parallel Scavenge 收集器关注的是如何控制系统运行的吞吐量。这里说的吞吐量，指的是 CPU 用于运行应用程序的时间和 CPU 总时间的占比，吞吐量 = 代码运行时间 / （代码运行时间 + 垃圾收集时间）。如果虚拟机运行的总的 CPU 时间是 100 分钟，而用于执行垃圾收集的时间为 1 分钟，那么吞吐量就是 99%。

**使用算法：复制算法**

**老年代垃圾收集器**

**Serial Old 收集器**

特点： Serial Old 收集器是 Serial 收集器的老年代版本。这款收集器主要用于客户端应用程序中作为老年代的垃圾收集器，也可以作为服务端应用程序的垃圾收集器。

**使用算法：标记-整理**

**Parallel Old 收集器**

特点： Parallel Old 收集器是 Parallel Scavenge 收集器的老年代版本这个收集器是在 JDK1.6 版本中出现的，所以在 JDK1.6 之前，新生代的 Parallel Scavenge 只能和 Serial Old 这款单线程的老年代收集器配合使用。Parallel Old 垃圾收集器和 Parallel Scavenge 收集器一样，也是一款关注吞吐量的垃圾收集器，和 Parallel Scavenge 收集器一起配合，可以实现对 Java 堆内存的吞吐量优先的垃圾收集策略。

**使用算法：标记-整理**

**CMS 收集器**

特点： CMS 收集器是目前老年代收集器中比较优秀的垃圾收集器。CMS 是 Concurrent Mark Sweep，从名字可以看出，这是一款使用"标记-清除"算法的并发收集器。

CMS 垃圾收集器是一款以获取最短停顿时间为目标的收集器。如下图所示：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/05/34/39_3.png#alt=39%5C_3.png)

**从图中可以看出，CMS 收集器的工作过程可以分为 4 个阶段：**

**1、** 初始标记（CMS initial mark）阶段

**2、** 并发标记（CMS concurrent mark）阶段

**3、** 重新标记（CMS remark）阶段

**4、** 并发清除(（CMS concurrent sweep）阶段

使用算法：复制+标记清除

**其他**

**G1 垃圾收集器**

特点： 主要步骤：`初始标记，并发标记，重新标记，复制清除。`

**使用算法：复制 + 标记整理**


### 7、自动装箱与拆箱

**装箱**：将基本类型用它们对应的引用类型包装起来；

**拆箱**：将包装类型转换为基本数据类型；

Java使用自动装箱和拆箱机制，节省了常用数值的内存开销和创建对象的开销，提高了效率，由编译器来完成，编译器会在编译期根据语法决定是否进行装箱和拆箱动作。


### 8、解释什么是Jasper?

Jasper是Tomcat的JSP引擎

它解析JSP文件，将它们编译成JAVA代码作为servlet

在运行时，Jasper允许自动检测JSP文件的更改并重新编译它们


### 9、在多线程环境下，SimpleDateFormat 是线程安全的吗？

不是，非常不幸，DateFormat 的所有实现，包括 SimpleDateFormat 都不是线程安全的，因此你不应该在多线程序中使用，除非是在对外线程安全的环境中使用，如 将 SimpleDateFormat 限制在 ThreadLocal 中。如果你不这么做，在解析或者格式化日期的时候，可能会获取到一个不正确的结果。因此，从日期、时间处理的所有实践来说，我强力推荐 joda-time 库。


### 10、Java常用包有那些？

**1、** Java.lang

**2、** Java.io

**3、** Java.sql

**4、** Java.util

**5、** Java.awt

**6、** Java.net

**7、** Java.math


### 11、HashMap 和 ConcurrentHashMap 的区别
### 12、遇到过元空间溢出吗？
### 13、String 类的常用方法都有那些？
### 14、什么是方法重载？
### 15、JVM 出现 fullGC 很频繁，怎么去线上排查问题
### 16、线程的调度策略
### 17、什么是Hash算法
### 18、Hashtable 与 HashMap 有什么不同之处？
### 19、Spring开发中的工厂设计模式
### 20、说一下 Atomic的原理？
### 21、请解释一下什么时候可以使用“.”，什么时候可以使用“[]”?
### 22、JVM 数据运行区，哪些会造成 OOM 的情况？
### 23、阐述JDBC操作数据库的步骤。
### 24、使用集合框架的好处
### 25、HashMap中的key，可以是普通对象么？需要什么注意的地方？
### 26、什么是重写？什么是重载？
### 27、volatile 能使得一个非原子操作变成原子操作吗？
### 28、线程之间是如何通信的？
### 29、如何自定义线程线程池?
### 30、什么是Executors框架？
### 31、什么是重排序
### 32、类加载是什么？
### 33、在使用jdbc的时候，如何防止出现sql注入的问题。
### 34、抽象的（abstract）方法是否可同时是静态的（static）,是否可同时是本地方法（native），是否可同时被synchronized修饰？
### 35、什么时候使用享元模式？
### 36、说下有哪些类加载器？
### 37、synchronized、volatile、CAS 比较
### 38、你都用过G1垃圾回收器的哪几个重要参数？
### 39、什么叫线程安全？servlet 是线程安全吗?
### 40、CyclicBarrier和CountDownLatch的区别
### 41、HTTP的状态码




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
