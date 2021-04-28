# Java最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是 FutureTask

FutureTask 表示一个异步运算的任务。FutureTask 里面可以传入一个 Callable 的具体实现类，可以对这个异步运算的任务的结果进行等待获取、判断是否已经完成、取消任务等操作。只有当运算完成的时候结果才能取回，如果运算尚未完成 get 方法将会阻塞。一个 FutureTask 对象可以对调用了 Callable 和 Runnable 的对象进行包装，由于 FutureTask 也是Runnable 接口的实现类，所以 FutureTask 也可以放入线程池中。


### 2、当一个线程进入一个对象的 synchronized 方法 A 之后，其它线程是否可进入此对象的 synchronized 方法 B？

不能。其它线程只能访问该对象的非同步方法，同步方法则不能进入。因为非静态方法上的 synchronized 修饰符要求执行方法时要获得对象的锁，如果已经进入A 方法说明对象锁已经被取走，那么试图进入 B 方法的线程就只能在等锁池（注意不是等待池哦）中等待对象的锁。


### 3、你了解过哪些垃圾收集器？

年轻代 Serial 垃圾收集器（单线程，通常用在客户端应用上。因为客户端应用不会频繁创建很多对象，用户也不会感觉出明显的卡顿。相反，它使用的资源更少，也更轻量级。） ParNew 垃圾收集器（多线程，追求降低用户停顿时间，适合交互式应用。） Parallel Scavenge 垃圾收集器（追求 CPU 吞吐量，能够在较短时间内完成指定任务，适合没有交互的后台计算。）

老年代 Serial Old 垃圾收集器 Parallel Old垃圾收集器 CMS 垃圾收集器（以获取最短 GC 停顿时间为目标的收集器，它在垃圾收集时使得用户线程和 GC 线程能够并发执行，因此在垃圾收集过程中用户也不会感到明显的卡顿。）


### 4、集合的特点

集合的特点主要有如下两点：


### 5、方法区溢出的原因？

方法区主要存放类型信息，如类名、访问修饰符、常量池、字段描述、方法描述等。只要不断在运行时产生大量类，方法区就会溢出。例如使用 JDK 反射或 CGLib 直接操作字节码在运行时生成大量的类。很多框架如 Spring、Hibernate 等对类增强时都会使用 CGLib 这类字节码技术，增强的类越多就需要越大的方法区保证动态生成的新类型可以载入内存，也就更容易导致方法区溢出。

JDK8 使用元空间取代永久代，HotSpot 提供了一些参数作为元空间防御措施，例如 `-XX:MetaspaceSize` 指定元空间初始大小，达到该值会触发 GC 进行类型卸载，同时收集器会对该值进行调整，如果释放大量空间就适当降低该值，如果释放很少空间就适当提高。


### 6、串行(serial)收集器和吞吐量(throughput)收集器的区别是什么？

吞吐量收集器使用并行版本的新生代垃圾收集器，它用于中等规模和大规模数据的应用程序。而串行收集器对大多数的小应用(在现代处理器上需要大概100M左右的内存)就足够了。


### 7、强引用、软引用、弱引用、虚引用是什么，有什么区别？

**1、** 强引用，就是普通的对象引用关系，如 String s = new String("ConstXiong")

**2、** 软引用，用于维护一些可有可无的对象。只有在内存不足时，系统则会回收软引用对象，如果回收了软引用对象之后仍然没有足够的内存，才会抛出内存溢出异常。SoftReference 实现

**3、** 弱引用，相比软引用来说，要更加无用一些，它拥有更短的生命周期，当 JVM 进行垃圾回收时，无论内存是否充足，都会回收被弱引用关联的对象。WeakReference 实现

**4、** 虚引用是一种形同虚设的引用，在现实场景中用的不是很多，它主要用来跟踪对象被垃圾回收的活动。PhantomReference 实现


### 8、Java中异常分为哪两种？

**1、** 编译时异常

**2、** 运行时异常


### 9、如何让正在运行的线程暂停一段时间？

我们可以使用Thread类的Sleep()方法让线程暂停一段时间。需要注意的是，这并不会让线程终止，一旦从休眠中唤醒线程，线程的状态将会被改变为Runnable，并且根据线程调度，它将得到执行。


### 10、如果父类只有有参构造方法，那么子类必须要重写父类的构造方法吗？

必须重写


### 11、Semaphore有什么作用
### 12、Java 中，受检查异常 和 不受检查异常的区别？
### 13、什么时候使用组合模式？
### 14、类加载器双亲委派模型机制？
### 15、一个类的构造方法的作用是什么？若一个类没有声明构造方法，改程序能正确执行吗？为什么？
### 16、请解释一下MAC代表什么?
### 17、什么是自旋
### 18、Java 中，Maven 和 ANT 有什么区别？
### 19、代理的分类
### 20、Java中的ReadWriteLock是什么？
### 21、对象都是优先分配在年轻代上的吗？
### 22、用最有效率的方法计算2乘以8？
### 23、游标的创建步骤？
### 24、Hibernate中SessionFactory是线程安全的吗？Session是线程安全的吗（两个线程能够共享同一个Session吗）？
### 25、使用js获取一个表单元素
### 26、什么情况下会发生栈溢出？
### 27、怎么检查一个字符串只包含数字？解决方案
### 28、重载（Overload）和重写（Override）的区别。重载的方法能否根据返回类型进行区分？
### 29、GC日志的real、user、sys是什么意思？
### 30、ArrayList 和 Vector 的区别是什么？
### 31、TCP 协议与 UDP 协议有什么区别？
### 32、堆（Heap-线程共享） -运行时数据区
### 33、你都有哪些手段用来排查内存溢出？
### 34、什么是可重入锁（ReentrantLock）？
### 35、线程池中 submit() 和 execute() 方法有什么区别？
### 36、Session与cookie的区别？
### 37、什么是上下文切换?
### 38、有没有可能两个不相等的对象有有相同的 hashcode？
### 39、怎么看死锁的线程？
### 40、JVM 选项 -XX:+UseCompressedOops 有什么作用？为什么要使用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
