# Java面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、有哪些类加载器？

自 JDK1.2 起 Java 一直保持三层类加载器：

**启动类加载器**

在 JVM 启动时创建，负责加载最核心的类，例如 Object、System 等。无法被程序直接引用，如果需要把加载委派给启动类加载器，直接使用 null 代替即可，因为启动类加载器通常由操作系统实现，并不存在于 JVM 体系。

**平台类加载器**

从 JDK9 开始从扩展类加载器更换为平台类加载器，负载加载一些扩展的系统类，比如 XML、加密、压缩相关的功能类等。

**应用类加载器**

也称系统类加载器，负责加载用户类路径上的类库，可以直接在代码中使用。如果没有自定义类加载器，一般情况下应用类加载器就是默认的类加载器。自定义类加载器通过继承 ClassLoader 并重写 `findClass` 方法实现。


### 2、Hashtable 与 HashMap 有什么不同之处？

这两个类有许多不同的地方，下面列出了一部分：

a) Hashtable 是 JDK 1 遗留下来的类，而 HashMap 是后来增加的。

b）Hashtable 是同步的，比较慢，但 HashMap 没有同步策略，所以会更快。

c）Hashtable 不允许有个空的 key，但是 HashMap 允许出现一个 null key。

更多的不同之处参见答案。


### 3、什么是竞争条件？你怎样发现和解决竞争？

当多个进程都企图对共享数据进行某种处理，而最后的结果又取决于进程运行的顺序时，则我们认为这发生了竞争条件（race condition）。


### 4、如何实现字符串的反转及替换？



方法很多，可以自己写实现也可以使用String或StringBuffer/StringBuilder中的方法。有一道很常见的面试题是用递归实现字符串反转，代码如下所示：

```
    public static String reverse(String originStr) {
        if(originStr == null || originStr.length() <= 1) 
            return originStr;
        return reverse(originStr.substring(1)) + originStr.charAt(0);
    }
```


### 5、HashMap 与 HashTable 有什么区别？

**1、** **线程安全**： HashMap 是非线程安全的，HashTable 是线程安全的；HashTable 内部的方法基本都经过 `synchronized` 修饰。（如果你要保证线程安全的话就使用 ConcurrentHashMap ）；

**2、** **效率**： 因为线程安全的问题，HashMap 要比 HashTable 效率高一点。另外，HashTable 基本被淘汰，不要在代码中使用它；（如果你要保证线程安全的话就使用 ConcurrentHashMap ）；

**3、** **对Null key 和Null value的支持**： HashMap 中，null 可以作为键，这样的键只有一个，可以有一个或多个键所对应的值为 null。但是在 HashTable 中 put 进的键值只要有一个 null，直接抛NullPointerException。

**4、** **初始容量大小和每次扩充容量大小的不同** ：

**1、** 创建时如果不指定容量初始值，Hashtable 默认的初始大小为11，之后每次扩充，容量变为原来的2n+1。HashMap 默认的初始化大小为16。之后每次扩充，容量变为原来的2倍。

**2、** 创建时如果给定了容量初始值，那么 Hashtable 会直接使用你给定的大小，而 HashMap 会将其扩充为2的幂次方大小。也就是说 HashMap 总是使用2的幂作为哈希表的大小，后面会介绍到为什么是2的幂次方。

**底层数据结构**：

JDK1.8 以后的 HashMap 在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转化为红黑树，以减少搜索时间。Hashtable 没有这样的机制。

**推荐使用：**

在 Hashtable 的类注释可以看到，Hashtable 是保留类不建议使用，推荐在单线程环境下使用 HashMap 替代，如果需要多线程使用则用 ConcurrentHashMap 替代。


### 6、实现可见性的方法有哪些？

synchronized或者Lock：保证同一个时刻只有一个线程获取锁执行代码，锁释放之前把最新的值刷新到主内存，实现可见性。


### 7、XML文档定义有几种形式？它们之间有何本质区别？解析XML文档有哪几种方式？



XML文档定义分为DTD和Schema两种形式，二者都是对XML语法的约束，其本质区别在于Schema本身也是一个XML文件，可以被XML解析器解析，而且可以为XML承载的数据定义类型，约束能力较之DTD更强大。对XML的解析主要有DOM（文档对象模型，Document Object Model）、SAX（Simple API for XML）和StAX（Java 6中引入的新的解析XML的方式，Streaming API for XML），其中DOM处理大型文件时其性能下降的非常厉害，这个问题是由DOM树结构占用的内存较多造成的，而且DOM解析方式必须在解析文件之前把整个文档装入内存，适合对XML的随机访问（典型的用空间换取时间的策略）；SAX是事件驱动型的XML解析方式，它顺序读取XML文件，不需要一次全部装载整个文件。当遇到像文件开头，文档结束，或者标签开头与标签结束时，它会触发一个事件，用户通过事件回调代码来处理XML文件，适合对XML的顺序访问；顾名思义，StAX把重点放在流上，实际上StAX与其他解析方式的本质区别就在于应用程序能够把XML作为一个事件流来处理。将XML作为一组事件来处理的想法并不新颖（SAX就是这样做的），但不同之处在于StAX允许应用程序代码把这些事件逐个拉出来，而不用提供在解析器方便时从解析器中接收事件的处理程序。


### 8、什么是Executors？

**Executors框架实现的就是线程池的功能**

Executors工厂类中提供的newCachedThreadPool、newFixedThreadPool 、newScheduledThreadPool 、newSingleThreadExecutor 等方法其实也只是ThreadPoolExecutor的构造函数参数不同而已。通过传入不同的参数，就可以构造出适用于不同应用场景下的线程池，

Executor工厂类如何创建线程池图：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_7.png#alt=87%5C_7.png)


### 9、Java的双亲委托机制是什么？

它的意思是，除了顶层的启动类加载器以外，其余的类加载器，在加载之前，都会委派给它的父加载器进行加载。这样一层层向上传递，直到祖先们都无法胜任，它才会真正的加载。

Java默认是这种行为。当然Java中也有很多打破双亲行为的骚操作，比如SPI（JDBC驱动加载），OSGI等。


### 10、使用sql写出一个分页程序？

Select top 3 * from tb_name where id not in (select top 3 id from tb_name)


### 11、适配器模式和装饰器模式有什么区别？
### 12、说一下 synchronized 底层实现原理？
### 13、Collection和Collections的区别？
### 14、TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？
### 15、GC的回收流程是怎样的？
### 16、常见的计算机网络协议有那些？
### 17、HashSet如何检查重复？HashSet是如何保证数据不可重复的？
### 18、Java 中，如何将字符串 YYYYMMDD 转换为日期？
### 19、怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？
### 20、Java Concurrency API中的Lock接口(Lock interface)是什么？对比同步它有什么优势？
### 21、JVM 运行时内存
### 22、如何选择单例创建方式
### 23、如何合理分配线程池大小?
### 24、新生代与复制算法
### 25、Java 中应该使用什么数据类型来代表价格？
### 26、JRE、JDK、JVM 及 JIT 之间有什么不同？
### 27、两个相同的对象会有不同的的 hash code 吗？
### 28、线程与进程的区别
### 29、我们可以在 hashcode() 中使用随机数字吗？
### 30、如果父类只有有参构造方法，那么子类必须要重写父类的构造方法吗？
### 31、请解释如何配置Tomcat来使用IIS和NTLM ?
### 32、Swing 是线程安全的？
### 33、ConcurrentHashMap的并发度是什么
### 34、死锁的原因
### 35、String str=”aaa”,与String str=new String(“aaa”)一样吗？
### 36、JVM 提供的常用工具
### 37、为什么我们调用start()方法时会执行run()方法，为什么我们不能直接调用run()方法？
### 38、safepoint 是什么？
### 39、Java中Synchronized关键字的使用？
### 40、工厂模式分类




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
