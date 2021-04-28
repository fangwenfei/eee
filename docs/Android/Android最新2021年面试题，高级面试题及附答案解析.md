# Android最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？

开始定位，Application 持有一个全局的公共位置对象，然后隔一定时间自动刷新位置，每次刷新成功都把新的位置信息赋值到全局的位置对象， 然后每个需要使用位置请求的地方都使用全局的位置信息进行请求。

**1、** 该方案好处：请求的时候无需再反复定位，每次请求都使用全局的位置对象，节省时间。

**2、** 该方案弊端：耗电，每隔一定时间自动刷新位置，对电量的消耗比较大。

按需定位，每次请求前都进行定位。这样做的好处是比较省电，而且节省资源，但是请求时间会变得相对较长。


### 2、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布?

可以将dictionary.db文件复制到Eclipse Android工程中的res aw目录中。所有在res aw目录中的文件不会被压缩，这样可以直接提取该目录中的文件。可以将dictionary.db文件复制到res aw目录中


### 3、16Android性能优化

布局优化: 减少布局层级，使用ViewStub提高显示速度，布局服用，尽可能少使用warp_content，删除空间中无用的属性,避免过度绘制移除window默认背景，按需显示展位图，自定义View优化，使用canvas.clipRect()识别可见区域

**1、** 启动速度:采用分布加载，异步加载，延期加载提高应用初始化速度，采用线程初始化数据等，合理的刷新机制

**2、** 内存方面:防止内存泄露,使用一些第三方工具检测解决

**3、** 代码优化:遵循Java生命周期

**4、** 安装包优化:删除无用资源，优化图片，代码混淆，避免重复库存在，插件化


### 4、Serializable 和 Parcelable 的区别？

如果存储在内存中，推荐使用parcelable，使用serialiable在序列化的时候会产生大量的临时变量，会引起频繁的GC

如果存储在硬盘上，推荐使用Serializable，虽然serializable效率较低

Serializable的实现：只需要实现Serializable接口，就会自动生成一个序列化id

Parcelable的实现：需要实现Parcelable接口，还需要Parcelable.CREATER变量


### 5、Service和Thread的区别？

servie是系统的组件，它由系统进程托管（servicemanager）；它们之间的通信类似于client和server，是一种轻量级的ipc通信，这种通信的载体是binder，它是在linux层交换信息的一种ipc。而thread是由本应用程序托管。1)、Thread：Thread 是程序执行的最小单元，它是分配CPU的基本单位。可以用 Thread 来执行一些异步的操作。

2)、Service：Service 是android的一种机制，当它运行的时候如果是Local Service，那么对应的 Service 是运行在主进程的 main 线程上的。如：onCreate，onStart 这些函数在被系统调用的时候都是在主进程的 main 线程上运行的。如果是Remote Service，那么对应的 Service 则是运行在独立进程的 main 线程上。

既然这样，那么我们为什么要用 Service 呢？其实这跟 android 的系统机制有关，我们先拿 Thread 来说。Thread 的运行是独立于 Activity 的，也就是说当一个 Activity 被 finish 之后，如果你没有主动停止 Thread 或者 Thread 里的 run 方法没有执行完毕的话，Thread 也会一直执行。因此这里会出现一个问题：当 Activity 被 finish 之后，你不再持有该 Thread 的引用。另一方面，你没有办法在不同的 Activity 中对同一 Thread 进行控制。

举个例子：如果你的 Thread 需要不停地隔一段时间就要连接服务器做某种同步的话，该 Thread 需要在 Activity 没有start的时候也在运行。这个时候当你 start 一个 Activity 就没有办法在该 Activity 里面控制之前创建的 Thread。因此你便需要创建并启动一个 Service ，在 Service 里面创建、运行并控制该 Thread，这样便解决了该问题（因为任何 Activity 都可以控制同一 Service，而系统也只会创建一个对应 Service 的实例）。

因此你可以把 Service 想象成一种消息服务，而你可以在任何有 Context 的地方调用 Context.startService、Context.stopService、Context.bindService，Context.unbindService，来控制它，你也可以在 Service 里注册 BroadcastReceiver，在其他地方通过发送 broadcast 来控制它，当然这些都是 Thread 做不到的。


### 6、如何将打开res aw目录中的数据库文件?

**1、** 在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

**2、** 复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。

**3、** 在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 7、Activity间通过Intent传递数据大小有没有限制？

Intent在传递数据时是有大小限制的，这里官方并未详细说明，不过通过实验的方法可以测出数据应该被限制在1MB之内（1024KB），笔者采用的是传递Bitmap的方法，发现当图片大小超过1024（准确地说是1020左右）的时候，程序就会出现闪退、停止运行等异常(不同的手机反应不同)，因此可以判断Intent的传输容量在1MB之内。


### 8、如何提升Service进程优先级

在AndroidManifest.xml文件中对于intent-filter可以通过android:priority = “1000”这个属性设置最高优先级，1000是最高值，如果数字越小则优先级越低，同时适用于广播。



### 9、请介绍下Android的数据存储方式。

使用SharedPreferences存储数据；文件存储数据；SQLite数据库存储数据；使用ContentProvider存储数据；网络存储数据；

Preference，File， DataBase这三种方式分别对应的目录是/data/data/Package Name/Shared_Pref, /data/data/Package Name/files, /data/data/Package Name/database 。

**一：使用SharedPreferences存储数据**

首先说明SharedPreferences存储方式，它是 Android提供的用来存储一些简单配置信息的一种机制，例如：登录用户的用户名与密码。其采用了Map数据结构来存储数据，以键值的方式存储，可以简单的读取与写入，具体实例如下：

```
void  ReadSharedPreferences() {
    String  strName, strPassword;
    SharedPreferences    user  =  getSharedPreferences(“user_info”, 0);
    strName  =  user.getString(“NAME”, ””);
    strPassword  =  user  getString(“PASSWORD”, ””);
}
void  WriteSharedPreferences(String  strName, String  strPassword) {
    SharedPreferences    user  =  getSharedPreferences(“user_info”, 0);
    uer.edit();
    user.putString(“NAME”,  strName);
    user.putString(“PASSWORD” , strPassword);
    user.commit();
}
```

数据读取与写入的方法都非常简单，只是在写入的时候有些区别：先调用edit()使其处于编辑状态，然后才能修改数据，最后使用commit()提交修改的数据。实际上SharedPreferences是采用了XML格式将数据存储到设备中，在DDMS中的File Explorer中的/data/data//shares_prefs下。使用SharedPreferences是有些限制的：只能在同一个包内使用，不能在不同的包之间使用</package name>

**二：文件存储数**

文件存储方式是一种较常用的方法，在Android中读取/写入文件的方法，与 Java中实现I/O的程序是完全一样的，提供了openFileInput()和openFileOutput()方法来读取设备上的文件。具体实例如下

```
String fn = “moandroid.log”;
FileInputStream fis = openFileInput(fn);
FileOutputStream fos = openFileOutput(fn,Context.MODE_PRIVATE);
```

**三：网络存储数**

网络存储方式，需要与Android 网络数据包打交道，关于Android 网络数据包的详细说明，请阅读Android SDK引用了Java SDK的哪些package？

**四：ContentProvide**

**1、** ContentProvider简

当应用继承ContentProvider类，并重写该类用于提供数据和存储数据的方法，就可以向其他应用共享其数据。虽然使用其他方法也可以对外共享数据，但数据访问方式会因数据存储的方式而不同，如：采用文件方式对外共享数据，需要进行文件操作读写数据；采用sharedpreferences共享数据，需要使用sharedpreferences API读写数据。而使用ContentProvider共享数据的好处是统一了数据访问方式

**2、** Uri类简

Uri代表了要操作的数据，Uri主要包含了两部分信息：1.需要操作的ContentProvider ，2.对ContentProvider中的什么数据进行操作，一个Uri由以下几部分组成

**1、** scheme：ContentProvider（内容提供者）的scheme已经由Android所规定为：content://

**2、** 主机名（或Authority）：用于唯一标识这个ContentProvider，外部调用者可以根据这个标识来找到它

**3、** 路径（path）：可以用来表示我们要操作的数据，路径的构建应根据业务而定，如下

**1、** 要操作contact表中id为10的记录，可以构建这样的路径:/contact/10

**2、** 要操作contact表中id为10的记录的name字段， contact/10/name

**3、** 要操作contact表中的所有记录，可以构建这样的路径:/contact?

**4、** 要操作的数据不一定来自数据库，也可以是文件等他存储方式，如下:

**5、** 要操作xml文件中contact节点下的name节点，可以构建这样的路径：/contact/name

**6、** 如果要把一个字符串转换成Uri，可以使用Uri类中的parse()方法，如下：

Uri uri = Uri.parse("content://com.changcheng.provider.contactprovider/contact")

**3、** UriMatcher、ContentUrist和ContentResolver简介

因为Uri代表了要操作的数据，所以我们很经常需要解析Uri，并从 Uri中获取数据。Android系统提供了两个用于操作Uri的工具类，分别为UriMatcher 和ContentUris 。掌握它们的使用，会便于我们的开发工作。

**UriMatcher：用于匹配Uri，它的用法如下：**

1.首先把你需要匹配Uri路径全部给注册上，如下

```
//常量UriMatcher.NO_MATCH表示不匹配任何路径的返回码(-1)。
UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
//如果match()方法匹配content://com.changcheng.sqlite.provider.contactprovider /contact路径，返回匹配码为1
uriMatcher.addURI(“com.changcheng.sqlite.provider.contactprovider”, “contact”, 1);//添加需要匹配uri，如果匹配就会返回匹配码
//如果match()方法匹配 content://com.changcheng.sqlite.provider.contactprovider/contact/230路径，返回匹配码为2
uriMatcher.addURI(“com.changcheng.sqlite.provider.contactprovider”, “contact/#”, 2);//#号为通配符
```

2.注册完需要匹配的Uri后，就可以使用uriMatcher.match(uri)方法对输入的Uri进行匹配，如果匹配就返回匹配码，匹配码是调用 addURI()方法传入的第三个参数，假设匹配 content://com.changcheng.sqlite.provider.contactprovider/contact路径，返回的匹配码为1

ContentUris：用于获取Uri路径后面的ID部分，它有两个比较实用的方法

withAppendedId(uri, id)用于为路径加上ID部

parseId(uri)方法用于从路径中获取ID部

ContentResolver：当外部应用需要对ContentProvider中的数据进行添加、删除、修改和查询操作时，可以使用 ContentResolver 类来完成，要获取ContentResolver 对象，可以使用Activity提供的getContentResolver()方法。 ContentResolver使用insert、delete、update、query方法，来操作数据


### 10、NDK

**1、** NDK是一系列工具集合，NDK提供了一系列的工具，帮助开发者迅速的开发C/C++的动态库，并能自动将so和Java应用打成apk包。

**2、** NDK集成了交叉编译器，并提供了相应的mk文件和隔离cpu、平台等的差异，开发人员只需要简单的修改mk文件就可以创建出so文件。


### 11、如何切换 fragement,不重新实例化
### 12、补间动画
### 13、音视频相关类
### 14、你一般在开发项目中都使用什么设计模式？如何来重构，优化你的代码？
### 15、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？
### 16、Android中activity，context，application有什么不同。
### 17、Android系统的架构
### 18、SurfaceView
### 19、Android中常用布局
### 20、ListView的优化方案
### 21、android:gravity与android:layout_gravity的区别
### 22、简述JNI
### 23、jni 的调用过程?
### 24、SQLite支持事务吗?添加删除如何提高性能?
### 25、AIDL的全称是什么？如何工作？能处理哪些类型的数据？
### 26、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。
### 27、Intent 传递数据时，可以传递哪些类型数据？
### 28、Android 引入广播机制的用意
### 29、ListView 如何定位到指定位置
### 30、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
