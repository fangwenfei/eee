# Memcached最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Memcached的cache机制是怎样的？

Memcached主要的cache机制是LRU（最近最少用）算法+超时失效。当您存数据到Memcached中，可以指定该数据在缓存中可以呆多久Which is forever,

or some time in the future。如果Memcached的内存不够用了，过期的slabs会优先被替换，接着就轮到最老的未被使用的slabs。


### 2、简述Memcached内存管理机制原理？

早期的Memcached内存管理方式是通过malloc的分配的内存，使用完后通过free来回收内存，这种方式容易产生内存碎片，并降低操作系统对内存的管理效率。加重操作系统内存管理器的负担，最坏的情况下，会导致操作系统比Memcached进程本身还慢，为了解决这个问题，Slab Allocation内存分配机制就延生了。

**现在Memcached利用Slab Allocation机制来分配和管理内存**

SlabAllocation机制原理是按照预先规定的大小，将分配给Memcached的内存分割成特定长度的内存块（chunk)，再把尺寸相同的内存块，分成组

（chunks slab class),这些内存块不会释放，可以重复利用。

而且，slab allocator还有重复使用已分配的内存的目的。 也就是说，分配到的内存不会释放，而是重复利用。

**Slab Allocation的主要术语**

**Page**

分配给Slab的内存空间，默认是1MB。分配给Slab之后根据slab的大小切分成chunk。

**Chunk**

用于缓存记录的内存空间。

**SlabClass**

特定大小的chunk的组。

集群架构方面的问题


### 3、如何将Memcached中item批量导入导出？

您不应该这样做！Memcached是一个非阻塞的服务器。任何可能导致Memcached暂停或瞬时拒绝服务的操作都应该值得深思熟虑。向 Memcached中批量导入数据往往不是您真正想要的！想象看，如果缓存数据在导出导入之间发生了变化，您就需要处理脏数据了；


### 4、Memcached能接受的key的最大长度是多少？

key的最大长度是250个字符。需要注意的是，250是Memcached服务器端内部的限制，如果您使用的客户端支持”key的前缀”或类似特性，那么key（前缀+原始key）的最大长度是可以超过250个字符的。我们推荐使用使用较短的key，因为可以节省内存和带宽。

**Memcached对item的过期时间有什么限制？**

过期时间最大可以达到30天。Memcached把传入的过期时间（时间段）解释成时间点后，一旦到了这个时间点，Memcached就把item置为失效状态。这是一个简单但obscure的机制。


### 5、Memcached和服务器的local cache（比如PHP的APC、mmap文件等）相比，有什么优缺点？

首先，local cache有许多与上面(query cache)相同的问题。local cache能够利用的内存容量受到（单台）服务器空闲内存空间的限制。不过，local

cache有一点比Memcached和query cache都要好，那就是它不但可以存储任意的数据，而且没有网络存取的延迟。

**1、** local cache的数据查询更快。考虑把highly common的数据放在local cache中吧。如果每个页面都需要加载一些数量较少的数据，考虑把它们放在local

cached吧。

**2、** local cache缺少集体失效（group

invalidation）的特性。在Memcached集群中，删除或更新一个key会让所有的观察者觉察到。但是在local cache中, 我们只能通知所有的服务器刷新cache（很慢，不具扩展性），或者仅仅依赖缓存超时失效机制。

**3、** local cache面临着严重的内存限制，这一点上面已经提到。


### 6、Memcached能够更有效地使用内存吗？

Memcache客户端仅根据哈希算法来决定将某个key存储在哪个节点上，而不考虑节点的内存大小。因此，您可以在不同的节点上使用大小不等的缓存。但是一般都是这样做的：拥有较多内存的节点上可以运行多个Memcached实例，每个实例使用的内存跟其他节点上的实例相同。


### 7、Memcached最大能存储多大的单个item？

1MB。如果你的数据大于1MB，可以考虑在客户端压缩或拆分到多个key中。

为什么单个item的大小被限制在1M byte之内？

啊…这是一个大家经常问的问题！

**简单的回因为内存分配器的算法就是这样的。**

详细的回Memcached的内存存储引擎（引擎将来可插拔…），使用slabs来管理内存。内存被分成大小不等的slabs chunks（先分成大小相等的slabs，然后每个slab被分成大小相等chunks，不同slab的chunk大小是不相等的）。chunk的大小依次从一个最小数开始，按某个因子增长，直到达到最大的可能值。


### 8、Memcached与Redis的区别？

**1、** Redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，zset，hash等数据结构的存储。而memcache只支持简单数据类型，需要客户端自己处理复杂对象

**2、** Redis支持数据的持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用（PS：持久化在rdb、aof）。

**3、** 由于Memcache没有持久化机制，因此宕机所有缓存数据失效。Redis配置为持久化，宕机重启后，将自动加载宕机时刻的数据到缓存系统中。具有更好的灾备机制。

**4、** Memcache可以使用Magent在客户端进行一致性hash做分布式。Redis支持在服务器端做分布式（PS:Twemproxy/Codis/Redis-cluster多种分布式实现方式）

**5、** Memcached的简单限制就是键（key）和Value的限制。最大键长为250个字符。可以接受的储存数据不能超过1MB（可修改配置文件变大），因为这是典型slab 的最大值，不适合虚拟机使用。而Redis的Key长度支持到512k。

**6、** Redis使用的是单线程模型，保证了数据按顺序提交。Memcache需要使用cas保证数据一致性。CAS（Check and Set）是一个确保并发一致性的机制，属于“乐观锁”范畴；原理很简单：拿版本号，操作，对比版本号，如果一致就操作，不一致就放弃任何操作

cpu利用。由于Redis只使用单核，而Memcached可以使用多核，所以平均每一个核上Redis在存储小数据时比Memcached性能更 高。而在100k以上的数据中，Memcached性能要高于Redis 。

**7、** memcache内存管理：使用Slab Allocation。原理相当简单，预先分配一系列大小固定的组，然后根据数据大小选择最合适的块存储。避免了内存碎片。（缺点：不能变长，浪费了一定空间）Memcached默认情况下下一个slab的最大值为前一个的1.25倍。

**8、** Redis内存管理： Redis通过定义一个数组来记录所有的内存分配情况， Redis采用的是包装的malloc/free，相较于Memcached的内存 管理方法来说，要简单很多。由于malloc 首先以链表的方式搜索已管理的内存中可用的空间分配，导致内存碎片比较多

### 9、Memcached最大的优势是什么？

Memcached最大的好处就是它带来了极佳的水平可扩展性，特别是在一个巨大的系统中。由于客户端自己做了一次哈希，那么我们很容易增加大量Memcached到集群中。Memcached之间没有相互通信，因此不会增加 Memcached的负载；没有多播协议，不会网络通信量爆炸（implode）。Memcached的集群很好用。内存不够了？增加几台Memcached吧；CPU不够用了？再增加几台吧；有多余的内存？在增加几台吧，不要浪费了。

基于Memcached的基本原则，可以相当轻松地构建出不同类型的缓存架构。除了这篇FAQ，在其他地方很容易找到详细资料的。


### 10、Memcached的内存分配器是如何工作的？为什么不适用malloc/free！？为何要使用slabs？

实际上，这是一个编译时选项。默认会使用内部的slab分配器。您确实确实应该使用内建的slab分配器。最早的时候，Memcached只使用 malloc/free来管理内存。然而，这种方式不能与OS的内存管理以前很好地工作。反复地malloc/free造成了内存碎片，OS最终花费大量的时间去查找连续的内存块来满足malloc的请求，而不是运行Memcached进程。如果您不同意，当然可以使用malloc！只是不要在邮件列表中抱怨啊

slab分配器就是为了解决这个问题而生的。内存被分配并划分成chunks，一直被重复使用。因为内存被划分成大小不等的slabs，如果item 的大小与被选择存放它的slab不是很合适的话，就会浪费一些内存。Steven Grimm正在这方面已经做出了有效的改进。


### 11、什么是二进制协议，我该关注吗？
### 12、如何实现集群中的session共享存储？
### 13、Memcached服务特点及工作原理是什么？
### 14、Memcached是怎么工作的？
### 15、Memcached是什么，有什么作用？
### 16、Memcached服务在企业集群架构中有哪些应用场景？
### 17、Memcached和MySQL的query
### 18、Memcached是如何做身份验证的？
### 19、Memcached如何实现冗余机制？
### 20、Memcached如何处理容错的？
### 21、Memcached是原子的吗？
### 22、Memcached的多线程是什么？如何使用它们？
### 23、如果缓存数据在导出导入之间过期了，您又怎么处理这些数据呢？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
