# Elasticsearch最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、详细描述一下 Elasticsearch 搜索的过程。

**1、** 搜索被执行成一个两阶段过程，我们称之为 Query Then Fetch；

**2、** 在初始查询阶段时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。

PS：在搜索的时候是会查询 Filesystem Cache 的，但是有部分数据还在 Memory Buffer，所以搜索是近实时的。

**3、** 每个分片返回各自优先队列中 所有文档的 ID 和排序值 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。

**4、** 接下来就是 取回阶段，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 _丰富_ 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。

**5、** 补充：Query Then Fetch 的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch 增加了一个预查询的处理，询问 Term 和 Document frequency，这个评分更准确，但是性能会变差。

![70_6.png][70_6.png]


### 2、ES更新数据的执行流程？

(1) 将原来的doc标识为deleted状态，然后新写入一条数据。

(2) buffer每refresh一次，就会产生一个segmentfile，所以默认情况下是1s一个segmentfile，segmentfile会越来越多，此时会定期执行merge。

(3) 每次merge时,会将多个segmentfile合并成一个，同时这里会将标识为deleted的doc给物理删除掉，然后将新的segmentfile写入磁盘，这里会写一个commitpoint，标识所有新的segmentfile，然后打开segmentfile供搜索使用，同时删除旧的segmentfile。


### 3、介绍一下你们的个性化搜索方案？

SEE 基于 word2vec 和 Elasticsearch 实现个性化搜索


### 4、解释一下Elasticsearch Cluster？

Elasticsearch 集群是一组连接在一起的一个或多个 Elasticsearch 节点实例。

Elasticsearch 集群的功能在于在集群中的所有节点之间分配任务，进行搜索和建立索引。


### 5、介绍下你们电商搜索的整体技术架构

![70_7.png][70_7.png]


### 6、请解释有关 Elasticsearch的 NRT？

从文档索引（写入）到可搜索到之间的延迟默认一秒钟，因此Elasticsearch是近实时（NRT）搜索平台。

也就是说：文档写入，最快一秒钟被索引到，不能再快了。

写入调优的时候，我们通常会动态调整：refresh_interval = 30s 或者更达值，以使得写入数据更晚一点时间被搜索到。


### 7、在并发情况下，Elasticsearch 如果保证读写一致？

**1、** 可以通过版本号使用乐观并发控制，以确保新版本不会被旧版本覆盖，**由应用**

**层来处理具体的冲突；**

**2、** 另外对于写操作，一致性级别支持 quorum/one/all，默认为 quorum，即只有当大多数分片可用时才允许写操作。但即使大多数可用，也可能存在因为网络等原因导致写入副本失败，这样该副本被认为故障，分片将会在一个不同的节点

上重建。

**3、** 对于读操作，可以设置 replication 为 sync(默认)，这使得操作在主分片和副本分片都完成后才会返回；如果设置 replication 为 async 时，也可以通过设置搜索请求参数_preference 为 primary 来查询主分片，确保文档是最新版本。


### 8、ElasticSearch主分片数量可以在后期更改吗？为什么？

不可以，因为根据路由算法shard = hash(document_id) % (num_of_primary_shards)，当主分片数量变化时会影响数据被路由到哪个分片上。


### 9、elasticsearch 是如何实现 master 选举的

面试官：想了解 ES 集群的底层原理，不再只关注业务层面了。

解

**前置前提：**

**1、** 只有候选主节点（master：true）的节点才能成为主节点。

**2、** 最小主节点数（min_master_nodes）的目的是防止脑裂。

这个我看了各种网上分析的版本和源码分析的书籍，云里雾里。核对了一下代码，核心入口为 findMaster，选择主节点成功返回对应 Master，否则返回 null。

**选举流程大致描述如下：**

第一步：确认候选主节点数达标，elasticsearch.yml 设置的值

```
discovery.zen.minimum_master_nodes；
```

第二步：比较：先判定是否具备 master 资格，具备候选主节点资格的优先返回；

若两节点都为候选主节点，则 id 小的值会主节点。

注意这里的 id 为 string 类型。

题外话：获取节点 id 的方法。

```
1GET /_cat/nodes?v&h=ip,port,heapPercent,heapMax,id,name
2ip
port heapPercent heapMax id
name
```


### 10、迁移 Migration API 如何用作 Elasticsearch？

迁移 API简化了X-Pack索引从一个版本到另一个版本的升级。

点到为止即可，类似问题实际开发现用现查，类似问题没有什么意义。

[https://www.elastic.co/guide/en/elasticsearch/reference/current/migration-api.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/migration-api.html)


### 11、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 12、如何在 Elasticsearch中 搜索数据？
### 13、详细描述一下 Elasticsearch 索引文档的过程。
### 14、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 15、在 Elasticsearch 中，是怎么根据一个词找到对应的倒排索引的？
### 16、Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个master，另外 10 个选了另一个 master，怎么办？
### 17、elasticsearch 了解多少，说说你们公司 es 的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 18、您能否说明当前可下载的稳定Elasticsearch版本？
### 19、elasticsearch 数据的写入过程
### 20、你能告诉我 Elasticsearch 中的数据存储功能吗？
### 21、elasticsearch 索引数据多了怎么办，如何调优，部署
### 22、Elasticsearch是如何实现master选举的？
### 23、详细描述一下Elasticsearch搜索的过程？
### 24、Beats 如何与 Elasticsearch 结合使用？
### 25、详细描述一下 Elasticsearch 索引文档的过程




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
