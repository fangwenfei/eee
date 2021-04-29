# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、dagger2

Dagger2是一个主要用于依赖注入的框架，减少初始化对象操作，降低耦合度


### 2、如何将打开res aw目录中的数据库文件?

解在Android中不能直接打开res aw目录中的数据库文件，而需要在程序第一次启动时将该文件复制到手机内存或SD卡的某个目录中，然后再打开该数据库文件。

复制的基本方法是使用getResources().openRawResource方法获得res aw目录中资源的 InputStream对象，然后将该InputStream对象中的数据写入其他的目录中相应文件中。在Android SDK中可以使用SQLiteDatabase.openOrCreateDatabase方法来打开任意目录中的SQLite数据库文件。


### 3、SQLite支持事务吗? 添加删除如何提高性能?

在sqlite插入数据的时候默认一条语句就是一个事务，有多少条数据就有多少次磁盘操作 比如5000条记录也就是要5000次读写磁盘操作。

添加事务处理，把多条记录的插入或者删除作为一个事务


### 4、android 中有哪几种解析xml的类？官方推荐哪种？以及它们的原理和区别。

XML解析主要有三种方式，SAX、DOM、PULL。常规在PC上开发我们使用Dom相对轻松些，但一些性能敏感的数据库或手机上还是主要采用SAX方式，SAX读取是单向的，优点:不占内存空间、解析属性方便，但缺点就是对于套嵌多个分支来说处理不是很方便。而DOM方式会把整个XML文件加载到内存中去，这里Android开发网提醒大家该方法在查找方面可以和XPath很好的结合如果数据量不是很大推荐使用，而PULL常常用在J2ME对于节点处理比较好，类似SAX方式，同样很节省内存，在J2ME中我们经常使用的KXML库来解析。


### 5、Android数字签名

**1、** 所有的应用程序都必须有数字证书，Android系统不会安装一个没有数字证书的应用程序

**2、** Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证

**3、** 如果要正式发布一个Android ，必须使用一个合适的私钥生成的数字证书来给程序签名。

**4、** 数字证书都是有有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能。


### 6、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布

把这个文件放在/res/raw目录下即可。res\raw目录中的文件不会被压缩，这样可以直接提取该目录中的文件，会生成资源id。


### 7、嵌入式操作系统内存管理有哪几种， 各有何特性

页式，段式，段页，用到了MMU,虚拟空间等技术


### 8、Service 是否在 main thread 中执行, service 里面是否能执行耗时的操作?
### 9、SharedPreference跨进程使用会怎么样？如何保证跨进程使用安全？
### 10、请介绍下Android中常用的五种布局。
### 11、什么是 AIDL？如何使用？
### 12、AIDL 的全称是什么?如何工作?能处理哪些类型的数据？
### 13、Android中任务栈的分配
### 14、推送到达率如何提高
### 15、activity之间传递参数，除了intent，广播接收器，contentProvider之外，还有那些方法？
### 16、Android i18n
### 17、recyclerView嵌套卡顿解决如何解决
### 18、如何退出Activity？如何安全退出已调用多个Activity的Application？
### 19、9.进程和线程的区别
### 20、Android dvm的进程和Linux的进程, 应用程序的进程是否为同一个概念
### 21、了解IntentServices吗?
### 22、Fragment 如何实现类似 Activity 栈的压栈和出栈效果的？
### 23、Service和Thread的区别？
### 24、Service 和 Activity 在同一个线程吗
### 25、ContentProvider与sqlite有什么不一样的？
### 26、Android 中如何捕获未捕获的异常
### 27、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。
### 28、NDK是什么
### 29、Fragment 的 replace 和 add 方法的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
