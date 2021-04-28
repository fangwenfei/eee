# Java高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是JVM？java虚拟机包括什么？

JVM：java虚拟机，运用硬件或软件手段实现的虚拟的计算机，Java虚拟机包括：寄存器，堆栈，处理器


### 2、集合的特点

**集合的特点主要有如下两点：**

**1、** 集合用于存储对象的容器，对象是用来封装数据，对象多了也需要存储集中式管理。

**2、** 和数组对比对象的大小不确定。因为集合是可变长度的。数组需要提前定义大小


### 3、解释如何使用WAR文件部署web应用程序?

在Tomcat的web应用程序目录下，jsp、servlet和它们的支持文件被放置在适当的子目录中。你可以将web应用程序目录下的所有文件压缩到一个压缩文件中，以.war文件扩展名结束。你可以通过在webapps目录中放置WAR文件来执行web应用程序。当一个web服务器开始执行时，它会将WAR文件的内容提取到适当的webapps子目录中。


### 4、本地方法区(线程私有)

本地方法区和 Java Stack 作用类似, 区别是虚拟机栈为执行 Java 方法服务, 而本地方法栈则为Native 方法服务, 如果一个 VM 实现使用 C-linkage 模型来支持 Native 调用, 那么该栈将会是一个C 栈，但 HotSpot VM 直接就把本地方法栈和虚拟机栈合二为一 。


### 5、什么是线程局部变量？

线程局部变量是局限于线程内部的变量，属于线程自身所有，不在多个线程间共享。Java 提供 ThreadLocal 类来支持线程局部变量，是一种实现线程安全的方式。但是在管理环境下（如 web 服务器）使用线程局部变量的时候要特别小心，在这种情况下，工作线程的生命周期比任何应用变量的生命周期都要长。任何线程局部变量一旦在工作完成后没有释放，Java 应用就存在内存泄露的风险。


### 6、Collection 和 Collections 有什么区别？

java.util.Collection 是一个集合接口（集合类的一个顶级接口）。它提供了对集合对象进行基本操作的通用接口方法。Collection接口在Java 类库中有很多具体的实现。Collection接口的意义是为各种具体的集合提供了最大化的统一操作方式，其直接继承接口有List与Set。

Collections则是集合类的一个工具类/帮助类，其中提供了一系列静态方法，用于对集合中元素进行排序、搜索以及线程安全等各种操作。


### 7、Java中Synchronized关键字的使用？

Synchronized关键字在方法签名上，可以防止多个线程同时访问这个对象的synchronized修饰的方法。如果一个对象有多个synchronized方法，只要一个线程访问其中的一个同步方法，那么其他线程就不能访问对象其他的任何一个同步方法。不同对象实例的synchronize方法是互不干扰的，也就是说，其他对象还可以访问这个类中的同步方法。

Synchronized如果修饰的是静态方法，防止多个线程同时访问这个类中的静态同步方法，它对类中所有对象都能起作用。也就是说，只有一个对象一个线程可以访问静态同步方法

Synchronized修饰方法中的某段代码块，只对当前代码块实行互斥访问。当多个线程同步访问同步代码块，同一时间只能有一个线程得到执行，其他线程必须等待当前线程执行完代码块之后才能执行。当一个线程访问同步代码快时，其他线程可以访问非同步的代码。当一个线程访问同步代码块时，那么其他线程访问对其他同步代码块的访问将会被阻塞

Synchronized关键字是不能继承的，如果父类的synchronized在继承时并不自动是synchronized修饰的，需要显示地声明。

Synchronized修饰this时，会得到这个对象的对象锁，当一个线程访问时，那么其他线程访问对象的所有同步代码块或者同步方法，将会被阻塞。


### 8、什么是方法内联？

为了减少方法调用的开销，可以把一些短小的方法，纳入到目标方法的调用范围之内，这样就少了一次方法调用，提升速度


### 9、说出至少 5 点在 Java 中使用线程的最佳实践。

答案

[http://java67.blogspot.com/2014/01/10-points-about-thread-and-javalangthread-in-java.html](http://java67.blogspot.com/2014/01/10-points-about-thread-and-javalangthread-in-java.html)

**1、** 这个问题与之前的问题类似，你可以使用上面的答案。对线程来说，你应该：

**2、** 对线程命名

**3、** 将线程和任务分离，使用线程池执行器来执行 Runnable 或 Callable。

**4、** 使用线程池


### 10、Spring中Bean的作用域有哪些？

**1、** Singleton：Bean以单例的方式存在

**2、** Prototype：表示每次从容器中调用Bean时，都会返回一个新的实例，prototype通常翻译为原型

**3、** Request：每次HTTP请求都会创建一个新的Bean

**4、** Session：同一个HttpSession共享同一个Bean，不同的HttpSession使用不同的Bean

**5、** globalSession：同一个全局Session共享一个Bean


### 11、守护线程和用户线程有什么区别呢？
### 12、面向对象的特征有哪些方面？
### 13、构造方法有哪些特性？
### 14、如何停止一个正在运行的线程？
### 15、调优工具
### 16、Java 中的同步集合与并发集合有什么区别？
### 17、什么是过滤器？怎么创建一个过滤器
### 18、堆和栈的区别
### 19、32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？
### 20、String 是最基本的数据类型吗？
### 21、请解释StackOverflowError和OutOfMemeryError的区别？
### 22、说几个常见的编译时异常类？
### 23、抽象类可以使用final修饰吗？
### 24、Servlet中如何获取用户提交的查询参数或表单数据？
### 25、什么是多态机制？Java语言是如何实现多态的？
### 26、JDBC中如何进行事务处理？
### 27、JIT 是什么？
### 28、什么是Executors？
### 29、怎么打出线程栈信息？
### 30、说说CMS垃圾收集器的工作原理
### 31、HashSet如何检查重复？HashSet是如何保证数据不可重复的？
### 32、用 wait-notify 写一段代码来解决生产者-消费者问题？
### 33、synchronized、volatile、CAS比较
### 34、什么是线程池（thread pool）？
### 35、策略模式应用场景
### 36、在java中wait和sleep方法的不同？
### 37、线程与进程的区别
### 38、Java中是如何支持正则表达式操作的？
### 39、Java 中垃圾收集的方法有哪些
### 40、React有哪些优化性能是手段?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
