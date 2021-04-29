# Redis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis是单线程的，如何提高多核CPU的利用率？

可以在同一个服务器部署多个Redis的实例，并把他们当作不同的服务器来使用，在某些时候，无论如何一个服务器是不够的， 所以，如果你想使用多个CPU，你可以考虑一下分片（shard）。


### 2、Redis 提供 6种数据淘汰策略：

**1、**   volatile-lru：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**2、**   volatile-ttl：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**3、**   volatile-random：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**4、**   allkeys-lru：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**5、**   allkeys-random：从数据集（server.db[i].dict）中任意选择数据淘汰

**6、**   no-enviction（驱逐）：禁止驱逐数据




### 3、Redis前端启动命令

./Redis-server


### 4、Redis常见性能问题和解决方案？

**1、** Master最好不要做任何持久化工作，如RDB内存快照和AOF日志文件

**2、** 如果数据比较重要，某个Slave开启AOF备份数据，策略设置为每秒同步一次

**3、** 为了主从复制的速度和连接的稳定性，Master和Slave最好在同一个局域网内

**4、** 尽量避免在压力很大的主库上增加从库

**5、** 主从复制不要用图状结构，用单向链表结构更为稳定，即：Master <- Slave1 <- Slave2 <- Slave3...

这样的结构方便解决单点故障问题，实现Slave对Master的替换。如果Master挂了，可以立刻启用Slave1做Master，其他不变。


### 5、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？

理论上Redis可以处理多达232的keys，并且在实际中进行了测试，每个实例至少存放了2亿5千万的keys。我们正在测试一些较大的值。任何list、set、和sorted set都可以放232个元素。换句话说，Redis的存储极限是系统中的可用内存值。


### 6、什么是Redis？

Redis本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能，比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。

Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 7、Redis 集群的主从复制模型是怎样的？

为了使在部分节点失败或者大部分节点无法通信的情况下集群仍然可用， 所以集群使用了主从复制模型,每个节点都会有 N-1 个复制品.


### 8、Redis的数据类型？

Redis支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及zsetsorted set：有序集合)。

我们实际项目中比较常用的是string，hash如果你是Redis中高级用户，还需要加上下面几种数据结构HyperLogLog、Geo、Pub/Sub。

如果你说还玩过Redis Module，像BloomFilter，RedisSearch，Redis-ML，面试官得眼睛就开始发亮了。


### 9、Redis Module 实现布隆过滤器

Redis module 是Redis 4.0 以后支持的新的特性，这里很多国外牛逼的大学和机构提供了很多牛逼的Module 只要编译引入到Redis 中就能轻松的实现我们某些需求的功能。在Redis 官方Module 中有一些我们常见的一些模块，我们在这里就做一个简单的使用。

**1、** neural-Redis 主要是神经网络的机器学，集成到Redis 可以做一些机器训练感兴趣的可以尝试

**2、** RedisSearch 主要支持一些富文本的的搜索

**3、** RedisBloom 支持分布式环境下的Bloom 过滤器


### 10、Redis 事务相关的命令有哪几个？

MULTI、EXEC、DISCARD、WATCH


### 11、Redis哨兵
### 12、Redis中的管道有什么用？
### 13、Redis和Redisson有什么关系？
### 14、Redis 如何做内存优化？
### 15、Memcache与Redis的区别都有哪些？
### 16、Redis 的同步机制了解么？
### 17、，免费领取架构资料。
### 18、Redis集群最大节点个数是多少？
### 19、Redis如何做大量数据插入？
### 20、Pipeline有什么好处，为什么要用pipeline？
### 21、Redis 过期键的删除策略？
### 22、为什么Redis需要把所有数据放到内存中?
### 23、为什么Redis需要把所有数据放到内存中？
### 24、Redis回收进程如何工作的？
### 25、Redis分区有什么缺点？
### 26、Redis 的回收策略（淘汰策略）
### 27、分布式Redis是前期做还是后期规模上来了再做好？为什么？
### 28、怎么测试 Redis 的连通性？
### 29、怎么测试Redis的连通性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
