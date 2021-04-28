# MySQL最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、一个6亿的表a，一个3亿的表b，通过外间tid关联，你如何最快的查询出满足条件的第50000到第50200中的这200条数据记录。

**1、** 如果A表TID是自增长,并且是连续的,B表的ID为索引 select * from a,b where a.tid = b.id and a.tid>500000 limit 200;

**2、** 如果A表的TID不是连续的,那么就需要使用覆盖索引.TID要么是主键,要么是辅助索引,B表ID也需要有索引。 select * from b , (select tid from a limit 50000,200) a where b.id = a .tid;


### 2、什么是幻读，脏读，不可重复读呢？

**1、** 事务A、B交替执行，事务A被事务B干扰到了，因为事务A读取到事务B未提交的数据,这就是**脏读**

**2、** 在一个事务范围内，两个相同的查询，读取同一条记录，却返回了不同的数据，这就是**不可重复读**。

**3、** 事务A查询一个范围的结果集，另一个并发事务B往这个范围中插入/删除了数据，并静悄悄地提交，然后事务A再次查询相同的范围，两次读取得到的结果集不一样了，这就是**幻读**。


### 3、使用索引查询一定能提高查询的性能吗？为什么

通常，通过索引查询数据比全表扫描要快。但是我们也必须注意到它的代价。

索引需要空间来存储，也需要定期维护， 每当有记录在表中增减或索引列被修改时，索引本身也会被修改。 这意味着每条记录的INSERT，DELETE，UPDATE将为此多付出4，5 次的磁盘I/O。 因为索引需要额外的存储空间和处理，那些不必要的索引反而会使查询反应时间变慢。使用索引查询不一定能提高查询性能，索引范围查询(INDEX RANGE SCAN)适用于两种情况:

**1、** 基于一个范围的检索，一般查询返回结果集小于表中记录数的30%

**2、** 基于非唯一性索引的检索


### 4、你怎么知道SQL语句性能是高还是低

**1、** 查看SQL的执行时间

**2、** 使用explain关键字可以模拟优化器执行SQL查询语句，从而知道MYSQL是如何处理你的SQL语句的。分析你的查询语句或是表结构的性能瓶颈。


### 5、事物的四大特性(ACID)介绍一下?

关系性数据库需要遵循ACID规则，具体内容如下：

![99_6.png][99_6.png]

**1、** 原子性：

事务是最小的执行单位，不允许分割。事务的原子性确保动作要么全部完成，要么完全不起作用；

**2、** 一致性：

执行事务前后，数据保持一致，多个事务对同一个数据读取的结果是相同的；

**3、** 隔离性：

并发访问数据库时，一个用户的事务不被其他事务所干扰，各并发事务之间数据库是独立的；

**4、** 持久性：

一个事务被提交之后。它对数据库中数据的改变是持久的，即使数据库发生故障也不应该对其有任何影响。


### 6、为什么要尽量设定一个主键？

主键是数据库确保数据行在整张表唯一性的保障，即使业务上本张表没有主键，也建议添加一个自增长的ID列作为主键。设定了主键之后，在后续的删改查的时候可能更加快速以及确保操作数据范围安全。


### 7、MySQL中InnoDB引擎的行锁是怎么实现的？

基于索引来完成行锁的。

```
select * from t where id = 666 for update;
```

for update 可以根据条件来完成行锁锁定，并且 id 是有索引键的列，如果 id 不是索引键那么InnoDB将实行表锁。


### 8、谈谈MySQL的Explain

Explain 执行计划包含字段信息如下：分别是 id、select_type、table、partitions、type、possible_keys、key、key_len、ref、rows、filtered、Extra 等12个字段。

我们重点关注的是type，它的属性排序如下：

```
system  > const > eq_ref > ref  > ref_or_null >
index_merge > unique_subquery > index_subquery >
range > index > ALL
```

推荐大家看这篇文章哈： [面试官：不会看 Explain执行计划，简历敢写 SQL 优化？](https://link.zhihu.com/?target=https%3A//mp.weixin.qq.com/s%3F__biz%3DMzIwOTE2MzU4NA%3D%3D%26mid%3D2247484319%26idx%3D1%26sn%3D17c98e757c24a853374cb7e06c9c9302%26chksm%3D977947b0a00ecea66f3971c723cd844158a24c6c602c22c562223f6932b5b7ad1eee8b700255%26token%3D1596384379%26lang%3Dzh_CN%23rd)


### 9、你是如何监控你们的数据库的？你们的慢日志都是怎么查询的？

监控的工具有很多，例如zabbix，lepus，我这里用的是lepus


### 10、什么是锁？

数据库是一个多用户使用的共享资源。当多个用户并发地存取数据时，在数据库中就会产生多个事务同时存取同一数据的情况。若对并发操作不加控制就可能会读取和存储不正确的数据，破坏数据库的一致性。

加锁是实现数据库并发控制的一个非常重要的技术。当事务在对某个数据对象进行操作前，先向系统发出请求，对其加锁。加锁后事务就对该数据对象有了一定的控制，在该事务释放锁之前，其他的事务不能对此数据对象进行更新操作。


### 11、MySQL中有哪几种锁？
### 12、主键使用自增ID还是UUID？
### 13、什么是游标？
### 14、数据库存储日期格式时，如何考虑时区转换问题？
### 15、什么是事务的隔离级别？MySQL的默认隔离级别是什么？
### 16、什么是死锁？怎么解决？
### 17、为什么要优化
### 18、你怎么看到为表格定义的所有索引？
### 19、MySQL 遇到过死锁问题吗，你是如何解决的？
### 20、什么是索引？
### 21、MySQL中DATETIME和TIMESTAMP的区别
### 22、什么是非标准字符串类型？
### 23、什么是聚簇索引？何时使用聚簇索引与非聚簇索引
### 24、数据库自增主键可能遇到什么问题。
### 25、SQL注入漏洞产生的原因？如何防止？
### 26、主从同步延迟的原因
### 27、Innodb的事务实现原理？
### 28、为表中得字段选择合适得数据类型
### 29、怎样才能找出最后一次插入时分配了哪个自动增量？
### 30、一条sql执行过长的时间，你如何优化，从哪些方面入手？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
