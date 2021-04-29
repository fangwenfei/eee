# Java最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在老年代-标记整理算法

因为对象存活率高、没有额外空间对它进行分配担保, 就必须采用“标记—清理”或“标记—整理” 算法来进行回收, 不必进行内存复制, 且直接腾出空闲内存。


### 2、堆的作用是什么？

**堆**是虚拟机所管理的内存中最大的一块，被所有线程共享的，在虚拟机启动时创建。堆用来存放对象实例，Java 里几乎所有对象实例都在堆分配内存。堆可以处于物理上不连续的内存空间，逻辑上应该连续，但对于例如数组这样的大对象，多数虚拟机实现出于简单、存储高效的考虑会要求连续的内存空间。

堆既可以被实现成固定大小，也可以是可扩展的，可通过 `-Xms` 和 `-Xmx` 设置堆的最小和最大容量，当前主流 JVM 都按照可扩展实现。如果堆没有内存完成实例分配也无法扩展，抛出 OutOfMemoryError。


### 3、什么情况发生栈溢出？

-Xss可以设置线程栈的大小，当线程方法递归调用层次太深或者栈帧中的局部变量过多时，会出现栈溢出错误 java.lang.StackOverflowError


### 4、插入数据时 ArrayList、LinkedList、Vector谁速度较快？

阐述 ArrayList、Vector、LinkedList 的存储性能和特性？

**1、** ArrayList和Vector 底层的实现都是使用数组方式存储数据。数组元素数大于实际存储的数据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢。

**2、** Vector 中的方法由于加了 synchronized 修饰，因此Vector** **是线程安全容器，但性能上较ArrayList差

**3、** LinkedList 使用双向链表实现存储，按序号索引数据需要进行前向或后向遍历，但插入数据时只需要记录当前项的前后项即可，所以 **LinkedList** **插入速度较快**。


### 5、什么是不可变对象（immutable object）？Java 中怎么创建一个不可变对象？

不可变对象指对象一旦被创建，状态就不能再改变。任何修改都会创建一个新的对象，如 String、Integer及其它包装类。详情参见答案，一步一步指导你在 Java 中创建一个不可变的类。


### 6、你平时工作中用过的JVM常用基本配置参数有哪些？

**-Xms**

初始化大小内存，默认为物理内存1/64

等价于-XX:InitialHeapSize

**-Xmx**

最大分配内存，默认物理内存的1/4

等价于-XX:MaxHeapSize

**-Xss**

设置单个线程栈的大小，一般默认为512K~1024K

等价于-XX:ThreadStackSize

-XX:ThreadStackSize = 0 ， 表示使用默认512K~1024K

-XX:ThreadStackSize != 0 , 表示使用自己设置的

**-Xmn**

设置年轻代大小,一般不需要改动

**-Xms128m -Xmx4096m -Xss1024k -XX:MetaSpaceSize=512m -XX:+PrintCommandFlags -XX:+PrintGCDetails -XX:+UseSerialGC**

**-XX:MetaspaceSize**

元空间的本质和永久代类似，都是对JVM规范中方法区的实现。

不过元空间与永久代之间最大的区别在于：

永久代在堆里面

元空间并不在虚拟机中，而是使用本地内存。

因此，在默认情况下，元空间的大小仅受本地内存限制

eg:

Xms10m -Xmx10m -XX:MetaspaceSize=1024m -XX:+PrintFlagsFinal

初始值约21M，也就是说只占用本地内存的21M，如果你频繁的new对象，有可能就会把元空间撑爆从而发生元空间异常，因此需要调大一些

-XX:+PrintGCDetails

你只需要记忆10个左右即可应付`绝大多数`面试，建议只记忆G1相关参数。CMS这种既耗时间参数又多又被淘汰的东西，不看也罢。面试时间有限，不会在这上面纠结，除非你表现的太嚣张了。


### 7、什么时候使用模板方法

实现一些操作时，整体步骤很固定，但是呢。就是其中一小部分需要改变，这时候可以使用模板方法模式，将容易变的部分抽象出来，供子类实现。


### 8、JVM 有哪些运行时内存区域？
### 9、Java中的同步集合与并发集合有什么区别？
### 10、在进行数据库编程时，连接池有什么作用？
### 11、线程与进程的区别？
### 12、谈谈 JVM 中的常量池
### 13、并行和并发有什么区别？
### 14、JVM 的内存模型以及分区情况和作用
### 15、有哪些打破了双亲委托机制的案例？
### 16、可以描述一下 class 文件的结构吗？
### 17、Java 中怎么创建 ByteBuffer？
### 18、打印昨天的当前时刻。
### 19、HashMap的put方法的具体流程？
### 20、java 面向对象编程三大特性------封装、继承、多态
### 21、你知道哪些内存分配与回收策略？
### 22、说说CMS垃圾收集器的工作原理
### 23、Thow与thorws区别
### 24、内存溢出和内存泄漏的区别？
### 25、怎么检测一个线程是否拥有锁？
### 26、JVM 内存区域
### 27、请你谈谈对OOM的认识
### 28、JVM的引用类型有哪些？
### 29、GC 是什么？为什么要有 GC？
### 30、访问修饰符public,private,protected,以及不写（默认）时的区别？
### 31、如何让正在运行的线程暂停一段时间？
### 32、并发编程有什么缺点
### 33、final、finalize()、finally，作用
### 34、什么是隐式转换，什么是显式转换
### 35、如何实现数组和 List 之间的转换？
### 36、Executors类是什么？
### 37、JRE、JDK、JVM 及 JIT 之间有什么不同？
### 38、OOP 中的 组合、聚合和关联有什么区别？
### 39、线程池的优点？
### 40、接口是什么？为什么要使用接口而不是直接使用具体类？
### 41、请解释一下MAC代表什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
