# Python最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何实现"1.2.3"变成['1','2','3']?

```python
s="1,2,3"
s=s.split(',')
```


### 2、位和字节的关系

8位=一字节


### 3、为何不建议以下划线作为标识符的开头

因为Python并没有私有变量的概念，所以约定速成以下划线为开头来声明一个变量为私有。所以如果你不想让变量私有，就不要使用下划线开头。


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


### 5、Redis默认多少个db

默认有16个数据库


### 6、什么是twisted框架

twisted是用python实现的基于事件驱动的网络引擎框架。


### 7、JavaScript(或者jQuery)如何选择一个id为main的容器

**1、** jquery：$('#id')

**2、** JavaScript：document.getElementById("id"))


### 8、字节码和机器码的区别
### 9、什么时GIL锁
### 10、什么是闭包
### 11、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。
### 12、什么是switch语句。如何在Python中创建switch语句？
### 13、lambda表达式格式以及应用场景？
### 14、解释一下Python中的赋值运算符
### 15、什么是抽象？
### 16、Python代码是如何执行的？
### 17、vuex的作用
### 18、filter、map、reduce的作用。
### 19、下面代码的执行结果是
### 20、如何高效的找到Redis中所有以felix开头的key
### 21、python的垃圾回收机制
### 22、怎样获取字典中所有键的列表？
### 23、使用生成器编写一个函数实现生成指定个数的斐波那契数列
### 24、解释*args和**kwargs？
### 25、类和对象有什么区别？
### 26、Python中的闭包是什么？
### 27、什么是索引合并
### 28、解释//、％、* *运算符？
### 29、一个数如果恰好等于它的因子之和，这个数就称为‘完数’，比如6=1+2+3，编程找出1000以内的所有的完数。
### 30、公司线上和开发环境使用的什么系统




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
