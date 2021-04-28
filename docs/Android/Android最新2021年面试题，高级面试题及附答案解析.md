# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Service生命周期

在Service的生命周期里，常用的有：

4个手动调用的方法

```
startService()    启动服务
stopService()    关闭服务
bindService()    绑定服务
unbindService()    解绑服务
```

5个内部自动调用的方法

```
onCreat()            创建服务
onStartCommand()    开始服务
onDestroy()            销毁服务
onBind()            绑定服务
onUnbind()            解绑服务
```

**1、** 手动调用startService()启动服务，自动调用内部方法：onCreate()、onStartCommand()，如果一个Service被startService()多次启动，那么onCreate()也只会调用一次。

**2、** 手动调用stopService()关闭服务，自动调用内部方法：onDestory()，如果一个Service被启动且被绑定，如果在没有解绑的前提下使用stopService()关闭服务是无法停止服务的。

**3、** 手动调用bindService()后，自动调用内部方法：onCreate()、onBind()。

**4、** 手动调用unbindService()后，自动调用内部方法：onUnbind()、onDestory()。

**5、** startService()和stopService()只能开启和关闭Service，无法操作Service，调用者退出后Service仍然存在；bindService()和unbindService()可以操作Service，调用者退出后，Service随着调用者销毁。


### 2、Android 判断SD卡是否存在

首先要在AndroidManifest.xml中增加SD卡访问权限


### 3、内存溢出和内存泄漏有什么区别？何时会产生内存泄漏？

内存溢出：当程序运行时所需的内存大于程序允许的最高内存，这时会出现内存溢出；

内存泄漏：在一些比较消耗资源的操作中，如果操作中内存一直未被释放，就会出现内存泄漏。比如未关闭io,cursor。


### 4、如何在 ScrollView 中如何嵌入 ListView

通常情况下我们不会在 ScrollView 中嵌套 ListView。

在 ScrollView 添加一个 ListView 会导致 listview 控件显示不全，通常只会显示一条，这是因为两个控件的滚动事件冲突导致。所以需要通过 listview 中的 item 数量去计算 listview 的显示高度，从而使其完整展示。

现阶段最好的处理的方式是： 自定义 ListView，重载 onMeasure()方法，设置全部显示。


### 5、事件分发中的 onTouch 和 onTouchEvent 有什么区别，又该如何使用？

这两个方法都是在 View 的 dispatchTouchEvent 中调用的，onTouch 优先于 onTouchEvent执行。如果在 onTouch 方法中通过返回 true 将事件消费掉，onTouchEvent 将不会再执行。

另外需要注意的是，onTouch 能够得到执行需要两个前提条件，第一 mOnTouchListener 的值不能为空，第二当前点击的控件必须是 enable 的。因此如果你有一个控件是非 enable 的，那么给它注册 onTouch 事件将永远得不到执行。对于这一类控件，如果我们想要监听它的 touch 事件，就必须通过在该控件中重写 onTouchEvent 方法来实现。


### 6、Android中常用布局

常用的布局：

```
FrameLayout(帧布局):所有东西依次都放在左上角，会重叠
LinearLayout(线性布局):按照水平和垂直进行数据展示
RelativeLayout(相对布局):以某一个元素为参照物，来定位的布局方式
```

不常用的布局：

```
TableLayout(表格布局): 每一个TableLayout里面有表格行TableRow，TableRow里面可以具体定义每一个元素（Android TV上使用）
AbsoluteLayout(绝对布局):用X,Y坐标来指定元素的位置，元素多就不适用。（机顶盒上使用）
```

新增布局：

```
PercentRelativeLayout（百分比相对布局）可以通过百分比控制控件的大小。
PercentFrameLayout（百分比帧布局）可以通过百分比控制控件的大小。
```


### 7、Intent 传递数据时，可以传递哪些类型数据？

```
基本数据类型以及对应的数组类型
可以传递bundle类型，但是bundle类型的数据需要实现Serializable或者parcelable接口
```


### 8、都使用过哪些自定义控件

**1、** pull2RefreshListView

**2、** LazyViewPager

**3、** SlidingMenu

**4、** SmoothProgressBar

**5、** 自定义组合控件

**6、** ToggleButton

**7、** 自定义Toast


### 9、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？

mvc是model,view,controller的缩写，mvc包含三个部分：

**1、** 模型（model）对象：是应用程序的主体部分，所有的业务逻辑都应该写在该层。

**2、** 视图（view）对象：是应用程序中负责生成用户界面的部分。也是在整个mvc架构中用户唯一可以看到的一层，接收用户的输入，显示处理结果。

**3、** 控制器（control）对象：是根据用户的输入，控制用户界面数据显示及更新model对象状态的部分，控制器更重要的一种导航功能，响应用户出发的相关事件，交给m层处理。

**android鼓励弱耦合和组件的重用，在android中mvc的具体体现如下：**

**1、** 视图层（view）：一般采用xml文件进行界面的描述，使用的时候可以非常方便的引入，当然，如果你对android了解的比较的多了话，就一定可以想到在android中也可以使用JavaScript+html等的方式作为view层，当然这里需要进行java和javascript之间的通信，幸运的是，android提供了它们之间非常方便的通信实现。

**2、** 控制层（controller）：android的控制层的重任通常落在了众多的acitvity的肩上，这句话也就暗含了不要在acitivity中写代码，要通过activity交割model业务逻辑层处理，这样做的另外一个原因是android中的acitivity的响应时间是5s，如果耗时的操作放在这里，程序就很容易被回收掉。

**3、** 模型层（model）：对数据库的操作、对网络等的操作都应该在model里面处理，当然对业务计算等操作也是必须放在的该层的。


### 10、activity与fragment区别

生命周期：

fragment从创建倒销毁整个生命周期依次为onAttach()→onCreate()→onCreateView()→onActivityCreated()→onStart()→onResume()→onPause()→onStop()→onDestroyView()→onDestroy()→onDetach()

**与activity不同的方法有**

**1、** onAttach():当Fragment和Activity建立关联的时候调用；

**2、** onCreateView():当Fragment创建视图调用；

**3、** onActivityCreated:与Fragment相关联的Activity完成onCreate()之后调用；

**4、** onDestoryView():在Fragment中的布局被移除时调用；

**5、** onDetach():当Fragment和Activity解除关联时调用；

**6、** activity常用的生命周期只有以下几个；

**7、** onCreate()： 表示 Activity 正在被创建，常用来 初始化工作，比如调用 setContentView 加载界面布局资源，初始化 Activity 所需数据等；

**8、** onRestart()：表示 Activity 正在重新启动，一般情况下，当前Acitivty 从不可见重新变为可见时，OnRestart就会被调用；

**9、** onStart()： 表示 Activity 正在被启动，此时 Activity 可见但不在前台，还处于后台，无法与用户交互；

**10、** onResume()： 表示 Activity 获得焦点，此时 Activity 可见且在前台并开始活动，这是与 onStart 的区别所在；

**11、** onPause()： 表示 Activity 正在停止，此时可做一些 存储数据、停止动画等工作，但是不能太耗时，因为这会影响到新 Activity的显示，onPause 必须先执行完，新 Activity 的 onResume 才会执行；

**12、** onStop()： 表示 Activity 即将停止，可以做一些稍微重量级的回收工作，比如注销广播接收器、关闭网络连接等，同样不能太耗时；

**13、** onDestroy()： 表示 Activity 即将被销毁，这是 Activity 生命周期中的最后一个回调，常做 回收工作、资源释放；

**14、** 区别：

**15、** Fragment比Activity多出四个回调周期，控制操作上更灵活；

**16、** Fragment可以在xml文件中直接写入，也可以在Activity中动态添加；

**17、** Fragment可以使用show()/hide()或者replace()对Fragment进行切换，切换的时候不会出现明显的效果，Activity切换的时候会有明显的翻页或其他效果；


### 11、Fragment 在你们项目中的使用
### 12、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?
### 13、简述JNI
### 14、请解释下Android程序运行时权限与文件系统权限的区别。
### 15、跟activity和Task 有关的 Intent启动方式有哪些？其含义？
### 16、Android 中的动画有哪几类，它们的特点和区别是什么
### 17、Fragment中add与replace的区别？
### 18、View的分发机制，滑动冲突
### 19、SQLite支持事务吗? 添加删除如何提高性能?
### 20、Android 线程间通信有哪几种方式（重要）
### 21、IntentService有何优点?
### 22、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？
### 23、Android中的ANR
### 24、自定义view的基本流程
### 25、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系
### 26、Service 和 Activity 在同一个线程吗
### 27、ListView 如何定位到指定位置
### 28、广播注册
### 29、Fragment 的 replace 和 add 方法的区别
### 30、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
