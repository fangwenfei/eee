# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述TCP，UDP，Socket

TCP是经过3次握手，4次挥手完成一串数据的传送

UDP是无连接的，知道IP地址和端口号，向其发送数据即可，不管数据是否发送成功

Socket是一种不同计算机，实时连接，比如说传送文件，即时通讯


### 2、如何在 ScrollView 中如何嵌入 ListView

通常情况下我们不会在 ScrollView 中嵌套 ListView。

在 ScrollView 添加一个 ListView 会导致 listview 控件显示不全，通常只会显示一条，这是因为两个控件的滚动事件冲突导致。所以需要通过 listview 中的 item 数量去计算 listview 的显示高度，从而使其完整展示。

现阶段最好的处理的方式是： 自定义 ListView，重载 onMeasure()方法，设置全部显示。


### 3、子线程中能不能 new handler？为什么？

不能,如果在子线程中直接 new Handler()会抛出异常 java.lang.RuntimeException: Can'tcreate handler inside thread that has not called

在没有调用 Looper.prepare()的时候不能创建 Handler,因为在创建 Handler 的源码中做了如下操作

Handler 的构造方法中


### 4、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？

所有的框架都是基于反射 和 配置文件（manifest）的。

**普通的情况:**

Activity 创建一个 view 是通过 ondraw 画出来的, 画这个 view 之前呢,还会调用 onmeasure方法来计算显示的大小.

**特殊情况：**

Surfaceview 是直接操作硬件的，因为 或者视频播放对帧数有要求，onDraw 效率太低，不够使，Surfaceview 直接把数据写到显存。


### 5、ListView 如何实现分页加载

设置 ListView 的滚动监听器：setOnScrollListener(new OnScrollListener{….})在监听器中有两个方法： 滚动状态发生变化的方法(onScrollStateChanged)和 listView 被滚动时调用的方法(onScroll)

在滚动状态发生改变的方法中，有三种状态：手指按下移动的状态： SCROLL_STATE_TOUCH_SCROLL:触摸滑动，惯性滚动（滑翔（flgin）状态）： SCROLL_STATE_FLING: 滑翔，静止状态： SCROLL_STATE_IDLE: // 静止，对不同的状态进行处理：

分批加载数据，只关心静止状态：关心最后一个可见的条目，如果最后一个可见条目就是数据适配器（集合）里的最后一个，此时可加载更多的数据。在每次加载的时候，计算出滚动的数量，当滚动的数量大于等于总数量的时候，可以提示用户无更多数据了。


### 6、如何将打开res aw目录中的数据库文件?

**1、** 在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

**2、** 复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。

**3、** 在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 7、谈谈Android的IPC（进程间通信）机制

IPC是内部进程通信的简称， 是共享"命名管道"的资源。Android中的IPC机制是为了让Activity和Service之间可以随时的进行交互，故在Android中该机制，只适用于Activity和Service之间的通信，类似于远程方法调用，类似于C/S模式的访问。通过定义AIDL接口文件来定义IPC接口。Servier端实现IPC接口，Client端调用IPC接口本地代理。


### 8、IntentService有何优点?
### 9、View的绘制原理
### 10、自定义view的基本流程
### 11、音视频相关类
### 12、如何保存activity的状态？
### 13、说下Activity 的四种启动模式、应用场景 ？
### 14、跟activity和Task 有关的 Intent启动方式有哪些？其含义？
### 15、Android中4大组件
### 16、什么是aar?aar是jar有什么区别?
### 17、如何切换 fragement,不重新实例化
### 18、GLSurfaceView
### 19、Fragment中add与replace的区别？
### 20、描述一下android的系统架构
### 21、如果Listview中的数据源发生改变，如何更新listview中的数据
### 22、即时通讯是是怎么做的?
### 23、View的分发机制，滑动冲突
### 24、属性动画
### 25、一条最长的短信息约占多少byte?
### 26、内存溢出和内存泄漏有什么区别？何时会产生内存泄漏？
### 27、补间动画
### 28、Android中，帧动画
### 29、AsyncTask
### 30、如何启用Service，如何停用Service。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
