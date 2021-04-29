# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、能列出 10 个使用 Elasticsearch 作为其搜索引擎或数据库的公司吗？

这个问题，铭毅本来想删掉。但仔细一想，至少能看出求职者的视野够不够开阔。

参与过 Elastic中文社区活动或者经常关注社区动态的就知道，公司太多了，列举如下（排名不分先后）：

1、阿里

2、腾讯

3、百度

4、京东

5、美团

6、小米

7、滴滴

8、携程

**9、** 今日头条

**10、** 贝壳找房

**11、** 360

**12、** IBM

**13、** 顺丰快递

几乎我们能想到的互联网公司都在使用 Elasticsearch。

关注 TOP 互联网公司的相关技术的动态和技术博客，也是一种非常好的学习方式。


### 2、Elasticsearch Analyzer 中的字符过滤器如何利用？

字符过滤器将原始文本作为字符流接收，并可以通过添加，删除或更改字符来转换字符流。

字符过滤分类如下：

**HTML Strip Character Filter.**

用途：删除HTML元素，如**，并解码HTML实体，如＆amp 。**

**Mapping Character Filter**

用途：替换指定的字符。

**Pattern Replace Character Filter**

用途：基于正则表达式替换指定的字符。


### 3、请解释一下 Elasticsearch 中聚合？

聚合有助于从搜索中使用的查询中收集数据，聚合为各种统计指标，便于统计信息或做其他分析。聚合可帮助回答以下问题：

**1、** 我的网站平均加载时间是多少？

**2、** 根据交易量，谁是我最有价值的客户？

**3、** 什么会被视为我网络上的大文件？

**4、** 每个产品类别中有多少个产品？

**聚合的分三类：**

主要查看7.10 的官方文档，早期是4个分类，别大意啊！

**分桶 Bucket 聚合**

根据字段值，范围或其他条件将文档分组为桶（也称为箱）。

**指标 Metric 聚合**

从字段值计算指标（例如总和或平均值）的指标聚合。

**管道 Pipeline 聚合**

子聚合，从其他聚合（而不是文档或字段）获取输入。


### 4、客户端在和集群连接时，如何选择特定的节点执行请求的？

TransportClient 利用 transport 模块远程连接一个 elasticsearch 集群。它并不加入到集群中，只是简单的获得一个或者多个初始化的 transport 地址，并以 轮询 的方式与这些地址进行通信。


### 5、ElasticSearch是如何实现Master选举的？

ElasticSearch的选举是ZenDiscovery模块负责的，主要包含Ping（节点之间通过这个RPC来发现彼此）和Unicast（单播模块包含一个主机列表以控制哪些节点需要ping通）这两部分；

对所有可以成为master的节点（node.master: true）根据nodeId字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第0位）节点，暂且认为它是master节点。

如果对某个节点的投票数达到一定的值（可以成为master节点数n/2+1）并且该节点自己也选举自己， 那这个节点就是master。否则重新选举一直到满足上述条件。


### 6、如何使用 Elasticsearch Tokenizer？

Tokenizer 接收字符流（如果包含了字符过滤，则接收过滤后的字符流；否则，接收原始字符流），将其分词。同时记录分词后的顺序或位置(position)，以及开始值（start_offset）和偏移值(end_offset-start_offset)。


### 7、ES在生产集群的部署架构是什么，每个索引有多大的数据量，每个索引有多少分片

**生产环境部署情况**

**1、** es生产集群我们部署了5台机器，每台机器是6核64G的，集群总内存是320G

**2、** 我们es集群的日增量数据大概是2000万条，每天日增量数据大概是500MB，

**3、** 每月增量数据大概是6亿，15G。目前系统已经运行了几个月，现在es集群里数据总量大概是100G左右。

**4、** 目前线上有5个索引（这个结合你们自己业务来，看看自己有哪些数据可以放es的），

**5、** 每个索引的数据量大概是20G，所以这个数据量之内，我们每个索引分配的是8个shard，比默认的5个shard多了3个shard。



### 8、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法？

**1、** 64 GB 内存的机器是非常理想的， 但是 32 GB 和 16 GB 机器也是很常见的。少于 8 GB 会适得其反。

**2、** 如果你要在更快的 CPUs 和更多的核心之间选择，选择更多的核心更好。多个内核提供的额外并发远胜过稍微快一点点的时钟频率。

**3、** 如果你负担得起 SSD，它将远远超出任何旋转介质。基于 SSD 的节点，查询和索引性能都有提升。如果你负担得起，SSD 是一个好的选择。

**4、** 即使数据中心们近在咫尺，也要避免集群跨越多个数据中心。绝对要避免集群跨越大的地理距离。

**5、** 请确保运行你应用程序的 JVM 和服务器的 JVM 是完全一样的。在Elasticsearch 的几个地方，使用 Java 的本地序列化。

**6、** 通过设置 gateway.recover_after_nodes、gateway.expected_nodes、gateway.recover_after_time 可以在集群重启的时候避免过多的分片交换，这可能会让数据恢复从数个小时缩短为几秒钟。

**7、** Elasticsearch 默认被配置为使用单播发现，以防止节点无意中加入集群。只有在同一台机器上运行的节点才会自动组成集群。最好使用单播代替组播。

**8、** 不要随意修改垃圾回收器（CMS）和各个线程池的大小。

**9、** 把你的内存的（少于）一半给 Lucene（但不要超过 32 GB！），通过ES_HEAP_SIZE 环境变量设置。

**10、** 内存交换到磁盘对服务器性能来说是致命的。如果内存交换到磁盘上，一个100 微秒的操作可能变成 10 毫秒。再想想那么多 10 微秒的操作时延累加起来。不难看出 swapping 对于性能是多么可怕。

**11、** Lucene 使用了_大量 的_文件。同时，Elasticsearch 在节点和 HTTP 客户端之间进行通信也使用了大量的套接字。所有这一切都需要足够的文件描述符。你应该增加你的文件描述符，设置一个很大的值，如 64,000。

补充：索引阶段性能提升方法.

**1、** 使用批量请求并调整其大小：每次批量数据 5–15 MB 大是个不错的起始点。

**2、存储：**使用 SSD

**3、段和合并：**Elasticsearch 默认值是 20 MB/s，对机械磁盘应该是个不错的设置。如果你用的是 SSD，可以考虑提高到 100–200 MB/s。如果你在做批量导入，完全不在意搜索，你可以彻底关掉合并限流。另外还可以增加index.translog.flush_threshold_size 设置，从默认的 512 MB 到更大一些的值，比如 1 GB，这可以在一次清空触发的时候在事务日志里积累出更大的段。

**4、** 如果你的搜索结果不需要近实时的准确度，考虑把每个索引的index.refresh_interval 改到 30s。

**5、** 如果你在做大批量导入，考虑通过设置 index.number_of_replicas: 0 关闭副本。


### 9、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？

Elasticsearch 提供的首个近似聚合是 cardinality 度量。它提供一个字段的基数，即该字段的 _distinct_ 或者 _unique_ 值的数目。它是基于 HLL 算法的。HLL 会先对我们的输入作哈希运算，然后根据哈希运算的结果中的 bits 做概率估算从而得到

基数。其特点是：可配置的精度，用来控制内存的使用（更精确 ＝ 更多内存）；小的数据集精度是非常高的；我们可以通过配置参数，来设置去重需要的固定内存使用量。无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关。


### 10、elasticsearch 的 filesystem

es每次走fileSystem cache查询速度是最快的

所以将每个查询的数据50% 容量

= fileSystem cache 容量。


### 11、ElasticSearch中的倒排索引是什么？
### 12、ElasticSearch中的副本是什么？
### 13、elasticsearch 实际设计
### 14、elasticsearch 分布式架构原理
### 15、解释一下 Elasticsearch 的 分片？
### 16、elasticsearch 冷热分离
### 17、Elasticsearch 支持哪些类型的查询？
### 18、详细说明ELK Stack及其内容？
### 19、Elasticsearch中的 Ingest 节点如何工作？
### 20、解释一下 Elasticsearch Node？
### 21、elasticsearch的倒排索引是什么
### 22、Elasticsearch在部署时，对Linux的设置有哪些优化方法
### 23、ElasticSearch中的分析器是什么？
### 24、是否了解字典树？
### 25、拼写纠错是如何实现的？
### 26、解释一下 Elasticsearch 集群中的 Type 的概念 ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
