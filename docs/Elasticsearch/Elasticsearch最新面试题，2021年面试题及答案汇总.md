# Elasticsearch最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、详细描述一下Elasticsearch更新和删除文档的过程。

**1、** 删除和更新也都是写操作，但是Elasticsearch中的文档是不可变的，因此不能被删除或者改动以展示其变更；

**2、** 磁盘上的每个段都有一个相应的.del文件。当删除请求发送后，文档并没有真的被删除，而是在.del文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del文件中被标记为删除的文档将不会被写入新段。

**3、** 在新的文档被创建时，Elasticsearch会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中被过滤掉。


### 2、详细描述一下 Elasticsearch 索引文档的过程。

协调节点默认使用文档 ID 参与计算（也支持通过 routing），以便为路由提供合适的分片。

shard = hash(document_id) % (num_of_primary_shards)

**1、** 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到 MemoryBuffer，然后定时（默认是每隔 1 秒）写入到 Filesystem Cache，这个从 MomeryBuffer 到 Filesystem Cache 的过程就叫做 refresh；

**2、** 当然在某些情况下，存在 Momery Buffer 和 Filesystem Cache 的数据可能会丢失，ES 是通过 translog 的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也会写入到 translog 中，当 Filesystem cache 中的数据写入到磁盘中时，才会清除掉，这个过程叫做 flush；

**3、** 在 flush 过程中，内存中的缓冲将被清除，内容被写入一个新段，段的 fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的 translog 将被删除并开始一个新的 translog。

**4、** flush 触发的时机是定时触发（默认 30 分钟）或者 translog 变得太大（默认为 512M）时；


### 3、详细描述一下Elasticsearch搜索的过程？

`面试官`：想了解ES搜索的底层原理，不再只关注业务层面了。

搜索拆解为“query then fetch” 两个阶段。

**query阶段的目的**：定位到位置，但不取。

步骤拆解如下：

**1、** 假设一个索引数据有5主+1副本 共10分片，一次请求会命中（主或者副本分片中）的一个。

**2、** 每个分片在本地进行查询，结果返回到本地有序的优先队列中。

**3、** 第2）步骤的结果发送到协调节点，协调节点产生一个全局的排序列表。

**fetch阶段的目的**：取数据。

路由节点获取所有文档，返回给客户端。


### 4、Elasticsearch 中常用的 cat命令有哪些？

面试时说几个核心的就可以，包含但不限于：

| 含义 | 命令 |
| --- | --- |
| 别名 | GET _cat/aliases?v |
| 分配相关 | GET _cat/allocation |
| 计数 | GET _cat/count?v |
| 字段数据 | GET _cat/fielddata?v |
| 运行状况 | GET_cat/health? |
| 索引相关 | GET _cat/indices?v |
| 主节点相关 | GET _cat/master?v |
| 节点属性 | GET _cat/nodeattrs?v |
| 节点 | GET _cat/nodes?v |
| 待处理任务 | GET _cat/pending_tasks?v |
| 插件 | GET _cat/plugins?v |
| 恢复 | GET _cat / recovery?v |
| 存储库 | GET _cat /repositories?v |
| 段 | GET _cat /segments?v |
| 分片 | GET _cat/shards?v |
| 快照 | GET _cat/snapshots?v |
| 任务 | GET _cat/tasks?v |
| 模板 | GET _cat/templates?v |
| 线程池 | GET _cat/thread_pool?v |



### 5、你是如何做 ElasticSearch 写入调优的？

1）写入前副本数设置为0；

2）写入前关闭refresh_interval设置为-1，禁用刷新机制；

3）写入过程中：采取bulk批量写入；

4） 写入后恢复副本数和刷新间隔；

5） 尽量使用自动生成的id。


### 6、什么是ElasticSearch索引？

索引（名词）： 一个索引(index)就像是传统关系数据库中的数据库，它是相关文档存储的地方，index的复数是indices或indexes。

索引（动词）：「索引一个文档」表示把一个文档存储到索引（名词）里，以便它可以被检索或者查询。这很像SQL中的INSERT关键字，差别是，如果文档已经存在，新的文档将覆盖旧的文档。


### 7、elasticsearch是如何实现master选举的

`面试官`：想了解ES集群的底层原理，不再只关注业务层面了。

**前置前提：**

**1、** 只有候选主节点（master：true）的节点才能成为主节点。

**2、** 最小主节点数（min_master_nodes）的目的是防止脑裂。

这个我看了各种网上分析的版本和源码分析的书籍，云里雾里。

核对了一下代码，核心入口为findMaster，选择主节点成功返回对应Master，否则返回null。选举流程大致描述如下：

第一步：确认候选主节点数达标，elasticsearch.yml设置的值discovery.zen.minimum_master_nodes；

第二步：比较：先判定是否具备master资格，具备候选主节点资格的优先返回；若两节点都为候选主节点，则id小的值会主节点。注意这里的id为string类型。

题外话：获取节点id的方法。

```
 1GET /_cat/nodes?v&h=ip,port,heapPercent,heapMax,id,name
2ip        port heapPercent heapMax id   name
```


### 8、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？
### 9、解释一下 Elasticsearch Node？
### 10、Elasticsearch中的 Ingest 节点如何工作？
### 11、在安装Elasticsearch时，请说明不同的软件包及其重要性？
### 12、elasticsearch 的 filesystem
### 13、lucence内部结构是什么？
### 14、ElasticSearch中的副本是什么？
### 15、拼写纠错是如何实现的？
### 16、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 17、是否了解字典树？
### 18、在并发情况下，Elasticsearch如果保证读写一致？
### 19、elasticsearch 是如何实现 master 选举的
### 20、详细描述一下Elasticsearch搜索的过程。
### 21、elasticsearch 了解多少，说说你们公司 es 的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 22、Master 节点和 候选 Master节点有什么区别？
### 23、Elasticsearch 支持哪些类型的查询？
### 24、Elasticsearch 是如何实现 Master 选举的？
### 25、如何监控Elasticsearch集群状态？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
