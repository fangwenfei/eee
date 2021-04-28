# MySQL高级面试题及答案，企业真面试题

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、SQL语句的语法顺序：

**1、** SELECT

**2、** FROM

**3、** JOIN

4、ON

**5、** WHERE

**6、** GROUP BY

**7、** HAVING

**8、** UNION

**9、** ORDER BY

**10、**  LIMIT


### 2、什么是锁？

数据库是一个多用户使用的共享资源。当多个用户并发地存取数据时，在数据库中就会产生多个事务同时存取同一数据的情况。若对并发操作不加控制就可能会读取和存储不正确的数据，破坏数据库的一致性。

加锁是实现数据库并发控制的一个非常重要的技术。当事务在对某个数据对象进行操作前，先向系统发出请求，对其加锁。加锁后事务就对该数据对象有了一定的控制，在该事务释放锁之前，其他的事务不能对此数据对象进行更新操作。

**基本锁类型：锁包括行级锁和表级锁**


### 3、MySQL中有哪几种锁，列举一下？

![](https://user-gold-cdn.xitu.io/2020/5/23/17240a13fa147bea?w=1280&h=687&f=png&s=248056#alt=)

**如果按锁粒度划分，有以下3种：**

**1、** 表锁： 开销小，加锁快；锁定力度大，发生锁冲突概率高，并发度最低;不会出现死锁。

**2、** 行锁： 开销大，加锁慢；会出现死锁；锁定粒度小，发生锁冲突的概率低，并发度高。

**3、** 页锁： 开销和加锁速度介于表锁和行锁之间；会出现死锁；锁定粒度介于表锁和行锁之间，并发度一般


### 4、优化LIMIT分页

**1、** LIMIT偏移量大的时候，查询效率较低

**2、** 可以记录上次查询的最大ID，下次查询时直接根据该ID来查询


### 5、列对比运算符是什么？

在SELECT语句的列比较中使用=，<>，<=，<，> =，>，<<，>>，<=>，AND，OR或LIKE运算符。


### 6、怎么查询SQL语句是否使用了索引查询？

使用explain查询SQL语句的执行计划，通过执行计划来分析索引的使用情况。


### 7、锁的优化策略

**1、** 读写分离

**2、** 分段加锁

**3、** 减少锁持有的时间

4.多个线程尽量以相同的顺序去获取资源

不能将锁的粒度过于细化，不然可能会出现线程的加锁和释放次数过多，反而效率不如一次加一把大锁。


### 8、字段为什么要求定义为not null？

null值会占用更多的字节，且会在程序中造成很多与预期不符的情况。


### 9、如何选择合适的分布式主键方案呢？

**1、** 数据库自增长序列或字段。

**2、** UUID。

**3、** Redis生成ID

**4、** Twitter的snowflake算法

**5、** 利用zookeeper生成唯一ID

**6、** MongoDB的ObjectId


### 10、MySQL中int(20)和char(20)以及varchar(20)的区别

**1、** int(20) 表示字段是int类型，显示长度是 20

**2、** char(20)表示字段是固定长度字符串，长度为 20

**3、** varchar(20) 表示字段是可变长度字符串，长度为 20


### 11、大表怎么优化？分库分表了是怎么做的？分表分库了有什么问题？有用到中间件么？他们的原理知道么？
### 12、UNION与UNION ALL的区别？
### 13、MySQL数据库作发布系统的存储，一天五万条以上的增量，预计运维三年,怎么优化？
### 14、索引的底层实现
### 15、列设置为AUTO INCREMENT时，如果在表中达到最大值，会发生什么情况？
### 16、myisamchk是用来做什么的？
### 17、MySQL一条SQL加锁分析
### 18、Blob和text有什么区别？
### 19、使用B树的好处
### 20、为什么官方建议使用自增长主键作为索引？
### 21、创建索引的原则
### 22、SQL的生命周期？
### 23、日常工作中你是怎么优化SQL的？
### 24、B+ Tree索引和Hash索引区别？
### 25、innoDB的B+Tree 存储整行数据和主键的值得区别？
### 26、日常工作中你是怎么优化SQL的？
### 27、如果一个表有一列定义为TIMESTAMP，将发生什么？
### 28、事务是如何通过日志来实现的
### 29、MySQL中都有哪些触发器？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
