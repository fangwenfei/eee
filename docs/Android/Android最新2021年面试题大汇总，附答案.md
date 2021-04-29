# Android最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如果Listview中的数据源发生改变，如何更新listview中的数据

使用adapter的notifyDataSetChanged方法


### 2、Android中，帧动画

帧动画是最容易实现的一种动画，这种动画更多的依赖于完善的UI资源，他的原理就是将一张张单独的图片连贯的进行播放，从而在视觉上产生一种动画的效果；有点类似于某些软件制作gif动画的方式。在有些代码中，我们还会看到android：oneshot="false" ，这个oneshot 的含义就是动画执行一次（true）还是循环执行多次。

```
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/a_0"
        android:duration="100" />
    <item
        android:drawable="@drawable/a_1"
        android:duration="100" />
    <item
        android:drawable="@drawable/a_2"
        android:duration="100" />
</animation-list>
```


### 3、跟activity和Task 有关的 Intent启动方式有哪些？其含义？

核心的Intent Flag有

**1、** FLAG_ACTIVITY_NEW_TAS

**2、** FLAG_ACTIVITY_CLEAR_TOP

**3、** FLAG_ACTIVITY_RESET_TASK_IF_NEEDED

**4、** FLAG_ACTIVITY_SINGLE_TO

**5、** FLAG_ACTIVITY_NEW_TAS

如果设置，这个Activity会成为历史stack中一个新Task的开始。一个Task（从启动它的Activity到下一个Task中的 Activity）定义了用户可以迁移的Activity原子组。Task可以移动到前台和后台；在某个特定Task中的所有Activity总是保持相同的次序

这个标志一般用于呈现“启动”类型的行为：它们提供用户一系列可以单独完成的事情，与启动它们的Activity完全无关。

使用这个标志，如果正在启动的Activity的Task已经在运行的话，那么，新的Activity将不会启动；代替的，当前Task会简单的移入前台。参考FLAG_ACTIVITY_MULTIPLE_TASK标志，可以禁用这一行为。

这个标志不能用于调用方对已经启动的Activity请求结果。

**FLAG_ACTIVITY_CLEAR_TOP**

如果设置，并且这个Activity已经在当前的Task中运行，因此，不再是重新启动一个这个Activity的实例，而是在这个Activity上方的所有Activity都将关闭，然后这个Intent会作为一个新的Intent投递到老的Activity（现在位于顶端）中。

例如，假设一个Task中包含这些Activity：A，B，C，D。如果D调用了startActivity()，并且包含一个指向Activity B的Intent，那么，C和D都将结束，然后B接收到这个Intent，因此，目前stack的状况是：A，B。

上例中正在运行的Activity B既可以在onNewIntent()中接收到这个新的Intent，也可以把自己关闭然后重新启动来接收这个Intent。如果它的启动模式声明为 “multiple”(默认值)，并且你没有在这个Intent中设置FLAG_ACTIVITY_SINGLE_TOP标志，那么它将关闭然后重新创建；对于其它的启动模式，或者在这个Intent中设置FLAG_ACTIVITY_SINGLE_TOP标志，都将把这个Intent投递到当前这个实例的onNewIntent()中。

这个启动模式还可以与FLAG_ACTIVITY_NEW_TASK结合起来使用：用于启动一个Task中的根Activity，它会把那个Task中任何运行的实例带入前台，然后清除它直到根Activity。这非常有用，例如，当从Notification Manager处启动一个Activity。

**FLAG_ACTIVITY_RESET_TASK_IF_NEEDED**

如果设置这个标志，这个activity不管是从一个新的栈启动还是从已有栈推到栈顶，它都将以the front door of the task的方式启动。这就讲导致任何与应用相关的栈都讲重置到正常状态（不管是正在讲activity移入还是移除），如果需要，或者直接重置该栈为初始状态。

**FLAG_ACTIVITY_SINGLE_TOP**

如果设置，当这个Activity位于历史stack的顶端运行时，不再启动一个新的

**FLAG_ACTIVITY_BROUGHT_TO_FRONT**

这个标志一般不是由程序代码设置的，如在launchMode中设置singleTask模式时系统帮你设定。

**FLAG_ACTIVITY_CLEAR_WHEN_TASK_RESET**

如果设置，这将在Task的Activity stack中设置一个还原点，当Task恢复时，需要清理Activity。也就是说，下一次Task带着 FLAG_ACTIVITY_RESET_TASK_IF_NEEDED标记进入前台时（典型的操作是用户在主画面重启它），这个Activity和它之上的都将关闭，以至于用户不能再返回到它们，但是可以回到之前的Activity。

这在你的程序有分割点的时候很有用。例如，一个e-mail应用程序可能有一个操作是查看一个附件，需要启动图片浏览Activity来显示。这个 Activity应该作为e-mail应用程序Task的一部分，因为这是用户在这个Task中触发的操作。然而，当用户离开这个Task，然后从主画面选择e-mail app，我们可能希望回到查看的会话中，但不是查看图片附件，因为这让人困惑。通过在启动图片浏览时设定这个标志，浏览及其它启动的Activity在下次用户返回到mail程序时都将全部清除。

**FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS**

如果设置，新的Activity不会在最近启动的Activity的列表中保存。

**FLAG_ACTIVITY_FORWARD_RESULT**

如果设置，并且这个Intent用于从一个存在的Activity启动一个新的Activity，那么，这个作为答复目标的Activity将会传到这个新的Activity中。这种方式下，新的Activity可以调用setResult(int)，并且这个结果值将发送给那个作为答复目标的 Activity。

**FLAG_ACTIVITY_LAUNCHED_FROM_HISTORY**

这个标志一般不由应用程序代码设置，如果这个Activity是从历史记录里启动的（常按HOME键），那么，系统会帮你设定。

**FLAG_ACTIVITY_MULTIPLE_TASK**

不要使用这个标志，除非你自己实现了应用程序启动器。与FLAG_ACTIVITY_NEW_TASK结合起来使用，可以禁用把已存的Task送入前台的行为。当设置时，新的Task总是会启动来处理Intent，而不管这是是否已经有一个Task可以处理相同的事情。

由于默认的系统不包含图形Task管理功能，因此，你不应该使用这个标志，除非你提供给用户一种方式可以返回到已经启动的Task。

如果FLAG_ACTIVITY_NEW_TASK标志没有设置，这个标志被忽略。

**FLAG_ACTIVITY_NO_ANIMATION**

如果在Intent中设置，并传递给Context.startActivity()的话，这个标志将阻止系统进入下一个Activity时应用 Acitivity迁移动画。这并不意味着动画将永不运行——如果另一个Activity在启动显示之前，没有指定这个标志，那么，动画将被应用。这个标志可以很好的用于执行一连串的操作，而动画被看作是更高一级的事件的驱动。

**FLAG_ACTIVITY_NO_HISTORY**

如果设置，新的Activity将不再历史stack中保留。用户一离开它，这个Activity就关闭了。这也可以通过设置noHistory特性。

**FLAG_ACTIVITY_NO_USER_ACTION**

如果设置，作为新启动的Activity进入前台时，这个标志将在Activity暂停之前阻止从最前方的Activity回调的onUserLeaveHint()。

典型的，一个Activity可以依赖这个回调指明显式的用户动作引起的Activity移出后台。这个回调在Activity的生命周期中标记一个合适的点，并关闭一些Notification。

如果一个Activity通过非用户驱动的事件，如来电或闹钟，启动的，这个标志也应该传递给Context.startActivity，保证暂停的Activity不认为用户已经知晓其Notification。

**FLAG_ACTIVITY_PREVIOUS_IS_TOP**

If set and this intent is being used to launch a new activity from an existing one, the current activity will not be counted as the top activity for deciding whether the new intent should be delivered to the top instead of starting a new one、The previous activity will be used as the top, with the assumption being that the current activity will finish itself immediately.

**FLAG_ACTIVITY_REORDER_TO_FRONT**

如果在Intent中设置，并传递给Context.startActivity()，这个标志将引发已经运行的Activity移动到历史stack的顶端。

例如，假设一个Task由四个Activity组成：A,B,C,D。如果D调用startActivity()来启动Activity B，那么，B会移动到历史stack的顶端，现在的次序变成A,C,D,B。如果FLAG_ACTIVITY_CLEAR_TOP标志也设置的话，那么这个标志将被忽略。


### 4、ListView 如何定位到指定位置

可以通过 ListView 提供的 lv.setSelection(listView.getPosition())方法。



### 5、请解释下Android程序运行时权限与文件系统权限的区别。

运行时权限Dalvik( android授权)

文件系统 linux 内核授权


### 6、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？

**程序出现异常，比如nullpointer。**

避免：编写程序时逻辑连贯，思维缜密。能捕获异常，在logcat中能看到异常信息


### 7、Android中activity，context，application有什么不同。

Content与application都继承与contextWrapper，contextWrapper继承于Context类。

Context：表示当前上下文对象，保存的是上下文中的参数和变量，它可以让更加方便访问到一些资源。

Context通常与activity的生命周期是一样的，application表示整个应用程序的对象。

对于一些生命周期较长的，不要使用context，可以使用application。

在activity中，尽量使用静态内部类，不要使用内部类。内部里作为外部类的成员存在，不是独立于activity，如果内存中还有内存继续引用到context，activity如果被销毁，context还不会结束。


### 8、Android的四大组件是哪些，它们的作用？

****

**1、** Activity：Activity是Android程序与用户交互的窗口，是Android构造块中最基本的一种，它需要为保持各界面的状态，做很多持久化的事情，妥善管理生命周期以及一些跳转逻辑

**2、** service：后台服务于Activity，封装有一个完整的功能逻辑实现，接受上层指令，完成相关的事物，定义好需要接受的Intent提供同步和异步的接口

**3、** Content Provider：是Android提供的第三方应用数据的访问方案，可以派生Content Provider类，对外提供数据，可以像数据库一样进行选择排序，屏蔽内部数据的存储细节，向外提供统一的借口模型，大大简化上层应用，对数据的整合提供了更方便的途径

**4、** BroadCast Receiver：接受一种或者多种Intent作触发事件，接受相关消息，做一些简单处理，转换成一条Notification，统一了Android的事件广播模型


### 9、Android dvm的进程和Linux的进程, 应用程序的进程是否为同一个概念

DVM指dalivk的虚拟机。每一个Android应用程序都在它自己的进程中运行，都拥有一个独立的Dalvik虚拟机实例。而每一个DVM都是在Linux 中的一个进程，所以说可以认为是同一个概念。


### 10、Android数字签名

**1、** 所有的应用程序都必须有数字证书，Android系统不会安装一个没有数字证书的应用程序

**2、** Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证

**3、** 如果要正式发布一个Android ，必须使用一个合适的私钥生成的数字证书来给程序签名。

**4、** 数字证书都是有有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能。


### 11、Android i18n
### 12、jni 的调用过程?
### 13、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？
### 14、Fragment的生命周期
### 15、请介绍下 ContentProvider 是如何实现数据共享的
### 16、java中如何引用本地语言
### 17、Serializable 和 Parcelable 的区别？
### 18、请介绍下Android的数据存储方式。
### 19、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？
### 20、String,StringBuffer,StringBuilder的区别
### 21、如何将一个Activity设置成窗口的样式。
### 22、启动一个程序，可以主界面点击图标进入，也可以从一个程序中跳转过去，二者有什么区别？
### 23、请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系。
### 24、View的分发机制，滑动冲突
### 25、AIDL的全称是什么？如何工作？能处理哪些类型的数据？
### 26、属性动画
### 27、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 28、简述JNI
### 29、Android 中的动画有哪几类，它们的特点和区别是什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
