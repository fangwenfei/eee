# Elasticsearch最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、什么是ElasticSearch脑裂？

一个正常es集群中只有一个主节点，主节点负责管理整个集群，集群的所有节点都会选择同一个节点作 为主节点所以无论访问那个节点都可以查看集群的状态信息。而脑裂问题的出现就是因为从节点在选择 主节点上出现分歧导致一个集群出现多个主节点从而使集群分裂，使得集群处于异常状态。


### 2、拼写纠错是如何实现的？

**1、拼写纠错是基于编辑距离来实现**；编辑距离是一种标准的方法，它用来表示经过插入、删除和替换操作从一个字符串转换到另外一个字符串的最小操作步数；

**2、编辑距离的计算过程：**比如要计算 batyu 和 beauty 的编辑距离，先创建一个7×8 的表（batyu 长度为 5，coffee 长度为 6，各加 2），接着，在如下位置填入

黑色数字。

**其他格的计算过程是取以下三个值的最小值：**

如果最上方的字符等于最左方的字符，则为左上方的数字。否则为左上方的数字 +1。（对于 3,3 来说为 0）左方数字+1（对于 3,3 格来说为 2）上方数字+1（对于 3,3 格来说为 2）

最终取右下角的值即为编辑距离的值 3。

![70_10.png][70_10.png]

对于拼写纠错，我们考虑构造一个度量空间（Metric Space），该空间内任何关

系满足以下三条基本条件：

> d(x,y) = 0 -- 假如 x 与 y 的距离为 0，则 x=y

d(x,y) = d(y,x) -- x 到 y 的距离等同于 y 到 x 的距离

d(x,y) + d(y,z) >= d(x,z) -- 三角不等式


**1、** 根据三角不等式，则满足与 query 距离在 n 范围内的另一个字符转 B，其与 A的距离最大为 d+n，最小为 d-n。

**2、** BK 树的构造就过程如下：每个节点有任意个子节点，每条边有个值表示编辑距离。所有子节点到父节点的边上标注 n 表示编辑距离恰好为 n。比如，我们有棵树父节点是”book”和两个子

**点”cake”和”books”，”book”到”books”的边标号 ：**

**1、** ”book”到”cake”的边上标号.

**2、** 从字典里构造好树后，无论何时你想插入新单词时.计算该单词与根节点的编辑距离，并且查找数值为 d(neweord, root)的边。递归得与各子节点进行比较，直到没有子节点，你就可以创建新的子节点并将新单词保存在那。比如，插入”boo”到刚才上述例子的树中，我们先检查根节点，查找 d(“book”, “boo”) = 1 的边，然后检查标号为1 的边的子节点，得到单词”books”。我们再计算距离 d(“books”, “boo”)=2，则将新单词插在”books”之后，边标号为 2。

**3、** 查询相似词如下：计算单词与根节点的编辑距离 d，然后递归查找每个子节点标号为 d-n 到 d+n（包含）的边。假如被检查的节点与搜索单词的距离 d 小于n，则返回该节点并继续查询。比如输入 cape 且最大容忍距离为 1，则先计算和根的编辑距离 d(“book”,“cape”)=4，然后接着找和根节点之间编辑距离为 3 到5 的，这个就找到了cake 这个节点，计算 d(“cake”, “cape”)=1，满足条件所以返回 cake，然后再找和 cake 节点编辑距离是 0 到 2 的，分别找到 cape 和cart 节点，这样就得到 cape 这个满足条件的结果。



### 3、logstash 如何与 Elasticsearch 结合使用？

logstash 是ELK Stack附带的开源 ETL 服务器端引擎，该引擎可以收集和处理来自各种来源的数据。

最典型应用包含：同步日志、邮件数据，同步关系型数据库（MySQL、Oracle）数据，同步非关系型数据库（MongoDB）数据，同步实时数据流 Kafka数据、同步高性能缓存 Redis 数据等。


### 4、客户端在和集群连接时，是如何选择特定的节点执行请求的？

TransportClient利用transport模块远程连接一个ElasticSearch集群。它并不加入到集群中，只是简单的获得一个或者多个初始化的transport地址，并以轮询的方式与这些地址进行通信。


### 5、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？

enabled：false，启用的设置仅可应用于顶级映射定义和 Object 对象字段，导致 Elasticsearch 完全跳过对字段内容的解析。

仍然可以从_source字段中检索JSON，但是无法搜索或以其他任何方式存储JSON。

如果对非全局或者 Object 类型，设置 enable : false 会报错如下：

```
 "type": "mapper_parsing_exception",
 "reason": "Mapping definition for [user_id] has unsupported parameters:  [enabled : false]"
```

index：false, 索引选项控制是否对字段值建立索引。它接受true或false，默认为true。未索引的字段不可查询。

如果非要检索，报错如下：

```
 "type": "search_phase_execution_exception",
  "reason": "Cannot search on field [user_id] since it is not indexed."
```

**store：**

某些特殊场景下，如果你只想检索单个字段或几个字段的值，而不是整个_source的值，则可以使用源过滤来实现；

这个时候， store 就派上用场了。


### 6、elasticsearch 冷热分离

类似于MySQL的分表分库

将热数据单独建立一个索引 分配3台机器只保持热机器的索引

另外的机器保持冷数据的索引，但有一个问题，就是事先必须知道哪些是热数据 哪些是冷数据


### 7、解释一下 Elasticsearch 的 分片？

当文档数量增加，硬盘容量和处理能力不足时，对客户端请求的响应将延迟。

在这种情况下，将索引数据分成小块的过程称为分片，可改善数据搜索结果的获取。


### 8、如何使用 Elastic Reporting ？

收费功能，只是了解，点到为止。

Reporting API有助于将检索结果生成 PD F格式，图像 PNG 格式以及电子表格 CSV 格式的数据，并可根据需要进行共享或保存。


### 9、详细描述一下ElasticSearch更新和删除文档的过程

删除和更新都是写操作，但是ElasticSearch中的文档是不可变的，因此不能被删除或者改动以展示其变更。

磁盘上的每个段都有一个相应的.del文件。当删除请求发送后，文档并没有真的被删除，而是在.del文件中被标记为删除。该文档依然能匹配查询，但是会在结果中被过滤掉。当段合并时，在.del文件中被标记为删除的文档将不会被写入新段。

在新的文档被创建时，ElasticSearch会为该文档指定一个版本号，当执行更新时，旧版本的文档在.del文件中被标记为删除，新版本的文档被索引到一个新段。旧版本的文档依然能匹配查询，但是会在结果中会被过滤掉。


### 10、详细描述一下 Elasticsearch 索引文档的过程。

协调节点默认使用文档 ID 参与计算（也支持通过 routing），以便为路由提供合适的分片。

```
shard = hash(document_id) % (num_of_primary_shards)
```

**1、** 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到 MemoryBuffer，然后定时（默认是每隔 1 秒）写入到 Filesystem Cache，这个从MomeryBuffer 到 Filesystem Cache 的过程就叫做 refresh；

**2、** 当然在某些情况下，存在 Momery Buffer 和 Filesystem Cache 的数据可能会丢失，ES 是通过 translog 的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也会写入到 translog 中，当 Filesystem cache 中的数据写入到磁盘中时，才会清除掉，这个过程叫做 flush；

**3、** 在 flush 过程中，内存中的缓冲将被清除，内容被写入一个新段，段的 fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的 translog 将被删除并开始一个新的 translog。

**4、** flush 触发的时机是定时触发（默认 30 分钟）或者 translog 变得太大（默认为 512M）时；

**补充：关于 Lucene 的 Segement：**

**1、** Lucene 索引是由多个段组成，段本身是一个功能齐全的倒排索引。

**2、** 段是不可变的，允许 Lucene 将新的文档增量地添加到索引中，而不用从头重建索引。

**3、** 对于每一个搜索请求而言，索引中的所有段都会被搜索，并且每个段会消耗CPU 的时钟周、文件句柄和内存。这意味着段的数量越多，搜索性能会越低。

**4、** 为了解决这个问题，Elasticsearch 会合并小段到一个较大的段，提交新的合并

段到磁盘，并删除那些旧的小段。


### 11、详细描述一下 Elasticsearch 搜索的过程。
### 12、elasticsearch 数据预热
### 13、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 14、客户端在和集群连接时，如何选择特定的节点执行请求的？
### 15、解释一下 Elasticsearch集群中的 索引的概念 ？
### 16、Elasticsearch在部署时，对Linux的设置有哪些优化方法？
### 17、elasticsearch 的 filesystem
### 18、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 19、Elasticsearch的 文档是什么？
### 20、详细描述一下 Elasticsearch 更新和删除文档的过程。
### 21、您能否分步介绍如何启动 Elasticsearch 服务器？
### 22、在并发情况下，Elasticsearch如果保证读写一致？
### 23、Elasticsearch是如何实现Master选举的？
### 24、请解释一下 Elasticsearch 中聚合？
### 25、你可以列出 Elasticsearch 各种类型的分析器吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
