# Oracle最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、说下 Oracle中有哪几种文件？

**1、** 数据文件（一般后缀为.dbf或者.ora）

**2、** 日志文件(后缀名.log)

**3、** 控制文件（后缀名为.c


### 2、Oralce怎样存储文件，能够存储哪些文件？

**1、** Oracle 能存储 clob、nclob、 blob、 bfile

**2、** Clob 可变长度的字符型数据，也就是其他数据库中提到的文本型数据类型

**3、** Nclob 可变字符类型的数据，不过其存储的是Unicode字符集的字符数据

**4、** Blob 可变长度的二进制数据

**5、** Bfile 数据库外面存储的可变二进制数据


### 3、解释什么是死锁，如何解决Oracle中的死锁？

简言之就是存在加了锁而没有解锁，可能是使用锁没有提交或者回滚事务，如果是表级锁则不能操作表，客户端处于等在状态，如果是行级锁则不能操作锁定行

**解决办法：**

查找出被锁的表

```
select b.owner,b.object_name,a.session_id,a.locked_mode 
from v$locked_object a,dba_objects b 
where b.object_id = a.object_id; 

select b.username,b.sid,b.serial#,logon_time 
from v$locked_object a,v$session b 
where a.session_id = b.sid order by b.logon_time;
```

**杀进程中的会话**

`alter system kill session "sid,serial#";`


### 4、如何判断哪个session正在连结以及它们等待的资源？

V$$SESSION / V$$SESSION_WAIT


### 5、描述tablespace和datafile之间的关系

一个tablespace可以有一个或多个datafile，每个datafile只能在一个tablespace内，table中的数据,通过hash算法分布在tablespace中的各个datafile中，tablespace是逻辑上的概念,datafile则在物理上储存了数据库的种种对象。


### 6、列出Oracle Forms配置文件?

Oracle Forms配置文件包括：　　基本HTML文件(base.htm，basejini.htm，basejpi.htm和baseie.htm)　　ENV　　CFG　　CFG　　DEVLOBER


### 7、用于网络连接的2个文件？

TNSNAMES.ORA and SQLNET.ORA


### 8、可以从表单执行动态SQL吗?

是的，可以通过使用内置的FORMS_DDL或通过从表单调用DBNS_SQL数据库包从表单执行动态SQL。


### 9、说一下，什么是Oracle分区

分区的实质是把一张大表的数据按照某种规则使用多张子表来存储。

然后这多张子表使用统一的表名对外提供服务，子表实际对用户不可见。类似于在多张子表上建立一个视图，然后用户直接使用该视图来访问数据。


### 10、pctused and pctfree 表示什么含义有什么作用？

pctused与pctfree控制数据块是否出现在freelist中,pctfree控制数据块中保留用于update的空间,当数据块中的free space小于pctfree设置的空间时，该数据块从freelist中去掉,当块由于dml操作free space大于pct_used设置的空间时,该数据库块将被添加在freelist链表中。


### 11、给出在STAR SCHEMA中的两种表及它们分别含有的数据
### 12、怎样查看数据库引擎的报错
### 13、如何判断谁往表里增加了一条纪录？
### 14、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 15、解释GLOBAL_NAMES设为TRUE的用途？
### 16、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 17、数据库的三大范式是什么？
### 18、存储过程的操作 当它抛出异常的时候 你是如何解决的用了什么技术
### 19、Oracle中function和procedure的区别？
### 20、说下 怎样创建一个视图,视图的好处, 视图可以控制权限吗?
### 21、解释data block , extent 和 segment的区别(这里建议用英文术语)
### 22、如何转换init.ora到spfile?
### 23、oracle中存储过程，游标和函数的区别
### 24、SGA主要有那些部分，主要作用是什么?
### 25、在千万级的数据库查询中，如何提高效率？
### 26、truncate和delete区别：
### 27、FACT Table上需要建立何种索引？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
