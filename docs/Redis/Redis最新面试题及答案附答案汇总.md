# Redis最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis有哪些适合的场景？

**会话缓存（Session Cache）**

最常用的一种使用Redis的情景是会话缓存（sessioncache），用Redis缓存会话比其他存储（如Memcached）的优势在于：Redis提供持久化。当维护一个不是严格要求一致性的缓存时，如果用户的购物车信息全部丢失，大部分人都会不高兴的，现在，他们还会这样吗？

幸运的是，随着 Redis 这些年的改进，很容易找到怎么恰当的使用Redis来缓存会话的文档。甚至广为人知的商业平台Magento也提供Redis的插件。

**全页缓存（FPC）**

除基本的会话token之外，Redis还提供很简便的FPC平台。回到一致性问题，即使重启了Redis实例，因为有磁盘的持久化，用户也不会看到页面加载速度的下降，这是一个极大改进，类似PHP本地FPC。

再次以Magento为例，Magento提供一个插件来使用Redis作为全页缓存后端。

此外，对WordPress的用户来说，Pantheon有一个非常好的插件wp-Redis，这个插件能帮助你以最快速度加载你曾浏览过的页面。

**队列**

Reids在内存存储引擎领域的一大优点是提供list和set操作，这使得Redis能作为一个很好的消息队列平台来使用。Redis作为队列使用的操作，就类似于本地程序语言（如Python）对 list 的 push/pop 操作。

如果你快速的在Google中搜索“Redis queues”，你马上就能找到大量的开源项目，这些项目的目的就是利用Redis创建非常好的后端工具，以满足各种队列需求。例如，Celery有一个后台就是使用Redis作为broker，你可以从这里去查看。

**排行榜/计数器**

Redis在内存中对数字进行递增或递减的操作实现的非常好。集合（Set）和有序集合（SortedSet）也使得我们在执行这些操作的时候变的非常简单，Redis只是正好提供了这两种数据结构。

所以，我们要从排序集合中获取到排名最靠前的10个用户–我们称之为“user_scores”，我们只需要像下面一样执行即可：

当然，这是假定你是根据你用户的分数做递增的排序。如果你想返回用户及用户的分数，你需要这样执行：

ZRANGE user_scores 0 10 WITHSCORES

Agora Games就是一个很好的例子，用Ruby实现的，它的排行榜就是使用Redis来存储数据的，你可以在这里看到。

**发布/订阅**

最后（但肯定不是最不重要的）是Redis的发布/订阅功能。发布/订阅的使用场景确实非常多。我已看见人们在社交网络连接中使用，还可作为基于发布/订阅的脚本触发器，甚至用Redis的发布/订阅功能来建立聊天系统！


### 2、Redis没有直接使用C字符串

(即以空字符’\0’结尾的字符数组)作为默认的字符串表示，而是使用了SDS。SDS是简单动态字符串(Simple Dynamic String)的缩写。


### 3、Redis 相比Memcached 有哪些优势？

**1、** Memcached 所有的值均是简单的字符串， Redis 作为其替代者， 支持更为丰富的数据类

**2、** Redis 的速度比 Memcached 快很3、Redis 可以持久化其数据

**3、** 更多面试题关注微信公众号：Java2B


### 4、Reids常用5种数据类型

string，list，set，sorted set，hash


### 5、查看Redis使用情况及状态信息用什么命令？

info


### 6、怎么测试Redis的连通性？

ping


### 7、定期删除

由于定时删除会占用太多cpu时间，影响服务器的响应时间和吞吐量以及惰性删除浪费太多内存，有内存泄露的危险，所以出现一种整合和折中这两种策略的定期删除策略。

**1、** 定期删除策略每隔一段时间执行一次删除过期键操作，并通过限制删除操作执行的时长和频率来减少删除操作对CPU时间的影响。

**2、** 定时删除策略有效地减少了因为过期键带来的内存浪费。


### 8、一个字符串类型的值能存储最大容量是多少？
### 9、Redis如何做内存优化？
### 10、Redis 过期键的删除策略？
### 11、缓存雪崩问题
### 12、Redis最适合的场景？
### 13、Redis 中设置过期时间主要通过以下四种方式
### 14、数据分片模型
### 15、使用过Redis分布式锁么，它是什么回事？
### 16、Redis回收进程如何工作的？
### 17、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？
### 18、Redis的回收策略（淘汰策略）?
### 19、为什么Redis需要把所有数据放到内存中？
### 20、Redis 持久化方案：
### 21、Redis事务相关的命令有哪几个？
### 22、Redis 的回收策略（淘汰策略）
### 23、Reids6种淘汰策略：
### 24、Redis 事务相关的命令有哪几个？
### 25、Reids的特点
### 26、手写一个 LRU 算法
### 27、Redis提供了哪几种持久化方式？
### 28、Redis 的同步机制了解么？
### 29、Redis支持的Java客户端都有哪些？官方推荐用哪个？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
