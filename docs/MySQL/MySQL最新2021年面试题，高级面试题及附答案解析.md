# MySQL最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、非主键索引一定会查询多次吗？

不一定的？因为通过覆盖索引也可以只查询一次。


### 2、SQL的生命周期？

**1、** 服务器与数据库建立连接

**2、** 数据库进程拿到请求sql

**3、** 解析并生成执行计划，执行

**4、** 读取数据到内存，并进行逻辑处理

**5、** 通过步骤一的连接，发送结果到客户端

**6、** 关掉连接，释放资源


### 3、B+树在满足聚簇索引和覆盖索引的时候不需要回表查询数据，

在B+树的索引中，叶子节点可能存储了当前的key值，也可能存储了当前的key值以及整行的数据，这就是聚簇索引和非聚簇索引。 在InnoDB中，只有主键索引是聚簇索引，如果没有主键，则挑选一个唯一键建立聚簇索引。如果没有唯一键，则隐式的生成一个键来建立聚簇索引。

`当查询使用聚簇索引时，在对应的叶子节点，可以获取到整行数据，因此不用再次进行回表查询。`


### 4、什么是数据库连接池?为什么需要数据库连接池呢?

「连接池基本原理：」 数据库连接池原理：在内部对象池中，维护一定数量的数据库连接，并对外暴露数据库连接的获取和返回方法。

**「应用程序和数据库建立连接的过程：」**

**1、** 通过TCP协议的三次握手和数据库服务器建立连接

**2、** 发送数据库用户账号密码，等待数据库验证用户身份

**3、** 完成身份验证后，系统可以提交SQL语句到数据库执行

**4、** 把连接关闭，TCP四次挥手告别。

**「数据库连接池好处：」**

**1、** 资源重用 (连接复用)

**2、** 更快的系统响应速度

**3、** 新的资源分配手段

**4、** 统一的连接管理，避免数据库连接泄漏


### 5、如何显示前50行？

在MySQL中，使用以下代码查询显示前50行：

SELECT*FROM

LIMIT 0,50;


### 6、MySQL数据库cpu飙升到500%的话他怎么处理？

**1、** 当 cpu 飙升到 500%时，先用操作系统命令 top 命令观察是不是 MySQLd 占用导致的，如果不是，找出占用高的进程，并进行相关处理。

**2、** 如果是 MySQLd 造成的， show processlist，看看里面跑的 session 情况，是不是有消耗资源的 sql 在运行。找出消耗高的 sql，看看执行计划是否准确， index 是否缺失，或者实在是数据量太大造成。

**3、** 一般来说，肯定要 kill 掉这些线程(同时观察 cpu 使用率是否下降)，等进行相应的调整(比如说加索引、改 sql、改内存参数)之后，再重新跑这些 SQL。

**4、** 也有可能是每个 sql 消耗资源并不多，但是突然之间，有大量的 session 连进来导致 cpu 飙升，这种情况就需要跟应用一起来分析为何连接数会激增，再做出相应的调整，比如说限制连接数等


### 7、SQL注入漏洞产生的原因？如何防止？

SQL注入产生的原因：程序开发过程中不注意规范书写sql语句和对特殊字符进行过滤，导致客户端可以通过全局变量POST和GET提交一些sql语句正常执行。

**防止SQL注入的方式：**

**1、** 开启配置文件中的magic_quotes_gpc 和 magic_quotes_runtime设置

**2、** 执行sql语句时使用addslashes进行sql语句转换

**3、** Sql语句书写尽量不要省略双引号和单引号。

**4、** 过滤掉sql语句中的一些关键词：update、insert、delete、select、 * 。

**5、** 提高数据库表和字段的命名技巧，对一些重要的字段根据程序的特点命名，取不易被猜到的。


### 8、如何写sql能够有效的使用到复合索引。

复合索引，也叫组合索引，用户可以在多个列上建立索引,这种索引叫做复合索引。

当我们创建一个组合索引的时候，如(k1,k2,k3)，相当于创建了（k1）、(k1,k2)和(k1,k2,k3)三个索引，这就是最左匹配原则。

```
select * from table where k1=A AND k2=B AND k3=D
```

有关于复合索引，我们需要关注查询Sql条件的顺序，确保最左匹配原则有效，同时可以删除不必要的冗余索引。


### 9、读写分离有哪些解决方案？

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


### 10、MVCC熟悉吗，它的底层原理？

MVCC,多版本并发控制,它是通过读取历史版本的数据，来降低并发事务冲突，从而提高并发性能的一种机制。

**MVCC需要关注这几个知识点：**

**1、** 事务版本号

**2、** 表的隐藏列

**3、** undo log

**4、** read view


### 11、使用乐观锁
### 12、索引有哪些优缺点？
### 13、500台db，在最快时间之内重启。
### 14、MySQL中TEXT数据类型的最大长度
### 15、字段为什么要求定义为not null？
### 16、一个6亿的表a，一个3亿的表b，通过外间tid关联，你如何最快的查询出满足条件的第50000到第50200中的这200条数据记录。
### 17、简单描述MySQL中，索引，主键，唯一索引，联合索引的区别，对数据库的性能有什么影响（从读写两方面）
### 18、varchar(50)中50的涵义
### 19、创建索引的三种方式
### 20、SQL语言包括哪几部分？每部分都有哪些操作关键字？
### 21、优化特定类型的查询语句
### 22、你可以用什么来确保表格里的字段只接受特定范围里的值?
### 23、索引设计的原则？
### 24、MySQL 遇到过死锁问题吗，你是如何解决的？
### 25、简述在MySQL数据库中MyISAM和InnoDB的区别
### 26、试述视图的优点？
### 27、select for update有什么含义，会锁表还是锁行还是其他。
### 28、MySQL如何优化DISTINCT？
### 29、MySQL存储引擎MyISAM与InnoDB区别
### 30、什么是死锁？怎么解决？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
