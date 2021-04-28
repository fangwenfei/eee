# Redis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Reids工具命令

```
#Redis-server：Redis 服务器的 daemon 启动程序
#Redis-cli：Redis 命令行操作工具。当然，你也可以用 telnet 根据其纯文本协议来操作
#Redis-benchmark：Redis 性能测试工具，测试 Redis 在你的系统及你的配置下的读写性能
$Redis-benchmark -n 100000 –c 50
#模拟同时由 50 个客户端发送 100000 个 SETs/GETs 查询
#Redis-check-aof：更新日志检查
#Redis-check-dump：本地数据库检查
```


### 2、Reids主从复制

复制是高可用Redis的基础，哨兵和集群都是在复制基础上实现高可用的。复制主要实现了数据的多机备份，以及对于读操作的负载均衡和简单的故障恢复。缺陷：故障恢复无法自动化；写操作无法负载均衡；存储能力受到单机的限制。


### 3、Redis 最适合的场景？

**1、** 会话缓存（ Session  Cache）

最常用的一种使用 Redis 的情景是会话缓存（ session cache）。用 Redis 缓存会话比其他存储（ 如 Memcached）的优势在于：Redis 提供持久化。当维护一个不是严格要求一致性的缓存时， 如果用户的购物车信息全部丢失， 大部分人都会不高兴的， 现在， 他们还会这样吗？ 幸运的是， 随着 Redis 这些年的改进， 很容易找到怎么恰当的使用 Redis 来缓存会话的文档。甚至广为人知的商业平台Magento 也提供 Redis 的插件。

**2、** 全页缓存（ FPC）

除基本的会话 token 之外， Redis 还提供很简便的 FPC 平台。回到一致性问题， 即使重启了 Redis 实例， 因为有磁盘的持久化， 用户也不会看到页面加载速度的下降，这是一个极大改进，类似 PHP 本地 FPC。 再次以 Magento 为例，Magento 提供一个插件来使用 Redis 作为全页缓存后端。 此外， 对 WordPress 的用户来说， Pantheon 有一个非常好的插件 wp-Redis， 这个插件能帮助你以最快速度加载你曾浏览过的页面。

3、队列

Reids 在内存存储引擎领域的一大优点是提供 list 和 set 操作， 这使得 Redis 能作为一个很好的消息队列平台来使用。Redis 作为队列使用的操作，就类似于本地程序语言（ 如 Python）对 list 的 push/pop 操作。 如果你快速的在 Google 中搜索“ Redis  queues”， 你马上就能找到大量的开源项目， 这些项目的目的就是利用 Redis 创建非常好的后端工具， 以满足各种队列需求。例如， Celery 有一个后台就是使用 Redis 作为 broker， 你可以从这里去查看。

4， 排行榜/计数器

Redis 在内存中对数字进行递增或递减的操作实现的非常好。集合（ Set） 和有序集合（ Sorted Set）也使得我们在执行这些操作的时候变的非常简单，Redis 只是正好提供了这两种数据结构。所以， 我们要从排序集合中获取到排名最靠前的 10 个用户– 我们称之为“ user_scores”， 我们只需要像下面一样执行即可：   当然，这是假定你是根据你用户的分数做递增的排序。如果你想返回用户及用户的分数，   你需要这样执行：  ZRANGE user_scores 0 10 WITHSCORES Agora Games 就是一个很好的例子， 用 Ruby 实现的， 它的排行榜就是使用 Redis 来存储数据的， 你可以在这里看到。

**5、** 发布/订阅

最后（ 但肯定不是最不重要的）是 Redis 的发布/订阅功能。发布/订阅的使用场景确实非常多。我已看见人们在社交网络连接中使用， 还可作为基于发布/订阅的脚本触发器， 甚至用 Redis 的发布/订阅功能来建立聊天系统！


### 4、Pipeline有什么好处，为什么要用pipeline？

可以将多次IO往返的时间缩减为一次，前提是pipeline执行的指令之间没有因果相关性。使用Redis-benchmark进行压测的时候可以发现影响Redis的QPS峰值的一个重要因素是pipeline批次指令的数目。


### 5、怎么理解Redis事务？

事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。

事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。


### 6、Redis相比Memcached有哪些优势：

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据


### 7、Redis的全称是什么？

Remote Dictionary Server。


### 8、Reids持久化触发条件

RDB持久化的触发分为手动触发和自动触发两种。


### 9、Redis的同步机制了解么？

Redis可以使用主从同步，从从同步。第一次同步时，主节点做一次bgsave，并同时将后续修改操作记录到内存buffer，待完成后将rdb文件全量同步到复制节点，复制节点接受完成后将rdb镜像加载到内存。加载完成后，再通知主节点将期间修改的操作记录同步到复制节点进行重放就完成了同步过程。


### 10、Redis中的管道有什么用？

一次请求/响应服务器能实现处理新的请求即使旧的请求还未被响应。这样就可以将多个命令发送到服务器，而不用等待回复，最后在一个步骤中读取该答复。

这就是管道（pipelining），是一种几十年来广泛使用的技术。例如许多POP3协议已经实现支持这个功能，大大加快了从服务器下载新邮件的过程。


### 11、什么是Redis?
### 12、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？
### 13、缓存雪崩问题
### 14、是否使用过 Redis 集群，集群的原理是什么？
### 15、内存碎片
### 16、Redis 支持的Java 客户端都有哪些？官方推荐用哪个？
### 17、Redis有哪几种数据淘汰策略？
### 18、一个字符串类型的值能存储最大容量是多少？
### 19、Redis与其他key-value存储有什么不同？
### 20、Redis如何设置密码及验证密码？
### 21、Memcache与Redis的区别都有哪些？
### 22、Redis过期键的删除策略？
### 23、是否使用过Redis集群，集群的原理是什么？
### 24、微信公众号：Java资讯库，回复“架构”
### 25、后端开发群：943918498
### 26、如何选择合适的持久化方式？
### 27、Redis哨兵
### 28、Redis常用管理命令
### 29、Redis内存模型
### 30、使用过 Redis 分布式锁么，它是什么回事？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
