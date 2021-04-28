# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、提到在MongoDB中使用索引的基本语法是什么？

MongoDB中使用的基本语法是> db.COLLECTION_NAME.ensureIndex（{KEY：1}）。在这里，键是文档中存在的COLUMN（或KEY：VALUE对）的名称。


### 2、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？

命令语法Db.isMaster（）会告诉您是否在主服务器上。MongoDB仅允许一个主服务器，而ouchDB允许多个主服务器。


### 3、解释一下MongoDB中的索引是什么？

索引是MongoDB中的特殊结构，它以易于遍历的形式存储一小部分数据集。索引按索引中指定的字段的值排序，存储特定字段或一组字段的值。


### 4、提到用于查看Mongo的命令语法正在使用链接吗？

用于查看mongo的命令语法使用的链接是db._adminCommand（“ connPoolStats。”）。


### 5、分片（sharding）和复制（replication）是怎样工作的？

分片可能是单一的服务器或者集群组成，推荐使用集群


### 6、解释什么是MongoDB？

Mongo-DB是一个文档数据库，可提供高性能，高可用性和易扩展性。


### 7、什么是非关系型数据库

非关系型数据库的显著特点是不使用SQL作为查询语言，数据存储不需要特定的表格模式。


### 8、复制在MongoDB中如何工作？

在多台服务器之间，同步数据的过程称为复制。它通过不同数据库服务器上的多个数据副本提供冗余并提高数据可用性。复制有助于防止数据库丢失单个服务器。


### 9、为什么用MOngoDB？

1. 架构简单
2. 没有复杂的连接
3. 深度查询能力,MongoDB支持动态查询。
4. 容易调试
5. 容易扩展
6. 不需要转化/映射应用对象到数据库对象
7. 使用内部内存作为存储工作区,以便更快的存取数据。


### 10、我应该启动一个集群分片(sharded)还是一个非集群分片的 mongodb 环境?

(数据量大用集群分片,数据量小用非集群)

为开发便捷起见,我们建议以非集群分片(unsharded)方式开始一个 mongodb 环境,除非一台服务器不足以存放你的初始数据集.从非集群分片升级到集群分片(sharding)是无缝的,所以在你的数据集还不是很大的时候没必要考虑集群分片(sharding).


### 11、mongodb成为最好nosql数据库的原因是什么?
### 12、如何使用"AND"或"OR"条件循环查询集合中的文档
### 13、解释什么是副本集？
### 14、更新操作立刻fsync到磁盘？
### 15、如果用户移除对象的属性，该属性是否从存储层中删除？
### 16、分析器在MongoDB中的作用是什么?
### 17、mongodb的结构介绍
### 18、nosql数据库有哪些
### 19、什么是数据库
### 20、启用备份故障恢复需要多久?
### 21、提及插入文档的命令语法是什么？
### 22、为什么mongodb的数据文件那么庞大
### 23、数据在什么时候才会扩展到多个分片（shard）里？
### 24、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？
### 25、在MongoDB中什么是副本集（避免单点故障）
### 26、当我试图更新一个正在被迁移的块（chunk）上的文档时会发生什么？
### 27、MongoDB的优势有哪些
### 28、为什么MongoDB的数据文件很大？
### 29、为什么要在MongoDB中用"Regular Expression"数据类型




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
