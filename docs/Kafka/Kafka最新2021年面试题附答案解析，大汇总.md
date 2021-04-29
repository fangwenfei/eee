# Kafka最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、：41, 42, 43, 44, 45, 47, 49Apache Kafka对于有经验的人的面试
### 2、解释偏移的作用。

给分区中的消息提供了一个顺序ID号，我们称之为偏移量。因此，为了唯一地识别分区中的每条消息，我们使用这些偏移量。


### 3、为什么Kafka不支持读写分离？

在 Kafka 中，生产者写入消息、消费者读取消息的操作都是与 leader 副本进行交互的，从 而实现的是一种**主写主读**的生产消费模型。

Kafka 并不支持主写从读，因为主写从读有 2 个很明 显的缺点:

**数据一致性问题**。数据从主节点转到从节点必然会有一个延时的时间窗口，这个时间 窗口会导致主从节点之间的数据不一致。某一时刻，在主节点和从节点中 A 数据的值都为 X， 之后将主节点中 A 的值修改为 Y，那么在这个变更通知到从节点之前，应用读取从节点中的 A 数据的值并不为最新的 Y，由此便产生了数据不一致的问题。

**延时问题**。类似 Redis 这种组件，数据从写入主节点到同步至从节点中的过程需要经 历网络→主节点内存→网络→从节点内存这几个阶段，整个过程会耗费一定的时间。而在 Kafka 中，主从同步会比 Redis 更加耗时，它需要经历网络→主节点内存→主节点磁盘→网络→从节 点内存→从节点磁盘这几个阶段。对延时敏感的应用而言，主写从读的功能并不太适用。


### 4、Kafka的一些最显著的应用。

Netflix，Mozilla，Oracle


### 5、分区Leader选举策略有几种？

分区的Leader副本选举对用户是完全透明的，它是由Controller独立完成的。你需要回答的是，在哪些场景下，需要执行分区Leader选举。每一种场景对应于一种选举策略。

**1、** OfflinePartition Leader选举：每当有分区上线时，就需要执行Leader选举。所谓的分区上线，可能是创建了新分区，也可能是之前的下线分区重新上线。这是最常见的分区Leader选举场景。

**2、** ReassignPartition Leader选举：当你手动运行Kafka-reassign-partitions命令，或者是调用Admin的alterPartitionReassignments方法执行分区副本重分配时，可能触发此类选举。假设原来的AR是[1，2，3]，Leader是1，当执行副本重分配后，副本集合AR被设置成[4，5，6]，显然，Leader必须要变更，此时会发生Reassign Partition Leader选举。

**3、** PreferredReplicaPartition Leader选举：当你手动运行Kafka-preferred-replica-election命令，或自动触发了Preferred Leader选举时，该类策略被激活。所谓的Preferred Leader，指的是AR中的第一个副本。比如AR是[3，2，1]，那么，Preferred Leader就是3。

**4、** ControlledShutdownPartition Leader选举：当Broker正常关闭时，该Broker上的所有Leader副本都会下线，因此，需要为受影响的分区执行相应的Leader选举。

这4类选举策略的大致思想是类似的，即从AR中挑选首个在ISR中的副本，作为新Leader。


### 6、Kafka为什么那么快?

1. Cache Filesystem Cache PageCache缓存
2. 顺序写 由于现代的操作系统提供了预读和写技术，磁盘的顺序写大多数情况下比随机写内存还要快。
3. Zero-copy 零拷技术减少拷贝次数
4. Batching of Messages 批量量处理。合并小的请求，然后以流的方式进行交互，直顶网络上限。
5. Pull 拉模式 使用拉模式进行消息的获取消费，与消费端处理能力相符。


### 7、消费者故障，出现活锁问题如何解决？

出现“活锁”的情况，是它持续的发送心跳，但是没有处理。为了预防消费者在这种情况下一直持有分区，我们使用max.poll.interval.ms活跃检测机制。 在此基础上，如果你调用的poll的频率大于最大间隔，则客户端将主动地离开组，以便其他消费者接管该分区。 发生这种情况时，你会看到offset提交失败（调用commitSync（）引发的CommitFailedException）。这是一种安全机制，保障只有活动成员能够提交offset。所以要留在组中，你必须持续调用poll。

**消费者提供两个配置设置来控制poll循环：**

**1、** max.poll.interval.ms：增大poll的间隔，可以为消费者提供更多的时间去处理返回的消息（调用poll(long)返回的消息，通常返回的消息都是一批）。缺点是此值越大将会延迟组重新平衡。

**2、** max.poll.records：此设置限制每次调用poll返回的消息数，这样可以更容易的预测每次poll间隔要处理的最大值。通过调整此值，可以减少poll间隔，减少重新平衡分组的

**3、** 对于消息处理时间不可预测地的情况，这些选项是不够的。 处理这种情况的推荐方法是将消息处理移到另一个线程中，让消费者继续调用poll。 但是必须注意确保已提交的offset不超过实际位置。另外，你必须禁用自动提交，并只有在线程完成处理后才为记录手动提交偏移量（取决于你）。 还要注意，你需要pause暂停分区，不会从poll接收到新消息，让线程处理完之前返回的消息（如果你的处理能力比拉取消息的慢，那创建新线程将导致你机器内存溢出）。


### 8、简单说一下ack机制

ack：producer收到多少broker的答复才算真的发送成功

0表示producer无需等待leader的确认(吞吐最高、数据可靠性最差)

1代表需要leader确认写入它的本地log并立即确认

-1/all 代表所有的ISR都完成后确认(吞吐最低、数据可靠性最高)


### 9、副本和 ISR 扮演什么角色？

基本上，复制日志的节点列表就是副本。特别是对于特定的分区。但是，无论他们是否扮演leader的角色，他们都是如此。此外，ISR指的是同步副本。在定义ISR时，它是一组与leader同步的消息副本。


### 10、为什么Kafka技术很重要？

Kafka有一些优点，因此使用起来很重要：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_2.png#alt=9%5C_2.png)

高吞吐量：我们在Kafka中不需要任何大型硬件，因为它能够处理高速和大容量数据。此外，它还可以支持每秒数千条消息的消息吞吐量。低延迟：Kafka可以轻松处理这些消息，具有毫秒级的极低延迟，这是大多数新用例所要求的。容错：Kafka能够抵抗集群中的节点/机器故障。耐久性：由于Kafka支持消息复制，因此消息永远不会丢失。这是耐久性背后的原因之一。可扩展性：卡夫卡可以扩展，而不需要通过添加额外的节点而在运行中造成任何停机。


### 11、什么是Apache Kafka?
### 12、解释Apache Kafka用例？
### 13、Apache Kafka的缺陷
### 14、Kafka 与传统消息系统之间有三个关键区别
### 15、传统的消息传递方法有哪些类型？
### 16、如何获取topic主题的列表
### 17、Kafka的主要API有哪些？
### 18、为什么需要消息系统，MySQL不能满足需求吗？
### 19、Kafka 消息是采用 Pull 模式，还是 Push 模式？
### 20、为什么要使用 Kafka？为什么要使用消息队列？
### 21、没有zookeeper可以使用Kafka吗？
### 22、如何保证Kafka顺序消费
### 23、什么是消费者或用户？
### 24、阐述下 Kafka 中的领导者副本（Leader Replica）和追随者副本（Follower Replica）的区别
### 25、Kafka 如何实现延迟队列?
### 26、解释生产者是什么？
### 27、Kafka判断一个节点是否还活着有那两个条件？
### 28、能简单说一下rebalance过程吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
