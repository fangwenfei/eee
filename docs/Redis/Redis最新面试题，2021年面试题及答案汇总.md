# Redis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、使用过 Redis 分布式锁么，它是什么回事？

先拿 setnx 来争抢锁， 抢到之后， 再用 expire 给锁加一个过期时间防止锁忘记了释放。

这时候对方会告诉你说你回答得不错， 然后接着问如果在 setnx 之后执行 expire 之前进程意外 crash 或者要重启维护了， 那会怎么样？

这时候你要给予惊讶的反馈： 唉， 是喔， 这个锁就永远得不到释放了。紧接着你需要抓一抓自己得脑袋， 故作思考片刻， 好像接下来的结果是你主动思考出来的， 然后回我记得 set 指令有非常复杂的参数， 这个应该是可以同时把 setnx 和expire 合成一条指令来用的！ 对方这时会显露笑容， 心里开始默念： 摁， 这小子还不错。


### 2、AOF常用配置总结

下面是AOF常用的配置项，以及默认值；前面介绍过的这里不再详细介绍。

**1、** appendonly no：是否开启AOF

**2、** appendfilename "appendonly.aof"：AOF文件名

**3、** dir ./：RDB文件和AOF文件所在目录

**4、** appendfsync everysec：fsync持久化策略

**5、** no-appendfsync-on-rewrite no：AOF重写期间是否禁止fsync；如果开启该选项，可以减轻文件重写时CPU和硬盘的负载（尤其是硬盘），但是可能会丢失AOF重写期间的数据；需要在负载和安全性之间进行平衡

**6、** auto-aof-rewrite-percentage 100：文件重写触发条件之一

**7、** auto-aof-rewrite-min-size 64mb：文件重写触发提交之一

**8、** aof-load-truncated yes：如果AOF文件结尾损坏，Redis启动时是否仍载入AOF文件


### 3、Redis集群方案应该怎么做？都有哪些方案？

**1、** codis。

目前用的最多的集群方案，基本和twemproxy一致的效果，但它支持在 节点数量改变情况下，旧节点数据可恢复到新hash节点。

**2、** Redis cluster3.0自带的集群，特点在于他的分布式算法不是一致性hash，而是hash槽的概念，以及自身支持节点设置从节点。具体看官方文档介绍。

**3、** 在业务代码层实现，起几个毫无关联的Redis实例，在代码层，对key 进行hash计算，然后去对应的Redis实例操作数据。 这种方式对hash层代码要求比较高，考虑部分包



### 4、定期删除

由于定时删除会占用太多cpu时间，影响服务器的响应时间和吞吐量以及惰性删除浪费太多内存，有内存泄露的危险，所以出现一种整合和折中这两种策略的定期删除策略。

**1、** 定期删除策略每隔一段时间执行一次删除过期键操作，并通过限制删除操作执行的时长和频率来减少删除操作对CPU时间的影响。

**2、** 定时删除策略有效地减少了因为过期键带来的内存浪费。


### 5、Redis 持久化方案：

Rdb 和 Aof


### 6、Redis如何做内存优化？

尽可能使用散列表（hashes），散列表（是说散列表里面存储的数少）使用的内存非常小，所以你应该尽可能的将你的数据模型抽象到一个散列表里面。比如你的web系统中有一个用户对象，不要为这个用户的名称，姓氏，邮箱，密码设置单独的key,而是应该把这个用户的所有信息存储到一张散列表里面.


### 7、Redis主要消耗什么物理资源？

内存。


### 8、Redis有哪几种数据淘汰策略？

**1、** noeviction:返回错误当内存限制达到，并且客户端尝试执行会让更多内存被使用的命令。

**2、** allkeys-lru: 尝试回收最少使用的键（LRU），使得新添加的数据有空间存放。

**3、** volatile-lru: 尝试回收最少使用的键（LRU），但仅限于在过期集合的键,使得新添加的数据有空间存放。

**4、** allkeys-random: 回收随机的键使得新添加的数据有空间存放。

**5、** volatile-random: 回收随机的键使得新添加的数据有空间存放，但仅限于在过期集合的键。

**6、** volatile-ttl: 回收在过期集合的键，并且优先回收存活时间（TTL）较短的键,使得新添加的数据有空间存放。


### 9、Redis集群如何选择数据库？

Redis集群目前无法做数据库选择，默认在0数据库。


### 10、Redis 集群之间是如何复制的？

异步复制


### 11、后端开发群：943918498
### 12、mySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据
### 13、Redis常用管理命令
### 14、查看Redis使用情况及状态信息用什么命令？
### 15、为什么需要持久化？
### 16、Redis 的内存用完了会发生什么？
### 17、Redis通讯协议
### 18、RDB和AOF的优缺点
### 19、持久化策略选择
### 20、Redis分布式
### 21、Reids三种不同删除策略
### 22、什么是Redis?
### 23、修改配置不重启Redis会实时生效吗？
### 24、Redis集群最大节点个数是多少？
### 25、Redis与其他key-value存储有什么不同？
### 26、Redis中的管道有什么用？
### 27、SCAN系列命令注意事项
### 28、Redis如何做内存优化？
### 29、Redis常见性能问题和解决方案：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
