# Java高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、为什么HashMap中String、Integer这样的包装类适合作为K？

String、Integer等包装类的特性能够保证Hash值的不可更改性和计算准确性，能够有效的减少Hash碰撞的几率

**1、** 都是final类型，即不可变性，保证key的不可更改性，不会存在获取hash值不同的情况

**2、** 内部已重写了`equals()`、`hashCode()`等方法，遵守了HashMap内部的规范（不清楚可以去上面看看putValue的过程），不容易出现Hash值计算错误的情况；


### 2、try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?



会执行，在方法返回调用者前执行。

> 注意：在finally中改变返回值的做法是不好的，因为如果存在finally代码块，try中的return语句不会立马返回调用者，而是记录下返回值待finally代码块执行完毕之后再向调用者返回其值，然后如果在finally中修改了返回值，就会返回修改后的值。显然，在finally中返回或者修改返回值会对程序造成很大的困扰，C#中直接用编译错误的方式来阻止程序员干这种龌龊的事情，Java中也可以通过提升编译器的语法检查级别来产生警告或错误，Eclipse中可以在如图所示的地方进行设置，强烈建议将此项设置为编译错误。


![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0816/03/img_1.png#alt=img%5C_1.png)


### 3、在 Java 中 Executor 和 Executors 的区别？

**1、** Executors 工具类的不同方法按照我们的需求创建了不同的线程池，来满足业务的需求。

**2、** Executor 接口对象能执行我们的线程任务。

**3、** ExecutorService 接口继承了 Executor 接口并进行了扩展，提供了更多的方法我们能获得任务执行的状态并且可以获取任务的返回值。

**4、** 使用 ThreadPoolExecutor 可以创建自定义线程池。


### 4、抽象工厂模式和原型模式之间的区别？

抽象工厂模式：通常由工厂方法模式来实现。但一个工厂中往往含有多个工厂方法生成一系列的产品。这个模式强调的是客户代码一次保证只使用一个系列的产品。当要切换为另一个系列的产品，换一个工厂类即可。

原型模式：工厂方法的最大缺点就是，对应一个继承体系的产品类，要有一个同样复杂的工厂类的继承体系。我们可以把工厂类中的工厂方法放到产品类自身之中吗？如果这样的话，就可以将两个继承体系为一个。这也就是原型模式的思想，原型模式中的工厂方法为clone，它会返回一个拷贝（可以是浅拷贝，也可以是深拷贝，由设计者决定）。为了保证用户代码中到时可以通过指针调用clone来动态绑定地生成所需的具体的类。这些原型对象必须事先构造好。

原型模式想对工厂方法模式的另一个好处是，拷贝的效率一般对构造的效率要高。


### 5、java中有几种方法可以实现一个线程？

继承 Thread 类

实现 Runnable 接口

实现 Callable 接口，需要实现的是 call() 方法


### 6、JVM内存模型

线程独占:栈,本地方法栈,程序计数器

线程共享:堆,方法区


### 7、四种线程池的创建：

**1、** newCachedThreadPool创建一个可缓存线程池

**2、** newFixedThreadPool 创建一个定长线程池，可控制线程最大并发数。

**3、** newScheduledThreadPool 创建一个定长线程池，支持定时及周期性任务执行。

**4、** newSingleThreadExecutor 创建一个单线程化的线程池，它只会用唯一的工作线程来执行任务。


### 8、什么是重写？什么是重载？

重载和重写都是java多态的表现。

重载叫override，在同一个类中多态的表现。当一个类中出现了多个相同名称的方法，但参数个数和参数类型不同，方法重载与返回值无关

重写叫overwrite，是字符类中多态的表现。当子类出现与父类相同的方法，那么这就是方法重写。方法重写时，子类的返回值必须与父类的一致。如果父类方法抛出一个异常，子类重写的方法抛出的异常类型不能小于父类抛出的异常类型。


### 9、线程同步的方法

**1、** wait():让线程等待。将线程存储到一个线程池中。

**2、** notify()：唤醒被等待的线程。通常都唤醒线程池中的第一个。让被唤醒的线程处于临时阻塞状态。

**3、** notifyAll(): 唤醒所有的等待线程。将线程池中的所有线程都唤醒。


### 10、你都用过G1垃圾回收器的哪几个重要参数？

最重要的是`MaxGCPauseMillis`，可以通过它设定G1的目标停顿时间，它会尽量的去达成这个目标。G1HeapRegionSize可以设置小堆区的大小，一般是2的次幂。

`InitiatingHeapOccupancyPercent`，启动并发GC时的堆内存占用百分比。G1用它来触发并发GC周期，基于整个堆的使用率，而不只是某一代内存的使用比例，默认是45%。

再多？不是专家，就没必要要求别人也是。


### 11、多线程同步有哪几种方法？
### 12、Tcp协议的特点
### 13、用Java实现阻塞队列
### 14、简述synchronized 和java.util.concurrent.locks.Lock的异同？
### 15、使用Log4j对程序有影响吗？
### 16、什么是阻塞式方法？
### 17、游标的创建步骤？
### 18、Java 中你怎样唤醒一个阻塞的线程？
### 19、comparable 和 comparator的区别？
### 20、说出几点 Java 中使用 Collections 的最佳实践
### 21、G1 收集器
### 22、堆的作用是什么？
### 23、如何判断对象可以被回收
### 24、Java中垃圾回收有什么目的？什么时候进行垃圾回收？
### 25、垃圾收集算法
### 26、Serial 垃圾收集器（单线程、 复制算法）
### 27、java中equals方法的用法以及==的用法
### 28、请解释一下什么时候可以使用“.”，什么时候可以使用“[]”?
### 29、形参与实参
### 30、Xml的java解析有几种方式？
### 31、能否使用任何类作为 Map 的 key？
### 32、为什么wait()方法和notify()/notifyAll()方法要在同步块中被调用
### 33、Log4j日志有几个级别？
### 34、如何选择单例创建方式
### 35、什么时候使用模板方法
### 36、常用并发列队的介绍：
### 37、什么是方法重载？
### 38、什么是线程组，为什么在Java中不推荐使用？
### 39、如何合理分配线程池大小?
### 40、Spring支持的事务管理类型有哪些？你在项目中使用哪种方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
