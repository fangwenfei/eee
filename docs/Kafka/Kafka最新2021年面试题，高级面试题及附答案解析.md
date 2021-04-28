# Kafka最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、连接器API的作用是什么？

一个允许运行和构建可重用的生产者或消费者的API，将Kafka主题连接到现有的应用程序或数据系统，我们称之为连接器API。Apache Kafka对于新手的面试
### 2、消费者故障，出现活锁问题如何解决？

出现“活锁”的情况，是它持续的发送心跳，但是没有处理。为了预防消费者在这种情况下一直持有分区，我们使用max.poll.interval.ms活跃检测机制。 在此基础上，如果你调用的poll的频率大于最大间隔，则客户端将主动地离开组，以便其他消费者接管该分区。 发生这种情况时，你会看到offset提交失败（调用commitSync（）引发的CommitFailedException）。这是一种安全机制，保障只有活动成员能够提交offset。所以要留在组中，你必须持续调用poll。

**消费者提供两个配置设置来控制poll循环：**

**1、** max.poll.interval.ms：增大poll的间隔，可以为消费者提供更多的时间去处理返回的消息（调用poll(long)返回的消息，通常返回的消息都是一批）。缺点是此值越大将会延迟组重新平衡。

**2、** max.poll.records：此设置限制每次调用poll返回的消息数，这样可以更容易的预测每次poll间隔要处理的最大值。通过调整此值，可以减少poll间隔，减少重新平衡分组的

**3、** 对于消息处理时间不可预测地的情况，这些选项是不够的。 处理这种情况的推荐方法是将消息处理移到另一个线程中，让消费者继续调用poll。 但是必须注意确保已提交的offset不超过实际位置。另外，你必须禁用自动提交，并只有在线程完成处理后才为记录手动提交偏移量（取决于你）。 还要注意，你需要pause暂停分区，不会从poll接收到新消息，让线程处理完之前返回的消息（如果你的处理能力比拉取消息的慢，那创建新线程将导致你机器内存溢出）。


### 3、消费者负载均衡策略

一个消费者组中的一个分片对应一个消费者成员，他能保证每个消费者成员都能访问，如

果组中成员太多会有空闲的成员


### 4、为什么Kafka技术很重要？

Kafka有一些优点，因此使用起来很重要：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_2.png#alt=9%5C_2.png)

高吞吐量：我们在Kafka中不需要任何大型硬件，因为它能够处理高速和大容量数据。此外，它还可以支持每秒数千条消息的消息吞吐量。低延迟：Kafka可以轻松处理这些消息，具有毫秒级的极低延迟，这是大多数新用例所要求的。容错：Kafka能够抵抗集群中的节点/机器故障。耐久性：由于Kafka支持消息复制，因此消息永远不会丢失。这是耐久性背后的原因之一。可扩展性：卡夫卡可以扩展，而不需要通过添加额外的节点而在运行中造成任何停机。


### 5、Kafka中有哪几个组件?

Kafka最重要的元素是：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_1.png#alt=9%5C_1.png)

主题：Kafka主题是一堆或一组消息。生产者：在Kafka，生产者发布通信以及向Kafka主题发布消息。消费者：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。经纪人：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 6、Kafka 如何判断节点是否存活

节点必须可以维护和 ZooKeeper 的连接，ZooKeeper 通过心跳机制检查每个节点的连 接

如果节点是个 follower,他必须能及时的同步 leader 的写操作，延时不能太久

问题5：Kafka 消息是采用 Pull 模式，还是 Push 模式

Kafka 最初考虑的问题是，customer 应该从 brokes 拉取消息还是 brokers 将消息推送到 consumer，也就是 pull 还 push。

在这方面，Kafka 遵循了一种大部分消息系统共同的传统 的设计：producer 将消息推送到 broker，consumer 从 broker 拉取消息 一些消息系统比如 Scribe 和 Apache Flume 采用了 push 模式，将消息推送到下游的 consumer。

这样做有好处也有坏处：由 broker 决定消息推送的速率，对于不同消费速率的 consumer 就不太好处理了。

消息系统都致力于让 consumer 以最大的速率最快速的消费消 息，但不幸的是，push 模式下，当 broker 推送的速率远大于 consumer 消费的速率时， consumer 恐怕就要崩溃了。

最终 Kafka 还是选取了传统的 pull 模式 Pull 模式的另外一个好处是 consumer 可以自主决定是否批量的从 broker 拉取数据。Push 模式必须在不知道下游 consumer 消费能力和消费策略的情况下决定是立即推送每条消息还 是缓存之后批量推送。

如果为了避免 consumer 崩溃而采用较低的推送速率，将可能导致一 次只推送较少的消息而造成浪费。

Pull 模式下，consumer 就可以根据自己的消费能力去决 定这些策略 Pull 有个缺点是，如果 broker 没有可供消费的消息，将导致 consumer 不断在循环中轮询， 直到新消息到 t 达。为了避免这点，Kafka 有个参数可以让 consumer 阻塞知道新消息到达 (当然也可以阻塞知道消息的数量达到某个特定的量这样就可以批量发）


### 7、Kafka为何这么快

Kafka 实现了零拷贝原理来快速移动数据，避免了内核之间的切换。Kafka 可以将数据记录分批发送，从生产者到文件系统（Kafka 主题日志）到消费者，可以端到端的查看这些批次的数据。

批处理能够进行更有效的数据压缩并减少 I/O 延迟，Kafka 采取顺序写入磁盘的方式，避免了随机磁盘寻址的浪费，更多关于磁盘寻址的了解，请参阅 程序员需要了解的硬核知识之磁盘 。总结一下其实就是四个要点

顺序读写

零拷贝

消息压缩

分批发送


### 8、偏移的作用是什么？

给分区中的消息提供了一个顺序ID号，我们称之为偏移量。因此，为了唯一地识别分区中的每条消息，我们使用这些偏移量。


### 9、Controller发生网络分区（Network Partitioning）时，Kafka会怎么样？

**1、** 这道题目能够诱发我们对分布式系统设计、CAP理论、一致性等多方面的思考。

**2、** 一旦发生Controller网络分区，那么，第一要务就是查看集群是否出现“脑裂”，即同时出现两个甚至是多个Controller组件。这可以根据Broker端监控指标ActiveControllerCount来判断。

**3、** 不过，通常而言，我们在设计整个部署架构时，为了避免这种网络分区的发生，一般会将broker节点尽可能的防止在一个机房或者可用区。

**4、** 由于Controller会给Broker发送3类请求，LeaderAndIsrRequest，StopReplicaRequest，UpdateMetadataRequest，因此，一旦出现网络分区，这些请求将不能顺利到达Broker端。

**5、** 这将影响主题的创建、修改、删除操作的信息同步，表现为集群仿佛僵住了一样，无法感知到后面的所有操作。因此，网络分区通常都是非常严重的问题，要赶快修复。


### 10、解释Apache Kafka用例？

Apache Kafka有很多用例，例如：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_4.png#alt=9%5C_4.png)

Kafka指标可以使用Kafka进行操作监测数据。此外，为了生成操作数据的集中提要，它涉及到从分布式应用程序聚合统计信息。Kafka日志聚合 从组织中的多个服务收集日志。流处理在流处理过程中，Kafka的强耐久性非常有用。Apache Kafka对于新手的面试
### 11、：31, 32, 33, 34, 38, 39, 40Apache Kafka对于有经验的人的面试
### 12、Kafka 新建的分区会在哪个目录下创建
### 13、为什么需要消息系统，MySQL不能满足需求吗？
### 14、解释术语“Log Anatomy”
### 15、什么是复制工具及其类型？
### 16、阐述下 Kafka 中的领导者副本（Leader Replica）和追随者副本（Follower Replica）的区别
### 17、Kafka的主要API有哪些？
### 18、Kafka和Flume之间的主要区别是什么？
### 19、Kafka流的特点。
### 20、能简单说一下rebalance过程吗？
### 21、数据传输的事物定义有哪三种？
### 22、如果 Leader Crash 时，ISR为空怎么办
### 23、Kafka为什么不支持读写分离？
### 24、如何控制消费的位置
### 25、ZooKeeper在Kafka中的作用是什么？
### 26、consumer是推还是拉？
### 27、如何设置Kafka能接收的最大消息的大小？
### 28、Kafka 消息是采用 Pull 模式，还是 Push 模式？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
