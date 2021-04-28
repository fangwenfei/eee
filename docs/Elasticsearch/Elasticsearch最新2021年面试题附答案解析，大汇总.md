# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、安装 Elasticsearch 需要依赖什么组件吗？

ES 早期版本需要JDK，在7.X版本后已经集成了 JDK，已无需第三方依赖。


### 2、如何在 Elasticsearch中 搜索数据？

Search API 有助于从索引、路由参数引导的特定分片中查找检索数据。


### 3、详细描述一下Elasticsearch索引文档的过程。

协调节点默认使用文档ID参与计算（也支持通过routing），以便为路由提供合适的分片。

```
shard = hash(document_id) % (num_of_primary_shards)
```

**1、** 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到Memory Buffer，然后定时（默认是每隔1秒）写入到Filesystem Cache，这个从Momery Buffer到Filesystem Cache的过程就叫做refresh；

**2、** 当然在某些情况下，存在Momery Buffer和Filesystem Cache的数据可能会丢失，ES是通过translog的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也会写入到translog中，当Filesystem cache中的数据写入到磁盘中时，才会清除掉，这个过程叫做flush；

**3、** 在flush过程中，内存中的缓冲将被清除，内容被写入一个新段，段的fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的translog将被删除并开始一个新的translog。

**4、** flush触发的时机是定时触发（默认30分钟）或者translog变得太大（默认为512M）时；

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_1.png#alt=img%5C_1.png)

**补充：关于Lucene的Segement：**

**1、** Lucene索引是由多个段组成，段本身是一个功能齐全的倒排索引。

**2、** 段是不可变的，允许Lucene将新的文档增量地添加到索引中，而不用从头重建索引。

**3、** 对于每一个搜索请求而言，索引中的所有段都会被搜索，并且每个段会消耗CPU的时钟周、文件句柄和内存。这意味着段的数量越多，搜索性能会越低。

**4、** 为了解决这个问题，Elasticsearch会合并小段到一个较大的段，提交新的合并段到磁盘，并删除那些旧的小段。


### 4、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？

**1、** 当集群master候选数量不小于3个时，可以通过设置最少投票通过数量（**discovery.zen.minimum_master_nodes**）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个master候选，其他作为data节点，避免脑裂问题。


### 5、lucence 内部结构是什么？

面试官：想了解你的知识面的广度和深度。

解

Lucene 是有索引和搜索的两个过程，包含索引创建，索引，搜索三个要点。可以基于这个脉络展开一些。

最近面试一些公司，被问到的关于 Elasticsearch 和搜索引擎相关的问题，以及自己总结的回答。


### 6、Elasticsearch中的 Ingest 节点如何工作？

ingest 节点可以看作是数据前置处理转换的节点，支持 pipeline管道 设置，可以使用 ingest 对数据进行过滤、转换等操作，类似于 logstash 中 filter 的作用，功能相当强大。


### 7、ElasticSearch如何监控集群状态？

Marvel让你可以很简单的通过Kibana监控Elasticsearch。你可以实时查看你的集群健康状态和性能，也可以分析过去的集群、索引和节点指标。


### 8、Kibana在Elasticsearch的哪些地方以及如何使用？

Kibana是ELK Stack –日志分析解决方案的一部分。

它是一种开放源代码的可视化工具，可以以拖拽、自定义图表的方式直观分析数据，极大降低的数据分析的门槛。

未来会向类似：商业智能和分析软件 - Tableau 发展。


### 9、你能否在 Elasticsearch 中定义映射？

映射是定义文档及其包含的字段的存储和索引方式的过程。

**例如，使用映射定义：**

**1、** 哪些字符串字段应该定义为 text 类型。

**2、** 哪些字段应该定义为：数字，日期或地理位置 类型。

**3、** 自定义规则来控制动态添加字段的类型。


### 10、ElasticSearch对于大数据量（上亿量级）的聚合如何实现？

ElasticSearch提供的首个近似聚合是cardinality度量。它提供一个字段的基数，即该字段的distinct或者unique值的数目。它是基于HLL算法的。HLL会先对我们的输入做哈希运算，然后根据哈希运算结果中的bits做概率估算从而得到基数。其特点是：

可配置的精度，用来控制内存的使用（更精确＝更多内存），小的数据集精度是非常高的；我们可以通过配置参数来设置去重需要的固定内存使用量，无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关 。

图片


### 11、简要介绍一下Elasticsearch？
### 12、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 13、elasticsearch 读取数据
### 14、您能否分步介绍如何启动 Elasticsearch 服务器？
### 15、客户端在和集群连接时，是如何选择特定的节点执行请求的？
### 16、Beats 如何与 Elasticsearch 结合使用？
### 17、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？
### 18、elasticsearch 分布式架构原理
### 19、详细说明ELK Stack及其内容？
### 20、在并发情况下，Elasticsearch 如果保证读写一致？
### 21、ES更新数据的执行流程？
### 22、elasticsearch是如何实现master选举的
### 23、elasticsearch 的 document设计
### 24、可以列出X-Pack API 吗？
### 25、如何使用 Elasticsearch Tokenizer？
### 26、定义副本、创建副本的好处是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
