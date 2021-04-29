# Java高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Spring中自动装配的方式有哪些？

**1、** no：不进行自动装配，手动设置Bean的依赖关系。

**2、** byName：根据Bean的名字进行自动装配。

**3、** byType：根据Bean的类型进行自动装配。

**4、** constructor：类似于byType，不过是应用于构造器的参数，如果正好有一个Bean与构造器的参数类型相同则可以自动装配，否则会导致错误。

**5、** autodetect：如果有默认的构造器，则通过constructor的方式进行自动装配，否则使用byType的方式进行自动装配。


### 2、HTTP的状态码

**1、** 200：请求成功

**2、** 400：不是正确的请求，大多情况下表示参数错误

**3、** 404：找不到请求资源

**4、** 500：服务器内部错误

**5、** 403：服务器拒绝

**6、** 405：请求的method不支持

**7、** 504：服务器临时不可用


### 3、JVM垃圾回收机制，何时触发MinorGC等操作

当young gen中的eden区分配满的时候触发MinorGC(新生代的空间不够放的时候).


### 4、react-redux是如何工作的?

**1、** Provider: Provider的作用是从最外部封装了整个应用，并向connect模块传递store

**2、** connect: 负责连接React和Redux

**3、** 获取state: connect通过context获取Provider中的store，通过store.getState()获取整个store tree 上所有state

**4、** 包装原组件: 将state和action通过props的方式传入到原组件内部wrapWithConnect返回一个ReactComponent对象Connect，Connect重新render外部传入的原组件WrappedComponent，并把connect中传入的mapStateToProps, mapDispatchToProps与组件上原有的props合并后，通过属性的方式传给WrappedComponent

**5、** 监听store tree变化: connect缓存了store tree中state的状态,通过当前state状态和变更前state状态进行比较,从而确定是否调用`this.setState()`方法触发Connect及其子组件的重新渲染

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_12.png#alt=97%5C_12.png)


### 5、== 和 equals 的区别是什么？

== 解读

对于基本类型和引用类型 == 的作用效果是不同的，如下所示：

基本类型：比较的是值是否相同； 引用类型：比较的是引用是否相同； 代码示例：

```
String x = "string";
String y = "string";
String z = new String("string");
System.out.println(x==y); // true
System.out.println(x==z); // false
System.out.println(x.equals(y)); // true
System.out.println(x.equals(z)); // true
```

代码解读：因为 x 和 y 指向的是同一个引用，所以 == 也是 true，而 new String()方法则重写开辟了内存空间，所以 == 结果为 false，而 equals 比较的一直是值，所以结果都为 true。

equals 解读

equals 本质上就是 ==，只不过 String 和 Integer 等重写了 equals 方法，把它变成了值比较。看下面的代码就明白了。

首先来看默认情况下 equals 比较一个有相同值的对象，代码如下：

```
class Cat {
    public Cat(String name) {
        this.name = name;
    }
 
    private String name;
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
}
 
Cat c1 = new Cat("提莫");
Cat c2 = new Cat("提莫");
System.out.println(c1.equals(c2)); // false
```

输出结果出乎我们的意料，竟然是 false？这是怎么回事，看了 equals 源码就知道了，源码如下：

```
public boolean equals(Object obj) {
    return (this == obj);
}
```

原来 equals 本质上就是 ==。

那问题来了，两个相同值的 String 对象，为什么返回的是 true？代码如下：

```
String s1 = new String("阿莫");
String s2 = new String("阿莫");
System.out.println(s1.equals(s2)); // true
```

同样的，当我们进入 String 的 equals 方法，找到了答案，代码如下：

```
public boolean equals(Object anObject) {
    if (this == anObject) {
    return true;
    }
    if (anObject instanceof String) {
        String anotherString = (String)anObject;
        int n = value.length;
        if (n == anotherString.value.length) {
            char v1[] = value;
            char v2[] = anotherString.value;
            int i = 0;
            while (n-- != 0) {
                if (v1[i] != v2[i])
                    return false;
                i++;
            }
            return true;
        }
    }
    return false;
}
```

原来是 String 重写了 Object 的 equals 方法，把引用比较改成了值比较。

总结：== 对于基本类型来说是值比较，对于引用类型来说是比较的是引用；而 equals 默认情况下是引用比较，只是很多类重新了 equals 方法，比如 String、Integer 等把它变成了值比较，所以一般情况下 equals 比较的是值是否相等。


### 6、CyclicBarrier和CountDownLatch的区别

**1、** CountDownLatch简单的说就是一个线程等待，直到他所等待的其他线程都执行完成并且调用countDown()方法发出通知后，当前线程才可以继续执行。

**2、** cyclicBarrier是所有线程都进行等待，直到所有线程都准备好进入await()方法之后，所有线程同时开始执行！

**3、** CountDownLatch的计数器只能使用一次。而CyclicBarrier的计数器可以使用reset() 方法重置。所以CyclicBarrier能处理更为复杂的业务场景，比如如果计算发生错误，可以重置计数器，并让线程们重新执行一次。

**4、** CyclicBarrier还提供其他有用的方法，比如getNumberWaiting方法可以获得CyclicBarrier阻塞的线程数量。isBroken方法用来知道阻塞的线程是否被中断。如果被中断返回true，否则返回false。


### 7、String和StringBuilder、StringBuffer的区别？



Java平台提供了两种类型的字符串：String和StringBuffer/StringBuilder，它们可以储存和操作字符串。其中String是只读字符串，也就意味着String引用的字符串内容是不能被改变的。而StringBuffer/StringBuilder类表示的字符串对象可以直接进行修改。StringBuilder是Java 5中引入的，它和StringBuffer的方法完全相同，区别在于它是在单线程环境下使用的，因为它的所有方面都没有被synchronized修饰，因此它的效率也比StringBuffer要高。

**面试题1**

什么情况下用+运算符进行字符串连接比调用StringBuffer/StringBuilder对象的append方法连接字符串性能更好？

**面试题2**

请说出下面程序的输出。

```
class StringEqualTest {

    public static void main(String[] args) {
        String s1 = "Programming";
        String s2 = new String("Programming");
        String s3 = "Program";
        String s4 = "ming";
        String s5 = "Program" + "ming";
        String s6 = s3 + s4;
        System.out.println(s1 == s2);
        System.out.println(s1 == s5);
        System.out.println(s1 == s6);
        System.out.println(s1 == s6.intern());
        System.out.println(s2 == s2.intern());
    }
}
```

**补充：**

解答上面的面试题需要清除两点：1、String对象的intern方法会得到字符串对象在常量池中对应的版本的引用（如果常量池中有一个字符串与String对象的equals结果是true），如果常量池中没有对应的字符串，则该字符串将被添加到常量池中，然后返回常量池中字符串的引用；2、字符串的+操作其本质是创建了StringBuilder对象进行append操作，然后将拼接后的StringBuilder对象用toString方法处理成String对象，这一点可以用javap -c StringEqualTest.class命令获得class文件对应的JVM字节码指令就可以看出来。


### 8、JAVA弱引用
### 9、用最有效率的方法计算2乘以8？
### 10、什么是原子操作？在Java Concurrency API中有哪些原子类(atomic classes)？
### 11、可达性分析
### 12、什么是方法重载？
### 13、什么是方法内联？
### 14、同步方法和同步块，哪个是更好的选择？
### 15、我们能创建一个包含可变对象的不可变对象吗？
### 16、JVM的永久代中会发生垃圾回收么
### 17、如何选择单例创建方式
### 18、你知道有哪些开源框架？
### 19、UML中有哪些常用的图？
### 20、什么是 Busy spin？我们为什么要使用它？
### 21、String str=”aaa”,与String str=new String(“aaa”)一样吗？
### 22、为什么选择使用框架而不是原生?
### 23、请说明NAT协议的目的是什么?
### 24、什么是重写？什么是重载？
### 25、ConcurrentHashMap的并发度是什么
### 26、Tcp协议的特点
### 27、多线程场景下如何使用 ArrayList？
### 28、简单描述一下（分代）垃圾回收的过程
### 29、说说G1垃圾收集器的工作原理
### 30、JVM内存模型
### 31、Java 如何实现多线程之间的通讯和协作？
### 32、说一下垃圾分代收集的过程
### 33、Java中异常分为哪两种？
### 34、同步方法和同步块，哪个是更好的选择?
### 35、ThreadLocal是什么？有什么用？
### 36、双亲委派模型是什么？
### 37、如何通过反射调用对象的方法？
### 38、什么是线程池？ 为什么要使用它？
### 39、try{}里有一个return语句，那么紧跟在这个try后的finally{}里的代码会不会被执行，什么时候被执行，在return前还是后?
### 40、说出几点 Java 中使用 Collections 的最佳实践




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
