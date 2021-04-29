# MySQL最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、InnoDB引擎的4大特性

**1、** 插入缓冲（insert buffer)

**2、** 二次写(double write)

**3、** 自适应哈希索引(ahi)

**4、** 预读(read ahead)


### 2、B+树在满足聚簇索引和覆盖索引的时候不需要回表查询数据？

在B+树的索引中，叶子节点可能存储了当前的key值，也可能存储了当前的key值以及整行的数据，这就是聚簇索引和非聚簇索引。 在InnoDB中，只有主键索引是聚簇索引，如果没有主键，则挑选一个唯一键建立聚簇索引。如果没有唯一键，则隐式的生成一个键来建立聚簇索引。

当查询使用聚簇索引时，在对应的叶子节点，可以获取到整行数据，因此不用再次进行回表查询。


### 3、列的字符串类型可以是什么？

字符串类型是：

**1、** SET

**2、** BLOB

**3、** ENUM

**4、** CHAR

**5、** TEXT


### 4、索引的一些潜规则

**1、** 覆盖索引

2、回表

**3、** 索引数据结构（B+树）

**4、** 最左前缀原则

**5、** 索引下推


### 5、limit 1000000 加载很慢的话，你是怎么解决的呢？

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


### 6、LIKE声明中的％和_是什么意思？

％对应于0个或更多字符，_只是LIKE语句中的一个字符。

**如何在Unix和MySQL时间戳之间进行转换？**

UNIX_TIMESTAMP是从MySQL时间戳转换为Unix时间戳的命令

FROM_UNIXTIME是从Unix时间戳转换为MySQL时间戳的命令


### 7、MVCC熟悉吗，它的底层原理？

MVCC,多版本并发控制,它是通过读取历史版本的数据，来降低并发事务冲突，从而提高并发性能的一种机制。

**「MVCC需要关注这几个知识点：」**

**1、** 事务版本号

**2、** 表的隐藏列

**3、** undo log

**4、** read view


### 8、MySQL中都有哪些触发器？
### 9、什么情况下设置了索引但无法使用
### 10、MySQL为什么这么设计
### 11、MySQL中InnoDB引擎的行锁是怎么实现的？
### 12、使用B树的好处
### 13、非主键索引一定会查询多次吗？
### 14、什么是通用SQL函数？
### 15、索引失效情况？ ==校验SQL语句是否使用了索引方式为：
### 16、你怎么知道SQL语句性能是高还是低
### 17、超键、候选键、主键、外键分别是什么？
### 18、组合索引是什么？为什么需要注意组合索引中的顺序？
### 19、drop、delete与truncate的区别
### 20、MySQL驱动程序是什么？
### 21、MySQL中int(20)和char(20)以及varchar(20)的区别
### 22、数据库三大范式是什么
### 23、谈谈MySQL的Explain
### 24、数据库索引的原理，为什么要用 B+树，为什么不用二叉树？
### 25、说说对SQL语句优化有哪些方法？（选择几条）
### 26、主键、外键和索引的区别？
### 27、MySQL的binlog有有几种录入格式？分别有什么区别？
### 28、在高并发情况下，如何做到安全的修改同一行数据？
### 29、有多少种日志
### 30、主从同步延迟的原因




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
