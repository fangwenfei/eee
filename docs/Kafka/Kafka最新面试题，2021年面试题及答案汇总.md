# Kafka最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka 高效文件存储设计特点：

**1、** Kafka 把 topic 中一个 parition 大文件分成多个小文件段，通过多个小文件段，就容易定

**2、** 期清除或删除已经消费完文件，减少磁盘占用。

**3、** 通过索引信息可以快速定位 message 和确定 response 的最大大小。

**4、** 通过 index 元数据全部映射到 memory，可以避免 segment file 的 IO 磁盘操作。

**5、** 通过索引文件稀疏存储，可以大幅降低 index 文件元数据占用空间大小。


### 2、如果 Leader Crash 时，ISR为空怎么办

Kafka在Broker端提供了一个配置参数：unclean.leader.election,这个参数有两个值：

**true**（默认）：允许不同步副本成为leader，由于不同步副本的消息较为滞后，此时成为leader，可能会出现消息不一致的情况。

**false**：不允许不同步副本成为leader，此时如果发生ISR列表为空，会一直等待旧leader恢复，降低了可用性。


### 3、启动Kafka服务器的过程是什么？

初始化ZooKeeper服务器是非常重要的一步，因为Kafka使用ZooKeeper，所以启动Kafka服务器的过程是：要启动ZooKeeper服务器：>bin/zooKeeper-server-start.sh config/zooKeeper.properties接下来，启动Kafka服务器：>bin/Kafka-server-start.sh config/server.properties


### 4、解释流API的作用？

一种允许应用程序充当流处理器的API，它还使用一个或多个主题的输入流，并生成一个输出流到一个或多个输出主题，此外，有效地将输入流转换为输出流，我们称之为流API。


### 5、Kafka的哪些场景中使用了零拷贝（Zero Copy）？

**1、** 其实这道题对于SRE来讲，有点超纲了，不过既然Zero Copy是Kafka高性能的保证，我们需要了解它。

**2、** Zero Copy是特别容易被问到的高阶题目。在Kafka中，体现Zero Copy使用场景的地方有两处：基于mmap的索引和日志文件读写所用的TransportLayer。

**3、** 先说第一个。索引都是基于MappedByteBuffer的，也就是让用户态和内核态共享内核态的数据缓冲区，此时，数据不需要复制到用户态空间。不过，mmap虽然避免了不必要的拷贝，但不一定就能保证很高的性能。在不同的操作系统下，mmap的创建和销毁成本可能是不一样的。很高的创建和销毁开销会抵消Zero Copy带来的性能优势。由于这种不确定性，在Kafka中，只有索引应用了mmap，最核心的日志并未使用mmap机制。

**4、** 再说第二个。TransportLayer是Kafka传输层的接口。它的某个实现类使用了FileChannel的transferTo方法。该方法底层使用sendfile实现了Zero Copy。对Kafka而言，如果I/O通道使用普通的PLAINTEXT，那么，Kafka就可以利用Zero Copy特性，直接将页缓存中的数据发送到网卡的Buffer中，避免中间的多次拷贝。相反，如果I/O通道启用了SSL，那么，Kafka便无法利用Zero Copy特性了。


### 6、Kafka为什么不支持读写分离？

**1、** 这其实是分布式场景下的通用问题，因为我们知道CAP理论下，我们只能保证C（一致性）和A（可用性）取其一，如果支持读写分离，那其实对于一致性的要求可能就会有一定折扣，因为通常的场景下，副本之间都是通过同步来实现副本数据一致的，那同步过程中肯定会有时间的消耗，如果支持了读写分离，就意味着可能的数据不一致，或数据滞后。

**2、** Leader/Follower模型并没有规定Follower副本不可以对外提供读服务。很多框架都是允许这么做的，只是 Kafka最初为了避免不一致性的问题，而采用了让Leader统一提供服务的方式。

**3、** 不过，自Kafka 2.4之后，Kafka提供了有限度的读写分离，也就是说，Follower副本能够对外提供读服务。


### 7、消费者故障，出现活锁问题如何解决？

出现“活锁”的情况，是它持续的发送心跳，但是没有处理。为了预防消费者在这种情况下一直持有分区，我们使用max.poll.interval.ms活跃检测机制。 在此基础上，如果你调用的poll的频率大于最大间隔，则客户端将主动地离开组，以便其他消费者接管该分区。 发生这种情况时，你会看到offset提交失败（调用commitSync（）引发的CommitFailedException）。这是一种安全机制，保障只有活动成员能够提交offset。所以要留在组中，你必须持续调用poll。

**消费者提供两个配置设置来控制poll循环：**

**1、** max.poll.interval.ms：增大poll的间隔，可以为消费者提供更多的时间去处理返回的消息（调用poll(long)返回的消息，通常返回的消息都是一批）。缺点是此值越大将会延迟组重新平衡。

**2、** max.poll.records：此设置限制每次调用poll返回的消息数，这样可以更容易的预测每次poll间隔要处理的最大值。通过调整此值，可以减少poll间隔，减少重新平衡分组的

**3、** 对于消息处理时间不可预测地的情况，这些选项是不够的。 处理这种情况的推荐方法是将消息处理移到另一个线程中，让消费者继续调用poll。 但是必须注意确保已提交的offset不超过实际位置。另外，你必须禁用自动提交，并只有在线程完成处理后才为记录手动提交偏移量（取决于你）。 还要注意，你需要pause暂停分区，不会从poll接收到新消息，让线程处理完之前返回的消息（如果你的处理能力比拉取消息的慢，那创建新线程将导致你机器内存溢出）。


### 8、解释多租户是什么？
### 9、什么是消费者或用户？
### 10、为什么需要消息系统，MySQL不能满足需求吗？
### 11、为什么Kafka技术很重要？
### 12、是什么确保了Kafka中服务器的负载平衡？
### 13、如何保证Kafka顺序消费
### 14、监控Kafka的框架都有哪些？
### 15、Kafka的一些最显著的应用。
### 16、kafaka 生产数据时数据的分组策略
### 17、消费者负载均衡策略
### 18、Kafka 与传统消息系统之间有三个关键区别
### 19、为什么Kafka的复制至关重要？
### 20、consumer_offsets是做什么用的？
### 21、什么是消费者组？
### 22、：35, 36, 37
### 23、：31, 32, 33, 34, 38, 39, 40Apache Kafka对于有经验的人的面试
### 24、连接器API的作用是什么？
### 25、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?
### 26、解释Kafka可以接收的消息最大为多少？
### 27、Kafka如何不消费重复数据？比如扣款，我们不能重复的扣。
### 28、传统的消息传递方法有哪些类型？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
