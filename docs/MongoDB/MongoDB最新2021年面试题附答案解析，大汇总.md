# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、为什么在MongoDB中使用"Object ID"数据类型

"ObjectID"数据类型用于存储文档id


### 2、为什么要在MongoDB中使用分析器

mongodb中包括了一个可以显示数据库中每个操作性能特点的数据库分析器.通过这个分析器你可以找到比预期慢

的查询(或写操作);利用这一信息,比如,可以确定是否需要添加索引.


### 3、当我试图更新一个正在被迁移的块（chunk）上的文档时会发生什么？

会立即更新旧的分片，然后更改才会在所有权转移前复制到新的分片上


### 4、如果用户移除对象的属性,该属性是否从存储层中删除?

是的,用户移除属性然后对象会重新保存(re-save()).


### 5、为什么要在MongoDB中用"Regular Expression"数据类型

"Regular Expression"类型用于在文档中存储正则表达式


### 6、什么是master或primary？

当前备份集群负责所有的写入操作的主要节点，在集群中，当主节点（master）失效，另一个成员会变为master


### 7、在MongoDb中什么是索引

索引用于高效的执行查询,没有索引的MongoDB将扫描整个集合中的所有文档,这种扫描效率很低,需要处理大量

的数据. 索引是一种特殊的数据结构,将一小块数据集合保存为容易遍历的形式.索引能够存储某种特殊字段或字段集的

值,并按照索引指定的方式将字段值进行排序.


### 8、什么是聚合
### 9、什么是集合(表)
### 10、如果在一个分片(shard)停止或者很慢的时候,我发起一个查询会怎样?
### 11、如何执行事务/加锁？
### 12、我怎么查看 Mongo 正在使用的链接？
### 13、31如何理解MongoDB中的GridFS机制，MongoDB为何使用GridFS来存储文件？
### 14、什么是文档(记录)
### 15、mongodb是否支持事务
### 16、mongodb成为最好nosql数据库的原因是什么?
### 17、解释什么是MongoDB？
### 18、MongoDB中的命名空间是什么意思?
### 19、什么是数据库
### 20、解释什么是MongoDB中的GridFS？
### 21、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？
### 22、提到如何检查函数的源代码？
### 23、数据库的整体结构
### 24、如果用户移除对象的属性，该属性是否从存储层中删除？
### 25、什么是MongoDB中的“命名空间”？
### 26、查看Mongos使用的连接？
### 27、在MongoDB中创建集合并将其删除的语法是什么？
### 28、数据在什么时候才会扩展到多个分片(shard)里?
### 29、为什么要在MongoDB中用"Code"数据类型




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
