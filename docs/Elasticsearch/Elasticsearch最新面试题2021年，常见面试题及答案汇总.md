# Elasticsearch最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个master，另外 10 个选了另一个 master，怎么办？

**1、** 当集群 master 候选数量不小于 3 个时，可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个 master 候选，其他作为 data节点，避免脑裂问题。


### 2、Elasticsearch 是如何实现 Master 选举的？

**1、** Elasticsearch 的选主是 ZenDiscovery 模块负责的，**主要包含 Ping（节点之**

**间通过这个 RPC 来发现彼此）和 Unicast（单播模块包含一个主机列表以控制哪**

**些节点需要 ping 通）这两部分；**

**2、** 对所有可以成为 master 的节点（node.master: true）根据 nodeId 字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第 0 位）节点，暂且认为它是 master 节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为 master 节点数 n/2+1）并且该节点自己也选举自己，那这个节点就是 master。否则重新选举一直到满足上述条件。

**4、补充**：master 节点的职责主要包括集群、节点和索引的管理，不负责文档级

别的管理；data 节点可以关闭 http 功能。


### 3、你能否列出与 Elasticsearch 有关的主要可用字段数据类型？

**1、** 字符串数据类型，包括支持全文检索的 text 类型 和 精准匹配的 keyword 类型。

**2、** 数值数据类型，例如字节，短整数，长整数，浮点数，双精度数，half_float，scaled_float。

**3、** 日期类型，日期纳秒Date nanoseconds，布尔值，二进制（Base64编码的字符串）等。

**4、** 范围（整数范围 integer_range，长范围 long_range，双精度范围 double_range，浮动范围 float_range，日期范围 date_range）。

**5、** 包含对象的复杂数据类型，nested 、Object。

**6、** GEO 地理位置相关类型。

**7、** 特定类型如：数组（数组中的值应具有相同的数据类型）


### 4、在并发情况下，Elasticsearch如果保证读写一致？

**1、** 可以通过版本号使用乐观并发控制，以确保新版本不会被旧版本覆盖，由应用层来处理具体的冲突；

**2、** 另外对于写操作，一致性级别支持quorum/one/all，默认为quorum，即只有当大多数分片可用时才允许写操作。但即使大多数可用，也可能存在因为网络等原因导致写入副本失败，这样该副本被认为故障，分片将会在一个不同的节点上重建。

**3、** 对于读操作，可以设置replication为sync(默认)，这使得操作在主分片和副本分片都完成后才会返回；如果设置replication为async时，也可以通过设置搜索请求参数_preference为primary来查询主分片，确保文档是最新版本。


### 5、您能否说明当前可下载的稳定Elasticsearch版本？

Elasticsearch 当前最新版本是7.10（2020年11月21日）。

为什么问这个问题？ES 更新太快了，应聘者如果了解并使用最新版本，基本能说明他关注 ES 更新。甚至从更广维度讲，他关注技术的迭代和更新。

但，不信你可以问问，很多求职者只知道用了 ES，什么版本一概不知。


### 6、请解释有关 Elasticsearch的 NRT？

从文档索引（写入）到可搜索到之间的延迟默认一秒钟，因此Elasticsearch是近实时（NRT）搜索平台。

也就是说：文档写入，最快一秒钟被索引到，不能再快了。

写入调优的时候，我们通常会动态调整：refresh_interval = 30s 或者更达值，以使得写入数据更晚一点时间被搜索到。


### 7、elasticsearch 的 document设计

在使用es时 避免使用复杂的查询语句（Join 、聚合），就是在建立索引时，

就根据查询语句建立好对应的元数据。


### 8、ElasticSearch如何监控集群状态？

Marvel让你可以很简单的通过Kibana监控Elasticsearch。你可以实时查看你的集群健康状态和性能，也可以分析过去的集群、索引和节点指标。


### 9、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？

Elasticsearch 提供的首个近似聚合是 cardinality 度量。它提供一个字段的基数，即该字段的 _distinct_ 或者 _unique_ 值的数目。它是基于 HLL 算法的。HLL 会先对我们的输入作哈希运算，然后根据哈希运算的结果中的 bits 做概率估算从而得到

基数。其特点是：可配置的精度，用来控制内存的使用（更精确 ＝ 更多内存）；小的数据集精度是非常高的；我们可以通过配置参数，来设置去重需要的固定内存使用量。无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关。


### 10、REST API在 Elasticsearch 方面有哪些优势？

REST API是使用超文本传输协议的系统之间的通信，该协议以 XML 和 JSON格式传输数据请求。

REST 协议是无状态的，并且与带有服务器和存储数据的用户界面分开，从而增强了用户界面与任何类型平台的可移植性。它还提高了可伸缩性，允许独立实现组件，因此应用程序变得更加灵活。

REST API与平台和语言无关，只是用于数据交换的语言是XML或JSON。

借助：REST API 查看集群信息或者排查问题都非常方便。


### 11、能列出 10 个使用 Elasticsearch 作为其搜索引擎或数据库的公司吗？
### 12、elasticsearch的倒排索引是什么
### 13、什么是ElasticSearch索引？
### 14、19、解释 Elasticsearch 中的相关性和得分？
### 15、elasticsearch 的倒排索引是什么
### 16、在并发情况下，Elasticsearch 如果保证读写一致？
### 17、elasticsearch 索引数据多了怎么办，如何调优，部署
### 18、解释一下 Elasticsearch集群中的 索引的概念 ？
### 19、详细描述一下Elasticsearch搜索的过程。
### 20、elasticsearch是如何实现master选举的
### 21、如何使用 Elastic Reporting ？
### 22、简要介绍一下Elasticsearch？
### 23、详细描述一下Elasticsearch搜索的过程？
### 24、详细描述一下ElasticSearch更新和删除文档的过程
### 25、您能解释一下 Elasticsearch 中的 Explore API 吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
