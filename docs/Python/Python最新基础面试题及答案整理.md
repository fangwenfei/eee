# Python最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、在Python中如何使用多进制数字？

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


### 2、xrange和range的区别

xrange和range用法相同，但是xrange是一个生成器，range结果是一个列表。xrange做循环的时候性能比range好。


### 3、TCP和UDP的区别

**1、** TCP面向连接（如打电话要先拨号建立连接）;UDP是无连接的，即发送数据之前不需要建立连接

**2、** TCP提供可靠的服务。也就是说，通过TCP连接传送的数据，无差错，不丢失，不重复，且按序到达;UDP尽最大努力交付，即不保证可靠交付

**3、** UDP具有较好的实时性，工作效率比TCP高，适用于对高速传输和实时性有较高的通信或广播通信。

**4、** 每一条TCP连接只能是点到点的;UDP支持一对一，一对多，多对一和多对多的交互通信

**5、** TCP对系统资源要求较多，UDP对系统资源要求较少。


### 4、yield from 和 yield 的区别

[简述yield和yield from](https://blog.csdn.net/lamusique/article/details/85845225)

```python
# 下面a()和b()是等价的
def a():
yield from [1,2,3,4,5]
def b():
for i in [1,2,3,4,5]:
yield i
for i in a():
print(i)
for i in b():
print(i)
```

yield将一个函数变成一个生成器

yield 返回一个值

yield from后面接可迭代对象，一个一个返回值。


### 5、Python中append，insert和extend的区别?

append：在列表末尾添加新元素。

insert：在列表的特定位置添加元素。

extend：通过添加新列表来扩展列表。

```
numbers = [1,2,3,4,5]
numbers.append(6)
print(numbers)
>[1,2,3,4,5,6]

## insert(position,value)
numbers.insert(2,7)  
print(numbers)
>[1,2,7,4,5,6]

numbers.extend([7,8,9])
print(numbers)
>[1,2,7,4,5,6,7,8,9]

numbers.append([4,5])
>[1,2,7,4,5,6,7,8,9,[4,5]]
```


### 6、编写一个函数，找出数组中没有重复的值的和

```python
def func(lis):
lis1=[]
del_lis=[]
for i in lis:
if i not in lis1:
if i not in del_lis:
    lis1.append(i)
else:
del_lis.append(i)
lis1.remove(i)
return sum(lis1)

def func2(lis):
return sum([i for i in set(lis) if lis.count(i)==1])

print(func2([3,4,1,2,5,6,6,5,4,3,3]))
```


### 7、python的垃圾回收机制

[python垃圾回收机制详解](https://testerhome.com/topics/16556)

**1、** 概述：python采用的是引用计数机制为主，标记-清除和分代收集两种机制为辅的策略

**2、** 引用计数：

**3、** 每当新的引用指向该对象时，引用计数加1，当对该对象的引用失效时，引用计数减1，当对象的引用计数为0时，对象被回收。缺点是，需要额外的空间来维护引用计数，并且无法解决对象的循环引用。

**4、** 分代回收：（具体见上面链接）

**5、** 以时间换空间的回收方式

**6、** 标记清除：

**7、** 活动对象会被打上标记，会把那些没有被打上标记的非活动对象进行回收。


### 8、什么是负载均衡

负载均衡建立在现有网络结构之上，它提供了一种廉价有效透明的方法扩展网络设备和服务器的带宽、增加吞吐量、加强网络数据处理能力、提高网络的灵活性和可用性。

负载均衡其意思就是分摊到多个操作单元上进行执行。


### 9、简述SQL注入原理，以及如何在代码层面房子sql注入

通俗点讲，SQL注入的根本原因是: "用户输入数据"意外变成了代码被执行。

"用户输入数据"我这里可以指Web前端$_POST,$_GET获取的数据，也可以指从数据库获取的数据，当然也不排除程序猿无意中使用的特殊字符串。

在SQL语句的拼接中，一些含特殊字符的变量在拼接时破坏了SQL语句的结构，导致"用户输入数据"意外变成了代码被执行。

**规避方法：**

**1、** 理语句法  (解析协议层面上完全规避SQL注入)

**2、** 字符串转义（不要在sql中拼接字符）


### 10、区分Python中的remove，del和pop？

remove：将删除列表中的第一个匹配值，它以值作为参数。

del：使用索引删除元素，它不返回任何值。

pop：将删除列表中顶部的元素，并返回列表的顶部元素。

```
numbers = [1,2,3,4,5]
numbers.remove(5)
> [1,2,3,4]

del numbers[0]
>[2,3,4]

numbers.pop()
>4
```


### 11、python中enumerate的意思是什么？
### 12、is和==的区别
### 13、有如下代码：
### 14、对字典d={'a':30,'g':17,'b':25,'c':18,'d':50,'e':36,'f':57,'h':25}按照value字段进行排序
### 15、求以下代码的输出结果
### 16、什么是一致性哈希
### 17、文件操作时，xreadlines和readlines的区别
### 18、常用字符串格式化有哪几种？
### 19、如何保证Redis中的数据都是热点数据
### 20、如何实现['1','2','3']变成[1,2,3]
### 21、Python中的字典是什么？
### 22、在什么情况下y!=x-(x-y)会成立？
### 23、请写一个Python逻辑，计算一个文件中的大写字母数量
### 24、什么是Nginx
### 25、介绍一下try except的用法和作用？
### 26、编写程序，输出给定序列中的所有质数
### 27、如果Redis中的某个列表中的数据量非常大，如何实现循环显示每一个值？
### 28、a=range(10),则a[::-3]的值是？
### 29、Redis和Memcached的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
