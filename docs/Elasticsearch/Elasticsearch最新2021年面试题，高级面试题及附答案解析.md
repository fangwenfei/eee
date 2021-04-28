# Elasticsearch最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、你是如何做 ElasticSearch 写入调优的？

1）写入前副本数设置为0；

2）写入前关闭refresh_interval设置为-1，禁用刷新机制；

3）写入过程中：采取bulk批量写入；

4） 写入后恢复副本数和刷新间隔；

5） 尽量使用自动生成的id。


### 2、可以列出X-Pack API 吗？

付费功能只是试用过（面试时如实回答就可以）。

7.1 安全功能免费后，用 X-pack 创建Space、角色、用户，设置SSL加密，并且为不同用户设置不同的密码和分配不同的权限。

其他如：机器学习、 Watcher、 Migration 等 API 用的较少。


### 3、如何在 Elasticsearch中 搜索数据？

Search API 有助于从索引、路由参数引导的特定分片中查找检索数据。


### 4、ElasticSearch中的倒排索引是什么？

倒排索引是搜索引擎的核心，搜索引擎的主要目标是在查找发生搜索条件的文档时提供快速搜索。倒排索引是一种像数据结构一样的散列图，可将用户从单词导向文档或网页，它是搜索引擎的核心。其主要目标是快速搜索从数百万文件中查找数据。


### 5、详细描述一下Elasticsearch索引文档的过程。

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


### 6、你可以列出 Elasticsearch 各种类型的分析器吗？

Elasticsearch Analyzer 的类型为内置分析器和自定义分析器。

**Standard Analyzer**

标准分析器是默认分词器，如果未指定，则使用该分词器。

它基于Unicode文本分割算法，适用于大多数语言。

**Whitespace Analyzer**

基于空格字符切词。

**Stop Analyzer**

在simple Analyzer的基础上，移除停用词。

**Keyword Analyzer**

不切词，将输入的整个串一起返回。

自定义分词器的模板

自定义分词器的在Mapping的Setting部分设置：

```
PUT my_custom_index
{
 "settings":{
  "analysis":{
  "char_filter":{},
  "tokenizer":{},
  "filter":{},
  "analyzer":{}
  }
 }
}
```

脑海中还是上面的三部分组成的图示。其中：

“char_filter”:{},——对应字符过滤部分；

“tokenizer”:{},——对应文本切分为分词部分；

“filter”:{},——对应分词后再过滤部分；

“analyzer”:{}——对应分词器组成部分，其中会包含：1. 2. 3。


### 7、elasticsearch 是如何实现 master 选举的

面试官：想了解 ES 集群的底层原理，不再只关注业务层面了。

解

**前置前提：**

**1、** 只有候选主节点（master：true）的节点才能成为主节点。

**2、** 最小主节点数（min_master_nodes）的目的是防止脑裂。

这个我看了各种网上分析的版本和源码分析的书籍，云里雾里。核对了一下代码，核心入口为 findMaster，选择主节点成功返回对应 Master，否则返回 null。

**选举流程大致描述如下：**

第一步：确认候选主节点数达标，elasticsearch.yml 设置的值

```
discovery.zen.minimum_master_nodes；
```

第二步：比较：先判定是否具备 master 资格，具备候选主节点资格的优先返回；

若两节点都为候选主节点，则 id 小的值会主节点。

注意这里的 id 为 string 类型。

题外话：获取节点 id 的方法。

```
1GET /_cat/nodes?v&h=ip,port,heapPercent,heapMax,id,name
2ip
port heapPercent heapMax id
name
```


### 8、ElasticSearch对于大数据量（上亿量级）的聚合如何实现？

ElasticSearch提供的首个近似聚合是cardinality度量。它提供一个字段的基数，即该字段的distinct或者unique值的数目。它是基于HLL算法的。HLL会先对我们的输入做哈希运算，然后根据哈希运算结果中的bits做概率估算从而得到基数。其特点是：

可配置的精度，用来控制内存的使用（更精确＝更多内存），小的数据集精度是非常高的；我们可以通过配置参数来设置去重需要的固定内存使用量，无论数千还是数十亿的唯一值，内存使用量只与你配置的精确度相关 。

图片


### 9、客户端在和集群连接时，如何选择特定的节点执行请求的？

**1、** TransportClient利用transport模块远程连接一个elasticsearch集群。它并不加入到集群中，只是简单的获得一个或者多个初始化的transport地址，并以 **轮询** 的方式与这些地址进行通信。


### 10、elasticsearch 数据的写入原理

es数据写入原理主要可以分为4个操作：

**1、** refresh

**2、** commit

**3、** flush

**4、** merge

| 操作触发条件 | 操作过程 |
| --- | --- |
| **refresh** | 1\\、每隔1s进行一次refresh操作
2\\、buffer已满，则进行一次refresh操作 |
| 2\\、清空buffer |  |
| **commit** | 1\\、每隔30分钟执行一次translog
2\\、translog日志已满 |
| 2\\、生成一个 commit point 文件标识此次操作一件把buffer数据执行到了哪一个segment文件
3\\、执行flush操作 |  |
| **flush** | commit操作中 |
| **merge** | 后台检查 |


![](https://image-static.segmentfault.com/284/854/2848546943-5e5b563ad0f06_articlex#alt=3chLse.png)


### 11、ElasticSearch如何监控集群状态？
### 12、token filter 过滤器 在 Elasticsearch 中如何工作？
### 13、对于GC方面，在使用Elasticsearch时要注意什么？
### 14、elasticsearch 冷热分离
### 15、Beats 如何与 Elasticsearch 结合使用？
### 16、Elasticsearch在部署时，对Linux的设置有哪些优化方法
### 17、你之前公司的ElasticSearch集群，一个Node一般会分配几个分片？
### 18、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？
### 19、Elasticsearch 支持哪些配置管理工具？
### 20、详细描述一下 Elasticsearch 索引文档的过程。
### 21、elasticsearch 数据预热
### 22、logstash 如何与 Elasticsearch 结合使用？
### 23、在Elasticsearch中 按 ID检索文档的语法是什么？
### 24、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 25、简要介绍一下Elasticsearch？
### 26、Elasticsearch 中常用的 cat命令有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
