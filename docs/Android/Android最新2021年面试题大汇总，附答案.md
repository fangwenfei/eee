# Android最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请解释下Android程序运行时权限与文件系统权限的区别。

运行时权限Dalvik( android授权)

文件系统 linux 内核授权


### 2、请介绍下Android的数据存储方式。

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


### 3、Activity启动模式

介绍 Android 启动模式之前，先介绍两个概念task和taskAffinity

**task：**

翻译过来就是“任务”，是一组相互有关联的 activity 集合，可以理解为 Activity 是在 task 里面活动的。 task 存在于一个称为 back stack 的数据结构中，也就是说， task 是以栈的形式去管理 activity 的，所以也叫可以称为“任务栈”。

**taskAffinity：**

官方文档解释是："The task that the activity has an affinity for."，可以翻译为 activity 相关或者亲和的任务，这个参数标识了一个 Activity 所需要的任务栈的名字。默认情况下，所有Activity所需的任务栈的名字为应用的包名。 taskAffinity 属性主要和 singleTask 启动模式或者 allowTaskReparenting 属性配对使用。

**4种启动模式**

**1、** standard：

标准模式，也是系统默认的启动模式。假如 activity A 启动了 activity B ， activity B 则会运行在 activity A 所在的任务栈中。而且每次启动一个 Activity ，都会重新创建新的实例，不管这个实例在任务中是否已经存在。非 Activity 类型的 context （如 ApplicationContext ）启动 standard 模式的 Activity 时会报错。非 Activity 类型的 context 并没有所谓的任务栈，由于上面第 1 点的原因所以系统会报错。此解决办法就是为待启动 Activity 指定 FLAG_ACTIVITY_NEW_TASK 标记位，这样启动的时候系统就会为它创建一个新的任务栈。这个时候待启动 Activity 其实是以 singleTask 模式启动的。

**2、** singleTop：

栈顶复用模式。假如 activity A 启动了 activity B ，就会判断 A 所在的任务栈栈顶是否是 B 的实例。如果是，则不创建新的 activity B 实例而是直接引用这个栈顶实例，同时 onNewIntent 方法会被回调，通过该方法的参数可以取得当前请求的信息；如果不是，则创建新的 activity B 实例。

**3、** singleTask：

栈内复用模式。在第一次启动这个 Activity 时，系统便会创建一个新的任务，并且初始化 Activity 的实例，放在新任务的底部。不过需要满足一定条件的。那就是需要设置 taskAffinity 属性。前面也说过了， taskAffinity 属性是和 singleTask 模式搭配使用的。

![92_4.png][92_4.png]

**1、** singleInstance：单实例模式。这个是 singleTask 模式的加强版，它除了具有 singleTask 模式的所有特性外，它还有一点独特的特性，那就是此模式的 Activity 只能单独地位于一个任务栈，不与其他 Activity 共存于同一个任务栈。


### 4、jni 的调用过程?

**1、** 安装和下载 Cygwin，下载 Android NDK。

**2、** ndk 项目中 JNI 接口的设计。

**3、** 使用 C/C++实现本地方法。

**4、** JNI 生成动态链接库.so 文件。

**5、** 将动态链接库复制到 java 工程，在 java 工程中调用，运行 java 工程即可。


### 5、activity的生命周期

![92_1.png][92_1.png]

Activity生命周期方法主要有onCreate()、onStart()、onResume()、onPause()、onStop()、onDestroy()和onRestart()等7个方法。

**1、** 启动一个A Activity，分别执行onCreate()、onStart()、onResume()方法。

**2、** 从A Activity打开B Activity分别执行A onPause()、B onCreate()、B onStart()、B onResume()、A onStop()方法。

**3、** 关闭B Activity，分别执行B onPause()、A onRestart()、A onStart()、A onResume()、B onStop()、B onDestroy()方法。

**4、** 横竖屏切换A Activity，清单文件中不设置android:configChanges属性时，先销毁onPause()、onStop()、onDestroy()再重新创建onCreate()、onStart()、onResume()方法，设置orientation|screenSize（一定要同时出现）属性值时，不走生命周期方法，只会执行onConfigurationChanged()方法。

**5、** Activity之间的切换可以看出onPause()、onStop()这两个方法比较特殊，切换的时候onPause()方法不要加入太多耗时操作否则会影响体验。


### 6、Manifest.xml文件中主要包括哪些信息？

**1、** manifest：根节点，描述了package中所有的内容。

**2、** uses-permission：请求你的package正常运作所需赋予的安全许可。

**3、** permission： 声明了安全许可来限制哪些程序能你package中的组件和功能。

**4、** instrumentation：声明了用来测试此package或其他package指令组件的代码。

**5、** application：包含package中application级别组件声明的根节点。

**6、** activity：Activity是用来与用户交互的主要工具。

**7、** receiver：IntentReceiver能使的application获得数据的改变或者发生的操作，即使它当前不在运行。

**8、** service：Service是能在后台运行任意时间的组件。

**9、** provider：ContentProvider是用来管理持久化数据并发布给其他应用程序使用的组件。


### 7、RecyclerView和ListView的区别

缓存上:前者缓存的是View+ViewHolder+flag，不用每次调用findViewById,后者则只是缓存View

刷新数据方面，前者提供了局部刷新，后者则全部刷新


### 8、请介绍下 AsyncTask 的内部实现和适用的场景
### 9、Android中activity，context，application有什么不同。
### 10、开发中都使用过哪些框架、平台
### 11、说下 Activity 跟 跟 window ， view 之间的关系？
### 12、Intent 传递数据时，可以传递哪些类型数据？
### 13、Android 引入广播机制的用意
### 14、简要解释一下activity、 intent 、intent filter、service、Broadcase、BroadcaseReceiver
### 15、什么是嵌入式实时操作系统, Android 操作系统属于实时操作系统吗?
### 16、如果后台的Activity由于某原因被系统回收了，如何在被系统回收之前保存当前状态？
### 17、让Activity变成一个窗口
### 18、说说mvc模式的原理，它在android中的运用,android的官方建议应用程序的开发采用mvc模式。何谓mvc？
### 19、andorid 应用第二次登录实现自动登录
### 20、Activity的状态有几种？
### 21、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布
### 22、activity的启动模式有哪些？是什么含义
### 23、什么情况会导致Force Close ？如何避免？能否捕获导致其的异常？
### 24、谈谈你在工作中是怎样解决一个 bug
### 25、String,StringBuffer,StringBuilder的区别
### 26、activity与fragment区别
### 27、你一般在开发项目中都使用什么设计模式？如何来重构，优化你的代码？
### 28、android:gravity与android:layout_gravity的区别
### 29、activity在屏幕旋转时的生命周期




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
