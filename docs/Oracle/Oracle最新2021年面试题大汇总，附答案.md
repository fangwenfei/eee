# Oracle最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Oracle中function和procedure的区别？

**1、** 可以理解函数是存储过程的一种

**2、** 函数可以没有参数,但是一定需要一个返回值，存储过程可以没有参数,不需要返回值

**3、** 函数return返回值没有返回参数模式，存储过程通过out参数返回值, 如果需要返回多个参数则建议使用存储过程

**4、** 在sql数据操纵语句中只能调用函数而不能调用存储过程


### 2、如何变动数据文件的大小？

ALTER DATABASE DATAFILE <datafile_name> RESIZE <new_size>;


### 3、集合操作符

**1、** Union ： 不包含重复值，默认按第一个查询的第一列升序排列。

**2、** Union All : 完全并集包含重复值。不排序。

**3、** Minus 不包含重复值，不排序。


### 4、使用存储过程访问数据库比直接用SQL语句访问有何优点？

**1、** 存储过程是预编译过的，执行时不须编译，执行速度更快。

**2、** 存储过程封装了多条SQL，便于维护数据的完整性与一致性。

**3、** 实现代码复用。


### 5、说一下，什么是Oracle分区

分区的实质是把一张大表的数据按照某种规则使用多张子表来存储。

然后这多张子表使用统一的表名对外提供服务，子表实际对用户不可见。类似于在多张子表上建立一个视图，然后用户直接使用该视图来访问数据。


### 6、说下 怎样创建一个视图,视图的好处, 视图可以控制权限吗?

create view 视图名 as select 列名 [别名]  …  from 表 [unio [all] select … ] ]

好处：

**1、** 可以简单的将视图理解为sql查询语句，视图最大的好处是不占系统空间

**2、** 一些安全性很高的系统，不会公布系统的表结构，可能会使用视图将一些敏感信息过虑或者重命名后公布结构

**3、** 简化查询

**4、** 视图可以控制权限的，在使用的时候需要将视图的使用权限grant给用户


### 7、说下 Oracle的导入导出有几种方式，有何区别？

**1、** 使用oracle工具 exp/imp

**2、** 使用plsql相关工具

方法1、导入/导出的是二进制的数据，

方法2、.plsql导入/导出的是sql语句的文本文件


### 8、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录


### 9、解释GLOBAL_NAMES设为TRUE的用途？

GLOBAL_NAMES指明联接数据库的方式。如果这个参数设置为TRUE,在建立数据库链接时就必须用相同的名字连结远程数据库


### 10、Coalescing做了什么？

Coalescing针对于字典管理的tablespace进行碎片整理，将临近的小extents合并成单个的大extent.


### 11、列出Oracle Forms配置文件?
### 12、回滚段的作用是什么
### 13、pctused and pctfree 表示什么含义有什么作用？
### 14、如何加密PL/SQL程序？
### 15、说明如何使用相同的LOV 2列?
### 16、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?
### 17、解释FUNCTION,PROCEDURE和PACKAGE区别
### 18、比较truncate和delete 命令
### 19、解释 冷备份 和 热备份 的不同点，以及各自的优点？
### 20、在Oracle Forms Report中，Record组列的最大长度是多少?什么是不同类型的记录组?
### 21、不借助第三方工具，怎样查看sql的执行计划
### 22、本地管理表空间和字典管理表空间的特点，ASSM有什么特点？
### 23、使用索引的理由
### 24、ORA-01555的应对方法?
### 25、事务的特性（ACID）是指什么？
### 26、哪个column可以用来区别V$$视图和GV$$视图?
### 27、如何判断哪个session正在连结以及它们等待的资源？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
