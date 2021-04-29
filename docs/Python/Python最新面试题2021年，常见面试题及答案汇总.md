# Python最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、vue中的路由拦截器的作用

当某些页面需要访问权限时，可以使用路由拦截器对用户权限进行判断


### 2、什么是Nginx

nginx是一个高性能的HTTP和反向代理服务，也是一个IMAP/POP3/SMTP服务


### 3、mro是什么？

对于支持继承的编程语言来说，其方法（属性）可能定义在当前类，也可能来自于基类，所以在方法调用时就需要对当前类和基类进行搜索以确定方法所在的位置。而搜索的顺序就是所谓的「方法解析顺序」（Method Resolution Order，或MRO）。


### 4、怎么移除一个字符串中的前导空格？

字符串中的前导空格就是出现在字符串中第一个非空格字符前的空格。我们使用方法Istrip()可以将它从字符串中移除。

```
>>> '   Ayushi '.lstrip()
```

结果：

```
‘Ayushi   ’
```

可以看到，该字符串既有前导字符，也有后缀字符，调用Istrip()去除了前导空格。如果我们想去除后缀空格，就用rstrip()方法。

```
>>> '   Ayushi '.rstrip()
```

结果：

```
‘   Ayushi’
```

从Q 21到Q 35是为有Python经验者准备的进阶版Python面试题。


### 5、什么是lambda函数？

Lambda函数是不带名称的单行函数，可以具有n个参数，但只能有一个表达式。也称为匿名函数。

```
a = lambda x, y：x + y 
print(a(5, 6))

> 11
```


### 6、使用生成器编写一个函数实现生成指定个数的斐波那契数列

```python
def fib2(imax):
t,a,b=0,0,1
while t<imax:
yield b
a,b=b,a+b
t+=1

for i in fib2(10):
print(i)
```


### 7、简述jsonp及其原理

JSONP是JSON with Padding的略称。它是一个非官方的协议，它允许在服务器端集成Script tags返回至客户端，通过javascript callback的形式实现跨域访问（这仅仅是JSONP简单的实现形式）

原理：








### 8、什么是switch语句。如何在Python中创建switch语句？

switch语句是实现多分支选择功能，根据列表值测试变量。

switch语句中的每个值都被称为一个case。

在Python中，没有内置switch函数，但是我们可以创建一个自定义的switch语句。

```
switcher = {
   1: "January",
   2: "February",
   3: "March",
   4: "April",
   5: "May",
   6: "June",
   7: "July",
   8: "August",
   9: "September",
   10: "October",
   11: "November",
   12: "December"
}
month = int(input())
print(switcher.get(month))

> 3
march
```


### 9、列表和元组之间的区别是？

二者的主要区别是列表是可变的，而元组是不可变的。举个例子，如下所示：

```
>>> mylist=[1,3,3]
>>> mylist[1]=2
>>> mytuple=(1,3,3)
>>> mytuple[1]=2
Traceback (most recent call last):
File "<pyshell#97>", line 1, in <module>
mytuple[1]=2
```

会出现以下报错：

```
TypeError: ‘tuple’ object does not support item assignment
```

关于列表和元组的更多内容，可以查看这里：


### 10、简述线程死锁是怎么造成的。如何避免？

**1、** 死锁的产生原因？

**2、** 系统资源的竞争

**3、** 进程运行推进顺序不当

**4、** 解决死锁

**5、** 加锁顺序：线程按照一定的顺序加锁

**6、** 加锁时限：线程尝试获取锁的时候加上一定的时限，超过时限，则放弃对该锁的请求，并释放自己占有的锁。

**7、** 死锁检测


### 11、列举常见的关系型数据库和非关系型数据库。
### 12、简述数据库的读写分离
### 13、什么是粘包？出现粘包的原因？
### 14、请编写一个函数将ip地址转换成一个整数。如10.3.9.12转换成00001010 00000011 00001001 00001100，然后转换成整数
### 15、什么是轮询和长轮询
### 16、举例说明Python中的range函数?
### 17、什么是抽象？
### 18、简述进程，线程，协程的区别以及应用场景？
### 19、MySQL如何创建索引
### 20、编写一个函数，找出数组中没有重复的值的和
### 21、在什么情况下y!=x-(x-y)会成立？
### 22、1<(22)和1<22的结果分别是什么？
### 23、关于Python程序的运行方面，有什么手段能提升性能？
### 24、列举Redis支持的过期策略
### 25、对列表[3,1,-4,-2]按照绝对值排序
### 26、以下代码输出什么？
### 27、什么是并发和并行
### 28、三元运算编写格式
### 29、python如何定义函数时如何书写可变参数和关键字参数？
### 30、什么是cdn




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
