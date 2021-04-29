# Android最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、sim卡的EF文件是什么？有何作用

sim卡的文件系统有自己规范，主要是为了和手机通讯，sim本 身可以有自己的操作系统，EF就是作存储并和手机通讯用的


### 2、在 service 的生命周期方法 onstartConmand()可不可以执行网络操作？如何在 service 中执行网络操作？

可以的，就在onstartConmand方法内执行。


### 3、说说 LruCache 底层原理

LruCache 使用一个 LinkedHashMap 简单的实现内存的缓存，没有软引用，都是强引用。

如果添加的数据大于设置的最大值，就删除最先缓存的数据来调整内存。maxSize 是通过构造方法初始化的值，他表示这个缓存能缓存的最大值是多少。

size 在添加和移除缓存都被更新值， 他通过 safeSizeOf 这个方法更新值。 safeSizeOf 默认返回 1，但一般我们会根据 maxSize 重写这个方法，比如认为 maxSize 代表是 KB 的话，那么就以 KB 为单位返回该项所占的内存大小。

除异常外，首先会判断 size 是否超过 maxSize，如果超过了就取出最先插入的缓存，如果不为空就删掉，并把 size 减去该项所占的大小。这个操作将一直循环下去，直到 size 比 maxSize 小或者缓存为空。


### 4、Service和Thread的区别？

servie是系统的组件，它由系统进程托管（servicemanager）；它们之间的通信类似于client和server，是一种轻量级的ipc通信，这种通信的载体是binder，它是在linux层交换信息的一种ipc。而thread是由本应用程序托管。1)、Thread：Thread 是程序执行的最小单元，它是分配CPU的基本单位。可以用 Thread 来执行一些异步的操作。

2)、Service：Service 是android的一种机制，当它运行的时候如果是Local Service，那么对应的 Service 是运行在主进程的 main 线程上的。如：onCreate，onStart 这些函数在被系统调用的时候都是在主进程的 main 线程上运行的。如果是Remote Service，那么对应的 Service 则是运行在独立进程的 main 线程上。

既然这样，那么我们为什么要用 Service 呢？其实这跟 android 的系统机制有关，我们先拿 Thread 来说。Thread 的运行是独立于 Activity 的，也就是说当一个 Activity 被 finish 之后，如果你没有主动停止 Thread 或者 Thread 里的 run 方法没有执行完毕的话，Thread 也会一直执行。因此这里会出现一个问题：当 Activity 被 finish 之后，你不再持有该 Thread 的引用。另一方面，你没有办法在不同的 Activity 中对同一 Thread 进行控制。

举个例子：如果你的 Thread 需要不停地隔一段时间就要连接服务器做某种同步的话，该 Thread 需要在 Activity 没有start的时候也在运行。这个时候当你 start 一个 Activity 就没有办法在该 Activity 里面控制之前创建的 Thread。因此你便需要创建并启动一个 Service ，在 Service 里面创建、运行并控制该 Thread，这样便解决了该问题（因为任何 Activity 都可以控制同一 Service，而系统也只会创建一个对应 Service 的实例）。

因此你可以把 Service 想象成一种消息服务，而你可以在任何有 Context 的地方调用 Context.startService、Context.stopService、Context.bindService，Context.unbindService，来控制它，你也可以在 Service 里注册 BroadcastReceiver，在其他地方通过发送 broadcast 来控制它，当然这些都是 Thread 做不到的。


### 5、activity在屏幕旋转时的生命周期

不设置Activity的android:configChanges时，切屏会重新调用各个生命周期，切横屏时会执行一次，切竖屏时会执行两次；设置Activity的android:configChanges="orientation"时，切屏还是会重新调用各个生命周期，切横、竖屏时只会执行一次；设置Activity的android:configChanges="orientation|keyboardHidden"时，切屏不会重新调用各个生命周期，只会执行onConfigurationChanged方法


### 6、Android 判断SD卡是否存在

首先要在AndroidManifest.xml中增加SD卡访问权限


### 7、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

解可以将dictionary.db文件复制到Eclipse Android工程中的res aw目录中。所有在res aw目录中的文件不会被压缩，这样可以直接提取该目录中的文件。可以将dictionary.db文件复制到res aw目录中


### 8、Fragment中add与replace的区别？

add不会重新初始化fragment,replace每次都会；

添加相同的fragment时，replace不会有任何变化，add会报IllegalStateException 异常；

replace 先 remove 掉相同 id 的所有 fragment，然后在add 当前的这个 fragment，而 add 是覆盖前一个fragment。所以如果使用 add 一般会伴随 hide()和show()，避免布局重叠；

使用 add，如果应用放在后台，或以其他方式被系统销毁，再打开时，hide()中引用的 fragment 会销毁，所以依然会出现布局重叠 bug，可以使用 replace 或使用 add时，添加一个 tag 参数；


### 9、描述一下android的系统架构

android系统架构分从下往上为linux 内核层、运行库、应用程序框架层、和应用程序层。

linuxkernel：负责硬件的驱动程序、网络、电源、系统安全以及内存管理等功能。

libraries和 android runtime：libraries：即c/c++函数库部分，大多数都是开放源代码的函数库，例如webkit（引擎），该函数库负责 android网页浏览器的运行，例如标准的c函数库libc、openssl、sqlite等，当然也包括支持游戏开发2dsgl和 3dopengles，在多媒体方面有mediaframework框架来支持各种影音和图形文件的播放与显示，例如mpeg4、h.264、mp3、 aac、amr、jpg和png等众多的多媒体文件格式。android的runtime负责解释和执行生成的dalvik格式的字节码。

applicationframework（应用软件架构），java应用程序开发人员主要是使用该层封装好的api进行快速开发。

applications:该层是java的应用程序层，android内置的googlemaps、e-mail、即时通信工具、浏览器、mp3播放器等处于该层，java开发人员开发的程序也处于该层，而且和内置的应用程序具有平等的位置，可以调用内置的应用程序，也可以替换内置的应用程序。

上面的四个层次，下层为上层服务，上层需要下层的支持，调用下层的服务，这种严格分层的方式带来的极大的稳定性、灵活性和可扩展性，使得不同层的开发人员可以按照规范专心特定层的开发。

android应用程序使用框架的api并在框架下运行，这就带来了程序开发的高度一致性，另一方面也告诉我们，要想写出优质高效的程序就必须对整个 applicationframework进行非常深入的理解。精通applicationframework，你就可以真正的理解android的设计和运行机制，也就更能够驾驭整个应用层的开发。


### 10、ListView 如何实现分页加载

设置 ListView 的滚动监听器：setOnScrollListener(new OnScrollListener{….})在监听器中有两个方法： 滚动状态发生变化的方法(onScrollStateChanged)和 listView 被滚动时调用的方法(onScroll)

在滚动状态发生改变的方法中，有三种状态：手指按下移动的状态： SCROLL_STATE_TOUCH_SCROLL:触摸滑动，惯性滚动（滑翔（flgin）状态）： SCROLL_STATE_FLING: 滑翔，静止状态： SCROLL_STATE_IDLE: // 静止，对不同的状态进行处理：

分批加载数据，只关心静止状态：关心最后一个可见的条目，如果最后一个可见条目就是数据适配器（集合）里的最后一个，此时可加载更多的数据。在每次加载的时候，计算出滚动的数量，当滚动的数量大于等于总数量的时候，可以提示用户无更多数据了。


### 11、DDMS和TraceView的区别?
### 12、如何修改 Activity 进入和退出动画
### 13、说下Activity 的四种启动模式、应用场景 ？
### 14、如何在 ScrollView 中如何嵌入 ListView
### 15、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？
### 16、Hander原理
### 17、View和SurfaceView的区别
### 18、什么是ANR 如何避免它？
### 19、activity，fragment传值问题
### 20、Fragment 在你们项目中的使用
### 21、ListView的优化方案
### 22、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？
### 23、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 24、如何将打开res aw目录中的数据库文件?
### 25、AIDL 的全称是什么?如何工作?能处理哪些类型的数据？
### 26、Android root机制
### 27、嵌入式操作系统内存管理有哪几种， 各有何特性
### 28、Android中的长度单位详解
### 29、Service生命周期
### 30、Android中任务栈的分配




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
