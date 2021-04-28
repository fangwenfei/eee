# Python最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何更改列表的数据类型？

要将列表的数据类型进行更改，可以使用tuple()或者set()。

```
lst = [1,2,3,4,2]

# 更改为集合
set(lst)    ## {1,2,3,4}
# 更改为元组
tuple(lst)  ## (1,2,3,4,2)
```


### 2、用一行Python代码，从给定列表中取出所有的偶数和奇数

```
a = [1,2,3,4,5,6,7,8,9,10]
odd, even = [el for el in a if el % 2==1], [el for el in a if el % 2==0]

print(odd,even)
> ([1, 3, 5, 7, 9], [2, 4, 6, 8, 10])
```


### 3、在什么情况下y!=x-(x-y)会成立？

x，y是两个不相等的非空集合


### 4、Python中使用的zip函数是什么？

zip函数获取可迭代对象，将它们聚合到一个元组中，然后返回结果。

zip()函数的语法是zip(*iterables)

```
numbers = [1, 2, 3]
string = ['one', 'two', 'three'] 
result = zip(numbers,string)

print(set(result))
-------------------------------------
{(3, 'three'), (2, 'two'), (1, 'one')}
```


### 5、编写程序，打印斐波那契数列的前十项

```
fibo = [0,1]
[fibo.append(fibo[-2]+fibo[-1]) for i in range(8)]

fibo
> [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```


### 6、索引有什么作用，有哪些分类，有什么好处和坏处？

作用：为了增加查询速度，提高系统性能

**分类：**

**1、** 唯一索引：不允许其中任何两行具有相同索引值的索引。

**2、** 非唯一索引：允许其中任何两行具有相同索引值的索引。

**3、** 主键索引：有一列或列组合，其值唯一标识表中的每一行。

**4、** 聚集索引：表中行的物理顺序与键值的逻辑（索引）顺序相同。一个表只能包含一个聚集索引。

**好处：**

**1、** 帮助用户提高查询速度

**2、** 利用索引的唯一性来控制记录的唯一性

**3、** 可以加速表与表之间的连接

**4、** 降低查询中分组和排序的时间

**坏处：**

**1、** 存储索引占用磁盘空间

**2、** 执行数据修改操作(INSERT、UPDATE、DELETE)产生索引维护


### 7、简述多进程开发中join和deamon的区别

**1、** join：当子线程调用join时，主线程会被阻塞，当子线程结束后，主线程才能继续执行。

**2、** deamon：当子进程被设置为守护进程时，主进程结束，不管子进程是否执行完毕，都会随着主进程的结束而结束。


### 8、什么是Python中的猴子补丁？

猴子补丁(monkey patching)，是指在运行时动态修改类或模块。

```
from SomeOtherProduct.SomeModule import SomeClass

def speak(self):
    return "Hello!"

SomeClass.speak = speak
```


### 9、为什么学python

答题路线：a、python的优点，b、python的应用领域广

**具体：**

优点

**1、** python语法非常优雅，简单易学

**2、** 免费开源

**3、** 跨平台，可以自由移植

**4、** 可扩展，可嵌入性强

**5、** 第三方库丰富

**应用领域**

**1、** 在系统编程中应用广泛，比如说shell工具。

**2、** 在网络爬虫方面功能非常强大，常用的库如scrapy，request等

**3、** 在web开发中使用也很广泛，如很多大型网站都用python开发的，如ins，youtube等，常用的框架如django，flask等

**4、** python在系统运维中应用广泛，尤其在linux运维方面，基本上都是自动化运维。

**5、** 在人工智能，云计算，金融等方面也应用非常广泛。


### 10、Redis中watch的作用

**1、** watch 用于在进行事务操作的最后一步也就是在执行exec 之前对某个key进行监视

**2、** 如果这个被监视的key被改动，那么事务就被取消，否则事务正常执行.

**3、** 一般在MULTI 命令前就用watch命令对某个key进行监控.如果想让key取消被监控，可以用unwatch命令


### 11、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序
### 12、列举创建索引但是无法命中索引的情况
### 13、文件操作时，xreadlines和readlines的区别
### 14、简述python字符串的驻留机制
### 15、IO多路复用的作用？
### 16、列举你所了解的所有Python2和Python3的区别
### 17、阅读以下代码，写输出结果
### 18、简述python的深浅拷贝
### 19、列举Redis支持的过期策略
### 20、将下面列表中的元素根据位数合并成字典：
### 21、vue中的路由拦截器的作用
### 22、双下划线和单下划线的区别
### 23、数据库锁的作用
### 24、简述生成器，迭代器，装饰器以及应用场景
### 25、Python中的Map Function是什么？
### 26、元组的解封装是什么？
### 27、什么时GIL锁
### 28、如何判断一个对象是否可调用？哪些对象是可调用对象？如何定义一个类，使其对象本身就是可调用对象？
### 29、你对Python类中的self有什么了解？
### 30、解释Python中的help()和dir()函数




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
