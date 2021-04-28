# MongoDB最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、在MongoDB中创建模式时，需要考虑哪些要点？

**需要考虑的要点是**

**1、** 根据用户要求设计架构

**2、** 如果将它们一起使用，则将它们组合到一个文档中。否则，将它们分开

**3、** 在写入时进行连接，而不是在读取时进行连接

**4、** 对于最常见的用例，请优化您的架构

**5、** 在架构中进行复杂的汇总


### 2、提及Objecld由什么组成？

**Objectld由以下组成**

**1、** 时间戳记

**2、** 客户端机器ID

**3、** 客户端进程ID

**4、** 3字节递增计数器


### 3、解释什么是MongoDB中的GridFS？

为了存储和检索大文件，例如图像，视频文件和音频文件，使用GridFS。默认情况下，它使用两个文件fs.files和fs.chunks来存储文件的元数据和数据块。


### 4、MongoDB相似的产品有哪些？

Cassandra，CouchDB，Redis，Riak，Hbase



### 5、用什么方法可以格式化输出结果

db.collectionName.find().pretty()


### 6、MongoDB的优势有哪些

1. 面向文档的存储：以 JSON 格式的文档保存数据。
2. 任何属性都可以建立索引。
3. 复制以及高可扩展性。
4. 自动分片。
5. 丰富的查询功能。
6. 快速的即时更新。


### 7、什么是master或primary？

当前备份集群负责所有的写入操作的主要节点，在集群中，当主节点（master）失效，另一个成员会变为master


### 8、使用mongodb的优点

**1、** 面向文件

**2、** 高性能

**3、** 高可用

**4、** 易扩展

**5、** 可分片

**6、** 对数据存储友好


### 9、分片(sharding)和复制(replication)是怎样工作的?

每一个分片(shard)是一个分区数据的逻辑集合.分片可能由单一服务器或者集群组成,我们推荐为每一个分片(shard)使用集群.


### 10、分析器在MongoDB中的作用是什么?

分析器就是explain 显示每次操作性能特点的数据库分析器。通过分析器可能查找比预期慢的操作


### 11、解释一下您可以将旧文件移动到moveChunk目录中吗？
### 12、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？
### 13、31如何理解MongoDB中的GridFS机制，MongoDB为何使用GridFS来存储文件？
### 14、什么是聚合
### 15、如何删除文档
### 16、数据在什么时候才会扩展到多个分片（shard）里？
### 17、为什么要在MongoDB中使用分析器
### 18、在哪些场景使用MongoDB
### 19、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?
### 20、我怎么查看 Mongo 正在使用的链接？
### 21、当我试图更新一个正在被迁移的块（chunk）上的文档时会发生什么？
### 22、monogodb 中的分片什么意思
### 23、ObjectID"有哪些部分组成
### 24、分片（sharding）和复制（replication）是怎样工作的？
### 25、什么是非关系型数据库
### 26、如何使用"AND"或"OR"条件循环查询集合中的文档
### 27、MongoDB支持存储过程吗？如果支持的话，怎么用？
### 28、如何添加索引
### 29、在MongoDB中什么是副本集（避免单点故障）




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
