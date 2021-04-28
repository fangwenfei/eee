# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于:truncate是DDL操作，它移动HWK，不需要rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 2、说明如何在指定的块中迭代项目和记录?

要遍历指定块中的项目和记录，可以使用NEXT_FIELD来迭代特定块中的项，并且NEXT_RECORD遍历块中的记录。


### 3、解释归档和非归档模式之间的不同和它们各自的优缺点

归档模式是指你可以备份所有的数据库 transactions并恢复到任意一个时间点。非归档模式则相反，不能恢复到任意一个时间点。但是非归档模式可以带来数据库性能上的少许提高.


### 4、如何转换init.ora到spfile?

使用create spfile from pfile 命令.


### 5、简单描述table / segment / extent / block之间的关系？

table创建时,默认创建了一个data segment，每个datasegment含有min extents指定的extents数，每个extent据据表空间的存储参数分配一定数量的blocks


### 6、如何生成explain plan?

运行utlxplan.sql. 建立plan 表针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table 运行

utlxplp.sql 或 utlxpls.sql察看explain plan


### 7、创建用户时，需要赋予新用户什么权限才能使它联上数据库。

CONNECT


### 8、说明如何使用相同的LOV 2列?

我们可以通过在全局值中传递返回值并使用代码中的全局值，将相同的LOV用于2列。


### 9、解释Oracle表单服务组件包括什么?

Oracle表单包含：　　客户端：客户端发送HTTP请求　　窗口监听器Servlet：它启动，停止并与窗体运行进程通信　　表单运行过程：它执行特定表单应用程序中包含的代码　　数据库：从数据库中获取的数据


### 10、Oracle的导入导出有几种方式，有何区别？

**1、** 使用oracle工具 exp/imp

**2、** 使用plsql相关工具

**方法1.**

导入/导出的是二进制的数据， 2.plsql导入/导出的是sql语句的文本文件

**3、** sqlloader

**4、** dblink


### 11、举出3种可以收集three advisory statistics
### 12、解释materialized views的作用
### 13、使用索引的理由
### 14、如何重构索引？
### 15、解释FUNCTION,PROCEDURE和PACKAGE区别
### 16、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？
### 17、提及11g版本2中Oracle Forms Services中引入的新功能是什么?
### 18、比较truncate和delete 命令
### 19、如何生成explain plan?
### 20、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 21、说说Oracle中经常使用到的函数
### 22、提示窗体中触发的顺序是什么?
### 23、说明你可以将FMX转换或反向回到FMB文件吗?
### 24、如何增加buffer cache的命中率？
### 25、比较truncate和delete 命令
### 26、FACT Table上需要建立何种索引?
### 27、Oracle跟SQL Server 2005的区别？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
