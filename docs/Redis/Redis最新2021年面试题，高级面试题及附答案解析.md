# Redis最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis与Memcached相比有哪些优势？

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据Redis可以持久化其数据


### 2、Redis相比Memcached有哪些优势：

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据


### 3、内存碎片

内存碎片是Redis在分配、回收物理内存过程中产生的。例如，如果对数据的更改频繁，而且数据之间的大小相差很大，可能导致Redis释放的空间在物理内存中并没有释放，但Redis又无法有效利用，这就形成了内存碎片。内存碎片不会统计在used_memory中。


### 4、Redis 如何设置密码及验证密码？

设置密码： config set requirepass 123456 授权密码： auth 123456


### 5、Redis Module 实现布隆过滤器

Redis module 是Redis 4.0 以后支持的新的特性，这里很多国外牛逼的大学和机构提供了很多牛逼的Module 只要编译引入到Redis 中就能轻松的实现我们某些需求的功能。在Redis 官方Module 中有一些我们常见的一些模块，我们在这里就做一个简单的使用。

**1、** neural-Redis 主要是神经网络的机器学，集成到Redis 可以做一些机器训练感兴趣的可以尝试

**2、** RedisSearch 主要支持一些富文本的的搜索

**3、** RedisBloom 支持分布式环境下的Bloom 过滤器


### 6、Redis回收进程如何工作的？

一个客户端运行了新的命令，添加了新的数据。

Redi检查内存使用情况，如果大于maxmemory的限制, 则根据设定好的策略进行回收。

一个新的命令被执行，等等。

所以我们不断地穿越内存限制的边界，通过不断达到边界然后不断地回收回到边界以下。

如果一个命令的结果导致大量内存被使用（例如很大的集合的交集保存到一个新的键），不用多久内存限制就会被这个内存使用量超越。

### 7、Redis的并发竞争问题如何解决?

单进程单线程模式，采用队列模式将并发访问变为串行访问。Redis本身没有锁的概念，Redis对于多个客户端连接并不存在竞争，利用setnx实现锁。


### 8、Jedis 与 Redisson 对比有什么优缺点？
### 9、为什么要做Redis分区？
### 10、，或是关注
### 11、假如Redis里面有1亿个key，其中有10w个key是以某个固定的已知的前缀开头的，如果将它们全部找出来？
### 12、如何实现集群中的 session 共享存储？
### 13、进程本身运行需要的内存
### 14、Redis是单线程的，如何提高多核CPU的利用率？
### 15、Redis是单进程单线程的
### 16、Redis常见性能问题和解决方案：
### 17、Redis的内存用完了会发生什么？
### 18、Redis缓存被击穿处理机制
### 19、Redis和Redisson有什么关系？
### 20、Memcache 与Redis 的区别都有哪些？
### 21、Redis对象有5种类型
### 22、为什么Redis是单线程的？
### 23、Redis做异步队列
### 24、Redis回收进程如何工作的？
### 25、Redis通讯协议
### 26、Reids持久化触发条件
### 27、怎么理解 Redis 事务？
### 28、Redis内存模型
### 29、Redis过期键的删除策略？
### 30、什么是Redis?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
