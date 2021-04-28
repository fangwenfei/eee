# Java高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是线程组，为什么在Java中不推荐使用？

ThreadGroup类，可以把线程归属到某一个线程组中，线程组中可以有线程对象，也可以有线程组，组中还可以有线程，这样的组织结构有点类似于树的形式。

为什么不推荐使用？因为使用有很多的安全隐患吧，没有具体追究，如果需要使用，推荐使用线程池。


### 2、什么情况下会违反迪米特法则？为什么会有这个问题？

迪米特法则建议“只和朋友说话，不要陌生人说话”，以此来减少类之间的耦合。


### 3、描述 Java 中的重载和重写？

重载和重写都允许你用相同的名称来实现不同的功能，但是重载是编译时活动，而重写是运行时活动。你可以在同一个类中重载方法，但是只能在子类中重写方法。重写必须要有继承。


### 4、四种构建线程池的区别及特点？

- newCachedThreadPool

**特点**：

newCachedThreadPool创建一个可缓存线程池，如果当前线程池的长度超过了处理的需要时，它可以灵活的回收空闲的线程，当需要增加时， 它可以灵活的添加新的线程，而不会对池的长度作任何限制

**缺点**：

他虽然可以无线的新建线程，但是容易造成堆外内存溢出，因为它的最大值是在初始化的时候设置为 Integer.MAX_VALUE，一般来说机器都没那么大内存给它不断使用。当然知道可能出问题的点，就可以去重写一个方法限制一下这个最大值

**总结**：

线程池为无限大，当执行第二个任务时第一个任务已经完成，会复用执行第一个任务的线程，而不用每次新建线程

- 代码示例：

```
package com.lijie;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class TestNewCachedThreadPool {
    public static void main(String[] args) {
        // 创建无限大小线程池，由jvm自动回收
        ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newCachedThreadPool.execute(new Runnable() {
                public void run() {
                    try {
                        Thread.sleep(100);
                    } catch (Exception e) {}
                    System.out.println(Thread.currentThread().getName() + ",i==" + temp);
                }
            });
        }
    }
}
```

- newFixedThreadPool

**特点**：

创建一个定长线程池，可控制线程最大并发数，超出的线程会在队列中等待。定长线程池的大小最好根据系统资源进行设置。

**缺点**：

线程数量是固定的，但是阻塞队列是无界队列。如果有很多请求积压，阻塞队列越来越长，容易导致OOM（超出内存空间）

**总结**：

请求的挤压一定要和分配的线程池大小匹配，定线程池的大小最好根据系统资源进行设置。如Runtime.getRuntime().availableProcessors()

`Runtime.getRuntime().availableProcessors()方法是查看电脑CPU核心数量）`

- 代码示例

```
package com.lijie;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestNewFixedThreadPool {
public static void main(String[] args) {
ExecutorService newFixedThreadPool = Executors.newFixedThreadPool(3);
for (int i = 0; i < 10; i++) {
final int temp = i;
newFixedThreadPool.execute(new Runnable() {
public void run() {
System.out.println(Thread.currentThread().getName() + ",i==" + temp);
}
});
}
}
}
```

- newScheduledThreadPool

**特点**：

创建一个固定长度的线程池，而且支持定时的以及周期性的任务执行，类似于Timer（Timer是Java的一个定时器类）

**缺点**：由于所有任务都是由同一个线程来调度，因此所有任务都是串行执行的，同一时间只能有一个任务在执行，前一个任务的延迟或异常都将会影响到之后的任务（比如：一个任务出错，以后的任务都无法继续）。

- 代码示例

```
package com.lijie;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
public class TestNewScheduledThreadPool {
    public static void main(String[] args) {
        //定义线程池大小为3
        ScheduledExecutorService newScheduledThreadPool = Executors.newScheduledThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int temp = i;
            newScheduledThreadPool.schedule(new Runnable() {
                public void run() {
                    System.out.println("i:" + temp);
                }
            }, 3, TimeUnit.SECONDS); //这里表示延迟3秒执行。
        }
    }
}
```

- newSingleThreadExecutor

**特点**：

创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务，如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它，他必须保证前一项任务执行完毕才能执行后一项。保证所有任务按照指定顺序(FIFO, LIFO, 优先级)执行。

**缺点**：

缺点的话，很明显，他是单线程的，高并发业务下有点无力

**总结**：

保证所有任务按照指定顺序执行的，如果这个唯一的线程因为异常结束，那么会有一个新的线程来替代它

- 代码示例

```
package com.lijie;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
public class TestNewSingleThreadExecutor {
    public static void main(String[] args) {
        ExecutorService newSingleThreadExecutor = Executors.newSingleThreadExecutor();
        for (int i = 0; i < 10; i++) {
            final int index = i;
            newSingleThreadExecutor.execute(new Runnable() {
                public void run() {
                    System.out.println(Thread.currentThread().getName() + " index:" + index);
                    try {
                        Thread.sleep(200);
                    } catch (Exception e) {}
                }
            });
        }
    }
}
```


### 5、JSP中的静态包含和动态包含有什么区别？

静态包含是通过JSP的include指令包含页面，动态包含是通过JSP标准动作  包含页面。

静态包含是编译时包含，如果包含的页面不存在则会产生编译错误，而且两个页面的"contentType"属性应保持一致，因为两个页面会合二为一，只产生一个class文件，因此被包含页面发生的变动再包含它的页面更新前不会得到更新。

动态包含是运行时包含，可以向被包含的页面传递参数，包含页面和被包含页面是独立的，会编译出两个class文件，如果被包含的页面不存在，不会产生编译错误，也不影响页面其他部分的执行。


### 6、说一下HashMap的实现原理？

**1、** HashMap概述： HashMap是基于哈希表的Map接口的非同步实现。此实现提供所有可选的映射操作，并允许使用null值和null键。此类不保证映射的顺序，特别是它不保证该顺序恒久不变。

**2、** HashMap的数据结构： 在Java编程语言中，最基本的结构就是两种，一个是数组，另外一个是模拟指针（引用），所有的数据结构都可以用这两个基本结构来构造的，HashMap也不例外。HashMap实际上是一个“链表散列”的数据结构，即数组和链表的结合体。

**HashMap 基于 Hash 算法实现的**

**1、** 当我们往HashMap中put元素时，利用key的hashCode重新hash计算出当前对象的元素在数组中的下标

**2、** 存储时，如果出现hash值相同的key，此时有两种情况。

(1)如果key相同，则覆盖原始值；

(2)如果key不同（出现冲突），则将当前的key-value放入链表中

**3、** 获取时，直接找到hash值对应的下标，在进一步判断key是否相同，从而找到对应值。

**4、** 理解了以上过程就不难明白HashMap是如何解决hash冲突的问题，核心就是使用了数组的存储方式，然后将冲突的key的对象放入链表中，一旦发现冲突就在链表中做进一步的对比。

需要注意Jdk 1.8中对HashMap的实现做了优化，当链表中的节点数据超过八个之后，该链表会转为红黑树来提高查询效率，从原来的O(n)到O(logn)


### 7、对象是怎么从年轻代进入老年代的？

这是老掉牙的题目了。在下面四种情况下，对象会从年轻代进入老年代。

**1、** 如果对象够老，会通过提升（Promotion）进入老年代，这一般是根据对象的年龄进行判断的。

**2、** 动态对象年龄判定。有的垃圾回收算法，比如G1，并不要求age必须达到15才能晋升到老年代，它会使用一些动态的计算方法。

**3、** 分配担保。当 Survivor 空间不够的时候，就需要依赖其他内存（指老年代）进行分配担保。这个时候，对象也会直接在老年代上分配。

**4、** 超出某个大小的对象将直接在老年代分配。不过这个值默认为0，意思是全部首选Eden区进行分配。


### 8、JDBC中如何进行事务处理？



Connection提供了事务处理的方法，通过调用setAutoCommit(false)可以设置手动提交事务；当事务完成后用commit()显式提交事务；如果在事务处理过程中发生异常则通过rollback()进行事务回滚。除此之外，从JDBC 3.0中还引入了Savepoint（保存点）的概念，允许通过代码设置保存点并让事务回滚到指定的保存点。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/03/img_3.png#alt=img%5C_3.png)


### 9、能否使用任何类作为 Map 的 key？

可以使用任何类作为 Map 的 key，然而在使用之前，需要考虑以下几点：

**1、** 如果类重写了 equals() 方法，也应该重写 hashCode() 方法。

**2、** 类的所有实例需要遵循与 equals() 和 hashCode() 相关的规则。

**3、** 如果一个类没有使用 equals()，不应该在 hashCode() 中使用它。

**4、** 用户自定义 Key 类最佳实践是使之为不可变的，这样 hashCode() 值可以被缓存起来，拥有更好的性能。不可变的类也可以确保 hashCode() 和 equals() 在未来不会改变，这样就会解决与可变相关的问题了。


### 10、如何通过反射创建对象？



**1、** 方法1：通过类对象调用newInstance()方法，例如：String.class.newInstance()

**2、** 方法2：通过类对象的getConstructor()或getDeclaredConstructor()方法获得构造器（Constructor）对象并调用其newInstance()方法创建对象，例如：String.class.getConstructor(String.class).newInstance(“Hello”);


### 11、你所知道网络协议有那些？
### 12、引用计数法
### 13、Files的常用方法都有哪些？
### 14、说一下堆和栈的区别
### 15、对象的内存布局了解吗？
### 16、Java 中，如何计算两个日期之间的差距？
### 17、如何停止一个正在运行的线程？
### 18、Static关键字有什么作用？
### 19、Java 中，受检查异常 和 不受检查异常的区别？
### 20、什么时候会触发FullGC
### 21、请说明NAT协议的目的是什么?
### 22、假设把实例化的数组的变量当成方法参数，当方法执行的时候改变了数组内的元素，那么在方法外，数组元素有发生改变吗？
### 23、三种代理的区别
### 24、MinorGC、MajorGC、FullGC 什么时候发生？
### 25、Serial 垃圾收集器（单线程、 复制算法）
### 26、并发编程有什么缺点
### 27、volatile 类型变量提供什么保证？
### 28、继承和组合之间有什么不同？
### 29、面向对象的特征有哪些方面？
### 30、死锁与活锁的区别，死锁与饥饿的区别？
### 31、游标的创建步骤？
### 32、什么是字节码？采用字节码的最大好处是什么？什么Java是虚拟机？
### 33、用 wait-notify 写一段代码来解决生产者-消费者问题？
### 34、redux中如何进行异步操作?
### 35、请说明select * from tab的输出结果是什么?
### 36、说说线程栈
### 37、在 Java 程序中怎么保证多线程的运行安全？
### 38、Java中notify 和 notifyAll有什么区别？
### 39、React有哪些优化性能是手段?
### 40、notify() 和 notifyAll() 有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
