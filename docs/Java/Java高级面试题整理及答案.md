# Java高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在使用jdbc的时候，如何防止出现sql注入的问题。

使用PreparedStatement类，而不是使用Statement类


### 2、Servlet生命周期内调用的方法过程？

**1、** Init()

**2、** Service()

**3、** doGet或者doPost

**4、** destroy


### 3、TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？

TreeSet 要求存放的对象所属的类必须实现 Comparable 接口，该接口提供了比较元素的 compareTo()方法，当插入元素时会回调该方法比较元素的大小。TreeMap 要求存放的键值对映射的键必须实现 Comparable 接口从而根据键对元素进 行排 序。

Collections 工具类的 sort 方法有两种重载的形式，

第一种要求传入的待排序容器中存放的对象比较实现 Comparable 接口以实现元素的比较；

**1、** comparable接口实际上是出自java.lang包，它有一个 compareTo(Object obj)方法用来排序

**2、** comparator接口实际上是出自 java.util 包，它有一个compare(Object obj1, Object obj2)方法用来排序

一般我们需要对一个集合使用自定义排序时，我们就要重写compareTo方法或compare方法，当我们需要对某一个集合实现两种排序方式，比如一个song对象中的歌名和歌手名分别采用一种排序方法的话，我们可以重写compareTo方法和使用自制的Comparator方法或者以两个Comparator来实现歌名排序和歌星名排序，第二种代表我们只能使用两个参数版的Collections.sort().


### 4、方法区的作用是什么？

**方法区**用于存储被虚拟机加载的类型信息、常量、静态变量、即时编译器编译后的代码缓存等数据。

JDK8 之前使用永久代实现方法区，容易内存溢出，因为永久代有 `-XX:MaxPermSize` 上限，即使不设置也有默认大小。JDK7 把放在永久代的字符串常量池、静态变量等移出，JDK8 中永久代完全废弃，改用在本地内存中实现的元空间代替，把 JDK 7 中永久代剩余内容（主要是类型信息）全部移到元空间。

虚拟机规范对方法区的约束宽松，除和堆一样不需要连续内存和可选择固定大小/可扩展外，还可以不实现垃圾回收。垃圾回收在方法区出现较少，主要目标针对常量池和类型卸载。如果方法区无法满足新的内存分配需求，将抛出 OutOfMemoryError。


### 5、Error和Exception有什么区别？



Error表示系统级的错误和程序不必处理的异常，是恢复不是不可能但很困难的情况下的一种严重问题；比如内存溢出，不可能指望程序能处理这样的情况；Exception表示需要捕捉或者需要程序进行处理的异常，是一种设计或实现问题；也就是说，它表示如果程序运行正常，从不会发生的情况。

> 面试题：2005年摩托罗拉的面试中曾经问过这么一个问题“If a process reports a stack overflow run-time error, what’s the most possible cause?”，给了四个选项a、lack of memory; b、write on an invalid memory space; c、recursive function calling; d、array index out of boundary、Java程序在运行时也可能会遭遇StackOverflowError，这是一个无法恢复的错误，只能重新修改代码了，这个面试题的答案是c。如果写了不能迅速收敛的递归，则很有可能引发栈溢出的错误，如下所示：


```
class StackOverflowErrorTest {

    public static void main(String[] args) {
        main(null);
    }
}
```

> 提示：用递归编写程序时一定要牢记两点：1、递归公式；2、收敛条件（什么时候就不再继续递归）。



### 6、ConcurrentHashMap 底层具体实现知道吗？实现原理是什么？

**JDK1.7**

**1、** 首先将数据分为一段一段的存储，然后给每一段数据配一把锁，当一个线程占用锁访问其中一个段数据时，其他段的数据也能被其他线程访问。

**2、** 在JDK1.7中，ConcurrentHashMap采用Segment + HashEntry的方式进行实现，结构如下：

**3、** 一个 ConcurrentHashMap 里包含一个 Segment 数组。Segment 的结构和HashMap类似，是一种数组和链表结构，一个 Segment 包含一个 HashEntry 数组，每个 HashEntry 是一个链表结构的元素，每个 Segment 守护着一个HashEntry数组里的元素，当对 HashEntry 数组的数据进行修改时，必须首先获得对应的 Segment的锁。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/056/58/114_13.png#alt=114%5C_13.png)

**1、** 该类包含两个静态内部类 HashEntry 和 Segment ；前者用来封装映射表的键值对，后者用来充当锁的角色；

**2、** Segment 是一种可重入的锁 ReentrantLock，每个 Segment 守护一个HashEntry 数组里得元素，当对 HashEntry 数组的数据进行修改时，必须首先获得对应的 Segment 锁。

**JDK1.8**

在**JDK1.8中，放弃了Segment臃肿的设计，取而代之的是采用Node + CAS + Synchronized来保证并发安全进行实现**，synchronized只锁定当前链表或红黑二叉树的首节点，这样只要hash不冲突，就不会产生并发，效率又提升N倍。

**结构如下：**

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/056/58/114_14.png#alt=114%5C_14.png)

**1、** **附加源码，有需要的可以看看**

**2、** 插入元素过程（建议去看看源码）：

**3、** 如果相应位置的Node还没有初始化，则调用CAS插入相应的数据；

```
else if ((f = tabAt(tab, i = (n - 1) & hash)) == null) {
    if (casTabAt(tab, i, null, new Node < K, V > (hash, key, value, null))) break; // no lock when adding to empty bin
}
```

如果相应位置的Node不为空，且当前该节点不处于移动状态，则对该节点加synchronized锁，如果该节点的hash不小于0，则遍历链表更新节点或插入新节点；

```
if (fh >= 0) {
    binCount = 1;
    for (Node < K, V > e = f;; ++binCount) {
        K ek;
        if (e.hash == hash && ((ek = e.key) == key || (ek != null && key.equals(ek)))) {
            oldVal = e.val;
            if (!onlyIfAbsent) e.val = value;
            break;
        }
        Node < K, V > pred = e;
        if ((e = e.next) == null) {
            pred.next = new Node < K, V > (hash, key, value, null);
            break;
        }
    }
}
```

**1、** 如果该节点是TreeBin类型的节点，说明是红黑树结构，则通过putTreeVal方法往红黑树中插入节点；如果binCount不为0，说明put操作对数据产生了影响，如果当前链表的个数达到8个，则通过treeifyBin方法转化为红黑树，如果oldVal不为空，说明是一次更新操作，没有对元素个数产生影响，则直接返回旧值；

**2、** 如果插入的是一个新节点，则执行addCount()方法尝试更新元素个数baseCount；


### 7、为什么 Thread 类的 sleep()和 yield ()方法是静态的？

Thread 类的 sleep()和 yield()方法将在当前正在执行的线程上运行。所以在其他处于等待状态的线程上调用这些方法是没有意义的。这就是为什么这些方法是静态的。它们可以在当前正在执行的线程中工作，并避免程序员错误的认为可以在其他非运行线程调用这些方法。


### 8、事务的ACID是指什么？



1. 原子性(Atomic)：事务中各项操作，要么全做要么全不做，任何一项操作的失败都会导致整个事务的失败；
2. 一致性(Consistent)：事务结束后系统状态是一致的；
3. 隔离性(Isolated)：并发执行的事务彼此无法看到对方的中间状态；
4. 持久性(Durable)：事务完成后所做的改动都会被持久化，即使发生灾难性的失败。通过日志和同步备份可以在故障发生后重建数据。

补充：关于事务，在面试中被问到的概率是很高的，可以问的问题也是很多的。首先需要知道的是，只有存在并发数据访问时才需要事务。当多个事务访问同一数据时，可能会存在5类问题，包括3类数据读取问题（脏读、不可重复读和幻读）和2类数据更新问题（第1类丢失更新和第2类丢失更新）。

脏读（Dirty Read）：A事务读取B事务尚未提交的数据并在此基础上操作，而B事务执行回滚，那么A读取到的数据就是脏数据。

| 时间 | 转账事务A | 取款事务B |
| --- | --- | --- |
| T1 |  | 开始事务 |
| T2 | 开始事务 |  |
| T3 |  | 查询账户余额为1000元 |
| T4 |  | 取出500元余额修改为500元 |
| T5 | 查询账户余额为500元（脏读） |  |
| T6 |  | 撤销事务余额恢复为1000元 |
| T7 | 汇入100元把余额修改为600元 |  |
| T8 | 提交事务 |  |


---

不可重复读（Unrepeatable Read）：事务A重新读取前面读取过的数据，发现该数据已经被另一个已提交的事务B修改过了。

| 时间 | 转账事务A | 取款事务B |
| --- | --- | --- |
| T1 |   | 开始事务 |
| T2 | 开始事务 |   |
| T3 |   | 查询账户余额为1000元 |
| T4 | 查询账户余额为1000元 |   |
| T5 |   | 取出100元修改余额为900元 |
| T6 |   | 提交事务 |
| T7 | 查询账户余额为900元（不可重复读） |   |


---

幻读（Phantom Read）：事务A重新执行一个查询，返回一系列符合查询条件的行，发现其中插入了被事务B提交的行。

| 时间 | 统计金额事务A | 转账事务B |
| --- | --- | --- |
| T1 |   | 开始事务 |
| T2 | 开始事务 |   |
| T3 | 统计总存款为10000元 |   |
| T4 |   | 新增一个存款账户存入100元 |
| T5 |   | 提交事务 |
| T6 | 再次统计总存款为10100元（幻读） |   |


---

第1类丢失更新：事务A撤销时，把已经提交的事务B的更新数据覆盖了。

| 时间 | 取款事务A | 转账事务B |
| --- | --- | --- |
| T1 | 开始事务 |   |
| T2 |   | 开始事务 |
| T3 | 查询账户余额为1000元 |   |
| T4 |   | 查询账户余额为1000元 |
| T5 |   | 汇入100元修改余额为1100元 |
| T6 |   | 提交事务 |
| T7 | 取出100元将余额修改为900元 |   |
| T8 | 撤销事务 |   |
| T9 | 余额恢复为1000元（丢失更新） |   |


---

第2类丢失更新：事务A覆盖事务B已经提交的数据，造成事务B所做的操作丢失。

| 时间 | 转账事务A | 取款事务B |
| --- | --- | --- |
| T1 |   | 开始事务 |
| T2 | 开始事务 |   |
| T3 |   | 查询账户余额为1000元 |
| T4 | 查询账户余额为1000元 |   |
| T5 |   | 取出100元将余额修改为900元 |
| T6 |   | 提交事务 |
| T7 | 汇入100元将余额修改为1100元 |   |
| T8 | 提交事务 |   |
| T9 | 查询账户余额为1100元（丢失更新） |   |


---

数据并发访问所产生的问题，在有些场景下可能是允许的，但是有些场景下可能就是致命的，数据库通常会通过锁机制来解决数据并发访问问题，按锁定对象不同可以分为表级锁和行级锁；按并发事务锁定关系可以分为共享锁和独占锁，具体的内容大家可以自行查阅资料进行了解。

直接使用锁是非常麻烦的，为此数据库为用户提供了自动锁机制，只要用户指定会话的事务隔离级别，数据库就会通过分析SQL语句然后为事务访问的资源加上合适的锁，此外，数据库还会维护这些锁通过各种手段提高系统的性能，这些对用户来说都是透明的（就是说你不用理解，事实上我确实也不知道）。ANSI/ISO SQL 92标准定义了4个等级的事务隔离级别，如下表所示：

| 隔离级别 | 脏读 | 不可重复读 | 幻读 | 第一类丢失更新 | 第二类丢失更新 |
| --- | --- | --- | --- | --- | --- |
| READ UNCOMMITED | 允许 | 允许 | 允许 | 不允许 | 允许 |
| READ COMMITTED | 不允许 | 允许 | 允许 | 不允许 | 允许 |
| REPEATABLE READ | 不允许 | 不允许 | 允许 | 不允许 | 不允许 |
| SERIALIZABLE | 不允许 | 不允许 | 不允许 | 不允许 | 不允许 |


需要说明的是，事务隔离级别和数据访问的并发性是对立的，事务隔离级别越高并发性就越差。所以要根据具体的应用来确定合适的事务隔离级别，这个地方没有万能的原则。


### 9、介绍一下 JVM 中垃圾收集器有哪些？ 他们特点分别是什么？

**新生代垃圾收集器**

**Serial 收集器**

特点： Serial 收集器只能使用一条线程进行垃圾收集工作，并且在进行垃圾收集的时候，所有的工作线程都需要停止工作，等待垃圾收集线程完成以后，其他线程才可以继续工作。

**使用算法：复制算法**

**ParNew 收集器**

特点： ParNew 垃圾收集器是Serial收集器的多线程版本。为了利用 CPU 多核多线程的优势，ParNew 收集器可以运行多个收集线程来进行垃圾收集工作。这样可以提高垃圾收集过程的效率。

**使用算法：复制算法**

**Parallel Scavenge 收集器**

特点： Parallel Scavenge 收集器是一款多线程的垃圾收集器，但是它又和 ParNew 有很大的不同点。

Parallel Scavenge 收集器和其他收集器的关注点不同。其他收集器，比如 ParNew 和 CMS 这些收集器，它们主要关注的是如何缩短垃圾收集的时间。而 Parallel Scavenge 收集器关注的是如何控制系统运行的吞吐量。这里说的吞吐量，指的是 CPU 用于运行应用程序的时间和 CPU 总时间的占比，吞吐量 = 代码运行时间 / （代码运行时间 + 垃圾收集时间）。如果虚拟机运行的总的 CPU 时间是 100 分钟，而用于执行垃圾收集的时间为 1 分钟，那么吞吐量就是 99%。

**使用算法：复制算法**

**老年代垃圾收集器**

**Serial Old 收集器**

特点： Serial Old 收集器是 Serial 收集器的老年代版本。这款收集器主要用于客户端应用程序中作为老年代的垃圾收集器，也可以作为服务端应用程序的垃圾收集器。

**使用算法：标记-整理**

**Parallel Old 收集器**

特点： Parallel Old 收集器是 Parallel Scavenge 收集器的老年代版本这个收集器是在 JDK1.6 版本中出现的，所以在 JDK1.6 之前，新生代的 Parallel Scavenge 只能和 Serial Old 这款单线程的老年代收集器配合使用。Parallel Old 垃圾收集器和 Parallel Scavenge 收集器一样，也是一款关注吞吐量的垃圾收集器，和 Parallel Scavenge 收集器一起配合，可以实现对 Java 堆内存的吞吐量优先的垃圾收集策略。

**使用算法：标记-整理**

**CMS 收集器**

特点： CMS 收集器是目前老年代收集器中比较优秀的垃圾收集器。CMS 是 Concurrent Mark Sweep，从名字可以看出，这是一款使用"标记-清除"算法的并发收集器。

CMS 垃圾收集器是一款以获取最短停顿时间为目标的收集器。如下图所示：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/05/34/39_3.png#alt=39%5C_3.png)

**从图中可以看出，CMS 收集器的工作过程可以分为 4 个阶段：**

**1、** 初始标记（CMS initial mark）阶段

**2、** 并发标记（CMS concurrent mark）阶段

**3、** 重新标记（CMS remark）阶段

**4、** 并发清除(（CMS concurrent sweep）阶段

使用算法：复制+标记清除

**其他**

**G1 垃圾收集器**

特点： 主要步骤：`初始标记，并发标记，重新标记，复制清除。`

**使用算法：复制 + 标记整理**


### 10、Spring开发中的工厂设计模式

**Spring IOC**

**1、** 看过Spring源码就知道，在Spring IOC容器创建bean的过程是使用了工厂设计模式

**2、** Spring中无论是通过xml配置还是通过配置类还是注解进行创建bean，大部分都是通过简单工厂来进行创建的。

**3、** 当容器拿到了beanName和class类型后，动态的通过反射创建具体的某个对象，最后将创建的对象放到Map中。

**为什么Spring IOC要使用工厂设计模式创建Bean呢**

**1、** 在实际开发中，如果我们A对象调用B，B调用C，C调用D的话我们程序的耦合性就会变高。（耦合大致分为类与类之间的依赖，方法与方法之间的依赖。）

**2、** 在很久以前的三层架构编程时，都是控制层调用业务层，业务层调用数据访问层时，都是是直接new对象，耦合性大大提升，代码重复量很高，对象满天飞

**3、** 为了避免这种情况，Spring使用工厂模式编程，写一个工厂，由工厂创建Bean，以后我们如果要对象就直接管工厂要就可以，剩下的事情不归我们管了。Spring IOC容器的工厂中有个静态的Map集合，是为了让工厂符合单例设计模式，即每个对象只生产一次，生产出对象后就存入到Map集合中，保证了实例不会重复影响程序效率。


### 11、Java 中，怎么获取一个文件中单词出现的最高频率？
### 12、说说你知道的几种主要的JVM参数
### 13、你都有哪些手段用来排查内存溢出？
### 14、生产环境用的什么JDK？如何配置的垃圾收集器？
### 15、sleep方法和wait方法有什么区别?
### 16、一个”.java”源文件中是否可以包含多个类（不是内部类）？有什么限制？
### 17、Error与Exception区别？
### 18、什么时候使用组合模式？
### 19、Java中Semaphore是什么？
### 20、怎么唤醒一个阻塞的线程
### 21、并发队列的常用方法
### 22、Log4j日志有几个级别？
### 23、什么是happen-before原则？
### 24、Js如何跳转到到一个指定页面
### 25、在 Java 中 Executor 和 Executors 的区别？
### 26、如果一个类中有抽象方法，那么这个一定是抽象类？
### 27、Thread 类中的 yield 方法有什么作用？
### 28、嵌套静态类与顶级类有什么区别？
### 29、谈一谈Hibernate的一级缓存、二级缓存和查询缓存。
### 30、可以描述一下 class 文件的结构吗？
### 31、java 中操作字符串都有哪些类？它们之间有什么区别？
### 32、运行时数据区是什么？
### 33、常用JVM基本配置参数
### 34、请解释什么是Tomcat Coyote ?
### 35、32 位和 64 位的 JVM，int 类型变量的长度是多数？
### 36、如何测试静态方法？()
### 37、数组实例化有几种方式？
### 38、类加载器
### 39、你知道有哪些开源框架？
### 40、什么是ThreadPoolExecutor？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
