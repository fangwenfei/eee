# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、提及插入文档的命令语法是什么？

用于插入文档的命令语法是database.collection.insert（文档）。


### 2、解释一下MongoDB中的索引是什么？

索引是MongoDB中的特殊结构，它以易于遍历的形式存储一小部分数据集。索引按索引中指定的字段的值排序，存储特定字段或一组字段的值。


### 3、名字空间（namespace）是什么？

在collection中，数据库名+集合名叫做名字空间。也就是一个集合的完整名


### 4、为什么MongoDB的数据文件很大？

MongoDB采用的预分配空间的方式来防止文件碎片。


### 5、MongoDB中的分片是什么？

在多台计算机上存储数据记录的过程称为分片。这是一种MongoDB方法，可以满足数据增长的需求。它是数据库或搜索引擎中数据的水平分区。每个分区称为分片或数据库分片。


### 6、启用备份故障恢复需要多久?

从备份数据库声明主数据库宕机到选出一个备份数据库作为新的主数据库将花费10到30秒时间.这期间在主数据库上的操作将会失败–包括写入和强一致性读取(strong consistent read)操作.然而,你还能在第二数据库上执行最终一致性查询(eventually consistent query)(在slaveok模式下),即使在这段时间里.


### 7、你怎么比较MongoDB、CouchDB及CouchBase?

不知道


### 8、为什么要在MongoDB中用"Regular Expression"数据类型

"Regular Expression"类型用于在文档中存储正则表达式


### 9、能否使用日志特征进行安全备份？

是的。


### 10、数据在什么时候才会扩展到多个分片(shard)里?

mongodb 分片是基于区域(range)的.所以一个集合(collection)中的所有的对象都被存放到一个块(chunk)中.只有当存在多余一个块的时候,才会有多个分片获取数据的选项.现在,每个默认块的大小是 64mb,所以你需要至少 64 mb 空间才可以实施一个迁移.


### 11、提到用于查看Mongo的命令语法正在使用链接吗？
### 12、MySQL与mongodb本质之间最基本的差别是什么
### 13、复制在MongoDB中如何工作？
### 14、如何执行事务/加锁？
### 15、更新操作立刻fsync到磁盘?
### 16、提到如何检查函数的源代码？
### 17、MongoDB在A:{B,C}上建立索引，查询A:{B,C}和A:{C,B}都会使用索引吗？
### 18、nosql数据库有哪些
### 19、什么是NoSQL数据库？NoSQL和RDBMS有什么区别？在哪些情况下使用和不使用NoSQL数据库？
### 20、查看Mongos使用的连接？
### 21、在MongoDb中什么是索引
### 22、我应该启动一个集群分片(sharded)还是一个非集群分片的 mongodb 环境?
### 23、为什么mongodb的数据文件那么庞大
### 24、什么是MongoDB
### 25、如何查询集合中的文档
### 26、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?
### 27、解释什么是MongoDB？
### 28、getLastError的作用
### 29、为什么用MOngoDB？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
