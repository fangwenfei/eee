# Python最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、python中如何使用进程池和线程池

```python
from concurrent.futures import ThreadPoolExecutor,ProcessPoolExecutor
import os,time,random
from multiprocessing import Pool

def task(n):
print('%s is runing' %os.getpid())
time.sleep(random.randint(1,3))
return n**2

if __name__ == '__main__':
# 多进程方式一
pool2=Pool()
pool2.map(task,range(10))

# 多进程方式二，下面这种多进程和多线程的用法一模一样
executor=ThreadPoolExecutor(max_workers=3)
futures=[]
for i in range(11):
future=executor.submit(task,i)
futures.append(future)
executor.shutdown(True)
print('+++>')
for future in futures:
print(future.result())
```


### 2、简述数据库的读写分离

读写分离就是在主服务器上修改，数据会同步到从服务器，从服务器只能提供读取数据，不能写入，实现备份的同时也实现了数据库性能的优化，以及提升了服务器安全。


### 3、ascii、Unicode、utf-8、gbk的区别

**1、** ascii 是最早美国用的标准信息交换码，把所有的字母的大小写，各种符号用 二进制来表示，共有256中，加入些拉丁文等字符，1bytes代表一个字符

**2、** Unicode是为了统一世界各国语言的不用，统一用2个bytes代表一个字符，可以表达2^16=65556个，称为万国语言，特点：速度快，但浪费空间

**3、** utf-8 为了改变Unicode的这种缺点，规定1个英文字符用1个字节表示，1个中文字符用3个字节表示，特点；节省空间，速度慢，用在硬盘数据传输，网络数据传输，相比硬盘和网络速度，体现不出来的

**4、** gbk  是中文的字符编码，用2个字节代表一个字符


### 4、pass的使用

通常用来标记一个还未写的代码的位置，pass不做任何事情，一般用来做占位语句，保持程序结构的完整性


### 5、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。

```python
a='aaabbcccdddde'
aa=''
for i in sorted(list(set(a)),key=a.index):
aa=aa+i+str(a.count(i))
print(aa)
```


### 6、什么是asyncio

asyncio是并发的一种方式，是一个协程相关的库。也叫异步IO


### 7、解释Python中的Filter？

过滤器函数，根据某些条件从可迭代对象中筛选值。

```
# iterable
lst = [1,2,3,4,5,6,7,8,9,10]

def even(num):
    if num%2==0:
        return num

# filter all even numbers
list(filter(even,lst))
---------------------------------------------
[2, 4, 6, 8, 10]
```


### 8、什么是鸭子模型？

鸭子类型（英语：duck typing）是动态类型的一种风格。在这种风格中，一个对象有效的语义，不是由继承自特定的类或实现特定的接口，而是由当前方法和属性的集合决定。


### 9、解释Python的内置数据结构？

Python中主要有四种类型的数据结构。

列表：列表是从整数到字符串甚至另一个列表的异构数据项的集合。列表是可变的。列表完成了其他语言中大多数集合数据结构的工作。列表在[ ]方括号中定义。

例如：a = [1,2,3,4]

集合：集合是唯一元素的无序集合。集合运算如联合|，交集&和差异，可以应用于集合。集是不可变的。()用于表示一个集合。

例如：a = {1,2,3,4}

元组：Python元组的工作方式与Python列表完全相同，只是它们是不可变的。()用于定义元组。

例如：a =（1,2,3,4）

字典：字典是键值对的集合。它类似于其他语言中的hash map。在字典里，键是唯一且不可变的对象。

例如：a = {'number'：[1,2,3,4]}


### 10、编写一个函数实现十进制转62进制，分别用0-9A-Za-z,表示62位字母

```python
import string
print(string.ascii_lowercase) # 小写字母
print(string.ascii_uppercase) # 大写字母
print(string.digits) # 0-9

s=string.digits+string.ascii_uppercase+string.ascii_lowercase
def _10_to_62(num):
ss=''
while True:
ss=s[num%62]+ss
if num//62==0:
break
num=num//62
return ss
print(_10_to_62(65))
```


### 11、请列出至少5个PEP8规范
### 12、什么是负载均衡
### 13、解释一下Python中的继承
### 14、什么是域名解析
### 15、什么是覆盖索引
### 16、比较：a=[1,2,3]和b=[(1),(2),(3)]以及c=[(1,),(2,),(3,)]的区别
### 17、char和varchar的区别
### 18、Python是否有main函数？
### 19、如何在Python中管理内存？
### 20、编写一个函数，找出数组中没有重复的值的和
### 21、请写一个Python逻辑，计算一个文件中的大写字母数量
### 22、Redis默认多少个db
### 23、!=和is not运算符的区别？
### 24、re的match和search的区别
### 25、python和java、php、c、c#、c++ 等其他语言对比？
### 26、简述生成器，迭代器，装饰器以及应用场景
### 27、在python中如何拷贝一个对象，并说明他们之间的区别
### 28、求下面代码结果
### 29、解释什么是异步非阻塞
### 30、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
