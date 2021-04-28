# Python最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释Python中的join()和split()函数

Join()能让我们将指定字符添加至字符串中。

```
>>> ','.join('12345')
```

运行结果：

```
‘1,2,3,4,5’
```

Split()能让我们用指定字符分割字符串。

```
>>> '1,2,3,4,5'.split(',')
```

运行结果：

```
[‘1’, ‘2’, ‘3’, ‘4’, ‘5’]
```


### 2、Python区分大小写吗？

如果能区分像myname和Myname这样的标识符，那么它就是区分大小写的。也就是说它很在乎大写和小写。我们可以用Python试一试：

```
>>> myname='Ayushi'
>>> Myname
Traceback (most recent call last):
File "<pyshell#3>", line 1, in <module>
```

运行结果：

```
Myname

NameError: name ‘Myname’ is not defined
```

可以看到，这里出现了NameError，所以Python是区分大小写的。


### 3、什么是cdn

cdn全称是内容分发网络。其目的是让用户能够更快速的得到请求的数据。

cdn就是用来加速的，他能让用户就近访问数据，这样就更更快的获取到需要的数据。


### 4、通过什么途径学习python

**1、** 通过看官方文档

**2、** 通过哔哩哔哩上的视频教程

**3、** 通过百度查资料

**4、** 通过买python相关方面的书


### 5、为何不建议以下划线作为标识符的开头

因为Python并没有私有变量的概念，所以约定速成以下划线为开头来声明一个变量为私有。所以如果你不想让变量私有，就不要使用下划线开头。


### 6、实现一个装饰器，限制该函数被调用的频率，如10秒一次

```python
import time
from functools import wraps
def dec(func):
key=func.__name__
cache={key:None}
@wraps(func)
def inner(*args,**kwargs):
result=None
if cache.get(key) is None:
cache[key]=time.time()
result=func(*args,**kwargs)
print('执行函数中')
else:
now=time.time()
if now-cache[key]>10:
    cache[key]=now
    result=func(*args,**kwargs)
    print('执行函数中')
else:
    print('函数执行受限')
return result
return inner

@dec
def add(x,y):
print(x+y)

add(1,2)
add(1,3)
time.sleep(10)
add(3,4)
```


### 7、a = dict(zip(('a','b','c','d','e'),(1,2,3,4,5))) 请问a是什么？

**{'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}**


### 8、了解过Hbase，DB2，SQLServer，Access吗

**1、** Hbase：HBase是一个分布式的、面向列的开源数据库

**2、** DB2：一套关系型数据库管理系统，

**3、** SQLServer：SQL Server是由Microsoft开发和推广的关系数据库管理系统

**4、** Sccess：Access是由微软发布的关系数据库管理系统。


### 9、MySQL索引种类

**1、** 普通索引：仅加速查询

**2、** 唯一索引：加速查询 + 列值唯一（可以有null）

**3、** 主键索引：加速查询 + 列值唯一（不可以有null）+ 表中只有一个

**4、** 组合索引：多列值组成一个索引，专门用于组合搜索，其效率大于索引合并

**5、** 全文索引：对文本的内容进行分词，进行搜索


### 10、索引再什么情况下遵循最左前缀的规则？

在多字段进行索引的时候，会遵循以上原则


### 11、将列表按照下列规则排序：
### 12、关于Python程序的运行方面，有什么手段能提升性能？
### 13、解释一下Python中的关系运算符
### 14、字节码和机器码的区别
### 15、描述以下dict的items和iteritems的区别
### 16、如何判断一个对象是否可调用？哪些对象是可调用对象？如何定义一个类，使其对象本身就是可调用对象？
### 17、python的底层网络交互模块有哪些
### 18、实现一个装饰器，通过一次调用，使函数重复执行5次
### 19、super的作用
### 20、曾经使用过哪些前端框架
### 21、什么是负索引？
### 22、讲讲Python中的位运算符
### 23、什么是猴子补丁？
### 24、简述进程，线程，协程的区别以及应用场景？
### 25、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来
### 26、怎样声明多个变量并赋值？
### 27、解释*args和**kwargs？
### 28、数据库的导入与导出命令
### 29、MySQL常见数据库引擎及区别
### 30、编写程序，检查数字是否为Armstrong




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
