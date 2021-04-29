# Oracle最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何生成explain plan?

运行utlxplan.sql. 建立plan 表

针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table

运行utlxplp.sql 或 utlxpls.sql察看explain plan


### 2、解释GLOBAL_NAMES设为TRUE的用途？

GLOBAL_NAMES指明联接数据库的方式。如果这个参数设置为TRUE,在建立数据库链接时就必须用相同的名字连结远程数据库


### 3、如何建立一个备份控制文件?

Alter database backup control file to trace.


### 4、不借助第三方工具，怎样查看sql的执行计划

```
set autot on

explain plan set statement_id = &item_id for &sql;
select * from table(dbms_xplan.display);
```


### 5、当用户进程出错，哪个后台进程负责清理它

PMON


### 6、truncate和delete区别：

**1、** Truncate 和delete都可以将数据实体删掉，truncate 的操作并不记录到 rollback日志，所以操作速度较快，但同时这个数据不能恢复

**2、** Delete操作不腾出表空间的空间

**3、** Truncate 不能对视图等进行删除

**4、** Truncate是数据定义语言（DDL），而delete是数据操纵语言(DML)


### 7、Oracle中function和procedure的区别？

**1、** 可以理解函数是存储过程的一种

**2、** 函数可以没有参数,但是一定需要一个返回值，存储过程可以没有参数,不需要返回值

**3、** 函数return返回值没有返回参数模式，存储过程通过out参数返回值, 如果需要返回多个参数则建议使用存储过程

**4、** 在sql数据操纵语句中只能调用函数而不能调用存储过程


### 8、哪个后台进程刷新materialized views?
### 9、解释Oracle表单服务组件包括什么?
### 10、提到一个项目的“验证LOV”属性?提到lov和list项目有什么区别?
### 11、说下 Oracle的导入导出有几种方式，有何区别？
### 12、oracle的锁又几种,定义分别是什么;
### 13、用于网络连接的2个文件？
### 14、使用存储过程访问数据库比直接用SQL语句访问有何优点？
### 15、解释$$ORACLE\_HOME和$$ORACLE_BASE的区别?
### 16、给出两种相关约束?
### 17、解释data block , extent 和 segment的区别？
### 18、比较truncate和delete 命令
### 19、如何增加buffer cache的命中率？
### 20、Oracle的导入导出有几种方式，有何区别？
### 21、如何定位重要(消耗资源多)的SQL
### 22、Oracle的游标在存储过程里是放在begin与end的里面还是外面？
### 23、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 24、说明如何在指定的块中迭代项目和记录?
### 25、Audit trace 存放在哪个oracle目录结构中?
### 26、如何增加buffer cache的命中率?
### 27、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
