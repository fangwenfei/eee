# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在Oracle Forms Report中，Record组列的最大长度是多少?什么是不同类型的记录组?

记录组列名的最大长度不能超过30个字符。不同类型的记录组包括：查询记录组　　状态记录组　　非查询记录组


### 2、解释什么是死锁，如何解决Oracle中的死锁？

简言之就是存在加了锁而没有解锁，可能是使用锁没有提交或者回滚事务，如果是表级锁则不能操作表，客户端处于等在状态，如果是行级锁则不能操作锁定行

**解决办法：**

查找出被锁的表

```
select b.owner,b.object_name,a.session_id,a.locked_mode 
from v$locked_object a,dba_objects b 
where b.object_id = a.object_id; 

select b.username,b.sid,b.serial#,logon_time 
from v$locked_object a,v$session b 
where a.session_id = b.sid order by b.logon_time;
```

**杀进程中的会话**

`alter system kill session "sid,serial#";`


### 3、说下 Oracle中function和procedure的区别？

**1、** 可以理解函数是存储过程的一种

**2、** 函数可以没有参数,但是一定需要一个返回值，存储过程可以没有参数,不需要返回值

**3、** 函数return返回值没有返回参数模式，存储过程通过out参数返回值, 如果需要返回多个参数则建议使用存储过程

**4、** 在sql数据操纵语句中只能调用函数而不能调用存储过程


### 4、举出两个判断DDL改动的方法？

你可以使用 Logminer 或 Streams


### 5、如何启动SESSION级别的TRACE

解答:

DBMS_SESSION.SET_SQL_TRACE

ALTER SESSION SET SQL_TRACE = TRUE;

49.###

这两个ORACLE工具都是用来将数据导入数据库的。

区别是：IMPORT工具只能处理由另一个ORACLE工具EXPORT生成

的数据。而SQL*LOADER可以导入不同的ASCII格式的数据源


### 6、Coalescing做了什么？

Coalescing针对于字典管理的tablespace进行碎片整理，将临近的小extents合并成单个的大extent.


### 7、解释GLOBAL_NAMES设为TRUE的用途？

GLOBAL_NAMES指明联接数据库的方式。如果这个参数设置为TRUE,在建立数据库链接时就必须用相同的名字连结远程数据库


### 8、给出两个检查表结构的方法

1.DESCRIBE命令

**2、** DBMS_METADATA.GET_DDL 包


### 9、哪个VIEW用来判断tablespace的剩余空间

DBA_FREE_SPACE


### 10、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录


### 11、可以从表单执行动态SQL吗?
### 12、说下 oracle的锁又几种,定义分别是什么;
### 13、哪个column可以用来区别V$$视图和GV$$视图?
### 14、Oracle的导入导出有几种方式，有何区别？
### 15、集合操作符
### 16、事务的特性（ACID）是指什么？
### 17、如何定位重要(消耗资源多)的SQL
### 18、说说Oracle中经常使用到的函数
### 19、描述tablespace和datafile之间的关系
### 20、如何搜集表的各种状态数据？
### 21、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术
### 22、如何使用Oracle的游标？
### 23、解释data block , extent 和 segment的区别？
### 24、你刚刚编译了一个PL/SQL Package但是有错误报道，如何显示出错信息？
### 25、解释FUNCTION,PROCEDURE和PACKAGE区别
### 26、解释归档和非归档模式之间的不同和它们各自的优缺点
### 27、如何在不影响子表的前提下，重建一个母表




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
