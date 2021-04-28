# Kafka最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何估算Kafka集群的机器数量？

**1、** 该题也算是SRE的送分题吧，对于SRE来讲，任何生产的系统第一步需要做的就是容量预估以及集群的架构规划，实际上也就是机器数量和所用资源之间的关联关系，资源通常来讲就是CPU，内存，磁盘容量，带宽。但需要注意的是，Kafka因为独有的设计，对于磁盘的要求并不是特别高，普通机械硬盘足够，而通常的瓶颈会出现在带宽上。

**2、** 在预估磁盘的占用时，你一定不要忘记计算副本同步的开销。如果一条消息占用1KB的磁盘空间，那么，在有3个副本的主题中，你就需要3KB的总空间来保存这条消息。同时，需要考虑到整个业务Topic数据保存的最大时间，以上几个因素，基本可以预估出来磁盘的容量需求。

**3、** 需要注意的是：对于磁盘来讲，一定要提前和业务沟通好场景，而不是等待真正有磁盘容量瓶颈了才去扩容磁盘或者找业务方沟通方案。

**4、** 对于带宽来说，常见的带宽有1Gbps和10Gbps，通常我们需要知道，当带宽占用接近总带宽的90%时，丢包情形就会发生。


### 2、没有ZooKeeper可以使用Kafka吗？

绕过Zookeeper并直接连接到Kafka服务器是不可能的，所以答案是否定的。如果以某种方式，使ZooKeeper关闭，则无法为任何客户端请求提供服务。


### 3、Kafka的主要API有哪些？

Apache Kafka有4个主要API：

生产者API 消费者API 流 API 连接器API


### 4、如何调优Kafka？

**1、** 作为SRE来讲，任何生产环境的调优，首先需要识别问题和瓶颈点，而不是随意的进行臆想调优。随后，需要确定优化目标，并且定量给出目标。

**2、** 对于Kafka来讲，常见的调优方向基本为：吞吐量、延时、持久性和可用性，每种目标之前都是由冲突点，这也就要求了，我们在对业务接入使用时，要进行业务场景的了解，以对业务进行相对的集群隔离，因为每一个方向的优化思路都是不同的，甚至是相反的。

**3、** 确定了目标之后，还要明确优化的维度。有些调优属于通用的优化思路，比如对操作系统、JVM等的优化；有些则是有针对性的，比如要优化Kafka的TPS。我们需要从3个方向去考虑：

**1、** Producer端：增加batch.size和linger.ms，启用压缩，关闭重试

**2、** Broker端：增加num.replica.fetchers提升Follower同步TPS，避免Broker Full GC等。

**3、** Consumer：增加fetch.min.bytes


### 5、Kafka的流处理是什么意思？

连续、实时、并发和以逐记录方式处理数据的类型，我们称之为Kafka流处理。


### 6、：12,15,20


### 7、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?

**1、** Kafka分布式的单位是partition，同一个partition用一个write ahead log组织，所以可以保证FIFO的顺序。不同partition之间不能保证顺序。但是绝大多数用户都可以通过message key来定义，因为同一个key的message可以保证只发送到同一个partition。

**2、** Kafka 中发送1条消息的时候，可以指定(topic, partition, key) 3个参数。partiton 和 key 是可选的。如果你指定了 partition，那就是所有消息发往同1个 partition，就是有序的。并且在消费端，Kafka 保证，1个 partition 只能被1个 consumer 消费。或者你指定 key（比如 order id），具有同1个 key 的所有消息，会发往同1个 partition。


### 8、如何获取topic主题的列表

bin/Kafka-topics.sh --list --zookeeper localhost:2181


### 9、比较传统队列系统与Apache Kafka

让我们比较一下传统队列系统与Apache Kafka的功能：消息保留 传统的队列系统 - 它通常从队列末尾处理完成后删除消息。 Apache Kafka中，消息即使在处理后仍然存在。这意味着Kafka中的消息不会因消费者收到消息而被删除。基于逻辑的处理传统队列系统不允许基于类似消息或事件处理逻辑。Apache Kafka允许基于类似消息或事件处理逻辑。


### 10、Apache Kafka是什么？

能问这道题，主要是想看候选人对于Kafka的使用场景以及定位认知理解有多深，同时候可以知道候选人对于这项技术的关注度。

我们都知道，在开源软件中，大部分软件随着用户量的增加，整个软件的功能和定位也有了新的变化，而Apache Kafka一路发展到现在，已经由最初的分布式提交日志系统逐渐演变成了实时流处理框架。

因此，这道题你最好这么回Apach Kafka是一款分布式流处理平台，用于实时构建流处理应用。它有一个核心的功能广为人知，即作为企业级的消息引擎被广泛使用（通常也会称之为消息总线message bus）。

关于分布式流处理平台，其实从它官方的Logo以及Slogan我们就很容易看出来。


### 11、消息队列的作用
### 12、什么是消费者或用户？
### 13、什么是Kafka？
### 14、：11,13,14,16,17,18,19Apache Kafka对于有经验的人的面试
### 15、Kafka Producer 写数据，ACK 为 0，1，-1 时分别代表什么？
### 16、：35, 36, 37
### 17、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 18、Kafka 与传统消息系统之间有三个关键区别
### 19、Kafka 判断一个节点是否还活着有那两个条件？
### 20、消费者如何不自动提交偏移量，由应用提交？
### 21、Kafka为什么不支持读写分离？
### 22、解释下Kafka中位移（offset）的作用
### 23、producer 是否直接将数据发送到 broker 的 leader(主节点)？
### 24、Java Consumer为什么采用单线程来获取消息？
### 25、Kafka能手动删除消息吗？
### 26、Kafka流的特点。
### 27、如何设置Kafka能接收的最大消息的大小？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
