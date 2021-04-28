# Python最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来

```python
A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]]
def my_print(lis):
for i in lis:
if type(i)==list:
my_print(i)
else:
print(i)
my_print(A)
```


### 2、sys.path.append('xxx')的作用

添加搜索路径


### 3、解释Python中reduce函数的用法？

reduce()函数接受一个函数和一个序列，并在计算后返回数值。

```
from functools import reduce

a = lambda x,y:x+y
print(reduce(a,[1,2,3,4]))

> 10
```


### 4、什么是猴子补丁？

在运行期间动态修改一个类或模块。

```
>>> class A:
    def func(self):
        print("Hi")
>>> def monkey(self):
print "Hi, monkey"
>>> m.A.func = monkey
>>> a = m.A()
>>> a.func()
```

运行结果为：

```
Hi, Monkey
```


### 5、xrange和range的区别

xrange和range用法相同，但是xrange是一个生成器，range结果是一个列表。xrange做循环的时候性能比range好。


### 6、有如下代码：

```python
import copy
a=[1,2,3,[4,5],6]
b=a
c=copy.copy(a)
d=copy.deepcopy(a)
b.append(10)
c[3].append(11)
d[3].append(12)
```

求a，b，c，d

**答案：**

> a：[1, 2, 3, [4, 5, 11], 6, 10]

b：[1, 2, 3, [4, 5, 11], 6, 10]

c：[1, 2, 3, [4, 5, 11], 6]

d：[1, 2, 3, [4, 5, 12], 6]



### 7、手写一个队列

```python
class Queue(object):
def __init__(self,size):
self.queue=[]
self.size=size
def is_empty(self):
return not bool(len(self.queue))
def is_full(self):
return len(self.queue)==self.size
def enqueue(self,val):
if not self.is_full():
self.queue.insert(0,val)
return True
return False
def dequeue(self):
if not self.is_empty():
return self.queue.pop()
return None
s=Queue(2)
print(s.is_empty)
s.enqueue(1)
s.enqueue(2)
print(s.is_full())
print(s.dequeue())
print(s.dequeue())
print(s.is_empty())
```


### 8、解释一下Python中的三元运算子

不像C++，我们在Python中没有?:，但我们有这个：

```
[on true] if [expression] else [on false]
```

如果表达式为True，就执行[on true]中的语句。否则，就执行[on false]中的语句。

下面是使用它的方法：

```
>>> a,b=2,3
>>> min=a if a<b else b
>>> min
```

运行结果：

```
2
```

```
>>> print("Hi") if a<b else print("Bye")
```

运行结果：

```
Hi
```


### 9、列举创建索引但是无法命中索引的情况

**1、** 如果条件中有or，即使其中有条件带索引也不会使用(这也是为什么尽量少用or的原因）

**2、** 对于多列索引，不是使用的第一部分(第一个)，则不会使用索引

**3、** like查询是以%开头

**4、** 如果列类型是字符串，那一定要在条件中将数据使用引号引用起来,否则不使用索引

**5、** 如果MySQL估计使用全表扫描要比使用索引快,则不使用索引


### 10、简述TCP三次握手，四次挥手的流程。

**三次握手**

**1、** 第一次握手：客户端的应用进程主动打开，并向客户端发出请求报文段。其首部中：SYN=1,seq=x。

**2、** 第二次握手：服务器应用进程被动打开。若同意客户端的请求，则发回确认报文，其首部中：SYN=1,ACK=1,ack=x+1,seq=y。

**3、** 第三次握手：客户端收到确认报文之后，通知上层应用进程连接已建立，并向服务器发出确认报文，其首部：ACK=1,ack=y+1。当服务器收到客户端的确认报文之后，也通知其上层应用进程连接已建立。

**四次挥手**

**1、** 第一次挥手：数据传输结束以后，客户端的应用进程发出连接释放报文段，并停止发送数据，其首部：FIN=1,seq=u。

**2、** 第二次挥手：服务器端收到连接释放报文段之后，发出确认报文，其首部：ack=u+1,seq=v。此时本次连接就进入了半关闭状态，客户端不再向服务器发送数据。而服务器端仍会继续发送。

**3、** 第三次挥手：若服务器已经没有要向客户端发送的数据，其应用进程就通知服务器释放TCP连接。这个阶段服务器所发出的最后一个报文的首部应为：FIN=1,ACK=1,seq=w,ack=u+1。

**4、** 第四次挥手：客户端收到连接释放报文段之后，必须发出确认：ACK=1,seq=u+1,ack=w+1。 再经过2MSL(最长报文端寿命)后，本次TCP连接真正结束，通信双方完成了他们的告别。


### 11、写python爬虫分别用到了哪些模块？分别有什么用？
### 12、python和java、php、c、c#、c++ 等其他语言对比？
### 13、举例说明Python中的range函数?
### 14、怎样声明多个变量并赋值？
### 15、常用字符串格式化有哪几种？
### 16、通过什么途径学习python
### 17、Python的局限性？
### 18、类和对象有什么区别？
### 19、简述面向对象的三大特性？
### 20、IO多路复用的作用？
### 21、Python中使用的zip函数是什么？
### 22、实现一个单例模式。(尽可能多的方法)
### 23、列举Redis支持的过期策略
### 24、如何在Python中管理内存？
### 25、列表中保留顺序和不保留顺序去重
### 26、请列出至少5个PEP8规范
### 27、一个大小为100G的文件etl_log.txt，要读取文件的内容，写出具体过程代码
### 28、什么是一致性哈希
### 29、如何实现Redis集群
### 30、简述SQL注入原理，以及如何在代码层面房子sql注入




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
