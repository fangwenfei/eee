# Python最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、解释re模块的split()、sub()、subn()方法？

split()：只要模式匹配，此方法就会拆分字符串。

sub()：此方法用于将字符串中的某些模式替换为其他字符串或序列。

subn()：和sub()很相似，不同之处在于它返回一个元组，将总替换计数和新字符串作为输出。

```
import re
string = "There are two ball in the basket 101"


re.split("\W+",string)
---------------------------------------
['There', 'are', 'two', 'ball', 'in', 'the', 'basket', '101']

re.sub("[^A-Za-z]"," ",string)
----------------------------------------
'There are two ball in the basket'

re.subn("[^A-Za-z]"," ",string)
-----------------------------------------
('There are two ball in the basket', 10)
```


### 2、什么是rpc

远程过程调用 (RPC) 是一种协议，程序可使用这种协议向网络中的另一台计算机上的程序请求服务

1.RPC采用客户机/服务器模式。请求程序就是一个客户机，而服务提供程序就是一个服务器。

2.首先，客户机调用进程发送一个有进程参数的调用信息到服务进程，然后等待应答信息。

2.在服务器端，进程保持睡眠状态直到调用信息到达为止。当一个调用信息到达，服务器获得进程参数，计算结果，发送答复信息，然后等待下一个调用信息，

3.最后，客户端调用进程接收答复信息，获得进程结果，然后调用执行继续进行。


### 3、编写一个函数，找出数组中没有重复的值的和

```python
def func(lis):
lis1=[]
del_lis=[]
for i in lis:
if i not in lis1:
if i not in del_lis:
    lis1.append(i)
else:
del_lis.append(i)
lis1.remove(i)
return sum(lis1)

def func2(lis):
return sum([i for i in set(lis) if lis.count(i)==1])

print(func2([3,4,1,2,5,6,6,5,4,3,3]))
```


### 4、解释Python中的join()和split()函数

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


### 5、MySQL索引种类

**1、** 普通索引：仅加速查询

**2、** 唯一索引：加速查询 + 列值唯一（可以有null）

**3、** 主键索引：加速查询 + 列值唯一（不可以有null）+ 表中只有一个

**4、** 组合索引：多列值组成一个索引，专门用于组合搜索，其效率大于索引合并

**5、** 全文索引：对文本的内容进行分词，进行搜索


### 6、实例方法、静态方法和类方法的区别

**1、** 实例方法：第一个参数必须是实例对象，通常为self。实例方法只能由实例对象调用。

**2、** 类方法：使用装饰器@classmethod。第一个参数为当前类的对象，通常为cls。实例对象和类对象都可以调用类方法。

**3、** 静态方法：使用装饰器@staticmethod。没有self和cls参数。方法体中不能使用类或者实例的任何属性和方法。实例对象和类对象都可以调用。


### 7、如何实现Redis集群

**1、** Twitter开发的twemproxy

**2、** 豌豆荚开发的codis

**3、** Redis官方的Redis-cluster


### 8、区分Python中的remove，del和pop？
### 9、什么是ajax请求？手写一个ajax请求
### 10、什么是lambda函数？
### 11、在python中如何拷贝一个对象，并说明他们之间的区别
### 12、MySQL如何创建索引
### 13、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今
### 14、写一个函数，计算出以下字母所代表的数字，每个字母值不一样
### 15、类的加载和实例化过程
### 16、请写一个Python逻辑，计算一个文件中的大写字母数量
### 17、怎样将字符串转换为小写？
### 18、求以下代码的输出结果
### 19、以下代码输出什么？
### 20、简述触发器、函数、视图和存储过程
### 21、为什么学python
### 22、is和==的区别
### 23、Python有哪些应用？
### 24、Redis中sentinel的作用
### 25、xrange和range的区别
### 26、什么是Python？为什么它会如此流行？
### 27、ascii、Unicode、utf-8、gbk的区别
### 28、如何查找一个字符串中特定的字符？find和index的差异？
### 29、如何基于Redis实现发布和订阅
### 30、列表中保留顺序和不保留顺序去重




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
