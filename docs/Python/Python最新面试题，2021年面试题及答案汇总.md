# Python最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、输入一个字符串，输出该字符串的字符的所有组合。如输入'abc',输出a,b,c,ab,ac,bc,abc.

```python
def getC(s):
if not s:
return
len_s=len(s)
ss=[]
for i in range(len_s):
combination(s,0,i,ss)
aaa=[]
def combination(s,index,num,ss):
global aaa
if num==-1:
return
if index==len(s):
return
ss.append(s[index])
aaa.append(''.join(ss))
combination(s,index+1,num-1,ss)
ss.pop()
combination(s,index+1,num,ss)

getC('123')
print(aaa)
print(sorted(set(aaa),key=lambda x:len(str(x))))
```


### 2、Python中使用的zip函数是什么？

zip函数获取可迭代对象，将它们聚合到一个元组中，然后返回结果。

zip()函数的语法是zip(*iterables)

```
numbers = [1, 2, 3]
string = ['one', 'two', 'three'] 
result = zip(numbers,string)

print(set(result))
-------------------------------------
{(3, 'three'), (2, 'two'), (1, 'one')}
```


### 3、是否使用过functools中的函数？他的作用是什么？

**1、** functools.wraps()

在装饰器中用过，如果不使用wraps，则原始函数的**name**和**doc**的值就会丢失

**2、** functools.reduce()

第一个参数是一个函数，第二个参数是一个可迭代对象，代码如下：

```python
# 下面代码相当于从1加到9
from functools import reduce
a=reduce(lambda x,y:x+y,range(10))
print(a)
```


### 4、什么是局域网和广域网

**1、** 局域网（Local Area Network），简称LAN，是指在某一区域内由多台计算机互联成的计算机组。“某一区域”指的是同一办公室、同一建筑物、同一公司和同一学校等，一般是方圆几千米以内。局域网可以实现文件管理、应用软件共享、打印机共享、扫描仪共享、工作组内的日程安排、电子邮件和传真通信服务等功能。局域网是封闭型的，可以由办公室内的两台计算机组成，也可以由一个公司内的上千台计算机组成。

**2、** 广域网（Wide Area Network），简称WAN，是一种跨越大的、地域性的计算机网络的集合。通常跨越省、市，甚至一个国家。广域网包括大大小小不同的子网，子网可以是局域网，也可以是小型的广域网。

**3、** 两者区别：

**4、** 范围不同，广域网比局域网广

**5、** 接口类型不同

**6、** 速率不同

**7、** 协议不同


### 5、!=和is not运算符的区别？

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


### 6、一行代码通过filter和lambda函数输出alist=[1,22,2,33,23,32]中索引为奇数的值

```python
alist=[1,22,2,33,23,32]
ss=[x[1] for x in filter(lambda x:x[0]%2==1,enumerate(alist))]
print(ss)
```


### 7、什么是负载均衡

负载均衡建立在现有网络结构之上，它提供了一种廉价有效透明的方法扩展网络设备和服务器的带宽、增加吞吐量、加强网络数据处理能力、提高网络的灵活性和可用性。

负载均衡其意思就是分摊到多个操作单元上进行执行。


### 8、一个数如果恰好等于它的因子之和，这个数就称为‘完数’，比如6=1+2+3，编程找出1000以内的所有的完数。

```python
wanshu=[]
for i in range(1,1001):
s=0
for j in range(1,i//2+1):
if i % j ==0:
s+=j
else:
if i==s:
wanshu.append(i)
print(wanshu)
```


### 9、logging模块的作用以及应用场景

logging模块定义的函数和类为应用程序和库的开发实现了一个灵活的事件日志系统。

记录日志


### 10、MySQL索引种类

**1、** 普通索引：仅加速查询

**2、** 唯一索引：加速查询 + 列值唯一（可以有null）

**3、** 主键索引：加速查询 + 列值唯一（不可以有null）+ 表中只有一个

**4、** 组合索引：多列值组成一个索引，专门用于组合搜索，其效率大于索引合并

**5、** 全文索引：对文本的内容进行分词，进行搜索


### 11、如果Redis中的某个列表中的数据量非常大，如何实现循环显示每一个值？
### 12、字节码和机器码的区别
### 13、解决哈希冲突的算法有哪几种？分别有什么特点？
### 14、列举字符串、列表、元组、字典每个常用的5个方法
### 15、Redis中watch的作用
### 16、python和java、php、c、c#、c++ 等其他语言对比？
### 17、手写一个栈
### 18、文件操作时，xreadlines和readlines的区别
### 19、你了解哪些数据库优化方案
### 20、a = dict(zip(('a','b','c','d','e'),(1,2,3,4,5))) 请问a是什么？
### 21、什么是C/S和B/S架构
### 22、用一行Python代码，从给定列表中取出所有的偶数和奇数
### 23、请写一个Python逻辑，计算一个文件中的大写字母数量
### 24、DNS域名解析过程
### 25、解释一下Python中的成员运算符
### 26、or 和 and
### 27、如何打乱一个排好序的列表
### 28、实现一个单例模式。(尽可能多的方法)
### 29、什么是codis
### 30、从0-99这100个数中随机取出10个，要求不能重复




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
