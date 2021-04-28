# Android最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、广播接受者的生命周期？

```
广播接收者的生命周期非常短。当执行onRecieve方法之后，广播就会销毁
在广播接受者不能进行耗时较长的操作
在广播接收者不要创建子线程。广播接收者完成操作后，所在进程会变成空进程，很容易被系统回收
```


### 2、Service 和 Activity 在同一个线程吗

默认情况下service与activity在同一个线程，都在main Thread，或者ui线程中。

如果在清单文件中指定service的process属性，那么service就在另一个进程中运行。


### 3、Android dvm的进程和Linux的进程, 应用程序的进程是否为同一个概念

DVM指dalivk的虚拟机。每一个Android应用程序都在它自己的进程中运行，都拥有一个独立的Dalvik虚拟机实例。而每一个DVM都是在Linux 中的一个进程，所以说可以认为是同一个概念。


### 4、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系

```
ContentProvider：内容提供者，对外提供数据的操作，contentProvider.notifyChanged(uir)：可以更新数据
contentResolver：内容解析者，解析ContentProvider返回的数据
ContentObServer:内容监听者，监听数据的改变，contentResolver.registerContentObServer()
```


### 5、Fragment 在你们项目中的使用

Fragment 是 android3.0 以后引入的的概念，做局部内容更新更方便，原来为了到达这一点要把多个布局放到一个 activity 里面，现在可以用多 Fragment 来代替，只有在需要的时候才加载Fragment，提高性能。

**Fragment 的好处：**

**1、** Fragment 可以使你能够将 activity 分离成多个可重用的组件，每个都有它自己的生命周期和UI。

**2、** Fragment 可以轻松得创建动态灵活的 UI 设计，可以适应于不同的屏幕尺寸。从手机到平板电脑。

**3、** Fragment 是一个独立的模块,紧紧地与 activity 绑定在一起。可以运行中动态地移除、加入、交换等。

**4、** Fragment 提供一个新的方式让你在不同的安卓设备上统一你的 UI。

**5、** Fragment 解决 Activity 间的切换不流畅，轻量切换。

**6、** Fragment 替代 TabActivity 做导航，性能更好。

**7、** Fragment 在 4.2.版本中新增嵌套 fragment 使用方法，能够生成更好的界面效果。


### 6、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

解可以将dictionary.db文件复制到Eclipse Android工程中的res aw目录中。所有在res aw目录中的文件不会被压缩，这样可以直接提取该目录中的文件。可以将dictionary.db文件复制到res aw目录中


### 7、Activity间通过Intent传递数据大小有没有限制？

Intent在传递数据时是有大小限制的，这里官方并未详细说明，不过通过实验的方法可以测出数据应该被限制在1MB之内（1024KB），笔者采用的是传递Bitmap的方法，发现当图片大小超过1024（准确地说是1020左右）的时候，程序就会出现闪退、停止运行等异常(不同的手机反应不同)，因此可以判断Intent的传输容量在1MB之内。


### 8、Fragment 的 replace 和 add 方法的区别

Fragment 本身并没有 replace 和 add 方法，FragmentManager才有replace和add方法。我们经常使用的一个架构就是通过RadioGroup切换Fragment，每个 Fragment 就是一个功能模块。

Fragment 的容器一个 FrameLayout，add 的时候是把所有的 Fragment 一层一层的叠加到了。FrameLayout 上了，而 replace 的话首先将该容器中的其他 Fragment 去除掉然后将当前Fragment添加到容器中。

一个 Fragment 容器中只能添加一个 Fragment 种类，如果多次添加则会报异常，导致程序终止，而 replace 则无所谓，随便切换。因为通过 add 的方法添加的 Fragment，每个 Fragment 只能添加一次，因此如果要想达到切换效果需要通过 Fragment 的的 hide 和 show 方法结合者使用。将要显示的 show 出来，将其他 hide起来。这个过程 Fragment 的生命周期没有变化。

通过 replace 切换 Fragment，每次都会执行上一个 Fragment 的 onDestroyView，新 Fragment的 onCreateView、onStart、onResume 方法。基于以上不同的特点我们在使用的使用一定要结合着生命周期操作我们的视图和数据。


### 9、9.进程和线程的区别

概念：进程包括多个线程，一个程序一个进程，多线程的优点可以提高执行效率，提高资源利用率

创建：Thread类和Runnable接口

**常用方法有：**

**1、** start()用于启动线程

**2、** run()调用线程对象中的run方法

**3、** join()合并插队到当前线程

**4、** sellp()睡眠释放cpu资源

**5、** setPriority()设置线程优先级


### 10、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？

开始定位，Application 持有一个全局的公共位置对象，然后隔一定时间自动刷新位置，每次刷新成功都把新的位置信息赋值到全局的位置对象， 然后每个需要使用位置请求的地方都使用全局的位置信息进行请求。

**1、** 该方案好处：请求的时候无需再反复定位，每次请求都使用全局的位置对象，节省时间。

**2、** 该方案弊端：耗电，每隔一定时间自动刷新位置，对电量的消耗比较大。

按需定位，每次请求前都进行定位。这样做的好处是比较省电，而且节省资源，但是请求时间会变得相对较长。


### 11、View的分发机制，滑动冲突
### 12、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布?
### 13、Service和Thread的区别？
### 14、补间动画
### 15、Android中4大组件
### 16、简述TCP，UDP，Socket
### 17、开发中都使用过哪些框架、平台
### 18、ListView 如何提高其效率？
### 19、Hander原理
### 20、怎样对 android 进行优化？
### 21、Android 中的动画有哪几类，它们的特点和区别是什么
### 22、请介绍下 ContentProvider 是如何实现数据共享的
### 23、如何启用Service，如何停用Service。
### 24、GLSurfaceView
### 25、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？
### 26、如何在 ScrollView 中如何嵌入 ListView
### 27、View和SurfaceView的区别
### 28、启动一个程序，可以主界面点击图标进入，也可以从一个程序中跳转过去，二者有什么区别？
### 29、Android本身的api并未声明会抛出异常，则其在运行时有无可能抛出runtime异常，你遇到过吗？诺有的话会导致什么问题？如何解决？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
