# Android最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系

```
ContentProvider：内容提供者，对外提供数据的操作，contentProvider.notifyChanged(uir)：可以更新数据
contentResolver：内容解析者，解析ContentProvider返回的数据
ContentObServer:内容监听者，监听数据的改变，contentResolver.registerContentObServer()
```


### 2、Android中常用布局

常用的布局：

```
FrameLayout(帧布局):所有东西依次都放在左上角，会重叠
LinearLayout(线性布局):按照水平和垂直进行数据展示
RelativeLayout(相对布局):以某一个元素为参照物，来定位的布局方式
```

不常用的布局：

```
TableLayout(表格布局): 每一个TableLayout里面有表格行TableRow，TableRow里面可以具体定义每一个元素（Android TV上使用）
AbsoluteLayout(绝对布局):用X,Y坐标来指定元素的位置，元素多就不适用。（机顶盒上使用）
```

新增布局：

```
PercentRelativeLayout（百分比相对布局）可以通过百分比控制控件的大小。
PercentFrameLayout（百分比帧布局）可以通过百分比控制控件的大小。
```


### 3、AIDL 的全称是什么?如何工作?能处理哪些类型的数据？

AIDL 全称 Android Interface Definition Language（AndRoid 接口描述语言） 是一种接口描述语言; 编译器可以通过 aidl 文件生成一段代码，通过预先定义的接口达到两个进程内部通信进程跨界对象访问的目的。需要完成两件事情：

**1、** 引入 AIDL 的相关类.;

**2、** 调用 aidl 产生的 class

理论上, 参数可以传递基本数据类型和 String, 还有就是 Bundle 的派生类, 不过在 Eclipse 中,目前的 ADT 不支持 Bundle 做为参数。


### 4、jni 的调用过程?

**1、** 安装和下载 Cygwin，下载 Android NDK。

**2、** ndk 项目中 JNI 接口的设计。

**3、** 使用 C/C++实现本地方法。

**4、** JNI 生成动态链接库.so 文件。

**5、** 将动态链接库复制到 java 工程，在 java 工程中调用，运行 java 工程即可。


### 5、Service 和 Activity 在同一个线程吗

默认情况下service与activity在同一个线程，都在main Thread，或者ui线程中。

如果在清单文件中指定service的process属性，那么service就在另一个进程中运行。


### 6、activity，fragment传值问题

通过Bundle传值，在activty定义变量传值，扩展fragment创建传值


### 7、开发中都使用过哪些框架、平台

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


### 8、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？

**程序出现异常，比如nullpointer。**

避免：编写程序时逻辑连贯，思维缜密。能捕获异常，在logcat中能看到异常信息


### 9、View的绘制原理

View为所有图形控件的基类，View的绘制由3个函数完成

measure,计算视图的大小

layout,提供视图要显示的位置

draw,绘制


### 10、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。

XML解析主要有三种方式，SAX、DOM、PULL。常规在PC上开发我们使用Dom相对轻松些，但一些性能敏感的数据库或手机上还是主要采用SAX方式，SAX读取是单向的，优点:不占内存空间、解析属性方便，但缺点就是对于套嵌多个分支来说处理不是很方便。而DOM方式会把整个XML文件加载到内存中去，这里Android开发网提醒大家该方法在查找方面可以和XPath很好的结合如果数据量不是很大推荐使用，而PULL常常用在J2ME对于节点处理比较好，类似SAX方式，同样很节省内存，在J2ME中我们经常使用的KXML库来解析。


### 11、andorid 应用第二次登录实现自动登录
### 12、Fragment中add与replace的区别？
### 13、如何退出Activity？如何安全退出已调用多个Activity的Application？
### 14、什么是ANR 如何避免它？
### 15、SQLite支持事务吗? 添加删除如何提高性能?
### 16、简要解释一下activity、 intent 、intent filter、service、Broadcase、BroadcaseReceiver
### 17、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?
### 18、如何对 Android 应用进行性能分析
### 19、DDMS和TraceView的区别?
### 20、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？
### 21、9.进程和线程的区别
### 22、请介绍下Android中常用的五种布局。
### 23、Android中任务栈的分配
### 24、android的数据存储
### 25、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？
### 26、GLSurfaceView
### 27、广播接受者的生命周期？
### 28、activity的启动模式有哪些？是什么含义
### 29、什么是IntentService？有何优点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
