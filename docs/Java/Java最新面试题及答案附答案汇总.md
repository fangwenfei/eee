# Java最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Jsp包含那些隐藏对象或者内建对象

**1、** Page

**2、** pageContext

**3、** request

**4、** response

**5、** out

**6、** session

**7、** application

**8、** config

**9、** exception


### 2、除了使用new创建对象之外，还可以用什么方法创建对象？

Java反射


### 3、常见的计算机网络协议有那些？

**1、** TCP/IP协议

**2、** IPX/SPX协议

**3、** NetBEUI协议


### 4、什么是并发容器的实现？

**1、** 何为同步容器：可以简单地理解为通过synchronized来实现同步的容器，如果有多个线程调用同步容器的方法，它们将会串行执行。比如Vector，Hashtable，以及Collections.synchronizedSet，synchronizedList等方法返回的容器。

**2、** 可以通过查看Vector，Hashtable等这些同步容器的实现代码，可以看到这些容器实现线程安全的方式就是将它们的状态封装起来，并在需要同步的方法上加上关键字synchronized。

并发容器使用了与同步容器完全不同的加锁策略来提供更高的并发性和伸缩性，例如在ConcurrentHashMap中采用了一种粒度更细的加锁机制，可以称为分段锁，在这种锁机制下，允许任意数量的读线程并发地访问map，并且执行读操作的线程和写操作的线程也可以并发的访问map，同时允许一定数量的写操作线程并发地修改map，所以它可以在并发环境下实现更高的吞吐量。


### 5、使用sql写出一个分页程序？

Select top 3 * from tb_name where id not in (select top 3 id from tb_name)


### 6、如何将字符串反转？

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


### 7、抽象类能使用 final 修饰吗？

不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承，这样彼此就会产生矛盾，所以 final 不能修饰抽象类，如下图所示，编辑器也会提示错误信息：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/2012/47/79_1.png#alt=79%5C_1.png)


### 8、多线程的劣势：

**线程也是程序，所以线程需要占用内存，线程越多占用内存也越多；

多线程需要协调和管理，所以需要 CPU 时间跟踪线程；

线程之间对共享资源的访问会相互影响，必须解决竞用共享资源的问题。**


### 9、说一下堆和栈的区别

**1、** 物理地址 堆的物理地址分配对对象是不连续的。因此性能慢些。在GC的时候也要考虑到不连续的分配，所以有各种算法。比如，标记-消除，复制，标记-压缩，分代（即新生代使用复制算法，老年代使用标记——压缩） 栈使用的是数据结构中的栈，先进后出的原则，物理地址分配是连续的。所以性能快。

**2、** 内存分别 堆因为是不连续的，所以分配的内存是在运行期确认的，因此大小不固定。一般堆大小远远大于栈。栈是连续的，所以分配的内存大小要在编译期就确认，大小是固定的。

**3、** 存放的内容 堆存放的是对象的实例和数组。因此该区更关注的是数据的存储 栈存放：局部变量，操作数栈，返回结果。该区更关注的是程序方法的执行。

**4、** 程序的可见度 堆对于整个应用程序都是共享、可见的。栈只对于线程是可见的。所以也是线程私有。他的生命周期和线程相同。


### 10、Java的内存模型是什么？（JMM是什么？）

JVM试图定义一种统一的内存模型，能将各种底层硬件及操作系统的内存访问差异进行封装，使Java程序在不同硬件及操作系统上都能达到相同的并发效果。它分为工作内存和主内存，线程无法对主存储器**直接**进行操作，一个线程要和另外一个线程通信，只能通过主存进行交换。

JMM可以说是Java并发的基础，它的定义将直接影响多线程实现的机制，如果你想要想深入了解多线程并发中的相关问题现象，对JMM的深入研究是必不可少的。

上面两个问题是经常容易搞混的，但它们的内容却完全不同的。


### 11、阐述final、finally、finalize的区别。
### 12、获得一个类的类对象有哪些方式？
### 13、Minor Gc和Full GC 有什么不同呢？
### 14、Sql中delete与truncate的区别
### 15、虚拟DOM的优劣如何?
### 16、构造方法能不能重载？能不能重写？
### 17、抽象的关键字是什么？
### 18、java 面向对象编程三大特性------封装、继承、多态
### 19、Java语言有哪些特点？
### 20、Java Concurrency API中的Lock接口(Lock interface)是什么？对比同步它有什么优势？
### 21、常用io类有那些？
### 22、成员变量与局部变量的区别有那些？
### 23、什么是Future？
### 24、描述一下JVM加载class文件的原理机制？
### 25、类加载为什么要使用双亲委派模式，有没有什么场景是打破了这个模式？
### 26、原型模式的使用方式
### 27、哪些集合类是线程安全的？
### 28、CAS 的会产生什么问题？
### 29、描述 Java 中的重载和重写？
### 30、依赖注入和工程模式之间有什么不同？
### 31、程序计数器
### 32、谈谈你知道的垃圾收集器
### 33、除了单例模式，你在生产环境中还用过什么设计模式？
### 34、Java 中如何将字符串转换为整数？
### 35、poll() 方法和 remove() 方法的区别？
### 36、多线程同步有哪几种方法？
### 37、TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？
### 38、safepoint 是什么？
### 39、用代码演示三种代理
### 40、StringBuffer，Stringbuilder有什么区别？
### 41、Spring支持的事务管理类型有哪些？你在项目中使用哪种方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
