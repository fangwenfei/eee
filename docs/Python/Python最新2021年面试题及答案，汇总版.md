# Python最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、在Python中有多少种运算符？解释一下算数运算符。

在Python中，我们有7种运算符：算术运算符、关系运算符、赋值运算符、逻辑运算符、位运算符、成员运算符、身份运算符。

我们有7个算术运算符，能让我们对数值进行算术运算：

**1、** 加号（+），将两个值相加

```
>>> 7+8
15
```

**2、** 减号（-），将第一个值减去第二个值

```
>>> 7-8
-1
```

**3、** 乘号（*），将两个值相乘

```
>>> 7*8
56
```

**4、** 除号（/），用第二个值除以第一个值

```
>>> 7/8
0.875
>>> 1/1
1.0
```

**5、** 向下取整除、取模和取幂运算，参见上个问题。


### 2、什么是断言(assert)?应用场景？

[断言的参考](https://blog.csdn.net/shujuanyaning/article/details/47184541)

assert是用来检查一个条件，如果它为真，就不做任何事。如果它为假，则会抛出AssertError并且包含错误信息。

**应用场景**：

**1、** 防御型编程

**2、** 运行时检查程序逻辑

**3、** 检查约定

**4、** 程序常量

**5、** 检查文档


### 3、什么是封装？

封装(Encapsulation)意味着将数据和成员函数包装在一起成为一个单元。

它还实现了数据隐藏的概念。


### 4、什么是反射，以及应用场景

[什么是反射的解释](https://www.cnblogs.com/IT-Scavenger/p/9394306.html)

**1、** 反射就是通过字符串的形式，导入模块；通过字符串的形式，去模块寻找指定函数，并执行。利用字符串的形式去对象（模块）中操作（查找/获取/删除/添加）成员，一种基于字符串的事件驱动！

**2、** 应用场景：当我们动态的输入一个模块名的时候就可以使用到反射。

**3、** 通过hasattr，getattr，delattr，setattr等四个函数来操作


### 5、类的加载和实例化过程

**1、** 在堆内存中生成class对象, 把静态变量和静态方法加载到方法区, 这个堆内存中的class对象是方法区数据的入口

**2、** 静态变量默认初始化

**3、** 静态变量显式初始化

**4、** 执行静态代码块

**5、** 成员变量默认初始化, 显示初始化

**6、** 执行构造函数


### 6、请解释使用*args和**kwargs的含义

当我们不知道向函数传递多少参数时，比如我们向传递一个列表或元组，我们就使用*args。

```
>>> def func(*args):
    for i in args:
        print(i)  
>>> func(3,2,1,4,7)
```

运行结果为：

```
3
 
2
 
1
 
4
 
7
```

在我们不知道该传递多少关键字参数时，使用**kwargs来收集关键字参数。

```
>>> def func(**kwargs):
    for i in kwargs:
        print(i,kwargs[i])
>>> func(a=1,b=2,c=7)
```

运行结果为：

```
a.1
 
b.2
 
c.7
```


### 7、break、continue、pass是什么？

break：在满足条件时，它将导致程序退出循环。

continue：将返回到循环的开头，它使程序在当前循环迭代中的跳过所有剩余语句。

pass：使程序传递所有剩余语句而不执行。


### 8、MySQL常见的函数

**1、** ABS(x)：返回x的绝对值

**2、** ROUND(x)：返回参数x的四舍五入的一个整数

**3、** TRIM(str)：去除字符串两边的空白

**4、** COUNT()：返回值的个数

**5、** AVG()：返回平均值

**6、** SUM()：求和


### 9、列举字符串、列表、元组、字典每个常用的5个方法

**字符串**

**1、** strip() ->去掉字符串两端的空白符

**2、** split() ->对字符串进行分割，默认按照空格分割

**3、** join() ->字符串连接

**4、** startwith(),endwith() ->判断是否以啥开头或者结尾

**5、** replace() -> 字符串替换

**6、** find() -> 查找字符串，存在返回第一个索引，不存在返回-1

**列表**

**1、** count() ->统计在列表中出现的个数

**2、** apped() ->在列表末尾添加值

**3、** pop() ->删除一个对象，默认最后一个

**4、** remove() ->删除指定的第一个匹配项

**5、** insert() ->插入对象

**6、** index() ->获取索引

**元组**

**1、** count() ->统计在元组中出现的个数

**2、** index() ->获取索引

**字典**

**1、** keys() ->获取所有的键

**2、** pop() ->删除指定的键的键值对

**3、** popitem() ->随机删除一个键值对

**4、** update() ->更新字典，参数为一个字典，如果键已存在，则更改，不存在则添加

**5、** setdefault() ->如果键存在则，返回该键对应的值，如果不存在，设置该键为设置的默认值，然后返回该键对应的值

**6、** get() ->返回键对应的值

**7、** fromkeys() ->创建字典，第一个参数为可迭代对象，每个值变成字典的键，第二个参数为每个键的默认值


### 10、解释一下Python中的身份运算符

这也是一个在Python面试中常问的问题。

通过身份运算符‘is’和‘is not’，我们可以确认两个值是否相同。

```
>>> 10 is '10'
False
 
>>> True is not False
True
```


### 11、生产者消费者模型的应用场景
### 12、什么是Nginx
### 13、MySQL执行计划的作用和使用方法
### 14、如何保证api调用时数据的安全性
### 15、通过什么途径学习python
### 16、Redis如何实现主从复制？以及数据同步机制？
### 17、Redis是单进程单线程的吗？
### 18、如何在Python中管理内存？
### 19、Redis和Memcached的区别
### 20、py2项目如何迁移成py3
### 21、一个大小为100G的文件etl_log.txt，要读取文件的内容，写出具体过程代码
### 22、什么是ajax请求？手写一个ajax请求
### 23、_init_在Python中有什么用？
### 24、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。
### 25、什么是lambda函数？
### 26、如何使用python删除一个文件或者文件夹？
### 27、MySQL的建表语句
### 28、Python的局限性？
### 29、select、poll、epoll模型的区别
### 30、vuex的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
