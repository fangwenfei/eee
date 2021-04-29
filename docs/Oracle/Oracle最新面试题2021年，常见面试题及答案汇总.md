# Oracle最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何判断数据库的时区？

SELECT DBTIMEZONE FROM DUAL;


### 2、解释data block , extent 和 segment的区别(这里建议用英文术语)

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一个数据库对象拥有的所有extents被称为该对象的segment.


### 3、如何搜集表的各种状态数据？

ANALYZE

The ANALYZE command.


### 4、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢?

重建控制文件，用带backup control file 子句的recover 命令恢复数据库。


### 5、什么是绑定变量?

报表6i中使用了绑定变量来替换select语句中的单个参数。


### 6、如何在不影响子表的前提下，重建一个母表

子表的外键强制实效，重建母表，激活外键


### 7、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于:truncate是DDL操作，它移动HWK，不需要rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 8、解释data block , extent 和 segment的区别（这里建议用英文术语）

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一个数据库对象拥有的所有extents被称为该对象的segment.


### 9、解释归档和非归档模式之间的不同和它们各自的优缺点

归档模式是指你可以备份所有的数据库 transactions并恢复到任意一个时间点。非归档模式则相反，不能恢复到任意一个时间点。但是非归档模式可以带来数据库性能上的少许提高.


### 10、Oracle 分区在什么情况下使用

当一张表的数据量到达上亿行的时候，表的性能会严重降低，这个时候就需要用到分区了，通过划分成多个小表，并在每个小表上建立本地索引可以大大缩小索引数据文件的大小，从而更快的定位到目标数据来提升访问性能。

分区除了可以用来提升访问性能外，还因为可以指定分区所使用的表空间，因此也用来做数据的生命周期管理。当前需要频繁使用的活跃数据可以放到访问速度更快但价格也更贵的存储设备上，而2、3年前的历史数据，或者叫冷数据可以放到更廉价、速度更低的设备上。从而降低存储费用。


### 11、ORA-01555的应对方法？
### 12、说下如何使用Oracle的游标？
### 13、如何生成explain plan?
### 14、说下 oracle的锁又几种,定义分别是什么;
### 15、本地管理表空间和字典管理表空间的特点，ASSM有什么特点？
### 16、解释data block , extent 和 segment的区别？
### 17、ORA-01555的应对方法?
### 18、解释FUNCTION,PROCEDURE和PACKAGE区别
### 19、如何在tablespace里增加数据文件？
### 20、集合操作符
### 21、如何判断谁往表里增加了一条纪录？
### 22、事务的特性（ACID）是指什么？
### 23、Oracle中function和procedure的区别？
### 24、如何进行强制LOG SWITCH?
### 25、解释什么是Partitioning（分区）以及它的优点。
### 26、FACT Table上需要建立何种索引？
### 27、举出两个判断DDL改动的方法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
