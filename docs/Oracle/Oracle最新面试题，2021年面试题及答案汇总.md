# Oracle最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢？

重建控制文件，用带backup control file 子句的recover 命令恢复数据库。


### 2、使用索引的理由

快速访问表中的data block


### 3、说下 oracle的锁又几种,定义分别是什么;

**1、** 行共享锁 (ROW SHARE)

**2、** 行排他锁(ROW EXCLUSIVE)

**3、** 共享锁(SHARE)

**4、** 共享行排他锁(SHARE ROW EXCLUSIVE)

**5、** 排他锁(EXCLUSIVE)


### 4、你必须利用备份恢复数据库，但是你没有控制文件，该如何解决问题呢?

重建控制文件，用带backup control file 子句的recover 命令恢复数据库。


### 5、创建数据库时自动建立的tablespace名称？

SYSTEM tablespace.


### 6、如何使用Oracle的游标？

**1、** oracle中的游标分为显示游标和隐式游标

**2、** 显示游标是用cursor...is命令定义的游标，它可以对查询语句(select)返回的多条记录进行处理；隐式游标是在执行插入 (insert)、删除(delete)、修改(update)和返回单条记录的查询(select)语句时由PL/SQL自动定义的。

**3、** 显式游标的操作：打开游标、操作游标、关闭游标；PL/SQL隐式地打开SQL游标，并在它内部处理SQL语句，然后关闭它


### 7、如何判断数据库的时区？

SELECT DBTIMEZONE FROM DUAL;


### 8、解释冷备份和热备份的不同点以及各自的优点
### 9、给出数据库正常启动所经历的几种状态 ?
### 10、比较truncate和delete 命令
### 11、如何增加buffer cache的命中率？
### 12、集合操作符
### 13、简述oracle中 dml、ddl、dcl的使用
### 14、FACT Table上需要建立何种索引？
### 15、解释归档和非归档模式之间的不同和它们各自的优缺点
### 16、本地管理表空间和字典管理表空间的特点，ASSM有什么特点？
### 17、如何转换init.ora到spfile?
### 18、创建用户时，需要赋予新用户什么权限才能使它联上数据库。
### 19、触发器的作用有哪些？
### 20、FACT Table上需要建立何种索引？
### 21、你刚刚编译了一个PL/SQL Package但是有错误报道，如何显示出错信息？
### 22、举出两个判断DDL改动的方法？
### 23、给出两个检查表结构的方法
### 24、说一下，Oracle的分区有几种
### 25、如何转换init.ora到spfile?
### 26、解释data block , extent 和 segment的区别（这里建议用英文术语）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
