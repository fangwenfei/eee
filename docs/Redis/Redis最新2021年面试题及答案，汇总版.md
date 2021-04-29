# Redis最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、使用过Redis做异步队列么，你是怎么用的？

一般使用list结构作为队列，rpush生产消息，lpop消费消息。当lpop没有消息的时候，要适当sleep一会再重试。

**如果对方追问可不可以不用sleep呢？**

list还有个指令叫blpop，在没有消息的时候，它会阻塞住直到消息到来。如果对方追问能不能生产一次消费多次呢？使用pub/sub主题订阅者模式，可以实现1:N的消息队列。

**如果对方追问pub/sub有什么缺点？**

在消费者下线的情况下，生产的消息会丢失，得使用专业的消息队列如RabbitMQ等。

**如果对方追问Redis如何实现延时队列？**

我估计现在你很想把面试官一棒打死如果你手上有一根棒球棍的话，怎么问的这么详细。但是你很克制，然后神态自若的回答道：使用sortedset，拿时间戳作为score，消息内容作为key调用zadd来生产消息，消费者用zrangebyscore指令获取N秒之前的数据轮询进行处理。到这里，面试官暗地里已经对你竖起了大拇指。但是他不知道的是此刻你却竖起了中指，在椅子背后。


### 2、都有哪些办法可以降低Redis的内存使用情况呢？

如果你使用的是32位的Redis实例，可以好好利用Hash,list,sorted set,set等集合类型数据，因为通常情况下很多小的Key-Value可以用更紧凑的方式存放到一起。


### 3、为什么需要持久化？

由于Redis是一种内存型数据库，即服务器在运行时，系统为其分配了一部分内存存储数据，一旦服务器挂了，或者突然宕机了，那么数据库里面的数据将会丢失，为了使服务器即使突然关机也能保存数据，必须通过持久化的方式将数据从内存保存到磁盘中。


### 4、Redis 管道 Pipeline

在某些场景下我们在**一次操作中可能需要执行多个命令**，而如果我们只是一个命令一个命令去执行则会浪费很多网络消耗时间，如果将命令一次性传输到 `Redis`中去再执行，则会减少很多开销时间。但是需要注意的是 `pipeline`中的命令并不是原子性执行的，也就是说管道中的命令到达 `Redis`服务器的时候可能会被其他的命令穿插


### 5、一个 Redis 实例最多能存放多少的 keys？List、Set、Sorted Set 他们最多能存放多少元素?

理论上 Redis 可以处理多达 232 的 keys，并且在实际中进行了测试，每个实例至少存放了 2 亿 5 千万的 keys。我们正在测试一些较大的值。任何 list、set、和 sorted set 都可以放 232 个元素。换句话说， Redis 的存储极限是系统中的可用内存值。


### 6、缓存并发问题

这里的并发指的是多个Redis的client同时set key引起的并发问题。比较有效的解决方案就是把Redis.set操作放在队列中使其串行化，必须的一个一个执行，具体的代码就不上了，当然加锁也是可以的，至于为什么不用Redis中的事务，留给各位看官自己思考探究。


### 7、Redis集群如何选择数据库？

Redis集群目前无法做数据库选择，默认在0数据库。


### 8、Redis分布式
### 9、Redis支持哪几种数据类型？
### 10、Redis 常见性能问题和解决方案：
### 11、Redis中海量数据的正确操作方式
### 12、，免费领取架构资料。
### 13、是否使用过 Redis 集群，集群的原理是什么？
### 14、Redis常用管理命令
### 15、Redis的同步机制了解么？
### 16、持久化策略选择
### 17、Redis 支持的Java 客户端都有哪些？官方推荐用哪个？
### 18、mySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据
### 19、Pipeline有什么好处，为什么要用pipeline？
### 20、怎么理解Redis事务？
### 21、Redis key 的过期时间和永久有效分别怎么设置？
### 22、Pipeline 有什么好处，为什么要用pipeline？
### 23、缓冲内存
### 24、为什么Redis需要把所有数据放到内存中?
### 25、Redis相比Memcached有哪些优势？
### 26、SCAN系列命令注意事项
### 27、判断key是否存在
### 28、惰性删除
### 29、为什么Redis需要把所有数据放到内存中？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
