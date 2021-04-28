# Oracle最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释Oracle表单服务组件包括什么?

Oracle表单包含：　　客户端：客户端发送HTTP请求　　窗口监听器Servlet：它启动，停止并与窗体运行进程通信　　表单运行过程：它执行特定表单应用程序中包含的代码　　数据库：从数据库中获取的数据


### 2、如何在不影响子表的前提下，重建一个母表

子表的外键强制实效，重建母表，激活外键


### 3、如何增加buffer cache的命中率?

在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice.如果有必要更改，可以使用 alter system set db_cache_size 命令


### 4、如何增加buffer cache的命中率？

在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice . 如果有必要更改，可以使用 alter system set

db_cache_size 命令


### 5、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢?

重建控制文件，用带backup control file 子句的recover 命令恢复数据库。


### 6、解释data block , extent 和 segment的区别（这里建议用英文术语）

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一

个数据库对象拥有的所有extents被称为该对象的segment.


### 7、如何生成explain plan?

运行utlxplan.sql. 建立plan 表

针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table运行utlxplp.sql 或 utlxpls.sql察看explain plan


### 8、数据库的三大范式是什么？

**1、** 第一范式：原子件，要求每一列的值不能再拆分了。

**2、** 第二范式： 一张表只描述一个实体（若列中有冗余数据，则不满足）

**3、** 第三范式： 所有列与主键值直接相关。


### 9、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术

**1、** 中止当前语句执行，转到exception语句块执行。

**2、** 在异常处理时，捕获相应异常，并执行对应解决方案语句。


### 10、SGA主要有那些部分，主要作用是什么?

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


### 11、使用存储过程访问数据库比直接用SQL语句访问有何优点？
### 12、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？
### 13、提到一个项目的“验证LOV”属性?提到lov和list项目有什么区别?
### 14、Oracle跟SQL Server 2005的区别？
### 15、ORA-01555的应对方法?
### 16、Oralce怎样存储文件，能够存储哪些文件？
### 17、怎样创建一个一个索引,索引使用的原则,有什么优点和缺点
### 18、如何生成explain plan?
### 19、解释归档和非归档模式之间的不同和它们各自的优缺点
### 20、举出3种可以收集three advisory statistics
### 21、TEMPORARY tablespace和PERMANENT tablespace 的区别是？
### 22、解释什么是Oracle Forms?
### 23、FACT Table上需要建立何种索引？
### 24、怎样查看数据库引擎的报错
### 25、解释什么是Partitioning（分区）以及它的优点。
### 26、FACT Table上需要建立何种索引?
### 27、给出两种相关约束?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
