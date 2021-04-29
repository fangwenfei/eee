# Kafka最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka的message格式是什么？

一个Kafka的Message由一个**固定长度的header**和一个**变长的消息体body**组成

1. header部分 由一个字节的magic(文件格式)和四个字节的CRC32(用于判断body消息体是否正常)构成。
2. 当magic的值为1的时候，会在magic和crc32之间多一个字节的数据：attributes(保存一些相关属性，比如是否压缩、压缩格式等等);
3. 如果magic的值为0，那么不存在attributes属性
4. body部分 由N个字节构成的一个消息体，包含了具体的key/value消息


### 2、什么是多租户？

我们可以轻松地将Kafka部署为多租户解决方案。但是，通过配置主题可以生成或使用数据，可以启用多租户。此外，它还为配额提供操作支持。


### 3、偏移的作用是什么？

给分区中的消息提供了一个顺序ID号，我们称之为偏移量。因此，为了唯一地识别分区中的每条消息，我们使用这些偏移量。


### 4、Kafka什么情况下会rebalance

rebalance 的触发条件有五个。

条件1：有新的consumer加入

条件2：旧的consumer挂了

条件3：coordinator挂了，集群选举出新的coordinator

条件4：topic的partition新加

条件5：consumer调用unsubscrible()，取消topic的订阅

rebalance 发生时，Group 下所有 consumer 实例都会协调在一起共同参与，Kafka 能够保证尽量达到最公平的分配。但是 Rebalance 过程对 consumer group 会造成比较严重的影响。在 Rebalance 的过程中 consumer group 下的所有消费者实例都会停止工作，等待 Rebalance 过程完成。


### 5、如何获取topic主题的列表

bin/Kafka-topics.sh --list --zookeeper localhost:2181


### 6、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?

**1、** Kafka分布式的单位是partition，同一个partition用一个write ahead log组织，所以可以保证FIFO的顺序。不同partition之间不能保证顺序。但是绝大多数用户都可以通过message key来定义，因为同一个key的message可以保证只发送到同一个partition。

**2、** Kafka 中发送1条消息的时候，可以指定(topic, partition, key) 3个参数。partiton 和 key 是可选的。如果你指定了 partition，那就是所有消息发往同1个 partition，就是有序的。并且在消费端，Kafka 保证，1个 partition 只能被1个 consumer 消费。或者你指定 key（比如 order id），具有同1个 key 的所有消息，会发往同1个 partition。


### 7、为什么需要消息系统，MySQL不能满足需求吗？

**1、** 解耦：

允许你独立的扩展或修改两边的处理过程，只要确保它们遵守同样的接口约束。

**2、** 冗余：

消息队列把数据进行持久化直到它们已经被完全处理，通过这一方式规避了数据丢失风险。许多消息队列所采用的”插入-获取-删除”范式中，在把一个消息从队列中删除之前，需要你的处理系统明确的指出该消息已经被处理完毕，从而确保你的数据被安全的保存直到你使用完毕。

**3、** 扩展性：

因为消息队列解耦了你的处理过程，所以增大消息入队和处理的频率是很容易的，只要另外增加处理过程即可。

**4、** 灵活性 & 峰值处理能力：

在访问量剧增的情况下，应用仍然需要继续发挥作用，但是这样的突发流量并不常见。如果为以能处理这类峰值访问为标准来投入资源随时待命无疑是巨大的浪费。使用消息队列能够使关键组件顶住突发的访问压力，而不会因为突发的超负荷的请求而完全崩溃。

**5、** 可恢复性：

系统的一部分组件失效时，不会影响到整个系统。消息队列降低了进程间的耦合度，所以即使一个处理消息的进程挂掉，加入队列中的消息仍然可以在系统恢复后被处理。

**6、** 顺序保证：

在大多使用场景下，数据处理的顺序都很重要。大部分消息队列本来就是排序的，并且能保证数据会按照特定的顺序来处理。（Kafka 保证一个 Partition 内的消息的有序性）

**7、** 缓冲：

有助于控制和优化数据流经过系统的速度，解决生产消息和消费消息的处理速度不一致的情况。

**8、** 异步通信：

很多时候，用户不想也不需要立即处理消息。消息队列提供了异步处理机制，允许用户把一个消息放入队列，但并不立即处理它。想向队列中放入多少消息就放多少，然后在需要的时候再去处理它们。


### 8、消费者API的作用是什么？

允许应用程序订阅一个或多个主题并处理生成给它们的记录流的API，我们称之为消费者API。


### 9、在Kafka集群中保留期的目的是什么？

保留期限保留了Kafka群集中的所有已发布记录。它不会检查它们是否已被消耗。此外，可以通过使用保留期的配置设置来丢弃记录。而且，它可以释放一些空间。


### 10、producer 是否直接将数据发送到 broker 的 leader(主节点)？

producer 直接将数据发送到 broker 的 leader(主节点)，不需要在多个节点进行分发，为了

帮助 producer 做到这点，所有的 Kafka 节点都可以及时的告知:哪些节点是活动的，目标

topic 目标分区的 leader 在哪。这样 producer 就可以直接将消息发送到目的地了


### 11、为什么Kafka技术很重要？
### 12、什么是消费者或用户？
### 13、连接器API的作用是什么？
### 14、为什么Kafka不支持读写分离？
### 15、消费者负载均衡策略
### 16、Kafka Unclean 配置代表什么？会对 spark streaming 消费有什么影响？
### 17、解释生产者是什么？
### 18、Kafka 与传统消息系统之间有三个关键区别
### 19、：31, 32, 33, 34, 38, 39, 40Apache Kafka对于有经验的人的面试
### 20、启动Kafka服务器的过程是什么？
### 21、ISR在Kafka环境中代表什么？
### 22、连接器API的作用是什么？
### 23、比较RabbitMQ与Apache Kafka
### 24、解释领导者和追随者的概念。
### 25、Kafka 判断一个节点是否还活着有那两个条件？
### 26、传统的消息传递方法有哪些类型？
### 27、什么是消费者组？
### 28、什么是生产者？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
