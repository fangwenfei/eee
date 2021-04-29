# Android最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何保存activity的状态？

默认情况下activity的状态系统会自动保存，有些时候需要我们手动调用保存。

当activity处于onPause，onStop之后，activity处于未活动状态，但是activity对象却仍然存在。当内存不足，onPause，onStop之后的activity可能会被系统摧毁。

当通过返回退出activity时，activity状态并不会保存。

保存activity状态需要重写onSavedInstanceState()方法，在执行onPause,onStop之前调用onSavedInstanceState方法，onSavedInstanceState需要一个Bundle类型的参数，我们可以将数据保存到bundle中，通过实参传递给onSavedInstanceState方法。

Activity被销毁后，重新启动时，在onCreate方法中，接受保存的bundle参数，并将之前的数据取出。


### 2、activity的启动模式有哪些？是什么含义

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


### 3、android:gravity与android:layout_gravity的区别

gravity：表示组件内元素的对齐方式

layout_gravity：相对于父类容器，该视图组件的对齐方式


### 4、IntentService有何优点?

Acitivity的进程，当处理Intent的时候，会产生一个对应的Service； Android的进程处理器现在会尽可能的不kill掉你；非常容易使用


### 5、activity，service，intent之间的关系

这三个都是android应用频率非常的组件。Activity与service是四大核心组件。Activity用来加载布局，显示窗口界面，service运行后台，没有界面显示，intent是activity与service的通信使者。


### 6、AsyncTask

AsyncTask的三个泛型参数说明

**1、** 第一个参数：传入doInBackground()方法的参数类型

**2、** 第二个参数：传入onProgressUpdate()方法的参数类型

**3、** 第三个参数：传入onPostExecute()方法的参数类型，也是doInBackground()方法返回的类型

运行在主线程的方法:

```
onPostExecute（）
onPreExecute()
onProgressUpdate(Progress...)
```

运行在子线程的方法：

```
doInBackground（）
```

控制AsyncTask停止的方法：

```
cancel(boolean mayInterruptIfRunning)
```

AsyncTask的执行分为四个步骤

**1、** 继承AsyncTask。

**2、** 实现AsyncTask中定义的下面一个或几个方法onPreExecute()、doInBackground(Params...)、onProgressUpdate(Progress...)、onPostExecute(Result)。

**3、** 调用execute方法必须在UI thread中调用。

**4、** 该task只能被执行一次，否则多次调用时将会出现异常，取消任务可调用cancel。


### 7、AsyncTask使用在哪些场景？它的缺陷是什么？如何解决？

AsyncTask 运用的场景就是我们需要进行一些耗时的操作，耗时操作完成后更新主线程，或者在操作过程中对主线程的UI进行更新。

缺陷：AsyncTask中维护着一个长度为128的线程池，同时可以执行5个工作线程，还有一个缓冲队列，当线程池中已有128个线程，缓冲队列已满时，如果 此时向线程提交任务，将会抛出RejectedExecutionException。

解决：由一个控制线程来处理AsyncTask的调用判断线程池是否满了，如果满了则线程睡眠否则请求AsyncTask继续处理。


### 8、子线程中能不能 new handler？为什么？

不能,如果在子线程中直接 new Handler()会抛出异常 java.lang.RuntimeException: Can'tcreate handler inside thread that has not called

在没有调用 Looper.prepare()的时候不能创建 Handler,因为在创建 Handler 的源码中做了如下操作

Handler 的构造方法中


### 9、你一般在开发项目中都使用什么设计模式？如何来重构，优化你的代码？

较为常用的就是单例设计模式，工厂设计模式以及观察者设计模式,

一般需要保证对象在内存中的唯一性时就是用单例模式,例如对数据库操作的 SqliteOpenHelper 的对象。

工厂模式主要是为创建对象提供过渡接口，以便将创建对象的具体过程屏蔽隔离起来，达到提高灵活性的目的。

观察者模式定义对象间的一种一对多的依赖关系，当一个对象的状态发生改变时，所有依赖于它的对象都得到通知并被自动更新


### 10、SurfaceView

基于view视图进行拓展的视图类，更适合2D游戏的开发，是view的子类，类似使用双缓机制，在新的线程中更新画面所以刷新界面速度比view快


### 11、请描述一下 Intent 和 IntentFilter
### 12、Fragment 的 replace 和 add 方法的区别
### 13、如何启用Service，如何停用Service。
### 14、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？
### 15、什么是IntentService？有何优点？
### 16、wait和 sleep 的区别
### 17、如果有个100M大的文件，需要上传至服务器中，而服务器form表单最大只能上传2M，可以用什么方法。
### 18、Android中4大组件
### 19、都使用过哪些自定义控件
### 20、android的数据存储
### 21、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系
### 22、Android中的ANR
### 23、Fragment与activity如何传值和交互？
### 24、Adapter是什么？你所接触过的adapter有那些？
### 25、sim卡的EF 文件有何作用
### 26、如何切换 fragement,不重新实例化
### 27、ListView优化
### 28、跨进程通信的几种方式
### 29、Service 和 Activity 在同一个线程吗




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
