# Python最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Python有哪些特点和优点？

作为一门编程入门语言，Python主要有以下特点和优点：

**1、** 可解释

**2、** 具有动态特性

**3、** 面向对象

**4、** 简明简单

5、开源

**6、** 具有强大的社区支持

当然，实际上Python的优点远不止如此，


### 2、使用async语法实现一个协程

```python
import asyncio
import time

now = lambda : time.time()

async def hello():
print("hello")
await asyncio.sleep(2)
return "done"

start = now()
# 协程对象
h1 = hello()
h2 = hello()
h3 = hello()

# 创建一个事件loop
loop = asyncio.get_event_loop()
# 任务（task）对象
tasks = [
asyncio.ensure_future(h1),
asyncio.ensure_future(h2),
asyncio.ensure_future(h3),
]

# 将协程加入到事件循环loop
loop.run_until_complete(asyncio.wait(tasks))
for task in tasks:
print(task.result())

print(now()-start)
```


### 3、MySQL慢日志

MySQL的慢查询日志是MySQL提供的一种日志记录，它用来记录在MySQL中响应时间超过阀值的语句，具体指运行时间超过long_query_time值的SQL，则会被记录到慢查询日志中。


### 4、什么是codis

Codis 是一个分布式 Redis 解决方案, 对于上层的应用来说, 连接到 Codis Proxy 和连接原生的 Redis Server 没有明显的区别 (有一些命令不支持), 上层应用可以像使用单机的 Redis 一样使用, Codis 底层会处理请求的转发, 不停机的数据迁移等工作, 所有后边的一切事情, 对于前面的客户端来说是透明的, 可以简单的认为后边连接的是一个内存无限大的 Redis 服务，当然，前段时间Redis官方的3.0出了稳定版，3.0支持集群功能，codis的实现原理和3.0的集群功能差不多。


### 5、关于Python程序的运行方面，有什么手段能提升性能？

**1、** 使用多进程，充分利用机器的多核性能

**2、** 对于性能影响较大的部分代码，可以使用C或C++编写

**3、** 对于IO阻塞造成的性能影响，可以使用IO多路复用来解决

**4、** 尽量使用Python的内建函数5、尽量使用局部变量


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


### 7、什么是索引合并

**1、** 索引合并是把几个索引的范围扫描合并成一个索引。

**2、** 索引合并的时候，会对索引进行并集，交集或者先交集再并集操作，以便合并成一个索引。

**3、** 这些需要合并的索引只能是一个表的。不能对多表进行索引合并。


### 8、什么是抽象？

抽象(Abstraction)是将一个对象的本质或必要特征向外界展示，并隐藏所有其他无关信息的过程。


### 9、Python中的生成器是什么？

生成器(generator)的定义与普通函数类似，生成器使用yield关键字生成值。

如果一个函数包含yield关键字，那么该函数将自动成为一个生成器。

```
# A program to demonstrate the use of generator object with next() A generator function 
def Fun(): 
   yield 1
   yield 2
   yield 3

# x is a generator object 
x = Fun()
print(next(x))
-----------------------------
1
print(next(x))
-----------------------------
2
```


### 10、双下划线和单下划线的区别

**1、** "单下划线" 开始的成员变量叫做保护变量，意思是只有类对象和子类对象自己能访问到这些变量；

**2、** "双下划线" 开始的是私有成员，意思是只有类对象自己能访问，连子类对象也不能访问到这个数据。


### 11、xrange和range的区别
### 12、有如下链表类，请实现单链表逆置。
### 13、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。
### 14、简述多进程开发中join和deamon的区别
### 15、super的作用
### 16、threading.local的作用
### 17、什么是rpc
### 18、索引再什么情况下遵循最左前缀的规则？
### 19、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今
### 20、用一行代码实现数值交换
### 21、数据库锁的作用
### 22、写出邮箱的正则表达式
### 23、下面代码的执行结果是
### 24、常用字符串格式化有哪几种？
### 25、TCP和UDP的区别
### 26、描述以下dict的items和iteritems的区别
### 27、python递归的最大层数？
### 28、列举Redis支持的过期策略
### 29、解释一下Python中的继承
### 30、什么是twisted框架




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
