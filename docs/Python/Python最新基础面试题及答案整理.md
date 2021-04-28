# Python最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、阅读以下代码，写输出结果

```python
lis = [2,4,5,6,7]
for i in lis:
if i % 2==0:
lis.remove(i)
print(lis)
```

结果：[4, 5, 7]


### 2、在Python中是如何管理内存的？

Python有一个私有堆空间来保存所有的对象和数据结构。作为开发者，我们无法访问它，是解释器在管理它。但是有了核心API后，我们可以访问一些工具。Python内存管理器控制内存分配。

另外，内置垃圾回收器会回收使用所有的未使用内存，所以使其适用于堆空间。


### 3、怎样将字符串转换为小写？

我们使用lower()方法。

```
>>> 'AyuShi'.lower()
```

结果：

```
‘ayushi’
```

使用upper()方法可以将其转换为大写。

```
>>> 'AyuShi'.upper()
```

结果：

```
‘AYUSHI’
```

另外，使用isupper()和islower()方法检查字符春是否全为大写或小写。

```
>>> 'AyuShi'.isupper()
False
 
>>> 'AYUSHI'.isupper()
True
 
>>> 'ayushi'.islower()
True
 
>>> '@yu$hi'.islower()
True
 
>>> '@YU$HI'.isupper()
True
```

那么，像@和$这样的字符既满足大写也满足小写。

Istitle()能告诉我们一个字符串是否为标题格式。

```
>>> 'The Corpse Bride'.istitle()
True
```


### 4、列举你所了解的所有Python2和Python3的区别

[python2和python3的区别](https://blog.csdn.net/weixin_41819299/article/details/81259721)

**1、** python2没有nonlocal关键字，要修改临时变量只能将其改成可变数据类型，如数组。b=[a]

**2、** print()函数代替print语句

**3、** Python3加入 Unicode 字符串，用以编码存储字符串。比如用 utf-8可以用来输入中文

**4、** Python3去掉long类型，新增了bytes。

**5、** Python 3整数之间做除法可以得到浮点数的结果，不需要进行数据格式转换1/2=0.5 Python 2整数int间除法结果为把运算结果去尾的整数1/2=0，3/2.0=1.5

**6、** Python3 中 range()，Python2 中 xrange()。

**7、** python2中的不等于号可以是!=或者<>，python3只能是!=

**8、** python2中raw_input()用来输入字符串，而python3中使用input()来输入字符串


### 5、为什么学python

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


### 6、css如何隐藏一个元素

display：none


### 7、python哪些类型的数据才能作为字典的key？

可哈希的类型


### 8、Python中OOPS是什么？

面向对象编程，抽象(Abstraction)、封装(Encapsulation)、继承(Inheritance)、多态(Polymorphism)


### 9、python是如何进行内存管理的？python的程序会内存泄漏吗？说说有没有什么方面阻止或者检测内存泄漏？

python是如何进行内存管理的[参考文章](https://blog.csdn.net/u010967872/article/details/80301633)

**1、** 引用计数

Python内部使用引用计数，来保持追踪内存中的对象，Python内部记录了对象有多少个引用，就是引用计数，当对象被创建时就创建了一个引用计数，当对象不再需要的时候，这个对象的引用计数为0时，他被垃圾回收。

**2、** 垃圾回收

当内存中有不再使用的部分时，垃圾收集器就会把他们清理掉。他会去检查那些引用计数为0的对象，然后清除其在内存中的空间。当然除了引用计数为0的会被清除，还有一种情况也会被垃圾收集器清掉，当两个对象相互引用时，他们本身其他引用已经为0了。

**3、** 内存池机制

**1、** Python提供了对内存的垃圾收集机制，但是他将不用的内存放到内存池而不是反回给操作系统。

**2、** python的程序会内存泄漏吗？

**3、** 会发生内存泄漏，在Python程序里，内存泄漏是由于一个长期持有的对象不断的往一个dict或者list对象里添加新的对象, 而又没有即时释放，就会导致这些对象占用的内存越来越多，从而造成内存泄漏。另外，对象的交叉引用也会造成内存无法释放的问题。

**说说有没有什么方面阻止或者检测内存泄漏？**

**1、** 程序员管理好每个python对象的引用，尽量在不需要使用对象的时候，断开所有引用

**2、** 尽量少通过循环引用组织数据，可以改用weakref做弱引用或者用id之类的句柄访问对象

**3、** 通过gc模块的接口可以检查出每次垃圾回收有哪些对象不能自动处理，再逐个逐个处理


### 10、!=和is not运算符的区别？

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


### 11、从0-99这100个数中随机取出10个，要求不能重复
### 12、解释一下Python中的逻辑运算符
### 13、Python中使用的zip函数是什么？
### 14、Python有哪些应用？
### 15、编写程序，输出给定序列中的所有质数
### 16、re的match和search的区别
### 17、DNS域名解析过程
### 18、如何使用索引来反转Python中的字符串?
### 19、前后端分离的基本原理
### 20、使用生成器编写一个函数实现生成指定个数的斐波那契数列
### 21、Redis中watch的作用
### 22、请列出至少5个PEP8规范
### 23、编写一个函数，找出数组中没有重复的值的和
### 24、解释Python中的join()和split()函数
### 25、用尽量简洁的方法将二维数组合并成一维数组
### 26、什么是鸭子模型？
### 27、python和java、php、c、c#、c++ 等其他语言对比？
### 28、列举常见的关系型数据库和非关系型数据库。
### 29、解释//、％、* *运算符？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
