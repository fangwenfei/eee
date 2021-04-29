# Java高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说说CMS垃圾收集器的工作原理

Concurrent mark sweep(CMS)收集器是一种年老代垃圾收集器，其最主要目标是获取最短垃圾回收停顿时间， 和其他年老代使用标记-整理算法不同，它使用多线程的标记-清除算法。最短的垃圾收集停顿时间可以为交互比较高的程序提高用户体验。CMS 工作机制相比其他的垃圾收集器来说更复杂

**整个过程分为以下 4 个阶段：**

**1、** 初始标记 只是标记一下 GC Roots 能直接关联的对象，速度很快，仍然需要暂停所有的工作线程。

**2、** 并发标记 进行 GC Roots 跟踪的过程，和用户线程一起工作，不需要暂停工作线程。

**3、** 重新标记 为了修正在并发标记期间，因用户程序继续运行而导致标记产生变动的那一部分对象的标记记录，仍然需要暂停所有的工作线程。

**4、** 并发清除 清除 GC Roots 不可达对象，和用户线程一起工作，不需要暂停工作线程。由于耗时最长的并发标记和并发清除过程中，垃圾收集线程可以和用户线程一起并发工作， 所以总体上来看CMS 收集器的内存回收和用户线程是一起并发地执行。


### 2、Java 中的同步集合与并发集合有什么区别？

同步集合与并发集合都为多线程和并发提供了合适的线程安全的集合，不过并发集合的可扩展性更高。在 Java1.5 之前程序员们只有同步集合来用且在多线程并发的时候会导致争用，阻碍了系统的扩展性。Java5 介绍了并发集合像ConcurrentHashMap，不仅提供线程安全还用锁分离和内部分区等现代技术提高了可扩展性。


### 3、什么是并发容器的实现？

何为同步容器：可以简单地理解为通过 synchronized 来实现同步的容器，如果有多个线程调用同步容器的方法，它们将会串行执行。比如 Vector，Hashtable，以及 Collections.synchronizedSet，synchronizedList 等方法返回的容器。可以通过查看 Vector，Hashtable 等这些同步容器的实现代码，可以看到这些容器实现线程安全的方式就是将它们的状态封装起来，并在需要同步的方法上加上关键字 synchronized。

并发容器使用了与同步容器完全不同的加锁策略来提供更高的并发性和伸缩性，例如在 ConcurrentHashMap 中采用了一种粒度更细的加锁机制，可以称为分段锁，在这种锁机制下，允许任意数量的读线程并发地访问 map，并且执行读操作的线程和写操作的线程也可以并发的访问 map，同时允许一定数量的写操作线程并发地修改 map，所以它可以在并发环境下实现更高的吞吐量。


### 4、如何自定义线程线程池?

先看ThreadPoolExecutor（线程池）这个类的构造参数

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_8.png#alt=87%5C_8.png)构造参数参数介绍：

```
corePoolSize 核心线程数量
maximumPoolSize 最大线程数量
keepAliveTime 线程保持时间，N个时间单位
unit 时间单位（比如秒，分）
workQueue 阻塞队列
threadFactory 线程工厂
handler 线程池拒绝策略
```

- 代码示例：

```
package com.lijie;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
public class Test001 {
    public static void main(String[] args) {
        //创建线程池
        ThreadPoolExecutor executor = new ThreadPoolExecutor(1, 2, 60L, TimeUnit.SECONDS, new ArrayBlockingQueue < > (3));
        for (int i = 1; i <= 6; i++) {
            TaskThred t1 = new TaskThred("任务" + i);
            //executor.execute(t1);是执行线程方法
            executor.execute(t1);
        }
        //executor.shutdown()不再接受新的任务，并且等待之前提交的任务都执行完再关闭，阻塞队列中的任务不会再执行。
        executor.shutdown();
    }
}
class TaskThred implements Runnable {
    private String taskName;
    public TaskThred(String taskName) {
        this.taskName = taskName;
    }
    public void run() {
        System.out.println(Thread.currentThread().getName() + taskName);
    }
}
```


### 5、创建一个对象用什么运算符？对象实体与对象引用有何不同？

new运算符，new创建对象实例（对象实例在堆内存中），对象引用指向对象实例（对象引用存放在栈内存中）。一个对象引用可以指向0个或1个对象（一根绳子可以不系气球，也可以系一个气球）;一个对象可以有n个引用指向它（可以用n条绳子系住一个气球）


### 6、Java中有几种数据类型

**1、** 整形：byte,short,int,long

**2、** 浮点型：float,double

**3、** 字符型：char

**4、** 布尔型：boolean


### 7、MinorGC、MajorGC、FullGC 什么时候发生？

**1、** MinorGC 在年轻代空间不足的时候发生

**2、** MajorGC 指的是老年代的 GC，出现 MajorGC 一般经常伴有 MinorGC

**3、** FullGC 老年代无法再分配内存；元空间不足；显示调用 System.gc；像 CMS 一类的垃圾回收器，在 MinorGC 出现 promotion failure 时也会发生 FullGC


### 8、如何将字符串反转？

使用 StringBuilder 或者 stringBuffer 的 reverse() 方法。

示例代码：

```
// StringBuffer reverse
StringBuffer stringBuffer = new StringBuffer();
stringBuffer.append("abcdefg");
System.out.println(stringBuffer.reverse()); // gfedcba
// StringBuilder reverse
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("abcdefg");
System.out.println(stringBuilder.reverse()); // gfedcba
```


### 9、ArrayList与LinkedList有什么区别？

**1、** ArrayList与LinkedList都实现了List接口。

**2、** ArrayList是线性表，底层是使用数组实现的，它在尾端插入和访问数据时效率较高，

**3、** Linked是双向链表，他在中间插入或者头部插入时效率较高，在访问数据时效率较低


### 10、synchronized 和 volatile 的区别是什么？

**1、** synchronized 表示只有一个线程可以获取作用对象的锁，执行代码，阻塞其他线程。

**2、** volatile 表示变量在 CPU 的寄存器中是不确定的，必须从主存中读取。保证多线程环境下变量的可见性；禁止指令重排序。

**区别**

**1、** volatile 是变量修饰符；synchronized 可以修饰类、方法、变量。

**2、** volatile 仅能实现变量的修改可见性，不能保证原子性；而 synchronized 则可以保证变量的修改可见性和原子性。

**3、** volatile 不会造成线程的阻塞；synchronized 可能会造成线程的阻塞。

**4、** volatile标记的变量不会被编译器优化；synchronized标记的变量可以被编译器优化。

**5、** volatile关键字是线程同步的轻量级实现，所以volatile性能肯定比synchronized关键字要好。但是volatile关键字只能用于变量而synchronized关键字可以修饰方法以及代码块。synchronized关键字在JavaSE1.6之后进行了主要包括为了减少获得锁和释放锁带来的性能消耗而引入的偏向锁和轻量级锁以及其它各种优化之后执行效率有了显著提升，实际开发中使用 synchronized 关键字的场景还是更多一些。


### 11、新生代与复制算法
### 12、对象在哪块内存分配？
### 13、虚拟DOM实现原理?
### 14、Java 中怎么获取一份线程 dump 文件？
### 15、用 Java 写一个线程安全的单例模式（Singleton）？
### 16、代理的分类
### 17、什么是并发容器的实现？
### 18、什么是上下文切换?
### 19、你对线程优先级的理解是什么？
### 20、重载和重写的区别
### 21、怎么看死锁的线程？
### 22、什么是隐式转换，什么是显式转换
### 23、线程的 run()和 start()有什么区别？
### 24、虚拟DOM的优劣如何?
### 25、什么是线程组，为什么在 Java 中不推荐使用？
### 26、事务的使用场景在什么地方？
### 27、多线程应用场景
### 28、Java中ConcurrentHashMap的并发度是什么？
### 29、GC 垃圾收集器
### 30、请说明select * from tab的输出结果是什么?
### 31、你能保证 GC 执行吗？
### 32、标记整理算法(Mark-Compact)
### 33、为什么我们调用start()方法时会执行run()方法，为什么我们不能直接调用run()方法？
### 34、CMS都有哪些问题？
### 35、Java线程池中submit() 和 execute()方法有什么区别？
### 36、什么是 CAS
### 37、Java是否需要开发人员回收内存垃圾吗？
### 38、工作中常用的 JVM 配置参数有哪些？
### 39、描述一下 JVM 加载 class 文件的原理机制
### 40、列举一些你知道的打破双亲委派机制的例子。为什么要打破？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
