# Python最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、什么是多态？

多态(Polymorphism)的意思是「许多形式」。

子类可以定义自己的独特行为，并且仍然共享其父类/基类的相同功能或行为。


### 2、什么是haproxy？

HAProxy是一个使用C语言编写的自由及开放源代码软件，其提供高可用性、负载均衡，以及基于TCP和HTTP的应用程序代理


### 3、如果已经建立了TCP连接，但是客户端突然出现故障了怎么办

TCP还设有一个保活计时器，显然，客户端如果出现故障，服务器不能一直等下去，白白浪费资源。服务器每收到一次客户端的请求后都会重新复位这个计时器，时间通常是设置为2小时，若两小时还没有收到客户端的任何数据，服务器就会发送一个探测报文段，以后每隔75秒发送一次。若一连发送10个探测报文仍然没反应，服务器就认为客户端出了故障，接着就关闭连接。


### 4、Python有哪些特点和优点？

作为一门编程入门语言，Python主要有以下特点和优点：

**1、** 可解释

**2、** 具有动态特性

**3、** 面向对象

**4、** 简明简单

5、开源

**6、** 具有强大的社区支持

当然，实际上Python的优点远不止如此，


### 5、求以下代码的输出结果

```python
collapse=True
processFunc=collapse and (lambda s:' '.join(s.split())) or (lambda s:s)
print(processFunc('i\tam\ntest\tproject!'))

collapse=False
processFunc=collapse and (lambda s:' '.join(s.split())) or (lambda s:s)
print(processFunc('i\tam\ntest\tproject!'))
```

答案：

> i am test project!

i       am

test    project!



### 6、如何高效的找到Redis中所有以felix开头的key

**1、** scan 0 match felixcount 5

**2、** 表示从游标0开始查询felix开头的key，每次返回5条，但是这个5条不一定


### 7、is和==的区别

is比较的是两个对象的id是否相同

==比较的是两个对象的值是否相同


### 8、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？

对的


### 9、简述jsonp及其原理

JSONP是JSON with Padding的略称。它是一个非官方的协议，它允许在服务器端集成Script tags返回至客户端，通过javascript callback的形式实现跨域访问（这仅仅是JSONP简单的实现形式）

原理：








### 10、python中enumerate的意思是什么？

枚举的意思，同时得到可迭代对象，如列表和元组的索引和值，以元组形式返回


### 11、css如何隐藏一个元素
### 12、请写一个Python逻辑，计算一个文件中的大写字母数量
### 13、select、poll、epoll模型的区别
### 14、为什么学python
### 15、ascii、Unicode、utf-8、gbk的区别
### 16、python的底层网络交互模块有哪些
### 17、a=range(10),则a[::-3]的值是？
### 18、super的作用
### 19、Python中的pass语句是什么？
### 20、Redis中sentinel的作用
### 21、列举你所了解的所有Python2和Python3的区别
### 22、MySQL的增删改查
### 23、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。
### 24、yield from 和 yield 的区别
### 25、实现一个装饰器，限制该函数被调用的频率，如10秒一次
### 26、什么是Python？为什么它会如此流行？
### 27、类的加载和实例化过程
### 28、python是如何进行内存管理的？python的程序会内存泄漏吗？说说有没有什么方面阻止或者检测内存泄漏？
### 29、MySQL慢日志
### 30、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
