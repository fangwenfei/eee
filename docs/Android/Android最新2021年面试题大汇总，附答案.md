# Android最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、跨进程通信的几种方式

Intent,比如拨打电话

ContentProvider数据库存储数据

Broadcast广播通信

AIDL通信，通过接口共享数据


### 2、说下Activity 的四种启动模式、应用场景 ？

standard 标准模式： 每次启动一个 Activity 都会重新创建一个新的实例，不管这个实例是否已经存在，此模式的 Activity 默认会进入启动它的 Activity 所属的任务栈中； singleTop 栈顶复用模式： 如果新 Activity 已经位于任务栈的栈顶，那么此 Activity 不会被重新创建，同时会回调 onNewIntent方法，如果新 Activity 实例已经存在但不在栈顶，那么Activity 依然会被重新创建；

singleTask 栈内复用模式： 只要 Activity 在一个任务栈中存在，那么多次启动此 Activity 都不会重新创建实例，并回调onNewIntent 方法，此模式启动 Activity A，系统首先会寻找是否存在 A 想要的任务栈，如果不存在，就会重新创建一个任务栈，然后把创建好 A 的实例放到栈中；

singleInstance单实例模式： 这是一种加强的 singleTask 模式，具有此种模式的 Activity 只能单独地位于一个任务栈中，且此任务栈中只有唯一一个实例；


### 3、ContentProvider与sqlite有什么不一样的？

```
ContentProvider会对外隐藏内部实现，只需要关注访问contentProvider的uri即可，contentProvider应用在应用间共享。
Sqlite操作本应用程序的数据库。
ContentProiver可以对本地文件进行增删改查操作
```


### 4、activity的启动模式有哪些？是什么含义

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


### 5、ListView的优化方案

**1、** 如果自定义适配器，那么在getView方法中要考虑方法传进来的参数contentView是否为null，如果为null就创建contentView并返回，如果不为null则直接使用。在这个方法中尽可能少创建view。

**2、** 给contentView设置tag（setTag（）），传入一个viewHolder对象，用于缓存要显示的数据，可以达到图像数据异步加载的效果。

**3、** 如果listview需要显示的item很多，就要考虑分页加载。比如一共要显示100条或者更多的时候，我们可以考虑先加载20条，等用户拉到列表底部的时候再去加载接下来的20条。


### 6、如何将打开res aw目录中的数据库文件?

解在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 7、AIDL 的全称是什么?如何工作?能处理哪些类型的数据？

AIDL 全称 Android Interface Definition Language（AndRoid 接口描述语言） 是一种接口描述语言; 编译器可以通过 aidl 文件生成一段代码，通过预先定义的接口达到两个进程内部通信进程跨界对象访问的目的。需要完成两件事情：

**1、** 引入 AIDL 的相关类.;

**2、** 调用 aidl 产生的 class

理论上, 参数可以传递基本数据类型和 String, 还有就是 Bundle 的派生类, 不过在 Eclipse 中,目前的 ADT 不支持 Bundle 做为参数。


### 8、Android与服务器交互的方式中的对称加密和非对称加密是什么?

对称加密，就是加密和解密数据都是使用同一个key，这方面的算法有DES。

非对称加密，加密和解密是使用不同的key。发送数据之前要先和服务端约定生成公钥和私钥，使用公钥加密的数据可以用私钥解密，反之。这方面的算法有RSA。ssh 和 ssl都是典型的非对称加密。


### 9、RecyclerView和ListView的区别

缓存上:前者缓存的是View+ViewHolder+flag，不用每次调用findViewById,后者则只是缓存View

刷新数据方面，前者提供了局部刷新，后者则全部刷新


### 10、ListView 中图片错位的问题是如何产生的

图片错位问题的本质源于我们的 listview 使用了缓存 convertView， 假设一种场景， 一个 listview一屏显示九个 item，那么在拉出第十个 item 的时候，事实上该 item 是重复使用了第一个 item，也就是说在第一个 item 从网络中下载图片并最终要显示的时候，其实该 item 已经不在当前显示区域内了，此时显示的后果将可能在第十个 item 上输出图像，这就导致了图片错位的问题。所以解决办法就是可见则显示，不可见则不显示。


### 11、如何切换 fragement,不重新实例化
### 12、sim卡的EF文件是什么？有何作用
### 13、说下 Activity 跟 跟 window ， view 之间的关系？
### 14、简述JNI
### 15、SurfaceView
### 16、Android系统的架构
### 17、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？
### 18、什么是ANR 如何避免它？
### 19、android的数据存储
### 20、Activity启动模式
### 21、什么是aar?aar是jar有什么区别?
### 22、如何保存activity的状态？
### 23、广播注册
### 24、内存泄露如何查看和解决
### 25、谈谈对Android NDK的理解
### 26、嵌入式操作系统内存管理有哪几种， 各有何特性
### 27、Serializable 和 Parcelable 的区别？
### 28、简要解释一下activity、 intent 、intent filter、service、Broadcase、BroadcaseReceiver
### 29、Android中常用布局




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
