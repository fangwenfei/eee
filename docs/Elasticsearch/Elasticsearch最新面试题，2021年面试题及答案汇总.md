# Elasticsearch最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、请解释一下 Elasticsearch 中聚合？

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


### 2、elasticsearch 分布式架构原理

**1、** 首先需要明白es是如何存储数据的，es把对应的数据转换为index。基于倒排索引的方式，每个index上存储了多个type类型，每个type对应一个document。而一个index会被分成多个shard(默认是5个)。

**2、** 在分布式部署时，每个shard会被复制，即一个shard有primary和replica 每个es进程存储的是不同shard的primary和replica。es集群多个节点，会自动选举一个节点为master节点，这个master节点其实就是干一些管理的工作的，比如维护索引元数据拉，负责切换primary shard和replica shard身份拉，之类的。

**3、** ![](https://image-static.segmentfault.com/339/553/3395533898-5e5b562eb42c6_articlex#alt=3cWgYV.png)


### 3、Elasticsearch Analyzer 中的字符过滤器如何利用？

字符过滤器将原始文本作为字符流接收，并可以通过添加，删除或更改字符来转换字符流。

字符过滤分类如下：

**HTML Strip Character Filter.**

用途：删除HTML元素，如**，并解码HTML实体，如＆amp 。**

**Mapping Character Filter**

用途：替换指定的字符。

**Pattern Replace Character Filter**

用途：基于正则表达式替换指定的字符。


### 4、你之前公司的ElasticSearch集群，一个Node一般会分配几个分片？

我们遵循官方建议，一个Node最好不要多于三个shards.


### 5、详细描述一下 Elasticsearch 更新和删除文档的过程。

**1、** 删除和更新也都是写操作，但是 Elasticsearch 中的文档是不可变的，因此不能被删除或者改动以展示其变更；

**2、** 磁盘上的每个段都有一个相应的.del 文件。当删除请求发送后，文档并没有真的被删除，而是在.del 文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del 文件中被标记为删除的文档将不会被写入新段。

**3、** 在新的文档被创建时，Elasticsearch 会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del 文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。


### 6、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？

enabled：false，启用的设置仅可应用于顶级映射定义和 Object 对象字段，导致 Elasticsearch 完全跳过对字段内容的解析。

仍然可以从_source字段中检索JSON，但是无法搜索或以其他任何方式存储JSON。

如果对非全局或者 Object 类型，设置 enable : false 会报错如下：

```
 "type": "mapper_parsing_exception",
 "reason": "Mapping definition for [user_id] has unsupported parameters:  [enabled : false]"
```

index：false, 索引选项控制是否对字段值建立索引。它接受true或false，默认为true。未索引的字段不可查询。

如果非要检索，报错如下：

```
 "type": "search_phase_execution_exception",
  "reason": "Cannot search on field [user_id] since it is not indexed."
```

**store：**

某些特殊场景下，如果你只想检索单个字段或几个字段的值，而不是整个_source的值，则可以使用源过滤来实现；

这个时候， store 就派上用场了。


### 7、介绍下你们电商搜索的整体技术架构

![70_7.png][70_7.png]


### 8、对于GC方面，在使用Elasticsearch时要注意什么？

**1、** SEE：[https://elasticsearch.cn/article/32](https://elasticsearch.cn/article/32)

**2、** 倒排词典的索引需要常驻内存，无法GC，需要监控data node上segment memory增长趋势。

**3、** 各类缓存，field cache, filter cache, indexing cache, bulk queue等等，要设置合理的大小，并且要应该根据最坏的情况来看heap是否够用，也就是各类缓存全部占满的时候，还有heap空间可以分配给其他任务吗？避免采用clear cache等“自欺欺人”的方式来释放内存。

**4、** 避免返回大量结果集的搜索与聚合。确实需要大量拉取数据的场景，可以采用scan & scroll api来实现。

**5、** cluster stats驻留内存并无法水平扩展，超大规模集群可以考虑分拆成多个集群通过tribe node连接。

**6、** 想知道heap够不够，必须结合实际应用场景，并对集群的heap使用情况做持续的监控。


### 9、elasticsearch 的 filesystem

es每次走fileSystem cache查询速度是最快的

所以将每个查询的数据50% 容量

= fileSystem cache 容量。


### 10、ES更新数据的执行流程？

(1) 将原来的doc标识为deleted状态，然后新写入一条数据。

(2) buffer每refresh一次，就会产生一个segmentfile，所以默认情况下是1s一个segmentfile，segmentfile会越来越多，此时会定期执行merge。

(3) 每次merge时,会将多个segmentfile合并成一个，同时这里会将标识为deleted的doc给物理删除掉，然后将新的segmentfile写入磁盘，这里会写一个commitpoint，标识所有新的segmentfile，然后打开segmentfile供搜索使用，同时删除旧的segmentfile。


### 11、请解释在 Elasticsearch 集群中添加或创建索引的过程？
### 12、logstash 如何与 Elasticsearch 结合使用？
### 13、Elasticsearch对于大数据量（上亿量级）的聚合如何实现？
### 14、Elasticsearch 中常用的 cat命令有哪些？
### 15、lucence 内部结构是什么？
### 16、拼写纠错是如何实现的？
### 17、详细描述一下 Elasticsearch 索引文档的过程
### 18、ElasticSearch如何避免脑裂？
### 19、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 20、定义副本、创建副本的好处是什么？
### 21、elasticsearch 数据预热
### 22、迁移 Migration API 如何用作 Elasticsearch？
### 23、ElasticSearch中的倒排索引是什么？
### 24、elasticsearch 数据的写入过程
### 25、详细描述一下 Elasticsearch 搜索的过程？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
