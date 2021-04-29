# Java面试题目大汇总，附参考答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、栈帧里面包含哪些东西？

局部变量表、操作数栈、动态连接、返回地址等


### 2、43.将下java中的math类有那些常用方法？

**1、** Pow()：幂运算

**2、** Sqrt()：平方根

**3、** Round()：四舍五入

**4、** Abs()：求绝对值

**5、** Random()：生成一个0-1的随机数，包括0不包括1


### 3、MinorGC、MajorGC、FullGC 什么时候发生？

**1、** MinorGC 在年轻代空间不足的时候发生

**2、** MajorGC 指的是老年代的 GC，出现 MajorGC 一般经常伴有 MinorGC

**3、** FullGC 老年代无法再分配内存；元空间不足；显示调用 System.gc；像 CMS 一类的垃圾回收器，在 MinorGC 出现 promotion failure 时也会发生 FullGC


### 4、在新生代-复制算法

每次垃圾收集都能发现大批对象已死, 只有少量存活、因此选用复制算法, 只需要付出少量存活对象的复制成本就可以完成收集


### 5、Java 中的 HashSet，内部是如何工作的？

HashSet 的内部采用 HashMap来实现。由于 Map 需要 key 和 value，所以所有 key 的都有一个默认 value。类似于 HashMap，HashSet 不允许重复的 key，只允许有一个null key，意思就是 HashSet 中只允许存储一个 null 对象。


### 6、如何写一段简单的死锁代码？

这个笔试的话频率也挺高（遇见笔试的公司要三思啊），所以这里直接给出一个答案（有很多版本的）。

```
public class DeadLockDemo {
    public static void main(String[] args) {
        Object object1 = new Object();
        Object object2 = new Object();
        Thread t1 = new Thread(() -> {
            synchronized (object1) {
                try {
                    Thread.sleep(200);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (object2) {
                }
            }
        }, "deadlock-demo-1");

        t1.start();
        Thread t2 = new Thread(() -> {
            synchronized (object2) {
                synchronized (object1) {
                }
            }
        }, "deadlock-demo-2");
        t2.start();
    }
}
```


### 7、谈谈对 OOM 的认识

除了程序计数器，其他内存区域都有 OOM 的风险。

**1、** 栈一般经常会发生 StackOverflowError，比如 32 位的 windows 系统单进程限制 2G 内存，无限创建线程就会发生栈的 OOM

**2、** Java 8 常量池移到堆中，溢出会出 java.lang.OutOfMemoryError: Java heap space，设置最大元空间大小参数无效

**3、** 堆内存溢出，报错同上，这种比较好理解，GC 之后无法在堆中申请内存创建对象就会报错

**4、** 方法区 OOM，经常会遇到的是动态生成大量的类、jsp 等

**5、** 直接内存 OOM，涉及到 -XX:MaxDirectMemorySize 参数和 Unsafe 对象对内存的申请


### 8、CopyOnWriteArrayList 是什么?
### 9、你在项目中哪些地方用到了XML？
### 10、Jsp指令有那些？
### 11、工作中常用的 JVM 配置参数有哪些？
### 12、Java语言如何进行异常处理，关键字：throws、throw、try、catch、finally分别如何使用？
### 13、在Java中定义一个不做事且没有参数的构造方法的作用
### 14、说一下HashMap的实现原理？
### 15、什么是线程异步？什么是线程同步？
### 16、写一个方法，输入一个文件名和一个字符串，统计这个字符串在这个文件中出现的次数。
### 17、怎么查看服务器默认的垃圾回收器是哪一个？
### 18、设计模式的六大原则
### 19、Java语言有哪些特点？
### 20、解释何时在Tomcat使用SSL ?
### 21、多线程中 synchronized 锁升级的原理是什么？
### 22、Java 的引用有哪些类型？
### 23、你如何在Java中获取线程堆栈？
### 24、重定向和请求转发的区别？
### 25、什么是UML？
### 26、如何使用exception对象？
### 27、说出 5 条 IO 的最佳实践(答案)
### 28、你知道哪些GC类型？
### 29、ZGC收集器中的染色指针有什么用？
### 30、Spring中如何使用注解来配置Bean？有哪些相关的注解？
### 31、如何判断一个对象是否存活
### 32、遇到过元空间溢出吗？
### 33、Java 中，怎么获取一个文件中单词出现的最高频率？
### 34、Final在java中的作用
### 35、什么是happen-before原则？
### 36、垃圾收集算法
### 37、类加载的过程是什么？
### 38、Java 中，怎么在格式化的日期中显示时区？
### 39、Js如何跳转到到一个指定页面
### 40、并发队列和并发集合的区别：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
