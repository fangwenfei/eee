# MySQL最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是触发器？触发器的使用场景有哪些？

「触发器」，指一段代码，当触发某个事件时，自动执行这些代码。

**「使用场景：」**

**1、** 可以通过数据库中的相关表实现级联更改。

**2、** 实时监控某张表中的某个字段的更改而需要做出相应的处理。

**3、** 例如可以生成某些业务的编号。

**4、** 注意不要滥用，否则会造成数据库及应用程序的维护困难。


### 2、MySQL数据库作发布系统的存储，一天五万条以上的增量，预计运维三年,怎么优化？

**1、** 设计良好的数据库结构，允许部分数据冗余，尽量避免join查询，提高效率。

**2、** 选择合适的表字段数据类型和存储引擎，适当的添加索引。

**3、** MySQL库主从读写分离。

**4、** 找规律分表，减少单表中的数据量提高查询速度。

**5、** 添加缓存机制，比如Memcached，apc等。

**6、** 不经常改动的页面，生成静态页面。

**7、** 书写高效率的SQL。比如 SELECT * FROM TABEL 改为 SELECT field_1, field_2, field_3 FROM TABLE.


### 3、什么是存储过程？用什么来调用？

存储过程是一个预编译的SQL语句，优点是允许模块化的设计，就是说只需创建一次，以后在该程序中就可以调用多次。如果某次操作需要执行多次SQL，使用存储过程比单纯SQL语句执行要快。可以用一个命令对象来调用存储过程。


### 4、你是否做过主从一致性校验，如果有，怎么做的，如果没有，你打算怎么做？

主从一致性校验有多种工具 例如checksum、MySQLdiff、pt-table-checksum等


### 5、事务的隔离级别有哪些？MySQL的默认隔离级别是什么？

**1、** 读未提交（Read Uncommitted）

**2、** 读已提交（Read Committed）

**3、** 可重复读（Repeatable Read）

**4、** 串行化（Serializable）

MySQL默认的事务隔离级别是可重复读(Repeatable Read)


### 6、创建索引的三种方式

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


### 7、MySQL中TEXT数据类型的最大长度

**1、** TINYTEXT：256 bytes

**2、** TEXT：65,535 bytes(64kb)

**3、** MEDIUMTEXT：16,777,215 bytes(16MB)

**4、** LONGTEXT：4,294,967,295 bytes(4GB)


### 8、B+树在满足聚簇索引和覆盖索引的时候不需要回表查询数据，
### 9、覆盖索引、回表等这些，了解过吗？
### 10、Blob和text有什么区别？
### 11、MySQL存储引擎MyISAM与InnoDB区别
### 12、最左匹配原则？
### 13、事物的四大特性(ACID)介绍一下?
### 14、varchar(50)中50的涵义
### 15、数据库存储日期格式时，如何考虑时区转换问题？
### 16、索引分类？
### 17、myisamchk是用来做什么的？
### 18、什么是最左前缀原则？什么是最左匹配原则？
### 19、使用悲观锁
### 20、innoDB的B+Tree 存储整行数据和主键的值得区别？
### 21、MySQL里记录货币用什么字段类型好
### 22、数据库中的事务是什么?
### 23、MYSQL的主从延迟，你怎么解决？
### 24、drop、delete与truncate的区别
### 25、MySQL数据库cpu飙升的话，要怎么处理呢？
### 26、对MySQL的锁了解吗
### 27、什么是SQL？
### 28、什么是聚簇索引？何时使用聚簇索引与非聚簇索引
### 29、SQL语言包括哪几部分？每部分都有哪些操作关键字？
### 30、谈谈MySQL的Explain




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
