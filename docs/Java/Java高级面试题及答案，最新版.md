# Java高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Java都有那些开发平台？

**1、** JAVA SE：主要用在客户端开发

**2、** JAVA EE：主要用在web应用程序开发

**3、** JAVA ME：主要用在嵌入式应用程序开发


### 2、CopyOnWriteArrayList 的使用场景?

合适读多写少的场景。


### 3、你如何确保main()方法所在的线程是Java 程序最后结束的线程？

我们可以使用Thread类的join()方法来确保所有程序创建的线程在main()方法退出前结束。


### 4、Java 中怎么获取一份线程 dump 文件？

在 Linux 下，你可以通过命令 kill -3 PID （Java 进程的进程 ID）来获取 Java 应用的 dump 文件。在 Windows 下，你可以按下 Ctrl + Break 来获取。这样 JVM 就会将线程的 dump 文件打印到标准输出或错误文件中，它可能打印在控制台或者日志文件中，具体位置依赖应用的配置。如果你使用Tomcat。


### 5、Object类常用方法有那些？

**1、** Equals

**2、** Hashcode

**3、** toString

**4、** wait

**5、** notify

**6、** clone

**7、** getClass


### 6、原型模式的应用场景

**1、** 类初始化需要消化非常多的资源，这个资源包括数据、硬件资源等。这时我们就可以通过原型拷贝避免这些消耗。

**2、** 通过new产生的一个对象需要非常繁琐的数据准备或者权限，这时可以使用原型模式。

**3、** 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用，即保护性拷贝。

我们Spring框架中的多例就是使用原型


### 7、Servlet生命周期内调用的方法过程？

**1、** Init()

**2、** Service()

**3、** doGet或者doPost

**4、** destroy


### 8、JVM的引用类型有哪些？

引用内型：

**强引用：**

当内存不足的时候，JVM宁可出现OutOfMemoryError错误停止，也需要进行保存，并且不会将此空间回收。在引用期间和栈有联系就无法被回收

**软引用：**

当内存不足的时候，进行对象的回收处理，往往用于高速缓存中；mybatis就是其中

**弱引用：**

不管内存是否紧张，只要有垃圾了就立即回收

**幽灵引用：**

和没有引用是一样的


### 9、Java 中，怎样才能打印出数组中的重复元素？

解决方案

[http://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html](http://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html)


### 10、Java中Semaphore是什么？

Java中的Semaphore是一种新的同步类，它是一个计数信号。从概念上讲，从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release()添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore只对可用许可的号码进行计数，并采取相应的行动。信号量常常用于多线程的代码中，比如数据库连接池。


### 11、聚集索引与非聚集索引有什么区别？
### 12、HashMap 与 HashTable 有什么区别？
### 13、怎么利用 JUnit 来测试一个方法的异常？
### 14、String s = new String(“xyz”);创建了几个字符串对象？
### 15、用哪两种方式来实现集合的排序？
### 16、Js如何跳转到到一个指定页面
### 17、comparable 和 comparator的区别？
### 18、单例防止反射漏洞攻击
### 19、说出 5 个 JDK 1.8 引入的新特性？
### 20、Java 堆的结构是什么样子的？什么是堆中的永久代（Perm Gen space）
### 21、你对线程优先级的理解是什么？
### 22、程序计数器(线程私有)
### 23、永久代
### 24、mixin、hoc、render props、react-hooks的优劣如何？
### 25、Serial 与 Parallel GC 之间的不同之处？
### 26、为什么HashTable是线程安全的？
### 27、说一下垃圾分代收集的过程
### 28、为什么你应该在循环中检查等待条件?
### 29、谈谈永久代
### 30、什么是多线程环境下的伪共享（false sharing）？
### 31、volatile关键字的原理是什么？干什么用的？
### 32、如何部署一个web项目？
### 33、在 Java 程序中怎么保证多线程的运行安全？
### 34、关于 OOP 和设计模式的面试题
### 35、线程的 run()和 start()有什么区别？
### 36、接口和抽象类的区别是什么？
### 37、什么是Callable和Future?
### 38、当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？
### 39、什么是Web Service（Web服务）
### 40、什么是Daemon线程？它有什么意义？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
