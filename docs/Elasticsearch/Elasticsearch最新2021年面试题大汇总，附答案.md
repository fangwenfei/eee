# Elasticsearch最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、你是如何做 ElasticSearch 写入调优的？

1）写入前副本数设置为0；

2）写入前关闭refresh_interval设置为-1，禁用刷新机制；

3）写入过程中：采取bulk批量写入；

4） 写入后恢复副本数和刷新间隔；

5） 尽量使用自动生成的id。


### 2、elasticsearch 数据的写入原理

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


### 3、elasticsearch 索引数据多了怎么办，如何调优，部署

`面试官`：想了解大数据量的运维能力。

索引数据的规划，应在前期做好规划，正所谓“设计先行，编码在后”，这样才能有效的避免突如其来的数据激增导致集群处理能力不足引发的线上客户检索或者其他业务受到影响。

如何调优，正如问题1所说，这里细化一下：

**动态索引层面**

基于`模板+时间+rollover api滚动`创建索引，举例：设计阶段定义：blog索引的模板格式为：blog_index_时间戳的形式，每天递增数据。

这样做的好处：不至于数据量激增导致单个索引数据量非常大，接近于上线2的32次幂-1，索引存储达到了TB+甚至更大。

一旦单个索引很大，存储等各种风险也随之而来，所以要提前考虑+及早避免。

**存储层面**

`冷热数据分离存储`，热数据（比如最近3天或者一周的数据），其余为冷数据。

对于冷数据不会再写入新数据，可以考虑定期force_merge加shrink压缩操作，节省存储空间和检索效率。

**部署层面**

一旦之前没有规划，这里就属于应急策略。

结合ES自身的支持动态扩展的特点，动态新增机器的方式可以缓解集群压力，注意：如果之前主节点等`规划合理`，不需要重启集群也能完成动态新增的。


### 4、Elasticsearch的 文档是什么？

文档是存储在 Elasticsearch 中的 JSON 文档。它等效于关系数据库表中的一行记录。


### 5、详细描述一下Elasticsearch搜索的过程？

`面试官`：想了解ES搜索的底层原理，不再只关注业务层面了。

搜索拆解为“query then fetch” 两个阶段。

**query阶段的目的**：定位到位置，但不取。

步骤拆解如下：

**1、** 假设一个索引数据有5主+1副本 共10分片，一次请求会命中（主或者副本分片中）的一个。

**2、** 每个分片在本地进行查询，结果返回到本地有序的优先队列中。

**3、** 第2）步骤的结果发送到协调节点，协调节点产生一个全局的排序列表。

**fetch阶段的目的**：取数据。

路由节点获取所有文档，返回给客户端。


### 6、我们可以在 Elasticsearch 中执行搜索的各种可能方式有哪些？

核心方式如下：

方式一：基于 DSL 检索（最常用） Elasticsearch提供基于JSON的完整查询DSL来定义查询。

```
GET /shirts/_search
{
  "query": {
    "bool": {
      "filter": [
        { "term": { "color": "red"   }},
        { "term": { "brand": "gucci" }}
      ]
    }
  }
}
```

方式二：基于 URL 检索

```
GET /my_index/_search?q=user:seina
```

方式三：类SQL 检索

```
POST /_sql?format=txt
{
  "query": "SELECT * FROM uint-2020-08-17 ORDER BY itemid DESC LIMIT 5"
}
```

功能还不完备，不推荐使用。


### 7、Elasticsearch中的属性 enabled, index 和 store 的功能是什么？

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


### 8、什么是Elasticsearch Analyzer？

分析器用于文本分析，它可以是内置分析器也可以是自定义分析器。


### 9、是否了解字典树？

**常用字典数据结构如下所示：**

![70_8.png][70_8.png]

**Trie 的核心思想是空间换时间，利用字符串的公共前缀来降低查询时间的开销以**

达到提高效率的目的。

**它有 3 个基本性质：**

**1、** 根节点不包含字符，除根节点外每一个节点都只包含一个字符。

**2、** 从根节点到某一节点，路径上经过的字符连接起来，为该节点对应的字符串。

**3、** 每个节点的所有子节点包含的字符都不相同。

![70_9.png][70_9.png]

**1、** 可以看到，trie 树每一层的节点数是 26^i 级别的。所以为了节省空间，我们还可以用动态链表，或者用数组来模拟动态。而空间的花费，不会超过单词数×单词长度。

**2、实现：**对每个结点开一个字母集大小的数组，每个结点挂一个链表，使用左儿子右兄弟表示法记录这棵树；

**3、** 对于中文的字典树，每个节点的子节点用一个哈希表存储，这样就不用浪费太大的空间，而且查询速度上可以保留哈希的复杂度 O(1)。


### 10、在安装Elasticsearch时，请说明不同的软件包及其重要性？

这个貌似没什么好说的，去官方文档下载对应操作系统安装包即可。

部分功能是收费的，如机器学习、高级别 kerberos 认证安全等选型要知悉。


### 11、在Elasticsearch中 cat API的功能是什么？
### 12、详细描述一下Elasticsearch更新和删除文档的过程。
### 13、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法
### 14、elasticsearch 全文检索
### 15、Elasticsearch 支持哪些配置管理工具？
### 16、Kibana在Elasticsearch的哪些地方以及如何使用？
### 17、Elasticsearch对于大数据量（上亿量级）的聚合如何实现？
### 18、如何监控 Elasticsearch 集群状态？
### 19、安装 Elasticsearch 需要依赖什么组件吗？
### 20、定义副本、创建副本的好处是什么？
### 21、详细描述一下ElasticSearch更新和删除文档的过程
### 22、在 Elasticsearch 中列出集群的所有索引的语法是什么？
### 23、elasticsearch 的倒排索引是什么
### 24、Elasticsearch 中常用的 cat命令有哪些？
### 25、elasticsearch 的 document设计
### 26、您能否列出 与 ELK日志分析相关的应用场景？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
