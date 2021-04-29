# Python最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、生成器与函数的区别？

生成器和函数的主要区别在于函数 return a value，生成器 yield a value同时标记或记忆point of the yield 以便于在下次调用时从标记点恢复执行。 yield 使函数转换成生成器，而生成器反过来又返回迭代器。

```python
# 简单实现生成器
def dec():
n=0
for i in range(10):
yield n
n+=i

for i in dec():
print(i)
```


### 2、使用两个队列实现一个栈

```python
class Stack(object):
def __init__(self):
self.queueA=[]
self.queueB=[]
def push(self,node):
self.queueA.append(node)
def pop(self):
if len(self.queueA)==0:
return None
while len(self.queueA)!=1:
self.queueB.append(self.queueA.pop(0))
self.queueA,self.queueB=self.queueB,self.queueA
return self.queueB.pop()

st=Stack()
print(st.pop())
st.push(1)
print(st.pop())
st.push(1)
st.push(1)
st.push(1)
print(st.pop())
print(st.pop())
print(st.pop())
```

注意上面两个栈的实现方法，第一种的效率高，队列的这种方法效率低


### 3、如何以就地操作方式打乱一个列表的元素？

为了达到这个目的，我们从random模块中导入shuffle()函数。

```
>>> from random import shuffle
>>> shuffle(mylist)
>>> mylist
```

运行结果：

```
[3, 4, 8, 0, 5, 7, 6, 2, 1]
```


### 4、什么是Python？为什么它会如此流行？

Python是一种解释的、高级的、通用的编程语言。

Python的设计理念是通过使用必要的空格与空行，增强代码的可读性。

它之所以受欢迎，就是因为它具有简单易用的语法。


### 5、Redis默认多少个db

默认有16个数据库


### 6、xrange和range的区别

xrange和range用法相同，但是xrange是一个生成器，range结果是一个列表。xrange做循环的时候性能比range好。


### 7、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？

对的


### 8、使用python将数据库的student表中的数据写入db.txt

```python
import pyMySQL
connect=pyMySQL.Connect(
host='',
port=,
user='',
passwd='',
db='',
charset='',
)

cursor=connect.cursor()
sql='select from student'
cursor.execute(sql)
students=cursor.fetchall()

with open('db.txt','w') as f:
for student in students:
f.write(student)

cursor.close()
connect.close()
```


### 9、super的作用

当子类中的方法与父类中的方法重名时，子类中的方法会覆盖父类中的方法，那么，如果我们想实现同时调用父类和子类中的同名方法，就需要使用到super()这个函数，用法为super().函数名()


### 10、在Python中如何实现多线程？

一个线程就是一个轻量级进程，多线程能让我们一次执行多个线程。我们都知道，Python是多线程语言，其内置有多线程工具包。

Python中的GIL（全局解释器锁）确保一次执行单个线程。一个线程保存GIL并在将其传递给下个线程之前执行一些操作，这会让我们产生并行运行的错觉。但实际上，只是线程在CPU上轮流运行。当然，所有的传递会增加程序执行的内存压力。


### 11、实现一个装饰器，限制该函数被调用的频率，如10秒一次
### 12、Redis是单进程单线程的吗？
### 13、什么是防火墙？防火墙的作用是什么？
### 14、写出邮箱的正则表达式
### 15、python的可变类型和不可变类型的区别
### 16、类的加载和实例化过程
### 17、进程之间如何进行通信？
### 18、简述数据库分库分表
### 19、什么时GIL锁
### 20、编写一个函数实现十进制转62进制，分别用0-9A-Za-z,表示62位字母
### 21、Python中的pass语句是什么？
### 22、什么是LVS
### 23、Python中的单引号和双引号有什么区别？
### 24、filter、map、reduce的作用。
### 25、如何在Python中管理内存？
### 26、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序
### 27、TCP和UDP的区别
### 28、Redis中sentinel的作用
### 29、yield from 和 yield 的区别
### 30、解释Python中map()函数？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
