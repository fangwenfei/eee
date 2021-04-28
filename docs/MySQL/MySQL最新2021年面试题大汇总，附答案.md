# MySQL最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、MYSQL数据库服务器性能分析的方法命令有哪些?

Show status, 一些值得监控的变量值：

**1、** Bytes_received和Bytes_sent 和服务器之间来往的流量。

**2、** Com_*服务器正在执行的命令。

**3、** Created_*在查询执行期限间创建的临时表和文件。

**4、** Handler_*存储引擎操作。

**5、** Select_*不同类型的联接执行计划。

**6、** Sort_*几种排序信息。

Show profiles 是MySql用来分析当前会话SQL语句执行的资源消耗情况


### 2、日常工作中你是怎么优化SQL的？

可以从这几个维度回答这个问题：

**1、** 加索引

**2、** 避免返回不必要的数据

**3、** 适当分批量进行

**4、** 优化sql结构

**5、** 分库分表

**6、** 读写分离


### 3、优化关联查询

**1、** 确定ON或者USING子句中是否有索引。

**2、** 确保GROUP BY和ORDER BY只有一个表中的列，这样MySQL才有可能使用索引。


### 4、主从同步延迟的解决办法

**1、** 主服务器要负责更新操作，对安全性的要求比从服务器要高，所以有些设置参数可以修改，比如sync_binlog=1，innodb_flush_log_at_trx_commit = 1 之类的设置等。

**2、** 选择更好的硬件设备作为slave。

**3、** 把一台从服务器当度作为备份使用， 而不提供查询， 那边他的负载下来了， 执行relay log 里面的SQL效率自然就高了。

**4、** 增加从服务器喽，这个目的还是分散读的压力，从而降低服务器负载。


### 5、NOW（）和CURRENT_DATE（）有什么区别？

NOW（）命令用于显示当前年份，月份，日期，小时，分钟和秒。

CURRENT_DATE（）仅显示当前年份，月份和日期。


### 6、创建索引有什么原则呢？

**1、** 最左前缀匹配原则

**2、** 频繁作为查询条件的字段才去创建索引

**3、** 频繁更新的字段不适合创建索引

**4、** 索引列不能参与计算，不能有函数操作

**5、** 优先考虑扩展索引，而不是新建索引，避免不必要的索引

**6、** 在order by或者group by子句中，创建索引需要注意顺序

**7、** 区分度低的数据列不适合做索引列(如性别）

**8、** 定义有外键的数据列一定要建立索引。

**9、** 对于定义为text、image数据类型的列不要建立索引。

**10、** 删除不再使用或者很少使用的索引


### 7、隔离级别与锁的关系

**1、** 在Read Uncommitted级别下，读取数据不需要加共享锁，这样就不会跟被修改的数据上的排他锁冲突

**2、** 在Read Committed级别下，读操作需要加共享锁，但是在语句执行完以后释放共享锁；

**3、** 在Repeatable Read级别下，读操作需要加共享锁，但是在事务提交之前并不释放共享锁，也就是必须等待事务执行完毕以后才释放共享锁。

**4、** SERIALIZABLE 是限制性最强的隔离级别，因为该级别**锁定整个范围的键**，并一直持有锁，直到事务完成。


### 8、索引是什么?

索引是帮助MySQL高效获取数据的数据结构。


### 9、谈谈MySQL的Explain

Explain 执行计划包含字段信息如下：分别是 id、select_type、table、partitions、type、possible_keys、key、key_len、ref、rows、filtered、Extra 等12个字段。

我们重点关注的是type，它的属性排序如下：

```
system  > const > eq_ref > ref  > ref_or_null >
index_merge > unique_subquery > index_subquery >
range > index > ALL
```

推荐大家看这篇文章哈： [面试官：不会看 Explain执行计划，简历敢写 SQL 优化？](https://link.zhihu.com/?target=https%3A//mp.weixin.qq.com/s%3F__biz%3DMzIwOTE2MzU4NA%3D%3D%26mid%3D2247484319%26idx%3D1%26sn%3D17c98e757c24a853374cb7e06c9c9302%26chksm%3D977947b0a00ecea66f3971c723cd844158a24c6c602c22c562223f6932b5b7ad1eee8b700255%26token%3D1596384379%26lang%3Dzh_CN%23rd)


### 10、MySQL5.6和MySQL5.7对索引做了哪些优化？

**1、** MySQL5.6引入了索引下推优化，默认是开启的。

**2、** 例子：user表中（a,b,c）构成一个索引。

**3、** select * from user where a='23' and b like '%eqw%' and c like 'dasd'。

**4、** 解释：如果没有索引下推原则，则MySQL会通过a='23' 先查询出一个对应的数据。然后返回到MySQL服务端。MySQL服务端再基于两个like模糊查询来校验and查询出的数据是否符合条件。这个过程就设计到回表操作。

**5、** 如果使用了索引下推技术，则MySQL会首先返回返回条件a='23'的数据的索引，然后根据模糊查询的条件来校验索引行数据是否符合条件，如果符合条件，则直接根据索引来定位对应的数据，如果不符合直接reject掉。因此，有了索引下推优化，可以在有like条件的情况下，减少回表的次数。


### 11、MySQL_fetch_array和MySQL_fetch_object的区别是什么？
### 12、索引有哪些优缺点？
### 13、什么是MySQL?
### 14、存储时期
### 15、创建索引的原则
### 16、优化数据库的方法
### 17、什么是死锁？怎么解决？
### 18、隔离级别与锁的关系
### 19、视图的使用场景有哪些？
### 20、读写分离常见方案？
### 21、如何优化长难的查询语句
### 22、聚簇索引和非聚簇索引，在查询数据的时候有区别吗？为什么？
### 23、500台db，在最快时间之内重启。
### 24、B树和B+树的区别
### 25、为表中得字段选择合适得数据类型
### 26、什么是死锁？怎么解决？
### 27、优化特定类型的查询语句
### 28、什么是SQL？
### 29、什么情况下设置了索引但无法使用
### 30、LIKE声明中的％和_是什么意思？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
