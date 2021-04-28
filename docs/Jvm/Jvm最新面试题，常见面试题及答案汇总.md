# Jvm最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、调优命令有哪些？

Sun JDK监控和故障处理命令有jps jstat jmap jhat jstack jinfo

**1、** jps，JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。

**2、** jstat，JVM statistics Monitoring是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。

**3、** jmap，JVM Memory Map命令用于生成heap dump文件

**4、** jhat，JVM Heap Analysis Tool命令是与jmap搭配使用，用来分析jmap生成的dump，jhat内置了一个微型的HTTP/HTML服务器，生成dump的分析结果后，可以在浏览器中查看

**5、** jstack，用于生成java虚拟机当前时刻的线程快照。

**6、** jinfo，JVM Configuration info 这个命令作用是实时查看和调整虚拟机运行参数


### 2、什么是方法区

用于存储虚拟机加载的类信息，常量，静态变量等数据。


### 3、64 位 JVM 中，int 的长度是多数？

Java 中，int 类型变量的长度是一个固定值，与平台无关，都是 32 位。意思就是说，在 32 位 和 64 位 的 Java 虚拟机中，int 类型的长度是相同的。


### 4、JVM 内存区域

JVM 内存区域主要分为线程私有区域【程序计数器、虚拟机栈、本地方法区】、线程共享区域【JAVA 堆、方法区】、直接内存。

线程私有数据区域生命周期与线程相同, 依赖用户线程的启动/结束 而 创建/销毁(在 Hotspot VM 内, 每个线程都与操作系统的本地线程直接映射, 因此这部分内存区域的存/否跟随本地线程的生/死对应)。

线程共享区域随虚拟机的启动/关闭而创建/销毁。

直接内存并不是 JVM 运行时数据区的一部分, 但也会被频繁的使用: 在 JDK 1.4 引入的 NIO 提供了基于Channel与 Buffer的IO方式, 它可以使用Native函数库直接分配堆外内存, 然后使用DirectByteBuffer 对象作为这块内存的引用进行操作(详见: Java I/O 扩展), 这样就避免了在 Java堆和 Native 堆中来回复制数据, 因此在一些场景中可以显著提高性能。


### 5、什么是happen-before原则？

单线程happen-before原则：在同一个线程中，书写在前面的操作happen-before后面的操作。锁的happen-before原则：同一个锁的unlock操作happen-before此锁的lock操作。volatile的happen-before原则：对一个volatile变量的写操作happen-before对此变量的任意操作(当然也包括写操作了)。happen-before的传递性原则：如果A操作 happen-before B操作，B操作happen-before C操作，那么A操作happen-before C操作。线程启动的happen-before原则：同一个线程的start方法happen-before此线程的其它方法。线程中断的happen-before原则 ：对线程interrupt方法的调用happen-before被中断线程的检测到中断发送的代码。线程终结的happen-before原则：线程中的所有操作都happen-before线程的终止检测。对象创建的happen-before原则：一个对象的初始化完成先于他的finalize方法调用。


### 6、讲讲什么情况下会出现内存溢出，内存泄漏？

内存泄漏的原因很简单：

**1、** 对象是可达的(一直被引用)

**2、** 但是对象不会被使用

常见的内存泄漏例子：

```
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Object object = new Object();
            set.add(object);

            // 设置为空，该对象不再使用
            object = null;
        }

        // 但是set集合中还维护object的引用，gc不会回收object对象
        System.out.println(set);
        System.out.println(set.size());
    }
}
```

输出结果

```
[java.lang.Object@74a14482, 
java.lang.Object@677327b6, 
java.lang.Object@6d6f6e28, 
java.lang.Object@4554617c, 
java.lang.Object@45ee12a7, 
java.lang.Object@1b6d3586, 
java.lang.Object@7f31245a,
java.lang.Object@135fbaa4,
java.lang.Object@1540e19d, 
java.lang.Object@14ae5a5]
10

Process finished with exit code 0
```

解决这个内存泄漏问题也很简单，将set设置为null，那就可以避免上述内存泄漏问题了。其他内存泄漏得一步一步分析了。

**内存溢出的原因：**

**1、** 内存泄露导致堆栈内存不断增大，从而引发内存溢出。

**2、** 大量的jar，class文件加载，装载类的空间不够，溢出

**3、** 操作大量的对象导致堆内存空间已经用满了，溢出

**4、** nio直接操作内存，内存过大导致溢出

**解决：**

**1、** 查看程序是否存在内存泄漏的问题

**2、** 设置参数加大空间

**3、** 代码中是否存在死循环或循环产生过多重复的对象实体、

**4、** 查看是否使用了nio直接操作内存。


### 7、JVM 选项 -XX:+UseCompressedOops 有什么作用？为什么要使用

当你将你的应用从 32 位的 JVM 迁移到 64 位的 JVM 时，由于对象的指针从32 位增加到了 64 位，因此堆内存会突然增加，差不多要翻倍。这也会对 CPU缓存（容量比内存小很多）的数据产生不利的影响。因为，迁移到 64 位的 JVM主要动机在于可以指定最大堆大小，通过压缩OOP 可以节省一定的内存。通过-XX:+UseCompressedOops 选项，JVM 会使用 32 位的 OOP，而不是 64 位的 OOP。


### 8、Java 的引用有哪些类型？

JDK1.2 后对引用进行了扩充，按强度分为四种：

**强引用：** 最常见的引用，例如 `Object obj = new Object()` 就属于强引用。只要对象有强引用指向且 GC Roots 可达，在内存回收时即使濒临内存耗尽也不会被回收。

**软引用：** 弱于强引用，描述非必需对象。在系统将发生内存溢出前，会把软引用关联的对象加入回收范围以获得更多内存空间。用来缓存服务器中间计算结果及不需要实时保存的用户行为等。

**弱引用：** 弱于软引用，描述非必需对象。弱引用关联的对象只能生存到下次 YGC 前，当垃圾收集器开始工作时无论当前内存是否足够都会回收只被弱引用关联的对象。由于 YGC 具有不确定性，因此弱引用何时被回收也不确定。

**虚引用：** 最弱的引用，定义完成后无法通过该引用获取对象。唯一目的就是为了能在对象被回收时收到一个系统通知。虚引用必须与引用队列联合使用，垃圾回收时如果出现虚引用，就会在回收对象前把这个虚引用加入引用队列。


### 9、你做过 JVM 调优，说说如何查看 JVM 参数默认值？

**1、** jps -v 可以查看 jvm 进程显示指定的参数

**2、** 使用 -XX:+PrintFlagsFinal 可以看到 JVM 所有参数的值

**3、** jinfo 可以实时查看和调整虚拟机各项参数


### 10、MinorGC、MajorGC、FullGC 什么时候发生？

**1、** MinorGC 在年轻代空间不足的时候发生

**2、** MajorGC 指的是老年代的 GC，出现 MajorGC 一般经常伴有 MinorGC

**3、** FullGC 老年代无法再分配内存；元空间不足；显示调用 System.gc；像 CMS 一类的垃圾回收器，在 MinorGC 出现 promotion failure 时也会发生 FullGC


### 11、类加载器
### 12、GC日志的real、user、sys是什么意思？
### 13、safepoint 是什么？
### 14、双亲委派机制可以被违背吗？请举例说明。
### 15、Parallel Old 收集器（多线程标记整理算法）
### 16、栈溢出的原因？
### 17、老年代与标记复制算法
### 18、复制算法（copying）
### 19、ZGC 了解吗？
### 20、ZGC收集器中的染色指针有什么用？
### 21、类加载有几个过程？
### 22、什么时候会触发FullGC
### 23、介绍一下 JVM 中垃圾收集器有哪些？ 他们特点分别是什么？
### 24、遇到过元空间溢出吗？
### 25、有哪些类加载器？
### 26、JVM 的内存模型是什么？
### 27、什么是类加载器，类加载器有哪些？
### 28、谈谈永久代
### 29、safepoint是什么？
### 30、怎么获取 Java 程序使用的内存？堆使用的百分比？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
