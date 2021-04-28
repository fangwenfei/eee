# Oracle最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、简单描述table / segment / extent / block之间的关系？

table创建时,默认创建了一个data segment，每个datasegment含有min extents指定的extents数，每个extent据据表空间的存储参数分配一定数量的blocks


### 2、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 3、创建用户时，需要赋予新用户什么权限才能使它联上数据库。

CONNECT


### 4、解释归档和非归档模式之间的不同和它们各自的优缺点

归档模式是指你可以备份所有的数据库 transactions并恢复到任意一个时间点。非归档模式则相反，不能恢复到任意一个时间点。

但是非归档模式可以带来数据库性能上的少许提高


### 5、TEMPORARY tablespace和PERMANENT tablespace 的区别是？

A temporary tablespace 用于临时对象例如排序结构而 permanent tablespaces用来存储那些'真实'的对象(例如表，回滚段等)


### 6、描述什么是 redo logs

Redo Logs 是用于存放数据库数据改动状况的物理和逻辑结构。可以用来修复数据库.


### 7、在Oracle Forms Report中，Record组列的最大长度是多少?什么是不同类型的记录组?

记录组列名的最大长度不能超过30个字符。不同类型的记录组包括：查询记录组　　状态记录组　　非查询记录组


### 8、如何建立一个备份控制文件?

Alter database backup control file to trace.


### 9、解释GLOBAL_NAMES设为TRUE的用途？

GLOBAL_NAMES指明联接数据库的方式。如果这个参数设置为TRUE,在建立数据库链接时就必须用相同的名字连结远程数据库


### 10、给出在STAR SCHEMA中的两种表及它们分别含有的数据

Fact tables 和dimension tables. fact table包含大量的主要的信息而dimension tables 存放对fact table 某些属性描述的信息


### 11、举出3种可以收集three advisory statistics
### 12、事务的特性（ACID）是指什么？
### 13、哪个column可以用来区别V$$视图和GV$$视图?
### 14、给出两种相关约束?
### 15、提示窗体中触发的顺序是什么?
### 16、Oracle中function和procedure的区别？
### 17、说说Oracle中经常使用到的函数
### 18、给出两个检查表结构的方法
### 19、怎样查看数据库引擎的报错
### 20、oracle的锁又几种,定义分别是什么;
### 21、truncate和delete区别：
### 22、如何生成explain plan?
### 23、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术
### 24、如何在tablespace里增加数据文件？
### 25、解释FUNCTION,PROCEDURE和PACKAGE区别
### 26、oracle中存储过程，游标和函数的区别
### 27、说明你可以将FMX转换或反向回到FMB文件吗?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
