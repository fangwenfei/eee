# Redis最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Memcached 与Redis 的区别？

**1、** Redis 不仅仅支持简单的 k/v 类型的数据，同时还提供 list，set，zset， hash 等数据结构的存储。而 memcache 只支持简单数据类型，需要客户端自己处理复杂对象

**2、** Redis 支持数据的持久化， 可以将内存中的数据保持在磁盘中， 重启的时候可以再次加载进行使用（ PS： 持久化在 rdb、aof）。


### 2、Redis相比Memcached有哪些优势？

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据


### 3、Redis集群方案应该怎么做？都有哪些方案？

**1、** codis

**2、** 目前用的最多的集群方案，基本和twemproxy一致的效果，但它支持在节点数量改变情况下，旧节点数据可恢复到新hash节点。 Redis cluster3.0自带的集群，特点在于他的分布式算法不是一致性hash，而是hash槽的概念，以及自身支持节点设置从节点。具体看官方文档介绍。

**3、** 在业务代码层实现，起几个毫无关联的Redis实例，在代码层，对key进行hash计算，然后去对应的Redis实例操作数据。这种方式对hash层代码要求比较高，考虑部分包括，节点失效后的替代算法方案，数据震荡后的自动脚本恢复，实例的监控，等等。


### 4、假如 Redis 里面有 1 亿个key，其中有 10w 个key 是以某个固定的已知的前缀开头的，如果将它们全部找出来？

使用 keys 指令可以扫出指定模式的 key 列表。

对方接着追问： 如果这个 Redis 正在给线上的业务提供服务， 那使用 keys 指令会有什么问题？

这个时候你要回答 Redis 关键的一个特性：Redis 的单线程的。keys 指令会导致线程阻塞一段时间， 线上服务会停顿， 直到指令执行完毕， 服务才能恢复。这个时候可以使用 scan 指令， scan 指令可以无阻塞的提取出指定模式的 key 列表， 但是会有一定的重复概率， 在客户端做一次去重就可以了， 但是整体所花费的时间会比直接用 keys 指令长。


### 5、Reids支持的语言：

java、C、C#、C++、php、Node.js、Go等。


### 6、Redis主要消耗什么物理资源？

内存。


### 7、Redis中的管道有什么用？

一次请求/响应服务器能实现处理新的请求即使旧的请求还未被响应，这样就可以将多个命令发送到服务器，而不用等待回复，最后在一个步骤中读取该答复。

这就是管道（pipelining），是一种几十年来广泛使用的技术。例如许多POP3协议已经实现支持这个功能，大大加快了从服务器下载新邮件的过程。


### 8、Redis支持哪几种数据类型？

String、List、Set、Sorted Set、hashes


### 9、Reids6种淘汰策略：

**noeviction**: 不删除策略, 达到最大内存限制时, 如果需要更多内存, 直接返回错误信息。大多数写命令都会导致占用更多的内存(有极少数会例外。

**allkeys-lru:**所有key通用; 优先删除最近最少使用(less recently used ,LRU) 的 key。

**volatile-lru:**只限于设置了 expire 的部分; 优先删除最近最少使用(less recently used ,LRU) 的 key。

**allkeys-random:**所有key通用; 随机删除一部分 key。

**volatile-random**: 只限于设置了 **expire** 的部分; 随机删除一部分 key。

**volatile-ttl**: 只限于设置了 **expire** 的部分; 优先删除剩余时间(time to live,TTL) 短的key。


### 10、为什么要做Redis分区？

分区可以让Redis管理更大的内存，Redis将可以使用所有机器的内存。如果没有分区，你最多只能使用一台机器的内存。分区使Redis的计算能力通过简单地增加计算机得到成倍提升,Redis的网络带宽也会随着计算机和网卡的增加而成倍增长。


### 11、Redis集群方案应该怎么做？都有哪些方案？
### 12、Redis与其他key-value存储有什么不同？
### 13、Redis回收进程如何工作的？
### 14、Redis 的数据类型？
### 15、怎么理解Redis事务？
### 16、Redis 最适合的场景
### 17、，或是关注
### 18、Redis常见性能问题和解决方案：
### 19、Redis的内存用完了会发生什么？
### 20、RDB和AOF的优缺点
### 21、Redis的缓存失效策略和主键失效机制
### 22、Redis最适合的场景？
### 23、Redis事务相关的命令有哪几个？
### 24、Redis回收使用的是什么算法？
### 25、使用Redis 有哪些好处？
### 26、Jedis与Redisson对比有什么优缺点？
### 27、使用过 Redis 做异步队列么，你是怎么用的？
### 28、Redis 集群的主从复制模型是怎样的？
### 29、Redis 的持久化机制是什么？各自的优缺点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
