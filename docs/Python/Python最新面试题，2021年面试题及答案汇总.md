# Python最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、手写一个栈

```python
#给一个点，我们能够根据这个点知道一些内容
class Node(object):
def __init__(self,val): #定位的点的值和一个指向
self.val=val #指向元素的值,原队列第二元素
self.next=None #指向的指针

class stack(object):
def __init__(self):
self.top=None #初始化最开始的位置

def push(self,n):#添加到栈中
n=Node(n) #实例化节点
n.next=self.top #顶端元素传值给一个指针
self.top=n
return n.val

def pop(self): #退出栈
if self.top == None:
return None
else:
tmp=self.top.val
self.top=self.top.next #下移一位，进行
return tmp

if __name__=="__main__":
s=stack()
print(s.pop())
s.push(1)
print(s.pop())
s.push(2)
s.push(3)
print(s.pop())
s.push(3)
s.push(3)
s.push(3)
print(s.pop())
print(s.pop())
print(s.pop())
print(s.pop())
```


### 2、Python中的装饰器是什么？

装饰器(Decorator)是Python中一个有趣的功能。

它用于向现有代码添加功能。这也称为元编程，因为程序的一部分在编译时会尝试修改程序的另一部分。

```
def addition(func):
    def inner(a,b):
        print("numbers are",a,"and",b)
        return func(a,b)
    return inner

@addition
def add(a,b):
   print(a+b)

add(5,6)
---------------------------------
numbers are 5 and 6
sum: 11
```


### 3、数据库锁的作用

**锁分为三种：乐观锁，悲观锁和共享锁**

数据库和操作系统一样，是一个多用户使用的共享资源。当多个用户并发地存取数据 时，在数据库中就会产生多个事务同时存取同一数据的情况。若对并发操作不加控制就可能会读取和存储不正确的数据，破坏数据库的一致性。加锁是实现数据库并 发控制的一个非常重要的技术。在实际应用中经常会遇到的与锁相关的异常情况，当两个事务需要一组有冲突的锁，而不能将事务继续下去的话，就会出现死锁，严 重影响应用的正常执行。


### 4、什么是封装？

封装(Encapsulation)意味着将数据和成员函数包装在一起成为一个单元。

它还实现了数据隐藏的概念。


### 5、在Python中如何实现多线程？

一个线程就是一个轻量级进程，多线程能让我们一次执行多个线程。我们都知道，Python是多线程语言，其内置有多线程工具包。

Python中的GIL（全局解释器锁）确保一次执行单个线程。一个线程保存GIL并在将其传递给下个线程之前执行一些操作，这会让我们产生并行运行的错觉。但实际上，只是线程在CPU上轮流运行。当然，所有的传递会增加程序执行的内存压力。


### 6、位和字节的关系

8位=一字节


### 7、MySQL常见的函数

**1、** ABS(x)：返回x的绝对值

**2、** ROUND(x)：返回参数x的四舍五入的一个整数

**3、** TRIM(str)：去除字符串两边的空白

**4、** COUNT()：返回值的个数

**5、** AVG()：返回平均值

**6、** SUM()：求和


### 8、filter、map、reduce的作用。

**1、** filter() 相当于过滤器的作用

```python
s=[1,2,3,5,6,8,9,10,25,12,30]
# 筛选出3的倍数
# 第一个参数为一个返回True或者False的函数，第二个参数为可迭代对象
# 该函数把可迭代对象依次传入第一个函数，如果为True，则筛选
d=filter(lambda x:True if x % 3 == 0 else False,s)
print(list(d))
```

**2、** map()函数，

```python
# 第一个参数为函数，依次将后面的参数传给第一个函数，并执行函数
# 如果有多个参数则，依次将后面的对应传给参数
s=map(lambda x,y:x+y,range(10),range(10))
print(list(s))
ss=map(lambda x:x*x,range(10))
print(list(ss))
```

**3、** reduce()函数

```python
from functools import reduce
# 开始的时候将可迭代对象的第一个数和第二个数当成x和y
# 然后将第一次函数的执行结果当成x，然后再传入一个数当成y
# 再执行函数
s=reduce(lambda x,y:x+y,range(101))
print(s) # 相当于0+1+2+……+99+100
```


### 9、解释Python中的join()和split()函数

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


### 10、什么是LVS

LVS是linux虚拟服务器，是一个虚拟的linux集群系统。


### 11、Python中append，insert和extend的区别?
### 12、用一行Python代码，从给定列表中取出所有的偶数和奇数
### 13、什么是c3算法？
### 14、解释//、％、* *运算符？
### 15、公司线上和开发环境使用的什么系统
### 16、什么是twisted框架
### 17、怎样获取字典中所有键的列表？
### 18、列举字符串、列表、元组、字典每个常用的5个方法
### 19、数据库的导入与导出命令
### 20、写出邮箱的正则表达式
### 21、Redis中默认有多少个哈希槽
### 22、简述触发器、函数、视图和存储过程
### 23、编写一个函数实现十进制转62进制，分别用0-9A-Za-z,表示62位字母
### 24、实例方法、静态方法和类方法的区别
### 25、如何实现['1','2','3']变成[1,2,3]
### 26、请列举布尔值位False的常见值
### 27、什么是Flask？
### 28、使用with语句的好处是什么
### 29、traceroute使用哪种网络协议
### 30、简述Redis的有几种持久化策略以及比较？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
