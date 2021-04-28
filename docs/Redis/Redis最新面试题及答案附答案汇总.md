# Redis最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Redis常见性能问题和解决方案？

**1、** Master最好不要做任何持久化工作，如RDB内存快照和AOF日志文件

**2、** 如果数据比较重要，某个Slave开启AOF备份数据，策略设置为每秒同步一次

**3、** 为了主从复制的速度和连接的稳定性，Master和Slave最好在同一个局域网内

**4、** 尽量避免在压力很大的主库上增加从库

**5、** 主从复制不要用图状结构，用单向链表结构更为稳定，即：Master <- Slave1 <- Slave2 <- Slave3...

这样的结构方便解决单点故障问题，实现Slave对Master的替换。如果Master挂了，可以立刻启用Slave1做Master，其他不变。


### 2、一个 Redis 实例最多能存放多少的 keys？List、Set、Sorted Set 他们最多能存放多少元素?

理论上 Redis 可以处理多达 232 的 keys，并且在实际中进行了测试，每个实例至少存放了 2 亿 5 千万的 keys。我们正在测试一些较大的值。任何 list、set、和 sorted set 都可以放 232 个元素。换句话说， Redis 的存储极限是系统中的可用内存值。


### 3、说说Redis哈希槽的概念？

Redis集群没有使用一致性hash,而是引入了哈希槽的概念，Redis集群有16384个哈希槽，每个key通过CRC16校验后对16384取模来决定放置哪个槽，集群的每个节点负责一部分hash槽。


### 4、Redis集群方案应该怎么做？都有哪些方案？

**1、** codis。

目前用的最多的集群方案，基本和twemproxy一致的效果，但它支持在 节点数量改变情况下，旧节点数据可恢复到新hash节点。

**2、** Redis cluster3.0自带的集群，特点在于他的分布式算法不是一致性hash，而是hash槽的概念，以及自身支持节点设置从节点。具体看官方文档介绍。

**3、** 在业务代码层实现，起几个毫无关联的Redis实例，在代码层，对key 进行hash计算，然后去对应的Redis实例操作数据。 这种方式对hash层代码要求比较高，考虑部分包



### 5、Reids6种淘汰策略：

**noeviction**: 不删除策略, 达到最大内存限制时, 如果需要更多内存, 直接返回错误信息。大多数写命令都会导致占用更多的内存(有极少数会例外。

**allkeys-lru:**所有key通用; 优先删除最近最少使用(less recently used ,LRU) 的 key。

**volatile-lru:**只限于设置了 expire 的部分; 优先删除最近最少使用(less recently used ,LRU) 的 key。

**allkeys-random:**所有key通用; 随机删除一部分 key。

**volatile-random**: 只限于设置了 **expire** 的部分; 随机删除一部分 key。

**volatile-ttl**: 只限于设置了 **expire** 的部分; 优先删除剩余时间(time to live,TTL) 短的key。


### 6、Redis的并发竞争问题如何解决?

Redis为单进程单线程模式，采用队列模式将并发访问变为串行访问。Redis本身没有锁的概念，Redis对于多个客户端连接并不存在竞争，但是在Jedis客户端对Redis进行并发访问时会发生连接超时、数据转换错误、阻塞、客户端关闭连接等问题，这些问题均是由于客户端连接混乱造成。

**对此有2种解决方法：**

**1、** 客户端角度，为保证每个客户端间正常有序与Redis进行通信，对连接进行池化，同时对客户端读写Redis操作采用内部锁synchronized。

**2、** 服务器角度，利用setnx实现锁。

_注：对于第一种，需要应用程序自己处理资源的同步，可以使用的方法比较通俗，可以使用synchronized也可以使用lock；第二种需要用到Redis的setnx命令，但是需要注意一些问题。_


### 7、怎么测试Redis的连通性？

ping


### 8、Redis是单进程单线程的

Redis利用队列技术将并发访问变为串行访问，消除了传统数据库串行控制的开销


### 9、Redis做异步队列

一般使用list结构作为队列，rpush生产消息，lpop消费消息。当lpop没有消息的时候，要适当sleep一会再重试。缺点：在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如rabbitmq等。能不能生产一次消费多次呢？使用pub/sub主题订阅者模式，可以实现1:N的消息队列。


### 10、Redis有哪几种数据淘汰策略？

noeviction:返回错误当内存限制达到并且客户端尝试执行会让更多内存被使用的命令（大部分的写入指令，但DEL和几个例外）

allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。

volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。

allkeys-random: 回收随机的键使得新添加的数据有空间存放。

volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。

volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。


### 11、Redis 的回收策略（淘汰策略）
### 12、Redis 的持久化机制是什么？各自的优缺点？
### 13、Redis内存模型
### 14、Redis主要消耗什么物理资源？
### 15、是否使用过Redis集群，集群的原理是什么？
### 16、Redis 的同步机制了解么？
### 17、多节点 Redis 分布式锁：Redlock 算法
### 18、Redis 如何设置密码及验证密码？
### 19、Redis 中设置过期时间主要通过以下四种方式
### 20、什么是Redis?
### 21、读写分离模型
### 22、Redis回收使用的是什么算法？
### 23、Redis 到底是怎么实现“附近的人”
### 24、Redis事物的了解CAS(check-and-set 操作实现乐观锁 )?
### 25、SCAN系列命令注意事项
### 26、Redis key 的过期时间和永久有效分别怎么设置？
### 27、怎么理解Redis事务？
### 28、Redis持久化数据和缓存怎么做扩容？
### 29、MySQL里有2000w数据，Redis中只存20w的数据




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
