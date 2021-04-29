# Android最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Android中activity，context，application有什么不同。

Content与application都继承与contextWrapper，contextWrapper继承于Context类。

Context：表示当前上下文对象，保存的是上下文中的参数和变量，它可以让更加方便访问到一些资源。

Context通常与activity的生命周期是一样的，application表示整个应用程序的对象。

对于一些生命周期较长的，不要使用context，可以使用application。

在activity中，尽量使用静态内部类，不要使用内部类。内部里作为外部类的成员存在，不是独立于activity，如果内存中还有内存继续引用到context，activity如果被销毁，context还不会结束。


### 2、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。

通过直接发送Uri把参数带过去，或者通过manifest里的intentfilter里的data属性


### 3、事件分发中的 onTouch 和 onTouchEvent 有什么区别，又该如何使用？

这两个方法都是在 View 的 dispatchTouchEvent 中调用的，onTouch 优先于 onTouchEvent执行。如果在 onTouch 方法中通过返回 true 将事件消费掉，onTouchEvent 将不会再执行。

另外需要注意的是，onTouch 能够得到执行需要两个前提条件，第一 mOnTouchListener 的值不能为空，第二当前点击的控件必须是 enable 的。因此如果你有一个控件是非 enable 的，那么给它注册 onTouch 事件将永远得不到执行。对于这一类控件，如果我们想要监听它的 touch 事件，就必须通过在该控件中重写 onTouchEvent 方法来实现。


### 4、Fragment 的 replace 和 add 方法的区别

Fragment 本身并没有 replace 和 add 方法，FragmentManager才有replace和add方法。我们经常使用的一个架构就是通过RadioGroup切换Fragment，每个 Fragment 就是一个功能模块。

Fragment 的容器一个 FrameLayout，add 的时候是把所有的 Fragment 一层一层的叠加到了。FrameLayout 上了，而 replace 的话首先将该容器中的其他 Fragment 去除掉然后将当前Fragment添加到容器中。

一个 Fragment 容器中只能添加一个 Fragment 种类，如果多次添加则会报异常，导致程序终止，而 replace 则无所谓，随便切换。因为通过 add 的方法添加的 Fragment，每个 Fragment 只能添加一次，因此如果要想达到切换效果需要通过 Fragment 的的 hide 和 show 方法结合者使用。将要显示的 show 出来，将其他 hide起来。这个过程 Fragment 的生命周期没有变化。

通过 replace 切换 Fragment，每次都会执行上一个 Fragment 的 onDestroyView，新 Fragment的 onCreateView、onStart、onResume 方法。基于以上不同的特点我们在使用的使用一定要结合着生命周期操作我们的视图和数据。


### 5、子线程中能不能 new handler？为什么？

不能,如果在子线程中直接 new Handler()会抛出异常 java.lang.RuntimeException: Can'tcreate handler inside thread that has not called

在没有调用 Looper.prepare()的时候不能创建 Handler,因为在创建 Handler 的源码中做了如下操作

Handler 的构造方法中


### 6、什么是aar?aar是jar有什么区别?

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


### 7、java中如何引用本地语言

可以用JNI（java native interface  java 本地接口）接口 。


### 8、ContentProvider与sqlite有什么不一样的？

```
ContentProvider会对外隐藏内部实现，只需要关注访问contentProvider的uri即可，contentProvider应用在应用间共享。
Sqlite操作本应用程序的数据库。
ContentProiver可以对本地文件进行增删改查操作
```


### 9、如何保存activity的状态？

默认情况下activity的状态系统会自动保存，有些时候需要我们手动调用保存。

当activity处于onPause，onStop之后，activity处于未活动状态，但是activity对象却仍然存在。当内存不足，onPause，onStop之后的activity可能会被系统摧毁。

当通过返回退出activity时，activity状态并不会保存。

保存activity状态需要重写onSavedInstanceState()方法，在执行onPause,onStop之前调用onSavedInstanceState方法，onSavedInstanceState需要一个Bundle类型的参数，我们可以将数据保存到bundle中，通过实参传递给onSavedInstanceState方法。

Activity被销毁后，重新启动时，在onCreate方法中，接受保存的bundle参数，并将之前的数据取出。


### 10、内存泄露如何查看和解决

概念：有些对象只有有限的生命周期，当他们的任务完成之后，它们将被垃圾回收，如果在对象的生命周期本该结束的时候，这个对象还被一系列的引用，着就会导致内存泄露。

解决方法：使用开源框架LeakCanary检测针对性解决

**常见的内存泄露有：**

**1、** 单例造成的内存泄露，例如单例中的Context生命周期大于本身Context生命周期

**2、** 线程使用Hander造成的内存卸扣，当activity已经结束，线程依然在运行更新UI

**3、** 非静态类使用静态变量导致无法回收释放造成泄露

**4、** WebView网页过多造成内存泄露

**5、** 资源未关闭造成泄露，例如数据库使用完之后关闭连接


### 11、如何提升Service进程优先级
### 12、如何退出Activity？如何安全退出已调用多个Activity的Application？
### 13、Android系统的架构
### 14、怎样对 android 进行优化？
### 15、Android 中如何捕获未捕获的异常
### 16、推送到达率如何提高
### 17、View和SurfaceView的区别
### 18、NDK
### 19、自定义view的基本流程
### 20、View
### 21、SurfaceView
### 22、什么是ANR 如何避免它？
### 23、Fragment的生命周期
### 24、在 service 的生命周期方法 onstartConmand()可不可以执行网络操作？如何在 service 中执行网络操作？
### 25、wait和 sleep 的区别
### 26、如果有个100M大的文件，需要上传至服务器中，而服务器form表单最大只能上传2M，可以用什么方法。
### 27、一条最长的短信息约占多少byte?
### 28、activity在屏幕旋转时的生命周期
### 29、Android 中的动画有哪几类，它们的特点和区别是什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
