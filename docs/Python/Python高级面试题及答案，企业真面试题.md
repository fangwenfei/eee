# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、生产者消费者模型的应用场景

**说明**

生产者只在仓库未满时进行生产，仓库满时生产者进程被阻塞；消费者只在仓库非空时进行消费，仓库为空时消费者进程被阻塞；

应用场景：处理数据比较消耗时间，线程独占，生产数据不需要即时的反馈等。比如说写入日志，将多线程产生的日志放在队列中，然后写入。


### 2、什么是Flask？

Flask是Python编写的一款轻量级Web应用框架。其 WSGI 工具箱采用 Werkzeug ，模板引擎则使用 Jinja2。Flask使用 BSD 授权。其中两个环境依赖是Werkzeug和jinja2，这意味着它不需要依赖外部库。正因如此，我们将其称为轻量级框架。

Flask会话使用签名cookie让用户查看和修改会话内容。它会记录从一个请求到另一个请求的信息。不过，要想修改会话，用户必须有密钥Flask.secret_key。


### 3、什么是抽象？

抽象(Abstraction)是将一个对象的本质或必要特征向外界展示，并隐藏所有其他无关信息的过程。


### 4、怎么移除一个字符串中的前导空格？

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


### 5、解释Python中的Filter？

过滤器函数，根据某些条件从可迭代对象中筛选值。

```
# iterable
lst = [1,2,3,4,5,6,7,8,9,10]

def even(num):
    if num%2==0:
        return num

# filter all even numbers
list(filter(even,lst))
---------------------------------------------
[2, 4, 6, 8, 10]
```


### 6、Python代码是如何执行的？

首先，解释器读取Python代码并检查是否有语法或格式错误。

如果发现错误，则暂停执行。如果没有发现错误，则解释器会将Python代码转换为等效形式或字节代码。

然后将字节码发送到Python虚拟机(PVM)，这里Python代码将被执行，如果发现任何错误，则暂停执行，否则结果将显示在输出窗口中。

![90_1.png][90_1.png]


### 7、sys.path.append('xxx')的作用

添加搜索路径


### 8、Python有哪些特点和优点？

作为一门编程入门语言，Python主要有以下特点和优点：

**1、** 可解释

**2、** 具有动态特性

**3、** 面向对象

**4、** 简明简单

5、开源

**6、** 具有强大的社区支持

当然，实际上Python的优点远不止如此，


### 9、MySQL的建表语句

```mysql
#创建表，例子
#所谓的建表就是声明列的过程,所以要首先分析列
create table member(
                       id int unsigned auto_increment primary key,
                       username varchar(20) not null default '',
                       gender char(1) not null default '',
                       weight tinyint unsigned not null default 0,
                       birth date not null default '0000-00-00',
                       salary decimal(8,2) not null default 0.00,
                       lastlogin int unsigned not null default 0
)engine myisam charset utf8;
```


### 10、如何更改列表的数据类型？

要将列表的数据类型进行更改，可以使用tuple()或者set()。

```
lst = [1,2,3,4,2]

# 更改为集合
set(lst)    ## {1,2,3,4}
# 更改为元组
tuple(lst)  ## (1,2,3,4,2)
```


### 11、22、iterables和iterators之间的区别？
### 12、python和java、php、c、c#、c++ 等其他语言对比？
### 13、Python有什么特点？
### 14、怎样将字符串转换为小写？
### 15、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}
### 16、Python中的装饰器是什么？
### 17、traceroute使用哪种网络协议
### 18、什么是pickling和unpickling？
### 19、python代码如何获取命令行参数
### 20、描述以下字典的items()方法和iteritems()方法有啥不同？
### 21、使用生成器编写一个函数实现生成指定个数的斐波那契数列
### 22、守护线程，守护进程是什么
### 23、Python中的闭包是什么？
### 24、如果已经建立了TCP连接，但是客户端突然出现故障了怎么办
### 25、char和varchar的区别
### 26、简述TCP三次握手，四次挥手的流程。
### 27、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。
### 28、实现99乘法表（使用两种方法）
### 29、css如何隐藏一个元素




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
