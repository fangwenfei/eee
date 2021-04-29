# MySQL最新基础面试题及答案整理

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、FLOAT和DOUBLE的区别是什么？

**1、** FLOAT类型数据可以存储至多8位十进制数，并在内存中占4字节。

**2、** DOUBLE类型数据可以存储至多18位十进制数，并在内存中占8字节。


### 2、在高并发情况下，如何做到安全的修改同一行数据？

要安全的修改同一行数据，就要保证一个线程在修改时其它线程无法更新这行记录。一般有悲观锁和乐观锁两种方案~

**使用悲观锁**

悲观锁思想就是，当前线程要进来修改数据时，别的线程都得拒之门外~

比如，可以使用select…for update ~

```
select * from User where name=‘jay’ for update
```

以上这条sql语句会锁定了User表中所有符合检索条件（name=‘jay’）的记录。本次事务提交之前，别的线程都无法修改这些记录。

**使用乐观锁**

乐观锁思想就是，有线程过来，先放过去修改，如果看到别的线程没修改过，就可以修改成功，如果别的线程修改过，就修改失败或者重试。实现方式：乐观锁一般会使用版本号机制或CAS算法实现。


### 3、MySQL中TEXT数据类型的最大长度

**1、** TINYTEXT：256 bytes

**2、** TEXT：65,535 bytes(64kb)

**3、** MEDIUMTEXT：16,777,215 bytes(16MB)

**4、** LONGTEXT：4,294,967,295 bytes(4GB)

**1、** 
### 4、什么是最左前缀原则？什么是最左匹配原则？

最左前缀原则，就是最左优先，在创建多列索引时，要根据业务需求，where子句中使用最频繁的一列放在最左边。

当我们创建一个组合索引的时候，如(k1,k2,k3)，相当于创建了（k1）、(k1,k2)和(k1,k2,k3)三个索引，这就是最左匹配原则。。


### 5、如果一个表有一列定义为TIMESTAMP，将发生什么？

每当行被更改时，时间戳字段将获取当前时间戳。

**列设置为AUTO INCREMENT时，如果在表中达到最大值，会发生什么情况？**

它会停止递增，任何进一步的插入都将产生错误，因为密钥已被使用。

**怎样才能找出最后一次插入时分配了哪个自动增量？**

LAST_INSERT_ID将返回由Auto_increment分配的最后一个值，并且不需要指定表名称。


### 6、SQL注入漏洞产生的原因？如何防止？

SQL注入产生的原因：程序开发过程中不注意规范书写sql语句和对特殊字符进行过滤，导致客户端可以通过全局变量POST和GET提交一些sql语句正常执行。

**防止SQL注入的方式：**

**1、** 开启配置文件中的magic_quotes_gpc 和 magic_quotes_runtime设置

**2、** 执行sql语句时使用addslashes进行sql语句转换

**3、** Sql语句书写尽量不要省略双引号和单引号。

**4、** 过滤掉sql语句中的一些关键词：update、insert、delete、select、 * 。

**5、** 提高数据库表和字段的命名技巧，对一些重要的字段根据程序的特点命名，取不易被猜到的。


### 7、B树和B+树的区别，数据库为什么使用B+树而不是B树？

在B树中，键和值即存放在内部节点又存放在叶子节点；在B+树中，内部节点只存键，叶子节点则同时存放键和值。

B+树的叶子节点有一条链相连，而B树的叶子节点各自独立的。

B+树索引的所有数据均存储在叶子节点，而且数据是按照顺序排列的，链表连着的。那么B+树使得范围查找，排序查找，分组查找以及去重查找变得异常简单。.

B+树非叶子节点上是不存储数据的，仅存储键值，而B树节点中不仅存储键值，也会存储数据。innodb中页的默认大小是16KB，如果不存储数据，那么就会存储更多的键值，相应的树的阶数（节点的子节点树）就会更大，树就会更矮更胖，如此一来我们查找数据进行磁盘的IO次数有会再次减少，数据查询的效率也会更快.


### 8、关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？

**1、** 我们平时写Sql时，都要养成用explain分析的习惯。

**2、** 慢查询的统计，运维会定期统计给我们

**优化慢查询：**

**1、** 分析语句，是否加载了不必要的字段/数据。

**2、** 分析SQl执行句话，是否命中索引等。

**3、** 如果SQL很复杂，优化SQL结构

**4、** 如果表数据量太大，考虑分表


### 9、六种关联查询

**1、** 交叉连接（CROSS JOIN）

**2、** 内连接（INNER JOIN）

**3、** 外连接（LEFT JOIN/RIGHT JOIN）

**4、** 联合查询（UNION与UNION ALL）

**5、** 全连接（FULL JOIN）

**6、** 交叉连接（CROSS JOIN）

```
SELECT * FROM A,B(,C)或者SELECT * FROM A CROSS JOIN B (CROSS JOIN C)#没有任何关联条件，结果是笛卡尔积，结果集会很大，没有意义，很少使用内连接（INNER JOIN）SELECT * FROM A,B WHERE A.id=B.id或者SELECT * FROM A INNER JOIN B ON A.id=B.id多表中同时符合某种条件的数据记录的集合，INNER JOIN可以缩写为JOIN
```

**内连接分为三类**

**1、** 等值连接：ON A.id=B.id

**2、** 不等值连接：ON A.id > B.id

**3、** 自连接：SELECT * FROM A T1 INNER JOIN A T2 ON T1.id=T2.pid

**外连接（LEFT JOIN/RIGHT JOIN）**

**左外连接：**

LEFT OUTER JOIN, 以左表为主，先查询出左表，按照ON后的关联条件匹配右表，没有匹配到的用NULL填充，可以简写成LEFT JOIN

**右外连接：**

RIGHT OUTER JOIN, 以右表为主，先查询出右表，按照ON后的关联条件匹配左表，没有匹配到的用NULL填充，可以简写成RIGHT JOIN

**联合查询（UNION与UNION ALL）**

```
SELECT * FROM A UNION SELECT * FROM B UNION ...
```

**1、** 就是把多个结果集集中在一起，UNION前的结果为基准，需要注意的是联合查询的列数要相等，相同的记录行会合并

**2、** 如果使用UNION ALL，不会合并重复的记录行

**3、** 效率 UNION 高于 UNION ALL

**全连接（FULL JOIN）**

```
SELECT * FROM A LEFT JOIN B ON A.id=B.id UNIONSELECT * FROM A RIGHT JOIN B ON A.id=B.id
```

MySQL不支持全连接

可以使用LEFT JOIN 和UNION和RIGHT JOIN联合使用

**有2张表**

1张R、1张S，R表有ABC三列，S表有CD两列，表中各有三条记录

**R表**

| A | B | C |
| --- | --- | --- |
| a1 | b1 | c1 |
| a2 | b2 | c2 |
| a3 | b3 | c3 |


**S表**

| C | D |
| --- | --- |
| c1 | d1 |
| c2 | d2 |
| c4 | d3 |


**交叉连接(笛卡尔积)**

SQL

```
select r.*,s.* from r,s
```

**结果**

| A | B | C | C | D |
| --- | --- | --- | --- | --- |
| a1 | b1 | c1 | c1 | d1 |
| a2 | b2 | c2 | c1 | d1 |
| a3 | b3 | c3 | c1 | d1 |
| a1 | b1 | c1 | c2 | d2 |
| a2 | b2 | c2 | c2 | d2 |
| a3 | b3 | c3 | c2 | d2 |
| a1 | b1 | c1 | c4 | d3 |
| a2 | b2 | c2 | c4 | d3 |
| a3 | b3 | c3 | c4 | d3 |


**内连接结果**

SQL

```
select r.*,s.* from r inner join s on r.c=s.c
```

**结果**

| A | B | C | C | D |
| --- | --- | --- | --- | --- |
| a1 | b1 | c1 | c1 | d1 |
| a2 | b2 | c2 | c2 | d2 |


**左连接结果**

SQL

```
select r.*,s.* from r left join s on r.c=s.c
```

**结果**

| A | B | C | C | D |
| --- | --- | --- | --- | --- |
| a1 | b1 | c1 | c1 | d1 |
| a2 | b2 | c2 | c2 | d2 |
| a3 | b3 | c3 |  |  |


**右连接结果**

SQL

```
select r.*,s.* from r right join s on r.c=s.c
```

**结果**

| A | B | C | C | D |
| --- | --- | --- | --- | --- |
| a1 | b1 | c1 | c1 | d1 |
| a2 | b2 | c2 | c2 | d2 |
|  |  |  | c4 | d3 |


**全表连接的结果（MySql不支持，Oracle支持）**

SQL

```
select r.*,s.* from r full join s on r.c=s.c
```

**结果**

| A | B | C | C | D |
| --- | --- | --- | --- | --- |
| a1 | b1 | c1 | c1 | d1 |
| a2 | b2 | c2 | c2 | d2 |
| a3 | b3 | c3 |  |  |
|  |  |  | c4 | d3 |



### 10、MySQL驱动程序是什么？

这个jar包： MySQL-connector-java-5.1.18.jar

MySQL驱动程序主要帮助编程语言与 MySQL服务端进行通信，如连接、传输数据、关闭等。


### 11、MySQL中 in 和 exists 区别
### 12、创建索引的原则？
### 13、MySQL数据库作发布系统的存储，一天五万条以上的增量，预计运维三年,怎么优化？
### 14、MySQL如何优化DISTINCT？
### 15、关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？
### 16、索引分类？
### 17、Hash索引和B+树区别是什么？你在设计索引是怎么抉择的？
### 18、NOW（）和CURRENT_DATE（）有什么区别？
### 19、你们数据库是否支持emoji表情存储，如果不支持，如何操作？
### 20、怎么创建索引的，有什么好处，有哪些分类
### 21、既然提到了InnoDB使用户的B+树的索引模型
### 22、视图的优点，缺点，讲一下？
### 23、超键、候选键、主键、外键分别是什么？
### 24、MVCC熟悉吗，它的底层原理？
### 25、前缀索引
### 26、Hash索引和B+树所有有什么区别或者说优劣呢?
### 27、创建索引的原则
### 28、如果要存储用户的密码散列，应该使用什么字段进行存储？
### 29、索引有哪些优缺点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
