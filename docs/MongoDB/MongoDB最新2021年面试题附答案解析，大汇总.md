# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、分片(sharding)和复制(replication)是怎样工作的?

每一个分片(shard)是一个分区数据的逻辑集合.分片可能由单一服务器或者集群组成,我们推荐为每一个分片(shard)使用集群.


### 2、如何执行事务/加锁?

mongodb没有使用传统的锁或者复杂的带回滚的事务,因为它设计的宗旨是轻量,快速以及可预计的高性能.可以把它类比成MySQL mylsam的自动提交模式.通过精简对事务的支持,性能得到了提升,特别是在一个可能会穿过多个服务器的系统里.


### 3、提到在MongoDB中使用索引的基本语法是什么？

MongoDB中使用的基本语法是> db.COLLECTION_NAME.ensureIndex（{KEY：1}）。在这里，键是文档中存在的COLUMN（或KEY：VALUE对）的名称。


### 4、为什么mongodb的数据文件那么庞大

mongodb会积极的预分配预留空间，防止文件系统碎片


### 5、如何添加索引

使用db.collection.createIndex()在集合中创建一个索引


### 6、数据在什么时候才会扩展到多个分片（shard）里？

mongodb分片是基于区域的，所以一个集合的所有对象都放置在同一个块中，只有当存在多余一个块的时候，才会有多个分片获取数据的选项


### 7、在MongoDB中如何排序

并使用 1 和 -1 来指定排序方式，其中 1 表示升序，而 -1 表示降序。

db.connectionName.find({key:value}).sort({columnName:1})


### 8、为什么用MOngoDB？

1. 架构简单
2. 没有复杂的连接
3. 深度查询能力,MongoDB支持动态查询。
4. 容易调试
5. 容易扩展
6. 不需要转化/映射应用对象到数据库对象
7. 使用内部内存作为存储工作区,以便更快的存取数据。


### 9、为什么MongoDB的数据文件很大？

MongoDB采用的预分配空间的方式来防止文件碎片。


### 10、要进行安全备份，可以使用MongoDB中的功能是什么？

日记功能是MongoDB中的功能，可用于执行安全备份。


### 11、如果在一个分片(shard)停止或者很慢的时候,我发起一个查询会怎样?
### 12、MongoDB在A:{B,C}上建立索引，查询A:{B,C}和A:{C,B}都会使用索引吗？
### 13、为什么要在MongoDB中用"Code"数据类型
### 14、能否使用日志特征进行安全备份？
### 15、MongoDB中的分片是什么？
### 16、复制在MongoDB中如何工作？
### 17、什么是master或primary？
### 18、什么是非关系型数据库
### 19、getLastError的作用
### 20、mongodb是否支持事务
### 21、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?
### 22、查看Mongos使用的连接？
### 23、如果用户移除对象的属性，该属性是否从存储层中删除？
### 24、可以把movechunk目录里的旧文件删除吗?
### 25、启用备份故障恢复需要多久?
### 26、如何使用"AND"或"OR"条件循环查询集合中的文档
### 27、为什么在MongoDB中使用"Object ID"数据类型
### 28、在MongoDb中什么是索引
### 29、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
