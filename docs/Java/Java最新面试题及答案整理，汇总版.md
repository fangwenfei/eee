# Java最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、在不使用 StringBuffer 的前提下，怎么反转一个字符串？

解决方案

[http://java67.blogspot.com/2012/12/how-to-reverse-string-in-java-stringbuffer-stringbuilder.htm](http://java67.blogspot.com/2012/12/how-to-reverse-string-in-java-stringbuffer-stringbuilder.htm)


### 2、什么是线程池？

在一个应用程序中初始化一个线程集合，然后在需要执行新的任务时重用线程池中的线程，而不是创建一个新的线程。线程池中的每个线程都有被分配一个任务，一旦任务完成，线程就回到线程池中，等待下一次的任务分配


### 3、并发编程有什么缺点

并发编程的目的就是为了能提高程序的执行效率，提高程序运行速度，但是并发编程并不总是能提高程序运行速度的，而且并发编程可能会遇到很多问题，比如：内存泄漏、上下文切换、线程安全、死锁等问题。


### 4、工厂模式分类

工厂模式分为简单工厂、工厂方法、抽象工厂模式

**简单工厂 ：**

用来生产同一等级结构中的任意产品。（不支持拓展增加产品）

**工厂方法 ：**

用来生产同一等级结构中的固定产品。（支持拓展增加产品）

**抽象工厂 ：**

用来生产不同产品族的全部产品。（不支持拓展增加产品；支持增加产品族）

我下面来使用代码演示一下：

- 简单工厂模式

**什么是简单工厂模式**

简单工厂模式相当于是一个工厂中有各种产品，创建在一个类中，客户无需知道具体产品的名称，只需要知道产品类所对应的参数即可。但是工厂的职责过重，而且当类型过多时不利于系统的扩展维护。

- 代码演示

**1、** 创建工厂

```
package com.lijie;

public interface Car {
    public void run();
}
```

**2、** 创建工厂的产品（宝马）

```
package com.lijie;

public class Bmw implements Car {
    public void run() {
        System.out.println("我是宝马汽车...");
    }
}
```

**3、** 创建工另外一种产品（奥迪）

```
package com.lijie;

public class AoDi implements Car {
    public void run() {
        System.out.println("我是奥迪汽车..");
    }
}
```

**4、** 创建核心工厂类，由他决定具体调用哪产品

```
package com.lijie;

public class CarFactory {

     public static Car createCar(String name) {
        if ("".equals(name)) {
             return null;
        }
        if(name.equals("奥迪")){
            return new AoDi();
        }
        if(name.equals("宝马")){
            return new Bmw();
        }
        return null;
    }
}
```

**5、** 演示创建工厂的具体实例

```
package com.lijie;

public class Client01 {

    public static void main(String[] args) {
        Car aodi  =CarFactory.createCar("奥迪");
        Car bmw  =CarFactory.createCar("宝马");
        aodi.run();
        bmw.run();
    }
}
```

**单工厂的优点/缺点**

**优点：**

简单工厂模式能够根据外界给定的信息，决定究竟应该创建哪个具体类的对象。明确区分了各自的职责和权力，有利于整个软件体系结构的优化。

**缺点：**

很明显工厂类集中了所有实例的创建逻辑，容易违反GRASPR的高内聚的责任分配原则

- 工厂方法模式

**什么是工厂方法模式**

工厂方法模式Factory Method，又称多态性工厂模式。在工厂方法模式中，核心的工厂类不再负责所有的产品的创建，而是将具体创建的工作交给子类去做。该核心类成为一个抽象工厂角色，仅负责给出具体工厂子类必须实现的接口，而不接触哪一个产品类应当被实例化这种细节

- 代码演示

**1、** 创建工厂

```
package com.lijie;

public interface Car {
    public void run();
}
```

**2、** 创建工厂方法调用接口（所有的产品需要new出来必须继承他来实现方法）

```
package com.lijie;

public interface CarFactory {

    Car createCar();

}
```

**3、** 创建工厂的产品（奥迪）

```
package com.lijie;

public class AoDi implements Car {
    public void run() {
        System.out.println("我是奥迪汽车..");
    }
}
```

**4、** 创建工厂另外一种产品（宝马）

```
package com.lijie;

public class Bmw implements Car {
    public void run() {
        System.out.println("我是宝马汽车...");
    }
}
```

**5、** 创建工厂方法调用接口的实例（奥迪）

```
package com.lijie;

public class AoDiFactory implements CarFactory {

    public Car createCar() {
    
        return new AoDi();
    }
}
```

**6、** 创建工厂方法调用接口的实例（宝马）

```
package com.lijie;

public class BmwFactory implements CarFactory {

    public Car createCar() {

        return new Bmw();
    }

}
```

**7、** 演示创建工厂的具体实例

```
package com.lijie;

public class Client {

    public static void main(String[] args) {
        Car aodi = new AoDiFactory().createCar();
        Car jili = new BmwFactory().createCar();
        aodi.run();
        jili.run();
    }
}
```

- 抽象工厂模式

**什么是抽象工厂模式**

抽象工厂简单地说是工厂的工厂，抽象工厂可以创建具体工厂，由具体工厂来产生具体产品。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/047/42/89_3.png#alt=89%5C_3.png)

- 代码演示

**1、** 创建第一个子工厂，及实现类

```
package com.lijie;

//汽车
public interface Car {
       void run();
}

 class CarA implements Car{

    public void run() {
        System.out.println("宝马");
    }
    
}
 class CarB implements Car{

    public void run() {
        System.out.println("摩拜");
    }
    
}
```

**2、** 创建第二个子工厂，及实现类

```
package com.lijie;

//发动机
public interface Engine {

    void run();

}

class EngineA implements Engine {

    public void run() {
        System.out.println("转的快!");
    }

}

class EngineB implements Engine {

    public void run() {
        System.out.println("转的慢!");
    }

}
```

**3、** 创建一个总工厂，及实现类（由总工厂的实现类决定调用那个工厂的那个实例）

```
package com.lijie;

public interface TotalFactory {
    // 创建汽车
    Car createChair();
    // 创建发动机
    Engine createEngine();
}

//总工厂实现类，由他决定调用哪个工厂的那个实例
class TotalFactoryReally implements TotalFactory {

    public Engine createEngine() {

        return new EngineA();
    }

    public Car createChair() {

        return new CarA();
    }
}
```

**4、** 运行测试

```
package com.lijie;

public class Test {

    public static void main(String[] args) {
        TotalFactory totalFactory2 = new TotalFactoryReally();
        Car car = totalFactory2.createChair();
        car.run();

        TotalFactory totalFactory = new TotalFactoryReally();
        Engine engine = totalFactory.createEngine();
        engine.run();
    }
}
```


### 5、Statement与preparedStatement区别

preparedStatement会预编译sql语句，能够提高批量的数据操作的执行效率，Statement执行slq的时候才进行编译

Preparedstatement在第一次执行sql的时候，比较耗费资源。如果只对数据库进行一次操作，使用statement比较好。

Statement会出现sql注入的问题，使用preparedstatment可以解决sql注入


### 6、说明Tomcat配置了多少个Valve?

Tomcat配置了四种类型的Valve：

**1、** 访问日志

**2、** 远程地址过滤

**3、** 远程主机过滤器

**4、** 客户请求记录器


### 7、Java 中堆和栈有什么区别？

JVM 中堆和栈属于不同的内存区域，使用目的也不同。栈常用于保存方法帧和局部变量，而对象总是在堆上分配。栈通常都比堆小，也不会在多个线程之间共享，而堆被整个 JVM 的所有线程共享。


### 8、62、volatile 变量和 atomic 变量有什么不同？

Volatile变量可以确保先行关系，即写操作会发生在后续的读操作之前, 但它并不能保证原子性。例如用volatile修饰count变量那么 count++ 操作就不是原子性的。

而AtomicInteger类提供的atomic方法可以让这种操作具有原子性如getAndIncrement()方法会原子性的进行增量操作把当前值加一，其它数据类型和引用变量也可以进行相似操作。


### 9、多线程的常用方法
| 方法 名 | 描述 |
| --- | --- |
| sleep() | 强迫一个线程睡眠Ｎ毫秒 |
| isAlive() | 判断一个线程是否存活。 |
| join() | 等待线程终止。 |
| activeCount() | 程序中活跃的线程数。 |
| enumerate() | 枚举程序中的线程。 |
| currentThread() | 得到当前线程。 |
| isDaemon() | 一个线程是否为守护线程。 |
| setDaemon() | 设置一个线程为守护线程。 |
| setName() | 为线程设置一个名称。 |
| wait() | 强迫一个线程等待。 |
| notify() | 通知一个线程继续运行。 |
| setPriority() | 设置一个线程的优先级。 |



### 10、阐述ArrayList、Vector、LinkedList的存储性能和特性。



ArrayList 和Vector都是使用数组方式存储数据，此数组元素数大于实际存储的数据以便增加和插入元素，它们都允许直接按序号索引元素，但是插入元素要涉及数组元素移动等内存操作，所以索引数据快而插入数据慢，Vector中的方法由于添加了synchronized修饰，因此Vector是线程安全的容器，但性能上较ArrayList差，因此已经是Java中的遗留容器。LinkedList使用双向链表实现存储（将内存中零散的内存单元通过附加的引用关联起来，形成一个可以按序号索引的线性结构，这种链式存储方式与数组的连续存储方式相比，内存的利用率更高），按序号索引数据需要进行前向或后向遍历，但是插入数据时只需要记录本项的前后项即可，所以插入速度较快。Vector属于遗留容器（Java早期的版本中提供的容器，除此之外，Hashtable、Dictionary、BitSet、Stack、Properties都是遗留容器），已经不推荐使用，但是由于ArrayList和LinkedListed都是非线程安全的，如果遇到多个线程操作同一个容器的场景，则可以通过工具类Collections中的synchronizedList方法将其转换成线程安全的容器后再使用（这是对装潢模式的应用，将已有对象传入另一个类的构造器中创建新的对象来增强实现）。

> 补充：遗留容器中的Properties类和Stack类在设计上有严重的问题，Properties是一个键和值都是字符串的特殊的键值对映射，在设计上应该是关联一个Hashtable并将其两个泛型参数设置为String类型，但是Java API中的Properties直接继承了Hashtable，这很明显是对继承的滥用。这里复用代码的方式应该是Has-A关系而不是Is-A关系，另一方面容器都属于工具类，继承工具类本身就是一个错误的做法，使用工具类最好的方式是Has-A关系（关联）或Use-A关系（依赖）。同理，Stack类继承Vector也是不正确的。Sun公司的工程师们也会犯这种低级错误，让人唏嘘不已。



### 11、CopyOnWriteArrayList 的缺点?
### 12、在监视器(Monitor)内部，是如何做线程同步的？程序应该做哪种级别的同步？
### 13、Java中ConcurrentHashMap的并发度是什么？
### 14、JIT是什么？
### 15、你将如何使用thread dump？你将如何分析Thread dump？
### 16、什么是Hash算法
### 17、什么是 FutureTask
### 18、Final在java中的作用
### 19、线程池中 submit() 和 execute() 方法有什么区别？
### 20、分区收集算法
### 21、TreeMap 和 TreeSet 在排序时如何比较元素？Collections 工具类中的 sort()方法如何比较元素？
### 22、如何在两个线程间共享数据？
### 23、Javascript中常用的事件有哪些？
### 24、JDK 和 JRE 有什么区别？
### 25、as-if-serial规则和happens-before规则的区别
### 26、String 属于基础的数据类型吗？
### 27、双亲委派模型是什么？
### 28、java如何实现多线程之间的通讯和协作？
### 29、为什么要学习工厂设计模式
### 30、synchronized的作用？
### 31、final、finalize()、finally，性质不同
### 32、ThreadLocal是什么？有什么用？
### 33、==与equlas有什么区别？
### 34、JVM 的内存模型以及分区情况和作用
### 35、那针对浮点型数据运算出现的误差的问题，你怎么解决？
### 36、Minor Gc和Full GC 有什么不同呢？
### 37、什么是方法内联？
### 38、如何设置请求的编码以及响应内容的类型？
### 39、同步方法和同步块，哪个是更好的选择?
### 40、重排序遵守的规则




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
