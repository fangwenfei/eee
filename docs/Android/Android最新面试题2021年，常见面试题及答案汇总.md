# Android最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、一条最长的短信息约占多少byte?

中文70(包括标点)，英文160，160个字节。


### 2、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？

FragmentPagerAdapter 的每个 Fragment 会持久的保存在 FragmentManager 中，只要用户可以返回到页面中，它都不会被销毁。因此适用于那些数据 相对静态的页，Fragment 数量也比较少的那种;FragmentStatePagerAdapter 只保留当前页面，当页面不可见时，该 Fragment 就会被消除，释放其资源。因此适用于那些 数据动态性较大、 占用内存较多，多 Fragment 的情况；


### 3、View和SurfaceView的区别

View基于主线程刷新UI，SurfaceView子线程又可以刷新UI


### 4、Manifest.xml文件中主要包括哪些信息？

**1、** manifest：根节点，描述了package中所有的内容。

**2、** uses-permission：请求你的package正常运作所需赋予的安全许可。

**3、** permission： 声明了安全许可来限制哪些程序能你package中的组件和功能。

**4、** instrumentation：声明了用来测试此package或其他package指令组件的代码。

**5、** application：包含package中application级别组件声明的根节点。

**6、** activity：Activity是用来与用户交互的主要工具。

**7、** receiver：IntentReceiver能使的application获得数据的改变或者发生的操作，即使它当前不在运行。

**8、** service：Service是能在后台运行任意时间的组件。

**9、** provider：ContentProvider是用来管理持久化数据并发布给其他应用程序使用的组件。


### 5、android的数据存储

**1、** 使用SharedPreferences存储数据；它是Android提供的用来存储一些简单配置信息的一种机制，采用了XML格式将数据存储到设备中。只能在同一个包内使用，不能在不同的包之间使用。

**2、** 文件存储数据；文件存储方式是一种较常用的方法，在Android中读取/写入文件的方法，与Java中实现I/O的程序是完全一样的，提供了openFileInput()和openFileOutput()方法来读取设备上的文件。

**3、** SQLite数据库存储数据；SQLite是Android所带的一个标准的数据库，它支持SQL语句，它是一个轻量级的嵌入式数据库。

**4、** 使用ContentProvider存储数据；主要用于应用程序之间进行数据交换，从而能够让其他的应用保存或读取此Content Provider的各种数据类型。

**5、** 网络存储数据；通过网络上提供给我们的存储空间来上传(存储)和下载(获取)我们存储在网络空间中的数据信息。


### 6、Android中touch事件的传递机制是怎样的?

**1、** Touch事件传递的相关API有dispatchTouchEvent、onTouchEvent、onInterceptTouchEvent

**2、** Touch事件相关的类有View、ViewGroup、Activity

**3、** Touch事件会被封装成MotionEvent对象，该对象封装了手势按下、移动、松开等动作

**4、** Touch事件通常从Activity#dispatchTouchEvent发出，只要没有被消费，会一直往下传递，到最底层的View。

**5、** 如果Touch事件传递到的每个View都不消费事件，那么Touch事件会反向向上传递,最终交由Activity#onTouchEvent处理、

**6、** onInterceptTouchEvent为ViewGroup特有，可以拦截事件、

**7、** Down事件到来时，如果一个View没有消费该事件，那么后续的MOVE/UP事件都不会再给它


### 7、什么是aar?aar是jar有什么区别?

“aar”包是 Android 的类库项目的二进制发行包。

文件扩展名是.aar，maven 项目类型应该也是aar，但文件本身是带有以下各项的 zip 文件：

**1、** /AndroidManifest.xml (mandatory)

**2、** /classes.jar (mandatory)

**3、** /res/ (mandatory)

**4、** /R.txt (mandatory)

**5、** /assets/ (optional)

**6、** /libs/*.jar (optional)

**7、** /jni//*.so (optional)

**8、** /proguard.txt (optional)

**9、** /lint.jar (optional)

这些条目是直接位于 zip 文件根目录的。 其中R.txt 文件是aapt带参数–output-text-symbols的输出结果。

jar打包不能包含资源文件，比如一些drawable文件、xml资源文件之类的,aar可以。


### 8、广播接受者的生命周期？

```
广播接收者的生命周期非常短。当执行onRecieve方法之后，广播就会销毁
在广播接受者不能进行耗时较长的操作
在广播接收者不要创建子线程。广播接收者完成操作后，所在进程会变成空进程，很容易被系统回收
```


### 9、Android中，帧动画

帧动画是最容易实现的一种动画，这种动画更多的依赖于完善的UI资源，他的原理就是将一张张单独的图片连贯的进行播放，从而在视觉上产生一种动画的效果；有点类似于某些软件制作gif动画的方式。在有些代码中，我们还会看到android：oneshot="false" ，这个oneshot 的含义就是动画执行一次（true）还是循环执行多次。

```
<?xml version="1.0" encoding="utf-8"?>
<animation-list xmlns:android="http://schemas.android.com/apk/res/android">
    <item
        android:drawable="@drawable/a_0"
        android:duration="100" />
    <item
        android:drawable="@drawable/a_1"
        android:duration="100" />
    <item
        android:drawable="@drawable/a_2"
        android:duration="100" />
</animation-list>
```


### 10、NDK是什么

NDK是一些列工具的集合，NDK提供了一系列的工具，帮助开发者迅速的开发C/C++的动态库，并能自动将so和java 应用打成apk包。

NDK集成了交叉编译器，并提供了相应的mk文件和隔离cpu、平台等的差异，开发人员只需简单的修改mk文件就可以创建出so



### 11、View的绘制原理
### 12、广播注册
### 13、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()
### 14、Android dvm的进程和Linux的进程, 应用程序的进程是否为同一个概念
### 15、activity，service，intent之间的关系
### 16、SQLite支持事务吗? 添加删除如何提高性能?
### 17、java中如何引用本地语言
### 18、怎样对 android 进行优化？
### 19、如何将一个Activity设置成窗口的样式。
### 20、说说 ContentProvider、ContentResolver、ContentObserver 之间的关系
### 21、android系统的优势和不足
### 22、Activity启动模式
### 23、请描述一下 Intent 和 IntentFilter
### 24、RecyclerView和ListView的区别
### 25、内存泄露如何查看和解决
### 26、请解释下 Android 程序运行时权限与文件系统权限的区别？
### 27、View的分发机制，滑动冲突
### 28、DDMS和TraceView的区别?
### 29、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
