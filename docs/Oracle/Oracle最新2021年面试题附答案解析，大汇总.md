# Oracle最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、给出数据库正常启动所经历的几种状态 ?

STARTUP NOMOUNT – 数据库实例启动

STARTUP MOUNT - 数据库装载

STARTUP OPEN – 数据库打开


### 2、FACT Table上需要建立何种索引?

位图索引 (bitmap index)


### 3、TEMPORARY tablespace和PERMANENT tablespace 的区别是？

A temporary tablespace 用于临时对象例如排序结构而 permanent tablespaces用来存储那些'真实'的对象(例如表，回滚段等)


### 4、解释materialized views的作用

Materialized views 用于减少那些汇总，集合和分组的信息的集合数量。它们通常适合于数据仓库和DSS系统。


### 5、说下 怎样创建一个视图,视图的好处, 视图可以控制权限吗?

create view 视图名 as select 列名 [别名]  …  from 表 [unio [all] select … ] ]

好处：

**1、** 可以简单的将视图理解为sql查询语句，视图最大的好处是不占系统空间

**2、** 一些安全性很高的系统，不会公布系统的表结构，可能会使用视图将一些敏感信息过虑或者重命名后公布结构

**3、** 简化查询

**4、** 视图可以控制权限的，在使用的时候需要将视图的使用权限grant给用户


### 6、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术

**1、** 中止当前语句执行，转到exception语句块执行。

**2、** 在异常处理时，捕获相应异常，并执行对应解决方案语句。


### 7、使用存储过程访问数据库比直接用SQL语句访问有何优点？

**1、** 存储过程是预编译过的，执行时不须编译，执行速度更快。

**2、** 存储过程封装了多条SQL，便于维护数据的完整性与一致性。

**3、** 实现代码复用。


### 8、MySQL数据库与Oracle 数据库有什么区别？

**1、** 应用方面，MySQL 是中小型应用的数据库。一般用于个人和中小型企业。Oracle 属于大型数据库，一般用于具有相当规模的企业应用。

**2、** 自动增长的数据类型方面： MySQL有自动增长的数据类型。Oracle 没有自动增长的数据类型。需要建立一个自增序列。

**3、** group by 用法： MySQL 中group by 在SELECT 语句中可以随意使用，但在ORACLE 中如果查询语句中有组函数，那么其他列必须是组函数处理过的或者是group by子句中的列，否则会报错。

**4、** 引导方面： MySQL中可以用单引号、双引号包起字符串，Oracle 中只可以用单引号包起字符串


### 9、可以从表单执行动态SQL吗?

是的，可以通过使用内置的FORMS_DDL或通过从表单调用DBNS_SQL数据库包从表单执行动态SQL。


### 10、解释TABLE Function的用途

TABLE Function是通过PL/SQL逻辑返回一组纪录，用于普通的表/视图。他们也用于pipeline和ETL过程。


### 11、用于网络连接的2个文件？
### 12、delete 与Truncate区别？
### 13、如何启动SESSION级别的TRACE
### 14、解释 冷备份 和 热备份 的不同点，以及各自的优点？
### 15、说一下，什么是Oracle分区
### 16、Audit trace 存放在哪个oracle目录结构中?
### 17、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 18、如何转换init.ora到spfile?
### 19、存储过程 、函数 、游标 在项目中怎么用的：
### 20、哪个column可以用来区别V$$视图和GV$$视图?
### 21、回滚段的作用是什么
### 22、说明如何在指定的块中迭代项目和记录?
### 23、说一下，Oracle的分区有几种
### 24、提到一个项目的“验证LOV”属性?提到lov和list项目有什么区别?
### 25、SGA主要有那些部分，主要作用是什么?
### 26、哪个VIEW用来检查数据文件的大小？
### 27、怎样查看数据库引擎的报错




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
