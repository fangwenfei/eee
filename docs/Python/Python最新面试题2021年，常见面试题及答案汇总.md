# Python最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、发生粘包现象如何处理？

**1、** 对于发送方引起的粘包现象，用户可通过编程设置来避免，TCP提供了强制数据立即传送的操作指令push，TCP软件收到该操作指令后，就立即将本段数据发送出去，而不必等待发送缓冲区满；

**2、** 对于接收方引起的粘包，则可通过优化程序设计、精简接收进程工作量、提高接收进程优先级等措施，使其及时接收数据，从而尽量避免出现粘包现象；

**3、** 由接收方控制，将一包数据按结构字段，人为控制分多次接收，然后合并，通过这种手段来避免粘包。


### 2、Python有哪些应用？

**1、**  Web开发

**2、**  桌面GUI开发

**3、**  人工智能和机器学习

**4、**  软件开发

**5、**  业务应用程序开发

**6、**  基于控制台的应用程序

**7、**  软件测试

**8、**  Web自动化

**9、**  基于音频或视频的应用程序

**10、**  图像处理应用程序


### 3、路由器和交换机的区别

交换机是一种用于电信号转发的网络设备。路由器是链接因特网中各局域网和广域网的设备。

区别

**1、** 交换机工作在第二层，数据链路层，路由器工作在第三层，网络层。

**2、** 路由器提供防火墙服务。

**3、** 传统交换机只能风格冲突域，不能分割广播域，二路由器可以分割广播域。


### 4、如何更改列表的数据类型？

要将列表的数据类型进行更改，可以使用tuple()或者set()。

```
lst = [1,2,3,4,2]

# 更改为集合
set(lst)    ## {1,2,3,4}
# 更改为元组
tuple(lst)  ## (1,2,3,4,2)
```


### 5、什么是域名解析

域名解析是把域名指向网站空间IP，让人们通过注册的域名可以方便地访问到网站一种服务。IP地址是网络上标识站点的数字地址，为方便记忆，采用域名来代替IP地址标识站点地址。域名解析就是域名到IP地址的转换过程。


### 6、Python是否有main函数？

是的，它有的。只要我们运行Python脚本，它就会自动执行。


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


### 8、Python有什么特点？

**1、**  易于编码

**2、**  免费和开源语言

**3、**  高级语言

**4、**  易于调试

**5、**  OOPS支持

**6、**  大量的标准库和第三方模块

**7、**  可扩展性(我们可以用C或C++编写Python代码)

**8、**  用户友好的数据结构


### 9、简述进程，线程，协程的区别以及应用场景？

**区别：**

**1、** 线程是资源分配的单位

**2、** 线程是操作系统调度的单位

**3、** 进程切换需要的资源很大，效率很低

**4、** 线程切换需要的资源一般，效率一般(在不考虑GIL的情况下

**5、** 协程切换任务资源很小，效率高

**6、** 多进程，多线程根据cpu核数不一样可能是并行的，但是协程是在一个线程中，所以是并发。)

**应用场景**

**1、** 协程：当程序中存在大量不需要cpu的操作时，适用协程

**2、** 计算密集型，用进程。IO密集型，用线程。


### 10、文件操作时，xreadlines和readlines的区别

**1、** xreadlines返回的是一个生成器

**2、** readlines返回的是一个列表


### 11、简述多进程开发中join和deamon的区别
### 12、解释一下Python中的成员运算符
### 13、当退出Python时，是否释放全部内存？
### 14、求以下代码结果：
### 15、什么是索引合并
### 16、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。
### 17、什么是lambda函数？
### 18、写出如下代码的输出结果
### 19、如何判断一个值是方法还是函数？
### 20、什么是断言(assert)?应用场景？
### 21、MySQL的建表语句
### 22、什么是Nginx
### 23、什么是覆盖索引
### 24、GIL锁对python性能的影响
### 25、简述事务及其特性
### 26、什么是switch语句。如何在Python中创建switch语句？
### 27、22、iterables和iterators之间的区别？
### 28、如何使用索引来反转Python中的字符串?
### 29、解释Python中map()函数？
### 30、==和is的区别是？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
