# MongoDB最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、mongodb是否支持事务

MongoDB 4.0的新特性——事务（Transactions）：MongoDB 是不支持事务的，因此开发者在需要用到事务的时候，不得不借用其他工具，在业务代码层面去弥补数据库的不足。

事务和会话(Sessions)关联，一个会话同一时刻只能开启一个事务操作，当一个会话断开，这个会话中的事务也会结束。



### 2、什么是master或primary?

它是当前备份集群(replica set)中负责处理所有写入操作的主要节点/成员.在一个备份集群中,当失效备援(failover)事件发生时,一个另外的成员会变成primary.


### 3、允许空值null吗?

对于对象成员而言,是的.然而用户不能够添加空值(null)到数据库丛集(collection)因为空值不是对象.然而用户能够添加空对象{}.


### 4、可以把movechunk目录里的旧文件删除吗?

没问题,这些文件是在分片(shard)进行均衡操作(balancing)的时候产生的临时文件.一旦这些操作已经完成,相关的临时文件也应该被删除掉.但目前清理工作是需要手动的,所以请小心地考虑再释放这些文件的空间.


### 5、我怎么查看 Mongo 正在使用的链接？

db._adminCommand("connPoolStats");


### 6、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?

不需要,移动操作是一致(consistent)并且是确定性的(deterministic);一次失败后,移动操作会不断重试;当完成后,数据只会出现在新的分片里(shard).


### 7、MySQL与mongodb本质之间最基本的差别是什么

差别在多方面  例如 数据的表示，查询 关系 事务 模式的设计和定义 速度和性能


### 8、在MongoDb中什么是索引

索引用于高效的执行查询,没有索引的MongoDB将扫描整个集合中的所有文档,这种扫描效率很低,需要处理大量

的数据. 索引是一种特殊的数据结构,将一小块数据集合保存为容易遍历的形式.索引能够存储某种特殊字段或字段集的

值,并按照索引指定的方式将字段值进行排序.


### 9、为什么要在MongoDB中用"Code"数据类型

"Code"类型用于在文档中存储 JavaScript 代码。


### 10、为什么要在MongoDB中使用分析器

mongodb中包括了一个可以显示数据库中每个操作性能特点的数据库分析器.通过这个分析器你可以找到比预期慢

的查询(或写操作);利用这一信息,比如,可以确定是否需要添加索引.


### 11、在MongoDB中创建模式时，需要考虑哪些要点？
### 12、如何执行事务/加锁？
### 13、什么是文档(记录)
### 14、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?
### 15、getLastError的作用
### 16、在MongoDB中创建集合并将其删除的语法是什么？
### 17、数据库的整体结构
### 18、如果用户移除对象的属性,该属性是否从存储层中删除?
### 19、为什么在MongoDB中使用"Object ID"数据类型
### 20、如何执行事务/加锁?
### 21、如何查询集合中的文档
### 22、提及Objecld由什么组成？
### 23、MongoDB中的分片是什么？
### 24、要进行安全备份，可以使用MongoDB中的功能是什么？
### 25、什么是MongoDB
### 26、MongoDB相似的产品有哪些？
### 27、什么是MongoDB中的“命名空间”？
### 28、什么是集合(表)
### 29、分片(sharding)和复制(replication)是怎样工作的?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
