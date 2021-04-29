# Python最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



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


### 2、简述left join和right join的区别

**1、** 左连接和右连接很相似，只是左右表位置的不同罢了。

**2、** left join(左连接) 返回包括左表中的所有记录和右表中连接字段相等的记录

**3、** right join(右连接) 返回包括右表中的所有记录和左表中连接字段相等的记录


### 3、解释一下Python中的身份运算符

这也是一个在Python面试中常问的问题。

通过身份运算符‘is’和‘is not’，我们可以确认两个值是否相同。

```
>>> 10 is '10'
False
 
>>> True is not False
True
```


### 4、位和字节的关系

8位=一字节


### 5、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。

```python
a='aaabbcccdddde'
aa=''
for i in sorted(list(set(a)),key=a.index):
aa=aa+i+str(a.count(i))
print(aa)
```


### 6、一行代码实现删除列表中的所有的重复的值

```python
lis=[1,1,2,1,22,5]
lis=list(set(lis))
```


### 7、Python中append，insert和extend的区别?

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


### 8、元组的解封装是什么？

首先我们来看解封装：

```
>>> mytuple=3,4,5
>>> mytuple
(3, 4, 5)
```

这将 3，4，5 封装到元组 mytuple 中。

现在我们将这些值解封装到变量 x，y，z 中：

```
>>> x,y,z=mytuple
>>> x+y+z
```

得到结果12.


### 9、比较：a=[1,2,3]和b=[(1),(2),(3)]以及c=[(1,),(2,),(3,)]的区别

a和b的结果相同，列表里面的值相同，类型也相同

c中的列表里面的值是元组类型的


### 10、解释Python中的help()和dir()函数

Help()函数是一个内置函数，用于查看函数或模块用途的详细说明：

```
>>> import copy
>>> help(copy.copy)
```

运行结果为：

```
Help on function copy in module copy:

 
 
copy(x)
 
Shallow copy operation on arbitrary Python objects.
 
See the module’s __doc__ string for more info.
```

Dir()函数也是Python内置函数，dir() 函数不带参数时，返回当前范围内的变量、方法和定义的类型列表；带参数时，返回参数的属性、方法列表。

以下实例展示了 dir 的使用方法：

```
>>> dir(copy.copy)
```

运行结果为：

```
[‘__annotations__’, ‘__call__’, ‘__class__’, ‘__closure__’, ‘__code__’, ‘__defaults__’, ‘__delattr__’, ‘__dict__’, ‘__dir__’, ‘__doc__’, ‘__eq__’, ‘__format__’, ‘__ge__’, ‘__get__’, ‘__getattribute__’, ‘__globals__’, ‘__gt__’, ‘__hash__’, ‘__init__’, ‘__init_subclass__’, ‘__kwdefaults__’, ‘__le__’, ‘__lt__’, ‘__module__’, ‘__name__’, ‘__ne__’, ‘__new__’, ‘__qualname__’, ‘__reduce__’, ‘__reduce_ex__’, ‘__repr__’, ‘__setattr__’, ‘__sizeof__’, ‘__str__’, ‘__subclasshook__’]
```


### 11、lambda表达式格式以及应用场景？
### 12、如何更改列表的数据类型？
### 13、22、iterables和iterators之间的区别？
### 14、将列表alist=[{'name':'a','age':25},{'name':'b','age':30},{'name':'c','age':20}]，按照age的值从大到小排列。
### 15、守护线程，守护进程是什么
### 16、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今
### 17、_init_在Python中有什么用？
### 18、isinstance和type的作用
### 19、用尽量简洁的方法将二维数组合并成一维数组
### 20、什么是Python中的猴子补丁？
### 21、Python是否有main函数？
### 22、介绍一下try except的用法和作用？
### 23、如何高效的找到Redis中所有以felix开头的key
### 24、什么是索引合并
### 25、路由器和交换机的区别
### 26、列表中保留顺序和不保留顺序去重
### 27、python的垃圾回收机制
### 28、ascii、Unicode、utf-8、gbk的区别
### 29、给定一个非空的字符串，判断它是否可以由它的一个子串重复多次构成。给定的字符串只含有小写英文字母，并且长度不超过10000。例如：'ababab',返回True，'ababa'，返回False
### 30、了解过Hbase，DB2，SQLServer，Access吗




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
