# Python最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是c3算法？

c3算法是python新式类中用来产生mro顺序的一套算法。即多继承的查找规则。


### 2、!=和is not运算符的区别？

!=如果两个变量或对象的值不相等，则返回true。

is not是用来检查两个对象是否属于同一内存对象。

```
lst1 = [1,2,3,4]
lst2 = [1,2,3,4]

lst1 != lst2
>False

lst1 is not lst2
>True
```


### 3、query作为sql模板，args为将要传入的参数

execute(query, args=None)


### 4、isinstance和type的作用

**1、** 两者都用来判断对象的类型

**2、** 对于一个类的之类对象的类型判断，type就不行了，而isinstance可以。

```pyyhon
class A(object):
pass
class B(A):
pass

ba=B()
ab=A()
print(type(ba)==A) # False
print(type(ab)==A) # True
print(isinstance(ab,A)) # True
print(isinstance(ba,A)) # True
```


### 5、简述Redis的有几种持久化策略以及比较？

**1、** RDB 持久化可以在指定的时间间隔内生成数据集的时间点快照。

**2、** AOF 持久化记录服务器执行的所有写操作命令，并在服务器启动时，通过重新执行这些命令来还原数据集。 AOF 文件中的命令全部以 Redis 协议的格式来保存，新命令会被追加到文件的末尾。 Redis 还可以在后台对 AOF 文件进行重写(rewrite)，使得 AOF 文件的体积不会超出保存数据集状态所需的实际大小。

**区别：**

**1、** RDB持久化是指在指定的时间间隔内将内存中的数据集快照写入磁盘，实际操作过程是fork一个子进程，先将数据集写入临时文件，写入成功后，再替换之前的文件，用二进制压缩存储。

**2、** AOF持久化以日志的形式记录服务器所处理的每一个写、删除操作，查询操作不会记录，以文本的方式记录，可以打开文件看到详细的操作记录。


### 6、列举Redis支持的过期策略

**定时删除**

在设置key的过期时间的同时，为该key创建一个定时器，让定时器在key的过期时间来临时，对key进行删除

**惰性删除**

key过期的时候不删除，每次从数据库获取key的时候去检查是否过期，若过期，则删除，返回null。

**定期删除**

每隔一段时间执行一次删除(在Redis.conf配置文件设置hz，1s刷新的频率)过期key操作


### 7、pass的使用

通常用来标记一个还未写的代码的位置，pass不做任何事情，一般用来做占位语句，保持程序结构的完整性


### 8、什么是Twemproxy
### 9、什么是负索引？
### 10、用一行代码实现数值交换
### 11、如何更改列表的数据类型？
### 12、编写一个函数实现十进制转62进制，分别用0-9A-Za-z,表示62位字母
### 13、在Python中如何实现多线程？
### 14、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False
### 15、Redis如何实现主从复制？以及数据同步机制？
### 16、什么是并发和并行
### 17、比较：a=[1,2,3]和b=[(1),(2),(3)]以及c=[(1,),(2,),(3,)]的区别
### 18、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}
### 19、IO多路复用的作用？
### 20、如果已经建立了TCP连接，但是客户端突然出现故障了怎么办
### 21、描述以下字典的items()方法和iteritems()方法有啥不同？
### 22、如何在函数中设置一个全局变量？
### 23、请列举你所知道的python代码检测工具以及他们之间的区别
### 24、Python中使用的zip函数是什么？
### 25、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？
### 26、python中enumerate的意思是什么？
### 27、在Python中有多少种运算符？解释一下算数运算符。
### 28、logging模块的作用以及应用场景
### 29、介绍一下try except的用法和作用？
### 30、Python的局限性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
