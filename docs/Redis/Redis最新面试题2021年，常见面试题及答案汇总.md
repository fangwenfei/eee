# Redis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis Module 实现布隆过滤器

Redis module 是Redis 4.0 以后支持的新的特性，这里很多国外牛逼的大学和机构提供了很多牛逼的Module 只要编译引入到Redis 中就能轻松的实现我们某些需求的功能。在Redis 官方Module 中有一些我们常见的一些模块，我们在这里就做一个简单的使用。

**1、** neural-Redis 主要是神经网络的机器学，集成到Redis 可以做一些机器训练感兴趣的可以尝试

**2、** RedisSearch 主要支持一些富文本的的搜索

**3、** RedisBloom 支持分布式环境下的Bloom 过滤器


### 2、进程本身运行需要的内存

Redis主进程本身运行肯定需要占用内存，如代码、常量池等等；这部分内存大约几兆，在大多数生产环境中与Redis数据占用的内存相比可以忽略。这部分内存不是由jemalloc分配，因此不会统计在used_memory中。


### 3、假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？

使用keys指令可以扫出指定模式的key列表。

对方接着追问：如果这个Redis正在给线上的业务提供服务，那使用keys指令会有什么问题？

这个时候你要回答Redis关键的一个特性：Redis的单线程的。keys指令会导致线程阻塞一段时间，线上服务会停顿，直到指令执行完毕，服务才能恢复。这个时候可以使用scan指令，scan指令可以无阻塞的提取出指定模式的key列表，但是会有一定的重复概率，在客户端做一次去重就可以了，但是整体所花费的时间会比直接用keys指令长。


### 4、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？

理论上Redis可以处理多达232的keys，并且在实际中进行了测试，每个实例至少存放了2亿5千万的keys。我们正在测试一些较大的值。任何list、set、和sorted set都可以放232个元素。换句话说，Redis的存储极限是系统中的可用内存值。


### 5、都有哪些办法可以降低 Redis 的内存使用情况呢?

如果你使用的是 32 位的 Redis 实例，可以好好利用 Hash,list,sorted set,set 等集合类型数据， 因为通常情况下很多小的 Key-Value 可以用更紧凑的方式存放到一起。


### 6、为什么edis需要把所有数据放到内存中？

Redis为了达到最快的读写速度将数据都读到内存中，并通过异步的方式将数据写入磁盘。所以Redis具有快速和数据持久化的特征。如果不将数据放在内存中，磁盘I/O速度为严重影响Redis的性能。在内存越来越便宜的今天，Redis将会越来越受欢迎。如果设置了最大使用的内存，则数据已有记录数达到内存限值后不能继续插入新值。


### 7、Redis没有直接使用C字符串

(即以空字符’\0’结尾的字符数组)作为默认的字符串表示，而是使用了SDS。SDS是简单动态字符串(Simple Dynamic String)的缩写。


### 8、分布式Redis是前期做还是后期规模上来了再做好？为什么？

既然Redis是如此的轻量（单实例只使用1M内存）,为防止以后的扩容，最好的办法就是一开始就启动较多实例。即便你只有一台服务器，你也可以一开始就让Redis以分布式的方式运行，使用分区，在同一台服务器上启动多个实例。

一开始就多设置几个Redis实例，例如32或者64个实例，对大多数用户来说这操作起来可能比较麻烦，但是从长久来看做这点牺牲是值得的。

这样的话，当你的数据不断增长，需要更多的Redis服务器时，你需要做的就是仅仅将Redis实例从一台服务迁移到另外一台服务器而已（而不用考虑重新分区的问题）。一旦你添加了另一台服务器，你需要将你一半的Redis实例从第一台机器迁移到第二台机器。


### 9、Redis有哪几种数据淘汰策略？

noeviction:返回错误当内存限制达到并且客户端尝试执行会让更多内存被使用的命令（大部分的写入指令，但DEL和几个例外）

allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。

volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。

allkeys-random: 回收随机的键使得新添加的数据有空间存放。

volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。

volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。


### 10、判断key是否存在

exists key +key名字


### 11、Redis的并发竞争问题如何解决?
### 12、都有哪些办法可以降低Redis的内存使用情况呢？
### 13、Redis是单线程
### 14、Redis是单线程的，如何提高多核CPU的利用率？
### 15、Jedis与Redisson对比有什么优缺点？
### 16、Redis有哪几种数据淘汰策略？
### 17、缓存雪崩问题
### 18、什么是Redis？
### 19、Redis常见性能问题和解决方案？
### 20、怎么理解Redis事务？
### 21、Reids三种不同删除策略
### 22、Redis 集群之间是如何复制的？
### 23、Redis回收进程如何工作的？
### 24、Redis key 的过期时间和永久有效分别怎么设置？
### 25、Redis 管道 Pipeline
### 26、Redis 提供 6种数据淘汰策略：
### 27、删除key
### 28、Redis集群最大节点个数是多少？
### 29、怎么测试Redis的连通性？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
