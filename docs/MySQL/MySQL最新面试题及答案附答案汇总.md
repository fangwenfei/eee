# MySQL最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、说说MySQL 的基础架构图

![](https://user-gold-cdn.xitu.io/2020/5/23/17240afafdc289e5?w=661&h=500&f=png&s=289132#alt=)

**MySQL逻辑架构图主要分三层：**

**1、** 第一层负责连接处理，授权认证，安全等等

**2、** 第二层负责编译并优化SQL

**3、** 第三层是存储引擎。


### 2、列的字符串类型可以是什么？

字符串类型是：

**1、** SET

**2、** BLOB

**3、** ENUM

**4、** CHAR

**5、** TEXT


### 3、SQL 约束有哪几种？

> SQL 约束有哪几种？


**1、** NOT NULL: 用于控制字段的内容一定不能为空（NULL）。

**2、** UNIQUE: 控件字段内容不能重复，一个表允许有多个 Unique 约束。

**3、** PRIMARY KEY: 也是用于控件字段内容不能重复，但它在一个表只允许出现一个。

**4、** FOREIGN KEY: 用于预防破坏表之间连接的动作，也能防止非法数据插入外键列，因为它必须是它指向的那个表中的值之一。

**5、** CHECK: 用于控制字段的值范围。


### 4、drop、delete与truncate的区别
|  | delete | truncate | drop |
| --- | --- | --- | --- |
| 类型 | DML | DDL | DDL |
| 回滚 | 可回滚 | 不可回滚 | 不可回滚 |
| 删除内容 | 表结构还在，删除表的全部或者一部分数据行 | 表结构还在，删除表中的所有数据 | 从数据库中删除表，所有的数据行，索引和权限也会被删除 |
| 删除速度 | 删除速度慢，逐行删除 | 删除速度快 | 删除速度最快 |



### 5、说一下大表查询的优化方案

**1、** 优化shema、sql语句+索引；

**2、** 可以考虑加缓存，Memcached, Redis，或者JVM本地缓存；

**3、** 主从复制，读写分离；

**4、** 分库分表；


### 6、为什么索引结构默认使用B+Tree，而不是Hash，二叉树，红黑树？

B+tree：因为B树不管叶子节点还是非叶子节点，都会保存数据，这样导致在非叶子节点中能保存的指针数量变少（有些资料也称为扇出），指针少的情况下要保存大量数据，只能增加树的高度，导致IO操作变多，查询性能变低；

Hash：虽然可以快速定位，但是没有顺序，IO复杂度高。

二叉树：树的高度不均匀，不能自平衡，查找效率跟数据有关（树的高度），并且IO代价高。

红黑树：树的高度随着数据量增加而增加，IO代价高。


### 7、什么是非标准字符串类型？

**1、**  TINYTEXT

**2、**  TEXT

**3、**  MEDIUMTEXT

**4、**  LONGTEXT


### 8、主键、外键和索引的区别？

主键、外键和索引的区别

定义：

主键–唯一标识一条记录，不能有重复的，不允许为空

外键–表的外键是另一表的主键, 外键可以有重复的, 可以是空值

索引–该字段没有重复值，但可以有一个空值

作用：

主键–用来保证数据完整性

外键–用来和其他表建立联系用的

索引–是提高查询排序的速度

个数：

主键–主键只能有一个

外键–一个表可以有多个外键

索引–一个表可以有多个唯一索引


### 9、100.MySQL一条SQL加锁分析

一条SQL加锁，可以分9种情况进行：

**1、** 组合一：id列是主键，RC隔离级别

**2、** 组合二：id列是二级唯一索引，RC隔离级别

**3、** 组合三：id列是二级非唯一索引，RC隔离级别

**4、** 组合四：id列上没有索引，RC隔离级别

**5、** 组合五：id列是主键，RR隔离级别

**6、** 组合六：id列是二级唯一索引，RR隔离级别

**7、** 组合七：id列是二级非唯一索引，RR隔离级别

**8、** 组合八：id列上没有索引，RR隔离级别

**9、** 组合九：Serializable隔离级别


### 10、索引具体采用那种数据结构呢？

常见的MySQL主要有两种结构：hash索引和B+Tree索引，我们使用的是innodb引擎，默认的是B+树。


### 11、InnoDB引擎的4大特性
### 12、MySQL驱动程序是什么？
### 13、创建索引有什么原则呢？
### 14、B+Tree的页子节点都可以存放哪些东西？
### 15、MySQL的binlog有几种录入格式？分别有什么区别？
### 16、SQL的执行顺序
### 17、如何通俗地理解三个范式？
### 18、实践中如何优化MySQL
### 19、组合索引是什么？为什么需要注意组合索引中的顺序？
### 20、Innodb的事务与日志的实现方式
### 21、MySQL 索引使用有哪些注意事项呢？
### 22、在高并发情况下，如何做到安全的修改同一行数据？
### 23、MVCC熟悉吗，它的底层原理？
### 24、什么是SQL？
### 25、索引是什么?
### 26、什么是内连接、外连接、交叉连接、笛卡尔积呢？
### 27、4.说说分库与分表的设计
### 28、存储引擎分类有哪些以及使用场景？
### 29、实践中如何优化MySQL
### 30、数据库三大范式是什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
