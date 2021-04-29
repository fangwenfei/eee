# Oracle最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要 rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 2、使用存储过程访问数据库比直接用SQL语句访问有何优点？

**1、** 存储过程是预编译过的，执行时不须编译，执行速度更快。

**2、** 存储过程封装了多条SQL，便于维护数据的完整性与一致性。

**3、** 实现代码复用。


### 3、举出3种可以收集three advisory statistics

Buffer Cache Advice, Segment Level Statistics, Timed Statistics


### 4、提到一个项目的“验证LOV”属性?提到lov和list项目有什么区别?

当验证的LOV设置为True时，Oracle Forms将文本项的当前值与LOV中显示的第一列中的值进行比较。LOV是列表项的属性。列表项只能有一列，而lov可以有一个或多个列。


### 5、说明你可以将FMX转换或反向回到FMB文件吗?

不，不可能将FMX转换或反向回到FMB文件，以确保它们不会丢失。


### 6、提示窗体中触发的顺序是什么?

表单打开时，触发序列　　预成型　　预块　　预录　　前文项　　当新形式的实例　　当新块实例　　当新记录实例　　当新项目实例


### 7、如何生成explain plan?

运行utlxplan.sql. 建立plan 表

针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table

运行utlxplp.sql 或 utlxpls.sql察看explain plan


### 8、用于网络连接的2个文件？

TNSNAMES.ORA and SQLNET.ORA


### 9、数据库的三大范式是什么？

**1、** 第一范式：原子件，要求每一列的值不能再拆分了。

**2、** 第二范式： 一张表只描述一个实体（若列中有冗余数据，则不满足）

**3、** 第三范式： 所有列与主键值直接相关。


### 10、如何判断谁往表里增加了一条纪录？

auditing


### 11、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢?
### 12、如何转换init.ora到spfile?
### 13、pctused and pctfree 表示什么含义有什么作用？
### 14、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 15、解释$$ORACLE\_HOME和$$ORACLE_BASE的区别?
### 16、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 17、什么是绑定变量?
### 18、解释什么是Oracle Forms?
### 19、Oracle 分区在什么情况下使用
### 20、如何进行强制LOG SWITCH?
### 21、如何生成explain plan?
### 22、ORA-01555的应对方法?
### 23、oracle的锁又几种,定义分别是什么;
### 24、存储过程 、函数 、游标 在项目中怎么用的：
### 25、怎样查看数据库引擎的报错
### 26、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?
### 27、解释什么是Partitioning（分区）以及它的优点。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
