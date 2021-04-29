# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是猴子补丁？

在运行期间动态修改一个类或模块。

```
>>> class A:
    def func(self):
        print("Hi")
>>> def monkey(self):
print "Hi, monkey"
>>> m.A.func = monkey
>>> a = m.A()
>>> a.func()
```

运行结果为：

```
Hi, Monkey
```


### 2、如何保证Redis中的数据都是热点数据

**1、** Redis 内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略。Redis 提供 6种数据淘汰策略：

**2、** volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**3、** volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**4、** volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**5、** allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**6、** allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰

**7、** no-enviction（驱逐）：禁止驱逐数据


### 3、求以下代码结果：

```python
def num():
return [lambda x:i*x for i in range(4)]
print([m(2) for m in num()])
```

答案：[6,6,6,6]


### 4、char和varchar的区别

**1、** 保存方式不一样

**2、** char有固定的长度，而varchar属于可变长的字符类型

**3、** char的效率比varchar高


### 5、axios的作用

**axios是基于promise的用于浏览器和nodejs的HTTP客户端，本身有以下特征：**

**1、** 从浏览器中创建XMLHttpRequest；

**2、** 从nodejs发出http请求

**3、** 支持promiseAPI

**4、** 拦截 请求和响应

**5、** 转换请求和响应数据

**6、** 取消请求

**7、** 自动转换JSON数据

**8、** 客户端支持防止CSRF/XSRF攻击


### 6、如何实现响应式布局

**1、** 流体布局

其实就是度量单位的改变。在响应式设计的布局中，不在把像素(px)作为唯一的单位，而是采用%或者是混合%、px为单位，设计出自己想要的布局方式。

**2、** 媒体查询

媒体查询可以在你根据特定的环境下查询到各种属性---------比如设备类型，分辨率、屏幕物理尺寸以及色彩等。通过使用媒体查询，可以获得设备的一些特性，以及响应式的布局方案。

**3、** 弹性图片

其实在做响应式布局时，大多用到的是弹性盒子进行布局，那么在设置图片的地方也应该具有一些变化以适应布局的变化。出了图片外，像图标啦！视频啦也应做一些调整用以适应布局的变化。


### 7、MySQL常见数据库引擎及区别

**1、** InnoDB：用于事务处理应用程序，具有众多特性，包括ACID事务支持。(提供行级锁)

**2、** MyISAM：默认的MySQL插件式存储引擎，它是在Web、数据仓储和其他应用环境下最常使用的存储引擎之一。注意，通过更改STORAGE_ENGINE配置变量，能够方便地更改MySQL服务器的默认存储引擎。

**3、** Memory：将所有数据保存再RAM中


### 8、GIL锁对python性能的影响
### 9、解释Python中的Filter？
### 10、解释一下Python中的三元运算子
### 11、如何实现字符串的反转？如：name=felix，反转成name=xilef
### 12、发生粘包现象如何处理？
### 13、实现一个单例模式。(尽可能多的方法)
### 14、简述left join和right join的区别
### 15、描述以下dict的items和iteritems的区别
### 16、什么是反射，以及应用场景
### 17、怎么移除一个字符串中的前导空格？
### 18、索引有什么作用，有哪些分类，有什么好处和坏处？
### 19、请列出至少5个PEP8规范
### 20、简述python字符串的驻留机制
### 21、在Python中如何使用多进制数字？
### 22、css如何隐藏一个元素
### 23、什么是cdn
### 24、现有mydict和变量onekey，请写出从mydict中取出onekey的值的方法
### 25、什么是haproxy？
### 26、编写程序，检查序列是否为回文
### 27、使用两个队列实现一个栈
### 28、Python中append，insert和extend的区别?
### 29、什么是LVS




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
