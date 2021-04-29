# Java最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、你熟悉哪些垃圾收集算法？

标记清除（缺点是碎片化） 复制算法（缺点是浪费空间） 标记整理算法（效率比前两者差） 分代收集算法（老年代一般使用“标记-清除”、“标记-整理”算法，年轻代一般用复制算法）


### 2、创建线程的三种方式的对比？

**1、** 采用实现Runnable、Callable接口的方式创建多线程。

**优势是：**

线程类只是实现了Runnable接口或Callable接口，还可以继承其他类。

在这种方式下，多个线程可以共享同一个target对象，所以非常适合多个相同线程来处理同一份资源的情况，从而可以将CPU、代码和数据分开，形成清晰的模型，较好地体现了面向对象的思想。

**劣势是：**

编程稍微复杂，如果要访问当前线程，则必须使用Thread.currentThread()方法。

**2、** 使用继承Thread类的方式创建多线程

**优势是：**

编写简单，如果需要访问当前线程，则无需使用Thread.currentThread()方法，直接使用this即可获得当前线程。

**劣势是：**

线程类已经继承了Thread类，所以不能再继承其他父类。

**3、** Runnable和Callable的区别

**1、** Callable规定（重写）的方法是call()，Runnable规定（重写）的方法是run()。

**2、** Callable的任务执行后可返回值，而Runnable的任务是不能返回值的。

**3、** Call方法可以抛出异常，run方法不可以。

**4、** 运行Callable任务可以拿到一个Future对象，表示异步计算的结果。它提供了检查计算是否完成的方法，以等待计算的完成，并检索计算的结果。通过Future对象可以了解任务执行情况，可取消任务的执行，还可获取执行结果。


### 3、Tcp协议的特点

**1、** TCP 是面向连接的传输层协议

**2、** 每一条 TCP 连接只能有两个端点(endpoint),每一条 TCP 连接只能是点对点的（一对一）

**3、** TCP 提供可靠交付的服务

**4、** TCP 提供全双工通信

**5、** 面向字节流

**1、** TCP 是面向连接的传输层协议

**2、** 每一条 TCP 连接只能有两个端点(endpoint),每一条 TCP 连接只能是点对点的（一对一）

**3、** TCP 提供可靠交付的服务

**4、** TCP 提供全双工通信

**5、** 面向字节流


### 4、说几个常见的编译时异常类？

**1、** NullPointerException：空指针异常

**2、** ArrayIndexOutOfBoundsException：数组下标越界

**3、** NumberFormatException：数字转换异常

**4、** IllegalArgumentException：参数不匹配异常

**5、** InstantiationException：对象初始化异常

**6、** ArithmeticException：算术异常


### 5、Spring中Bean的作用域有哪些？

**1、** Singleton：Bean以单例的方式存在

**2、** Prototype：表示每次从容器中调用Bean时，都会返回一个新的实例，prototype通常翻译为原型

**3、** Request：每次HTTP请求都会创建一个新的Bean

**4、** Session：同一个HttpSession共享同一个Bean，不同的HttpSession使用不同的Bean

**5、** globalSession：同一个全局Session共享一个Bean


### 6、Java中有几种类型的流？



字节流和字符流。字节流继承于InputStream、OutputStream，字符流继承于Reader、Writer。在java.io 包中还有许多其他的流，主要是为了提高性能和使用方便。关于Java的I/O需要注意的有两点：一是两种对称性（输入和输出的对称性，字节和字符的对称性）；二是两种设计模式（适配器模式和装潢模式）。另外Java中的流不同于C#的是它只有一个维度一个方向。

> 面试题 - 编程实现文件拷贝。（这个题目在笔试的时候经常出现，下面的代码给出了两种实现方案）


```
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public final class MyUtil {

    private MyUtil() {
        throw new AssertionError();
    }

    public static void fileCopy(String source, String target) throws IOException {
        try (InputStream in = new FileInputStream(source)) {
            try (OutputStream out = new FileOutputStream(target)) {
                byte[] buffer = new byte[4096];
                int bytesToRead;
                while((bytesToRead = in.read(buffer)) != -1) {
                    out.write(buffer, 0, bytesToRead);
                }
            }
        }
    }

    public static void fileCopyNIO(String source, String target) throws IOException {
        try (FileInputStream in = new FileInputStream(source)) {
            try (FileOutputStream out = new FileOutputStream(target)) {
                FileChannel inChannel = in.getChannel();
                FileChannel outChannel = out.getChannel();
                ByteBuffer buffer = ByteBuffer.allocate(4096);
                while(inChannel.read(buffer) != -1) {
                    buffer.flip();
                    outChannel.write(buffer);
                    buffer.clear();
                }
            }
        }
    }
}
```

> 注意：上面用到Java 7的TWR，使用TWR后可以不用在finally中释放外部资源 ，从而让代码更加优雅。



### 7、线程与进程的区别

进程是系统进行资源分配和调度的一个独立单位，线程是CPU调度和分派的基本单位

进程和线程的关系：

**1、** 一个线程只能属于一个进程，而一个进程可以有多个线程，但至少有一个线程。

**2、** 资源分配给进程，同一进程的所有线程共享该进程的所有资源。

**3、** 线程在执行过程中，需要协作同步。不同进程的线程间要利用消息通信的办法实现同步。

**4、** 线程是指进程内的一个执行单元，也是进程内的可调度实体。

线程与进程的区别：

**1、** 调度：线程作为调度和分配的基本单位，进程作为拥有资源的基本单位。

**2、** 并发性：不仅进程之间可以并发执行，同一个进程的多个线程之间也可以并发执行。

**3、** 拥有资源：进程是拥有资源的一个独立单位，线程不拥有系统资源，但可以访问隶属于进程的资源。

**4、** 系统开销：在创建或撤销进程的时候，由于系统都要为之分配和回收资源，导致系统的明显大于创建或撤销线程时的开销。但进程有独立的地址空间，进程崩溃后，在保护模式下不会对其他的进程产生影响，而线程只是一个进程中的不同的执行路径。线程有自己的堆栈和局部变量，但线程之间没有单独的地址空间，一个线程死掉就等于整个进程死掉，所以多进程的程序要比多线程的程序健壮，但是在进程切换时，耗费的资源较大，效率要差些。


### 8、在没有使用临时变量的情况如何交换两个整数变量的值？

解决方案

[https://blog.csdn.net/zidane_2014/article/details/34180223](https://blog.csdn.net/zidane_2014/article/details/34180223)


### 9、程序计数器(线程私有)

一块较小的内存空间, 是当前线程所执行的字节码的行号指示器，每条线程都要有一个独立的程序计数器，这类内存也称为“线程私有” 的内存。

正在执行 java 方法的话，计数器记录的是虚拟机字节码指令的地址（当前指令的地址） 。如果还是 Native 方法，则为空。

这个内存区域是唯一一个在虚拟机中没有规定任何 OutOfMemoryError 情况的区域。


### 10、为什么HashTable是线程安全的？

因为HasTable的内部方法都被synchronized修饰了，所以是线程安全的。其他的都和HashMap一样

**1、** HashMap添加方法的源码 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_12.png#alt=87%5C_12.png)

**2、** HashTable添加方法的源码 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_13.png#alt=87%5C_13.png)


### 11、模式的职责
### 12、[@Before ](/Before ) 和 [@BeforeClass ](/BeforeClass ) 有什么区别？
### 13、float f=3.4;是否正确？
### 14、乐观锁和悲观锁的理解及如何实现，有哪些实现方式？
### 15、String s = new String(“xyz”);创建了几个字符串对象？
### 16、用Java写一个冒泡排序。
### 17、用Java写一个单例类。
### 18、方法区
### 19、什么是多线程的上下文切换
### 20、为什么 Java 中的 String 是不可变的（Immutable）？
### 21、描述一下JVM加载class文件的原理机制？
### 22、类与对象的关系?
### 23、对象是怎么从年轻代进入老年代的？
### 24、CMS分为哪几个阶段?
### 25、什么是策略模式
### 26、老年代与标记复制算法
### 27、写一段代码在遍历 ArrayList 时移除一个元素？
### 28、如何在 Windows 和 Linux 上查找哪个线程cpu利用率最高？
### 29、什么是Web Service（Web服务）
### 30、线程类的构造方法、静态块是被哪个线程调用的
### 31、Collection接口下有那些集合框架？
### 32、类加载器双亲委派模型机制？
### 33、volatile关键字的原理是什么？干什么用的？
### 34、获得一个类的类对象有哪些方式？
### 35、Math.round(11.5) 等于多少？Math.round(-11.5)等于多少？
### 36、Java 中 WeakReference 与 SoftReference的区别？
### 37、Session加载实体对象的过程。
### 38、类、方法、成员变量和局部变量的可用修饰符 -
### 39、面向对象的语言有那些特征？
### 40、你都用过G1垃圾回收器的哪几个重要参数？
### 41、Java 中如何将字符串转换为整数？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
