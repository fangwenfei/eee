# Java高级面试题合集，附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring开发中的工厂设计模式

**Spring IOC**

**1、** 看过Spring源码就知道，在Spring IOC容器创建bean的过程是使用了工厂设计模式

**2、** Spring中无论是通过xml配置还是通过配置类还是注解进行创建bean，大部分都是通过简单工厂来进行创建的。

**3、** 当容器拿到了beanName和class类型后，动态的通过反射创建具体的某个对象，最后将创建的对象放到Map中。

**为什么Spring IOC要使用工厂设计模式创建Bean呢**

**1、** 在实际开发中，如果我们A对象调用B，B调用C，C调用D的话我们程序的耦合性就会变高。（耦合大致分为类与类之间的依赖，方法与方法之间的依赖。）

**2、** 在很久以前的三层架构编程时，都是控制层调用业务层，业务层调用数据访问层时，都是是直接new对象，耦合性大大提升，代码重复量很高，对象满天飞

**3、** 为了避免这种情况，Spring使用工厂模式编程，写一个工厂，由工厂创建Bean，以后我们如果要对象就直接管工厂要就可以，剩下的事情不归我们管了。Spring IOC容器的工厂中有个静态的Map集合，是为了让工厂符合单例设计模式，即每个对象只生产一次，生产出对象后就存入到Map集合中，保证了实例不会重复影响程序效率。


### 2、什么时候用断言（assert）？



断言在软件开发中是一种常用的调试方式，很多开发语言中都支持这种机制。一般来说，断言用于保证程序最基本、关键的正确性。断言检查通常在开发和测试时开启。为了保证程序的执行效率，在软件发布后断言检查通常是关闭的。断言是一个包含布尔表达式的语句，在执行这个语句时假定该表达式为true；如果表达式的值为false，那么系统会报告一个AssertionError。断言的使用如下面的代码所示：

```
assert(a > 0); // throws an AssertionError if a <= 0
```

**断言可以有两种形式**：

**1、** assert Expression1;

**2、** assert Expression1 : Expression2 ;

Expression1 应该总是产生一个布尔值。

Expression2 可以是得出一个值的任意表达式；这个值用于生成显示更多调试信息的字符串消息。

要在运行时启用断言，可以在启动JVM时使用-enableassertions或者-ea标记。要在运行时选择禁用断言，可以在启动JVM时使用-da或者-disableassertions标记。要在系统类中启用或禁用断言，可使用-esa或-dsa标记。还可以在包的基础上启用或者禁用断言。

> 注意：断言不应该以任何方式改变程序的状态。简单的说，如果希望在不满足某些条件时阻止代码的执行，就可以考虑用断言来阻止它。



### 3、如何查看 JVM 当前使用的是什么垃圾收集器？

-XX:+PrintCommandLineFlags 参数可以打印出所选垃圾收集器和堆空间大小等设置

如果开启了 GC 日志详细信息，里面也会包含各代使用的垃圾收集器的简称


### 4、为什么我们调用 start() 方法时会执行 run() 方法，为什么我们不能直接调用 run() 方法？

这是另一个非常经典的 java 多线程面试问题，而且在面试中会经常被问到。很简单，但是很多人都会答不上来！

new 一个 Thread，线程进入了新建状态。调用 start() 方法，会启动一个线程并使线程进入了就绪状态，当分配到`时间片`后就可以开始运行了。 start() 会执行线程的相应准备工作，然后自动执行 run() 方法的内容，这是真正的多线程工作。

而直接执行 run() 方法，会把 run 方法当成一个 main 线程下的普通方法去执行，并不会在某个线程中执行它，所以这并不是多线程工作。

**总结：**

调用 start 方法方可启动线程并使线程进入就绪状态，而 run 方法只是 thread 的一个普通方法调用，还是在主线程里执行。


### 5、介绍一下 JVM 中垃圾收集器有哪些？ 他们特点分别是什么？

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


### 6、那些地方用到了单例模式

**1、** 网站的计数器，一般也是采用单例模式实现，否则难以同步。

**2、** 应用程序的日志应用，一般都是单例模式实现，只有一个实例去操作才好，否则内容不好追加显示。

**3、** 多线程的线程池的设计一般也是采用单例模式，因为线程池要方便对池中的线程进行控制

**4、** Windows的（任务管理器）就是很典型的单例模式，他不能打开俩个

**5、** windows的（回收站）也是典型的单例应用。在整个系统运行过程中，回收站只维护一个实例。


### 7、什么是ThreadPoolExecutor？

**ThreadPoolExecutor就是线程池**

ThreadPoolExecutor其实也是JAVA的一个类，我们一般通过Executors工厂类的方法，通过传入不同的参数，就可以构造出适用于不同应用场景下的ThreadPoolExecutor（线程池）

构造参数图：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_6.png#alt=87%5C_6.png)`构造参数参数介绍：`

```
corePoolSize 核心线程数量
maximumPoolSize 最大线程数量
keepAliveTime 线程保持时间，N个时间单位
unit 时间单位（比如秒，分）
workQueue 阻塞队列
threadFactory 线程工厂
handler 线程池拒绝策略
```


### 8、JVM 监控与分析工具你用过哪些？介绍一下。
### 9、请解释Tomcat的默认端口是什么?
### 10、同步方法和同步块，哪个是更好的选择？
### 11、对象的相等与指向他们的引用相等，两者有什么不同？
### 12、java中equals方法的用法以及==的用法
### 13、finalize()方法什么时候被调用？析构函数(finalization)的目的是什么？
### 14、除了使用new创建对象之外，还可以用什么方法创建对象？
### 15、设计模式分类
### 16、谈谈动态年龄判断
### 17、Java 中，直接缓冲区与非直接缓冲器有什么区别？
### 18、Jsp由哪些内容组成？
### 19、如何判断两个类是否相等？
### 20、Spring支持的事务管理类型有哪些？你在项目中使用哪种方式？
### 21、使用Log4j对程序有影响吗？
### 22、如何通过反射获取和设置对象私有字段的值？
### 23、什么是事务？事务有那些特点？
### 24、Java 中，嵌套公共静态类与顶级类有什么不同？
### 25、描述一下JVM加载class文件的原理机制？
### 26、String 属于基础的数据类型吗？
### 27、策略模式应用场景
### 28、HashMap的扩容操作是怎么实现的？
### 29、对象的访问方式有哪些？
### 30、栈
### 31、safepoint是什么？
### 32、栈溢出的原因？
### 33、解释 Java 堆空间及 GC？
### 34、JVM中一次完整的GC流程是怎样的，对象如何晋升到老年代？
### 35、堆
### 36、什么是链表
### 37、如何修改tomcat的端口号？
### 38、Java对象的布局了解过吗？
### 39、TCP 协议与 UDP 协议有什么区别？
### 40、Error与Exception区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
