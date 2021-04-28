# Elasticsearch最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、解释一下 Elasticsearch 的 分片？

当文档数量增加，硬盘容量和处理能力不足时，对客户端请求的响应将延迟。

在这种情况下，将索引数据分成小块的过程称为分片，可改善数据搜索结果的获取。


### 2、详细描述一下Elasticsearch搜索的过程？

面试官：想了解ES搜索的底层原理，不再只关注业务层面了。

搜索拆解为“query then fetch” 两个阶段。

query阶段的目的：定位到位置，但不取。

**步骤拆解如下：**

**1、** 假设一个索引数据有5主+1副本 共10分片，一次请求会命中（主或者副本分片中）的一个。

**2、** 每个分片在本地进行查询，结果返回到本地有序的优先队列中。

**3、** 第2）步骤的结果发送到协调节点，协调节点产生一个全局的排序列表。

fetch阶段的目的：取数据。

路由节点获取所有文档，返回给客户端。


### 3、能列出 10 个使用 Elasticsearch 作为其搜索引擎或数据库的公司吗？

这个问题，铭毅本来想删掉。但仔细一想，至少能看出求职者的视野够不够开阔。

参与过 Elastic中文社区活动或者经常关注社区动态的就知道，公司太多了，列举如下（排名不分先后）：

1、阿里

2、腾讯

3、百度

4、京东

5、美团

6、小米

7、滴滴

8、携程

**9、** 今日头条

**10、** 贝壳找房

**11、** 360

**12、** IBM

**13、** 顺丰快递

几乎我们能想到的互联网公司都在使用 Elasticsearch。

关注 TOP 互联网公司的相关技术的动态和技术博客，也是一种非常好的学习方式。


### 4、Elasticsearch 中的节点（比如共 20 个），其中的 10 个选了一个master，另外 10 个选了另一个 master，怎么办？

**1、** 当集群 master 候选数量不小于 3 个时，可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上来解决脑裂问题；

**2、** 当候选数量为两个时，只能修改为唯一的一个 master 候选，其他作为 data节点，避免脑裂问题。


### 5、Elasticsearch 是如何实现 Master 选举的？

**1、** Elasticsearch 的选主是 ZenDiscovery 模块负责的，**主要包含 Ping（节点之**

**间通过这个 RPC 来发现彼此）和 Unicast（单播模块包含一个主机列表以控制哪**

**些节点需要 ping 通）这两部分；**

**2、** 对所有可以成为 master 的节点（node.master: true）根据 nodeId 字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第 0 位）节点，暂且认为它是 master 节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为 master 节点数 n/2+1）并且该节点自己也选举自己，那这个节点就是 master。否则重新选举一直到满足上述条件。

**4、补充**：master 节点的职责主要包括集群、节点和索引的管理，不负责文档级

别的管理；data 节点可以关闭 http 功能。


### 6、elasticsearch 实际设计

采用elasticSearch + Hbase的架构方式。es中只存放少量关键数据建立索引，通过es查询到doc id 再去Hbase中查询完整的数据信息。


### 7、详细描述一下 Elasticsearch 索引文档的过程。

协调节点默认使用文档 ID 参与计算（也支持通过 routing），以便为路由提供合适的分片。

shard = hash(document_id) % (num_of_primary_shards)

**1、** 当分片所在的节点接收到来自协调节点的请求后，会将请求写入到 MemoryBuffer，然后定时（默认是每隔 1 秒）写入到 Filesystem Cache，这个从 MomeryBuffer 到 Filesystem Cache 的过程就叫做 refresh；

**2、** 当然在某些情况下，存在 Momery Buffer 和 Filesystem Cache 的数据可能会丢失，ES 是通过 translog 的机制来保证数据的可靠性的。其实现机制是接收到请求后，同时也会写入到 translog 中，当 Filesystem cache 中的数据写入到磁盘中时，才会清除掉，这个过程叫做 flush；

**3、** 在 flush 过程中，内存中的缓冲将被清除，内容被写入一个新段，段的 fsync将创建一个新的提交点，并将内容刷新到磁盘，旧的 translog 将被删除并开始一个新的 translog。

**4、** flush 触发的时机是定时触发（默认 30 分钟）或者 translog 变得太大（默认为 512M）时；


### 8、elasticsearch 读取数据

使用RestFul API向对应的node发送查询请求，根据did来判断在哪个shard上，返回的是primary和replica的node节点集合

这样会负载均衡地把查询发送到对应节点，之后对应节点接收到请求，将document数据返回协调节点，协调节点把document返回给客户端

![](https://image-static.segmentfault.com/277/237/2772379432-5e5b563f9a221_articlex#alt=3cI6RP.png)


### 9、能列举过你使用的 X-Pack 命令吗?

7.1 安全功能免费后，使用了：setup-passwords 为账号设置密码，确保集群安全。


### 10、如何使用 Elastic Reporting ？

收费功能，只是了解，点到为止。

Reporting API有助于将检索结果生成 PD F格式，图像 PNG 格式以及电子表格 CSV 格式的数据，并可根据需要进行共享或保存。


### 11、ES更新数据的执行流程？
### 12、elasticsearch 的 filesystem
### 13、对于 GC 方面，在使用 Elasticsearch 时要注意什么？
### 14、详细描述一下Elasticsearch索引文档的过程
### 15、详细说明ELK Stack及其内容？
### 16、详细描述一下Elasticsearch搜索的过程。
### 17、elasticsearch 了解多少，说说你们公司 es 的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 18、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。
### 19、客户端在和集群连接时，如何选择特定的节点执行请求的？
### 20、Master 节点和 候选 Master节点有什么区别？
### 21、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？
### 22、介绍一下你们的个性化搜索方案？
### 23、elasticsearch 数据的写入过程
### 24、解释一下 Elasticsearch集群中的 索引的概念 ？
### 25、请解释一下 Elasticsearch 中聚合？
### 26、Elasticsearch是如何实现master选举的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
