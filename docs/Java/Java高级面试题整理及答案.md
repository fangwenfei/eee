# Java高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Java 中，编写多线程程序的时候你会遵循哪些最佳实践？

这是我在写Java 并发程序的时候遵循的一些最佳实践：

**1、** 给线程命名，这样可以帮助调试。

**2、** 最小化同步的范围，而不是将整个方法同步，只对关键部分做同步。

**3、** 如果可以，更偏向于使用 volatile 而不是 synchronized。

**4、** 使用更高层次的并发工具，而不是使用 wait() 和 notify() 来实现线程间通信，如 BlockingQueue，CountDownLatch 及 Semeaphore。

**5、** 优先使用并发集合，而不是对集合进行同步。并发集合提供更好的可扩展性。


### 2、线程的生命周期？

1、新建

2、就绪

3、运行

4、死亡

5、阻塞


### 3、Java线程数过多会造成什么异常？

**1、** 线程的生命周期开销非常高

**2、** 消耗过多的CPU资源

如果可运行的线程数量多于可用处理器的数量，那么有线程将会被闲置。大量空闲的线程会占用许多内存，给垃圾回收器带来压力，而且大量的线程在竞争CPU资源时还将产生其他性能的开销。

**3、** 降低稳定性

JVM在可创建线程的数量上存在一个限制，这个限制值将随着平台的不同而不同，并且承受着多个因素制约，包括JVM的启动参数、Thread构造函数中请求栈的大小，以及底层操作系统对线程的限制等。如果破坏了这些限制，那么可能抛出OutOfMemoryError异常。


### 4、模块化编程与热插拔

OSGi 旨在为实现 Java 程序的模块化编程提供基础条件，基于 OSGi 的程序很可能可以实现模块级的热插拔功能，当程序升级更新时，可以只停用、重新安装然后启动程序的其中一部分，这对企业级程序开发来说是非常具有诱惑力的特性。

OSGi 描绘了一个很美好的模块化开发目标，而且定义了实现这个目标的所需要服务与架构，同时也有成熟的框架进行实现支持。但并非所有的应用都适合采用 OSGi 作为基础架构，它在提供强大功能同时，也引入了额外的复杂度，因为它不遵守了类加载的双亲委托模型。


### 5、适配器模式和代理模式之前有什么不同？

这个问题与前面的类似，适配器模式和代理模式的区别在于他们的意图不同。由于适配器模式和代理模式都是封装真正执行动作的类，因此结构是一致的，但是适配器模式用于接口之间的转换，而代理模式则是增加一个额外的中间层，以便支持分配、控制或智能访问。


### 6、什么是ORM？

对象关系映射（Object-Relational Mapping，简称ORM）是一种为了解决程序的面向对象模型与数据库的关系模型互不匹配问题的技术


### 7、Java中是如何支持正则表达式操作的？



Java中的String类提供了支持正则表达式操作的方法，包括：matches()、replaceAll()、replaceFirst()、split()。此外，Java中可以用Pattern类表示正则表达式对象，它提供了丰富的API进行各种正则表达式操作，请参考下面面试题的代码。

> 面试题： - 如果要从字符串中截取第一个英文左括号之前的字符串，例如：北京市(朝阳区)(西城区)(海淀区)，截取结果为：北京市，那么正则表达式怎么写？


```
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class RegExpTest {

    public static void main(String[] args) {
        String str = "北京市(朝阳区)(西城区)(海淀区)";
        Pattern p = Pattern.compile(".*?(?=\\()");
        Matcher m = p.matcher(str);
        if(m.find()) {
            System.out.println(m.group());
        }
    }
}
```

> 说明：上面的正则表达式中使用了懒惰匹配和前瞻，如果不清楚这些内容，推荐读一下网上很有名的[《正则表达式30分钟入门教程》](http://www.jb51.net/tools/zhengze.html)。



### 8、对象的内存布局了解吗？

对象在堆内存的存储布局可分为对象头、实例数据和对齐填充。

**对象头**占 12B，包括对象标记和类型指针。对象标记存储对象自身的运行时数据，如哈希码、GC 分代年龄、锁标志、偏向线程 ID 等，这部分占 8B，称为 Mark Word。Mark Word 被设计为动态数据结构，以便在极小的空间存储更多数据，根据对象状态复用存储空间。

类型指针是对象指向它的类型元数据的指针，占 4B。JVM 通过该指针来确定对象是哪个类的实例。

**实例数据**是对象真正存储的有效信息，即本类对象的实例成员变量和所有可见的父类成员变量。存储顺序会受到虚拟机分配策略参数和字段在源码中定义顺序的影响。相同宽度的字段总是被分配到一起存放，在满足该前提条件的情况下父类中定义的变量会出现在子类之前。

**对齐填充**不是必然存在的，仅起占位符作用。虚拟机的自动内存管理系统要求任何对象的大小必须是 8B 的倍数，对象头已被设为 8B 的 1 或 2 倍，如果对象实例数据部分没有对齐，需要对齐填充补全。


### 9、多线程的常用方法
| 方法 名 | 描述 |
| --- | --- |
| sleep() | 强迫一个线程睡眠Ｎ毫秒 |
| isAlive() | 判断一个线程是否存活。 |
| join() | 等待线程终止。 |
| activeCount() | 程序中活跃的线程数。 |
| enumerate() | 枚举程序中的线程。 |
| currentThread() | 得到当前线程。 |
| isDaemon() | 一个线程是否为守护线程。 |
| setDaemon() | 设置一个线程为守护线程。 |
| setName() | 为线程设置一个名称。 |
| wait() | 强迫一个线程等待。 |
| notify() | 通知一个线程继续运行。 |
| setPriority() | 设置一个线程的优先级。 |



### 10、策略模式的优点和缺点

**优点：**

**1、** 算法可以自由切换。

**2、** 避免使用多重条件判断。

**3、** 扩展性非常良好。

**缺点：**

**1、** 策略类会增多。

**2、** 所有策略类都需要对外暴露。

- 代码演示

模拟支付模块有微信支付、支付宝支付、银联支付

**1、** 定义抽象的公共方法

```
package com.lijie;

//策略模式 定义抽象方法 所有支持公共接口
abstract class PayStrategy {

    // 支付逻辑方法
    abstract void algorithmInterface();

}
```

**2、** 定义实现微信支付

```
package com.lijie;

class PayStrategyA extends PayStrategy {

    void algorithmInterface() {
        System.out.println("微信支付");
    }
}
```

**3、** 定义实现支付宝支付

```
package com.lijie;

class PayStrategyB extends PayStrategy {

    void algorithmInterface() {
        System.out.println("支付宝支付");
    }
}
```

**4、** 定义实现银联支付

```
package com.lijie;

class PayStrategyC extends PayStrategy {

    void algorithmInterface() {
        System.out.println("银联支付");
    }
}
```

**5、** 定义下文维护算法策略

```
package com.lijie;// 使用上下文维护算法策略

class Context {

    PayStrategy strategy;

    public Context(PayStrategy strategy) {
        this.strategy = strategy;
    }

    public void algorithmInterface() {
        strategy.algorithmInterface();
    }

}
```

**6、** 运行测试

```
package com.lijie;

class ClientTestStrategy {
    public static void main(String[] args) {
        Context context;
        //使用支付逻辑A
        context = new Context(new PayStrategyA());
        context.algorithmInterface();
        //使用支付逻辑B
        context = new Context(new PayStrategyB());
        context.algorithmInterface();
        //使用支付逻辑C
        context = new Context(new PayStrategyC());
        context.algorithmInterface();
    }
}
```


### 11、Java 中，直接缓冲区与非直接缓冲器有什么区别？
### 12、int和Integer有什么区别？
### 13、如何判断对象可以被回收
### 14、怎么看死锁的线程？
### 15、什么是多态机制？Java语言是如何实现多态的？
### 16、什么是工厂模式
### 17、什么时候使用访问者模式？
### 18、对象在哪块内存分配？
### 19、Parallel Old 收集器（多线程标记整理算法）
### 20、如何使用exception对象？
### 21、什么是并发容器的实现？
### 22、栈溢出的原因？
### 23、ArrayList 和 HashMap 的默认大小是多数？
### 24、如何查看 JVM 当前使用的是什么垃圾收集器？
### 25、Java 中用到的线程调度算法是什么？
### 26、用 wait-notify 写一段代码来解决生产者-消费者问题？
### 27、JDK 和 JRE 有什么区别？
### 28、类加载的过程是什么？
### 29、为什么使用Executor框架？
### 30、什么是happen-before原则？
### 31、Session与cookie的区别？
### 32、说说CMS垃圾收集器的工作原理
### 33、JDBC操作的步骤
### 34、JAVA弱引用
### 35、解释什么是Tomcat Valve?
### 36、策略模式应用场景
### 37、抽象类必须要有抽象方法吗
### 38、Java 中，抽象类与接口之间有什么不同？
### 39、形成死锁的四个必要条件是什么
### 40、UML中有哪些常用的图？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
