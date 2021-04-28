# MySQL最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、创建索引的三种方式

**在执行CREATE TABLE时创建索引**

```
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

**使用ALTER TABLE命令添加索引**

```
ALTER TABLE table_name ADD INDEX index_name (column);
```

**使用CREATE INDEX命令创建**

```
CREATE INDEX index_name ON table_name (column);
```


### 2、对MySQL的锁了解吗

当数据库有并发事务的时候，可能会产生数据的不一致，这时候需要一些机制来保证访问的次序，锁机制就是这样的一个机制。

就像酒店的房间，如果大家随意进出，就会出现多人抢夺同一个房间的情况，而在房间上装上锁，申请到钥匙的人才可以入住并且将房间锁起来，其他人只有等他使用完毕才可以再次使用。


### 3、读写分离有哪些解决方案？

读写分离是依赖于主从复制，而主从复制又是为读写分离服务的。因为主从复制要求`slave`不能写只能读（如果对`slave`执行写操作，那么`show slave status`将会呈现`Slave_SQL_Running=NO`，此时你需要按照前面提到的手动同步一下`slave`）。

**方案一**

使用MySQL-proxy代理

**优点：**

直接实现读写分离和负载均衡，不用修改代码，master和slave用一样的帐号，MySQL官方不建议实际生产中使用

**缺点：**

降低性能， 不支持事务

**方案二**

**1、** 使用AbstractRoutingDataSource+aop+annotation在dao层决定数据源。

**2、** 如果采用了mybatis， 可以将读写分离放在ORM层，比如mybatis可以通过mybatis plugin拦截sql语句，所有的insert/update/delete都访问master库，所有的select 都访问salve库，这样对于dao层都是透明。 plugin实现时可以通过注解或者分析语句是读写方法来选定主从库。不过这样依然有一个问题， 也就是不支持事务， 所以我们还需要重写一下DataSourceTransactionManager， 将read-only的事务扔进读库， 其余的有读有写的扔进写库。

**方案三**

**1、** 使用AbstractRoutingDataSource+aop+annotation在service层决定数据源，可以支持事务.

**2、** 缺点：类内部方法通过this.xx()方式相互调用时，aop不会进行拦截，需进行特殊处理。


### 4、什么是子查询

**1、** 条件：一条SQL语句的查询结果做为另一条查询语句的条件或查询结果

**2、** 嵌套：多条SQL语句嵌套使用，内部的SQL查询语句称为子查询。


### 5、varchar(50)中50的涵义

字段最多存放 50 个字符

如 varchar(50) 和 varchar(200) 存储 "jay" 字符串所占空间是一样的，后者在排序时会消耗更多内存


### 6、Innodb的事务与日志的实现方式


### 7、MySQL数据库cpu飙升的话，要怎么处理呢？

**「排查过程：」**

使用top 命令观察，确定是MySQLd导致还是其他原因。

如果是MySQLd导致的，show processlist，查看session情况，确定是不是有消耗资源的sql在运行。

找出消耗高的 sql，看看执行计划是否准确， 索引是否缺失，数据量是否太大。

**「处理：」**

kill 掉这些线程(同时观察 cpu 使用率是否下降)，

进行相应的调整(比如说加索引、改 sql、改内存参数)

重新跑这些 SQL。

**「其他情况：」**

也有可能是每个 sql 消耗资源并不多，但是突然之间，有大量的 session 连进来导致 cpu 飙升，这种情况就需要跟应用一起来分析为何连接数会激增，再做出相应的调整，比如说限制连接数等


### 8、什么是非标准字符串类型？

**1、**  TINYTEXT

**2、**  TEXT

**3、**  MEDIUMTEXT

**4、**  LONGTEXT


### 9、MySQL中有哪几种锁？

**1、** 表级锁：开销小，加锁快；不会出现死锁；锁定粒度大，发生锁冲突的概率最高，并发度最低。

**2、** 行级锁：开销大，加锁慢；会出现死锁；锁定粒度最小，发生锁冲突的概率最低，并发度也最高。

**3、** 页面锁：开销和加锁时间界于表锁和行锁之间；会出现死锁；锁定粒度界于表锁和行锁之间，并发度一般。


### 10、索引有哪几种类型？

**主键索引:** 数据列不允许重复，不允许为NULL，一个表只能有一个主键。

**唯一索引:** 数据列不允许重复，允许为NULL值，一个表允许多个列创建唯一索引。

**1、** 可以通过 `ALTER TABLE table_name ADD UNIQUE (column);` 创建唯一索引

**2、** 可以通过 `ALTER TABLE table_name ADD UNIQUE (column1,column2);` 创建唯一组合索引

**普通索引:** 基本的索引类型，没有唯一性的限制，允许为NULL值。

**1、** 可以通过`ALTER TABLE table_name ADD INDEX index_name (column);`创建普通索引

**2、** 可以通过`ALTER TABLE table_name ADD INDEX index_name(column1, column2, column3);`创建组合索引

**全文索引：** 是目前搜索引擎使用的一种关键技术。

可以通过`ALTER TABLE table_name ADD FULLTEXT (column);`创建全文索引


### 11、什么是触发器？触发器的使用场景有哪些？
### 12、什么叫视图？游标是什么？
### 13、count(1)、count(*) 与 count(列名) 的区别？
### 14、如何选择合适的分布式主键方案呢？
### 15、SQL注入漏洞产生的原因？如何防止？
### 16、MySQL中InnoDB支持的四种事务隔离级别名称，以及逐级之间的区别？
### 17、MySQL中TEXT数据类型的最大长度
### 18、SQL语句主要分为哪几类
### 19、MySQL中都有哪些触发器？
### 20、前缀索引
### 21、日志的存放形式
### 22、覆盖索引是什么？
### 23、怎么优化SQL查询语句吗
### 24、drop、delete与truncate的区别
### 25、如何通俗地理解三个范式？
### 26、你怎么看到为表格定义的所有索引？
### 27、索引使用场景
### 28、主键和候选键有什么区别？
### 29、慢查询日志




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
