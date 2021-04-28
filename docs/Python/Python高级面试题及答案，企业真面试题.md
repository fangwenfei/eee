# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、ascii、Unicode、utf-8、gbk的区别

**1、** ascii 是最早美国用的标准信息交换码，把所有的字母的大小写，各种符号用 二进制来表示，共有256中，加入些拉丁文等字符，1bytes代表一个字符

**2、** Unicode是为了统一世界各国语言的不用，统一用2个bytes代表一个字符，可以表达2^16=65556个，称为万国语言，特点：速度快，但浪费空间

**3、** utf-8 为了改变Unicode的这种缺点，规定1个英文字符用1个字节表示，1个中文字符用3个字节表示，特点；节省空间，速度慢，用在硬盘数据传输，网络数据传输，相比硬盘和网络速度，体现不出来的

**4、** gbk  是中文的字符编码，用2个字节代表一个字符


### 2、什么是一致性哈希

[参考链接](https://www.jianshu.com/p/49e3fbf41b9b)

一致性哈希简称DHT,是麻省理工学院提出的一种算法，目前主要应用于分布式缓存当中。一致性哈希可以有效地解决分布式存储结构下动态增加和删除节点所带来的问题。


### 3、判断dict中有没有某个key。

key in dict.keys()  判断


### 4、什么是Python？为什么它会如此流行？

Python是一种解释的、高级的、通用的编程语言。

Python的设计理念是通过使用必要的空格与空行，增强代码的可读性。

它之所以受欢迎，就是因为它具有简单易用的语法。


### 5、GIL锁对python性能的影响

**1、** 会降低多线程的效率。可以说python就是个单线程的程序。

**2、** 如何避免：

**3、** 用多进程代替多线程

**4、** 使用其他解释器


### 6、解释什么是异步非阻塞

**1、** 同步和异步：

**2、** 同步：就是在发出一个功能调用时，在没有得到结果之前，该调用就不返回。

**3、** 异步：当一个异步过程调用发出后，调用者不会立刻得到结果。实际处理这个调用的部件是在调用发出后，通过状态、通知来通知调用者，或通过回调函数处理这个调用。

**4、** 阻塞和非阻塞

**5、** 阻塞：阻塞调用是指调用结果返回之前，当前线程会被挂起。函数只有在得到结果之后才会返回。

**6、** 非阻塞：指在不能立刻得到结果之前，该函数不会阻塞当前线程，而会立刻返回。

**7、** 阻塞，非阻塞：进程/线程要访问的数据是否就绪，进程/线程是否需要等待；

**8、** 同步，异步：访问数据的方式，同步需要主动读写数据，在读写数据的过程中还是会阻塞；异步只需要I/O操作完成的通知，并不主动读写数据，由操作系统内核完成数据的读写。


### 7、路由器和交换机的区别

交换机是一种用于电信号转发的网络设备。路由器是链接因特网中各局域网和广域网的设备。

区别

**1、** 交换机工作在第二层，数据链路层，路由器工作在第三层，网络层。

**2、** 路由器提供防火墙服务。

**3、** 传统交换机只能风格冲突域，不能分割广播域，二路由器可以分割广播域。


### 8、怎么移除一个字符串中的前导空格？

字符串中的前导空格就是出现在字符串中第一个非空格字符前的空格。我们使用方法Istrip()可以将它从字符串中移除。

```
>>> '   Ayushi '.lstrip()
```

结果：

```
‘Ayushi   ’
```

可以看到，该字符串既有前导字符，也有后缀字符，调用Istrip()去除了前导空格。如果我们想去除后缀空格，就用rstrip()方法。

```
>>> '   Ayushi '.rstrip()
```

结果：

```
‘   Ayushi’
```

从Q 21到Q 35是为有Python经验者准备的进阶版Python面试题。


### 9、使用python将数据库的student表中的数据写入db.txt

```python
import pyMySQL
connect=pyMySQL.Connect(
host='',
port=,
user='',
passwd='',
db='',
charset='',
)

cursor=connect.cursor()
sql='select from student'
cursor.execute(sql)
students=cursor.fetchall()

with open('db.txt','w') as f:
for student in students:
f.write(student)

cursor.close()
connect.close()
```


### 10、编写程序，检查序列是否为回文

```
a = input("Enter The sequence")
ispalindrome = a == a[::-1]

ispalindrome
>True
```


### 11、Python中的装饰器是什么？
### 12、Python有什么特点？
### 13、is和==的区别
### 14、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False
### 15、列表和元组之间的区别是？
### 16、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？
### 17、发生粘包现象如何处理？
### 18、你了解哪些数据库优化方案
### 19、什么是switch语句。如何在Python中创建switch语句？
### 20、python3和python2中int和long的区别
### 21、编写程序，计算文件中单词的出现频率
### 22、什么是socket？简述基于tcp协议的socket通信流程？
### 23、什么是LVS
### 24、在什么情况下y!=x-(x-y)会成立？
### 25、简述TCP三次握手，四次挥手的流程。
### 26、Python中的单引号和双引号有什么区别？
### 27、IO多路复用的作用？
### 28、公司线上和开发环境使用的什么系统
### 29、在Python中如何使用多进制数字？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
