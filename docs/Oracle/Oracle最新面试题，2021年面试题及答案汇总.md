# Oracle最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、解释$$ORACLE\_HOME和$$ORACLE_BASE的区别?

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录。


### 2、Oracle跟SQL Server 2005的区别？

**宏观上：**

**1、** 最大的区别在于平台，oracle可以运行在不同的平台上，sql server只能运行在windows平台上，由于windows平台的稳定性和安全性影响了sql server的稳定性和安全性

**2、** oracle使用的脚本语言为PL-SQL，而sql server使用的脚本为T-SQL

**微观上：**

**1、** 从数据类型,数据库的结构等等回答


### 3、给出在STAR SCHEMA中的两种表及它们分别含有的数据

Fact tables 和dimension tables. fact table 包含大量的主要的信息而 dimension tables 存放对fact table 某些属性描述的

信息


### 4、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要 rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 5、MySQL数据库与Oracle 数据库有什么区别？

**1、** 应用方面，MySQL 是中小型应用的数据库。一般用于个人和中小型企业。Oracle 属于大型数据库，一般用于具有相当规模的企业应用。

**2、** 自动增长的数据类型方面： MySQL有自动增长的数据类型。Oracle 没有自动增长的数据类型。需要建立一个自增序列。

**3、** group by 用法： MySQL 中group by 在SELECT 语句中可以随意使用，但在ORACLE 中如果查询语句中有组函数，那么其他列必须是组函数处理过的或者是group by子句中的列，否则会报错。

**4、** 引导方面： MySQL中可以用单引号、双引号包起字符串，Oracle 中只可以用单引号包起字符串


### 6、说明如何在指定的块中迭代项目和记录?

要遍历指定块中的项目和记录，可以使用NEXT_FIELD来迭代特定块中的项，并且NEXT_RECORD遍历块中的记录。


### 7、给出数据库正常启动所经历的几种状态 ?

STARTUP NOMOUNT ?C 数据库实例启动

STARTUP MOUNT - 数据库装载

STARTUP OPEN ?C 数据库打开


### 8、如何生成explain plan?

运行utlxplan.sql. 建立plan 表

针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table运行utlxplp.sql 或 utlxpls.sql察看explain plan


### 9、ORA-01555的应对方法？

具体的出错信息是snapshot too old within rollback seg , 通常可以通过增大rollback seg来解决问题。当然也需要察看一下具体造成错误的SQL文本


### 10、oracle的锁又几种,定义分别是什么;

**1、**  行共享锁 (ROW SHARE)

**2、**  行排他锁(ROW EXCLUSIVE)

**3、** 共享锁(SHARE)

**4、**  共享行排他锁(SHARE ROW EXCLUSIVE)

**5、**  排他锁(EXCLUSIVE)

**使用方法：**

```
SELECT * FROM order_master WHERE vencode="V002" 
FOR UPDATE WAIT 5; 
LOCK TABLE order_master IN SHARE MODE; 
LOCK TABLE itemfile IN EXCLUSIVE MODE NOWAIT;
```

**ORACLE锁具体分为以下几类：**

**1、** 按用户与系统划分，可以分为自动锁与显示锁

自动锁：当进行一项数据库操作时，缺省情况下，系统自动为此数据库操作获得所有有必要的锁。

显示锁：某些情况下，需要用户显示的锁定数据库操作要用到的数据，才能使数据库操作执行得更好，显示锁是用户为数据库对象设定的。

**2、** 按锁级别划分，可分为共享锁与排它锁

**共享锁：**

共享锁使一个事务对特定数据库资源进行共享访问——另一事务也可对此资源进行访问或获得相同共享锁。共享锁为事务提供高并发性，但如拙劣的事务设计+共享锁容易造成死锁或数据更新丢失。

**排它锁：**

事务设置排它锁后，该事务单独获得此资源，另一事务不能在此事务提交之前获得相同对象的共享锁或排它锁。

**3、** 按操作划分，可分为DML锁、DDL锁

DML锁又可以分为，行锁、表锁、死锁

**行锁：**

当事务执行数据库插入、更新、删除操作时，该事务自动获得操作表中操作行的排它锁。

**表级锁：**

当事务获得行锁后，此事务也将自动获得该行的表锁(共享锁),以防止其它事务进行DDL语句影响记录行的更新。事务也可以在进行过程中获得共享

锁或排它锁，只有当事务显示使用LOCK TABLE语句显示的定义一个排它锁时，事务才会获得表上的排它锁,也可使用LOCK TABLE显示的定义一个表级的共享锁(LOCK TABLE具体用法请参考相关文档)。

**死锁：**

当两个事务需要一组有冲突的锁，而不能将事务继续下去的话，就出现死锁。

如事务1在表A行记录#3中有一排它锁，并等待事务2在表A中记录#4中排它锁的释放，而事务2在表A记录行#4中有一排它锁，并等待事务; 1在表A中记录#3中排它锁的释放，事务1与事务2彼此等待，因此就造成了死锁。死锁一般是因拙劣的事务设计而产生。死锁只能使用SQL下:alter system kill session "sid,serial#"；或者使用相关操作系统kill进程的命令，如UNIX下kill -9 sid,或者使用其它工具杀掉死锁进程。

**DDL锁又可以分为：**

排它DDL锁、共享DDL锁、分析锁

**排它DDL锁：**

创建、修改、删除一个数据库对象的DDL语句获得操作对象的 排它锁。如使用alter table语句时，为了维护数据的完成性、一致性、合法性，该事务获得一排它DDL锁。

共享DDL锁：需在数据库对象之间建立相互依赖关系的DDL语句通常需共享获得DDL锁。

如创建一个包，该包中的过程与函数引用了不同的数据库表，当编译此包时，该事务就获得了引用表的共享DDL锁。

**分析锁：**

ORACLE使用共享池存储分析与优化过的SQL语句及PL/SQL程序，使运行相同语句的应用速度更快。一个在共享池中缓存的对象获得它所引用数据库对象的分析锁。分析锁是一种独特的DDL锁类型，ORACLE使用它追踪共享池对象及它所引用数据库对象之间的依赖关系。当一个事务修改或删除了共享池持有分析锁的数据库对象时，ORACLE使共享池中的对象作废，下次在引用这条SQL/PLSQL语句时，ORACLE重新分析编译此语句。

**4.内部闩锁**

内部闩锁：这是ORACLE中的一种特殊锁，用于顺序访问内部系统结构。当事务需向缓冲区写入信息时，为了使用此块内存区域，ORACLE首先必须取得这块内存区域的闩锁，才能向此块内存写入信息。



### 11、索引是用来干什么的？有那些约束建立索引？
### 12、oracle中存储过程，游标和函数的区别
### 13、解释materialized views的作用
### 14、说下 oracle的锁又几种,定义分别是什么;
### 15、怎样创建一个一个索引,索引使用的原则,有什么优点和缺点
### 16、如何启动SESSION级别的TRACE
### 17、FACT Table上需要建立何种索引？
### 18、你刚刚编译了一个PL/SQL Package但是有错误报道，如何显示出错信息？
### 19、如何在tablespace里增加数据文件？
### 20、解释data block , extent 和 segment的区别？
### 21、创建用户时，需要赋予新用户什么权限才能使它联上数据库。
### 22、说下 oracle 中 dml、ddl、dcl 的使用有哪些
### 23、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 24、用于网络连接的2个文件？
### 25、如何进行强制LOG SWITCH?
### 26、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
