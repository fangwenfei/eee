# Elasticsearch最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、请解释有关 Elasticsearch的 NRT？

从文档索引（写入）到可搜索到之间的延迟默认一秒钟，因此Elasticsearch是近实时（NRT）搜索平台。

也就是说：文档写入，最快一秒钟被索引到，不能再快了。

写入调优的时候，我们通常会动态调整：refresh_interval = 30s 或者更达值，以使得写入数据更晚一点时间被搜索到。


### 2、在索引中更新 Mapping 的语法？

```
PUT test_001/_mapping
{
  "properties": {
    "title":{
      "type":"keyword"
    }
  }
}
```


### 3、如何在 Elasticsearch中 搜索数据？

Search API 有助于从索引、路由参数引导的特定分片中查找检索数据。


### 4、能列出 10 个使用 Elasticsearch 作为其搜索引擎或数据库的公司吗？

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


### 5、Elasticsearch 在部署时，对 Linux 的设置有哪些优化方法

面试官：想了解对 ES 集群的运维能力。

解

**1、** 关闭缓存 swap;

**2、** 堆内存设置为：Min（节点内存/2, 32GB）;

**3、** 设置最大文件句柄数；

**4、** 线程池+队列大小根据业务需要做调整；

**5、** 磁盘存储 raid 方式——存储有条件使用 RAID10，增加单节点性能以及避免单

节点存储故障。


### 6、Beats 如何与 Elasticsearch 结合使用？

Beats是一种开源工具，可以将数据直接传输到 Elasticsearch 或通过 logstash，在使用Kibana进行查看之前，可以对数据进行处理或过滤。

传输的数据类型包含：审核数据，日志文件，云数据，网络流量和窗口事件日志等。


### 7、能列举过你使用的 X-Pack 命令吗?

7.1 安全功能免费后，使用了：setup-passwords 为账号设置密码，确保集群安全。


### 8、您能否列出 与 ELK日志分析相关的应用场景？

**1、** 电子商务搜索解决方案

**2、** 欺诈识别

**3、** 市场情报

**4、** 风险管理

**5、** 安全分析 等。

### 9、您能解释一下 Elasticsearch 中的 Explore API 吗？

没有用过，这是 Graph （收费功能）相关的API。

点到为止即可，类似问题实际开发现用现查，类似问题没有什么意义。

[https://www.elastic.co/guide/en/elasticsearch/reference/current/graph-explore-api.html](https://www.elastic.co/guide/en/elasticsearch/reference/current/graph-explore-api.html)


### 10、ElasticSearch如何监控集群状态？

Marvel让你可以很简单的通过Kibana监控Elasticsearch。你可以实时查看你的集群健康状态和性能，也可以分析过去的集群、索引和节点指标。


### 11、解释一下 Elasticsearch 集群中的 Type 的概念 ？
### 12、Elasticsearch是如何实现master选举的？
### 13、在安装Elasticsearch时，请说明不同的软件包及其重要性？
### 14、token filter 过滤器 在 Elasticsearch 中如何工作？
### 15、可以列出X-Pack API 吗？
### 16、如何监控 Elasticsearch 集群状态？
### 17、Elasticsearch在部署时，对Linux的设置有哪些优化方法
### 18、elasticsearch 数据的写入原理
### 19、ElasticSearch主分片数量可以在后期更改吗？为什么？
### 20、elasticsearch 的 document设计
### 21、Elasticsearch中的节点（比如共20个），其中的10个选了一个master，另外10个选了另一个master，怎么办？
### 22、elasticsearch 的倒排索引是什么
### 23、Elasticsearch 中常用的 cat命令有哪些？
### 24、lucence内部结构是什么？
### 25、迁移 Migration API 如何用作 Elasticsearch？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
