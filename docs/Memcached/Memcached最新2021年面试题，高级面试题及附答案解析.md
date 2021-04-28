# Memcached最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Memcached的多线程是什么？如何使用它们？

线程就是定律（threads rule）！在Steven Grimm和Facebook的努力下，Memcached 1.2及更高版本拥有了多线程模式。多线程模式允许Memcached能够充分利用多个CPU，并在CPU之间共享所有的缓存数据。Memcached使用一种简单的锁机制来保证数据更新操作的互斥。相比在同一个物理机器上运行多个Memcached实例，这种方式能够更有效地处理multi gets。

如果您的系统负载并不重，也许您不需要启用多线程工作模式。如果您在运行一个拥有大规模硬件的、庞大的网站，您将会看到多线程的好处。

简单地总结一下：命令解析（Memcached在这里花了大部分时间）可以运行在多线程模式下。Memcached内部对数据的操作是基于很多全局锁的（因此这部分工作不是多线程的）。未来对多线程模式的改进，将移除大量的全局锁，提高Memcached在负载极高的场景下的性能。


### 2、Memcached与Redis的区别？

**1、** Redis不仅仅支持简单的k/v类型的数据，同时还提供list，set，zset，hash等数据结构的存储。而memcache只支持简单数据类型，需要客户端自己处理复杂对象

**2、** Redis支持数据的持久化，可以将内存中的数据保持在磁盘中，重启的时候可以再次加载进行使用（PS：持久化在rdb、aof）。

**3、** 由于Memcache没有持久化机制，因此宕机所有缓存数据失效。Redis配置为持久化，宕机重启后，将自动加载宕机时刻的数据到缓存系统中。具有更好的灾备机制。

**4、** Memcache可以使用Magent在客户端进行一致性hash做分布式。Redis支持在服务器端做分布式（PS:Twemproxy/Codis/Redis-cluster多种分布式实现方式）

**5、** Memcached的简单限制就是键（key）和Value的限制。最大键长为250个字符。可以接受的储存数据不能超过1MB（可修改配置文件变大），因为这是典型slab 的最大值，不适合虚拟机使用。而Redis的Key长度支持到512k。

**6、** Redis使用的是单线程模型，保证了数据按顺序提交。Memcache需要使用cas保证数据一致性。CAS（Check and Set）是一个确保并发一致性的机制，属于“乐观锁”范畴；原理很简单：拿版本号，操作，对比版本号，如果一致就操作，不一致就放弃任何操作

cpu利用。由于Redis只使用单核，而Memcached可以使用多核，所以平均每一个核上Redis在存储小数据时比Memcached性能更 高。而在100k以上的数据中，Memcached性能要高于Redis 。

**7、** memcache内存管理：使用Slab Allocation。原理相当简单，预先分配一系列大小固定的组，然后根据数据大小选择最合适的块存储。避免了内存碎片。（缺点：不能变长，浪费了一定空间）Memcached默认情况下下一个slab的最大值为前一个的1.25倍。

**8、** Redis内存管理： Redis通过定义一个数组来记录所有的内存分配情况， Redis采用的是包装的malloc/free，相较于Memcached的内存 管理方法来说，要简单很多。由于malloc 首先以链表的方式搜索已管理的内存中可用的空间分配，导致内存碎片比较多

### 3、Memcached如何处理容错的？

不处理！在Memcached节点失效的情况下，集群没有必要做任何容错处理。如果发生了节点失效，应对的措施完全取决于用户。

**节点失效时，下面列出几种方案供您选择：**

**1、** 忽略它！ 在失效节点被恢复或替换之前，还有很多其他节点可以应对节点失效带来的影响。

**2、** 把失效的节点从节点列表中移除。做这个操作千万要小心！在默认情况下（余数式哈希算法），客户端添加或移除节点，会导致所有的缓存数据不可用！因为哈希参照的节点列表变化了，大部分key会因为哈希值的改变而被映射到（与原来）不同的节点上。

**3、** 启动热备节点，接管失效节点所占用的IP。这样可以防止哈希紊乱（hashing chaos）。

**4、** 如果希望添加和移除节点，而不影响原先的哈希结果，可以使用一致性哈希算法（consistent hashing）。您可以百度一下一致性哈希算法。支持一致性哈希的客户端已经很成熟，而且被广泛使用。去尝试一下吧！

**5、** 两次哈希（reshing）。当客户端存取数据时，如果发现一个节点down了，就再做一次哈希（哈希算法与前一次不同），重新选择另一个节点（需要注意的时，客户端并没有把down的节点从节点列表中移除，下次还是有可能先哈希到它）。如果某个节点时好时坏，两次哈希的方法就有风险了，好的节点和坏的节点上都可能存在脏数据（stale data）。


### 4、Memcached最大的优势是什么？

Memcached最大的好处就是它带来了极佳的水平可扩展性，特别是在一个巨大的系统中。由于客户端自己做了一次哈希，那么我们很容易增加大量Memcached到集群中。Memcached之间没有相互通信，因此不会增加 Memcached的负载；没有多播协议，不会网络通信量爆炸（implode）。Memcached的集群很好用。内存不够了？增加几台Memcached吧；CPU不够用了？再增加几台吧；有多余的内存？在增加几台吧，不要浪费了。

基于Memcached的基本原则，可以相当轻松地构建出不同类型的缓存架构。除了这篇FAQ，在其他地方很容易找到详细资料的。


### 5、Memcached和服务器的local cache（比如PHP的APC、mmap文件等）相比，有什么优缺点？

首先，local cache有许多与上面(query cache)相同的问题。local cache能够利用的内存容量受到（单台）服务器空闲内存空间的限制。不过，local

cache有一点比Memcached和query cache都要好，那就是它不但可以存储任意的数据，而且没有网络存取的延迟。

**1、** local cache的数据查询更快。考虑把highly common的数据放在local cache中吧。如果每个页面都需要加载一些数量较少的数据，考虑把它们放在local

cached吧。

**2、** local cache缺少集体失效（group

invalidation）的特性。在Memcached集群中，删除或更新一个key会让所有的观察者觉察到。但是在local cache中, 我们只能通知所有的服务器刷新cache（很慢，不具扩展性），或者仅仅依赖缓存超时失效机制。

**3、** local cache面临着严重的内存限制，这一点上面已经提到。


### 6、简述Memcached内存管理机制原理？

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


### 7、Memcached是原子的吗？

所有的被发送到Memcached的单个命令是完全原子的。如果您针对同一份数据同时发送了一个set命令和一个get命令，它们不会影响对方。它们将被串行化、先后执行。即使在多线程模式，所有的命令都是原子的，除非程序有bug:)

命令序列不是原子的。如果您通过get命令获取了一个item，修改了它，然后想把它set回Memcached，我们不保证这个item没有被其他进程（process，未必是操作系统中的进程）操作过。在并发的情况下，您也可能覆写了一个被其他进程set的item。

Memcached 1.2.5以及更高版本，提供了gets和cas命令，它们可以解决上面的问题。如果您使用gets命令查询某个key的item，Memcached会给您返回该item当前值的唯一标识。如果您覆写了这个item并想把它写回到Memcached中，您可以通过cas命令把那个唯一标识一起发送给 Memcached。如果该item存放在Memcached中的唯一标识与您提供的一致，您的写操作将会成功。如果另一个进程在这期间也修改了这个 item，那么该item存放在Memcached中的唯一标识将会改变，您的写操作就会失败


### 8、Memcached能够更有效地使用内存吗？

Memcache客户端仅根据哈希算法来决定将某个key存储在哪个节点上，而不考虑节点的内存大小。因此，您可以在不同的节点上使用大小不等的缓存。但是一般都是这样做的：拥有较多内存的节点上可以运行多个Memcached实例，每个实例使用的内存跟其他节点上的实例相同。


### 9、Memcached能接受的key的最大长度是多少？

key的最大长度是250个字符。需要注意的是，250是Memcached服务器端内部的限制，如果您使用的客户端支持”key的前缀”或类似特性，那么key（前缀+原始key）的最大长度是可以超过250个字符的。我们推荐使用使用较短的key，因为可以节省内存和带宽。

**Memcached对item的过期时间有什么限制？**

过期时间最大可以达到30天。Memcached把传入的过期时间（时间段）解释成时间点后，一旦到了这个时间点，Memcached就把item置为失效状态。这是一个简单但obscure的机制。


### 10、Memcached如何实现冗余机制？

不实现！我们对这个问题感到很惊讶。Memcached应该是应用的缓存层。它的设计本身就不带有任何冗余机制。如果一个Memcached节点失去了所有数据，您应该可以从数据源（比如数据库）再次获取到数据。您应该特别注意，您的应用应该可以容忍节点的失效。不要写一些糟糕的查询代码，寄希望于 Memcached来保证一切！如果您担心节点失效会大大加重数据库的负担，那么您可以采取一些办法。比如您可以增加更多的节点（来减少丢失一个节点的影响），热备节点（在其他节点down了的时候接管IP），等等。


### 11、Memcached和MySQL的query
### 12、如何实现集群中的session共享存储？
### 13、Memcached服务特点及工作原理是什么？
### 14、如何将Memcached中item批量导入导出？
### 15、Memcached服务在企业集群架构中有哪些应用场景？
### 16、Memcached是如何做身份验证的？
### 17、Memcached的内存分配器是如何工作的？为什么不适用malloc/free！？为何要使用slabs？
### 18、Memcached最大能存储多大的单个item？
### 19、Memcached是怎么工作的？
### 20、Memcached是什么，有什么作用？
### 21、Memcached的cache机制是怎样的？
### 22、什么是二进制协议，我该关注吗？
### 23、如果缓存数据在导出导入之间过期了，您又怎么处理这些数据呢？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
