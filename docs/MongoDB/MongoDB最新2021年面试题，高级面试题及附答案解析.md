# MongoDB最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？

命令语法Db.isMaster（）会告诉您是否在主服务器上。MongoDB仅允许一个主服务器，而ouchDB允许多个主服务器。


### 2、当我试图更新一个正在被迁移的块（chunk）上的文档时会发生什么？

会立即更新旧的分片，然后更改才会在所有权转移前复制到新的分片上


### 3、为什么要在MongoDB中用"Regular Expression"数据类型

"Regular Expression"类型用于在文档中存储正则表达式


### 4、分片（sharding）和复制（replication）是怎样工作的？

分片可能是单一的服务器或者集群组成，推荐使用集群


### 5、MongoDB的优势有哪些

1. 面向文档的存储：以 JSON 格式的文档保存数据。
2. 任何属性都可以建立索引。
3. 复制以及高可扩展性。
4. 自动分片。
5. 丰富的查询功能。
6. 快速的即时更新。


### 6、MySQL与mongodb本质之间最基本的差别是什么

差别在多方面  例如 数据的表示，查询 关系 事务 模式的设计和定义 速度和性能


### 7、解释什么是MongoDB中的GridFS？

为了存储和检索大文件，例如图像，视频文件和音频文件，使用GridFS。默认情况下，它使用两个文件fs.files和fs.chunks来存储文件的元数据和数据块。


### 8、在MongoDB中创建模式时，需要考虑哪些要点？

**需要考虑的要点是**

**1、** 根据用户要求设计架构

**2、** 如果将它们一起使用，则将它们组合到一个文档中。否则，将它们分开

**3、** 在写入时进行连接，而不是在读取时进行连接

**4、** 对于最常见的用例，请优化您的架构

**5、** 在架构中进行复杂的汇总


### 9、MongoDB支持哪些数据类型

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


### 10、解释什么是副本集？

副本集是一组托管相同数据集的mongo实例。在副本集中，一个节点是主节点，另一个是辅助节点。从主节点到辅助节点，所有数据都会复制。


### 11、mongodb成为最好nosql数据库的原因是什么?
### 12、什么是聚合
### 13、解释什么是MongoDB？
### 14、如何执行事务/加锁？
### 15、说明Profiler在MongoDB中的作用是什么？
### 16、如果用户移除对象的属性,该属性是否从存储层中删除?
### 17、MongoDB支持存储过程吗？如果支持的话，怎么用？
### 18、.MongoDB支持主键外键关系吗
### 19、为什么要在MongoDB中使用分析器
### 20、什么是MongoDB中的“命名空间”？
### 21、在MongoDB中创建集合并将其删除的语法是什么？
### 22、名字空间（namespace）是什么？
### 23、允许空值null吗?
### 24、什么是数据库
### 25、解释一下MongoDB中的索引是什么？
### 26、解释一下您可以将旧文件移动到moveChunk目录中吗？
### 27、我应该启动一个集群分片(sharded)还是一个非集群分片的 mongodb 环境?
### 28、更新操作立刻fsync到磁盘？
### 29、31如何理解MongoDB中的GridFS机制，MongoDB为何使用GridFS来存储文件？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
