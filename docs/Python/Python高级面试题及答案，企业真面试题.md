# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、阅读以下代码，写输出结果

```python
lis = [2,4,5,6,7]
for i in lis:
if i % 2==0:
lis.remove(i)
print(lis)
```

结果：[4, 5, 7]


### 2、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False

```python
def solution(s):
ll=len(s)
for i in range(1,ll//2+1):
if ll % i == 0:
j=0
while s[:i]==s[j:j+i] and j<ll:
    j=j+i
if j==ll:
    return True
return False

print(solution('abababa'))
```


### 3、守护线程，守护进程是什么

主进程创建守护进程

**1、** 守护进程会在主进程代码运行结束的情况下，立即挂掉。

**2、** 守护进程本身就是一个子进程。

**3、** 主进程在其代码结束后就已经算运行完毕了（守护进程在此时就被回收）,然后主进程会一直等非守护的子进程都运行完毕后回收子进程的资源(否则会产生僵尸进程)，才会结束，

守护线程

**1、** 守护线程会在"该进程内所有非守护线程全部都运行完毕后,守护线程才会挂掉"。并不是主线程运行完毕后守护线程挂掉。这一点是和守护进程的区别之处！

**2、** 守护线程守护的是：当前进程内所有的子线程！

**3、** 主线程在其他非守护线程运行完毕后才算运行完毕（守护线程在此时就被回收）。因为主线程的结束意味着进程的结束，进程整体的资源都将被回收，而进程必须保证非守护线程都运行完毕后才能结束。


### 4、编写程序，查找文本文件中最长的单词

```
def longest_word(filename):
    with open(filename, 'r') as infile:
              words = infile.read().split()
    max_len = len(max(words, key=len))
    return [word for word in words if len(word) == max_len]

print(longest_word('test.txt'))
----------------------------------------------------
['comprehensions']
```


### 5、如何用一行代码生成[1,4,9,16,25,36,49,64,81,100]?

```python
lis=[i**2 for i in range(1,11)]
```


### 6、什么时GIL锁

**1、** 即全局解释器锁，

**2、** 一个时间点只有一个线程处于执行状态。


### 7、解释Python中的help()和dir()函数

Help()函数是一个内置函数，用于查看函数或模块用途的详细说明：

```
>>> import copy
>>> help(copy.copy)
```

运行结果为：

```
Help on function copy in module copy:

 
 
copy(x)
 
Shallow copy operation on arbitrary Python objects.
 
See the module’s __doc__ string for more info.
```

Dir()函数也是Python内置函数，dir() 函数不带参数时，返回当前范围内的变量、方法和定义的类型列表；带参数时，返回参数的属性、方法列表。

以下实例展示了 dir 的使用方法：

```
>>> dir(copy.copy)
```

运行结果为：

```
[‘__annotations__’, ‘__call__’, ‘__class__’, ‘__closure__’, ‘__code__’, ‘__defaults__’, ‘__delattr__’, ‘__dict__’, ‘__dir__’, ‘__doc__’, ‘__eq__’, ‘__format__’, ‘__ge__’, ‘__get__’, ‘__getattribute__’, ‘__globals__’, ‘__gt__’, ‘__hash__’, ‘__init__’, ‘__init_subclass__’, ‘__kwdefaults__’, ‘__le__’, ‘__lt__’, ‘__module__’, ‘__name__’, ‘__ne__’, ‘__new__’, ‘__qualname__’, ‘__reduce__’, ‘__reduce_ex__’, ‘__repr__’, ‘__setattr__’, ‘__sizeof__’, ‘__str__’, ‘__subclasshook__’]
```


### 8、曾经使用过哪些前端框架

react，vue，bootstrap，elementUI，Echarts


### 9、Python区分大小写吗？

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


### 10、如何以就地操作方式打乱一个列表的元素？

为了达到这个目的，我们从random模块中导入shuffle()函数。

```
>>> from random import shuffle
>>> shuffle(mylist)
>>> mylist
```

运行结果：

```
[3, 4, 8, 0, 5, 7, 6, 2, 1]
```


### 11、解释一下Python中的//，%和 ** 运算符
### 12、编写程序，打印斐波那契数列的前十项
### 13、MySQL执行计划的作用和使用方法
### 14、在什么情况下y!=x-(x-y)会成立？
### 15、json序列化时可以处理的数据类型有哪些？如何定制支持datetime类型？序列化时，遇到中文转成unicode，如何保持中文形式？
### 16、什么是Twemproxy
### 17、怎么移除一个字符串中的前导空格？
### 18、一行代码通过filter和lambda函数输出alist=[1,22,2,33,23,32]中索引为奇数的值
### 19、索引有什么作用，有哪些分类，有什么好处和坏处？
### 20、求下面代码结果
### 21、编写程序，输出给定序列中的所有质数
### 22、实现99乘法表（使用两种方法）
### 23、如何修改本地hosts文件
### 24、什么是粘包？出现粘包的原因？
### 25、什么是socket？简述基于tcp协议的socket通信流程？
### 26、Python中OOPS是什么？
### 27、如何打乱一个排好序的列表
### 28、如何判断一个对象是否可调用？哪些对象是可调用对象？如何定义一个类，使其对象本身就是可调用对象？
### 29、为何不建议以下划线作为标识符的开头




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
