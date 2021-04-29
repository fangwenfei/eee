# Oracle最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何转换init.ora到spfile?

使用create spfile from pfile 命令.


### 2、创建数据库时自动建立的tablespace名称？

SYSTEM tablespace.


### 3、解释什么是死锁，如何解决Oracle中的死锁？

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


### 4、给出数据库正常启动所经历的几种状态 ?

STARTUP NOMOUNT – 数据库实例启动

STARTUP MOUNT - 数据库装载

STARTUP OPEN – 数据库打开


### 5、使用索引的理由

快速访问表中的data block


### 6、本地管理表空间和字典管理表空间的特点，ASSM有什么特点？

本地管理表空间(LocallyManaged Tablespace简称LMT)，8i以后出现的一种新的表空间的管理模式，通过位图来管理表空间的空间使用。字典管理表空间(Dictionary-ManagedTablespace简称DMT)8i以前包括以后都还可以使用的一种表空间管理模式，通过数据字典管理表空间的空间使用。动段空间管理（ASSM)，它首次出现在Oracle920里有了ASSM，链接列表freelist被位图所取代，它是一个二进制的数组，能够迅速有效地管理存储扩展和剩余区块(free block)，因此能够改善分段存储本质，ASSM表空间上创建的段还有另外一个称呼叫Bitmap ManagedSegments(BMB 段)


### 7、回滚段的作用是什么

事务回滚：当事务修改表中数据的时候，该数据修改前的值(即前影像)会存放在回滚段中，当用户回滚事务(ROLLBACK)时，ORACLE将会利用回滚段中的数据前影像来将修改的数据恢复到原来的值。

事务恢复：当事务正在处理的时候，例程失败，回滚段的信息保存在undo表空间中，ORACLE将在下次打开数据库时利用回滚来恢复未提交的数据。

**1、** 读一致性：当一个会话正在修改数据时，其他的会话将看不到该会话未提交的修改。

**2、** 当一个语句正在执行时，该语句将看不到从该语句开始执行后的未提交的修改(语句级读一致性)。

**3、** 当ORACLE执行Select语句时，ORACLE依照当前的系统改变号(SYSTEM CHANGE NUMBER-SCN)。

**4、** 来保证任何前于当前SCN的未提交的改变不被该语句处理。可以想象：当一个长时间的查询正在执行时。

**5、** 若其他会话改变了该查询要查询的某个数据块，ORACLE将利用回滚段的数据前影像来构造一个读一致性视图。


### 8、给出两个检查表结构的方法

**1、** DESCRIBE命令

**2、**  DBMS_METADATA.GET_DDL 包


### 9、简单描述table / segment / extent / block之间的关系？

table创建时,默认创建了一个data segment，每个datasegment含有min extents指定的extents数，每个extent据据表空间的存储参数分配一定数量的blocks


### 10、说下 怎样创建一个视图,视图的好处, 视图可以控制权限吗?

create view 视图名 as select 列名 [别名]  …  from 表 [unio [all] select … ] ]

好处：

**1、** 可以简单的将视图理解为sql查询语句，视图最大的好处是不占系统空间

**2、** 一些安全性很高的系统，不会公布系统的表结构，可能会使用视图将一些敏感信息过虑或者重命名后公布结构

**3、** 简化查询

**4、** 视图可以控制权限的，在使用的时候需要将视图的使用权限grant给用户


### 11、给出两种相关约束?
### 12、如何建立一个备份控制文件?
### 13、MySQL数据库与Oracle 数据库有什么区别？
### 14、如何加密PL/SQL程序？
### 15、如何在tablespace里增加数据文件？
### 16、Audit trace 存放在哪个oracle目录结构中?
### 17、解释冷备份和热备份的不同点以及各自的优点
### 18、ORA-01555的应对方法？
### 19、解释归档和非归档模式之间的不同和它们各自的优缺点
### 20、Oracle的游标在存储过程里是放在begin与end的里面还是外面？
### 21、在千万级的数据库查询中，如何提高效率？
### 22、比较truncate和delete 命令
### 23、truncate和delete区别：
### 24、如何建立一个备份控制文件？
### 25、如何变动数据文件的大小？
### 26、怎样创建一个一个索引,索引使用的原则,有什么优点和缺点
### 27、如何判断数据库的时区？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
