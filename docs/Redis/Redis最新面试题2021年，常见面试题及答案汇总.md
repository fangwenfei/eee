# Redis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、删除key

```
del key1 key2 ...
```


### 2、Redis提供了哪几种持久化方式？

**1、** RDB持久化方式能够在指定的时间间隔能对你的数据进行快照存储.

**2、** AOF持久化方式记录每次对服务器写的操作,当服务器重启的时候会重新执行这些命令来恢复原始的数据,AOF命令以Redis协议追加保存每次写的操作到文件末尾.Redis还能对AOF文件进行后台重写,使得AOF文件的体积不至于过大.

**3、** 如果你只希望你的数据在服务器运行的时候存在,你也可以不使用任何持久化方式.

**4、** 你也可以同时开启两种持久化方式, 在这种情况下, 当Redis重启的时候会优先载入AOF文件来恢复原始的数据,因为在通常情况下AOF文件保存的数据集要比RDB文件保存的数据集要完整.

**5、** 最重要的事情是了解RDB和AOF持久化方式的不同,让我们以RDB持久化方式开始。


### 3、Redis和Redisson有什么关系？

Redisson是一个高级的分布式协调Redis客服端，能帮助用户在分布式环境中轻松实现一些Java的对象 (Bloom filter, BitSet, Set, SetMultimap, ScoredSortedSet, SortedSet, Map, ConcurrentMap, List, ListMultimap, Queue, BlockingQueue, Deque, BlockingDeque, Semaphore, Lock, ReadWriteLock, AtomicLong, CountDownLatch, Publish / Subscribe, HyperLogLog)。


### 4、使用过 Redis 分布式锁么，它是什么回事？

先拿 setnx 来争抢锁， 抢到之后， 再用 expire 给锁加一个过期时间防止锁忘记了释放。

这时候对方会告诉你说你回答得不错， 然后接着问如果在 setnx 之后执行 expire 之前进程意外 crash 或者要重启维护了， 那会怎么样？

这时候你要给予惊讶的反馈： 唉， 是喔， 这个锁就永远得不到释放了。紧接着你需要抓一抓自己得脑袋， 故作思考片刻， 好像接下来的结果是你主动思考出来的， 然后回我记得 set 指令有非常复杂的参数， 这个应该是可以同时把 setnx 和expire 合成一条指令来用的！ 对方这时会显露笑容， 心里开始默念： 摁， 这小子还不错。


### 5、Redis如何做内存优化？

尽可能使用散列表（hashes），散列表（是说散列表里面存储的数少）使用的内存非常小，所以你应该尽可能的将你的数据模型抽象到一个散列表里面。比如你的web系统中有一个用户对象，不要为这个用户的名称，姓氏，邮箱，密码设置单独的key,而是应该把这个用户的所有信息存储到一张散列表里面.


### 6、Redis有哪几种数据淘汰策略？

**1、** noeviction:返回错误当内存限制达到，并且客户端尝试执行会让更多内存被使用的命令。

**2、** allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。

**3、** volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。

**4、** allkeys-random: 回收随机的键使得新添加的数据有空间存放。

**5、** volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。

**6、** volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。


### 7、如何实现集群中的 session 共享存储？

Session 是运行在一台服务器上的，所有的访问都会到达我们的唯一服务器上，这样我们可以根据客户端传来的 sessionID，来获取 session，或在对应 Session 不存在的情况下（ session 生命周期到了/用户第一次登录），创建一个新的 Session； 但是， 如果我们在集群环境下， 假设我们有两台服务器 A， B， 用户的请求会由Nginx 服务器进行转发（ 别的方案也是同理）， 用户登录时， Nginx 将请求转发至服务器 A 上，A 创建了新的 session，并将 SessionID 返回给客户端，用户在浏览其他页面时， 客户端验证登录状态， Nginx 将请求转发至服务器 B， 由于 B 上并没有对应客户端发来  sessionId 的  session，所以会重新创建一个新的  session，并且再将这个新的 sessionID 返回给客户端， 这样， 我们可以想象一下， 用户每一次操作都有 1/2 的概率进行再次的登录， 这样不仅对用户体验特别差， 还会让服务器上的 session 激增， 加大服务器的运行压力。

为了解决集群环境下的 seesion 共享问题， 共有 4 种解决方案：

**1、** 粘性 session

粘性 session 是指 Ngnix 每次都将同一用户的所有请求转发至同一台服务器上， 即将用户与服务器绑定。

**2、** 服务器 session 复制

即每次 session 发生变化时， 创建或者修改， 就广播给所有集群中的服务器， 使所有的服务器上的 session 相同。

**3、** session 共享

缓存 session， 使用 Redis， Memcached。4.session 持久化

将 session 存储至数据库中， 像操作数据一样才做 session。


### 8、如何选择合适的持久化方式？

一般来说， 如果想达到足以媲美PostgreSQL的数据安全性， 你应该同时使用两种持久化功能。如果你非常关心你的数据， 但仍然可以承受数分钟以内的数据丢失，那么你可以只使用RDB持久化。

有很多用户都只使用AOF持久化，但并不推荐这种方式：因为定时生成RDB快照（snapshot）非常便于进行数据库备份， 并且 RDB 恢复数据集的速度也要比AOF恢复的速度要快，除此之外， 使用RDB还可以避免之前提到的AOF程序的bug。


### 9、Redis 集群方案什么情况下会导致整个集群不可用？

有 A， B， C 三个节点的集群,在没有复制模型的情况下,如果节点 B 失败了， 那么整个集群就会以为缺少 5501-11000 这个范围的槽而不可用。


### 10、使用Redis有哪些好处？

**1、** 速度快，因为数据存在内存中，类似于HashMap，HashMap的优势就是查找和操作的时间复杂度都是O1)

**2、** 支持丰富数据类型，支持string，list，set，Zset，hash等

**3、** 支持事务，操作都是原子性，所谓的原子性就是对数据的更改要么全部执行，要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按key设置过期时间，过期后将会自动删除


### 11、Redis集群如何选择数据库？
### 12、WATCH命令和基于CAS的乐观锁：
### 13、手写一个 LRU 算法
### 14、Redis通讯协议
### 15、Redis的全称是什么？
### 16、什么是Redis？
### 17、数据分片模型
### 18、Jedis 与 Redisson 对比有什么优缺点？
### 19、什么是Redis?
### 20、为什么需要持久化？
### 21、Reids三种不同删除策略
### 22、Redis常见的几种缓存策略
### 23、Redis集群最大节点个数是多少？
### 24、，或是关注
### 25、Redis分区有什么缺点？
### 26、Redis集群的主从复制模型是怎样的？
### 27、Redis 集群之间是如何复制的？
### 28、Reids工具命令
### 29、Redis集群方案应该怎么做？都有哪些方案？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
