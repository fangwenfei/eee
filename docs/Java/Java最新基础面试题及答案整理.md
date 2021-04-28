# Java最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、[@Before ](/Before ) 和 [@BeforeClass ](/BeforeClass ) 有什么区别？

[http://javarevisited.blogspot.sg/2013/04/JUnit-tutorial-example-test-exception-thrown-by-java-method.html](http://javarevisited.blogspot.sg/2013/04/JUnit-tutorial-example-test-exception-thrown-by-java-method.html)


### 2、方法区

又称非堆区,用于存储已被虚拟机加载的类信息,常量,静态变量,即时编译器优化后的代码等数据.1.7的永久代和1.8的元空间都是方法区的一种实现。


### 3、如何使用exception对象？

用于处理JSP文件执行时发生的所有错误和异常，只有在page指令中设置isErrorPage值为true的页面中才可以被使用，在一般的JSP页面中使用该对象，将无法编译JSP文件。


### 4、什么是接口？

接口就是某个事物对外提供的一些功能的声明，是一种特殊的java类


### 5、Java 中怎样将 bytes 转换为 long 类型？

这个问题你来回答 :-)


### 6、JVM垃圾回收时候如何确定垃圾？什么是GC Roots？

JVM采用的是可达性分析算法。JVM是通过GC Roots来判定对象的存活的。从`GC Roots`向下追溯、搜索，会产生一个叫做`Reference Chain`的链条。当一个对象不能和任何一个GC Root产生关系，就判定为垃圾。

**GC Roots大体包括：**

**1、** 活动线程相关的各种引用，比如虚拟机栈中栈帧里的引用。

**2、** 类的静态变量的引用。

**3、** JNI引用等。

**当然也有比较详细的回答，个人认为这些就够了。详细版本如下：**

**1、** Java线程中，当前所有正在被调用的方法的 `引用类型`参数、局部变量、临时值等。也就是与我们 `栈帧`相关的各种引用。

**2、** 所有当前被加载的Java类。

**3、** Java类的引用类型静态变量。

**4、** 运行时常量池里的引用类型常量（String或Class类型）。

**5、** JVM内部数据结构的一些引用，比如 `sun.jvm.hotspot.memory.Universe`类。

**6、** 用于同步的监控对象，比如调用了对象的 `wait()`方法。

**7、** JNI handles，包括global handles和local handles


### 7、java中有没有指针？

有指针，但是隐藏了，开发人员无法直接操作指针，由jvm来操作指针


### 8、说一下 runnable 和 callable 有什么区别

**相同点：**

**1、** 都是接口

**2、** 都可以编写多线程程序

**3、** 都采用Thread.start()启动线程

**主要区别：**

Runnable 接口 run 方法无返回值；Callable 接口 call 方法有返回值，是个泛型，和Future、FutureTask配合可以用来获取异步执行的结果

Runnable 接口 run 方法只能抛出运行时异常，且无法捕获处理；Callable 接口 call 方法允许抛出异常，可以获取异常信息 注：Callalbe接口支持返回执行结果，需要调用FutureTask.get()得到，此方法会阻塞主进程的继续往下执行，如果不调用不会阻塞。


### 9、解释一下什么叫AOP（面向切面编程）？

AOP（Aspect-Oriented Programming）指一种程序设计范型，该范型以一种称为切面（aspect）的语言构造为基础，切面是一种新的模块化机制，用来描述分散在对象、类或方法中的横切关注点（crosscutting concern）。


### 10、请解释一下什么时候可以使用“.”，什么时候可以使用“[]”?

如果正在运行bean属性，请使用“.”操作符，如果正在执行映射值或数组索引，则首选使用“[]”运算符。虽然两个运算符可以互换。


### 11、实际开发中应用场景哪里用到了模板方法
### 12、JAVA虚引用
### 13、Java 中你怎样唤醒一个阻塞的线程？
### 14、插入数据时 ArrayList、LinkedList、Vector谁速度较快？
### 15、单例模式使用注意事项：
### 16、Java中操作字符串使用哪个类？
### 17、解释何时在Tomcat使用SSL ?
### 18、什么是Executors框架？
### 19、JVM垃圾回收机制，何时触发MinorGC等操作
### 20、JRE、JDK、JVM 及 JIT 之间有什么不同？
### 21、OSGI（ 动态模型系统）
### 22、为什么我们调用start()方法时会执行run()方法，为什么我们不能直接调用run()方法？
### 23、JSP中的静态包含和动态包含有什么区别？
### 24、JAVA8 与元数据
### 25、用 Java 写一个线程安全的单例模式（Singleton）？
### 26、解释servlet如何完成生命周期?
### 27、请说出与线程同步以及线程调度相关的方法。
### 28、ConcurrentHashMap的并发度是什么
### 29、你知道哪些故障处理工具？
### 30、当一个线程进入一个对象的 synchronized 方法 A 之后，其它线程是否可进入此对象的 synchronized 方法 B？
### 31、什么是隐式转换，什么是显式转换
### 32、策略模式的优点和缺点
### 33、Java语言采用何种编码方案？有何特点？
### 34、java 中的 Math.round(-1.5) 等于多少？
### 35、Linux环境下如何查找哪个线程使用CPU最长
### 36、java 中操作字符串都有哪些类？它们之间有什么区别？
### 37、分代回收
### 38、对象分配内存是否线程安全？
### 39、重定向和请求转发的区别？
### 40、你能保证 GC 执行吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
