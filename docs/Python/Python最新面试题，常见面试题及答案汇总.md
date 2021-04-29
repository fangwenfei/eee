# Python最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Python中的字典是什么？

字典是C++和Java等编程语言中所没有的东西，它具有键值对。

```
>>> roots={25:5,16:4,9:3,4:2,1:1}
>>> type(roots)
<class 'dict'>
>>> roots[9]
```

运行结果为：

```
3
```

字典是不可变的，我们也能用一个推导式来创建它。

```
>>> roots={x**2:x for x in range(5,0,-1)}
>>> roots
```

运行结果：

```
{25: 5, 16: 4, 9: 3, 4: 2, 1: 1}
```


### 2、通过什么途径学习python

**1、** 通过看官方文档

**2、** 通过哔哩哔哩上的视频教程

**3、** 通过百度查资料

**4、** 通过买python相关方面的书


### 3、什么是keepalived

Keepalived是Linux下一个轻量级别的高可用解决方案


### 4、如何保证Redis中的数据都是热点数据

**1、** Redis 内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略。Redis 提供 6种数据淘汰策略：

**2、** volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**3、** volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**4、** volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**5、** allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**6、** allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰

**7、** no-enviction（驱逐）：禁止驱逐数据


### 5、解释一下Python中的赋值运算符

这在Python面试中是个重要的面试问题。

我们将所有的算术运算符和赋值符号放在一起展示：

```
>>> a=7
>>> a+=1
>>> a
8
 
>>> a-=1
>>> a
7
 
>>> a*=2
>>> a
14
 
>>> a/=2
>>> a
7.0 
 
>>> a**=2
>>> a
49
 
>>> a//=3
>>> a
16.0
 
>>> a%=4
>>> a
0.0
```


### 6、python中进制转换

> 进制转换以十进制为媒介

十六进制前面加上0x，八进制加上0o，二进制前面加上0b

|  | 二进制 | 八进制 | 十进制 | 十六进制 |
| --- | --- | --- | --- | --- |
| 二进制 |  | bin(int(x, 8)） | bin(int(x, 10)) | bin(int(x, 16)) |
| 八进制 | oct(int(x, 2)) |  | oct(int(x, 10)) | oct(int(x, 16)) |
| 十进制 | int(x, 2) | int(x, 8) |  | int(x, 16) |
| 十六进制 | hex(int(x, 2)) | hex(int(x, 8)) | hex(int(x, 10)) |  |



### 7、编写程序，检查序列是否为回文

```
a = input("Enter The sequence")
ispalindrome = a == a[::-1]

ispalindrome
>True
```


### 8、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？

[参考文档](https://www.cnblogs.com/ILoke-Yang/p/8060003.html)

贪婪匹配:正则表达式一般趋向于最大长度匹配，也就是所谓的贪婪匹配。

非贪婪匹配：就是匹配到结果就好，就少的匹配字符。

区别：默认是贪婪模式；在量词后面直接加上一个问号？就是非贪婪模式。


### 9、解释一下Python中的三元运算子

不像C++，我们在Python中没有?:，但我们有这个：

```
[on true] if [expression] else [on false]
```

如果表达式为True，就执行[on true]中的语句。否则，就执行[on false]中的语句。

下面是使用它的方法：

```
>>> a,b=2,3
>>> min=a if a<b else b
>>> min
```

运行结果：

```
2
```

```
>>> print("Hi") if a<b else print("Bye")
```

运行结果：

```
Hi
```


### 10、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来

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


### 11、如何实现['1','2','3']变成[1,2,3]
### 12、Python中的生成器是什么？
### 13、如何在函数中设置一个全局变量？
### 14、如何实现字符串的反转？如：name=felix，反转成name=xilef
### 15、求出以下代码的输出结果
### 16、解释//、％、* *运算符？
### 17、实现99乘法表（使用两种方法）
### 18、py2项目如何迁移成py3
### 19、query作为sql模板，args为将要传入的参数
### 20、解释一下Python中的继承？
### 21、为什么Python执行速度慢，我们如何改进它？
### 22、什么是域名解析
### 23、什么是多态？
### 24、编写程序，查找文本文件中最长的单词
### 25、简述触发器、函数、视图和存储过程
### 26、用一行代码实现数值交换
### 27、什么是arp协议
### 28、为什么数据很大的时候使用limit offset分页时，越往后翻速度越慢，如何优化？
### 29、Python的局限性？
### 30、前后端分离的基本原理




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
