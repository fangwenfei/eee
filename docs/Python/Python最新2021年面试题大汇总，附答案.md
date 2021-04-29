# Python最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是rpc

远程过程调用 (RPC) 是一种协议，程序可使用这种协议向网络中的另一台计算机上的程序请求服务

1.RPC采用客户机/服务器模式。请求程序就是一个客户机，而服务提供程序就是一个服务器。

2.首先，客户机调用进程发送一个有进程参数的调用信息到服务进程，然后等待应答信息。

2.在服务器端，进程保持睡眠状态直到调用信息到达为止。当一个调用信息到达，服务器获得进程参数，计算结果，发送答复信息，然后等待下一个调用信息，

3.最后，客户端调用进程接收答复信息，获得进程结果，然后调用执行继续进行。


### 2、公司线上和开发环境使用的什么系统

线上用的centos和Ubuntu系统

开发环境用的windows，mac，还有Ubuntu。


### 3、有如下链表类，请实现单链表逆置。

```python
class ListNode:
def __init__(self,val):
self.val=val
self.next=None

class Solution:
def reverseList(self,pHead):
if not pHead or not pHead.next:
return pHead
last=None
while pHead:
tmp=pHead.next
pHead.next=last
last=pHead
pHead=tmp
return last
```


### 4、写出以下代码的输出结果：

```python
def test():
try:
raise ValueError('something wrong')
except ValueError as e:
print('error occured')
return
finally:
print('ok')
test()
```

结果(finally无论怎样都会执行)

> error occured

ok



### 5、什么是gevent

gevent是一个pythn网络框架，它为各种并发和网络相关的任务提供了整洁的API


### 6、为什么基于tcp协议的通信比基于udp协议的通信更可靠

TCP是面向连接的传输协议，每次都需要建立一个可以相互信任的连接，中间有个三次握手过程。而UDP是面向无连接的传输协议，不需要建立安全的连接，


### 7、什么是负索引？

我们先创建这样一个列表：

```
>>> mylist=[0,1,2,3,4,5,6,7,8]
```

负索引和正索引不同，它是从右边开始检索。

```
>>> mylist[-3]
```

运行结果：

```
6
```

它也能用于列表中的切片：

```
>>> mylist[-6:-1]
```

结果：

```
[3, 4, 5, 6, 7]
```


### 8、什么是封装？

封装(Encapsulation)意味着将数据和成员函数包装在一起成为一个单元。

它还实现了数据隐藏的概念。


### 9、深拷贝和浅拷贝之间的区别是什么？

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


### 10、下面代码的执行结果是

```python
a=1
def bar():
a+=3

bar()
print(a)
```

答案：运行出错


### 11、一个大小为100G的文件etl_log.txt，要读取文件的内容，写出具体过程代码
### 12、编写程序，打印斐波那契数列的前十项
### 13、描述以下dict的items和iteritems的区别
### 14、MySQL常见的函数
### 15、在Python中如何使用多进制数字？
### 16、怎样获取字典中所有键的列表？
### 17、简述python的深浅拷贝
### 18、解释Python中reduce函数的用法？
### 19、如何实现响应式布局
### 20、什么是haproxy？
### 21、css如何隐藏一个元素
### 22、解释一下Python中的//，%和 ** 运算符
### 23、Python中OOPS是什么？
### 24、什么是ajax请求？手写一个ajax请求
### 25、1，2，3，4，5能组成多少个互不相同且不重复的三位数？
### 26、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}
### 27、数据库锁的作用
### 28、简述面向对象的三大特性？
### 29、解释Python中的join()和split()函数
### 30、简述多进程开发中join和deamon的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
