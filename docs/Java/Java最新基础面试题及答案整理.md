# Java最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在异常捕捉时，如果发生异常，那么try.catch.finally块外的return语句会执行吗？

会执行，如果有finally，在finally之后被执行，如果没有finally，在catch之后被执行


### 2、是否了解连接池，使用连接池有什么好处？

数据库连接是非常消耗资源的，影响到程序的性能指标。连接池是用来分配、管理、释放数据库连接的，可以使应用程序重复使用同一个数据库连接，而不是每次都创建一个新的数据库连接。通过释放空闲时间较长的数据库连接避免数据库因为创建太多的连接而造成的连接遗漏问题，提高了程序性能。


### 3、串行(serial)收集器和吞吐量(throughput)收集器的区别是什么？

吞吐量收集器使用并行版本的新生代垃圾收集器，它用于中等规模和大规模数据的应用程序。而串行收集器对大多数的小应用(在现代处理器上需要大概100M左右的内存)就足够了。


### 4、你所知道的web服务器有哪些？

**1、** Tomcat

**2、** Jboss

**3、** Weblogic

**4、** Glassfish


### 5、Java 虚拟机栈的作用？

**Java 虚拟机栈**来描述 Java 方法的内存模型。每当有新线程创建时就会分配一个栈空间，线程结束后栈空间被回收，栈与线程拥有相同的生命周期。栈中元素用于支持虚拟机进行方法调用，每个方法在执行时都会创建一个栈帧存储方法的局部变量表、操作栈、动态链接和方法出口等信息。每个方法从调用到执行完成，就是栈帧从入栈到出栈的过程。

有两类异常：① 线程请求的栈深度大于虚拟机允许的深度抛出 StackOverflowError。② 如果 JVM 栈容量可以动态扩展，栈扩展无法申请足够内存抛出 OutOfMemoryError（HotSpot 不可动态扩展，不存在此问题）。


### 6、环境变量Path和ClassPath的作用是什么？如何设置这两个环境变量？

Java环境变量PATH和CLASSPATH - 简书 [http://www.jianshu.com/p/d63b099cf283](http://www.jianshu.com/p/d63b099cf283)


### 7、Servlet的生命周期？

**1、** 加载：判断servlet实例是否存在，如果不存在，就加载serlvet

**2、** 实例化：

**3、** 初始化

4、服务

5、销毁


### 8、当一个对象被当作参数传递到一个方法后，此方法可改变这个对象的属性，并可返回变化后的结果，那么这里到底是值传递还是引用传递？
### 9、final 在 java 中有什么作用？
### 10、常用并发列队的介绍：
### 11、对象的内存布局了解吗？
### 12、如何用Java代码列出一个目录下所有的文件？
### 13、Jsp包含那些隐藏对象或者内建对象
### 14、React最新的生命周期是怎样的?
### 15、类加载为什么要使用双亲委派模式，有没有什么场景是打破了这个模式？
### 16、Parallel Scavenge 收集器（多线程复制算法、高效）
### 17、形成死锁的四个必要条件是什么
### 18、请说出与线程同步以及线程调度相关的方法。
### 19、阐述JDBC操作数据库的步骤。
### 20、你熟悉哪些垃圾收集算法？
### 21、ConcurrentHashMap 底层具体实现知道吗？实现原理是什么？
### 22、说说你知道的几种主要的JVM参数
### 23、Parallel Old 收集器（多线程标记整理算法）
### 24、volatile 变量和 atomic 变量有什么不同？
### 25、64 位 JVM 中，int 的长度是多数？
### 26、什么是Java虚拟机
### 27、生产环境 CPU 占用过高，你如何解决？
### 28、类加载是什么？
### 29、Java 中，如何计算两个日期之间的差距？
### 30、调优命令有哪些？
### 31、你做过 JVM 调优，说说如何查看 JVM 参数默认值？
### 32、接口和抽象类有什么区别？
### 33、你知道哪些故障处理工具？
### 34、常用io类有那些？
### 35、可以直接调用Thread类的run ()方法么？
### 36、静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同？
### 37、&和&&的区别？
### 38、调优工具
### 39、CopyOnWriteArrayList 的设计思想?
### 40、什么是同步任务？什么是异步任务？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
