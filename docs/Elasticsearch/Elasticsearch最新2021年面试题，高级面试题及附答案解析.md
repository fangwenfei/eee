# Elasticsearch最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？

**1、** 当集群master候选数量不小于3个时，可以通过设置最少投票通过数量（**discovery.zen.minimum_master_nodes**）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个master候选，其他作为data节点，避免脑裂问题。


### 2、你之前公司的ElasticSearch集群，一个Node一般会分配几个分片？

我们遵循官方建议，一个Node最好不要多于三个shards.


### 3、ElasticSearch中的倒排索引是什么？

倒排索引是搜索引擎的核心，搜索引擎的主要目标是在查找发生搜索条件的文档时提供快速搜索。倒排索引是一种像数据结构一样的散列图，可将用户从单词导向文档或网页，它是搜索引擎的核心。其主要目标是快速搜索从数百万文件中查找数据。


### 4、Beats 如何与 Elasticsearch 结合使用？

Beats是一种开源工具，可以将数据直接传输到 Elasticsearch 或通过 logstash，在使用Kibana进行查看之前，可以对数据进行处理或过滤。

传输的数据类型包含：审核数据，日志文件，云数据，网络流量和窗口事件日志等。


### 5、ElasticSearch主分片数量可以在后期更改吗？为什么？

不可以，因为根据路由算法shard = hash(document_id) % (num_of_primary_shards)，当主分片数量变化时会影响数据被路由到哪个分片上。


### 6、REST API在 Elasticsearch 方面有哪些优势？

REST API是使用超文本传输协议的系统之间的通信，该协议以 XML 和 JSON格式传输数据请求。

REST 协议是无状态的，并且与带有服务器和存储数据的用户界面分开，从而增强了用户界面与任何类型平台的可移植性。它还提高了可伸缩性，允许独立实现组件，因此应用程序变得更加灵活。

REST API与平台和语言无关，只是用于数据交换的语言是XML或JSON。

借助：REST API 查看集群信息或者排查问题都非常方便。


### 7、ES在生产集群的部署架构是什么，每个索引有多大的数据量，每个索引有多少分片

**生产环境部署情况**

**1、** es生产集群我们部署了5台机器，每台机器是6核64G的，集群总内存是320G

**2、** 我们es集群的日增量数据大概是2000万条，每天日增量数据大概是500MB，

**3、** 每月增量数据大概是6亿，15G。目前系统已经运行了几个月，现在es集群里数据总量大概是100G左右。

**4、** 目前线上有5个索引（这个结合你们自己业务来，看看自己有哪些数据可以放es的），

**5、** 每个索引的数据量大概是20G，所以这个数据量之内，我们每个索引分配的是8个shard，比默认的5个shard多了3个shard。



### 8、Elasticsearch是如何实现master选举的？
### 9、ElasticSearch中的分析器是什么？
### 10、elasticsearch 的 document设计
### 11、对于 GC 方面，在使用 Elasticsearch 时要注意什么？
### 12、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法
### 13、19、解释 Elasticsearch 中的相关性和得分？
### 14、请解释在 Elasticsearch 集群中添加或创建索引的过程？
### 15、elasticsearch 读取数据
### 16、elasticsearch 冷热分离
### 17、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 18、解释一下 Elasticsearch 集群中的 Type 的概念 ？
### 19、如何监控 Elasticsearch 集群状态？
### 20、在 Elasticsearch 中列出集群的所有索引的语法是什么？
### 21、ElasticSearch如何避免脑裂？
### 22、客户端在和集群连接时，如何选择特定的节点执行请求的？
### 23、logstash 如何与 Elasticsearch 结合使用？
### 24、迁移 Migration API 如何用作 Elasticsearch？
### 25、Elasticsearch的 文档是什么？
### 26、在索引中更新 Mapping 的语法？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
