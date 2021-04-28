# Oracle最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、给出两个检查表结构的方法

**1、** DESCRIBE命令

**2、**  DBMS_METADATA.GET_DDL 包


### 2、解释冷备份和热备份的不同点以及各自的优点

热备份针对归档模式的数据库，在数据库仍旧处于工作状态时进行备份。而冷备份指在数据库关闭后，进行备份，适用于所有模式的数据库。热备份的优 点在于当备份时，数据库仍旧可以被使用并且可以将数据库恢复到任意一个时间点。冷备份的优点在于它的备份和恢复操作相当简单，并且由于冷备份的数据库可以 工作在非归档模式下,数据库性能会比归档模式稍好。（因为不必将archive log写入硬盘）


### 3、存储过程 、函数 、游标 在项目中怎么用的：

**存储过程：**

**2、** 能够批量执行的一组SQL语句，且容易控制事务。但没有返回值，可以通过设置in out|out类型的参数返回结果

**3、** 存储过程可以没有参数,不需要返回值

**函数：**

与存储过程相似，函数可以没有参数,但是一定需要一个返回值

**游标：**

游标类似指针，游标可以执行多个不相关的操作.如果希望当产生了结果集后,对结果集中的数据进行多 种不相关的数据操作


### 4、触发器的作用有哪些？

**1、** 触发器可通过数据库中的相关表实现级联更改；通过级联引用完整性约束可以更有效地执行这些更改。

**2、** 触发器可以强制比用 CHECK 约束定义的约束更为复杂的约束。与 CHECK 约束不同，触发器可以引用其它表中的列。例如，触发器可以使用另一个表中的 SELECT 比较插入或更新的数据，以及执行其它操作，如修改数据或显示用户定义错误信息。

**3、** 触发器还可以强制执行业务规则

**4、** 触发器也可以评估数据修改前后的表状态，并根据其差异采取对策。


### 5、给出两个检查表结构的方法

1.DESCRIBE命令

2.DBMS_METADATA.GET_DDL 包


### 6、给出两种相关约束?

主键和外键


### 7、解释data block , extent 和 segment的区别（这里建议用英文术语）

data block是数据库中最小的逻辑存储单元。当数据库的对象需要更多的物理存储空间时，连续的data block就组成了extent . 一个数据库对象拥有的所有extents被称为该对象的segment.


### 8、FACT Table上需要建立何种索引?

位图索引 (bitmap index)


### 9、比较truncate和delete 命令

两者都可以用来删除表中所有的记录。区别在于：truncate是DDL操作，它移动HWK，不需要rollback segment .而Delete是DML操作, 需要rollback segment 且花费较长时间.


### 10、描述什么是 redo logs

Redo Logs 是用于存放数据库数据改动状况的物理和逻辑结构。可以用来修复数据库.


### 11、解释冷备份和热备份的不同点以及各自的优点
### 12、解释归档和非归档模式之间的不同和它们各自的优缺点
### 13、提及11g版本2中Oracle Forms Services中引入的新功能是什么?
### 14、Oracle的游标在存储过程里是放在begin与end的里面还是外面？
### 15、解释data block , extent 和 segment的区别（这里建议用英文术语）
### 16、解释TABLE Function的用途
### 17、简单描述table / segment / extent / block之间的关系？
### 18、解释什么是Partitioning（分区）以及它的优点。
### 19、如何转换init.ora到spfile?
### 20、提示窗体中触发的顺序是什么?
### 21、Audit trace 存放在哪个oracle目录结构中?
### 22、如何增加buffer cache的命中率?
### 23、可以从表单执行动态SQL吗?
### 24、SGA主要有那些部分，主要作用是什么?
### 25、如何搜集表的各种状态数据？
### 26、delete 与Truncate区别？
### 27、在千万级的数据库查询中，如何提高效率？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
