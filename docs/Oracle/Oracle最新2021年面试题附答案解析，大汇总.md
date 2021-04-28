# Oracle最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Oralce怎样存储文件，能够存储哪些文件？

**1、** Oracle 能存储 clob、nclob、 blob、 bfile

**2、** Clob 可变长度的字符型数据，也就是其他数据库中提到的文本型数据类型

**3、** Nclob 可变字符类型的数据，不过其存储的是Unicode字符集的字符数据

**4、** Blob 可变长度的二进制数据

**5、** Bfile 数据库外面存储的可变二进制数据


### 2、给出数据库正常启动所经历的几种状态 ?

STARTUP NOMOUNT – 数据库实例启动

STARTUP MOUNT - 数据库装载

STARTUP OPEN – 数据库打开


### 3、Oracle 分区在什么情况下使用

当一张表的数据量到达上亿行的时候，表的性能会严重降低，这个时候就需要用到分区了，通过划分成多个小表，并在每个小表上建立本地索引可以大大缩小索引数据文件的大小，从而更快的定位到目标数据来提升访问性能。

分区除了可以用来提升访问性能外，还因为可以指定分区所使用的表空间，因此也用来做数据的生命周期管理。当前需要频繁使用的活跃数据可以放到访问速度更快但价格也更贵的存储设备上，而2、3年前的历史数据，或者叫冷数据可以放到更廉价、速度更低的设备上。从而降低存储费用。


### 4、如何使用Oracle的游标？

**1、** oracle中的游标分为显示游标和隐式游标

**2、** 显示游标是用cursor...is命令定义的游标，它可以对查询语句(select)返回的多条记录进行处理；隐式游标是在执行插入 (insert)、删除(delete)、修改(update)和返回单条记录的查询(select)语句时由PL/SQL自动定义的。

**3、** 显式游标的操作：打开游标、操作游标、关闭游标；PL/SQL隐式地打开SQL游标，并在它内部处理SQL语句，然后关闭它


### 5、如何生成explain plan?

运行utlxplan.sql. 建立plan 表

针对特定SQL语句，使用 explain plan set statement_id = 'tst1' into plan_table

运行utlxplp.sql 或 utlxpls.sql察看explain plan


### 6、举出3种可以收集three advisory statistics

Buffer Cache Advice, Segment Level Statistics, Timed Statistics


### 7、什么是绑定变量?

报表6i中使用了绑定变量来替换select语句中的单个参数。


### 8、如何判断数据库的时区？

SELECT DBTIMEZONE FROM DUAL;


### 9、ORA-01555的应对方法？

具体的出错信息是snapshot too old within rollback seg , 通常可以通过增大rollback seg来解决问题。当然也需要察看一下具

体造成错误的SQL文本


### 10、如何建立一个备份控制文件?

Alter database backup control file to trace.


### 11、哪个VIEW用来检查数据文件的大小？
### 12、如何判断谁往表里增加了一条纪录？
### 13、如何建立一个备份控制文件？
### 14、说一下，Oracle的分区有几种
### 15、FACT Table上需要建立何种索引？
### 16、说下如何使用Oracle的游标？
### 17、解释Oracle表单服务组件包括什么?
### 18、如何增加buffer cache的命中率？
### 19、哪个后台进程刷新materialized views?
### 20、Oracle的导入导出有几种方式，有何区别？
### 21、如何定位重要(消耗资源多)的SQL
### 22、举出两个判断DDL改动的方法？
### 23、解释data block , extent 和 segment的区别(这里建议用英文术语)
### 24、如何重构索引？
### 25、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢?
### 26、哪个column可以用来区别V$$视图和GV$$视图?
### 27、如何生成explain plan?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
