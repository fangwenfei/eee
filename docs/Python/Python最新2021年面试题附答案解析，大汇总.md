# Python最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、写出如下代码的输出结果

```python
def decorator_a(func):
print('Get in decorator_a')
def inner_a(*args, **kwargs):
print('Get in inner_a')
return func(*args, **kwargs)
return inner_a

def decorator_b(func):
print('Get in decorator_b')
def inner_b(*args, **kwargs):
print('Get in inner_b')
return func(*args, **kwargs)
return inner_b

@decorator_b #f=decorator_b(f)
@decorator_a #f=decorator_a(f)
def f(x):
print('Get in f')
return x 2
f(1)
```

答案

> Get in decorator_a

Get in decorator_b

Get in inner_b

Get in inner_a

Get in f


解释

> 当我们对f传入参数1进行调用时，inner_b被调用了，他会先打印Get in inner_b,然后在inner_b内部调用了inner_a,所以会再打印Get in inner_a,然后再inner_a内部调用原来的f,并且将结果作为最终的返回总结：装饰器函数在被装饰函数定义好后立即执行从下往上执行函数调用时从上到下执行



### 2、简述数据库分库分表

垂直切分

**垂直分库：**

就是根据业务耦合性，将关联度低的不同表存储在不同的数据库

**垂直分表：**

基于数据库中的"列"进行，某个表字段较多，可以新建一张扩展表，将不经常用或字段长度较大的字段拆分出去到扩展表中。

**横向切分：**

水平切分分为库内分表和分库分表，是根据表内数据内在的逻辑关系，将同一个表按不同的条件分散到多个数据库或多个表中，每个表中只包含一部分数据，从而使得单个表的数据量变小，达到分布式的效果。


### 3、如何高效的找到Redis中所有以felix开头的key

**1、** scan 0 match felixcount 5

**2、** 表示从游标0开始查询felix开头的key，每次返回5条，但是这个5条不一定


### 4、python哪些类型的数据才能作为字典的key？

可哈希的类型


### 5、如何查找一个字符串中特定的字符？find和index的差异？

使用find和index方法查找

**1、** find()方法：查找子字符串，若找到返回从0开始的下标值，若找不到返回-1

**2、** index()方法：python 的index方法是在字符串里查找子串第一次出现的位置，类似字符串的find方法，不过比find方法更好的是，如果查找不到子串，会抛出异常，而不是返回-1


### 6、break、continue、pass是什么？

break：在满足条件时，它将导致程序退出循环。

continue：将返回到循环的开头，它使程序在当前循环迭代中的跳过所有剩余语句。

pass：使程序传递所有剩余语句而不执行。


### 7、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？

对的


### 8、b、B、kB、MB、GB的关系

**1、** 1B=8b

**2、** 1kB=1024B

**3、** 1MB=1024kB

**4、** 1GB=1024MB


### 9、阅读以下代码，写输出结果

```python
lis = [2,4,5,6,7]
for i in lis:
if i % 2==0:
lis.remove(i)
print(lis)
```

结果：[4, 5, 7]


### 10、Python是否有main函数？

是的，它有的。只要我们运行Python脚本，它就会自动执行。


### 11、MySQL慢日志
### 12、什么是LVS
### 13、Python中的Map Function是什么？
### 14、生成器与函数的区别？
### 15、列举Redis支持的过期策略
### 16、实现一个单例模式。(尽可能多的方法)
### 17、python如何定义函数时如何书写可变参数和关键字参数？
### 18、Python支持多重继承吗？
### 19、什么是Twemproxy
### 20、输入某年某月某日，判断这是这一年的第几天？
### 21、什么是轮询和长轮询
### 22、如何实现"1.2.3"变成['1','2','3']?
### 23、以下代码输出什么？
### 24、简述数据库的读写分离
### 25、MySQL执行计划的作用和使用方法
### 26、ascii、Unicode、utf-8、gbk的区别
### 27、为什么学python
### 28、使用with语句的好处是什么
### 29、有两个字符串列表a和b，每个字符串是由逗号隔开的一些字符
### 30、在Python中如何实现多线程？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
