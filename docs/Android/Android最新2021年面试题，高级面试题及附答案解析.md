# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

解可以将dictionary.db文件复制到Eclipse Android工程中的res aw目录中。所有在res aw目录中的文件不会被压缩，这样可以直接提取该目录中的文件。可以将dictionary.db文件复制到res aw目录中


### 2、Fragment中add与replace的区别？

add不会重新初始化fragment,replace每次都会；

添加相同的fragment时，replace不会有任何变化，add会报IllegalStateException 异常；

replace 先 remove 掉相同 id 的所有 fragment，然后在add 当前的这个 fragment，而 add 是覆盖前一个fragment。所以如果使用 add 一般会伴随 hide()和show()，避免布局重叠；

使用 add，如果应用放在后台，或以其他方式被系统销毁，再打开时，hide()中引用的 fragment 会销毁，所以依然会出现布局重叠 bug，可以使用 replace 或使用 add时，添加一个 tag 参数；


### 3、Activity启动模式

介绍 Android 启动模式之前，先介绍两个概念task和taskAffinity

**task：**

翻译过来就是“任务”，是一组相互有关联的 activity 集合，可以理解为 Activity 是在 task 里面活动的。 task 存在于一个称为 back stack 的数据结构中，也就是说， task 是以栈的形式去管理 activity 的，所以也叫可以称为“任务栈”。

**taskAffinity：**

官方文档解释是："The task that the activity has an affinity for."，可以翻译为 activity 相关或者亲和的任务，这个参数标识了一个 Activity 所需要的任务栈的名字。默认情况下，所有Activity所需的任务栈的名字为应用的包名。 taskAffinity 属性主要和 singleTask 启动模式或者 allowTaskReparenting 属性配对使用。

**4种启动模式**

**1、** standard：

标准模式，也是系统默认的启动模式。假如 activity A 启动了 activity B ， activity B 则会运行在 activity A 所在的任务栈中。而且每次启动一个 Activity ，都会重新创建新的实例，不管这个实例在任务中是否已经存在。非 Activity 类型的 context （如 ApplicationContext ）启动 standard 模式的 Activity 时会报错。非 Activity 类型的 context 并没有所谓的任务栈，由于上面第 1 点的原因所以系统会报错。此解决办法就是为待启动 Activity 指定 FLAG_ACTIVITY_NEW_TASK 标记位，这样启动的时候系统就会为它创建一个新的任务栈。这个时候待启动 Activity 其实是以 singleTask 模式启动的。

**2、** singleTop：

栈顶复用模式。假如 activity A 启动了 activity B ，就会判断 A 所在的任务栈栈顶是否是 B 的实例。如果是，则不创建新的 activity B 实例而是直接引用这个栈顶实例，同时 onNewIntent 方法会被回调，通过该方法的参数可以取得当前请求的信息；如果不是，则创建新的 activity B 实例。

**3、** singleTask：

栈内复用模式。在第一次启动这个 Activity 时，系统便会创建一个新的任务，并且初始化 Activity 的实例，放在新任务的底部。不过需要满足一定条件的。那就是需要设置 taskAffinity 属性。前面也说过了， taskAffinity 属性是和 singleTask 模式搭配使用的。

![92_4.png][92_4.png]

**1、** singleInstance：单实例模式。这个是 singleTask 模式的加强版，它除了具有 singleTask 模式的所有特性外，它还有一点独特的特性，那就是此模式的 Activity 只能单独地位于一个任务栈，不与其他 Activity 共存于同一个任务栈。


### 4、sim卡的EF 文件有何作用

sim卡就是电话卡，sim卡内有自己的操作系统，用来与手机通讯的。Ef文件用来存储数据的。


### 5、Fragment 在你们项目中的使用

Fragment 是 android3.0 以后引入的的概念，做局部内容更新更方便，原来为了到达这一点要把多个布局放到一个 activity 里面，现在可以用多 Fragment 来代替，只有在需要的时候才加载Fragment，提高性能。

**Fragment 的好处：**

**1、** Fragment 可以使你能够将 activity 分离成多个可重用的组件，每个都有它自己的生命周期和UI。

**2、** Fragment 可以轻松得创建动态灵活的 UI 设计，可以适应于不同的屏幕尺寸。从手机到平板电脑。

**3、** Fragment 是一个独立的模块,紧紧地与 activity 绑定在一起。可以运行中动态地移除、加入、交换等。

**4、** Fragment 提供一个新的方式让你在不同的安卓设备上统一你的 UI。

**5、** Fragment 解决 Activity 间的切换不流畅，轻量切换。

**6、** Fragment 替代 TabActivity 做导航，性能更好。

**7、** Fragment 在 4.2.版本中新增嵌套 fragment 使用方法，能够生成更好的界面效果。


### 6、如何将打开res aw目录中的数据库文件?

**1、** 在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

**2、** 复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。

**3、** 在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 7、Android root机制

root指的是你有权限可以再系统上对所有档案有 "读" "写" "执行"的权力。root机器不是真正能让你的应用程序具有root权限。它原理就跟linux下的像sudo这样的命令。在系统的bin目录下放个su程序并属主是root并有suid权限。则通过su执行的命令都具有Android root权限。当然使用临时用户权限想把su拷贝的/system/bin目录并改属性并不是一件容易的事情。这里用到2个工具跟2个命令。把busybox拷贝到你有权限访问的目录然后给他赋予4755权限，你就可以用它做很多事了。


### 8、GLSurfaceView

基于SurfaceView视图再次进行拓展的视图类，专用于3D游戏开发的视图，是surfaceView的子类，openGL专用


### 9、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？

补间动画只是显示的位置变动，View 的实际位置未改变，表现为 View 移动到其他地方，点击事件仍在原处才能响应。而属性动画控件移动后事件相应就在控件移动后本身进行处理


### 10、什么是IntentService？有何优点？

IntentService 是 Service 的子类，比普通的 Service 增加了额外的功能。先看 Service 本身存在两个问题：

```
Service 不会专门启动一条单独的进程，Service 与它所在应用位于同一个进程中；
Service 也不是专门一条新线程，因此不应该在 Service 中直接处理耗时的任务；
```

特征

```
会创建独立的 worker 线程来处理所有的 Intent 请求；
会创建独立的 worker 线程来处理 onHandleIntent()方法实现的代码，无需处理多线程问题；
所有请求处理完成后，IntentService 会自动停止，无需调用 stopSelf()方法停止 Service；
为 Service 的 onBind()提供默认实现，返回 null；
为 Service 的 onStartCommand 提供默认实现，将请求 Intent 添加到队列中
```

使用

```
让service类继承IntentService，重写onStartCommand和onHandleIntent实现
```


### 11、activity的启动模式有哪些？是什么含义
### 12、简述JNI
### 13、补间动画
### 14、Service 和 Activity 在同一个线程吗
### 15、16Android性能优化
### 16、如何启用Service，如何停用Service。
### 17、什么是 IntentService？有何优点？
### 18、Android本身的api并未声明会抛出异常，则其在运行时有无可能抛出runtime异常，你遇到过吗？诺有的话会导致什么问题？如何解决？
### 19、Android 判断SD卡是否存在
### 20、请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系。
### 21、Adapter是什么？你所接触过的adapter有那些？
### 22、请解释下 Android 程序运行时权限与文件系统权限的区别？
### 23、Android 引入广播机制的用意
### 24、如何退出Activity
### 25、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布?
### 26、广播接受者的生命周期？
### 27、Service生命周期
### 28、ListView 如何实现分页加载
### 29、谈谈你在工作中是怎样解决一个 bug
### 30、Activity间通过Intent传递数据大小有没有限制？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
