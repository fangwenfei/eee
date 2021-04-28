# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是域名解析

域名解析是把域名指向网站空间IP，让人们通过注册的域名可以方便地访问到网站一种服务。IP地址是网络上标识站点的数字地址，为方便记忆，采用域名来代替IP地址标识站点地址。域名解析就是域名到IP地址的转换过程。


### 2、怎样将字符串转换为小写？

我们使用lower()方法。

```
>>> 'AyuShi'.lower()
```

结果：

```
‘ayushi’
```

使用upper()方法可以将其转换为大写。

```
>>> 'AyuShi'.upper()
```

结果：

```
‘AYUSHI’
```

另外，使用isupper()和islower()方法检查字符春是否全为大写或小写。

```
>>> 'AyuShi'.isupper()
False
 
>>> 'AYUSHI'.isupper()
True
 
>>> 'ayushi'.islower()
True
 
>>> '@yu$hi'.islower()
True
 
>>> '@YU$HI'.isupper()
True
```

那么，像@和$这样的字符既满足大写也满足小写。

Istitle()能告诉我们一个字符串是否为标题格式。

```
>>> 'The Corpse Bride'.istitle()
True
```


### 3、简述jsonp及其原理

JSONP是JSON with Padding的略称。它是一个非官方的协议，它允许在服务器端集成Script tags返回至客户端，通过javascript callback的形式实现跨域访问（这仅仅是JSONP简单的实现形式）

原理：








### 4、讲讲Python中的位运算符

该运算符按二进制位对值进行操作。

**1、**   与（&），按位与运算符：参与运算的两个值,如果两个相应位都为1,则该位的结果为1,否则为0

```
>>> 0b110 & 0b010
2
```

**2、** 或（|），按位或运算符：只要对应的二个二进位有一个为1时，结果位就为1。

```
>>> 3|2
3
```

**3、** 异或（^），按位异或运算符：当两对应的二进位相异时，结果为1

```
>>> 3^2
1
```

**4、** 取反（~），按位取反运算符：对数据的每个二进制位取反,即把1变为0,把0变为1

```
>>> ~2
-3
```

**5、** 左位移（<<），运算数的各二进位全部左移若干位，由 << 右边的数字指定了移动的位数，高位丢弃，低位补0

```
>>> 1<<2
4
```

**6、** 右位移（>>），把">>"左边的运算数的各二进位全部右移若干位，>> 右边的数字指定了移动的位数

```
>>> 4>>2
1
```

更多关于运算符的知识，参考这里：

[戳这里](https://data-flair.training/blogs/python-operators/)


### 5、在Python中如何使用多进制数字？

我们在Python中，除十进制外还可以使用二进制、八进制和十六进制。

**1、**   二进制数字由0和1组成，我们使用 0b 或 0B 前缀表示二进制数。

```
>>> int(0b1010)
10
```

**2、** 使用bin()函数将一个数字转换为它的二进制形式。

```
>>> bin(0xf)
‘0b1111’
```

**3、** 八进制数由数字 0-7 组成，用前缀 0o 或 0O 表示 8 进制数。

```
>>> oct(8)
‘0o10’
```

**4、** 十六进数由数字 0-15 组成，用前缀 0x 或者 0X 表示 16 进制数。

```
>>> hex(16)
‘0x10’
 
>>> hex(15)
‘0xf’
```


### 6、解释Python中map()函数？

map()函数将给定函数应用于可迭代对象(列表、元组等)，然后返回结果(map对象)。

我们还可以在map()函数中，同时传递多个可迭代对象。

```
numbers = (1, 2, 3, 4)
result = map(lambda x: x + x, numbers)

print(list(result))
```


### 7、MySQL如何创建索引

**1、** ALTER TABLE

**2、** ALTER TABLE用来创建普通索引、UNIQUE索引或PRIMARY KEY索引。

**3、** ALTER TABLE table_name ADD INDEX index_name (column_list)

**4、** ALTER TABLE table_name ADD UNIQUE (column_list)

**5、** ALTER TABLE table_name ADD PRIMARY KEY (column_list)

**6、** CREATE INDEX

**7、** CREATE INDEX可对表增加普通索引或UNIQUE索引。

**8、** CREATE INDEX index_name ON table_name (column_list)

**9、** CREATE UNIQUE INDEX index_name ON table_name (column_list)


### 8、什么是rpc

远程过程调用 (RPC) 是一种协议，程序可使用这种协议向网络中的另一台计算机上的程序请求服务

1.RPC采用客户机/服务器模式。请求程序就是一个客户机，而服务提供程序就是一个服务器。

2.首先，客户机调用进程发送一个有进程参数的调用信息到服务进程，然后等待应答信息。

2.在服务器端，进程保持睡眠状态直到调用信息到达为止。当一个调用信息到达，服务器获得进程参数，计算结果，发送答复信息，然后等待下一个调用信息，

3.最后，客户端调用进程接收答复信息，获得进程结果，然后调用执行继续进行。


### 9、TCP和UDP的区别

**1、** TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接

**2、** TCP提供可靠的服务。也就是说，通过TCP连接传送的数据，无差错，不丢失，不重复，且按序到达;UDP尽最大努力交付，即不保证可靠交付

**3、** UDP具有较好的实时性，工作效率比TCP高，适用于对高速传输和实时性有较高的通信或广播通信。

**4、** 每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信

**5、** TCP对系统资源要求较多，UDP对系统资源要求较少。


### 10、描述以下字典的items()方法和iteritems()方法有啥不同？

**1、** 字典的items方法作用：是可以将字典中的所有项，以列表方式返回。因为字典是无序的，所以用items方法返回字典的所有项，也是没有顺序的。

**2、** 字典的iteritems方法作用：与items方法相比作用大致相同，只是它的返回值不是列表，而是一个迭代器


### 11、下面代码的执行结果是
### 12、如何使用索引来反转Python中的字符串?
### 13、写代码：如何由tuple1=('a','b','c','d','e')，和tuple2=(1,2,3,4,5)得到res={'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}
### 14、求出以下代码的输出结果
### 15、生成器与函数的区别？
### 16、解释一下Python中的//，%和 ** 运算符
### 17、区分Python中的remove，del和pop？
### 18、python的可变类型和不可变类型的区别
### 19、Redis如何实现事务
### 20、实现一个装饰器，限制该函数被调用的频率，如10秒一次
### 21、什么是pickling和unpickling？
### 22、解释一下Python中的逻辑运算符
### 23、什么是正向代理和反向代理？
### 24、什么是asyncio
### 25、什么是Twemproxy
### 26、Python中的装饰器是什么？
### 27、1，2，3，4，5能组成多少个互不相同且不重复的三位数？
### 28、守护线程，守护进程是什么
### 29、isinstance和type的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
