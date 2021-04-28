# Java最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、mixin、hoc、render props、react-hooks的优劣如何？

**Mixin的缺陷：**

**1、** 组件与 Mixin 之间存在隐式依赖（Mixin 经常依赖组件的特定方法，但在定义组件时并不知道这种依赖关系）

**2、** 多个 Mixin 之间可能产生冲突（比如定义了相同的state字段）

**3、** Mixin 倾向于增加更多状态，这降低了应用的可预测性（The more state in your application, the harder it is to reason about it.），导致复杂度剧增

**隐式依赖导致依赖关系不透明，维护成本和理解成本迅速攀升：**

**1、** 难以快速理解组件行为，需要全盘了解所有依赖 Mixin 的扩展行为，及其之间的相互影响

**2、** 组价自身的方法和state字段不敢轻易删改，因为难以确定有没有 Mixin 依赖它

**3、** Mixin 也难以维护，因为 Mixin 逻辑最后会被打平合并到一起，很难搞清楚一个 Mixin 的输入输出

**HOC相比Mixin的优势:**

**1、** HOC通过外层组件通过 Props 影响内层组件的状态，而不是直接改变其 State不存在冲突和互相干扰,这就降低了耦合度

**2、** 不同于 Mixin 的打平+合并，HOC 具有天然的层级结构（组件树结构），这又降低了复杂度

**HOC的缺陷:**

**1、** 扩展性限制: HOC 无法从外部访问子组件的 State因此无法通过shouldComponentUpdate滤掉不必要的更新,React 在支持 ES6 Class 之后提供了React.PureComponent来解决这个问题

**2、** Ref 传递问题: Ref 被隔断,后来的React.forwardRef 来解决这个问题

**3、** Wrapper Hell: HOC可能出现多层包裹组件的情况,多层抽象同样增加了复杂度和理解成本

**4、** 命名冲突: 如果高阶组件多次嵌套,没有使用命名空间的话会产生冲突,然后覆盖老属性

**5、** 不可见性: HOC相当于在原有组件外层再包装一个组件,你压根不知道外层的包装是啥,对于你是黑盒

**Render Props优点:**

上述HOC的缺点Render Props都可以解决

**Render Props缺陷:**

**1、** 使用繁琐: HOC使用只需要借助装饰器语法通常一行代码就可以进行复用,Render Props无法做到如此简单

**2、** 嵌套过深: Render Props虽然摆脱了组件多层嵌套的问题,但是转化为了函数回调的嵌套

**React Hooks优点:**

**1、** 简洁: React Hooks解决了HOC和Render Props的嵌套问题,更加简洁

**2、** 解耦: React Hooks可以更方便地把 UI 和状态分离,做到更彻底的解耦

**3、** 组合: Hooks 中可以引用另外的 Hooks形成新的Hooks,组合变化万千

**4、** 函数友好: React Hooks为函数组件而生,从而解决了类组件的几大问题:

**1、** this 指向容易错误

**2、** 分割在不同声明周期中的逻辑使得代码难以理解和维护

**3、** 代码复用成本高（高阶组件容易使代码量剧增）

**React Hooks缺陷:**

**1、** 额外的学习成本（Functional Component 与 Class Component 之间的困惑）

**2、** 写法上有限制（不能出现在条件、循环中），并且写法限制增加了重构成本

**3、** 破坏了PureComponent、React.memo浅比较的性能优化效果（为了取最新的props和state，每次render()都要重新创建事件处函数）

**4、** 在闭包场景可能会引用到旧的state、props值

**5、** 内部实现上不直观（依赖一份可变的全局状态，不再那么“纯”）

**6、** React.memo并不能完全替代shouldComponentUpdate（因为拿不到 state change，只针对 props change）

> 关于react-hooks的评价来源于官方[react-hooks RFC](https://github.com/reactjs/rfcs/blob/master/text/0068-react-hooks.md#drawbacks)



### 2、什么是 Callable 和 Future?

Callable 接口类似于 Runnable，从名字就可以看出来了，但是 Runnable 不会返回结果，并且无法抛出返回结果的异常，而 Callable 功能更强大一些，被线程执行后，可以返回值，这个返回值可以被 Future 拿到，也就是说，Future 可以拿到异步执行任务的返回值。

Future 接口表示异步任务，是一个可能还没有完成的异步任务的结果。所以说 Callable用于产生结果，Future 用于获取结果。


### 3、ArrayList 和 LinkedList 的区别是什么？

**1、** 数据结构实现：ArrayList 是动态数组的数据结构实现，而 LinkedList 是双向链表的数据结构实现。

**2、** 随机访问效率：ArrayList 比 LinkedList 在随机访问的时候效率要高，因为 LinkedList 是线性的数据存储方式，所以需要移动指针从前往后依次查找。

**3、** 增加和删除效率：在非首尾的增加和删除操作，LinkedList 要比 ArrayList 效率要高，因为 ArrayList 增删操作要影响数组内的其他数据的下标。

**4、** 内存空间占用：LinkedList 比 ArrayList 更占内存，因为 LinkedList 的节点除了存储数据，还存储了两个引用，一个指向前一个元素，一个指向后一个元素。

**5、** 线程安全：ArrayList 和 LinkedList 都是不同步的，也就是不保证线程安全；

**6、** 综合来说，在需要频繁读取集合中的元素时，更推荐使用 ArrayList，而在插入和删除操作较多时，更推荐使用 LinkedList。

**7、** LinkedList 的双向链表也叫双链表，是链表的一种，它的每个数据结点中都有两个指针，分别指向直接后继和直接前驱。所以，从双向链表中的任意一个结点开始，都可以很方便地访问它的前驱结点和后继结点。


### 4、React最新的生命周期是怎样的?

React 16之后有三个生命周期被废弃(但并未删除)

**1、** componentWillMount

**2、** componentWillReceiveProps

**3、** componentWillUpdate

官方计划在17版本完全删除这三个函数，只保留UNSAVE_前缀的三个函数，目的是为了向下兼容，但是对于开发者而言应该尽量避免使用他们，而是使用新增的生命周期函数替代它们

目前React 16.8 +的生命周期分为三个阶段,分别是挂载阶段、更新阶段、卸载阶段

**挂载阶段:**

**1、** constructor: 构造函数，最先被执行,我们通常在构造函数里初始化state对象或者给自定义方法绑定this

**2、** getDerivedStateFromProps: `static getDerivedStateFromProps(nextProps, prevState)`,这是个静态方法,当我们接收到新的属性想去修改我们state，可以使用getDerivedStateFromProps

**3、** render: render函数是纯函数，只返回需要渲染的东西，不应该包含其它的业务逻辑,可以返回原生的DOM、React组件、Fragment、Portals、字符串和数字、Boolean和null等内容

**4、** componentDidMount: 组件装载之后调用，此时我们可以获取到DOM节点并操作，比如对canvas，svg的操作，服务器请求，订阅都可以写在这个里面，但是记得在componentWillUnmount中取消订阅

**更新阶段:**

**1、** getDerivedStateFromProps: 此方法在更新个挂载阶段都可能会调用

**2、** shouldComponentUpdate: `shouldComponentUpdate(nextProps, nextState)`,有两个参数nextProps和nextState，表示新的属性和变化之后的state，返回一个布尔值，true表示会触发重新渲染，false表示不会触发重新渲染，默认返回true,我们通常利用此生命周期来优化React程序性能

**3、** render: 更新阶段也会触发此生命周期

**4、** getSnapshotBeforeUpdate: `getSnapshotBeforeUpdate(prevProps, prevState)`,这个方法在render之后，componentDidUpdate之前调用，有两个参数prevProps和prevState，表示之前的属性和之前的state，这个函数有一个返回值，会作为第三个参数传给componentDidUpdate，如果你不想要返回值，可以返回null，此生命周期必须与componentDidUpdate搭配使用

**5、** componentDidUpdate: `componentDidUpdate(prevProps, prevState, snapshot)`,该方法在getSnapshotBeforeUpdate方法之后被调用，有三个参数prevProps，prevState，snapshot，表示之前的props，之前的state，和snapshot。第三个参数是getSnapshotBeforeUpdate返回的,如果触发某些回调函数时需要用到 DOM 元素的状态，则将对比或计算的过程迁移至 getSnapshotBeforeUpdate，然后在 componentDidUpdate 中统一触发回调或更新状态。

**卸载阶段:**

componentWillUnmount: 当我们的组件被卸载或者销毁了就会调用，我们可以在这个函数里去清除一些定时器，取消网络请求，清理无效的DOM元素等垃圾清理工作

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/1939/39/97_1.png#alt=97%5C_1.png)

> 一个查看react生命周期的[网站](http://projects.wojtekmaj.pl/react-lifecycle-methods-diagram/)



### 5、Serial 与 Parallel GC 之间的不同之处？

Serial 与 Parallel 在 GC 执行的时候都会引起 stop-the-world。它们之间主要不同 serial 收集器是默认的复制收集器，执行 GC 的时候只有一个线程，而parallel 收集器使用多个 GC 线程来执行。


### 6、Java 中如何格式化一个日期？如格式化为 ddMMyyyy 的形式？

[http://javarevisited.blogspot.com/2011/09/convert-date-to-string-simpledateformat.html](http://javarevisited.blogspot.com/2011/09/convert-date-to-string-simpledateformat.html)

Java 中，可以使用 SimpleDateFormat 类或者 joda-time 库来格式日期。DateFormat 类允许你使用多种流行的格式来格式化日期。参见中的示例代码，代码中演示了将日期格式化成不同的格式，如 dd-MM-yyyy 或 ddMMyyyy。


### 7、运行时异常与受检异常有何异同？



异常表示程序运行过程中可能出现的非正常状态，运行时异常表示虚拟机的通常操作中可能遇到的异常，是一种常见运行错误，只要程序设计得没有问题通常就不会发生。受检异常跟程序运行的上下文环境有关，即使程序设计无误，仍然可能因使用的问题而引发。Java编译器要求方法必须声明抛出可能发生的受检异常，但是并不要求必须声明抛出未被捕获的运行时异常。异常和继承一样，是面向对象程序设计中经常被滥用的东西，在_Effective Java_中对异常的使用给出了以下指导原则：

**1、** 不要将异常处理用于正常的控制流（设计良好的API不应该强迫它的调用者为了正常的控制流而使用异常）

**2、** 对可以恢复的情况使用受检异常，对编程错误使用运行时异常

**3、** 避免不必要的使用受检异常（可以通过一些状态检测手段来避免异常的发生）

**4、** 优先使用标准的异常

**5、** 每个方法抛出的异常都要有文档

**6、** 保持异常的原子性

**7、** 不要在catch中忽略掉捕获到的异常


### 8、Java最顶级的父类是哪个？

Object


### 9、集合框架底层数据结构

**Collection**

**List**

**1、** Arraylist： Object数组

**2、** Vector： Object数组

**3、** LinkedList： 双向循环链表

**Set**

**1、** HashSet（无序，唯一）：基于 HashMap 实现的，底层采用 HashMap 来保存元素

**2、** LinkedHashSet： LinkedHashSet 继承与 HashSet，并且其内部是通过 LinkedHashMap 来实现的。有点类似于我们之前说的LinkedHashMap 其内部是基于 Hashmap 实现一样，不过还是有一点点区别的。

**3、** TreeSet（有序，唯一）： 红黑树(自平衡的排序二叉树。)

**Map**

**1、** HashMap： JDK1.8之前HashMap由数组+链表组成的，数组是HashMap的主体，链表则是主要为了解决哈希冲突而存在的（“拉链法”解决冲突）.JDK1.8以后在解决哈希冲突时有了较大的变化，当链表长度大于阈值（默认为8）时，将链表转化为红黑树，以减少搜索时间

**2、** LinkedHashMap：LinkedHashMap 继承自 HashMap，所以它的底层仍然是基于拉链式散列结构即由数组和链表或红黑树组成。另外，LinkedHashMap 在上面结构的基础上，增加了一条双向链表，使得上面的结构可以保持键值对的插入顺序。同时通过对链表进行相应的操作，实现了访问顺序相关逻辑。

**3、** HashTable： 数组+链表组成的，数组是 HashMap 的主体，链表则是主要为了解决哈希冲突而存在的

**4、** TreeMap： 红黑树（自平衡的排序二叉树）


### 10、实例化数组后，能不能改变数组长度呢？

不能，数组一旦实例化，它的长度就是固定的


### 11、创建一个对象用什么运算符？对象实体与对象引用有何不同？
### 12、JVM 选项 -XX:+UseCompressedOops 有什么作用？为什么要使用？
### 13、你是如何调用 wait() 方法的？使用 if 块还是循环？为什么？
### 14、请说出与线程同步以及线程调度相关的方法。
### 15、程序计数器有什么作用？
### 16、并发队列和并发集合的区别：
### 17、如何用Java代码列出一个目录下所有的文件？
### 18、怎么检查一个字符串只包含数字？解决方案
### 19、Java是否需要开发人员回收内存垃圾吗？
### 20、说一下堆内存中对象的分配的基本策略
### 21、ConcurrentHashMap 底层具体实现知道吗？实现原理是什么？
### 22、栈帧里面包含哪些东西？
### 23、为什么要学习设计模式
### 24、在异常捕捉时，如果发生异常，那么try.catch.finally块外的return语句会执行吗？
### 25、常用的集合类有哪些？
### 26、用Java的套接字编程实现一个多线程的回显（echo）服务器。
### 27、在新生代-复制算法
### 28、什么是Java虚拟机？为什么Java被称作是“平台无关的编程语言”？
### 29、如何让正在运行的线程暂停一段时间？
### 30、在不使用 StringBuffer 的前提下，怎么反转一个字符串？
### 31、HashMap 的长度为什么是2的幂次方
### 32、Tomcat是怎么打破双亲委派机制的呢？
### 33、Linux环境下如何查找哪个线程使用CPU最长
### 34、并行和并发有什么区别？
### 35、垃圾回收的优点和原理。说说2种回收机制
### 36、线程之间如何通信及线程之间如何同步
### 37、什么是游标？
### 38、什么是AQS
### 39、Java应用程序与小程序之间有那些差别？
### 40、什么是方法的返回值？返回值在类的方法里的作用是什么？
### 41、什么是 Busy spin？我们为什么要使用它？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
