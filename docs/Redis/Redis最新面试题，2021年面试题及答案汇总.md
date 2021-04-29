# Redis最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Redis常见性能问题和解决方案？

**1、** Master最好不要做任何持久化工作，如RDB内存快照和AOF日志文件

**2、** 如果数据比较重要，某个Slave开启AOF备份数据，策略设置为每秒同步一次

**3、** 为了主从复制的速度和连接的稳定性，Master和Slave最好在同一个局域网内

**4、** 尽量避免在压力很大的主库上增加从库

**5、** 主从复制不要用图状结构，用单向链表结构更为稳定，即：Master <- Slave1 <- Slave2 <- Slave3...

这样的结构方便解决单点故障问题，实现Slave对Master的替换。如果Master挂了，可以立刻启用Slave1做Master，其他不变。


### 2、RDB和AOF的优缺点

**RDB持久化**

优点：RDB文件紧凑，体积小，网络传输快，适合全量复制；恢复速度比AOF快很多。当然，与AOF相比，RDB最重要的优点之一是对性能的影响相对较小。

缺点：RDB文件的致命缺点在于其数据快照的持久化方式决定了必然做不到实时持久化，而在数据越来越重要的今天，数据的大量丢失很多时候是无法接受的，因此AOF持久化成为主流。此外，RDB文件需要满足特定格式，兼容性差（如老版本的Redis不兼容新版本的RDB文件）。

**AOF持久化**

与RDB持久化相对应，AOF的优点在于支持秒级持久化、兼容性好，缺点是文件大、恢复速度慢、对性能影响大。


### 3、Redis集群方案应该怎么做？都有哪些方案？

**1、** codis。

目前用的最多的集群方案，基本和twemproxy一致的效果，但它支持在 节点数量改变情况下，旧节点数据可恢复到新hash节点。

**2、** Redis cluster3.0自带的集群，特点在于他的分布式算法不是一致性hash，而是hash槽的概念，以及自身支持节点设置从节点。具体看官方文档介绍。

**3、** 在业务代码层实现，起几个毫无关联的Redis实例，在代码层，对key 进行hash计算，然后去对应的Redis实例操作数据。 这种方式对hash层代码要求比较高，考虑部分包



### 4、分布式Redis是前期做还是后期规模上来了再做好？为什么？

既然Redis是如此的轻量（单实例只使用1M内存）,为防止以后的扩容，最好的办法就是一开始就启动较多实例。即便你只有一台服务器，你也可以一开始就让Redis以分布式的方式运行，使用分区，在同一台服务器上启动多个实例。

一开始就多设置几个Redis实例，例如32或者64个实例，对大多数用户来说这操作起来可能比较麻烦，但是从长久来看做这点牺牲是值得的。

这样的话，当你的数据不断增长，需要更多的Redis服务器时，你需要做的就是仅仅将Redis实例从一台服务迁移到另外一台服务器而已（而不用考虑重新分区的问题）。一旦你添加了另一台服务器，你需要将你一半的Redis实例从第一台机器迁移到第二台机器。


### 5、Twemproxy是什么？

Twemproxy是Twitter维护的（缓存）代理系统，代理Memcached的ASCII协议和Redis协议。它是单线程程序，使用c语言编写，运行起来非常快。它是采用Apache 2.0 license的开源软件。 Twemproxy支持自动分区，如果其代理的其中一个Redis节点不可用时，会自动将该节点排除（这将改变原来的keys-instances的映射关系，所以你应该仅在把Redis当缓存时使用Twemproxy)。 Twemproxy本身不存在单点问题，因为你可以启动多个Twemproxy实例，然后让你的客户端去连接任意一个Twemproxy实例。 Twemproxy是Redis客户端和服务器端的一个中间层，由它来处理分区功能应该不算复杂，并且应该算比较可靠的。


### 6、Redis 如何做内存优化？

尽可能使用散列表（ hashes）， 散列表（ 是说散列表里面存储的数少） 使用的内存非常小， 所以你应该尽可能的将你的数据模型抽象到一个散列表里面。比如你的 web 系统中有一个用户对象， 不要为这个用户的名称， 姓氏， 邮箱， 密码设置单独的 key,而是应该把这个用户的所有信息存储到一张散列表里面. 更多面试题关注微信公众号：Java2B


### 7、是否使用过Redis集群，集群的原理是什么？

**1、** Redis Sentinal着眼于高可用，在master宕机时会自动将slave提升为master，继续提供服务。

**2、** Redis Cluster着眼于扩展性，在单个Redis内存不足时，使用Cluster进行分片存储。


### 8、Reids工具命令
### 9、删除key
### 10、Redis 最适合的场景？
### 11、Redis常见性能问题和解决方案：
### 12、Redis是单进程单线程的？
### 13、Redis集群会有写操作丢失吗？为什么？
### 14、Redis 提供 6种数据淘汰策略：
### 15、多节点 Redis 分布式锁：Redlock 算法
### 16、AOF常用配置总结
### 17、Redis集群之间是如何复制的？
### 18、布隆过滤器
### 19、Redis常见性能问题和解决方案：
### 20、Redis是单线程的，但Redis为什么这么快？
### 21、Redis 集群之间是如何复制的？
### 22、支持一致性哈希的客户端有哪些？
### 23、Redis的数据类型？
### 24、后端开发群：943918498
### 25、Redis 的内存用完了会发生什么？
### 26、Redis如何做内存优化？
### 27、Redis如何设置密码及验证密码？
### 28、Redis集群方案应该怎么做？都有哪些方案？
### 29、修改配置不重启Redis会实时生效吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
