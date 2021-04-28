# Oracle最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?

CALL_FORM：它启动一个新窗体并传递控件　　New_FORM：它终止当前窗体，并用指定的新窗体替换它　　OPEN_FORM：打开指定的新表单，而不更换或暂停父表单。


### 2、举出两个判断DDL改动的方法？

你可以使用 Logminer 或 Streams


### 3、pctused and pctfree 表示什么含义有什么作用？

pctused与pctfree控制数据块是否出现在freelist中,pctfree控制数据块中保留用于update的空间,当数据块中的free space小于pctfree设置的空间时，该数据块从freelist中去掉,当块由于dml操作free space大于pct_used设置的空间时,该数据库块将被添加在freelist链表中。


### 4、ORA-01555的应对方法？

具体的出错信息是snapshot too old within rollback seg , 通常可以通过增大rollback seg来解决问题。当然也需要察看一下具体造成错误的SQL文本


### 5、给出在STAR SCHEMA中的两种表及它们分别含有的数据

Fact tables 和dimension tables. fact table 包含大量的主要的信息而 dimension tables 存放对fact table 某些属性描述的

信息


### 6、数据库的三大范式是什么？

**1、** 第一范式：原子件，要求每一列的值不能再拆分了。

**2、** 第二范式： 一张表只描述一个实体（若列中有冗余数据，则不满足）

**3、** 第三范式： 所有列与主键值直接相关。


### 7、使用索引的理由

快速访问表中的data block


### 8、解释data block , extent 和 segment的区别(这里建议用英文术语)

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一个数据库对象拥有的所有extents被称为该对象的segment.


### 9、如何在不影响子表的前提下，重建一个母表

子表的外键强制实效，重建母表，激活外键


### 10、提及11g版本2中Oracle Forms Services中引入的新功能是什么?

在Oracle Forms Services中，包括的功能包括：　　与Oracle Access Manager集成　　计划表格运行预备　　增强的网络统计报告　　支持Unicode列　　guiMode配置参数　　表单指标代理　　支持图像项目和图标按钮中的URL　　Oracle真正的用户体验洞察


### 11、使用存储过程访问数据库比直接用SQL语句访问有何优点？
### 12、说下 oracle 中 dml、ddl、dcl 的使用有哪些
### 13、ORA-01555的应对方法？
### 14、解释$$ORACLE\_HOME和$$ORACLE_BASE的区别?
### 15、解释冷备份和热备份的不同点以及各自的优点
### 16、如何加密PL/SQL程序？
### 17、SGA主要有那些部分，主要作用是什么?
### 18、本地管理表空间和字典管理表空间的特点，ASSM有什么特点？
### 19、如何进行强制LOG SWITCH?
### 20、如何重构索引？
### 21、解释TABLE Function的用途
### 22、说下 oracle的锁又几种,定义分别是什么;
### 23、提到一个项目的“验证LOV”属性?提到lov和list项目有什么区别?
### 24、解释$$ORACLE_HOME和$$ORACLE_BASE的区别？
### 25、如何生成explain plan?
### 26、如何生成explain plan?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
