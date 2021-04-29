# Kafka最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Java在Apache Kafka中的重要性是什么？

为了满足Kafka标准的高处理速率需求，我们可以使用java语言。此外，对于Kafka的消费者客户，Java也提供了良好的社区支持。所以，我们可以说在Java中实现Kafka是一个正确的选择。


### 2、能说一下leader选举过程吗

我们知道ZooKeeper集群中也有选举机制，是通过Paxos算法，通过不同节点向其他节点发送信息来投票选举出leader，但是Kafka的leader的选举就没有这么复杂了。

Kafka的Leader选举是通过在ZooKeeper上创建/controller临时节点来实现leader选举，并在该节点中写入当前broker的信息 {“version”:1,”brokerid”:1,”timestamp”:”1512018424988”} 利用ZooKeeper的强一致性特性，一个节点只能被一个客户端创建成功，创建成功的broker即为leader，即先到先得原则，leader也就是集群中的controller，负责集群中所有大小事务。当leader和ZooKeeper失去连接时，临时节点会删除，而其他broker会监听该节点的变化，当节点删除时，其他broker会收到事件通知，重新发起leader选举。


### 3、Kafka中的 zookeeper 起到什么作用？可以不用zookeeper吗？

zookeeper 是一个分布式的协调组件，早期版本的Kafka用zk做meta信息存储，consumer的消费状态，group 的管理以及 offset 的值。考虑到 zookeeper 本身的一些因素以及整个架构较大概率存在单点问题，新版本中逐渐弱化了 zookeeper 的作用。新的 consumer 使用了 Kafka 内部的 group coordination 协议，也减少了对 zookeeper 的依赖，

但是 broker 依然依赖于 zookeeper，zookeeper 在Kafka中还用来选举 controller 和检测 broker 是否存活等等。


### 4、Kafka流的特点。

Kafka流的一些最佳功能是Kafka Streams具有高度可扩展性和容错性。Kafka部署到容器，VM，裸机，云。我们可以说，Kafka流对于小型，中型和大型用例同样可行。此外，它完全与Kafka安全集成。编写标准Java应用程序。完全一次处理语义。而且，不需要单独的处理集群。


### 5、Zookeeper对于Kafka的作用是什么？

**1、** Zookeeper是一个开放源码的、高性能的协调服务，它用于Kafka的分布式应用。

**2、** Zookeeper主要用于在集群中不同节点之间进行通信

**3、** 在Kafka中，它被用于提交偏移量，因此如果节点在任何情况下都失败了，它都可以从之前提交的偏移量中获取

**4、** 除此之外，它还执行其他活动，如: leader检测、分布式同步、配置管理、识别新节点何时离开或连接、集群、节点实时状态等等。


### 6、为什么Kafka的复制至关重要？

由于复制，我们可以确保的消息不会丢失，并且可以在发生任何机器错误、程序错误或频繁的软件升级时使用。


### 7、Kafka 存储在硬盘上的消息格式是什么？

消息由一个固定长度的头部和可变长度的字节数组组成。头部包含了一个版本号和 CRC32

校验码。

**1、** 消息长度: 4 bytes (value: 1+4+n)

**2、** 版本号: 1 byte

**3、** CRC 校验码: 4 bytes

**4、** 具体的消息: n bytes


### 8、解释术语“主题复制因子”。

在设计Kafka系统时，考虑主题复制是非常重要的。


### 9、什么是Kafka？

Kafka是**分布式-订阅消息系统**，它最初是由LinkedIn公司开发的，之后成为Apache项目的一部分，Kafka是一个分布式，可划分的，冗余备份的持久性的日志服务，它主要用于处理流式数据。


### 10、Kafka中的 ISR、AR 又代表什么？ISR 的伸缩又指什么？

**ISR**：In-Sync Replicas 副本同步队列；ISR是由leader维护，follower从leader同步数据有一些延迟（包括延迟时间replica.lag.time.max.ms和延迟条数replica.lag.max.messages两个维度, 版本0.10.x中只支持replica.lag.time.max.ms这个维度），任意一个超过阈值都会把follower剔除出ISR, 存入OSR（Outof-Sync Replicas）列表，新加入的follower也会先存放在OSR中。AR=ISR+OSR。

**AR**：Assigned Replicas 所有副本；


### 11、Kafka存在那些局限性？
### 12、Kafka 判断一个节点是否还活着有那两个条件？
### 13、消费者如何不自动提交偏移量，由应用提交？
### 14、Kafka集群中保留期的目的是什么？
### 15、偏移的作用是什么？
### 16、：31, 32, 33, 34, 38, 39, 40Apache Kafka对于有经验的人的面试
### 17、Kafka 高效文件存储设计特点：
### 18、Kafka和Flume之间的主要区别是什么？
### 19、消费者API的作用是什么？
### 20、如何估算Kafka集群的机器数量？
### 21、解释Kafka Producer API的作用。
### 22、Controller发生网络分区（Network Partitioning）时，Kafka会怎么样？
### 23、为什么Kafka的复制至关重要？
### 24、比较传统队列系统与Apache Kafka
### 25、为什么要使用Apache Kafka集群？
### 26、什么是Kafka中的地域复制？
### 27、Kafka 的消费者如何消费数据
### 28、Kafka为什么不支持读写分离？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
