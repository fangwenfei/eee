# MySQL最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、SQL优化的一般步骤是什么，怎么看执行计划（explain），如何理解其中各个字段的含义。

**1、** show status 命令了解各种 sql 的执行频率

**2、** 通过慢查询日志定位那些执行效率较低的 sql 语句

**3、** explain 分析低效 sql 的执行计划（这点非常重要，日常开发中用它分析Sql，会大大降低Sql导致的线上事故）


### 2、innoDB的B+Tree 存储整行数据和主键的值得区别？

**1、** 整行数据：innoDB的B+Tree存储了整行数据的是主键索引，也被成为聚凑索引。

**2、** 存储主键的值：成为非主键索引，也被称为非聚凑索引


### 3、drop、delete与truncate的区别
|  | delete | truncate | drop |
| --- | --- | --- | --- |
| 类型 | DML | DDL | DDL |
| 回滚 | 可回滚 | 不可回滚 | 不可回滚 |
| 删除内容 | 表结构还在，删除表的全部或者一部分数据行 | 表结构还在，删除表中的所有数据 | 从数据库中删除表，所有的数据行，索引和权限也会被删除 |
| 删除速度 | 删除速度慢，逐行删除 | 删除速度快 | 删除速度最快 |



### 4、主键和候选键有什么区别？

表格的每一行都由主键唯一标识,一个表只有一个主键。

主键也是候选键。按照惯例，候选键可以被指定为主键，并且可以用于任何外键引用。


### 5、myisamchk是用来做什么的？

它用来压缩MyISAM表，这减少了磁盘或内存使用。


### 6、事物的四大特性(ACID)介绍一下?

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


### 7、慢查询日志

**用于记录执行时间超过某个临界值的SQL日志，用于快速定位慢查询，为我们的优化做参考**

**1、** 开启慢查询日志

**2、** 配置项：`slow_query_log`

**3、** 可以使用`show variables like ‘slov_query_log’`查看是否开启，如果状态值为`OFF`，可以使用`set GLOBAL slow_query_log = on`来开启，它会在`datadir`下产生一个`xxx-slow.log`的文件。

**4、** 设置临界时间

**5、** 配置项：`long_query_time`

**6、** 查看：`show VARIABLES like 'long_query_time'`，单位秒

**7、** 设置：`set long_query_time=0.5`

**8、** 实操时应该从长时间设置到短的时间，即将最慢的SQL优化掉

**9、** 查看日志，一旦SQL超过了我们设置的临界时间就会被记录到`xxx-slow.log`中


### 8、SQL语言包括哪几部分？每部分都有哪些操作关键字？

SQL语言包括数据定义(DDL)、数据操纵(DML),数据控制(DCL)和数据查询（DQL）四个部分。

数据定义：Create Table,Alter Table,Drop Table, Craete/Drop Index等

数据操纵：Select ,insert,update,delete,

数据控制：grant,revoke

数据查询：select


### 9、B树和B+树的区别

**1、** 在B树中，你可以将键和值存放在内部节点和叶子节点；但在B+树中，内部节点都是键，没有值，叶子节点同时存放键和值。

**2、** B+树的叶子节点有一条链相连，而B树的叶子节点各自独立。

![99_4.png][99_4.png]


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


### 11、SQL语言包括哪几部分？每部分都有哪些操作关键字？
### 12、简述有哪些索引和作用
### 13、SQL 约束有哪几种？
### 14、索引使用场景
### 15、varchar(50)中50的涵义
### 16、int(20)中20的涵义
### 17、MySQL里记录货币用什么字段类型比较好？
### 18、drop、delete与truncate的区别
### 19、什么是子查询
### 20、为什么要使用视图？什么是视图？
### 21、select for update 含义
### 22、字段为什么要求定义为not null？
### 23、如果某个表有近千万数据，CRUD比较慢，如何优化。
### 24、varchar与char的区别
### 25、按照锁的粒度分数据库锁有哪些？锁机制与InnoDB锁算法
### 26、存储引擎分类有哪些以及使用场景？
### 27、主键使用自增ID还是UUID？
### 28、什么是死锁？怎么解决？
### 29、主键、外键和索引的区别？
### 30、B+ Tree索引和Hash索引区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
