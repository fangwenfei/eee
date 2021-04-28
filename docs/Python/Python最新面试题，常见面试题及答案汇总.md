# Python最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释什么是异步非阻塞

**1、** 同步和异步：

**2、** 同步：就是在发出一个功能调用时，在没有得到结果之前，该调用就不返回。

**3、** 异步：当一个异步过程调用发出后，调用者不会立刻得到结果。实际处理这个调用的部件是在调用发出后，通过状态、通知来通知调用者，或通过回调函数处理这个调用。

**4、** 阻塞和非阻塞

**5、** 阻塞：阻塞调用是指调用结果返回之前，当前线程会被挂起。函数只有在得到结果之后才会返回。

**6、** 非阻塞：指在不能立刻得到结果之前，该函数不会阻塞当前线程，而会立刻返回。

**7、** 阻塞，非阻塞：进程/线程要访问的数据是否就绪，进程/线程是否需要等待；

**8、** 同步，异步：访问数据的方式，同步需要主动读写数据，在读写数据的过程中还是会阻塞；异步只需要I/O操作完成的通知，并不主动读写数据，由操作系统内核完成数据的读写。


### 2、双下划线和单下划线的区别

**1、** "单下划线" 开始的成员变量叫做保护变量，意思是只有类对象和子类对象自己能访问到这些变量；

**2、** "双下划线" 开始的是私有成员，意思是只有类对象自己能访问，连子类对象也不能访问到这个数据。


### 3、位和字节的关系

8位=一字节


### 4、解释一下Python中的继承

当一个类继承自另一个类，它就被称为一个子类/派生类，继承自父类/基类/超类。它会继承/获取所有类成员（属性和方法）。

继承能让我们重新使用代码，也能更容易的创建和维护应用。Python支持如下种类的继承：

- 单继承：一个类继承自单个基类
- 多继承：一个类继承自多个基类
- 多级继承：一个类继承自单个基类，后者则继承自另一个基类
- 分层继承：多个类继承自单个基类
- 混合继承：两种或多种类型继承的混合 更多关于继承的内容，参见：

[戳这里](https://data-flair.training/blogs/python-inheritance/)


### 5、比较：a=[1,2,3]和b=[(1),(2),(3)]以及c=[(1,),(2,),(3,)]的区别

a和b的结果相同，列表里面的值相同，类型也相同

c中的列表里面的值是元组类型的


### 6、使用python将数据库的student表中的数据写入db.txt

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


### 7、什么是多态？

多态(Polymorphism)的意思是「许多形式」。

子类可以定义自己的独特行为，并且仍然共享其父类/基类的相同功能或行为。


### 8、如何在函数中设置一个全局变量？

在函数中使用global关键字定义变量


### 9、Redis如何实现事务

参考链接

[https://blog.csdn.net/hxpjava1/article/details/79553073](https://blog.csdn.net/hxpjava1/article/details/79553073)


### 10、简述left join和right join的区别

**1、** 左连接和右连接很相似，只是左右表位置的不同罢了。

**2、** left join(左连接) 返回包括左表中的所有记录和右表中连接字段相等的记录

**3、** right join(右连接) 返回包括右表中的所有记录和左表中连接字段相等的记录


### 11、如何修改本地hosts文件
### 12、请列举你所知道的python代码检测工具以及他们之间的区别
### 13、Python中的单引号和双引号有什么区别？
### 14、是否使用过functools中的函数？他的作用是什么？
### 15、现有mydict和变量onekey，请写出从mydict中取出onekey的值的方法
### 16、请列出至少5个PEP8规范
### 17、json序列化时可以处理的数据类型有哪些？如何定制支持datetime类型？序列化时，遇到中文转成unicode，如何保持中文形式？
### 18、编写程序，查找文本文件中最长的单词
### 19、如何以就地操作方式打乱一个列表的元素？
### 20、实例方法、静态方法和类方法的区别
### 21、简述多进程开发中join和deamon的区别
### 22、简述Redis的有几种持久化策略以及比较？
### 23、什么是gevent
### 24、解释一下Python中的身份运算符
### 25、Python有哪些应用？
### 26、手写一个队列
### 27、前后端分离的基本原理
### 28、GIL锁对python性能的影响
### 29、Redis默认多少个db
### 30、解释Python中map()函数？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
