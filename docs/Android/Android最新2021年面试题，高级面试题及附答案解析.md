# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Android系统的架构

**1、** Android系统架构之应用程序

Android会同一系列核心应用程序包一起发布，该应用程序包包括email客户端，SMS短消息程序，日历，地图，浏览器，联系人管理程序等。所有的应用程序都是使用JAVA语言编写的。

**2、** Android系统架构之应用程序框架

开发人员可以完全访问核心应用程序所使用的API框架（android.jar）。该应用程序的架构设计简化了组件的重用;任何一个应用程序都可以发布它的功能块并且任何其它的应用程序都可以使用其所发布的功能块。

**3、** Android系统架构之系统运行库

Android 包含一些C/C++库，这些库能被Android系统中不同的组件使用。它们通过 Android 应用程序框架为开发者提供服务。

**4、** Android系统架构之Linux 内核

Android 的核心系统服务依赖于 Linux 2.6 内核，如安全性，内存管理，进程管理， 网络协议栈和驱动模型。 Linux 内核也同时作为硬件和软件栈之间的抽象层。


### 2、GLSurfaceView

基于SurfaceView视图再次进行拓展的视图类，专用于3D游戏开发的视图，是surfaceView的子类，openGL专用


### 3、谈谈你在工作中是怎样解决一个 bug

**1、** 异常附近多打印 log 信息；

**2、** 分析 log 日志，实在不行的话进行断点调试；

**3、** 调试不出结果，上 Stack Overflow 贴上异常信息，请教大牛

**4、** 再多看看代码，或者从源代码中查找相关信息

**5、** 实在不行就 GG 了，找师傅来解决！


### 4、简要解释一下activity、 intent 、intent filter、service、Broadcase、BroadcaseReceiver

一个activity呈现了一个用户可以操作的可视化用户界面；一个service不包含可见的用户界面，而是在后台运行，可以与一个activity绑定，通过绑定暴露出来接口并与其进行通信；一个broadcast receiver是一个接收广播消息并做出回应的component，broadcast receiver没有界面；一个intent是一个Intent对象，它保存了消息的内容。对于activity和service来说，它指定了请求的操作名称和待操作数据的URI，Intent对象可以显式的指定一个目标component。如果这样的话，android会找到这个component(基于manifest文件中的声明)并激活它。但如果一个目标不是显式指定的，android必须找到响应intent的最佳component。它是通过将Intent对象和目标的intent filter相比较来完成这一工作的；一个component的intent filter告诉android该component能处理的intent。intent filter也是在manifest文件中声明的。


### 5、ListView 如何提高其效率？

当 convertView 为空时，用 setTag()方法为每个 View 绑定一个存放控件的 ViewHolder 对象。当convertView 不为空， 重复利用已经创建的 view 的时候， 使用 getTag()方法获取绑定的 ViewHolder对象，这样就避免了 findViewById 对控件的层层查询，而是快速定位到控件。 复用 ConvertView，使用历史的 view，提升效率 200%

自定义静态类 ViewHolder，减少 findViewById 的次数。提升效率 50%

异步加载数据，分页加载数据。

使用 WeakRefrence 引用 ImageView 对象


### 6、了解IntentServices吗?

**1、** IntentService是Service的子类，是一个异步的，会自动停止的服务，很好解决了传统的Service中处理完耗时操作忘记停止并销毁Service的问题

**2、** 生成一个默认的且与线程相互独立的工作线程执行所有发送到onStartCommand()方法的Intent,可以在onHandleIntent()中处理.

**3、** 串行队列,每次只运行一个任务,不存在线程安全问题,所有任务执行完后自动停止服务,不需要自己手动调用stopSelf()来停止.


### 7、andorid 应用第二次登录实现自动登录

前置条件是所有用户相关接口都走 https，非用户相关列表类数据走 http。

**步骤**

**1、** 第一次登陆 getUserInfo 里带有一个长效 token，该长效 token 用来判断用户是否登陆和换取短 token

**2、** 把长效 token 保存到 SharedPreferences

**3、** 接口请求用长效 token 换取短token，短 token 服务端可以根据你的接口最后一次请求作为标示，超时时间为一天。

**4、** 所有接口都用短效 token

**5、** 如果返回短效 token 失效，执行第3步，再直接当前接口

**6、** 如果长效 token 失效（用户换设备或超过一月），提示用户登录。


### 8、什么是aar?aar是jar有什么区别?

“aar”包是 Android 的类库项目的二进制发行包。

文件扩展名是.aar，maven 项目类型应该也是aar，但文件本身是带有以下各项的 zip 文件：

**1、** /AndroidManifest.xml (mandatory)

**2、** /classes.jar (mandatory)

**3、** /res/ (mandatory)

**4、** /R.txt (mandatory)

**5、** /assets/ (optional)

**6、** /libs/*.jar (optional)

**7、** /jni//*.so (optional)

**8、** /proguard.txt (optional)

**9、** /lint.jar (optional)

这些条目是直接位于 zip 文件根目录的。 其中R.txt 文件是aapt带参数–output-text-symbols的输出结果。

jar打包不能包含资源文件，比如一些drawable文件、xml资源文件之类的,aar可以。


### 9、NDK是什么

NDK是一些列工具的集合，NDK提供了一系列的工具，帮助开发者迅速的开发C/C++的动态库，并能自动将so和java 应用打成apk包。

NDK集成了交叉编译器，并提供了相应的mk文件和隔离cpu、平台等的差异，开发人员只需简单的修改mk文件就可以创建出so



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


### 11、怎样对 android 进行优化？
### 12、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布
### 13、自定义view的基本流程
### 14、Android 应用中验证码登陆都有哪些实现方案
### 15、dagger2
### 16、请介绍下Android中常用的五种布局。
### 17、注册广播的几种方法?
### 18、Android 引入广播机制的用意
### 19、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？
### 20、SQLite支持事务吗? 添加删除如何提高性能?
### 21、事件分发中的 onTouch 和 onTouchEvent 有什么区别，又该如何使用？
### 22、描述下Handler 机制
### 23、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。
### 24、什么是 IntentService？有何优点？
### 25、Manifest.xml文件中主要包括哪些信息？
### 26、广播接受者的生命周期？
### 27、音视频相关类
### 28、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?
### 29、如何提升Service进程优先级
### 30、请介绍下 AsyncTask 的内部实现和适用的场景




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
