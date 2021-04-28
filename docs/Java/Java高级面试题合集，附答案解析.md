# Java高级面试题合集，附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么wait(), notify()和notifyAll ()必须在同步方法或者同步块中被调用？

当一个线程需要调用对象的wait()方法的时候，这个线程必须拥有该对象的锁，接着它就会释放这个对象锁并进入等待状态直到其他线程调用这个对象上的notify()方法。同样的，当一个线程需要调用对象的notify()方法时，它会释放这个对象的锁，以便其他在等待的线程就可以得到这个对象锁。由于所有的这些方法都需要线程持有对象的锁，这样就只能通过同步来实现，所以他们只能在同步方法或者同步块中被调用。


### 2、String str=”aaa”,与String str=new String(“aaa”)一样吗？

**1、** 不一样的。因为内存分配的方式不一样。

**2、** 第一种，创建的”aaa”是常量，jvm都将其分配在常量池中。

**3、** 第二种创建的是一个对象，jvm将其值分配在堆内存中。


### 3、用代码演示三种代理

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


### 4、各种回收算法

**GC最基础的算法有三种：**

**1、** 标记 -清除算法

**2、** 复制算法

**3、** 标记-压缩算法

我们常用的垃圾回收器一般都采用分代收集算法(其实就是组合上面的算法，不同的区域使用不同的算法)。

**具体：**

**1、** 标记-清除算法，“标记-清除”（Mark-Sweep）算法，如它的名字一样，算法分为“标记”和“清除”两个阶段：首先标记出所有需要回收的对象，在标记完成后统一回收掉所有被标记的对象。

**2、** 复制算法，“复制”（Copying）的收集算法，它将可用内存按容量划分为大小相等的两块，每次只使用其中的一块。当这一块的内存用完了，就将还存活着的对象复制到另外一块上面，然后再把已使用过的内存空间一次清理掉。

**3、** 标记-压缩算法，标记过程仍然与“标记-清除”算法一样，但后续步骤不是直接对可回收对象进行清理，而是让所有存活的对象都向一端移动，然后直接清理掉端边界以外的内存

**4、** 分代收集算法，“分代收集”（Generational Collection）算法，把Java堆分为新生代和老年代，这样就可以根据各个年代的特点采用最适当的收集算法。


### 5、线程 B 怎么知道线程 A 修改了变量

**1、** volatile 修饰变量

**2、** synchronized 修饰修改变量的方法

**3、** wait/notify

**4、** while 轮询


### 6、常用JVM基本配置参数

**1、** -Xmx：最大分配内存，默认为物理内存的1/4

**2、** -Xms：初始分配内存，默认为物理内存的1/64

**3、** -Xss：等价于-XX:ThreadStackSize，单个线程栈空间大小，默认一般为512k-1024k，通过jinfo查看为0时，表示使用默认值

**4、** -Xmn：设置年轻代大小

**5、** -XX:MetaspeaceSize：设置元空间大小（默认21M左右，可以配置大一些），元空间的本质可永久代类似，都是对JVM规范中方法区的实现，不过元空间与永久代的最大区别在于：元空间不在虚拟机中，而是使用本地内存，因此，默认情况下，元空间大小仅受本地内存大小限制

**6、** 典型设置案例：-Xms128m -Xmx4096m -Xss1024k -XX:MetaspaceSize=512m -XX:+PrintCommandLineFlags -XX:+PrintGCDetails -XX:+UseSerialGC

**7、** -XX:+PrintGCDetails：打印垃圾回收细节，打印GC： 打印Full GC：

**8、** -XX:SurvivorRatio：调整Eden中survivor区比例，默认-XX:SurvivorRatio=8（8:1:1），调整为-XX:SurvivorRatio=4（4:1:1）,一般使用默认值

**9、** -XX:NewRatio：调整新生代与老年代的比例，默认为2（新生代1，老年代2，年轻代占整个堆的1/3）,调整为-XX:NewRatio=4表示（新生代1，老年代4，年轻代占堆的1/5）,一般使用默认值

**10、** -XX:MaxTenuringThreshold：设置垃圾的最大年龄（经历多少次垃圾回收进入老年代），默认15（15次垃圾回收后依旧存活的对象进入老年代），JDK1.8设置必须0<-XX:MaxTenuringThreshold<15


### 7、死锁的原因

**1、** 是多个线程涉及到多个锁，这些锁存在着交叉，所以可能会导致了一个锁依赖的闭环。

例如：线程在获得了锁A并且没有释放的情况下去申请锁B，这时，另一个线程已经获得了锁B，在释放锁B之前又要先获得锁A，因此闭环发生，陷入死锁循环。

**2、** 默认的锁申请操作是阻塞的。

所以要避免死锁，就要在一遇到多个对象锁交叉的情况，就要仔细审查这几个对象的类中的所有方法，是否存在着导致锁依赖的环路的可能性。总之是尽量避免在一个同步方法中调用其它对象的延时方法和同步方法。


### 8、Java 中 WeakReference 与 SoftReference 的区别？

虽然 WeakReference 与 SoftReference 都有利于提高 GC 和 内存的效率，但是 WeakReference ，一旦失去最后一个强引用，就会被 GC回收，而软引用虽然不能阻止被回收，但是可以延迟到 JVM 内存不足的时候。


### 9、Array 和 ArrayList 有何区别？

**1、** Array 可以存储基本数据类型和对象，ArrayList 只能存储对象。

**2、** Array 是指定固定大小的，而 ArrayList 大小是自动扩展的。

**3、** Array 内置方法没有 ArrayList 多，比如 addAll、removeAll、iteration 等方法只有 ArrayList 有。

`对于基本类型数据，集合使用自动装箱来减少编码工作量。但是，当处理固定大小的基本数据类型的时候，这种方式相对比较慢。`


### 10、Swing 是线程安全的？

不是，Swing 不是线程安全的。你不能通过任何线程来更新 Swing 组件，如 JTable、JList 或 JPanel，事实上，它们只能通过 GUI 或 AWT 线程来更新。这就是为什么 Swing 提供 invokeAndWait() 和 invokeLater() 方法来获取其他线程的 GUI 更新请求。这些方法将更新请求放入 AWT 的线程队列中，可以一直等待，也可以通过异步更新直接返回结果。你也可以在参考答案中查看和学习到更详细的内容。


### 11、类的实例化顺序
### 12、如何自定义线程线程池?
### 13、Executors类是什么？
### 14、描述一下JVM加载class文件的原理机制？
### 15、32 位 JVM 和 64 位 JVM 的最大堆内存分别是多数？
### 16、接口和抽象类有什么区别？
### 17、Semaphore有什么作用
### 18、类ExampleA继承Exception，类ExampleB继承ExampleA。
### 19、为什么线程通信的方法wait(), notify()和notifyAll()被定义在Object 类里？
### 20、堆溢出的原因？
### 21、一个java类中包含那些内容？
### 22、如何通过反射获取和设置对象私有字段的值？
### 23、你知道哪些JVM性能调优
### 24、为什么wait和notify方法要在同步块中调用？
### 25、你能写出一个正则表达式来判断一个字符串是否是一个数字吗？
### 26、CAS 的会产生什么问题？
### 27、url是什么？由哪些部分组成？
### 28、栈帧里面包含哪些东西？
### 29、常用的并发工具类有哪些？
### 30、Set接口有什么特点
### 31、List 和 Set 的区别
### 32、Anonymous Inner Class(匿名内部类)是否可以继承其它类？是否可以实现接口？
### 33、Java 中应该使用什么数据类型来代表价格？
### 34、HashMap在JDK1.7和JDK1.8中有哪些不同？HashMap的底层实现
### 35、类初始化的情况有哪些？
### 36、你能解释一下里氏替换原则吗?
### 37、有什么堆外内存的排查思路？
### 38、两个对象的 hashCode()相同，则 equals()也一定为 true，对吗？
### 39、Java 中 LinkedHashMap 和 PriorityQueue 的区别是什么？
### 40、抽象类必须要有抽象方法吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
