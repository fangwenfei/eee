# Java高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、常用并发列队的介绍：

- 非堵塞队列：

**ArrayDeque, （数组双端队列）**

ArrayDeque （非堵塞队列）是JDK容器中的一个双端队列实现，内部使用数组进行元素存储，不允许存储null值，可以高效的进行元素查找和尾部插入取出，是用作队列、双端队列、栈的绝佳选择，性能比LinkedList还要好。

**PriorityQueue, （优先级队列）**

PriorityQueue （非堵塞队列） 一个基于优先级的无界优先级队列。优先级队列的元素按照其自然顺序进行排序，或者根据构造队列时提供的 Comparator 进行排序，具体取决于所使用的构造方法。该队列不允许使用 null 元素也不允许插入不可比较的对象

**ConcurrentLinkedQueue, （基于链表的并发队列）**

ConcurrentLinkedQueue （非堵塞队列）: 是一个适用于高并发场景下的队列，通过无锁的方式，实现了高并发状态下的高性能。ConcurrentLinkedQueue的性能要好于BlockingQueue接口，它是一个基于链接节点的无界线程安全队列。该队列的元素遵循先进先出的原则。该队列不允许null元素。

- 堵塞队列：

**DelayQueue, （基于时间优先级的队列，延期阻塞队列）**

DelayQueue是一个没有边界BlockingQueue实现，加入其中的元素必需实现Delayed接口。当生产者线程调用put之类的方法加入元素时，会触发Delayed接口中的compareTo方法进行排序，也就是说队列中元素的顺序是按到期时间排序的，而非它们进入队列的顺序。排在队列头部的元素是最早到期的，越往后到期时间赿晚。

**ArrayBlockingQueue, （基于数组的并发阻塞队列）**

ArrayBlockingQueue是一个有边界的阻塞队列，它的内部实现是一个数组。有边界的意思是它的容量是有限的，我们必须在其初始化的时候指定它的容量大小，容量大小一旦指定就不可改变。ArrayBlockingQueue是以先进先出的方式存储数据

**LinkedBlockingQueue, （基于链表的FIFO阻塞队列）**

LinkedBlockingQueue阻塞队列大小的配置是可选的，如果我们初始化时指定一个大小，它就是有边界的，如果不指定，它就是无边界的。说是无边界，其实是采用了默认大小为Integer.MAX_VALUE的容量 。它的内部实现是一个链表。

**LinkedBlockingDeque, （基于链表的FIFO双端阻塞队列）**

LinkedBlockingDeque是一个由链表结构组成的双向阻塞队列，即可以从队列的两端插入和移除元素。双向队列因为多了一个操作队列的入口，在多线程同时入队时，也就减少了一半的竞争。

相比于其他阻塞队列，LinkedBlockingDeque多了addFirst、addLast、peekFirst、peekLast等方法，以first结尾的方法，表示插入、获取获移除双端队列的第一个元素。以last结尾的方法，表示插入、获取获移除双端队列的最后一个元素。

LinkedBlockingDeque是可选容量的，在初始化时可以设置容量防止其过度膨胀，如果不设置，默认容量大小为Integer.MAX_VALUE。

**PriorityBlockingQueue, （带优先级的无界阻塞队列）**

priorityBlockingQueue是一个无界队列，它没有限制，在内存允许的情况下可以无限添加元素；它又是具有优先级的队列，是通过构造函数传入的对象来判断，传入的对象必须实现comparable接口。

**SynchronousQueue （并发同步阻塞队列）**

SynchronousQueue是一个内部只能包含一个元素的队列。插入元素到队列的线程被阻塞，直到另一个线程从队列中获取了队列中存储的元素。同样，如果线程尝试获取元素并且当前不存在任何元素，则该线程将被阻塞，直到线程将元素插入队列。

将这个类称为队列有点夸大其词。这更像是一个点。


### 2、sleep() 和 wait() 有什么区别？

两者都可以暂停线程的执行

**1、** 类的不同：

sleep() 是 Thread线程类的静态方法，wait() 是 Object类的方法。

**2、** 是否释放锁：

sleep() 不释放锁；wait() 释放锁。

**3、** 用途不同：

Wait 通常被用于线程间交互/通信，sleep 通常被用于暂停执行。

**4、** 用法不同：

wait() 方法被调用后，线程不会自动苏醒，需要别的线程调用同一个对象上的 notify() 或者 notifyAll() 方法。sleep() 方法执行完成后，线程会自动苏醒。或者可以使用wait(long timeout)超时后线程会自动苏醒。


### 3、TreeMap和TreeSet在排序时如何比较元素？Collections工具类中的sort()方法如何比较元素？



TreeSet要求存放的对象所属的类必须实现Comparable接口，该接口提供了比较元素的compareTo()方法，当插入元素时会回调该方法比较元素的大小。TreeMap要求存放的键值对映射的键必须实现Comparable接口从而根据键对元素进行排序。Collections工具类的sort方法有两种重载的形式，第一种要求传入的待排序容器中存放的对象比较实现Comparable接口以实现元素的比较；第二种不强制性的要求容器中的元素必须可比较，但是要求传入第二个参数，参数是Comparator接口的子类型（需要重写compare方法实现元素的比较），相当于一个临时定义的排序规则，其实就是通过接口注入比较元素大小的算法，也是对回调模式的应用（Java中对函数式编程的支持）。

例子1：

```

public class Student implements Comparable<Student> {
    private String name;        // 姓名
    private int age;            // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

    @Override
    public int compareTo(Student o) {
        return this.age - o.age; // 比较年龄(年龄的升序)
    }

}
```

```
import java.util.Set;
import java.util.TreeSet;

class Test01 {

    public static void main(String[] args) {
        Set<Student> set = new TreeSet<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        set.add(new Student("Hao LUO", 33));
        set.add(new Student("XJ WANG", 32));
        set.add(new Student("Bruce LEE", 60));
        set.add(new Student("Bob YANG", 22));

        for(Student stu : set) {
            System.out.println(stu);
        }
//      输出结果: 
//      Student [name=Bob YANG, age=22]
//      Student [name=XJ WANG, age=32]
//      Student [name=Hao LUO, age=33]
//      Student [name=Bruce LEE, age=60]
    }
}
```

例子2：

```
public class Student {
    private String name;    // 姓名
    private int age;        // 年龄

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /
     * 获取学生姓名
     */
    public String getName() {
        return name;
    }

    /
     * 获取学生年龄
     */
    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student [name=" + name + ", age=" + age + "]";
    }

}
```

```
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Test02 {

    public static void main(String[] args) {
        List<Student> list = new ArrayList<>();     // Java 7的钻石语法(构造器后面的尖括号中不需要写类型)
        list.add(new Student("Hao LUO", 33));
        list.add(new Student("XJ WANG", 32));
        list.add(new Student("Bruce LEE", 60));
        list.add(new Student("Bob YANG", 22));

        // 通过sort方法的第二个参数传入一个Comparator接口对象
        // 相当于是传入一个比较对象大小的算法到sort方法中
        // 由于Java中没有函数指针、仿函数、委托这样的概念
        // 因此要将一个算法传入一个方法中唯一的选择就是通过接口回调
        Collections.sort(list, new Comparator<Student> () {

            @Override
            public int compare(Student o1, Student o2) {
                return o1.getName().compareTo(o2.getName());    // 比较学生姓名
            }
        });

        for(Student stu : list) {
            System.out.println(stu);
        }
//      输出结果: 
//      Student [name=Bob YANG, age=22]
//      Student [name=Bruce LEE, age=60]
//      Student [name=Hao LUO, age=33]
//      Student [name=XJ WANG, age=32]
    }
}
```


### 4、为什么我们调用 start() 方法时会执行 run() 方法，为什么我们不能直接调用 run() 方法？

这是另一个非常经典的 java 多线程面试问题，而且在面试中会经常被问到。很简单，但是很多人都会答不上来！

new 一个 Thread，线程进入了新建状态。调用 start() 方法，会启动一个线程并使线程进入了就绪状态，当分配到`时间片`后就可以开始运行了。 start() 会执行线程的相应准备工作，然后自动执行 run() 方法的内容，这是真正的多线程工作。

而直接执行 run() 方法，会把 run 方法当成一个 main 线程下的普通方法去执行，并不会在某个线程中执行它，所以这并不是多线程工作。

**总结：**

调用 start 方法方可启动线程并使线程进入就绪状态，而 run 方法只是 thread 的一个普通方法调用，还是在主线程里执行。


### 5、能否使用任何类作为 Map 的 key？

可以使用任何类作为 Map 的 key，然而在使用之前，需要考虑以下几点：

**1、** 如果类重写了 equals() 方法，也应该重写 hashCode() 方法。

**2、** 类的所有实例需要遵循与 equals() 和 hashCode() 相关的规则。

**3、** 如果一个类没有使用 equals()，不应该在 hashCode() 中使用它。

**4、** 用户自定义 Key 类最佳实践是使之为不可变的，这样 hashCode() 值可以被缓存起来，拥有更好的性能。不可变的类也可以确保 hashCode() 和 equals() 在未来不会改变，这样就会解决与可变相关的问题了。


### 6、字符串常量存放在哪个区域？

**1、** 字符串常量池，已经移动到堆上（jdk8之前是perm区），也就是执行intern方法后存的地方。

**2、** 类文件常量池，constant_pool，是每个类每个接口所拥有的，这部分数据在方法区，也就是元数据区。而运行时常量池是在类加载后的一个内存区域，它们都在元空间。


### 7、CMS都有哪些问题？

**1、** 内存碎片问题。Full GC的整理阶段，会造成较长时间的停顿。

**2、** 需要预留空间，用来分配收集阶段产生的“浮动垃圾“。

**3、** 使用更多的CPU资源，在应用运行的同时进行堆扫描。

**4、** 停顿时间是不可预期的。

正因为有这些问题，所以大家才用更加完备的G1。况且，现在都是大内存时代了，G1玩得转，就没必要用CMS。


### 8、Java 中用到的线程调度算法是什么？

计算机通常只有一个 CPU，在任意时刻只能执行一条机器指令，每个线程只有获得CPU 的使用权才能执行指令。所谓多线程的并发运行，其实是指从宏观上看，各个线程轮流获得 CPU 的使用权，分别执行各自的任务。在运行池中，会有多个处于就绪状态的线程在等待 CPU，JAVA 虚拟机的一项任务就是负责线程的调度，线程调度是指按照特定机制为多个线程分配 CPU 的使用权。（Java是由JVM中的线程计数器来实现线程调度）

**有两种调度模型：**

分时调度模型和抢占式调度模型。

**1、** 分时调度模型是指让所有的线程轮流获得 cpu 的使用权，并且平均分配每个线程占用的 CPU 的时间片这个也比较好理解。

**2、** Java虚拟机采用抢占式调度模型，是指优先让可运行池中优先级高的线程占用CPU，如果可运行池中的线程优先级相同，那么就随机选择一个线程，使其占用CPU。处于运行状态的线程会一直运行，直至它不得不放弃 CPU。


### 9、用 wait-notify 写一段代码来解决生产者-消费者问题？

答案

[http://java67.blogspot.sg/2012/12/producer-consumer-problem-with-wait-and-notify-example.html](http://java67.blogspot.sg/2012/12/producer-consumer-problem-with-wait-and-notify-example.html)

请参考答案中的示例代码。只要记住在同步块中调用 wait() 和 notify()方法，如果阻塞，通过循环来测试等待条件。


### 10、线程的状态流转图

线程的生命周期及五种基本状态：


### 11、静态方法和实例方法有何不同？
### 12、模式的职责
### 13、Java中如何实现多线程
### 14、Java 中，Serializable 与 Externalizable 的区别？
### 15、有什么堆外内存的排查思路？
### 16、并发编程三要素？
### 17、四种构建线程池的区别及特点？
### 18、解释 Java 堆空间及 GC？
### 19、解释什么是Tomcat Valve?
### 20、说一下 JVM 调优的工具？
### 21、JVM 中一次完整的 GC 流程（从 ygc 到 fgc）是怎样的
### 22、在使用jdbc的时候，如何防止出现sql注入的问题。
### 23、Java中用到的线程调度算法是什么？
### 24、“a==b”和”a.equals(b)”有什么区别？
### 25、Java 中，怎么打印出一个字符串的所有排列？
### 26、Parallel Scavenge 收集器（多线程复制算法、高效）
### 27、volatile 能使得一个非原子操作变成原子操作吗？
### 28、如果你提交任务时，线程池队列已满，这时会发生什么
### 29、怎么确保一个集合不能被修改？
### 30、说一下 Atomic的原理？
### 31、Char类型能不能转成int类型？能不能转化成string类型，能不能转成double类型
### 32、为什么 ArrayList 的 elementData 加上 transient 修饰？
### 33、为什么我们调用start()方法时会执行run()方法，为什么我们不能直接调用run()方法？
### 34、说一下 synchronized 底层实现原理？
### 35、Java 中怎么获取一份线程 dump 文件？你如何在 Java 中获取线程堆栈？
### 36、如何理解Hibernate的延迟加载机制？在实际应用中，延迟加载与Session关闭的矛盾是如何处理的？
### 37、在进行数据库编程时，连接池有什么作用？
### 38、怎么查看服务器默认的垃圾回收器是哪一个？
### 39、双亲委派模型是什么？
### 40、TCP编程与UDP编程有什么区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
