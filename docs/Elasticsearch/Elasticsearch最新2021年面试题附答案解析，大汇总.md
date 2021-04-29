# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、详细描述一下Elasticsearch搜索的过程？

面试官：想了解ES搜索的底层原理，不再只关注业务层面了。

搜索拆解为“query then fetch” 两个阶段。

query阶段的目的：定位到位置，但不取。

**步骤拆解如下：**

**1、** 假设一个索引数据有5主+1副本 共10分片，一次请求会命中（主或者副本分片中）的一个。

**2、** 每个分片在本地进行查询，结果返回到本地有序的优先队列中。

**3、** 第2）步骤的结果发送到协调节点，协调节点产生一个全局的排序列表。

fetch阶段的目的：取数据。

路由节点获取所有文档，返回给客户端。


### 2、详细描述一下 Elasticsearch 搜索的过程。

**1、** 搜索被执行成一个两阶段过程，我们称之为 Query Then Fetch；

**2、** 在初始查询阶段时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。

PS：在搜索的时候是会查询 Filesystem Cache 的，但是有部分数据还在 Memory Buffer，所以搜索是近实时的。

**3、** 每个分片返回各自优先队列中 所有文档的 ID 和排序值 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。

**4、** 接下来就是 取回阶段，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 _丰富_ 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。

**5、** 补充：Query Then Fetch 的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch 增加了一个预查询的处理，询问 Term 和 Document frequency，这个评分更准确，但是性能会变差。

![70_6.png][70_6.png]


### 3、elasticsearch 全文检索

(1) 客户端使用RestFul API向对应的node发送查询请求

(2)协调节点将请求转发到所有节点（primary或者replica）所有节点将对应的数据查询之后返回对应的doc id 返回给协调节点

(3)协调节点将doc进行排序聚合

(4) 协调节点再根据doc id 把查询请求发送到对应shard的node，返回document


### 4、您能否说明当前可下载的稳定Elasticsearch版本？

Elasticsearch 当前最新版本是7.10（2020年11月21日）。

为什么问这个问题？ES 更新太快了，应聘者如果了解并使用最新版本，基本能说明他关注 ES 更新。甚至从更广维度讲，他关注技术的迭代和更新。

但，不信你可以问问，很多求职者只知道用了 ES，什么版本一概不知。


### 5、介绍一下你们的个性化搜索方案？

SEE [基于word2vec和Elasticsearch实现个性化搜索](http://ginobefunny.com/post/personalized_search_implemention_based_word2vec_and_elasticsearch/)


### 6、介绍下你们电商搜索的整体技术架构。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_3.png#alt=img%5C_3.png)


### 7、Elasticsearch对于大数据量（上亿量级）的聚合如何实现？

Elasticsearch 提供的首个近似聚合是cardinality 度量。它提供一个字段的基数，即该字段的_distinct_或者_unique_值的数目。它是基于HLL算法的。HLL 会先对我们的输入作哈希运算，然后根据哈希运算的结果中的 bits 做概率估算从而得到基数。其特点是：可配置的精度，用来控制内存的使用（更精确 ＝ 更多内存）；小的数据集精度是非常高的；我们可以通过配置参数，来设置去重需要的固定内存使用量。无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关。


### 8、在Elasticsearch中 按 ID检索文档的语法是什么？
### 9、什么是Elasticsearch Analyzer？
### 10、elasticsearch 分布式架构原理
### 11、是否了解字典树？
### 12、您能解释一下 Elasticsearch 中的 Explore API 吗？
### 13、在并发情况下，Elasticsearch 如果保证读写一致？
### 14、Elasticsearch 支持哪些配置管理工具？
### 15、你能告诉我 Elasticsearch 中的数据存储功能吗？
### 16、介绍一下你们的个性化搜索方案？
### 17、如何使用 Elastic Reporting ？
### 18、能列出 10 个使用 Elasticsearch 作为其搜索引擎或数据库的公司吗？
### 19、elasticsearch的倒排索引是什么
### 20、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 21、对于GC方面，在使用Elasticsearch时要注意什么？
### 22、如何在 Elasticsearch中 搜索数据？
### 23、token filter 过滤器 在 Elasticsearch 中如何工作？
### 24、ElasticSearch如何监控集群状态？
### 25、elasticsearch 数据的写入原理
### 26、Kibana在Elasticsearch的哪些地方以及如何使用？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
