# Python最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、解释re模块的split()、sub()、subn()方法？

split()：只要模式匹配，此方法就会拆分字符串。

sub()：此方法用于将字符串中的某些模式替换为其他字符串或序列。

subn()：和sub()很相似，不同之处在于它返回一个元组，将总替换计数和新字符串作为输出。

```
import re
string = "There are two ball in the basket 101"


re.split("\W+",string)
---------------------------------------
['There', 'are', 'two', 'ball', 'in', 'the', 'basket', '101']

re.sub("[^A-Za-z]"," ",string)
----------------------------------------
'There are two ball in the basket'

re.subn("[^A-Za-z]"," ",string)
-----------------------------------------
('There are two ball in the basket', 10)
```


### 2、22、iterables和iterators之间的区别？

iterable：可迭代是一个对象，可以对其进行迭代。在可迭代的情况下，整个数据一次存储在内存中。

iterators：迭代器是用来在对象上迭代的对象。它只在被调用时被初始化或存储在内存中。迭代器使用next从对象中取出元素。

```
# List is an iterable
lst = [1,2,3,4,5]
for i in lst:
    print(i)

# iterator
lst1 = iter(lst)
next(lst1)
>1
next(lst1)
>2
for i in lst1:
    print(i)
>3,4,5
```


### 3、!=和is not运算符的区别？

!=如果两个变量或对象的值不相等，则返回true。

is not是用来检查两个对象是否属于同一内存对象。

```
lst1 = [1,2,3,4]
lst2 = [1,2,3,4]

lst1 != lst2
>False

lst1 is not lst2
>True
```


### 4、Python支持多重继承吗？

Python可以支持多重继承。多重继承意味着，一个类可以从多个父类派生。


### 5、Python中的标识符长度能有多长？

在Python中，标识符可以是任意长度。此外，我们在命名标识符时还必须遵守以下规则：

**1、**   只能以下划线或者 A-Z/a-z 中的字母开头

**2、**   其余部分可以使用 A-Z/a-z/0-9

**3、**   区分大小写

**4、**   关键字不能作为标识符，Python中共有如下关键字：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/4/30/200/33/53_3.png#alt=53%5C_3.png)


### 6、请列出至少5个PEP8规范

**1、** 每个缩进级别使用4个空格

**2、** 每行代码的最大长度限制为79个字符

**3、** 若是导入多个库函数，应该分开依次导入

**4、** 道路应按照以下顺序导入

a、标准库导入

b、相关的第三方库导入

c、本地应用程序的库导入

**1、** 在表达式中避免无关的空格

**2、** 在括号或者大括号内

**3、** 在尾随逗号和后面的右括号之间

**4、** 在逗号，分号或者冒号前面

**5、** 函数名的与后面的参数的括号之间

**6、** 代码更改时，相应的注释也要随之更改

**7、** 命名要规范，通俗易懂


### 7、是否使用过functools中的函数？他的作用是什么？

**1、** functools.wraps()

在装饰器中用过，如果不使用wraps，则原始函数的**name**和**doc**的值就会丢失

**2、** functools.reduce()

第一个参数是一个函数，第二个参数是一个可迭代对象，代码如下：

```python
# 下面代码相当于从1加到9
from functools import reduce
a=reduce(lambda x,y:x+y,range(10))
print(a)
```


### 8、编写程序，检查序列是否为回文

```
a = input("Enter The sequence")
ispalindrome = a == a[::-1]

ispalindrome
>True
```


### 9、解释一下Python中的三元运算子

不像C++，我们在Python中没有?:，但我们有这个：

```
[on true] if [expression] else [on false]
```

如果表达式为True，就执行[on true]中的语句。否则，就执行[on false]中的语句。

下面是使用它的方法：

```
>>> a,b=2,3
>>> min=a if a<b else b
>>> min
```

运行结果：

```
2
```

```
>>> print("Hi") if a<b else print("Bye")
```

运行结果：

```
Hi
```


### 10、列举面向对象中带双下划线的特殊方法

```
\_\_new__：可以调用其它类的构造方法或者直接返回别的对象来作为本类的实例。
\_\_init__： 负责类的实例化
\_\_call__：对象后边加括号，触发执行
\_\_str__：print打印一个对象时。
\_\_doc__：类的注释，该属性是无法继承的。
\_\_getattr__：在使用调用属性（方式、属性）不存在的时候触发
\_\_setattr__：添加/修改属性会触发它的执行
\_\_dellattr__：删除属性的时候会触发
\_\_delete__：采用del删除属性时，触发
```


### 11、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？
### 12、query作为sql模板，args为将要传入的参数
### 13、re的match和search的区别
### 14、实例变量和类变量的区别
### 15、什么是gevent
### 16、Python区分大小写吗？
### 17、编写一个函数实现十进制转62进制，分别用0-9A-Za-z,表示62位字母
### 18、什么是轮询和长轮询
### 19、MySQL的半同步复制原理
### 20、Python中注释代码的方法有哪些？
### 21、Python有什么特点？
### 22、怎样获取字典中所有键的列表？
### 23、什么是猴子补丁？
### 24、描述以下dict的items和iteritems的区别
### 25、==和is的区别是？
### 26、有一个多层嵌套的列表A=[1,2,3,[4,1,['j1',1,[1,2,3,'aa']]]],请写一段代码将A中的元素全部打印出来
### 27、python的底层网络交互模块有哪些
### 28、一个数如果恰好等于它的因子之和，这个数就称为‘完数’，比如6=1+2+3，编程找出1000以内的所有的完数。
### 29、如果已经建立了TCP连接，但是客户端突然出现故障了怎么办
### 30、实现一个装饰器，通过一次调用，使函数重复执行5次




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
