# MongoDB最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、MongoDB在A:{B,C}上建立索引，查询A:{B,C}和A:{C,B}都会使用索引吗？

不会，只会在A:{B,C}上使用索引。


### 2、mongodb成为最好nosql数据库的原因是什么?

面向文件的 高性能 高可用性 易扩展性 丰富的查询语言


### 3、ObjectID"有哪些部分组成

一共有四部分组成:时间戳、客户端ID、客户进程ID、三个字节的增量计数器


### 4、为什么mongodb的数据文件那么庞大

mongodb会积极的预分配预留空间，防止文件系统碎片


### 5、解释什么是MongoDB中的GridFS？

为了存储和检索大文件，例如图像，视频文件和音频文件，使用GridFS。默认情况下，它使用两个文件fs.files和fs.chunks来存储文件的元数据和数据块。


### 6、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？

命令语法Db.isMaster（）会告诉您是否在主服务器上。MongoDB仅允许一个主服务器，而ouchDB允许多个主服务器。


### 7、能否使用日志特征进行安全备份？

是的。


### 8、.MongoDB支持主键外键关系吗

默认MongoDB不支持主键和外键关系。 用Mongodb本身的API需要硬编码才能实现外键关联，不够直观且难度

较大


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


### 10、解释一下您可以将旧文件移动到moveChunk目录中吗？

是的，可以将旧文件移动到moveChunk目录中，在常规分片平衡操作期间，这些文件将作为备份，并且在操作完成后可以删除。


### 11、如果在一个分片(shard)停止或者很慢的时候,我发起一个查询会怎样?
### 12、如何删除文档
### 13、解释一下MongoDB中的索引是什么？
### 14、什么是数据库
### 15、我怎么查看 Mongo 正在使用的链接？
### 16、提及Objecld由什么组成？
### 17、如何查询集合中的文档
### 18、什么是文档(记录)
### 19、提到用于查看Mongo的命令语法正在使用链接吗？
### 20、分片（sharding）和复制（replication）是怎样工作的？
### 21、分析器在MongoDB中的作用是什么?
### 22、为什么MongoDB的数据文件很大？
### 23、在MongoDb中什么是索引
### 24、要进行安全备份，可以使用MongoDB中的功能是什么？
### 25、分片(sharding)和复制(replication)是怎样工作的?
### 26、MongoDB支持存储过程吗？如果支持的话，怎么用？
### 27、monogodb 中的分片什么意思
### 28、什么是非关系型数据库
### 29、可以把movechunk目录里的旧文件删除吗?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
