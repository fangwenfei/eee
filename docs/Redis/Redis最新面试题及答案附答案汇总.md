# Redis最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、Redis还提供的高级工具

像慢查询分析、性能测试、Pipeline、事务、Lua自定义命令、Bitmaps、HyperLogLog、/订阅、Geo等个性化功能。


### 2、Redis回收进程如何工作的？

**1、** 一个客户端运行了新的命令，添加了新的数据。

**2、** Redi检查内存使用情况，如果大于maxmemory的限制, 则根据设定好的策略进行回收。

**3、** 一个新的命令被执行，等等。

**4、** 所以我们不断地穿越内存限制的边界，通过不断达到边界然后不断地回收回到边界以下。

如果一个命令的结果导致大量内存被使用（例如很大的集合的交集保存到一个新的键），不用多久内存限制就会被这个内存使用量超越。


### 3、Redis 如何做内存优化？

尽可能使用散列表（ hashes）， 散列表（ 是说散列表里面存储的数少） 使用的内存非常小， 所以你应该尽可能的将你的数据模型抽象到一个散列表里面。比如你的 web 系统中有一个用户对象， 不要为这个用户的名称， 姓氏， 邮箱， 密码设置单独的 key,而是应该把这个用户的所有信息存储到一张散列表里面. 更多面试题关注微信公众号：Java2B


### 4、都有哪些办法可以降低Redis的内存使用情况呢？

如果你使用的是32位的Redis实例，可以好好利用Hash,list,sorted set,set等集合类型数据，因为通常情况下很多小的Key-Value可以用更紧凑的方式存放到一起。


### 5、Redis回收使用的是什么算法？

LRU算法


### 6、Redis回收进程如何工作的？

一个客户端运行了新的命令，添加了新的数据。Redi检查内存使用情况，如果大于maxmemory的限制, 则根据设定好的策略进行回收。一个新的命令被执行，等等。所以我们不断地穿越内存限制的边界，通过不断达到边界然后不断地回收回到边界以下。如果一个命令的结果导致大量内存被使用（例如很大的集合的交集保存到一个新的键），不用多久内存限制就会被这个内存使用量超越。


### 7、定时删除

优点：对内存友好，定时删除策略可以保证过期键会尽可能快地被删除，并释放国期间所占用的内存

缺点：对cpu时间不友好，在过期键比较多时，删除任务会占用很大一部分cpu时间，在内存不紧张但cpu时间紧张的情况下，将cpu时间用在删除和当前任务无关的过期键上，影响服务器的响应时间和吞吐量


### 8、布隆过滤器

bloomfilter就类似于一个hash set，用于快速判某个元素是否存在于集合中，其典型的应用场景就是快速判断一个key是否存在于某容器，不存在就直接返回。布隆过滤器的关键就在于hash算法和容器大小


### 9、Redis是单进程单线程的

Redis利用队列技术将并发访问变为串行访问，消除了传统数据库串行控制的开销


### 10、支持一致性哈希的客户端有哪些？

Redis-rb、PRedis等。


### 11、Redis分布式
### 12、是否使用过 Redis 集群，集群的原理是什么？
### 13、Redis 的主从复制
### 14、AOF常用配置总结
### 15、Reids工具命令
### 16、Redis集群会有写操作丢失吗？为什么？
### 17、Redis分布式锁实现
### 18、如何选择合适的持久化方式？
### 19、Redis 最适合的场景
### 20、Redis有哪几种数据淘汰策略？
### 21、分布式Redis是前期做还是后期规模上来了再做好？为什么？
### 22、Redis 集群方案什么情况下会导致整个集群不可用？
### 23、Reids主从复制
### 24、Redis 管道 Pipeline
### 25、Redis 事务相关的命令有哪几个？
### 26、Redis支持的Java客户端都有哪些？官方推荐用哪个？
### 27、使用过Redis分布式锁么，它是什么回事？
### 28、Redis分区有什么缺点？
### 29、说说 Redis 哈希槽的概念？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
