# Redis最新2021年面试题及答案，汇总版

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、都有哪些办法可以降低Redis的内存使用情况呢？

如果你使用的是32位的Redis实例，可以好好利用Hash,list,sorted set,set等集合类型数据，因为通常情况下很多小的Key-Value可以用更紧凑的方式存放到一起。


### 2、怎么理解 Redis 事务？

**1、** 事务是一个单独的隔离操作：   事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中， 不会被其他客户端发送来的命令请求所打断。

**2、** 事务是一个原子操作： 事务中的命令要么全部被执行， 要么全部都不执行。


### 3、Redis分布式锁实现

先拿setnx来争抢锁，抢到之后，再用expire给锁加一个过期时间防止锁忘记了释放。如果在setnx之后执行expire之前进程意外crash或者要重启维护了，那会怎么样？set指令有非常复杂的参数，这个应该是可以同时把setnx和expire合成一条指令来用的！


### 4、Pipeline有什么好处，为什么要用pipeline？

可以将多次IO往返的时间缩减为一次，前提是pipeline执行的指令之间没有因果相关性。使用Redis-benchmark进行压测的时候可以发现影响Redis的QPS峰值的一个重要因素是pipeline批次指令的数目。


### 5、内存碎片

内存碎片是Redis在分配、回收物理内存过程中产生的。例如，如果对数据的更改频繁，而且数据之间的大小相差很大，可能导致Redis释放的空间在物理内存中并没有释放，但Redis又无法有效利用，这就形成了内存碎片。内存碎片不会统计在used_memory中。


### 6、分布式Redis是前期做还是后期规模上来了再做好？为什么？

既然Redis是如此的轻量（单实例只使用1M内存）,为防止以后的扩容，最好的办法就是一开始就启动较多实例。即便你只有一台服务器，你也可以一开始就让Redis以分布式的方式运行，使用分区，在同一台服务器上启动多个实例。

一开始就多设置几个Redis实例，例如32或者64个实例，对大多数用户来说这操作起来可能比较麻烦，但是从长久来看做这点牺牲是值得的。

这样的话，当你的数据不断增长，需要更多的Redis服务器时，你需要做的就是仅仅将Redis实例从一台服务迁移到另外一台服务器而已（而不用考虑重新分区的问题）。一旦你添加了另一台服务器，你需要将你一半的Redis实例从第一台机器迁移到第二台机器。


### 7、进程本身运行需要的内存

Redis主进程本身运行肯定需要占用内存，如代码、常量池等等；这部分内存大约几兆，在大多数生产环境中与Redis数据占用的内存相比可以忽略。这部分内存不是由jemalloc分配，因此不会统计在used_memory中。


### 8、Redis 相比Memcached 有哪些优势？

**1、** Memcached 所有的值均是简单的字符串， Redis 作为其替代者， 支持更为丰富的数据类

**2、** Redis 的速度比 Memcached 快很3、Redis 可以持久化其数据

**3、** 更多面试题关注微信公众号：Java2B


### 9、Reids常用5种数据类型

string，list，set，sorted set，hash


### 10、Redis常见性能问题和解决方案：

**1、** Master最好不要写内存快照，如果Master写内存快照，save命令调度rdbSave函数，会阻塞主线程的工作，当快照比较大时对性能影响是非常大的，会间断性暂停服务

**2、** 如果数据比较重要，某个Slave开启AOF备份数据，策略设置为每秒同步一

**3、** 为了主从复制的速度和连接的稳定性，Master和Slave最好在同一个局域网

**4、** 尽量避免在压力很大的主库上增加从

**5、** 主从复制不要用图状结构，用单向链表结构更为稳定，即：Master <- Slave1 <- Slave2 <- Slave3…这样的结构方便解决单点故障问题，实现Slave对Master的替换。如果Master挂了，可以立刻启用Slave1做Master，其他不变。


### 11、AOF常用配置总结
### 12、Reids支持的语言：
### 13、Redis是单线程的，如何提高多核CPU的利用率？
### 14、Redis集群之间是如何复制的？
### 15、为什么Redis需要把所有数据放到内存中？
### 16、Redis集群方案什么情况下会导致整个集群不可用？
### 17、Redis的并发竞争问题如何解决?
### 18、Redis如何设置密码及验证密码？
### 19、Redis最适合的场景？
### 20、Redis 的数据类型？
### 21、修改配置不重启Redis会实时生效吗？
### 22、惰性删除
### 23、Redis 持久化方案：
### 24、缓存和数据库间数据一致性问题
### 25、Redis 集群最大节点个数是多少？
### 26、Redis 集群会有写操作丢失吗？为什么？
### 27、查看Redis使用情况及状态信息用什么命令？
### 28、缓存雪崩问题
### 29、使用过Redis分布式锁么，它是什么回事？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
