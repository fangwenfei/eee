# Redis最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis 的内存用完了会发生什么？

如果达到设置的上限，Redis 的写命令会返回错误信息（ 但是读命令还可以正常返回。） 或者你可以将 Redis 当缓存来使用配置淘汰机制， 当 Redis 达到内存上限时会冲刷掉旧的内容。


### 2、Redis key的过期时间和永久有效分别怎么设置？

EXPIRE和PERSIST命令


### 3、Redis相比Memcached有哪些优势：

**1、** Memcached所有的值均是简单的字符串，Redis作为其替代者，支持更为丰富的数据类型

**2、** Redis的速度比Memcached快很多

**3、** Redis可以持久化其数据


### 4、，免费领取架构资料。


### 5、Redis通讯协议

RESP 是Redis客户端和服务端之前使用的一种通讯协议；RESP 的特点：实现简单、快速解析、可读性好


### 6、Redis如何做内存优化？

尽可能使用散列表（hashes），散列表（是说散列表里面存储的数少）使用的内存非常小，所以你应该尽可能的将你的数据模型抽象到一个散列表里面。比如你的web系统中有一个用户对象，不要为这个用户的名称，姓氏，邮箱，密码设置单独的key,而是应该把这个用户的所有信息存储到一张散列表里面.


### 7、为什么Redis需要把所有数据放到内存中?

Redis为了达到最快的读写速度将数据都读到内存中，并通过异步的方式将数据写入磁盘。所以Redis具有快速和数据持久化的特征。如果不将数据放在内存中，磁盘I/O速度为严重影响Redis的性能。在内存越来越便宜的今天，Redis将会越来越受欢迎。

如果设置了最大使用的内存，则数据已有记录数达到内存限值后不能继续插入新值。


### 8、MySQL 里有 2000w 数据，Redis 中只存 20w 的数据，如何保证Redis 中的数据都是热点数据？

Redis 内存数据集大小上升到一定大小的时候， 就会施行数据淘汰策略。相关知识： Redis 提供 6 种数据淘汰策略：

volatile-lru：从已设置过期时间的数据集（ server.db[i].expires）中挑选最近最

少使用的数据淘汰

volatile-ttl： 从已设置过期时间的数据集（ server.db[i].expires） 中挑选将要过期的数据淘汰

volatile-random： 从已设置过期时间的数据集（ server.db[i].expires） 中任意选择数据淘汰

allkeys-lru： 从数据集（ server.db[i].dict） 中挑选最近最少使用的数据淘汰

allkeys-random： 从数据集（ server.db[i].dict） 中任意选择数据淘汰

no-enviction（ 驱逐） ： 禁止驱逐数据


### 9、Pipeline有什么好处，为什么要用pipeline？

可以将多次IO往返的时间缩减为一次，前提是pipeline执行的指令之间没有因果相关性。使用Redis-benchmark进行压测的时候可以发现影响Redis的QPS峰值的一个重要因素是pipeline批次指令的数目。


### 10、Redis 过期键的删除策略？

**1、** 定时删除:在设置键的过期时间的同时，创建一个定时器 timer). 让定时器在键的过期时间来临时， 立即执行对键的删除操作。

**2、** 惰性删除:放任键过期不管，但是每次从键空间中获取键时，都检查取得的键是   否过期， 如果过期的话， 就删除该键;如果没有过期， 就返回该键。

**3、** 定期删除:每隔一段时间程序就对数据库进行一次检查，删除里面的过期键。至   于要删除多少过期键， 以及要检查多少个数据库， 则由算法决定。


### 11、说说 Redis 哈希槽的概念？
### 12、Redis回收进程如何工作的？
### 13、Redis集群会有写操作丢失吗？为什么？
### 14、说说Redis哈希槽的概念？
### 15、Redis集群的主从复制模型是怎样的？
### 16、Redis集群如何选择数据库？
### 17、Redis 的回收策略（淘汰策略）
### 18、使用Redis有哪些好处？
### 19、Redis集群方案什么情况下会导致整个集群不可用？
### 20、修改配置不重启Redis会实时生效吗？
### 21、Redis如何做内存优化？
### 22、如果有大量的key需要设置同一时间过期，一般需要注意什么？
### 23、Redis内存模型
### 24、请用Redis和任意语言实现一段恶意登录保护的代码，
### 25、Redis回收进程如何工作的？
### 26、Redis 如何做内存优化？
### 27、一个字符串类型的值能存储最大容量是多少？
### 28、Redis是单线程的，但Redis为什么这么快？
### 29、Redis常见的几种缓存策略
### 30、Redis常见性能问题和解决方案：




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
