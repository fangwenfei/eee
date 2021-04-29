# Oracle最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、举出3种可以收集three advisory statistics

Buffer Cache Advice, Segment Level Statistics, Timed Statistics


### 2、给出两个检查表结构的方法

1.DESCRIBE命令

2.DBMS_METADATA.GET_DDL 包


### 3、简述oracle中 dml、ddl、dcl的使用

**1、** Dml 数据操纵语言，如select、update、delete，insert

**2、** Ddl 数据定义语言，如create table 、drop table 等等

**3、** Dcl 数据控制语言， 如 commit、 rollback、grant、 invoke等


### 4、如何增加buffer cache的命中率?

在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice.如果有必要更改，可以使用 alter system set db_cache_size 命令


### 5、索引是用来干什么的？有那些约束建立索引？

**说下你怎么使用索引的？使用索引的好处和坏处？**

**1、** 索引用于对指定字段查询时，提升查询速度。

**2、** 主要有B树索引，位图索引，函数索引。

**3、** 对查询频率比较高的字段做索引，但一张表不要做太多索引。

**4、** 索引能提升查询效率，但它占用存储空间，且在更新数据时也会影响更新效率。


### 6、描述什么是 redo logs

Redo Logs 是用于存放数据库数据改动状况的物理和逻辑结构。可以用来修复数据库.


### 7、解释什么是Oracle Forms?

Oracle Forms是用于创建与Oracle数据库交互的软件产品。它有一个IDE，包括一个属性表，对象导航器和使用PL/SQL的代码编辑器。


### 8、Oracle的游标在存储过程里是放在begin与end的里面还是外面？

Oracle的存储过程跟函数你写没有？项目中用到没有？怎么用的？

**1、** 放在begin与end之间。

**2、** 用作多表连接查询数据返回结果查询。

**3、** 复杂的业务操作，涉及多表的数据操作的事务控制。

**4、** 预防SQL注入。


### 9、如何生成explain plan?

运行utlxplan.sql. 建立plan 表

针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table运行utlxplp.sql 或 utlxpls.sql察看explain plan


### 10、提示窗体中触发的顺序是什么?

表单打开时，触发序列　　预成型　　预块　　预录　　前文项　　当新形式的实例　　当新块实例　　当新记录实例　　当新项目实例


### 11、给出两个检查表结构的方法
### 12、说明如何使用相同的LOV 2列?
### 13、解释冷备份和热备份的不同点以及各自的优点
### 14、说明你可以将FMX转换或反向回到FMB文件吗?
### 15、解释什么是死锁，如何解决Oracle中的死锁？
### 16、描述tablespace和datafile之间的关系
### 17、说下 Oracle中有哪几种文件？
### 18、FACT Table上需要建立何种索引？
### 19、说说Oracle中经常使用到的函数
### 20、如何增加buffer cache的命中率？
### 21、你刚刚编译了一个PL/SQL Package但是有错误报道，如何显示出错信息？
### 22、数据库的三大范式是什么？
### 23、Oralce怎样存储文件，能够存储哪些文件？
### 24、简单描述table / segment / extent / block之间的关系？
### 25、pctused and pctfree 表示什么含义有什么作用？
### 26、ORA-01555的应对方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
