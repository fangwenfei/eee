# Android最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、简述TCP，UDP，Socket

TCP是经过3次握手，4次挥手完成一串数据的传送

UDP是无连接的，知道IP地址和端口号，向其发送数据即可，不管数据是否发送成功

Socket是一种不同计算机，实时连接，比如说传送文件，即时通讯


### 2、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？

补间动画只是显示的位置变动，View 的实际位置未改变，表现为 View 移动到其他地方，点击事件仍在原处才能响应。而属性动画控件移动后事件相应就在控件移动后本身进行处理


### 3、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()

Bitmap 是 android 中经常使用的一个类，它代表了一个图片资源。 Bitmap 消耗内存很严重，如果不注意优化代码，经常会出现 OOM 问题，优化方式通常有这么几种：

**1、** 使用缓存；

**2、** 压缩图片；

**3、** 及时回收；

至于什么时候需要手动调用 recycle，这就看具体场景了，原则是当我们不再使用 Bitmap 时，需要回收之。另外，我们需要注意，2.3 之前 Bitmap 对象与像素数据是分开存放的，Bitmap 对象存在java Heap 中而像素数据存放在 Native Memory 中， 这时很有必要调用 recycle 回收内存。 但是 2.3之后，Bitmap 对象和像素数据都是存在 Heap 中，GC 可以回收其内存。


### 4、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。

通过直接发送Uri把参数带过去，或者通过manifest里的intentfilter里的data属性


### 5、RecyclerView和ListView的区别

缓存上:前者缓存的是View+ViewHolder+flag，不用每次调用findViewById,后者则只是缓存View

刷新数据方面，前者提供了局部刷新，后者则全部刷新


### 6、java中如何引用本地语言

可以用JNI（java native interface  java 本地接口）接口 。


### 7、请描述下Activity的生命周期。

activity的生命周期方法有：onCreate()、onStart()、onReStart()、onResume()、onPause()、onStop()、onDestory()；

可见生命周期：从onStart()直到系统调用onStop()

前台生命周期：从onResume()直到系统调用onPause()


### 8、activity，service，intent之间的关系

这三个都是android应用频率非常的组件。Activity与service是四大核心组件。Activity用来加载布局，显示窗口界面，service运行后台，没有界面显示，intent是activity与service的通信使者。


### 9、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

把这个文件放在/res/raw目录下即可。res\raw目录中的文件不会被压缩，这样可以直接提取该目录中的文件，会生成资源id。


### 10、补间动画

补间动画又可以分为四种形式，分别是 alpha（淡入淡出），translate（位移），scale（缩放大小），rotate（旋转）。

补间动画的实现，一般会采用xml 文件的形式；代码会更容易书写和阅读，同时也更容易复用。Interpolator 主要作用是可以控制动画的变化速率 ，就是动画进行的快慢节奏。pivot 决定了当前动画执行的参考位置

```
<?xml version="1.0" encoding="utf-8"?>
<set xmlns:android="http://schemas.android.com/apk/res/android"
    android:interpolator="@[package:]anim/interpolator_resource"
    android:shareInterpolator=["true" | "false"] >
    <alpha
        android:fromAlpha="float"
        android:toAlpha="float" />
    <scale
        android:fromXScale="float"
        android:toXScale="float"
        android:fromYScale="float"
        android:toYScale="float"
        android:pivotX="float"
        android:pivotY="float" />
    <translate
        android:fromXDelta="float"
        android:toXDelta="float"
        android:fromYDelta="float"
        android:toYDelta="float" />
    <rotate
        android:fromDegrees="float"
        android:toDegrees="float"
        android:pivotX="float"
        android:pivotY="float" />
    <set>
        ...
    </set>
</set>
```


### 11、Adapter是什么？你所接触过的adapter有那些？
### 12、谈谈对Android NDK的理解
### 13、Android 中如何捕获未捕获的异常
### 14、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？
### 15、android:gravity与android:layout_gravity的区别
### 16、SurfaceView
### 17、请介绍下 AsyncTask 的内部实现和适用的场景
### 18、Service 里面可以弹吐司么
### 19、开发中都使用过哪些框架、平台
### 20、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。
### 21、请介绍下ContentProvider是如何实现数据共享的。
### 22、dagger2
### 23、NDK是什么
### 24、推送到达率如何提高
### 25、String,StringBuffer,StringBuilder的区别
### 26、说下Activity 的四种启动模式、应用场景 ？
### 27、什么是IntentService？有何优点？
### 28、如何启用Service，如何停用Service。
### 29、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
