# Python最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来

```python
A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]]
def my_print(lis):
for i in lis:
if type(i)==list:
my_print(i)
else:
print(i)
my_print(A)
```


### 2、a=range(10),则a[::-3]的值是？

[9,6,3,0] 或者 range(9,-1,-3)


### 3、什么是lambda函数？

Lambda函数是不带名称的单行函数，可以具有n个参数，但只能有一个表达式。也称为匿名函数。

```
a = lambda x, y：x + y 
print(a(5, 6))

> 11
```


### 4、类的加载和实例化过程

**1、** 在堆内存中生成class对象, 把静态变量和静态方法加载到方法区, 这个堆内存中的class对象是方法区数据的入口

**2、** 静态变量默认初始化

**3、** 静态变量显式初始化

**4、** 执行静态代码块

**5、** 成员变量默认初始化, 显示初始化

**6、** 执行构造函数


### 5、使用yield实现一个协程

```python
def consumer():
r = ''
while True:
n = yield r
if n is None:
return
print('[CONSUMER] Consuming %s...' % n)
r = '200 OK'

def produce(c):
c.send(None)
n = 0
while n < 5:
n = n + 1
print('[PRODUCER] Producing %s...' % n)
r = c.send(n)
print('[PRODUCER] Consumer return: %s' % r)
c.close()

c = consumer()
produce(c)
```


### 6、元组的解封装是什么？

首先我们来看解封装：

```
>>> mytuple=3,4,5
>>> mytuple
(3, 4, 5)
```

这将 3，4，5 封装到元组 mytuple 中。

现在我们将这些值解封装到变量 x，y，z 中：

```
>>> x,y,z=mytuple
>>> x+y+z
```

得到结果12.


### 7、什么是pickling和unpickling？

pickling是将Python对象(甚至是Python代码)，转换为字符串的过程。

unpickling是将字符串，转换为原来对象的逆过程。


### 8、为什么基于tcp协议的通信比基于udp协议的通信更可靠

TCP是面向连接的传输协议，每次都需要建立一个可以相互信任的连接，中间有个三次握手过程。而UDP是面向无连接的传输协议，不需要建立安全的连接，


### 9、python中enumerate的意思是什么？

枚举的意思，同时得到可迭代对象，如列表和元组的索引和值，以元组形式返回


### 10、什么是局域网和广域网

**1、** 局域网（Local Area Network），简称LAN，是指在某一区域内由多台计算机互联成的计算机组。“某一区域”指的是同一办公室、同一建筑物、同一公司和同一学校等，一般是方圆几千米以内。局域网可以实现文件管理、应用软件共享、打印机共享、扫描仪共享、工作组内的日程安排、电子邮件和传真通信服务等功能。局域网是封闭型的，可以由办公室内的两台计算机组成，也可以由一个公司内的上千台计算机组成。

**2、** 广域网（Wide Area Network），简称WAN，是一种跨越大的、地域性的计算机网络的集合。通常跨越省、市，甚至一个国家。广域网包括大大小小不同的子网，子网可以是局域网，也可以是小型的广域网。

**3、** 两者区别：

**4、** 范围不同，广域网比局域网广

**5、** 接口类型不同

**6、** 速率不同

**7、** 协议不同


### 11、编写程序，检查数字是否为Armstrong
### 12、Python中append，insert和extend的区别?
### 13、列举创建索引但是无法命中索引的情况
### 14、如果已经建立了TCP连接，但是客户端突然出现故障了怎么办
### 15、了解过Hbase，DB2，SQLServer，Access吗
### 16、手写一个队列
### 17、对字典d={'a':30,'g':17,'b':25,'c':18,'d':50,'e':36,'f':57,'h':25}按照value字段进行排序
### 18、traceroute使用哪种网络协议
### 19、如何更改列表的数据类型？
### 20、进程之间如何进行通信？
### 21、使用两个队列实现一个栈
### 22、简述SQL注入原理，以及如何在代码层面房子sql注入
### 23、求以下代码的输出结果
### 24、mro是什么？
### 25、MySQL的建表语句
### 26、什么是负载均衡
### 27、1，2，3，4，5能组成多少个互不相同且不重复的三位数？
### 28、如何用一行代码生成[1,4,9,16,25,36,49,64,81,100]?
### 29、简述OSI七层协议
### 30、char和varchar的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
