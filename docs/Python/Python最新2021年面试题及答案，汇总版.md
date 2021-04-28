# Python最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、re的match和search的区别

match()函数是在string的开始位置匹配，如果不匹配，则返回None

search()会扫描整个string查找匹配；也就是说match()只有在0位置匹配成功的话才有返回，


### 2、当退出Python时，是否释放全部内存？

答案是No。循环引用其它对象或引用自全局命名空间的对象的模块，在Python退出时并非完全释放。

另外，也不会释放C库保留的内存部分。


### 3、什么是C/S和B/S架构

**1、** C/S 架构是一种典型的两层架构，其全称是Client/Server，即客户端服务器端架构，其客户端包含一个或多个在用户的电脑上运行的程序，而服务器端有两种，一种是数据库服务器端，客户端通过数据库连接访问服务器端的数据；另一种是Socket服务器端，服务器端的程序通过Socket与客户端的程序通信。

**2、** B/S架构的全称为Browser/Server，即浏览器/服务器结构。Browser指的是Web浏览器，极少数事务逻辑在前端实现，但主要事务逻辑在服务器端实现，Browser客户端，WebApp服务器端和DB端构成所谓的三层架构。B/S架构的系统无须特别安装，只有Web浏览器即可。


### 4、简述线程死锁是怎么造成的。如何避免？

**1、** 死锁的产生原因？

**2、** 系统资源的竞争

**3、** 进程运行推进顺序不当

**4、** 解决死锁

**5、** 加锁顺序：线程按照一定的顺序加锁

**6、** 加锁时限：线程尝试获取锁的时候加上一定的时限，超过时限，则放弃对该锁的请求，并释放自己占有的锁。

**7、** 死锁检测


### 5、什么是lambda函数？

Lambda函数是不带名称的单行函数，可以具有n个参数，但只能有一个表达式。也称为匿名函数。

```
a = lambda x, y：x + y 
print(a(5, 6))

> 11
```


### 6、获取python解释器版本的方法

终端执行python -V


### 7、输入一个字符串，输出该字符串的字符的所有组合。如输入'abc',输出a,b,c,ab,ac,bc,abc.

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


### 8、列举你所了解的所有Python2和Python3的区别

[python2和python3的区别](https://blog.csdn.net/weixin_41819299/article/details/81259721)

**1、** python2没有nonlocal关键字，要修改临时变量只能将其改成可变数据类型，如数组。b=[a]

**2、** print()函数代替print语句

**3、** Python3加入 Unicode 字符串，用以编码存储字符串。比如用 utf-8可以用来输入中文

**4、** Python3去掉long类型，新增了bytes。

**5、** Python 3整数之间做除法可以得到浮点数的结果，不需要进行数据格式转换1/2=0.5 Python 2整数int间除法结果为把运算结果去尾的整数1/2=0，3/2.0=1.5

**6、** Python3 中 range()，Python2 中 xrange()。

**7、** python2中的不等于号可以是!=或者<>，python3只能是!=

**8、** python2中raw_input()用来输入字符串，而python3中使用input()来输入字符串


### 9、python是如何进行内存管理的？python的程序会内存泄漏吗？说说有没有什么方面阻止或者检测内存泄漏？

python是如何进行内存管理的[参考文章](https://blog.csdn.net/u010967872/article/details/80301633)

**1、** 引用计数

Python内部使用引用计数，来保持追踪内存中的对象，Python内部记录了对象有多少个引用，就是引用计数，当对象被创建时就创建了一个引用计数，当对象不再需要的时候，这个对象的引用计数为0时，他被垃圾回收。

**2、** 垃圾回收

当内存中有不再使用的部分时，垃圾收集器就会把他们清理掉。他会去检查那些引用计数为0的对象，然后清除其在内存中的空间。当然除了引用计数为0的会被清除，还有一种情况也会被垃圾收集器清掉，当两个对象相互引用时，他们本身其他引用已经为0了。

**3、** 内存池机制

**1、** Python提供了对内存的垃圾收集机制，但是他将不用的内存放到内存池而不是反回给操作系统。

**2、** python的程序会内存泄漏吗？

**3、** 会发生内存泄漏，在Python程序里，内存泄漏是由于一个长期持有的对象不断的往一个dict或者list对象里添加新的对象, 而又没有即时释放，就会导致这些对象占用的内存越来越多，从而造成内存泄漏。另外，对象的交叉引用也会造成内存无法释放的问题。

**说说有没有什么方面阻止或者检测内存泄漏？**

**1、** 程序员管理好每个python对象的引用，尽量在不需要使用对象的时候，断开所有引用

**2、** 尽量少通过循环引用组织数据，可以改用weakref做弱引用或者用id之类的句柄访问对象

**3、** 通过gc模块的接口可以检查出每次垃圾回收有哪些对象不能自动处理，再逐个逐个处理


### 10、python解释器种类以及特点

**1、** CPython

**2、** c语言开发的 使用最广的解释器

**3、** IPython

**4、** 基于cpython之上的一个交互式计时器 交互方式增强 功能和cpython一样

**5、** PyPy

**6、** 目标是执行效率 采用JIT技术 对python代码进行动态编译，提高执行效率

**7、** JPython

**8、** 运行在Java上的解释器 直接把python代码编译成Java字节码执行

**9、** IronPython

**10、** 运行在微软 .NET 平台上的解释器，把python编译成、NET 的字节码


### 11、简述解释型和编译型编程语言
### 12、写一个函数，计算出以下字母所代表的数字，每个字母值不一样
### 13、找出两个列表中相同的元素和不同的元素
### 14、什么是haproxy？
### 15、_init_在Python中有什么用？
### 16、如何实现响应式布局
### 17、求以下代码结果：
### 18、深拷贝和浅拷贝之间的区别是什么？
### 19、什么是keepalived
### 20、什么是粘包？出现粘包的原因？
### 21、1，2，3，4，5能组成多少个互不相同且不重复的三位数？
### 22、pass的使用
### 23、三元运算编写格式
### 24、解释一下Python中的成员运算符
### 25、用一行Python代码，从给定列表中取出所有的偶数和奇数
### 26、解释一下Python中的逻辑运算符
### 27、or 和 and
### 28、简述生成器，迭代器，装饰器以及应用场景
### 29、什么是局域网和广域网
### 30、什么是正向代理和反向代理？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
