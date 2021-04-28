# MongoDB最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、查看是否在主服务器上的命令语法是什么？MongoDB允许多少个主机？

命令语法Db.isMaster（）会告诉您是否在主服务器上。MongoDB仅允许一个主服务器，而ouchDB允许多个主服务器。


### 2、分析器在MongoDB中的作用是什么?

分析器就是explain 显示每次操作性能特点的数据库分析器。通过分析器可能查找比预期慢的操作


### 3、数据库的整体结构

键值对–》文档–》集合–》数据库



### 4、解释一下您可以将旧文件移动到moveChunk目录中吗？

是的，可以将旧文件移动到moveChunk目录中，在常规分片平衡操作期间，这些文件将作为备份，并且在操作完成后可以删除。


### 5、更新操作立刻fsync到磁盘?

不会,磁盘写操作默认是延迟执行的.写操作可能在两三秒(默认在60秒内)后到达磁盘.例如,如果一秒内数据库收到一千个对一个对象递增的操作,仅刷新磁盘一次.


### 6、能否使用日志特征进行安全备份？

是的。


### 7、数据在什么时候才会扩展到多个分片（shard）里？

mongodb分片是基于区域的，所以一个集合的所有对象都放置在同一个块中，只有当存在多余一个块的时候，才会有多个分片获取数据的选项


### 8、为什么MongoDB的数据文件很大？

MongoDB采用的预分配空间的方式来防止文件碎片。


### 9、名字空间（namespace）是什么？

在collection中，数据库名+集合名叫做名字空间。也就是一个集合的完整名


### 10、MongoDB支持存储过程吗？如果支持的话，怎么用？

MongoDB支持存储过程，它是javascript写的，保存在db.system.js表中。


### 11、在MongoDB中如何排序
### 12、如何执行事务/加锁?
### 13、MongoDB中的命名空间是什么意思?
### 14、启用备份故障恢复需要多久?
### 15、复制在MongoDB中如何工作？
### 16、你怎么比较MongoDB、CouchDB及CouchBase?
### 17、mongodb的结构介绍
### 18、当我试图更新一个正在被迁移的块(chunk)上的文档时会发生什么?
### 19、在MongoDb中什么是索引
### 20、为什么要在MongoDB中用"Code"数据类型
### 21、当我试图更新一个正在被迁移的块（chunk）上的文档时会发生什么？
### 22、如何使用"AND"或"OR"条件循环查询集合中的文档
### 23、为什么要在MongoDB中使用分析器
### 24、数据在什么时候才会扩展到多个分片(shard)里?
### 25、MongoDB在A:{B,C}上建立索引，查询A:{B,C}和A:{C,B}都会使用索引吗？
### 26、什么是master或primary?
### 27、查看Mongos使用的连接？
### 28、nosql数据库有哪些
### 29、分片（sharding）和复制（replication）是怎样工作的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
