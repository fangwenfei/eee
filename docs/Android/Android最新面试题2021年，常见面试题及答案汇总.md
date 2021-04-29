# Android最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请介绍下Android的数据存储方式。

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


### 2、Android数字签名

**1、** 所有的应用程序都必须有数字证书，Android系统不会安装一个没有数字证书的应用程序

**2、** Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证

**3、** 如果要正式发布一个Android ，必须使用一个合适的私钥生成的数字证书来给程序签名。

**4、** 数字证书都是有有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能。


### 3、SQLite支持事务吗? 添加删除如何提高性能?

在sqlite插入数据的时候默认一条语句就是一个事务，有多少条数据就有多少次磁盘操作 比如5000条记录也就是要5000次读写磁盘操作。

添加事务处理，把多条记录的插入或者删除作为一个事务


### 4、说说 LruCache 底层原理

LruCache 使用一个 LinkedHashMap 简单的实现内存的缓存，没有软引用，都是强引用。

如果添加的数据大于设置的最大值，就删除最先缓存的数据来调整内存。maxSize 是通过构造方法初始化的值，他表示这个缓存能缓存的最大值是多少。

size 在添加和移除缓存都被更新值， 他通过 safeSizeOf 这个方法更新值。 safeSizeOf 默认返回 1，但一般我们会根据 maxSize 重写这个方法，比如认为 maxSize 代表是 KB 的话，那么就以 KB 为单位返回该项所占的内存大小。

除异常外，首先会判断 size 是否超过 maxSize，如果超过了就取出最先插入的缓存，如果不为空就删掉，并把 size 减去该项所占的大小。这个操作将一直循环下去，直到 size 比 maxSize 小或者缓存为空。


### 5、dagger2

Dagger2是一个主要用于依赖注入的框架，减少初始化对象操作，降低耦合度


### 6、内存溢出和内存泄漏有什么区别？何时会产生内存泄漏？

内存溢出：当程序运行时所需的内存大于程序允许的最高内存，这时会出现内存溢出；

内存泄漏：在一些比较消耗资源的操作中，如果操作中内存一直未被释放，就会出现内存泄漏。比如未关闭io,cursor。


### 7、请介绍下 AsyncTask 的内部实现和适用的场景

AsyncTask 内部也是 Handler 机制来完成的，只不过 Android 提供了执行框架来提供线程池来执行相应地任务，因为线程池的大小问题，所以 AsyncTask 只应该用来执行耗时时间较短的任务，比如 HTTP 请求，大规模的下载和数据库的更改不适用于 AsyncTask，因为会导致线程池堵塞，没有线程来执行其他的任务，导致的情形是会发生 AsyncTask 根本执行不了的问题


### 8、Android中，帧动画

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


### 9、ListView 如何定位到指定位置

可以通过 ListView 提供的 lv.setSelection(listView.getPosition())方法。



### 10、ListView的优化方案

**1、** 如果自定义适配器，那么在getView方法中要考虑方法传进来的参数contentView是否为null，如果为null就创建contentView并返回，如果不为null则直接使用。在这个方法中尽可能少创建view。

**2、** 给contentView设置tag（setTag（）），传入一个viewHolder对象，用于缓存要显示的数据，可以达到图像数据异步加载的效果。

**3、** 如果listview需要显示的item很多，就要考虑分页加载。比如一共要显示100条或者更多的时候，我们可以考虑先加载20条，等用户拉到列表底部的时候再去加载接下来的20条。


### 11、启动一个程序，可以主界面点击图标进入，也可以从一个程序中跳转过去，二者有什么区别？
### 12、横竖屏切换的Activity 生命周期变化？
### 13、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 14、IntentService有何优点?
### 15、请介绍下ContentProvider是如何实现数据共享的。
### 16、如何修改 Activity 进入和退出动画
### 17、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？
### 18、activity的生命周期
### 19、谈MVC ，MVP，MVVM
### 20、子线程发消息到主线程进行更新 UI，除了 handler 和 AsyncTask，还有什么？
### 21、简述TCP，UDP，Socket
### 22、如何将打开res aw目录中的数据库文件?
### 23、让Activity变成一个窗口
### 24、Intent 传递数据时，可以传递哪些类型数据？
### 25、android:gravity与android:layout_gravity的区别
### 26、即时通讯是是怎么做的?
### 27、Fragment 如何实现类似 Activity 栈的压栈和出栈效果的？
### 28、View的分发机制，滑动冲突
### 29、Fragment与activity如何传值和交互？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
