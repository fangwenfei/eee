# Java高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、JVM怎么判断一个对象是不是要回收？

引用计数法（缺点是对于相互引用的对象，无法进行清除） 可达性分析


### 2、synchronized 和 ReentrantLock 区别是什么？

**1、** synchronized 是和 if、else、for、while 一样的关键字，ReentrantLock 是类，这是二者的本质区别。既然 ReentrantLock 是类，那么它就提供了比synchronized 更多更灵活的特性，可以被继承、可以有方法、可以有各种各样的类变量

**2、** synchronized 早期的实现比较低效，对比 ReentrantLock，大多数场景性能都相差较大，但是在 Java 6 中对 synchronized 进行了非常多的改进。

**相同点：两者都是可重入锁**

两者都是可重入锁。“可重入锁”概念是：自己可以再次获取自己的内部锁。比如一个线程获得了某个对象的锁，此时这个对象锁还没有释放，当其再次想要获取这个对象的锁的时候还是可以获取的，如果不可锁重入的话，就会造成死锁。同一个线程每次获取锁，锁的计数器都自增1，所以要等到锁的计数器下降为0时才能释放锁。

**主要区别如下：**

**1、** ReentrantLock 使用起来比较灵活，但是必须有释放锁的配合动作；

**2、** ReentrantLock 必须手动获取与释放锁，而 synchronized 不需要手动释放和开启锁；

**3、** ReentrantLock 只适用于代码块锁，而 synchronized 可以修饰类、方法、变量等。

**4、** 二者的锁机制其实也是不一样的。ReentrantLock 底层调用的是 Unsafe 的park 方法加锁，synchronized 操作的应该是对象头中 mark word

**5、** Java中每一个对象都可以作为锁，这是synchronized实现同步的基础：

**1、** 普通同步方法，锁是当前实例对象

**2、** 静态同步方法，锁是当前类的class对象

**3、** 同步方法块，锁是括号里面的对象


### 3、举例说明同步和异步。



如果系统中存在临界资源（资源数量少于竞争资源的线程数量的资源），例如正在写的数据以后可能被另一个线程读到，或者正在读的数据可能已经被另一个线程写过了，那么这些数据就必须进行同步存取（数据库操作中的排他锁就是最好的例子）。当应用程序在对象上调用了一个需要花费很长时间来执行的方法，并且不希望让程序等待方法的返回时，就应该使用异步编程，在很多情况下采用异步途径往往更有效率。事实上，所谓的同步就是指阻塞式操作，而异步就是非阻塞式操作。


### 4、对象的访问定位有哪几种方式?

建立对象就是为了使用对象，我们的Java程序通过栈上的 reference 数据来操作堆上的具体对象。对象的访问方式有虚拟机实现而定，目前主流的访问方式有使用句柄和直接指针2种：

句柄：如果使用句柄的话，那么Java堆中将会划分出一块内存来作为句柄池，reference 中存储的就是对象的句柄地址，而句柄中包含了对象实例数据与类型数据各自的具体地址信息。

直接指针：如果使用直接指针访问，那么 Java 堆对象的布局中就必须考虑如何放置访问类型数据的相关信息，而reference 中存储的直接就是对象的地址。

这两种对象访问方式各有优势。使用句柄来访问的最大好处是 reference 中存储的是稳定的句柄地址，在对象被移动时只会改变句柄中的实例数据指针，而 reference 本身不需要修改。使用直接指针访问方式最大的好处就是速度快，它节省了一次指针定位的时间开销。


### 5、接口有什么特点？

**1、** 接口中声明全是public static final修饰的常量

**2、** 接口中所有方法都是抽象方法

**3、** 接口是没有构造方法的

**4、** 接口也不能直接实例化

**5、** 接口可以多继承


### 6、Java 中的 TreeMap 是采用什么树实现的？(答案)

Java 中的 TreeMap 是使用红黑树实现的。


### 7、列出 5 个应该遵循的 JDBC 最佳实践

有很多的最佳实践，你可以根据你的喜好来例举。下面是一些更通用的原则：

**1、** 使用批量的操作来插入和更新数据

**2、** 使用 PreparedStatement 来避免 SQL 异常，并提高性能。

**3、** 使用数据库连接池

**4、** 通过列名来获取结果集，不要使用列的下标来获取。


### 8、final 在 java 中有什么作用？

final 修饰的类叫最终类，该类不能被继承。 final 修饰的方法不能被重写。 final 修饰的变量叫常量，常量必须初始化，初始化之后值就不能被修改。


### 9、有什么堆外内存的排查思路？

进程占用的内存，可以使用top命令，看RES段占用的值。如果这个值大大超出我们设定的最大堆内存，则证明堆外内存占用了很大的区域。

使用gdb可以将物理内存dump下来，通常能看到里面的内容。更加复杂的分析可以使用perf工具，或者谷歌开源的gperftools。那些申请内存最多的native函数，很容易就可以找到。


### 10、你能写出一个正则表达式来判断一个字符串是否是一个数字吗？

一个数字字符串，只能包含数字，如 0 到 9 以及 +、- 开头，通过这个信息，你可以下一个如下的正则表达式来判断给定的字符串是不是数字。

```
首先要import java.util.regex.Pattern 和 java.util.regex.Matcher
public boolean isNumeric(String str){ 
   Pattern pattern = Pattern.compile("[0-9]*"); 
   Matcher isNum = pattern.matcher(str);
   if( !isNum.matches() ){
       return false; 
   } 
   return true; 
}
```


### 11、你知道有哪些开源框架？
### 12、访问修饰符public,private,protected,以及不写（默认）时的区别？
### 13、类与对象的关系?
### 14、JVM 类加载机制
### 15、什么是方法内联？
### 16、什么情况会造成元空间溢出？
### 17、串行(serial)收集器和吞吐量(throughput)收集器的区别是什么？
### 18、Java中用到的线程调度算法是什么
### 19、说出 5 条 IO 的最佳实践(答案)
### 20、并发关键字 synchronized ？
### 21、事务的ACID是指什么？
### 22、如果使用Object作为HashMap的Key，应该怎么办呢？
### 23、Collection 和 Collections 有什么区别？
### 24、JVM 如何确定垃圾对象？
### 25、字符型常量和字符串常量的区别
### 26、JVM 出现 fullGC 很频繁，怎么去线上排查问题
### 27、什么是集合
### 28、JVM 数据运行区，哪些会造成 OOM 的情况？
### 29、程序的结构有那些？
### 30、64 位 JVM 中，int 的长度是多数？
### 31、invokedynamic 指令是干什么的？
### 32、为什么代码会重排序？
### 33、Array 和 ArrayList 有何区别？
### 34、什么是双亲委派机制？
### 35、为什么wait, notify 和 notifyAll这些方法不在thread类里面？
### 36、Js如何实现动态效果？
### 37、什么是多线程的上下文切换
### 38、怎么查看服务器默认的垃圾回收器是哪一个？
### 39、程序计数器为什么是私有的?
### 40、调优工具




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
