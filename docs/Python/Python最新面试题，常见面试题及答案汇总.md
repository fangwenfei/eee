# Python最新面试题，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、获取python解释器版本的方法

终端执行python -V


### 2、简述线程死锁是怎么造成的。如何避免？

**1、** 死锁的产生原因？

**2、** 系统资源的竞争

**3、** 进程运行推进顺序不当

**4、** 解决死锁

**5、** 加锁顺序：线程按照一定的顺序加锁

**6、** 加锁时限：线程尝试获取锁的时候加上一定的时限，超过时限，则放弃对该锁的请求，并释放自己占有的锁。

**7、** 死锁检测


### 3、路由器和交换机的区别

交换机是一种用于电信号转发的网络设备。路由器是链接因特网中各局域网和广域网的设备。

区别

**1、** 交换机工作在第二层，数据链路层，路由器工作在第三层，网络层。

**2、** 路由器提供防火墙服务。

**3、** 传统交换机只能风格冲突域，不能分割广播域，二路由器可以分割广播域。


### 4、Python中append，insert和extend的区别?

append：在列表末尾添加新元素。

insert：在列表的特定位置添加元素。

extend：通过添加新列表来扩展列表。

```
numbers = [1,2,3,4,5]
numbers.append(6)
print(numbers)
>[1,2,3,4,5,6]

## insert(position,value)
numbers.insert(2,7)  
print(numbers)
>[1,2,7,4,5,6]

numbers.extend([7,8,9])
print(numbers)
>[1,2,7,4,5,6,7,8,9]

numbers.append([4,5])
>[1,2,7,4,5,6,7,8,9,[4,5]]
```


### 5、编写一个函数，找出数组中没有重复的值的和

```python
def func(lis):
lis1=[]
del_lis=[]
for i in lis:
if i not in lis1:
if i not in del_lis:
    lis1.append(i)
else:
del_lis.append(i)
lis1.remove(i)
return sum(lis1)

def func2(lis):
return sum([i for i in set(lis) if lis.count(i)==1])

print(func2([3,4,1,2,5,6,6,5,4,3,3]))
```


### 6、python中如何使用进程池和线程池

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


### 7、数据库的导入与导出命令

**1、** 导出(MySQLdump)

**2、** 导出数据和表结构

**3、** MySQLdump -uroot -p dbname > dbname .sql

**4、** 只导出表结构

**5、** MySQLdump -uroot -p -d dbname > dbname .sql

6、导入

**7、** MySQL -u用户名 -p密码 数据库名 < 数据库名.sql


### 8、公司线上和开发环境使用的什么系统

线上用的centos和Ubuntu系统

开发环境用的windows，mac，还有Ubuntu。


### 9、手写一个队列

```python
class Queue(object):
def __init__(self,size):
self.queue=[]
self.size=size
def is_empty(self):
return not bool(len(self.queue))
def is_full(self):
return len(self.queue)==self.size
def enqueue(self,val):
if not self.is_full():
self.queue.insert(0,val)
return True
return False
def dequeue(self):
if not self.is_empty():
return self.queue.pop()
return None
s=Queue(2)
print(s.is_empty)
s.enqueue(1)
s.enqueue(2)
print(s.is_full())
print(s.dequeue())
print(s.dequeue())
print(s.is_empty())
```


### 10、一行代码实现删除列表中的所有的重复的值

```python
lis=[1,1,2,1,22,5]
lis=list(set(lis))
```


### 11、你了解哪些数据库优化方案
### 12、如何实现"1.2.3"变成['1','2','3']?
### 13、如何实现字符串的反转？如：name=felix，反转成name=xilef
### 14、简述进程，线程，协程的区别以及应用场景？
### 15、在Python中是如何管理内存的？
### 16、python中进制转换
### 17、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？
### 18、python哪些类型的数据才能作为字典的key？
### 19、JavaScript(或者jQuery)如何选择一个id为main的容器
### 20、Python中OOPS是什么？
### 21、python和java、php、c、c#、c++ 等其他语言对比？
### 22、解释Python中的Filter？
### 23、如何判断一个值是方法还是函数？
### 24、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今
### 25、实现一个单例模式。(尽可能多的方法)
### 26、MySQL慢日志
### 27、axios的作用
### 28、实现99乘法表（使用两种方法）
### 29、什么是负索引？
### 30、Python中的pass语句是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
