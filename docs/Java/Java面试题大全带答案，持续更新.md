# Java面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Java 中，怎样才能打印出数组中的重复元素？

解决方案

[http://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html](http://javarevisited.blogspot.com/2015/06/3-ways-to-find-duplicate-elements-in-array-java.html)


### 2、多线程同步和互斥有几种实现方法，都是什么？

**1、** 线程同步是指线程之间所具有的一种制约关系，一个线程的执行依赖另一个线程的消息，当它没有得到另一个线程的消息时应等待，直到消息到达时才被唤醒。

**2、** 线程互斥是指对于共享的进程系统资源，在各单个线程访问时的排它性。当有若干个线程都要使用某一共享资源时，任何时刻最多只允许一个线程去使用，其它要使用该资源的线程必须等待，直到占用资源者释放该资源。线程互斥可以看成是一种特殊的线程同步。

**1、** 线程间的同步方法大体可分为两类：用户模式和内核模式。顾名思义，内核模式就是指利用系统内核对象的单一性来进行同步，使用时需要切换内核态与用户态，而用户模式就是不需要切换到内核态，只在用户态完成操作。

**2、** 用户模式下的方法有：原子操作（例如一个单一的全局变量），临界区。内核模式下的方法有：事件，信号量，互斥量。


### 3、为什么wait(), notify()和notifyAll ()必须在同步方法或者同步块中被调用？

当一个线程需要调用对象的wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的notify()方法。同样的，当一个线程需要调用对象的notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。


### 4、简述Hibernate常见优化策略。

**1、** 制定合理的缓存策略（二级缓存、查询缓存）。

**2、** 采用合理的Session管理机制。

**3、** 尽量使用延迟加载特性。

**4、** 设定合理的批处理参数。

**5、** 如果可以，选用UUID作为主键生成器。

**6、** 如果可以，选用乐观锁替代悲观锁。

**7、** 在开发过程中, 开启hibernate.show_sql选项查看生成的SQL，从而了解底层的状况；开发完成后关闭此选项。

**8、** 考虑数据库本身的优化，合理的索引、恰当的数据分区策略等都会对持久层的性能带来可观的提升，但这些需要专业的DBA（数据库管理员）提供支持。


### 5、生产环境用的什么JDK？如何配置的垃圾收集器？

**Oracle JDK 1.8**

JDK 1.8 中有 Serial、ParNew、Parallel Scavenge、Serial Old、Parallel Old、CMS、G1，默认使用 Parallel Scavenge + Parallel Old。

**1、** Serial 系列是单线程垃圾收集器，处理效率很高，适合小内存、客户端场景使用，使用参数 -XX:+UseSerialGC 显式启用。

**2、** Parallel 系列相当于并发版的 Serial，追求高吞吐量，适用于较大内存并且有多核CPU的环境，默认或显式使用参数 -XX:+UseParallelGC 启用。可以使用 -XX:MaxGCPauseMillis 参数指定最大垃圾收集暂停毫秒数，收集器会尽量达到目标；使用 -XX:GCTimeRatio 指定期望吞吐量大小，默认 99，用户代码运行时间:垃圾收集时间=99:1。

**3、** CMS，追求垃圾收集暂停时间尽可能短，适用于服务端较大内存且多 CPU 的应用，使用参数 -XX:+UseConcMarkSweepGC 显式开启，会同时作用年轻代与老年代，但有浮动垃圾和内存碎片化的问题。

**4、** G1，主要面向服务端应用的垃圾收集器，适用于具有大内存的多核 CPU 的服务器，追求较小的垃圾收集暂停时间和较高的吞吐量。首创局部内存回收设计思路，采用不同策略实现分代，不再使用固定大小、固定数量的堆内存分代区域划分，而是基于 Region 内存布局，优先回收价收益最大的 Region。使用参数 -XX:+UseG1GC 开启。

**我们生产环境使用了 G1 收集器，相关配置如下**

**1、** -Xmx12g

**2、** -Xms12g

**3、** -XX:+UseG1GC

**4、** -XX:InitiatingHeapOccupancyPercent=45

**5、** -XX:MaxGCPauseMillis=200

**6、** -XX:MetaspaceSize=256m

**7、** -XX:MaxMetaspaceSize=256m

**8、** -XX:MaxDirectMemorySize=512m

**9、** -XX:G1HeapRegionSize 未指定

**核心思路：**

**1、** 每个内存区域设置上限，避免溢出

**2、** 堆设置为操作系统的 70%左右，超过 8 G，首选 G1

**3、** 根据老年代对象提升速度，调整新生代与老年代之间的内存比例

**4、** 等过 GC 信息，针对项目敏感指标优化，比如访问延迟、吞吐量等


### 6、如何实现字符串的反转及替换？



方法很多，可以自己写实现也可以使用String或StringBuffer/StringBuilder中的方法。有一道很常见的面试题是用递归实现字符串反转，代码如下所示：

```
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
```


### 7、64 位 JVM 中，int 的长度是多数？

Java 中，int 类型变量的长度是一个固定值，与平台无关，都是 32 位。意思就是说，在 32 位 和 64 位 的Java 虚拟机中，int 类型的长度是相同的。


### 8、并发队列和并发集合的区别：

那就有可能要说了，我们并发集合不是也可以实现多线程之间的数据共享吗，其实也是有区别的：

队列遵循“先进先出”的规则，可以想象成排队检票，队列一般用来解决大数据量采集处理和显示的。

并发集合就是在多个线程中共享数据的


### 9、HashMap为什么不直接使用hashCode()处理后的哈希值直接作为table的下标？

`hashCode()`方法返回的是int整数类型，其范围为-(2 ^ 31)~(2 ^ 31 - 1)，约有40亿个映射空间，而HashMap的容量范围是在16（初始化默认值）~2 ^ 30，HashMap通常情况下是取不到最大值的，并且设备上也难以提供这么多的存储空间，从而导致通过`hashCode()`计算出的哈希值可能不在数组大小范围内，进而无法匹配存储位置；

**那怎么解决呢？**

**1、** HashMap自己实现了自己的`hash()`方法，通过两次扰动使得它自己的哈希值高低位自行进行异或运算，降低哈希碰撞概率也使得数据分布更平均；

**2、** 在保证数组长度为2的幂次方的时候，使用`hash()`运算之后的值与运算（&）（数组长度 - 1）来获取数组下标的方式进行存储，这样一来是比取余操作更加有效率，二来也是因为只有当数组长度为2的幂次方时，h&(length-1)才等价于h%length，三来解决了“哈希值与数组大小范围不匹配”的问题；


### 10、有什么堆外内存的排查思路？

进程占用的内存，可以使用top命令，看RES段占用的值。如果这个值大大超出我们设定的最大堆内存，则证明堆外内存占用了很大的区域。

使用gdb可以将物理内存dump下来，通常能看到里面的内容。更加复杂的分析可以使用perf工具，或者谷歌开源的gperftools。那些申请内存最多的native函数，很容易就可以找到。


### 11、Jsp指令有那些？
### 12、java 中 IO 流分为几种？
### 13、是否了解连接池，使用连接池有什么好处？
### 14、当一个线程进入一个对象的synchronized方法A之后，其它线程是否可进入此对象的synchronized方法B？
### 15、在Java中，如何跳出当前的多重嵌套循环？
### 16、如何进行单元测试
### 17、什么是工厂模式
### 18、HashMap 的长度为什么是2的幂次方
### 19、如何判断一个类是无用的类?
### 20、volatile 关键字的作用
### 21、如何确保线程安全？
### 22、Collection 和 Collections 有什么区别？
### 23、为什么wait()方法和notify()/notifyAll()方法要在同步块中被调用
### 24、如何通过反射获取和设置对象私有字段的值？
### 25、日期和时间：
### 26、Java 中怎样将 bytes 转换为 long 类型？
### 27、import java和javax有什么区别
### 28、用 Java 写一个线程安全的单例模式（Singleton）？
### 29、Java线程池中submit() 和 execute()方法有什么区别？
### 30、如何实现数组和 List 之间的转换？
### 31、抽象类必须要有抽象方法吗
### 32、你对线程优先级的理解是什么？
### 33、你知道哪些JVM性能调优
### 34、Java 中用到的线程调度算法是什么？
### 35、程序计数器(线程私有)
### 36、String str=”aa”,String s=”bb”,String aa=aa+s;一种创建了几个对象？
### 37、如何实现对象克隆？
### 38、说说类加载的过程
### 39、并发队列的常用方法
### 40、解释什么是Tomcat Valve?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
