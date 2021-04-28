# Redis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Reids的特点

Redis本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。

Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 2、是否使用过 Redis 集群，集群的原理是什么？

**1、** Redis Sentinal 着眼于高可用， 在 master 宕机时会自动将 slave 提升为master， 继续提供服务。

**2、** Redis Cluster 着眼于扩展性， 在单个 Redis 内存不足时， 使用 Cluster 进行分片存储。


### 3、使用Redis 有哪些好处？

**1、** 速度快， 因为数据存在内存中， 类似于 HashMap， HashMap 的优势就是查找和操作的时间复杂度都是 O1)

**2、** 支持丰富数据类型， 支持 string， list， set， Zset， hash 等

**3、** 支持事务， 操作都是原子性， 所谓的原子性就是对数据的更改要么全部执行， 要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按 key 设置过期时间，过期后将会自动删除


### 4、Redis 过期键的删除策略？

**1、** 定时删除:在设置键的过期时间的同时，创建一个定时器 timer). 让定时器在键的过期时间来临时， 立即执行对键的删除操作。

**2、** 惰性删除:放任键过期不管，但是每次从键空间中获取键时，都检查取得的键是   否过期， 如果过期的话， 就删除该键;如果没有过期， 就返回该键。

**3、** 定期删除:每隔一段时间程序就对数据库进行一次检查，删除里面的过期键。至   于要删除多少过期键， 以及要检查多少个数据库， 则由算法决定。


### 5、Redis还提供的高级工具

像慢查询分析、性能测试、Pipeline、事务、Lua自定义命令、Bitmaps、HyperLogLog、/订阅、Geo等个性化功能。


### 6、Redis如何做内存优化？

尽可能使用散列表（hashes），散列表（是说散列表里面存储的数少）使用的内存非常小，所以你应该尽可能的将你的数据模型抽象到一个散列表里面。

比如你的web系统中有一个用户对象，不要为这个用户的名称，姓氏，邮箱，密码设置单独的key,而是应该把这个用户的所有信息存储到一张散列表里面。


### 7、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？

Redis内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略。

相关知识：Redis提供6种数据淘汰策略：

**volatile-lru**：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**volatile-ttl**：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**volatile-random**：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**allkeys-lru**：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**allkeys-random**：从数据集（server.db[i].dict）中任意选择数据淘汰

**no-enviction（驱逐）**：禁止驱逐数据


### 8、Redis前端启动命令

./Redis-server


### 9、Redis分布式

Redis支持主从的模式。原则：Master会将数据同步到slave，而slave不会将数据同步到master。Slave启动时会连接master来同步数据。

这是一个典型的分布式读写分离模型。我们可以利用master来插入数据，slave提供检索服务。这样可以有效减少单个机器的并发访问数量


### 10、Redis是单进程单线程的？

Redis是单进程单线程的，Redis利用队列技术将并发访问变为串行访问，消除了传统数据库串行控制的开销。


### 11、Redis的持久化机制是什么？各自的优缺点？
### 12、Redis的回收策略（淘汰策略）?
### 13、Pipeline 有什么好处，为什么要用pipeline？
### 14、Memcache 与Redis 的区别都有哪些？
### 15、都有哪些办法可以降低 Redis 的内存使用情况呢?
### 16、Redis哨兵
### 17、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？
### 18、Reids主从复制
### 19、请用Redis和任意语言实现一段恶意登录保护的代码，
### 20、Redis 最适合的场景？
### 21、Redis常见性能问题和解决方案：
### 22、判断key是否存在
### 23、RDB和AOF的优缺点
### 24、如果有大量的key需要设置同一时间过期，一般需要注意什么？
### 25、，免费领取架构资料。
### 26、Redis 管道 Pipeline
### 27、缓存并发问题
### 28、Redis相比Memcached有哪些优势？
### 29、定期删除




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
