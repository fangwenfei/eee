# Java最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是Executors框架？

Executor框架是一个根据一组执行策略调用，调度，执行和控制的异步任务的框架。

无限制的创建线程会引起应用程序内存溢出。所以创建一个线程池是个更好的的解决方案，因为可以限制线程的数量并且可以回收再利用这些线程。利用Executors框架可以非常方便的创建一个线程池。


### 2、方法区

又称非堆区,用于存储已被虚拟机加载的类信息,常量,静态变量,即时编译器优化后的代码等数据.1.7的永久代和1.8的元空间都是方法区的一种实现。


### 3、为什么 Thread 类的 sleep()和 yield ()方法是静态的？

Thread 类的 sleep()和 yield()方法将在当前正在执行的线程上运行。所以在其他处于等待状态的线程上调用这些方法是没有意义的。这就是为什么这些方法是静态的。它们可以在当前正在执行的线程中工作，并避免程序员错误的认为可以在其他非运行线程调用这些方法。


### 4、JDK 和 JRE 有什么区别？

JDK：Java Development Kit 的简称，java 开发工具包，提供了 java 的开发环境和运行环境。

JRE：Java Runtime Environment 的简称，java 运行环境，为 java 的运行提供了所需环境。 具体来说 JDK 其实包含了 JRE，同时还包含了编译 java 源码的编译器 javac，还包含了很多 java 程序调试和分析的工具。简单来说：如果你需要运行 java 程序，只需安装 JRE 就可以了，如果你需要编写 java 程序，需要安装 JDK。


### 5、JVM 选项 -XX:+UseCompressedOops 有什么作用？为什么要使用？

当你将你的应用从 32 位的 JVM 迁移到 64 位的 JVM 时，由于对象的指针从 32 位增加到了 64 位，因此堆内存会突然增加，差不多要翻倍。这也会对 CPU 缓存（容量比内存小很多）的数据产生不利的影响。因为，迁移到 64 位的 JVM 主要动机在于可以指定最大堆大小，通过压缩 OOP 可以节省一定的内存。通过 -XX:+UseCompressedOops 选项，JVM 会使用 32 位的 OOP，而不是 64 位的 OOP。


### 6、Collection和Collections的区别？



Collection是一个接口，它是Set、List等容器的父接口；Collections是个一个工具类，提供了一系列的静态方法来辅助容器操作，这些方法包括对容器的搜索、排序、线程安全化等等。


### 7、在 Java 程序中怎么保证多线程的运行安全？

**1、** 使用安全类，比如 java.util.concurrent 下的类，使用原子类AtomicInteger

**2、** 使用自动锁 synchronized。

**3、** 使用手动锁 Lock。

**手动锁 Java 示例代码如下：**

```
Lock lock = new ReentrantLock();
    lock、lock();

    try {
        System、out、println("获得锁");
            } catch (Exception e) {
            // TODO: handle exception
    } finally {
    System、out、println("释放锁");

    lock、unlock();
}
```


### 8、栈帧都有哪些数据？

JVM的运行是基于栈的，和C语言的栈类似，它的大多数数据都是在堆里面的，只有少部分运行时的数据存在于栈上。

在JVM中，每个线程栈里面的元素，就叫`栈帧`。

栈帧包含：局部变量表、操作数栈、动态连接、返回地址等。


### 9、List 和 Set 的区别

List , Set 都是继承自Collection 接口

**1、** List 特点：一个有序（元素存入集合的顺序和取出的顺序一致）容器，元素可以重复，可以插入多个null元素，元素都有索引。常用的实现类有 ArrayList、LinkedList 和 Vector。

**2、** Set 特点：一个无序（存入和取出顺序有可能不一致）容器，不可以存储重复元素，只允许存入一个null元素，必须保证元素唯一性。Set 接口常用实现类是 HashSet、LinkedHashSet 以及 TreeSet。

**3、** 另外 List 支持for循环，也就是通过下标来遍历，也可以用迭代器，但是set只能用迭代，因为他无序，无法用下标来取得想要的值。

Set和List对比

**1、** Set：检索元素效率低下，删除和插入效率高，插入和删除不会引起元素位置改变。

**2、** List：和数组类似，List可以动态增长，查找元素效率高，插入删除元素效率低，因为会引起其他元素位置改变


### 10、38、数据类型之间的转换：

1. 如何将字符串转换为基本数据类型？
2. 如何将基本数据类型转换为字符串？



1. 调用基本数据类型对应的包装类中的方法parseXXX(String)或valueOf(String)即可返回相应基本类型；
2. 一种方法是将基本数据类型与空字符串（”“）连接（+）即可获得其所对应的字符串；另一种方法是调用String 类中的valueOf()方法返回相应字符串


### 11、如何使用exception对象？
### 12、Java反射创建对象效率高还是通过new创建对象的效率高？
### 13、被引用的对象就一定能存活吗？
### 14、阐述final、finally、finalize的区别。
### 15、老年代
### 16、当一个线程进入一个对象的 synchronized 方法 A 之后，其它线程是否可进入此对象的 synchronized 方法 B？
### 17、原型模式的应用场景
### 18、复制算法（copying）
### 19、List接口有什么特点？
### 20、Jsp由哪些内容组成？
### 21、阐述ArrayList、Vector、LinkedList的存储性能和特性。
### 22、在老年代-标记整理算法
### 23、Hashtable 与 HashMap 有什么不同之处？
### 24、final、finalize()、finally，性质不同
### 25、谈一谈Hibernate的一级缓存、二级缓存和查询缓存。
### 26、我们能将 int 强制转换为 byte 类型的变量吗？如果该值大于 byte 类型的范围，将会出现什么现象？
### 27、如何修改tomcat的端口号？
### 28、垃圾回收的优点和原理。说说2种回收机制
### 29、请说明NAT协议的目的是什么?
### 30、怎么利用 JUnit 来测试一个方法的异常？
### 31、Executors类是什么？
### 32、详细介绍一下JVM内存模型
### 33、setState到底是异步还是同步?
### 34、请阐述Catalina的配置文件有哪些?
### 35、在java中wait和sleep方法的不同？
### 36、AQS支持两种同步方式：
### 37、Js如何实现动态效果？
### 38、什么情况下会发生栈内存溢出？
### 39、串行(serial)收集器和吞吐量(throughput)收集器的区别是什么？
### 40、JRE、JDK、JVM 及 JIT 之间有什么不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
