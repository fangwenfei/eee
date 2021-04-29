# Python最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在什么情况下y!=x-(x-y)会成立？

x，y是两个不相等的非空集合


### 2、简述面向对象的三大特性？

继承，封装和多态

**继承：**

继承就是继承的类直接拥有被继承类的属性而不需要在自己的类体中重新再写一遍，其中被继承的类叫做父类、基类，继承的类叫做派生类、子类。

**封装：**

封装就是把类中的属性和方法定义为私有的，方法就是在属性名或方法名前加双下划线，而一旦这样定义了属性或方法名后，python会自动将其转换为_类名**属性名（方法名）的格式，在类的内部调用还是用双下划线加属性名或方法名，在类的外部调用就要用**类名_属性名（方法名）。父类的私有属性和方法，子类无法对其进行修改。

**多态：**

多态就是不同的对象可以调用相同的方法然后得到不同的结果，有点类似接口类的感觉，在python中处处体现着多态，比如不管你是列表还是字符串还是数字都可以使用+和*。


### 3、为什么Python执行速度慢，我们如何改进它？

Python代码执行缓慢的原因，是因为它是一种解释型语言。它的代码在运行时进行解释，而不是编译为本地语言。

为了提高Python代码的速度，我们可以使用CPython、Numba，或者我们也可以对代码进行一些修改。

**1、**  减少内存占用。

**2、**  使用内置函数和库。

**3、**  将计算移到循环外。

**4、**  保持小的代码库。

**5、**  避免不必要的循环


### 4、什么是Nginx

nginx是一个高性能的HTTP和反向代理服务，也是一个IMAP/POP3/SMTP服务


### 5、什么是c3算法？

c3算法是python新式类中用来产生mro顺序的一套算法。即多继承的查找规则。


### 6、什么是抽象？

抽象(Abstraction)是将一个对象的本质或必要特征向外界展示，并隐藏所有其他无关信息的过程。


### 7、MySQL常见的函数

**1、** ABS(x)：返回x的绝对值

**2、** ROUND(x)：返回参数x的四舍五入的一个整数

**3、** TRIM(str)：去除字符串两边的空白

**4、** COUNT()：返回值的个数

**5、** AVG()：返回平均值

**6、** SUM()：求和


### 8、简述SQL注入原理，以及如何在代码层面房子sql注入

通俗点讲，SQL注入的根本原因是: "用户输入数据"意外变成了代码被执行。

"用户输入数据"我这里可以指Web前端$_POST,$_GET获取的数据，也可以指从数据库获取的数据，当然也不排除程序猿无意中使用的特殊字符串。

在SQL语句的拼接中，一些含特殊字符的变量在拼接时破坏了SQL语句的结构，导致"用户输入数据"意外变成了代码被执行。

**规避方法：**

**1、** 理语句法  (解析协议层面上完全规避SQL注入)

**2、** 字符串转义（不要在sql中拼接字符）


### 9、使用yield实现一个协程

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


### 10、为什么基于tcp协议的通信比基于udp协议的通信更可靠

TCP是面向连接的传输协议，每次都需要建立一个可以相互信任的连接，中间有个三次握手过程。而UDP是面向无连接的传输协议，不需要建立安全的连接，


### 11、如何实现"1.2.3"变成['1','2','3']?
### 12、如何使用python删除一个文件或者文件夹？
### 13、使用生成器编写一个函数实现生成指定个数的斐波那契数列
### 14、Python中的pass语句是什么？
### 15、Python有哪些应用？
### 16、Redis中watch的作用
### 17、将列表按照下列规则排序：
### 18、写一个函数，计算出以下字母所代表的数字，每个字母值不一样
### 19、mro是什么？
### 20、用一行代码实现数值交换
### 21、解释一下Python中的关系运算符
### 22、*arg和**kwargs的作用
### 23、如何保证api调用时数据的安全性
### 24、如何在函数中设置一个全局变量？
### 25、解释一下Python中的赋值运算符
### 26、写一个的支持with语句的类
### 27、什么是arp协议
### 28、super的作用
### 29、下面代码的执行结果是




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
