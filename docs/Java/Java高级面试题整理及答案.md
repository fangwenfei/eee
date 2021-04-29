# Java高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、HashMap中的key，可以是普通对象么？需要什么注意的地方？

Map的key和value都可以是任何类型。但要注意的是，一定要重写它的equals和hashCode方法，否则容易发生内存泄漏。


### 2、模式的职责

观察者模式主要用于1对N的通知。当一个对象的状态变化时，他需要及时告知一系列对象，令他们做出相应。

**实现有两种方式：**

**1、推：**

每次都会把通知以广播的方式发送给所有观察者，所有的观察者只能被动接收。

**2、拉：**

观察者只要知道有情况即可，至于什么时候获取内容，获取什么内容，都可以自主决定。


### 3、如何将字符串反转？

Stringbuilder或者stringbuffer的reverse方法


### 4、构造方法能不能重载？能不能重写？

可以重载，必须重写


### 5、为什么HashTable是线程安全的？

因为HasTable的内部方法都被synchronized修饰了，所以是线程安全的。其他的都和HashMap一样

**1、** HashMap添加方法的源码 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_12.png#alt=87%5C_12.png)

**2、** HashTable添加方法的源码 ![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_13.png#alt=87%5C_13.png)


### 6、GC 是什么? 为什么要有 GC

GC 是垃圾收集的意思（GabageCollection），内存处理是编程人员容易出现问题的地方，忘记或者错误的内存回收会导致程序或系统的不稳定甚至崩溃，Java 提供的 GC 功能可以自动监测对象是否超过作用域从而达到自动回收内存的目的，Java 语言没有提供释放已分配内存的显示操作方法。


### 7、notify() 和 notifyAll() 有什么区别？

**1、** 如果线程调用了对象的 wait()方法，那么线程便会处于该对象的等待池中，等待池中的线程不会去竞争该对象的锁。

**2、** notifyAll() 会唤醒所有的线程，notify() 只会唤醒一个线程。

**3、** notifyAll() 调用后，会将全部线程由等待池移到锁池，然后参与锁的竞争，竞争成功则继续执行，如果不成功则留在锁池等待锁被释放后再次参与竞争。而 notify()只会唤醒一个线程，具体唤醒哪一个线程由虚拟机控制。


### 8、请阐述Catalina的配置文件有哪些?
### 9、简述Java的对象结构
### 10、java 中的 Math.round(-1.5) 等于多少？
### 11、如何自定义线程线程池?
### 12、抽象的关键字是什么？
### 13、被引用的对象就一定能存活吗？
### 14、Java中如何实现序列化，有什么意义？
### 15、SynchronizedMap 和 ConcurrentHashMap 有什么区别？
### 16、JVM垃圾回收时候如何确定垃圾？什么是GC Roots？
### 17、什么是线程池？
### 18、什么是自旋
### 19、线程的基本状态以及状态之间的关系？
### 20、url是什么？由哪些部分组成？
### 21、Java最顶级的父类是哪个？
### 22、生产上如何配置垃圾收集器的？
### 23、类与对象的关系?
### 24、Minor Gc和Full GC 有什么不同呢？
### 25、我们能自己写一个容器类，然后使用 for-each 循环码？
### 26、说说 JVM 如何执行 class 中的字节码。
### 27、Hibernate中SessionFactory是线程安全的吗？Session是线程安全的吗（两个线程能够共享同一个Session吗）？
### 28、集合的特点
### 29、Get请求与post有什么区别？
### 30、用Java写一个折半查找。
### 31、页面前进或者后退
### 32、简述一下你了解的设计模式。
### 33、类、方法、成员变量和局部变量的可用修饰符 -
### 34、Java 8 为什么要将永久代(PermGen)替换为元空间(MetaSpace)呢？
### 35、List接口有什么特点？
### 36、Java中集合框架的有几个？
### 37、为什么 ArrayList 的 elementData 加上 transient 修饰？
### 38、Java线程数过多会造成什么异常？
### 39、如何通过反射创建对象？
### 40、能够找到 Reference Chain 的对象，就一定会存活么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
