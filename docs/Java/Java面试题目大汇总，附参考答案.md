# Java面试题目大汇总，附参考答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、抽象类可以使用final修饰吗？

不可以。定义抽象类就是让其他继承的，而final修饰类表示该类不能被继承，与抽象类的理念违背了


### 2、JRE、JDK、JVM 及 JIT 之间有什么不同？

JRE 代表 Java 运行时（Java run-time），是运行 Java 引用所必须的。JDK 代表 Java 开发工具（Java development kit），是 Java 程序的开发工具，如 Java编译器，它也包含 JRE。JVM 代表 Java 虚拟机（Java virtual machine），它的责任是运行 Java 应用。JIT 代表即时编译（Just In Time compilation），当代码执行的次数超过一定的阈值时，会将 Java 字节码转换为本地代码，如，主要的热点代码会被准换为本地代码，这样有利大幅度提高 Java 应用的性能。


### 3、Java中Synchronized关键字的使用？

Synchronized关键字在方法签名上，可以防止多个线程同时访问这个对象的synchronized修饰的方法。如果一个对象有多个synchronized方法，只要一个线程访问其中的一个同步方法，那么其他线程就不能访问对象其他的任何一个同步方法。不同对象实例的synchronize方法是互不干扰的，也就是说，其他对象还可以访问这个类中的同步方法。

Synchronized如果修饰的是静态方法，防止多个线程同时访问这个类中的静态同步方法，它对类中所有对象都能起作用。也就是说，只有一个对象一个线程可以访问静态同步方法

Synchronized修饰方法中的某段代码块，只对当前代码块实行互斥访问。当多个线程同步访问同步代码块，同一时间只能有一个线程得到执行，其他线程必须等待当前线程执行完代码块之后才能执行。当一个线程访问同步代码快时，其他线程可以访问非同步的代码。当一个线程访问同步代码块时，那么其他线程访问对其他同步代码块的访问将会被阻塞

Synchronized关键字是不能继承的，如果父类的synchronized在继承时并不自动是synchronized修饰的，需要显示地声明。

Synchronized修饰this时，会得到这个对象的对象锁，当一个线程访问时，那么其他线程访问对象的所有同步代码块或者同步方法，将会被阻塞。


### 4、有什么堆外内存的排查思路？

进程占用的内存，可以使用top命令，看RES段占用的值。如果这个值大大超出我们设定的最大堆内存，则证明堆外内存占用了很大的区域。

使用gdb可以将物理内存dump下来，通常能看到里面的内容。更加复杂的分析可以使用perf工具，或者谷歌开源的gperftools。那些申请内存最多的native函数，很容易就可以找到。


### 5、假设把实例化的数组的变量当成方法参数，当方法执行的时候改变了数组内的元素，那么在方法外，数组元素有发生改变吗？

改变了，因为传递是对象的引用，操作的是引用所指向的对象


### 6、什么是TreeMap

**1、** TreeMap 是一个**有序的key-value集合**，它是通过红黑树实现的。

**2、** TreeMap基于**红黑树（Red-Black tree）实现**。该映射根据**其键的自然顺序进行排序**，或者根据**创建映射时提供的 Comparator 进行排序**，具体取决于使用的构造方法。

**3、** TreeMap是线程**非同步**的。


### 7、Java 中怎么打印数组？

你可以使用 Arrays.toString() 和 Arrays.deepToString() 方法来打印数组。由于数组没有实现 toString() 方法，所以如果将数组传递给 System.out.println() 方法，将无法打印出数组的内容，但是 Arrays.toString() 可以打印每个元素。


### 8、存储过程与函数的区别

**1、** 存储过程的关键自是procedure，函数关键字是function

**2、** 函数必须有返回值，存储过程没有返回值，但是有传出参数

**3、** 函数注重的是结果，存储过程注重的是过程

**4、** 函数可以在select语句中直接使用，而存储过程则不能


### 9、Java 中，编写多线程程序的时候你会遵循哪些最佳实践？

这是我在写Java 并发程序的时候遵循的一些最佳实践：

**1、** 给线程命名，这样可以帮助调试。

**2、** 最小化同步的范围，而不是将整个方法同步，只对关键部分做同步。

**3、** 如果可以，更偏向于使用 volatile 而不是 synchronized。

**4、** 使用更高层次的并发工具，而不是使用 wait() 和 notify() 来实现线程间通信，如 BlockingQueue，CountDownLatch 及 Semeaphore。

**5、** 优先使用并发集合，而不是对集合进行同步。并发集合提供更好的可扩展性。


### 10、本地方法区(线程私有)

本地方法区和 Java Stack 作用类似, 区别是虚拟机栈为执行 Java 方法服务, 而本地方法栈则为Native 方法服务, 如果一个 VM 实现使用 C-linkage 模型来支持 Native 调用, 那么该栈将会是一个C 栈，但 HotSpot VM 直接就把本地方法栈和虚拟机栈合二为一 。


### 11、List 和 Set 的区别
### 12、volatile 类型变量提供什么保证？
### 13、什么是阻塞式方法？
### 14、如何判断两个类是否相等？
### 15、乐观锁和悲观锁的理解及如何实现，有哪些实现方式？
### 16、说下有哪些类加载器？
### 17、在老年代-标记整理算法
### 18、setState到底是异步还是同步?
### 19、为什么需要双亲委派模式？
### 20、Java 中 LinkedHashMap 和 PriorityQueue 的区别是什么？
### 21、JVM新生代中为什么要分为Eden和Survivor？
### 22、String 是最基本的数据类型吗？
### 23、什么是竞争条件？你怎样发现和解决竞争？
### 24、Array 和 ArrayList 有何区别？
### 25、当父类引用指向子类对象的时候，子类重写了父类方法和属性，那么当访问属性的时候，访问是谁的属性？调用方法时，调用的是谁的方法？
### 26、形参与实参
### 27、什么是过滤器？怎么创建一个过滤器
### 28、Java 中的final关键字有哪些用法？
### 29、能否使用任何类作为 Map 的 key？
### 30、串行（serial）收集器和吞吐量（throughput）收集器的区别是什么？
### 31、双亲委派
### 32、什么是观察者模式
### 33、栈溢出的原因？
### 34、HashMap的扩容操作是怎么实现的？
### 35、内部类与静态内部类的区别？
### 36、能够找到 Reference Chain 的对象，就一定会存活么？
### 37、HashMap中的key，可以是普通对象么？需要什么注意的地方？
### 38、插入数据时 ArrayList、LinkedList、Vector谁速度较快？
### 39、怎么打破双亲委派模型？
### 40、死锁与活锁的区别，死锁与饥饿的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
