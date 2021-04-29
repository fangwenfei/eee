# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、android中的动画有哪几类，它们的特点和区别是什么

两种，一种是Tween动画、还有一种是Frame动画。Tween动画，这种实现方式可以使视图组件移动、放大、缩小以及产生透明度的变化;另一种Frame动画，传统的动画方法，通过顺序的播放排列好的图片来实现，类似电影。


### 2、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？

mvc是model,view,controller的缩写，mvc包含三个部分：

**1、** 模型（model）对象：是应用程序的主体部分，所有的业务逻辑都应该写在该层。

**2、** 视图（view）对象：是应用程序中负责生成用户界面的部分。也是在整个mvc架构中用户唯一可以看到的一层，接收用户的输入，显示处理结果。

**3、** 控制器（control）对象：是根据用户的输入，控制用户界面数据显示及更新model对象状态的部分，控制器更重要的一种导航功能，响应用户出发的相关事件，交给m层处理。

**android鼓励弱耦合和组件的重用，在android中mvc的具体体现如下：**

**1、** 视图层（view）：一般采用xml文件进行界面的描述，使用的时候可以非常方便的引入，当然，如果你对android了解的比较的多了话，就一定可以想到在android中也可以使用JavaScript+html等的方式作为view层，当然这里需要进行java和javascript之间的通信，幸运的是，android提供了它们之间非常方便的通信实现。

**2、** 控制层（controller）：android的控制层的重任通常落在了众多的acitvity的肩上，这句话也就暗含了不要在acitivity中写代码，要通过activity交割model业务逻辑层处理，这样做的另外一个原因是android中的acitivity的响应时间是5s，如果耗时的操作放在这里，程序就很容易被回收掉。

**3、** 模型层（model）：对数据库的操作、对网络等的操作都应该在model里面处理，当然对业务计算等操作也是必须放在的该层的。


### 3、DDMS和TraceView的区别?

DDMS是一个程序执行查看器，在里面可以看见线程和堆栈等信息，TraceView是程序性能分析器 。


### 4、广播注册

首先写一个类要继承BroadCastReceiver

第一种：在清单文件中声明，添加

```
<receive android:name=".BroadCastReceiverDemo">
<intent-filter>
<action android:name="android.provider.Telephony.SMS_RECEIVED">
</intent-filter>
</receiver>
```

第二种：使用代码进行注册如：

```
IntentFilter filter = new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
BroadCastReceiverDemo receiver = new BroadCastReceiver();
registerReceiver(receiver, filter);
```

两种注册类型的区别是：

a.第一种是常驻型广播，也就是说当应用程序关闭后，如果有信息广播来，程序也会被系统调用自动运行。

b.第二种不是常驻广播，也就是说广播跟随程序的生命周期。


### 5、什么是嵌入式实时操作系统, Android 操作系统属于实时操作系统吗?

嵌入式实时操作系统是指当外界事件或数据产生时，能够接受并以足够快的速度予以处理，其处理的结果又能在规定的时间之内来控制生产过程或对处理系统作出快速响应，并控制所有实时任务协调一致运行的嵌入式操作系统。主要用于工业控制、 军事设备、 航空航天等领域对系统的响应时间有苛刻的要求，这就需要使用实时系统。又可分为软实时和硬实时两种，而android是基于linux内核的，因此属于软实时。


### 6、如何切换 fragement,不重新实例化

翻看了 Android 官方 Doc，和一些组件的源代码，发现 replace()这个方法只是在上一个 Fragment不再需要时采用的简便方法.

正确的切换方式是 add()，切换时 hide()，add()另一个 Fragment；再次切换时，只需 hide()当前，show()另一个。

这样就能做到多个 Fragment 切换不重新实例化：


### 7、简要解释一下activity、 intent 、intent filter、service、Broadcase、BroadcaseReceiver

一个activity呈现了一个用户可以操作的可视化用户界面；一个service不包含可见的用户界面，而是在后台运行，可以与一个activity绑定，通过绑定暴露出来接口并与其进行通信；一个broadcast receiver是一个接收广播消息并做出回应的component，broadcast receiver没有界面；一个intent是一个Intent对象，它保存了消息的内容。对于activity和service来说，它指定了请求的操作名称和待操作数据的URI，Intent对象可以显式的指定一个目标component。如果这样的话，android会找到这个component(基于manifest文件中的声明)并激活它。但如果一个目标不是显式指定的，android必须找到响应intent的最佳component。它是通过将Intent对象和目标的intent filter相比较来完成这一工作的；一个component的intent filter告诉android该component能处理的intent。intent filter也是在manifest文件中声明的。


### 8、ListView优化

**1、** convertView重用，利用好 convertView 来重用 View，切忌每次 getView() 都新建。ListView 的核心原理就是重用 View，如果重用 view 不改变宽高，重用View可以减少重新分配缓存造成的内存频繁分配/回收;

**2、** ViewHolder优化，使用ViewHolder的原因是findViewById方法耗时较大，如果控件个数过多，会严重影响性能，而使用ViewHolder主要是为了可以省去这个时间。通过setTag，getTag直接获取View。

**3、** 减少Item View的布局层级，这是所有layout都必须遵循的，布局层级过深会直接导致View的测量与绘制浪费大量的时间。

**4、** adapter中的getView方法尽量少使用逻辑

**5、** 图片加载采用三级缓存，避免每次都要重新加载。

**6、** 尝试开启硬件加速来使ListView的滑动更加流畅。

**7、** 使用 RecycleView 代替。


### 9、Android中touch事件的传递机制是怎样的?

**1、** Touch事件传递的相关API有dispatchTouchEvent、onTouchEvent、onInterceptTouchEvent

**2、** Touch事件相关的类有View、ViewGroup、Activity

**3、** Touch事件会被封装成MotionEvent对象，该对象封装了手势按下、移动、松开等动作

**4、** Touch事件通常从Activity#dispatchTouchEvent发出，只要没有被消费，会一直往下传递，到最底层的View。

**5、** 如果Touch事件传递到的每个View都不消费事件，那么Touch事件会反向向上传递,最终交由Activity#onTouchEvent处理、

**6、** onInterceptTouchEvent为ViewGroup特有，可以拦截事件、

**7、** Down事件到来时，如果一个View没有消费该事件，那么后续的MOVE/UP事件都不会再给它


### 10、Android dvm的进程和Linux的进程, 应用程序的进程是否为同一个概念

DVM指dalivk的虚拟机。每一个Android应用程序都在它自己的进程中运行，都拥有一个独立的Dalvik虚拟机实例。而每一个DVM都是在Linux 中的一个进程，所以说可以认为是同一个概念。


### 11、recyclerView嵌套卡顿解决如何解决
### 12、jni 的调用过程?
### 13、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?
### 14、Android中的ANR
### 15、如何对 Android 应用进行性能分析
### 16、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？
### 17、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？
### 18、说下 Activity 跟 跟 window ， view 之间的关系？
### 19、为什么Android引入广播机制?
### 20、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 21、注册广播的几种方法?
### 22、andorid 应用第二次登录实现自动登录
### 23、你一般在开发项目中都使用什么设计模式？如何来重构，优化你的代码？
### 24、AsyncTask使用在哪些场景？它的缺陷是什么？如何解决？
### 25、SQLite支持事务吗?添加删除如何提高性能?
### 26、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。
### 27、嵌入式操作系统内存管理有哪几种， 各有何特性
### 28、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？
### 29、属性动画




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
