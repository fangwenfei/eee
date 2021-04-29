# Java高级面试题合集，附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如果你提交任务时，线程池队列已满，这时会发生什么

这里区分一下：

**1、** 如果使用的是无界队列LinkedBlockingQueue，也就是无界队列的话，没关系，继续添加任务到阻塞队列中等待执行，因为LinkedBlockingQueue可以近乎认为是一个无穷大的队列，可以无限存放任务

**2、** 如果使用的是有界队列比如ArrayBlockingQueue，任务首先会被添加到ArrayBlockingQueue中，ArrayBlockingQueue满了，会根据maximumPoolSize的值增加线程数量，如果增加了线程数量还是处理不过来，ArrayBlockingQueue继续满，那么则会使用拒绝策略RejectedExecutionHandler处理满了的任务，默认是AbortPolicy


### 2、在进行数据库编程时，连接池有什么作用？



由于创建连接和释放连接都有很大的开销（尤其是数据库服务器不在本地时，每次建立连接都需要进行TCP的三次握手，释放连接需要进行TCP四次握手，造成的开销是不可忽视的），为了提升系统访问数据库的性能，可以事先创建若干连接置于连接池中，需要时直接从连接池获取，使用结束时归还连接池而不必关闭连接，从而避免频繁创建和释放连接所造成的开销，这是典型的用空间换取时间的策略（浪费了空间存储连接，但节省了创建和释放连接的时间）。池化技术在Java开发中是很常见的，在使用线程时创建线程池的道理与此相同。基于Java的开源数据库连接池主要有：[C3P0](http://sourceforge.net/projects/c3p0/)、[Proxool](http://proxool.sourceforge.net)、[DBCP](http://commons.apache.org/proper/commons-dbcp/)、[BoneCP](https://github.com/wwadge/bonecp)、[Druid](https://github.com/alibaba/druid)等。

> 补充：在计算机系统中时间和空间是不可调和的矛盾，理解这一点对设计满足性能要求的算法是至关重要的。大型网站性能优化的一个关键就是使用缓存，而缓存跟上面讲的连接池道理非常类似，也是使用空间换时间的策略。可以将热点数据置于缓存中，当用户查询这些数据时可以直接从缓存中得到，这无论如何也快过去数据库中查询。当然，缓存的置换策略等也会对系统性能产生重要影响，对于这个问题的讨论已经超出了这里要阐述的范围。



### 3、safepoint 是什么？

**1、** 为了减少对象引用的扫描，使用 OopMap 的数据结构在特定的位置记录下栈里和寄存器里哪些位置是引用；

**2、** 但为了避免给每条指令都生成 OopMap 记录占用大量内存的问题，只在特定位置记录这些信息。

**3、** 安全点的选定既不能太少以至于让收集器等待时间过长，也不能太过频繁以至于过分增大运行时的内存负荷。安全点位置的选取基本上是以“是否具有让程序长时间执行的特征”为标准进行选定的，如方法调用、循环跳转、异常跳转等都属于指令序列复用。


### 4、解释如何使用WAR文件部署web应用程序?

在Tomcat的web应用程序目录下，jsp、servlet和它们的支持文件被放置在适当的子目录中。你可以将web应用程序目录下的所有文件压缩到一个压缩文件中，以.war文件扩展名结束。你可以通过在webapps目录中放置WAR文件来执行web应用程序。当一个web服务器开始执行时，它会将WAR文件的内容提取到适当的webapps子目录中。


### 5、策略模式应用场景

策略模式的用意是针对一组算法或逻辑，将每一个算法或逻辑封装到具有共同接口的独立的类中，从而使得它们之间可以相互替换。

**例如：**

我要做一个不同会员打折力度不同的三种策略，初级会员，中级会员，高级会员（三种不同的计算）。

**例如：**

我要一个支付模块，我要有微信支付、支付宝支付、银联支付等


### 6、什么是不可变对象（immutable object）？Java 中怎么创建一个不可变对象？

不可变对象指对象一旦被创建，状态就不能再改变。任何修改都会创建一个新的对象，如 String、Integer及其它包装类。详情参见答案，一步一步指导你在 Java 中创建一个不可变的类。


### 7、什么是Java虚拟机

任何一种可以运行Java字节码的软件均可看成是Java的虚拟机（JVM）


### 8、在java中守护线程和本地线程区别？

java中的线程分为两种：守护线程（Daemon）和用户线程（User）。

任何线程都可以设置为守护线程和用户线程，通过方法Thread.setDaemon(bool on)；true则把该线程设置为守护线程，反之则为用户线程。Thread.setDaemon()必须在Thread.start()之前调用，否则运行时会抛出异常。

**两者的区别**：

唯一的区别是判断虚拟机(JVM)何时离开，Daemon是为其他线程提供服务，如果全部的User Thread已经撤离，Daemon 没有可服务的线程，JVM撤离。也可以理解为守护线程是JVM自动创建的线程（但不一定），用户线程是程序创建的线程；比如JVM的垃圾回收线程是一个守护线程，当所有线程已经撤离，不再产生垃圾，守护线程自然就没事可干了，当垃圾回收线程是Java虚拟机上仅剩的线程时，Java虚拟机会自动离开。

**扩展**：

Thread Dump打印出来的线程信息，含有daemon字样的线程即为守护进程，可能会有：服务守护进程、编译守护进程、windows下的监听Ctrl+break的守护进程、Finalizer守护进程、引用处理守护进程、GC守护进程。


### 9、线程的 sleep()方法和 yield()方法有什么区别？

**1、** sleep()方法给其他线程运行机会时不考虑线程的优先级，因此会给低优先级的线程以运行的机会；yield()方法只会给相同优先级或更高优先级的线程以运行的机会；

**2、** 线程执行 sleep()方法后转入阻塞（blocked）状态，而执行 yield()方法后转入就绪（ready）状态；

**3、** sleep()方法声明抛出 InterruptedException，而 yield()方法没有声明任何异常；

**4、** sleep()方法比 yield()方法（跟操作系统 CPU 调度相关）具有更好的可移植性，通常不建议使用yield()方法来控制并发线程的执行。


### 10、什么是Java程序的主类？应用程序和小程序的主类有何不同？

一个程序中可以有多个类，但只能有一个类是主类。在Java应用程序中，这个主类是指包含main（）方法的类。而在Java小程序中，这个主类是一个继承自系统类JApplet或Applet的子类。应用程序的主类不一定要求是public类，但小程序的主类要求必须是public类。主类是Java程序执行的入口点。


### 11、Session与cookie的区别？
### 12、什么情况下会发生栈溢出？
### 13、关于 OOP 和设计模式的面试题
### 14、ArrayList 与 LinkedList 的不区别？
### 15、建造者模式的使用场景
### 16、ArrayList 和 Vector 的区别是什么？
### 17、Hibernate的对象有几种状态
### 18、Java 中，throw 和 throws 有什么区别
### 19、多线程的价值？
### 20、JVM 的内存模型是什么？
### 21、Java的内存模型是什么？（JMM是什么？）
### 22、如何检查出两个给定的字符串是反序的？
### 23、import java和javax有什么区别
### 24、常用并发列队的介绍：
### 25、一个java类中包含那些内容？
### 26、什么是重排序
### 27、如果父类只有有参构造方法，那么子类必须要重写父类的构造方法吗？
### 28、Java中垃圾回收有什么目的？什么时候进行垃圾回收？
### 29、什么是建造者模式
### 30、Static关键字有什么作用？
### 31、抽象类和接口的区别?
### 32、简单描述一下（分代）垃圾回收的过程
### 33、Hibernate中SessionFactory是线程安全的吗？Session是线程安全的吗（两个线程能够共享同一个Session吗）？
### 34、单例模式使用注意事项：
### 35、被引用的对象就一定能存活吗？
### 36、什么是B/S架构？什么是C/S架构
### 37、怎么在JDBC内调用一个存储过程
### 38、Java 中，如何将字符串 YYYYMMDD 转换为日期？
### 39、JVM怎么判断一个对象是不是要回收？
### 40、对象分配内存是否线程安全？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
