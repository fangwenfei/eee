# Python最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、求下面代码结果

```python
v=dict.fromkeys(['k1','k2'],[])
v['k1'].append(666)
print(v)
v['k1']=777
print(v)
```

**结果：**

{'k1': [666], 'k2': [666]}

{'k1': 777, 'k2': [666]}


### 2、如何基于Redis实现发布和订阅

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


### 3、Python中的字典是什么？

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


### 4、python中enumerate的意思是什么？

枚举的意思，同时得到可迭代对象，如列表和元组的索引和值，以元组形式返回


### 5、MySQL常见数据库引擎及区别

**1、** InnoDB：用于事务处理应用程序，具有众多特性，包括ACID事务支持。(提供行级锁)

**2、** MyISAM：默认的MySQL插件式存储引擎，它是在Web、数据仓储和其他应用环境下最常使用的存储引擎之一。注意，通过更改STORAGE_ENGINE配置变量，能够方便地更改MySQL服务器的默认存储引擎。

**3、** Memory：将所有数据保存再RAM中


### 6、列表中保留顺序和不保留顺序去重

**不保留顺序**

```python
lis=[3, 1, 4, 2, 3]
print(list(set(lis)))
```

**保留顺序**

```python
lis=[3, 1, 4, 2, 3]
T=[]
[T.append(i) for i in lis if i not in T])
print(T)

# 或者
T=sorted(set(lis), key=lis.index)
print(T)
```


### 7、什么是闭包

在函数中可以（嵌套）定义另一个函数时，如果内部的函数引用了外部的函数的变量，则可能产生闭包。闭包可以用来在一个函数与一组“私有”变量之间创建关联关系。在给定函数被多次调用的过程中，这些私有变量能够保持其持久性。

```python
# 内部函数使用了外部函数的变量，就相当于闭包
def func1():
a=1
def inner():
return a
return inner
print(func1()())
```


### 8、什么是一致性哈希

[参考链接](https://www.jianshu.com/p/49e3fbf41b9b)

一致性哈希简称DHT,是麻省理工学院提出的一种算法，目前主要应用于分布式缓存当中。一致性哈希可以有效地解决分布式存储结构下动态增加和删除节点所带来的问题。


### 9、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。

```python
a='aaabbcccdddde'
aa=''
for i in sorted(list(set(a)),key=a.index):
aa=aa+i+str(a.count(i))
print(aa)
```


### 10、介绍一下try except的用法和作用？

主要用来处理异常

**完整用法如下：**

```python
try:
     Normal execution block
except A:
     Exception A handle
except B:
     Exception B handle
except:
     Other exception handle
else:
     if no exception,get here
finally:
     print("finally")
```


### 11、解释Python中的join()和split()函数
### 12、请编写一个函数将ip地址转换成一个整数。如10.3.9.12转换成00001010 00000011 00001001 00001100，然后转换成整数
### 13、Redis默认多少个db
### 14、什么是多态？
### 15、使用两个队列实现一个栈
### 16、threading.local的作用
### 17、简述解释型和编译型编程语言
### 18、json序列化时可以处理的数据类型有哪些？如何定制支持datetime类型？序列化时，遇到中文转成unicode，如何保持中文形式？
### 19、Python中的生成器是什么？
### 20、如何查找一个字符串中特定的字符？find和index的差异？
### 21、深拷贝和浅拷贝之间的区别是什么？
### 22、常用字符串格式化有哪几种？
### 23、请列举你所知道的python代码检测工具以及他们之间的区别
### 24、现有mydict和变量onekey，请写出从mydict中取出onekey的值的方法
### 25、如何保证Redis中的数据都是热点数据
### 26、如何实现['1','2','3']变成[1,2,3]
### 27、GIL锁对python性能的影响
### 28、a = dict(zip(('a','b','c','d','e'),(1,2,3,4,5))) 请问a是什么？
### 29、从0-99这100个数中随机取出10个，要求不能重复
### 30、解释一下Python中的成员运算符




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
