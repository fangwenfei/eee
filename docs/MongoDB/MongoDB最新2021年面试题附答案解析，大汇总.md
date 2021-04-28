# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、查看Mongos使用的连接？

要查看Mongos使用的连接，请使用db_adminCommand（“ connPoolStats”）；


### 2、更新操作立刻fsync到磁盘？

一般磁盘的写操作都是延迟执行的


### 3、如何执行事务/加锁?

mongodb没有使用传统的锁或者复杂的带回滚的事务,因为它设计的宗旨是轻量,快速以及可预计的高性能.可以把它类比成MySQL mylsam的自动提交模式.通过精简对事务的支持,性能得到了提升,特别是在一个可能会穿过多个服务器的系统里.


### 4、名字空间（namespace）是什么？

在collection中，数据库名+集合名叫做名字空间。也就是一个集合的完整名


### 5、为什么要在MongoDB中用"Regular Expression"数据类型

"Regular Expression"类型用于在文档中存储正则表达式


### 6、提到用于查看Mongo的命令语法正在使用链接吗？

用于查看mongo的命令语法使用的链接是db._adminCommand（“ connPoolStats。”）。


### 7、什么是文档(记录)

文档由一组key value组成。文档是动态模式,这意味着同一集合里的文档不需要有相同的字段和结构。在关系型

数据库中table中的每一条记录相当于MongoDB中的一个文


### 8、为什么用MOngoDB？

1. 架构简单
2. 没有复杂的连接
3. 深度查询能力,MongoDB支持动态查询。
4. 容易调试
5. 容易扩展
6. 不需要转化/映射应用对象到数据库对象
7. 使用内部内存作为存储工作区,以便更快的存取数据。


### 9、更新数据

db.collectionName.update({key:value},{$set:{newkey:newValue}})


### 10、如何添加索引

使用db.collection.createIndex()在集合中创建一个索引


### 11、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？
### 12、在MongoDB中创建模式时，需要考虑哪些要点？
### 13、MongoDB中的命名空间是什么意思?
### 14、为什么要在MongoDB中用"Code"数据类型
### 15、.MongoDB支持主键外键关系吗
### 16、31如何理解MongoDB中的GridFS机制，MongoDB为何使用GridFS来存储文件？
### 17、什么是聚合
### 18、如果用户移除对象的属性，该属性是否从存储层中删除？
### 19、如何删除文档
### 20、MongoDB支持哪些数据类型
### 21、MongoDB支持存储过程吗？如果支持的话，怎么用？
### 22、分片（sharding）和复制（replication）是怎样工作的？
### 23、为什么MongoDB的数据文件很大？
### 24、MongoDB相似的产品有哪些？
### 25、能否使用日志特征进行安全备份？
### 26、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?
### 27、为什么在MongoDB中使用"Object ID"数据类型
### 28、解释一下您可以将旧文件移动到moveChunk目录中吗？
### 29、可以把movechunk目录里的旧文件删除吗?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
