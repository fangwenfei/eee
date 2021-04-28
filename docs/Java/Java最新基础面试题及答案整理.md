# Java最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、怎样通过 Java 程序来判断 JVM 是 32 位 还是 64位？

你可以检查某些系统属性如 sun.arch.data.model 或 os.arch 来获取该信息。


### 2、怎么在JDBC内调用一个存储过程

使用CallableStatement


### 3、你对线程优先级的理解是什么？

**1、** 每一个线程都是有优先级的，一般来说，高优先级的线程在运行时会具有优先权，但这依赖于线程调度的实现，这个实现是和操作系统相关的(OS dependent)。我们可以定义线程的优先级，但是这并不能保证高优先级的线程会在低优先级的线程前执行。线程优先级是一个int变量(从1-10)，1代表最低优先级，10代表最高优先级。

**2、** java的线程优先级调度会委托给操作系统去处理，所以与具体的操作系统优先级有关，如非特别需要，一般无需设置线程优先级。


### 4、你平时工作中用过的JVM常用基本配置参数有哪些？

**-Xms**

初始化大小内存，默认为物理内存1/64

等价于-XX:InitialHeapSize

**-Xmx**

最大分配内存，默认物理内存的1/4

等价于-XX:MaxHeapSize

**-Xss**

设置单个线程栈的大小，一般默认为512K~1024K

等价于-XX:ThreadStackSize

-XX:ThreadStackSize = 0 ， 表示使用默认512K~1024K

-XX:ThreadStackSize != 0 , 表示使用自己设置的

**-Xmn**

设置年轻代大小,一般不需要改动

**-Xms128m -Xmx4096m -Xss1024k -XX:MetaSpaceSize=512m -XX:+PrintCommandFlags -XX:+PrintGCDetails -XX:+UseSerialGC**

**-XX:MetaspaceSize**

元空间的本质和永久代类似，都是对JVM规范中方法区的实现。

不过元空间与永久代之间最大的区别在于：

永久代在堆里面

元空间并不在虚拟机中，而是使用本地内存。

因此，在默认情况下，元空间的大小仅受本地内存限制

eg:

Xms10m -Xmx10m -XX:MetaspaceSize=1024m -XX:+PrintFlagsFinal

初始值约21M，也就是说只占用本地内存的21M，如果你频繁的new对象，有可能就会把元空间撑爆从而发生元空间异常，因此需要调大一些

-XX:+PrintGCDetails

你只需要记忆10个左右即可应付`绝大多数`面试，建议只记忆G1相关参数。CMS这种既耗时间参数又多又被淘汰的东西，不看也罢。面试时间有限，不会在这上面纠结，除非你表现的太嚣张了。


### 5、说明Tomcat配置了多少个Valve?

Tomcat配置了四种类型的Valve：

**1、** 访问日志

**2、** 远程地址过滤

**3、** 远程主机过滤器

**4、** 客户请求记录器


### 6、抽象类必须要有抽象方法吗？

示例代码：

```
abstract class Cat {
    public static void sayHi() {
    System.out.println("hi~");
    }
}
```

上面代码，抽象类并没有抽象方法但完全可以正常运行。


### 7、多线程的常用方法
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



### 8、事务的使用场景在什么地方？

但一个业务逻辑包括多个数据库操作的时候，而且需要保证每个数据表操作都执行的成功进行下一个操作，这个时候可以使用事务


### 9、简述Hibernate常见优化策略。

**1、** 制定合理的缓存策略（二级缓存、查询缓存）。

**2、** 采用合理的Session管理机制。

**3、** 尽量使用延迟加载特性。

**4、** 设定合理的批处理参数。

**5、** 如果可以，选用UUID作为主键生成器。

**6、** 如果可以，选用乐观锁替代悲观锁。

**7、** 在开发过程中, 开启hibernate.show_sql选项查看生成的SQL，从而了解底层的状况；开发完成后关闭此选项。

**8、** 考虑数据库本身的优化，合理的索引、恰当的数据分区策略等都会对持久层的性能带来可观的提升，但这些需要专业的DBA（数据库管理员）提供支持。


### 10、ArrayList和Vector有什么不同之处？

**Vector方法带上了synchronized关键字，是线程同步的**

**1、** ArrayList添加方法源码 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_10.png#alt=87%5C_10.png)

**2、** Vector添加源码（加锁了synchronized关键字） ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_11.png#alt=87%5C_11.png)


### 11、本地方法栈
### 12、如何确保线程安全？
### 13、ConcurrentHashMap的并发度是什么
### 14、是否可以从一个静态（static）方法内部发出对非静态（non-static）方法的调用？
### 15、React有哪些优化性能是手段?
### 16、为什么 Thread 类的 sleep()和 yield ()方法是静态的？
### 17、假如生产环境CPU占用过高，请谈谈你的分析思路和定位。
### 18、如何使用exception对象？
### 19、String 类的常用方法都有那些？
### 20、单例模式了解吗？给我解释一下双重检验锁方式实现单例模式！”
### 21、策略模式的优点和缺点
### 22、JAVA弱引用
### 23、int 和 Integer 哪个会占用更多的内存？
### 24、Java中操作字符串使用哪个类？
### 25、JVM 类加载机制
### 26、什么情况发生栈溢出？
### 27、解释servlet如何完成生命周期?
### 28、char 型变量中能不能存贮一个中文汉字，为什么？
### 29、Java线程具有五中基本状态
### 30、什么是原子操作？在Java Concurrency API中有哪些原子类(atomic classes)？
### 31、Java 的引用有哪些类型？
### 32、什么是方法的返回值？返回值在类的方法里的作用是什么？
### 33、JAVA软引用
### 34、如何将字符串反转？
### 35、为什么代码会重排序？
### 36、MinorGC，MajorGC、FullGC都什么时候发生？
### 37、Java 中应该使用什么数据类型来代表价格？
### 38、Java 中，编写多线程程序的时候你会遵循哪些最佳实践？
### 39、构造方法能不能重写？能不能重载？
### 40、说出几条 Java 中方法重载的最佳实践？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
