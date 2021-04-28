# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、客户端在和集群连接时，如何选择特定的节点执行请求的？

**1、** TransportClient利用transport模块远程连接一个elasticsearch集群。它并不加入到集群中，只是简单的获得一个或者多个初始化的transport地址，并以 **轮询** 的方式与这些地址进行通信。


### 2、介绍下你们电商搜索的整体技术架构。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_3.png#alt=img%5C_3.png)


### 3、详细描述一下Elasticsearch更新和删除文档的过程。

**1、** 删除和更新也都是写操作，但是Elasticsearch中的文档是不可变的，因此不能被删除或者改动以展示其变更；

**2、** 磁盘上的每个段都有一个相应的.del文件。当删除请求发送后，文档并没有真的被删除，而是在.del文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del文件中被标记为删除的文档将不会被写入新段。

**3、** 在新的文档被创建时，Elasticsearch会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。


### 4、ElasticSearch中的倒排索引是什么？

倒排索引是搜索引擎的核心，搜索引擎的主要目标是在查找发生搜索条件的文档时提供快速搜索。倒排索引是一种像数据结构一样的散列图，可将用户从单词导向文档或网页，它是搜索引擎的核心。其主要目标是快速搜索从数百万文件中查找数据。


### 5、在安装Elasticsearch时，请说明不同的软件包及其重要性？

这个貌似没什么好说的，去官方文档下载对应操作系统安装包即可。

部分功能是收费的，如机器学习、高级别 kerberos 认证安全等选型要知悉。


### 6、elasticsearch 的 filesystem

es每次走fileSystem cache查询速度是最快的

所以将每个查询的数据50% 容量

= fileSystem cache 容量。


### 7、Master 节点和 候选 Master节点有什么区别？

主节点负责集群相关的操作，例如创建或删除索引，跟踪哪些节点是集群的一部分，以及决定将哪些分片分配给哪些节点。

拥有稳定的主节点是衡量集群健康的重要标志。

而候选主节点是被选具备候选资格，可以被选为主节点的那些节点。


### 8、你是如何做 ElasticSearch 写入调优的？

1）写入前副本数设置为0；

2）写入前关闭refresh_interval设置为-1，禁用刷新机制；

3）写入过程中：采取bulk批量写入；

4） 写入后恢复副本数和刷新间隔；

5） 尽量使用自动生成的id。


### 9、ElasticSearch主分片数量可以在后期更改吗？为什么？

不可以，因为根据路由算法shard = hash(document_id) % (num_of_primary_shards)，当主分片数量变化时会影响数据被路由到哪个分片上。


### 10、elasticsearch 冷热分离

类似于MySQL的分表分库

将热数据单独建立一个索引 分配3台机器只保持热机器的索引

另外的机器保持冷数据的索引，但有一个问题，就是事先必须知道哪些是热数据 哪些是冷数据


### 11、ElasticSearch中的副本是什么？
### 12、Beats 如何与 Elasticsearch 结合使用？
### 13、精准匹配检索和全文检索匹配检索的不同？
### 14、请解释在 Elasticsearch 集群中添加或创建索引的过程？
### 15、在 Elasticsearch 中列出集群的所有索引的语法是什么？
### 16、在 Elasticsearch 中，是怎么根据一个词找到对应的倒排索引的？
### 17、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？
### 18、Elasticsearch是如何实现Master选举的？
### 19、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法
### 20、你能告诉我 Elasticsearch 中的数据存储功能吗？
### 21、elasticsearch 实际设计
### 22、拼写纠错是如何实现的？
### 23、Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个master，另外 10 个选了另一个 master，怎么办？
### 24、Elasticsearch在部署时，对Linux的设置有哪些优化方法？
### 25、对于 GC 方面，在使用 Elasticsearch 时要注意什么？
### 26、解释一下Elasticsearch Cluster？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
