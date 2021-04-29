# Oracle最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、日志的作用是什么

记录数据库事务,最大限度地保证数据的一致性与安全性

重做日志文件：含对数据库所做的更改记录，这样万一出现故障可以启用数据恢复,一个数据库至少需要两个重做日志文件

归档日志文件：是重做日志文件的脱机副本，这些副本可能对于从介质失败中进行恢复很必要。


### 2、ORA-01555的应对方法？

具体的出错信息是snapshot too old within rollback seg , 通常可以通过增大rollback seg来解决问题。当然也需要察看一下具

体造成错误的SQL文本


### 3、解释FUNCTION,PROCEDURE和PACKAGE区别

function 和procedure是PL/SQL代码的集合，通常为了完成一个任务。procedure 不需要返回任何值而function将返回一个值在另一

方面，Package是为了完成一个商业功能的一组function和proceudre的集合


### 4、索引是用来干什么的？有那些约束建立索引？

**说下你怎么使用索引的？使用索引的好处和坏处？**

**1、** 索引用于对指定字段查询时，提升查询速度。

**2、** 主要有B树索引，位图索引，函数索引。

**3、** 对查询频率比较高的字段做索引，但一张表不要做太多索引。

**4、** 索引能提升查询效率，但它占用存储空间，且在更新数据时也会影响更新效率。


### 5、在千万级的数据库查询中，如何提高效率？

**分别从，从数据库设计方面，SQL优化语句方面说，物理优化方面说**

**1、** 从数据库设计方面说

**2、** 从SQL优化语句方面说

**3、** 物理优化方面说

**数据库设计方面**

**1、** 对查询进行优化，应尽量避免全表扫描，首先应考虑在 where 及 order by 涉及的列上建立索引。

**2、** 应尽量避免在 where 子句中对字段进行 null 值判断，否则将导致引擎放弃使用索引而进行全表扫描，如： select id from t where num is null 可以在 num 上设置默认值 0，确保表中 num 列没有 null 值，然后这样查询： select id from t where num=0

**3、** 并不是所有索引对查询都有效，SQL 是根据表中数据来进行查询优化的，当索引列有大量数据重复时，查询可能不会去利用索引，如一表中有字段 sex，male、female 几乎各一半，那么即使在 sex 上建了索引也对查询效率起不了作用。

**4、** 索引并不是越多越好，索引固然可以提高相应的 select 的效率，但同时也降低了 insert 及 update 的效率，因为 insert 或 update 时有可能会重建索引，所以怎样建索引需要慎重考虑，视具体情况而定。一个表的索引数最好不要超过 6 个，若太多则应考虑一些不常使用到的列上建的索引是否有必要。

**5、** 应尽可能的避免更新索引数据列，因为索引数据列的顺序就是表记录的物理存储顺序，一旦该列值改变将导致整个表记录的顺序的调整，会耗费相当大的资源。若应用系统需要频繁更新索引数据列，那么需要考虑是否应将该索引建为索引。

**6、** 尽量使用数字型字段，若只含数值信息的字段尽量不要设计为字符型，这会降低查询和连接的性能，并会增加存储开销。这是因为引擎在处理查询和连接时会逐个比较字符串中每一个字符，而对于数字型而言只需要比较一次就够了。

**7、** 尽可能的使用 varchar/nvarchar 代替 char/nchar ，因为首先变长字段存储空间小，可以节省存储空间，其次对于查询来说，在一个相对较小的字段内搜索效率显然要高些。

**8、** 尽量使用表变量来代替临时表。如果表变量包含大量数据，请注意索引非常有限（只有主键索引）。

**9、** 避免频繁创建和删除临时表，以减少系统表资源的消耗。

**10、** 临时表并不是不可使用，适当地使用它们可以使某些例程更有效，例如，当需要重复引用大型表或常用表中的某个数据集时。但是，对于一次性事件，最好使用导出表。

**11、** 在新建临时表时，如果一次性插入数据量很大，那么可以使用 select into 代替 create table，避免造成大量 log ，以提高速度；如果数据量不大，为了缓和系统表的资源，应先 create table，然后 insert。

**12、** 如果使用到了临时表，在存储过程的最后务必将所有的临时表显式删除，先 `truncate table ，然后 drop table` ，这样可以避免系统表的较长时间锁定。

**从SQL语句方面**

**1、** 应尽量避免在 where 子句中使用!=或<>操作符，否则将引擎放弃使用索引而进行全表扫描。

**2、** 应尽量避免在 where 子句中使用 or 来连接条件，否则将导致引擎放弃使用索引而进行全表扫描，如：select id from t where num=10 or num=20 可以这样查询： select id from t where num=10 union all select id from t where num=20

**3、** in 和 not in 也要慎用，否则会导致全表扫描，如： select id from t where num in(1,2,3) 对于连续的数值，能用 between 就不要用 in 了： select id from t where num between 1 and 3

**4、** 下面的查询也将导致全表扫描： select id from t where name like ‘%abc%’

**5、** 如果在 where 子句中使用参数，也会导致全表扫描。因为 SQL 只有在运行时才会解析局部变量，但优化程序不能将访问计划的选择推迟到运行时；它必须在编译时进行选择。然而，如果在编译时建立访问计划，变量的值还是未知的，因而无法作为索引选择的输入项。如下面语句将进行全表扫描： select id from t where num=[@num ](/num) 可以改为强制查询使用索引： select id from t with(index(索引名)) where num=[@num ](/num)

**6、** 应尽量避免在 where 子句中对字段进行表达式操作，这将导致引擎放弃使用索引而进行全表扫描。

如：select id from t where num/2=100 应改为: select id from t where num=100*2

**7、** 应尽量避免在where子句中对字段进行函数操作，这将导致引擎放弃使用索引而进行全表扫描。

如：select id from t where substring(name,1,3)= ‘ abc ’ – name 以 abc 开 头 的 id

select id from t where datediff(day,createdate,’2005-11-30′)=0–‘2005-11-30’生成的 id

应改为: select id from t where name like ‘abc%’，

select id from t where createdate>='2005-11-30' and createdate<'2005-12-1'.

不要在 where 子句中的“=”左边进行函数、算术运算或其他表达式运算，否则系统将可能无法正确使用索引。

**8、** 不要写一些没有意义的查询，

如需要生成一个空表结构： select col1,col2 into #t from t where 1=0 这类代码不会返回任何结果集，但是会消耗系统资源的，应改成这样： create table #t(…)

**9、** 很多时候用 exists 代替 in 是一个好的选择：

select num from a where num in(select num from b)

用下面的语句替换： select num from a where exists(select 1 from b where num=a.num)

**10、** 任何地方都不要使用 select _ from t ，用具体的字段列表代替“_”，不要返回用不到的任何字段。

**11、** 尽量避免使用游标，因为游标的效率较差，如果游标操作的数据超过 1 万行，那么就应该考虑改写。

**12、** 尽量避免向客户端返回大数据量，若数据量过大，应该考虑相应需求是否合理。

**13、** 尽量避免大事务操作，提高系统并发能力。

**物理优化方面说**

**1、** Oracle的运行环境（网络，硬件等）

**2、** 使用合适的优化器

**3、** 合理配置oracle实例参数

**4、** 建立合适的索引（减少IO）

**5、** 将索引数据和表数据分开在不同的表空间上（降低IO冲突）

**6、** 建立表分区，将数据分别存储在不同的分区上（以空间换取时间，减少IO）


### 6、说下如何使用Oracle的游标？

**1、** oracle中的游标分为显示游标和隐式游标

**2、** 显示游标是用cursor...is命令定义的游标，它可以对查询语句(select)返回的多条记录进行处理；隐式游标是在执行插入 (insert)、删除(delete)、修改(update)和返回单条记录的查询(select)语句时由PL/SQL自动定义的。

**3、** 显式游标的操作：打开游标、操作游标、关闭游标；PL/SQL隐式地打开SQL游标，并在它内部处理SQL语句，然后关闭它


### 7、解释materialized views的作用

Materialized views 用于减少那些汇总，集合和分组的信息的集合数量。它们通常适合于数据仓库和DSS系统。


### 8、如何进行强制LOG SWITCH?
### 9、Coalescing做了什么？
### 10、ORA-01555的应对方法?
### 11、什么是绑定变量?
### 12、给出两个检查表结构的方法
### 13、可以从表单执行动态SQL吗?
### 14、简单描述table / segment / extent / block之间的关系？
### 15、如何搜集表的各种状态数据？
### 16、解释什么是Oracle Forms?
### 17、解释什么是死锁，如何解决Oracle中的死锁？
### 18、FACT Table上需要建立何种索引?
### 19、TEMPORARY tablespace和PERMANENT tablespace 的区别是？
### 20、数据库的三大范式是什么？
### 21、如何在不影响子表的前提下，重建一个母表
### 22、解释CALL_FORM，NEW_FORM和OPEN_FORM之间有什么区别?
### 23、说一下，什么是Oracle分区
### 24、描述tablespace和datafile之间的关系
### 25、Oracle 分区在什么情况下使用
### 26、说下 Oracle中有哪几种文件？
### 27、回滚段的作用是什么




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
