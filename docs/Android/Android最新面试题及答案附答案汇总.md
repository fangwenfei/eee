# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简述TCP，UDP，Socket

TCP是经过3次握手，4次挥手完成一串数据的传送

UDP是无连接的，知道IP地址和端口号，向其发送数据即可，不管数据是否发送成功

Socket是一种不同计算机，实时连接，比如说传送文件，即时通讯


### 2、ListView 中图片错位的问题是如何产生的

图片错位问题的本质源于我们的 listview 使用了缓存 convertView， 假设一种场景， 一个 listview一屏显示九个 item，那么在拉出第十个 item 的时候，事实上该 item 是重复使用了第一个 item，也就是说在第一个 item 从网络中下载图片并最终要显示的时候，其实该 item 已经不在当前显示区域内了，此时显示的后果将可能在第十个 item 上输出图像，这就导致了图片错位的问题。所以解决办法就是可见则显示，不可见则不显示。


### 3、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。

XML解析主要有三种方式，SAX、DOM、PULL。常规在PC上开发我们使用Dom相对轻松些，但一些性能敏感的数据库或手机上还是主要采用SAX方式，SAX读取是单向的，优点:不占内存空间、解析属性方便，但缺点就是对于套嵌多个分支来说处理不是很方便。而DOM方式会把整个XML文件加载到内存中去，这里Android开发网提醒大家该方法在查找方面可以和XPath很好的结合如果数据量不是很大推荐使用，而PULL常常用在J2ME对于节点处理比较好，类似SAX方式，同样很节省内存，在J2ME中我们经常使用的KXML库来解析。


### 4、android中的动画有哪几类，它们的特点和区别是什么

两种，一种是Tween动画、还有一种是Frame动画。Tween动画，这种实现方式可以使视图组件移动、放大、缩小以及产生透明度的变化;另一种Frame动画，传统的动画方法，通过顺序的播放排列好的图片来实现，类似电影。


### 5、Intent 传递数据时，可以传递哪些类型数据？

```
基本数据类型以及对应的数组类型
可以传递bundle类型，但是bundle类型的数据需要实现Serializable或者parcelable接口
```


### 6、Android 中如何捕获未捕获的异常

**UncaughtExceptionHandler**

**1、** 自 定 义 一 个 Application ， 比 如 叫 MyApplication 继 承 Application 实 现UncaughtExceptionHandler。

**2、** 覆写 UncaughtExceptionHandler 的 onCreate 和 uncaughtException 方法。 注意：上面的代码只是简单的将异常打印出来。在 onCreate 方法中我们给 Thread 类设置默认异常处理 handler，如果这句代码不执行则一切都是白搭。在 uncaughtException 方法中我们必须新开辟个线程进行我们异常的收集工作，然后将系统给杀死。

**3、** 在 AndroidManifest 中配置该 Application：<application android:name="com.example.uncatchexception.MyApplication"

Bug 收集工具 Crashlytics

Crashlytics 是专门为移动应用开发者提供的保存和分析应用崩溃的工具。国内主要使用的是友盟做数据统计。

**Crashlytics 的好处：**

**1、** Crashlytics 不会漏掉任何应用崩溃信息。

**2、** Crashlytics 可以象 Bug 管理工具那样，管理这些崩溃日志。

**3、** Crashlytics 可以每天和每周将崩溃信息汇总发到你的邮箱，所有信息一目了然。


### 7、如何将打开res aw目录中的数据库文件?

**1、** 在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

**2、** 复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。

**3、** 在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 8、activity的生命周期

![92_1.png][92_1.png]

Activity生命周期方法主要有onCreate()、onStart()、onResume()、onPause()、onStop()、onDestroy()和onRestart()等7个方法。

**1、** 启动一个A Activity，分别执行onCreate()、onStart()、onResume()方法。

**2、** 从A Activity打开B Activity分别执行A onPause()、B onCreate()、B onStart()、B onResume()、A onStop()方法。

**3、** 关闭B Activity，分别执行B onPause()、A onRestart()、A onStart()、A onResume()、B onStop()、B onDestroy()方法。

**4、** 横竖屏切换A Activity，清单文件中不设置android:configChanges属性时，先销毁onPause()、onStop()、onDestroy()再重新创建onCreate()、onStart()、onResume()方法，设置orientation|screenSize（一定要同时出现）属性值时，不走生命周期方法，只会执行onConfigurationChanged()方法。

**5、** Activity之间的切换可以看出onPause()、onStop()这两个方法比较特殊，切换的时候onPause()方法不要加入太多耗时操作否则会影响体验。


### 9、一条最长的短信息约占多少byte?

中文70(包括标点)，英文160，160个字节。


### 10、SQLite支持事务吗?添加删除如何提高性能?

SQLite作为轻量级的数据库，比MySQL还小，但支持SQL语句查询，提高性能可以考虑通过原始经过优化的SQL查询语句方式处理


### 11、Activity的状态有几种？
### 12、说下 Activity 跟 跟 window ， view 之间的关系？
### 13、ListView 可以显示多种类型的条目吗
### 14、View的绘制原理
### 15、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？
### 16、NDK
### 17、如何对 Android 应用进行性能分析
### 18、Android中touch事件的传递机制是怎样的?
### 19、请解释下 Android 程序运行时权限与文件系统权限的区别？
### 20、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()
### 21、什么是 AIDL？如何使用？
### 22、android系统的优势和不足
### 23、谈谈Android的IPC（进程间通信）机制
### 24、Service 里面可以弹吐司么
### 25、推送到达率如何提高
### 26、Android 线程间通信有哪几种方式（重要）
### 27、即时通讯是是怎么做的?
### 28、RecyclerView和ListView的区别
### 29、为什么Android引入广播机制?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
