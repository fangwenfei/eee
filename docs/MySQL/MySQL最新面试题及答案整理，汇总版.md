# MySQL最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、什么是存储过程？有哪些优缺点？

「存储过程」，就是一些编译好了的SQL语句，这些SQL语句代码像一个方法一样实现一些功能（对单表或多表的增删改查），然后给这些代码块取一个名字，在用到这个功能的时候调用即可。

**「优点：」**

**1、** 存储过程是一个预编译的代码块，执行效率比较高

**2、** 存储过程在服务器端运行，减少客户端的压力

**3、** 允许模块化程序设计，只需要创建一次过程，以后在程序中就可以调用该过程任意次，类似方法的复用

**4、** 一个存储过程替代大量T_SQL语句 ，可以降低网络通信量，提高通信速率

**5、** 可以一定程度上确保数据安全

**「缺点：」**

**1、** 调试麻烦

**2、** 可移植性不灵活

**3、** 重新编译问题



### 2、MySQL5.6和MySQL5.7对索引做了哪些优化？

**1、** MySQL5.6引入了索引下推优化，默认是开启的。

**2、** 例子：user表中（a,b,c）构成一个索引。

**3、** select * from user where a='23' and b like '%eqw%' and c like 'dasd'。

**4、** 解释：如果没有索引下推原则，则MySQL会通过a='23' 先查询出一个对应的数据。然后返回到MySQL服务端。MySQL服务端再基于两个like模糊查询来校验and查询出的数据是否符合条件。这个过程就设计到回表操作。

**5、** 如果使用了索引下推技术，则MySQL会首先返回返回条件a='23'的数据的索引，然后根据模糊查询的条件来校验索引行数据是否符合条件，如果符合条件，则直接根据索引来定位对应的数据，如果不符合直接reject掉。因此，有了索引下推优化，可以在有like条件的情况下，减少回表的次数。


### 3、关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？

**1、** 我们平时写Sql时，都要养成用explain分析的习惯。

**2、** 慢查询的统计，运维会定期统计给我们

**优化慢查询：**

**1、** 分析语句，是否加载了不必要的字段/数据。

**2、** 分析SQl执行句话，是否命中索引等。

**3、** 如果SQL很复杂，优化SQL结构

**4、** 如果表数据量太大，考虑分表


### 4、最左匹配原则？

在创建联合索引时候，一般需要遵循最左匹配原则。即联合索引中的属性识别度最高的放在查询语句的最前面。


### 5、使用B+树的好处

由于B+树的内部节点只存放键，不存放值，因此，一次读取，可以在内存页中获取更多的键，有利于更快地缩小查找范围。 B+树的叶节点由一条链相连，因此，当需要进行一次全数据遍历的时候，B+树只需要使用O(logN)时间找到最小的一个节点，然后通过链进行O(N)的顺序遍历即可。而B树则需要对树的每一层进行遍历，这会需要更多的内存置换次数，因此也就需要花费更多的时间


### 6、BLOB和TEXT有什么区别？

BLOB是一个二进制对象，可以容纳可变数量的数据。TEXT是一个不区分大小写的BLOB。

BLOB和TEXT类型之间的唯一区别在于对BLOB值进行排序和比较时区分大小写，对TEXT值不区分大小写。


### 7、什么是幻读，脏读，不可重复读呢？

**1、** 事务A、B交替执行，事务A被事务B干扰到了，因为事务A读取到事务B未提交的数据,这就是「脏读」

**2、** 在一个事务范围内，两个相同的查询，读取同一条记录，却返回了不同的数据，这就是「不可重复读」。

**3、** 事务A查询一个范围的结果集，另一个并发事务B往这个范围中插入/删除了数据，并静悄悄地提交，然后事务A再次查询相同的范围，两次读取得到的结果集不一样了，这就是「幻读」。


### 8、什么是存储过程？有哪些优缺点？

**存储过程**，就是一些编译好了的SQL语句，这些SQL语句代码像一个方法一样实现一些功能（对单表或多表的增删改查），然后给这些代码块取一个名字，在用到这个功能的时候调用即可。

**优点：**

**1、** 存储过程是一个预编译的代码块，执行效率比较高

**2、** 存储过程在服务器端运行，减少客户端的压力

**3、** 允许模块化程序设计，只需要创建一次过程，以后在程序中就可以调用该过程任意次，类似方法的复用

**4、** 一个存储过程替代大量T_SQL语句 ，可以降低网络通信量，提高通信速率

**5、** 可以一定程度上确保数据安全

**缺点：**

**1、** 调试麻烦

**2、** 可移植性不灵活

**3、** 重新编译问题


### 9、LIKE声明中的％和_是什么意思？

％对应于0个或更多字符，_只是LIKE语句中的一个字符。

**如何在Unix和MySQL时间戳之间进行转换？**

UNIX_TIMESTAMP是从MySQL时间戳转换为Unix时间戳的命令

FROM_UNIXTIME是从Unix时间戳转换为MySQL时间戳的命令


### 10、六种关联查询

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



### 11、什么是触发器？触发器的使用场景有哪些？
### 12、什么是通用SQL函数？
### 13、InnoDB引擎中的索引策略，了解过吗？
### 14、乐观锁：
### 15、MySQL如何获取当前日期？
### 16、MySQL有关权限的表有哪几个呢？
### 17、什么是游标？
### 18、索引的一些潜规则
### 19、你是否做过主从一致性校验，如果有，怎么做的，如果没有，你打算怎么做？
### 20、FLOAT和DOUBLE的区别是什么？
### 21、优化数据库的方法
### 22、在高并发情况下，如何做到安全的修改同一行数据？
### 23、MySQL如何优化DISTINCT？
### 24、如何优化长难的查询语句
### 25、视图有哪些特点？哪些使用场景？
### 26、索引的分类?
### 27、MyISAM Static和MyISAM Dynamic有什么区别？
### 28、MySQL中有哪些不同的表格？
### 29、数据库中间件了解过吗，sharding jdbc，mycat？
### 30、从锁的类别上分MySQL都有哪些锁呢？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
