# Python最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、有两个字符串列表a和b，每个字符串是由逗号隔开的一些字符

```python
a=[
'a,1',
'b,3,22',
'c,3,4',
]
b=[
'a,2',
'b,1',
'd,5',
]
# 按照a，b中每个字符串的第一个值，合并成c如下：
c=[
'a,1,2',
'b,3,22,1',
'c,3,4',
'd,5'
]
```

```python
# 解法：

a=[
'a,1',
'b,3,22',
'c,3,4',
]
b=[
'a,2',
'b,1',
'd,5',
]
a_dic={}
for s in a:
k,v = s.split(',',1)
a_dic[k]=v
b_dic={}
for s in b:
k,v = s.split(',',1)
b_dic[k]=v
c_dic=a_dic
for k,v in b_dic.items():
if k in c_dic:
c_dic[k]=','.join([c_dic[k],v])
else:
c_dic[k]=v
c=[','.join([k,c_dic[k]]) for k in c_dic]
print(c)
```


### 2、怎样声明多个变量并赋值？

一共有两种方式：

```
>>> a,b,c=3,4,5 #This assigns 3, 4, and 5 to a, b, and c respectively
>>> a=b=c=3 #This assigns 3 to a, b, and c
```


### 3、super的作用

当子类中的方法与父类中的方法重名时，子类中的方法会覆盖父类中的方法，那么，如果我们想实现同时调用父类和子类中的同名方法，就需要使用到super()这个函数，用法为super().函数名()


### 4、有如下代码：

```python
import copy
a=[1,2,3,[4,5],6]
b=a
c=copy.copy(a)
d=copy.deepcopy(a)
b.append(10)
c[3].append(11)
d[3].append(12)
```

求a，b，c，d

**答案：**

> a：[1, 2, 3, [4, 5, 11], 6, 10]

b：[1, 2, 3, [4, 5, 11], 6, 10]

c：[1, 2, 3, [4, 5, 11], 6]

d：[1, 2, 3, [4, 5, 12], 6]



### 5、有如下链表类，请实现单链表逆置。

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


### 6、什么是c3算法？

c3算法是python新式类中用来产生mro顺序的一套算法。即多继承的查找规则。


### 7、编写程序，检查数字是否为Armstrong

将每个数字依次分离，并累加其立方(位数)。

最后，如果发现总和等于原始数，则称为阿姆斯特朗数(Armstrong)。

```
num = int(input("Enter the number:\n"))
order = len(str(num))

sum = 0
temp = num

while temp > 0:
   digit = temp % 10
   sum += digit ** order
   temp //= 10

if num == sum:
   print(num,"is an Armstrong number")
else:
   print(num,"is not an Armstrong number")
```


### 8、举例说明Python中的range函数?

range：range函数返回从起点到终点的一系列序列。

range(start, end, step)，第三个参数是用于定义范围内的步数。

```
# number
for i in range(5):
    print(i)
> 0,1,2,3,4

# (start, end)
for i in range(1, 5):
    print(i)
> 1,2,3,4

# (start, end, step)
for i in range(0, 5, 2):
    print(i)
>0,2,4
```


### 9、sys.path.append('xxx')的作用

添加搜索路径


### 10、为什么数据很大的时候使用limit offset分页时，越往后翻速度越慢，如何优化？

使用limit分页时，比如limit 10000，20的意思是扫描满足条件的10020行，扔掉前面的10000行，最后返回20行，问题就出在这，当数据量大的时候，大量时间花在了扫描上面了。

**优化方法：**

**1、** 当一个数据库表过于庞大，LIMIT offset, length中的offset值过大，则SQL查询语句会非常缓慢，你需增加order by，并且order by字段需要建立索引。

**2、** 如果使用子查询去优化LIMIT的话，则子查询必须是连续的，某种意义来讲，子查询不应该有where条件，where会过滤数据，使数据失去连续性


### 11、简述数据库分库分表
### 12、解释//、％、* *运算符？
### 13、当退出Python时，是否释放全部内存？
### 14、*arg和**kwargs的作用
### 15、对字典d={'a':30,'g':17,'b':25,'c':18,'d':50,'e':36,'f':57,'h':25}按照value字段进行排序
### 16、python是如何进行内存管理的？python的程序会内存泄漏吗？说说有没有什么方面阻止或者检测内存泄漏？
### 17、为什么基于tcp协议的通信比基于udp协议的通信更可靠
### 18、python3和python2中int和long的区别
### 19、写出以下代码的输出结果：
### 20、python如何定义函数时如何书写可变参数和关键字参数？
### 21、写出邮箱的正则表达式
### 22、写出如下代码的输出结果
### 23、列表推导式[i for i in range(10)]和生成式表达式(i for i in range(10))的区别
### 24、ascii、Unicode、utf-8、gbk的区别
### 25、为什么Python执行速度慢，我们如何改进它？
### 26、filter、map、reduce的作用。
### 27、以下代码输出什么？
### 28、Redis中sentinel的作用
### 29、如何打乱一个排好序的列表




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
