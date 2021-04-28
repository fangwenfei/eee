# MongoDB最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



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


### 2、当更新一个正在被迁移的块（Chunk）上的文档时会发生什么？

更新操作会立即发生在旧的块（Chunk）上，然后更改才会在所有权转移前复制到新的分片上。


### 3、如果块移动操作(movechunk)失败了,我需要手动清除部分转移的文档吗?

不需要,移动操作是一致(consistent)并且是确定性的(deterministic);一次失败后,移动操作会不断重试;当完成后,数据只会出现在新的分片里(shard).


### 4、提到如何检查函数的源代码？

要检查没有任何括号的函数源代码，必须调用该函数。


### 5、如何删除文档

db.collectionName.remove({key:value})


### 6、如果用户移除对象的属性,该属性是否从存储层中删除?

是的,用户移除属性然后对象会重新保存(re-save()).


### 7、解释什么是MongoDB？

Mongo-DB是一个文档数据库，可提供高性能，高可用性和易扩展性。


### 8、在MongoDB中创建模式时，需要考虑哪些要点？

**需要考虑的要点是**

**1、** 根据用户要求设计架构

**2、** 如果将它们一起使用，则将它们组合到一个文档中。否则，将它们分开

**3、** 在写入时进行连接，而不是在读取时进行连接

**4、** 对于最常见的用例，请优化您的架构

**5、** 在架构中进行复杂的汇总


### 9、getLastError的作用

调用getLastError 可以确认当前的写操作是否成功的提交


### 10、monogodb 中的分片什么意思

分片是将数据水平切分到不同的物理节点。当应用数据越来越大的时候，数据量也会越来越大。当数据量增长

时，单台机器有可能无法存储数据或可接受的读取写入吞吐量。利用分片技术可以添加更多的机器来应对数据量增加

以及读写操作的要求。


### 11、在MongoDB中什么是副本集（避免单点故障）
### 12、什么是NoSQL数据库？NoSQL和RDBMS有什么区别？在哪些情况下使用和不使用NoSQL数据库？
### 13、如何执行事务/加锁？
### 14、可以把movechunk目录里的旧文件删除吗?
### 15、MySQL与mongodb本质之间最基本的差别是什么
### 16、在MongoDB中创建集合并将其删除的语法是什么？
### 17、提到在MongoDB中使用索引的基本语法是什么？
### 18、MongoDB中的分片是什么？
### 19、ObjectID"有哪些部分组成
### 20、使用mongodb的优点
### 21、mongodb是否支持事务
### 22、如果在一个分片(shard)停止或者很慢的时候,我发起一个查询会怎样?
### 23、什么是文档(记录)
### 24、如果用户移除对象的属性，该属性是否从存储层中删除？
### 25、什么是MongoDB中的“命名空间”？
### 26、什么是集合(表)
### 27、提到用于查看Mongo的命令语法正在使用链接吗？
### 28、分片(sharding)和复制(replication)是怎样工作的?
### 29、什么是数据库




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
