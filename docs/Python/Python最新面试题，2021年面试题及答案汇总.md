# Python最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何高效的找到Redis中所有以felix开头的key

**1、** scan 0 match felixcount 5

**2、** 表示从游标0开始查询felix开头的key，每次返回5条，但是这个5条不一定


### 2、python递归的最大层数？

1000


### 3、在Python中有多少种运算符？解释一下算数运算符。

在Python中，我们有7种运算符：算术运算符、关系运算符、赋值运算符、逻辑运算符、位运算符、成员运算符、身份运算符。

我们有7个算术运算符，能让我们对数值进行算术运算：

**1、** 加号（+），将两个值相加

```
>>> 7+8
15
```

**2、** 减号（-），将第一个值减去第二个值

```
>>> 7-8
-1
```

**3、** 乘号（*），将两个值相乘

```
>>> 7*8
56
```

**4、** 除号（/），用第二个值除以第一个值

```
>>> 7/8
0.875
>>> 1/1
1.0
```

**5、** 向下取整除、取模和取幂运算，参见上个问题。


### 4、简述Redis的有几种持久化策略以及比较？

**1、** RDB 持久化可以在指定的时间间隔内生成数据集的时间点快照。

**2、** AOF 持久化记录服务器执行的所有写操作命令，并在服务器启动时，通过重新执行这些命令来还原数据集。 AOF 文件中的命令全部以 Redis 协议的格式来保存，新命令会被追加到文件的末尾。 Redis 还可以在后台对 AOF 文件进行重写(rewrite)，使得 AOF 文件的体积不会超出保存数据集状态所需的实际大小。

**区别：**

**1、** RDB持久化是指在指定的时间间隔内将内存中的数据集快照写入磁盘，实际操作过程是fork一个子进程，先将数据集写入临时文件，写入成功后，再替换之前的文件，用二进制压缩存储。

**2、** AOF持久化以日志的形式记录服务器所处理的每一个写、删除操作，查询操作不会记录，以文本的方式记录，可以打开文件看到详细的操作记录。


### 5、is和==的区别

is比较的是两个对象的id是否相同

==比较的是两个对象的值是否相同


### 6、如何使用索引来反转Python中的字符串?

```
string = 'hello'

string[::-1]
>'olleh'
```


### 7、1<(22)和1<22的结果分别是什么？

第一个为False，第二个为True，暂时按照第一个类型进行相应的转换


### 8、有一个列表lis=['This','is','a','Man','B','!']，对它进行大小写无关的排序

```python
lis=['This','is','a','Man','B','!']
lis=sorted(lis,key=str.lower)
print(lis)
```


### 9、描述以下dict的items和iteritems的区别

python3中没有iteritems

items和iteritems大致相同，只是items返回的是一个列表，iteritems返回的是一个迭代器。


### 10、Redis如何实现事务

参考链接

[https://blog.csdn.net/hxpjava1/article/details/79553073](https://blog.csdn.net/hxpjava1/article/details/79553073)


### 11、Python的局限性？
### 12、什么是反射，以及应用场景
### 13、Python中的字典是什么？
### 14、写个函数接收一个文件夹名称作为参数，显示文件夹中文件的路径，以及其中包含的文件夹中文件的如今
### 15、traceroute使用哪种网络协议
### 16、什么是C/S和B/S架构
### 17、isinstance和type的作用
### 18、实现一个装饰器，限制该函数被调用的频率，如10秒一次
### 19、在Python中如何使用多进制数字？
### 20、输入一个字符串，输出该字符串的字符的所有组合。如输入'abc',输出a,b,c,ab,ac,bc,abc.
### 21、python中进制转换
### 22、什么是防火墙？防火墙的作用是什么？
### 23、对列表[3,1,-4,-2]按照绝对值排序
### 24、有如下代码：
### 25、如何实现['1','2','3']变成[1,2,3]
### 26、列表推导式[i for i in range(10)]和生成式表达式(i for i in range(10))的区别
### 27、Python中的装饰器是什么？
### 28、vue中的路由拦截器的作用
### 29、列举面向对象中带双下划线的特殊方法
### 30、xrange和range的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
