# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、介绍一下你们的个性化搜索方案？

SEE [基于word2vec和Elasticsearch实现个性化搜索](http://ginobefunny.com/post/personalized_search_implemention_based_word2vec_and_elasticsearch/)


### 2、在Elasticsearch中 cat API的功能是什么？

cat API 命令提供了Elasticsearch 集群的分析、概述和运行状况，其中包括与别名，分配，索引，节点属性等有关的信息。

这些 cat 命令使用查询字符串作为其参数，并以J SON 文档格式返回结果信息。


### 3、elasticsearch 数据的写入过程

注意，客户端是可以在任意节点进行写入数据的，与Kakfa不同。

**1、** 客户端选择一个node发送请求过去，这个node就是coordinating node（协调节点）

**2、** coordinating node，对document进行路由得到对应应该存储到哪个shard，将请求转发给对应的node（有primary shard）

**3、** 实际的node上的primary shard处理请求，然后将数据同步到replica node

**4、** coordinating node，如果发现primary node和所有replica node都搞定之后，就返回响应结果给客户端

![](https://image-static.segmentfault.com/162/449/16244926-5e5b5631a5371_articlex#alt=3cWXlD.png)


### 4、在Elasticsearch中 按 ID检索文档的语法是什么？

```
GET test_001/_doc/1
```


### 5、详细描述一下Elasticsearch搜索的过程。

**1、** 搜索被执行成一个两阶段过程，我们称之为 Query Then Fetch；

**2、** 在初始**查询阶段**时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。 每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。

PS：在搜索的时候是会查询Filesystem Cache的，但是有部分数据还在Memory Buffer，所以搜索是近实时的。

**3、** 每个分片返回各自优先队列中 **所有文档的 ID 和排序值** 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。

**4、** 接下来就是 **取回阶段**，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 _丰富_ 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。

**5、** 补充：Query Then Fetch的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch增加了一个预查询的处理，询问Term和Document frequency，这个评分更准确，但是性能会变差。*

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_2.png#alt=img%5C_2.png)


### 6、Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个master，另外 10 个选了另一个 master，怎么办？

**1、** 当集群 master 候选数量不小于 3 个时，可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个 master 候选，其他作为 data节点，避免脑裂问题。


### 7、在 Elasticsearch 中，是怎么根据一个词找到对应的倒排索引的？

**SEE：**

1. Lucene 的索引文件格式(1)
2. Lucene 的索引文件格式（2）


### 8、什么是Elasticsearch Analyzer？

分析器用于文本分析，它可以是内置分析器也可以是自定义分析器。


### 9、Elasticsearch 支持哪些类型的查询？

查询主要分为两种类型：精确匹配、全文检索匹配。

1. 精确匹配，例如 term、exists、term set、 range、prefix、 ids、 wildcard、regexp、 fuzzy等。
2. 全文检索，例如match、match_phrase、multi_match、match_phrase_prefix、query_string 等


### 10、详细描述一下 Elasticsearch 搜索的过程？

面试官：想了解 ES 搜索的底层原理，不再只关注业务层面了。

解

搜索拆解为“query then fetch” 两个阶段。

query 阶段的目的：定位到位置，但不取。

**步骤拆解如下：**

**1、** 假设一个索引数据有 5 主+1 副本 共 10 分片，一次请求会命中（主或者副本分片中）的一个。

**2、** 每个分片在本地进行查询，结果返回到本地有序的优先队列中。

**3、** 第 2）步骤的结果发送到协调节点，协调节点产生一个全局的排序列表。fetch 阶段的目的：取数据。路由节点获取所有文档，返回给客户端。


### 11、elasticsearch 分布式架构原理
### 12、你能告诉我 Elasticsearch 中的数据存储功能吗？
### 13、解释一下Elasticsearch Cluster？
### 14、Kibana在Elasticsearch的哪些地方以及如何使用？
### 15、Master 节点和 候选 Master节点有什么区别？
### 16、什么是ElasticSearch索引？
### 17、安装 Elasticsearch 需要依赖什么组件吗？
### 18、介绍下你们电商搜索的整体技术架构
### 19、对于GC方面，在使用Elasticsearch时要注意什么？
### 20、elasticsearch 实际设计
### 21、你是如何做 ElasticSearch 写入调优的？
### 22、是否了解字典树？
### 23、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 24、elasticsearch 是如何实现 master 选举的
### 25、ElasticSearch中的分析器是什么？
### 26、详细说明ELK Stack及其内容？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
