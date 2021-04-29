# MongoDB最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在MongoDB中如何排序

并使用 1 和 -1 来指定排序方式，其中 1 表示升序，而 -1 表示降序。

db.connectionName.find({key:value}).sort({columnName:1})


### 2、在哪些场景使用MongoDB

1. 大数据
2. 内容管理系统
3. 移动端Apps
4. 数据管理


### 3、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?

更新操作会立即发生在旧的分片(shard)上,然后更改才会在所有权转移(ownership transfers)前复制到新的分片上.


### 4、为什么mongodb的数据文件那么庞大

mongodb会积极的预分配预留空间，防止文件系统碎片


### 5、名字空间（namespace）是什么？

在collection中，数据库名+集合名叫做名字空间。也就是一个集合的完整名


### 6、如何使用"AND"或"OR"条件循环查询集合中的文档

db.mycol.find( { $or: [ {key1: value1}, {key2:value2} ] } ).pretty()


### 7、说明Profiler在MongoDB中的作用是什么？

MongoDB数据库分析器显示针对数据库的每个操作的性能特征。您可以使用探查器找到比其慢的查询。


### 8、如何查询集合中的文档
### 9、更新数据
### 10、在MongoDB中什么是副本集（避免单点故障）
### 11、能否使用日志特征进行安全备份？
### 12、为什么用MOngoDB？
### 13、如何执行事务/加锁?
### 14、什么是非关系型数据库
### 15、允许空值null吗?
### 16、MongoDB支持存储过程吗？如果支持的话，怎么用？
### 17、如何添加索引
### 18、提到用于查看Mongo的命令语法正在使用链接吗？
### 19、在MongoDB中创建模式时，需要考虑哪些要点？
### 20、复制在MongoDB中如何工作？
### 21、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？
### 22、mongodb的结构介绍
### 23、解释一下MongoDB中的索引是什么？
### 24、nosql数据库有哪些
### 25、提及Objecld由什么组成？
### 26、使用mongodb的优点
### 27、分析器在MongoDB中的作用是什么?
### 28、如何删除文档
### 29、你怎么比较MongoDB、CouchDB及CouchBase?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
