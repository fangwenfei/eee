# Python最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MySQL执行计划的作用和使用方法

**1、** 作用：用来进行查询分析，比如整个查询涉及多少防，使用哪些索引，运行时间等

**2、** 使用方法：使用explain关键字，如explain select xxx from xxx;


### 2、使用with语句的好处是什么

**1、** 使用with后不管with中的代码出现什么错误，都会进行对当前对象进行清理工作。例如file的file.close()方法，无论with中出现任何错误，都会执行file.close（）方法

**2、** 只有支持上下文管理器的对象才能使用with，即在对象内实现了两个方法：**enter**()和**exit**()


### 3、当退出Python时，是否释放全部内存？

答案是No。循环引用其它对象或引用自全局命名空间的对象的模块，在Python退出时并非完全释放。

另外，也不会释放C库保留的内存部分。


### 4、怎样声明多个变量并赋值？

一共有两种方式：

```
>>> a,b,c=3,4,5 #This assigns 3, 4, and 5 to a, b, and c respectively
>>> a=b=c=3 #This assigns 3 to a, b, and c
```


### 5、写出如下代码的输出结果

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



### 6、threading.local的作用

为每个线程创建一个独立的空间，使得线程对自己的空间中的数据进行操作(数据隔离)。


### 7、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？

对的


### 8、MySQL的建表语句

```mysql
#创建表，例子
#所谓的建表就是声明列的过程,所以要首先分析列
create table member(
                       id int unsigned auto_increment primary key,
                       username varchar(20) not null default '',
                       gender char(1) not null default '',
                       weight tinyint unsigned not null default 0,
                       birth date not null default '0000-00-00',
                       salary decimal(8,2) not null default 0.00,
                       lastlogin int unsigned not null default 0
)engine myisam charset utf8;
```


### 9、一行代码实现删除列表中的所有的重复的值

```python
lis=[1,1,2,1,22,5]
lis=list(set(lis))
```


### 10、列举创建索引但是无法命中索引的情况

**1、** 如果条件中有or，即使其中有条件带索引也不会使用(这也是为什么尽量少用or的原因）

**2、** 对于多列索引，不是使用的第一部分(第一个)，则不会使用索引

**3、** like查询是以%开头

**4、** 如果列类型是字符串，那一定要在条件中将数据使用引号引用起来,否则不使用索引

**5、** 如果MySQL估计使用全表扫描要比使用索引快,则不使用索引


### 11、使用async语法实现一个协程
### 12、python是如何进行内存管理的？python的程序会内存泄漏吗？说说有没有什么方面阻止或者检测内存泄漏？
### 13、解释一下Python中的身份运算符
### 14、简述jsonp及其原理
### 15、守护线程，守护进程是什么
### 16、发生粘包现象如何处理？
### 17、使用两个队列实现一个栈
### 18、如何保证Redis中的数据都是热点数据
### 19、python的垃圾回收机制
### 20、Python中append，insert和extend的区别?
### 21、怎么移除一个字符串中的前导空格？
### 22、select、poll、epoll模型的区别
### 23、什么是断言(assert)?应用场景？
### 24、什么是cdn
### 25、文件操作时，xreadlines和readlines的区别
### 26、什么是socket？简述基于tcp协议的socket通信流程？
### 27、==和is的区别是？
### 28、实例方法、静态方法和类方法的区别
### 29、Python支持多重继承吗？
### 30、列表中保留顺序和不保留顺序去重




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
