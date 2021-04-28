# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、给出两个检查表结构的方法

1.DESCRIBE命令

**2、** DBMS_METADATA.GET_DDL 包


### 2、如何在不影响子表的前提下，重建一个母表

子表的外键强制实效，重建母表，激活外键


### 3、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？

重建控制文件，用带backup control file 子句的recover 命令恢复数据库。


### 4、怎样查看数据库引擎的报错

alert log.


### 5、说下，内连接，左连接，右连接的区别

**内连接：**

指主表，从表中符合连接条件的记录全部显示

**左连接：**

外连接方式，主要是显示主表，从表中符合连接条件的记录，并且主表中所有不符合连接条件的记录也要显示。

**右连接：**

外连接方式，主要是显示主表，从表中所有符合连接条件的记录，并且从表中不符合的记录也要显示。


### 6、日志的作用是什么

记录数据库事务,最大限度地保证数据的一致性与安全性

重做日志文件：含对数据库所做的更改记录，这样万一出现故障可以启用数据恢复,一个数据库至少需要两个重做日志文件

归档日志文件：是重做日志文件的脱机副本，这些副本可能对于从介质失败中进行恢复很必要。


### 7、说说Oracle中经常使用到的函数

length长度、lower小写、upper大写、to_date转化日期、to_char转化字符、to_number转化数字Ltrim去左边空格、rtrim去右边空格、substr截取字符串、add_month增加或减掉月份、


### 8、解释什么是死锁，如何解决Oracle中的死锁？

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


### 9、提到一个项目的“验证LOV”属性?提到lov和list项目有什么区别?

当验证的LOV设置为True时，Oracle Forms将文本项的当前值与LOV中显示的第一列中的值进行比较。LOV是列表项的属性。列表项只能有一列，而lov可以有一个或多个列。


### 10、truncate和delete区别：

**1、** Truncate 和delete都可以将数据实体删掉，truncate 的操作并不记录到 rollback日志，所以操作速度较快，但同时这个数据不能恢复

**2、** Delete操作不腾出表空间的空间

**3、** Truncate 不能对视图等进行删除

**4、** Truncate是数据定义语言（DDL），而delete是数据操纵语言(DML)


### 11、解释什么是死锁，如何解决Oracle中的死锁？
### 12、解释归档和非归档模式之间的不同和它们各自的优缺点
### 13、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 14、当用户进程出错，哪个后台进程负责清理它
### 15、创建数据库时自动建立的tablespace名称？
### 16、描述tablespace和datafile之间的关系
### 17、如何转换init.ora到spfile?
### 18、如何增加buffer cache的命中率？
### 19、数据库的三大范式是什么？
### 20、TEMPORARY tablespace和PERMANENT tablespace 的区别是？
### 21、说下 Oracle中有哪几种文件？
### 22、说下 Oracle中function和procedure的区别？
### 23、哪个VIEW用来判断tablespace的剩余空间
### 24、解释什么是Oracle Forms?
### 25、简述oracle中 dml、ddl、dcl的使用
### 26、解释冷备份和热备份的不同点以及各自的优点
### 27、说明你可以将FMX转换或反向回到FMB文件吗?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
