# MongoDB最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、用什么方法可以格式化输出结果

db.collectionName.find().pretty()


### 2、使用mongodb的优点

**1、** 面向文件

**2、** 高性能

**3、** 高可用

**4、** 易扩展

**5、** 可分片

**6、** 对数据存储友好


### 3、提及插入文档的命令语法是什么？

用于插入文档的命令语法是database.collection.insert（文档）。


### 4、数据在什么时候才会扩展到多个分片(shard)里?

mongodb 分片是基于区域(range)的.所以一个集合(collection)中的所有的对象都被存放到一个块(chunk)中.只有当存在多余一个块的时候,才会有多个分片获取数据的选项.现在,每个默认块的大小是 64mb,所以你需要至少 64 mb 空间才可以实施一个迁移.


### 5、分析器在MongoDB中的作用是什么?

分析器就是explain 显示每次操作性能特点的数据库分析器。通过分析器可能查找比预期慢的操作


### 6、在MongoDB中什么是副本集（避免单点故障）

在MongoDB中副本集由一组MongoDB实例组成，包括一个主节点多个次节点，MongoDB客户端的所有数据都

写入主节点(Primary),副节点从主节点同步写入数据，以保持所有复制集内存储相同的数据，提高数据可用性。


### 7、如何删除文档

db.collectionName.remove({key:value})


### 8、更新操作立刻fsync到磁盘?

不会,磁盘写操作默认是延迟执行的.写操作可能在两三秒(默认在60秒内)后到达磁盘.例如,如果一秒内数据库收到一千个对一个对象递增的操作,仅刷新磁盘一次.


### 9、MongoDB相似的产品有哪些？

Cassandra，CouchDB，Redis，Riak，Hbase



### 10、什么是master或primary?

它是当前备份集群(replica set)中负责处理所有写入操作的主要节点/成员.在一个备份集群中,当失效备援(failover)事件发生时,一个另外的成员会变成primary.


### 11、提到用于查看Mongo的命令语法正在使用链接吗？
### 12、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？
### 13、提到如何检查函数的源代码？
### 14、在哪些场景使用MongoDB
### 15、什么是文档(记录)
### 16、MongoDB中的命名空间是什么意思?
### 17、mongodb的结构介绍
### 18、你怎么比较MongoDB、CouchDB及CouchBase?
### 19、什么是MongoDB
### 20、ObjectID"有哪些部分组成
### 21、什么是集合(表)
### 22、数据库的整体结构
### 23、nosql数据库有哪些
### 24、我怎么查看 Mongo 正在使用的链接？
### 25、monogodb 中的分片什么意思
### 26、更新数据
### 27、什么是NoSQL数据库？NoSQL和RDBMS有什么区别？在哪些情况下使用和不使用NoSQL数据库？
### 28、如何查询集合中的文档
### 29、提及Objecld由什么组成？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
