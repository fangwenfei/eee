# Python最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、写出邮箱的正则表达式

```python
import re
pp=re.compile('[a-zA-Z0-9_-]+@[0-9A-Za-z]+(\.[0-9a-zA-Z]+)+')
if pp.match('1403179190@qq.com'):
print('ok')
```


### 2、解释Python中的help()和dir()函数

Help()函数是一个内置函数，用于查看函数或模块用途的详细说明：

```
>>> import copy
>>> help(copy.copy)
```

运行结果为：

```
Help on function copy in module copy:

 
 
copy(x)
 
Shallow copy operation on arbitrary Python objects.
 
See the module’s __doc__ string for more info.
```

Dir()函数也是Python内置函数，dir() 函数不带参数时，返回当前范围内的变量、方法和定义的类型列表；带参数时，返回参数的属性、方法列表。

以下实例展示了 dir 的使用方法：

```
>>> dir(copy.copy)
```

运行结果为：

```
[‘__annotations__’, ‘__call__’, ‘__class__’, ‘__closure__’, ‘__code__’, ‘__defaults__’, ‘__delattr__’, ‘__dict__’, ‘__dir__’, ‘__doc__’, ‘__eq__’, ‘__format__’, ‘__ge__’, ‘__get__’, ‘__getattribute__’, ‘__globals__’, ‘__gt__’, ‘__hash__’, ‘__init__’, ‘__init_subclass__’, ‘__kwdefaults__’, ‘__le__’, ‘__lt__’, ‘__module__’, ‘__name__’, ‘__ne__’, ‘__new__’, ‘__qualname__’, ‘__reduce__’, ‘__reduce_ex__’, ‘__repr__’, ‘__setattr__’, ‘__sizeof__’, ‘__str__’, ‘__subclasshook__’]
```


### 3、Redis中watch的作用

**1、** watch 用于在进行事务操作的最后一步也就是在执行exec 之前对某个key进行监视

**2、** 如果这个被监视的key被改动，那么事务就被取消，否则事务正常执行.

**3、** 一般在MULTI 命令前就用watch命令对某个key进行监控.如果想让key取消被监控，可以用unwatch命令


### 4、列举常见的关系型数据库和非关系型数据库。

**1、** 关系型数据库：Oracle、DB2、Microsoft SQL Server、Microsoft Access、MySQL

**2、** 非关系型数据库：mongodb，Redis，elasticsearch，NoSql


### 5、什么是轮询和长轮询

轮询是在特定的的时间间隔（如每1秒），由浏览器对服务器发出HTTP request，然后由服务器返回最新的数据给客户端的浏览器。这种传统的HTTP request 的模式带来很明显的缺点 – 浏览器需要不断的向服务器发出请求，然而HTTP request 的header是非常长的，里面包含的有用数据可能只是一个很小的值，这样会占用很多的带宽。

```javascript
var xhr = new XMLHttpRequest();
setInterval(function() {
    xhr.open('GET', '/user');
    xhr.onreadystatechange = function() {};
    xhr.send();
}, 1000)
```

长轮询是ajax实现:在发送ajax后,服务器端会阻塞请求直到有数据传递或超时才返回。 客户端JavaScript响应处理函数会在处理完服务器返回的信息后，再次发出请求，重新建立连接。

```javascript
function ajax() {
    var xhr = new XMLHttpRequest();
    xhr.open('GET', '/user');
    xhr.onreadystatechange = function() {
        ajax();
    };
    xhr.send();
}
```


### 6、什么是gevent

gevent是一个pythn网络框架，它为各种并发和网络相关的任务提供了整洁的API


### 7、进程之间如何进行通信？

**1、** 共享内存

通过mmap模块实现

2、信号

**3、** 通过Queue队列

**4、** 通过Pipe管道

**5、** 通过socket


### 8、输入一个字符串，输出该字符串的字符的所有组合。如输入'abc',输出a,b,c,ab,ac,bc,abc.
### 9、MySQL常见的函数
### 10、break、continue、pass是什么？
### 11、如何保证api调用时数据的安全性
### 12、你了解哪些数据库优化方案
### 13、什么是C/S和B/S架构
### 14、re的match和search的区别
### 15、Python中的标识符长度能有多长？
### 16、or 和 and
### 17、解释一下Python中的继承？
### 18、求下面代码结果
### 19、简述线程死锁是怎么造成的。如何避免？
### 20、_init_在Python中有什么用？
### 21、判断dict中有没有某个key。
### 22、三元运算编写格式
### 23、是否使用过functools中的函数？他的作用是什么？
### 24、什么是pickling和unpickling？
### 25、解释一下Python中的关系运算符
### 26、vue中的路由拦截器的作用
### 27、Python中注释代码的方法有哪些？
### 28、1，2，3，4，5能组成多少个互不相同且不重复的三位数？
### 29、threading.local的作用
### 30、TCP和UDP的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
