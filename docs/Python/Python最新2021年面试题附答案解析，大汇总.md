# Python最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、求以下代码的输出结果

```python
collapse=True
processFunc=collapse and (lambda s:' '.join(s.split())) or (lambda s:s)
print(processFunc('i\tam\ntest\tproject!'))

collapse=False
processFunc=collapse and (lambda s:' '.join(s.split())) or (lambda s:s)
print(processFunc('i\tam\ntest\tproject!'))
```

答案：

> i am test project!

i       am

test    project!



### 2、解释一下Python中的//，%和 ** 运算符

//运算符执行地板除法（向下取整除），它会返回整除结果的整数部分。

```
>>> 7//2
3
```

这里整除后会返回3.5。

同样地，**执行取幂运算。a**b会返回a的b次方。

```
>>> 2**10
1024
```

最后，%执行取模运算，返回除法的余数。

```
>>> 13%7
6
>>> 3.5%1.5
0.5
```


### 3、如何判断一个对象是否可调用？哪些对象是可调用对象？如何定义一个类，使其对象本身就是可调用对象？

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


### 4、什么是粘包？出现粘包的原因？

**1、** 粘包：多个数据包被连续存储于连续的缓存中，在对数据包进行读取时由于无法确定发生方的发送边界，而采用某一估测值大小来进行数据读出，若双方的size不一致时就会使指发送方发送的若干包数据到接收方接收时粘成一包，从接收缓冲区看，后一包数据的头紧接着前一包数据的尾。

**2、** 出现粘包现象的原因是多方面的，它既可能由发送方造成，也可能由接收方造成。

**3、** 发送方引起的粘包是由TCP协议本身造成的，TCP为提高传输效率，发送方往往要收集到足够多的数据后才发送一包数据。若连续几次发送的数据都很少，通常TCP会根据优化算法把这些数据合成一包后一次发送出去，这样接收方就收到了粘包数据。

**4、** 接收方引起的粘包是由于接收方用户进程不及时接收数据，从而导致粘包现象。这是因为接收方先把收到的数据放在系统接收缓冲区，用户进程从该缓冲区取数据，若下一包数据到达时前一包数据尚未被用户进程取走，则下一包数据放到系统接收缓冲区时就接到前一包数据之后，而用户进程根据预先设定的缓冲区大小从系统接收缓冲区取数据，这样就一次取到了多包数据。


### 5、索引再什么情况下遵循最左前缀的规则？

在多字段进行索引的时候，会遵循以上原则


### 6、实现一个单例模式。(尽可能多的方法)

```python
# 方法一：使用__new__()
import threading
class Singleton(object):
_instance_lock = threading.Lock()
def __init__(self):
pass

def __new__(cls, *args, **kwargs):
if not hasattr(Singleton, "_instance"):
with Singleton._instance_lock:
    if not hasattr(Singleton, "_instance"):
        Singleton._instance = object.__new__(cls)
return Singleton._instance

obj1 = Singleton()
obj2 = Singleton()
print(obj1 is obj2)

# 方法二：使用元类来创建
import threading

class SingletonType(type):
_instance_lock = threading.Lock()
def __call__(cls, *args, **kwargs):
if not hasattr(cls, "_instance"):
with SingletonType._instance_lock:
    if not hasattr(cls, "_instance"):
        cls._instance = super().__call__(*args, **kwargs)
return cls._instance

class Singleton(metaclass=SingletonType):
def __init__(self):
pass

obj1 = Singleton()
obj2 = Singleton()
print(obj1 is obj2)
```


### 7、什么是轮询和长轮询

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


### 8、了解过Hbase，DB2，SQLServer，Access吗

**1、** Hbase：HBase是一个分布式的、面向列的开源数据库

**2、** DB2：一套关系型数据库管理系统，

**3、** SQLServer：SQL Server是由Microsoft开发和推广的关系数据库管理系统

**4、** Sccess：Access是由微软发布的关系数据库管理系统。


### 9、路由器和交换机的区别

交换机是一种用于电信号转发的网络设备。路由器是链接因特网中各局域网和广域网的设备。

区别

**1、** 交换机工作在第二层，数据链路层，路由器工作在第三层，网络层。

**2、** 路由器提供防火墙服务。

**3、** 传统交换机只能风格冲突域，不能分割广播域，二路由器可以分割广播域。


### 10、python的底层网络交互模块有哪些

socket，urllib，requests，pycurl


### 11、logging模块的作用以及应用场景
### 12、json序列化时可以处理的数据类型有哪些？如何定制支持datetime类型？序列化时，遇到中文转成unicode，如何保持中文形式？
### 13、解释Python中的help()和dir()函数
### 14、实现一个装饰器，通过一次调用，使函数重复执行5次
### 15、什么是闭包
### 16、前后端分离的基本原理
### 17、什么是switch语句。如何在Python中创建switch语句？
### 18、讲讲Python中的位运算符
### 19、对字典d={'a':30,'g':17,'b':25,'c':18,'d':50,'e':36,'f':57,'h':25}按照value字段进行排序
### 20、什么是keepalived
### 21、编写程序，检查序列是否为回文
### 22、什么是gevent
### 23、py2项目如何迁移成py3
### 24、DNS域名解析过程
### 25、列举常见的关系型数据库和非关系型数据库。
### 26、vuex的作用
### 27、Python代码是如何执行的？
### 28、类的加载和实例化过程
### 29、深拷贝和浅拷贝之间的区别是什么？
### 30、css如何隐藏一个元素




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
