# Oracle最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何重构索引？

ALTER INDEX <index_name> REBUILD;


### 2、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？

ORACLE_BASE是oracle的根目录，ORACLE_HOME是oracle产品的目录


### 3、解释GLOBAL_NAMES设为TRUE的用途？

GLOBAL_NAMES指明联接数据库的方式。如果这个参数设置为TRUE,在建立数据库链接时就必须用相同的名字连结远程数据库


### 4、提及11g版本2中Oracle Forms Services中引入的新功能是什么?

在Oracle Forms Services中，包括的功能包括：　　与Oracle Access Manager集成　　计划表格运行预备　　增强的网络统计报告　　支持Unicode列　　guiMode配置参数　　表单指标代理　　支持图像项目和图标按钮中的URL　　Oracle真正的用户体验洞察


### 5、如何转换init.ora到spfile?

使用create spfile from pfile 命令.


### 6、如何增加buffer cache的命中率？

在数据库较繁忙时，适用buffer cache advisory 工具，查询v$db_cache_advice . 如果有必要更改，可以使用 alter system set

db_cache_size 命令


### 7、Oracle跟SQL Server 2005的区别？

**宏观上：**

**1、** 最大的区别在于平台，oracle可以运行在不同的平台上，sql server只能运行在windows平台上，由于windows平台的稳定性和安全性影响了sql server的稳定性和安全性

**2、** oracle使用的脚本语言为PL-SQL，而sql server使用的脚本为T-SQL

**微观上：**

**1、** 从数据类型,数据库的结构等等回答


### 8、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？

重建控制文件，用带backup control file 子句的recover 命令恢复数据库。


### 9、如何变动数据文件的大小？

ALTER DATABASE DATAFILE <datafile_name> RESIZE <new_size>;


### 10、给出两种相关约束?

主键和外键


### 11、说下 oracle 中 dml、ddl、dcl 的使用有哪些
### 12、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 13、说下 Oracle的导入导出有几种方式，有何区别？
### 14、哪个column可以用来区别V$$视图和GV$$视图?
### 15、如何生成explain plan?
### 16、给出数据库正常启动所经历的几种状态 ?
### 17、日志的作用是什么
### 18、比较truncate和delete 命令
### 19、在千万级的数据库查询中，如何提高效率？
### 20、怎样创建一个一个索引,索引使用的原则,有什么优点和缺点
### 21、创建用户时，需要赋予新用户什么权限才能使它联上数据库。
### 22、如何加密PL/SQL程序？
### 23、Oracle的导入导出有几种方式，有何区别？
### 24、给出两个检查表结构的方法
### 25、如何使用Oracle的游标？
### 26、哪个VIEW用来判断tablespace的剩余空间
### 27、说下，内连接，左连接，右连接的区别




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
