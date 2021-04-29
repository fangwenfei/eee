# Elasticsearch最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、解释一下Elasticsearch Cluster？

Elasticsearch 集群是一组连接在一起的一个或多个 Elasticsearch 节点实例。

Elasticsearch 集群的功能在于在集群中的所有节点之间分配任务，进行搜索和建立索引。


### 2、Elasticsearch是如何实现Master选举的？

**1、** Elasticsearch的选主是ZenDiscovery模块负责的，主要包含Ping（节点之间通过这个RPC来发现彼此）和Unicast（单播模块包含一个主机列表以控制哪些节点需要ping通）这两部分；

**2、** 对所有可以成为master的节点（**node.master: true**）根据nodeId字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第0位）节点，暂且认为它是master节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为master节点数n/2+1）并且该节点自己也选举自己，那这个节点就是master。否则重新选举一直到满足上述条件。

**4、** 补充：master节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data节点可以关闭http功能*。


### 3、elasticsearch 索引数据多了怎么办，如何调优，部署

`面试官`：想了解大数据量的运维能力。

索引数据的规划，应在前期做好规划，正所谓“设计先行，编码在后”，这样才能有效的避免突如其来的数据激增导致集群处理能力不足引发的线上客户检索或者其他业务受到影响。

如何调优，正如问题1所说，这里细化一下：

**动态索引层面**

基于`模板+时间+rollover api滚动`创建索引，举例：设计阶段定义：blog索引的模板格式为：blog_index_时间戳的形式，每天递增数据。

这样做的好处：不至于数据量激增导致单个索引数据量非常大，接近于上线2的32次幂-1，索引存储达到了TB+甚至更大。

一旦单个索引很大，存储等各种风险也随之而来，所以要提前考虑+及早避免。

**存储层面**

`冷热数据分离存储`，热数据（比如最近3天或者一周的数据），其余为冷数据。

对于冷数据不会再写入新数据，可以考虑定期force_merge加shrink压缩操作，节省存储空间和检索效率。

**部署层面**

一旦之前没有规划，这里就属于应急策略。

结合ES自身的支持动态扩展的特点，动态新增机器的方式可以缓解集群压力，注意：如果之前主节点等`规划合理`，不需要重启集群也能完成动态新增的。


### 4、elasticsearch 的倒排索引是什么

面试官：想了解你对基础概念的认知。

解通俗解释一下就可以。

传统的我们的检索是通过文章，逐个遍历找到对应关键词的位置。

而倒排索引，是通过分词策略，形成了词和文章的映射关系表，这种词典+映射表

即为倒排索引。

有了倒排索引，就能实现 o

**时间复杂度的效率检索文章了，极大的提高了检索效率。**

**学术的解答方式：**

倒排索引，相反于一篇文章包含了哪些词，它从词出发，记载了这个词在哪些文档中出现过，由两部分组成——词典和倒排表。

加分项：倒排索引的底层实现是基于：

```
FST（Finite State Transducer）数据结构
```

lucene 从 4+版本后开始大量使用的数据结构是 FST。FST 有两个优点：

**1、** 空间占用小。通过对词典中单词前缀和后缀的重复利用，压缩了存储空间；

**2、** 查询速度快。O(len(str))的查询时间复杂度。


### 5、我们可以在 Elasticsearch 中执行搜索的各种可能方式有哪些？

核心方式如下：

方式一：基于 DSL 检索（最常用） Elasticsearch提供基于JSON的完整查询DSL来定义查询。

```
GET /shirts/_search
{
  "query": {
    "bool": {
      "filter": [
        { "term": { "color": "red"   }},
        { "term": { "brand": "gucci" }}
      ]
    }
  }
}
```

方式二：基于 URL 检索

```
GET /my_index/_search?q=user:seina
```

方式三：类SQL 检索

```
POST /_sql?format=txt
{
  "query": "SELECT * FROM uint-2020-08-17 ORDER BY itemid DESC LIMIT 5"
}
```

功能还不完备，不推荐使用。


### 6、能列举过你使用的 X-Pack 命令吗?

7.1 安全功能免费后，使用了：setup-passwords 为账号设置密码，确保集群安全。


### 7、客户端在和集群连接时，如何选择特定的节点执行请求的？

TransportClient 利用 transport 模块远程连接一个 elasticsearch 集群。它并不加入到集群中，只是简单的获得一个或者多个初始化的 transport 地址，并以 轮询 的方式与这些地址进行通信。


### 8、ElasticSearch对于大数据量（上亿量级）的聚合如何实现？
### 9、详细描述一下 Elasticsearch 索引文档的过程。
### 10、详细描述一下 Elasticsearch 索引文档的过程
### 11、详细说明ELK Stack及其内容？
### 12、详细描述一下Elasticsearch索引文档的过程。
### 13、如何使用 Elasticsearch Tokenizer？
### 14、请解释有关 Elasticsearch的 NRT？
### 15、详细描述一下ElasticSearch更新和删除文档的过程
### 16、客户端在和集群连接时，是如何选择特定的节点执行请求的？
### 17、您能解释一下X-Pack for Elasticsearch的功能和重要性吗？
### 18、在 Elasticsearch 中删除索引的语法是什么？
### 19、拼写纠错是如何实现的？
### 20、elasticsearch 数据的写入过程
### 21、ES更新数据的执行流程？
### 22、你能否在 Elasticsearch 中定义映射？
### 23、安装 Elasticsearch 需要依赖什么组件吗？
### 24、解释一下 Elasticsearch集群中的 索引的概念 ？
### 25、介绍下你们电商搜索的整体技术架构




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
