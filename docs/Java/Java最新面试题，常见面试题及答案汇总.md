# Java最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何在 Windows 和 Linux 上查找哪个线程cpu利用率最高？

windows上面用任务管理器看，linux下可以用 top 这个工具看。

**1、** 找出cpu耗用厉害的进程pid， 终端执行top命令，然后按下shift+p (shift+m是找出消耗内存最高)查找出cpu利用最厉害的pid号

**2、** 根据上面第一步拿到的pid号，top -H -p pid 。然后按下shift+p，查找出cpu利用率最厉害的线程号，比如top -H -p 1328

**3、** 将获取到的线程号转换成16进制，去百度转换一下就行

**4、** 使用jstack工具将进程信息打印输出，jstack pid号 > /tmp/t.dat，比如jstack 31365 > /tmp/t.dat

**5、** 编辑/tmp/t.dat文件，查找线程号对应的信息

或者直接使用JDK自带的工具查看“jconsole” 、“visualVm”，这都是JDK自带的，可以直接在JDK的bin目录下找到直接使用


### 2、标记清除算法（ Mark-Sweep）

最基础的垃圾回收算法，分为两个阶段，标注和清除。标记阶段标记出所有需要回收的对象，清除阶段回收被标记的对象所占用的空间。

从图中我们就可以发现，该算法最大的问题是内存碎片化严重，后续可能发生大对象不能找到可利用空间的问题。


### 3、对象的访问方式有哪些？

Java 程序会通过栈上的 reference 引用操作堆对象，访问方式由虚拟机决定，主流访问方式主要有句柄和直接指针。

**句柄：** 堆会划分出一块内存作为句柄池，reference 中存储对象的句柄地址，句柄包含对象实例数据与类型数据的地址信息。优点是 reference 中存储的是稳定句柄地址，在 GC 过程中对象被移动时只会改变句柄的实例数据指针，而 reference 本身不需要修改。

**直接指针：** 堆中对象的内存布局就必须考虑如何放置访问类型数据的相关信息，reference 存储对象地址，如果只是访问对象本身就不需要多一次间接访问的开销。优点是速度更快，节省了一次指针定位的时间开销，HotSpot 主要使用直接指针进行对象访问。


### 4、模块化编程与热插拔

OSGi 旨在为实现 Java 程序的模块化编程提供基础条件，基于 OSGi 的程序很可能可以实现模块级的热插拔功能，当程序升级更新时，可以只停用、重新安装然后启动程序的其中一部分，这对企业级程序开发来说是非常具有诱惑力的特性。

OSGi 描绘了一个很美好的模块化开发目标，而且定义了实现这个目标的所需要服务与架构，同时也有成熟的框架进行实现支持。但并非所有的应用都适合采用 OSGi 作为基础架构，它在提供强大功能同时，也引入了额外的复杂度，因为它不遵守了类加载的双亲委托模型。


### 5、请解释如何配置Tomcat来使用IIS和NTLM ?

必须遵循isapi_redirector.dll的标准指令

配置IIS使用“集成windows验证”

确保在服务器.xml中您已经禁用了tomcat身份验证

### 6、GC 垃圾收集器

Java 堆内存被划分为新生代和年老代两部分，新生代主要使用复制和标记-清除垃圾回收算法；年老代主要使用标记-整理垃圾回收算法，因此 java 虚拟中针对新生代和年老代分别提供了多种不同的垃圾收集器， JDK1.6 中 Sun HotSpot 虚拟机的垃圾收集器


### 7、适配器模式和代理模式之前有什么不同？

这个问题与前面的类似，适配器模式和代理模式的区别在于他们的意图不同。由于适配器模式和代理模式都是封装真正执行动作的类，因此结构是一致的，但是适配器模式用于接口之间的转换，而代理模式则是增加一个额外的中间层，以便支持分配、控制或智能访问。


### 8、调优命令有哪些？

Sun JDK监控和故障处理命令有jps jstat jmap jhat jstack jinfo

**1、** jps，JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。

**2、** jstat，JVM statistics Monitoring是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。

**3、** jmap，JVM Memory Map命令用于生成heap dump文件

**4、** jhat，JVM Heap Analysis Tool命令是与jmap搭配使用，用来分析jmap生成的dump，jhat内置了一个微型的HTTP/HTML服务器，生成dump的分析结果后，可以在浏览器中查看

**5、** jstack，用于生成java虚拟机当前时刻的线程快照。

**6、** jinfo，JVM Configuration info 这个命令作用是实时查看和调整虚拟机运行参数


### 9、final不可变对象，它对写并发应用有什么帮助？

**1、** 不可变对象(Immutable Objects)即对象一旦被创建它的状态（对象的数据，也即对象属性值）就不能改变，反之即为可变对象(Mutable Objects)。

**2、** 不可变对象的类即为不可变类(Immutable Class)。Java 平台类库中包含许多不可变类，如 String、基本类型的包装类、BigInteger 和 BigDecimal 等。

**3、** 只有满足如下状态，一个对象才是不可变的；

**4、** 它的状态不能在创建后再被修改；

**5、** 所有域都是 final 类型；并且，它被正确创建（创建期间没有发生 this 引用的逸出）。

不可变对象保证了对象的内存可见性，对不可变对象的读取不需要进行额外的同步手段，提升了代码执行效率。


### 10、工作中常用的 JVM 配置参数有哪些？

Java 8 为例

**日志**

**1、** -XX:+PrintFlagsFinal，打印JVM所有参数的值

**2、** -XX:+PrintGC，打印GC信息

**3、** -XX:+PrintGCDetails，打印GC详细信息

**4、** -XX:+PrintGCTimeStamps，打印GC的时间戳

**5、** -Xloggc:filename，设置GC log文件的位置

**6、** -XX:+PrintTenuringDistribution，查看熬过收集后剩余对象的年龄分布信息

**内存设置**

**1、** -Xms，设置堆的初始化内存大小

**2、** -Xmx，设置堆的最大内存

**3、** -Xmn，设置新生代内存大小

**4、** -Xss，设置线程栈大小

**5、** -XX:NewRatio，新生代与老年代比值

**6、** -XX:SurvivorRatio，新生代中Eden区与两个Survivor区的比值，默认为8，即Eden:Survivor:Survivor=8:1:1

**7、** -XX:MaxTenuringThreshold，从年轻代到老年代，最大晋升年龄。CMS 下默认为 6，G1 下默认为 15

**8、** -XX:MetaspaceSize，设置元空间的大小，第一次超过将触发 GC

**9、** -XX:MaxMetaspaceSize，元空间最大值

**10、** -XX:MaxDirectMemorySize，用于设置直接内存的最大值，限制通过 DirectByteBuffer 申请的内存

**11、** -XX:ReservedCodeCacheSize，用于设置 JIT 编译后的代码存放区大小，如果观察到这个值有限制，可以适当调大，一般够用即可

**设置垃圾收集相关**

**1、** -XX:+UseSerialGC，设置串行收集器

**2、** -XX:+UseParallelGC，设置并行收集器

**3、** -XX:+UseConcMarkSweepGC，使用CMS收集器

**4、** -XX:ParallelGCThreads，设置Parallel GC的线程数

**5、** -XX:MaxGCPauseMillis，GC最大暂停时间 ms

**6、** -XX:+UseG1GC，使用G1垃圾收集器

**CMS 垃圾回收器相关**

**1、** -XX:+UseCMSInitiatingOccupancyOnly

**2、** -XX:CMSInitiatingOccupancyFraction，与前者配合使用，指定MajorGC的发生时机

**3、** -XX:+ExplicitGCInvokesConcurrent，代码调用 System.gc() 开始并行 FullGC，建议加上这个参数

**4、** -XX:+CMSScavengeBeforeRemark，表示开启或关闭在 CMS 重新标记阶段之前的清除（YGC）尝试，它可以降低 remark 时间，建议加上

**5、** -XX:+ParallelRefProcEnabled，可以用来并行处理 Reference，以加快处理速度，缩短耗时

**G1 垃圾回收器相关**

**1、** -XX:MaxGCPauseMillis，用于设置目标停顿时间，G1 会尽力达成

**2、** -XX:G1HeapRegionSize，用于设置小堆区大小，建议保持默认

**3、** -XX:InitiatingHeapOccupancyPercent，表示当整个堆内存使用达到一定比例（默认是 45%），并发标记阶段就会被启动

**4、** -XX:ConcGCThreads，表示并发垃圾收集器使用的线程数量，默认值随 JVM 运行的平台不同而变动，不建议修改

参数查询官网地址：

[https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html](https://docs.oracle.com/javase/8/docs/technotes/tools/unix/java.html)

建议面试时最好能记住 CMS 和 G1的参数，特点突出使用较多，被问的概率大


### 11、说说你知道的几种主要的JVM参数
### 12、如何决定使用 HashMap 还是 TreeMap？
### 13、简述synchronized 和java.util.concurrent.locks.Lock的异同？
### 14、Final在java中的作用
### 15、并发编程有什么缺点
### 16、OOP 中的 组合、聚合和关联有什么区别？
### 17、什么情况会造成元空间溢出？
### 18、CopyOnWriteArrayList 是什么?
### 19、运行时数据区是什么？
### 20、你知道有哪些开源框架？
### 21、为什么需要双亲委派模式？
### 22、线程类的构造方法、静态块是被哪个线程调用的
### 23、用Java写一个单例类。
### 24、在 Java 程序中怎么保证多线程的运行安全？
### 25、双亲委派
### 26、线程B怎么知道线程A修改了变量
### 27、为什么 wait(), notify()和 notifyAll()必须在同步方法或者同步块中被调用？
### 28、SWAP会影响性能么？
### 29、在java中wait和sleep方法的不同？
### 30、Swing 是线程安全的？
### 31、一个线程运行时发生异常会怎样？
### 32、你是如何调用 wait() 方法的？使用 if 块还是循环？为什么？
### 33、创建对象的过程是什么？
### 34、同步方法和同步块，哪个是更好的选择？
### 35、Try.catch.finally是必须要存在的吗？
### 36、Json是什么？
### 37、请说明select * from tab的输出结果是什么?
### 38、什么是多态机制？Java语言是如何实现多态的？
### 39、抽象类可以使用final修饰吗？
### 40、Java 中，throw 和 throws 有什么区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
