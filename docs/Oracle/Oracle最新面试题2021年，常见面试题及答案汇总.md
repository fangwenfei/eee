# Oracle最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、解释冷备份和热备份的不同点以及各自的优点

热备份针对归档模式的数据库，在数据库仍旧处于工作状态时进行备份。而冷备份指在数据库关闭后，进行备份，适用于所有模式的数据库。热备份的优 点在于当备份时，数据库仍旧可以被使用并且可以将数据库恢复到任意一个时间点。冷备份的优点在于它的备份和恢复操作相当简单，并且由于冷备份的数据库可以 工作在非归档模式下,数据库性能会比归档模式稍好。（因为不必将archive log写入硬盘）


### 2、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录。


### 3、如何增加buffer cache的命中率？

在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice.如果有必要更改，可以使用 alter system set db_cache_size 命令


### 4、说下 oracle 中 dml、ddl、dcl 的使用有哪些

**1、** Dml 数据操纵语言，如select、update、delete，insert

**2、** Ddl 数据定义语言，如create table 、drop table 等等

**3、** Dcl 数据控制语言， 如 commit、 rollback、grant、 invoke等


### 5、SGA主要有那些部分，主要作用是什么?

SGA：db_cache/shared_pool/large_pool/java_pooldb_cache:

数据库缓存(BlockBuffer)对于Oracle数据库的运转和性能起着非常关键的作用，它占据Oracle数据库SGA(系统共享内存区)的主要部分。Oracle数据库通过使用LRU算法，将最近访问的数据块存放到缓存中，从而优化对磁盘数据的访问。

**shared_pool:**

共享池的大小对于Oracle性能来说都是很重要的。

共享池中保存数据字典高速缓冲和完全解析或编译的的PL/SQL 块和SQL 语句及控制结构。

**large_pool:**

使用MTS配置时，因为要在SGA中分配UGA来保持用户的会话，就是用Large_pool来保持这个会话内存使用RMAN做备份的时候，要使用Large_pool这个内存结构来做磁盘I/O缓存器

**java_pool:**

为javaprocedure预备的内存区域,如果没有使用java proc,java_pool不是必须的.

8 oracle系统进程主要有哪些，作用是什么

数据写进程(dbwr)：负责将更改的数据从数据库缓冲区高速缓存写入数据文件。

日志写进程(lgwr)：将重做日志缓冲区中的更改写入在线重做日志文件。

**1、** 系统监控(smon) ：检查数据库的一致性如有必要还会在数据库打开时启动数据库的恢复。

**2、** 进程监控(pmon) ：负责在一个Oracle 进程失败时清理资源。

**3、** 检查点进程(chpt)：负责在每当缓冲区高速缓存中的更改永久地记录在数据库中时,更新控制文件和数据文件中的数据库状态信息。

**4、** 归档进程(arcn) ：在每次日志切换时把已满的日志组进行备份或归档。

**5、** 作业调度器(cjq) :负责将调度与执行系统中已定义好的job,完成一些预定义的工作.。

**6、** 恢复进程(reco) :保证分布式事务的一致性,在分布式事务中,要么同时commit,要么同时rollback。


### 6、当用户进程出错，哪个后台进程负责清理它

PMON


### 7、触发器的作用有哪些？

**1、** 触发器可通过数据库中的相关表实现级联更改；通过级联引用完整性约束可以更有效地执行这些更改。

**2、** 触发器可以强制比用 CHECK 约束定义的约束更为复杂的约束。与 CHECK 约束不同，触发器可以引用其它表中的列。例如，触发器可以使用另一个表中的 SELECT 比较插入或更新的数据，以及执行其它操作，如修改数据或显示用户定义错误信息。

**3、** 触发器还可以强制执行业务规则

**4、** 触发器也可以评估数据修改前后的表状态，并根据其差异采取对策。


### 8、哪个column可以用来区别V$$视图和GV$$视图?

INST_ID 指明集群环境中具体的某个instance 。


### 9、描述什么是 redo logs

Redo Logs 是用于存放数据库数据改动状况的物理和逻辑结构。可以用来修复数据库.


### 10、说一下，Oracle的分区有几种

Oracle的分区可以分为：`列表分区`、`范围分区`、`散列分区(哈希分区)`、`复合分区`。

**范围分区**

**1、** 就是根据数据库表中某一字段的值的范围来划分分区。

**2、** 数据中有空值，Oracle机制会自动将其规划到maxvalue的分区中。

**散列分区区(哈希分区)**

**1、** 根据字段的hash值进行均匀分布，尽可能地实现各分区所散列的数据相等。

**2、** 散列分区即为哈希分区，Oracle采用哈希码技术分区，具体分区如何由Oracle说的算，也可能我下一次搜索就不是这个数据了。

**列表分区**

列表分区明确指定了根据某字段的某个具体值进行分区，而不是像范围分区那样根据字段的值范围来划分的。

**复合分区**

根据范围分区后，每个分区内的数据再散列地分布在几个表空间中，这样我们就要使用复合分区。复合分区是先使用范围分区，然后在每个分区同再使用散列分区的一种分区方法。


### 11、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？
### 12、Oracle跟SQL Server 2005的区别？
### 13、FACT Table上需要建立何种索引?
### 14、说下 Oracle的导入导出有几种方式，有何区别？
### 15、如何生成explain plan?
### 16、Oralce怎样存储文件，能够存储哪些文件？
### 17、创建用户时，需要赋予新用户什么权限才能使它联上数据库。
### 18、说明如何使用相同的LOV 2列?
### 19、说一下，什么是Oracle分区
### 20、解释 冷备份 和 热备份 的不同点，以及各自的优点？
### 21、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 22、ORA-01555的应对方法？
### 23、如何判断哪个session正在连结以及它们等待的资源？
### 24、如何增加buffer cache的命中率?
### 25、解释data block , extent 和 segment的区别(这里建议用英文术语)
### 26、不借助第三方工具，怎样查看sql的执行计划
### 27、索引是用来干什么的？有那些约束建立索引？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
