# Redis最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Redis通讯协议

RESP 是Redis客户端和服务端之前使用的一种通讯协议；RESP 的特点：实现简单、快速解析、可读性好


### 2、使用Redis 有哪些好处？

**1、** 速度快， 因为数据存在内存中， 类似于 HashMap， HashMap 的优势就是查找和操作的时间复杂度都是 O1)

**2、** 支持丰富数据类型， 支持 string， list， set， Zset， hash 等

**3、** 支持事务， 操作都是原子性， 所谓的原子性就是对数据的更改要么全部执行， 要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按 key 设置过期时间，过期后将会自动删除


### 3、Redis集群的主从复制模型是怎样的？

为了使在部分节点失败或者大部分节点无法通信的情况下集群仍然可用，所以集群使用了主从复制模型,每个节点都会有N-1个复制品.


### 4、MySQL 里有 2000w 数据，Redis 中只存 20w 的数据，如何保证Redis 中的数据都是热点数据？

Redis 内存数据集大小上升到一定大小的时候， 就会施行数据淘汰策略。相关知识： Redis 提供 6 种数据淘汰策略：

volatile-lru：从已设置过期时间的数据集（ server.db[i].expires）中挑选最近最

少使用的数据淘汰

volatile-ttl： 从已设置过期时间的数据集（ server.db[i].expires） 中挑选将要过期的数据淘汰

volatile-random： 从已设置过期时间的数据集（ server.db[i].expires） 中任意选择数据淘汰

allkeys-lru： 从数据集（ server.db[i].dict） 中挑选最近最少使用的数据淘汰

allkeys-random： 从数据集（ server.db[i].dict） 中任意选择数据淘汰

no-enviction（ 驱逐） ： 禁止驱逐数据


### 5、Redis分布式

Redis支持主从的模式。原则：Master会将数据同步到slave，而slave不会将数据同步到master。Slave启动时会连接master来同步数据。

这是一个典型的分布式读写分离模型。我们可以利用master来插入数据，slave提供检索服务。这样可以有效减少单个机器的并发访问数量


### 6、Redis的内存用完了会发生什么？

如果达到设置的上限，Redis的写命令会返回错误信息（但是读命令还可以正常返回。）或者你可以将Redis当缓存来使用配置淘汰机制，当Redis达到内存上限时会冲刷掉旧的内容。


### 7、为什么Redis需要把所有数据放到内存中？

Redis为了达到最快的读写速度将数据都读到内存中，并通过异步的方式将数据写入磁盘。所以Redis具有快速和数据持久化的特征。如果不将数据放在内存中，磁盘I/O速度为严重影响Redis的性能。在内存越来越便宜的今天，Redis将会越来越受欢迎。

如果设置了最大使用的内存，则数据已有记录数达到内存限值后不能继续插入新值。


### 8、Redis key 的过期时间和永久有效分别怎么设置？

EXPIRE 和 PERSIST 命令。


### 9、什么是Redis？简述它的优缺点？

Redis的全称是：Remote Dictionary.Server，本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。

另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。 Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 10、Redis常见性能问题和解决方案：

**1、** Master最好不要写内存快照，如果Master写内存快照，save命令调度rdbSave函数，会阻塞主线程的工作，当快照比较大时对性能影响是非常大的，会间断性暂停服务

**2、** 如果数据比较重要，某个Slave开启AOF备份数据，策略设置为每秒同步一

**3、** 为了主从复制的速度和连接的稳定性，Master和Slave最好在同一个局域网

**4、** 尽量避免在压力很大的主库上增加从

**5、** 主从复制不要用图状结构，用单向链表结构更为稳定，即：Master <- Slave1 <- Slave2 <- Slave3…这样的结构方便解决单点故障问题，实现Slave对Master的替换。如果Master挂了，可以立刻启用Slave1做Master，其他不变。


### 11、Jedis与Redisson对比有什么优缺点？
### 12、修改配置不重启Redis会实时生效吗？
### 13、Redis key的过期时间和永久有效分别怎么设置？
### 14、使用Redis有哪些好处？
### 15、Redis事物的了解CAS(check-and-set 操作实现乐观锁 )?
### 16、使用过Redis分布式锁么，它是什么回事？
### 17、Redis 管道 Pipeline
### 18、一个字符串类型的值能存储最大容量是多少？
### 19、如何实现集群中的 session 共享存储？
### 20、Redis key的过期时间和永久有效分别怎么设置？
### 21、都有哪些办法可以降低 Redis 的内存使用情况呢?
### 22、使用Redis有哪些好处？
### 23、Redis如何做大量数据插入？
### 24、Reids三种不同删除策略
### 25、Redis做异步队列
### 26、Redis 集群会有写操作丢失吗？为什么？
### 27、为什么需要持久化？
### 28、Redis回收进程如何工作的？
### 29、Redis相比Memcached有哪些优势？
### 30、Redis 的同步机制了解么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
