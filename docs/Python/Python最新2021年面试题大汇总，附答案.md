# Python最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Redis中默认有多少个哈希槽

**1、** 2^14个

**2、** Redis 集群没有使用一致性hash, 而是引入了哈希槽的概念。


### 2、b、B、kB、MB、GB的关系

**1、** 1B=8b

**2、** 1kB=1024B

**3、** 1MB=1024kB

**4、** 1GB=1024MB


### 3、a=range(10),则a[::-3]的值是？

[9,6,3,0] 或者 range(9,-1,-3)


### 4、在python中如何拷贝一个对象，并说明他们之间的区别

**1、** 赋值（=），就是创建了对象的一个新的引用，修改其中任意一个变量都会影响到另一个。

**2、** 浅拷贝：创建一个新的对象，但它包含的是对原始对象中包含项的引用（copy模块的copy()函数）

**3、** 深拷贝：创建一个新的对象，并且递归的复制它所包含的对象（修改其中一个，另外一个不会改变）（copy模块的deep.deepcopy()函数）


### 5、什么是C/S和B/S架构

**1、** C/S 架构是一种典型的两层架构，其全称是Client/Server，即客户端服务器端架构，其客户端包含一个或多个在用户的电脑上运行的程序，而服务器端有两种，一种是数据库服务器端，客户端通过数据库连接访问服务器端的数据；另一种是Socket服务器端，服务器端的程序通过Socket与客户端的程序通信。

**2、** B/S架构的全称为Browser/Server，即浏览器/服务器结构。Browser指的是Web浏览器，极少数事务逻辑在前端实现，但主要事务逻辑在服务器端实现，Browser客户端，WebApp服务器端和DB端构成所谓的三层架构。B/S架构的系统无须特别安装，只有Web浏览器即可。


### 6、实例方法、静态方法和类方法的区别

**1、** 实例方法：第一个参数必须是实例对象，通常为self。实例方法只能由实例对象调用。

**2、** 类方法：使用装饰器@classmethod。第一个参数为当前类的对象，通常为cls。实例对象和类对象都可以调用类方法。

**3、** 静态方法：使用装饰器@staticmethod。没有self和cls参数。方法体中不能使用类或者实例的任何属性和方法。实例对象和类对象都可以调用。


### 7、怎么移除一个字符串中的前导空格？

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


### 8、位和字节的关系

8位=一字节


### 9、写一个的支持with语句的类

[参考链接](https://www.cnblogs.com/yidashi110/p/10091991.html)

```python
class W(object):
def __init__(self):
pass
def __enter__(self):
print('进入with语句')
return self

def __exit__(self,*args,**kwargs):
print('退出with语句')

with W() as w:
print('之前')
print(w)
print('之后')
```


### 10、编写程序，输出给定序列中的所有质数

```
lower = int(input("Enter the lower range:"))
upper = int(input("Enter the upper range:"))
list(filter(lambda x:all(x % y != 0 for y in range(2, x)), range(lower, upper)))

-------------------------------------------------
Enter the lower range:10
Enter the upper range:50
[11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47]
```


### 11、traceroute使用哪种网络协议
### 12、列表和元组之间的区别是？
### 13、python代码如何获取命令行参数
### 14、python的垃圾回收机制
### 15、xrange和range的区别
### 16、什么是codis
### 17、DNS域名解析过程
### 18、解释什么是异步非阻塞
### 19、logging模块的作用以及应用场景
### 20、三元运算编写格式
### 21、使用yield实现一个协程
### 22、发生粘包现象如何处理？
### 23、列举常见的关系型数据库和非关系型数据库。
### 24、什么是鸭子模型？
### 25、简述SQL注入原理，以及如何在代码层面房子sql注入
### 26、char和varchar的区别
### 27、如何以就地操作方式打乱一个列表的元素？
### 28、解释一下Python中的继承
### 29、一行代码通过filter和lambda函数输出alist=[1,22,2,33,23,32]中索引为奇数的值
### 30、解释Python的内置数据结构？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
