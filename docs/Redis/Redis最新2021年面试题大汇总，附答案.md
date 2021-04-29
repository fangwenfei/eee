# Redis最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis持久化数据和缓存怎么做扩容？

1. 如果Redis被当做缓存使用，使用一致性哈希实现动态扩容缩容。
2. 如果Redis被当做一个持久化存储使用，必须使用固定的keys-to-nodes映射关系，节点的数量一旦确定不能变化。否则的话(即Redis节点需要动态变化的情况），必须使用可以在运行时进行数据再平衡的一套系统，而当前只有Redis集群可以做到这样。


### 2、是否使用过Redis集群，集群的原理是什么？

**1、** Redis Sentinal着眼于高可用，在master宕机时会自动将slave提升为master，继续提供服务。

**2、** Redis Cluster着眼于扩展性，在单个Redis内存不足时，使用Cluster进行分片存储。


### 3、惰性删除

优点：对cpu时间友好，在每次从键空间获取键时进行过期键检查并是否删除，删除目标也仅限当前处理的键，这个策略不会在其他无关的删除任务上花费任何cpu时间。

缺点：对内存不友好，过期键过期也可能不会被删除，导致所占的内存也不会释放。甚至可能会出现内存泄露的现象，当存在很多过期键，而这些过期键又没有被访问到，这会可能导致它们会一直保存在内存中，造成内存泄露。


### 4、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？

Redis内存数据集大小上升到一定大小的时候，就会施行数据淘汰策略。

相关知识：Redis提供6种数据淘汰策略：

**volatile-lru**：从已设置过期时间的数据集（server.db[i].expires）中挑选最近最少使用的数据淘汰

**volatile-ttl**：从已设置过期时间的数据集（server.db[i].expires）中挑选将要过期的数据淘汰

**volatile-random**：从已设置过期时间的数据集（server.db[i].expires）中任意选择数据淘汰

**allkeys-lru**：从数据集（server.db[i].dict）中挑选最近最少使用的数据淘汰

**allkeys-random**：从数据集（server.db[i].dict）中任意选择数据淘汰

**no-enviction（驱逐）**：禁止驱逐数据


### 5、什么是Redis?

Redis 是一个基于内存的高性能key-value数据库。


### 6、为什么需要持久化？

由于Redis是一种内存型数据库，即服务器在运行时，系统为其分配了一部分内存存储数据，一旦服务器挂了，或者突然宕机了，那么数据库里面的数据将会丢失，为了使服务器即使突然关机也能保存数据，必须通过持久化的方式将数据从内存保存到磁盘中。


### 7、AOF常用配置总结

下面是AOF常用的配置项，以及默认值；前面介绍过的这里不再详细介绍。

**1、** appendonly no：是否开启AOF

**2、** appendfilename "appendonly.aof"：AOF文件名

**3、** dir ./：RDB文件和AOF文件所在目录

**4、** appendfsync everysec：fsync持久化策略

**5、** no-appendfsync-on-rewrite no：AOF重写期间是否禁止fsync；如果开启该选项，可以减轻文件重写时CPU和硬盘的负载（尤其是硬盘），但是可能会丢失AOF重写期间的数据；需要在负载和安全性之间进行平衡

**6、** auto-aof-rewrite-percentage 100：文件重写触发条件之一

**7、** auto-aof-rewrite-min-size 64mb：文件重写触发提交之一

**8、** aof-load-truncated yes：如果AOF文件结尾损坏，Redis启动时是否仍载入AOF文件


### 8、Redis的数据类型？

Redis支持五种数据类型：string（字符串），hash（哈希），list（列表），set（集合）及zsetsorted set：有序集合)。

我们实际项目中比较常用的是string，hash如果你是Redis中高级用户，还需要加上下面几种数据结构HyperLogLog、Geo、Pub/Sub。

如果你说还玩过Redis Module，像BloomFilter，RedisSearch，Redis-ML，面试官得眼睛就开始发亮了。


### 9、WATCH命令和基于CAS的乐观锁：

在Redis的事务中，WATCH命令可用于提供CAS(check-and-set)功能。假设我们通过WATCH命令在事务执行之前监控了多个Keys，倘若在WATCH之后有任何Key的值发生了变化，EXEC命令执行的事务都将被放弃，同时返回Null multi-bulk应答以通知调用者事务

执行失败。例如，我们再次假设Redis中并未提供incr命令来完成键值的原子性递增，如果要实现该功能，我们只能自行编写相应的代码。其伪码如下：

```
val = GET mykey
val = val + 1
SET mykey $val
```

以上代码只有在单连接的情况下才可以保证执行结果是正确的，因为如果在同一时刻有多个客户端在同时执行该段代码，那么就会出现多线程程序中经常出现的一种错误场景--竞态争用(race condition)。

比如，客户端A和B都在同一时刻读取了mykey的原有值，假设该值为10，此后两个客户端又均将该值加一后set回Redis服务器，这样就会导致mykey的结果为11，而不是我们认为的12。为了解决类似的问题，我们需要借助WATCH命令的帮助，见如下代码：

```
WATCH mykey
val = GET mykey
val = val + 1
MULTI
SET mykey $val
EXEC
```

和此前代码不同的是，新代码在获取mykey的值之前先通过WATCH命令监控了该键，此后又将set命令包围在事务中，这样就可以有效的保证每个连接在执行EXEC之前，如果当前连接获取的mykey的值被其它连接的客户端修改，那么当前连接的EXEC命令将执行失败。这样调用者在判断返回值后就可以获悉val是否被重新设置成功。


### 10、读写分离模型

通过增加Slave DB的数量，读的性能可以线性增长。为了避免Master DB的单点故障，集群一般都会采用两台Master DB做双机热备，所以整个集群的读和写的可用性都非常高。读写分离架构的缺陷在于，不管是Master还是Slave，每个节点都必须保存完整的数据，如果在数据量很大的情况下，集群的扩展能力还是受限于单个节点的存储能力，而且对于Write-intensive类型的应用，读写分离架构并不适合。


### 11、是否使用过 Redis 集群，集群的原理是什么？
### 12、Redis相比Memcached有哪些优势？
### 13、Redis持久化的几种方式
### 14、Redis 的主从复制
### 15、Redis有哪些适合的场景？
### 16、Twemproxy是什么？
### 17、如何实现集群中的 session 共享存储？
### 18、Redis 常见性能问题和解决方案：
### 19、Redis如何设置密码及验证密码？
### 20、Pipeline 有什么好处，为什么要用pipeline？
### 21、Redis的持久化机制是什么？各自的优缺点？
### 22、使用过 Redis 分布式锁么，它是什么回事？
### 23、Redis key的过期时间和永久有效分别怎么设置？
### 24、Redis有哪些适合的场景？
### 25、Redis的内存占用情况怎么样？
### 26、Redis和Redisson有什么关系？
### 27、后端开发群：943918498
### 28、Redis常见性能问题和解决方案：
### 29、Redis分布式




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
