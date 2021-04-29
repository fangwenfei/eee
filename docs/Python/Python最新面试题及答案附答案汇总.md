# Python最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、b、B、kB、MB、GB的关系

**1、** 1B=8b

**2、** 1kB=1024B

**3、** 1MB=1024kB

**4、** 1GB=1024MB


### 2、什么是猴子补丁？

在运行期间动态修改一个类或模块。

```
>>> class A:
    def func(self):
        print("Hi")
>>> def monkey(self):
print "Hi, monkey"
>>> m.A.func = monkey
>>> a = m.A()
>>> a.func()
```

运行结果为：

```
Hi, Monkey
```


### 3、简述python的深浅拷贝

**1、** 浅拷贝只是对另外一个变量的内存地址的拷贝，这两个变量指向同一个内存地址的变量值。

**2、** 浅拷贝的特点：

**3、** 共用一个值

**4、** 这两个变量的内存地址一样

**5、** 对其中一个变量的值改变，另外一个变量的值也会改变

**6、** 深拷贝是一个变量对另外一个变量的值拷贝

**7、** 深拷贝的特点：

**8、** 两个变量的内存地址不同

**9、** 两个变量各有自己的值，且互不影响

**10、** 对其任意一个变量的值的改变不会影响另外一个

**11、** 如果是不可变类型，则深浅拷贝只拷贝引用，如果是可变类型，浅拷贝只拷贝第一层引用，深拷贝无论多少层引用都拷贝


### 4、Python中的闭包是什么？

当一个嵌套函数在其外部区域引用了一个值时，该嵌套函数就是一个闭包。其意义就是会记录这个值。

```
>>> def A(x):
    def B():
        print(x)
    return B
>>> A(7)()
```

结果：

```
7
```

更多关于闭包的知识，请参看这里：

[戳这里](https://data-flair.training/blogs/python-closure/)


### 5、a = dict(zip(('a','b','c','d','e'),(1,2,3,4,5))) 请问a是什么？

**{'a': 1, 'b': 2, 'c': 3, 'd': 4, 'e': 5}**


### 6、数据库的导入与导出命令

**1、** 导出(MySQLdump)

**2、** 导出数据和表结构

**3、** MySQLdump -uroot -p dbname > dbname .sql

**4、** 只导出表结构

**5、** MySQLdump -uroot -p -d dbname > dbname .sql

6、导入

**7、** MySQL -u用户名 -p密码 数据库名 < 数据库名.sql


### 7、简述进程，线程，协程的区别以及应用场景？

**区别：**

**1、** 线程是资源分配的单位

**2、** 线程是操作系统调度的单位

**3、** 进程切换需要的资源很大，效率很低

**4、** 线程切换需要的资源一般，效率一般(在不考虑GIL的情况下

**5、** 协程切换任务资源很小，效率高

**6、** 多进程，多线程根据cpu核数不一样可能是并行的，但是协程是在一个线程中，所以是并发。)

**应用场景**

**1、** 协程：当程序中存在大量不需要cpu的操作时，适用协程

**2、** 计算密集型，用进程。IO密集型，用线程。


### 8、22、iterables和iterators之间的区别？

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


### 9、如何查找一个字符串中特定的字符？find和index的差异？

使用find和index方法查找

**1、** find()方法：查找子字符串，若找到返回从0开始的下标值，若找不到返回-1

**2、** index()方法：python 的index方法是在字符串里查找子串第一次出现的位置，类似字符串的find方法，不过比find方法更好的是，如果查找不到子串，会抛出异常，而不是返回-1


### 10、JavaScript(或者jQuery)如何选择一个id为main的容器

**1、** jquery：$('#id')

**2、** JavaScript：document.getElementById("id"))


### 11、一个大小为100G的文件etl_log.txt，要读取文件的内容，写出具体过程代码
### 12、1，2，3，4，5能组成多少个互不相同且不重复的三位数？
### 13、python解释器种类以及特点
### 14、元组的解封装是什么？
### 15、解决哈希冲突的算法有哪几种？分别有什么特点？
### 16、query作为sql模板，args为将要传入的参数
### 17、axios的作用
### 18、现有mydict和变量onekey，请写出从mydict中取出onekey的值的方法
### 19、如何实现字符串的反转？如：name=felix，反转成name=xilef
### 20、Redis和Memcached的区别
### 21、什么是Python？为什么它会如此流行？
### 22、如何判断一个值是方法还是函数？
### 23、以下代码输出什么？
### 24、Python中使用的zip函数是什么？
### 25、编写程序，计算文件中单词的出现频率
### 26、实现99乘法表（使用两种方法）
### 27、什么是局域网和广域网
### 28、简述OSI七层协议
### 29、用尽量简洁的方法将二维数组合并成一维数组
### 30、解释Python中map()函数？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
