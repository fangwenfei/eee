# MySQL最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、简单总结下

**1、** MySQL使用B+Tree作为索引数据结构。

**2、** B+Tree在新增数据时，会根据索引指定列的值对旧的B+Tree做调整。

**4、** 从物理存储结构上说，B-Tree和B+Tree都以页(4K)来划分节点的大小，但是由于B+Tree中中间节点不存储数据，因此B+Tree能够在同样大小的节点中，存储更多的key，提高查找效率。

**5、** 影响MySQL查找性能的主要还是磁盘IO次数，大部分是磁头移动到指定磁道的时间花费。

**6、** MyISAM存储引擎下索引和数据存储是分离的，InnoDB索引和数据存储在一起。

**7、** InnoDB存储引擎下索引的实现，(辅助索引)全部是依赖于主索引建立的(辅助索引中叶子结点存储的并不是数据的地址，还是主索引的值，因此，所有依赖于辅助索引的都是先根据辅助索引查到主索引，再根据主索引查数据的地址)。

**8、** 由于InnoDB索引的特性，因此如果主索引不是自增的(id作主键)，那么每次插入新的数据，都很可能对B+Tree的主索引进行重整，影响性能。因此，尽量以自增id作为InnoDB的主索引。




### 2、索引失效情况？ ==校验SQL语句是否使用了索引方式为：

**在SQL语句前面使用explain关键字==**

**1、** like以%开头索引无效，当like以&结尾，索引有效。

**2、** or语句前后没有同事使用索引，当且仅当or语句查询条件的前后列均为索引时，索引生效。

**3、** 组合索引，使用的不是第一列索引时候，索引失效，即最左匹配规则。

**4、** 数据类型出现隐式转换，如varchar不加单引号的时候可能会自动转换为int类型，这个时候索引失效。

**5、** 在索引列上使用IS NULL或者 IS NOT NULL 时候，索引失效，因为索引是不索引空值得。

**6、** 在索引字段上使用，NOT、 <>、！= 、时候是不会使用索引的，对于这样的处理只会进行全表扫描。

**7、** 对索引字段进行计算操作，函数操作时不会使用索引。

**8、** 当全表扫描速度比索引速度快的时候不会使用索引。


### 3、为什么要使用视图？什么是视图？

为了提高复杂SQL语句的复用性和表操作的安全性，MySQL数据库管理系统提供了视图特性。所谓视图，本质上是一种虚拟表，在物理上是不存在的，其内容与真实的表相似，包含一系列带有名称的列和行数据。但是，视图并不在数据库中以储存的数据值形式存在。行和列数据来自定义视图的查询所引用基本表，并且在具体引用视图时动态生成。

视图使开发者只关心感兴趣的某些特定数据和所负责的特定任务，只能看到视图中所定义的数据，而不是视图所引用表中的数据，从而提高了数据库中数据的安全性。


### 4、索引不适合哪些场景

**1、** 数据量少的不适合加索引

**2、** 更新比较频繁的也不适合加索引

**3、** 区分度低的字段不适合加索引（如性别）


### 5、count(1)、count(*) 与 count(列名) 的区别？

**1、** count(*)包括了所有的列，相当于行数，在统计结果的时候，不会忽略列值为NULL

**2、** count(1)包括了忽略所有列，用1代表代码行，在统计结果的时候，不会忽略列值为NULL

**3、** count(列名)只包括列名那一列，在统计结果的时候，会忽略列值为空（这里的空不是只空字符串或者0，而是表示null）的计数，即某个字段值为NULL时，不统计。


### 6、索引有哪几种类型？

**主键索引:** 数据列不允许重复，不允许为NULL，一个表只能有一个主键。

**唯一索引:** 数据列不允许重复，允许为NULL值，一个表允许多个列创建唯一索引。

**1、** 可以通过 `ALTER TABLE table_name ADD UNIQUE (column);` 创建唯一索引

**2、** 可以通过 `ALTER TABLE table_name ADD UNIQUE (column1,column2);` 创建唯一组合索引

**普通索引:** 基本的索引类型，没有唯一性的限制，允许为NULL值。

**1、** 可以通过`ALTER TABLE table_name ADD INDEX index_name (column);`创建普通索引

**2、** 可以通过`ALTER TABLE table_name ADD INDEX index_name(column1, column2, column3);`创建组合索引

**全文索引：** 是目前搜索引擎使用的一种关键技术。

可以通过`ALTER TABLE table_name ADD FULLTEXT (column);`创建全文索引


### 7、列的字符串类型可以是什么？

字符串类型是：

**1、**  SET

**2、**  BLOB

**3、**  ENUM

**4、**  CHAR

**5、**  TEXT


### 8、非聚簇索引一定会回表查询吗？

不一定，如果查询语句的字段全部命中了索引，那么就不必再进行回表查询（哈哈，覆盖索引就是这么回事）。

举个简单的例子，假设我们在学生表的上建立了索引，那么当进行select age from student where age < 20的查询时，在索引的叶子节点上，已经包含了age信息，不会再次进行回表查询。


### 9、MySQL中InnoDB支持的四种事务隔离级别名称，以及逐级之间的区别？

SQL标准定义的四个隔离级别为：

**1、**  read uncommited ：读到未提交数据

**2、**  read committed：脏读，不可重复读

**3、**  repeatable read：可重读

**4、**  serializable ：串行事物


### 10、NULL是什么意思

NULL这个值表示UNKNOWN(未知):它不表示“”(空字符串)。对NULL这个值的任何比较都会生产一个NULL值。您不能把任何值与一个 NULL值进行比较，并在逻辑上希望获得一个答案。

使用IS NULL来进行NULL判断


### 11、LIKE声明中的％和_是什么意思？
### 12、MySQL有关权限的表都有哪几个？
### 13、视图有哪些特点？
### 14、MySQL有关权限的表都有哪几个
### 15、MySQL中有哪几种锁，列举一下？
### 16、何时使用聚簇索引与非聚簇索引
### 17、日志的存放形式
### 18、如何删除索引
### 19、优化关联查询
### 20、MySQL支持事务吗？
### 21、什么是SQL？
### 22、优化特定类型的查询语句
### 23、索引有哪些优缺点？
### 24、对于关系型数据库而言，索引是相当重要的概念，请回答有关索引的几个问题：
### 25、什么是子查询
### 26、linux添加索引
### 27、MySQL数据库cpu飙升的话，要怎么处理呢？
### 28、MySQL为什么这么设计
### 29、什么是存储过程？用什么来调用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
