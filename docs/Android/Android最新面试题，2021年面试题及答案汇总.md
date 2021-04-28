# Android最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何保存activity的状态？

默认情况下activity的状态系统会自动保存，有些时候需要我们手动调用保存。

当activity处于onPause，onStop之后，activity处于未活动状态，但是activity对象却仍然存在。当内存不足，onPause，onStop之后的activity可能会被系统摧毁。

当通过返回退出activity时，activity状态并不会保存。

保存activity状态需要重写onSavedInstanceState()方法，在执行onPause,onStop之前调用onSavedInstanceState方法，onSavedInstanceState需要一个Bundle类型的参数，我们可以将数据保存到bundle中，通过实参传递给onSavedInstanceState方法。

Activity被销毁后，重新启动时，在onCreate方法中，接受保存的bundle参数，并将之前的数据取出。


### 2、ListView的优化方案

**1、** 如果自定义适配器，那么在getView方法中要考虑方法传进来的参数contentView是否为null，如果为null就创建contentView并返回，如果不为null则直接使用。在这个方法中尽可能少创建view。

**2、** 给contentView设置tag（setTag（）），传入一个viewHolder对象，用于缓存要显示的数据，可以达到图像数据异步加载的效果。

**3、** 如果listview需要显示的item很多，就要考虑分页加载。比如一共要显示100条或者更多的时候，我们可以考虑先加载20条，等用户拉到列表底部的时候再去加载接下来的20条。


### 3、Service和Thread的区别？

servie是系统的组件，它由系统进程托管（servicemanager）；它们之间的通信类似于client和server，是一种轻量级的ipc通信，这种通信的载体是binder，它是在linux层交换信息的一种ipc。而thread是由本应用程序托管。1)、Thread：Thread 是程序执行的最小单元，它是分配CPU的基本单位。可以用 Thread 来执行一些异步的操作。

2)、Service：Service 是android的一种机制，当它运行的时候如果是Local Service，那么对应的 Service 是运行在主进程的 main 线程上的。如：onCreate，onStart 这些函数在被系统调用的时候都是在主进程的 main 线程上运行的。如果是Remote Service，那么对应的 Service 则是运行在独立进程的 main 线程上。

既然这样，那么我们为什么要用 Service 呢？其实这跟 android 的系统机制有关，我们先拿 Thread 来说。Thread 的运行是独立于 Activity 的，也就是说当一个 Activity 被 finish 之后，如果你没有主动停止 Thread 或者 Thread 里的 run 方法没有执行完毕的话，Thread 也会一直执行。因此这里会出现一个问题：当 Activity 被 finish 之后，你不再持有该 Thread 的引用。另一方面，你没有办法在不同的 Activity 中对同一 Thread 进行控制。

举个例子：如果你的 Thread 需要不停地隔一段时间就要连接服务器做某种同步的话，该 Thread 需要在 Activity 没有start的时候也在运行。这个时候当你 start 一个 Activity 就没有办法在该 Activity 里面控制之前创建的 Thread。因此你便需要创建并启动一个 Service ，在 Service 里面创建、运行并控制该 Thread，这样便解决了该问题（因为任何 Activity 都可以控制同一 Service，而系统也只会创建一个对应 Service 的实例）。

因此你可以把 Service 想象成一种消息服务，而你可以在任何有 Context 的地方调用 Context.startService、Context.stopService、Context.bindService，Context.unbindService，来控制它，你也可以在 Service 里注册 BroadcastReceiver，在其他地方通过发送 broadcast 来控制它，当然这些都是 Thread 做不到的。


### 4、SurfaceView

基于view视图进行拓展的视图类，更适合2D游戏的开发，是view的子类，类似使用双缓机制，在新的线程中更新画面所以刷新界面速度比view快


### 5、SQLite支持事务吗?添加删除如何提高性能?

SQLite作为轻量级的数据库，比MySQL还小，但支持SQL语句查询，提高性能可以考虑通过原始经过优化的SQL查询语句方式处理


### 6、如何将打开res aw目录中的数据库文件?

**1、** 在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

**2、** 复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。

**3、** 在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 7、请描述一下 Intent 和 IntentFilter

```
Intent是组件的通讯使者，可以在组件间传递消息和数据。
IntentFilter是intent的筛选器，可以对intent的action，data，catgory，uri这些属性进行筛选，确定符合的目标组件。
```


### 8、Android i18n

I18n 叫做国际化。android 对i18n和L10n提供了非常好的支持。软件在res/vales 以及 其他带有语言修饰符的文件夹。如： values-zh 这些文件夹中 提供语言，样式，尺寸 xml 资源。


### 9、什么是 IntentService？有何优点？

IntentService 是 Service 的子类，比普通的 Service 增加了额外的功能。先看 Service 本身存在两个问题：

**1、** Service 不会专门启动一条单独的进程，Service 与它所在应用位于同一个进程中；

**2、** Service 也不是专门一条新线程，因此不应该在 Service 中直接处理耗时的任务；

**IntentService 特征**

**1、** 会创建独立的 worker 线程来处理所有的 Intent 请求；

**2、** 会创建独立的 worker 线程来处理 onHandleIntent()方法实现的代码，无需处理多线程问题；

**3、** 所有请求处理完成后，IntentService 会自动停止，无需调用 stopSelf()方法停止 Service；

**4、** 为 Service 的 onBind()提供默认实现，返回 null；

**5、** 为 Service 的 onStartCommand 提供默认实现，将请求 Intent 添加到队列中；


### 10、Android中的ANR

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


### 11、activity，service，intent之间的关系
### 12、广播注册
### 13、Android 中的动画有哪几类，它们的特点和区别是什么
### 14、AsyncTask使用在哪些场景？它的缺陷是什么？如何解决？
### 15、请介绍下 ContentProvider 是如何实现数据共享的
### 16、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？
### 17、如果有个100M大的文件，需要上传至服务器中，而服务器form表单最大只能上传2M，可以用什么方法。
### 18、请介绍下ContentProvider是如何实现数据共享的。
### 19、ListView优化
### 20、如何将打开res aw目录中的数据库文件?
### 21、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布
### 22、谈谈对Android NDK的理解
### 23、Android本身的api并未声明会抛出异常，则其在运行时有无可能抛出runtime异常，你遇到过吗？诺有的话会导致什么问题？如何解决？
### 24、描述一下android的系统架构
### 25、即时通讯是是怎么做的?
### 26、ListView 如何定位到指定位置
### 27、跨进程通信的几种方式
### 28、如何修改 Activity 进入和退出动画
### 29、Fragment 在你们项目中的使用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
