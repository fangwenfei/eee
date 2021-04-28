# Python最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、python的垃圾回收机制

[python垃圾回收机制详解](https://testerhome.com/topics/16556)

**1、** 概述：python采用的是引用计数机制为主，标记-清除和分代收集两种机制为辅的策略

**2、** 引用计数：

**3、** 每当新的引用指向该对象时，引用计数加1，当对该对象的引用失效时，引用计数减1，当对象的引用计数为0时，对象被回收。缺点是，需要额外的空间来维护引用计数，并且无法解决对象的循环引用。

**4、** 分代回收：（具体见上面链接）

**5、** 以时间换空间的回收方式

**6、** 标记清除：

**7、** 活动对象会被打上标记，会把那些没有被打上标记的非活动对象进行回收。


### 2、比较：a=[1,2,3]和b=[(1),(2),(3)]以及c=[(1,),(2,),(3,)]的区别

a和b的结果相同，列表里面的值相同，类型也相同

c中的列表里面的值是元组类型的


### 3、MySQL如何创建索引

**1、** ALTER TABLE

**2、** ALTER TABLE用来创建普通索引、UNIQUE索引或PRIMARY KEY索引。

**3、** ALTER TABLE table_name ADD INDEX index_name (column_list)

**4、** ALTER TABLE table_name ADD UNIQUE (column_list)

**5、** ALTER TABLE table_name ADD PRIMARY KEY (column_list)

**6、** CREATE INDEX

**7、** CREATE INDEX可对表增加普通索引或UNIQUE索引。

**8、** CREATE INDEX index_name ON table_name (column_list)

**9、** CREATE UNIQUE INDEX index_name ON table_name (column_list)


### 4、输入某年某月某日，判断这是这一年的第几天？

```python
date=input('请输入某年某月某日，格式：xxxx.xx.xx')
def get_day(date):
days1=[31,28,31,30,31,30,31,31,30,31,30,31]
days2=[31,29,31,30,31,30,31,31,30,31,30,31]
year,month,day = [int(i) for i in date.split('.')]
if year % 400 ==0 or (year % 4==0 and year % 100!=0):
days=days2
else:
days=days1
return sum(days[:month-1])+day
print(get_day(date))
```


### 5、深拷贝和浅拷贝之间的区别是什么？

深拷贝就是将一个对象拷贝到另一个对象中，这意味着如果你对一个对象的拷贝做出改变时，不会影响原对象。在Python中，我们使用函数deepcopy()执行深拷贝，导入模块copy，如下所示：

```
>>> import copy
>>> b=copy.deepcopy(a)
```

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/200/33/53_1.png#alt=53%5C_1.png)而浅拷贝则是将一个对象的引用拷贝到另一个对象上，所以如果我们在拷贝中改动，会影响到原对象。我们使用函数function()执行浅拷贝，使用如下所示：

```
>>> b=copy.copy(a)
```

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/200/33/53_2.png#alt=53%5C_2.png)


### 6、写一个的支持with语句的类

[参考链接](https://www.cnblogs.com/yidashi110/p/10091991.html)

```python
class W(object):
def __init__(self):
pass
def __enter__(self):
print('进入with语句')
return self

def __exit__(self,*args,**kwargs):
print('退出with语句')

with W() as w:
print('之前')
print(w)
print('之后')
```


### 7、Python是否有main函数？

是的，它有的。只要我们运行Python脚本，它就会自动执行。


### 8、Python中的字典是什么？

字典是C++和Java等编程语言中所没有的东西，它具有键值对。

```
>>> roots={25:5,16:4,9:3,4:2,1:1}
>>> type(roots)
<class 'dict'>
>>> roots[9]
```

运行结果为：

```
3
```

字典是不可变的，我们也能用一个推导式来创建它。

```
>>> roots={x**2:x for x in range(5,0,-1)}
>>> roots
```

运行结果：

```
{25: 5, 16: 4, 9: 3, 4: 2, 1: 1}
```


### 9、一行代码实现删除列表中的所有的重复的值

```python
lis=[1,1,2,1,22,5]
lis=list(set(lis))
```


### 10、MySQL索引种类

**1、** 普通索引：仅加速查询

**2、** 唯一索引：加速查询 + 列值唯一（可以有null）

**3、** 主键索引：加速查询 + 列值唯一（不可以有null）+ 表中只有一个

**4、** 组合索引：多列值组成一个索引，专门用于组合搜索，其效率大于索引合并

**5、** 全文索引：对文本的内容进行分词，进行搜索


### 11、==和is的区别是？
### 12、Redis和Memcached的区别
### 13、写出如下代码的输出结果
### 14、什么是Nginx
### 15、JavaScript(或者jQuery)如何选择一个id为main的容器
### 16、一个大小为100G的文件etl_log.txt，要读取文件的内容，写出具体过程代码
### 17、曾经使用过哪些前端框架
### 18、b、B、kB、MB、GB的关系
### 19、一行代码通过filter和lambda函数输出alist=[1,22,2,33,23,32]中索引为奇数的值
### 20、简述触发器、函数、视图和存储过程
### 21、简述面向对象的三大特性？
### 22、简述jsonp及其原理
### 23、数据库的导入与导出命令
### 24、Redis是单进程单线程的吗？
### 25、Redis如何实现事务
### 26、什么是轮询和长轮询
### 27、什么是覆盖索引
### 28、什么是多态？
### 29、当退出Python时，是否释放全部内存？
### 30、解释Python中map()函数？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
