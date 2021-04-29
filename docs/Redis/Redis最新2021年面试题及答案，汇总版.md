# Redis最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如果有大量的 key 需要设置同一时间过期，一般需要注意什么？

如果大量的 key 过期时间设置的过于集中，到过期的那个时间点，Redis 可能会出现短暂的卡顿现象。一般需要在时间上加一个随机值， 使得过期时间分散一些。


### 2、你知道有哪些Redis分区实现方案？

客户端分区就是在客户端就已经决定数据会被存储到哪个Redis节点或者从哪个Redis节点读取。大多数客户端已经实现了客户端分区。

代理分区 意味着客户端将请求发送给代理，然后代理决定去哪个节点写数据或者读数据。代理根据分区规则决定请求哪些Redis实例，然后根据Redis的响应结果返回给客户端。Redis和Memcached的一种代理实现就是Twemproxy

查询路由(Query routing) 的意思是客户端随机地请求任意一个Redis实例，然后由Redis将请求转发给正确的Redis节点。Redis Cluster实现了一种混合形式的查询路由，但并不是直接将请求从一个Redis节点转发到另一个Redis节点，而是在客户端的帮助下直接redirected到正确的Redis节点。


### 3、Redis的并发竞争问题如何解决?

Redis为单进程单线程模式，采用队列模式将并发访问变为串行访问。Redis本身没有锁的概念，Redis对于多个客户端连接并不存在竞争，但是在Jedis客户端对Redis进行并发访问时会发生连接超时、数据转换错误、阻塞、客户端关闭连接等问题，这些问题均是由于客户端连接混乱造成。

**对此有2种解决方法：**

**1、** 客户端角度，为保证每个客户端间正常有序与Redis进行通信，对连接进行池化，同时对客户端读写Redis操作采用内部锁synchronized。

**2、** 服务器角度，利用setnx实现锁。

_注：对于第一种，需要应用程序自己处理资源的同步，可以使用的方法比较通俗，可以使用synchronized也可以使用lock；第二种需要用到Redis的setnx命令，但是需要注意一些问题。_


### 4、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？

理论上Redis可以处理多达232的keys，并且在实际中进行了测试，每个实例至少存放了2亿5千万的keys。我们正在测试一些较大的值。

任何list、set、和sorted set都可以放232个元素。

换句话说，Redis的存储极限是系统中的可用内存值。


### 5、Redis 持久化方案：

Rdb 和 Aof


### 6、内存碎片

内存碎片是Redis在分配、回收物理内存过程中产生的。例如，如果对数据的更改频繁，而且数据之间的大小相差很大，可能导致Redis释放的空间在物理内存中并没有释放，但Redis又无法有效利用，这就形成了内存碎片。内存碎片不会统计在used_memory中。


### 7、Redis是单进程单线程的

Redis利用队列技术将并发访问变为串行访问，消除了传统数据库串行控制的开销


### 8、什么是Redis？简述它的优缺点？

Redis的全称是：Remote Dictionary.Server，本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。

另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。 Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 9、使用过Redis分布式锁么，它是什么回事？

先拿setnx来争抢锁，抢到之后，再用expire给锁加一个过期时间防止锁忘记了释放。

这时候对方会告诉你说你回答得不错，然后接着问如果在setnx之后执行expire之前进程意外crash或者要重启维护了，那会怎么样？

这时候你要给予惊讶的反馈：唉，是喔，这个锁就永远得不到释放了。紧接着你需要抓一抓自己得脑袋，故作思考片刻，好像接下来的结果是你主动思考出来的，然后回我记得set指令有非常复杂的参数，这个应该是可以同时把setnx和expire合成一条指令来用的！对方这时会显露笑容，心里开始默念：摁，这小子还不错。


### 10、mySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据

_相关知识：Redis 内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略（回收策略）。_


### 11、布隆过滤器
### 12、Redis支持的Java客户端都有哪些？官方推荐用哪个？
### 13、为什么Redis需要把所有数据放到内存中？
### 14、Redis集群之间是如何复制的？
### 15、Redis集群最大节点个数是多少？
### 16、支持一致性哈希的客户端有哪些？
### 17、MySQL里有2000w数据，Redis中只存20w的数据
### 18、Reids工具命令
### 19、缓冲内存
### 20、持久化策略选择
### 21、Redis分区有什么缺点？
### 22、微信公众号：Java资讯库，回复“架构”
### 23、Jedis 与 Redisson 对比有什么优缺点？
### 24、Reids持久化触发条件
### 25、Redis 是单进程单线程的？
### 26、Redis 中设置过期时间主要通过以下四种方式
### 27、Redis提供了哪几种持久化方式？
### 28、什么是Redis?
### 29、Memcache 与Redis 的区别都有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
