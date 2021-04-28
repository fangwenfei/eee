# Python最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何判断一个对象是否可调用？哪些对象是可调用对象？如何定义一个类，使其对象本身就是可调用对象？

**1、** 使用callable函数判断。

**2、** 可调用对象有7类：

**3、** 用户自定义函数

**4、** 内置函数

**5、** 内置方法

**6、** 方法(定义在类中的函数)

7、类

**8、** 类实例(如果类中定义了**call**方法，那么这个类的实例就是可调用对象)

**9、** 生成器函数

在类中定义**call**方法，实例对象加()是即调用**call**的方法


### 2、如何在函数中设置一个全局变量？

在函数中使用global关键字定义变量


### 3、用一行Python代码，从给定列表中取出所有的偶数和奇数

```
a = [1,2,3,4,5,6,7,8,9,10]
odd, even = [el for el in a if el % 2==1], [el for el in a if el % 2==0]

print(odd,even)
> ([1, 3, 5, 7, 9], [2, 4, 6, 8, 10])
```


### 4、简述线程死锁是怎么造成的。如何避免？

**1、** 死锁的产生原因？

**2、** 系统资源的竞争

**3、** 进程运行推进顺序不当

**4、** 解决死锁

**5、** 加锁顺序：线程按照一定的顺序加锁

**6、** 加锁时限：线程尝试获取锁的时候加上一定的时限，超过时限，则放弃对该锁的请求，并释放自己占有的锁。

**7、** 死锁检测


### 5、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。

```python
alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]
blist=sorted(alist,key=lambda x:x['age'],reverse=True)
print(blist)
```


### 6、logging模块的作用以及应用场景

logging模块定义的函数和类为应用程序和库的开发实现了一个灵活的事件日志系统。

记录日志


### 7、解释一下Python中的赋值运算符

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


### 8、列举面向对象中带双下划线的特殊方法

```
\_\_new__：可以调用其它类的构造方法或者直接返回别的对象来作为本类的实例。
\_\_init__： 负责类的实例化
\_\_call__：对象后边加括号，触发执行
\_\_str__：print打印一个对象时。
\_\_doc__：类的注释，该属性是无法继承的。
\_\_getattr__：在使用调用属性（方式、属性）不存在的时候触发
\_\_setattr__：添加/修改属性会触发它的执行
\_\_dellattr__：删除属性的时候会触发
\_\_delete__：采用del删除属性时，触发
```


### 9、什么是闭包

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


### 10、写python爬虫分别用到了哪些模块？分别有什么用？

模块

request，发起请求

pyquery，解析html数据

beautifulsoup，解析html数据

aiohttp，异步发送请求

框架

pyspider，web界面的爬虫框架

scrapy，爬虫框架

selenium，模拟浏览器的爬虫框架


### 11、什么是域名解析
### 12、手写一个栈
### 13、如何实现响应式布局
### 14、22、iterables和iterators之间的区别？
### 15、or 和 and
### 16、写一个函数，计算出以下字母所代表的数字，每个字母值不一样
### 17、什么是ajax请求？手写一个ajax请求
### 18、什么是负索引？
### 19、Python中的Map Function是什么？
### 20、在Python中如何实现多线程？
### 21、Python中注释代码的方法有哪些？
### 22、如何实现['1','2','3']变成[1,2,3]
### 23、请列举你所知道的python代码检测工具以及他们之间的区别
### 24、举例说明Python中的range函数?
### 25、Redis默认多少个db
### 26、Python中的标识符长度能有多长？
### 27、将下面列表中的元素根据位数合并成字典：
### 28、MySQL的增删改查
### 29、如何修改本地hosts文件
### 30、解释Python中的Filter？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
