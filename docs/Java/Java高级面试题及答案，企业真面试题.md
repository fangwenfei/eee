# Java高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是线程同步和线程互斥，有哪几种实现方式？

**1、** 当一个线程对共享的数据进行操作时，应使之成为一个”原子操作“，即在没有完成相关操作之前，不允许其他线程打断它，否则，就会破坏数据的完整性，必然会得到错误的处理结果，这就是线程的同步。

**2、** 在多线程应用中，考虑不同线程之间的数据同步和防止死锁。当两个或多个线程之间同时等待对方释放资源的时候就会形成线程之间的死锁。为了防止死锁的发生，需要通过同步来实现线程安全。

**3、** 线程互斥是指对于共享的进程系统资源，在各单个线程访问时的排它性。当有若干个线程都要使用某一共享资源时，任何时刻最多只允许一个线程去使用，其它要使用该资源的线程必须等待，直到占用资源者释放该资源。线程互斥可以看成是一种特殊的线程同步。

**4、** 线程间的同步方法大体可分为两类：用户模式和内核模式。顾名思义，内核模式就是指利用系统内核对象的单一性来进行同步，使用时需要切换内核态与用户态，而用户模式就是不需要切换到内核态，只在用户态完成操作。

**5、** 用户模式下的方法有：

原子操作（例如一个单一的全局变量），临界区。内核模式下的方法有：事件，信号量，互斥量。

**实现线程同步的方法**

**1、** 同步代码方法：sychronized 关键字修饰的方法

**2、** 同步代码块：sychronized 关键字修饰的代码块

**3、** 使用特殊变量域volatile实现线程同步：volatile关键字为域变量的访问提供了一种免锁机制

**4、** 使用重入锁实现线程同步：reentrantlock类是可冲入、互斥、实现了lock接口的锁他与sychronized方法具有相同的基本行为和语义


### 2、JVM 运行时内存

Java 堆从 GC 的角度还可以细分为: 新生代(Eden 区、 From Survivor 区和 To Survivor 区)和老年代。

**新生代**

是用来存放新生的对象。一般占据堆的 1/3 空间。由于频繁创建对象，所以新生代会频繁触发MinorGC 进行垃圾回收。新生代又分为 Eden区、 ServivorFrom、 ServivorTo 三个区。

**Eden 区**

Java 新对象的出生地（如果新创建的对象占用内存很大，则直接分配到老年代）。当 Eden 区内存不够的时候就会触发 MinorGC，对新生代区进行一次垃圾回收。

**ServivorFrom**

上一次 GC 的幸存者，作为这一次 GC 的被扫描者。

**ServivorTo**

保留了一次 MinorGC 过程中的幸存者。

**MinorGC 的过程（复制->清空->互换）**

MinorGC 采用复制算法。

**eden、 servicorFrom 复制到 ServicorTo，年龄+1**

首先，把 Eden 和 ServivorFrom 区域中存活的对象复制到 ServicorTo 区域（如果有对象的年龄以及达到了老年的标准，则赋值到老年代区），同时把这些对象的年龄+1（如果 ServicorTo 不够位置了就放到老年区）；

**清空 eden、 servicorFrom**

然后，清空 Eden 和 ServicorFrom 中的对象；

**ServicorTo 和 ServicorFrom 互换**

最后， ServicorTo 和 ServicorFrom 互换，原 ServicorTo 成为下一次 GC 时的 ServicorFrom区。


### 3、什么是同步任务？什么是异步任务？

**1、** 同步任务：当前任务没有完成之前，其他任务不能够执行

**2、** 异步任务：当前任务没有完成，任然可以可以发送一个新的请求


### 4、重排序实际执行的指令步骤

![87_5.png][87_5.png]

**1、** 编译器优化的重排序。编译器在不改变单线程程序语义的前提下，可以重新安排语句的执行顺序。

**2、** 指令级并行的重排序。现代处理器采用了指令级并行技术（ILP）来将多条指令重叠执行。如果不存在数据依赖性，处理器可以改变语句对应机器指令的执行顺序。

**3、** 内存系统的重排序。由于处理器使用缓存和读/写缓冲区，这使得加载和存储操作看上去可能是在乱序执行。

这些重排序对于单线程没问题，但是多线程都可能会导致多线程程序出现内存可见性问题。


### 5、WeakHashMap 是怎么工作的？

WeakHashMap 的工作与正常的 HashMap 类似，但是使用弱引用作为 key，意思就是当 key 对象没有任何引用时，key/value 将会被回收。


### 6、什么是重排序

程序执行的顺序按照代码的先后顺序执行。

一般来说处理器为了提高程序运行效率，可能会对输入代码进行优化，进行重新排序（重排序），它不保证程序中各个语句的执行先后顺序同代码中的顺序一致，但是它会保证程序最终执行结果和代码顺序执行的结果是一致的。

```
int a = 5;//语句1
int r = 3;//语句2
a = a + 2;//语句3
r = a*a;  //语句4
```

则因为重排序，他还可能执行顺序为（这里标注的是语句的执行顺序） 2-1-3-4，1-3-2-4 但绝不可能 2-1-4-3，因为这打破了依赖关系。

显然重排序对单线程运行是不会有任何问题，但是多线程就不一定了，所以我们在多线程编程时就得考虑这个问题了。


### 7、Java 中的 LinkedList 是单向链表还是双向链表？

是双向链表，你可以检查 JDK 的源码。在 Eclipse，你可以使用快捷键 Ctrl + T，直接在编辑器中打开该类。


### 8、什么是方法重载？

方法的重载就是在同一个类中允许同时存在一个以上的同名方法，只要它们的参数个数或者类型不同即可。在这种情况下，该方法就叫被重载了，这个过程称为方法的重载（override）


### 9、创建线程的三种方式的对比？

**1、** 采用实现Runnable、Callable接口的方式创建多线程。

**优势是：**

线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。

在这种方式下，多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。

**劣势是：**

编程稍微复杂，如果要访问当前线程，则必须使用Thread.currentThread()方法。

**2、** 使用继承Thread类的方式创建多线程

**优势是：**

编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，直接使用this即可获得当前线程。

**劣势是：**

线程类已经继承了Thread类，所以不能再继承其他父类。

**3、** Runnable和Callable的区别

**1、** Callable规定（重写）的方法是call()，Runnable规定（重写）的方法是run()。

**2、** Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。

**3、** Call方法可以抛出异常，run方法不可以。

**4、** 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果。


### 10、Java 中，Comparator 与 Comparable 有什么不同？

Comparable 接口用于定义对象的自然顺序，而 comparator 通常用于定义用户定制的顺序。Comparable 总是只有一个，但是可以有多个 comparator 来定义对象的顺序。

65）为什么在重写 equals 方法的时候需要重写 hashCode 方法？([答案](http://javarevisited.blogspot.sg/2015/01/why-override-equals-hashcode-or-tostring-java.html))

因为有强制的规范指定需要同时重写 hashcode 与 equal 是方法，许多容器类，如 HashMap、HashSet 都依赖于 hashcode 与 equals 的规定。


### 11、老年代与标记复制算法
### 12、什么是过滤器？怎么创建一个过滤器
### 13、Java中有几种类型的流？
### 14、Collection 和 Collections 有什么区别？
### 15、什么是链表
### 16、Java 中能创建 volatile 数组吗？
### 17、synchronized、volatile、CAS比较
### 18、为什么 Java 中的 String 是不可变的（Immutable）？
### 19、栈帧里面包含哪些东西？
### 20、synchronized、volatile、CAS 比较
### 21、Hashtable 与 HashMap 有什么不同之处？
### 22、Java常用包有那些？
### 23、3*0.1 == 0.3 将会返回什么？true 还是 false？
### 24、volatile 类型变量提供什么保证？
### 25、Serial 与 Parallel GC之间的不同之处？
### 26、[@Before ](/Before ) 和 [@BeforeClass ](/BeforeClass ) 有什么区别？
### 27、List、Set、Map是否继承自Collection接口？
### 28、List 和 Set 的区别
### 29、请你谈谈对OOM的认识
### 30、什么是不可变对象（immutable object）？Java 中怎么创建一个不可变对象？
### 31、集合和数组的区别
### 32、事务的ACID是指什么？
### 33、a = a + b 与 a += b 的区别
### 34、方法区的作用是什么？
### 35、Java 虚拟机栈的作用？
### 36、Java 中，直接缓冲区与非直接缓冲器有什么区别？
### 37、什么是模板方法模式？
### 38、什么是设计模式
### 39、sleep方法和wait方法有什么区别?
### 40、JRE、JDK、JVM 及 JIT 之间有什么不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
