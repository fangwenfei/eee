# MongoDB最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、更新数据

db.collectionName.update({key:value},{$set:{newkey:newValue}})


### 2、如果用户移除对象的属性,该属性是否从存储层中删除?

是的,用户移除属性然后对象会重新保存(re-save()).


### 3、为什么要在MongoDB中用"Code"数据类型

"Code"类型用于在文档中存储 JavaScript 代码。


### 4、提到在MongoDB中使用索引的基本语法是什么？

MongoDB中使用的基本语法是> db.COLLECTION_NAME.ensureIndex（{KEY：1}）。在这里，键是文档中存在的COLUMN（或KEY：VALUE对）的名称。


### 5、.MongoDB支持主键外键关系吗

默认MongoDB不支持主键和外键关系。 用Mongodb本身的API需要硬编码才能实现外键关联，不够直观且难度

较大


### 6、如果在一个分片(shard)停止或者很慢的时候,我发起一个查询会怎样?

如果一个分片(shard)停止了,除非查询设置了“partial”选项,否则查询会返回一个错误.如果一个分片(shard)响应很慢,mongodb则会等待它的响应.


### 7、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？

更新操作会立即发生在旧的块（Chunk）上，然后更改才会在所有权转移前复制到新的分片上。


### 8、mongodb是否支持事务

MongoDB 4.0的新特性——事务（Transactions）：MongoDB 是不支持事务的，因此开发者在需要用到事务的时候，不得不借用其他工具，在业务代码层面去弥补数据库的不足。

事务和会话(Sessions)关联，一个会话同一时刻只能开启一个事务操作，当一个会话断开，这个会话中的事务也会结束。



### 9、为什么在MongoDB中使用"Object ID"数据类型

"ObjectID"数据类型用于存储文档id


### 10、允许空值null吗?

对于对象成员而言,是的.然而用户不能够添加空值(null)到数据库丛集(collection)因为空值不是对象.然而用户能够添加空对象{}.


### 11、如果用户移除对象的属性，该属性是否从存储层中删除？
### 12、更新操作立刻fsync到磁盘？
### 13、mongodb的结构介绍
### 14、什么是集合(表)
### 15、什么是文档(记录)
### 16、解释什么是副本集？
### 17、MongoDB支持哪些数据类型
### 18、可以把movechunk目录里的旧文件删除吗?
### 19、在MongoDB中创建集合并将其删除的语法是什么？
### 20、说明Profiler在MongoDB中的作用是什么？
### 21、什么是master或primary?
### 22、在MongoDB中如何排序
### 23、mongodb成为最好nosql数据库的原因是什么?
### 24、什么是数据库
### 25、MongoDB中的命名空间是什么意思?
### 26、要进行安全备份，可以使用MongoDB中的功能是什么？
### 27、数据库的整体结构
### 28、如何执行事务/加锁?
### 29、什么是MongoDB中的“命名空间”？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
