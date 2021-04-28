# Python最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、索引再什么情况下遵循最左前缀的规则？

在多字段进行索引的时候，会遵循以上原则


### 2、python递归的最大层数？

1000


### 3、什么是twisted框架

twisted是用python实现的基于事件驱动的网络引擎框架。


### 4、对列表[3,1,-4,-2]按照绝对值排序

```python
lis=[3,1,-4,-2]
lis=sorted(lis,key=lambda x:abs(x))
print(lis)
```


### 5、什么是Python？为什么它会如此流行？

Python是一种解释的、高级的、通用的编程语言。

Python的设计理念是通过使用必要的空格与空行，增强代码的可读性。

它之所以受欢迎，就是因为它具有简单易用的语法。


### 6、字节码和机器码的区别

**1、** 机器码是电脑CPU直接读取运行的机器指令，运行速度最快，但是非常晦涩难懂，也比较难编写，一般从业人员接触不到。

**2、** 字节码是一种中间状态（中间码）的二进制代码（文件）。需要直译器转译后才能成为机器码。


### 7、lambda表达式格式以及应用场景？

格式：lambda 参数列表 : 返回表达式

应用场景：常见的在filter，reduce以及map中使用。


### 8、MySQL索引种类

**1、** 普通索引：仅加速查询

**2、** 唯一索引：加速查询 + 列值唯一（可以有null）

**3、** 主键索引：加速查询 + 列值唯一（不可以有null）+ 表中只有一个

**4、** 组合索引：多列值组成一个索引，专门用于组合搜索，其效率大于索引合并

**5、** 全文索引：对文本的内容进行分词，进行搜索


### 9、使用with语句的好处是什么

**1、** 使用with后不管with中的代码出现什么错误，都会进行对当前对象进行清理工作。例如file的file.close()方法，无论with中出现任何错误，都会执行file.close（）方法

**2、** 只有支持上下文管理器的对象才能使用with，即在对象内实现了两个方法：**enter**()和**exit**()


### 10、什么是arp协议

**1、** ARP全称“Address Resolution Protocol”，地址解析协议。

**2、** 实现局域网内通过IP地址获取主机的MAC地址。

**3、** MAC地址48位主机的物理地址，局域网内唯一。

**4、** ARP协议类似DNS服务，但不需要配置服务。

**5、** ARP协议是三层协议。


### 11、Python有哪些应用？
### 12、比较：a=[1,2,3]和b=[(1),(2),(3)]以及c=[(1,),(2,),(3,)]的区别
### 13、什么是防火墙？防火墙的作用是什么？
### 14、了解过Hbase，DB2，SQLServer，Access吗
### 15、解释一下Python中的关系运算符
### 16、什么是Flask？
### 17、pass的使用
### 18、请写一个Python逻辑，计算一个文件中的大写字母数量
### 19、什么是并发和并行
### 20、找出两个列表中相同的元素和不同的元素
### 21、解释*args和**kwargs？
### 22、用尽量简洁的方法将二维数组合并成一维数组
### 23、简述触发器、函数、视图和存储过程
### 24、什么是switch语句。如何在Python中创建switch语句？
### 25、Python是否有main函数？
### 26、将列表按照下列规则排序：
### 27、什么是索引合并
### 28、编写程序，计算文件中单词的出现频率
### 29、什么是粘包？出现粘包的原因？
### 30、yield from 和 yield 的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
