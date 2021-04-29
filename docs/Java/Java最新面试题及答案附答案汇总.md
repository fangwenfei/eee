# Java最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、stackoverflow错误，permgen space错误

stackoverflow错误主要出现：

在虚拟机栈中(线程请求的栈深度大于虚拟机栈锁允许的最大深度)

permgen space错误(针对jdk之前1.7版本)：

**1、** 大量加载class文件

**2、** 常量池内存溢出


### 2、写一段代码在遍历 ArrayList 时移除一个元素？

该问题的关键在于面试者使用的是 ArrayList 的 remove() 还是 Iterator 的 remove()方法。这有一段[示例代码](http://java67.blogspot.com/2015/10/how-to-solve-concurrentmodificationexception-in-java-arraylist.html)，是使用正确的方式来实现在遍历的过程中移除元素，而不会出现 ConcurrentModificationException 异常的示例代码。


### 3、多线程的好处

可以提高 CPU 的利用率。在多线程程序中，一个线程必须等待的时候，CPU 可以运行其它的线程而不是等待，这样就大大提高了程序的效率。也就是说允许单个程序创建多个并行执行的线程来完成各自的任务。


### 4、如何使session失效

Session.invalidate()


### 5、怎么检查一个字符串只包含数字？解决方案

[http://java67.blogspot.com/2014/01/java-regular-expression-to-check-numbers-in-String.html](http://java67.blogspot.com/2014/01/java-regular-expression-to-check-numbers-in-String.html)


### 6、synchronized、volatile、CAS比较

**1、** synchronized是悲观锁，属于抢占式，会引起其他线程阻塞。

**2、** volatile提供多线程共享变量可见性和禁止指令重排序优化。

**3、** CAS是基于冲突检测的乐观锁（非阻塞）


### 7、静态方法和实例方法有何不同？

静态方法和实例方法的区别主要体现在两个方面：

**1、** 在外部调用静态方法时，可以使用"类名.方法名"的方式，也可以使用"对象名.方法名"的方式。而实例方法只有后面这种方式。也就是说，调用静态方法可以无需创建对象。

**2、** 静态方法在访问本类的成员时，只允许访问静态成员（即静态成员变量和静态方法），而不允许访问实例成员变量和实例方法；实例方法则无此限制


### 8、那些地方用到了单例模式

**1、** 网站的计数器，一般也是采用单例模式实现，否则难以同步。

**2、** 应用程序的日志应用，一般都是单例模式实现，只有一个实例去操作才好，否则内容不好追加显示。

**3、** 多线程的线程池的设计一般也是采用单例模式，因为线程池要方便对池中的线程进行控制

**4、** Windows的（任务管理器）就是很典型的单例模式，他不能打开俩个

**5、** windows的（回收站）也是典型的单例应用。在整个系统运行过程中，回收站只维护一个实例。


### 9、如何在两个线程间共享数据？

**在两个线程间共享变量即可实现共享**

一般来说，共享变量要求变量本身是线程安全的，然后在线程内使用的时候，如果有对共享变量的复合操作，那么也得保证复合操作的线程安全性


### 10、GC 垃圾收集器

Java 堆内存被划分为新生代和年老代两部分，新生代主要使用复制和标记-清除垃圾回收算法；年老代主要使用标记-整理垃圾回收算法，因此 java 虚拟中针对新生代和年老代分别提供了多种不同的垃圾收集器， JDK1.6 中 Sun HotSpot 虚拟机的垃圾收集器


### 11、使用JDBC操作数据库时，如何提升读取数据的性能？如何提升更新数据的性能？
### 12、ThreadLocal是什么？有什么用？
### 13、简述正则表达式及其用途。
### 14、Java 中，怎么打印出一个字符串的所有排列？
### 15、什么情况下会发生栈溢出？
### 16、Java中的包装类都是那些？
### 17、什么是红黑树
### 18、串行（serial）收集器和吞吐量（throughput）收集器的区别是什么？
### 19、策略模式应用场景
### 20、String 属于基础的数据类型吗？
### 21、什么时候使用享元模式？
### 22、Java 内存分配与回收策率以及 Minor GC 和 Major GC
### 23、如何避免线程死锁
### 24、你是如何调用 wait() 方法的？使用 if 块还是循环？为什么？
### 25、ConcurrentHashMap 和 Hashtable 的区别？
### 26、url是什么？由哪些部分组成？
### 27、本地方法栈的作用？
### 28、volatile 能使得一个非原子操作变成原子操作吗？
### 29、如何实现 Array 和 List 之间的转换？
### 30、上传文件是如何做的？
### 31、面向对象的语言有那些特征？
### 32、什么是DAO模式？
### 33、什么是线程同步和线程互斥，有哪几种实现方式？
### 34、有没有可能两个不相等的对象有有相同的 hashcode？
### 35、乐观锁和悲观锁的理解及如何实现，有哪些实现方式？
### 36、如何停止一个正在运行的线程？
### 37、什么是并发容器的实现？
### 38、TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？
### 39、如何部署一个web项目？
### 40、为什么要学习工厂设计模式
### 41、线程的调度策略




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
