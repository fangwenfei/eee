# Kafka最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Kafka可以接收的消息最大为多少？

Kafka可以接收的最大消息大小约为1000000字节。


### 2、在Kafka中，ZooKeeper的作用是什么？

**1、** 这道题，也是我经常会问候选人的题，因为任何分布式系统中虽然都通过一些列的算法去除了传统的关系型数据存储，但是毕竟还是有些数据要存储的，同时分布式系统的特性往往是需要有一些中间人角色来统筹集群。比如我们在整个微服务框架中的Dubbo，它也是需要依赖一些注册中心或配置中心类的中间件的，以及云原生的Kubernetes使用etcd作为整个集群的枢纽。

**2、** 标准答案：目前，Kafka使用ZooKeeper存放集群元数据、成员管理、Controller选举，以及其他一些管理类任务。之后，等KIP-500提案完成后，Kafka将完全不再依赖于ZooKeeper。

**1、** “存放元数据”是指主题分区的所有数据都保存在 ZooKeeper 中，且以它保存的数据为权威，其他 “人” 都要与它保持对齐。

**2、** “成员管理” 是指 Broker 节点的注册、注销以及属性变更，等等。

**3、** “Controller 选举” 是指选举集群 Controller，而其他管理类任务包括但不限于主题删除、参数配置等。

KIP-500 思想，是使用社区自研的基于Raft的共识算法，替代ZooKeeper，实现Controller自选举。



### 3、副本长时间不在ISR中，这意味着什么？

意味着 follower 不能像 leader 收集数据那样快速地获取数据。


### 4、Kafka系统工具有哪些类型？

**1、** Kafka迁移工具：它有助于将代理从一个版本迁移到另一个版本。

**2、** Mirror Maker：Mirror Maker工具有助于将一个Kafka集群的镜像提供给另一个。

**3、** 消费者检查:对于指定的主题集和消费者组，它显示主题，分区，所有者。


### 5、列出所有Apache Kafka业务

Apache Kafka的业务包括：添加和删除Kafka主题如何修改Kafka主题如何关机在Kafka集群之间镜像数据找到消费者的位置扩展您的Kafka群集自动迁移数据退出服务器数据中心


### 6、Kafka一次reblance大概要多久

1个Topic，10个partition，3个consumer 测试结果 经过几轮测试发现每次rebalance所消耗的时间大概在 80ms~100ms平均耗时在87ms左右。


### 7、为什么Kafka技术很重要？

Kafka有一些优点，因此使用起来很重要：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_2.png#alt=9%5C_2.png)

高吞吐量：我们在Kafka中不需要任何大型硬件，因为它能够处理高速和大容量数据。此外，它还可以支持每秒数千条消息的消息吞吐量。低延迟：Kafka可以轻松处理这些消息，具有毫秒级的极低延迟，这是大多数新用例所要求的。容错：Kafka能够抵抗集群中的节点/机器故障。耐久性：由于Kafka支持消息复制，因此消息永远不会丢失。这是耐久性背后的原因之一。可扩展性：卡夫卡可以扩展，而不需要通过添加额外的节点而在运行中造成任何停机。


### 8、：35, 36, 37


### 9、3.它还可以在记录进入时对其进行处理。Apache Kafka对于新手的面试
### 10、分区Leader选举策略有几种？

分区的Leader副本选举对用户是完全透明的，它是由Controller独立完成的。你需要回答的是，在哪些场景下，需要执行分区Leader选举。每一种场景对应于一种选举策略。

**1、** OfflinePartition Leader选举：每当有分区上线时，就需要执行Leader选举。所谓的分区上线，可能是创建了新分区，也可能是之前的下线分区重新上线。这是最常见的分区Leader选举场景。

**2、** ReassignPartition Leader选举：当你手动运行Kafka-reassign-partitions命令，或者是调用Admin的alterPartitionReassignments方法执行分区副本重分配时，可能触发此类选举。假设原来的AR是[1，2，3]，Leader是1，当执行副本重分配后，副本集合AR被设置成[4，5，6]，显然，Leader必须要变更，此时会发生Reassign Partition Leader选举。

**3、** PreferredReplicaPartition Leader选举：当你手动运行Kafka-preferred-replica-election命令，或自动触发了Preferred Leader选举时，该类策略被激活。所谓的Preferred Leader，指的是AR中的第一个副本。比如AR是[3，2，1]，那么，Preferred Leader就是3。

**4、** ControlledShutdownPartition Leader选举：当Broker正常关闭时，该Broker上的所有Leader副本都会下线，因此，需要为受影响的分区执行相应的Leader选举。

这4类选举策略的大致思想是类似的，即从AR中挑选首个在ISR中的副本，作为新Leader。


### 11、Kafka存在那些局限性？
### 12、比较传统队列系统与Apache Kafka
### 13、Kafka 的设计时什么样的呢？
### 14、：3,5,6
### 15、如何估算Kafka集群的机器数量？
### 16、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 17、Kafka Producer 写数据，ACK 为 0，1，-1 时分别代表什么？
### 18、Kafka 判断一个节点是否还活着有那两个条件？
### 19、如何设置Kafka能接收的最大消息的大小？
### 20、Kafka 消息是采用 Pull 模式，还是 Push 模式？
### 21、能简单说一下rebalance过程吗？
### 22、consumer是推还是拉？
### 23、Kafka的主要API有哪些？
### 24、consumer_offsets是做什么用的？
### 25、没有zookeeper可以使用Kafka吗？
### 26、解释如何调整Kafka以获得最佳性能。
### 27、解释下Kafka中位移（offset）的作用




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
