# Oracle最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、回滚段的作用是什么

事务回滚：当事务修改表中数据的时候，该数据修改前的值(即前影像)会存放在回滚段中，当用户回滚事务(ROLLBACK)时，ORACLE将会利用回滚段中的数据前影像来将修改的数据恢复到原来的值。

事务恢复：当事务正在处理的时候，例程失败，回滚段的信息保存在undo表空间中，ORACLE将在下次打开数据库时利用回滚来恢复未提交的数据。

**1、** 读一致性：当一个会话正在修改数据时，其他的会话将看不到该会话未提交的修改。

**2、** 当一个语句正在执行时，该语句将看不到从该语句开始执行后的未提交的修改(语句级读一致性)。

**3、** 当ORACLE执行Select语句时，ORACLE依照当前的系统改变号(SYSTEM CHANGE NUMBER-SCN)。

**4、** 来保证任何前于当前SCN的未提交的改变不被该语句处理。可以想象：当一个长时间的查询正在执行时。

**5、** 若其他会话改变了该查询要查询的某个数据块，ORACLE将利用回滚段的数据前影像来构造一个读一致性视图。


### 2、创建数据库时自动建立的tablespace名称？

SYSTEM tablespace.


### 3、Audit trace 存放在哪个oracle目录结构中?

unix $ORACLE_HOME/rdbms/audit Windows the event viewer


### 4、解释什么是Oracle Forms?

Oracle Forms是用于创建与Oracle数据库交互的软件产品。它有一个IDE，包括一个属性表，对象导航器和使用PL/SQL的代码编辑器。


### 5、Oracle的游标在存储过程里是放在begin与end的里面还是外面？

Oracle的存储过程跟函数你写没有？项目中用到没有？怎么用的？

**1、** 放在begin与end之间。

**2、** 用作多表连接查询数据返回结果查询。

**3、** 复杂的业务操作，涉及多表的数据操作的事务控制。

**4、** 预防SQL注入。


### 6、解释什么是死锁，如何解决Oracle中的死锁？

简言之就是存在加了锁而没有解锁，可能是使用锁没有提交或者回滚事务，如果是表级锁则不能操作表，客户端处于等在状态，如果是行级锁则不能操作锁定行

**解决办法：**

**1、** 查找出被锁的表

**1、** select b.owner,b.object_name,a.session_id,a.locked_mode

**2、** from v$locked_object a,dba_objects b

**3、** where b.object_id = a.object_id;

**1、** select b.username,b.sid,b.serial#,logon_time

**2、** from v$$locked_object a,v$$session b

**3、** where a.session_id = b.sid order by b.logon_time;

**2、** 杀进程中的会话

alter system kill session "sid,serial#";


### 7、如何搜集表的各种状态数据？

ANALYZE

The ANALYZE command.


### 8、说明如何使用相同的LOV 2列?

我们可以通过在全局值中传递返回值并使用代码中的全局值，将相同的LOV用于2列。


### 9、Coalescing做了什么？

Coalescing针对于字典管理的tablespace进行碎片整理，将临近的小extents合并成单个的大extent.


### 10、Oracle 分区在什么情况下使用

当一张表的数据量到达上亿行的时候，表的性能会严重降低，这个时候就需要用到分区了，通过划分成多个小表，并在每个小表上建立本地索引可以大大缩小索引数据文件的大小，从而更快的定位到目标数据来提升访问性能。

分区除了可以用来提升访问性能外，还因为可以指定分区所使用的表空间，因此也用来做数据的生命周期管理。当前需要频繁使用的活跃数据可以放到访问速度更快但价格也更贵的存储设备上，而2、3年前的历史数据，或者叫冷数据可以放到更廉价、速度更低的设备上。从而降低存储费用。


### 11、说下，内连接，左连接，右连接的区别
### 12、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢?
### 13、说下 怎样创建一个视图,视图的好处, 视图可以控制权限吗?
### 14、如何增加buffer cache的命中率?
### 15、delete 与Truncate区别？
### 16、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 17、说下 Oracle中function和procedure的区别？
### 18、如何增加buffer cache的命中率？
### 19、如何判断哪个session正在连结以及它们等待的资源？
### 20、比较truncate和delete 命令
### 21、可以从表单执行动态SQL吗?
### 22、如何启动SESSION级别的TRACE
### 23、存储过程 、函数 、游标 在项目中怎么用的：
### 24、描述tablespace和datafile之间的关系
### 25、日志的作用是什么
### 26、怎样创建一个一个索引,索引使用的原则,有什么优点和缺点
### 27、如何转换init.ora到spfile?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
