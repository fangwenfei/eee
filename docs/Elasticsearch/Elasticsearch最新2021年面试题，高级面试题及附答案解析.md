# Elasticsearch最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、lucence 内部结构是什么？

面试官：想了解你的知识面的广度和深度。

解

Lucene 是有索引和搜索的两个过程，包含索引创建，索引，搜索三个要点。可以基于这个脉络展开一些。

最近面试一些公司，被问到的关于 Elasticsearch 和搜索引擎相关的问题，以及自己总结的回答。


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


### 3、Elasticsearch 支持哪些配置管理工具？

**1、** Ansible

**2、** Chef

**3、** Puppet

**4、** Salt Stack

是 DevOps 团队使用的 Elasticsearch支持的配置工具。


### 4、迁移 Migration API 如何用作 Elasticsearch？

迁移 API简化了X-Pack索引从一个版本到另一个版本的升级。

点到为止即可，类似问题实际开发现用现查，类似问题没有什么意义。

[https://www.elastic.co/guide/en/elasticsearch/reference/current/migration-api.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/migration-api.html)


### 5、REST API在 Elasticsearch 方面有哪些优势？

REST API是使用超文本传输协议的系统之间的通信，该协议以 XML 和 JSON格式传输数据请求。

REST 协议是无状态的，并且与带有服务器和存储数据的用户界面分开，从而增强了用户界面与任何类型平台的可移植性。它还提高了可伸缩性，允许独立实现组件，因此应用程序变得更加灵活。

REST API与平台和语言无关，只是用于数据交换的语言是XML或JSON。

借助：REST API 查看集群信息或者排查问题都非常方便。


### 6、什么是Elasticsearch Analyzer？

分析器用于文本分析，它可以是内置分析器也可以是自定义分析器。


### 7、Elasticsearch 支持哪些类型的查询？

查询主要分为两种类型：精确匹配、全文检索匹配。

1. 精确匹配，例如 term、exists、term set、 range、prefix、 ids、 wildcard、regexp、 fuzzy等。
2. 全文检索，例如match、match_phrase、multi_match、match_phrase_prefix、query_string 等


### 8、详细描述一下 Elasticsearch 搜索的过程。

**1、** 搜索被执行成一个两阶段过程，我们称之为 Query Then Fetch；

**2、** 在初始查询阶段时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。

PS：在搜索的时候是会查询 Filesystem Cache 的，但是有部分数据还在 Memory Buffer，所以搜索是近实时的。

**3、** 每个分片返回各自优先队列中 所有文档的 ID 和排序值 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。

**4、** 接下来就是 取回阶段，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 _丰富_ 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。

**5、** 补充：Query Then Fetch 的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch 增加了一个预查询的处理，询问 Term 和 Document frequency，这个评分更准确，但是性能会变差。

![70_6.png][70_6.png]


### 9、Kibana在Elasticsearch的哪些地方以及如何使用？

Kibana是ELK Stack –日志分析解决方案的一部分。

它是一种开放源代码的可视化工具，可以以拖拽、自定义图表的方式直观分析数据，极大降低的数据分析的门槛。

未来会向类似：商业智能和分析软件 - Tableau 发展。


### 10、ElasticSearch是如何实现Master选举的？

ElasticSearch的选举是ZenDiscovery模块负责的，主要包含Ping（节点之间通过这个RPC来发现彼此）和Unicast（单播模块包含一个主机列表以控制哪些节点需要ping通）这两部分；

对所有可以成为master的节点（node.master: true）根据nodeId字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第0位）节点，暂且认为它是master节点。

如果对某个节点的投票数达到一定的值（可以成为master节点数n/2+1）并且该节点自己也选举自己， 那这个节点就是master。否则重新选举一直到满足上述条件。


### 11、解释一下 Elasticsearch 的 分片？
### 12、elasticsearch 是如何实现 master 选举的
### 13、Elasticsearch 是如何实现 Master 选举的？
### 14、elasticsearch是如何实现master选举的
### 15、详细描述一下 Elasticsearch 更新和删除文档的过程。
### 16、您能解释一下X-Pack for Elasticsearch的功能和重要性吗？
### 17、你能否列出与 Elasticsearch 有关的主要可用字段数据类型？
### 18、详细描述一下Elasticsearch搜索的过程。
### 19、你可以列出 Elasticsearch 各种类型的分析器吗？
### 20、详细描述一下Elasticsearch搜索的过程？
### 21、可以列出X-Pack API 吗？
### 22、请解释有关 Elasticsearch的 NRT？
### 23、elasticsearch 数据的写入原理
### 24、ElasticSearch如何监控集群状态？
### 25、安装 Elasticsearch 需要依赖什么组件吗？
### 26、能列出 10 个使用 Elasticsearch 作为其搜索引擎或数据库的公司吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
