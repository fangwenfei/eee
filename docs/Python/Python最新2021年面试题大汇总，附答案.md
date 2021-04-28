# Python最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、编写程序，打印斐波那契数列的前十项

```
fibo = [0,1]
[fibo.append(fibo[-2]+fibo[-1]) for i in range(8)]

fibo
> [0, 1, 1, 2, 3, 5, 8, 13, 21, 34]
```


### 2、简述解释型和编译型编程语言

**1、** 解释型语言编写的程序不需要编译，在执行的时候，专门有一个解释器能够将VB语言翻译成机器语言，每个语句都是执行的时候才翻译。这样解释型语言每执行一次就要翻译一次，效率比较低。

**2、** 用编译型语言写的程序执行之前，需要一个专门的编译过程，通过编译系统，把源高级程序编译成为机器语言文件，翻译只做了一次，运行时不需要翻译，所以编译型语言的程序执行效率高，但也不能一概而论，部分解释型语言的解释器通过在运行时动态优化代码，甚至能够使解释型语言的性能超过编译型语言。


### 3、介绍一下try except的用法和作用？

主要用来处理异常

**完整用法如下：**

```python
try:
     Normal execution block
except A:
     Exception A handle
except B:
     Exception B handle
except:
     Other exception handle
else:
     if no exception,get here
finally:
     print("finally")
```


### 4、编写程序，查找文本文件中最长的单词

```
def longest_word(filename):
    with open(filename, 'r') as infile:
              words = infile.read().split()
    max_len = len(max(words, key=len))
    return [word for word in words if len(word) == max_len]

print(longest_word('test.txt'))
----------------------------------------------------
['comprehensions']
```


### 5、MySQL常见数据库引擎及区别

**1、** InnoDB：用于事务处理应用程序，具有众多特性，包括ACID事务支持。(提供行级锁)

**2、** MyISAM：默认的MySQL插件式存储引擎，它是在Web、数据仓储和其他应用环境下最常使用的存储引擎之一。注意，通过更改STORAGE_ENGINE配置变量，能够方便地更改MySQL服务器的默认存储引擎。

**3、** Memory：将所有数据保存再RAM中


### 6、什么是c3算法？

c3算法是python新式类中用来产生mro顺序的一套算法。即多继承的查找规则。


### 7、sys.path.append('xxx')的作用

添加搜索路径


### 8、怎样获取字典中所有键的列表？

使用 keys() 获取字典中的所有键

```
>>> mydict={'a':1,'b':2,'c':3,'e':5}
>>> mydict.keys()
dict_keys(['a', 'b', 'c', 'e'])
```


### 9、类和对象有什么区别？

类(Class)被视为对象的蓝图。类中的第一行字符串称为doc字符串，包含该类的简短描述。

在Python中，使用class关键字可以创建了一个类。一个类包含变量和成员组合，称为类成员。

对象(Object)是真实存在的实体。在Python中为类创建一个对象，我们可以使用obj = CLASS_NAME()

例如：obj = num()

使用类的对象，我们可以访问类的所有成员，并对其进行操作。

```
class Person:
    """ This is a Person Class"""
    # varable
    age = 10
    def greets(self):
        print('Hello')


# object
obj = Person()
print(obj.greet)
----------------------------------------
Hello
```


### 10、*arg和**kwargs的作用

用来接收不确定个数的参数，*args通常用来接收不确定个数的非关键字参数，而**kwargs通常用来接收不确定个数的关键字参数


### 11、Python代码是如何执行的？
### 12、python中进制转换
### 13、什么是keepalived
### 14、什么是gevent
### 15、什么是防火墙？防火墙的作用是什么？
### 16、求以下代码结果：
### 17、如何以就地操作方式打乱一个列表的元素？
### 18、在Python中有多少种运算符？解释一下算数运算符。
### 19、filter、map、reduce的作用。
### 20、描述以下字典的items()方法和iteritems()方法有啥不同？
### 21、Python支持多重继承吗？
### 22、什么是反射，以及应用场景
### 23、Python中的pass语句是什么？
### 24、解释一下Python中的//，%和 ** 运算符
### 25、如何保证Redis中的数据都是热点数据
### 26、什么是正则的贪婪匹配？贪婪模式和非贪婪模式的区别？
### 27、Python区分大小写吗？
### 28、解释Python的内置数据结构？
### 29、python中如何使用进程池和线程池
### 30、解释*args和**kwargs？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
