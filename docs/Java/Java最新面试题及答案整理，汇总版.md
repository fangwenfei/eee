# Java最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、GC的回收流程是怎样的？

**GC回收流程如下：**

**1、** 对于整个的GC流程里面，那么最需要处理的就是新生代和老年代的内存清理操作，而元空间（永久代）都不在GC范围内

**2、** 当现在有一个新的对象产生，那么对象一定需要内存空间，平均每个栈内存存4k，每个堆内存存8k，那么对象一定需要进行堆空间的申请

**3、** 首先会判断Eden区是否有内存空间，如果此时有内存空间，则直接将新对象保存在伊甸园区。

**4、** 但是如果此时在伊甸园区内存不足，那么会自动执行一个Minor GC 操作，将伊甸园区的无用内存空间进行清理，Minor GC的清理范围只在Eden园区，清理之后会继续判断Eden园区的内存空间是否充足？如果内存空间充足，则将新对象直接在Eden园区进行空间分配。

**5、** 如果执行Minor GC 之后发现伊甸园区的内存空间依然不足，那么这个时候会执行存活区的判断，如果存活区有剩余空间，则将Eden园区部分活跃对象保存在存活区，那么随后继续判断Eden园区的内存空间是否充足，如果充足怎则将新对象直接在Eden园区进行空间分配。

**6、** 此时如果存活区没有内存空间，则继续判断老年区。则将部分存活对象保存在老年代，而后存活区将有空余空间。

**7、** 如果这个时候老年代也满了，那么这个时候将产生Major GC（Full GC）,那么这个时候将进行老年代的清理

**8、** 如果老年代执行Full GC之后，无法进行对象的保存，则会产生OOM异常,OutOfMemoryError异常



### 2、对象是怎么从年轻代进入老年代的？

这是老掉牙的题目了。在下面四种情况下，对象会从年轻代进入老年代。

**1、** 如果对象够老，会通过提升（Promotion）进入老年代，这一般是根据对象的年龄进行判断的。

**2、** 动态对象年龄判定。有的垃圾回收算法，比如G1，并不要求age必须达到15才能晋升到老年代，它会使用一些动态的计算方法。

**3、** 分配担保。当 Survivor 空间不够的时候，就需要依赖其他内存（指老年代）进行分配担保。这个时候，对象也会直接在老年代上分配。

**4、** 超出某个大小的对象将直接在老年代分配。不过这个值默认为0，意思是全部首选Eden区进行分配。


### 3、Serial Old 收集器（单线程标记整理算法 ）

Serial Old 是 Serial 垃圾收集器年老代版本，它同样是个单线程的收集器，使用标记-整理算法，这个收集器也主要是运行在 Client 默认的

**java 虚拟机默认的年老代垃圾收集器。在 Server 模式下，主要有两个用途：**

**1、** 在 JDK1.5 之前版本中与新生代的 Parallel Scavenge 收集器搭配使用。

**2、** 作为年老代中使用 CMS 收集器的后备垃圾收集方案。新生代 Serial 与年老代 Serial Old 搭配垃圾收集

新生代 Parallel Scavenge 收集器与 ParNew 收集器工作原理类似，都是多线程的收集器，都使用的是复制算法，在垃圾收集过程中都需要暂停所有的工作线程。新生代 ParallelScavenge/ParNew 与年老代 Serial Old 搭配垃圾收集过程图：


### 4、Java网络编程有几种？

TCP编程

UDP编程


### 5、JVM调优命令有哪些？

jps，JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。jstat，JVM statistics Monitoring是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。jmap，JVM Memory Map命令用于生成heap dump文件 jhat，JVM Heap Analysis Tool命令是与jmap搭配使用，用来分析jmap生成的dump，jhat内置了一个微型的HTTP/HTML服务器，生成dump的分析结果后，可以在浏览器中查看 jstack，用于生成java虚拟机当前时刻的线程快照。jinfo，JVM Conﬁguration info 这个命令作用是实时查看和调整虚拟机运行参数。


### 6、栈帧里面包含哪些东西？

局部变量表、操作数栈、动态连接、返回地址等


### 7、阻塞队列和非阻塞队列区别

**1、** 当队列阻塞队列为空的时，从队列中获取元素的操作将会被阻塞。

**2、** 或者当阻塞队列是满时，往队列里添加元素的操作会被阻塞。

**3、** 或者试图从空的阻塞队列中获取元素的线程将会被阻塞，直到其他的线程往空的队列插入新的元素。

**4、** 试图往已满的阻塞队列中添加新元素的线程同样也会被阻塞，直到其他的线程使队列重新变得空闲起来


### 8、线程的基本状态以及状态之间的关系？



![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/03/img_2.png#alt=img%5C_2.png)

> 说明：其中Running表示运行状态，Runnable表示就绪状态（万事俱备，只欠CPU），Blocked表示阻塞状态，阻塞状态又有多种情况，可能是因为调用wait()方法进入等待池，也可能是执行同步方法或同步代码块进入等锁池，或者是调用了sleep()方法或join()方法等待休眠或其他线程结束，或是因为发生了I/O中断。



### 9、解释何时在Tomcat使用SSL ?

当你将Tomcat作为独立的web服务器运行时，需使用Tomcat来处理连接


### 10、什么是类加载器，类加载器有哪些？

实现通过类的权限定名获取该类的二进制字节流的代码块叫做类加载器。

**主要有一下四种类加载器：**

**1、** 动类加载器（Bootstrap ClassLoader）

用来加载 Java 核心类库，无法被 Java 程序直接引用。

**2、** 展类加载器（extensions class loader）：

它用来加载 Java 的扩展库。Java 虚拟机的实现会提供一个扩展库目录。该类加载器在此目录里面查找并加载 Java 类。

**3、** 统类加载器（system class loader）：

它根据 Java 应用的类路径（CLASSPATH）来加载 Java 类。一般来说，Java 应用的类都是由它来完成加载的。可以通过 ClassLoader.getSystemClassLoader() 来获取它。

**4、** 户自定义类加载器

通过继承 java.lang.ClassLoader 类的方式实现。


### 11、有哪些打破了双亲委托机制的案例？
### 12、JVM怎么判断一个对象是不是要回收？
### 13、自动装箱与拆箱
### 14、JSP中的静态包含和动态包含有什么区别？
### 15、什么是工厂模式
### 16、为什么选择使用框架而不是原生?
### 17、使用sql写出一个分页程序？
### 18、说出至少 5 点在 Java 中使用线程的最佳实践。
### 19、Tomcat是怎么打破双亲委派机制的呢？
### 20、程序计数器
### 21、怎么打出线程栈信息？
### 22、用代码演示三种代理
### 23、java中会存在内存泄漏吗，请简单描述。
### 24、Java 中 interrupted 和 isInterrupted 方法的区别？
### 25、TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？
### 26、两个相同的对象会有不同的的 hash code 吗？
### 27、SynchronizedMap和ConcurrentHashMap有什么区别？
### 28、写一个方法，输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数。
### 29、如何让正在运行的线程暂停一段时间？
### 30、什么是ThreadLocal变量？
### 31、多线程场景下如何使用 ArrayList？
### 32、哪些是 GC Roots？
### 33、32 位和 64 位的 JVM，int 类型变量的长度是多数？
### 34、死锁与活锁的区别，死锁与饥饿的区别？
### 35、四种构建线程池的区别及特点？
### 36、什么时候使用访问者模式？
### 37、Static关键字有什么作用？
### 38、我们能自己写一个容器类，然后使用 for-each 循环码？
### 39、为什么线程通信的方法wait(), notify()和notifyAll()被定义在Object 类里？
### 40、什么是Vector




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
