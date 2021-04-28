# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、谈MVC ，MVP，MVVM

MVC:View是可以直接访问Model的！从而，View里会包含Model信息，不可避免的还要包括一些 业务逻辑。 在MVC模型里，更关注的Model的不变，而同时有多个对Model的不同显示，及View。所以，在MVC模型里，Model不依赖于View，但是 View是依赖于Model的。不仅如此，因为有一些业务逻辑在View里实现了，导致要更改View也是比较困难的，至少那些业务逻辑是无法重用的。

MVP：MVP 是从经典的模式MVC演变而来，它们的基本思想有相通的地方：Controller/Presenter负责逻辑的处理，Model提供数据，View负 责显示。作为一种新的模式，MVP与MVC有着一个重大的区别：在MVP中View并不直接使用Model，它们之间的通信是通过Presenter (MVC中的Controller)来进行的，所有的交互都发生在Presenter内部，而在MVC中View会从直接Model中读取数据而不是通过 Controller。

MVVM：数据双向绑定，通过数据驱动UI，M提供数据，V视图，VM即数据驱动层


### 2、Android 引入广播机制的用意

从 MVC 的角度考虑(应用程序内) 其实回答这个问题的时候还可以这样问，android 为什么要有那 4 大组件，现在的移动开发模型基本上也是照搬的 web 那一套 MVC 架构，只不过稍微做了修改。android 的四大组件本质上就是为了实现移动或者说嵌入式设备上的 MVC 架构，它们之间有时候是一种相互依存的关系，有时候又是一种补充关系，引入广播机制可以方便几大组件的信息和数据交互。

程序间互通消息(例如在自己的应用程序内监听系统来电)

效率上(参考 UDP 的广播协议在局域网的方便性)

设计模式上(反转控制的一种应用，类似监听者模式)


### 3、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？

在两个应用的manifest配置中好相同的shartdUserId属性，A应用正常保存数据，B应用

createPackageContext("com.netease.nim.demo", CONTEXT_IGNORE_SECURITY)

获取context然后获取应用数据，为保证数据安全，使用加密存储


### 4、android:gravity与android:layout_gravity的区别

gravity：表示组件内元素的对齐方式

layout_gravity：相对于父类容器，该视图组件的对齐方式


### 5、描述一下android的系统架构

android系统架构分从下往上为linux 内核层、运行库、应用程序框架层、和应用程序层。

linuxkernel：负责硬件的驱动程序、网络、电源、系统安全以及内存管理等功能。

libraries和 android runtime：libraries：即c/c++函数库部分，大多数都是开放源代码的函数库，例如webkit（引擎），该函数库负责 android网页浏览器的运行，例如标准的c函数库libc、openssl、sqlite等，当然也包括支持游戏开发2dsgl和 3dopengles，在多媒体方面有mediaframework框架来支持各种影音和图形文件的播放与显示，例如mpeg4、h.264、mp3、 aac、amr、jpg和png等众多的多媒体文件格式。android的runtime负责解释和执行生成的dalvik格式的字节码。

applicationframework（应用软件架构），java应用程序开发人员主要是使用该层封装好的api进行快速开发。

applications:该层是java的应用程序层，android内置的googlemaps、e-mail、即时通信工具、浏览器、mp3播放器等处于该层，java开发人员开发的程序也处于该层，而且和内置的应用程序具有平等的位置，可以调用内置的应用程序，也可以替换内置的应用程序。

上面的四个层次，下层为上层服务，上层需要下层的支持，调用下层的服务，这种严格分层的方式带来的极大的稳定性、灵活性和可扩展性，使得不同层的开发人员可以按照规范专心特定层的开发。

android应用程序使用框架的api并在框架下运行，这就带来了程序开发的高度一致性，另一方面也告诉我们，要想写出优质高效的程序就必须对整个 applicationframework进行非常深入的理解。精通applicationframework，你就可以真正的理解android的设计和运行机制，也就更能够驾驭整个应用层的开发。


### 6、Fragment的生命周期

Fragment的生命周期

![92_2.png][92_2.png]

Fragment与Activity生命周期对比

![92_3.png][92_3.png]

Fragment的生命周期方法主要有onAttach()、onCreate()、onCreateView()、onActivityCreated()、onstart()、onResume()、onPause()、onStop()、onDestroyView()、onDestroy()、onDetach()等11个方法。

**1、** 切换到该Fragment，分别执行onAttach()、onCreate()、onCreateView()、onActivityCreated()、onstart()、onResume()方法。

**2、** 锁屏，分别执行onPause()、onStop()方法。

**3、** 亮屏，分别执行onstart()、onResume()方法。

**4、** 覆盖，切换到其他Fragment，分别执行onPause()、onStop()、onDestroyView()方法。

**5、** 从其他Fragment回到之前Fragment，分别执行onCreateView()、onActivityCreated()、onstart()、onResume()方法。


### 7、在 service 的生命周期方法 onstartConmand()可不可以执行网络操作？如何在 service 中执行网络操作？

可以的，就在onstartConmand方法内执行。


### 8、Android root机制

root指的是你有权限可以再系统上对所有档案有 "读" "写" "执行"的权力。root机器不是真正能让你的应用程序具有root权限。它原理就跟linux下的像sudo这样的命令。在系统的bin目录下放个su程序并属主是root并有suid权限。则通过su执行的命令都具有Android root权限。当然使用临时用户权限想把su拷贝的/system/bin目录并改属性并不是一件容易的事情。这里用到2个工具跟2个命令。把busybox拷贝到你有权限访问的目录然后给他赋予4755权限，你就可以用它做很多事了。


### 9、Activity的状态有几种？

```
运行
暂停
停止
```


### 10、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？

FragmentPagerAdapter 的每个 Fragment 会持久的保存在 FragmentManager 中，只要用户可以返回到页面中，它都不会被销毁。因此适用于那些数据 相对静态的页，Fragment 数量也比较少的那种;FragmentStatePagerAdapter 只保留当前页面，当页面不可见时，该 Fragment 就会被消除，释放其资源。因此适用于那些 数据动态性较大、 占用内存较多，多 Fragment 的情况；


### 11、请介绍下Android中常用的五种布局。
### 12、Android 中如何捕获未捕获的异常
### 13、Android 判断SD卡是否存在
### 14、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布
### 15、说说 LruCache 底层原理
### 16、jni 的调用过程?
### 17、子线程中能不能 new handler？为什么？
### 18、DDMS和TraceView的区别?
### 19、Android数字签名
### 20、ListView优化
### 21、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?
### 22、推送到达率如何提高
### 23、Android i18n
### 24、sim卡的EF 文件有何作用
### 25、自定义view的基本流程
### 26、16Android性能优化
### 27、Android 应用中验证码登陆都有哪些实现方案
### 28、如何修改 Activity 进入和退出动画
### 29、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？
### 30、NDK是什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
