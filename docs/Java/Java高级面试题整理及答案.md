# Java高级面试题整理及答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Java 中，嵌套公共静态类与顶级类有什么不同？

类的内部可以有多个嵌套公共静态类，但是一个 Java 源文件只能有一个顶级公共类，并且顶级公共类的名称与源文件名称必须一致。


### 2、写一段代码在遍历 ArrayList 时移除一个元素？

该问题的关键在于面试者使用的是 ArrayList 的 remove() 还是 Iterator 的 remove()方法。这有一段[示例代码](http://java67.blogspot.com/2015/10/how-to-solve-concurrentmodificationexception-in-java-arraylist.html)，是使用正确的方式来实现在遍历的过程中移除元素，而不会出现 ConcurrentModificationException 异常的示例代码。


### 3、ZGC 了解吗？

JDK11 中加入的具有实验性质的低延迟垃圾收集器，目标是尽可能在不影响吞吐量的前提下，实现在任意堆内存大小都可以把停顿时间限制在 10ms 以内的低延迟。

基于 Region 内存布局，不设分代，使用了读屏障、染色指针和内存多重映射等技术实现可并发的标记-整理，以低延迟为首要目标。

ZGC 的 Region 具有动态性，是动态创建和销毁的，并且容量大小也是动态变化的。


### 4、用最有效率的方法计算2乘以8？



2 << 3（左移3位相当于乘以2的3次方，右移3位相当于除以2的3次方）。

**补充：**

我们为编写的类重写hashCode方法时，可能会看到如下所示的代码，其实我们不太理解为什么要使用这样的乘法运算来产生哈希码（散列码），而且为什么这个数是个素数，为什么通常选择31这个数？前两个问题的答案你可以自己百度一下，选择31是因为可以用移位和减法运算来代替乘法，从而得到更好的性能。说到这里你可能已经想到了：31 * num 等价于(num << 5) - num，左移5位相当于乘以2的5次方再减去自身就相当于乘以31，现在的VM都能自动完成这个优化。

```
public class PhoneNumber {
    private int areaCode;
    private String prefix;
    private String lineNumber;

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + areaCode;
        result = prime * result
                + ((lineNumber == null) ? 0 : lineNumber.hashCode());
        result = prime * result + ((prefix == null) ? 0 : prefix.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        PhoneNumber other = (PhoneNumber) obj;
        if (areaCode != other.areaCode)
            return false;
        if (lineNumber == null) {
            if (other.lineNumber != null)
                return false;
        } else if (!lineNumber.equals(other.lineNumber))
            return false;
        if (prefix == null) {
            if (other.prefix != null)
                return false;
        } else if (!prefix.equals(other.prefix))
            return false;
        return true;
    }

}
```


### 5、动态改变构造

OSGi 服务平台提供在多种网络设备上无需重启的动态改变构造的功能。为了最小化耦合度和促使这些耦合度可管理， OSGi 技术提供一种面向服务的架构，它能使这些组件动态地发现对方。


### 6、有没有可能两个不相等的对象有有相同的 hashcode？

有可能，两个不相等的对象可能会有相同的 hashcode 值，这就是为什么在 hashmap 中会有冲突。相等 hashcode 值的规定只是说如果两个对象相等，必须有相同的hashcode 值，但是没有关于不相等对象的任何规定。


### 7、Java Concurrency API中的Lock接口(Lock interface)是什么？对比同步它有什么优势？

Lock接口比同步方法和同步块提供了更具扩展性的锁操作。

他们允许更灵活的结构，可以具有完全不同的性质，并且可以支持多个相关类的条件对象。

**它的优势有**：

**1、** 可以使锁更公平

**2、** 可以使线程在等待锁的时候响应中断

**3、** 可以让线程尝试获取锁，并在无法获取锁的时候立即返回或者等待一段时间

**4、** 可以在不同的范围，以不同的顺序获取和释放锁

**5、** 整体上来说Lock是synchronized的扩展版，Lock提供了无条件的、可轮询的(tryLock方法)、定时的(tryLock带参方法)、可中断的(lockInterruptibly)、可多条件队列的(newCondition方法)锁操作。另外Lock的实现类基本都支持非公平锁(默认)和公平锁，synchronized只支持非公平锁，当然，在大部分情况下，非公平锁是高效的选择。


### 8、什么是ORM？

对象关系映射（Object-Relational Mapping，简称ORM）是一种为了解决程序的面向对象模型与数据库的关系模型互不匹配问题的技术


### 9、为什么Thread类的sleep()和yield ()方法是静态的？

Thread类的sleep()和yield()方法将在当前正在执行的线程上运行。所以在其他处于等待状态的线程上调用这些方法是没有意义的。这就是为什么这些方法是静态的。它们可以在当前正在执行的线程中工作，并避免程序员错误的认为可以在其他非运行线程调用这些方法。


### 10、什么是过滤器？怎么创建一个过滤器

过滤器：在请求发送之后，处理之前对请求的一次拦截，可以更改请求状态或者参数值等。

创建过滤器：实现filter接口，重写doFilter方法，最后在web.xml中配置过滤器


### 11、原型模式的应用场景
### 12、使用Log4j对程序有影响吗？
### 13、在java中守护线程和本地线程区别？
### 14、什么是Java Timer 类？如何创建一个有特定时间间隔的任务？
### 15、CopyOnWriteArrayList 的使用场景?
### 16、创建一个对象用什么运算符？对象实体与对象引用有何不同？
### 17、Java 中 interrupted 和 isInterrupted 方法的区别？
### 18、int 和 Integer 哪个会占用更多的内存？
### 19、float f=3.4;是否正确？
### 20、Java中用到的线程调度算法是什么
### 21、如何合理分配线程池大小?
### 22、什么是线程调度器(Thread Scheduler)和时间分片(Time Slicing)？
### 23、Java中集合框架的有几个？
### 24、Java 中 ++ 操作符是线程安全的吗？
### 25、程序计数器
### 26、Java线程数过多会造成什么异常？
### 27、Spring中Bean的作用域有哪些？
### 28、Final在java中的作用
### 29、什么是面向对象？
### 30、java中有没有指针？
### 31、short s1 = 1; s1 = s1 + 1;有错吗?short s1 = 1; s1 += 1;有错吗？
### 32、创建一个子类对象的时候，那么父类的构造方法会执行吗？
### 33、说一下堆内存中对象的分配的基本策略
### 34、Java语言采用何种编码方案？有何特点？
### 35、Thow与thorws区别
### 36、Java 中会存在内存泄漏?简述一下
### 37、url是什么？由哪些部分组成？
### 38、你都有哪些手段用来排查内存溢出？
### 39、Java 中，编写多线程程序的时候你会遵循哪些最佳实践？
### 40、怎么检查一个字符串只包含数字？解决方案




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
