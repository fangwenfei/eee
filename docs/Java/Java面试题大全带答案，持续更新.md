# Java面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、创建线程的有哪些方式？

**1、** 继承Thread类创建线程类

**2、** 通过Runnable接口创建线程类

**3、** 通过Callable和Future创建线程

**4、** 通过线程池创建


### 2、请说明select * from tab的输出结果是什么?

显示数据库中的默认表


### 3、你对线程优先级的理解是什么？

**1、** 每一个线程都是有优先级的，一般来说，高优先级的线程在运行时会具有优先权，但这依赖于线程调度的实现，这个实现是和操作系统相关的(OS dependent)。我们可以定义线程的优先级，但是这并不能保证高优先级的线程会在低优先级的线程前执行。线程优先级是一个 int 变量(从 1-10)，1 代表最低优先级，10 代表最高优先级。

**2、** Java 的线程优先级调度会委托给操作系统去处理，所以与具体的操作系统优先级有关，如非特别需要，一般无需设置线程优先级。

**3、** 当然，如果你真的想设置优先级可以通过setPriority()方法设置，但是设置了不一定会该变，这个是不准确的


### 4、你说你做过JVM参数调优和参数配置，请问如何查看JVM系统默认值

使用-XX:+PrintFlagsFinal参数可以看到参数的默认值。这个默认值还和垃圾回收器有关，比如UseAdaptiveSizePolicy。


### 5、为什么wait(), notify()和notifyAll ()必须在同步方法或者同步块中被调用？

当一个线程需要调用对象的wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的notify()方法。同样的，当一个线程需要调用对象的notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。


### 6、接口与抽象类有什么区别？

**1、** 抽象类有构造方法，接口没有构造方法

**2、** 抽象类只能单继承，接口可以多继承

**3、** 抽象类可以有普通方法，接口中的所有方法都是抽象方法

**4、** 接口的属性都是public static final修饰的，而抽象的不是


### 7、Java 中会存在内存泄漏吗，请简单描述。



理论上Java因为有垃圾回收机制（GC）不会存在内存泄露问题（这也是Java被广泛使用于服务器端编程的一个重要原因）；然而在实际开发中，可能会存在无用但可达的对象，这些对象不能被GC回收，因此也会导致内存泄露的发生。例如Hibernate的Session（一级缓存）中的对象属于持久态，垃圾回收器是不会回收这些对象的，然而这些对象中可能存在无用的垃圾对象，如果不及时关闭（close）或清空（flush）一级缓存就可能导致内存泄露。下面例子中的代码也会导致内存泄露。

```
import java.util.Arrays;
import java.util.EmptyStackException;

public class MyStack<T> {
    private T[] elements;
    private int size = 0;

    private static final int INIT_CAPACITY = 16;

    public MyStack() {
        elements = (T[]) new Object[INIT_CAPACITY];
    }

    public void push(T elem) {
        ensureCapacity();
        elements[size++] = elem;
    }

    public T pop() {
        if(size == 0) 
            throw new EmptyStackException();
        return elements[--size];
    }

    private void ensureCapacity() {
        if(elements.length == size) {
            elements = Arrays.copyOf(elements, 2 * size + 1);
        }
    }
}
```

上面的代码实现了一个栈（先进后出（FILO））结构，乍看之下似乎没有什么明显的问题，它甚至可以通过你编写的各种单元测试。然而其中的pop方法却存在内存泄露的问题，当我们用pop方法弹出栈中的对象时，该对象不会被当作垃圾回收，即使使用栈的程序不再引用这些对象，因为栈内部维护着对这些对象的过期引用（obsolete reference）。在支持垃圾回收的语言中，内存泄露是很隐蔽的，这种内存泄露其实就是无意识的对象保持。如果一个对象引用被无意识的保留起来了，那么垃圾回收器不会处理这个对象，也不会处理该对象引用的其他对象，即使这样的对象只有少数几个，也可能会导致很多的对象被排除在垃圾回收之外，从而对性能造成重大影响，极端情况下会引发Disk Paging（物理内存与硬盘的虚拟内存交换数据），甚至造成OutOfMemoryError。


### 8、什么情况下会违反迪米特法则？为什么会有这个问题？
### 9、程序的结构有那些？
### 10、什么是线程调度器(Thread Scheduler)和时间分片(Time Slicing)？
### 11、什么是单例
### 12、策略模式的优点和缺点
### 13、列举一些你知道的打破双亲委派机制的例子。为什么要打破？
### 14、迭代器 Iterator 是什么？
### 15、jspservlet中通信作用域有那些？
### 16、垃圾回收的优点和原理。说说2种回收机制
### 17、String str=”aa”,String s=”bb”,String aa=aa+s;一种创建了几个对象？
### 18、怎么获取 Java 程序使用的内存？堆使用的百分比？
### 19、Sql中delete与truncate的区别
### 20、用 wait-notify 写一段代码来解决生产者-消费者问题？
### 21、遇到过堆外内存溢出吗？
### 22、什么情况会造成元空间溢出？
### 23、Minor GC与Full GC分别在什么时候发生？
### 24、怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？
### 25、死锁的原因
### 26、JVM 如何确定垃圾对象？
### 27、如何测试静态方法？()
### 28、如果对象的引用被置为null，垃圾收集器是否会立即释放对象占用的内存？
### 29、stackoverflow错误，permgen space错误
### 30、JRE、JDK、JVM 及 JIT 之间有什么不同？
### 31、在使用jdbc的时候，如何防止出现sql注入的问题。
### 32、不可变对象对多线程有什么帮助
### 33、int和Integer有什么区别？
### 34、一个线程运行时发生异常会怎样？
### 35、常用的并发工具类有哪些？
### 36、Java中用到的线程调度算法是什么？
### 37、HashMap在JDK1.7和JDK1.8中有哪些不同？HashMap的底层实现
### 38、构造方法能不能重写？能不能重载？
### 39、并发关键字 synchronized ？
### 40、解释什么是Tomcat Valve?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
