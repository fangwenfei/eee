# Oracle最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、TEMPORARY tablespace和PERMANENT tablespace 的区别是？

A temporary tablespace 用于临时对象例如排序结构而 permanent tablespaces用来存储那些'真实'的对象(例如表，回滚段等)


### 2、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 3、提及11g版本2中Oracle Forms Services中引入的新功能是什么?

在Oracle Forms Services中，包括的功能包括：　　与Oracle Access Manager集成　　计划表格运行预备　　增强的网络统计报告　　支持Unicode列　　guiMode配置参数　　表单指标代理　　支持图像项目和图标按钮中的URL　　Oracle真正的用户体验洞察


### 4、说下 Oracle中有哪几种文件？

**1、** 数据文件（一般后缀为.dbf或者.ora）

**2、** 日志文件(后缀名.log)

**3、** 控制文件（后缀名为.c


### 5、解释TABLE Function的用途

TABLE Function是通过PL/SQL逻辑返回一组纪录，用于普通的表/视图。他们也用于pipeline和ETL过程。


### 6、FACT Table上需要建立何种索引？

位图索引 （bitmap index）


### 7、Oracle中function和procedure的区别？

**1、** 可以理解函数是存储过程的一种

**2、** 函数可以没有参数,但是一定需要一个返回值，存储过程可以没有参数,不需要返回值

**3、** 函数return返回值没有返回参数模式，存储过程通过out参数返回值, 如果需要返回多个参数则建议使用存储过程

**4、** 在sql数据操纵语句中只能调用函数而不能调用存储过程


### 8、给出两个检查表结构的方法

1.DESCRIBE命令

2.DBMS_METADATA.GET_DDL 包


### 9、给出数据库正常启动所经历的几种状态 ?

STARTUP NOMOUNT ?C 数据库实例启动

STARTUP MOUNT - 数据库装载

STARTUP OPEN ?C 数据库打开


### 10、简述oracle中 dml、ddl、dcl的使用

**1、** Dml 数据操纵语言，如select、update、delete，insert

**2、** Ddl 数据定义语言，如create table 、drop table 等等

**3、** Dcl 数据控制语言， 如 commit、 rollback、grant、 invoke等


### 11、说明如何在指定的块中迭代项目和记录?
### 12、解释冷备份和热备份的不同点以及各自的优点
### 13、说下如何使用Oracle的游标？
### 14、列出Oracle Forms配置文件?
### 15、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 16、解释Oracle表单服务组件包括什么?
### 17、delete 与Truncate区别？
### 18、如何重构索引？
### 19、日志的作用是什么
### 20、说下，内连接，左连接，右连接的区别
### 21、解释materialized views的作用
### 22、哪个VIEW用来检查数据文件的大小？
### 23、FACT Table上需要建立何种索引？
### 24、如何增加buffer cache的命中率？
### 25、oracle中存储过程，游标和函数的区别
### 26、哪个后台进程刷新materialized views?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
