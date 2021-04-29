# Python最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、对列表[3,1,-4,-2]按照绝对值排序

```python
lis=[3,1,-4,-2]
lis=sorted(lis,key=lambda x:abs(x))
print(lis)
```


### 2、python的底层网络交互模块有哪些

socket，urllib，requests，pycurl


### 3、python的可变类型和不可变类型的区别

**1、** 可变类型有：列表，字典等

**2、** 不可变类型有：数字，字符串，元组等

**3、** 这里的可变不可变是指内存中的那块内容是否可以被改变。


### 4、通过什么途径学习python

**1、** 通过看官方文档

**2、** 通过哔哩哔哩上的视频教程

**3、** 通过百度查资料

**4、** 通过买python相关方面的书


### 5、如何判断一个值是方法还是函数？

**1、** 使用type()来判断，如果是method为方法，如果是function则是函数。

**2、** 与类和实例无绑定关系的function都属于函数（function）

**3、** 与类和实例有绑定关系的function都属于方法


### 6、请编写一个函数将ip地址转换成一个整数。如10.3.9.12转换成00001010 00000011 00001001 00001100，然后转换成整数

```python
def ip2int(ip):
nums=ip.split('.')
# zfill()函数是补0
to_bin=[bin(int(i))[2:].zfill(8) for i in nums]
return int(''.join(to_bin),2)
i=ip2int('127.0.0.1')
print(i)
```


### 7、MySQL的建表语句

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


### 8、简述面向对象的三大特性？
### 9、解释一下Python中的逻辑运算符
### 10、二叉树是非线性结构，栈和队列以及线性表都是线性结构，对吗？
### 11、手写一个栈
### 12、简述TCP三次握手，四次挥手的流程。
### 13、22、iterables和iterators之间的区别？
### 14、把a='aaabbcccdddde'这种形式的字符串，压缩成a3b2c3d4e1这种形式。
### 15、获取python解释器版本的方法
### 16、找出两个列表中相同的元素和不同的元素
### 17、Python中的装饰器是什么？
### 18、MySQL的半同步复制原理
### 19、写一个的支持with语句的类
### 20、Redis和Memcached的区别
### 21、如何用一行代码生成[1,4,9,16,25,36,49,64,81,100]?
### 22、如何使用python删除一个文件或者文件夹？
### 23、写python爬虫分别用到了哪些模块？分别有什么用？
### 24、一个大小为100G的文件etl_log.txt，要读取文件的内容，写出具体过程代码
### 25、编写程序，检查数字是否为Armstrong
### 26、手写一个队列
### 27、select、poll、epoll模型的区别
### 28、python哪些类型的数据才能作为字典的key？
### 29、编写程序，计算文件中单词的出现频率




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
