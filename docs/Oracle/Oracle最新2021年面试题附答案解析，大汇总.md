# Oracle最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释什么是死锁，如何解决Oracle中的死锁？

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


### 2、Oracle的导入导出有几种方式，有何区别？

**1、** 使用oracle工具 exp/imp

**2、** 使用plsql相关工具

**方法1.**

导入/导出的是二进制的数据， 2.plsql导入/导出的是sql语句的文本文件

**3、** sqlloader

**4、** dblink


### 3、Oracle跟SQL Server 2005的区别？

**宏观上：**

**1、** 最大的区别在于平台，oracle可以运行在不同的平台上，sql server只能运行在windows平台上，由于windows平台的稳定性和安全性影响了sql server的稳定性和安全性

**2、** oracle使用的脚本语言为PL-SQL，而sql server使用的脚本为T-SQL

**微观上：**

**1、** 从数据类型,数据库的结构等等回答


### 4、如何判断数据库的时区？

SELECT DBTIMEZONE FROM DUAL;


### 5、哪个column可以用来区别V$$视图和GV$$视图?

INST_ID 指明集群环境中具体的 某个instance 。


### 6、Oralce怎样存储文件，能够存储哪些文件？

**1、** Oracle 能存储 clob、nclob、 blob、 bfile

**2、** Clob 可变长度的字符型数据，也就是其他数据库中提到的文本型数据类型

**3、** Nclob 可变字符类型的数据，不过其存储的是Unicode字符集的字符数据

**4、** Blob 可变长度的二进制数据

**5、** Bfile 数据库外面存储的可变二进制数据


### 7、哪个VIEW用来检查数据文件的大小？

DBA_DATA_FILES


### 8、给出两个检查表结构的方法

**1、** DESCRIBE命令

**2、**  DBMS_METADATA.GET_DDL 包


### 9、ORA-01555的应对方法?

具体的出错信息是snapshot too old within rollback seg , 通常可以通过增大rollback seg来解决问题。当然也需要察看一下具体造成错误的SQL文本


### 10、如何变动数据文件的大小？

ALTER DATABASE DATAFILE <datafile_name> RESIZE <new_size>;


### 11、比较truncate和delete 命令
### 12、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 13、用于网络连接的2个文件？
### 14、给出数据库正常启动所经历的几种状态 ?
### 15、解释data block , extent 和 segment的区别？
### 16、FACT Table上需要建立何种索引?
### 17、当用户进程出错，哪个后台进程负责清理它
### 18、说下 Oracle中有哪几种文件？
### 19、集合操作符
### 20、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 21、解释冷备份和热备份的不同点以及各自的优点
### 22、说一下，Oracle的分区有几种
### 23、哪个VIEW用来判断tablespace的剩余空间
### 24、如何建立一个备份控制文件？
### 25、FACT Table上需要建立何种索引？
### 26、说下 Oracle的导入导出有几种方式，有何区别？
### 27、如何定位重要(消耗资源多)的SQL




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
