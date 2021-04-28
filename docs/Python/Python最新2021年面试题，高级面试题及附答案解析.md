# Python最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么数据很大的时候使用limit offset分页时，越往后翻速度越慢，如何优化？

使用limit分页时，比如limit 10000，20的意思是扫描满足条件的10020行，扔掉前面的10000行，最后返回20行，问题就出在这，当数据量大的时候，大量时间花在了扫描上面了。

**优化方法：**

**1、** 当一个数据库表过于庞大，LIMIT offset, length中的offset值过大，则SQL查询语句会非常缓慢，你需增加order by，并且order by字段需要建立索引。

**2、** 如果使用子查询去优化LIMIT的话，则子查询必须是连续的，某种意义来讲，子查询不应该有where条件，where会过滤数据，使数据失去连续性


### 2、简述生成器，迭代器，装饰器以及应用场景

**1、** 迭代器对象实现了iter()方法

**2、** 迭代器实现了iter()和next()方法，迭代器对象从集合的第一个元素开始访问，直到所有的元素被访问完结束

**3、** 生成器是迭代器的一种，一个函数调用时返回一个迭代器，这个函数就叫生成器。通常带有yield

**4、** 装饰器是一个以函数作为参数，并返回一个替换函数的可执行函数，是闭包的一种应用。通常用来给一个函数添加功能


### 3、Redis默认多少个db

默认有16个数据库


### 4、如何实现响应式布局

**1、** 流体布局

其实就是度量单位的改变。在响应式设计的布局中，不在把像素(px)作为唯一的单位，而是采用%或者是混合%、px为单位，设计出自己想要的布局方式。

**2、** 媒体查询

媒体查询可以在你根据特定的环境下查询到各种属性---------比如设备类型，分辨率、屏幕物理尺寸以及色彩等。通过使用媒体查询，可以获得设备的一些特性，以及响应式的布局方案。

**3、** 弹性图片

其实在做响应式布局时，大多用到的是弹性盒子进行布局，那么在设置图片的地方也应该具有一些变化以适应布局的变化。出了图片外，像图标啦！视频啦也应做一些调整用以适应布局的变化。


### 5、如何保证Redis中的数据都是热点数据

**1、** Redis 内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略。Redis 提供 6种数据淘汰策略：

**2、** volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**3、** volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**4、** volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**5、** allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**6、** allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰

**7、** no-enviction（驱逐）：禁止驱逐数据


### 6、什么是反射，以及应用场景

[什么是反射的解释](https://www.cnblogs.com/IT-Scavenger/p/9394306.html)

**1、** 反射就是通过字符串的形式，导入模块；通过字符串的形式，去模块寻找指定函数，并执行。利用字符串的形式去对象（模块）中操作（查找/获取/删除/添加）成员，一种基于字符串的事件驱动！

**2、** 应用场景：当我们动态的输入一个模块名的时候就可以使用到反射。

**3、** 通过hasattr，getattr，delattr，setattr等四个函数来操作


### 7、mro是什么？

对于支持继承的编程语言来说，其方法（属性）可能定义在当前类，也可能来自于基类，所以在方法调用时就需要对当前类和基类进行搜索以确定方法所在的位置。而搜索的顺序就是所谓的「方法解析顺序」（Method Resolution Order，或MRO）。


### 8、解释*args和**kwargs？

*args，是当我们不确定要传递给函数参数的数量时使用的。

```
def add（* num）：
    sum = 0 
    for val in num：
        sum = val + sum 
    print（sum）


add（4,5）
add（7,4,6）
add（10,34,23）
--------------------- 
9 
17 
57
```

**kwargs，是当我们想将字典作为参数传递给函数时使用的。

```
def intro(**data):
    print("\nData type of argument:",type(data))
    for key, value in data.items():
        print("{} is {}".format(key,value))


intro(name="alex",Age=22, Phone=1234567890)
intro(name="louis",Email="a@gmail.com",Country="Wakanda", Age=25)
--------------------------------------------------------------
Data type of argument: <class 'dict'>
name is alex
Age is 22
Phone is 1234567890

Data type of argument: <class 'dict'>
name is louis
Email is a@gmail.com
Country is Wakanda
Age is 25
```


### 9、简述OSI七层协议

为了实现计算机系统的互连，OSI参考模型把整个网络的通信功能划分为7个层次，同时也定义了层次之间的相互关系以及各层所包括的服务及每层的功能。OSI的七层由低到高依次为：物理层、数据链路层、网络层、传输层、会话层、表示层、应用层，下三层（物理层、数据链路层、网络层）面向数据通信，而上三层（会话层、表示层、应用层）则面向资源子网，而传输层则是七层中最为重要的一层。它位于上层和下层中间，起承上启下的作用。


### 10、前后端分离的基本原理

前后端分离并非仅仅只是一种开发模式，而是一种架构模式（前后端分离架构）。前端项目与后端项目是两个项目，放在两个不同的服务器，需要独立部署，两个不同的工程，两个不同的代码库，不同的开发人员。前后端工程师需要约定交互接口，实现并行开发，开发结束后需要进行独立部署，前端通过Ajax来调用HTTP请求调用后端的restful api。前端只需要关注页面的样式与动态数据的解析&渲染，而后端专注于具体业务逻辑。


### 11、什么是C/S和B/S架构
### 12、如何实现字符串的反转？如：name=felix，反转成name=xilef
### 13、axios的作用
### 14、列表和元组之间的区别是？
### 15、三元运算编写格式
### 16、对列表[3,1,-4,-2]按照绝对值排序
### 17、python哪些类型的数据才能作为字典的key？
### 18、python中进制转换
### 19、获取python解释器版本的方法
### 20、编写一个函数，找出数组中没有重复的值的和
### 21、什么是rpc
### 22、生产者消费者模型的应用场景
### 23、元组的解封装是什么？
### 24、Python中的生成器是什么？
### 25、python的可变类型和不可变类型的区别
### 26、输入某年某月某日，判断这是这一年的第几天？
### 27、解释一下Python中的逻辑运算符
### 28、了解过Hbase，DB2，SQLServer，Access吗
### 29、双下划线和单下划线的区别
### 30、Redis中watch的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
