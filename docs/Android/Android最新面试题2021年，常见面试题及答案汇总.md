# Android最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、java中如何引用本地语言

可以用JNI（java native interface  java 本地接口）接口 。


### 2、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？

重写onSaveInstanceState()方法，在此方法中保存需要保存的数据，该方法将会在activity被回收之前调用。通过重写onRestoreInstanceState()方法可以从中提取保存好的数据


### 3、什么是 AIDL？如何使用？

aidl 是 Android interface definition Language 的英文缩写，意思 Android 接口定义语言。

使用 aidl 可以帮助我们发布以及调用远程服务，实现跨进程通信。

**1、** 将服务的 aidl 放到对应的 src 目录，工程的 gen 目录会生成相应的接口类

**2、** 我们通过 bindService（Intent，ServiceConnect，int）方法绑定远程服务，在 bindService中 有 一 个 ServiceConnec 接 口 ， 我 们 需 要 覆 写 该 类 的onServiceConnected(ComponentName,IBinder)方法，这个方法的第二个参数 IBinder 对象其实就是已经在 aidl 中定义的接口，因此我们可以将 IBinder 对象强制转换为 aidl 中的接口类。我们通过 IBinder 获取到的对象（也就是 aidl 文件生成的接口）其实是系统产生的代理对象，该代理对象既可以跟我们的进程通信， 又可以跟远程进程通信， 作为一个中间的角色实现了进程间通信。


### 4、什么是 IntentService？有何优点？

IntentService 是 Service 的子类，比普通的 Service 增加了额外的功能。先看 Service 本身存在两个问题：

**1、** Service 不会专门启动一条单独的进程，Service 与它所在应用位于同一个进程中；

**2、** Service 也不是专门一条新线程，因此不应该在 Service 中直接处理耗时的任务；

**IntentService 特征**

**1、** 会创建独立的 worker 线程来处理所有的 Intent 请求；

**2、** 会创建独立的 worker 线程来处理 onHandleIntent()方法实现的代码，无需处理多线程问题；

**3、** 所有请求处理完成后，IntentService 会自动停止，无需调用 stopSelf()方法停止 Service；

**4、** 为 Service 的 onBind()提供默认实现，返回 null；

**5、** 为 Service 的 onStartCommand 提供默认实现，将请求 Intent 添加到队列中；


### 5、如何退出Activity？如何安全退出已调用多个Activity的Application？

对于单一Activity的应用来说，退出很简单，直接finish()即可。当然，也可以用killProcess()和System.exit()这样的方法。

对于多个activity，1、记录打开的Activity：每打开一个Activity，就记录下来。在需要退出时，关闭每一个Activity即可。2、发送特定广播：在需要结束应用时，发送一个特定的广播，每个Activity收到广播后，关闭即可。3、递归退出：在打开新的Activity时使用startActivityForResult，然后自己加标志，在onActivityResult中处理，递归关闭。为了编程方便，最好定义一个Activity基类，处理这些共通问题。

在2.1之前，可以使用ActivityManager的restartPackage方法。

它可以直接结束整个应用。在使用时需要权限android.permission.RESTART_PACKAGES。

注意不要被它的名字迷惑。

可是，在2.2，这个方法失效了。在2.2添加了一个新的方法，killBackground Processes()，需要权限 android.permission.KILL_BACKGROUND_PROCESSES。可惜的是，它和2.2的restartPackage一样，根本起不到应有的效果。

另外还有一个方法，就是系统自带的应用程序管理里，强制结束程序的方法，forceStopPackage()。它需要权限android.permission.FORCE_STOP_PACKAGES。并且需要添加android:sharedUserId="android.uid.system"属性。同样可惜的是，该方法是非公开的，他只能运行在系统进程，第三方程序无法调用。

因为需要在Android.mk中添加LOCAL_CERTIFICATE := platform。

而Android.mk是用于在Android源码下编译程序用的。

从以上可以看出，在2.2，没有办法直接结束一个应用，而只能用自己的办法间接办到。

**现提供几个方法，供参考：**

**1、** 抛异常强制退出：

该方法通过抛异常，使程序Force Close。

验证可以，但是，需要解决的问题是，如何使程序结束掉，而不弹出Force Close的窗口。

**2、** 记录打开的Activity：

每打开一个Activity，就记录下来。在需要退出时，关闭每一个Activity即可。

**3、** 发送特定广播：

在需要结束应用时，发送一个特定的广播，每个Activity收到广播后，关闭即可。

**4、** 递归退出

在打开新的Activity时使用startActivityForResult，然后自己加标志，在onActivityResult中处理，递归关闭。

除了第一个，都是想办法把每一个Activity都结束掉，间接达到目的。但是这样做同样不完美。你会发现，如果自己的应用程序对每一个Activity都设置了nosensor，在两个Activity结束的间隙，sensor可能有效了。但至少，我们的目的达到了，而且没有影响用户使用。为了编程方便，最好定义一个Activity基类，处理这些共通问题。


### 6、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？

在onPuase方法中调用onSavedInstanceState()


### 7、andorid 应用第二次登录实现自动登录

前置条件是所有用户相关接口都走 https，非用户相关列表类数据走 http。

**步骤**

**1、** 第一次登陆 getUserInfo 里带有一个长效 token，该长效 token 用来判断用户是否登陆和换取短 token

**2、** 把长效 token 保存到 SharedPreferences

**3、** 接口请求用长效 token 换取短token，短 token 服务端可以根据你的接口最后一次请求作为标示，超时时间为一天。

**4、** 所有接口都用短效 token

**5、** 如果返回短效 token 失效，执行第3步，再直接当前接口

**6、** 如果长效 token 失效（用户换设备或超过一月），提示用户登录。


### 8、如何对 Android 应用进行性能分析

如果不考虑使用其他第三方性能分析工具的话，我们可以直接使用 ddms 中的工具，其实 ddms 工具已经非常的强大了。ddms 中有 traceview、heap、allocation tracker 等工具都可以帮助我们分析应用的方法执行时间效率和内存使用情况。

Traceview 是 Android 平台特有的数据采集和分析工具，它主要用于分析 Android 中应用程序的 hotspot（瓶颈）。Traceview 本身只是一个数据分析工具，而数据的采集则需要使用 AndroidSDK 中的 Debug 类或者利用 DDMS 工具。

heap 工具可以帮助我们检查代码中是否存在会造成内存泄漏的地方。

allocation tracker 是内存分配跟踪工具


### 9、如何提升Service进程优先级

在AndroidManifest.xml文件中对于intent-filter可以通过android:priority = “1000”这个属性设置最高优先级，1000是最高值，如果数字越小则优先级越低，同时适用于广播。



### 10、横竖屏切换的Activity 生命周期变化？

不设置 Activity 的 android:configChanges 时，切屏会销毁当前Activity，然后重新加载调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次；

onPause()→onStop()→onDestory()→onCreate()→onStart()→onResume()

设置 Activity 的 android:configChanges=" orientation"，经过机型测试

在 Android5.1 即 即 API 3 23 级别下，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次

在 Android9 即 即 API 8 28 级别下，切屏不会重新调用各个生命周期，只会执行 onConfigurationChanged方法

官方纠正后，原话如下

如果您的应用面向 Android 2 3.2 即 即 API 级别 3 13 或更

高级别（按照 minSdkVersion 和 targetSdkVersion)


### 11、请介绍下 AsyncTask 的内部实现和适用的场景
### 12、Android的四大组件是哪些，它们的作用？
### 13、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()
### 14、Fragment 如何实现类似 Activity 栈的压栈和出栈效果的？
### 15、什么是嵌入式实时操作系统, Android 操作系统属于实时操作系统吗?
### 16、Android中任务栈的分配
### 17、属性动画
### 18、Adapter是什么？你所接触过的adapter有那些？
### 19、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。
### 20、Service 里面可以弹吐司么
### 21、Fragment中add与replace的区别？
### 22、什么是IntentService？有何优点？
### 23、请解释下Android程序运行时权限与文件系统权限的区别。
### 24、描述下Handler 机制
### 25、事件分发中的 onTouch 和 onTouchEvent 有什么区别，又该如何使用？
### 26、activity与fragment区别
### 27、请描述一下 Intent 和 IntentFilter
### 28、即时通讯是是怎么做的?
### 29、注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
