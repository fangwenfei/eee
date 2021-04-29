# Android最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请描述一下 Intent 和 IntentFilter

```
Intent是组件的通讯使者，可以在组件间传递消息和数据。
IntentFilter是intent的筛选器，可以对intent的action，data，catgory，uri这些属性进行筛选，确定符合的目标组件。
```


### 2、启动一个程序，可以主界面点击图标进入，也可以从一个程序中跳转过去，二者有什么区别？

通过主界面进入，就是设置默认启动的activity。在manifest.xml文件的activity标签中，写以下代码

```
<intent- filter>
<intent android:name=“android.intent.action.MAIN”>
<intent android:name=”android:intent.category.LAUNCHER”>
</intent-filter>
```

从另一个组件跳转到目标activity，需要通过intent进行跳转。具体

```
Intent intent=new Intent(this,activity.class),startActivity(intent)
```


### 3、Serializable 和 Parcelable 的区别？

如果存储在内存中，推荐使用parcelable，使用serialiable在序列化的时候会产生大量的临时变量，会引起频繁的GC

如果存储在硬盘上，推荐使用Serializable，虽然serializable效率较低

Serializable的实现：只需要实现Serializable接口，就会自动生成一个序列化id

Parcelable的实现：需要实现Parcelable接口，还需要Parcelable.CREATER变量


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


### 5、View和SurfaceView的区别

View基于主线程刷新UI，SurfaceView子线程又可以刷新UI


### 6、Fragment 在你们项目中的使用

Fragment 是 android3.0 以后引入的的概念，做局部内容更新更方便，原来为了到达这一点要把多个布局放到一个 activity 里面，现在可以用多 Fragment 来代替，只有在需要的时候才加载Fragment，提高性能。

**Fragment 的好处：**

**1、** Fragment 可以使你能够将 activity 分离成多个可重用的组件，每个都有它自己的生命周期和UI。

**2、** Fragment 可以轻松得创建动态灵活的 UI 设计，可以适应于不同的屏幕尺寸。从手机到平板电脑。

**3、** Fragment 是一个独立的模块,紧紧地与 activity 绑定在一起。可以运行中动态地移除、加入、交换等。

**4、** Fragment 提供一个新的方式让你在不同的安卓设备上统一你的 UI。

**5、** Fragment 解决 Activity 间的切换不流畅，轻量切换。

**6、** Fragment 替代 TabActivity 做导航，性能更好。

**7、** Fragment 在 4.2.版本中新增嵌套 fragment 使用方法，能够生成更好的界面效果。


### 7、为什么Android引入广播机制?

**1、** 从MVC的角度考虑(应用程序内) 其实回答这个问题的时候还可以这样问，android为什么要有那4大组件，现在的移动开发模型基本上也是照搬的web那一套MVC架构，只不过是改了点嫁妆而已。

**2、** android的四大组件本质上就是为了实现移动或者说嵌入式设备上的MVC架构

**3、** 它们之间有时候是一种相互依存的关系，有时候又是一种补充关系，引入广播机制可以方便几大组件的信息和数据交互。

**4、** 程序间互通消息(例如在自己的应用程序内监听系统来电)

**5、** 效率上(参考UDP的广播协议在局域网的方便性)

**6、** 设计模式上(反转控制的一种应用，类似监听者模式)


### 8、请解释下 Android 程序运行时权限与文件系统权限的区别？
### 9、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？
### 10、Android与服务器交互的方式中的对称加密和非对称加密是什么?
### 11、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系
### 12、如果有个100M大的文件，需要上传至服务器中，而服务器form表单最大只能上传2M，可以用什么方法。
### 13、ListView 中图片错位的问题是如何产生的
### 14、横竖屏切换的Activity 生命周期变化？
### 15、Android中的ANR
### 16、说说 LruCache 底层原理
### 17、SQLite支持事务吗?添加删除如何提高性能?
### 18、Android中touch事件的传递机制是怎样的?
### 19、AsyncTask使用在哪些场景？它的缺陷是什么？如何解决？
### 20、Android 线程间通信有哪几种方式（重要）
### 21、View
### 22、如何对 Android 应用进行性能分析
### 23、ListView优化
### 24、android中的动画有哪几类，它们的特点和区别是什么
### 25、什么是 IntentService？有何优点？
### 26、activity，service，intent之间的关系
### 27、DDMS和TraceView的区别?
### 28、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 29、Service 里面可以弹吐司么
### 30、如何修改 Activity 进入和退出动画




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
