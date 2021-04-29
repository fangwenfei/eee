# Redis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、使用Redis有哪些好处？

**1、** 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O1)

**2、** 支持丰富数据类型，支持string，list，set，Zset，hash等

**3、** 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除


### 2、查看Redis使用情况及状态信息用什么命令？

info


### 3、Redis 集群会有写操作丢失吗？为什么？

Redis 并不能保证数据的强一致性，这意味这在实际中集群在特定的条件下可能会丢失写操作。


### 4、一个 Redis 实例最多能存放多少的 keys？List、Set、Sorted Set 他们最多能存放多少元素?

理论上 Redis 可以处理多达 232 的 keys，并且在实际中进行了测试，每个实例至少存放了 2 亿 5 千万的 keys。我们正在测试一些较大的值。任何 list、set、和 sorted set 都可以放 232 个元素。换句话说， Redis 的存储极限是系统中的可用内存值。


### 5、定时删除

优点：对内存友好，定时删除策略可以保证过期键会尽可能快地被删除，并释放国期间所占用的内存

缺点：对cpu时间不友好，在过期键比较多时，删除任务会占用很大一部分cpu时间，在内存不紧张但cpu时间紧张的情况下，将cpu时间用在删除和当前任务无关的过期键上，影响服务器的响应时间和吞吐量


### 6、多节点 Redis 分布式锁：Redlock 算法

获取当前时间（start）。

依次向 N 个 `Redis`节点请求锁。请求锁的方式与从单节点 `Redis`获取锁的方式一致。为了保证在某个 `Redis`节点不可用时该算法能够继续运行，获取锁的操作都需要设置超时时间，需要保证该超时时间远小于锁的有效时间。这样才能保证客户端在向某个 `Redis`节点获取锁失败之后，可以立刻尝试下一个节点。

计算获取锁的过程总共消耗多长时间（consumeTime = end - start）。如果客户端从大多数 `Redis`节点（>= N/2 + 1) 成功获取锁，并且获取锁总时长没有超过锁的有效时间，这种情况下，客户端会认为获取锁成功，否则，获取锁失败。

如果最终获取锁成功，锁的有效时间应该重新设置为锁最初的有效时间减去 `consumeTime`。

如果最终获取锁失败，客户端应该立刻向所有 `Redis`节点发起释放锁的请求。


### 7、为什么Redis需要把所有数据放到内存中？

Redis为了达到最快的读写速度将数据都读到内存中，并通过异步的方式将数据写入磁盘。

所以Redis具有快速和数据持久化的特征，如果不将数据放在内存中，磁盘I/O速度为严重影响Redis的性能。

在内存越来越便宜的今天，Redis将会越来越受欢迎， 如果设置了最大使用的内存，则数据已有记录数达到内存限值后不能继续插入新值。


### 8、使用过Redis做异步队列么，你是怎么用的？

一般使用list结构作为队列，rpush生产消息，lpop消费消息。当lpop没有消息的时候，要适当sleep一会再重试。

**如果对方追问可不可以不用sleep呢？**

list还有个指令叫blpop，在没有消息的时候，它会阻塞住直到消息到来。如果对方追问能不能生产一次消费多次呢？使用pub/sub主题订阅者模式，可以实现1:N的消息队列。

**如果对方追问pub/sub有什么缺点？**

在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如RabbitMQ等。

**如果对方追问Redis如何实现延时队列？**

我估计现在你很想把面试官一棒打死如果你手上有一根棒球棍的话，怎么问的这么详细。但是你很克制，然后神态自若的回答道：使用sortedset，拿时间戳作为score，消息内容作为key调用zadd来生产消息，消费者用zrangebyscore指令获取N秒之前的数据轮询进行处理。到这里，面试官暗地里已经对你竖起了大拇指。但是他不知道的是此刻你却竖起了中指，在椅子背后。


### 9、手写一个 LRU 算法

```
class LRUCache<K, V> extends LinkedHashMap<K, V> {
    private final int CACHE_SIZE;

    /**
     * 传递进来最多能缓存多少数据
     *
     * @param cacheSize 缓存大小
     */
    public LRUCache(int cacheSize) {
        // true 表示让 linkedHashMap 按照访问顺序来进行排序，最近访问的放在头部，最老访问的放在尾部。
        super((int) Math.ceil(cacheSize / 0.75) + 1, 0.75f, true);
        CACHE_SIZE = cacheSize;
    }

    @Override
    protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
        // 当 map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据。
        return size() > CACHE_SIZE;
    }
}
```


### 10、缓存和数据库间数据一致性问题

分布式环境下（单机就不用说了）非常容易出现缓存和数据库间的数据一致性问题，针对这一点的话，只能说，如果你的项目对缓存的要求是强一致性的，那么请不要使用缓存。我们只能采取合适的策略来降低缓存和数据库间数据不一致的概率，而无法保证两者间的强一致性。合适的策略包括 合适的缓存更新策略，更新数据库后要及时更新缓存、缓存失败时增加重试机制，例如MQ模式的消息队列。


### 11、Redis的回收策略（淘汰策略）?
### 12、Redis过期键的删除策略？
### 13、Redis 到底是怎么实现“附近的人”
### 14、Redis集群方案应该怎么做？都有哪些方案？
### 15、Redis 支持的Java 客户端都有哪些？官方推荐用哪个？
### 16、定期删除
### 17、Redis 相比Memcached 有哪些优势？
### 18、Redis哨兵
### 19、Redis与Memcached相比有哪些优势？
### 20、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？
### 21、Reids主从复制
### 22、为什么Redis是单线程的？
### 23、Redis 开启AOF
### 24、Redis前端启动命令
### 25、Reids常用5种数据类型
### 26、Redis是单进程单线程的？
### 27、为什么 edis 需要把所有数据放到内存中？
### 28、Redis做异步队列
### 29、Redis如何做大量数据插入？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
