# MongoDB最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、你怎么比较MongoDB、CouchDB及CouchBase?

不知道


### 2、如何查询集合中的文档

db.collectionName.find({key:value})


### 3、要进行安全备份，可以使用MongoDB中的功能是什么？

日记功能是MongoDB中的功能，可用于执行安全备份。


### 4、解释什么是副本集？

副本集是一组托管相同数据集的mongo实例。在副本集中，一个节点是主节点，另一个是辅助节点。从主节点到辅助节点，所有数据都会复制。


### 5、什么是MongoDB

MongoDB是一个文档数据库，提供好的性能，领先的非关系型数据库。采用BSON存储文档数据。

BSON（）是一种类json的一种二进制形式的存储格式，简称Binary JSON.

相对于json多了date类型和二进制数组。


### 6、用什么方法可以格式化输出结果

db.collectionName.find().pretty()


### 7、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？

命令语法Db.isMaster（）会告诉您是否在主服务器上。MongoDB仅允许一个主服务器，而ouchDB允许多个主服务器。


### 8、分片(sharding)和复制(replication)是怎样工作的?

每一个分片(shard)是一个分区数据的逻辑集合.分片可能由单一服务器或者集群组成,我们推荐为每一个分片(shard)使用集群.


### 9、提及Objecld由什么组成？

**Objectld由以下组成**

**1、** 时间戳记

**2、** 客户端机器ID

**3、** 客户端进程ID

**4、** 3字节递增计数器


### 10、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?

不需要,移动操作是一致(consistent)并且是确定性的(deterministic);一次失败后,移动操作会不断重试;当完成后,数据只会出现在新的分片里(shard).


### 11、如何使用"AND"或"OR"条件循环查询集合中的文档
### 12、分析器在MongoDB中的作用是什么?
### 13、ObjectID"有哪些部分组成
### 14、getLastError的作用
### 15、复制在MongoDB中如何工作？
### 16、mongodb是否支持事务
### 17、数据库的整体结构
### 18、mongodb的结构介绍
### 19、在MongoDB中创建集合并将其删除的语法是什么？
### 20、如果在一个分片(shard)停止或者很慢的时候,我发起一个查询会怎样?
### 21、什么是master或primary?
### 22、什么是集合(表)
### 23、MongoDB的优势有哪些
### 24、数据在什么时候才会扩展到多个分片(shard)里?
### 25、MongoDB在A:{B,C}上建立索引，查询A:{B,C}和A:{C,B}都会使用索引吗？
### 26、数据在什么时候才会扩展到多个分片（shard）里？
### 27、在哪些场景使用MongoDB
### 28、nosql数据库有哪些
### 29、提到在MongoDB中使用索引的基本语法是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
