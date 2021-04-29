# Redis最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、缓存雪崩问题

存在同一时间内大量键过期（失效），接着来的一大波请求瞬间都落在了数据库中导致连接异常。

解决方案：

**1、** 也是像解决缓存穿透一样加锁排队。

**2、** 建立备份缓存，缓存A和缓存B，A设置超时时间，B不设值超时时间，先从A读缓存，A没有读B，并且更新A缓存和B缓存;


### 2、MySQL里有2000w数据，Redis中只存20w的数据

**如何保证Redis中的数据都是热点数据？**

Redis内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略。

其实面试除了考察Redis，不少公司都很重视高并发高可用的技术，特别是一线互联网公司，分布式、JVM、spring源码分析、微服务等知识点已是面试的必考题。我自己整理收集了一套系统的架构技术体系，针对当前互联网公司的技术需求以及结合主流技术，这些东西可能你们平时在工作中接触过，但是缺少的全面系统的学习，加入
### 3、怎么理解Redis事务？



事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。

事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。


### 4、Redis 集群方案什么情况下会导致整个集群不可用？

有 A， B， C 三个节点的集群,在没有复制模型的情况下,如果节点 B 失败了， 那么整个集群就会以为缺少 5501-11000 这个范围的槽而不可用。


### 5、Twemproxy是什么？

Twemproxy是Twitter维护的（缓存）代理系统，代理Memcached的ASCII协议和Redis协议。它是单线程程序，使用c语言编写，运行起来非常快。它是采用Apache 2.0 license的开源软件。 Twemproxy支持自动分区，如果其代理的其中一个Redis节点不可用时，会自动将该节点排除（这将改变原来的keys-instances的映射关系，所以你应该仅在把Redis当缓存时使用Twemproxy)。 Twemproxy本身不存在单点问题，因为你可以启动多个Twemproxy实例，然后让你的客户端去连接任意一个Twemproxy实例。 Twemproxy是Redis客户端和服务器端的一个中间层，由它来处理分区功能应该不算复杂，并且应该算比较可靠的。


### 6、支持一致性哈希的客户端有哪些？

Redis-rb、PRedis等。


### 7、Redis是单线程

Redis利用队列技术将并发访问变为串行访问，消除了传统数据库串行控制的开销


### 8、假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？

使用keys指令可以扫出指定模式的key列表。

对方接着追问：如果这个Redis正在给线上的业务提供服务，那使用keys指令会有什么问题？

这个时候你要回答Redis关键的一个特性：Redis的单线程的。keys指令会导致线程阻塞一段时间，线上服务会停顿，直到指令执行完毕，服务才能恢复。这个时候可以使用scan指令，scan指令可以无阻塞的提取出指定模式的key列表，但是会有一定的重复概率，在客户端做一次去重就可以了，但是整体所花费的时间会比直接用keys指令长。


### 9、什么是Redis？简述它的优缺点？

Redis的全称是：Remote Dictionary.Server，本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。

另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。 Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 10、Redis 是单进程单线程的？

Redis 是单进程单线程的， Redis 利用队列技术将并发访问变为串行访问， 消除了传统数据库串行控制的开销。


### 11、Redis分布式锁实现
### 12、Redis的同步机制了解么？
### 13、Redis key 的过期时间和永久有效分别怎么设置？
### 14、Reids常用5种数据类型
### 15、Redis 集群最大节点个数是多少？
### 16、MySQL 里有 2000w 数据，Redis 中只存 20w 的数据，如何保证Redis 中的数据都是热点数据？
### 17、Redis没有直接使用C字符串
### 18、Reids6种淘汰策略：
### 19、Redis集群会有写操作丢失吗？为什么？
### 20、Redis key的过期时间和永久有效分别怎么设置？
### 21、Redis集群方案什么情况下会导致整个集群不可用？
### 22、一个字符串类型的值能存储最大容量是多少？
### 23、手写一个 LRU 算法
### 24、Redis集群方案应该怎么做？都有哪些方案？
### 25、Memcache 与Redis 的区别都有哪些？
### 26、使用过Redis分布式锁么，它是什么回事？
### 27、怎么理解 Redis 事务？
### 28、微信公众号：Java资讯库，回复“架构”
### 29、如何实现集群中的 session 共享存储？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
