# Elasticsearch最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何使用 Elastic Reporting ？

收费功能，只是了解，点到为止。

Reporting API有助于将检索结果生成 PD F格式，图像 PNG 格式以及电子表格 CSV 格式的数据，并可根据需要进行共享或保存。


### 2、如何监控Elasticsearch集群状态？

Marvel 让你可以很简单的通过 Kibana 监控 Elasticsearch。你可以实时查看你的集群健康状态和性能，也可以分析过去的集群、索引和节点指标。


### 3、什么是ElasticSearch脑裂？

一个正常es集群中只有一个主节点，主节点负责管理整个集群，集群的所有节点都会选择同一个节点作 为主节点所以无论访问那个节点都可以查看集群的状态信息。而脑裂问题的出现就是因为从节点在选择 主节点上出现分歧导致一个集群出现多个主节点从而使集群分裂，使得集群处于异常状态。


### 4、介绍一下你们的个性化搜索方案？

SEE [基于word2vec和Elasticsearch实现个性化搜索](http://ginobefunny.com/post/personalized_search_implemention_based_word2vec_and_elasticsearch/)


### 5、请解释在 Elasticsearch 集群中添加或创建索引的过程？

要添加新索引，应使用创建索引 API 选项。创建索引所需的参数是索引的配置Settings，索引中的字段 Mapping 以及索引别名 Alias。

也可以通过模板 Template 创建索引。


### 6、你之前公司的ElasticSearch集群，一个Node一般会分配几个分片？

我们遵循官方建议，一个Node最好不要多于三个shards.


### 7、拼写纠错是如何实现的？

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


### 8、您能解释一下 Elasticsearch 中的 Explore API 吗？

没有用过，这是 Graph （收费功能）相关的API。

点到为止即可，类似问题实际开发现用现查，类似问题没有什么意义。

[https://www.elastic.co/guide/en/elasticsearch/reference/current/graph-explore-api.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/graph-explore-api.html)


### 9、elasticsearch是如何实现master选举的

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


### 10、详细描述一下Elasticsearch搜索的过程。

**1、** 搜索被执行成一个两阶段过程，我们称之为 Query Then Fetch；

**2、** 在初始**查询阶段**时，查询会广播到索引中每一个分片拷贝（主分片或者副本分片）。 每个分片在本地执行搜索并构建一个匹配文档的大小为 from + size 的优先队列。

PS：在搜索的时候是会查询Filesystem Cache的，但是有部分数据还在Memory Buffer，所以搜索是近实时的。

**3、** 每个分片返回各自优先队列中 **所有文档的 ID 和排序值** 给协调节点，它合并这些值到自己的优先队列中来产生一个全局排序后的结果列表。

**4、** 接下来就是 **取回阶段**，协调节点辨别出哪些文档需要被取回并向相关的分片提交多个 GET 请求。每个分片加载并 _丰富_ 文档，如果有需要的话，接着返回文档给协调节点。一旦所有的文档都被取回了，协调节点返回结果给客户端。

**5、** 补充：Query Then Fetch的搜索类型在文档相关性打分的时候参考的是本分片的数据，这样在文档数量较少的时候可能不够准确，DFS Query Then Fetch增加了一个预查询的处理，询问Term和Document frequency，这个评分更准确，但是性能会变差。*

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2019/08/0820/02/img_2.png#alt=img%5C_2.png)


### 11、token filter 过滤器 在 Elasticsearch 中如何工作？
### 12、Elasticsearch 是如何实现 Master 选举的？
### 13、elasticsearch 读取数据
### 14、您能否分步介绍如何启动 Elasticsearch 服务器？
### 15、能列举过你使用的 X-Pack 命令吗?
### 16、详细描述一下 Elasticsearch 更新和删除文档的过程。
### 17、介绍下你们电商搜索的整体技术架构。
### 18、可以列出X-Pack API 吗？
### 19、lucence内部结构是什么？
### 20、logstash 如何与 Elasticsearch 结合使用？
### 21、REST API在 Elasticsearch 方面有哪些优势？
### 22、Elasticsearch在部署时，对Linux的设置有哪些优化方法？
### 23、elasticsearch 数据预热
### 24、在并发情况下，Elasticsearch如果保证读写一致？
### 25、解释一下 Elasticsearch集群中的 索引的概念 ？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
