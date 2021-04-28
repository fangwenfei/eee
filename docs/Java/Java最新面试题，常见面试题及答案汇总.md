# Java最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Collections.synchronized  是什么？

**注意：_ 号代表后面是还有内容的_

此方法是干什么的呢，他完完全全的可以把List、Map、Set接口底下的集合变成线程安全的集合

Collections.synchronized * ：原理是什么，我猜的话是代理模式：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_14.png#alt=87%5C_14.png)


### 2、什么是观察者模式

先讲什么是行为性模型，行为型模式关注的是系统中对象之间的相互交互，解决系统在运行时对象之间的相互通信和协作，进一步明确对象的职责。

观察者模式，是一种行为性模型，又叫发布-订阅模式，他定义对象之间一种一对多的依赖关系，使得当一个对象改变状态，则所有依赖于它的对象都会得到通知并自动更新。


### 3、Java中Semaphore是什么？

Java中的Semaphore是一种新的同步类，它是一个计数信号。从概念上讲，从概念上讲，信号量维护了一个许可集合。如有必要，在许可可用前会阻塞每一个 acquire()，然后再获取该许可。每个 release()添加一个许可，从而可能释放一个正在阻塞的获取者。但是，不使用实际的许可对象，Semaphore只对可用许可的号码进行计数，并采取相应的行动。信号量常常用于多线程的代码中，比如数据库连接池。


### 4、为什么需要双亲委派模式？

在这里，先想一下，如果没有双亲委派，那么用户是不是可以自己定义一个java.lang.Object的同名类，java.lang.String的同名类，并把它放到ClassPath中,那么类之间的比较结果及类的唯一性将无法保证，因此，为什么需要双亲委派模型？防止内存中出现多份同样的字节码。


### 5、你是如何调用 wait（）方法的？使用 if 块还是循环？为什么？

wait() 方法应该在循环调用，因为当线程获取到 CPU 开始执行的时候，其他条件可能还没有满足，所以在处理前，循环检测条件是否满足会更好。下面是一段标准的使用 wait 和 notify 方法的代码：

```java
// The standard idiom for using the wait method
synchronized (obj) {
        while (condition does not hold)
        obj.wait(); // (Releases lock, and reacquires on wakeup)
        ..、// Perform action appropriate to condition
        }
```

参见 [Effective Java]第 69 条，获取更多关于为什么应该在循环中来调用 wait 方法的内容。


### 6、你知道哪些内存分配与回收策略？

**对象优先在 Eden 区分配**

大多数情况下对象在新生代 Eden 区分配，当 Eden 没有足够空间时将发起一次 Minor GC。

**大对象直接进入老年代**

大对象指需要大量连续内存空间的对象，典型是很长的字符串或数量庞大的数组。大对象容易导致内存还有不少空间就提前触发垃圾收集以获得足够的连续空间。

HotSpot 提供了 `-XX:PretenureSizeThreshold` 参数，大于该值的对象直接在老年代分配，避免在 Eden 和 Survivor 间来回复制。

**长期存活对象进入老年代**

虚拟机给每个对象定义了一个对象年龄计数器，存储在对象头。如果经历过第一次 Minor GC 仍然存活且能被 Survivor 容纳，该对象就会被移动到 Survivor 中并将年龄设置为 1。对象在 Survivor 中每熬过一次 Minor GC 年龄就加 1 ，当增加到一定程度（默认15）就会被晋升到老年代。对象晋升老年代的阈值可通过 `-XX:MaxTenuringThreshold` 设置。

**动态对象年龄判定**

为了适应不同内存状况，虚拟机不要求对象年龄达到阈值才能晋升老年代，如果在 Survivor 中相同年龄所有对象大小的总和大于 Survivor 的一半，年龄不小于该年龄的对象就可以直接进入老年代。

**空间分配担保**

MinorGC 前虚拟机必须检查老年代最大可用连续空间是否大于新生代对象总空间，如果满足则说明这次 Minor GC 确定安全。

如果不满足，虚拟机会查看 `-XX:HandlePromotionFailure` 参数是否允许担保失败，如果允许会继续检查老年代最大可用连续空间是否大于历次晋升老年代对象的平均大小，如果满足将冒险尝试一次 Minor GC，否则改成一次 FullGC。

冒险是因为新生代使用复制算法，为了内存利用率只使用一个 Survivor，大量对象在 Minor GC 后仍然存活时，需要老年代进行分配担保，接收 Survivor 无法容纳的对象。


### 7、Java 中，怎么打印出一个字符串的所有排列？

解决方案

[http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html](http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html)


### 8、普通类和抽象类有哪些区别？

普通类不能包含抽象方法，抽象类可以包含抽象方法。 抽象类不能直接实例化，普通类可以直接实例化。


### 9、final 在 java 中有什么作用？

final 修饰的类叫最终类，该类不能被继承。 final 修饰的方法不能被重写。 final 修饰的变量叫常量，常量必须初始化，初始化之后值就不能被修改。


### 10、什么是ORM？

对象关系映射（Object-Relational Mapping，简称ORM）是一种为了解决程序的面向对象模型与数据库的关系模型互不匹配问题的技术


### 11、如何判断一个类是无用的类?
### 12、Java 中 sleep 方法和 wait 方法的区别？
### 13、poll() 方法和 remove() 方法的区别？
### 14、如何查看 JVM 当前使用的是什么垃圾收集器？
### 15、CopyOnWriteArrayList可以用于什么应用场景？
### 16、堆的作用是什么？
### 17、生产环境服务器变慢，如何诊断处理？
### 18、volatile 修饰符的有过什么实践？
### 19、当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递？
### 20、怎么在JDBC内调用一个存储过程
### 21、如何部署一个web项目？
### 22、什么是Java虚拟机？为什么Java被称作是“平台无关的编程语言”？
### 23、谈一谈Hibernate的一级缓存、二级缓存和查询缓存。
### 24、什么是JDK?什么是JRE？
### 25、JVM 出现 fullGC 很频繁，怎么去线上排查问题
### 26、BIO、NIO、AIO 有什么区别？
### 27、抽象工厂模式和原型模式之间的区别？
### 28、Parallel Scavenge 收集器（多线程复制算法、高效）
### 29、建造者模式的使用场景
### 30、UML中有哪些常用的图？
### 31、ZGC收集器中的染色指针有什么用？
### 32、JRE、JDK、JVM 及 JIT 之间有什么不同？
### 33、Java 中的编译期常量是什么？使用它又什么风险？
### 34、访问修饰符public,private,protected,以及不写（默认）时的区别？
### 35、垃圾收集算法
### 36、虚拟DOM的优劣如何?
### 37、解释内存中的栈(stack)、堆(heap)和方法区(method area)的用法。
### 38、你是如何理解fiber的?
### 39、能够找到 Reference Chain 的对象，就一定会存活么？
### 40、Files的常用方法都有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
