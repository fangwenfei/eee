# MySQL高级面试题，中级面试题，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、创建索引的三种方式

**在执行CREATE TABLE时创建索引**

```
CREATE TABLE `employee` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `age` int(11) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  `sex` int(1) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `idx_name` (`name`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
```

**使用ALTER TABLE命令添加索引**

```
ALTER TABLE table_name ADD INDEX index_name (column);
```

**使用CREATE INDEX命令创建**

```
CREATE INDEX index_name ON table_name (column);
```


### 2、什么是通用SQL函数？

**1、** CONCAT(A, B) – 连接两个字符串值以创建单个字符串输出。通常用于将两个或多个字段合并为一个字段。

**2、** FORMAT(X, D)- 格式化数字X到D有效数字。

**3、** CURRDATE(), CURRTIME()- 返回当前日期或时间。

**4、** NOW（） – 将当前日期和时间作为一个值返回。

**5、** MONTH（），DAY（），YEAR（），WEEK（），WEEKDAY（） – 从日期值中提取给定数据。

**6、** HOUR（），MINUTE（），SECOND（） – 从时间值中提取给定数据。

**7、** DATEDIFF（A，B） – 确定两个日期之间的差异，通常用于计算年龄

**8、** SUBTIMES（A，B） – 确定两次之间的差异。

**9、** FROMDAYS（INT） – 将整数天数转换为日期值。


### 3、MySQL中有哪几种锁，列举一下？


**如果按锁粒度划分，有以下3种：**

**1、** 表锁： 开销小，加锁快；锁定力度大，发生锁冲突概率高，并发度最低;不会出现死锁。

**2、** 行锁： 开销大，加锁慢；会出现死锁；锁定粒度小，发生锁冲突的概率低，并发度高。

**3、** 页锁： 开销和加锁速度介于表锁和行锁之间；会出现死锁；锁定粒度介于表锁和行锁之间，并发度一般


### 4、数据表损坏的修复方式有哪些？

**使用 myisamchk 来修复，具体步骤：**

**1、** 修复前将MySQL服务停止。

**2、** 打开命令行方式，然后进入到MySQL的/bin目录。

**3、** 执行myisamchk –recover 数据库所在路径/*.MYI

使用repair table 或者 OPTIMIZE table命令来修复，REPAIR TABLE table_name 修复表 OPTIMIZE TABLE table_name 优化表 REPAIR TABLE 用于修复被破坏的表。 OPTIMIZE TABLE 用于回收闲置的数据库空间，当表上的数据行被删除时，所占据的磁盘空间并没有立即被回收，使用了OPTIMIZE TABLE命令后这些空间将被回收，并且对磁盘上的数据行进行重排（注意：是磁盘上，而非数据库）`




### 5、MySQL里记录货币用什么字段类型好

NUMERIC和DECIMAL类型被MySQL实现为同样的类型，这在SQL92标准允许。他们被用于保存值，该值的准确精度是极其重要的值，例如与金钱有关的数据。当声明一个类是这些类型之一时，精度和规模的能被(并且通常是)指定。

**例如：**

salary DECIMAL(9,2)

在这个例子中，9(precision)代表将被用于存储值的总的小数位数，而2(scale)代表将被用于存储小数点后的位数。

因此，在这种情况下，能被存储在salary列中的值的范围是从-9999999.99到9999999.99。


### 6、SQL的生命周期？

**1、** 应用服务器与数据库服务器建立一个连接

**2、** 数据库进程拿到请求sql

**3、** 解析并生成执行计划，执行

**4、** 读取数据到内存并进行逻辑处理

**5、** 通过步骤一的连接，发送结果到客户端

**6、** 关掉连接，释放资源

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/049/50/99_8.png#alt=99%5C_8.png)


### 7、索引的基本原理

索引用来快速地寻找那些具有特定值的记录。如果没有索引，一般来说执行查询时遍历整张表。

**索引的原理很简单，就是把无序的数据变成有序的查询**

**1、** 把创建了索引的列的内容进行排序

**2、** 对排序结果生成倒排表

**3、** 在倒排表内容上拼上数据地址链

**4、** 在查询的时候，先拿到倒排表内容，再取出数据地址链，从而拿到具体数据


### 8、日常工作中你是怎么优化SQL的？

可以从这几个维度回答这个问题：

**1、** 加索引

**2、** 避免返回不必要的数据

**3、** 适当分批量进行

**4、** 优化sql结构

**5、** 分库分表

**6、** 读写分离


### 9、索引设计的原则？

**1、** 适合索引的列是出现在where子句中的列，或者连接子句中指定的列

**2、** 基数较小的类，索引效果较差，没有必要在此列建立索引

**3、** 使用短索引，如果对长字符串列进行索引，应该指定一个前缀长度，这样能够节省大量索引空间

**4、** 不要过度索引。索引需要额外的磁盘空间，并降低写操作的性能。在修改表内容的时候，索引会进行更新甚至重构，索引列越多，这个时间就会越长。所以只保持需要的索引有利于查询即可。


### 10、谈谈MySQL的Explain

Explain 执行计划包含字段信息如下：分别是 id、select_type、table、partitions、type、possible_keys、key、key_len、ref、rows、filtered、Extra 等12个字段。

我们重点关注的是type，它的属性排序如下：

```
system  > const > eq_ref > ref  > ref_or_null >
index_merge > unique_subquery > index_subquery > 
range > index > ALL
```


### 11、百万级别或以上的数据如何删除
### 12、什么是死锁？怎么解决？
### 13、谈谈六种关联查询，使用场景。
### 14、使用悲观锁
### 15、为什么要使用数据库
### 16、乐观锁：
### 17、SQL的执行顺序
### 18、你是否做过主从一致性校验，如果有，怎么做的，如果没有，你打算怎么做？
### 19、数据库三大范式是什么
### 20、对于关系型数据库而言，索引是相当重要的概念，请回答有关索引的几个问题：
### 21、索引算法有哪些？
### 22、从锁的类别上分MySQL都有哪些锁呢？
### 23、MyISAM Static和MyISAM Dynamic有什么区别？
### 24、数据库中的事务是什么?
### 25、MySQL的复制原理以及流程
### 26、MySQL 分页
### 27、MySQL中InnoDB引擎的行锁是怎么实现的？
### 28、字段为什么要求定义为not null？
### 29、一个6亿的表a，一个3亿的表b，通过外间tid关联，你如何最快的查询出满足条件的第50000到第50200中的这200条数据记录。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
