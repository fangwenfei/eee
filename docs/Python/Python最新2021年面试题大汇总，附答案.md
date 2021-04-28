# Python最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、为什么Python执行速度慢，我们如何改进它？

Python代码执行缓慢的原因，是因为它是一种解释型语言。它的代码在运行时进行解释，而不是编译为本地语言。

为了提高Python代码的速度，我们可以使用CPython、Numba，或者我们也可以对代码进行一些修改。

**1、**  减少内存占用。

**2、**  使用内置函数和库。

**3、**  将计算移到循环外。

**4、**  保持小的代码库。

**5、**  避免不必要的循环


### 2、Python中的pass语句是什么？

在用Python写代码时，有时可能还没想好函数怎么写，只写了函数声明，但为了保证语法正确，必须输入一些东西，在这种情况下，我们会使用pass语句。

```
 >>> def func(*args):
           pass 
>>>
```

同样，break语句能让我们跳出循环。

```
>>> for i in range(7):
    if i==3: break
print(i)
```

结果：

```
0
 
1
 
2
```

最后，continue语句能让我们跳到下个循环。

```
>>> for i in range(7):
    if i==3: continue
print(i)
```

结果：

```
0
 
1
 
2
 
4
 
5
 
6
```


### 3、类的加载和实例化过程

**1、** 在堆内存中生成class对象, 把静态变量和静态方法加载到方法区, 这个堆内存中的class对象是方法区数据的入口

**2、** 静态变量默认初始化

**3、** 静态变量显式初始化

**4、** 执行静态代码块

**5、** 成员变量默认初始化, 显示初始化

**6、** 执行构造函数


### 4、用一行代码实现数值交换

**1、** a=1

**2、** b=2

**3、** 答案：a,b=b,a


### 5、对列表[3,1,-4,-2]按照绝对值排序

```python
lis=[3,1,-4,-2]
lis=sorted(lis,key=lambda x:abs(x))
print(lis)
```


### 6、简述python字符串的驻留机制

[python字符串驻留机制参考文档](https://www.cnblogs.com/asmer-stone/p/4802800.html)

**1、** 相同对象的引用都指向内存中的同一个位置，这个也叫python的字符串驻留机制

**2、** python的引用计数机制，并不是对所有的数字，字符串，他只对”[0-9][a-z][A-Z]

**3、** 和"_"(下划线)  ”有效“，当字符串中由其他字符比如“！ @ # ￥ % -”时字符驻留机制是不起作用的。


### 7、什么时GIL锁

**1、** 即全局解释器锁，

**2、** 一个时间点只有一个线程处于执行状态。


### 8、列表和元组之间的区别是？

二者的主要区别是列表是可变的，而元组是不可变的。举个例子，如下所示：

```
>>> mylist=[1,3,3]
>>> mylist[1]=2
>>> mytuple=(1,3,3)
>>> mytuple[1]=2
Traceback (most recent call last):
File "<pyshell#97>", line 1, in <module>
mytuple[1]=2
```

会出现以下报错：

```
TypeError: ‘tuple’ object does not support item assignment
```

关于列表和元组的更多内容，可以查看这里：


### 9、进程之间如何进行通信？

**1、** 共享内存

通过mmap模块实现

2、信号

**3、** 通过Queue队列

**4、** 通过Pipe管道

**5、** 通过socket


### 10、Redis中默认有多少个哈希槽

**1、** 2^14个

**2、** Redis 集群没有使用一致性hash, 而是引入了哈希槽的概念。


### 11、在python中如何拷贝一个对象，并说明他们之间的区别
### 12、列表推导式[i for i in range(10)]和生成式表达式(i for i in range(10))的区别
### 13、请列举布尔值位False的常见值
### 14、query作为sql模板，args为将要传入的参数
### 15、在Python中是如何管理内存的？
### 16、写出以下代码的输出结果：
### 17、一行代码实现删除列表中的所有的重复的值
### 18、Redis如何实现主从复制？以及数据同步机制？
### 19、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。
### 20、什么是索引合并
### 21、什么是闭包
### 22、logging模块的作用以及应用场景
### 23、什么是arp协议
### 24、列表中保留顺序和不保留顺序去重
### 25、从0-99这100个数中随机取出10个，要求不能重复
### 26、写出邮箱的正则表达式
### 27、用尽量简洁的方法将二维数组合并成一维数组
### 28、什么是switch语句。如何在Python中创建switch语句？
### 29、python中如何使用进程池和线程池
### 30、写一个的支持with语句的类




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
