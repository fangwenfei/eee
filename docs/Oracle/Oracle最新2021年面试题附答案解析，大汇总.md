# Oracle最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何转换init.ora到spfile?

使用create spfile from pfile 命令


### 2、说明你可以将FMX转换或反向回到FMB文件吗?

不，不可能将FMX转换或反向回到FMB文件，以确保它们不会丢失。


### 3、存储过程 、函数 、游标 在项目中怎么用的：

**存储过程：**

**2、** 能够批量执行的一组SQL语句，且容易控制事务。但没有返回值，可以通过设置in out|out类型的参数返回结果

**3、** 存储过程可以没有参数,不需要返回值

**函数：**

与存储过程相似，函数可以没有参数,但是一定需要一个返回值

**游标：**

游标类似指针，游标可以执行多个不相关的操作.如果希望当产生了结果集后,对结果集中的数据进行多 种不相关的数据操作


### 4、如何启动SESSION级别的TRACE

解答:

DBMS_SESSION.SET_SQL_TRACE

ALTER SESSION SET SQL_TRACE = TRUE;

49.###

这两个ORACLE工具都是用来将数据导入数据库的。

区别是：IMPORT工具只能处理由另一个ORACLE工具EXPORT生成

的数据。而SQL*LOADER可以导入不同的ASCII格式的数据源


### 5、索引是用来干什么的？有那些约束建立索引？

**说下你怎么使用索引的？使用索引的好处和坏处？**

**1、** 索引用于对指定字段查询时，提升查询速度。

**2、** 主要有B树索引，位图索引，函数索引。

**3、** 对查询频率比较高的字段做索引，但一张表不要做太多索引。

**4、** 索引能提升查询效率，但它占用存储空间，且在更新数据时也会影响更新效率。


### 6、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录。


### 7、如何判断数据库的时区？

SELECT DBTIMEZONE FROM DUAL;


### 8、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录


### 9、回滚段的作用是什么

事务回滚：当事务修改表中数据的时候，该数据修改前的值(即前影像)会存放在回滚段中，当用户回滚事务(ROLLBACK)时，ORACLE将会利用回滚段中的数据前影像来将修改的数据恢复到原来的值。

事务恢复：当事务正在处理的时候，例程失败，回滚段的信息保存在undo表空间中，ORACLE将在下次打开数据库时利用回滚来恢复未提交的数据。

**1、** 读一致性：当一个会话正在修改数据时，其他的会话将看不到该会话未提交的修改。

**2、** 当一个语句正在执行时，该语句将看不到从该语句开始执行后的未提交的修改(语句级读一致性)。

**3、** 当ORACLE执行Select语句时，ORACLE依照当前的系统改变号(SYSTEM CHANGE NUMBER-SCN)。

**4、** 来保证任何前于当前SCN的未提交的改变不被该语句处理。可以想象：当一个长时间的查询正在执行时。

**5、** 若其他会话改变了该查询要查询的某个数据块，ORACLE将利用回滚段的数据前影像来构造一个读一致性视图。


### 10、Coalescing做了什么？

Coalescing针对于字典管理的tablespace进行碎片整理，将临近的小extents合并成单个的大extent.


### 11、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 12、ORA-01555的应对方法？
### 13、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 14、如何生成explain plan?
### 15、说明如何在指定的块中迭代项目和记录?
### 16、如何判断谁往表里增加了一条纪录？
### 17、哪个column可以用来区别V$$视图和GV$$视图?
### 18、如何在tablespace里增加数据文件？
### 19、在千万级的数据库查询中，如何提高效率？
### 20、使用索引的理由
### 21、列出Oracle Forms配置文件?
### 22、pctused and pctfree 表示什么含义有什么作用？
### 23、说下 Oracle的导入导出有几种方式，有何区别？
### 24、集合操作符
### 25、可以从表单执行动态SQL吗?
### 26、Oracle中function和procedure的区别？
### 27、用于网络连接的2个文件？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
