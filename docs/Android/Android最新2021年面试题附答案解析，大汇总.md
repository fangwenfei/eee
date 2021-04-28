# Android最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、jni 的调用过程?

**1、** 安装和下载 Cygwin，下载 Android NDK。

**2、** ndk 项目中 JNI 接口的设计。

**3、** 使用 C/C++实现本地方法。

**4、** JNI 生成动态链接库.so 文件。

**5、** 将动态链接库复制到 java 工程，在 java 工程中调用，运行 java 工程即可。


### 2、音视频相关类

总体来说，分为几个类

**1、** 视频录制方面，Camear摄像头录制视频类，MediaProjection屏幕录制视频类

**2、** 编码方面，MediaCodec，MediaRecorder

**3、** 预览方面，SurfaceView,GLSurfaceView,TextureView,VideoView


### 3、Activity间通过Intent传递数据大小有没有限制？

Intent在传递数据时是有大小限制的，这里官方并未详细说明，不过通过实验的方法可以测出数据应该被限制在1MB之内（1024KB），笔者采用的是传递Bitmap的方法，发现当图片大小超过1024（准确地说是1020左右）的时候，程序就会出现闪退、停止运行等异常(不同的手机反应不同)，因此可以判断Intent的传输容量在1MB之内。


### 4、如何保存activity的状态？

默认情况下activity的状态系统会自动保存，有些时候需要我们手动调用保存。

当activity处于onPause，onStop之后，activity处于未活动状态，但是activity对象却仍然存在。当内存不足，onPause，onStop之后的activity可能会被系统摧毁。

当通过返回退出activity时，activity状态并不会保存。

保存activity状态需要重写onSavedInstanceState()方法，在执行onPause,onStop之前调用onSavedInstanceState方法，onSavedInstanceState需要一个Bundle类型的参数，我们可以将数据保存到bundle中，通过实参传递给onSavedInstanceState方法。

Activity被销毁后，重新启动时，在onCreate方法中，接受保存的bundle参数，并将之前的数据取出。


### 5、怎样对 android 进行优化？

**1、** 对 listview 的优化。

**2、** 对图片的优化。

**3、** 对内存的优化。

**4、** 具体一些措施

**5、** 尽量不要使用过多的静态类 static

**6、** 数据库使用完成后要记得关闭 cursor

**7、** 广播使用完之后要注销


### 6、activity的启动模式有哪些？是什么含义

在android里，有4种activity的启动模式，分别为：

**1、** “standard” (默认)

**2、** “singleTop”

**3、** “singleTask”

**4、** “singleInstance”

它们主要有如下不同

**1、** 如何决定所属task

“standard”和”singleTop”的activity的目标task，和收到的Intent的发送者在同一个task内，除非intent包括参数FLAG_ACTIVITY_NEW_TASK

如果提供了FLAG_ACTIVITY_NEW_TASK参数，会启动到别的task里。

“singleTask”和”singleInstance”总是把activity作为一个task的根元素，他们不会被启动到一个其他task里

**2、** 是否允许多个实例

“standard”和”singleTop”可以被实例化多次，并且存在于不同的task中，且一个task可以包括一个activity的多个实例；

“singleTask”和”singleInstance”则限制只生成一个实例，并且是task的根元素。 singleTop要求如果创建intent的时候栈顶已经有要创建的Activity的实例，则将intent发送给该实例，而不发送给新的实例

**3、** 是否允许其它activity存在于本task内

“singleInstance”独占一个task，其它activity不能存在那个task里；如果它启动了一个新的activity，不管新的activity的launch mode 如何，新的activity都将会到别的task里运行（如同加了FLAG_ACTIVITY_NEW_TASK参数）。

而另外三种模式，则可以和其它activity共存

**4、** 是否每次都生成新实

“standard”对于没一个启动Intent都会生成一个activity的新实例；

“singleTop”的activity如果在task的栈顶的话，则不生成新的该activity的实例，直接使用栈顶的实例，否则，生成该activity的实例。

比如现在task栈元素为A-B-C-D（D在栈顶），这时候给D发一个启动intent，如果D是 “standard”的，则生成D的一个新实例，栈变为A－B－C－D－D

如果D是singleTop的话，则不会生产D的新实例，栈状态仍为A-B-C-D

如果这时候给B发Intent的话，不管B的launchmode是”standard” 还是 “singleTop” ，都会生成B的新实例，栈状态变为A-B-C-D-B

“singleInstance”是其所在栈的唯一activity，它会每次都被重用

“singleTask”如果在栈顶，则接受intent，否则，该intent会被丢弃，但是该task仍会回到前台

当已经存在的activity实例处理新的intent时候，会调用onNewIntent()方法 如果收到intent生成一个activity实例，那么用户可以通过back键回到上一个状态；如果是已经存在的一个activity来处理这个intent的话，用户不能通过按back键返回到这之前的状态


### 7、属性动画

属性动画，顾名思义它是对于对象属性的动画。因此，所有补间动画的内容，都可以通过属性动画实现。属性动画的运行机制是通过不断地对值进行操作来实现的，而初始值和结束值之间的动画过渡就是由ValueAnimator这个类来负责计算的。它的内部使用一种时间循环的机制来计算值与值之间的动画过渡，我们只需要将初始值和结束值提供给ValueAnimator，并且告诉它动画所需运行的时长，那么ValueAnimator就会自动帮我们完成从初始值平滑地过渡到结束值这样的效果。除此之外，ValueAnimator还负责管理动画的播放次数、播放模式、以及对动画设置监听器等。


### 8、android的数据存储

**1、** 使用SharedPreferences存储数据；它是Android提供的用来存储一些简单配置信息的一种机制，采用了XML格式将数据存储到设备中。只能在同一个包内使用，不能在不同的包之间使用。

**2、** 文件存储数据；文件存储方式是一种较常用的方法，在Android中读取/写入文件的方法，与Java中实现I/O的程序是完全一样的，提供了openFileInput()和openFileOutput()方法来读取设备上的文件。

**3、** SQLite数据库存储数据；SQLite是Android所带的一个标准的数据库，它支持SQL语句，它是一个轻量级的嵌入式数据库。

**4、** 使用ContentProvider存储数据；主要用于应用程序之间进行数据交换，从而能够让其他的应用保存或读取此Content Provider的各种数据类型。

**5、** 网络存储数据；通过网络上提供给我们的存储空间来上传(存储)和下载(获取)我们存储在网络空间中的数据信息。


### 9、ListView 如何实现分页加载

设置 ListView 的滚动监听器：setOnScrollListener(new OnScrollListener{….})在监听器中有两个方法： 滚动状态发生变化的方法(onScrollStateChanged)和 listView 被滚动时调用的方法(onScroll)

在滚动状态发生改变的方法中，有三种状态：手指按下移动的状态： SCROLL_STATE_TOUCH_SCROLL:触摸滑动，惯性滚动（滑翔（flgin）状态）： SCROLL_STATE_FLING: 滑翔，静止状态： SCROLL_STATE_IDLE: // 静止，对不同的状态进行处理：

分批加载数据，只关心静止状态：关心最后一个可见的条目，如果最后一个可见条目就是数据适配器（集合）里的最后一个，此时可加载更多的数据。在每次加载的时候，计算出滚动的数量，当滚动的数量大于等于总数量的时候，可以提示用户无更多数据了。


### 10、Hander原理

Handler，loop轮询检测发送消息到MessagerQuery,MessageQuery对Message入列，Handler回调方法处理消息，重写handMessage方法刷新ui


### 11、请介绍下 ContentProvider 是如何实现数据共享的
### 12、Android中4大组件
### 13、Fragment与activity如何传值和交互？
### 14、消息推送的方式
### 15、activity的生命周期
### 16、请描述一下 Intent 和 IntentFilter
### 17、sim卡的EF文件是什么？有何作用
### 18、请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系。
### 19、即时通讯是是怎么做的?
### 20、ListView 如何提高其效率？
### 21、Android中touch事件的传递机制是怎样的?
### 22、了解IntentServices吗?
### 23、View
### 24、广播接受者的生命周期？
### 25、跨进程通信的几种方式
### 26、AsyncTask
### 27、什么是 AIDL？如何使用？
### 28、如果Listview中的数据源发生改变，如何更新listview中的数据
### 29、Android中，帧动画
### 30、GLSurfaceView




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
