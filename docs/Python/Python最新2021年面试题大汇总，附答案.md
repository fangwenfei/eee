# Python最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、python哪些类型的数据才能作为字典的key？

可哈希的类型


### 2、列表和元组之间的区别是？

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


### 3、怎样将字符串转换为小写？

我们使用lower()方法。

```
>>> 'AyuShi'.lower()
```

结果：

```
‘ayushi’
```

使用upper()方法可以将其转换为大写。

```
>>> 'AyuShi'.upper()
```

结果：

```
‘AYUSHI’
```

另外，使用isupper()和islower()方法检查字符春是否全为大写或小写。

```
>>> 'AyuShi'.isupper()
False
 
>>> 'AYUSHI'.isupper()
True
 
>>> 'ayushi'.islower()
True
 
>>> '@yu$hi'.islower()
True
 
>>> '@YU$HI'.isupper()
True
```

那么，像@和$这样的字符既满足大写也满足小写。

Istitle()能告诉我们一个字符串是否为标题格式。

```
>>> 'The Corpse Bride'.istitle()
True
```


### 4、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。

```python
alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]
blist=sorted(alist,key=lambda x:x['age'],reverse=True)
print(blist)
```


### 5、用一行Python代码，从给定列表中取出所有的偶数和奇数

```
a = [1,2,3,4,5,6,7,8,9,10]
odd, even = [el for el in a if el % 2==1], [el for el in a if el % 2==0]

print(odd,even)
> ([1, 3, 5, 7, 9], [2, 4, 6, 8, 10])
```


### 6、索引有什么作用，有哪些分类，有什么好处和坏处？

作用：为了增加查询速度，提高系统性能

**分类：**

**1、** 唯一索引：不允许其中任何两行具有相同索引值的索引。

**2、** 非唯一索引：允许其中任何两行具有相同索引值的索引。

**3、** 主键索引：有一列或列组合，其值唯一标识表中的每一行。

**4、** 聚集索引：表中行的物理顺序与键值的逻辑（索引）顺序相同。一个表只能包含一个聚集索引。

**好处：**

**1、** 帮助用户提高查询速度

**2、** 利用索引的唯一性来控制记录的唯一性

**3、** 可以加速表与表之间的连接

**4、** 降低查询中分组和排序的时间

**坏处：**

**1、** 存储索引占用磁盘空间

**2、** 执行数据修改操作(INSERT、UPDATE、DELETE)产生索引维护


### 7、MySQL常见数据库引擎及区别

**1、** InnoDB：用于事务处理应用程序，具有众多特性，包括ACID事务支持。(提供行级锁)

**2、** MyISAM：默认的MySQL插件式存储引擎，它是在Web、数据仓储和其他应用环境下最常使用的存储引擎之一。注意，通过更改STORAGE_ENGINE配置变量，能够方便地更改MySQL服务器的默认存储引擎。

**3、** Memory：将所有数据保存再RAM中


### 8、解释一下Python中的成员运算符

通过成员运算符‘in’和‘not in’，我们可以确认一个值是否是另一个值的成员。

```
>>> 'me' in 'disappointment'
True
 
>>> 'us' not in 'disappointment'
True
```


### 9、获取python解释器版本的方法

终端执行python -V


### 10、Redis中默认有多少个哈希槽

**1、** 2^14个

**2、** Redis 集群没有使用一致性hash, 而是引入了哈希槽的概念。


### 11、生产者消费者模型的应用场景
### 12、生成器与函数的区别？
### 13、MySQL的增删改查
### 14、如何基于Redis实现发布和订阅
### 15、break、continue、pass是什么？
### 16、Python中OOPS是什么？
### 17、Python中的单引号和双引号有什么区别？
### 18、你了解哪些数据库优化方案
### 19、Python有哪些特点和优点？
### 20、编写程序，查找文本文件中最长的单词
### 21、简述线程死锁是怎么造成的。如何避免？
### 22、如果已经建立了TCP连接，但是客户端突然出现故障了怎么办
### 23、什么是Flask？
### 24、手写一个队列
### 25、Python中的Map Function是什么？
### 26、列举Redis支持的过期策略
### 27、如何修改本地hosts文件
### 28、编写程序，打印斐波那契数列的前十项
### 29、什么是索引合并
### 30、请列举你所知道的python代码检测工具以及他们之间的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
