# Android最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Android root机制

root指的是你有权限可以再系统上对所有档案有 "读" "写" "执行"的权力。root机器不是真正能让你的应用程序具有root权限。它原理就跟linux下的像sudo这样的命令。在系统的bin目录下放个su程序并属主是root并有suid权限。则通过su执行的命令都具有Android root权限。当然使用临时用户权限想把su拷贝的/system/bin目录并改属性并不是一件容易的事情。这里用到2个工具跟2个命令。把busybox拷贝到你有权限访问的目录然后给他赋予4755权限，你就可以用它做很多事了。


### 2、Android 中的动画有哪几类，它们的特点和区别是什么

Frame Animation(帧动画)主要用于播放一帧帧准备好的图片，类似GIF图片，优点是使用简单方便、缺点是需要事先准备好每一帧图片；

Tween Animation(补间动画)仅需定义开始与结束的关键帧，而变化的中间帧由系统补上，优点是不用准备每一帧，缺点是只改变了对象绘制，而没有改变View本身属性。因此如果改变了按钮的位置，还是需要点击原来按钮所在位置才有效。

Property Animation(属性动画)是3.0后推出的动画，优点是使用简单、降低实现的复杂度、直接更改对象的属性、几乎可适用于任何对象而仅非View类，主要包括ValueAnimator和ObjectAnimator


### 3、String,StringBuffer,StringBuilder的区别

String不可改变对象，一旦创建就不能修改

```
String str="aaa";
str="bbb";
```

以上代码虽然改变了str，但是执行过程是回收str，把值赋给一个新的str

StringBuffer创建之后，可以去修改

StringBuilder也可修改，执行效率高于StringBuffer，不安全

当字符赋值少使用String

字符赋值频繁使用StringBuilder

当多个线程同步操作数据，使用StringBuffer


### 4、说下 Activity 跟 跟 window ， view 之间的关系？

Activity 创建时通过 attach()初始化了一个 Window 也就是PhoneWindow，一个 PhoneWindow 持有一个DecorView 的实例，DecorView 本身是一个 FrameLayout，继承于 View，Activty 通过setContentView 将xml 布局控件不断 addView()添加到 View 中，最终显示到 Window 于我们交互；


### 5、andorid 应用第二次登录实现自动登录

前置条件是所有用户相关接口都走 https，非用户相关列表类数据走 http。

**步骤**

**1、** 第一次登陆 getUserInfo 里带有一个长效 token，该长效 token 用来判断用户是否登陆和换取短 token

**2、** 把长效 token 保存到 SharedPreferences

**3、** 接口请求用长效 token 换取短token，短 token 服务端可以根据你的接口最后一次请求作为标示，超时时间为一天。

**4、** 所有接口都用短效 token

**5、** 如果返回短效 token 失效，执行第3步，再直接当前接口

**6、** 如果长效 token 失效（用户换设备或超过一月），提示用户登录。


### 6、View

显示视图，内置画布，提供图形绘制函数、触屏事件、按键事件函数等，必须在UI主线程内更新画面，速度较慢


### 7、activity与fragment区别

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


### 8、Android数字签名

**1、** 所有的应用程序都必须有数字证书，Android系统不会安装一个没有数字证书的应用程序

**2、** Android程序包使用的数字证书可以是自签名的，不需要一个权威的数字证书机构签名认证

**3、** 如果要正式发布一个Android ，必须使用一个合适的私钥生成的数字证书来给程序签名。

**4、** 数字证书都是有有效期的，Android只是在应用程序安装的时候才会检查证书的有效期。如果程序已经安装在系统中，即使证书过期也不会影响程序的正常功能。


### 9、如何修改 Activity 进入和退出动画

可 以 通 过 两 种 方 式 ， 一 是 通 过 定 义 Activity 的 主 题 ， 二 是 通 过 覆 写 Activity 的overridePendingTransition 方法。

通过设置主题样式在 styles.xml 中编辑如下代码：

```
添加 themes.xml 文件： 
在 AndroidManifest.xml 中给指定的 Activity 指定 theme。
```

覆写 overridePendingTransition 方法

```
overridePendingTransition(R.anim.fade, R.anim.hold);
```


### 10、Fragment 的 replace 和 add 方法的区别

Fragment 本身并没有 replace 和 add 方法，FragmentManager才有replace和add方法。我们经常使用的一个架构就是通过RadioGroup切换Fragment，每个 Fragment 就是一个功能模块。

Fragment 的容器一个 FrameLayout，add 的时候是把所有的 Fragment 一层一层的叠加到了。FrameLayout 上了，而 replace 的话首先将该容器中的其他 Fragment 去除掉然后将当前Fragment添加到容器中。

一个 Fragment 容器中只能添加一个 Fragment 种类，如果多次添加则会报异常，导致程序终止，而 replace 则无所谓，随便切换。因为通过 add 的方法添加的 Fragment，每个 Fragment 只能添加一次，因此如果要想达到切换效果需要通过 Fragment 的的 hide 和 show 方法结合者使用。将要显示的 show 出来，将其他 hide起来。这个过程 Fragment 的生命周期没有变化。

通过 replace 切换 Fragment，每次都会执行上一个 Fragment 的 onDestroyView，新 Fragment的 onCreateView、onStart、onResume 方法。基于以上不同的特点我们在使用的使用一定要结合着生命周期操作我们的视图和数据。


### 11、跟activity和Task 有关的 Intent启动方式有哪些？其含义？
### 12、简要解释一下activity、 intent 、intent filter、service、Broadcase、BroadcaseReceiver
### 13、都使用过哪些自定义控件
### 14、属性动画
### 15、什么是嵌入式实时操作系统, Android 操作系统属于实时操作系统吗?
### 16、ListView优化
### 17、sim卡的EF文件是什么？有何作用
### 18、说说 LruCache 底层原理
### 19、Fragment的生命周期
### 20、ListView 可以显示多种类型的条目吗
### 21、如果Listview中的数据源发生改变，如何更新listview中的数据
### 22、activity在屏幕旋转时的生命周期
### 23、Adapter是什么？你所接触过的adapter有那些？
### 24、推送到达率如何提高
### 25、什么是IntentService？有何优点？
### 26、Android 应用中验证码登陆都有哪些实现方案
### 27、Fragment与activity如何传值和交互？
### 28、Android中任务栈的分配
### 29、请描述下Activity的生命周期。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
