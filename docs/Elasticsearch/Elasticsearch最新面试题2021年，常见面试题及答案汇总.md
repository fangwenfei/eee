# Elasticsearch最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、您能否列出 与 ELK日志分析相关的应用场景？

**1、** 电子商务搜索解决方案

**2、** 欺诈识别

**3、** 市场情报

**4、** 风险管理

**5、** 安全分析 等。

### 2、什么是ElasticSearch索引？

索引（名词）： 一个索引(index)就像是传统关系数据库中的数据库，它是相关文档存储的地方，index的复数是indices或indexes。

索引（动词）：「索引一个文档」表示把一个文档存储到索引（名词）里，以便它可以被检索或者查询。这很像SQL中的INSERT关键字，差别是，如果文档已经存在，新的文档将覆盖旧的文档。


### 3、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法？

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


### 4、什么是ElasticSearch脑裂？

一个正常es集群中只有一个主节点，主节点负责管理整个集群，集群的所有节点都会选择同一个节点作 为主节点所以无论访问那个节点都可以查看集群的状态信息。而脑裂问题的出现就是因为从节点在选择 主节点上出现分歧导致一个集群出现多个主节点从而使集群分裂，使得集群处于异常状态。


### 5、您能解释一下 Elasticsearch 中的 Explore API 吗？

没有用过，这是 Graph （收费功能）相关的API。

点到为止即可，类似问题实际开发现用现查，类似问题没有什么意义。

[https://www.elastic.co/guide/en/elasticsearch/reference/current/graph-explore-api.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/graph-explore-api.html)


### 6、elasticsearch 数据预热

数据预热是指，每隔一段时间，将热数据

手动在后台查询一遍，将热数据刷新到fileSystem cache上


### 7、Elasticsearch是如何实现master选举的？

面试官：想了解ES集群的底层原理，不再只关注业务层面了。

**前置前提：**

**1、** 只有候选主节点（master：true）的节点才能成为主节点。

**1、** 最小主节点数（min_master_nodes）的目的是防止脑裂。

这个我看了各种网上分析的版本和源码分析的书籍，云里雾里。

核对了一下代码，核心入口为findMaster，选择主节点成功返回对应Master，否则返回null。选举流程大致描述如下：

第一步：确认候选主节点数达标，elasticsearch.yml设置的值discovery.zen.minimum_master_nodes；

第二步：比较：先判定是否具备master资格，具备候选主节点资格的优先返回；若两节点都为候选主节点，则id小的值会主节点。注意这里的id为string类型。

**题外话：获取节点id的方法。**

**1、** GET /_cat/nodes?v&h=ip,port,heapPercent,heapMax,id,name

**2、** ip    port heapPercent heapMax id  name

**3、** 127.0.0.1 9300     39  1.9gb Hk9w Hk9wFwU

**补充：**

**1、** Elasticsearch 的选主是 ZenDiscovery 模块负责的，主要包含 Ping（节点之间通过这个 RPC 来发现彼此）和 Unicast（单播模块包含一个主机列表以控制哪些节点需要 ping 通）这两部分；

**2、** 对所有可以成为 master 的节点（node.master: true）根据 nodeId 字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第 0 位）节点，暂且认为它是 master 节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为 master 节点数 n/2+1）并且该节点自己也选举自己，那这个节点就是 master。否则重新选举一直到满足上述条件。

**4、** master 节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data 节点可以关闭 http 功能。



### 8、您能否分步介绍如何启动 Elasticsearch 服务器？

启动方式有很多种，一般 bin 路径下

```
./elasticsearch -d
```

就可以后台启动。

打开浏览器输入 [http://ES](http://ES) IP:9200 就能知道集群是否启动成功。

如果启动报错，日志里会有详细信息，逐条核对解决就可以。


### 9、如何监控 Elasticsearch 集群状态？

Marvel 让你可以很简单的通过 Kibana 监控 Elasticsearch。你可以实时查看你的集群健康状态和性能，也可以分析过去的集群、索引和节点指标。


### 10、elasticsearch 了解多少，说说你们公司 es 的集群架构，索引数据大小，分片有多少，以及一些调优手段 。

面试官：想了解应聘者之前公司接触的 ES 使用场景、规模，有没有做过比较大规模的索引设计、规划、调优。

解如实结合自己的实践场景回答即可。

比如：ES 集群架构 13 个节点，索引根据通道不同共 20+索引，根据日期，每日递增 20+，索引：10 分片，每日递增 1 亿+数据，每个通道每天索引大小控制：

150GB 之内。

仅索引层面调优手段：

**设计阶段调优**

**1、** 根据业务增量需求，采取基于日期模板创建索引，通过 roll over API 滚动索引；

**2、** 使用别名进行索引管理；

**3、** 每天凌晨定时对索引做 force_merge 操作，以释放空间；

**4、** 采取冷热分离机制，热数据存储到 SSD，提高检索效率；冷数据定期进行 shrink操作，以缩减存储；

**5、** 采取 curator 进行索引的生命周期管理；

**6、** 仅针对需要分词的字段，合理的设置分词器；

**7、** Mapping 阶段充分结合各个字段的属性，是否需要检索、是否需要存储等。……..

**写入调优**

**1、** 写入前副本数设置为 0；

**2、** 写入前关闭 refresh_interval 设置为-1，禁用刷新机制；

**3、** 写入过程中：采取 bulk 批量写入；

**4、** 写入后恢复副本数和刷新间隔；

**5、** 尽量使用自动生成的 id。

**查询调优**

**1、** 禁用 wildcard；

**2、** 禁用批量 terms（成百上千的场景）；

**3、** 充分利用倒排索引机制，能 keyword 类型尽量 keyword；

**4、** 数据量大时候，可以先基于时间敲定索引再检索；

**5、** 设置合理的路由机制。

**其他调优**

部署调优，业务调优等。

上面的提及一部分，面试者就基本对你之前的实践或者运维经验有所评估了。


### 11、elasticsearch 的 document设计
### 12、您能否说明当前可下载的稳定Elasticsearch版本？
### 13、Elasticsearch中的 Ingest 节点如何工作？
### 14、如何使用 Elasticsearch Tokenizer？
### 15、详细描述一下ElasticSearch更新和删除文档的过程
### 16、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 17、elasticsearch 索引数据多了怎么办，如何调优，部署
### 18、Elasticsearch Analyzer 中的字符过滤器如何利用？
### 19、详细描述一下 Elasticsearch 索引文档的过程。
### 20、是否了解字典树？
### 21、拼写纠错是如何实现的？
### 22、简要介绍一下Elasticsearch？
### 23、你之前公司的ElasticSearch集群，一个Node一般会分配几个分片？
### 24、客户端在和集群连接时，如何选择特定的节点执行请求的？
### 25、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
