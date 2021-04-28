# Elasticsearch最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、对于 GC 方面，在使用 Elasticsearch 时要注意什么？

**1、** SEE

**2、** 倒排词典的索引需要常驻内存，无法 GC，需要监控 data node 上 segmentmemory 增长趋势。

**3、** 各类缓存，field cache, filter cache, indexing cache, bulk queue 等等，要设置合理的大小，并且要应该根据最坏的情况来看 heap 是否够用，也就是各类缓存全部占满的时候，还有 heap 空间可以分配给其他任务吗？避免采用 clear cache等“自欺欺人”的方式来释放内存。

**4、** 避免返回大量结果集的搜索与聚合。确实需要大量拉取数据的场景，可以采用scan & scroll api 来实现。

**5、** cluster stats 驻留内存并无法水平扩展，超大规模集群可以考虑分拆成多个集群通过 tribe node 连接。

**6、** 想知道 heap 够不够，必须结合实际应用场景，并对集群的 heap 使用情况做持续的监控。


### 2、解释一下 Elasticsearch Node？

节点是 Elasticsearch 的实例。实际业务中，我们会说：ES集群包含3个节点、7个节点。

这里节点实际就是：一个独立的 Elasticsearch 进程，一般将一个节点部署到一台独立的服务器或者虚拟机、容器中。

不同节点根据角色不同，可以划分为：

**主节点**

帮助配置和管理在整个集群中添加和删除节点。

**数据节点**

存储数据并执行诸如CRUD（创建/读取/更新/删除）操作，对数据进行搜索和聚合的操作。

**1、** 客户端节点（或者说：协调节点） 将集群请求转发到主节点，将与数据相关的请求转发到数据节点

**2、** 摄取节点

用于在索引之前对文档进行预处理。


### 3、客户端在和集群连接时，如何选择特定的节点执行请求的？

TransportClient 利用 transport 模块远程连接一个 elasticsearch 集群。它并不加入到集群中，只是简单的获得一个或者多个初始化的 transport 地址，并以 轮询 的方式与这些地址进行通信。


### 4、我们可以在 Elasticsearch 中执行搜索的各种可能方式有哪些？

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


### 5、Master 节点和 候选 Master节点有什么区别？

主节点负责集群相关的操作，例如创建或删除索引，跟踪哪些节点是集群的一部分，以及决定将哪些分片分配给哪些节点。

拥有稳定的主节点是衡量集群健康的重要标志。

而候选主节点是被选具备候选资格，可以被选为主节点的那些节点。


### 6、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？

**1、** 当集群master候选数量不小于3个时，可以通过设置最少投票通过数量（**discovery.zen.minimum_master_nodes**）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个master候选，其他作为data节点，避免脑裂问题。


### 7、在 Elasticsearch 中删除索引的语法是什么？

可以使用以下语法删除现有索引：

```
DELETE <index_name>
```

支持通配符删除：

```
DELETE my_*
```


### 8、介绍下你们电商搜索的整体技术架构。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_3.png#alt=img%5C_3.png)


### 9、介绍一下你们的个性化搜索方案？

SEE [基于word2vec和Elasticsearch实现个性化搜索](http://ginobefunny.com/post/personalized_search_implemention_based_word2vec_and_elasticsearch/)


### 10、你是如何做 ElasticSearch 写入调优的？

1）写入前副本数设置为0；

2）写入前关闭refresh_interval设置为-1，禁用刷新机制；

3）写入过程中：采取bulk批量写入；

4） 写入后恢复副本数和刷新间隔；

5） 尽量使用自动生成的id。


### 11、详细描述一下Elasticsearch更新和删除文档的过程。
### 12、详细描述一下Elasticsearch索引文档的过程
### 13、Elasticsearch在部署时，对Linux的设置有哪些优化方法
### 14、客户端在和集群连接时，如何选择特定的节点执行请求的？
### 15、在索引中更新 Mapping 的语法？
### 16、Elasticsearch 支持哪些类型的查询？
### 17、Elasticsearch 支持哪些配置管理工具？
### 18、安装 Elasticsearch 需要依赖什么组件吗？
### 19、你能告诉我 Elasticsearch 中的数据存储功能吗？
### 20、你可以列出 Elasticsearch 各种类型的分析器吗？
### 21、精准匹配检索和全文检索匹配检索的不同？
### 22、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法
### 23、在Elasticsearch中 按 ID检索文档的语法是什么？
### 24、elasticsearch 数据的写入原理
### 25、elasticsearch 实际设计
### 26、解释一下 Elasticsearch 集群中的 Type 的概念 ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
