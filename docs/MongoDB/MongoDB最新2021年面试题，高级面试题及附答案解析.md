# MongoDB最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MongoDB支持哪些数据类型

1. String
2. Integer
3. Double
4. Boolean
5. Object
6. Object ID
7. Arrays
8. Min/Max Keys
9. Datetime
10. Code
11. Regular Expression等


### 2、数据在什么时候才会扩展到多个分片（shard）里？

mongodb分片是基于区域的，所以一个集合的所有对象都放置在同一个块中，只有当存在多余一个块的时候，才会有多个分片获取数据的选项


### 3、提及插入文档的命令语法是什么？

用于插入文档的命令语法是database.collection.insert（文档）。


### 4、MySQL与mongodb本质之间最基本的差别是什么

差别在多方面  例如 数据的表示，查询 关系 事务 模式的设计和定义 速度和性能


### 5、分片(sharding)和复制(replication)是怎样工作的?

每一个分片(shard)是一个分区数据的逻辑集合.分片可能由单一服务器或者集群组成,我们推荐为每一个分片(shard)使用集群.


### 6、什么是MongoDB

MongoDB是一个文档数据库，提供好的性能，领先的非关系型数据库。采用BSON存储文档数据。

BSON（）是一种类json的一种二进制形式的存储格式，简称Binary JSON.

相对于json多了date类型和二进制数组。


### 7、monogodb 中的分片什么意思

分片是将数据水平切分到不同的物理节点。当应用数据越来越大的时候，数据量也会越来越大。当数据量增长

时，单台机器有可能无法存储数据或可接受的读取写入吞吐量。利用分片技术可以添加更多的机器来应对数据量增加

以及读写操作的要求。


### 8、解释什么是副本集？
### 9、MongoDB的优势有哪些
### 10、启用备份故障恢复需要多久?
### 11、提到在MongoDB中使用索引的基本语法是什么？
### 12、要进行安全备份，可以使用MongoDB中的功能是什么？
### 13、MongoDB中的分片是什么？
### 14、MongoDB在A:{B,C}上建立索引，查询A:{B,C}和A:{C,B}都会使用索引吗？
### 15、可以把movechunk目录里的旧文件删除吗?
### 16、.MongoDB支持主键外键关系吗
### 17、更新操作立刻fsync到磁盘？
### 18、MongoDB相似的产品有哪些？
### 19、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?
### 20、为什么MongoDB的数据文件很大？
### 21、我应该启动一个集群分片(sharded)还是一个非集群分片的 mongodb 环境?
### 22、ObjectID"有哪些部分组成
### 23、解释一下您可以将旧文件移动到moveChunk目录中吗？
### 24、用什么方法可以格式化输出结果
### 25、更新操作立刻fsync到磁盘?
### 26、分片（sharding）和复制（replication）是怎样工作的？
### 27、什么是NoSQL数据库？NoSQL和RDBMS有什么区别？在哪些情况下使用和不使用NoSQL数据库？
### 28、什么是master或primary?
### 29、getLastError的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
