# Python最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何基于Redis实现发布和订阅

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


### 2、编写程序，检查数字是否为Armstrong

将每个数字依次分离，并累加其立方(位数)。

最后，如果发现总和等于原始数，则称为阿姆斯特朗数(Armstrong)。

```
num = int(input("Enter the number:\n"))
order = len(str(num))

sum = 0
temp = num

while temp > 0:
   digit = temp % 10
   sum += digit ** order
   temp //= 10

if num == sum:
   print(num,"is an Armstrong number")
else:
   print(num,"is not an Armstrong number")
```


### 3、什么是Twemproxy

Twemproxy是一种代理分片机制，由Twitter开源。Twemproxy作为代理，可接受来自多个程序的访问，按照路由规则，转发给后台的各个Redis服务器，再原路返回。该方案很好的解决了单个Redis实例承载能力的问题。当然，Twemproxy本身也是单点，需要用Keepalived做高可用方案。通过Twemproxy可以使用多台服务器来水平扩张Redis服务，可以有效的避免单点故障问题。虽然使用Twemproxy需要更多的硬件资源和在Redis性能有一定的损失（twitter测试约20%），但是能够提高整个系统的HA也是相当划算的。不熟悉twemproxy的同学，如果玩过nginx反向代理或者MySQL proxy，那么你肯定也懂twemproxy了。其实twemproxy不光实现了Redis协议


### 4、简述SQL注入原理，以及如何在代码层面房子sql注入

通俗点讲，SQL注入的根本原因是: "用户输入数据"意外变成了代码被执行。

"用户输入数据"我这里可以指Web前端$_POST,$_GET获取的数据，也可以指从数据库获取的数据，当然也不排除程序猿无意中使用的特殊字符串。

在SQL语句的拼接中，一些含特殊字符的变量在拼接时破坏了SQL语句的结构，导致"用户输入数据"意外变成了代码被执行。

**规避方法：**

**1、** 理语句法  (解析协议层面上完全规避SQL注入)

**2、** 字符串转义（不要在sql中拼接字符）


### 5、如何查找一个字符串中特定的字符？find和index的差异？

使用find和index方法查找

**1、** find()方法：查找子字符串，若找到返回从0开始的下标值，若找不到返回-1

**2、** index()方法：python 的index方法是在字符串里查找子串第一次出现的位置，类似字符串的find方法，不过比find方法更好的是，如果查找不到子串，会抛出异常，而不是返回-1


### 6、Python代码是如何执行的？

首先，解释器读取Python代码并检查是否有语法或格式错误。

如果发现错误，则暂停执行。如果没有发现错误，则解释器会将Python代码转换为等效形式或字节代码。

然后将字节码发送到Python虚拟机(PVM)，这里Python代码将被执行，如果发现任何错误，则暂停执行，否则结果将显示在输出窗口中。

![90_1.png][90_1.png]


### 7、python代码如何获取命令行参数

[获取命令行参数的方法参考](https://www.cnblogs.com/ouyangpeng/p/8537616.html)

**1、** 使用sys模块

通过sys.argv来获取

**2、** 使用getopt模块


### 8、vuex的作用

**1、** 组件之间的数据通信

**2、** 使用单向数据流的方式进行数据的去中心化管理


### 9、在python中如何拷贝一个对象，并说明他们之间的区别

**1、** 赋值（=），就是创建了对象的一个新的引用，修改其中任意一个变量都会影响到另一个。

**2、** 浅拷贝：创建一个新的对象，但它包含的是对原始对象中包含项的引用（copy模块的copy()函数）

**3、** 深拷贝：创建一个新的对象，并且递归的复制它所包含的对象（修改其中一个，另外一个不会改变）（copy模块的deep.deepcopy()函数）


### 10、有如下代码：

```python
import copy
a=[1,2,3,[4,5],6]
b=a
c=copy.copy(a)
d=copy.deepcopy(a)
b.append(10)
c[3].append(11)
d[3].append(12)
```

求a，b，c，d

**答案：**

> a：[1, 2, 3, [4, 5, 11], 6, 10]

b：[1, 2, 3, [4, 5, 11], 6, 10]

c：[1, 2, 3, [4, 5, 11], 6]

d：[1, 2, 3, [4, 5, 12], 6]



### 11、输入某年某月某日，判断这是这一年的第几天？
### 12、GIL锁对python性能的影响
### 13、讲讲Python中的位运算符
### 14、MySQL常见数据库引擎及区别
### 15、如何用一行代码生成[1,4,9,16,25,36,49,64,81,100]?
### 16、axios的作用
### 17、解释什么是异步非阻塞
### 18、求以下代码的输出结果
### 19、Redis中默认有多少个哈希槽
### 20、threading.local的作用
### 21、traceroute使用哪种网络协议
### 22、如何保证api调用时数据的安全性
### 23、简述解释型和编译型编程语言
### 24、为何不建议以下划线作为标识符的开头
### 25、写一个函数，计算出以下字母所代表的数字，每个字母值不一样
### 26、python的底层网络交互模块有哪些
### 27、求下面代码结果
### 28、编写程序，计算文件中单词的出现频率
### 29、当退出Python时，是否释放全部内存？
### 30、请列出至少5个PEP8规范




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
