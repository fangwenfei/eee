# Java面试题大全带答案，持续更新

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MyBatis中使用#和$书写占位符有什么区别？

#将传入的数据都当成一个字符串，会对传入的数据自动加上引号；$$将传入的数据直接显示生成在SQL中。注意：使用$$占位符可能会导致SQL注射攻击，能用#的地方就不要使用$$，写order by子句的时候应该用$$而不是#。、


### 2、解释什么是Tomcat Valve?

Tomcat Valve——Tomcat 4引入的新技术，它允许您将Java类的实例链接到一个特定的Catalina容器。


### 3、String和StringBuffer、StringBuilder的区别是什么？String为什么是不可变的？

**可变性**

String类中使用字符数组保存字符串，private final char value[]，所以string对象是不可变的。StringBuilder与StringBuffer都继承自AbstractStringBuilder类，在AbstractStringBuilder中也是使用字符数组保存字符串，char[]value，这两种对象都是可变的。

**线程安全性**

String中的对象是不可变的，也就可以理解为常量，线程安全。AbstractStringBuilder是StringBuilder与StringBuffer的公共父类，定义了一些字符串的基本操作，如expandCapacity、append、insert、indexOf等公共方法。StringBuffer对方法加了同步锁或者对调用的方法加了同步锁，所以是线程安全的。StringBuilder并没有对方法进行加同步锁，所以是非线程安全的。

**性能**

每次对String 类型进行改变的时候，都会生成一个新的String对象，然后将指针指向新的String 对象。StringBuffer每次都会对StringBuffer对象本身进行操作，而不是生成新的对象并改变对象引用。相同情况下使用StirngBuilder 相比使用StringBuffer 仅能获得10%~15% 左右的性能提升，但却要冒多线程不安全的风险。 **对于三者使用的总结：** 如果要操作少量的数据用 = String 单线程操作字符串缓冲区 下操作大量数据 = StringBuilder 多线程操作字符串缓冲区 下操作大量数据 = StringBuffer


### 4、说说G1垃圾收集器的工作原理

优点：指定最大停顿时间、分Region的内存布局、按收益动态确定回收集

**1、** G1开创的基于Region的堆内存布局是它能够实现这个目标的关键。虽然G1也仍是遵循分代收集理论设计的，但其堆内存的布局与其他收集器有非常明显的差异：G1不再坚持固定大小以及固定数量的分代区域划分，而是把连续的Java堆划分为多个大小相等的独立区域（Region），每一个Region都可以根据需要，扮演新生代的Eden空间、Survivor空间，或者老年代空间。收集器能够对扮演不同角色的Region采用不同的策略去处理，这样无论是新创建的对象还是已经存活了一段时间、熬过多次收集的旧对象都能获取很好的收集效果。

**2、** 虽然G1仍然保留新生代和老年代的概念，但新生代和老年代不再是固定的了，它们都是一系列区域（不需要连续）的动态集合。G1收集器之所以能建立可预测的停顿时间模型，是因为它将Region作为单次回收的最小单元，即每次收集到的内存空间都是Region大小的整数倍，这样可以有计划地避免在整个Java堆中进行全区域的垃圾收集。更具体的处理思路是让G1收集器去跟踪各个Region里面的垃圾堆积的“价值”大小，价值即回收所获得的空间大小以及回收所需时间的经验值，然后在后台维护一个优先级列表，每次根据用户设定允许的收集停顿时间（使用参数-XX：MaxGCPauseMillis指定，默认值是200毫秒），优先处理回收价值收益最大的那些Region，这也就是“Garbage First”名字的由来。这种使用Region划分内存空间，以及具有优先级的区域回收方式，保证了G1收集器在有限的时间内获取尽可能高的收集效率。

**3、** G1收集器的运作过程大致可划分为以下四个步骤：·初始标记 （Initial Marking）：仅仅只是标记一下GC Roots能直接关联到的对象，并且修改TAMS指针的值，让下一阶段用户线程并发运行时，能正确地在可用的Region中分配新对象。这个阶段需要停顿线程，但耗时很短，而且是借用进行Minor GC的时候同步完成的，所以G1收集器在这个阶段实际并没有额外的停顿。·并发标记 （Concurrent Marking）：从GC Root开始对堆中对象进行可达性分析，递归扫描整个堆里的对象图，找出要回收的对象，这阶段耗时较长，但可与用户程序并发执行。当对象图扫描完成以后，还要重新处理SATB记录下的在并发时有引用变动的对象。·最终标记 （Final Marking）：对用户线程做另一个短暂的暂停，用于处理并发阶段结束后仍遗留下来的最后那少量的SATB记录。·筛选回收 （Live Data Counting and Evacuation）：负责更新Region的统计数据，对各个Region的回收价值和成本进行排序，根据用户所期望的停顿时间来制定回收计划，可以自由选择任意多个Region构成回收集，然后把决定回收的那一部分Region的存活对象复制到空的Region中，再清理掉整个旧Region的全部空间。这里的操作涉及存活对象的移动，是必须暂停用户线程，由多条收集器线程并行完成的。从上述阶段的描述可以看出，G1收集器除了并发标记外，其余阶段也是要完全暂停用户线程的 。


### 5、用代码演示三种代理

- 静态代理

**什么是静态代理**

由程序员创建或工具生成代理类的源码，再编译代理类。所谓静态也就是在程序运行前就已经存在代理类的字节码文件，代理类和委托类的关系在运行前就确定了。

- 代码演示

我有一段这样的代码：（如何能在不修改UserDao接口类的情况下开事务和关闭事务呢）

```
package com.lijie;

//接口类
public class UserDao{
    public void save() {
        System.out.println("保存数据方法");
    }
}
```

```
package com.lijie;

//运行测试类
public  class Test{
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        userDao.save();
    }
}
```

**修改代码，添加代理类**

```
package com.lijie;

//代理类
public class UserDaoProxy extends UserDao {
    private UserDao userDao;

    public UserDaoProxy(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save() {
        System.out.println("开启事物...");
        userDao.save();
        System.out.println("关闭事物...");
    }

}
```

```
//添加完静态代理的测试类
public class Test{
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        UserDaoProxy userDaoProxy = new UserDaoProxy(userDao);
        userDaoProxy.save();
    }
}
```

**缺点：**

每个需要代理的对象都需要自己重复编写代理，很不舒服，

**优点：**

但是可以面相实际对象或者是接口的方式实现代理

- 动态代理

**什么是动态代理**

动态代理也叫做，JDK代理、接口代理。

动态代理的对象，是利用JDK的API，动态的在内存中构建代理对象（是根据被代理的接口来动态生成代理类的class文件，并加载运行的过程），这就叫动态代理

- 代码演示

```
package com.lijie;

//接口
public interface UserDao {
    void save();
}
```

```
package com.lijie;

//接口实现类
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("保存数据方法");
    }
}
```

下面是代理类，可重复使用，不像静态代理那样要自己重复编写代理

```
package com.lijie;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

// 每次生成动态代理类对象时,实现了InvocationHandler接口的调用处理器对象
public class InvocationHandlerImpl implements InvocationHandler {

    // 这其实业务实现类对象，用来调用具体的业务方法
    private Object target;

    // 通过构造函数传入目标对象
    public InvocationHandlerImpl(Object target) {
        this.target = target;
    }

    //动态代理实际运行的代理方法
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用开始处理");
        //下面invoke()方法是以反射的方式来创建对象，第一个参数是要创建的对象，第二个是构成方法的参数，由第二个参数来决定创建对象使用哪个构造方法
        Object result = method.invoke(target, args);
        System.out.println("调用结束处理");
        return result;
    }
}
```

利用动态代理使用代理方法

```
package com.lijie;

import java.lang.reflect.Proxy;

public class Test {
    public static void main(String[] args) {
        // 被代理对象
        UserDao userDaoImpl = new UserDaoImpl();
        InvocationHandlerImpl invocationHandlerImpl = new InvocationHandlerImpl(userDaoImpl);

        //类加载器
        ClassLoader loader = userDaoImpl.getClass().getClassLoader();
        Class<?>[] interfaces = userDaoImpl.getClass().getInterfaces();

        // 主要装载器、一组接口及调用处理动态代理实例
        UserDao newProxyInstance = (UserDao) Proxy.newProxyInstance(loader, interfaces, invocationHandlerImpl);
        newProxyInstance.save();
    }
}
```

**缺点：**

必须是面向接口，目标业务类必须实现接口

**优点：**

不用关心代理类，只需要在运行阶段才指定代理哪一个对象

- CGLIB动态代理

**CGLIB动态代理原理：**

利用asm开源包，对代理对象类的class文件加载进来，通过修改其字节码生成子类来处理。

**什么是CGLIB动态代理**

CGLIB动态代理和jdk代理一样，使用反射完成代理，不同的是他可以直接代理类（jdk动态代理不行，他必须目标业务类必须实现接口），CGLIB动态代理底层使用字节码技术，CGLIB动态代理不能对 final类进行继承。（CGLIB动态代理需要导入jar包）

- 代码演示

```
package com.lijie;

//接口
public interface UserDao {
    void save();
}
```

```
package com.lijie;

//接口实现类
public class UserDaoImpl implements UserDao {
    public void save() {
        System.out.println("保存数据方法");
    }
}
```

```
package com.lijie;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;
import java.lang.reflect.Method;

//代理主要类
public class CglibProxy implements MethodInterceptor {
    private Object targetObject;
    // 这里的目标类型为Object，则可以接受任意一种参数作为被代理类，实现了动态代理
    public Object getInstance(Object target) {
        // 设置需要创建子类的类
        this.targetObject = target;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(target.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    //代理实际方法
    public Object intercept(Object obj, Method method, Object[] args, MethodProxy proxy) throws Throwable {
        System.out.println("开启事物");
        Object result = proxy.invoke(targetObject, args);
        System.out.println("关闭事物");
        // 返回代理对象
        return result;
    }
}
```

```
package com.lijie;

//测试CGLIB动态代理
public class Test {
    public static void main(String[] args) {
        CglibProxy cglibProxy = new CglibProxy();
        UserDao userDao = (UserDao) cglibProxy.getInstance(new UserDaoImpl());
        userDao.save();
    }
}
```


### 6、什么情况会造成元空间溢出？

元空间（Metaspace）默认是没有上限的，不加限制比较危险。当应用中的Java类过多，比如Spring等一些使用动态代理的框架生成了很多类，如果占用空间超出了`我们的设定值`，就会发生元空间溢出。

所以，默认风险大，但如果你不给足它空间，它也会溢出。


### 7、Swing 是线程安全的？

不是，Swing 不是线程安全的。你不能通过任何线程来更新 Swing 组件，如 JTable、JList 或 JPanel，事实上，它们只能通过 GUI 或 AWT 线程来更新。这就是为什么 Swing 提供 invokeAndWait() 和 invokeLater() 方法来获取其他线程的 GUI 更新请求。这些方法将更新请求放入 AWT 的线程队列中，可以一直等待，也可以通过异步更新直接返回结果。你也可以在参考答案中查看和学习到更详细的内容。


### 8、String str=”aa”,String s=”bb”,String aa=aa+s;一种创建了几个对象？

一共有两个引用，三个对象。因为”aa”与”bb”都是常量，常量的值不能改变，当执行字符串拼接时候，会创建一个新的常量是” aabbb”,有将其存到常量池中。


### 9、单例优缺点

**优点：**

**1、** 在单例模式中，活动的单例只有一个实例，对单例类的所有实例化得到的都是相同的一个实例。这样就防止其它对象对自己的实例化，确保所有的对象都访问一个实例

**2、** 单例模式具有一定的伸缩性，类自己来控制实例化进程，类就在改变实例化进程上有相应的伸缩性。

**3、** 提供了对唯一实例的受控访问。

**4、** 由于在系统内存中只存在一个对象，因此可以节约系统资源，当需要频繁创建和销毁的对象时单例模式无疑可以提高系统的性能。

**5、** 允许可变数目的实例。

**6、** 避免对共享资源的多重占用。

**缺点：**

**1、** 不适用于变化的对象，如果同一类型的对象总是要在不同的用例场景发生变化，单例就会引起数据的错误，不能保存彼此的状态。

**2、** 由于单利模式中没有抽象层，因此单例类的扩展有很大的困难。

**3、** 单例类的职责过重，在一定程度上违背了“单一职责原则”。

**4、** 滥用单例将带来一些负面问题，如为了节省资源将数据库连接池对象设计为的单例类，可能会导致共享连接池对象的程序过多而出现连接池溢出；如果实例化的对象长时间不被利用，系统会认为是垃圾而被回收，这将导致对象状态的丢失。


### 10、为什么 wait(), notify()和 notifyAll()必须在同步方法或者同步块中被调用？

当一个线程需要调用对象的 wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的 notify()方法。同样的，当一个线程需要调用对象的 notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。


### 11、React最新的生命周期是怎样的?
### 12、实际开发中应用场景哪里用到了模板方法
### 13、CopyOnWriteArrayList 的设计思想?
### 14、用Java的套接字编程实现一个多线程的回显（echo）服务器。
### 15、JRE、JDK、JVM 及 JIT 之间有什么不同？
### 16、如何判断对象可以被回收
### 17、JVM 如何确定垃圾对象？
### 18、jspservlet中通信作用域有那些？
### 19、代理模式应用场景
### 20、请你谈谈对OOM的认识
### 21、什么时候会触发FullGC
### 22、什么是阻塞队列？阻塞队列的实现原理是什么？如何使用阻塞队列来实现生产者-消费者模型？
### 23、接口是什么？为什么要使用接口而不是直接使用具体类？
### 24、Java 中如何格式化一个日期？如格式化为 ddMMyyyy 的形式？
### 25、什么是线程死锁
### 26、React的请求应该放在哪个生命周期中?
### 27、怎样将GB2312编码的字符串转换为ISO-8859-1编码的字符串？
### 28、字符串常量存放在哪个区域？
### 29、HashMap为什么不直接使用hashCode()处理后的哈希值直接作为table的下标？
### 30、java中有几种方法可以实现一个线程？
### 31、Collection和Collections的区别？
### 32、java 中的 Math.round(-1.5) 等于多少？
### 33、3*0.1 == 0.3 将会返回什么？true 还是 false？
### 34、说说ZGC垃圾收集器的工作原理
### 35、JVM 监控与分析工具你用过哪些？介绍一下。
### 36、java 面向对象编程三大特性------封装、继承、多态
### 37、描述一下什么情况下，对象会从年轻代进入老年代
### 38、直接内存是什么？
### 39、什么是类加载器，类加载器有哪些？
### 40、死锁与活锁的区别，死锁与饥饿的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
