# Elasticsearch最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、能列举过你使用的 X-Pack 命令吗?

7.1 安全功能免费后，使用了：setup-passwords 为账号设置密码，确保集群安全。


### 2、ES在生产集群的部署架构是什么，每个索引有多大的数据量，每个索引有多少分片

**生产环境部署情况**

**1、** es生产集群我们部署了5台机器，每台机器是6核64G的，集群总内存是320G

**2、** 我们es集群的日增量数据大概是2000万条，每天日增量数据大概是500MB，

**3、** 每月增量数据大概是6亿，15G。目前系统已经运行了几个月，现在es集群里数据总量大概是100G左右。

**4、** 目前线上有5个索引（这个结合你们自己业务来，看看自己有哪些数据可以放es的），

**5、** 每个索引的数据量大概是20G，所以这个数据量之内，我们每个索引分配的是8个shard，比默认的5个shard多了3个shard。



### 3、在Elasticsearch中 cat API的功能是什么？

cat API 命令提供了Elasticsearch 集群的分析、概述和运行状况，其中包括与别名，分配，索引，节点属性等有关的信息。

这些 cat 命令使用查询字符串作为其参数，并以J SON 文档格式返回结果信息。


### 4、详细说明ELK Stack及其内容？

ELK Stack是一系列搜索和分析工具（Elasticsearch），收集和转换工具（Logstash）以及数据管理及可视化工具（Kibana）、解析和收集日志工具（Beats 未来是 Agent）以及监视和报告工具（例如X Pack）的集合。

相当于用户基本不再需要第三方技术栈，就能全流程、全环节搞定数据接入、存储、检索、可视化分析等全部功能。


### 5、详细描述一下 Elasticsearch 索引文档的过程

面试官：想了解 ES 的底层原理，不再只关注业务层面了。

解

这里的索引文档应该理解为文档写入 ES，创建索引的过程。文档写入包含：单文档写入和批量 bulk 写入，这里只解释一下：单文档写入流程。

**第一步：**客户写集群某节点写入数据，发送请求。（如果没有指定路由/协调节点，请求的节点扮演路由节点的角色。）

**第二步：**节点 1 接受到请求后，使用文档_id 来确定文档属于分片 0。请求会被转到另外的节点，假定节点 3。因此分片 0 的主分片分配到节点 3 上。

**第三步：**节点 3 在主分片上执行写操作，如果成功，则将请求并行转发到节点 1和节点 2 的副本分片上，等待结果返回。所有的副本分片都报告成功，节点 3 将向协调节点（节点 1）报告成功，节点 1 向请求客户端报告写入成功。

**如果面试官再问：**第二步中的文档获取分片的过程？

回借助路由算法获取，路由算法就是根据路由和文档 id 计算目标的分片 id 的

过程。

```
1shard = hash(_routing) % (num_of_primary_shards)
```


### 6、介绍一下你们的个性化搜索方案？

SEE [基于word2vec和Elasticsearch实现个性化搜索](http://ginobefunny.com/post/personalized_search_implemention_based_word2vec_and_elasticsearch/)


### 7、ElasticSearch如何避免脑裂？

可以通过设置最少投票通过数量（discovery.zen.minimum_master_nodes）超过所有候选节点一半以上，来解决脑裂问题。


### 8、elasticsearch了解多少，说说你们公司es的集群架构，索引数据大小，分片有多少，以及一些调优手段 。

`面试官`：想了解应聘者之前公司接触的ES使用场景、规模，有没有做过比较大规模的索引设计、规划、调优。

如实结合自己的实践场景回答即可。

比如：ES集群架构13个节点，索引根据通道不同共20+索引，根据日期，每日递增20+，索引：10分片，每日递增1亿+数据，

每个通道每天索引大小控制：150GB之内。

仅索引层面调优手段：

**设计阶段调优**

**1、** 根据业务增量需求，采取基于日期模板创建索引，通过roll over API滚动索引；

**2、** 使用别名进行索引管理；

**3、** 每天凌晨定时对索引做force_merge操作，以释放空间；

**4、** 采取冷热分离机制，热数据存储到SSD，提高检索效率；冷数据定期进行shrink操作，以缩减存储；

**5、** 采取curator进行索引的生命周期管理；

**6、** 仅针对需要分词的字段，合理的设置分词器；

**7、** Mapping阶段充分结合各个字段的属性，是否需要检索、是否需要存储等。……..

**写入调优**

**1、** 写入前副本数设置为0；

**2、** 写入前关闭refresh_interval设置为-1，禁用刷新机制；

**3、** 写入过程中：采取bulk批量写入；

**4、** 写入后恢复副本数和刷新间隔；

**5、** 尽量使用自动生成的id。

**查询调优**

**1、** 禁用wildcard；

**2、** 禁用批量terms（成百上千的场景）；

**3、** 充分利用倒排索引机制，能keyword类型尽量keyword；

**4、** 数据量大时候，可以先基于时间敲定索引再检索；

**5、** 设置合理的路由机制。

**1.4、其他调优**

部署调优，业务调优等。

上面的提及一部分，面试者就基本对你之前的实践或者运维经验有所评估了。


### 9、ES更新数据的执行流程？

(1) 将原来的doc标识为deleted状态，然后新写入一条数据。

(2) buffer每refresh一次，就会产生一个segmentfile，所以默认情况下是1s一个segmentfile，segmentfile会越来越多，此时会定期执行merge。

(3) 每次merge时,会将多个segmentfile合并成一个，同时这里会将标识为deleted的doc给物理删除掉，然后将新的segmentfile写入磁盘，这里会写一个commitpoint，标识所有新的segmentfile，然后打开segmentfile供搜索使用，同时删除旧的segmentfile。


### 10、elasticsearch 读取数据

使用RestFul API向对应的node发送查询请求，根据did来判断在哪个shard上，返回的是primary和replica的node节点集合

这样会负载均衡地把查询发送到对应节点，之后对应节点接收到请求，将document数据返回协调节点，协调节点把document返回给客户端

![](https://image-static.segmentfault.com/277/237/2772379432-5e5b563f9a221_articlex#alt=3cI6RP.png)


### 11、在并发情况下，Elasticsearch 如果保证读写一致？
### 12、Elasticsearch 中常用的 cat命令有哪些？
### 13、token filter 过滤器 在 Elasticsearch 中如何工作？
### 14、elasticsearch的倒排索引是什么
### 15、介绍下你们电商搜索的整体技术架构
### 16、19、解释 Elasticsearch 中的相关性和得分？
### 17、请解释一下 Elasticsearch 中聚合？
### 18、详细描述一下Elasticsearch搜索的过程？
### 19、对于GC方面，在使用Elasticsearch时要注意什么？
### 20、在Elasticsearch中 按 ID检索文档的语法是什么？
### 21、如何使用 Elastic Reporting ？
### 22、详细描述一下Elasticsearch索引文档的过程
### 23、解释一下 Elasticsearch 集群中的 Type 的概念 ？
### 24、lucence内部结构是什么？
### 25、我们可以在 Elasticsearch 中执行搜索的各种可能方式有哪些？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
