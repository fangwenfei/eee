# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、IntentService有何优点?

Acitivity的进程，当处理Intent的时候，会产生一个对应的Service； Android的进程处理器现在会尽可能的不kill掉你；非常容易使用


### 2、Manifest.xml文件中主要包括哪些信息？

**1、** manifest：根节点，描述了package中所有的内容。

**2、** uses-permission：请求你的package正常运作所需赋予的安全许可。

**3、** permission： 声明了安全许可来限制哪些程序能你package中的组件和功能。

**4、** instrumentation：声明了用来测试此package或其他package指令组件的代码。

**5、** application：包含package中application级别组件声明的根节点。

**6、** activity：Activity是用来与用户交互的主要工具。

**7、** receiver：IntentReceiver能使的application获得数据的改变或者发生的操作，即使它当前不在运行。

**8、** service：Service是能在后台运行任意时间的组件。

**9、** provider：ContentProvider是用来管理持久化数据并发布给其他应用程序使用的组件。


### 3、谈谈Android的IPC（进程间通信）机制

IPC是内部进程通信的简称， 是共享"命名管道"的资源。Android中的IPC机制是为了让Activity和Service之间可以随时的进行交互，故在Android中该机制，只适用于Activity和Service之间的通信，类似于远程方法调用，类似于C/S模式的访问。通过定义AIDL接口文件来定义IPC接口。Servier端实现IPC接口，Client端调用IPC接口本地代理。


### 4、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？

所有的框架都是基于反射 和 配置文件（manifest）的。

**普通的情况:**

Activity 创建一个 view 是通过 ondraw 画出来的, 画这个 view 之前呢,还会调用 onmeasure方法来计算显示的大小.

**特殊情况：**

Surfaceview 是直接操作硬件的，因为 或者视频播放对帧数有要求，onDraw 效率太低，不够使，Surfaceview 直接把数据写到显存。


### 5、activity在屏幕旋转时的生命周期

不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次；设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次；设置Activity的android:configChanges="orientation|keyboardHidden"时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法


### 6、如何退出Activity

结束当前activity

```
Finish()
killProgress()
System.exit(0)
```

关闭应用程序时，结束所有的activity

可以创建一个List集合，每新创建一个activity，将该activity的实例放进list中，程序结束时，从集合中取出循环取出activity实例，调用finish()方法结束


### 7、Android中activity，context，application有什么不同。

Content与application都继承与contextWrapper，contextWrapper继承于Context类。

Context：表示当前上下文对象，保存的是上下文中的参数和变量，它可以让更加方便访问到一些资源。

Context通常与activity的生命周期是一样的，application表示整个应用程序的对象。

对于一些生命周期较长的，不要使用context，可以使用application。

在activity中，尽量使用静态内部类，不要使用内部类。内部里作为外部类的成员存在，不是独立于activity，如果内存中还有内存继续引用到context，activity如果被销毁，context还不会结束。


### 8、NDK

**1、** NDK是一系列工具集合，NDK提供了一系列的工具，帮助开发者迅速的开发C/C++的动态库，并能自动将so和Java应用打成apk包。

**2、** NDK集成了交叉编译器，并提供了相应的mk文件和隔离cpu、平台等的差异，开发人员只需要简单的修改mk文件就可以创建出so文件。


### 9、wait和 sleep 的区别

wait是Object的方法，wait是对象锁，锁定方法不让继续执行，当执行notify方法后就会继续执行，sleep 是Thread的方法，sleep 是使线程睡眠，让出cpu，结束后自动继续执行


### 10、activity，fragment传值问题

通过Bundle传值，在activty定义变量传值，扩展fragment创建传值


### 11、音视频相关类
### 12、ListView 可以显示多种类型的条目吗
### 13、请解释下 Android 程序运行时权限与文件系统权限的区别？
### 14、消息推送的方式
### 15、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？
### 16、dagger2
### 17、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。
### 18、recyclerView嵌套卡顿解决如何解决
### 19、一条最长的短信息约占多少byte?
### 20、activity，service，intent之间的关系
### 21、Fragment与activity如何传值和交互？
### 22、请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系。
### 23、Android中touch事件的传递机制是怎样的?
### 24、都使用过哪些自定义控件
### 25、View的绘制原理
### 26、谈谈你在工作中是怎样解决一个 bug
### 27、android系统的优势和不足
### 28、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？
### 29、了解IntentServices吗?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
