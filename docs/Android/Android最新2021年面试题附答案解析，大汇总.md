# Android最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、说下Activity 的四种启动模式、应用场景 ？

standard 标准模式： 每次启动一个 Activity 都会重新创建一个新的实例，不管这个实例是否已经存在，此模式的 Activity 默认会进入启动它的 Activity 所属的任务栈中； singleTop 栈顶复用模式： 如果新 Activity 已经位于任务栈的栈顶，那么此 Activity 不会被重新创建，同时会回调 onNewIntent方法，如果新 Activity 实例已经存在但不在栈顶，那么Activity 依然会被重新创建；

singleTask 栈内复用模式： 只要 Activity 在一个任务栈中存在，那么多次启动此 Activity 都不会重新创建实例，并回调onNewIntent 方法，此模式启动 Activity A，系统首先会寻找是否存在 A 想要的任务栈，如果不存在，就会重新创建一个任务栈，然后把创建好 A 的实例放到栈中；

singleInstance单实例模式： 这是一种加强的 singleTask 模式，具有此种模式的 Activity 只能单独地位于一个任务栈中，且此任务栈中只有唯一一个实例；


### 2、请描述一下 Intent 和 IntentFilter

```
Intent是组件的通讯使者，可以在组件间传递消息和数据。
IntentFilter是intent的筛选器，可以对intent的action，data，catgory，uri这些属性进行筛选，确定符合的目标组件。
```


### 3、activity与fragment区别

生命周期：

fragment从创建倒销毁整个生命周期依次为onAttach()→onCreate()→onCreateView()→onActivityCreated()→onStart()→onResume()→onPause()→onStop()→onDestroyView()→onDestroy()→onDetach()

**与activity不同的方法有**

**1、** onAttach():当Fragment和Activity建立关联的时候调用；

**2、** onCreateView():当Fragment创建视图调用；

**3、** onActivityCreated:与Fragment相关联的Activity完成onCreate()之后调用；

**4、** onDestoryView():在Fragment中的布局被移除时调用；

**5、** onDetach():当Fragment和Activity解除关联时调用；

**6、** activity常用的生命周期只有以下几个；

**7、** onCreate()： 表示 Activity 正在被创建，常用来 初始化工作，比如调用 setContentView 加载界面布局资源，初始化 Activity 所需数据等；

**8、** onRestart()：表示 Activity 正在重新启动，一般情况下，当前Acitivty 从不可见重新变为可见时，OnRestart就会被调用；

**9、** onStart()： 表示 Activity 正在被启动，此时 Activity 可见但不在前台，还处于后台，无法与用户交互；

**10、** onResume()： 表示 Activity 获得焦点，此时 Activity 可见且在前台并开始活动，这是与 onStart 的区别所在；

**11、** onPause()： 表示 Activity 正在停止，此时可做一些 存储数据、停止动画等工作，但是不能太耗时，因为这会影响到新 Activity的显示，onPause 必须先执行完，新 Activity 的 onResume 才会执行；

**12、** onStop()： 表示 Activity 即将停止，可以做一些稍微重量级的回收工作，比如注销广播接收器、关闭网络连接等，同样不能太耗时；

**13、** onDestroy()： 表示 Activity 即将被销毁，这是 Activity 生命周期中的最后一个回调，常做 回收工作、资源释放；

**14、** 区别：

**15、** Fragment比Activity多出四个回调周期，控制操作上更灵活；

**16、** Fragment可以在xml文件中直接写入，也可以在Activity中动态添加；

**17、** Fragment可以使用show()/hide()或者replace()对Fragment进行切换，切换的时候不会出现明显的效果，Activity切换的时候会有明显的翻页或其他效果；


### 4、android系统的优势和不足

Android平台手机 5大优势：

**一、开放性**

在优势方面，Android平台首先就是其开发性，开发的平台允许任何移动终端厂商加入到Android联盟中来。显著的开放性可以使其拥有更多的开发者，随着用户和应用的日益丰富，一个崭新的平台也将很快走向成熟。开放性对于Android的发展而言，有利于积累人气，这里的人气包括消费者和厂商，而对于消费者来讲，随大的受益正是丰富的软件资源。开放的平台也会带来更大竞争，如此一来，消费者将可以用更低的价位购得心仪的手机。

**二、挣脱运营商的束缚**

在过去很长的一段时间，特别是在欧美地区，手机应用往往受到运营商制约，使用什么功能接入什么网络，几乎都受到运营商的控制。从去年iPhone 上市 ，用户可以更加方便地连接网络，运营商的制约减少。随着EDGE、HSDPA这些2G至3G移动网络的逐步过渡和提升，手机随意接入网络已不是运营商口中的笑谈，当你可以通过手机IM软件方便地进行即时聊天时，再回想不久前天价的彩信和图铃下载业务，是不是像噩梦一样？互联网巨头Google推动的Android终端天生就有网络特色，将让用户离互联网更近。

**三、丰富的硬件选择**

这一点还是与Android平台的开放性相关，由于Android的开放性，众多的厂商会推出千奇百怪，功能特色各具的多种产品。功能上的差异和特色，却不会影响到数据同步、甚至软件的兼容，好比你从诺基亚 Symbian风格手机 一下改用苹果 iPhone ，同时还可将Symbian中优秀的软件带到iPhone上使用、联系人等资料更是可以方便地转移，是不是非常方便呢？

**四、不受任何限制的开发商**

Android平台提供给第三方开发商一个十分宽泛、自由的环境，不会受到各种条条框框的阻扰，可想而知，会有多少新颖别致的软件会诞生。但也有其两面性，血腥、暴力、情色方面的程序和游戏如可控制正是留给Android难题之一。

**五、无缝结合的Google应用**

如今叱诧互联网的Google已经走过10年度历史，从搜索巨人到全面的互联网渗透，Google服务如地图、邮件、搜索等已经成为连接用户和互联网的重要纽带，而Android平台手机将无缝结合这些优秀的Google服务。

**再说Android的5大不足：**

**一、安全和隐私**

由于手机 与互联网的紧密联系，个人隐私很难得到保守。除了上网过程中经意或不经意留下的个人足迹，Google这个巨人也时时站在你的身后，洞穿一切，因此，互联网的深入将会带来新一轮的隐私危机。

**二、首先开卖Android手机的不是最大运营商**

众所周知，T-Mobile在23日，于美国纽约发布 了Android首款手机G1。但是在北美市场，最大的两家运营商乃AT&T和Verizon，而目前所知取得Android手机销售权的仅有 T-Mobile和Sprint，其中T-Mobile的3G网络相对于其他三家也要逊色不少，因此，用户可以买账购买G1，能否体验到最佳的3G网络服务则要另当别论了！

**三、运营商仍然能够影响到Android手机**

在国内市场，不少用户对购得移动定制机不满，感觉所购的手机被人涂画了广告一般。这样的情况在国外市场同样出现。Android手机的另一发售运营商Sprint就将在其机型中内置其手机商店程序。

**四、同类机型用户减少**

在不少手机论坛都会有针对某一型号的子论坛，对一款手机的使用心得交流，并分享软件资源。而对于Android平台手机，由于厂商丰富，产品类型多样，这样使用同一款机型的用户越来越少，缺少统一机型的程序强化。举个稍显不当的例子，现在山寨机泛滥，品种各异，就很少有专门针对某个型号山寨机的讨论和群组，除了哪些功能异常抢眼、颇受追捧的机型以外。

**五、过分依赖开发商缺少标准配置**

在使用PC端的Windows Xp系统的时候，都会内置微软Windows Media Player这样一个浏览器程序，用户可以选择更多样的播放器，如Realplay或暴风影音等。但入手开始使用默认的程序同样可以应付多样的需要。在 Android平台中，由于其开放性，软件更多依赖第三方厂商，比如Android系统的SDK中就没有内置音乐 播放器，全部依赖第三方开发，缺少了产品的统一性。


### 5、跨进程通信的几种方式

Intent,比如拨打电话

ContentProvider数据库存储数据

Broadcast广播通信

AIDL通信，通过接口共享数据


### 6、描述下Handler 机制

**1、** Looper: 一个线程可以产生一个Looper对象，由它来管理此线程里的MessageQueue(消息队列)。

**2、** Handler: 你可以构造Handler对象来与Looper沟通，以便push新消息到MessageQueue里;或者接收Looper从Message Queue取出)所送来的消息。

**3、** Message Queue(消息队列):用来存放线程放入的消息。

**4、** 线程：UIthread 通常就是main thread，而Android启动程序时会替它建立一个MessageQueue。

Hander持有对UI主线程消息队列MessageQueue和消息循环Looper的引用，子线程可以通过Handler将消息发送到UI线程的消息队列MessageQueue中。


### 7、Android 线程间通信有哪几种方式（重要）

```
共享内存（变量）；
文件，数据库；
Handler；
Java 里的 wait()，notify()，notifyAll()
```


### 8、ListView 中图片错位的问题是如何产生的

图片错位问题的本质源于我们的 listview 使用了缓存 convertView， 假设一种场景， 一个 listview一屏显示九个 item，那么在拉出第十个 item 的时候，事实上该 item 是重复使用了第一个 item，也就是说在第一个 item 从网络中下载图片并最终要显示的时候，其实该 item 已经不在当前显示区域内了，此时显示的后果将可能在第十个 item 上输出图像，这就导致了图片错位的问题。所以解决办法就是可见则显示，不可见则不显示。


### 9、activity，fragment传值问题

通过Bundle传值，在activty定义变量传值，扩展fragment创建传值


### 10、Serializable 和 Parcelable 的区别？

如果存储在内存中，推荐使用parcelable，使用serialiable在序列化的时候会产生大量的临时变量，会引起频繁的GC

如果存储在硬盘上，推荐使用Serializable，虽然serializable效率较低

Serializable的实现：只需要实现Serializable接口，就会自动生成一个序列化id

Parcelable的实现：需要实现Parcelable接口，还需要Parcelable.CREATER变量


### 11、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？
### 12、开发中都使用过哪些框架、平台
### 13、android的数据存储
### 14、请介绍下Android中常用的五种布局。
### 15、AIDL的全称是什么？如何工作？能处理哪些类型的数据？
### 16、AIDL 的全称是什么?如何工作?能处理哪些类型的数据？
### 17、NDK是什么
### 18、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？
### 19、Activity的状态有几种？
### 20、请介绍下 ContentProvider 是如何实现数据共享的
### 21、Hander原理
### 22、9.进程和线程的区别
### 23、Android i18n
### 24、ListView 可以显示多种类型的条目吗
### 25、如何将一个Activity设置成窗口的样式。
### 26、描述一下android的系统架构
### 27、什么是 AIDL？如何使用？
### 28、AsyncTask
### 29、了解IntentServices吗?
### 30、Android的四大组件是哪些，它们的作用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
