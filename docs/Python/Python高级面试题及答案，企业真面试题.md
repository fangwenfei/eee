# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、有如下链表类，请实现单链表逆置。

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


### 2、写出以下代码的输出结果：

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



### 3、GIL锁对python性能的影响

**1、** 会降低多线程的效率。可以说python就是个单线程的程序。

**2、** 如何避免：

**3、** 用多进程代替多线程

**4、** 使用其他解释器


### 4、解释一下Python中的继承？

继承(inheritance)允许一个类获取另一个类的所有成员和属性。继承提供代码可重用性，可以更轻松地创建和维护应用程序。

被继承的类称为超类，而继承的类称为派生类/子类。


### 5、双下划线和单下划线的区别

**1、** "单下划线" 开始的成员变量叫做保护变量，意思是只有类对象和子类对象自己能访问到这些变量；

**2、** "双下划线" 开始的是私有成员，意思是只有类对象自己能访问，连子类对象也不能访问到这个数据。


### 6、MySQL的半同步复制原理

半同步复制，介于异步复制和全同步复制之间，主库在执行完客户端提交的事务后不是立刻返回给客户端，而是等待至少一个从库接收到并写到relay log中才返回给客户端。相对于异步复制，半同步复制牺牲了一定的性能，提高了数据的安全性。

异步复制，MySQL默认的复制是异步的，主库在执行完客户端提交的事务后会立即将结果返给给客户端，并不关心从库是否已经接收并处理。原理最简单，性能最好，但是主从之间数据不一致的概率很大。

全同步复制，指当主库执行完一个事务，所有的从库都执行了该事务才返回给客户端。因为需要等待所有从库执行完该事务才能返回，所以全同步复制的性能必然会收到严重的影响。


### 7、简述触发器、函数、视图和存储过程

**1、** 触发器：触发器是一个特殊的存储过程，它是MySQL在insert、update、delete的时候自动执行的代码块

**2、** 函数：MySQL中提供了许多内置函数，还可以自定义函数（实现程序员需要sql逻辑处理）

**3、** 视图：视图是由查询结果形成的一张虚拟表，是表通过某种运算得到的一个投影

**4、** 存储过程：把一段代码封装起来，当要执行这一段代码的时候，可以通过调用该存储过程来实现（经过第一次编译后再次调用不需要再次编译，比一个个执行sql语句效率高）


### 8、什么是lambda函数？

Lambda函数是不带名称的单行函数，可以具有n个参数，但只能有一个表达式。也称为匿名函数。

```
a = lambda x, y：x + y 
print(a(5, 6))

> 11
```


### 9、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}

```python
tuple1=('a','b','c','d','e')
tuple2=(1,2,3,4,5)
res=dict(zip(tuple1,tuple2))
print(res)
```


### 10、解释Python中的join()和split()函数

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


### 11、filter、map、reduce的作用。
### 12、从0-99这100个数中随机取出10个，要求不能重复
### 13、请编写一个函数将ip地址转换成一个整数。如10.3.9.12转换成00001010 00000011 00001001 00001100，然后转换成整数
### 14、列举你所了解的所有Python2和Python3的区别
### 15、python3和python2中int和long的区别
### 16、Redis是单进程单线程的吗？
### 17、lambda表达式格式以及应用场景？
### 18、python的可变类型和不可变类型的区别
### 19、Python区分大小写吗？
### 20、MySQL索引种类
### 21、编写程序，输出给定序列中的所有质数
### 22、TCP和UDP的区别
### 23、编写程序，检查数字是否为Armstrong
### 24、Python有什么特点？
### 25、Python中的生成器是什么？
### 26、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False
### 27、一个数如果恰好等于它的因子之和，这个数就称为‘完数’，比如6=1+2+3，编程找出1000以内的所有的完数。
### 28、什么是Python中的猴子补丁？
### 29、解释一下Python中的三元运算子




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
