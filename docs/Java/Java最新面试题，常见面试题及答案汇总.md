# Java最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、讲讲什么情况下会出现内存溢出，内存泄漏？

内存泄漏的原因很简单：

**1、** 对象是可达的(一直被引用)

**2、** 但是对象不会被使用

常见的内存泄漏例子：

```
    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();

        for (int i = 0; i < 10; i++) {
            Object object = new Object();
            set.add(object);

            // 设置为空，该对象不再使用
            object = null;
        }

        // 但是set集合中还维护object的引用，gc不会回收object对象
        System.out.println(set);
        System.out.println(set.size());
    }
}
```

输出结果

```
[java.lang.Object@74a14482, 
java.lang.Object@677327b6, 
java.lang.Object@6d6f6e28, 
java.lang.Object@4554617c, 
java.lang.Object@45ee12a7, 
java.lang.Object@1b6d3586, 
java.lang.Object@7f31245a,
java.lang.Object@135fbaa4,
java.lang.Object@1540e19d, 
java.lang.Object@14ae5a5]
10

Process finished with exit code 0
```

解决这个内存泄漏问题也很简单，将set设置为null，那就可以避免上述内存泄漏问题了。其他内存泄漏得一步一步分析了。

**内存溢出的原因：**

**1、** 内存泄露导致堆栈内存不断增大，从而引发内存溢出。

**2、** 大量的jar，class文件加载，装载类的空间不够，溢出

**3、** 操作大量的对象导致堆内存空间已经用满了，溢出

**4、** nio直接操作内存，内存过大导致溢出

**解决：**

**1、** 查看程序是否存在内存泄漏的问题

**2、** 设置参数加大空间

**3、** 代码中是否存在死循环或循环产生过多重复的对象实体、

**4、** 查看是否使用了nio直接操作内存。


### 2、阐述Spring框架中Bean的生命周期？

**1、** Spring IoC容器找到关于Bean的定义并实例化该Bean。

**2、** pring IoC容器对Bean进行依赖注入。

**3、** 如果Bean实现了BeanNameAware接口，则将该Bean的id传给setBeanName方法。

**4、** 如果Bean实现了BeanFactoryAware接口，则将BeanFactory对象传给setBeanFactory方法。

**5、** 如果Bean实现了BeanPostProcessor接口，则调用其postProcessBeforeInitialization方法。

**6、** 如果Bean实现了InitializingBean接口，则调用其afterPropertySet方法。

**7、** 如果有和Bean关联的BeanPostProcessors对象，则这些对象的postProcessAfterInitialization方法被调用。

**8、** 当销毁Bean实例时，如果Bean实现了DisposableBean接口，则调用其destroy方法。


### 3、现实生活中的模板方法

**例如：**

去餐厅吃饭，餐厅给我们提供了一个模板就是：看菜单，点菜，吃饭，付款，走人 （这里 “**点菜和付款**” 是不确定的由子类来完成的，其他的则是一个模板。）

- 代码演示

**1、** 先定义一个模板。把模板中的点菜和付款，让子类来实现。

```
package com.lijie;

//模板方法
public abstract class RestaurantTemplate {

    // 1.看菜单
    public void menu() {
        System.out.println("看菜单");
    }

    // 2.点菜业务
    abstract void spotMenu();

    // 3.吃饭业务
    public void havingDinner(){ System.out.println("吃饭"); }

    // 3.付款业务
    abstract void payment();

    // 3.走人
    public void GoR() { System.out.println("走人"); }

    //模板通用结构
    public void process(){
        menu();
        spotMenu();
        havingDinner();
        payment();
        GoR();
    }
}
```

**2、** 具体的模板方法子类 1

```
package com.lijie;

public class RestaurantGinsengImpl extends RestaurantTemplate {

    void spotMenu() {
        System.out.println("人参");
    }

    void payment() {
        System.out.println("5快");
    }
}
```

**3、** 具体的模板方法子类 2

```
package com.lijie;

public class RestaurantLobsterImpl  extends RestaurantTemplate  {

    void spotMenu() {
        System.out.println("龙虾");
    }

    void payment() {
        System.out.println("50块");
    }
}
```

**4、** 客户端测试

```
package com.lijie;

public class Client {

    public static void main(String[] args) {
        //调用第一个模板实例
        RestaurantTemplate restaurantTemplate = new RestaurantGinsengImpl();
        restaurantTemplate.process();
    }
}
```


### 4、并发队列的常用方法

不管是那种列队，是那个类，当是他们使用的方法都是差不多的

| 方法名 | 描述 |
| --- | --- |
| add() | 在不超出队列长度的情况下插入元素，可以立即执行，成功返回true，如果队列满了就抛出异常。 |
| offer() | 在不超出队列长度的情况下插入元素的时候则可以立即在队列的尾部插入指定元素,成功时返回true，如果此队列已满，则返回false。 |
| put() | 插入元素的时候，如果队列满了就进行等待，直到队列可用。 |
| take() | 从队列中获取值，如果队列中没有值，线程会一直阻塞，直到队列中有值，并且该方法取得了该值。 |
| poll(long timeout, TimeUnit unit) | 在给定的时间里，从队列中获取值，如果没有取到会抛出异常。 |
| remainingCapacity() | 获取队列中剩余的空间。 |
| remove(Object o) | 从队列中移除指定的值。 |
| contains(Object o) | 判断队列中是否拥有该值。 |
| drainTo(Collection c) | 将队列中值，全部移除，并发设置到给定的集合中。 |



### 5、Anonymous Inner Class(匿名内部类)是否可以继承其它类？是否可以实现接口？



可以继承其他类或实现其他接口，在Swing编程和Android开发中常用此方式来实现事件监听和回调。


### 6、什么是数据结构？

计算机保存，组织数据的方式


### 7、Super与this表示什么？

**1、** Super表示当前类的父类对象

**2、** This表示当前类的对象


### 8、Java会存在内存泄漏吗？请简单描述。

内存泄漏是指不再被使用的对象或者变量一直被占据在内存中。理论上来说，Java是有GC垃圾回收机制的，也就是说，不再被使用的对象，会被GC自动回收掉，自动从内存中清除

但是，即使这样，Java也还是存在着内存泄漏的情况，java导致内存泄露的原因很明确：长生命周期的对象持有短生命周期对象的引用就很可能发生内存泄露，尽管短生命周期对象已经不再需要，但是因为长生命周期对象持有它的引用而导致不能被回收，这就是java中内存泄露的发生场景。


### 9、在Java中CycliBarriar和CountdownLatch有什么区别？

**1、** CyclicBarrier可以重复使用，而CountdownLatch不能重复使用。

**2、** Java的concurrent包里面的CountDownLatch其实可以把它看作一个计数器，只不过这个计数器的操作是原子操作，同时只能有一个线程去操作这个计数器，也就是同时只能有一个线程去减这个计数器里面的值。

**3、** 你可以向CountDownLatch对象设置一个初始的数字作为计数值，任何调用这个对象上的await()方法都会阻塞，直到这个计数器的计数值被其他的线程减为0为止。

**4、** 所以在当前计数到达零之前，await 方法会一直受阻塞。之后，会释放所有等待的线程，await的所有后续调用都将立即返回。这种现象只出现一次——计数无法被重置。如果需要重置计数，请考虑使用 CyclicBarrier。

**5、** CountDownLatch的一个非常典型的应用场景是：有一个任务想要往下执行，但必须要等到其他的任务执行完毕后才可以继续往下执行。假如我们这个想要继续往下执行的任务调用一个CountDownLatch对象的await()方法，其他的任务执行完自己的任务后调用同一个CountDownLatch对象上的countDown()方法，这个调用await()方法的任务将一直阻塞等待，直到这个CountDownLatch对象的计数值减到0为止。

CyclicBarrier一个同步辅助类，它允许一组线程互相等待，直到到达某个公共屏障点 (common barrier point)。在涉及一组固定大小的线程的程序中，这些线程必须不时地互相等待，此时 CyclicBarrier 很有用。因为该 barrier 在释放等待线程后可以重用，所以称它为循环 的 barrier。


### 10、ParNew 垃圾收集器（Serial+多线程）

ParNew 垃圾收集器其实是 Serial 收集器的多线程版本，也使用复制算法，除了使用多线程进行垃圾收集之外，其余的行为和 Serial 收集器完全一样， ParNew 垃圾收集器在垃圾收集过程中同样也要暂停所有其他的工作线程。

ParNew 收集器默认开启和 CPU 数目相同的线程数，可以通过-XX:ParallelGCThreads 参数来限制垃圾收集器的线程数。【Parallel：平行的】

ParNew 虽然是除了多线程外和Serial 收集器几乎完全一样，但是ParNew垃圾收集器是很多 java虚拟机运行在 Server 模式下新生代的默认垃圾收集器。


### 11、equals 和 == 的区别？#
### 12、例如： if(a+1.0=4.0)，这样做好吗？
### 13、怎么看死锁的线程？
### 14、String s = new String(“xyz”);创建了几个字符串对象？
### 15、可以描述一下 class 文件的结构吗？
### 16、有什么堆外内存的排查思路？
### 17、在没有使用临时变量的情况如何交换两个整数变量的值？
### 18、永久代
### 19、Statement和PreparedStatement有什么区别？哪个性能更好？
### 20、是否可以从一个静态（static）方法内部发出对非静态（non-static）方法的调用？
### 21、存储过程与函数的区别
### 22、JVM新生代中为什么要分为Eden和Survivor？
### 23、请解释如何配置Tomcat来使用IIS和NTLM ?
### 24、JAVA8 与元数据
### 25、CMS 收集器（多线程标记清除算法）
### 26、线程B怎么知道线程A修改了变量
### 27、Java对象的布局了解过吗？
### 28、页面前进或者后退
### 29、如何通过反射创建对象？
### 30、什么是设计模式
### 31、SynchronizedMap 和 ConcurrentHashMap 有什么区别？
### 32、线程类的构造方法、静态块是被哪个线程调用的
### 33、守护线程和用户线程有什么区别呢？
### 34、类加载是什么？
### 35、多线程应用场景
### 36、在做文件上传的时候，form表单的enctype的指是什么？
### 37、Iterator 和 ListIterator 有什么区别？
### 38、解释servlet如何完成生命周期?
### 39、finalize()方法什么时候被调用？析构函数(finalization)的目的是什么？
### 40、你知道哪些JVM性能调优




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
