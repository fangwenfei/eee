# Android最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、请介绍下 AsyncTask 的内部实现和适用的场景

AsyncTask 内部也是 Handler 机制来完成的，只不过 Android 提供了执行框架来提供线程池来执行相应地任务，因为线程池的大小问题，所以 AsyncTask 只应该用来执行耗时时间较短的任务，比如 HTTP 请求，大规模的下载和数据库的更改不适用于 AsyncTask，因为会导致线程池堵塞，没有线程来执行其他的任务，导致的情形是会发生 AsyncTask 根本执行不了的问题


### 2、Android中4大组件

**1、** Activity：Activity是Android程序与用户交互的窗口，是Android构造块中最基本的一种，它需要为保持各界面的状态，做很多持久化的事情，妥善管理生命周期以及一些跳转逻辑。

**2、** BroadCast Receiver：接受一种或者多种Intent作触发事件，接受相关消息，做一些简单处理，转换成一条Notification，统一了Android的事件广播模型。

**3、** Content Provider：是Android提供的第三方应用数据的访问方案，可以派生Content Provider类，对外提供数据，可以像数据库一样进行选择排序，屏蔽内部数据的存储细节，向外提供统一的接口模型，大大简化上层应用，对数据的整合提 供了更方便的途径。

**4、** service：后台服务于Activity，封装有一个完整的功能逻辑实现，接受上层指令，完成相关的事务，定义好需要接受的Intent提供同步和异步的接口。


### 3、自定义view的基本流程

**1、** 自定义View的属性 编写attr.xml文件

**2、** 在layout布局文件中引用，同时引用命名空间

**3、** 在View的构造方法中获得我们自定义的属性 ，在自定义控件中进行读取（构造方法拿到attr.xml文件值）

**4、** 重写onMesure

**5、** 重写onDraw


### 4、Activity的状态有几种？

```
运行
暂停
停止
```


### 5、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

把这个文件放在/res/raw目录下即可。res\raw目录中的文件不会被压缩，这样可以直接提取该目录中的文件，会生成资源id。


### 6、如何在 ScrollView 中如何嵌入 ListView

通常情况下我们不会在 ScrollView 中嵌套 ListView。

在 ScrollView 添加一个 ListView 会导致 listview 控件显示不全，通常只会显示一条，这是因为两个控件的滚动事件冲突导致。所以需要通过 listview 中的 item 数量去计算 listview 的显示高度，从而使其完整展示。

现阶段最好的处理的方式是： 自定义 ListView，重载 onMeasure()方法，设置全部显示。


### 7、Service生命周期

在Service的生命周期里，常用的有：

4个手动调用的方法

```
startService()    启动服务
stopService()    关闭服务
bindService()    绑定服务
unbindService()    解绑服务
```

5个内部自动调用的方法

```
onCreat()            创建服务
onStartCommand()    开始服务
onDestroy()            销毁服务
onBind()            绑定服务
onUnbind()            解绑服务
```

**1、** 手动调用startService()启动服务，自动调用内部方法：onCreate()、onStartCommand()，如果一个Service被startService()多次启动，那么onCreate()也只会调用一次。

**2、** 手动调用stopService()关闭服务，自动调用内部方法：onDestory()，如果一个Service被启动且被绑定，如果在没有解绑的前提下使用stopService()关闭服务是无法停止服务的。

**3、** 手动调用bindService()后，自动调用内部方法：onCreate()、onBind()。

**4、** 手动调用unbindService()后，自动调用内部方法：onUnbind()、onDestory()。

**5、** startService()和stopService()只能开启和关闭Service，无法操作Service，调用者退出后Service仍然存在；bindService()和unbindService()可以操作Service，调用者退出后，Service随着调用者销毁。


### 8、AsyncTask使用在哪些场景？它的缺陷是什么？如何解决？

AsyncTask 运用的场景就是我们需要进行一些耗时的操作，耗时操作完成后更新主线程，或者在操作过程中对主线程的UI进行更新。

缺陷：AsyncTask中维护着一个长度为128的线程池，同时可以执行5个工作线程，还有一个缓冲队列，当线程池中已有128个线程，缓冲队列已满时，如果 此时向线程提交任务，将会抛出RejectedExecutionException。

解决：由一个控制线程来处理AsyncTask的调用判断线程池是否满了，如果满了则线程睡眠否则请求AsyncTask继续处理。


### 9、如何对 Android 应用进行性能分析

如果不考虑使用其他第三方性能分析工具的话，我们可以直接使用 ddms 中的工具，其实 ddms 工具已经非常的强大了。ddms 中有 traceview、heap、allocation tracker 等工具都可以帮助我们分析应用的方法执行时间效率和内存使用情况。

Traceview 是 Android 平台特有的数据采集和分析工具，它主要用于分析 Android 中应用程序的 hotspot（瓶颈）。Traceview 本身只是一个数据分析工具，而数据的采集则需要使用 AndroidSDK 中的 Debug 类或者利用 DDMS 工具。

heap 工具可以帮助我们检查代码中是否存在会造成内存泄漏的地方。

allocation tracker 是内存分配跟踪工具


### 10、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？

在onPuase方法中调用onSavedInstanceState()


### 11、Android 判断SD卡是否存在
### 12、请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系。
### 13、事件分发中的 onTouch 和 onTouchEvent 有什么区别，又该如何使用？
### 14、9.进程和线程的区别
### 15、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？
### 16、即时通讯是是怎么做的?
### 17、ListView 如何实现分页加载
### 18、在 service 的生命周期方法 onstartConmand()可不可以执行网络操作？如何在 service 中执行网络操作？
### 19、启动一个程序，可以主界面点击图标进入，也可以从一个程序中跳转过去，二者有什么区别？
### 20、注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意。
### 21、AIDL 的全称是什么?如何工作?能处理哪些类型的数据？
### 22、Fragment 在你们项目中的使用
### 23、ListView 如何提高其效率？
### 24、activity的生命周期
### 25、如何启用Service，如何停用Service。
### 26、ContentProvider与sqlite有什么不一样的？
### 27、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布
### 28、描述下Handler 机制
### 29、内存溢出和内存泄漏有什么区别？何时会产生内存泄漏？
### 30、如何退出Activity




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
