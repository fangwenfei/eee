# Java高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、使用JDBC操作数据库时，如何提升读取数据的性能？如何提升更新数据的性能？



要提升读取数据的性能，可以指定通过结果集（ResultSet）对象的setFetchSize()方法指定每次抓取的记录数（典型的空间换时间策略）；要提升更新数据的性能可以使用PreparedStatement语句构建批处理，将若干SQL语句置于一个批处理中执行。


### 2、Java中notify 和 notifyAll有什么区别？

notify() 方法不能唤醒某个具体的线程，所以只有一个线程在等待的时候它才有用武之地。而notifyAll()唤醒所有线程并允许他们争夺锁确保了至少有一个线程能继续运行。


### 3、什么是 Callable 和 Future?

Callable 接口类似于 Runnable，从名字就可以看出来了，但是 Runnable 不会返回结果，并且无法抛出返回结果的异常，而 Callable 功能更强大一些，被线程执行后，可以返回值，这个返回值可以被 Future 拿到，也就是说，Future 可以拿到异步执行任务的返回值。

Future 接口表示异步任务，是一个可能还没有完成的异步任务的结果。所以说 Callable用于产生结果，Future 用于获取结果。


### 4、列出 5 个应该遵循的 JDBC 最佳实践

有很多的最佳实践，你可以根据你的喜好来例举。下面是一些更通用的原则：

**1、** 使用批量的操作来插入和更新数据

**2、** 使用 PreparedStatement 来避免 SQL 异常，并提高性能。

**3、** 使用数据库连接池

**4、** 通过列名来获取结果集，不要使用列的下标来获取。


### 5、什么是竞争条件？你怎样发现和解决竞争？

当多个进程都企图对共享数据进行某种处理，而最后的结果又取决于进程运行的顺序时，则我们认为这发生了竞争条件（race condition）。


### 6、乐观锁和悲观锁的理解及如何实现，有哪些实现方式？

**悲观锁：**

总是假设最坏的情况，每次去拿数据的时候都认为别人会修改，所以每次在拿数据的时候都会上锁，这样别人想拿这个数据就会阻塞直到它拿到锁。传统的关系型数据库里边就用到了很多这种锁机制，比如行锁，表锁等，读锁，写锁等，都是在做操作之前先上锁。再比如 Java 里面的同步原语 synchronized 关键字的实现也是悲观锁。

**乐观锁：**

顾名思义，就是很乐观，每次去拿数据的时候都认为别人不会修改，所以不会上锁，但是在更新的时候会判断一下在此期间别人有没有去更新这个数据，可以使用版本号等机制。乐观锁适用于多读的应用类型，这样可以提高吞吐量，像数据库提供的类似于 write_condition 机制，其实都是提供的乐观锁。在 Java中 java.util.concurrent.atomic 包下面的原子变量类就是使用了乐观锁的一种实现方式 CAS 实现的。


### 7、那针对浮点型数据运算出现的误差的问题，你怎么解决？

使用Bigdecimal类进行浮点型数据的运算


### 8、Java中ConcurrentHashMap的并发度是什么？
### 9、Java中有几种类型的流？
### 10、谈谈你知道的垃圾回收算法
### 11、如何使session失效
### 12、什么是线程同步和线程互斥，有哪几种实现方式？
### 13、Java内存模型
### 14、什么是Callable和Future?
### 15、redux与mobx的区别?
### 16、谈谈你知道的垃圾收集器
### 17、在多线程环境下，SimpleDateFormat 是线程安全的吗？
### 18、在Java中CycliBarriar和CountdownLatch有什么区别？
### 19、形参与实参
### 20、如何停止一个正在运行的线程？
### 21、讲讲什么情况下会出现内存溢出，内存泄漏？
### 22、抽象类可以使用final修饰吗？
### 23、说出至少 5 点在 Java 中使用线程的最佳实践。
### 24、什么是Executors框架？
### 25、Java 中 interrupted 和 isInterrupted 方法的区别？
### 26、Java 中怎样将 bytes 转换为 long 类型？
### 27、引用计数法
### 28、假如生产环境CPU占用过高，请谈谈你的分析思路和定位。
### 29、数组有没有length()方法？String有没有length()方法？
### 30、抽象类必须要有抽象方法吗
### 31、监听器有哪些作用和用法？
### 32、运行时常量池的作用是什么?
### 33、永久代
### 34、什么是并发容器的实现？
### 35、怎么利用 JUnit 来测试一个方法的异常？
### 36、CMS 收集器（多线程标记清除算法）
### 37、运行时异常与受检异常有何异同？
### 38、运行时常量池溢出的原因？
### 39、如何理解Hibernate的延迟加载机制？在实际应用中，延迟加载与Session关闭的矛盾是如何处理的？
### 40、谈谈双亲委派模型




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
