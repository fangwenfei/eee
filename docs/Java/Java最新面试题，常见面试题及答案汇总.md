# Java最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、类的实例化顺序

**1、** 父类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行

**2、** 子类静态成员和静态初始化块 ，按在代码中出现的顺序依次执行

**3、** 父类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行

**4、** 父类构造方法

**5、** 子类实例成员和实例初始化块 ，按在代码中出现的顺序依次执行

**6、** 子类构造方法

**检验一下是不是真懂了：**

```
public class Base {
    private String name = "博客：Soinice";

    public Base() {
        tellName();
        printName();
    }

    public void tellName() {
        System.out.println("Base tell name: " + name);
    }

    public void printName() {
        System.out.println("Base print name: " + name);
    }
}
```

```
public class Dervied extends Base {
    private String name = "Java3y";

    public Dervied() {
        tellName();
        printName();
    }

    @Override
    public void tellName() {
        System.out.println("Dervied tell name: " + name);
    }

    @Override
    public void printName() {
        System.out.println("Dervied print name: " + name);
    }

    public static void main(String[] args) {
        new Dervied();
    }
}
```

**输出数据：**

```
Dervied tell name: null
Dervied print name: null
Dervied tell name: Java3y
Dervied print name: Java3y

Process finished with exit code 0
```

第一次做错的同学点个赞，加个关注不过分吧(hahaha。


### 2、如何将字符串反转？

使用 StringBuilder 或者 stringBuffer 的 reverse() 方法。

示例代码：

```
// StringBuffer reverse
StringBuffer stringBuffer = new StringBuffer();
stringBuffer.append("abcdefg");
System.out.println(stringBuffer.reverse()); // gfedcba
// StringBuilder reverse
StringBuilder stringBuilder = new StringBuilder();
stringBuilder.append("abcdefg");
System.out.println(stringBuilder.reverse()); // gfedcba
```


### 3、Iterator 和 ListIterator 有什么区别？

**1、** Iterator 可以遍历 Set 和 List 集合，而 ListIterator 只能遍历 List。

**2、** Iterator 只能单向遍历，而 ListIterator 可以双向遍历（向前/后遍历）。

**3、** ListIterator 实现 Iterator 接口，然后添加了一些额外的功能，比如添加一个元素、替换一个元素、获取前面或后面元素的索引位置。


### 4、在 Java 中 Executor 和 Executors 的区别？

**1、** Executors 工具类的不同方法按照我们的需求创建了不同的线程池，来满足业务的需求。

**2、** Executor 接口对象能执行我们的线程任务。

**3、** ExecutorService 接口继承了 Executor 接口并进行了扩展，提供了更多的方法我们能获得任务执行的状态并且可以获取任务的返回值。

**4、** 使用 ThreadPoolExecutor 可以创建自定义线程池。


### 5、什么是多线程环境下的伪共享（false sharing）？

伪共享是多线程系统（每个处理器有自己的局部缓存）中一个众所周知的性能问题。伪共享发生在不同处理器的上的线程对变量的修改依赖于相同的缓存行


### 6、HashSet与HashMap的区别
| HashMap | HashSet |
| --- | --- |
| 实现了Map接口 | 实现Set接口 |
| 存储键值对 | 仅存储对象 |
| 调用put（）向map中添加元素 | 调用add（）方法向Set中添加元素 |
| HashMap使用键（Key）计算Hashcode | HashSet使用成员对象来计算hashcode值，对于两个对象来说hashcode可能相同，所以equals()方法用来判断对象的相等性，如果两个对象不同的话，那么返回false |
| HashMap相对于HashSet较快，因为它是使用唯一的键获取对象 | HashSet较HashMap来说比较慢 |



### 7、js如何实现页面刷新呢？

**1、** history.go(0)

**2、** location.reload()


### 8、如何使session失效

Session.invalidate()


### 9、ArrayList 和 HashMap 的默认大小是多数？

在 Java 7 中，ArrayList 的默认大小是 10 个元素，HashMap 的默认大小是16个元素（必须是2的幂）。这就是 Java 7 中 ArrayList 和 HashMap 类的代码片段：

```java
// from ArrayList.java JDK 1.7
private static final int DEFAULT_CAPACITY = 10;

//from HashMap.java JDK 7
static final int DEFAULT_INITIAL_CAPACITY = 1 << 4; // aka 16
```


### 10、invokedynamic指令是干什么的？

属于比较高级的题目。没看过虚拟机的一般是不知道的。所以如果你不太熟悉，不要气馁，加油！（小拳拳锤你胸口）。

`invokedynamic`是`Java7`之后新加入的字节码指令，使用它可以实现一些动态类型语言的功能。我们使用的Lambda表达式，在字节码上就是invokedynamic指令实现的。它的功能有点类似反射，但它是使用方法句柄实现的，执行效率更高。


### 11、JAVA虚引用
### 12、被引用的对象就一定能存活吗？
### 13、数组实例化有几种方式？
### 14、ArrayList 与 LinkedList 的不区别？
### 15、OOP 中的 组合、聚合和关联有什么区别？
### 16、什么叫线程安全？servlet是线程安全吗?
### 17、生产环境服务器变慢，如何诊断处理？
### 18、你熟悉哪些垃圾收集算法？
### 19、堆和栈的区别
### 20、多线程的好处
### 21、字符串常量存放在哪个区域？
### 22、说一下 HashSet 的实现原理？
### 23、volatile关键字的原理是什么？干什么用的？
### 24、什么是设计模式
### 25、如果你提交任务时，线程池队列已满，这时会发生什么
### 26、Java 中能创建 volatile 数组吗？
### 27、什么是观察者模式
### 28、Object类常用方法有那些？
### 29、两个相同的对象会有不同的的 hash code 吗？
### 30、GC是什么？为什么要有GC？
### 31、用哪两种方式来实现集合的排序？
### 32、强引用、软引用、弱引用、虚引用是什么，有什么区别？
### 33、说说Java 垃圾回收机制
### 34、事务的ACID是指什么？
### 35、Servlet生命周期内调用的方法过程？
### 36、如何停止一个正在运行的线程？
### 37、串行（serial）收集器和吞吐量（throughput）收集器的区别是什么？
### 38、简述一下面向对象的”六原则一法则”。
### 39、乐观锁和悲观锁的理解及如何实现，有哪些实现方式？
### 40、说出 5 条 IO 的最佳实践(答案)




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
