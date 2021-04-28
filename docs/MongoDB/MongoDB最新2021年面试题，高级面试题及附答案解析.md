# MongoDB最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、mongodb成为最好nosql数据库的原因是什么?

面向文件的 高性能 高可用性 易扩展性 丰富的查询语言


### 2、什么是非关系型数据库

非关系型数据库的显著特点是不使用SQL作为查询语言，数据存储不需要特定的表格模式。


### 3、什么是MongoDB

MongoDB是一个文档数据库，提供好的性能，领先的非关系型数据库。采用BSON存储文档数据。

BSON（）是一种类json的一种二进制形式的存储格式，简称Binary JSON.

相对于json多了date类型和二进制数组。


### 4、我怎么查看 Mongo 正在使用的链接？

db._adminCommand("connPoolStats");


### 5、允许空值null吗?

对于对象成员而言,是的.然而用户不能够添加空值(null)到数据库丛集(collection)因为空值不是对象.然而用户能够添加空对象{}.


### 6、用什么方法可以格式化输出结果

db.collectionName.find().pretty()


### 7、更新数据

db.collectionName.update({key:value},{$set:{newkey:newValue}})


### 8、31如何理解MongoDB中的GridFS机制，MongoDB为何使用GridFS来存储文件？

GridFS是一种将大型文件存储在MongoDB中的文件规范。使用GridFS可以将大文件分隔成多个小文档存放，这样我们能够有效的保存大文档，而且解决了BSON对象有限制的问题。


### 9、什么是master或primary？

当前备份集群负责所有的写入操作的主要节点，在集群中，当主节点（master）失效，另一个成员会变为master


### 10、我应该启动一个集群分片(sharded)还是一个非集群分片的 mongodb 环境?

(数据量大用集群分片,数据量小用非集群)

为开发便捷起见,我们建议以非集群分片(unsharded)方式开始一个 mongodb 环境,除非一台服务器不足以存放你的初始数据集.从非集群分片升级到集群分片(sharding)是无缝的,所以在你的数据集还不是很大的时候没必要考虑集群分片(sharding).


### 11、在哪些场景使用MongoDB
### 12、MongoDB的优势有哪些
### 13、更新操作立刻fsync到磁盘？
### 14、如何添加索引
### 15、说明Profiler在MongoDB中的作用是什么？
### 16、为什么用MOngoDB？
### 17、.MongoDB支持主键外键关系吗
### 18、为什么mongodb的数据文件那么庞大
### 19、解释一下MongoDB中的索引是什么？
### 20、为什么要在MongoDB中用"Regular Expression"数据类型
### 21、解释什么是副本集？
### 22、提及插入文档的命令语法是什么？
### 23、为什么在MongoDB中使用"Object ID"数据类型
### 24、如何查询集合中的文档
### 25、MongoDB相似的产品有哪些？
### 26、提及Objecld由什么组成？
### 27、什么是聚合
### 28、解释什么是MongoDB中的GridFS？
### 29、要进行安全备份，可以使用MongoDB中的功能是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
