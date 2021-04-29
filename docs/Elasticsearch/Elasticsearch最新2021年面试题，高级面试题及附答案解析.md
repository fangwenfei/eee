# Elasticsearch最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、简要介绍一下Elasticsearch？

Elasticsearch 是一个分布式、RESTful 风格的搜索和数据分析引擎，能够解决不断涌现出的各种用例。作为 Elastic Stack 的核心，它集中存储您的数据，帮助您发现意料之中以及意料之外的情况。

ElasticSearch 是基于Lucene的搜索服务器。它提供了一个分布式多用户能力的全文搜索引擎，基于RESTful web接口。Elasticsearch是用Java开发的，并作为Apache许可条款下的开放源码，是当前流行的企业级搜索引擎。

**核心特点如下：**

**1、** 分布式的实时文件存储，每个字段都被索引且可用于搜索。

**2、** 分布式的实时分析搜索引擎，海量数据下近实时秒级响应。

**3、** 简单的restful api，天生的兼容多语言开发。

**4、** 易扩展，处理PB级结构化或非结构化数据。


### 2、ElasticSearch如何避免脑裂？

可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上，来解决脑裂问题。


### 3、详细描述一下 Elasticsearch 索引文档的过程。

协调节点默认使用文档 ID 参与计算（也支持通过 routing），以便为路由提供合适的分片。

```
shard = hash(document_id) % (num_of_primary_shards)
```

**1、** 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到 MemoryBuffer，然后定时（默认是每隔 1 秒）写入到 Filesystem Cache，这个从MomeryBuffer 到 Filesystem Cache 的过程就叫做 refresh；

**2、** 当然在某些情况下，存在 Momery Buffer 和 Filesystem Cache 的数据可能会丢失，ES 是通过 translog 的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也会写入到 translog 中，当 Filesystem cache 中的数据写入到磁盘中时，才会清除掉，这个过程叫做 flush；

**3、** 在 flush 过程中，内存中的缓冲将被清除，内容被写入一个新段，段的 fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的 translog 将被删除并开始一个新的 translog。

**4、** flush 触发的时机是定时触发（默认 30 分钟）或者 translog 变得太大（默认为 512M）时；

**补充：关于 Lucene 的 Segement：**

**1、** Lucene 索引是由多个段组成，段本身是一个功能齐全的倒排索引。

**2、** 段是不可变的，允许 Lucene 将新的文档增量地添加到索引中，而不用从头重建索引。

**3、** 对于每一个搜索请求而言，索引中的所有段都会被搜索，并且每个段会消耗CPU 的时钟周、文件句柄和内存。这意味着段的数量越多，搜索性能会越低。

**4、** 为了解决这个问题，Elasticsearch 会合并小段到一个较大的段，提交新的合并

段到磁盘，并删除那些旧的小段。


### 4、详细描述一下 Elasticsearch 搜索的过程？

面试官：想了解 ES 搜索的底层原理，不再只关注业务层面了。

解

搜索拆解为“query then fetch” 两个阶段。

query 阶段的目的：定位到位置，但不取。

**步骤拆解如下：**

**1、** 假设一个索引数据有 5 主+1 副本 共 10 分片，一次请求会命中（主或者副本分片中）的一个。

**2、** 每个分片在本地进行查询，结果返回到本地有序的优先队列中。

**3、** 第 2）步骤的结果发送到协调节点，协调节点产生一个全局的排序列表。fetch 阶段的目的：取数据。路由节点获取所有文档，返回给客户端。


### 5、你可以列出 Elasticsearch 各种类型的分析器吗？

Elasticsearch Analyzer 的类型为内置分析器和自定义分析器。

**Standard Analyzer**

标准分析器是默认分词器，如果未指定，则使用该分词器。

它基于Unicode文本分割算法，适用于大多数语言。

**Whitespace Analyzer**

基于空格字符切词。

**Stop Analyzer**

在simple Analyzer的基础上，移除停用词。

**Keyword Analyzer**

不切词，将输入的整个串一起返回。

自定义分词器的模板

自定义分词器的在Mapping的Setting部分设置：

```
PUT my_custom_index
{
 "settings":{
  "analysis":{
  "char_filter":{},
  "tokenizer":{},
  "filter":{},
  "analyzer":{}
  }
 }
}
```

脑海中还是上面的三部分组成的图示。其中：

“char_filter”:{},——对应字符过滤部分；

“tokenizer”:{},——对应文本切分为分词部分；

“filter”:{},——对应分词后再过滤部分；

“analyzer”:{}——对应分词器组成部分，其中会包含：1. 2. 3。


### 6、什么是ElasticSearch索引？

索引（名词）： 一个索引(index)就像是传统关系数据库中的数据库，它是相关文档存储的地方，index的复数是indices或indexes。

索引（动词）：「索引一个文档」表示把一个文档存储到索引（名词）里，以便它可以被检索或者查询。这很像SQL中的INSERT关键字，差别是，如果文档已经存在，新的文档将覆盖旧的文档。


### 7、Elasticsearch是如何实现Master选举的？

**1、** Elasticsearch的选主是ZenDiscovery模块负责的，主要包含Ping（节点之间通过这个RPC来发现彼此）和Unicast（单播模块包含一个主机列表以控制哪些节点需要ping通）这两部分；

**2、** 对所有可以成为master的节点（**node.master: true**）根据nodeId字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第0位）节点，暂且认为它是master节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为master节点数n/2+1）并且该节点自己也选举自己，那这个节点就是master。否则重新选举一直到满足上述条件。

**4、** 补充：master节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data节点可以关闭http功能*。


### 8、详细描述一下Elasticsearch索引文档的过程

`面试官`：想了解ES的底层原理，不再只关注业务层面了。

这里的索引文档应该理解为文档写入ES，创建索引的过程。

文档写入包含：单文档写入和批量bulk写入，这里只解释一下：单文档写入流程。

记住官方文档中的这个图。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0814/01/img_3.png#alt=img%5C_3.png)

第一步：客户写集群某节点写入数据，发送请求。（如果没有指定路由/协调节点，请求的节点扮演`路由节点`的角色。）

第二步：节点1接受到请求后，使用文档_id来确定文档属于分片0。请求会被转到另外的节点，假定节点3。因此分片0的主分片分配到节点3上。

第三步：节点3在主分片上执行写操作，如果成功，则将请求并行转发到节点1和节点2的副本分片上，等待结果返回。所有的副本分片都报告成功，节点3将向协调节点（节点1）报告成功，节点1向请求客户端报告写入成功。

如果面试官再问：第二步中的文档获取分片的过程？

回借助路由算法获取，路由算法就是根据路由和文档id计算目标的分片id的过程。

```
1shard = hash(_routing) % (num_of_primary_shards)
```


### 9、对于GC方面，在使用Elasticsearch时要注意什么？

**1、** SEE：[https://elasticsearch.cn/article/32](https://elasticsearch.cn/article/32)

**2、** 倒排词典的索引需要常驻内存，无法GC，需要监控data node上segment memory增长趋势。

**3、** 各类缓存，field cache, filter cache, indexing cache, bulk queue等等，要设置合理的大小，并且要应该根据最坏的情况来看heap是否够用，也就是各类缓存全部占满的时候，还有heap空间可以分配给其他任务吗？避免采用clear cache等“自欺欺人”的方式来释放内存。

**4、** 避免返回大量结果集的搜索与聚合。确实需要大量拉取数据的场景，可以采用scan & scroll api来实现。

**5、** cluster stats驻留内存并无法水平扩展，超大规模集群可以考虑分拆成多个集群通过tribe node连接。

**6、** 想知道heap够不够，必须结合实际应用场景，并对集群的heap使用情况做持续的监控。


### 10、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？

**1、** 当集群master候选数量不小于3个时，可以通过设置最少投票通过数量（**discovery.zen.minimum_master_nodes**）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个master候选，其他作为data节点，避免脑裂问题。


### 11、ElasticSearch对于大数据量（上亿量级）的聚合如何实现？
### 12、ElasticSearch如何监控集群状态？
### 13、在Elasticsearch中 按 ID检索文档的语法是什么？
### 14、你能否在 Elasticsearch 中定义映射？
### 15、你能否列出与 Elasticsearch 有关的主要可用字段数据类型？
### 16、客户端在和集群连接时，是如何选择特定的节点执行请求的？
### 17、19、解释 Elasticsearch 中的相关性和得分？
### 18、您能解释一下X-Pack for Elasticsearch的功能和重要性吗？
### 19、Master 节点和 候选 Master节点有什么区别？
### 20、lucence 内部结构是什么？
### 21、对于 GC 方面，在使用 Elasticsearch 时要注意什么？
### 22、详细描述一下Elasticsearch索引文档的过程。
### 23、精准匹配检索和全文检索匹配检索的不同？
### 24、在 Elasticsearch 中删除索引的语法是什么？
### 25、在索引中更新 Mapping 的语法？
### 26、客户端在和集群连接时，如何选择特定的节点执行请求的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
