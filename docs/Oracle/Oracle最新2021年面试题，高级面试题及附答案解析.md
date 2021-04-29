# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何变动数据文件的大小？

ALTER DATABASE DATAFILE <datafile_name> RESIZE <new_size>;


### 2、哪个VIEW用来检查数据文件的大小？

DBA_DATA_FILES


### 3、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术

**1、** 中止当前语句执行，转到exception语句块执行。

**2、** 在异常处理时，捕获相应异常，并执行对应解决方案语句。


### 4、解释冷备份和热备份的不同点以及各自的优点

热备份针对归档模式的数据库，在数据库仍旧处于工作状态时进行备份。而冷备份指在数据库关闭后，进行备份，适用于所有模式的数据库。热备份的优点在于当备份时，数据库仍旧可以被使用并且可以将数据库恢复到任意一个时间点。

冷备份的优点在于它的备份和恢复操作相当简单，并且由于冷备份的数据库可以工作在非归档模式下,数据库性能会比归档模式稍好。(因为不必将archive log写入硬盘)


### 5、解释data block , extent 和 segment的区别(这里建议用英文术语)

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一个数据库对象拥有的所有extents被称为该对象的segment.


### 6、如何生成explain plan?

运行utlxplan.sql. 建立plan 表针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table 运行

utlxplp.sql 或 utlxpls.sql察看explain plan


### 7、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要 rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 8、给出数据库正常启动所经历的几种状态 ?
### 9、SGA主要有那些部分，主要作用是什么?
### 10、如何在tablespace里增加数据文件？
### 11、说明如何使用相同的LOV 2列?
### 12、如何启动SESSION级别的TRACE
### 13、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 14、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 15、说下 怎样创建一个视图,视图的好处, 视图可以控制权限吗?
### 16、事务的特性（ACID）是指什么？
### 17、给出两个检查表结构的方法
### 18、delete 与Truncate区别？
### 19、解释什么是Partitioning（分区）以及它的优点。
### 20、列出Oracle Forms配置文件?
### 21、存储过程 、函数 、游标 在项目中怎么用的：
### 22、描述什么是 redo logs
### 23、说下，内连接，左连接，右连接的区别
### 24、oracle中存储过程，游标和函数的区别
### 25、解释什么是死锁，如何解决Oracle中的死锁？
### 26、如何判断哪个session正在连结以及它们等待的资源？
### 27、提及11g版本2中Oracle Forms Services中引入的新功能是什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
