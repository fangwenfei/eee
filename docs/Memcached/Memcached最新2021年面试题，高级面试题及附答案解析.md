# Memcached最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Memcached如何实现冗余机制？

不实现！我们对这个问题感到很惊讶。Memcached应该是应用的缓存层。它的设计本身就不带有任何冗余机制。如果一个Memcached节点失去了所有数据，您应该可以从数据源（比如数据库）再次获取到数据。您应该特别注意，您的应用应该可以容忍节点的失效。不要写一些糟糕的查询代码，寄希望于 Memcached来保证一切！如果您担心节点失效会大大加重数据库的负担，那么您可以采取一些办法。比如您可以增加更多的节点（来减少丢失一个节点的影响），热备节点（在其他节点down了的时候接管IP），等等。


### 2、Memcached和服务器的local cache（比如PHP的APC、mmap文件等）相比，有什么优缺点？

首先，local cache有许多与上面(query cache)相同的问题。local cache能够利用的内存容量受到（单台）服务器空闲内存空间的限制。不过，local

cache有一点比Memcached和query cache都要好，那就是它不但可以存储任意的数据，而且没有网络存取的延迟。

**1、** local cache的数据查询更快。考虑把highly common的数据放在local cache中吧。如果每个页面都需要加载一些数量较少的数据，考虑把它们放在local

cached吧。

**2、** local cache缺少集体失效（group

invalidation）的特性。在Memcached集群中，删除或更新一个key会让所有的观察者觉察到。但是在local cache中, 我们只能通知所有的服务器刷新cache（很慢，不具扩展性），或者仅仅依赖缓存超时失效机制。

**3、** local cache面临着严重的内存限制，这一点上面已经提到。


### 3、Memcached服务在企业集群架构中有哪些应用场景？

**一、作为数据库的前端缓存应用**

**a、完整缓存（易），静态缓存**

例如：商品分类（京东），以及商品信息，可事先放在内存里，然后再对外提供数据访问，这种先放到内存，我们称之为预热，（先把数据存缓存中），用户访问时可以只读取Memcached缓存，不读取数据库了。

**b、执点缓存（难）**

需要前端web程序配合，只缓存热点的数据，即缓存经常被访问的数据。

先预热数据库里的基础数据，然后在动态更新，选读取缓存，如果缓存里没有对应的数据，程序再去读取数据库，然后程序把读取的新数据放入缓存存储。

**特殊说明 ：**

**1、** 如果碰到电商秒杀等高并发的业务，一定要事先预热，或者其它思想实现，例如：称杀只是获取资格，而不是瞬间秒杀到手商品。

那么什么是获取资格？_

**2、** 就是在数据库中，把0标成1.就有资格啦。再慢慢的去领取商品订单。因为秒杀过程太长会占用服务器资源。

**3、** 如果数据更新，同时触发缓存更新，防止给用户过期数据。

**4、** 对于持久化缓存存储系统，例如：Redis，可以替代一部分数据库的存储，一些简单的数据业务，投票，统计，好友关注，商品分类等。nosql= not only sql

**二、作业集群的session会话共享存储**

**1、** Memcached服务在不同企业业务应用场景中的工作流程

当web程序需要访问后端数据库获取数据时会优先访问Memcached内存缓存，如果缓存中有数据就直接获取返回前端服务及用户，如果没有数据（没有命中），在由程序请求后端的数据库服务器，获取到对应的数据后，除了返回给前端服务及用户数据外，还会把数据放到Memcached内存中进行缓存，等待下次请求被访问，Memcache内存始终是数据库的挡箭牌，从而大大的减轻数据库的访问压力，提高整个网站架构的响应速度，提升了用户体验。

当程序更新，修改或删除数据库中已有的数据时，会同时发送请求通知Memcached已经缓存的同一个ID内容的旧数据失效，从而保证Memcache中数据和数据库中的数据一致。

如果在高并发场合，除了通知Memcached过程的缓存失效外，还会通过相关机制，使得在用户访问新数据前，通过程序预先把更新过的数据推送到memcache中缓存起来，这样可以减少数据库的访问压力，提升Memcached中缓存命中率。

数据库插件可以再写入更新数据库后，自动抛给MC缓存起来，自身不Cache.

**2、** Memcached服务分布式集群如何实现？

**特殊说明：**

Memcached集群和web服务集群是不一样的，所有Memcached的数据总和才是数据库的数据。每台Memcached都是部分数据。

（一台Memcached的数据，就是一部分MySQL数据库的数据）

**1、** 程序端实现

程序加载所有mc的ip列表，通过对key做hash (一致性哈希算法)

例如：web1 (key)===>对应A,B,C,D,E,F,G…..若干台服务器。（通过哈希算法实现）

**2、** 负载均衡器

通过对key做hash (一致性哈希算法)

一致哈希算法的目的是不但保证每个对象只请求一个对应的服务器，而且当节点宕机，缓存服务器的更新重新分配比例降到最低。


### 4、Memcached的多线程是什么？如何使用它们？

线程就是定律（threads rule）！在Steven Grimm和Facebook的努力下，Memcached 1.2及更高版本拥有了多线程模式。多线程模式允许Memcached能够充分利用多个CPU，并在CPU之间共享所有的缓存数据。Memcached使用一种简单的锁机制来保证数据更新操作的互斥。相比在同一个物理机器上运行多个Memcached实例，这种方式能够更有效地处理multi gets。

如果您的系统负载并不重，也许您不需要启用多线程工作模式。如果您在运行一个拥有大规模硬件的、庞大的网站，您将会看到多线程的好处。

简单地总结一下：命令解析（Memcached在这里花了大部分时间）可以运行在多线程模式下。Memcached内部对数据的操作是基于很多全局锁的（因此这部分工作不是多线程的）。未来对多线程模式的改进，将移除大量的全局锁，提高Memcached在负载极高的场景下的性能。


### 5、Memcached和MySQL的query

**cache相比，有什么优缺点？**

把Memcached引入应用中，还是需要不少工作量的。MySQL有个使用方便的query cache，可以自动地缓存SQL查询的结果，被缓存的SQL查询可以被反复地快速执行。Memcached与之相比，怎么样呢？MySQL的query cache是集中式的，连接到该query cache的MySQL服务器都会受益。

**1、** 当您修改表时，MySQL的query cache会立刻被刷新（flush）。存储一个Memcached item只需要很少的时间，但是当写操作很频繁时，MySQL的query cache会经常让所有缓存数据都失效。

**2、** 在多核CPU上，MySQL的query cache会遇到扩展问题（scalability issues）。在多核CPU上，query cache会增加一个全局锁（global lock）, 由于需要刷新更多的缓存数据，速度会变得更慢。

**3、** 在 MySQL的query cache中，我们是不能存储任意的数据的（只能是SQL查询结果）。而利用Memcached，我们可以搭建出各种高效的缓存。比如，可以执行多个独立的查询，构建出一个用户对象（user object），然后将用户对象缓存到Memcached中。而query cache是SQL语句级别的，不可能做到这一点。在小的网站中，query cache会有所帮助，但随着网站规模的增加，query cache的弊将大于利。

**4、** query cache能够利用的内存容量受到MySQL服务器空闲内存空间的限制。给数据库服务器增加更多的内存来缓存数据，固然是很好的。但是，有了Memcached，只要您有空闲的内存，都可以用来增加Memcached集群的规模，然后您就可以缓存更多的数据。


### 6、如何实现集群中的session共享存储？

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


### 7、Memcached服务特点及工作原理是什么？

**1、** 完全基于内存缓存的

**2、** 节点之间相互独立

**3、** C/S模式架构，C语言编写，总共2000行代码。

**4、** 异步Ｉ/O 模型，使用libevent作为事件通知机制。

**5、** 被缓存的数据以key/value键值对形式存在的。

**6、** 全部数据存放于内存中，无持久性存储的设计，重启服务器，内存里的数据会丢失。

**7、** 当内存中缓存的数据容量达到启动时设定的内存值时，就自动使用LRU算法删除过期的缓存数据。

**8、** 可以对存储的数据设置过期时间，这样过期后的数据自动被清除，服务本身不会监控过期，而是在访问的时候查看key的时间戳,判断是否过期。

**9、** memcache会对设定的内存进行分块，再把块分组，然后再提供服务。


### 8、Memcached最大能存储多大的单个item？
### 9、Memcached的内存分配器是如何工作的？为什么不适用malloc/free！？为何要使用slabs？
### 10、如何将Memcached中item批量导入导出？
### 11、Memcached是怎么工作的？
### 12、Memcached能够更有效地使用内存吗？
### 13、如果缓存数据在导出导入之间过期了，您又怎么处理这些数据呢？
### 14、Memcached是什么，有什么作用？
### 15、简述Memcached内存管理机制原理？
### 16、Memcached与Redis的区别？
### 17、Memcached能接受的key的最大长度是多少？
### 18、Memcached是如何做身份验证的？
### 19、Memcached如何处理容错的？
### 20、Memcached是原子的吗？
### 21、什么是二进制协议，我该关注吗？
### 22、Memcached最大的优势是什么？
### 23、Memcached的cache机制是怎样的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
