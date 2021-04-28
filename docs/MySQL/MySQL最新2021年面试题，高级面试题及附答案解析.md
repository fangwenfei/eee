# MySQL最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、MYSQL的主从延迟，你怎么解决？

嘻嘻，先复习一下主从复制原理吧，如图：

![](https://user-gold-cdn.xitu.io/2020/5/23/1723fa894b85ed73?w=1176&h=552&f=png&s=242934#alt=)

**主从复制分了五个步骤进行：**

**1、** 步骤一：主库的更新事件(update、insert、delete)被写到binlog

**2、** 步骤二：从库发起连接，连接到主库。

**3、** 步骤三：此时主库创建一个binlog dump thread，把binlog的内容发送到从库。

**4、** 步骤四：从库启动之后，创建一个I/O线程，读取主库传过来的binlog内容并写入到relay log

**5、** 步骤五：还会创建一个SQL线程，从relay log里面读取内容，从Exec_Master_Log_Pos位置开始执行读取到的更新事件，将更新内容写入到slave的db

**主从同步延迟的原因**

一个服务器开放Ｎ个链接给客户端来连接的，这样有会有大并发的更新操作, 但是从服务器的里面读取binlog的线程仅有一个，当某个SQL在从服务器上执行的时间稍长 或者由于某个SQL要进行锁表就会导致，主服务器的SQL大量积压，未被同步到从服务器里。这就导致了主从不一致， 也就是主从延迟。

**主从同步延迟的解决办法**

**1、** 主服务器要负责更新操作，对安全性的要求比从服务器要高，所以有些设置参数可以修改，比如sync_binlog=1，innodb_flush_log_at_trx_commit = 1 之类的设置等。

**2、** 选择更好的硬件设备作为slave。

**3、** 把一台从服务器当度作为备份使用， 而不提供查询， 那边他的负载下来了， 执行relay log 里面的SQL效率自然就高了。

**4、** 增加从服务器喽，这个目的还是分散读的压力，从而降低服务器负载。


### 2、事务是如何通过日志来实现的

因为事务在修改页时，要先记 undo，在记 undo 之前要记 undo 的 redo， 然后修改数据页，再记数据页修改的 redo。 Redo（里面包括 undo 的修改） 一定要比数据页先持久化到磁盘。

当事务需要回滚时，因为有 undo，可以把数据页回滚到前镜像的 状态，崩溃恢复时，如果 redo log 中事务没有对应的 commit 记录，那么需要用 undo把该事务的修改回滚到事务开始之前。

如果有 commit 记录，就用 redo 前滚到该事务完成时并提交掉。


### 3、MySql, Oracle，Sql Service的区别

**1、** Sql Service只能在Windows上使用，而MySql和Oracle可以在其他系统上使用， 而且可以支持数据库不同系统之间的移植

**2、** MySql开源免费的，Sql Service和Oracle要钱。

**3、** 我从小到大排序哈，MySql很小，Sql Service居中，Oracle最大

**4、** Oracle支持大并发量，大访问量，Sql Service还行，而MySql的话压力没这么大，因此现在的MySql的话最好是要使用集群或者缓存来搭配使用

**5、** Oracle支持多用户不同权限来进行操作，而MySql只要有登录权限就可操作全部数据库

**6、** 安装所用的空间差别也是很大的，MySQL安装完后才几百M而Oracle有几G左右，且使用的时候Oracle占用特别大的内存空间和其他机器性能。

**7、** 做分页的话，MySql使用Limit，Sql Service使用top，Oracle使用row

**8、** Oracle没有自动增长类型，MySQL和Sql Service一般使用自动增长类型


### 4、数据库的乐观锁和悲观锁。

**悲观锁：**

悲观锁她专一且缺乏安全感了，她的心只属于当前事务，每时每刻都担心着它心爱的数据可能被别的事务修改，所以一个事务拥有（获得）悲观锁后，其他任何事务都不能对数据进行修改啦，只能等待锁被释放才可以执行。

![](https://user-gold-cdn.xitu.io/2020/5/23/1723d313056fce6a?w=899&h=563&f=png&s=50589#alt=)

**乐观锁：**

乐观锁的“乐观情绪”体现在，它认为数据的变动不会太频繁。因此，它允许多个事务同时对数据进行变动。实现方式：乐观锁一般会使用版本号机制或CAS算法实现。

![](https://user-gold-cdn.xitu.io/2020/5/23/1723e7d3872c9406?w=931&h=657&f=png&s=68807#alt=)


### 5、如果一个表有一列定义为TIMESTAMP，将发生什么？

每当行被更改时，时间戳字段将获取当前时间戳。

**列设置为AUTO INCREMENT时，如果在表中达到最大值，会发生什么情况？**

它会停止递增，任何进一步的插入都将产生错误，因为密钥已被使用。

**怎样才能找出最后一次插入时分配了哪个自动增量？**

LAST_INSERT_ID将返回由Auto_increment分配的最后一个值，并且不需要指定表名称。


### 6、非聚簇索引一定会回表查询吗？

不一定，如果查询语句的字段全部命中了索引，那么就不必再进行回表查询（哈哈，覆盖索引就是这么回事）。

举个简单的例子，假设我们在学生表的上建立了索引，那么当进行select age from student where age < 20的查询时，在索引的叶子节点上，已经包含了age信息，不会再次进行回表查询。


### 7、CHAR和VARCHAR的区别？

1.CHAR和VARCHAR类型在存储和检索方面有所不同

2.CHAR列长度固定为创建表时声明的长度，长度值范围是1到255

当CHAR值被存储时，它们被用空格填充到特定长度，检索CHAR值时需删除尾随空格。


### 8、什么是游标？

游标是系统为用户开设的一个数据缓冲区，存放SQL语句的执行结果，每个游标区都有一个名字。用户可以通过游标逐一获取记录并赋给主变量，交由主语言进一步处理。


### 9、索引的底层实现

MySQL默认存储引擎innodb只显式支持B-Tree( 从技术上来说是B+Tree)索引，对于频繁访问的表，innodb会透明建立自适应hash索引，即在B树索引基础上建立hash索引，可以显著提高查找效率，对于客户端是透明的，不可控制的，隐式的。

> 不谈存储引擎，只讨论实现(抽象)


Hash索引

基于哈希表实现，只有精确匹配索引所有列的查询才有效，对于每一行数据，存储引擎都会对所有的索引列计算一个哈希码（hash code），并且Hash索引将所有的哈希码存储在索引中，同时在索引表中保存指向每个数据行的指针。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/04/img_2.png#alt=img%5C_2.png)

B-Tree索引（MySQL使用B+Tree）

B-Tree能加快数据的访问速度，因为存储引擎不再需要进行全表扫描来获取数据，数据分布在各个节点之中。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/04/img_3.png#alt=img%5C_3.png)

B+Tree索引

是B-Tree的改进版本，同时也是数据库索引索引所采用的存储结构。数据都在叶子节点上，并且增加了顺序访问指针，每个叶子节点都指向相邻的叶子节点的地址。相比B-Tree来说，进行范围查找时只需要查找两个节点，进行遍历即可。而B-Tree需要获取所有节点，相比之下B+Tree效率更高。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/04/img_4.png#alt=img%5C_4.png)

> 结合存储引擎来讨论（一般默认使用B+Tree）


案例：假设有一张学生表，id为主键

| id | name | birthday |
| --- | --- | --- |
| 1 | Tom | 1996-01-01 |
| 2 | Jann | 1996-01-04 |
| 3 | Ray | 1996-01-08 |
| 4 | Michael | 1996-01-10 |
| 5 | Jack | 1996-01-13 |
| 6 | Steven | 1996-01-23 |
| 7 | Lily | 1996-01-25 |


在MyISAM引擎中的实现（二级索引也是这样实现的）

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/04/img_5.png#alt=img%5C_5.png)

在InnoDB中的实现

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/04/img_6.png#alt=img%5C_6.png)

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/04/img_7.png#alt=img%5C_7.png)


### 10、MYSQL的主从延迟，你怎么解决？

嘻嘻，先复习一下主从复制原理吧

主从复制分了五个步骤进行：

**1、** 步骤一：主库的更新事件(update、insert、delete)被写到binlog

**2、** 步骤二：从库发起连接，连接到主库。

**3、** 步骤三：此时主库创建一个binlog dump thread，把binlog的内容发送到从库。

**4、** 步骤四：从库启动之后，创建一个I/O线程，读取主库传过来的binlog内容并写入到relay log

**5、** 步骤五：还会创建一个SQL线程，从relay log里面读取内容，从Exec_Master_Log_Pos位置开始执行读取到的更新事件，将更新内容写入到slave的db


### 11、索引的分类?
### 12、MySQL驱动程序是什么？
### 13、MySQL有哪些数据类型
### 14、说说对SQL语句优化有哪些方法？（选择几条）
### 15、使用B+树的好处
### 16、为什么官方建议使用自增长主键作为索引？
### 17、MySQL如何优化DISTINCT？
### 18、覆盖索引、回表等这些，了解过吗？
### 19、MySQL中 in 和 exists 区别
### 20、优化器的执行过程？
### 21、大表怎么优化？分库分表了是怎么做的？分表分库了有什么问题？有用到中间件么？他们的原理知道么？
### 22、数据库索引的原理，为什么要用 B+树，为什么不用二叉树？
### 23、列值为NULL时，查询是否会用到索引？
### 24、为什么要使用视图？什么是视图？
### 25、优化数据库的方法
### 26、从锁的类别上分MySQL都有哪些锁呢？
### 27、InnoDB存储引擎的锁的算法有三种
### 28、什么是最左前缀原则？什么是最左匹配原则？
### 29、按照锁的粒度分，数据库锁有哪些呢？锁机制与InnoDB锁算法
### 30、既然提到了InnoDB使用户的B+树的索引模型




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
