# Android最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、RecyclerView和ListView的区别

缓存上:前者缓存的是View+ViewHolder+flag，不用每次调用findViewById,后者则只是缓存View

刷新数据方面，前者提供了局部刷新，后者则全部刷新


### 2、Service和Thread的区别？

servie是系统的组件，它由系统进程托管（servicemanager）；它们之间的通信类似于client和server，是一种轻量级的ipc通信，这种通信的载体是binder，它是在linux层交换信息的一种ipc。而thread是由本应用程序托管。1)、Thread：Thread 是程序执行的最小单元，它是分配CPU的基本单位。可以用 Thread 来执行一些异步的操作。

2)、Service：Service 是android的一种机制，当它运行的时候如果是Local Service，那么对应的 Service 是运行在主进程的 main 线程上的。如：onCreate，onStart 这些函数在被系统调用的时候都是在主进程的 main 线程上运行的。如果是Remote Service，那么对应的 Service 则是运行在独立进程的 main 线程上。

既然这样，那么我们为什么要用 Service 呢？其实这跟 android 的系统机制有关，我们先拿 Thread 来说。Thread 的运行是独立于 Activity 的，也就是说当一个 Activity 被 finish 之后，如果你没有主动停止 Thread 或者 Thread 里的 run 方法没有执行完毕的话，Thread 也会一直执行。因此这里会出现一个问题：当 Activity 被 finish 之后，你不再持有该 Thread 的引用。另一方面，你没有办法在不同的 Activity 中对同一 Thread 进行控制。

举个例子：如果你的 Thread 需要不停地隔一段时间就要连接服务器做某种同步的话，该 Thread 需要在 Activity 没有start的时候也在运行。这个时候当你 start 一个 Activity 就没有办法在该 Activity 里面控制之前创建的 Thread。因此你便需要创建并启动一个 Service ，在 Service 里面创建、运行并控制该 Thread，这样便解决了该问题（因为任何 Activity 都可以控制同一 Service，而系统也只会创建一个对应 Service 的实例）。

因此你可以把 Service 想象成一种消息服务，而你可以在任何有 Context 的地方调用 Context.startService、Context.stopService、Context.bindService，Context.unbindService，来控制它，你也可以在 Service 里注册 BroadcastReceiver，在其他地方通过发送 broadcast 来控制它，当然这些都是 Thread 做不到的。


### 3、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

把这个文件放在/res/raw目录下即可。res\raw目录中的文件不会被压缩，这样可以直接提取该目录中的文件，会生成资源id。


### 4、ListView 如何提高其效率？

当 convertView 为空时，用 setTag()方法为每个 View 绑定一个存放控件的 ViewHolder 对象。当convertView 不为空， 重复利用已经创建的 view 的时候， 使用 getTag()方法获取绑定的 ViewHolder对象，这样就避免了 findViewById 对控件的层层查询，而是快速定位到控件。 复用 ConvertView，使用历史的 view，提升效率 200%

自定义静态类 ViewHolder，减少 findViewById 的次数。提升效率 50%

异步加载数据，分页加载数据。

使用 WeakRefrence 引用 ImageView 对象


### 5、谈谈对Android NDK的理解

NDK是一系列工具的集合.NDK提供了一系列的工具,帮助开发者快速开发C或C++的动态库,并能自动将so和java应用一起打包成apk.这些工具对开发者的帮助是巨大的.NDK集成了交叉编译器,并提供了相应的mk文件隔离CPU,平台,ABI等差异,开发人员只需要简单修改 mk文件(指出"哪些文件需要编译","编译特性要求"等),就可以创建出so.

NDK可以自动地将so和Java应用一起打包,极大地减轻了开发人员的打包工作.NDK提供了一份稳定,功能有限的API头文件声明.

Google明确声明该API是稳定的,在后续所有版本中都稳定支持当前发布的API.从该版本的NDK中看出,这些 API支持的功能非常有限,包含有:C标准库(libc),标准数学库(libm ),压缩库(libz),Log库(liblog).


### 6、Android中的长度单位详解

```
Px：像素
Sp与dp也是长度单位，但是与屏幕的单位密度无关。
```


### 7、Android与服务器交互的方式中的对称加密和非对称加密是什么?

对称加密，就是加密和解密数据都是使用同一个key，这方面的算法有DES。

非对称加密，加密和解密是使用不同的key。发送数据之前要先和服务端约定生成公钥和私钥，使用公钥加密的数据可以用私钥解密，反之。这方面的算法有RSA。ssh 和 ssl都是典型的非对称加密。


### 8、消息推送的方式

**1、** 使用极光和友盟推送。

**2、** 使用XMPP协议（Openfire + Spark + Smack）

**简介：**基于XML协议的通讯协议，前身是Jabber，目前已由IETF国际标准化组织完成了标准化工作。

**优点：**协议成熟、强大、可扩展性强、目前主要应用于许多聊天系统中，且已有开源的Java版的开发实例androidpn。

**缺点：**协议较复杂、冗余（基于XML）、费流量、费电，部署硬件成本高。

**3、** 使用MQTT协议（更多信息见：[mqtt.org/）][mqtt.org]

**简介：**轻量级的、基于代理的“发布/订阅”模式的消息传输协议。

**优点：**协议简洁、小巧、可扩展性强、省流量、省电，目前已经应用到企业领域（参考：[mqtt.org/software），且…][mqtt.org_software]

**缺点：**不够成熟、实现较复杂、服务端组件rsmb不开源，部署硬件成本较高。

**4、** 使用HTTP轮循方式

**简介：**定时向HTTP服务端接口（Web Service API）获取最新消息。

**优点：**实现简单、可控性强，部署硬件成本低。

**缺点：**实时性差。


### 9、String,StringBuffer,StringBuilder的区别

String不可改变对象，一旦创建就不能修改

```
String str="aaa";
str="bbb";
```

以上代码虽然改变了str，但是执行过程是回收str，把值赋给一个新的str

StringBuffer创建之后，可以去修改

StringBuilder也可修改，执行效率高于StringBuffer，不安全

当字符赋值少使用String

字符赋值频繁使用StringBuilder

当多个线程同步操作数据，使用StringBuffer


### 10、Service 里面可以弹吐司么

可以。


### 11、都使用过哪些自定义控件
### 12、Android中常用布局
### 13、谈谈Android的IPC（进程间通信）机制
### 14、请解释下Android程序运行时权限与文件系统权限的区别。
### 15、sim卡的EF文件是什么？有何作用
### 16、跟activity和Task 有关的 Intent启动方式有哪些？其含义？
### 17、View的绘制原理
### 18、Manifest.xml文件中主要包括哪些信息？
### 19、如何在 ScrollView 中如何嵌入 ListView
### 20、请描述下Activity的生命周期。
### 21、如果Listview中的数据源发生改变，如何更新listview中的数据
### 22、Android 应用中验证码登陆都有哪些实现方案
### 23、音视频相关类
### 24、Android中4大组件
### 25、注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意。
### 26、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系
### 27、Android中任务栈的分配
### 28、activity，service，intent之间的关系
### 29、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
