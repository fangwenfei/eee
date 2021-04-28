# Python最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、解决哈希冲突的算法有哪几种？分别有什么特点？

[哈希冲突参考](https://blog.csdn.net/seulzz/article/details/77163878)

**1、** 开放定址法

**2、** 再哈希法

**3、** 链地址法

**4、** 建立公共溢出区


### 2、曾经使用过哪些前端框架

react，vue，bootstrap，elementUI，Echarts


### 3、如何修改本地hosts文件

进入c:\windows\system32\drivers\etc进行修改


### 4、简述Redis的有几种持久化策略以及比较？

**1、** RDB 持久化可以在指定的时间间隔内生成数据集的时间点快照。

**2、** AOF 持久化记录服务器执行的所有写操作命令，并在服务器启动时，通过重新执行这些命令来还原数据集。 AOF 文件中的命令全部以 Redis 协议的格式来保存，新命令会被追加到文件的末尾。 Redis 还可以在后台对 AOF 文件进行重写(rewrite)，使得 AOF 文件的体积不会超出保存数据集状态所需的实际大小。

**区别：**

**1、** RDB持久化是指在指定的时间间隔内将内存中的数据集快照写入磁盘，实际操作过程是fork一个子进程，先将数据集写入临时文件，写入成功后，再替换之前的文件，用二进制压缩存储。

**2、** AOF持久化以日志的形式记录服务器所处理的每一个写、删除操作，查询操作不会记录，以文本的方式记录，可以打开文件看到详细的操作记录。


### 5、解释一下Python中的继承？

继承(inheritance)允许一个类获取另一个类的所有成员和属性。继承提供代码可重用性，可以更轻松地创建和维护应用程序。

被继承的类称为超类，而继承的类称为派生类/子类。


### 6、使用生成器编写一个函数实现生成指定个数的斐波那契数列

```python
def fib2(imax):
t,a,b=0,0,1
while t<imax:
yield b
a,b=b,a+b
t+=1

for i in fib2(10):
print(i)
```


### 7、什么是cdn

cdn全称是内容分发网络。其目的是让用户能够更快速的得到请求的数据。

cdn就是用来加速的，他能让用户就近访问数据，这样就更更快的获取到需要的数据。


### 8、is和==的区别

is比较的是两个对象的id是否相同

==比较的是两个对象的值是否相同


### 9、在Python中如何实现多线程？

一个线程就是一个轻量级进程，多线程能让我们一次执行多个线程。我们都知道，Python是多线程语言，其内置有多线程工具包。

Python中的GIL（全局解释器锁）确保一次执行单个线程。一个线程保存GIL并在将其传递给下个线程之前执行一些操作，这会让我们产生并行运行的错觉。但实际上，只是线程在CPU上轮流运行。当然，所有的传递会增加程序执行的内存压力。


### 10、编写程序，查找文本文件中最长的单词

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


### 11、类和对象有什么区别？
### 12、什么是keepalived
### 13、简述TCP三次握手，四次挥手的流程。
### 14、简述数据库的读写分离
### 15、MySQL的增删改查
### 16、mro是什么？
### 17、用一行代码实现数值交换
### 18、关于Python程序的运行方面，有什么手段能提升性能？
### 19、如何实现响应式布局
### 20、什么是负载均衡
### 21、1<(22)和1<22的结果分别是什么？
### 22、什么是局域网和广域网
### 23、什么是haproxy？
### 24、写python爬虫分别用到了哪些模块？分别有什么用？
### 25、Python有哪些特点和优点？
### 26、为何不建议以下划线作为标识符的开头
### 27、求以下代码结果：
### 28、如何高效的找到Redis中所有以felix开头的key
### 29、什么是抽象？
### 30、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
