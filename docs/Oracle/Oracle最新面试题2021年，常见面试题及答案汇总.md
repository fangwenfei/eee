# Oracle最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、使用存储过程访问数据库比直接用SQL语句访问有何优点？

**1、** 存储过程是预编译过的，执行时不须编译，执行速度更快。

**2、** 存储过程封装了多条SQL，便于维护数据的完整性与一致性。

**3、** 实现代码复用。


### 2、MySQL数据库与Oracle 数据库有什么区别？

**1、** 应用方面，MySQL 是中小型应用的数据库。一般用于个人和中小型企业。Oracle 属于大型数据库，一般用于具有相当规模的企业应用。

**2、** 自动增长的数据类型方面： MySQL有自动增长的数据类型。Oracle 没有自动增长的数据类型。需要建立一个自增序列。

**3、** group by 用法： MySQL 中group by 在SELECT 语句中可以随意使用，但在ORACLE 中如果查询语句中有组函数，那么其他列必须是组函数处理过的或者是group by子句中的列，否则会报错。

**4、** 引导方面： MySQL中可以用单引号、双引号包起字符串，Oracle 中只可以用单引号包起字符串


### 3、说下 Oracle中function和procedure的区别？

**1、** 可以理解函数是存储过程的一种

**2、** 函数可以没有参数,但是一定需要一个返回值，存储过程可以没有参数,不需要返回值

**3、** 函数return返回值没有返回参数模式，存储过程通过out参数返回值, 如果需要返回多个参数则建议使用存储过程

**4、** 在sql数据操纵语句中只能调用函数而不能调用存储过程


### 4、简述oracle中 dml、ddl、dcl的使用

**1、** Dml 数据操纵语言，如select、update、delete，insert

**2、** Ddl 数据定义语言，如create table 、drop table 等等

**3、** Dcl 数据控制语言， 如 commit、 rollback、grant、 invoke等


### 5、如何增加buffer cache的命中率？

在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice . 如果有必要更改，可以使用 alter system set

db_cache_size 命令


### 6、如何启动SESSION级别的TRACE

解答:

DBMS_SESSION.SET_SQL_TRACE

ALTER SESSION SET SQL_TRACE = TRUE;

49.###

这两个ORACLE工具都是用来将数据导入数据库的。

区别是：IMPORT工具只能处理由另一个ORACLE工具EXPORT生成

的数据。而SQL*LOADER可以导入不同的ASCII格式的数据源


### 7、解释什么是Oracle Forms?

Oracle Forms是用于创建与Oracle数据库交互的软件产品。它有一个IDE，包括一个属性表，对象导航器和使用PL/SQL的代码编辑器。


### 8、delete 与Truncate区别？

**1、** Truncate 是DDL 语句，DELETE 是DML语句。

**2、** Truncate 的速度远快于DELETE；

原因是： 当执行DELETE操作时所有表数据先被COPY到回滚表空间，数据量不同花费时间长短不一。而TRUNCATE 是直接删除数据不进回滚表空间。

**1、** delete 数据可以运行Rollback 进行数据回滚。而Truncate 则是永久删除不能回滚。

**2、** Truncate 操作不会触发表上的delete触发器，而delete 会正常触发。

**3、** Truncate 语句不能带where 条件意味着只能全部数据删除，而DELETE可带where 条件进行删除数据。

**4、** Truncate 操作会重置表的高水位线（High Water Mark）,而delete 不会。


### 9、如何加密PL/SQL程序？

WRAP


### 10、哪个VIEW用来检查数据文件的大小？

DBA_DATA_FILES


### 11、在Oracle Forms Report中，Record组列的最大长度是多少?什么是不同类型的记录组?
### 12、TEMPORARY tablespace和PERMANENT tablespace 的区别是？
### 13、哪个column可以用来区别V$$视图和GV$$视图?
### 14、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 15、举出两个判断DDL改动的方法？
### 16、如何判断数据库的时区？
### 17、如何搜集表的各种状态数据？
### 18、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?
### 19、给出两个检查表结构的方法
### 20、什么是绑定变量?
### 21、ORA-01555的应对方法？
### 22、集合操作符
### 23、说一下，Oracle的分区有几种
### 24、解释冷备份和热备份的不同点以及各自的优点
### 25、如何生成explain plan?
### 26、回滚段的作用是什么
### 27、ORA-01555的应对方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
