# Redis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Reids持久化触发条件

RDB持久化的触发分为手动触发和自动触发两种。


### 2、Redis常见性能问题和解决方案：

**1、** Master最好不要写内存快照，如果Master写内存快照，save命令调度rdbSave函数，会阻塞主线程的工作，当快照比较大时对性能影响是非常大的，会间断性暂停服务

**2、** 如果数据比较重要，某个Slave开启AOF备份数据，策略设置为每秒同步一

**3、** 为了主从复制的速度和连接的稳定性，Master和Slave最好在同一个局域网

**4、** 尽量避免在压力很大的主库上增加从

**5、** 主从复制不要用图状结构，用单向链表结构更为稳定，即：Master <- Slave1 <- Slave2 <- Slave3…这样的结构方便解决单点故障问题，实现Slave对Master的替换。如果Master挂了，可以立刻启用Slave1做Master，其他不变。


### 3、缓存并发问题

这里的并发指的是多个Redis的client同时set key引起的并发问题。比较有效的解决方案就是把Redis.set操作放在队列中使其串行化，必须的一个一个执行，具体的代码就不上了，当然加锁也是可以的，至于为什么不用Redis中的事务，留给各位看官自己思考探究。


### 4、使用Redis有哪些好处？

**1、** 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O(1)

**2、** 支持丰富数据类型，支持string，list，set，sorted set，hash

**3、** 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除


### 5、Redis 开启AOF

Redis服务器默认开启RDB，关闭AOF；要开启AOF，需要在配置文件中配置：

appendonly yes


### 6、使用Redis 有哪些好处？

**1、** 速度快， 因为数据存在内存中， 类似于 HashMap， HashMap 的优势就是查找和操作的时间复杂度都是 O1)

**2、** 支持丰富数据类型， 支持 string， list， set， Zset， hash 等

**3、** 支持事务， 操作都是原子性， 所谓的原子性就是对数据的更改要么全部执行， 要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按 key 设置过期时间，过期后将会自动删除


### 7、Redis支持哪几种数据类型？

String、List、Set、Sorted Set、hashes


### 8、读写分离模型

通过增加Slave DB的数量，读的性能可以线性增长。为了避免Master DB的单点故障，集群一般都会采用两台Master DB做双机热备，所以整个集群的读和写的可用性都非常高。读写分离架构的缺陷在于，不管是Master还是Slave，每个节点都必须保存完整的数据，如果在数据量很大的情况下，集群的扩展能力还是受限于单个节点的存储能力，而且对于Write-intensive类型的应用，读写分离架构并不适合。


### 9、惰性删除

优点：对cpu时间友好，在每次从键空间获取键时进行过期键检查并是否删除，删除目标也仅限当前处理的键，这个策略不会在其他无关的删除任务上花费任何cpu时间。

缺点：对内存不友好，过期键过期也可能不会被删除，导致所占的内存也不会释放。甚至可能会出现内存泄露的现象，当存在很多过期键，而这些过期键又没有被访问到，这会可能导致它们会一直保存在内存中，造成内存泄露。


### 10、Redis内存模型

**used_memory**：Redis分配器分配的内存总量（单位是字节），包括使用的虚拟内存（即swap）；Redis分配器后面会介绍。used_memory_human只是显示更友好。

**used_memory_rss**：Redis进程占据操作系统的内存（单位是字节），与top及ps命令看到的值是一致的；除了分配器分配的内存之外，used_memory_rss还包括进程运行本身需要的内存、内存碎片等，但是不包括虚拟内存。

**mem_fragmentation_ratio**：内存碎片比率，该值是used_memory_rss / used_memory的比值。

**mem_allocator**：Redis使用的内存分配器，在编译时指定；可以是 libc 、jemalloc或者tcmalloc，默认是jemalloc；截图中使用的便是默认的jemalloc。


### 11、Redis提供了哪几种持久化方式？
### 12、为什么Redis需要把所有数据放到内存中？
### 13、Reids支持的语言：
### 14、什么是Redis?
### 15、都有哪些办法可以降低Redis的内存使用情况呢？
### 16、怎么理解Redis事务？
### 17、Pipeline 有什么好处，为什么要用pipeline？
### 18、Reids的特点
### 19、Redis的并发竞争问题如何解决?
### 20、说说Redis哈希槽的概念？
### 21、Redis 的持久化机制是什么？各自的优缺点？
### 22、为什么 edis 需要把所有数据放到内存中？
### 23、是否使用过Redis集群，集群的原理是什么？
### 24、内存碎片
### 25、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？
### 26、Redis 最适合的场景
### 27、假如 Redis 里面有 1 亿个key，其中有 10w 个key 是以某个固定的已知的前缀开头的，如果将它们全部找出来？
### 28、Redis key的过期时间和永久有效分别怎么设置？
### 29、为什么要做Redis分区？
### 30、Redis 最适合的场景？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
