# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、可以列出X-Pack API 吗？

付费功能只是试用过（面试时如实回答就可以）。

7.1 安全功能免费后，用 X-pack 创建Space、角色、用户，设置SSL加密，并且为不同用户设置不同的密码和分配不同的权限。

其他如：机器学习、 Watcher、 Migration 等 API 用的较少。


### 2、ElasticSearch中的副本是什么？

一个索引被分解成碎片以便于分发和扩展，副本是分片的副本。一个节点是一个属于一个集群的ElasticSearch的运行实例，一个集群由一个或多个共享相同集群名称的节点组成。


### 3、Elasticsearch中的 Ingest 节点如何工作？

ingest 节点可以看作是数据前置处理转换的节点，支持 pipeline管道 设置，可以使用 ingest 对数据进行过滤、转换等操作，类似于 logstash 中 filter 的作用，功能相当强大。


### 4、你能否在 Elasticsearch 中定义映射？

映射是定义文档及其包含的字段的存储和索引方式的过程。

**例如，使用映射定义：**

**1、** 哪些字符串字段应该定义为 text 类型。

**2、** 哪些字段应该定义为：数字，日期或地理位置 类型。

**3、** 自定义规则来控制动态添加字段的类型。


### 5、在 Elasticsearch 中列出集群的所有索引的语法是什么？

```
GET _cat/indices
```


### 6、elasticsearch 索引数据多了怎么办，如何调优，部署

面试官：想了解大数据量的运维能力。

解索引数据的规划，应在前期做好规划，正所谓“设计先行，编码在后”，这样才能有效的避免突如其来的数据激增导致集群处理能力不足引发的线上客户检索或者其他业务受到影响。

如何调优，正如问题 1 所说，这里细化一下：

**动态索引层面**

基于模板+时间+rollover api 滚动创建索引，举例：设计阶段定义：blog 索引的模板格式为：blog_index_时间戳的形式，每天递增数据。

这样做的好处：不至于数据量激增导致单个索引数据量非常大，接近于上线 2 的32 次幂-1，索引存储达到了 TB+甚至更大。

一旦单个索引很大，存储等各种风险也随之而来，所以要提前考虑+及早避免。

**存储层面**

冷热数据分离存储，热数据（比如最近 3 天或者一周的数据），其余为冷数据。

对于冷数据不会再写入新数据，可以考虑定期 force_merge 加 shrink 压缩操作，节省存储空间和检索效率。

**部署层面**

一旦之前没有规划，这里就属于应急策略。结合 ES 自身的支持动态扩展的特点，动态新增机器的方式可以缓解集群压力，注意：如果之前主节点等规划合理，不需要重启集群也能完成动态新增的。


### 7、解释一下Elasticsearch Cluster？

Elasticsearch 集群是一组连接在一起的一个或多个 Elasticsearch 节点实例。

Elasticsearch 集群的功能在于在集群中的所有节点之间分配任务，进行搜索和建立索引。


### 8、详细说明ELK Stack及其内容？

ELK Stack是一系列搜索和分析工具（Elasticsearch），收集和转换工具（Logstash）以及数据管理及可视化工具（Kibana）、解析和收集日志工具（Beats 未来是 Agent）以及监视和报告工具（例如X Pack）的集合。

相当于用户基本不再需要第三方技术栈，就能全流程、全环节搞定数据接入、存储、检索、可视化分析等全部功能。


### 9、ElasticSearch对于大数据量（上亿量级）的聚合如何实现？

ElasticSearch提供的首个近似聚合是cardinality度量。它提供一个字段的基数，即该字段的distinct或者unique值的数目。它是基于HLL算法的。HLL会先对我们的输入做哈希运算，然后根据哈希运算结果中的bits做概率估算从而得到基数。其特点是：

可配置的精度，用来控制内存的使用（更精确＝更多内存），小的数据集精度是非常高的；我们可以通过配置参数来设置去重需要的固定内存使用量，无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关 。

图片


### 10、Beats 如何与 Elasticsearch 结合使用？

Beats是一种开源工具，可以将数据直接传输到 Elasticsearch 或通过 logstash，在使用Kibana进行查看之前，可以对数据进行处理或过滤。

传输的数据类型包含：审核数据，日志文件，云数据，网络流量和窗口事件日志等。


### 11、lucence内部结构是什么？
### 12、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法？
### 13、客户端在和集群连接时，是如何选择特定的节点执行请求的？
### 14、如何使用 Elasticsearch Tokenizer？
### 15、什么是ElasticSearch脑裂？
### 16、elasticsearch 冷热分离
### 17、elasticsearch 读取数据
### 18、您能解释一下X-Pack for Elasticsearch的功能和重要性吗？
### 19、Elasticsearch的 文档是什么？
### 20、token filter 过滤器 在 Elasticsearch 中如何工作？
### 21、是否了解字典树？
### 22、详细描述一下Elasticsearch索引文档的过程。
### 23、elasticsearch 是如何实现 master 选举的
### 24、在 Elasticsearch 中，是怎么根据一个词找到对应的倒排索引的？
### 25、详细描述一下 Elasticsearch 索引文档的过程。
### 26、什么是Elasticsearch Analyzer？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
