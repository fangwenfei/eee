# Android最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、android中的动画有哪几类，它们的特点和区别是什么

两种，一种是Tween动画、还有一种是Frame动画。Tween动画，这种实现方式可以使视图组件移动、放大、缩小以及产生透明度的变化;另一种Frame动画，传统的动画方法，通过顺序的播放排列好的图片来实现，类似电影。


### 2、说下 Activity 跟 跟 window ， view 之间的关系？

Activity 创建时通过 attach()初始化了一个 Window 也就是PhoneWindow，一个 PhoneWindow 持有一个DecorView 的实例，DecorView 本身是一个 FrameLayout，继承于 View，Activty 通过setContentView 将xml 布局控件不断 addView()添加到 View 中，最终显示到 Window 于我们交互；


### 3、Service生命周期

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


### 4、Serializable 和 Parcelable 的区别？

如果存储在内存中，推荐使用parcelable，使用serialiable在序列化的时候会产生大量的临时变量，会引起频繁的GC

如果存储在硬盘上，推荐使用Serializable，虽然serializable效率较低

Serializable的实现：只需要实现Serializable接口，就会自动生成一个序列化id

Parcelable的实现：需要实现Parcelable接口，还需要Parcelable.CREATER变量


### 5、消息推送的方式

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


### 6、请解释下Android程序运行时权限与文件系统权限的区别。

运行时权限Dalvik( android授权)

文件系统 linux 内核授权


### 7、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？

重写onSaveInstanceState()方法，在此方法中保存需要保存的数据，该方法将会在activity被回收之前调用。通过重写onRestoreInstanceState()方法可以从中提取保存好的数据


### 8、请介绍下Android的数据存储方式。

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


### 9、如何退出Activity

结束当前activity

```
Finish()
killProgress()
System.exit(0)
```

关闭应用程序时，结束所有的activity

可以创建一个List集合，每新创建一个activity，将该activity的实例放进list中，程序结束时，从集合中取出循环取出activity实例，调用finish()方法结束


### 10、什么是 AIDL？如何使用？

aidl 是 Android interface definition Language 的英文缩写，意思 Android 接口定义语言。

使用 aidl 可以帮助我们发布以及调用远程服务，实现跨进程通信。

**1、** 将服务的 aidl 放到对应的 src 目录，工程的 gen 目录会生成相应的接口类

**2、** 我们通过 bindService（Intent，ServiceConnect，int）方法绑定远程服务，在 bindService中 有 一 个 ServiceConnec 接 口 ， 我 们 需 要 覆 写 该 类 的onServiceConnected(ComponentName,IBinder)方法，这个方法的第二个参数 IBinder 对象其实就是已经在 aidl 中定义的接口，因此我们可以将 IBinder 对象强制转换为 aidl 中的接口类。我们通过 IBinder 获取到的对象（也就是 aidl 文件生成的接口）其实是系统产生的代理对象，该代理对象既可以跟我们的进程通信， 又可以跟远程进程通信， 作为一个中间的角色实现了进程间通信。


### 11、NDK是什么
### 12、activity与fragment区别
### 13、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？
### 14、请解释下在单线程模型中Message、Handler、Message Queue、Looper之间的关系。
### 15、请描述下Activity的生命周期。
### 16、Intent 传递数据时，可以传递哪些类型数据？
### 17、补间动画
### 18、一条最长的短信息约占多少byte?
### 19、简述TCP，UDP，Socket
### 20、activity的生命周期
### 21、如何提升Service进程优先级
### 22、如何将一个Activity设置成窗口的样式。
### 23、Manifest.xml文件中主要包括哪些信息？
### 24、recyclerView嵌套卡顿解决如何解决
### 25、属性动画
### 26、你一般在开发项目中都使用什么设计模式？如何来重构，优化你的代码？
### 27、横竖屏切换的Activity 生命周期变化？
### 28、ListView 可以显示多种类型的条目吗
### 29、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
