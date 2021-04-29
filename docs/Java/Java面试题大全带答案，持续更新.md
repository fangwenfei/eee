# Java面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、notify()和notifyAll()有什么区别？

当一个线程进入wait之后，就必须等其他线程notify/notifyall,使用notifyall,可以唤醒所有处于wait状态的线程，使其重新进入锁的争夺队列中，而notify只能唤醒一个。

如果没把握，建议notifyAll，防止notigy因为信号丢失而造成程序异常。


### 2、java 中的 Math.round(-1.5) 等于多少？

等于 -1，因为在数轴上取值时，中间值（0.5）向右取整，所以正 0.5 是往上取整，负 0.5 是直接舍弃。


### 3、如何在两个线程间共享数据？

在两个线程间共享变量即可实现共享。

一般来说，共享变量要求变量本身是线程安全的，然后在线程内使用的时候，如果有对共享变量的复合操作，那么也得保证复合操作的线程安全性。


### 4、volatile关键字的原理是什么？干什么用的？

使用了volatile关键字的变量，每当变量的值有变动的时候，都会将更改立即同步到主内存中；而如果某个线程想要使用这个变量，就先要从主存中刷新到工作内存，这样就确保了变量的可见性。

一般使用一个volatile修饰的bool变量，来控制线程的运行状态。

```
volatile boolean stop = false;
 
 void stop(){
  this.stop = true;
 }
 void start(){
  new Thread(()->{
   while (!stop){
    //sth
   }
  }).start();
 }
```


### 5、synchronized 和 ReentrantLock 区别是什么？

**1、** synchronized 是和 if、else、for、while 一样的关键字，ReentrantLock 是类，这是二者的本质区别。既然 ReentrantLock 是类，那么它就提供了比synchronized 更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量

**2、** synchronized 早期的实现比较低效，对比 ReentrantLock，大多数场景性能都相差较大，但是在 Java 6 中对 synchronized 进行了非常多的改进。

**相同点：两者都是可重入锁**

两者都是可重入锁。“可重入锁”概念是：自己可以再次获取自己的内部锁。比如一个线程获得了某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，如果不可锁重入的话，就会造成死锁。同一个线程每次获取锁，锁的计数器都自增1，所以要等到锁的计数器下降为0时才能释放锁。

**主要区别如下：**

**1、** ReentrantLock 使用起来比较灵活，但是必须有释放锁的配合动作；

**2、** ReentrantLock 必须手动获取与释放锁，而 synchronized 不需要手动释放和开启锁；

**3、** ReentrantLock 只适用于代码块锁，而 synchronized 可以修饰类、方法、变量等。

**4、** 二者的锁机制其实也是不一样的。ReentrantLock 底层调用的是 Unsafe 的park 方法加锁，synchronized 操作的应该是对象头中 mark word

**5、** Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

**1、** 普通同步方法，锁是当前实例对象

**2、** 静态同步方法，锁是当前类的class对象

**3、** 同步方法块，锁是括号里面的对象


### 6、阐述静态变量和实例变量的区别。



静态变量是被static修饰符修饰的变量，也称为类变量，它属于类，不属于类的任何一个对象，一个类不管创建多少个对象，静态变量在内存中有且仅有一个拷贝；实例变量必须依存于某一实例，需要先创建对象然后通过对象才能访问到它。静态变量可以实现让多个对象共享内存。

> 补充：在Java开发中，上下文类和工具类中通常会有大量的静态成员。



### 7、Java 中，编写多线程程序的时候你会遵循哪些最佳实践？

这是我在写Java 并发程序的时候遵循的一些最佳实践：

**1、** 给线程命名，这样可以帮助调试。

**2、** 最小化同步的范围，而不是将整个方法同步，只对关键部分做同步。

**3、** 如果可以，更偏向于使用 volatile 而不是 synchronized。

**4、** 使用更高层次的并发工具，而不是使用 wait() 和 notify() 来实现线程间通信，如 BlockingQueue，CountDownLatch 及 Semeaphore。

**5、** 优先使用并发集合，而不是对集合进行同步。并发集合提供更好的可扩展性。


### 8、Java 中 LinkedHashMap 和 PriorityQueue 的区别是什么？

PriorityQueue 保证最高或者最低优先级的的元素总是在队列头部，但是 LinkedHashMap 维持的顺序是元素插入的顺序。当遍历一个 PriorityQueue 时，没有任何顺序保证，但是 LinkedHashMap 课保证遍历顺序是元素插入的顺序。


### 9、Java 中，Maven 和 ANT 有什么区别？

虽然两者都是构建工具，都用于创建 Java 应用，但是 Maven 做的事情更多，在基于“约定优于配置”的概念下，提供标准的Java 项目结构，同时能为应用自动管理依赖（应用中所依赖的 JAR 文件），Maven 与 ANT 工具更多的不同之处请参见。

**1、** 这就是所有的面试题，如此之多，是不是？我可以保证，如果你能回答列表中的所有问题，你就可以很轻松的应付任何核心 Java 或者高级 Java 面试。虽然，这里没有涵盖 Servlet、JSP、JSF、JPA，JMS，EJB 及其它 Java EE 技术，也没有包含主流的框架如 Spring MVC，Struts 2.0，Hibernate，也没有包含 SOAP 和 RESTful web service，但是这份列表对做 Java 开发的、准备应聘 Java web 开发职位的人还是同样有用的，因为所有的 Java 面试，开始的问题都是 Java 基础和 JDK API 相关的。如果你认为我这里有任何应该在这份列表中而被我遗漏了的 Java 流行的问题，你可以自由的给我建议。我的目的是从最近的面试中创建一份最新的、最优的 Java 面试问题列表。


### 10、32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？

理论上说上 32 位的 JVM 堆内存可以到达 2^32，即 4GB，但实际上会比这个小很多。不同操作系统之间不同，如 Windows 系统大约 1.5GB，Solaris 大约3GB。64 位 JVM 允许指定最大的堆内存，理论上可以达到 2^64，这是一个非常大的数字，实际上你可以指定堆内存大小到 100GB。甚至有的 JVM，如 Azul，堆内存到 1000G 都是可能的。


### 11、简述Hibernate常见优化策略。
### 12、Java 中能创建 volatile 数组吗？
### 13、接口和抽象类的区别是什么？
### 14、请解释StackOverflowError和OutOfMemeryError的区别？
### 15、Java 程序是怎样运行的？
### 16、列出 5 个应该遵循的 JDBC 最佳实践
### 17、如何创建守护线程？
### 18、Java Concurrency API中的Lock接口(Lock interface)是什么？对比同步它有什么优势？
### 19、synchronized和ReentrantLock的区别
### 20、Java中你怎样唤醒一个阻塞的线程？
### 21、使用集合框架的好处
### 22、你知道哪些GC类型？
### 23、线上常用的 JVM 参数有哪些？
### 24、说一下 synchronized 底层实现原理？
### 25、Collection 和 Collections 有什么区别？
### 26、如何实现对象克隆？
### 27、Session与cookie的区别？
### 28、动态改变构造
### 29、适配器模式和代理模式之前有什么不同？
### 30、Lock 接口和synchronized 对比同步它有什么优势？
### 31、synchronized 和 Lock 有什么区别？
### 32、CopyOnWriteArrayList可以用于什么应用场景？
### 33、原型模式的使用方式
### 34、生产上如何配置垃圾收集器的？
### 35、对于JDK自带的监控和性能分析工具用过哪些？
### 36、生产环境服务器变慢，如何诊断处理？
### 37、JVM 数据运行区，哪些会造成 OOM 的情况？
### 38、java中是值传递引用传递？
### 39、final、finalize()、finally，作用
### 40、遇到过堆外内存溢出吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
