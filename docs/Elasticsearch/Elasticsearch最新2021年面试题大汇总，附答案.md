# Elasticsearch最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、你能否列出与 Elasticsearch 有关的主要可用字段数据类型？

**1、** 字符串数据类型，包括支持全文检索的 text 类型 和 精准匹配的 keyword 类型。

**2、** 数值数据类型，例如字节，短整数，长整数，浮点数，双精度数，half_float，scaled_float。

**3、** 日期类型，日期纳秒Date nanoseconds，布尔值，二进制（Base64编码的字符串）等。

**4、** 范围（整数范围 integer_range，长范围 long_range，双精度范围 double_range，浮动范围 float_range，日期范围 date_range）。

**5、** 包含对象的复杂数据类型，nested 、Object。

**6、** GEO 地理位置相关类型。

**7、** 特定类型如：数组（数组中的值应具有相同的数据类型）


### 2、介绍下你们电商搜索的整体技术架构。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_3.png#alt=img%5C_3.png)


### 3、详细描述一下Elasticsearch索引文档的过程

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


### 4、lucence 内部结构是什么？

面试官：想了解你的知识面的广度和深度。

解

Lucene 是有索引和搜索的两个过程，包含索引创建，索引，搜索三个要点。可以基于这个脉络展开一些。

最近面试一些公司，被问到的关于 Elasticsearch 和搜索引擎相关的问题，以及自己总结的回答。


### 5、Elasticsearch对于大数据量（上亿量级）的聚合如何实现？

Elasticsearch 提供的首个近似聚合是cardinality 度量。它提供一个字段的基数，即该字段的_distinct_或者_unique_值的数目。它是基于HLL算法的。HLL 会先对我们的输入作哈希运算，然后根据哈希运算的结果中的 bits 做概率估算从而得到基数。其特点是：可配置的精度，用来控制内存的使用（更精确 ＝ 更多内存）；小的数据集精度是非常高的；我们可以通过配置参数，来设置去重需要的固定内存使用量。无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关。


### 6、我们可以在 Elasticsearch 中执行搜索的各种可能方式有哪些？

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


### 7、elasticsearch 全文检索

(1) 客户端使用RestFul API向对应的node发送查询请求

(2)协调节点将请求转发到所有节点（primary或者replica）所有节点将对应的数据查询之后返回对应的doc id 返回给协调节点

(3)协调节点将doc进行排序聚合

(4) 协调节点再根据doc id 把查询请求发送到对应shard的node，返回document


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


### 9、你能否在 Elasticsearch 中定义映射？

映射是定义文档及其包含的字段的存储和索引方式的过程。

**例如，使用映射定义：**

**1、** 哪些字符串字段应该定义为 text 类型。

**2、** 哪些字段应该定义为：数字，日期或地理位置 类型。

**3、** 自定义规则来控制动态添加字段的类型。


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


### 11、请解释在 Elasticsearch 集群中添加或创建索引的过程？
### 12、Elasticsearch Analyzer 中的字符过滤器如何利用？
### 13、Elasticsearch中的 Ingest 节点如何工作？
### 14、Elasticsearch 是如何实现 Master 选举的？
### 15、ElasticSearch是如何实现Master选举的？
### 16、精准匹配检索和全文检索匹配检索的不同？
### 17、ElasticSearch对于大数据量（上亿量级）的聚合如何实现？
### 18、elasticsearch 读取数据
### 19、ElasticSearch中的副本是什么？
### 20、19、解释 Elasticsearch 中的相关性和得分？
### 21、定义副本、创建副本的好处是什么？
### 22、详细描述一下Elasticsearch更新和删除文档的过程。
### 23、ElasticSearch如何避免脑裂？
### 24、详细描述一下 Elasticsearch 索引文档的过程。
### 25、客户端在和集群连接时，如何选择特定的节点执行请求的？
### 26、如何监控Elasticsearch集群状态？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
