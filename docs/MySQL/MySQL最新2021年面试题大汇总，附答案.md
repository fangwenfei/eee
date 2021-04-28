# MySQL最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、有多少种日志

innodb两种日志redo和undo。


### 2、前缀索引

**1、** 语法：`index(field(10))`，使用字段值的前10个字符建立索引，默认是使用字段的全部内容建立索引。

**2、** 前提：前缀的标识度高。比如密码就适合建立前缀索引，因为密码几乎各不相同。

**3、** 实操的难度：在于前缀截取的长度。

**4、** 我们可以利用`select count(*)/count(distinct left(password,prefixLen));`，通过从调整`prefixLen`的值（从1自增）查看不同前缀长度的一个平均匹配度，接近1时就可以了（表示一个密码的前`prefixLen`个字符几乎能确定唯一一条记录）


### 3、SQL语言包括哪几部分？每部分都有哪些操作关键字？

SQL语言包括数据定义(DDL)、数据操纵(DML),数据控制(DCL)和数据查询（DQL）四个部分。

数据定义：Create Table,Alter Table,Drop Table, Craete/Drop Index等

数据操纵：Select ,insert,update,delete,

数据控制：grant,revoke

数据查询：select


### 4、Myql中的事务回滚机制概述

事务是用户定义的一个数据库操作序列，这些操作要么全做要么全不做，是一个不可分割的工作单位，事务回滚是指将该事务已经完成的对数据库的更新操作撤销。

要同时修改数据库中两个不同表时，如果它们不是一个事务的话，当第一个表修改完，可能第二个表修改过程中出现了异常而没能修改，此时就只有第二个表依旧是未修改之前的状态，而第一个表已经被修改完毕。而当你把它们设定为一个事务的时候，当第一个表修改完，第二表修改出现异常而没能修改，第一个表和第二个表都要回到未修改的状态，这就是所谓的事务回滚


### 5、从锁的类别角度讲，MySQL都有哪些锁呢？

**从锁的类别上来讲，有共享锁和排他锁**

**1、** 共享锁: 又叫做读锁。当用户要进行数据的读取时，对数据加上共享锁。共享锁可以同时加上多个。

**2、** 排他锁: 又叫做写锁。当用户要进行数据的写入时，对数据加上排他锁。排他锁只可以加一个，他和其他的排他锁，共享锁都相斥。

锁兼容性如下：

![](https://user-gold-cdn.xitu.io/2020/5/23/172412db1d202759?w=1045&h=229&f=png&s=68561#alt=)


### 6、聚簇索引和非聚簇索引，在查询数据的时候有区别吗？为什么？

聚簇索引查询会更加快些。因为主键索引树的页子节点存储的是整行数据。也就是我们需要得到的数据。而非主键索引的页子节点是主键的值，查询的主键之后，我们还需要通过主键的值再次进行查询数据。（这个过程被称之为回表）。


### 7、如何显示前50行？

**在MySQL中，使用以下代码查询显示前50行：**

SELECT*FROM

LIMIT 0,50;


### 8、MySQL里记录货币用什么字段类型好

NUMERIC和DECIMAL类型被MySQL实现为同样的类型，这在SQL92标准允许。他们被用于保存值，该值的准确精度是极其重要的值，例如与金钱有关的数据。当声明一个类是这些类型之一时，精度和规模的能被(并且通常是)指定。

**例如：**

salary DECIMAL(9,2)

在这个例子中，9(precision)代表将被用于存储值的总的小数位数，而2(scale)代表将被用于存储小数点后的位数。

因此，在这种情况下，能被存储在salary列中的值的范围是从-9999999.99到9999999.99。


### 9、MySQL中有哪些不同的表格？

共有5种类型的表格：

**1、**  MyISAM

**2、**  Heap

**3、**  Merge

**4、**  INNODB

**5、**  ISAM


### 10、limit 1000000 加载很慢的话，你是怎么解决的呢？

**方案一：**如果id是连续的，可以这样，返回上次查询的最大记录(偏移量)，再往下limit

```
select id，name from employee where id>1000000 limit 10.
```

**方案二：**在业务允许的情况下限制页数：

建议跟业务讨论，有没有必要查这么后的分页啦。因为绝大多数用户都不会往后翻太多页。

**方案三：**order by + 索引（id为索引）

```
select id，name from employee order by id  limit 1000000，10
```

**方案四：**利用延迟关联或者子查询优化超多分页场景。（先快速定位需要获取的id段，然后再关联）

```
SELECT a.* FROM employee a, (select id from employee where 条件 LIMIT 1000000,10 ) b where a.id=b.id
```


### 11、主键索引与唯一索引的区别
### 12、可以使用多少列创建索引？
### 13、什么是最左前缀原则？什么是最左匹配原则
### 14、索引有哪些优缺点？
### 15、什么是最左前缀原则？什么是最左匹配原则？
### 16、超键、候选键、主键、外键分别是什么？
### 17、MySQL里记录货币用什么字段类型好
### 18、MyISAM索引与InnoDB索引的区别？
### 19、什么是数据库事务？
### 20、谈谈MySQL的Explain
### 21、覆盖索引、回表等这些，了解过吗？
### 22、数据库中的事务是什么?
### 23、对于关系型数据库而言，索引是相当重要的概念，请回答有关索引的几个问题：
### 24、MySQL中有哪几种锁？
### 25、索引能干什么?
### 26、MySQL的binlog有几种录入格式？分别有什么区别？
### 27、如何优化长难的查询语句？有实战过吗？
### 28、InnoDB引擎的4大特性，了解过吗
### 29、MySQL里记录货币用什么字段类型比较好？
### 30、说一下数据库的三大范式




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
