# Redis最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、怎么理解Redis事务？

事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。

事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。


### 2、Reids工具命令

```
#Redis-server：Redis 服务器的 daemon 启动程序
#Redis-cli：Redis 命令行操作工具。当然，你也可以用 telnet 根据其纯文本协议来操作
#Redis-benchmark：Redis 性能测试工具，测试 Redis 在你的系统及你的配置下的读写性能
$Redis-benchmark -n 100000 –c 50
#模拟同时由 50 个客户端发送 100000 个 SETs/GETs 查询
#Redis-check-aof：更新日志检查
#Redis-check-dump：本地数据库检查
```


### 3、Redis缓存被击穿处理机制

使用mutex。简单地来说，就是在缓存失效的时候（判断拿出来的值为空），不是立即去load db，而是先使用缓存工具的某些带成功操作返回值的操作（比如Redis的SETNX或者Memcache的ADD）去set一个mutex key，当操作返回成功时，再进行load db的操作并回设缓存；否则，就重试整个get缓存的方法


### 4、Redis集群最大节点个数是多少？

16384个


### 5、Redis提供了哪几种持久化方式？

**1、** RDB持久化方式能够在指定的时间间隔能对你的数据进行快照存储.

**2、** AOF持久化方式记录每次对服务器写的操作,当服务器重启的时候会重新执行这些命令来恢复原始的数据,AOF命令以Redis协议追加保存每次写的操作到文件末尾.Redis还能对AOF文件进行后台重写,使得AOF文件的体积不至于过大.

**3、** 如果你只希望你的数据在服务器运行的时候存在,你也可以不使用任何持久化方式.

**4、** 你也可以同时开启两种持久化方式, 在这种情况下, 当Redis重启的时候会优先载入AOF文件来恢复原始的数据,因为在通常情况下AOF文件保存的数据集要比RDB文件保存的数据集要完整.

**5、** 最重要的事情是了解RDB和AOF持久化方式的不同,让我们以RDB持久化方式开始。


### 6、RDB和AOF的优缺点

**RDB持久化**

优点：RDB文件紧凑，体积小，网络传输快，适合全量复制；恢复速度比AOF快很多。当然，与AOF相比，RDB最重要的优点之一是对性能的影响相对较小。

缺点：RDB文件的致命缺点在于其数据快照的持久化方式决定了必然做不到实时持久化，而在数据越来越重要的今天，数据的大量丢失很多时候是无法接受的，因此AOF持久化成为主流。此外，RDB文件需要满足特定格式，兼容性差（如老版本的Redis不兼容新版本的RDB文件）。

**AOF持久化**

与RDB持久化相对应，AOF的优点在于支持秒级持久化、兼容性好，缺点是文件大、恢复速度慢、对性能影响大。


### 7、判断key是否存在

exists key +key名字


### 8、怎么测试 Redis 的连通性？

使用 ping 命令。


### 9、AOF常用配置总结

下面是AOF常用的配置项，以及默认值；前面介绍过的这里不再详细介绍。

**1、** appendonly no：是否开启AOF

**2、** appendfilename "appendonly.aof"：AOF文件名

**3、** dir ./：RDB文件和AOF文件所在目录

**4、** appendfsync everysec：fsync持久化策略

**5、** no-appendfsync-on-rewrite no：AOF重写期间是否禁止fsync；如果开启该选项，可以减轻文件重写时CPU和硬盘的负载（尤其是硬盘），但是可能会丢失AOF重写期间的数据；需要在负载和安全性之间进行平衡

**6、** auto-aof-rewrite-percentage 100：文件重写触发条件之一

**7、** auto-aof-rewrite-min-size 64mb：文件重写触发提交之一

**8、** aof-load-truncated yes：如果AOF文件结尾损坏，Redis启动时是否仍载入AOF文件


### 10、内存碎片

内存碎片是Redis在分配、回收物理内存过程中产生的。例如，如果对数据的更改频繁，而且数据之间的大小相差很大，可能导致Redis释放的空间在物理内存中并没有释放，但Redis又无法有效利用，这就形成了内存碎片。内存碎片不会统计在used_memory中。


### 11、Redis集群方案应该怎么做？都有哪些方案？
### 12、Redis支持哪几种数据类型？
### 13、后端开发群：943918498
### 14、使用过 Redis 分布式锁么，它是什么回事？
### 15、缓存和数据库间数据一致性问题
### 16、Memcache与Redis的区别都有哪些？
### 17、Redis是单进程单线程的？
### 18、怎么理解Redis事务？
### 19、使用过 Redis 做异步队列么，你是怎么用的？
### 20、怎么测试Redis的连通性？
### 21、什么是Redis?
### 22、假如 Redis 里面有 1 亿个key，其中有 10w 个key 是以某个固定的已知的前缀开头的，如果将它们全部找出来？
### 23、Redis中海量数据的正确操作方式
### 24、Redis的并发竞争问题如何解决?
### 25、Redis 的持久化机制是什么？各自的优缺点？
### 26、Redis常见性能问题和解决方案？
### 27、为什么 edis 需要把所有数据放到内存中？
### 28、什么是Redis？
### 29、多节点 Redis 分布式锁：Redlock 算法




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
