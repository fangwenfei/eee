# Redis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？

理论上Redis可以处理多达232的keys，并且在实际中进行了测试，每个实例至少存放了2亿5千万的keys。我们正在测试一些较大的值。任何list、set、和sorted set都可以放232个元素。换句话说，Redis的存储极限是系统中的可用内存值。


### 2、说说Redis哈希槽的概念？

Redis集群没有使用一致性hash,而是引入了哈希槽的概念，Redis集群有16384个哈希槽，每个key通过CRC16校验后对16384取模来决定放置哪个槽，集群的每个节点负责一部分hash槽。


### 3、Redis回收使用的是什么算法？

LRU算法


### 4、怎么测试Redis的连通性？

使用ping命令。


### 5、Redis中的管道有什么用？

一次请求/响应服务器能实现处理新的请求即使旧的请求还未被响应。这样就可以将多个命令发送到服务器，而不用等待回复，最后在一个步骤中读取该答复。

这就是管道（pipelining），是一种几十年来广泛使用的技术。例如许多POP3协议已经实现支持这个功能，大大加快了从服务器下载新邮件的过程。


### 6、Jedis与Redisson对比有什么优缺点？

Jedis是Redis的Java实现的客户端，其API提供了比较全面的Redis命令的支持；

Redisson实现了分布式和可扩展的Java数据结构，和Jedis相比，功能较为简单，不支持字符串操作，不支持排序、事务、管道、分区等Redis特性。Redisson的宗旨是促进使用者对Redis的关注分离，从而让使用者能够将精力更集中地放在处理业务逻辑上。


### 7、Reids支持的语言：

java、C、C#、C++、php、Node.js、Go等。


### 8、Reids主从复制
### 9、读写分离模型
### 10、Redis 是单进程单线程的？
### 11、Redis有哪几种数据淘汰策略？
### 12、怎么测试 Redis 的连通性？
### 13、为什么 edis 需要把所有数据放到内存中？
### 14、Redis持久化的几种方式
### 15、为什么edis需要把所有数据放到内存中？
### 16、Redis官方为什么不提供Windows版本？
### 17、Redis 的主从复制
### 18、Redis集群方案应该怎么做？都有哪些方案？
### 19、Redis 集群方案什么情况下会导致整个集群不可用？
### 20、Redis 集群会有写操作丢失吗？为什么？
### 21、使用Redis有哪些好处？
### 22、使用过 Redis 分布式锁么，它是什么回事？
### 23、假如 Redis 里面有 1 亿个key，其中有 10w 个key 是以某个固定的已知的前缀开头的，如果将它们全部找出来？
### 24、Memcache与Redis的区别都有哪些？
### 25、什么是Redis?
### 26、Redis 集群最大节点个数是多少？
### 27、Memcached 与Redis 的区别？
### 28、Redis哨兵
### 29、缓存和数据库间数据一致性问题
### 30、如何选择合适的持久化方式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
