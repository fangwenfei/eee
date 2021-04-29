# MySQL最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、何时使用聚簇索引与非聚簇索引

![](https://user-gold-cdn.xitu.io/2020/5/23/1724114378044d25?w=1332&h=689&f=png&s=77400#alt=)


### 2、MySQL中InnoDB引擎的行锁是怎么实现的？

基于索引来完成行锁的。

```
select * from t where id = 666 for update;
```

for update 可以根据条件来完成行锁锁定，并且 id 是有索引键的列，如果 id 不是索引键那么InnoDB将实行表锁。


### 3、MySql, Oracle，Sql Service的区别

**1、** Sql Service只能在Windows上使用，而MySql和Oracle可以在其他系统上使用， 而且可以支持数据库不同系统之间的移植

**2、** MySql开源免费的，Sql Service和Oracle要钱。

**3、** 我从小到大排序哈，MySql很小，Sql Service居中，Oracle最大

**4、** Oracle支持大并发量，大访问量，Sql Service还行，而MySql的话压力没这么大，因此现在的MySql的话最好是要使用集群或者缓存来搭配使用

**5、** Oracle支持多用户不同权限来进行操作，而MySql只要有登录权限就可操作全部数据库

**6、** 安装所用的空间差别也是很大的，MySQL安装完后才几百M而Oracle有几G左右，且使用的时候Oracle占用特别大的内存空间和其他机器性能。

**7、** 做分页的话，MySql使用Limit，Sql Service使用top，Oracle使用row

**8、** Oracle没有自动增长类型，MySQL和Sql Service一般使用自动增长类型


### 4、什么是SQL？

结构化查询语言(Structured Query Language)


### 5、如果一个表有一列定义为TIMESTAMP，将发生什么？

每当行被更改时，时间戳字段将获取当前时间戳。

**列设置为AUTO INCREMENT时，如果在表中达到最大值，会发生什么情况？**

它会停止递增，任何进一步的插入都将产生错误，因为密钥已被使用。

**怎样才能找出最后一次插入时分配了哪个自动增量？**

LAST_INSERT_ID将返回由Auto_increment分配的最后一个值，并且不需要指定表名称。


### 6、一条sql执行过长的时间，你如何优化，从哪些方面入手？

**1、** 查看是否涉及多表和子查询，优化Sql结构，如去除冗余字段，是否可拆表等

**2、** 优化索引结构，看是否可以适当添加索引

**3、** 数量大的表，可以考虑进行分离/分表（如交易流水表）

**4、** 数据库主从分离，读写分离

**5、** explain分析sql语句，查看执行计划，优化sql

**6、** 查看MySQL执行日志，分析是否有其他方面的问题


### 7、优化特定类型的查询语句

**平时积累吧：**

**1、** 比如使用select 具体字段代替 select *

**2、** 使用count(*) 而不是count(列名)

**3、** 在不影响业务的情况，使用缓存

**4、** explain 分析你的SQL


### 8、什么是最左前缀原则？什么是最左匹配原则

**1、** 顾名思义，就是最左优先，在创建多列索引时，要根据业务需求，where子句中使用最频繁的一列放在最左边。

**2、** 最左前缀匹配原则，非常重要的原则，MySQL会一直向右匹配直到遇到范围查询(>、<、between、like)就停止匹配，比如a = 1 and b = 2 and c > 3 and d = 4 如果建立(a,b,c,d)顺序的索引，d是用不到索引的，如果建立(a,b,d,c)的索引则都可以用到，a,b,d的顺序可以任意调整。

**3、** =和in可以乱序，比如a = 1 and b = 2 and c = 3 建立(a,b,c)索引可以任意顺序，MySQL的查询优化器会帮你优化成索引可以识别的形式


### 9、MySQL的复制原理以及流程

**主从复制：**

将主数据库中的DDL和DML操作通过二进制日志（BINLOG）传输到从数据库上，然后将这些日志重新执行（重做）；从而使得从数据库的数据与主数据库保持一致。

**主从复制的作用**

**1、** 主数据库出现问题，可以切换到从数据库。

**2、** 可以进行数据库层面的读写分离。

**3、** 可以在从数据库上进行日常备份。

MySQL主从复制解决的问题

**1、** 数据分布：随意开始或停止复制，并在不同地理位置分布数据备份

**2、** 负载均衡：降低单个服务器的压力

**3、** 高可用和故障切换：帮助应用程序避免单点失败

**4、** 升级测试：可以用更高版本的MySQL作为从库

**MySQL主从复制工作原理**

**1、** 在主库上把数据更高记录到二进制日志

**2、** 从库将主库的日志复制到自己的中继日志

**3、** 从库读取中继日志的事件，将其重放到从库数据中

**基本原理流程，3个线程以及之间的关联**

**主**：

binlog线程——记录下所有改变了数据库数据的语句，放进master上的binlog中；

**从**：

io线程——在使用start slave 之后，负责从master上拉取 binlog 内容，放进自己的relay log中；

**从**：

sql执行线程——执行relay log中的语句；

**复制过程**

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/049/50/99_14.png#alt=99%5C_14.png)

**Binary log：**主数据库的二进制日志

**Relay log：**从服务器的中继日志

**1、** master在每个事务更新数据完成之前，将该操作记录串行地写入到binlog文件中。

**2、** salve开启一个I/O Thread，该线程在master打开一个普通连接，主要工作是binlog dump process。如果读取的进度已经跟上了master，就进入睡眠状态并等待master产生新的事件。I/O线程最终的目的是将这些事件写入到中继日志中。

**3、** SQL Thread会读取中继日志，并顺序执行该日志中的SQL事件，从而与主数据库中的数据保持一致。


### 10、数据库的乐观锁和悲观锁。

**悲观锁：**

悲观锁她专一且缺乏安全感了，她的心只属于当前事务，每时每刻都担心着它心爱的数据可能被别的事务修改，所以一个事务拥有（获得）悲观锁后，其他任何事务都不能对数据进行修改啦，只能等待锁被释放才可以执行。


### 11、myisamchk是用来做什么的？
### 12、什么是锁？
### 13、列设置为AUTO INCREMENT时，如果在表中达到最大值，会发生什么情况？
### 14、什么是最左前缀原则？什么是最左匹配原则？
### 15、CHAR和VARCHAR的区别？
### 16、谈谈六种关联查询，使用场景。
### 17、视图的优点
### 18、读写分离有哪些解决方案？
### 19、事物的四大特性(ACID)介绍一下?
### 20、一条Sql的执行顺序？
### 21、简述在MySQL数据库中MyISAM和InnoDB的区别
### 22、MYSQL的主从延迟，你怎么解决？
### 23、4.说说分库与分表的设计
### 24、drop、delete与truncate的区别
### 25、锁的优化策略
### 26、MySQL如何优化DISTINCT？
### 27、视图有哪些特点？哪些使用场景？
### 28、FLOAT和DOUBLE的区别是什么？
### 29、什么是非标准字符串类型？
### 30、int(20)中20的涵义




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
