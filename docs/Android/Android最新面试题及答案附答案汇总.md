# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、ListView 中图片错位的问题是如何产生的

图片错位问题的本质源于我们的 listview 使用了缓存 convertView， 假设一种场景， 一个 listview一屏显示九个 item，那么在拉出第十个 item 的时候，事实上该 item 是重复使用了第一个 item，也就是说在第一个 item 从网络中下载图片并最终要显示的时候，其实该 item 已经不在当前显示区域内了，此时显示的后果将可能在第十个 item 上输出图像，这就导致了图片错位的问题。所以解决办法就是可见则显示，不可见则不显示。


### 2、Android本身的api并未声明会抛出异常，则其在运行时有无可能抛出runtime异常，你遇到过吗？诺有的话会导致什么问题？如何解决？

会，比如nullpointerException。我遇到过，比如textview.setText()时，textview没有初始化。会导致程序无法正常运行出现forceclose。打开控制台查看logcat信息找出异常信息并修改程序。


### 3、请介绍下Android中常用的五种布局。

常用五种布局方式，分别是：FrameLayout（框架布局），LinearLayout （线性布局），AbsoluteLayout（绝对布局），RelativeLayout（相对布局），TableLayout（表格布局）。

**1、** FrameLayout：所有东西依次都放在左上角，会重叠，这个布局比较简单，也只能放一点比较简单的东西。

**2、** LinearLayout：线性布局，每一个LinearLayout里面又可分为垂直布局（android:orientation="vertical"）和水平布局（android:orientation="horizontal" ）。当垂直布局时，每一行就只有一个元素，多个元素依次垂直往下；水平布局时，只有一行，每一个元素依次向右排列。

**3、** AbsoluteLayout：绝对布局用X,Y坐标来指定元素的位置，这种布局方式也比较简单，但是在屏幕旋转时，往往会出问题，而且多个元素的时候，计算比较麻烦。

**4、** RelativeLayout：相对布局可以理解为某一个元素为参照物，来定位的布局方式。主要属性有：相对于某一个元素android:layout_below、      android:layout_toLeftOf相对于父元素的地方android:layout_alignParentLeft、android:layout_alignParentRigh；

**5、** TableLayout：表格布局，每一个TableLayout里面有表格行TableRow，TableRow里面可以具体定义每一个元素。每一个布局都有自己适合的方式，这五个布局元素可以相互嵌套应用，做出美观的界面。


### 4、子线程中能不能 new handler？为什么？

不能,如果在子线程中直接 new Handler()会抛出异常 java.lang.RuntimeException: Can'tcreate handler inside thread that has not called

在没有调用 Looper.prepare()的时候不能创建 Handler,因为在创建 Handler 的源码中做了如下操作

Handler 的构造方法中


### 5、Android中的ANR

ANR的全称application not responding 应用程序未响应。

```
在android中Activity的最长执行时间是5秒。
BroadcastReceiver的最长执行时间则是10秒。
Service的最长执行时间则是20秒。
```

超出执行时间就会产生ANR。注意：ANR是系统抛出的异常，程序是捕捉不了这个异常的。

解决方法:

**1、** 运行在主线程里的任何方法都尽可能少做事情。特别是，Activity应该在它的关键生命周期方法 （如onCreate()和onResume()）里尽可能少的去做创建操作。（可以采用重新开启子线程的方式，然后使用Handler+Message 的方式做一些操作，比如更新主线程中的ui等）

**2、** 应用程序应该避免在BroadcastReceiver里做耗时的操作或计算。但不再是在子线程里做这些任务（因为 BroadcastReceiver的生命周期短），替代的是，如果响应Intent广播需要执行一个耗时的动作的话，应用程序应该启动一个 Service。


### 6、让Activity变成一个窗口

设置activity的style属性=”@android:style/Theme.Dialog”


### 7、dagger2

Dagger2是一个主要用于依赖注入的框架，减少初始化对象操作，降低耦合度


### 8、activity，fragment传值问题

通过Bundle传值，在activty定义变量传值，扩展fragment创建传值


### 9、Service 里面可以弹吐司么

可以。


### 10、开发中都使用过哪些框架、平台

**1、** EventBus（事件处理）

**2、** xUtils（网络、图片、ORM）

**3、** JPush（推送平台）

**4、** 友盟（统计平台）

**5、** 有米（优米）（广告平台）

**6、** 百度地图

**7、** bmob（服务器平台、短信验证、邮箱验证、第三方支付）

**8、** 阿里云 OSS（云存储）

**9、** ShareSDK（分享平台、第三方登录）

**10、** Gson（解析 json 数据框架）

**11、** imageLoader （图片处理框架）

**12、** zxing （二维码扫描）

**13、** anroid-asyn-http（网络通讯）

**14、** DiskLruCache(硬盘缓存框架)

**15、** Viatimo（多媒体播放框架）

**16、** universal-image-loader(图片缓存框架)

**17、** 讯飞语音（语音识别）


### 11、sim卡的EF 文件有何作用
### 12、请介绍下ContentProvider是如何实现数据共享的。
### 13、什么是 IntentService？有何优点？
### 14、请解释下Android程序运行时权限与文件系统权限的区别。
### 15、请介绍下 ContentProvider 是如何实现数据共享的
### 16、注册广播的几种方法?
### 17、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？
### 18、Hander原理
### 19、Service 和 Activity 在同一个线程吗
### 20、Android i18n
### 21、跨进程通信的几种方式
### 22、activity的启动模式有哪些？是什么含义
### 23、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。
### 24、android中的动画有哪几类，它们的特点和区别是什么
### 25、Fragment 如何实现类似 Activity 栈的压栈和出栈效果的？
### 26、嵌入式操作系统内存管理有哪几种， 各有何特性
### 27、如何保存activity的状态？
### 28、wait和 sleep 的区别
### 29、描述一下android的系统架构




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
