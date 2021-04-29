# Python最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是多态？

多态(Polymorphism)的意思是「许多形式」。

子类可以定义自己的独特行为，并且仍然共享其父类/基类的相同功能或行为。


### 2、简述事务及其特性

事务是用户定义的一个数据库操作序列，这些操作要么全做要么全不做，是一个不可分割的工作单位

事务具有4个特性：原子性、一致性、隔离性和持续性。

**1、** 原子性：事务是数据库的逻辑工作单位，事务中包括的诸操作要么都做，要么都不做。

**2、** 一致性：事务执行的结果必须是使数据库从一个一致性状态变到另一个一致性状态。

**3、** 隔离性：一个事务的执行不能被其他事务干扰。即一个事务内部的操作及使用的数据对其他并发事务是隔离的，并发执行的各个事务之间不能互相干扰。

**4、** 持续性：持续性也称永久性，指一个事务一旦提交，它对数据库中数据的改变就应该是永久性的。接下来的其他操作或故障不应该对其执行结果有任何影响。


### 3、Python中注释代码的方法有哪些？

在Python中，我们可以通过下面两种方式进行注释。

**1、**  三引号'''，用于多行注释。

**2、**  单井号#，用于单行注释。


### 4、Redis中sentinel的作用

Redis Sentinel是一个用来监控Redis集群中节点的状态，不用来存储数据。当集群中的某个节点有故障时，可以自动的进行故障转移的操作。通常为了保证sentinel的高可用，sentinel也会部署多个


### 5、如何实现Redis集群

**1、** Twitter开发的twemproxy

**2、** 豌豆荚开发的codis

**3、** Redis官方的Redis-cluster


### 6、怎样获取字典中所有键的列表？

使用 keys() 获取字典中的所有键

```
>>> mydict={'a':1,'b':2,'c':3,'e':5}
>>> mydict.keys()
dict_keys(['a', 'b', 'c', 'e'])
```


### 7、阅读以下代码，写输出结果

```python
lis = [2,4,5,6,7]
for i in lis:
if i % 2==0:
lis.remove(i)
print(lis)
```

结果：[4, 5, 7]


### 8、如果Redis中的某个列表中的数据量非常大，如何实现循环显示每一个值？

使用生成器一个一个取


### 9、进程之间如何进行通信？

**1、** 共享内存

通过mmap模块实现

2、信号

**3、** 通过Queue队列

**4、** 通过Pipe管道

**5、** 通过socket


### 10、你对Python类中的self有什么了解？

self表示类的实例。

通过使用self关键字，我们可以在Python中访问类的属性和方法。

注意，在类的函数当中，必须使用self，因为类中没有用于声明变量的显式语法。


### 11、什么是Twemproxy
### 12、什么是haproxy？
### 13、简述TCP三次握手，四次挥手的流程。
### 14、简述left join和right join的区别
### 15、python如何定义函数时如何书写可变参数和关键字参数？
### 16、为何不建议以下划线作为标识符的开头
### 17、解释//、％、* *运算符？
### 18、一行代码通过filter和lambda函数输出alist=[1,22,2,33,23,32]中索引为奇数的值
### 19、曾经使用过哪些前端框架
### 20、三元运算编写格式
### 21、什么是正向代理和反向代理？
### 22、描述以下字典的items()方法和iteritems()方法有啥不同？
### 23、or 和 and
### 24、什么是LVS
### 25、关于Python程序的运行方面，有什么手段能提升性能？
### 26、介绍一下try except的用法和作用？
### 27、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来
### 28、什么是twisted框架
### 29、如何打乱一个排好序的列表
### 30、python代码如何获取命令行参数




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
