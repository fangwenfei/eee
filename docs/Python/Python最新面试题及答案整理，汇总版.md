# Python最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是codis

Codis 是一个分布式 Redis 解决方案, 对于上层的应用来说, 连接到 Codis Proxy 和连接原生的 Redis Server 没有明显的区别 (有一些命令不支持), 上层应用可以像使用单机的 Redis 一样使用, Codis 底层会处理请求的转发, 不停机的数据迁移等工作, 所有后边的一切事情, 对于前面的客户端来说是透明的, 可以简单的认为后边连接的是一个内存无限大的 Redis 服务，当然，前段时间Redis官方的3.0出了稳定版，3.0支持集群功能，codis的实现原理和3.0的集群功能差不多。


### 2、写出邮箱的正则表达式

```python
import re
pp=re.compile('[a-zA-Z0-9_-]+@[0-9A-Za-z]+(\.[0-9a-zA-Z]+)+')
if pp.match('1403179190@qq.com'):
print('ok')
```


### 3、使用python将数据库的student表中的数据写入db.txt

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


### 4、判断dict中有没有某个key。

key in dict.keys()  判断


### 5、类和对象有什么区别？

类(Class)被视为对象的蓝图。类中的第一行字符串称为doc字符串，包含该类的简短描述。

在Python中，使用class关键字可以创建了一个类。一个类包含变量和成员组合，称为类成员。

对象(Object)是真实存在的实体。在Python中为类创建一个对象，我们可以使用obj = CLASS_NAME()

例如：obj = num()

使用类的对象，我们可以访问类的所有成员，并对其进行操作。

```
class Person:
    """ This is a Person Class"""
    # varable
    age = 10
    def greets(self):
        print('Hello')


# object
obj = Person()
print(obj.greet)
----------------------------------------
Hello
```


### 6、Redis如何实现主从复制？以及数据同步机制？

Redis从主从结构可以采用一主多从或者级联结构，主从复制可以根据是否全量分为全量同步和增量同步。

**全量同步：**

Redis全量复制一般发生在slave初始化阶段，这时slave需要将master上的所有数据都复制一份步骤如下：

**1、** 从服务器连接主服务器，发送SYNC命令；

**2、** 主服务器接收到SYNC命名后，开始执行BGSAVE命令生成RDB文件并使用缓冲区记录此后执行的所有写命令；

**3、** 主服务器BGSAVE执行完后，向所有从服务器发送快照文件，并在发送期间继续记录被执行的写命令；

**4、** 从服务器收到快照文件后丢弃所有旧数据，载入收到的快照；

**5、** 主服务器快照发送完毕后开始向从服务器发送缓冲区中的写命令；

**6、** 从服务器完成对快照的载入，开始接收命令请求，并执行来自主服务器缓冲区的写命令；

**增量同步：**

**1、** Redis增量复制是指Slave初始化后开始正常工作时主服务器发生的写操作同步到从服务器的过程。 增量复制的过程主要是主服务器每执行一个写命令就会向从服务器发送相同的写命令，从服务器接收并执行收到的写命令。

**2、** Redis主从同步策略

**3、** 主从刚刚连接的时候，进行全量同步；全同步结束后，进行增量同步。当然，如果有需要，slave 在任何时候都可以发起全量同步。Redis 策略是，无论如何，首先会尝试进行增量同步，如不成功，要求从机进行全量同步


### 7、python中enumerate的意思是什么？

枚举的意思，同时得到可迭代对象，如列表和元组的索引和值，以元组形式返回


### 8、简述数据库分库分表

垂直切分

**垂直分库：**

就是根据业务耦合性，将关联度低的不同表存储在不同的数据库

**垂直分表：**

基于数据库中的"列"进行，某个表字段较多，可以新建一张扩展表，将不经常用或字段长度较大的字段拆分出去到扩展表中。

**横向切分：**

水平切分分为库内分表和分库分表，是根据表内数据内在的逻辑关系，将同一个表按不同的条件分散到多个数据库或多个表中，每个表中只包含一部分数据，从而使得单个表的数据量变小，达到分布式的效果。


### 9、通过什么途径学习python

**1、** 通过看官方文档

**2、** 通过哔哩哔哩上的视频教程

**3、** 通过百度查资料

**4、** 通过买python相关方面的书


### 10、什么是负索引？

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


### 11、MySQL如何创建索引
### 12、常用字符串格式化有哪几种？
### 13、请解释使用*args和**kwargs的含义
### 14、解释*args和**kwargs？
### 15、简述多进程开发中join和deamon的区别
### 16、什么时GIL锁
### 17、Python中的标识符长度能有多长？
### 18、什么是封装？
### 19、输入某年某月某日，判断这是这一年的第几天？
### 20、有两个字符串列表a和b，每个字符串是由逗号隔开的一些字符
### 21、什么是一致性哈希
### 22、如何实现响应式布局
### 23、位和字节的关系
### 24、_init_在Python中有什么用？
### 25、是否使用过functools中的函数？他的作用是什么？
### 26、举例说明Python中的range函数?
### 27、在Python中如何实现多线程？
### 28、公司线上和开发环境使用的什么系统
### 29、解释一下Python中的逻辑运算符
### 30、请列举布尔值位False的常见值




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
