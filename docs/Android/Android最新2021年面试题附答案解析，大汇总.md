# Android最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、wait和 sleep 的区别

wait是Object的方法，wait是对象锁，锁定方法不让继续执行，当执行notify方法后就会继续执行，sleep 是Thread的方法，sleep 是使线程睡眠，让出cpu，结束后自动继续执行


### 2、了解IntentServices吗?

**1、** IntentService是Service的子类，是一个异步的，会自动停止的服务，很好解决了传统的Service中处理完耗时操作忘记停止并销毁Service的问题

**2、** 生成一个默认的且与线程相互独立的工作线程执行所有发送到onStartCommand()方法的Intent,可以在onHandleIntent()中处理.

**3、** 串行队列,每次只运行一个任务,不存在线程安全问题,所有任务执行完后自动停止服务,不需要自己手动调用stopSelf()来停止.


### 3、注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意。

首先写一个类要继承BroadcastReceiver

第一种:在清单文件中声明

第二种使用代码进行注册如:‍‍

```
IntentFilter filter =  new IntentFilter("android.provider.Telephony.SMS_RECEIVED");
IncomingSMSReceiver receiver = new IncomgSMSReceiver();
registerReceiver(receiver.filter);
```

两种注册类型的区别是：

1)第一种不是常驻型广播，也就是说广播跟随程序的生命周期。

2)第二种是常驻型，也就是说当应用程序关闭后，如果有信息广播来，程序也会被系统调用自动运行。


### 4、Android的四大组件是哪些，它们的作用？

****

**1、** Activity：Activity是Android程序与用户交互的窗口，是Android构造块中最基本的一种，它需要为保持各界面的状态，做很多持久化的事情，妥善管理生命周期以及一些跳转逻辑

**2、** service：后台服务于Activity，封装有一个完整的功能逻辑实现，接受上层指令，完成相关的事物，定义好需要接受的Intent提供同步和异步的接口

**3、** Content Provider：是Android提供的第三方应用数据的访问方案，可以派生Content Provider类，对外提供数据，可以像数据库一样进行选择排序，屏蔽内部数据的存储细节，向外提供统一的借口模型，大大简化上层应用，对数据的整合提供了更方便的途径

**4、** BroadCast Receiver：接受一种或者多种Intent作触发事件，接受相关消息，做一些简单处理，转换成一条Notification，统一了Android的事件广播模型


### 5、Android数字签名

**1、** 所有的应用程序都必须有数字证书，Android系统不会安装一个没有数字证书的应用程序

**2、** Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证

**3、** 如果要正式发布一个Android ，必须使用一个合适的私钥生成的数字证书来给程序签名。

**4、** 数字证书都是有有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能。


### 6、Fragment 的 replace 和 add 方法的区别

Fragment 本身并没有 replace 和 add 方法，FragmentManager才有replace和add方法。我们经常使用的一个架构就是通过RadioGroup切换Fragment，每个 Fragment 就是一个功能模块。

Fragment 的容器一个 FrameLayout，add 的时候是把所有的 Fragment 一层一层的叠加到了。FrameLayout 上了，而 replace 的话首先将该容器中的其他 Fragment 去除掉然后将当前Fragment添加到容器中。

一个 Fragment 容器中只能添加一个 Fragment 种类，如果多次添加则会报异常，导致程序终止，而 replace 则无所谓，随便切换。因为通过 add 的方法添加的 Fragment，每个 Fragment 只能添加一次，因此如果要想达到切换效果需要通过 Fragment 的的 hide 和 show 方法结合者使用。将要显示的 show 出来，将其他 hide起来。这个过程 Fragment 的生命周期没有变化。

通过 replace 切换 Fragment，每次都会执行上一个 Fragment 的 onDestroyView，新 Fragment的 onCreateView、onStart、onResume 方法。基于以上不同的特点我们在使用的使用一定要结合着生命周期操作我们的视图和数据。


### 7、Fragment的生命周期

Fragment的生命周期

![92_2.png][92_2.png]

Fragment与Activity生命周期对比

![92_3.png][92_3.png]

Fragment的生命周期方法主要有onAttach()、onCreate()、onCreateView()、onActivityCreated()、onstart()、onResume()、onPause()、onStop()、onDestroyView()、onDestroy()、onDetach()等11个方法。

**1、** 切换到该Fragment，分别执行onAttach()、onCreate()、onCreateView()、onActivityCreated()、onstart()、onResume()方法。

**2、** 锁屏，分别执行onPause()、onStop()方法。

**3、** 亮屏，分别执行onstart()、onResume()方法。

**4、** 覆盖，切换到其他Fragment，分别执行onPause()、onStop()、onDestroyView()方法。

**5、** 从其他Fragment回到之前Fragment，分别执行onCreateView()、onActivityCreated()、onstart()、onResume()方法。


### 8、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()

Bitmap 是 android 中经常使用的一个类，它代表了一个图片资源。 Bitmap 消耗内存很严重，如果不注意优化代码，经常会出现 OOM 问题，优化方式通常有这么几种：

**1、** 使用缓存；

**2、** 压缩图片；

**3、** 及时回收；

至于什么时候需要手动调用 recycle，这就看具体场景了，原则是当我们不再使用 Bitmap 时，需要回收之。另外，我们需要注意，2.3 之前 Bitmap 对象与像素数据是分开存放的，Bitmap 对象存在java Heap 中而像素数据存放在 Native Memory 中， 这时很有必要调用 recycle 回收内存。 但是 2.3之后，Bitmap 对象和像素数据都是存在 Heap 中，GC 可以回收其内存。


### 9、让Activity变成一个窗口

设置activity的style属性=”@android:style/Theme.Dialog”


### 10、什么是aar?aar是jar有什么区别?

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


### 11、Hander原理
### 12、Android系统的架构
### 13、Android dvm的进程和Linux的进程, 应用程序的进程是否为同一个概念
### 14、Fragment与activity如何传值和交互？
### 15、ListView 如何实现分页加载
### 16、子线程中能不能 new handler？为什么？
### 17、说下Activity 的四种启动模式、应用场景 ？
### 18、简述JNI
### 19、Adapter是什么？你所接触过的adapter有那些？
### 20、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 21、都使用过哪些自定义控件
### 22、Android 引入广播机制的用意
### 23、如果Listview中的数据源发生改变，如何更新listview中的数据
### 24、android:gravity与android:layout_gravity的区别
### 25、android系统的优势和不足
### 26、AsyncTask
### 27、说说 LruCache 底层原理
### 28、View
### 29、16Android性能优化
### 30、如何启用Service，如何停用Service。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
