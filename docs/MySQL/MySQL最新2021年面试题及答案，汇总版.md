# MySQL最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、事物的四大特性(ACID)介绍一下?

关系性数据库需要遵循ACID规则，具体内容如下：

![99_6.png][99_6.png]

**1、** 原子性：

事务是最小的执行单位，不允许分割。事务的原子性确保动作要么全部完成，要么完全不起作用；

**2、** 一致性：

执行事务前后，数据保持一致，多个事务对同一个数据读取的结果是相同的；

**3、** 隔离性：

并发访问数据库时，一个用户的事务不被其他事务所干扰，各并发事务之间数据库是独立的；

**4、** 持久性：

一个事务被提交之后。它对数据库中数据的改变是持久的，即使数据库发生故障也不应该对其有任何影响。


### 2、说说MySQL 的基础架构图

![](https://user-gold-cdn.xitu.io/2020/5/23/17240afafdc289e5?w=661&h=500&f=png&s=289132#alt=)

**MySQL逻辑架构图主要分三层：**

**1、** 第一层负责连接处理，授权认证，安全等等

**2、** 第二层负责编译并优化SQL

**3、** 第三层是存储引擎。


### 3、varchar与char的区别

**char的特点**

**1、** char表示定长字符串，长度是固定的；

**2、** 如果插入数据的长度小于char的固定长度时，则用空格填充；

**3、** 因为长度固定，所以存取速度要比varchar快很多，甚至能快50%，但正因为其长度固定，所以会占据多余的空间，是空间换时间的做法；

**4、** 对于char来说，最多能存放的字符个数为255，和编码无关

**varchar的特点**

**1、** varchar表示可变长字符串，长度是可变的；

**2、** 插入的数据是多长，就按照多长来存储；

**3、** varchar在存取方面与char相反，它存取慢，因为长度不固定，但正因如此，不占据多余的空间，是时间换空间的做法；

**4、** 对于varchar来说，最多能存放的字符个数为65532

**总之**

结合性能角度（char更快）和节省磁盘空间角度（varchar更小），具体情况还需具体来设计数据库才是妥当的做法


### 4、数据库中的事务是什么?

事务（transaction）是作为一个单元的一组有序的数据库操作。如果组中的所有操作都成功，则认为事务成功，即使只有一个操作失败，事务也不成功。如果所有操作完成，事务则提交，其修改将作用于所有其他数据库进程。如果一个操作失败，则事务将回滚，该事务所有操作的影响都将取消。


### 5、什么是MySQL?

MySQL是一个关系型数据库管理系统，由瑞典MySQL AB 公司开发，属于 Oracle 旗下产品。MySQL 是最流行的关系型数据库管理系统之一，在 WEB 应用方面，MySQL是最好的 RDBMS (Relational Database Management System，关系数据库管理系统) 应用软件之一。在Java企业级开发中非常常用，因为 MySQL 是开源免费的，并且方便扩展。


### 6、一个6亿的表a，一个3亿的表b，通过外间tid关联，你如何最快的查询出满足条件的第50000到第50200中的这200条数据记录。

**1、** 如果A表TID是自增长,并且是连续的,B表的ID为索引

select * from a,b where a.tid = b.id and a.tid>500000 limit 200;

**2、** 如果A表的TID不是连续的,那么就需要使用覆盖索引.TID要么是主键,要么是辅助索引,B表ID也需要有索引。

select * from b , (select tid from a limit 50000,200) a where b.id = a .tid;


### 7、MyISAM索引与InnoDB索引的区别？

**1、** InnoDB索引是聚簇索引，MyISAM索引是非聚簇索引。

**2、** InnoDB的主键索引的叶子节点存储着行数据，因此主键索引非常高效。

**3、** MyISAM索引的叶子节点存储的是行数据地址，需要再寻址一次才能得到数据。

**4、** InnoDB非主键索引的叶子节点存储的是主键和其他带索引的列数据，因此查询时做到覆盖索引会非常高效。


### 8、InnoDB与MyISAM的区别

**1、** InnoDB支持事务，MyISAM不支持事务

**2、** InnoDB支持外键，MyISAM不支持外键

**3、** InnoDB 支持 MVCC(多版本并发控制)，MyISAM 不支持

**4、** select count(*) from table时，MyISAM更快，因为它有一个变量保存了整个表的总行数，可以直接读取，InnoDB就需要全表扫描。

**5、** Innodb不支持全文索引，而MyISAM支持全文索引（5.7以后的InnoDB也支持全文索引）

**6、** InnoDB支持表、行级锁，而MyISAM支持表级锁。

**7、** InnoDB表必须有主键，而MyISAM可以没有主键

**8、** Innodb表需要更多的内存和存储，而MyISAM可被压缩，存储空间较小，。

**9、** Innodb按主键大小有序插入，MyISAM记录插入顺序是，按记录插入顺序保存。

**10、** InnoDB 存储引擎提供了具有提交、回滚、崩溃恢复能力的事务安全，与 MyISAM 比 InnoDB 写的效率差一些，并且会占用更多的磁盘空间以保留数据和索引


### 9、SQL注入漏洞产生的原因？如何防止？

SQL注入产生的原因：程序开发过程中不注意规范书写sql语句和对特殊字符进行过滤，导致客户端可以通过全局变量POST和GET提交一些sql语句正常执行。

防止SQL注入的方式：

开启配置文件中的magic_quotes_gpc 和 magic_quotes_runtime设置

执行sql语句时使用addslashes进行sql语句转换

Sql语句书写尽量不要省略双引号和单引号。

过滤掉sql语句中的一些关键词：update、insert、delete、select、 * 。

提高数据库表和字段的命名技巧，对一些重要的字段根据程序的特点命名，取不易被猜到的。


### 10、如何删除索引

根据索引名删除普通索引、唯一索引、全文索引：`alter table 表名 drop KEY 索引名`

```
alter table user_index drop KEY name;
alter table user_index drop KEY id_card;
alter table user_index drop KEY information;
```

**删除主键索引：**`alter table 表名 drop primary key`（因为主键只有一个）。这里值得注意的是，如果主键自增长，那么不能直接执行此操作（自增长依赖于主键索引）：

![99_3.png][99_3.png]

**需要取消自增长再行删除：**

```
alter table user_index
-- 重新定义字段
MODIFY id int,
drop PRIMARY KEY
```

但通常不会删除主键，因为设计主键一定与业务逻辑无关。


### 11、Blob和text有什么区别？
### 12、MySQL自增主键用完了怎么办？
### 13、数据库的乐观锁和悲观锁是什么？怎么实现的？
### 14、优化子查询
### 15、大表怎么优化？分库分表了是怎么做的？分表分库了有什么问题？有用到中间件么？他们的原理知道么？
### 16、MySQL中 in 和 exists 区别
### 17、使用B树的好处
### 18、百万级别或以上的数据，你是如何删除的？
### 19、关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？
### 20、MySQL支持事务吗？
### 21、什么是索引？
### 22、SQL的执行顺序
### 23、MySQL如何优化DISTINCT？
### 24、简述在MySQL数据库中MyISAM和InnoDB的区别
### 25、如何在Unix和MySQL时间戳之间进行转换？
### 26、索引有哪些优缺点？
### 27、主键、外键和索引的区别？
### 28、怎么查询SQL语句是否使用了索引查询？
### 29、为什么要尽量设定一个主键？
### 30、数据库存储日期格式时，如何考虑时区转换问题？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
