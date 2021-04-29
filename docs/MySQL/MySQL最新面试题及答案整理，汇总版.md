# MySQL最新面试题及答案整理，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是SQL？

结构化查询语言(Structured Query Language)简称SQL，是一种数据库查询语言。

**作用：**

用于存取数据、查询、更新和管理关系数据库系统。


### 2、你怎么看到为表格定义的所有索引？

索引是通过以下方式为表格定义的：

`SHOW INDEX FROM <tablename>;`


### 3、什么是游标？

游标是系统为用户开设的一个数据缓冲区，存放SQL语句的执行结果，每个游标区都有一个名字。用户可以通过游标逐一获取记录并赋给主变量，交由主语言进一步处理。


### 4、NULL是什么意思

NULL这个值表示UNKNOWN(未知):它不表示“”(空字符串)。对NULL这个值的任何比较都会生产一个NULL值。您不能把任何值与一个 NULL值进行比较，并在逻辑上希望获得一个答案。

使用IS NULL来进行NULL判断


### 5、谈谈MySQL的Explain

Explain 执行计划包含字段信息如下：分别是 id、select_type、table、partitions、type、possible_keys、key、key_len、ref、rows、filtered、Extra 等12个字段。

我们重点关注的是type，它的属性排序如下：

```
system  > const > eq_ref > ref  > ref_or_null >
index_merge > unique_subquery > index_subquery > 
range > index > ALL
```


### 6、为表中得字段选择合适得数据类型

字段类型优先级: 整形>date,time>enum,char>varchar>blob,text

优先考虑数字类型，其次是日期或者二进制类型，最后是字符串类型，同级别得数据类型，应该优先选择占用空间小的数据类型


### 7、优化数据库的方法

**1、** 选取最适用的字段属性，尽可能减少定义字段宽度，尽量把字段设置NOTNULL，例如’省份’、’性别’最好适用ENUM

**2、** 使用连接(JOIN)来代替子查询

**3、** 适用联合(UNION)来代替手动创建的临时表

**4、** 事务处理

**5、** 锁定表、优化事务处理

**6、** 适用外键，优化锁定表

**7、** 建立索引

**8、** 优化查询语句


### 8、MySQL中TEXT数据类型的最大长度

**1、** TINYTEXT：256 bytes

**2、** TEXT：65,535 bytes(64kb)

**3、** MEDIUMTEXT：16,777,215 bytes(16MB)

**4、** LONGTEXT：4,294,967,295 bytes(4GB)


### 9、什么是数据库事务？

事务是一个不可分割的数据库操作序列，也是数据库并发控制的基本单位，其执行的结果必须使数据库从一种一致性状态变到另一种一致性状态。事务是逻辑上的一组操作，要么都执行，要么都不执行。

**事务最经典也经常被拿出来说例子就是转账了**

假如小明要给小红转账1000元，这个转账会涉及到两个关键操作就是：将小明的余额减少1000元，将小红的余额增加1000元。万一在这两个操作之间突然出现错误比如银行系统崩溃，导致小明余额减少而小红的余额没有增加，这样就不对了。事务就是保证这两个关键操作要么都成功，要么都要失败。


### 10、LIKE声明中的％和_是什么意思？

％对应于0个或更多字符，_只是LIKE语句中的一个字符。


### 11、说说对SQL语句优化有哪些方法？（选择几条）
### 12、索引不适合哪些场景
### 13、创建索引的原则
### 14、MySQL 索引使用有哪些注意事项呢？
### 15、索引有哪些优缺点？
### 16、数据库中间件了解过吗，sharding jdbc，mycat？
### 17、实践中如何优化MySQL
### 18、主键、外键和索引的区别？
### 19、SQL的生命周期？
### 20、MySQL 分页
### 21、MySQL里记录货币用什么字段类型好
### 22、一条SQL语句在MySQL中如何执行的？
### 23、超键、候选键、主键、外键分别是什么？
### 24、列对比运算符是什么？
### 25、MySQL如何优化DISTINCT？
### 26、数据库存储日期格式时，如何考虑时区转换问题？
### 27、视图的缺点
### 28、MySQL有关权限的表都有哪几个
### 29、InnoDB引擎的4大特性，了解过吗
### 30、列值为NULL时，查询是否会用到索引？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
