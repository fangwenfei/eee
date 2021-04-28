# Java高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是线程池？

Java中的线程池是运用场景最多的并发框架，几乎所有需要异步或并发执行任务的程序都可以使用线程池。在开发过程中，合理地使用线程池能够带来许多好处。

**1、** 降低资源消耗。通过重复利用已创建的线程降低线程创建和销毁造成的消耗。

**2、** 提高响应速度。当任务到达时，任务可以不需要等到线程创建就能立即执行。

**3、** 提高线程的可管理性。线程是稀缺资源，如果无限制地创建，不仅会消耗系统资源，还会降低系统的稳定性，使用线程池可以进行统一分配、调优和监控。但是，要做到合理利用


### 2、如何实现 Array 和 List 之间的转换？

**1、** Array 转 List： Arrays、asList(array) ；

**2、** List 转 Array：List 的 toArray() 方法。


### 3、JVM调优命令有哪些？

jps，JVM Process Status Tool,显示指定系统内所有的HotSpot虚拟机进程。jstat，JVM statistics Monitoring是用于监视虚拟机运行时状态信息的命令，它可以显示出虚拟机进程中的类装载、内存、垃圾收集、JIT编译等运行数据。jmap，JVM Memory Map命令用于生成heap dump文件 jhat，JVM Heap Analysis Tool命令是与jmap搭配使用，用来分析jmap生成的dump，jhat内置了一个微型的HTTP/HTML服务器，生成dump的分析结果后，可以在浏览器中查看 jstack，用于生成java虚拟机当前时刻的线程快照。jinfo，JVM Conﬁguration info 这个命令作用是实时查看和调整虚拟机运行参数。


### 4、如何实现对象克隆？



有两种方式：

1)、实现Cloneable接口并重写Object类中的clone()方法；

2)、实现Serializable接口，通过对象的序列化和反序列化实现克隆，可以实现真正的深度克隆，代码如下。

```
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyUtil {

    private MyUtil() {
        throw new AssertionError();
    }

    @SuppressWarnings("unchecked")
    public static <T extends Serializable> T clone(T obj) throws Exception {
        ByteArrayOutputStream bout = new ByteArrayOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bout);
        oos.writeObject(obj);

        ByteArrayInputStream bin = new ByteArrayInputStream(bout.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bin);
        return (T) ois.readObject();

        // 说明：调用ByteArrayInputStream或ByteArrayOutputStream对象的close方法没有任何意义
        // 这两个基于内存的流只要垃圾回收器清理对象就能够释放资源，这一点不同于对外部资源（如文件流）的释放
    }
}
```

下面是测试代码：

```
import java.io.Serializable;

/
 * 人类
 * @author 骆昊
 *
 */
class Person implements Serializable {
    private static final long serialVersionUID = -9102017020286042305L;

    private String name;    // 姓名
    private int age;        // 年龄
    private Car car;        // 座驾

    public Person(String name, int age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + ", car=" + car + "]";
    }

}
```

```
/
 * 小汽车类
 * @author 骆昊
 *
 */
class Car implements Serializable {
    private static final long serialVersionUID = -5713945027627603702L;

    private String brand;       // 品牌
    private int maxSpeed;       // 最高时速

    public Car(String brand, int maxSpeed) {
        this.brand = brand;
        this.maxSpeed = maxSpeed;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public int getMaxSpeed() {
        return maxSpeed;
    }

    public void setMaxSpeed(int maxSpeed) {
        this.maxSpeed = maxSpeed;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", maxSpeed=" + maxSpeed + "]";
    }

}
```

```
class CloneTest {

    public static void main(String[] args) {
        try {
            Person p1 = new Person("Hao LUO", 33, new Car("Benz", 300));
            Person p2 = MyUtil.clone(p1);   // 深度克隆
            p2.getCar().setBrand("BYD");
            // 修改克隆的Person对象p2关联的汽车对象的品牌属性
            // 原来的Person对象p1关联的汽车不会受到任何影响
            // 因为在克隆Person对象时其关联的汽车对象也被克隆了
            System.out.println(p1);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
```

> 注意：基于序列化和反序列化实现的克隆不仅仅是深度克隆，更重要的是通过泛型限定，可以检查出要克隆的对象是否支持序列化，这项检查是编译器完成的，不是在运行时抛出异常，这种是方案明显优于使用Object类的clone方法克隆对象。让问题在编译的时候暴露出来总是好过把问题留到运行时。



### 5、Static关键字有什么作用？

Static可以修饰内部类、方法、变量、代码块

Static修饰的类是静态内部类

Static修饰的方法是静态方法，表示该方法属于当前类的，而不属于某个对象的，静态方法也不能被重写，可以直接使用类名来调用。在static方法中不能使用this或者super关键字。

Static修饰变量是静态变量或者叫类变量，静态变量被所有实例所共享，不会依赖于对象。静态变量在内存中只有一份拷贝，在JVM加载类的时候，只为静态分配一次内存。

Static修饰的代码块叫静态代码块，通常用来做程序优化的。静态代码块中的代码在整个类加载的时候只会执行一次。静态代码块可以有多个，如果有多个，按照先后顺序依次执行。


### 6、标记清除算法（ Mark-Sweep）

最基础的垃圾回收算法，分为两个阶段，标注和清除。标记阶段标记出所有需要回收的对象，清除阶段回收被标记的对象所占用的空间。

从图中我们就可以发现，该算法最大的问题是内存碎片化严重，后续可能发生大对象不能找到可利用空间的问题。


### 7、谈谈对 OOM 的认识

除了程序计数器，其他内存区域都有 OOM 的风险。

**1、** 栈一般经常会发生 StackOverflowError，比如 32 位的 windows 系统单进程限制 2G 内存，无限创建线程就会发生栈的 OOM

**2、** Java 8 常量池移到堆中，溢出会出 java.lang.OutOfMemoryError: Java heap space，设置最大元空间大小参数无效

**3、** 堆内存溢出，报错同上，这种比较好理解，GC 之后无法在堆中申请内存创建对象就会报错

**4、** 方法区 OOM，经常会遇到的是动态生成大量的类、jsp 等

**5、** 直接内存 OOM，涉及到 -XX:MaxDirectMemorySize 参数和 Unsafe 对象对内存的申请


### 8、ThreadPoolExecutor饱和策略有哪些？

`如果当前同时运行的线程数量达到最大线程数量并且队列也已经被放满了任时，ThreadPoolTaskExecutor 定义一些策略:`

**1、** ThreadPoolExecutor.AbortPolicy：抛出 RejectedExecutionException来拒绝新任务的处理。

**2、** ThreadPoolExecutor.CallerRunsPolicy：调用执行自己的线程运行任务。您不会任务请求。但是这种策略会降低对于新任务提交速度，影响程序的整体性能。另外，这个策略喜欢增加队列容量。如果您的应用程序可以承受此延迟并且你不能任务丢弃任何一个任务请求的话，你可以选择这个策略。

**3、** ThreadPoolExecutor.DiscardPolicy：不处理新任务，直接丢弃掉。

**4、** ThreadPoolExecutor.DiscardOldestPolicy： 此策略将丢弃最早的未处理的任务请求。


### 9、当一个线程进入某个对象的一个synchronized的实例方法后，其它线程是否可进入此对象的其它方法？

如果其他方法没有synchronized的话，其他线程是可以进入的。

所以要开放一个线程安全的对象时，得保证每个方法都是线程安全的。


### 10、Collections.synchronized  是什么？

**注意：_ 号代表后面是还有内容的_

此方法是干什么的呢，他完完全全的可以把List、Map、Set接口底下的集合变成线程安全的集合

Collections.synchronized * ：原理是什么，我猜的话是代理模式：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/045/42/87_14.png#alt=87%5C_14.png)


### 11、JVM内存模型
### 12、重载与重写
### 13、在 Java 中，对象什么时候可以被垃圾回收？
### 14、生产环境 CPU 占用过高，你如何解决？
### 15、重排序实际执行的指令步骤
### 16、说一下 Atomic的原理？
### 17、Java中的同步集合与并发集合有什么区别？
### 18、safepoint是什么？
### 19、GC是什么？为什么要有GC？
### 20、什么情况下会发生栈溢出？
### 21、char 型变量中能不能存贮一个中文汉字，为什么？
### 22、类加载是什么？
### 23、在java中守护线程和本地线程区别？
### 24、Spring开发中的工厂设计模式
### 25、线上常用的 JVM 参数有哪些？
### 26、标记整理算法(Mark-Compact)
### 27、Java中notify 和 notifyAll有什么区别？
### 28、程序计数器
### 29、类加载有几个过程？
### 30、接口和抽象类有什么区别？
### 31、你知道哪些JVM性能调优
### 32、switch 是否能作用在byte 上，是否能作用在long 上，是否能作用在String上？
### 33、OOP 中的 组合、聚合和关联有什么区别？
### 34、除了单例模式，你在生产环境中还用过什么设计模式？
### 35、继承和组合之间有什么不同？
### 36、HashMap在JDK1.7和JDK1.8中有哪些不同？HashMap的底层实现
### 37、int 和 Integer 哪个会占用更多的内存？
### 38、什么是线程池（thread pool）？
### 39、如何判断一个类是无用的类?
### 40、为什么HashMap中String、Integer这样的包装类适合作为K？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
