# Jvm最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、JVM 年轻代到年老代的晋升过程的判断条件是什么呢？

**1、** 部分对象会在From和To区域中复制来复制去,如此交换15次(由JVM参数MaxTenuringThreshold决定,这个参数默认是15),最终如果还是存活,就存入到老年代。

**2、** 如果对象的大小大于Eden的二分之一会直接分配在old，如果old也分配不下，会做一次majorGC，如果小于eden的一半但是没有足够的空间，就进行minorgc也就是新生代GC。

**3、** minor gc后，survivor仍然放不下，则放到老年代

**4、** 动态年龄判断 ，大于等于某个年龄的对象超过了survivor空间一半 ，大于等于某个年龄的对象直接进入老年代


### 2、请你谈谈对OOM的认识

OOM是非常严重的问题，除了`程序计数器`，其他内存区域都有溢出的风险。和我们平常工作最密切的，就是堆溢出。另外，元空间在方法区内容非常多的情况下也会溢出。还有就是栈溢出，这个通常影响比较小。堆外也有溢出的可能，这个就比较难排查一些。


### 3、JVM 提供的常用工具

**jps：**

用来显示本地的 Java 进程，可以查看本地运行着几个 Java 程序，并显示他们的进程号。 命令格式：jps

**jinfo：**

运行环境参数：Java System 属性和 JVM 命令行参数，Java class path 等信息。 命令格式：jinfo 进程 pid

**jstat：**

监视虚拟机各种运行状态信息的命令行工具。 命令格式：jstat -gc 123 250 20

**jstack：**

可以观察到 JVM 中当前所有线程的运行情况和线程当前状态。 命令格式：jstack 进程 pid

**jmap：**

观察运行中的 JVM 物理内存的占用情况（如：产生哪些对象，及其数量）。 命令格式：jmap [option] pid


### 4、什么时候会触发FullGC

除直接调用System.gc外，触发Full GC执行的情况有如下四种。

**旧生代空间不足**

旧生代空间只有在新生代对象转入及创建为大对象、大数组时才会出现不足的现象，当执行Full GC后空间仍然不足，则抛出如下错

**误：**

java.lang.OutOfMemoryError: Java heap space

为避免以上两种状况引起的FullGC，调优时应尽量做到让对象在Minor GC阶段被回收、让对象在新生代多存活一段时间及不要创建过大的对象及数组。

**Permanet Generation空间满**

PermanetGeneration中存放的为一些class的信息等，当系统中要加载的类、反射的类和调用的方法较多时，Permanet Generation可能会被占满，在未配置为采用CMS GC的情况下会执行Full GC。如果经过Full GC仍然回收不了，那么JVM会抛出如下错误信息：

java.lang.OutOfMemoryError: PermGen space

为避免Perm Gen占满造成Full GC现象，可采用的方法为增大Perm Gen空间或转为使用CMS GC。

**CMS GC时出现promotion failed和concurrent mode failure**

对于采用CMS进行旧生代GC的程序而言，尤其要注意GC日志中是否有promotion failed和concurrent mode failure两种状况，当这两种状况出现时可能会触发Full GC。

promotionfailed是在进行Minor GC时，survivor space放不下、对象只能放入旧生代，而此时旧生代也放不下造成的；concurrentmode failure是在执行CMS GC的过程中同时有对象要放入旧生代，而此时旧生代空间不足造成的。

应对措施为：增大survivorspace、旧生代空间或调低触发并发GC的比率，但在JDK 5.0+、6.0+的版本中有可能会由于JDK的bug29导致CMS在remark完毕后很久才触发sweeping动作。对于这种状况，可通过设置-XX:CMSMaxAbortablePrecleanTime=5（单位为ms）来避免。

**统计得到的Minor GC晋升到旧生代的平均大小大于旧生代的剩余空间**

这是一个较为复杂的触发情况，Hotspot为了避免由于新生代对象晋升到旧生代导致旧生代空间不足的现象，在进行Minor GC时，做了一个判断，如果之前统计所得到的Minor GC晋升到旧生代的平均大小大于旧生代的剩余空间，那么就直接触发Full GC。

例如程序第一次触发MinorGC后，有6MB的对象晋升到旧生代，那么当下一次Minor GC发生时，首先检查旧生代的剩余空间是否大于6MB，如果小于6MB，则执行Full GC。

当新生代采用PSGC时，方式稍有不同，PS GC是在Minor GC后也会检查，例如上面的例子中第一次Minor GC后，PS GC会检查此时旧生代的剩余空间是否大于6MB，如小于，则触发对旧生代的回收。除了以上4种状况外，对于使用RMI来进行RPC或管理的Sun JDK应用而言，默认情况下会一小时执行一次Full GC。可通过在启动时通过- java-Dsun.rmi.dgc.client.gcInterval=3600000来设置Full GC执行的间隔时间或通过-XX:+ DisableExplicitGC来禁止RMI调用System.gc


### 5、Java里有哪些引用类型？

**1、** 强引用 这种引用属于最普通最强硬的一种存在，只有在和 GC Roots 断绝关系时，才会被消灭掉。

**2、** 软引用 软引用用于维护一些可有可无的对象。在内存足够的时候，软引用对象不会被回收，只有在内存不足时，系统则会回收软引用对象，如果回收了软引用对象之后仍然没有足够的内存，才会抛出内存溢出异常。可以看到，这种特性非常适合用在缓存技术上。比如网页缓存、图片缓存等。软引用可以和一个引用队列（ReferenceQueue）联合使用，如果软引用所引用的对象被垃圾回收，Java 虚拟机就会把这个软引用加入到与之关联的引用队列中。

**3、** 弱引用 弱引用对象相比较软引用，要更加无用一些，它拥有更短的生命周期。当JVM进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。弱引用拥有更短的生命周期，在 Java 中，用 java.lang.ref.WeakReference 类来表示。它的应用场景和软引用类似，可以在一些对内存更加敏感的系统里采用。

**4、** 虚引用 这是一种形同虚设的引用，在现实场景中用的不是很多。虚引用必须和引用队列（ReferenceQueue）联合使用。如果一个对象仅持有虚引用，那么它就和没有任何引用一样，在任何时候都可能被垃圾回收。实际上，虚引用的 get，总是返回 null。


### 6、JVM 监控与分析工具你用过哪些？介绍一下。

**1、** jps，显示系统所有虚拟机进程信息的命令行工具

**2、** jstat，监视分析虚拟机运行状态的命令行工具

**3、** jinfo，查看和调整虚拟机参数的命令行工具

**4、** jmap，生成虚拟机堆内存转储快照的命令行工具

**5、** jhat，显示和分析虚拟机的转储快照文件的命令行工具

**6、** jstack，生成虚拟机的线程快照的命令行工具

**7、** jcmd，虚拟机诊断工具，JDK 7 提供

**8、** jhsdb，基于服务性代理实现的进程外可视化调试工具，JDK 9 提供

**9、** JConsole，基于JMX的可视化监视和管理工具

**10、** jvisualvm，图形化虚拟机使用情况的分析工具

**11、** Java Mission Control，监控和管理 Java 应用程序的工具

**1、** MAT，Memory Analyzer Tool，虚拟机内存分析工具

**2、** vjtools，唯品会的包含核心类库与问题分析工具

**3、** arthas，阿里开源的 Java 诊断工具

**4、** greys，JVM进程执行过程中的异常诊断工具

**5、** GCHisto，GC 分析工具

**6、** GCViewer，GC 日志文件分析工具

**7、** GCeasy，在线版 GC 日志文件分析工具

**8、** JProfiler，检查、监控、追踪 Java 性能的工具

**9、** BTrace，基于动态字节码修改技术(Hotswap)实现的Java程序追踪与分析工具

**下面可以重点体验下：**

JDK 自带的命令行工具方便快捷，不是特别复杂的问题可以快速定位；

阿里的 arthas 命令行也不错；

可视化工具 MAT、JProfiler 比较强大。


### 7、什么是 Class 文件？ Class 文件主要的信息结构有哪些？

Class 文件是一组以 8 位字节为基础单位的二进制流。各个数据项严格按顺序排列。

Class 文件格式采用一种类似于 C 语言结构体的伪结构来存储数据。这样的伪结构仅仅有两种数据类型：无符号数和表。

无符号数：是基本数据类型。以 u1、u2、u4、u8 分别代表 1 个字节、2 个字节、4 个字节、8 个字节的无符号数，能够用来描写叙述数字、索引引用、数量值或者依照 UTF-8 编码构成的字符串值。

表：由多个无符号数或者其它表作为数据项构成的复合数据类型。全部表都习惯性地以 _info 结尾。


### 8、什么是类加载器，类加载器有哪些？

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


### 9、串行（serial）收集器和吞吐量（throughput）收集器的区别是什么？

吞吐量收集器使用并行版本的新生代垃圾收集器，它用于中等规模和大规模数据的应用程序。 而串行收集器对大多数的小应用（在现代处理器上需要大概 100M 左右的内存）就足够了。


### 10、JVM垃圾回收时候如何确定垃圾？什么是GC Roots？

JVM采用的是可达性分析算法。JVM是通过GC Roots来判定对象的存活的。从`GC Roots`向下追溯、搜索，会产生一个叫做`Reference Chain`的链条。当一个对象不能和任何一个GC Root产生关系，就判定为垃圾。

**GC Roots大体包括：**

**1、** 活动线程相关的各种引用，比如虚拟机栈中栈帧里的引用。

**2、** 类的静态变量的引用。

**3、** JNI引用等。

**当然也有比较详细的回答，个人认为这些就够了。详细版本如下：**

**1、** Java线程中，当前所有正在被调用的方法的 `引用类型`参数、局部变量、临时值等。也就是与我们 `栈帧`相关的各种引用。

**2、** 所有当前被加载的Java类。

**3、** Java类的引用类型静态变量。

**4、** 运行时常量池里的引用类型常量（String或Class类型）。

**5、** JVM内部数据结构的一些引用，比如 `sun.jvm.hotspot.memory.Universe`类。

**6、** 用于同步的监控对象，比如调用了对象的 `wait()`方法。

**7、** JNI handles，包括global handles和local handles


### 11、什么是分布式垃圾回收（DGC）？它是如何工作的？
### 12、什么情况下会发生栈溢出？
### 13、堆和栈的区别
### 14、JAVA弱引用
### 15、怎么打出线程栈信息？
### 16、老年代与标记复制算法
### 17、什么是堆
### 18、方法区/永久代（线程共享）
### 19、类加载有几个过程？
### 20、你都有哪些手段用来排查内存溢出？
### 21、Java 堆的结构是什么样子的？什么是堆中的永久代（Perm Gen space）
### 22、标记清除算法（ Mark-Sweep）
### 23、java中会存在内存泄漏吗，请简单描述。
### 24、对象分配内存是否线程安全？
### 25、32、volatile关键字的原理是什么？干什么用的？
### 26、Java对象创建过程
### 27、类加载是什么？
### 28、说说线程栈
### 29、你做过 JVM 调优，说说如何查看 JVM 参数默认值？
### 30、生产环境用的什么JDK？如何配置的垃圾收集器？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
