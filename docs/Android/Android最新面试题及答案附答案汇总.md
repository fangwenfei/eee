# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Android 引入广播机制的用意

从 MVC 的角度考虑(应用程序内) 其实回答这个问题的时候还可以这样问，android 为什么要有那 4 大组件，现在的移动开发模型基本上也是照搬的 web 那一套 MVC 架构，只不过稍微做了修改。android 的四大组件本质上就是为了实现移动或者说嵌入式设备上的 MVC 架构，它们之间有时候是一种相互依存的关系，有时候又是一种补充关系，引入广播机制可以方便几大组件的信息和数据交互。

程序间互通消息(例如在自己的应用程序内监听系统来电)

效率上(参考 UDP 的广播协议在局域网的方便性)

设计模式上(反转控制的一种应用，类似监听者模式)


### 2、内存泄露如何查看和解决

概念：有些对象只有有限的生命周期，当他们的任务完成之后，它们将被垃圾回收，如果在对象的生命周期本该结束的时候，这个对象还被一系列的引用，着就会导致内存泄露。

解决方法：使用开源框架LeakCanary检测针对性解决

**常见的内存泄露有：**

**1、** 单例造成的内存泄露，例如单例中的Context生命周期大于本身Context生命周期

**2、** 线程使用Hander造成的内存卸扣，当activity已经结束，线程依然在运行更新UI

**3、** 非静态类使用静态变量导致无法回收释放造成泄露

**4、** WebView网页过多造成内存泄露

**5、** 资源未关闭造成泄露，例如数据库使用完之后关闭连接


### 3、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？

开始定位，Application 持有一个全局的公共位置对象，然后隔一定时间自动刷新位置，每次刷新成功都把新的位置信息赋值到全局的位置对象， 然后每个需要使用位置请求的地方都使用全局的位置信息进行请求。

**1、** 该方案好处：请求的时候无需再反复定位，每次请求都使用全局的位置对象，节省时间。

**2、** 该方案弊端：耗电，每隔一定时间自动刷新位置，对电量的消耗比较大。

按需定位，每次请求前都进行定位。这样做的好处是比较省电，而且节省资源，但是请求时间会变得相对较长。


### 4、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？

在onPuase方法中调用onSavedInstanceState()


### 5、什么是 IntentService？有何优点？

IntentService 是 Service 的子类，比普通的 Service 增加了额外的功能。先看 Service 本身存在两个问题：

**1、** Service 不会专门启动一条单独的进程，Service 与它所在应用位于同一个进程中；

**2、** Service 也不是专门一条新线程，因此不应该在 Service 中直接处理耗时的任务；

**IntentService 特征**

**1、** 会创建独立的 worker 线程来处理所有的 Intent 请求；

**2、** 会创建独立的 worker 线程来处理 onHandleIntent()方法实现的代码，无需处理多线程问题；

**3、** 所有请求处理完成后，IntentService 会自动停止，无需调用 stopSelf()方法停止 Service；

**4、** 为 Service 的 onBind()提供默认实现，返回 null；

**5、** 为 Service 的 onStartCommand 提供默认实现，将请求 Intent 添加到队列中；


### 6、什么是aar?aar是jar有什么区别?

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


### 7、Serializable 和 Parcelable 的区别？

如果存储在内存中，推荐使用parcelable，使用serialiable在序列化的时候会产生大量的临时变量，会引起频繁的GC

如果存储在硬盘上，推荐使用Serializable，虽然serializable效率较低

Serializable的实现：只需要实现Serializable接口，就会自动生成一个序列化id

Parcelable的实现：需要实现Parcelable接口，还需要Parcelable.CREATER变量


### 8、Android i18n

I18n 叫做国际化。android 对i18n和L10n提供了非常好的支持。软件在res/vales 以及 其他带有语言修饰符的文件夹。如： values-zh 这些文件夹中 提供语言，样式，尺寸 xml 资源。


### 9、嵌入式操作系统内存管理有哪几种， 各有何特性

页式，段式，段页，用到了MMU,虚拟空间等技术


### 10、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？

重写onSaveInstanceState()方法，在此方法中保存需要保存的数据，该方法将会在activity被回收之前调用。通过重写onRestoreInstanceState()方法可以从中提取保存好的数据


### 11、AsyncTask使用在哪些场景？它的缺陷是什么？如何解决？
### 12、描述一下android的系统架构
### 13、谈谈你在工作中是怎样解决一个 bug
### 14、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？
### 15、你一般在开发项目中都使用什么设计模式？如何来重构，优化你的代码？
### 16、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？
### 17、android中的动画有哪几类，它们的特点和区别是什么
### 18、一条最长的短信息约占多少byte?
### 19、ContentProvider与sqlite有什么不一样的？
### 20、sim卡的EF 文件有何作用
### 21、Activity启动模式
### 22、如何切换 fragement,不重新实例化
### 23、注册广播的几种方法?
### 24、Android中任务栈的分配
### 25、如何将一个Activity设置成窗口的样式。
### 26、说说 LruCache 底层原理
### 27、View的绘制原理
### 28、Service和Thread的区别？
### 29、请介绍下Android中常用的五种布局。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
