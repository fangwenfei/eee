# Redis最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis有哪几种数据淘汰策略？

**1、** noeviction:返回错误当内存限制达到，并且客户端尝试执行会让更多内存被使用的命令。

**2、** allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。

**3、** volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。

**4、** allkeys-random: 回收随机的键使得新添加的数据有空间存放。

**5、** volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。

**6、** volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。


### 2、Redis 集群如何选择数据库？

Redis 集群目前无法做数据库选择， 默认在 0 数据库。


### 3、Jedis与Redisson对比有什么优缺点？

Jedis是Redis的Java实现的客户端，其API提供了比较全面的Redis命令的支持；Redisson实现了分布式和可扩展的Java数据结构，和Jedis相比，功能较为简单，不支持字符串操作，不支持排序、事务、管道、分区等Redis特性。Redisson的宗旨是促进使用者对Redis的关注分离，从而让使用者能够将精力更集中地放在处理业务逻辑上。


### 4、Redis key的过期时间和永久有效分别怎么设置？

EXPIRE和PERSIST命令


### 5、什么是Redis？简述它的优缺点？

Redis的全称是：Remote Dictionary.Server，本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。

另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。 Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 6、什么是Redis？

Redis本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能，比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。

Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 7、Redis 回收进程如何工作的?

一个客户端运行了新的命令， 添加了新的数据。Redi 检查内存使用情况， 如果大于 maxmemory 的限制, 则根据设定好的策略进行回收。一个新的命令被执行， 等等。所以我们不断地穿越内存限制的边界， 通过不断达到边界然后不断地回收回到边界以下。如果一个命令的结果导致大量内存被使用（ 例如很大的集合的交集保存到一个新的键）， 不用多久内存限制就会被这个内存使用量超越。


### 8、Redis的并发竞争问题如何解决?
### 9、Redis事物的了解CAS(check-and-set 操作实现乐观锁 )?
### 10、Redis分布式锁实现
### 11、Redis 的持久化机制是什么？各自的优缺点？
### 12、Redis持久化数据和缓存怎么做扩容？
### 13、如果有大量的key需要设置同一时间过期，一般需要注意什么？
### 14、Redis与其他key-value存储有什么不同？
### 15、Redis 集群的主从复制模型是怎样的？
### 16、Redis还提供的高级工具
### 17、Redis key的过期时间和永久有效分别怎么设置？
### 18、Redis相比Memcached有哪些优势？
### 19、如果有大量的 key 需要设置同一时间过期，一般需要注意什么？
### 20、Redis如何做大量数据插入？
### 21、都有哪些办法可以降低 Redis 的内存使用情况呢?
### 22、Redis有哪些适合的场景？
### 23、使用Redis有哪些好处？
### 24、Redis 开启AOF
### 25、怎么理解Redis事务？
### 26、WATCH命令和基于CAS的乐观锁：
### 27、Redis集群的主从复制模型是怎样的？
### 28、Redis回收进程如何工作的？
### 29、MySQL 里有 2000w 数据，Redis 中只存 20w 的数据，如何保证Redis 中的数据都是热点数据？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
