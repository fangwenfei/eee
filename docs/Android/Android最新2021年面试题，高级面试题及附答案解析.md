# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、ContentProvider与sqlite有什么不一样的？

```
ContentProvider会对外隐藏内部实现，只需要关注访问contentProvider的uri即可，contentProvider应用在应用间共享。
Sqlite操作本应用程序的数据库。
ContentProiver可以对本地文件进行增删改查操作
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


### 3、ListView 中图片错位的问题是如何产生的

图片错位问题的本质源于我们的 listview 使用了缓存 convertView， 假设一种场景， 一个 listview一屏显示九个 item，那么在拉出第十个 item 的时候，事实上该 item 是重复使用了第一个 item，也就是说在第一个 item 从网络中下载图片并最终要显示的时候，其实该 item 已经不在当前显示区域内了，此时显示的后果将可能在第十个 item 上输出图像，这就导致了图片错位的问题。所以解决办法就是可见则显示，不可见则不显示。


### 4、sim卡的EF文件是什么？有何作用

sim卡的文件系统有自己规范，主要是为了和手机通讯，sim本 身可以有自己的操作系统，EF就是作存储并和手机通讯用的


### 5、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？

在两个应用的manifest配置中好相同的shartdUserId属性，A应用正常保存数据，B应用

createPackageContext("com.netease.nim.demo", CONTEXT_IGNORE_SECURITY)

获取context然后获取应用数据，为保证数据安全，使用加密存储


### 6、谈谈Android的IPC（进程间通信）机制

IPC是内部进程通信的简称， 是共享"命名管道"的资源。Android中的IPC机制是为了让Activity和Service之间可以随时的进行交互，故在Android中该机制，只适用于Activity和Service之间的通信，类似于远程方法调用，类似于C/S模式的访问。通过定义AIDL接口文件来定义IPC接口。Servier端实现IPC接口，Client端调用IPC接口本地代理。


### 7、java中如何引用本地语言

可以用JNI（java native interface  java 本地接口）接口 。


### 8、Android中4大组件

**1、** Activity：Activity是Android程序与用户交互的窗口，是Android构造块中最基本的一种，它需要为保持各界面的状态，做很多持久化的事情，妥善管理生命周期以及一些跳转逻辑。

**2、** BroadCast Receiver：接受一种或者多种Intent作触发事件，接受相关消息，做一些简单处理，转换成一条Notification，统一了Android的事件广播模型。

**3、** Content Provider：是Android提供的第三方应用数据的访问方案，可以派生Content Provider类，对外提供数据，可以像数据库一样进行选择排序，屏蔽内部数据的存储细节，向外提供统一的接口模型，大大简化上层应用，对数据的整合提 供了更方便的途径。

**4、** service：后台服务于Activity，封装有一个完整的功能逻辑实现，接受上层指令，完成相关的事务，定义好需要接受的Intent提供同步和异步的接口。


### 9、Android 判断SD卡是否存在

首先要在AndroidManifest.xml中增加SD卡访问权限


### 10、Android 中如何捕获未捕获的异常

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


### 11、嵌入式操作系统内存管理有哪几种， 各有何特性
### 12、String,StringBuffer,StringBuilder的区别
### 13、Android中activity，context，application有什么不同。
### 14、跟activity和Task 有关的 Intent启动方式有哪些？其含义？
### 15、dagger2
### 16、View和SurfaceView的区别
### 17、在 service 的生命周期方法 onstartConmand()可不可以执行网络操作？如何在 service 中执行网络操作？
### 18、activity在屏幕旋转时的生命周期
### 19、Android 应用中验证码登陆都有哪些实现方案
### 20、谈MVC ，MVP，MVVM
### 21、AIDL的全称是什么？如何工作？能处理哪些类型的数据？
### 22、描述下Handler 机制
### 23、内存泄露如何查看和解决
### 24、请解释下 Android 程序运行时权限与文件系统权限的区别？
### 25、Activity启动模式
### 26、Android中的长度单位详解
### 27、为什么Android引入广播机制?
### 28、自定义view的基本流程
### 29、内存溢出和内存泄漏有什么区别？何时会产生内存泄漏？
### 30、音视频相关类




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
