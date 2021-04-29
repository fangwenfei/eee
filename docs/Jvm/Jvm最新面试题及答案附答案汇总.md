# Jvm最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、怎么打破双亲委派模型？

打破双亲委派机制则不仅要继承ClassLoader类，还要重写loadClass和findClass方法。


### 2、动态改变构造

OSGi 服务平台提供在多种网络设备上无需重启的动态改变构造的功能。为了最小化耦合度和促使这些耦合度可管理， OSGi 技术提供一种面向服务的架构，它能使这些组件动态地发现对方。


### 3、如何开启和查看 GC 日志？

**常见的 GC 日志开启参数包括：**

**1、** -Xloggc:filename，指定日志文件路径

**2、** -XX:+PrintGC，打印 GC 基本信息

**3、** -XX:+PrintGCDetails，打印 GC 详细信息

**4、** -XX:+PrintGCTimeStamps，打印 GC 时间戳

**5、** -XX:+PrintGCDateStamps，打印 GC 日期与时间

**6、** -XX:+PrintHeapAtGC，打印 GC 前后的堆、方法区、元空间可用容量变化

**7、** -XX:+PrintTenuringDistribution，打印熬过收集后剩余对象的年龄分布信息，有助于 MaxTenuringThreshold 参数调优设置

**8、** -XX:+PrintAdaptiveSizePolicy，打印收集器自动设置堆空间各分代区域大小、收集目标等自动调节的相关信息

**9、** -XX:+PrintGCApplicationConcurrentTime，打印 GC 过程中用户线程并发时间

**10、** -XX:+PrintGCApplicationStoppedTime，打印 GC 过程中用户线程停顿时间

**11、** -XX:+HeapDumpOnOutOfMemoryError，堆 oom 时自动 dump

**12、** -XX:HeapDumpPath，堆 oom 时 dump 文件路径

Java 9 JVM 日志模块进行了重构，参数格式发生变化，这个需要知道。

GC 日志输出的格式，会随着上面的参数不同而发生变化。关注各个分代的内存使用情况、垃圾回收次数、垃圾回收的原因、垃圾回收占用的时间、吞吐量、用户线程停顿时间。

借助工具可视化工具可以更方便的分析，在线工具 GCeasy；离线版可以使用 GCViewer。

如果现场环境不允许，可以使用 JDK 自带的 jstat 工具监控观察 GC 情况。


### 4、safepoint 是什么？

**1、** 为了减少对象引用的扫描，使用 OopMap 的数据结构在特定的位置记录下栈里和寄存器里哪些位置是引用；

**2、** 但为了避免给每条指令都生成 OopMap 记录占用大量内存的问题，只在特定位置记录这些信息。

**3、** 安全点的选定既不能太少以至于让收集器等待时间过长，也不能太过频繁以至于过分增大运行时的内存负荷。安全点位置的选取基本上是以“是否具有让程序长时间执行的特征”为标准进行选定的，如方法调用、循环跳转、异常跳转等都属于指令序列复用。


### 5、类加载有几个过程？

加载、验证、准备、解析、初始化。


### 6、Minor Gc和Full GC 有什么不同呢？

大多数情况下，对象在新生代中 eden 区分配。当 eden 区没有足够空间进行分配时，虚拟机将发起一次Minor GC。新生代GC（Minor GC）:指发生新生代的的垃圾收集动作，Minor GC非常频繁，回收速度一般也比较快。老年代GC（Major GC/Full GC）:指发生在老年代的GC，出现了Major GC经常会伴随至少一次的Minor GC（并非绝对），Major GC的速度一般会比Minor GC的慢10倍以上。


### 7、JVM 数据运行区，哪些会造成 OOM 的情况？

除了数据运行区，其他区域均有可能造成 OOM 的情况。

**堆溢出：**java.lang.OutOfMemoryError: Java heap space

**栈溢出：**java.lang.StackOverflowError

**永久代溢出：**java.lang.OutOfMemoryError: PermGen space


### 8、生产环境 CPU 占用过高，你如何解决？

**1、** top + H 指令找出占用 CPU 最高的进程的 pid

**2、** top -H -p

在该进程中找到，哪些线程占用的 CPU 最高的线程，记录下 tid

**3、** jstack -l

threads.txt，导出进程的线程栈信息到文本，导出出现异常的话，加上 -F 参数

**4、** 将 tid 转换为十六进制，在 threads.txt 中搜索，查到对应的线程代码执行栈，在代码中查找占 CPU 比较高的原因。其中 tid 转十六进制，可以借助 Linux 的 printf "%x" tid 指令

我用上述方法查到过，jvm 多条线程疯狂 full gc 导致的CPU 100% 的问题和 JDK1.6 HashMap 并发 put 导致线程 CPU 100% 的问题


### 9、你做过 JVM 调优，说说如何查看 JVM 参数默认值？

**1、** jps -v 可以查看 jvm 进程显示指定的参数

**2、** 使用 -XX:+PrintFlagsFinal 可以看到 JVM 所有参数的值

**3、** jinfo 可以实时查看和调整虚拟机各项参数


### 10、Java的内存模型是什么？（JMM是什么？）

JVM试图定义一种统一的内存模型，能将各种底层硬件及操作系统的内存访问差异进行封装，使Java程序在不同硬件及操作系统上都能达到相同的并发效果。它分为工作内存和主内存，线程无法对主存储器**直接**进行操作，一个线程要和另外一个线程通信，只能通过主存进行交换。

JMM可以说是Java并发的基础，它的定义将直接影响多线程实现的机制，如果你想要想深入了解多线程并发中的相关问题现象，对JMM的深入研究是必不可少的。

上面两个问题是经常容易搞混的，但它们的内容却完全不同的。


### 11、JVM有哪些内存区域？(JVM的内存布局是什么？)
### 12、讲讲什么情况下会出现内存溢出，内存泄漏？
### 13、谈谈永久代
### 14、标记清除算法（ Mark-Sweep）
### 15、你知道哪些GC类型？
### 16、Java里有哪些引用类型？
### 17、Java的双亲委托机制是什么？
### 18、JVM垃圾回收机制，何时触发MinorGC等操作
### 19、stackoverflow错误，permgen space错误
### 20、垃圾回收器的基本原理是什么？垃圾回收器可以马上回收内存吗？有什么办法主动通知虚拟机进行垃圾回收？
### 21、如何写一段简单的死锁代码？
### 22、类加载的过程是什么？
### 23、可达性分析
### 24、JAVA 强引用
### 25、JAVA虚引用
### 26、什么是堆
### 27、什么时候会触发FullGC
### 28、生产上如何配置垃圾收集器的？
### 29、什么是 Class 文件？ Class 文件主要的信息结构有哪些？
### 30、什么是双亲委派机制？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
