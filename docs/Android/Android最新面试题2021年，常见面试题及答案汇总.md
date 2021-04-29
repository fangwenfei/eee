# Android最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请介绍下ContentProvider是如何实现数据共享的。

一个程序可以通过实现一个Content provider的抽象接口将自己的数据完全暴露出去，而且Content providers是以类似数据库中表的方式将数据暴露。Content providers存储和检索数据，通过它可以让所有的应用程序访问到，这也是应用程序之间唯一共享数据的方法。

要想使应用程序的数据公开化，可通过2种方法：创建一个属于你自己的Content provider或者将你的数据添加到一个已经存在的Content provider中，前提是有相同数据类型并且有写入Content provider的权限。

如何通过一套标准及统一的接口获取其他应用程序暴露的数据？

Android提供了ContentResolver，外界的程序可以通过ContentResolver接口访问ContentProvider提供的数据。


### 2、谈谈对Android NDK的理解

NDK是一系列工具的集合.NDK提供了一系列的工具,帮助开发者快速开发C或C++的动态库,并能自动将so和java应用一起打包成apk.这些工具对开发者的帮助是巨大的.NDK集成了交叉编译器,并提供了相应的mk文件隔离CPU,平台,ABI等差异,开发人员只需要简单修改 mk文件(指出"哪些文件需要编译","编译特性要求"等),就可以创建出so.

NDK可以自动地将so和Java应用一起打包,极大地减轻了开发人员的打包工作.NDK提供了一份稳定,功能有限的API头文件声明.

Google明确声明该API是稳定的,在后续所有版本中都稳定支持当前发布的API.从该版本的NDK中看出,这些 API支持的功能非常有限,包含有:C标准库(libc),标准数学库(libm ),压缩库(libz),Log库(liblog).


### 3、activity与fragment区别

生命周期：

fragment从创建倒销毁整个生命周期依次为onAttach()→onCreate()→onCreateView()→onActivityCreated()→onStart()→onResume()→onPause()→onStop()→onDestroyView()→onDestroy()→onDetach()

**与activity不同的方法有**

**1、** onAttach():当Fragment和Activity建立关联的时候调用；

**2、** onCreateView():当Fragment创建视图调用；

**3、** onActivityCreated:与Fragment相关联的Activity完成onCreate()之后调用；

**4、** onDestoryView():在Fragment中的布局被移除时调用；

**5、** onDetach():当Fragment和Activity解除关联时调用；

**6、** activity常用的生命周期只有以下几个；

**7、** onCreate()： 表示 Activity 正在被创建，常用来 初始化工作，比如调用 setContentView 加载界面布局资源，初始化 Activity 所需数据等；

**8、** onRestart()：表示 Activity 正在重新启动，一般情况下，当前Acitivty 从不可见重新变为可见时，OnRestart就会被调用；

**9、** onStart()： 表示 Activity 正在被启动，此时 Activity 可见但不在前台，还处于后台，无法与用户交互；

**10、** onResume()： 表示 Activity 获得焦点，此时 Activity 可见且在前台并开始活动，这是与 onStart 的区别所在；

**11、** onPause()： 表示 Activity 正在停止，此时可做一些 存储数据、停止动画等工作，但是不能太耗时，因为这会影响到新 Activity的显示，onPause 必须先执行完，新 Activity 的 onResume 才会执行；

**12、** onStop()： 表示 Activity 即将停止，可以做一些稍微重量级的回收工作，比如注销广播接收器、关闭网络连接等，同样不能太耗时；

**13、** onDestroy()： 表示 Activity 即将被销毁，这是 Activity 生命周期中的最后一个回调，常做 回收工作、资源释放；

**14、** 区别：

**15、** Fragment比Activity多出四个回调周期，控制操作上更灵活；

**16、** Fragment可以在xml文件中直接写入，也可以在Activity中动态添加；

**17、** Fragment可以使用show()/hide()或者replace()对Fragment进行切换，切换的时候不会出现明显的效果，Activity切换的时候会有明显的翻页或其他效果；


### 4、Android与服务器交互的方式中的对称加密和非对称加密是什么?

对称加密，就是加密和解密数据都是使用同一个key，这方面的算法有DES。

非对称加密，加密和解密是使用不同的key。发送数据之前要先和服务端约定生成公钥和私钥，使用公钥加密的数据可以用私钥解密，反之。这方面的算法有RSA。ssh 和 ssl都是典型的非对称加密。


### 5、Android中常用布局

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


### 6、如何退出Activity

结束当前activity

```
Finish()
killProgress()
System.exit(0)
```

关闭应用程序时，结束所有的activity

可以创建一个List集合，每新创建一个activity，将该activity的实例放进list中，程序结束时，从集合中取出循环取出activity实例，调用finish()方法结束


### 7、内存泄露如何查看和解决

概念：有些对象只有有限的生命周期，当他们的任务完成之后，它们将被垃圾回收，如果在对象的生命周期本该结束的时候，这个对象还被一系列的引用，着就会导致内存泄露。

解决方法：使用开源框架LeakCanary检测针对性解决

**常见的内存泄露有：**

**1、** 单例造成的内存泄露，例如单例中的Context生命周期大于本身Context生命周期

**2、** 线程使用Hander造成的内存卸扣，当activity已经结束，线程依然在运行更新UI

**3、** 非静态类使用静态变量导致无法回收释放造成泄露

**4、** WebView网页过多造成内存泄露

**5、** 资源未关闭造成泄露，例如数据库使用完之后关闭连接


### 8、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？

在两个应用的manifest配置中好相同的shartdUserId属性，A应用正常保存数据，B应用

createPackageContext("com.netease.nim.demo", CONTEXT_IGNORE_SECURITY)

获取context然后获取应用数据，为保证数据安全，使用加密存储


### 9、如何退出Activity？如何安全退出已调用多个Activity的Application？

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


### 10、ContentProvider与sqlite有什么不一样的？

```
ContentProvider会对外隐藏内部实现，只需要关注访问contentProvider的uri即可，contentProvider应用在应用间共享。
Sqlite操作本应用程序的数据库。
ContentProiver可以对本地文件进行增删改查操作
```


### 11、横竖屏切换的Activity 生命周期变化？
### 12、开发中都使用过哪些框架、平台
### 13、什么是嵌入式实时操作系统, Android 操作系统属于实时操作系统吗?
### 14、Fragment 如何实现类似 Activity 栈的压栈和出栈效果的？
### 15、广播注册
### 16、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布?
### 17、View
### 18、消息推送的方式
### 19、Activity间通过Intent传递数据大小有没有限制？
### 20、让Activity变成一个窗口
### 21、16Android性能优化
### 22、注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意。
### 23、谈MVC ，MVP，MVVM
### 24、内存溢出和内存泄漏有什么区别？何时会产生内存泄漏？
### 25、9.进程和线程的区别
### 26、recyclerView嵌套卡顿解决如何解决
### 27、Android本身的api并未声明会抛出异常，则其在运行时有无可能抛出runtime异常，你遇到过吗？诺有的话会导致什么问题？如何解决？
### 28、请描述下Activity的生命周期。
### 29、Activity启动模式




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
