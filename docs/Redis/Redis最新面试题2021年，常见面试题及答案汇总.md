# Redis最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、怎么理解Redis事务？



事务是一个单独的隔离操作：事务中的所有命令都会序列化、按顺序地执行。事务在执行的过程中，不会被其他客户端发送来的命令请求所打断。

事务是一个原子操作：事务中的命令要么全部被执行，要么全部都不执行。


### 2、Redis中的管道有什么用？

一次请求/响应服务器能实现处理新的请求即使旧的请求还未被响应，这样就可以将多个命令发送到服务器，而不用等待回复，最后在一个步骤中读取该答复。

这就是管道（pipelining），是一种几十年来广泛使用的技术。例如许多POP3协议已经实现支持这个功能，大大加快了从服务器下载新邮件的过程。


### 3、一个Redis实例最多能存放多少的keys？List、Set、Sorted Set他们最多能存放多少元素？

理论上Redis可以处理多达232的keys，并且在实际中进行了测试，每个实例至少存放了2亿5千万的keys。我们正在测试一些较大的值。

任何list、set、和sorted set都可以放232个元素。

换句话说，Redis的存储极限是系统中的可用内存值。


### 4、请用Redis和任意语言实现一段恶意登录保护的代码，

限制1小时内每用户Id最多只能登录5次。具体登录函数或功能用空函数即可，不用详细写出。

用列表实现:列表中每个元素代表登陆时间,只要最后的第5次登陆时间和现在时间差不超过1小时就禁止登陆.用Python写的代码如下：

```
#!/usr/bin/env python3
import Redis  
import sys  
import time  
 
r = Redis.StrictRedis(host=’127.0.0.1′, port=6379, db=0)  
try:       
    id = sys.argv[1]
except:      
    print(‘input argument error’)    
    sys.exit(0)  
if r.llen(id) >= 5 and time.time() – float(r.lindex(id, 4)) <= 3600:      
    print(“you are forbidden logining”)
else:       
    print(‘you are allowed to login’)    
    r.lpush(id, time.time())    
    # login_func()
```


### 5、Redis 的数据类型？

Redis 支持五种数据类型： string（ 字符串），hash（ 哈希）， list（ 列表）， set（ 集合） 及 zsetsorted set： 有序集合)。

我们实际项目中比较常用的是 string，hash 如果你是 Redis 中高级用户，还需要加上下面几种数据结构 HyperLogLog、Geo、Pub/Sub。

如果你说还玩过 Redis  Module，像  BloomFilter，RedisSearch，Redis-ML，面试官得眼睛就开始发亮了。


### 6、你知道有哪些Redis分区实现方案？

客户端分区就是在客户端就已经决定数据会被存储到哪个Redis节点或者从哪个Redis节点读取。大多数客户端已经实现了客户端分区。

代理分区 意味着客户端将请求发送给代理，然后代理决定去哪个节点写数据或者读数据。代理根据分区规则决定请求哪些Redis实例，然后根据Redis的响应结果返回给客户端。Redis和Memcached的一种代理实现就是Twemproxy

查询路由(Query routing) 的意思是客户端随机地请求任意一个Redis实例，然后由Redis将请求转发给正确的Redis节点。Redis Cluster实现了一种混合形式的查询路由，但并不是直接将请求从一个Redis节点转发到另一个Redis节点，而是在客户端的帮助下直接redirected到正确的Redis节点。


### 7、使用Redis 有哪些好处？

**1、** 速度快， 因为数据存在内存中， 类似于 HashMap， HashMap 的优势就是查找和操作的时间复杂度都是 O1)

**2、** 支持丰富数据类型， 支持 string， list， set， Zset， hash 等

**3、** 支持事务， 操作都是原子性， 所谓的原子性就是对数据的更改要么全部执行， 要么全部不执行

**4、** 丰富的特性：可用于缓存，消息，按 key 设置过期时间，过期后将会自动删除


### 8、MySQL里有2000w数据，Redis中只存20w的数据
### 9、Redis集群方案什么情况下会导致整个集群不可用？
### 10、Redis集群最大节点个数是多少？
### 11、Redis是单线程
### 12、MySQL里有2000w数据，Redis中只存20w的数据，如何保证Redis中的数据都是热点数据？
### 13、定时删除
### 14、使用过 Redis 做异步队列么，你是怎么用的？
### 15、说说 Redis 哈希槽的概念？
### 16、Redis 到底是怎么实现“附近的人”
### 17、Redis的缓存失效策略和主键失效机制
### 18、Redis的内存占用情况怎么样？
### 19、微信公众号：Java资讯库，回复“架构”
### 20、什么是Redis?
### 21、Redis前端启动命令
### 22、Redis 最适合的场景
### 23、Redis常见的几种缓存策略
### 24、Redis的持久化机制是什么？各自的优缺点？
### 25、Redis集群最大节点个数是多少？
### 26、Redis的全称是什么？
### 27、Redis分区有什么缺点？
### 28、Redis主要消耗什么物理资源？
### 29、Reids三种不同删除策略




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
