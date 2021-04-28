# Elasticsearch最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、elasticsearch 了解多少，说说你们公司 es 的集群架构，索引数据大小，分片有多少，以及一些调优手段 。

面试官：想了解应聘者之前公司接触的 ES 使用场景、规模，有没有做过比较大规模的索引设计、规划、调优。

解如实结合自己的实践场景回答即可。

比如：ES 集群架构 13 个节点，索引根据通道不同共 20+索引，根据日期，每日递增 20+，索引：10 分片，每日递增 1 亿+数据，每个通道每天索引大小控制：

150GB 之内。

仅索引层面调优手段：

**设计阶段调优**

**1、** 根据业务增量需求，采取基于日期模板创建索引，通过 roll over API 滚动索引；

**2、** 使用别名进行索引管理；

**3、** 每天凌晨定时对索引做 force_merge 操作，以释放空间；

**4、** 采取冷热分离机制，热数据存储到 SSD，提高检索效率；冷数据定期进行 shrink操作，以缩减存储；

**5、** 采取 curator 进行索引的生命周期管理；

**6、** 仅针对需要分词的字段，合理的设置分词器；

**7、** Mapping 阶段充分结合各个字段的属性，是否需要检索、是否需要存储等。……..

**写入调优**

**1、** 写入前副本数设置为 0；

**2、** 写入前关闭 refresh_interval 设置为-1，禁用刷新机制；

**3、** 写入过程中：采取 bulk 批量写入；

**4、** 写入后恢复副本数和刷新间隔；

**5、** 尽量使用自动生成的 id。

**查询调优**

**1、** 禁用 wildcard；

**2、** 禁用批量 terms（成百上千的场景）；

**3、** 充分利用倒排索引机制，能 keyword 类型尽量 keyword；

**4、** 数据量大时候，可以先基于时间敲定索引再检索；

**5、** 设置合理的路由机制。

**其他调优**

部署调优，业务调优等。

上面的提及一部分，面试者就基本对你之前的实践或者运维经验有所评估了。


### 2、如何监控 Elasticsearch 集群状态？

Marvel 让你可以很简单的通过 Kibana 监控 Elasticsearch。你可以实时查看你的集群健康状态和性能，也可以分析过去的集群、索引和节点指标。


### 3、Elasticsearch是如何实现Master选举的？

**1、** Elasticsearch的选主是ZenDiscovery模块负责的，主要包含Ping（节点之间通过这个RPC来发现彼此）和Unicast（单播模块包含一个主机列表以控制哪些节点需要ping通）这两部分；

**2、** 对所有可以成为master的节点（**node.master: true**）根据nodeId字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第0位）节点，暂且认为它是master节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为master节点数n/2+1）并且该节点自己也选举自己，那这个节点就是master。否则重新选举一直到满足上述条件。

**4、** 补充：master节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data节点可以关闭http功能*。


### 4、拼写纠错是如何实现的？

**1、** 拼写纠错是基于编辑距离来实现；编辑距离是一种标准的方法，它用来表示经过插入、删除和替换操作从一个字符串转换到另外一个字符串的最小操作步数；

**2、** 编辑距离的计算过程：比如要计算batyu和beauty的编辑距离，先创建一个7×8的表（batyu长度为5，coffee长度为6，各加2），接着，在如下位置填入黑色数字。其他格的计算过程是取以下三个值的最小值：

如果最上方的字符等于最左方的字符，则为左上方的数字。否则为左上方的数字+1。（对于3,3来说为0）

左方数字+1（对于3,3格来说为2）

上方数字+1（对于3,3格来说为2）

最终取右下角的值即为编辑距离的值3。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_6.png#alt=img%5C_6.png)

对于拼写纠错，我们考虑构造一个度量空间（Metric Space），该空间内任何关系满足以下三条基本条件：

d(x,y) = 0 -- 假如x与y的距离为0，则x=y

d(x,y) = d(y,x)  -- x到y的距离等同于y到x的距离

d(x,y) + d(y,z) >= d(x,z) -- 三角不等式

**1、** 根据三角不等式，则满足与query距离在n范围内的另一个字符转B，其与A的距离最大为d+n，最小为d-n。

**2、** BK树的构造就过程如下：每个节点有任意个子节点，每条边有个值表示编辑距离。所有子节点到父节点的边上标注n表示编辑距离恰好为n。比如，我们有棵树父节点是”book”和两个子节点”cake”和”books”，”book”到”books”的边标号1，”book”到”cake”的边上标号4。从字典里构造好树后，无论何时你想插入新单词时，计算该单词与根节点的编辑距离，并且查找数值为d(neweord, root)的边。递归得与各子节点进行比较，直到没有子节点，你就可以创建新的子节点并将新单词保存在那。比如，插入”boo”到刚才上述例子的树中，我们先检查根节点，查找d(“book”, “boo”) = 1的边，然后检查标号为1的边的子节点，得到单词”books”。我们再计算距离d(“books”, “boo”)=2，则将新单词插在”books”之后，边标号为2。

**3、** 查询相似词如下：计算单词与根节点的编辑距离d，然后递归查找每个子节点标号为d-n到d+n（包含）的边。假如被检查的节点与搜索单词的距离d小于n，则返回该节点并继续查询。比如输入cape且最大容忍距离为1，则先计算和根的编辑距离d(“book”, “cape”)=4，然后接着找和根节点之间编辑距离为3到5的，这个就找到了cake这个节点，计算d(“cake”, “cape”)=1，满足条件所以返回**cake**，然后再找和cake节点编辑距离是0到2的，分别找到cape和cart节点，这样就得到**cape**这个满足条件的结果。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_7.png#alt=img%5C_7.png)


### 5、解释一下 Elasticsearch 的 分片？

当文档数量增加，硬盘容量和处理能力不足时，对客户端请求的响应将延迟。

在这种情况下，将索引数据分成小块的过程称为分片，可改善数据搜索结果的获取。


### 6、ElasticSearch中的分析器是什么？

在ElasticSearch中索引数据时，数据由为索引定义的Analyzer在内部进行转换。分析器由一个Tokenizer和零个或多个TokenFilter组成。编译器可以在一个或多个CharFilter之前，分析模块允许你在逻辑名称下注册分析器，然后可以在映射定义或某些API中引用它们。ElasticSearch附带了许多可以随时使用的预建分析器。或者，你可以组合内置的字符过滤器，编译器和过滤器来创建自定义分析器。


### 7、您能否列出 与 ELK日志分析相关的应用场景？

**1、** 电子商务搜索解决方案

**2、** 欺诈识别

**3、** 市场情报

**4、** 风险管理

**5、** 安全分析 等。

### 8、Elasticsearch是如何实现master选举的？

面试官：想了解ES集群的底层原理，不再只关注业务层面了。

**前置前提：**

**1、** 只有候选主节点（master：true）的节点才能成为主节点。

**1、** 最小主节点数（min_master_nodes）的目的是防止脑裂。

这个我看了各种网上分析的版本和源码分析的书籍，云里雾里。

核对了一下代码，核心入口为findMaster，选择主节点成功返回对应Master，否则返回null。选举流程大致描述如下：

第一步：确认候选主节点数达标，elasticsearch.yml设置的值discovery.zen.minimum_master_nodes；

第二步：比较：先判定是否具备master资格，具备候选主节点资格的优先返回；若两节点都为候选主节点，则id小的值会主节点。注意这里的id为string类型。

**题外话：获取节点id的方法。**

**1、** GET /_cat/nodes?v&h=ip,port,heapPercent,heapMax,id,name

**2、** ip    port heapPercent heapMax id  name

**3、** 127.0.0.1 9300     39  1.9gb Hk9w Hk9wFwU

**补充：**

**1、** Elasticsearch 的选主是 ZenDiscovery 模块负责的，主要包含 Ping（节点之间通过这个 RPC 来发现彼此）和 Unicast（单播模块包含一个主机列表以控制哪些节点需要 ping 通）这两部分；

**2、** 对所有可以成为 master 的节点（node.master: true）根据 nodeId 字典排序，每次选举每个节点都把自己所知道节点排一次序，然后选出第一个（第 0 位）节点，暂且认为它是 master 节点。

**3、** 如果对某个节点的投票数达到一定的值（可以成为 master 节点数 n/2+1）并且该节点自己也选举自己，那这个节点就是 master。否则重新选举一直到满足上述条件。

**4、** master 节点的职责主要包括集群、节点和索引的管理，不负责文档级别的管理；data 节点可以关闭 http 功能。



### 9、能列举过你使用的 X-Pack 命令吗?

7.1 安全功能免费后，使用了：setup-passwords 为账号设置密码，确保集群安全。


### 10、ElasticSearch主分片数量可以在后期更改吗？为什么？

不可以，因为根据路由算法shard = hash(document_id) % (num_of_primary_shards)，当主分片数量变化时会影响数据被路由到哪个分片上。


### 11、ES在生产集群的部署架构是什么，每个索引有多大的数据量，每个索引有多少分片
### 12、在安装Elasticsearch时，请说明不同的软件包及其重要性？
### 13、详细描述一下 Elasticsearch 索引文档的过程。
### 14、ElasticSearch是如何实现Master选举的？
### 15、在Elasticsearch中 cat API的功能是什么？
### 16、详细描述一下Elasticsearch搜索的过程？
### 17、Elasticsearch 对于大数据量（上亿量级）的聚合如何实现？
### 18、详细描述一下 Elasticsearch 搜索的过程。
### 19、如何监控Elasticsearch集群状态？
### 20、是否了解字典树？
### 21、Kibana在Elasticsearch的哪些地方以及如何使用？
### 22、Elasticsearch在部署时，对Linux的设置有哪些优化方法？
### 23、介绍一下你们的个性化搜索方案？
### 24、如何在 Elasticsearch中 搜索数据？
### 25、您能否分步介绍如何启动 Elasticsearch 服务器？
### 26、elasticsearch 全文检索




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
