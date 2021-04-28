# Python最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}

```python
tuple1=('a','b','c','d','e')
tuple2=(1,2,3,4,5)
res=dict(zip(tuple1,tuple2))
print(res)
```


### 2、vue中的路由拦截器的作用

当某些页面需要访问权限时，可以使用路由拦截器对用户权限进行判断


### 3、query作为sql模板，args为将要传入的参数

execute(query, args=None)


### 4、索引有什么作用，有哪些分类，有什么好处和坏处？

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


### 5、什么是arp协议

**1、** ARP全称“Address Resolution Protocol”，地址解析协议。

**2、** 实现局域网内通过IP地址获取主机的MAC地址。

**3、** MAC地址48位主机的物理地址，局域网内唯一。

**4、** ARP协议类似DNS服务，但不需要配置服务。

**5、** ARP协议是三层协议。


### 6、json序列化时可以处理的数据类型有哪些？如何定制支持datetime类型？序列化时，遇到中文转成unicode，如何保持中文形式？

**1、** 可以处理的数据类型是 string、int、list、tuple、dict、bool、null

**2、** 通过自定义时间序列化转换器

```python
import json
from json import JSONEncoder
from datetime import datetime
class ComplexEncoder(JSONEncoder):
def default(self, obj):
if isinstance(obj, datetime):
return obj.strftime(‘%Y-%m-%d %H:%M:%S‘)
else:
return super(ComplexEncoder,self).default(obj)
d = { ‘name‘:‘alex‘,‘data‘:datetime.now()}
print(json.dumps(d,cls=ComplexEncoder))
# {"name": "alex", "data": "2018-05-18 19:52:05"}
```

**3、** 使用ensure_ascii=False参数


### 7、为什么Python执行速度慢，我们如何改进它？

Python代码执行缓慢的原因，是因为它是一种解释型语言。它的代码在运行时进行解释，而不是编译为本地语言。

为了提高Python代码的速度，我们可以使用CPython、Numba，或者我们也可以对代码进行一些修改。

**1、**  减少内存占用。

**2、**  使用内置函数和库。

**3、**  将计算移到循环外。

**4、**  保持小的代码库。

**5、**  避免不必要的循环


### 8、如何基于Redis实现发布和订阅

```python
# 发布者
#coding:utf-8import time
import Redis

number_list = ['300033', '300032', '300031', '300030']
signal = ['1', '-1', '1', '-1']

rc = Redis.StrictRedis(host='***', port='6379', db=3, password='********')
for i in range(len(number_list)):
value_new = str(number_list[i]) + ' ' + str(signal[i])
rc.publish("liao", value_new)  #发布消息到liao
```

```python
# 订阅者
#coding:utf-8import time
import Redis

rc = Redis.StrictRedis(host='****', port='6379', db=3,     password='******')
ps = rc.pubsub()
ps.subscribe('liao')  #从liao订阅消息for item in ps.listen():        #监听状态：有消息发布了就拿过来
if item['type'] == 'message':
print item['channel']
print item['data']
```


### 9、简述进程，线程，协程的区别以及应用场景？

**区别：**

**1、** 线程是资源分配的单位

**2、** 线程是操作系统调度的单位

**3、** 进程切换需要的资源很大，效率很低

**4、** 线程切换需要的资源一般，效率一般(在不考虑GIL的情况下

**5、** 协程切换任务资源很小，效率高

**6、** 多进程，多线程根据cpu核数不一样可能是并行的，但是协程是在一个线程中，所以是并发。)

**应用场景**

**1、** 协程：当程序中存在大量不需要cpu的操作时，适用协程

**2、** 计算密集型，用进程。IO密集型，用线程。


### 10、实例方法、静态方法和类方法的区别

**1、** 实例方法：第一个参数必须是实例对象，通常为self。实例方法只能由实例对象调用。

**2、** 类方法：使用装饰器@classmethod。第一个参数为当前类的对象，通常为cls。实例对象和类对象都可以调用类方法。

**3、** 静态方法：使用装饰器@staticmethod。没有self和cls参数。方法体中不能使用类或者实例的任何属性和方法。实例对象和类对象都可以调用。


### 11、什么是正向代理和反向代理？
### 12、解释re模块的split()、sub()、subn()方法？
### 13、如何保证api调用时数据的安全性
### 14、是否使用过functools中的函数？他的作用是什么？
### 15、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序
### 16、isinstance和type的作用
### 17、一个数如果恰好等于它的因子之和，这个数就称为‘完数’，比如6=1+2+3，编程找出1000以内的所有的完数。
### 18、简述数据库的读写分离
### 19、python代码如何获取命令行参数
### 20、Redis中sentinel的作用
### 21、什么是cdn
### 22、区分Python中的remove，del和pop？
### 23、如何实现"1.2.3"变成['1','2','3']?
### 24、守护线程，守护进程是什么
### 25、求出以下代码的输出结果
### 26、什么是Python中的猴子补丁？
### 27、py2项目如何迁移成py3
### 28、什么是并发和并行
### 29、生成器与函数的区别？
### 30、MySQL的半同步复制原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
