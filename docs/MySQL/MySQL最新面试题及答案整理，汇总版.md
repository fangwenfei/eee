# MySQL最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、innoDB的B+Tree 存储整行数据和主键的值得区别？

**1、** 整行数据：innoDB的B+Tree存储了整行数据的是主键索引，也被成为聚凑索引。

**2、** 存储主键的值：成为非主键索引，也被称为非聚凑索引


### 2、说一下数据库的三大范式

**1、** 第一范式：数据表中的每一列（每个字段）都不可以再拆分。

**2、** 第二范式：在第一范式的基础上，分主键列完全依赖于主键，而不能是依赖于主键的一部分。

**3、** 第三范式：在满足第二范式的基础上，表中的非主键只依赖于主键，而不依赖于其他非主键。


### 3、创建索引的三种方式

**第一种方式：**在执行CREATE TABLE时创建索引

```
CREATE TABLE user\_index2 ( id INT auto\_increment PRIMARY KEY, first\_name VARCHAR (16), last\_name VARCHAR (16), id\_card VARCHAR (18), information text, KEY name (first\_name, last\_name), FULLTEXT KEY (information), UNIQUE KEY (id\_card) );
```

**第二种方式：**使用ALTER TABLE命令去增加索引

```
ALTER TABLE table_name ADD INDEX index_name (column_list);
```

**1、** ALTER TABLE用来创建普通索引、UNIQUE索引或PRIMARY KEY索引。

**2、** 其中table_name是要增加索引的表名，column_list指出对哪些列进行索引，多列时各列之间用逗号分隔。

**3、** 索引名index_name可自己命名，缺省时，MySQL将根据第一个索引列赋一个名称。另外，ALTER TABLE允许在单个语句中更改多个表，因此可以在同时创建多个索引。

**4、** 第三种方式：使用CREATE INDEX命令创建

```
CREATE INDEX index_name ON table_name (column_list);
```

CREATE INDEX可对表增加普通索引或UNIQUE索引。（但是，不能创建PRIMARY KEY索引）


### 4、乐观锁：

乐观锁的“乐观情绪”体现在，它认为数据的变动不会太频繁。因此，它允许多个事务同时对数据进行变动。实现方式：乐观锁一般会使用版本号机制或CAS算法实现。


### 5、100.MySQL一条SQL加锁分析

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


### 6、超键、候选键、主键、外键分别是什么？

**1、** 超键：在关系模式中，能唯一知标识元组的属性集称为超键。

**2、** 候选键：是最小超键，即没有冗余元素的超键。

**3、** 主键：数据库表中对储存数据对象予以唯一和完整标识的数据列或属性的组合。一个数据列只能有一个主键，且主键的取值不能缺失，即不能为空值（Null）。

**4、** 外键：在一个表中存在的另一个表的主键称此表的外键。。


### 7、关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？

**1、** 我们平时写Sql时，都要养成用explain分析的习惯。

**2、** 慢查询的统计，运维会定期统计给我们

**优化慢查询：**

**1、** 分析语句，是否加载了不必要的字段/数据。

**2、** 分析SQl执行句话，是否命中索引等。

**3、** 如果SQL很复杂，优化SQL结构

**4、** 如果表数据量太大，考虑分表


### 8、索引算法有哪些？

索引算法有 BTree算法和Hash算法

**BTree算法**

BTree是最常用的MySQL数据库索引算法，也是MySQL默认的算法。因为它不仅可以被用在=,>,>=,<,<=和between这些比较操作符上，而且还可以用于like操作符，只要它的查询条件是一个不以通配符开头的常量， 例如：

```
-- 只要它的查询条件是一个不以通配符开头的常量
select * from user where name like 'jack%'; 
-- 如果一通配符开头，或者没有使用常量，则不会使用索引，例如： 
select * from user where name like '%jack';
```

**Hash算法**

Hash Hash索引只能用于对等比较，例如=,<=>（相当于=）操作符。由于是一次定位数据，不像BTree索引需要从根节点到枝节点，最后才能访问到页节点这样多次IO访问，所以检索效率远高于BTree索引。


### 9、什么情况下设置了索引但无法使用

**1、** 以“%”开头的LIKE语句，模糊匹配

**2、** OR语句前后没有同时使用索引

**3、** 数据类型出现隐式转化（如varchar不加单引号的话可能会自动转换为int型）


### 10、按照锁的粒度分，数据库锁有哪些呢？锁机制与InnoDB锁算法

![](https://user-gold-cdn.xitu.io/2020/5/23/1724129062f57007?w=1280&h=687&f=png&s=248056#alt=)

**1、** 按锁粒度分有：表锁，页锁，行锁

**2、** 按锁机制分有：乐观锁，悲观锁


### 11、如何选择合适的分布式主键方案呢？
### 12、你是否做过主从一致性校验，如果有，怎么做的，如果没有，你打算怎么做？
### 13、在高并发情况下，如何做到安全的修改同一行数据？
### 14、视图的使用场景有哪些？
### 15、MySQL里记录货币用什么字段类型比较好？
### 16、MySQL的binlog有几种录入格式？分别有什么区别？
### 17、MySQL一条SQL加锁分析
### 18、隔离级别与锁的关系
### 19、什么是最左前缀原则？什么是最左匹配原则？
### 20、一条SQL语句在MySQL中如何执行的？
### 21、你怎么看到为表格定义的所有索引？
### 22、简述有哪些索引和作用
### 23、覆盖索引、回表等这些，了解过吗？
### 24、MySQL存储引擎MyISAM与InnoDB区别
### 25、MySQL数据库cpu飙升的话，要怎么处理呢？
### 26、覆盖索引是什么？
### 27、主键和候选键有什么区别？
### 28、索引具体采用那种数据结构呢？
### 29、实践中如何优化MySQL
### 30、数据库自增主键可能遇到什么问题。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
