# Redis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Redis有哪几种数据淘汰策略？

**1、** noeviction:返回错误当内存限制达到，并且客户端尝试执行会让更多内存被使用的命令。

**2、** allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。

**3、** volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。

**4、** allkeys-random: 回收随机的键使得新添加的数据有空间存放。

**5、** volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。

**6、** volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。


### 2、Redis如何做大量数据插入？

Redis2.6开始Redis-cli支持一种新的被称之为pipe mode的新模式用于执行大量数据插入工作。


### 3、Redis前端启动命令

./Redis-server


### 4、Redis 开启AOF

Redis服务器默认开启RDB，关闭AOF；要开启AOF，需要在配置文件中配置：

appendonly yes


### 5、Memcache与Redis的区别都有哪些？

**1、** 存储方式 Memecache把数据全部存在内存之中，断电后会挂掉，数据不能超过内存大小。 Redis有部份存在硬盘上，这样能保证数据的持久性。

**2、** 数据支持类型 Memcache对数据类型支持相对简单。 Redis有复杂的数据类型。

**3、** 使用底层模型不同 它们之间底层实现方式 以及与客户端之间通信的应用协议不一样。 Redis直接自己构建了VM 机制 ，因为一般的系统调用系统函数的话，会浪费一定的时间去移动和请求。


### 6、Reids持久化触发条件

RDB持久化的触发分为手动触发和自动触发两种。


### 7、RDB和AOF的优缺点

**RDB持久化**

优点：RDB文件紧凑，体积小，网络传输快，适合全量复制；恢复速度比AOF快很多。当然，与AOF相比，RDB最重要的优点之一是对性能的影响相对较小。

缺点：RDB文件的致命缺点在于其数据快照的持久化方式决定了必然做不到实时持久化，而在数据越来越重要的今天，数据的大量丢失很多时候是无法接受的，因此AOF持久化成为主流。此外，RDB文件需要满足特定格式，兼容性差（如老版本的Redis不兼容新版本的RDB文件）。

**AOF持久化**

与RDB持久化相对应，AOF的优点在于支持秒级持久化、兼容性好，缺点是文件大、恢复速度慢、对性能影响大。


### 8、Redis key 的过期时间和永久有效分别怎么设置？

EXPIRE 和 PERSIST 命令。


### 9、Redis的数据类型？

Redis支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及zsetsorted set：有序集合)。

我们实际项目中比较常用的是string，hash如果你是Redis中高级用户，还需要加上下面几种数据结构HyperLogLog、Geo、Pub/Sub。

如果你说还玩过Redis Module，像BloomFilter，RedisSearch，Redis-ML，面试官得眼睛就开始发亮了。


### 10、使用Redis有哪些好处？

**1、** 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O1)

**2、** 支持丰富数据类型，支持string，list，set，Zset，hash等

**3、** 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除


### 11、Redis 集群之间是如何复制的？
### 12、WATCH命令和基于CAS的乐观锁：
### 13、Redis相比Memcached有哪些优势？
### 14、Redis 是单进程单线程的？
### 15、Redis与Memcached相比有哪些优势？
### 16、Redis 集群如何选择数据库？
### 17、Redis 最适合的场景？
### 18、Redis如何设置密码及验证密码？
### 19、Redis是单进程单线程的？
### 20、Redis过期键的删除策略？
### 21、Pipeline 有什么好处，为什么要用pipeline？
### 22、Redis做异步队列
### 23、Redis回收进程如何工作的？
### 24、Redis和Redisson有什么关系？
### 25、为什么edis需要把所有数据放到内存中？
### 26、Redis官方为什么不提供Windows版本？
### 27、缓存雪崩问题
### 28、MySQL 里有 2000w 数据，Redis 中只存 20w 的数据，如何保证Redis 中的数据都是热点数据？
### 29、Redis常见性能问题和解决方案：
### 30、缓存并发问题




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
