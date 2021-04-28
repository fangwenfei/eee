# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、本地管理表空间和字典管理表空间的特点，ASSM有什么特点？

本地管理表空间(LocallyManaged Tablespace简称LMT)，8i以后出现的一种新的表空间的管理模式，通过位图来管理表空间的空间使用。字典管理表空间(Dictionary-ManagedTablespace简称DMT)8i以前包括以后都还可以使用的一种表空间管理模式，通过数据字典管理表空间的空间使用。动段空间管理（ASSM)，它首次出现在Oracle920里有了ASSM，链接列表freelist被位图所取代，它是一个二进制的数组，能够迅速有效地管理存储扩展和剩余区块(free block)，因此能够改善分段存储本质，ASSM表空间上创建的段还有另外一个称呼叫Bitmap ManagedSegments(BMB 段)


### 2、ORA-01555的应对方法？

具体的出错信息是snapshot too old within rollback seg , 通常可以通过增大rollback seg来解决问题。当然也需要察看一下具

体造成错误的SQL文本


### 3、如何变动数据文件的大小？

ALTER DATABASE DATAFILE <datafile_name> RESIZE <new_size>;


### 4、Audit trace 存放在哪个oracle目录结构中?

unix $ORACLE_HOME/rdbms/audit Windows the event viewer


### 5、解释冷备份和热备份的不同点以及各自的优点

热备份针对归档模式的数据库，在数据库仍旧处于工作状态时进行备份。而冷备份指在数据库关闭后，进行备份，适用于所有模式的数据库。热备份的优 点在于当备份时，数据库仍旧可以被使用并且可以将数据库恢复到任意一个时间点。冷备份的优点在于它的备份和恢复操作相当简单，并且由于冷备份的数据库可以 工作在非归档模式下,数据库性能会比归档模式稍好。（因为不必将archive log写入硬盘）


### 6、解释materialized views的作用

Materialized views 用于减少那些汇总，集合和分组的信息的集合数量。它们通常适合于数据仓库和DSS系统。


### 7、什么是绑定变量?

报表6i中使用了绑定变量来替换select语句中的单个参数。


### 8、事务的特性（ACID）是指什么？

**1、** 原子性（Atomic）： 事务中的各项操作，要么全做要么全不做，任何一项操作的失败都会导致整个事务的失败。

**2、** 一致性（Consistent）： 事务结束后系统状态是一样的。

**3、** 隔离性（Isolated）: 并发执行的事务彼此无法看到对方的中间状态。

**4、** 持久性（Durable）:事务完成后，即使发生灾难性故障，通过日志和同步备份可以在故障发生后重建数据。


### 9、在Oracle Forms Report中，Record组列的最大长度是多少?什么是不同类型的记录组?

记录组列名的最大长度不能超过30个字符。不同类型的记录组包括：查询记录组　　状态记录组　　非查询记录组


### 10、给出数据库正常启动所经历的几种状态 ?

STARTUP NOMOUNT – 数据库实例启动

STARTUP MOUNT - 数据库装载

STARTUP OPEN – 数据库打开


### 11、解释什么是死锁，如何解决Oracle中的死锁？
### 12、简单描述table / segment / extent / block之间的关系？
### 13、描述tablespace和datafile之间的关系
### 14、Oracle 分区在什么情况下使用
### 15、哪个VIEW用来检查数据文件的大小？
### 16、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?
### 17、说下如何使用Oracle的游标？
### 18、给出两个检查表结构的方法
### 19、日志的作用是什么
### 20、说说Oracle中经常使用到的函数
### 21、delete 与Truncate区别？
### 22、创建数据库时自动建立的tablespace名称？
### 23、解释data block , extent 和 segment的区别？
### 24、比较truncate和delete 命令
### 25、解释TABLE Function的用途
### 26、创建用户时，需要赋予新用户什么权限才能使它联上数据库。
### 27、如何进行强制LOG SWITCH?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
