# Java高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、HashMap在JDK1.7和JDK1.8中有哪些不同？HashMap的底层实现

在Java中，保存数据有两种比较简单的数据结构：数组和链表。**数组的特点是：寻址容易，插入和删除困难；链表的特点是：寻址困难，但插入和删除容易；所以我们将数组和链表结合在一起，发挥两者各自的优势，使用一种叫做拉链法**的方式可以解决哈希冲突。

**HashMap JDK1.8之前**

JDK1.8之前采用的是拉链法。**拉链法**：将链表和数组相结合。也就是说创建一个链表数组，数组中每一格就是一个链表。若遇到哈希冲突，则将冲突的值加到链表中即可。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/056/58/114_5.png#alt=114%5C_5.png)

**HashMap JDK1.8之后**

相比于之前的版本，jdk1.8在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转化为红黑树，以减少搜索时间。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/056/58/114_6.png#alt=114%5C_6.png)

**JDK1.7 VS JDK1.8 比较**

**JDK1.8主要解决或优化了一下问题：**

**1、** resize 扩容优化

**2、** 引入了红黑树，目的是避免单条链表过长而影响查询效率，红黑树算法请参考

**3、** 解决了多线程死循环问题，但仍是非线程安全的，多线程时可能会造成数据丢失问题。

| 不同 | JDK 1.7 | JDK 1.8 |
| --- | --- | --- |
| 存储结构 | 数组 + 链表 | 数组 + 链表 + 红黑树 |
| 初始化方式 | 单独函数：`inflateTable()` | 直接集成到了扩容函数`resize()`中 |
| hash值计算方式 | 扰动处理 = 9次扰动 = 4次位运算 + 5次异或运算 | 扰动处理 = 2次扰动 = 1次位运算 + 1次异或运算 |
| 存放数据的规则 | 无冲突时，存放数组；冲突时，存放链表 | 无冲突时，存放数组；冲突 & 链表长度 < 8：存放单链表；冲突 & 链表长度 > 8：树化并存放红黑树 |
| 插入数据方式 | 头插法（先讲原位置的数据移到后1位，再插入数据到该位置） | 尾插法（直接插入到链表尾部/红黑树） |
| 扩容后存储位置的计算方式 | 全部按照原来方法进行计算（即hashCode ->> 扰动函数 ->> (h&length-1)） | 按照扩容后的规律计算（即扩容后的位置=原位置 or 原位置 + 旧容量） |



### 2、如何阻止表单提交

Onsubmit=“return false”


### 3、JIT是什么？

为了提高热点代码的执行效率，在运行时，虚拟机将会把这些代码编译成与本地平台相关的机器码，并进行各种层次的优化。完成这个任务的编译器，就称为即时编译器（Just In Time Compiler），简称 JIT 编译器。


### 4、如果对象的引用被置为null，垃圾收集器是否会立即释放对象占用的内存？

**1、** 不会，在下一个垃圾回调周期中，这个对象将是被可回收的。

**2、** 也就是说并不会立即被垃圾收集器立刻回收，而是在下一次垃圾回收时才会释放其占用的内存。


### 5、Java 中能创建 volatile 数组吗？

能，Java 中可以创建 volatile 类型数组，不过只是一个指向数组的引用，而不是整个数组。意思是，如果改变引用指向的数组，将会受到 volatile 的保护，但是如果多个线程同时改变数组的元素，volatile 标示符就不能起到之前的保护作用了。


### 6、ConcurrentHashMap的并发度是什么

ConcurrentHashMap的并发度就是segment的大小，默认为16，这意味着最多同时可以有16条线程操作ConcurrentHashMap，这也是ConcurrentHashMap对Hashtable的最大优势，任何情况下，Hashtable能同时有两条线程获取Hashtable中的数据吗？


### 7、多线程场景下如何使用 ArrayList？

ArrayList 不是线程安全的，如果遇到多线程场景，可以通过 Collections 的 synchronizedList 方法将其转换成线程安全的容器后再使用。例如像下面这样：

```
List<String> synchronizedList = Collections.synchronizedList(list);
synchronizedList.add("aaa");
synchronizedList.add("bbb");

for (int i = 0; i < synchronizedList.size(); i++) {
System.out.println(synchronizedList.get(i));
}
```


### 8、什么是ORM？

对象关系映射（Object-Relational Mapping，简称ORM）是一种为了解决程序的面向对象模型与数据库的关系模型互不匹配问题的技术


### 9、Java 中，怎么打印出一个字符串的所有排列？

解决方案

[http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html](http://javarevisited.blogspot.com/2015/08/how-to-find-all-permutations-of-string-java-example.html)


### 10、Java 中，抽象类与接口之间有什么不同？

Java 中，抽象类和接口有很多不同之处，但是最重要的一个是 Java 中限制一个类只能继承一个类，但是可以实现多个接口。抽象类可以很好的定义一个家族类的默认行为，而接口能更好的定义类型，有助于后面实现多态机制。


### 11、观察者模式应用场景
### 12、分代收集算法
### 13、类初始化的情况有哪些？
### 14、并发队列和并发集合的区别：
### 15、如何确保线程安全？
### 16、线程的生命周期？
### 17、Java 中怎样将 bytes 转换为 long 类型？
### 18、你将如何使用thread dump？你将如何分析Thread dump？
### 19、ArrayList和Vector有什么不同之处？
### 20、Java会存在内存泄漏吗？请简单描述。
### 21、Java 内存分配与回收策率以及 Minor GC 和 Major GC
### 22、创建一个子类对象的时候，那么父类的构造方法会执行吗？
### 23、模块化编程与热插拔
### 24、线程之间如何通信及线程之间如何同步
### 25、final、finalize 和 finally 的不同之处？
### 26、怎么获取 Java 程序使用的内存？堆使用的百分比？
### 27、HashSet与HashMap的区别
### 28、可达性分析
### 29、JVM 年轻代到年老代的晋升过程的判断条件是什么呢？
### 30、Java 中，受检查异常 和 不受检查异常的区别？
### 31、阻塞队列和非阻塞队列区别
### 32、final 在 java 中有什么作用？
### 33、HTTP的状态码
### 34、Java 中，怎样才能打印出数组中的重复元素？
### 35、线程池的优点？
### 36、Java都有那些开发平台？
### 37、你知道哪些故障处理工具？
### 38、switch 是否能作用在byte 上，是否能作用在long 上，是否能作用在String上？
### 39、MinorGC，MajorGC、FullGC都什么时候发生？
### 40、抽象类是什么？它与接口有什么区别？你为什么要使用过抽象类？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
