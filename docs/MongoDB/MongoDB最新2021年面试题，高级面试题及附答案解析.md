# MongoDB最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是MongoDB

MongoDB是一个文档数据库，提供好的性能，领先的非关系型数据库。采用BSON存储文档数据。

BSON（）是一种类json的一种二进制形式的存储格式，简称Binary JSON.

相对于json多了date类型和二进制数组。


### 2、用什么方法可以格式化输出结果

db.collectionName.find().pretty()


### 3、什么是聚合

聚合操作能够处理数据记录并返回计算结果。聚合操作能将多个文档中的值组合起来，对成组数据执行各种操作，返回单一的结果。它相当于 SQL 中的 count(*) 组合 group by。对于 MongoDB 中的聚合操作，应该使用`aggregate()`方法。

db.COLLECTION_NAME.aggregate(AGGREGATE_OPERATION)


### 4、你怎么比较MongoDB、CouchDB及CouchBase?

不知道


### 5、MongoDB相似的产品有哪些？

Cassandra，CouchDB，Redis，Riak，Hbase



### 6、如果用户移除对象的属性,该属性是否从存储层中删除?

是的,用户移除属性然后对象会重新保存(re-save()).


### 7、复制在MongoDB中如何工作？

在多台服务器之间，同步数据的过程称为复制。它通过不同数据库服务器上的多个数据副本提供冗余并提高数据可用性。复制有助于防止数据库丢失单个服务器。


### 8、启用备份故障恢复需要多久?

从备份数据库声明主数据库宕机到选出一个备份数据库作为新的主数据库将花费10到30秒时间.这期间在主数据库上的操作将会失败–包括写入和强一致性读取(strong consistent read)操作.然而,你还能在第二数据库上执行最终一致性查询(eventually consistent query)(在slaveok模式下),即使在这段时间里.


### 9、如何执行事务/加锁?

mongodb没有使用传统的锁或者复杂的带回滚的事务,因为它设计的宗旨是轻量,快速以及可预计的高性能.可以把它类比成MySQL mylsam的自动提交模式.通过精简对事务的支持,性能得到了提升,特别是在一个可能会穿过多个服务器的系统里.


### 10、在MongoDB中创建集合并将其删除的语法是什么？

**1、** 在MongoDB中创建集合的语法是db.createCollection（name，options）

**2、** 在MongoDB中删除收集的语法是db.collection.drop（）


### 11、mongodb的结构介绍
### 12、为什么要在MongoDB中使用分析器
### 13、为什么要在MongoDB中用"Regular Expression"数据类型
### 14、在MongoDB中创建模式时，需要考虑哪些要点？
### 15、MongoDB中的命名空间是什么意思?
### 16、更新操作立刻fsync到磁盘?
### 17、为什么要在MongoDB中用"Code"数据类型
### 18、31如何理解MongoDB中的GridFS机制，MongoDB为何使用GridFS来存储文件？
### 19、数据在什么时候才会扩展到多个分片（shard）里？
### 20、在哪些场景使用MongoDB
### 21、名字空间（namespace）是什么？
### 22、如何使用"AND"或"OR"条件循环查询集合中的文档
### 23、允许空值null吗?
### 24、MySQL与mongodb本质之间最基本的差别是什么
### 25、MongoDB的优势有哪些
### 26、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？
### 27、MongoDB中的分片是什么？
### 28、提及插入文档的命令语法是什么？
### 29、什么是master或primary?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
