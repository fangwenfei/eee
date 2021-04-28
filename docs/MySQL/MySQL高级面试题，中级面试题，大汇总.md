# MySQL高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、创建索引的三种方式

在执行CREATE TABLE时创建索引

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

使用ALTER TABLE命令添加索引

```
ALTER TABLE table_name ADD INDEX index_name (column);
```

使用CREATE INDEX命令创建

```
CREATE INDEX index_name ON table_name (column);
```


### 2、MySQL 分页

LIMIT 子句可以被用于强制 SELECT 语句返回指定的记录数。LIMIT 接受一个或两个数字参数。参数必须是一个整数常量。如果给定两个参数，第一个参数指定第一个返回记录行的偏移量，第二个参数指定返回记录行的最大数目。初始记录行的偏移量是 0(而不是 1)

`SELECT * FROM table LIMIT 5,10; // 检索记录行 6-15`

为了检索从某一个偏移量到记录集的结束所有的记录行，可以指定第二个参数为 -1：

`SELECT * FROM table LIMIT 95,-1; // 检索记录行 96-last.`

如果只给定一个参数，它表示返回最大的记录行数目：

`SELECT * FROM table LIMIT 5; //检索前 5 个记录行`

换句话说，LIMIT n 等价于 LIMIT 0,n。


### 3、如果要存储用户的密码散列，应该使用什么字段进行存储？

密码散列，盐，用户身份证号等固定长度的字符串应该使用char而不是varchar来存储，这样可以节省空间且提高检索效率。


### 4、列值为NULL时，查询是否会用到索引？

列值为NULL也是可以走索引的

计划对列进行索引，应尽量避免把它设置为可空，因为这会让 MySQL 难以优化引用了可空列的查询，同时增加了引擎的复杂度


### 5、UNION与UNION ALL的区别？

**1、** 如果使用UNION ALL，不会合并重复的记录行

**2、** 效率 UNION 高于 UNION ALL


### 6、SQL语句优化的一些方法

**1、** 对查询进行优化，应尽量避免全表扫描，首先应考虑在 where 及 order by 涉及的列上建立索引。

**2、** 应尽量避免在 where 子句中对字段进行 null 值判断，否则将导致引擎放弃使用索引而进行全表扫描，如：

```
select id from t where num is null
-- 可以在num上设置默认值0，确保表中num列没有null值，然后这样查询：
select id from t where num=0
```

**3、** 应尽量避免在 where 子句中使用!=或<>操作符，否则引擎将放弃使用索引而进行全表扫描。

**4、** 应尽量避免在 where 子句中使用or 来连接条件，否则将导致引擎放弃使用索引而进行全表扫描，如：

```
select id from t where num=10 or num=20
-- 可以这样查询：
select id from t where num=10 union all select id from t where num=20
```

5、in 和 not in 也要慎用，否则会导致全表扫描，如：

```
select id from t where num in(1,2,3) 
-- 对于连续的数值，能用 between 就不要用 in 了：
select id from t where num between 1 and 3
```

**6、** 下面的查询也将导致全表扫描：select id from t where name like ‘%李%’若要提高效率，可以考虑全文检索。

**7、** 如果在 where 子句中使用参数，也会导致全表扫描。因为SQL只有在运行时才会解析局部变量，但优化程序不能将访问计划的选择推迟到运行时；它必须在编译时进行选择。然 而，如果在编译时建立访问计划，变量的值还是未知的，因而无法作为索引选择的输入项。如下面语句将进行全表扫描：

```
select id from t where num=@num
-- 可以改为强制查询使用索引：
select id from t with(index(索引名)) where num=@num
```

**8、** 应尽量避免在 where 子句中对字段进行表达式操作，这将导致引擎放弃使用索引而进行全表扫描。如：

```
select id from t where num/2=100
-- 应改为:
select id from t where num=100*2
```

**9、** 应尽量避免在where子句中对字段进行函数操作，这将导致引擎放弃使用索引而进行全表扫描。如：

```
select id from t where substring(name,1,3)=’abc’
-- name以abc开头的id应改为:
select id from t where name like ‘abc%’
```

**10、** 不要在 where 子句中的“=”左边进行函数、算术运算或其他表达式运算，否则系统将可能无法正确使用索引。


### 7、如果要存储用户的密码散列，应该使用什么字段进行存储？

密码散列，盐，用户身份证号等固定长度的字符串，应该使用char而不是varchar来存储，这样可以节省空间且提高检索效率。


### 8、MySQL中in 和exists的区别。

这个，跟一下demo来看更刺激吧，啊哈哈

假设表A表示某企业的员工表，表B表示部门表，查询所有部门的所有员工，很容易有以下SQL:

```
select * from A where deptId in (select deptId from B);
```

**这样写等价于：**

**1、** 先查询部门表B

**2、** select deptId from B

**3、** 再由部门deptId，查询A的员工

**4、** select * from A where A.deptId = B.deptId

可以抽象成这样的一个循环：

```
List<> resultSet ;
 for(int i=0;i<B.length;i++) {
       for(int j=0;j<A.length;j++) {
       if(A[i].id==B[j].id) {
          resultSet.add(A[i]);
          break;
       }
    }
 }
```

显然，除了使用in，我们也可以用exists实现一样的查询功能，如下：

```
select * from A where exists (select 1 from B where A.deptId = B.deptId);
```

因为exists查询的理解就是，先执行主查询，获得数据后，再放到子查询中做条件验证，根据验证结果（true或者false），来决定主查询的数据结果是否得意保留。

那么，这样写就等价于：

> select * from A,先从A表做循环

> select * from B where A.deptId = B.deptId,再从B表做循环.


同理，可以抽象成这样一个循环：

```
   List<> resultSet ;
    for(int i=0;i<A.length;i++) {
          for(int j=0;j<B.length;j++) {
          if(A[i].deptId==B[j].deptId) {
             resultSet.add(A[i]);
             break;
          }
       }
    }
```

数据库最费劲的就是跟程序链接释放。假设链接了两次，每次做上百万次的数据集查询，查完就走，这样就只做了两次；相反建立了上百万次链接，申请链接释放反复重复，这样系统就受不了了。即MySQL优化原则，就是小表驱动大表，小的数据集驱动大的数据集，从而让性能更优。

因此，我们要选择最外层循环小的，也就是，如果**B的数据量小于A，适合使用in，如果B的数据量大于A，即适合选择exists**，这就是in和exists的区别。


### 9、MySQL中int(10)和char(10)以及varchar(10)的区别

**1、** int(10)的10表示显示的数据的长度，不是存储数据的大小；chart(10)和varchar(10)的10表示存储数据的大小，即表示存储多少个字符。

**2、** char(10)表示存储定长的10个字符，不足10个就用空格补齐，占用更多的存储空间

**3、** varchar(10)表示存储10个变长的字符，存储多少个就是多少个，空格也按一个字符存储，这一点是和char(10)的空格不同的，char(10)的空格表示占位不算一个字符


### 10、NOW（）和CURRENT_DATE（）有什么区别？

NOW（）命令用于显示当前年份，月份，日期，小时，分钟和秒。

CURRENT_DATE（）仅显示当前年份，月份和日期。


### 11、MySQL中InnoDB支持的四种事务隔离级别名称，以及逐级之间的区别？
### 12、完整性约束包括哪些？
### 13、MySQL的复制原理以及流程
### 14、聚集索引与非聚集索引的区别
### 15、事务的隔离级别有哪些？MySQL的默认隔离级别是什么？
### 16、MySQL 的内连接、左连接、右连接有什么区别？
### 17、MySQL的复制原理以及流程
### 18、慢查询日志
### 19、视图的优点，缺点，讲一下？
### 20、索引有哪几种类型？
### 21、什么是通用SQL函数？
### 22、你怎么看到为表格定义的所有索引？
### 23、什么是触发器？触发器的使用场景有哪些？
### 24、索引使用场景
### 25、超键、候选键、主键、外键分别是什么？
### 26、一条SQL语句在MySQL中如何执行的？
### 27、超大分页怎么处理？
### 28、对MySQL的锁了解吗
### 29、什么是脏读？幻读？不可重复读？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
