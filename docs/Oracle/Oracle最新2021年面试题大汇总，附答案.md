# Oracle最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、不借助第三方工具，怎样查看sql的执行计划

```
set autot on

explain plan set statement_id = &item_id for &sql;
select * from table(dbms_xplan.display);
```


### 2、解释FUNCTION,PROCEDURE和PACKAGE区别

function 和procedure是PL/SQL代码的集合，通常为了完成一个任务。procedure 不需要返回任何值而function将返回一个值在另一

方面，Package是为了完成一个商业功能的一组function和proceudre的集合


### 3、提示窗体中触发的顺序是什么?

表单打开时，触发序列　　预成型　　预块　　预录　　前文项　　当新形式的实例　　当新块实例　　当新记录实例　　当新项目实例


### 4、解释什么是死锁，如何解决Oracle中的死锁？

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


### 5、如何定位重要(消耗资源多)的SQL

```
select sql_text 
from v$sql 
where disk_reads > 1000 or (executions > 0 and buffer_gets/executions > 30000);
```


### 6、简述oracle中 dml、ddl、dcl的使用

**1、** Dml 数据操纵语言，如select、update、delete，insert

**2、** Ddl 数据定义语言，如create table 、drop table 等等

**3、** Dcl 数据控制语言， 如 commit、 rollback、grant、 invoke等


### 7、如何转换init.ora到spfile?

使用create spfile from pfile 命令.


### 8、如何搜集表的各种状态数据？

ANALYZE

The ANALYZE command.


### 9、如何使用Oracle的游标？

**1、** oracle中的游标分为显示游标和隐式游标

**2、** 显示游标是用cursor...is命令定义的游标，它可以对查询语句(select)返回的多条记录进行处理；隐式游标是在执行插入 (insert)、删除(delete)、修改(update)和返回单条记录的查询(select)语句时由PL/SQL自动定义的。

**3、** 显式游标的操作：打开游标、操作游标、关闭游标；PL/SQL隐式地打开SQL游标，并在它内部处理SQL语句，然后关闭它


### 10、如何判断哪个session正在连结以及它们等待的资源？

V$$SESSION / V$$SESSION_WAIT


### 11、哪个VIEW用来判断tablespace的剩余空间
### 12、如何加密PL/SQL程序？
### 13、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 14、如何建立一个备份控制文件？
### 15、解释$$ORACLE\_HOME和$$ORACLE_BASE的区别?
### 16、oracle的锁又几种,定义分别是什么;
### 17、比较truncate和delete 命令
### 18、解释冷备份和热备份的不同点以及各自的优点
### 19、举出两个判断DDL改动的方法？
### 20、提及11g版本2中Oracle Forms Services中引入的新功能是什么?
### 21、说一下，什么是Oracle分区
### 22、说下 oracle 中 dml、ddl、dcl 的使用有哪些
### 23、说一下，Oracle的分区有几种
### 24、给出两个检查表结构的方法
### 25、哪个column可以用来区别V$$视图和GV$$视图?
### 26、你刚刚编译了一个PL/SQL Package但是有错误报道，如何显示出错信息？
### 27、给出两个检查表结构的方法




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
