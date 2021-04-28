# Memcached最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Memcached如何处理容错的？

不处理！在Memcached节点失效的情况下，集群没有必要做任何容错处理。如果发生了节点失效，应对的措施完全取决于用户。

**节点失效时，下面列出几种方案供您选择：**

**1、** 忽略它！ 在失效节点被恢复或替换之前，还有很多其他节点可以应对节点失效带来的影响。

**2、** 把失效的节点从节点列表中移除。做这个操作千万要小心！在默认情况下（余数式哈希算法），客户端添加或移除节点，会导致所有的缓存数据不可用！因为哈希参照的节点列表变化了，大部分key会因为哈希值的改变而被映射到（与原来）不同的节点上。

**3、** 启动热备节点，接管失效节点所占用的IP。这样可以防止哈希紊乱（hashing chaos）。

**4、** 如果希望添加和移除节点，而不影响原先的哈希结果，可以使用一致性哈希算法（consistent hashing）。您可以百度一下一致性哈希算法。支持一致性哈希的客户端已经很成熟，而且被广泛使用。去尝试一下吧！

**5、** 两次哈希（reshing）。当客户端存取数据时，如果发现一个节点down了，就再做一次哈希（哈希算法与前一次不同），重新选择另一个节点（需要注意的时，客户端并没有把down的节点从节点列表中移除，下次还是有可能先哈希到它）。如果某个节点时好时坏，两次哈希的方法就有风险了，好的节点和坏的节点上都可能存在脏数据（stale data）。


### 2、Memcached和服务器的local cache（比如PHP的APC、mmap文件等）相比，有什么优缺点？

首先，local cache有许多与上面(query cache)相同的问题。local cache能够利用的内存容量受到（单台）服务器空闲内存空间的限制。不过，local

cache有一点比Memcached和query cache都要好，那就是它不但可以存储任意的数据，而且没有网络存取的延迟。

**1、** local cache的数据查询更快。考虑把highly common的数据放在local cache中吧。如果每个页面都需要加载一些数量较少的数据，考虑把它们放在local

cached吧。

**2、** local cache缺少集体失效（group

invalidation）的特性。在Memcached集群中，删除或更新一个key会让所有的观察者觉察到。但是在local cache中, 我们只能通知所有的服务器刷新cache（很慢，不具扩展性），或者仅仅依赖缓存超时失效机制。

**3、** local cache面临着严重的内存限制，这一点上面已经提到。


### 3、如何将Memcached中item批量导入导出？

您不应该这样做！Memcached是一个非阻塞的服务器。任何可能导致Memcached暂停或瞬时拒绝服务的操作都应该值得深思熟虑。向 Memcached中批量导入数据往往不是您真正想要的！想象看，如果缓存数据在导出导入之间发生了变化，您就需要处理脏数据了；


### 4、Memcached的cache机制是怎样的？

Memcached主要的cache机制是LRU（最近最少用）算法+超时失效。当您存数据到Memcached中，可以指定该数据在缓存中可以呆多久Which is forever,

or some time in the future。如果Memcached的内存不够用了，过期的slabs会优先被替换，接着就轮到最老的未被使用的slabs。


### 5、Memcached最大的优势是什么？

Memcached最大的好处就是它带来了极佳的水平可扩展性，特别是在一个巨大的系统中。由于客户端自己做了一次哈希，那么我们很容易增加大量Memcached到集群中。Memcached之间没有相互通信，因此不会增加 Memcached的负载；没有多播协议，不会网络通信量爆炸（implode）。Memcached的集群很好用。内存不够了？增加几台Memcached吧；CPU不够用了？再增加几台吧；有多余的内存？在增加几台吧，不要浪费了。

基于Memcached的基本原则，可以相当轻松地构建出不同类型的缓存架构。除了这篇FAQ，在其他地方很容易找到详细资料的。


### 6、Memcached服务特点及工作原理是什么？

**1、** 完全基于内存缓存的

**2、** 节点之间相互独立

**3、** C/S模式架构，C语言编写，总共2000行代码。

**4、** 异步Ｉ/O 模型，使用libevent作为事件通知机制。

**5、** 被缓存的数据以key/value键值对形式存在的。

**6、** 全部数据存放于内存中，无持久性存储的设计，重启服务器，内存里的数据会丢失。

**7、** 当内存中缓存的数据容量达到启动时设定的内存值时，就自动使用LRU算法删除过期的缓存数据。

**8、** 可以对存储的数据设置过期时间，这样过期后的数据自动被清除，服务本身不会监控过期，而是在访问的时候查看key的时间戳,判断是否过期。

**9、** memcache会对设定的内存进行分块，再把块分组，然后再提供服务。


### 7、如何实现集群中的session共享存储？

Session是运行在一台服务器上的，所有的访问都会到达我们的唯一服务器上，这样我们可以根据客户端传来的sessionID，来获取session，或在对应Session不存在的情况下（session 生命周期到了/用户第一次登录），创建一个新的Session；但是，如果我们在集群环境下，假设我们有两台服务器A，B，用户的请求会由Nginx服务器进行转发（别的方案也是同理），用户登录时，Nginx将请求转发至服务器A上，A创建了新的session，并将SessionID返回给客户端，用户在浏览其他页面时，客户端验证登录状态，Nginx将请求转发至服务器B，由于B上并没有对应客户端发来sessionId的session，所以会重新创建一个新的session，并且再将这个新的sessionID返回给客户端，这样，我们可以想象一下，用户每一次操作都有1/2的概率进行再次的登录，这样不仅对用户体验特别差，还会让服务器上的session激增，加大服务器的运行压力。

**为了解决集群环境下的seesion共享问题，共有4种解决方案：**

**1、** 粘性session

粘性session是指Ngnix每次都将同一用户的所有请求转发至同一台服务器上，即将用户与服务器绑定。

**2、** 服务器session复制

即每次session发生变化时，创建或者修改，就广播给所有集群中的服务器，使所有的服务器上的session相同。

**3、** session共享

缓存session，使用Redis， Memcached。

**4、** session持久化

将session存储至数据库中，像操作数据一样才做session。


### 8、Memcached是如何做身份验证的？

没有身份认证机制！Memcached是运行在应用下层的软件（身份验证应该是应用上层的职责）。Memcached的客户端和服务器端之所以是轻量级的，部分原因就是完全没有实现身份验证机制。这样，Memcached可以很快地创建新连接，服务器端也无需任何配置。

如果您希望限制访问，您可以使用防火墙，或者让Memcached监听unix domain socket。


### 9、Memcached与Redis的区别？

**1、** Redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，zset，hash等数据结构的存储。而memcache只支持简单数据类型，需要客户端自己处理复杂对象

**2、** Redis支持数据的持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用（PS：持久化在rdb、aof）。

**3、** 由于Memcache没有持久化机制，因此宕机所有缓存数据失效。Redis配置为持久化，宕机重启后，将自动加载宕机时刻的数据到缓存系统中。具有更好的灾备机制。

**4、** Memcache可以使用Magent在客户端进行一致性hash做分布式。Redis支持在服务器端做分布式（PS:Twemproxy/Codis/Redis-cluster多种分布式实现方式）

**5、** Memcached的简单限制就是键（key）和Value的限制。最大键长为250个字符。可以接受的储存数据不能超过1MB（可修改配置文件变大），因为这是典型slab 的最大值，不适合虚拟机使用。而Redis的Key长度支持到512k。

**6、** Redis使用的是单线程模型，保证了数据按顺序提交。Memcache需要使用cas保证数据一致性。CAS（Check and Set）是一个确保并发一致性的机制，属于“乐观锁”范畴；原理很简单：拿版本号，操作，对比版本号，如果一致就操作，不一致就放弃任何操作

cpu利用。由于Redis只使用单核，而Memcached可以使用多核，所以平均每一个核上Redis在存储小数据时比Memcached性能更 高。而在100k以上的数据中，Memcached性能要高于Redis 。

**7、** memcache内存管理：使用Slab Allocation。原理相当简单，预先分配一系列大小固定的组，然后根据数据大小选择最合适的块存储。避免了内存碎片。（缺点：不能变长，浪费了一定空间）Memcached默认情况下下一个slab的最大值为前一个的1.25倍。

**8、** Redis内存管理： Redis通过定义一个数组来记录所有的内存分配情况， Redis采用的是包装的malloc/free，相较于Memcached的内存 管理方法来说，要简单很多。由于malloc 首先以链表的方式搜索已管理的内存中可用的空间分配，导致内存碎片比较多

### 10、Memcached是什么，有什么作用？

Memcached是一个开源的，高性能的内存绶存软件，从名称上看Mem就是内存的意思，而Cache就是缓存的意思。Memcached的作用：通过在事先规划好的内存空间中临时绶存数据库中的各类数据，以达到减少业务对数据库的直接高并发访问，从而达到提升数据库的访问性能，加速网站集群动态应用服务的能力。


### 11、Memcached能接受的key的最大长度是多少？
### 12、什么是二进制协议，我该关注吗？
### 13、Memcached和MySQL的query
### 14、简述Memcached内存管理机制原理？
### 15、如果缓存数据在导出导入之间过期了，您又怎么处理这些数据呢？
### 16、Memcached如何实现冗余机制？
### 17、Memcached是怎么工作的？
### 18、Memcached最大能存储多大的单个item？
### 19、Memcached服务在企业集群架构中有哪些应用场景？
### 20、Memcached的内存分配器是如何工作的？为什么不适用malloc/free！？为何要使用slabs？
### 21、Memcached是原子的吗？
### 22、Memcached能够更有效地使用内存吗？
### 23、Memcached的多线程是什么？如何使用它们？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
