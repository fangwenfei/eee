# Redis最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Redis 的回收策略（淘汰策略）

volatile-lru：从已设置过期时间的数据集（ server.db[i].expires）中挑选最近最少使用的数据淘汰

volatile-ttl： 从已设置过期时间的数据集（ server.db[i].expires） 中挑选将要过期的数据淘汰

volatile-random： 从已设置过期时间的数据集（ server.db[i].expires） 中任意选择数据淘汰

allkeys-lru： 从数据集（ server.db[i].dict） 中挑选最近最少使用的数据淘汰

allkeys-random： 从数据集（ server.db[i].dict） 中任意选择数据淘汰

no-enviction（ 驱逐） ： 禁止驱逐数据

注意这里的 6 种机制，volatile 和 allkeys 规定了是对已设置过期时间的数据集淘汰数据还是从全部数据集淘汰数据， 后面的 lru、ttl 以及 random 是三种不同的淘汰策略， 再加上一种 no-enviction 永不回收的策略。

使用策略规则：

**1、** 如果数据呈现幂律分布，也就是一部分数据访问频率高，一部分数据访问频率   低， 则使用 allkeys-lru

**2、** 如果数据呈现平等分布， 也就是所有的数据访问频率都相同， 则使用allkeys-random


### 2、Redis Module 实现布隆过滤器

Redis module 是Redis 4.0 以后支持的新的特性，这里很多国外牛逼的大学和机构提供了很多牛逼的Module 只要编译引入到Redis 中就能轻松的实现我们某些需求的功能。在Redis 官方Module 中有一些我们常见的一些模块，我们在这里就做一个简单的使用。

**1、** neural-Redis 主要是神经网络的机器学，集成到Redis 可以做一些机器训练感兴趣的可以尝试

**2、** RedisSearch 主要支持一些富文本的的搜索

**3、** RedisBloom 支持分布式环境下的Bloom 过滤器


### 3、Redis回收进程如何工作的？

一个客户端运行了新的命令，添加了新的数据。

Redi检查内存使用情况，如果大于maxmemory的限制, 则根据设定好的策略进行回收。

一个新的命令被执行，等等。

所以我们不断地穿越内存限制的边界，通过不断达到边界然后不断地回收回到边界以下。

如果一个命令的结果导致大量内存被使用（例如很大的集合的交集保存到一个新的键），不用多久内存限制就会被这个内存使用量超越。


### 4、怎么理解 Redis 事务？

**1、** 事务是一个单独的隔离操作：   事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中， 不会被其他客户端发送来的命令请求所打断。

**2、** 事务是一个原子操作： 事务中的命令要么全部被执行， 要么全部都不执行。


### 5、Reids的特点

Redis本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。

Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 6、，或是关注
### 7、Redis没有直接使用C字符串

(即以空字符’\0’结尾的字符数组)作为默认的字符串表示，而是使用了SDS。SDS是简单动态字符串(Simple Dynamic String)的缩写。


### 8、Redis事务相关的命令有哪几个？

MULTI、EXEC、DISCARD、WATCH


### 9、修改配置不重启Redis会实时生效吗？

针对运行实例，有许多配置选项可以通过 CONFIG SET 命令进行修改，而无需执行任何形式的重启。 从 Redis 2.2 开始，可以从 AOF 切换到 RDB 的快照持久性或其他方式而不需要重启 Redis。检索 ‘CONFIG GET *’ 命令获取更多信息。

但偶尔重新启动是必须的，如为升级 Redis 程序到新的版本，或者当你需要修改某些目前 CONFIG 命令还不支持的配置参数的时候。


### 10、Redis 的主从复制

持久化保证了即使Redis服务重启也不会丢失数据，因为Redis服务重启后会将硬盘上持久化的数据恢复到内存中，但是当Redis服务器的硬盘损坏了可能会导致数据丢失，如果通过Redis的主从复制机制就可以避免这种单点故障，


### 11、Redis相比Memcached有哪些优势？
### 12、为什么Redis需要把所有数据放到内存中？
### 13、Redis是单线程的，但Redis为什么这么快？
### 14、Redis的内存用完了会发生什么？
### 15、Redis回收使用的是什么算法？
### 16、都有哪些办法可以降低 Redis 的内存使用情况呢?
### 17、Redis是单线程
### 18、Redis 集群之间是如何复制的？
### 19、什么是Redis？简述它的优缺点？
### 20、说说 Redis 哈希槽的概念？
### 21、怎么测试Redis的连通性？
### 22、Reids三种不同删除策略
### 23、mySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据
### 24、Redis的缓存失效策略和主键失效机制
### 25、一个 Redis 实例最多能存放多少的 keys？List、Set、Sorted Set 他们最多能存放多少元素?
### 26、Redis 如何设置密码及验证密码？
### 27、为什么 edis 需要把所有数据放到内存中？
### 28、Memcached 与Redis 的区别？
### 29、为什么Redis需要把所有数据放到内存中？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
