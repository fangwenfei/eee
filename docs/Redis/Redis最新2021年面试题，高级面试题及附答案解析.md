# Redis最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Redis 集群方案什么情况下会导致整个集群不可用？

有 A， B， C 三个节点的集群,在没有复制模型的情况下,如果节点 B 失败了， 那么整个集群就会以为缺少 5501-11000 这个范围的槽而不可用。


### 2、Redis常见的几种缓存策略

**1、** Cache-Aside

**2、** Read-Through

**3、** Write-Through

**4、** Write-Behind


### 3、Redis对象有5种类型

无论是哪种类型，Redis都不会直接存储，而是通过RedisObject对象进行存储。


### 4、Redis 管道 Pipeline

在某些场景下我们在**一次操作中可能需要执行多个命令**，而如果我们只是一个命令一个命令去执行则会浪费很多网络消耗时间，如果将命令一次性传输到 `Redis`中去再执行，则会减少很多开销时间。但是需要注意的是 `pipeline`中的命令并不是原子性执行的，也就是说管道中的命令到达 `Redis`服务器的时候可能会被其他的命令穿插


### 5、Redis主要消耗什么物理资源？

内存。


### 6、Redis支持哪几种数据类型？

String、List、Set、Sorted Set、hashes


### 7、Redis key 的过期时间和永久有效分别怎么设置？

EXPIRE 和 PERSIST 命令。


### 8、Redis 提供 6种数据淘汰策略：

**1、**   volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**2、**   volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**3、**   volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**4、**   allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**5、**   allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰

**6、**   no-enviction（驱逐）：禁止驱逐数据




### 9、为什么要做Redis分区？

分区可以让Redis管理更大的内存，Redis将可以使用所有机器的内存。如果没有分区，你最多只能使用一台机器的内存。分区使Redis的计算能力通过简单地增加计算机得到成倍提升,Redis的网络带宽也会随着计算机和网卡的增加而成倍增长。


### 10、什么是Redis？

Redis本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能，比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。

Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 11、Redis 到底是怎么实现“附近的人”
### 12、使用Redis有哪些好处？
### 13、MySQL 里有 2000w 数据，Redis 中只存 20w 的数据，如何保证Redis 中的数据都是热点数据？
### 14、读写分离模型
### 15、Reids6种淘汰策略：
### 16、Redis 的数据类型？
### 17、Redis 中设置过期时间主要通过以下四种方式
### 18、Redis 持久化方案：
### 19、Redis有哪些适合的场景？
### 20、使用过Redis做异步队列么，你是怎么用的？
### 21、为什么Redis需要把所有数据放到内存中?
### 22、Redis 是单进程单线程的？
### 23、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？
### 24、你知道有哪些Redis分区实现方案？
### 25、什么是Redis?
### 26、怎么测试 Redis 的连通性？
### 27、怎么测试Redis的连通性？
### 28、都有哪些办法可以降低Redis的内存使用情况呢？
### 29、AOF常用配置总结
### 30、Redis常见性能问题和解决方案？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
