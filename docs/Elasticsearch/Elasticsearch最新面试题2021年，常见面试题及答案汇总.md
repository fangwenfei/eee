# Elasticsearch最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、elasticsearch 实际设计

采用elasticSearch + Hbase的架构方式。es中只存放少量关键数据建立索引，通过es查询到doc id 再去Hbase中查询完整的数据信息。


### 2、详细描述一下 Elasticsearch 搜索的过程。

**1、** 搜索被执行成一个两阶段过程，我们称之为 Query Then Fetch；

**2、** 在初始查询阶段时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。

PS：在搜索的时候是会查询 Filesystem Cache 的，但是有部分数据还在 Memory Buffer，所以搜索是近实时的。

**3、** 每个分片返回各自优先队列中 所有文档的 ID 和排序值 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。

**4、** 接下来就是 取回阶段，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 _丰富_ 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。

**5、** 补充：Query Then Fetch 的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch 增加了一个预查询的处理，询问 Term 和 Document frequency，这个评分更准确，但是性能会变差。

![70_6.png][70_6.png]


### 3、elasticsearch 数据的写入过程

注意，客户端是可以在任意节点进行写入数据的，与Kakfa不同。

**1、** 客户端选择一个node发送请求过去，这个node就是coordinating node（协调节点）

**2、** coordinating node，对document进行路由得到对应应该存储到哪个shard，将请求转发给对应的node（有primary shard）

**3、** 实际的node上的primary shard处理请求，然后将数据同步到replica node

**4、** coordinating node，如果发现primary node和所有replica node都搞定之后，就返回响应结果给客户端

![](https://image-static.segmentfault.com/162/449/16244926-5e5b5631a5371_articlex#alt=3cWXlD.png)


### 4、你能否列出与 Elasticsearch 有关的主要可用字段数据类型？

**1、** 字符串数据类型，包括支持全文检索的 text 类型 和 精准匹配的 keyword 类型。

**2、** 数值数据类型，例如字节，短整数，长整数，浮点数，双精度数，half_float，scaled_float。

**3、** 日期类型，日期纳秒Date nanoseconds，布尔值，二进制（Base64编码的字符串）等。

**4、** 范围（整数范围 integer_range，长范围 long_range，双精度范围 double_range，浮动范围 float_range，日期范围 date_range）。

**5、** 包含对象的复杂数据类型，nested 、Object。

**6、** GEO 地理位置相关类型。

**7、** 特定类型如：数组（数组中的值应具有相同的数据类型）


### 5、详细描述一下Elasticsearch更新和删除文档的过程。

**1、** 删除和更新也都是写操作，但是Elasticsearch中的文档是不可变的，因此不能被删除或者改动以展示其变更；

**2、** 磁盘上的每个段都有一个相应的.del文件。当删除请求发送后，文档并没有真的被删除，而是在.del文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del文件中被标记为删除的文档将不会被写入新段。

**3、** 在新的文档被创建时，Elasticsearch会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。


### 6、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。

`面试官`：想了解应聘者之前公司接触的ES使用场景、规模，有没有做过比较大规模的索引设计、规划、调优。

如实结合自己的实践场景回答即可。

比如：ES集群架构13个节点，索引根据通道不同共20+索引，根据日期，每日递增20+，索引：10分片，每日递增1亿+数据，

每个通道每天索引大小控制：150GB之内。

仅索引层面调优手段：

**设计阶段调优**

**1、** 根据业务增量需求，采取基于日期模板创建索引，通过roll over API滚动索引；

**2、** 使用别名进行索引管理；

**3、** 每天凌晨定时对索引做force_merge操作，以释放空间；

**4、** 采取冷热分离机制，热数据存储到SSD，提高检索效率；冷数据定期进行shrink操作，以缩减存储；

**5、** 采取curator进行索引的生命周期管理；

**6、** 仅针对需要分词的字段，合理的设置分词器；

**7、** Mapping阶段充分结合各个字段的属性，是否需要检索、是否需要存储等。……..

**写入调优**

**1、** 写入前副本数设置为0；

**2、** 写入前关闭refresh_interval设置为-1，禁用刷新机制；

**3、** 写入过程中：采取bulk批量写入；

**4、** 写入后恢复副本数和刷新间隔；

**5、** 尽量使用自动生成的id。

**查询调优**

**1、** 禁用wildcard；

**2、** 禁用批量terms（成百上千的场景）；

**3、** 充分利用倒排索引机制，能keyword类型尽量keyword；

**4、** 数据量大时候，可以先基于时间敲定索引再检索；

**5、** 设置合理的路由机制。

**1.4、其他调优**

部署调优，业务调优等。

上面的提及一部分，面试者就基本对你之前的实践或者运维经验有所评估了。


### 7、请解释有关 Elasticsearch的 NRT？

从文档索引（写入）到可搜索到之间的延迟默认一秒钟，因此Elasticsearch是近实时（NRT）搜索平台。

也就是说：文档写入，最快一秒钟被索引到，不能再快了。

写入调优的时候，我们通常会动态调整：refresh_interval = 30s 或者更达值，以使得写入数据更晚一点时间被搜索到。


### 8、在 Elasticsearch 中列出集群的所有索引的语法是什么？

```
GET _cat/indices
```


### 9、ElasticSearch是如何实现Master选举的？

ElasticSearch的选举是ZenDiscovery模块负责的，主要包含Ping（节点之间通过这个RPC来发现彼此）和Unicast（单播模块包含一个主机列表以控制哪些节点需要ping通）这两部分；

对所有可以成为master的节点（node.master: true）根据nodeId字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第0位）节点，暂且认为它是master节点。

如果对某个节点的投票数达到一定的值（可以成为master节点数n/2+1）并且该节点自己也选举自己， 那这个节点就是master。否则重新选举一直到满足上述条件。


### 10、解释一下 Elasticsearch Node？

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


### 11、介绍下你们电商搜索的整体技术架构。
### 12、ElasticSearch中的分析器是什么？
### 13、logstash 如何与 Elasticsearch 结合使用？
### 14、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 15、ElasticSearch主分片数量可以在后期更改吗？为什么？
### 16、token filter 过滤器 在 Elasticsearch 中如何工作？
### 17、详细描述一下 Elasticsearch 索引文档的过程。
### 18、什么是ElasticSearch脑裂？
### 19、详细描述一下Elasticsearch搜索的过程。
### 20、elasticsearch 的倒排索引是什么
### 21、精准匹配检索和全文检索匹配检索的不同？
### 22、Master 节点和 候选 Master节点有什么区别？
### 23、介绍一下你们的个性化搜索方案？
### 24、Elasticsearch 是如何实现 Master 选举的？
### 25、介绍下你们电商搜索的整体技术架构




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
