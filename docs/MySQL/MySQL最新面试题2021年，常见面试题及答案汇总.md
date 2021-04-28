# MySQL最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、说说对SQL语句优化有哪些方法？（选择几条）

**1、** Where子句中：where表之间的连接必须写在其他Where条件之前，那些可以过滤掉最大数量记录的条件必须写在Where子句的末尾.HAVING最后。

**2、** 用EXISTS替代IN、用NOT EXISTS替代NOT IN。

**3、**  避免在索引列上使用计算

**4、** 避免在索引列上使用IS NULL和IS NOT NULL

**5、** 对查询进行优化，应尽量避免全表扫描，首先应考虑在 where 及 order by 涉及的列上建立索引。

**6、** 应尽量避免在 where 子句中对字段进行 null 值判断，否则将导致引擎放弃使用索引而进行全表扫描

**7、** 应尽量避免在 where 子句中对字段进行表达式操作，这将导致引擎放弃使用索引而进行全表扫描


### 2、为什么要使用数据库

**数据保存在内存**

**优点：**

存取速度快

**缺点：**

数据不能永久保存

**数据保存在文件**

**优点：**数据永久保存

**缺点：**

**1、** 速度比内存操作慢，频繁的IO操作。

**2、** 查询数据不方便

**数据保存在数据库**

**1、** 数据永久保存

**2、** 使用SQL语句，查询方便效率高。

**3、** 管理数据方便


### 3、为表中得字段选择合适得数据类型

字段类型优先级: 整形>date,time>enum,char>varchar>blob,text

优先考虑数字类型，其次是日期或者二进制类型，最后是字符串类型，同级别得数据类型，应该优先选择占用空间小的数据类型



### 4、SQL语句主要分为哪几类

**1、** 数据定义语言DDL（Data Ddefinition Language）CREATE，DROP，ALTER

主要为以上操作 即对逻辑结构等有操作的，其中包括表结构，视图和索引。

**2、** 数据查询语言DQL（Data Query Language）SELECT

这个较为好理解 即查询操作，以select关键字。各种简单查询，连接查询等 都属于DQL。

**3、** 数据操纵语言DML（Data Manipulation Language）INSERT，UPDATE，DELETE

主要为以上操作 即对数据进行操作的，对应上面所说的查询操作 DQL与DML共同构建了多数初级程序员常用的增删改查操作。而查询是较为特殊的一种 被划分到DQL中。

**4、** 数据控制功能DCL（Data Control Language）GRANT，REVOKE，COMMIT，ROLLBACK

主要为以上操作 即对数据库安全性完整性等有操作的，可以简单的理解为权限控制等。


### 5、MySQL数据库作发布系统的存储，一天五万条以上的增量，预计运维三年,怎么优化？

**1、** 设计良好的数据库结构，允许部分数据冗余，尽量避免join查询，提高效率。

**2、** 选择合适的表字段数据类型和存储引擎，适当的添加索引。

**3、** MySQL库主从读写分离。

**4、** 找规律分表，减少单表中的数据量提高查询速度。

**5、** 添加缓存机制，比如Memcached，apc等。

**6、** 不经常改动的页面，生成静态页面。

**7、** 书写高效率的SQL。比如 SELECT * FROM TABEL 改为 SELECT field_1, field_2, field_3 FROM TABLE.


### 6、一条sql执行过长的时间，你如何优化，从哪些方面入手？

**1、** 查看是否涉及多表和子查询，优化Sql结构，如去除冗余字段，是否可拆表等

**2、** 优化索引结构，看是否可以适当添加索引

**3、** 数量大的表，可以考虑进行分离/分表（如交易流水表）

**4、** 数据库主从分离，读写分离

**5、** explain分析sql语句，查看执行计划，优化sql

**6、** 查看MySQL执行日志，分析是否有其他方面的问题


### 7、存储时期

**1、** `Datatime:以 YYYY-MM-DD HH:MM:SS` 格式存储时期时间，精确到秒，占用8个字节得存储空间，datatime类型与时区无关

**2、** Timestamp:以时间戳格式存储，占用4个字节，范围小1970-1-1到2038-1-19，显示依赖于所指定得时区，默认在第一个列行的数据修改时可以自动得修改timestamp列得值

**3、** Date:（生日）占用得字节数比使用字符串.datatime.int储存要少，使用date只需要3个字节，存储日期月份，还可以利用日期时间函数进行日期间得计算

**4、** Time:存储时间部分得数据

**5、** 注意:不要使用字符串类型来存储日期时间数据（通常比字符串占用得储存空间小，在进行查找过滤可以利用日期得函数）

**6、** 使用int存储日期时间不如使用timestamp类型


### 8、MYSQL数据库服务器性能分析的方法命令有哪些?

Show status, 一些值得监控的变量值：

**1、** Bytes_received和Bytes_sent 和服务器之间来往的流量。

**2、** Com_*服务器正在执行的命令。

**3、** Created_*在查询执行期限间创建的临时表和文件。

**4、** Handler_*存储引擎操作。

**5、** Select_*不同类型的联接执行计划。

**6、** Sort_*几种排序信息。

Show profiles 是MySql用来分析当前会话SQL语句执行的资源消耗情况


### 9、MySQL中in 和exists的区别。

这个，跟一下demo来看更刺激吧，啊哈哈

假设表A表示某企业的员工表，表B表示部门表，查询所有部门的所有员工，很容易有以下SQL:

```
select * from A where deptId in (select deptId from B);
```

这样写等价于：

> ❝ 先查询部门表B

select deptId from B

再由部门deptId，查询A的员工

select * from A where A.deptId = B.deptId

❞


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

> ❝ select * from A,先从A表做循环

select * from B where A.deptId = B.deptId,再从B表做循环.

❞


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

因此，我们要选择最外层循环小的，也就是，如果「B的数据量小于A，适合使用in，如果B的数据量大于A，即适合选择exists」，这就是in和exists的区别。


### 10、MySQL中InnoDB支持的四种事务隔离级别名称，以及逐级之间的区别？

SQL标准定义的四个隔离级别为：

**1、**  read uncommited ：读到未提交数据

**2、**  read committed：脏读，不可重复读

**3、**  repeatable read：可重读

**4、**  serializable ：串行事物


### 11、数据库自增主键可能遇到什么问题。
### 12、关心过业务系统里面的sql耗时吗？统计过慢查询吗？对慢查询都怎么优化过？
### 13、SQL 约束有哪几种？
### 14、谈谈MySQL的Explain
### 15、B树和B+树的区别，数据库为什么使用B+树而不是B树？
### 16、如何选择合适的分布式主键方案呢？
### 17、索引能干什么?
### 18、如何显示前50行？
### 19、BLOB和TEXT有什么区别？
### 20、你是如何监控你们的数据库的？你们的慢日志都是怎么查询的？
### 21、什么是最左前缀原则？什么是最左匹配原则？
### 22、索引的底层实现
### 23、数据库中的事务是什么?
### 24、MySQL里记录货币用什么字段类型好
### 25、MySQL中都有哪些触发器？
### 26、从锁的类别上分MySQL都有哪些锁呢？
### 27、数据库索引的原理，为什么要用 B+树，为什么不用二叉树？
### 28、MySQL中有哪几种锁，列举一下？
### 29、varchar(50)中50的涵义
### 30、如何优化长难的查询语句




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
