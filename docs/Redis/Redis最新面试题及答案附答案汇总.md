# Redis最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis持久化的几种方式

**1、** 快照（snapshots）

缺省情况情况下，Redis把数据快照存放在磁盘上的二进制文件中，文件名为dump.rdb。你可以配置Redis的持久化策略，例如数据集中每N秒钟有超过M次更新，就将数据写入磁盘；或者你可以手工调用命令SAVE或BGSAVE。

**工作原理**

1. Redis forks.
2. 子进程开始将数据写到临时RDB文件中。
3. 当子进程完成写RDB文件，用新文件替换老文件。
4. 这种方式可以使Redis使用copy-on-write技术。

**2、** AOF

快照模式并不十分健壮，当系统停止，或者无意中Redis被kill掉，最后写入Redis的数据就会丢失。

这对某些应用也许不是大问题，但对于要求高可靠性的应用来说，Redis就不是一个合适的选择。Append-only文件模式是另一种选择。你可以在配置文件中打开AOF模式

**3、** 虚拟内存方式

当你的key很小而value很大时,使用VM的效果会比较好.因为这样节约的内存比较大.

当你的key不小时,可以考虑使用一些非常方法将很大的key变成很大的value,比如你可以考虑将key,value组合成一个新的value.

vm-max-threads这个参数,可以设置访问swap文件的线程数,设置最好不要超过机器的核数,如果设置为0,那么所有对swap文件的操作都是串行的.可能会造成比较长时间的延迟,但是对数据完整性有很好的保证.

自己测试的时候发现用虚拟内存性能也不错。如果数据量很大，可以考虑分布式或者其他数据库。


### 2、Redis事务相关的命令有哪几个？

MULTI、EXEC、DISCARD、WATCH


### 3、Redis 回收进程如何工作的?

一个客户端运行了新的命令， 添加了新的数据。Redi 检查内存使用情况， 如果大于 maxmemory 的限制, 则根据设定好的策略进行回收。一个新的命令被执行， 等等。所以我们不断地穿越内存限制的边界， 通过不断达到边界然后不断地回收回到边界以下。如果一个命令的结果导致大量内存被使用（ 例如很大的集合的交集保存到一个新的键）， 不用多久内存限制就会被这个内存使用量超越。


### 4、Redis与Memcached相比有哪些优势？

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据Redis可以持久化其数据


### 5、使用Redis有哪些好处？

**1、** 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O1)

**2、** 支持丰富数据类型，支持string，list，set，Zset，hash等

**3、** 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除


### 6、Reids工具命令

```
#Redis-server：Redis 服务器的 daemon 启动程序
#Redis-cli：Redis 命令行操作工具。当然，你也可以用 telnet 根据其纯文本协议来操作
#Redis-benchmark：Redis 性能测试工具，测试 Redis 在你的系统及你的配置下的读写性能
$Redis-benchmark -n 100000 –c 50
#模拟同时由 50 个客户端发送 100000 个 SETs/GETs 查询
#Redis-check-aof：更新日志检查
#Redis-check-dump：本地数据库检查
```


### 7、Redis相比Memcached有哪些优势：

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据


### 8、使用过Redis做异步队列么，你是怎么用的？

一般使用list结构作为队列，rpush生产消息，lpop消费消息。当lpop没有消息的时候，要适当sleep一会再重试。

**如果对方追问可不可以不用sleep呢？**

list还有个指令叫blpop，在没有消息的时候，它会阻塞住直到消息到来。如果对方追问能不能生产一次消费多次呢？使用pub/sub主题订阅者模式，可以实现1:N的消息队列。

**如果对方追问pub/sub有什么缺点？**

在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如RabbitMQ等。

**如果对方追问Redis如何实现延时队列？**

我估计现在你很想把面试官一棒打死如果你手上有一根棒球棍的话，怎么问的这么详细。但是你很克制，然后神态自若的回答道：使用sortedset，拿时间戳作为score，消息内容作为key调用zadd来生产消息，消费者用zrangebyscore指令获取N秒之前的数据轮询进行处理。到这里，面试官暗地里已经对你竖起了大拇指。但是他不知道的是此刻你却竖起了中指，在椅子背后。


### 9、缓存和数据库间数据一致性问题

分布式环境下（单机就不用说了）非常容易出现缓存和数据库间的数据一致性问题，针对这一点的话，只能说，如果你的项目对缓存的要求是强一致性的，那么请不要使用缓存。我们只能采取合适的策略来降低缓存和数据库间数据不一致的概率，而无法保证两者间的强一致性。合适的策略包括 合适的缓存更新策略，更新数据库后要及时更新缓存、缓存失败时增加重试机制，例如MQ模式的消息队列。


### 10、都有哪些办法可以降低 Redis 的内存使用情况呢?

如果你使用的是 32 位的 Redis 实例，可以好好利用 Hash,list,sorted set,set 等集合类型数据， 因为通常情况下很多小的 Key-Value 可以用更紧凑的方式存放到一起。


### 11、Memcached 与Redis 的区别？
### 12、Redis常见性能问题和解决方案：
### 13、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？
### 14、Redis的全称是什么？
### 15、如果有大量的 key 需要设置同一时间过期，一般需要注意什么？
### 16、Redis对象有5种类型
### 17、Redis过期键的删除策略？
### 18、Redis的并发竞争问题如何解决?
### 19、Redis 的主从复制
### 20、请用Redis和任意语言实现一段恶意登录保护的代码，
### 21、什么是Redis?
### 22、Redis持久化数据和缓存怎么做扩容？
### 23、定时删除
### 24、Redis还提供的高级工具
### 25、Redis集群方案应该怎么做？都有哪些方案？
### 26、Redis中海量数据的正确操作方式
### 27、Redis回收进程如何工作的？
### 28、Jedis 与 Redisson 对比有什么优缺点？
### 29、多节点 Redis 分布式锁：Redlock 算法




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
