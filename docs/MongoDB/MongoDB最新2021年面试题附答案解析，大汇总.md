# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、mongodb是否支持事务

MongoDB 4.0的新特性——事务（Transactions）：MongoDB 是不支持事务的，因此开发者在需要用到事务的时候，不得不借用其他工具，在业务代码层面去弥补数据库的不足。

事务和会话(Sessions)关联，一个会话同一时刻只能开启一个事务操作，当一个会话断开，这个会话中的事务也会结束。



### 2、nosql数据库有哪些

Redis mongodb  hbase


### 3、如何添加索引

使用db.collection.createIndex()在集合中创建一个索引


### 4、getLastError的作用

调用getLastError 可以确认当前的写操作是否成功的提交


### 5、为什么用MOngoDB？

1. 架构简单
2. 没有复杂的连接
3. 深度查询能力,MongoDB支持动态查询。
4. 容易调试
5. 容易扩展
6. 不需要转化/映射应用对象到数据库对象
7. 使用内部内存作为存储工作区,以便更快的存取数据。


### 6、数据库的整体结构

键值对–》文档–》集合–》数据库



### 7、说明Profiler在MongoDB中的作用是什么？

MongoDB数据库分析器显示针对数据库的每个操作的性能特征。您可以使用探查器找到比其慢的查询。


### 8、当我试图更新一个正在被迁移的块（chunk）上的文档时会发生什么？

会立即更新旧的分片，然后更改才会在所有权转移前复制到新的分片上


### 9、什么是master或primary？

当前备份集群负责所有的写入操作的主要节点，在集群中，当主节点（master）失效，另一个成员会变为master


### 10、我应该启动一个集群分片(sharded)还是一个非集群分片的 mongodb 环境?

(数据量大用集群分片,数据量小用非集群)

为开发便捷起见,我们建议以非集群分片(unsharded)方式开始一个 mongodb 环境,除非一台服务器不足以存放你的初始数据集.从非集群分片升级到集群分片(sharding)是无缝的,所以在你的数据集还不是很大的时候没必要考虑集群分片(sharding).


### 11、查看Mongos使用的连接？
### 12、解释什么是副本集？
### 13、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?
### 14、在MongoDB中如何排序
### 15、使用mongodb的优点
### 16、如何执行事务/加锁？
### 17、在MongoDB中什么是副本集（避免单点故障）
### 18、提到在MongoDB中使用索引的基本语法是什么？
### 19、解释什么是MongoDB？
### 20、为什么在MongoDB中使用"Object ID"数据类型
### 21、什么是集合(表)
### 22、更新操作立刻fsync到磁盘？
### 23、数据在什么时候才会扩展到多个分片(shard)里?
### 24、什么是MongoDB中的“命名空间”？
### 25、什么是NoSQL数据库？NoSQL和RDBMS有什么区别？在哪些情况下使用和不使用NoSQL数据库？
### 26、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?
### 27、提到如何检查函数的源代码？
### 28、更新数据
### 29、如果用户移除对象的属性，该属性是否从存储层中删除？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
