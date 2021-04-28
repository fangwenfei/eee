# Elasticsearch最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、请解释有关 Elasticsearch的 NRT？

从文档索引（写入）到可搜索到之间的延迟默认一秒钟，因此Elasticsearch是近实时（NRT）搜索平台。

也就是说：文档写入，最快一秒钟被索引到，不能再快了。

写入调优的时候，我们通常会动态调整：refresh_interval = 30s 或者更达值，以使得写入数据更晚一点时间被搜索到。


### 2、Elasticsearch对于大数据量（上亿量级）的聚合如何实现？

Elasticsearch 提供的首个近似聚合是cardinality 度量。它提供一个字段的基数，即该字段的_distinct_或者_unique_值的数目。它是基于HLL算法的。HLL 会先对我们的输入作哈希运算，然后根据哈希运算的结果中的 bits 做概率估算从而得到基数。其特点是：可配置的精度，用来控制内存的使用（更精确 ＝ 更多内存）；小的数据集精度是非常高的；我们可以通过配置参数，来设置去重需要的固定内存使用量。无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关。


### 3、介绍下你们电商搜索的整体技术架构

![70_7.png][70_7.png]


### 4、lucence 内部结构是什么？

面试官：想了解你的知识面的广度和深度。

解

Lucene 是有索引和搜索的两个过程，包含索引创建，索引，搜索三个要点。可以基于这个脉络展开一些。

最近面试一些公司，被问到的关于 Elasticsearch 和搜索引擎相关的问题，以及自己总结的回答。


### 5、详细描述一下 Elasticsearch 更新和删除文档的过程。

**1、** 删除和更新也都是写操作，但是 Elasticsearch 中的文档是不可变的，因此不能被删除或者改动以展示其变更；

**2、** 磁盘上的每个段都有一个相应的.del 文件。当删除请求发送后，文档并没有真的被删除，而是在.del 文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del 文件中被标记为删除的文档将不会被写入新段。

**3、** 在新的文档被创建时，Elasticsearch 会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del 文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。


### 6、您能否列出 与 ELK日志分析相关的应用场景？

**1、** 电子商务搜索解决方案

**2、** 欺诈识别

**3、** 市场情报

**4、** 风险管理

**5、** 安全分析 等。

### 7、如何使用 Elasticsearch Tokenizer？

Tokenizer 接收字符流（如果包含了字符过滤，则接收过滤后的字符流；否则，接收原始字符流），将其分词。同时记录分词后的顺序或位置(position)，以及开始值（start_offset）和偏移值(end_offset-start_offset)。


### 8、解释一下 Elasticsearch 集群中的 Type 的概念 ？

**5、** X 以及之前的 2.X、1.X 版本 ES支持一个索引多个type的，举例 ES 6.X 中的Join 类型在早期版本实际是多 Type 实现的。

在6、0.0 或 更高版本中创建的索引只能包含一个 Mapping 类型。

Type 将在Elasticsearch 7.0.0中的API中弃用，并在8.0.0中完全删除。


### 9、Elasticsearch Analyzer 中的字符过滤器如何利用？

字符过滤器将原始文本作为字符流接收，并可以通过添加，删除或更改字符来转换字符流。

字符过滤分类如下：

**HTML Strip Character Filter.**

用途：删除HTML元素，如**，并解码HTML实体，如＆amp 。**

**Mapping Character Filter**

用途：替换指定的字符。

**Pattern Replace Character Filter**

用途：基于正则表达式替换指定的字符。


### 10、你能否列出与 Elasticsearch 有关的主要可用字段数据类型？

**1、** 字符串数据类型，包括支持全文检索的 text 类型 和 精准匹配的 keyword 类型。

**2、** 数值数据类型，例如字节，短整数，长整数，浮点数，双精度数，half_float，scaled_float。

**3、** 日期类型，日期纳秒Date nanoseconds，布尔值，二进制（Base64编码的字符串）等。

**4、** 范围（整数范围 integer_range，长范围 long_range，双精度范围 double_range，浮动范围 float_range，日期范围 date_range）。

**5、** 包含对象的复杂数据类型，nested 、Object。

**6、** GEO 地理位置相关类型。

**7、** 特定类型如：数组（数组中的值应具有相同的数据类型）


### 11、在Elasticsearch中 cat API的功能是什么？
### 12、Elasticsearch中的 Ingest 节点如何工作？
### 13、解释一下Elasticsearch Cluster？
### 14、elasticsearch 分布式架构原理
### 15、Kibana在Elasticsearch的哪些地方以及如何使用？
### 16、Elasticsearch的 文档是什么？
### 17、什么是Elasticsearch Analyzer？
### 18、ElasticSearch中的副本是什么？
### 19、拼写纠错是如何实现的？
### 20、ElasticSearch如何避免脑裂？
### 21、我们可以在 Elasticsearch 中执行搜索的各种可能方式有哪些？
### 22、如何监控 Elasticsearch 集群状态？
### 23、您能否说明当前可下载的稳定Elasticsearch版本？
### 24、拼写纠错是如何实现的？
### 25、在安装Elasticsearch时，请说明不同的软件包及其重要性？
### 26、精准匹配检索和全文检索匹配检索的不同？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
