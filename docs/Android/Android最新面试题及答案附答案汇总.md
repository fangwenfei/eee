# Android最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Service 里面可以弹吐司么

可以。


### 2、ListView 如何提高其效率？

当 convertView 为空时，用 setTag()方法为每个 View 绑定一个存放控件的 ViewHolder 对象。当convertView 不为空， 重复利用已经创建的 view 的时候， 使用 getTag()方法获取绑定的 ViewHolder对象，这样就避免了 findViewById 对控件的层层查询，而是快速定位到控件。 复用 ConvertView，使用历史的 view，提升效率 200%

自定义静态类 ViewHolder，减少 findViewById 的次数。提升效率 50%

异步加载数据，分页加载数据。

使用 WeakRefrence 引用 ImageView 对象


### 3、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？

补间动画只是显示的位置变动，View 的实际位置未改变，表现为 View 移动到其他地方，点击事件仍在原处才能响应。而属性动画控件移动后事件相应就在控件移动后本身进行处理


### 4、sim卡的EF 文件有何作用

sim卡就是电话卡，sim卡内有自己的操作系统，用来与手机通讯的。Ef文件用来存储数据的。


### 5、Android root机制

root指的是你有权限可以再系统上对所有档案有 "读" "写" "执行"的权力。root机器不是真正能让你的应用程序具有root权限。它原理就跟linux下的像sudo这样的命令。在系统的bin目录下放个su程序并属主是root并有suid权限。则通过su执行的命令都具有Android root权限。当然使用临时用户权限想把su拷贝的/system/bin目录并改属性并不是一件容易的事情。这里用到2个工具跟2个命令。把busybox拷贝到你有权限访问的目录然后给他赋予4755权限，你就可以用它做很多事了。


### 6、系统上安装了多种浏览器，能否指定某浏览器访问指定页面？请说明原由。

通过直接发送Uri把参数带过去，或者通过manifest里的intentfilter里的data属性


### 7、如何切换 fragement,不重新实例化

翻看了 Android 官方 Doc，和一些组件的源代码，发现 replace()这个方法只是在上一个 Fragment不再需要时采用的简便方法.

正确的切换方式是 add()，切换时 hide()，add()另一个 Fragment；再次切换时，只需 hide()当前，show()另一个。

这样就能做到多个 Fragment 切换不重新实例化：


### 8、怎样对 android 进行优化？

**1、** 对 listview 的优化。

**2、** 对图片的优化。

**3、** 对内存的优化。

**4、** 具体一些措施

**5、** 尽量不要使用过多的静态类 static

**6、** 数据库使用完成后要记得关闭 cursor

**7、** 广播使用完之后要注销


### 9、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？

开始定位，Application 持有一个全局的公共位置对象，然后隔一定时间自动刷新位置，每次刷新成功都把新的位置信息赋值到全局的位置对象， 然后每个需要使用位置请求的地方都使用全局的位置信息进行请求。

**1、** 该方案好处：请求的时候无需再反复定位，每次请求都使用全局的位置对象，节省时间。

**2、** 该方案弊端：耗电，每隔一定时间自动刷新位置，对电量的消耗比较大。

按需定位，每次请求前都进行定位。这样做的好处是比较省电，而且节省资源，但是请求时间会变得相对较长。


### 10、什么是嵌入式实时操作系统, Android 操作系统属于实时操作系统吗?

嵌入式实时操作系统是指当外界事件或数据产生时，能够接受并以足够快的速度予以处理，其处理的结果又能在规定的时间之内来控制生产过程或对处理系统作出快速响应，并控制所有实时任务协调一致运行的嵌入式操作系统。主要用于工业控制、 军事设备、 航空航天等领域对系统的响应时间有苛刻的要求，这就需要使用实时系统。又可分为软实时和硬实时两种，而android是基于linux内核的，因此属于软实时。


### 11、Framework 工作方式及原理，Activity 是如何生成一个 view 的，机制是什么？
### 12、Fragment 如何实现类似 Activity 栈的压栈和出栈效果的？
### 13、事件分发中的 onTouch 和 onTouchEvent 有什么区别，又该如何使用？
### 14、RecyclerView和ListView的区别
### 15、注册广播的几种方法?
### 16、如何在 ScrollView 中如何嵌入 ListView
### 17、谈谈你在工作中是怎样解决一个 bug
### 18、NDK
### 19、Android中touch事件的传递机制是怎样的?
### 20、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布?
### 21、请介绍下 AsyncTask 的内部实现和适用的场景
### 22、Android 线程间通信有哪几种方式（重要）
### 23、推送到达率如何提高
### 24、IntentService有何优点?
### 25、View的分发机制，滑动冲突
### 26、Activity的状态有几种？
### 27、Android中，帧动画
### 28、Android与服务器交互的方式中的对称加密和非对称加密是什么?
### 29、Activity间通过Intent传递数据大小有没有限制？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
