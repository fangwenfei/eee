# Java最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、标记清除算法（ Mark-Sweep）

最基础的垃圾回收算法，分为两个阶段，标注和清除。标记阶段标记出所有需要回收的对象，清除阶段回收被标记的对象所占用的空间。

从图中我们就可以发现，该算法最大的问题是内存碎片化严重，后续可能发生大对象不能找到可利用空间的问题。


### 2、在不使用 StringBuffer 的前提下，怎么反转一个字符串？

解决方案

[http://java67.blogspot.com/2012/12/how-to-reverse-string-in-java-stringbuffer-stringbuilder.htm](http://java67.blogspot.com/2012/12/how-to-reverse-string-in-java-stringbuffer-stringbuilder.htm)


### 3、AQS支持两种同步方式：

**1、** 独占式

**2、** 共享式

这样方便使用者实现不同类型的同步组件，独占式如ReentrantLock，共享式如Semaphore，CountDownLatch，组合式的如ReentrantReadWriteLock。总之，AQS为使用提供了底层支撑，如何组装实现，使用者可以自由发挥。


### 4、线程的状态

![87_2.png][87_2.png]

**1、** 新建(new)：新创建了一个线程对象。

**2、** 就绪（可运行状态）(runnable)：线程对象创建后，当调用线程对象的 start()方法，该线程处于就绪状态，等待被线程调度选中，获取cpu的使用权。

**3、** 运行(running)：可运行状态(runnable)的线程获得了cpu时间片（timeslice），执行程序代码。注：就绪状态是进入到运行状态的唯一入口，也就是说，线程要想进入运行状态执行，首先必须处于就绪状态中；

**4、** 阻塞(block)：处于运行状态中的线程由于某种原因，暂时放弃对 CPU的使用权，停止执行，此时进入阻塞状态，直到其进入到就绪状态，才 有机会再次被 CPU 调用以进入到运行状态。

**阻塞的情况分三种：**

**1、** 等待阻塞：

运行状态中的线程执行 wait()方法，JVM会把该线程放入等待队列(waitting queue)中，使本线程进入到等待阻塞状态；

**2、** 同步阻塞：

线程在获取 synchronized 同步锁失败(因为锁被其它线程所占用)，，则JVM会把该线程放入锁池(lock pool)中，线程会进入同步阻塞状态；

**3、** 其他阻塞:

通过调用线程的 sleep()或 join()或发出了 I/O 请求时，线程会进入到阻塞状态。当 sleep()状态超时、join()等待线程终止或者超时、或者 I/O 处理完毕时，线程重新转入就绪状态。

**4、** 死亡(dead)(结束)：

线程run()、main()方法执行结束，或者因异常退出了run()方法，则该线程结束生命周期。死亡的线程不可再次复生。


### 5、32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？

理论上说上 32 位的 JVM 堆内存可以到达 2^32，即 4GB，但实际上会比这个小很多。不同操作系统之间不同，如 Windows 系统大约 1.5GB，Solaris 大约3GB。64 位 JVM 允许指定最大的堆内存，理论上可以达到 2^64，这是一个非常大的数字，实际上你可以指定堆内存大小到 100GB。甚至有的 JVM，如 Azul，堆内存到 1000G 都是可能的。


### 6、如何在两个线程间共享数据？

**在两个线程间共享变量即可实现共享**

一般来说，共享变量要求变量本身是线程安全的，然后在线程内使用的时候，如果有对共享变量的复合操作，那么也得保证复合操作的线程安全性


### 7、什么是线程调度器(Thread Scheduler)和时间分片(Time Slicing )？

**1、** 线程调度器是一个操作系统服务，它负责为 Runnable 状态的线程分配 CPU 时间。一旦我们创建一个线程并启动它，它的执行便依赖于线程调度器的实现。

**2、** 时间分片是指将可用的 CPU 时间分配给可用的 Runnable 线程的过程。分配 CPU 时间可以基于线程优先级或者线程等待的时间。

**3、** 线程调度并不受到 Java 虚拟机控制，所以由应用程序来控制它是更好的选择（也就是说不要让你的程序依赖于线程的优先级）。


### 8、线程的 run()和 start()有什么区别？
### 9、对象分配内存是否线程安全？
### 10、老年代
### 11、Java 中 WeakReference 与 SoftReference 的区别？
### 12、JVM 类加载机制
### 13、Array 和 ArrayList 有何区别？
### 14、38、数据类型之间的转换：
### 15、如何判断一个常量是废弃常量 ？
### 16、说一下堆和栈的区别
### 17、java中会存在内存泄漏吗，请简单描述。
### 18、JAVA8 与元数据
### 19、当打开其他程序的网页时，使用的target属性是哪个？
### 20、什么叫线程安全？servlet是线程安全吗?
### 21、Servlet中如何获取用户提交的查询参数或表单数据？
### 22、ArrayList 和 Vector 的区别是什么？
### 23、线程B怎么知道线程A修改了变量
### 24、多线程的劣势：
### 25、会话跟踪技术有那些？
### 26、什么是观察者模式
### 27、Java中用到的线程调度算法是什么
### 28、在一个静态方法内调用一个非静态成员为什么是非法的？
### 29、乐观锁和悲观锁的理解及如何实现，有哪些实现方式？
### 30、谈谈永久代
### 31、双亲委派机制可以被违背吗？请举例说明。
### 32、什么是类加载器，类加载器有哪些？
### 33、java 中 IO 流分为几种？
### 34、comparable 和 comparator的区别？
### 35、在 Java 中 Executor 和 Executors 的区别？
### 36、Java 中，DOM 和 SAX 解析器有什么不同？
### 37、适配器模式和装饰器模式有什么区别？
### 38、线程与进程的区别
### 39、如果一个类中有抽象方法，那么这个一定是抽象类？
### 40、我们能将 int 强制转换为 byte 类型的变量吗？如果该值大于 byte 类型的范围，将会出现什么现象？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
