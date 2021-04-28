# Python最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Python中注释代码的方法有哪些？

在Python中，我们可以通过下面两种方式进行注释。

**1、**  三引号'''，用于多行注释。

**2、**  单井号#，用于单行注释。


### 2、编写程序，检查序列是否为回文

```
a = input("Enter The sequence")
ispalindrome = a == a[::-1]

ispalindrome
>True
```


### 3、如何使用python删除一个文件或者文件夹？

```python
import os
import shutil
os.remove(path) # 删除文件
os.removedirs(path) # 删除空文件夹
shutil.rmtree(path) # 删除文件夹，可以为空也可以不为空
```


### 4、你了解哪些数据库优化方案

**1、** 减少数据访问-创建并正确使用索引

**2、** 返回更少的数据

**3、** 数据分页处理

**4、** 只返回需要的字段

**5、** 减少交互次数

**6、** 使用存储过程

**7、** 优化业务逻辑

**8、** 减少服务器的cpu运算

**9、** 使用绑定变量

**10、** 合理使用排序

**11、** 减少比较操作

**12、** 大量复杂运算在客户端处理

**13、** 利用更多资源

**14、** 客户端多进程访问

**15、** 数据库并行处理


### 5、元组的解封装是什么？

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


### 6、在Python中有多少种运算符？解释一下算数运算符。

在Python中，我们有7种运算符：算术运算符、关系运算符、赋值运算符、逻辑运算符、位运算符、成员运算符、身份运算符。

我们有7个算术运算符，能让我们对数值进行算术运算：

**1、** 加号（+），将两个值相加

```
>>> 7+8
15
```

**2、** 减号（-），将第一个值减去第二个值

```
>>> 7-8
-1
```

**3、** 乘号（*），将两个值相乘

```
>>> 7*8
56
```

**4、** 除号（/），用第二个值除以第一个值

```
>>> 7/8
0.875
>>> 1/1
1.0
```

**5、** 向下取整除、取模和取幂运算，参见上个问题。


### 7、如何基于Redis实现发布和订阅

```python
# 发布者
#coding:utf-8import time
import Redis

number_list = ['300033', '300032', '300031', '300030']
signal = ['1', '-1', '1', '-1']

rc = Redis.StrictRedis(host='***', port='6379', db=3, password='********')
for i in range(len(number_list)):
value_new = str(number_list[i]) + ' ' + str(signal[i])
rc.publish("liao", value_new)  #发布消息到liao
```

```python
# 订阅者
#coding:utf-8import time
import Redis

rc = Redis.StrictRedis(host='****', port='6379', db=3,     password='******')
ps = rc.pubsub()
ps.subscribe('liao')  #从liao订阅消息for item in ps.listen():        #监听状态：有消息发布了就拿过来
if item['type'] == 'message':
print item['channel']
print item['data']
```


### 8、手写一个栈

```python
#给一个点，我们能够根据这个点知道一些内容
class Node(object):
def __init__(self,val): #定位的点的值和一个指向
self.val=val #指向元素的值,原队列第二元素
self.next=None #指向的指针

class stack(object):
def __init__(self):
self.top=None #初始化最开始的位置

def push(self,n):#添加到栈中
n=Node(n) #实例化节点
n.next=self.top #顶端元素传值给一个指针
self.top=n
return n.val

def pop(self): #退出栈
if self.top == None:
return None
else:
tmp=self.top.val
self.top=self.top.next #下移一位，进行
return tmp

if __name__=="__main__":
s=stack()
print(s.pop())
s.push(1)
print(s.pop())
s.push(2)
s.push(3)
print(s.pop())
s.push(3)
s.push(3)
s.push(3)
print(s.pop())
print(s.pop())
print(s.pop())
print(s.pop())
```


### 9、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今

```python
# 方法一
import os
def Test1(rootDir):
list_dirs = os.walk(rootDir)
for root, dirs, files in list_dirs:
for d in dirs:
print(os.path.join(root, d))
for f in files:
print(os.path.join(root, f))
Test1(r'C:\Users\felix\Desktop\aaa')
print('#############')
# 方法二
import os
def Test2(rootDir):
paths=os.listdir(rootDir)
for lis in paths:
path=os.path.join(rootDir,lis)
print(path)
if os.path.isdir(path):
 Test2(path)
Test2(r'C:\Users\felix\Desktop\aaa')
```


### 10、mro是什么？

对于支持继承的编程语言来说，其方法（属性）可能定义在当前类，也可能来自于基类，所以在方法调用时就需要对当前类和基类进行搜索以确定方法所在的位置。而搜索的顺序就是所谓的「方法解析顺序」（Method Resolution Order，或MRO）。


### 11、使用两个队列实现一个栈
### 12、select、poll、epoll模型的区别
### 13、vuex的作用
### 14、解释Python中reduce函数的用法？
### 15、列举创建索引但是无法命中索引的情况
### 16、一个数如果恰好等于它的因子之和，这个数就称为‘完数’，比如6=1+2+3，编程找出1000以内的所有的完数。
### 17、将下面列表中的元素根据位数合并成字典：
### 18、IO多路复用的作用？
### 19、列举面向对象中带双下划线的特殊方法
### 20、如何实现字符串的反转？如：name=felix，反转成name=xilef
### 21、什么是twisted框架
### 22、什么是asyncio
### 23、MySQL如何创建索引
### 24、python递归的最大层数？
### 25、py2项目如何迁移成py3
### 26、Python中的生成器是什么？
### 27、!=和is not运算符的区别？
### 28、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？
### 29、求下面代码结果
### 30、解释Python的内置数据结构？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
