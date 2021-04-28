# Python最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、现有mydict和变量onekey，请写出从mydict中取出onekey的值的方法

> 方法一：mydict[onekey]

这种方法，如果mydict中键不存在的时候程序会报错

方法二：mydict.get(onekey)

这种方法，如果存在，返回值，不存在返回None

方法三：mydict.setdefault(onekey,[])

这种方法：存在的话返回值，不存在的时候创建一个值，值得内容为第二个参数+



### 2、以下代码输出什么？

```python
lis=['a','b','c','d','e']
print(lis[10:])
```

**答案：[]**


### 3、什么是粘包？出现粘包的原因？

**1、** 粘包：多个数据包被连续存储于连续的缓存中，在对数据包进行读取时由于无法确定发生方的发送边界，而采用某一估测值大小来进行数据读出，若双方的size不一致时就会使指发送方发送的若干包数据到接收方接收时粘成一包，从接收缓冲区看，后一包数据的头紧接着前一包数据的尾。

**2、** 出现粘包现象的原因是多方面的，它既可能由发送方造成，也可能由接收方造成。

**3、** 发送方引起的粘包是由TCP协议本身造成的，TCP为提高传输效率，发送方往往要收集到足够多的数据后才发送一包数据。若连续几次发送的数据都很少，通常TCP会根据优化算法把这些数据合成一包后一次发送出去，这样接收方就收到了粘包数据。

**4、** 接收方引起的粘包是由于接收方用户进程不及时接收数据，从而导致粘包现象。这是因为接收方先把收到的数据放在系统接收缓冲区，用户进程从该缓冲区取数据，若下一包数据到达时前一包数据尚未被用户进程取走，则下一包数据放到系统接收缓冲区时就接到前一包数据之后，而用户进程根据预先设定的缓冲区大小从系统接收缓冲区取数据，这样就一次取到了多包数据。


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


### 5、如何实现字符串的反转？如：name=felix，反转成name=xilef

```python
name = "felix"
# 方法一：
name=name[::-1]
# 方法二：
name2=list(name)
name2.reverse()
name=''.join(name2)
# 方法三：
from functools import reduce
name=reduce(lambda x, y: y+x, name)
```


### 6、如何在Python中管理内存？

Python内存由Python的私有headspace管理。

所有的Python对象和数据结构都位于一个私有堆中。私用堆的分配由Python内存管理器负责。

Python还内置了一个的垃圾收集器，可以回收未使用的内存并释放内存，使其可用于headspace。


### 7、pass的使用

通常用来标记一个还未写的代码的位置，pass不做任何事情，一般用来做占位语句，保持程序结构的完整性


### 8、axios的作用

**axios是基于promise的用于浏览器和nodejs的HTTP客户端，本身有以下特征：**

**1、** 从浏览器中创建XMLHttpRequest；

**2、** 从nodejs发出http请求

**3、** 支持promiseAPI

**4、** 拦截 请求和响应

**5、** 转换请求和响应数据

**6、** 取消请求

**7、** 自动转换JSON数据

**8、** 客户端支持防止CSRF/XSRF攻击


### 9、_init_在Python中有什么用？

“__init__”是Python类中的保留方法。

它被称为构造函数，每当执行代码时都会自动调用它，它主要用于初始化类的所有变量。


### 10、写出以下代码的输出结果：

```python
def test():
try:
raise ValueError('something wrong')
except ValueError as e:
print('error occured')
return
finally:
print('ok')
test()
```

结果(finally无论怎样都会执行)

> error occured

ok



### 11、break、continue、pass是什么？
### 12、如何高效的找到Redis中所有以felix开头的key
### 13、解决哈希冲突的算法有哪几种？分别有什么特点？
### 14、如果Redis中的某个列表中的数据量非常大，如何实现循环显示每一个值？
### 15、Python的局限性？
### 16、列表推导式[i for i in range(10)]和生成式表达式(i for i in range(10))的区别
### 17、select、poll、epoll模型的区别
### 18、请编写一个函数将ip地址转换成一个整数。如10.3.9.12转换成00001010 00000011 00001001 00001100，然后转换成整数
### 19、字节码和机器码的区别
### 20、输入一个字符串，输出该字符串的字符的所有组合。如输入'abc',输出a,b,c,ab,ac,bc,abc.
### 21、解释Python中的help()和dir()函数
### 22、什么是断言(assert)?应用场景？
### 23、MySQL常见的函数
### 24、实现一个装饰器，通过一次调用，使函数重复执行5次
### 25、解释一下Python中的三元运算子
### 26、有两个字符串列表a和b，每个字符串是由逗号隔开的一些字符
### 27、什么是haproxy？
### 28、怎样声明多个变量并赋值？
### 29、对列表[3,1,-4,-2]按照绝对值排序
### 30、将列表按照下列规则排序：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
