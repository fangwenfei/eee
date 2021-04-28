# Java高级面试题及答案，最新版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么叫线程安全？servlet是线程安全吗?

线程安全是编程中的术语，指某个函数、函数库在多线程环境中被调用时，能够正确地处理多个线程之间的共享变量，使程序功能正确完成。

Servlet不是线程安全的，servlet是单实例多线程的，当多个线程同时访问同一个方法，是不能保证共享变量的线程安全性的。

Struts2的action是多实例多线程的，是线程安全的，每个请求过来都会new一个新的action分配给这个请求，请求完成后销毁。

SpringMVC的Controller是线程安全的吗？不是的，和Servlet类似的处理流程。

Struts2好处是不用考虑线程安全问题；Servlet和SpringMVC需要考虑线程安全问题，但是性能可以提升不用处理太多的gc，可以使用ThreadLocal来处理多线程的问题。


### 2、例如： if(a+1.0=4.0)，这样做好吗？

不好，因为计算机在浮点型数据运算的时候，会有误差，尽量在布尔表达式中不使用浮点型数据(if,while,switch中判断条件不使用浮点型)


### 3、Java 中能创建 volatile 数组吗？

能，Java 中可以创建 volatile 类型数组，不过只是一个指向数组的引用，而不是整个数组。意思是，如果改变引用指向的数组，将会受到 volatile 的保护，但是如果多个线程同时改变数组的元素，volatile 标示符就不能起到之前的保护作用了。


### 4、怎么利用 JUnit 来测试一个方法的异常？

[http://javarevisited.blogspot.sg/2013/04/JUnit-tutorial-example-test-exception-thrown-by-java-method.html](http://javarevisited.blogspot.sg/2013/04/JUnit-tutorial-example-test-exception-thrown-by-java-method.html)


### 5、有哪些打破了双亲委托机制的案例？

**1、** Tomcat可以加载自己目录下的class文件，并不会传递给父类的加载器。

**2、** Java的SPI，发起者是 `BootstrapClassLoader`， `BootstrapClassLoader`已经是最上层的了。它直接获取了 `AppClassLoader`进行驱动加载，和双亲委派是相反的。。


### 6、Array与ArrayList有什么不一样？

Array与ArrayList都是用来存储数据的集合。ArrayList底层是使用数组实现的，但是arrayList对数组进行了封装和功能扩展，拥有许多原生数组没有的一些功能。我们可以理解成ArrayList是Array的一个升级版。


### 7、阐述final、finally、finalize的区别。



**1、** final：修饰符（关键字）有三种用法：如果一个类被声明为final，意味着它不能再派生出新的子类，即不能被继承，因此它和abstract是反义词。将变量声明为final，可以保证它们在使用中不被改变，被声明为final的变量必须在声明时给定初值，而在以后的引用中只能读取不可修改。被声明为final的方法也同样只能使用，不能在子类中被重写。

**2、** finally：通常放在try…catch…的后面构造总是执行代码块，这就意味着程序无论正常执行还是发生异常，这里的代码只要JVM不关闭都能执行，可以将释放外部资源的代码写在finally块中。

**3、** finalize：Object类中定义的方法，Java中允许使用finalize()方法在垃圾收集器将对象从内存中清除出去之前做必要的清理工作。这个方法是由垃圾收集器在销毁对象时调用的，通过重写finalize()方法可以整理系统资源或者执行其他清理工作。


### 8、抽象类能使用 final 修饰吗？

不能，定义抽象类就是让其他类继承的，如果定义为 final 该类就不能被继承，这样彼此就会产生矛盾，所以 final 不能修饰抽象类，如下图所示，编辑器也会提示错误信息：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/2012/47/79_1.png#alt=79%5C_1.png)


### 9、什么是阻塞式方法？

阻塞式方法是指程序会一直等待该方法完成期间不做其他事情，ServerSocket的accept()方法就是一直等待客户端连接。这里的阻塞是指调用结果返回之前，当前线程会被挂起，直到得到结果之后才会返回。此外，还有异步和非阻塞式方法在任务完成前就返回。


### 10、线程的 run()和 start()有什么区别？

**1、** 每个线程都是通过某个特定Thread对象所对应的方法run()来完成其操作的，run()方法称为线程体。通过调用Thread类的start()方法来启动一个线程。

**2、** start() 方法用于启动线程，run() 方法用于执行线程的运行时代码。run() 可以重复调用，而 start() 只能调用一次。

**3、** start()方法来启动一个线程，真正实现了多线程运行。调用start()方法无需等待run方法体代码执行完毕，可以直接继续执行其他的代码； 此时线程是处于就绪状态，并没有运行。 然后通过此Thread类调用方法run()来完成其运行状态， run()方法运行结束， 此线程终止。然后CPU再调度其它线程。

**4、** run()方法是在本线程里的，只是线程里的一个函数，而不是多线程的。 如果直接调用run()，其实就相当于是调用了一个普通函数而已，直接待用run()方法必须等待run()方法执行完毕才能执行下面的代码，所以执行路径还是只有一条，根本就没有线程的特征，所以在多线程执行时要使用start()方法而不是run()方法。


### 11、静态嵌套类(Static Nested Class)和内部类（Inner Class）的不同？
### 12、怎么获取 Java 程序使用的内存？堆使用的百分比？
### 13、如何开启和查看 GC 日志？
### 14、各种回收算法
### 15、单例模式使用注意事项：
### 16、你所知道的web服务器有哪些？
### 17、什么是 Class 文件？ Class 文件主要的信息结构有哪些？
### 18、Java线程具有五中基本状态
### 19、打印昨天的当前时刻。
### 20、Java中Semaphore是什么？
### 21、构造方法有哪些特性？
### 22、说说类加载的过程
### 23、多线程中 synchronized 锁升级的原理是什么？
### 24、Serial Old 收集器（单线程标记整理算法 ）
### 25、什么是线程池？
### 26、存在两个类，B 继承 A，C 继承 B，我们能将 B 转换为 C 么？如 C = (C) B；
### 27、生产环境用的什么JDK？如何配置的垃圾收集器？
### 28、synchronized和ReentrantLock的区别
### 29、你知道哪些内存分配与回收策略？
### 30、抽象的关键字是什么？
### 31、HashMap为什么不直接使用hashCode()处理后的哈希值直接作为table的下标？
### 32、在调用子类构造方法之前会先调用父类没有参数的构造方法，其目的是？
### 33、说下有哪些类加载器？
### 34、你对 Time Slice的理解?
### 35、如果对象的引用被置为null，垃圾收集器是否会立即释放对象占用的内存？
### 36、可以直接调用Thread类的run ()方法么？
### 37、当打开其他程序的网页时，使用的target属性是哪个？
### 38、什么是Vector
### 39、什么时候会造成堆外内存溢出？
### 40、什么是ThreadLocal变量？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
