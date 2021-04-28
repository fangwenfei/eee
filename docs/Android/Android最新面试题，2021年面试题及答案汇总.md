# Android最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Fragment中add与replace的区别？

add不会重新初始化fragment,replace每次都会；

添加相同的fragment时，replace不会有任何变化，add会报IllegalStateException 异常；

replace 先 remove 掉相同 id 的所有 fragment，然后在add 当前的这个 fragment，而 add 是覆盖前一个fragment。所以如果使用 add 一般会伴随 hide()和show()，避免布局重叠；

使用 add，如果应用放在后台，或以其他方式被系统销毁，再打开时，hide()中引用的 fragment 会销毁，所以依然会出现布局重叠 bug，可以使用 replace 或使用 add时，添加一个 tag 参数；


### 2、如何退出Activity？如何安全退出已调用多个Activity的Application？

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


### 3、GLSurfaceView

基于SurfaceView视图再次进行拓展的视图类，专用于3D游戏开发的视图，是surfaceView的子类，openGL专用


### 4、横竖屏切换的Activity 生命周期变化？

不设置 Activity 的 android:configChanges 时，切屏会销毁当前Activity，然后重新加载调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次；

onPause()→onStop()→onDestory()→onCreate()→onStart()→onResume()

设置 Activity 的 android:configChanges=" orientation"，经过机型测试

在 Android5.1 即 即 API 3 23 级别下，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次

在 Android9 即 即 API 8 28 级别下，切屏不会重新调用各个生命周期，只会执行 onConfigurationChanged方法

官方纠正后，原话如下

如果您的应用面向 Android 2 3.2 即 即 API 级别 3 13 或更

高级别（按照 minSdkVersion 和 targetSdkVersion)


### 5、谈谈对Android NDK的理解

NDK是一系列工具的集合.NDK提供了一系列的工具,帮助开发者快速开发C或C++的动态库,并能自动将so和java应用一起打包成apk.这些工具对开发者的帮助是巨大的.NDK集成了交叉编译器,并提供了相应的mk文件隔离CPU,平台,ABI等差异,开发人员只需要简单修改 mk文件(指出"哪些文件需要编译","编译特性要求"等),就可以创建出so.

NDK可以自动地将so和Java应用一起打包,极大地减轻了开发人员的打包工作.NDK提供了一份稳定,功能有限的API头文件声明.

Google明确声明该API是稳定的,在后续所有版本中都稳定支持当前发布的API.从该版本的NDK中看出,这些 API支持的功能非常有限,包含有:C标准库(libc),标准数学库(libm ),压缩库(libz),Log库(liblog).


### 6、如果有个100M大的文件，需要上传至服务器中，而服务器form表单最大只能上传2M，可以用什么方法。

首先来说使用http协议上传数据，特别在android下，跟form没什么关系。

传统的在web中，在form中写文件上传，其实浏览器所做的就是将我们的数据进行解析组拼成字符串，以流的方式发送到服务器，且上传文件用的都是POST方式，POST方式对大小没什么限制。

回到题目，可以说假设每次真的只能上传2M，那么可能我们只能把文件截断，然后分别上传了，断点上传。



### 7、消息推送的方式

**1、** 使用极光和友盟推送。

**2、** 使用XMPP协议（Openfire + Spark + Smack）

**简介：**基于XML协议的通讯协议，前身是Jabber，目前已由IETF国际标准化组织完成了标准化工作。

**优点：**协议成熟、强大、可扩展性强、目前主要应用于许多聊天系统中，且已有开源的Java版的开发实例androidpn。

**缺点：**协议较复杂、冗余（基于XML）、费流量、费电，部署硬件成本高。

**3、** 使用MQTT协议（更多信息见：[mqtt.org/）][mqtt.org]

**简介：**轻量级的、基于代理的“发布/订阅”模式的消息传输协议。

**优点：**协议简洁、小巧、可扩展性强、省流量、省电，目前已经应用到企业领域（参考：[mqtt.org/software），且…][mqtt.org_software]

**缺点：**不够成熟、实现较复杂、服务端组件rsmb不开源，部署硬件成本较高。

**4、** 使用HTTP轮循方式

**简介：**定时向HTTP服务端接口（Web Service API）获取最新消息。

**优点：**实现简单、可控性强，部署硬件成本低。

**缺点：**实时性差。


### 8、Android 中如何捕获未捕获的异常

**UncaughtExceptionHandler**

**1、** 自 定 义 一 个 Application ， 比 如 叫 MyApplication 继 承 Application 实 现UncaughtExceptionHandler。

**2、** 覆写 UncaughtExceptionHandler 的 onCreate 和 uncaughtException 方法。 注意：上面的代码只是简单的将异常打印出来。在 onCreate 方法中我们给 Thread 类设置默认异常处理 handler，如果这句代码不执行则一切都是白搭。在 uncaughtException 方法中我们必须新开辟个线程进行我们异常的收集工作，然后将系统给杀死。

**3、** 在 AndroidManifest 中配置该 Application：<application android:name="com.example.uncatchexception.MyApplication"

Bug 收集工具 Crashlytics

Crashlytics 是专门为移动应用开发者提供的保存和分析应用崩溃的工具。国内主要使用的是友盟做数据统计。

**Crashlytics 的好处：**

**1、** Crashlytics 不会漏掉任何应用崩溃信息。

**2、** Crashlytics 可以象 Bug 管理工具那样，管理这些崩溃日志。

**3、** Crashlytics 可以每天和每周将崩溃信息汇总发到你的邮箱，所有信息一目了然。


### 9、谈MVC ，MVP，MVVM

MVC:View是可以直接访问Model的！从而，View里会包含Model信息，不可避免的还要包括一些 业务逻辑。 在MVC模型里，更关注的Model的不变，而同时有多个对Model的不同显示，及View。所以，在MVC模型里，Model不依赖于View，但是 View是依赖于Model的。不仅如此，因为有一些业务逻辑在View里实现了，导致要更改View也是比较困难的，至少那些业务逻辑是无法重用的。

MVP：MVP 是从经典的模式MVC演变而来，它们的基本思想有相通的地方：Controller/Presenter负责逻辑的处理，Model提供数据，View负 责显示。作为一种新的模式，MVP与MVC有着一个重大的区别：在MVP中View并不直接使用Model，它们之间的通信是通过Presenter (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，而在MVC中View会从直接Model中读取数据而不是通过 Controller。

MVVM：数据双向绑定，通过数据驱动UI，M提供数据，V视图，VM即数据驱动层


### 10、了解IntentServices吗?

**1、** IntentService是Service的子类，是一个异步的，会自动停止的服务，很好解决了传统的Service中处理完耗时操作忘记停止并销毁Service的问题

**2、** 生成一个默认的且与线程相互独立的工作线程执行所有发送到onStartCommand()方法的Intent,可以在onHandleIntent()中处理.

**3、** 串行队列,每次只运行一个任务,不存在线程安全问题,所有任务执行完后自动停止服务,不需要自己手动调用stopSelf()来停止.


### 11、Android 线程间通信有哪几种方式（重要）
### 12、Android与服务器交互的方式中的对称加密和非对称加密是什么?
### 13、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？
### 14、为什么Android引入广播机制?
### 15、说下Activity 的四种启动模式、应用场景 ？
### 16、AsyncTask
### 17、简述TCP，UDP，Socket
### 18、Android的四大组件是哪些，它们的作用？
### 19、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？
### 20、IntentService有何优点?
### 21、Android中的长度单位详解
### 22、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 23、什么是 AIDL？如何使用？
### 24、谈谈Android的IPC（进程间通信）机制
### 25、什么是ANR 如何避免它？
### 26、谈谈你在工作中是怎样解决一个 bug
### 27、recyclerView嵌套卡顿解决如何解决
### 28、如何将打开res aw目录中的数据库文件?
### 29、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
