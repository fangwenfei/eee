# Java最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Super与this表示什么？

**1、** Super表示当前类的父类对象

**2、** This表示当前类的对象


### 2、HashSet如何检查重复？HashSet是如何保证数据不可重复的？

**1、** 向HashSet 中add ()元素时，判断元素是否存在的依据，不仅要比较hash值，同时还要结合equles 方法比较。

**2、** HashSet 中的add ()方法会使用HashMap 的put()方法。

**3、** HashMap 的 key 是唯一的，由源码可以看出 HashSet 添加进去的值就是作为HashMap 的key，并且在HashMap中如果K/V相同时，会用新的V覆盖掉旧的V，然后返回旧的V。所以不会重复（ HashMap 比较key是否相等是先比较hashcode 再比较equals ）。

**以下是HashSet 部分源码：**

```
private static final Object PRESENT = new Object();
private transient HashMap<E,Object> map;

public HashSet() {
map = new HashMap<>();
}

public boolean add(E e) {
// 调用HashMap的put方法,PRESENT是一个至始至终都相同的虚值
return map.put(e, PRESENT)==null;
}
```

**hashCode（）与equals（）的相关规定**：

**1、** 如果两个对象相等，则hashcode一定也是相同的，hashCode是jdk根据对象的地址或者字符串或者数字算出来的int类型的数值

**2、** 两个对象相等,对两个equals方法返回true

**3、** 两个对象有相同的hashcode值，它们也不一定是相等的

**4、** 综上，equals方法被覆盖过，则hashCode方法也必须被覆盖

**5、** hashCode()的默认行为是对堆上的对象产生独特值。如果没有重写hashCode()，则该class的两个对象无论如何都不会相等（即使这两个对象指向相同的数据）。

**==与equals的区别**

**1、** ==是判断两个变量或实例是不是指向同一个内存空间 equals是判断两个变量或实例所指向的内存空间的值是不是相同

**2、** ==是指对内存地址进行比较 equals()是对字符串的内容进行比较


### 3、notify()和notifyAll()有什么区别？

当一个线程进入wait之后，就必须等其他线程notify/notifyall,使用notifyall,可以唤醒所有处于wait状态的线程，使其重新进入锁的争夺队列中，而notify只能唤醒一个。

如果没把握，建议notifyAll，防止notigy因为信号丢失而造成程序异常。


### 4、生产环境服务器变慢，如何诊断处理？

**1、** 使用 top 指令，服务器中 CPU 和 内存的使用情况，-H 可以按 CPU 使用率降序，-M 内存使用率降序。排除其他进程占用过高的硬件资源，对 Java 服务造成影响。

**2、** 如果发现 CPU 使用过高，可以使用 top 指令查出 JVM 中占用 CPU 过高的线程，通过 jstack 找到对应的线程代码调用，排查出问题代码。

**3、** 如果发现内存使用率比较高，可以 dump 出 JVM 堆内存，然后借助 MAT 进行分析，查出大对象或者占用最多的对象来自哪里，为什么会长时间占用这么多；如果 dump 出的堆内存文件正常，此时可以考虑堆外内存被大量使用导致出现问题，需要借助操作系统指令 pmap 查出进程的内存分配情况、gdb dump 出具体内存信息、perf 查看本地函数调用等。

**4、** 如果 CPU 和 内存使用率都很正常，那就需要进一步开启 GC 日志，分析用户线程暂停的时间、各部分内存区域 GC 次数和时间等指标，可以借助 jstat 或可视化工具 GCeasy 等，如果问题出在 GC 上面的话，考虑是否是内存不够、根据垃圾对象的特点进行参数调优、使用更适合的垃圾收集器；分析 jstack 出来的各个线程状态。如果问题实在比较隐蔽，考虑是否可以开启 jmx，使用 visualmv 等可视化工具远程监控与分析。


### 5、请阐述Catalina的配置文件有哪些?

Catalina包含的配置文件有：

**1、** ·policy

**2、** ·properties

**3、** ·properties

**4、** ·xml

**5、** ·xml

**6、** ·Tomcat-users.xml


### 6、对象的访问方式有哪些？

Java 程序会通过栈上的 reference 引用操作堆对象，访问方式由虚拟机决定，主流访问方式主要有句柄和直接指针。

**句柄：** 堆会划分出一块内存作为句柄池，reference 中存储对象的句柄地址，句柄包含对象实例数据与类型数据的地址信息。优点是 reference 中存储的是稳定句柄地址，在 GC 过程中对象被移动时只会改变句柄的实例数据指针，而 reference 本身不需要修改。

**直接指针：** 堆中对象的内存布局就必须考虑如何放置访问类型数据的相关信息，reference 存储对象地址，如果只是访问对象本身就不需要多一次间接访问的开销。优点是速度更快，节省了一次指针定位的时间开销，HotSpot 主要使用直接指针进行对象访问。


### 7、调优工具

常用调优工具分为两类,jdk自带监控工具：jconsole和jvisualvm，第三方有：MAT(Memory AnalyzerTool)、GChisto。

**1、** jconsole，Java Monitoring and Management Console是从java5开始，在JDK中自带的java监控和管理控制台，用于对JVM中内存，线程和类等的监控

**2、** jvisualvm，jdk自带全能工具，可以分析内存快照、线程快照；监控内存变化、GC变化等。

**3、** MAT，Memory Analyzer Tool，一个基于Eclipse的内存分析工具，是一个快速、功能丰富的Javaheap分析工具，它可以帮助我们查找内存泄漏和减少内存消耗

**4、** GChisto，一款专业分析gc日志的工具


### 8、怎么查看服务器默认的垃圾回收器是哪一个？

这通常会使用另外一个参数：`-XX:+PrintCommandLineFlags`可以打印所有的参数，包括使用的垃圾回收器。


### 9、是否可以继承String类？



String 类是final类，不可以被继承。

> 补充：继承String本身就是一个错误的行为，对String类型最好的重用方式是关联关系（Has-A）和依赖关系（Use-A）而不是继承关系（Is-A）。



### 10、举例说明同步和异步。



如果系统中存在临界资源（资源数量少于竞争资源的线程数量的资源），例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就必须进行同步存取（数据库操作中的排他锁就是最好的例子）。当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。事实上，所谓的同步就是指阻塞式操作，而异步就是非阻塞式操作。


### 11、为什么wait(), notify()和notifyAll ()必须在同步方法或者同步块中被调用？
### 12、notify() 和 notifyAll() 有什么区别？
### 13、url是什么？由哪些部分组成？
### 14、线程的状态流转图
### 15、垃圾回收的优点和原理。说说2种回收机制
### 16、什么是AQS
### 17、你说你做过JVM参数调优和参数配置，请问如何查看JVM系统默认值
### 18、自动装箱与拆箱
### 19、在 Java 程序中怎么保证多线程的运行安全？
### 20、阐述静态变量和实例变量的区别。
### 21、如何实现对象克隆？
### 22、SWAP会影响性能么？
### 23、谈谈你知道的垃圾回收算法
### 24、什么是红黑树
### 25、继承和组合之间有什么不同？
### 26、打印昨天的当前时刻。
### 27、类加载有几个过程？
### 28、Java 中，Serializable 与 Externalizable 的区别？
### 29、在Java中CycliBarriar和CountdownLatch有什么区别？
### 30、线程 B 怎么知道线程 A 修改了变量
### 31、怎么打出线程栈信息？
### 32、Get请求与post有什么区别？
### 33、类ExampleA继承Exception，类ExampleB继承ExampleA。
### 34、32 位和 64 位的 JVM，int 类型变量的长度是多数？
### 35、Java应用程序与小程序之间有那些差别？
### 36、分代收集算法
### 37、你在项目中哪些地方用到了XML？
### 38、构造方法能不能重写？能不能重载？
### 39、什么情况下会违反迪米特法则？为什么会有这个问题？
### 40、你能写出一个正则表达式来判断一个字符串是否是一个数字吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
