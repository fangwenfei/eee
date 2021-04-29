# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、oracle的锁又几种,定义分别是什么;

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



### 2、当用户进程出错，哪个后台进程负责清理它

PMON


### 3、truncate和delete区别：

**1、** Truncate 和delete都可以将数据实体删掉，truncate 的操作并不记录到 rollback日志，所以操作速度较快，但同时这个数据不能恢复

**2、** Delete操作不腾出表空间的空间

**3、** Truncate 不能对视图等进行删除

**4、** Truncate是数据定义语言（DDL），而delete是数据操纵语言(DML)


### 4、列出Oracle Forms配置文件?

Oracle Forms配置文件包括：　　基本HTML文件(base.htm，basejini.htm，basejpi.htm和baseie.htm)　　ENV　　CFG　　CFG　　DEVLOBER


### 5、解释冷备份和热备份的不同点以及各自的优点

热备份针对归档模式的数据库，在数据库仍旧处于工作状态时进行备份。而冷备份指在数据库关闭后，进行备份，适用于所有模式的数据库。热备份的优点在于当备份时，数据库仍旧可以被使用并且可以将数据库恢复到任意一个时间点。

冷备份的优点在于它的备份和恢复操作相当简单，并且由于冷备份的数据库可以工作在非归档模式下,数据库性能会比归档模式稍好。(因为不必将archive log写入硬盘)


### 6、使用索引的理由

快速访问表中的data block


### 7、不借助第三方工具，怎样查看sql的执行计划

```
set autot on

explain plan set statement_id = &item_id for &sql;
select * from table(dbms_xplan.display);
```


### 8、解释data block , extent 和 segment的区别（这里建议用英文术语）

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一

个数据库对象拥有的所有extents被称为该对象的segment.


### 9、Coalescing做了什么？

Coalescing针对于字典管理的tablespace进行碎片整理，将临近的小extents合并成单个的大extent.


### 10、如何定位重要(消耗资源多)的SQL

```
select sql_text 
from v$sql 
where disk_reads > 1000 or (executions > 0 and buffer_gets/executions > 30000);
```


### 11、解释冷备份和热备份的不同点以及各自的优点
### 12、哪个后台进程刷新materialized views?
### 13、如何建立一个备份控制文件？
### 14、说下 Oracle中function和procedure的区别？
### 15、创建数据库时自动建立的tablespace名称？
### 16、解释归档和非归档模式之间的不同和它们各自的优缺点
### 17、如何建立一个备份控制文件?
### 18、解释Oracle表单服务组件包括什么?
### 19、解释$$ORACLE\_HOME和$$ORACLE_BASE的区别?
### 20、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?
### 21、触发器的作用有哪些？
### 22、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 23、在Oracle Forms Report中，Record组列的最大长度是多少?什么是不同类型的记录组?
### 24、如何判断哪个session正在连结以及它们等待的资源？
### 25、oracle中存储过程，游标和函数的区别
### 26、比较truncate和delete 命令
### 27、解释什么是死锁，如何解决Oracle中的死锁？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
