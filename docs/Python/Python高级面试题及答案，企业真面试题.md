# Python高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、怎样声明多个变量并赋值？

一共有两种方式：

```
>>> a,b,c=3,4,5 #This assigns 3, 4, and 5 to a, b, and c respectively
>>> a=b=c=3 #This assigns 3 to a, b, and c
```


### 2、Python中的Map Function是什么？

map函数在对可迭代对象的每一项应用特定函数后，会返回map对象。


### 3、*arg和**kwargs的作用

用来接收不确定个数的参数，*args通常用来接收不确定个数的非关键字参数，而**kwargs通常用来接收不确定个数的关键字参数


### 4、使用async语法实现一个协程

```python
import asyncio
import time

now = lambda : time.time()

async def hello():
print("hello")
await asyncio.sleep(2)
return "done"

start = now()
# 协程对象
h1 = hello()
h2 = hello()
h3 = hello()

# 创建一个事件loop
loop = asyncio.get_event_loop()
# 任务（task）对象
tasks = [
asyncio.ensure_future(h1),
asyncio.ensure_future(h2),
asyncio.ensure_future(h3),
]

# 将协程加入到事件循环loop
loop.run_until_complete(asyncio.wait(tasks))
for task in tasks:
print(task.result())

print(now()-start)
```


### 5、解释*args和**kwargs？

*args，是当我们不确定要传递给函数参数的数量时使用的。

```
def add（* num）：
    sum = 0 
    for val in num：
        sum = val + sum 
    print（sum）


add（4,5）
add（7,4,6）
add（10,34,23）
--------------------- 
9 
17 
57
```

**kwargs，是当我们想将字典作为参数传递给函数时使用的。

```
def intro(**data):
    print("\nData type of argument:",type(data))
    for key, value in data.items():
        print("{} is {}".format(key,value))


intro(name="alex",Age=22, Phone=1234567890)
intro(name="louis",Email="a@gmail.com",Country="Wakanda", Age=25)
--------------------------------------------------------------
Data type of argument: <class 'dict'>
name is alex
Age is 22
Phone is 1234567890

Data type of argument: <class 'dict'>
name is louis
Email is a@gmail.com
Country is Wakanda
Age is 25
```


### 6、请列举布尔值位False的常见值

0、''、[]、{}、tuple()、None、set()


### 7、双下划线和单下划线的区别

**1、** "单下划线" 开始的成员变量叫做保护变量，意思是只有类对象和子类对象自己能访问到这些变量；

**2、** "双下划线" 开始的是私有成员，意思是只有类对象自己能访问，连子类对象也不能访问到这个数据。


### 8、简述TCP三次握手，四次挥手的流程。

**三次握手**

**1、** 第一次握手：客户端的应用进程主动打开，并向客户端发出请求报文段。其首部中：SYN=1,seq=x。

**2、** 第二次握手：服务器应用进程被动打开。若同意客户端的请求，则发回确认报文，其首部中：SYN=1,ACK=1,ack=x+1,seq=y。

**3、** 第三次握手：客户端收到确认报文之后，通知上层应用进程连接已建立，并向服务器发出确认报文，其首部：ACK=1,ack=y+1。当服务器收到客户端的确认报文之后，也通知其上层应用进程连接已建立。

**四次挥手**

**1、** 第一次挥手：数据传输结束以后，客户端的应用进程发出连接释放报文段，并停止发送数据，其首部：FIN=1,seq=u。

**2、** 第二次挥手：服务器端收到连接释放报文段之后，发出确认报文，其首部：ack=u+1,seq=v。此时本次连接就进入了半关闭状态，客户端不再向服务器发送数据。而服务器端仍会继续发送。

**3、** 第三次挥手：若服务器已经没有要向客户端发送的数据，其应用进程就通知服务器释放TCP连接。这个阶段服务器所发出的最后一个报文的首部应为：FIN=1,ACK=1,seq=w,ack=u+1。

**4、** 第四次挥手：客户端收到连接释放报文段之后，必须发出确认：ACK=1,seq=u+1,ack=w+1。 再经过2MSL(最长报文端寿命)后，本次TCP连接真正结束，通信双方完成了他们的告别。


### 9、什么是socket？简述基于tcp协议的socket通信流程？

socket通常也称作"套接字"，用于描述IP地址和端口，是一个通信链的句柄。

**通信流程：**

**1、** 服务端创建一个ServerSocket对象,指定端口号,ServerSocket对象等待客户端的连接请求。

**2、** 客户端创建一个Socket对象,指定主机地址和端口号,向服务端发出连接请求。

**3、** 服务端接收到客户端的连接请求,建立一条TCP连接,再创建一个Socket对象与客户端的Socket对象进行通信。

**4、** 服务端和客户端分别创建字节输入流和字节输出流,通过字节输入流获得对方发来的数据,通过字节输出流向对方发送数据。

**5、** 当一方决定结束通信时,向对方发送结束信息;另一方接收到结束信息后,双方分别关闭各自的TCP连接。

**6、** ServerSocket对象停止等待客户端的连接请求。


### 10、a=range(10),则a[::-3]的值是？

[9,6,3,0] 或者 range(9,-1,-3)


### 11、解释一下Python中的继承
### 12、列举面向对象中带双下划线的特殊方法
### 13、IO多路复用的作用？
### 14、判断dict中有没有某个key。
### 15、Python有什么特点？
### 16、解释Python中的Filter？
### 17、如何使用python删除一个文件或者文件夹？
### 18、Redis如何实现事务
### 19、什么是鸭子模型？
### 20、什么是猴子补丁？
### 21、如何使用索引来反转Python中的字符串?
### 22、python解释器种类以及特点
### 23、MySQL执行计划的作用和使用方法
### 24、阅读以下代码，写输出结果
### 25、描述以下字典的items()方法和iteritems()方法有啥不同？
### 26、解释一下Python中的逻辑运算符
### 27、Python支持多重继承吗？
### 28、实例变量和类变量的区别
### 29、将下面列表中的元素根据位数合并成字典：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
