# Python最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、*arg和**kwargs的作用

用来接收不确定个数的参数，*args通常用来接收不确定个数的非关键字参数，而**kwargs通常用来接收不确定个数的关键字参数


### 2、解释一下Python中的继承？

继承(inheritance)允许一个类获取另一个类的所有成员和属性。继承提供代码可重用性，可以更轻松地创建和维护应用程序。

被继承的类称为超类，而继承的类称为派生类/子类。


### 3、有如下链表类，请实现单链表逆置。

```python
class ListNode:
def __init__(self,val):
self.val=val
self.next=None

class Solution:
def reverseList(self,pHead):
if not pHead or not pHead.next:
return pHead
last=None
while pHead:
tmp=pHead.next
pHead.next=last
last=pHead
pHead=tmp
return last
```


### 4、DNS域名解析过程

**1、** 浏览器检查缓存中有没有这个域名对应的解析后的IP地址，如果缓存中有，解析过程结束。缓存大小、时间都有限制，时间由TTL属性决定；

**2、** 如果浏览器缓存中么有，浏览器会查找操作系统缓存中有无这个域名DNS解析后的结果。操作系统也有一个域名解析的过程，windows通过C:\Windows\System32\drivers\etc\hosts，浏览器会优先使用这个解析结果（Win7已将hosts设置为只读），linux系统中/etc/named.conf。目前为止都是在本机完成，如果未完成，才会真正请求域名服务器解析域名。

**3、** “网络配置”中都会有“DNX服务器地址”，操作系统会把域名发送给这个LDNS，本地区的域名服务器，通常都会提供一个本地互联网接入的DNS解析服务。就在你所在城市的某个角落，通过ipconfig可以看到。

**4、** 如果LDNS仍然没有命中，则向RootServer域名服务器请求解析。

**5、** 根域名服务器向本地域名服务器返回一个所查询域的主域名服务器（gTLD Server）。国际顶级域名服务器（.com、.cn、.org等），全球13台。

**6、** 本地域名服务器（Local DNS Server）再向上一步返回的gTLD发送请求。

**7、** gTLD返回域名对应NameServer域名服务器地址，通常由你购买域名的服务商提供。

**8、** NameServer服务器查询域名与IP映射关系表，返回目标IP记录和TTL值给DNS Server域名服务器。

**9、** Local DNS Server根据TTL缓存该IP解析。

**10、** 缓存结果返回给用户，用户根据TTL缓存到本地操作系统中，域名解析过程结束。


### 5、如何在Python中管理内存？

Python内存由Python的私有headspace管理。

所有的Python对象和数据结构都位于一个私有堆中。私用堆的分配由Python内存管理器负责。

Python还内置了一个的垃圾收集器，可以回收未使用的内存并释放内存，使其可用于headspace。


### 6、求出以下代码的输出结果

```python
mydict={'a':1,'b':2}
def func(d):
d['a']=0
return d

func(mydict)
mydict['c']=2
print(mydict)
```

结果

> {'a': 0, 'b': 2, 'c': 2}



### 7、isinstance和type的作用

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


### 8、简述触发器、函数、视图和存储过程

**1、** 触发器：触发器是一个特殊的存储过程，它是MySQL在insert、update、delete的时候自动执行的代码块

**2、** 函数：MySQL中提供了许多内置函数，还可以自定义函数（实现程序员需要sql逻辑处理）

**3、** 视图：视图是由查询结果形成的一张虚拟表，是表通过某种运算得到的一个投影

**4、** 存储过程：把一段代码封装起来，当要执行这一段代码的时候，可以通过调用该存储过程来实现（经过第一次编译后再次调用不需要再次编译，比一个个执行sql语句效率高）


### 9、什么是覆盖索引

**覆盖索引又可以称为索引覆盖。**

**1、** 解释一： 就是select的数据列只用从索引中就能够取得，不必从数据表中读取，换句话说查询列要被所使用的索引覆盖。

**2、** 解释二： 索引是高效找到行的一个方法，当能通过检索索引就可以读取想要的数据，那就不需要再到数据表中读取行了。如果一个索引包含了（或覆盖了）满足查询语句中字段与条件的数据就叫做覆盖索引。

**3、** 解释三： 是非聚集组合索引的一种形式，它包括在查询里的Select、Join和Where子句用到的所有列（即建立索引的字段正好是覆盖查询语句[select子句]与查询条件[Where子句]中所涉及的字段，也即，索引包含了查询正在查找的所有数据）。


### 10、如何实现Redis集群

**1、** Twitter开发的twemproxy

**2、** 豌豆荚开发的codis

**3、** Redis官方的Redis-cluster


### 11、解释一下Python中的赋值运算符
### 12、Python的局限性？
### 13、请编写一个函数将ip地址转换成一个整数。如10.3.9.12转换成00001010 00000011 00001001 00001100，然后转换成整数
### 14、判断dict中有没有某个key。
### 15、什么是Python中的猴子补丁？
### 16、怎样获取字典中所有键的列表？
### 17、类和对象有什么区别？
### 18、1<(22)和1<22的结果分别是什么？
### 19、什么是codis
### 20、编写程序，计算文件中单词的出现频率
### 21、简述python的深浅拷贝
### 22、什么是防火墙？防火墙的作用是什么？
### 23、如何打乱一个排好序的列表
### 24、filter、map、reduce的作用。
### 25、什么是域名解析
### 26、使用yield实现一个协程
### 27、简述事务及其特性
### 28、lambda表达式格式以及应用场景？
### 29、简述jsonp及其原理
### 30、简述面向对象的三大特性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
