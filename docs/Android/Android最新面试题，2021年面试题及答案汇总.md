# Android最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是ANR 如何避免它？

ANR：Application Not Responding。在Android中，活动管理器和窗口管理器这两个系统服务负责监视应用程序的响应，当用户操作的在5s内应用程序没能做出反应，BroadcastReceiver在10秒内没有执行完毕，就会出现应用程序无响应对话框，这既是ANR。

避免方法：Activity应该在它的关键生命周期方法（如onCreate()和onResume()）里尽可能少的去做创建操作。潜在的耗时操作，例如网络或数据库操作，或者高耗时的计算如改变位图尺寸，应该在子线程里（或者异步方式）来完成。主线程应该为子线程提供一个Handler，以便完成时能够提交给主线程。


### 2、Activity间通过Intent传递数据大小有没有限制？

Intent在传递数据时是有大小限制的，这里官方并未详细说明，不过通过实验的方法可以测出数据应该被限制在1MB之内（1024KB），笔者采用的是传递Bitmap的方法，发现当图片大小超过1024（准确地说是1020左右）的时候，程序就会出现闪退、停止运行等异常(不同的手机反应不同)，因此可以判断Intent的传输容量在1MB之内。


### 3、Android 应用中验证码登陆都有哪些实现方案

**1、** 从服务器端获取图片

**2、** 通过短信服务，将验证码发送给客户端


### 4、谈谈你对 Bitmap 的理解, 什么时候应该手动调用 bitmap.recycle()

Bitmap 是 android 中经常使用的一个类，它代表了一个图片资源。 Bitmap 消耗内存很严重，如果不注意优化代码，经常会出现 OOM 问题，优化方式通常有这么几种：

**1、** 使用缓存；

**2、** 压缩图片；

**3、** 及时回收；

至于什么时候需要手动调用 recycle，这就看具体场景了，原则是当我们不再使用 Bitmap 时，需要回收之。另外，我们需要注意，2.3 之前 Bitmap 对象与像素数据是分开存放的，Bitmap 对象存在java Heap 中而像素数据存放在 Native Memory 中， 这时很有必要调用 recycle 回收内存。 但是 2.3之后，Bitmap 对象和像素数据都是存在 Heap 中，GC 可以回收其内存。


### 5、如何退出Activity

结束当前activity

```
Finish()
killProgress()
System.exit(0)
```

关闭应用程序时，结束所有的activity

可以创建一个List集合，每新创建一个activity，将该activity的实例放进list中，程序结束时，从集合中取出循环取出activity实例，调用finish()方法结束


### 6、Hander原理

Handler，loop轮询检测发送消息到MessagerQuery,MessageQuery对Message入列，Handler回调方法处理消息，重写handMessage方法刷新ui


### 7、Fragment与activity如何传值和交互？

```
Fragment对象有一个getActivity的方法，通过该方法与activity交互
使用framentmentManager.findFragmentByXX可以获取fragment对象，在activity中直接操作fragment对象
```


### 8、ListView 可以显示多种类型的条目吗
### 9、如何将SQLite数据库(dictionary.db文件)与apk文件一起发布?
### 10、如何提升Service进程优先级
### 11、sim卡的EF文件是什么？有何作用
### 12、SurfaceView
### 13、都使用过哪些自定义控件
### 14、Android 判断SD卡是否存在
### 15、activity，fragment传值问题
### 16、Android的四大组件是哪些，它们的作用？
### 17、Fragment的生命周期
### 18、ListView的优化方案
### 19、FragmentPagerAdapter 与 与 FragmentStatePagerAdapter 的区别与使用场景？
### 20、wait和 sleep 的区别
### 21、定位项目中，如何选取定位方案，如何平衡耗电与实时位置的精度？
### 22、注册广播的几种方法?
### 23、Service生命周期
### 24、NDK
### 25、内存泄露如何查看和解决
### 26、属性动画，例如一个 button 从 A 移动到 B 点，B 点还是可以响应点击事件，这个原理是什么？
### 27、Android 中的动画有哪几类，它们的特点和区别是什么
### 28、16Android性能优化
### 29、注册广播有几种方式，这些方式有何优缺点？请谈谈Android引入广播机制的用意。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
