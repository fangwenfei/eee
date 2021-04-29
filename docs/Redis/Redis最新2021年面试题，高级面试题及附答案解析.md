# Redis最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis对象有5种类型

无论是哪种类型，Redis都不会直接存储，而是通过RedisObject对象进行存储。


### 2、Reids的特点

Redis本质上是一个Key-Value类型的内存数据库，很像Memcached，整个数据库统统加载在内存当中进行操作，定期通过异步操作把数据库数据flush到硬盘上进行保存。

因为是纯内存操作，Redis的性能非常出色，每秒可以处理超过 10万次读写操作，是已知性能最快的Key-Value DB。

Redis的出色之处不仅仅是性能，Redis最大的魅力是支持保存多种数据结构，此外单个value的最大限制是1GB，不像 Memcached只能保存1MB的数据，因此Redis可以用来实现很多有用的功能。

比方说用他的List来做FIFO双向链表，实现一个轻量级的高性 能消息队列服务，用他的Set可以做高性能的tag系统等等。另外Redis也可以对存入的Key-Value设置expire时间，因此也可以被当作一 个功能加强版的Memcached来用。

Redis的主要缺点是数据库容量受到物理内存的限制，不能用作海量数据的高性能读写，因此Redis适合的场景主要局限在较小数据量的高性能操作和运算上。


### 3、Redis 如何设置密码及验证密码？

设置密码： config set requirepass 123456 授权密码： auth 123456


### 4、Redis 回收进程如何工作的?

一个客户端运行了新的命令， 添加了新的数据。Redi 检查内存使用情况， 如果大于 maxmemory 的限制, 则根据设定好的策略进行回收。一个新的命令被执行， 等等。所以我们不断地穿越内存限制的边界， 通过不断达到边界然后不断地回收回到边界以下。如果一个命令的结果导致大量内存被使用（ 例如很大的集合的交集保存到一个新的键）， 不用多久内存限制就会被这个内存使用量超越。


### 5、怎么理解Redis事务？



事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。

事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。


### 6、Redis的全称是什么？

Remote Dictionary Server。


### 7、怎么理解 Redis 事务？

**1、** 事务是一个单独的隔离操作：   事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中， 不会被其他客户端发送来的命令请求所打断。

**2、** 事务是一个原子操作： 事务中的命令要么全部被执行， 要么全部都不执行。


### 8、Redis中的管道有什么用？

一次请求/响应服务器能实现处理新的请求即使旧的请求还未被响应。这样就可以将多个命令发送到服务器，而不用等待回复，最后在一个步骤中读取该答复。

这就是管道（pipelining），是一种几十年来广泛使用的技术。例如许多POP3协议已经实现支持这个功能，大大加快了从服务器下载新邮件的过程。


### 9、Redis官方为什么不提供Windows版本？

因为目前Linux版本已经相当稳定，而且用户量很大，无需开发windows版本，反而会带来兼容性等问题。


### 10、Redis缓存被击穿处理机制

使用mutex。简单地来说，就是在缓存失效的时候（判断拿出来的值为空），不是立即去load db，而是先使用缓存工具的某些带成功操作返回值的操作（比如Redis的SETNX或者Memcache的ADD）去set一个mutex key，当操作返回成功时，再进行load db的操作并回设缓存；否则，就重试整个get缓存的方法


### 11、缓存并发问题
### 12、Redis 最适合的场景？
### 13、SCAN系列命令注意事项
### 14、Redis 集群如何选择数据库？
### 15、Redis事物的了解CAS(check-and-set 操作实现乐观锁 )?
### 16、Redis 的同步机制了解么？
### 17、什么是Redis?
### 18、Redis 集群方案什么情况下会导致整个集群不可用？
### 19、数据分片模型
### 20、怎么测试Redis的连通性？
### 21、Memcache与Redis的区别都有哪些？
### 22、怎么测试 Redis 的连通性？
### 23、Redis的同步机制了解么？
### 24、Redis还提供的高级工具
### 25、Redis分布式锁实现
### 26、Redis常用管理命令
### 27、Redis 事务相关的命令有哪几个？
### 28、如何选择合适的持久化方式？
### 29、Redis中海量数据的正确操作方式
### 30、Redis 集群最大节点个数是多少？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
