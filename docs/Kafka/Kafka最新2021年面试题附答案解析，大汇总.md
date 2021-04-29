# Kafka最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka的流处理是什么意思？

连续、实时、并发和以逐记录方式处理数据的类型，我们称之为Kafka流处理。


### 2、Kafka和Flume之间的主要区别是什么？

Kafka和Flume之间的主要区别是：工具类型 Apache Kafka——Kafka是面向多个生产商和消费者的通用工具。 Apache Flume——Flume被认为是特定应用程序的专用工具。复制功能Apache Kafka——Kafka可以复制事件。Apache Flume——Flume不复制事件。


### 3、Kafka Follower如何与Leader同步数据?

Kafka 的复制机制既不是完全的同步复制，也不是单纯的异步复制。完全同步复制要求 All Alive Follower 都复制完，这条消息才会被认为 commit，这种复制方式极大的影响了吞吐率。而异步复制方式下，Follower 异步的从 Leader 复制数据，数据只要被 Leader 写入 log 就被认为已经 commit，这种情况下，如果 leader 挂掉，会丢失数据，Kafka 使用 ISR 的方式很好的均衡了确保数据不丢失以及吞吐率。Follower 可以批量的从 Leader 复制数据，而且 Leader 充分利用磁盘顺序读以及 send file(zero copy) 机制，这样极大的提高复制性能，内部批量写磁盘，大幅减少了 Follower 与 Leader 的消息量差。


### 4、解释术语“Log Anatomy”

我们将日志视为分区。基本上，数据源将消息写入日志。其优点之一是，在任何时候，都有一个或多个消费者从他们选择的日志中读取数据。下面的图表显示，数据源正在写入一个日志，而用户正在以不同的偏移量读取该日志。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_3.png#alt=9%5C_3.png)


### 5、解释一些Kafka流实时用例。

《纽约时报》：该公司使用它来实时存储和分发已发布的内容到各种应用程序和系统，使其可供读者使用。基本上，它使用Apache Kafka和Kafka流。Zalando：作为ESB（企业服务总线）作为欧洲领先的在线时尚零售商，Zalando使用Kafka。LINE：基本上，为了相互通信，LINE应用程序使用Apache Kafka作为其服务的中心数据中心。


### 6、Java在Apache Kafka中的重要性是什么？

为了满足Kafka标准的高处理速率需求，我们可以使用java语言。此外，对于Kafka的消费者客户，Java也提供了良好的社区支持。所以，我们可以说在Java中实现Kafka是一个正确的选择。


### 7、Apache Kafka的缺陷

Kafka的局限性是：1.没有完整的监控工具集2.消息调整的
### 8、Kafka集群中保留期的目的是什么？

保留期限保留了Kafka群集中的所有已记录。它不会检查它们是否已被消耗。此外，可以通过使用保留期的配置设置来丢弃记录。而且，它可以释放一些空间。


### 9、Kafka为何这么快

Kafka 实现了零拷贝原理来快速移动数据，避免了内核之间的切换。Kafka 可以将数据记录分批发送，从生产者到文件系统（Kafka 主题日志）到消费者，可以端到端的查看这些批次的数据。

批处理能够进行更有效的数据压缩并减少 I/O 延迟，Kafka 采取顺序写入磁盘的方式，避免了随机磁盘寻址的浪费，更多关于磁盘寻址的了解，请参阅 程序员需要了解的硬核知识之磁盘 。总结一下其实就是四个要点

顺序读写

零拷贝

消息压缩

分批发送


### 10、什么是消费者组？

**1、** 消费者组是Kafka独有的概念，如果面试官问这个，就说明他对此是有一定了解的。

**2、** 胡大给的标准答案是：官网上的介绍言简意赅，即消费者组是Kafka提供的可扩展且具有容错性的消费者机制。

**3、** 但实际上，消费者组（Consumer Group）其实包含两个概念，作为队列，消费者组允许你分割数据处理到一组进程集合上（即一个消费者组中可以包含多个消费者进程，他们共同消费该topic的数据），这有助于你的消费能力的动态调整；作为-订阅模型（publish-subscribe），Kafka允许你将同一份消息广播到多个消费者组里，以此来丰富多种数据使用场景。

**4、** 需要注意的是：在消费者组中，多个实例共同订阅若干个主题，实现共同消费。同一个组下的每个实例都配置有相同的组ID，被分配不同的订阅分区。当某个实例挂掉的时候，其他实例会自动地承担起它负责消费的分区。因此，消费者组在一定程度上也保证了消费者程序的高可用性。

注意：消费者组的题目，能够帮你在某种程度上掌控下面的面试方向。

**1、** 如果你擅长位移值原理（Offset），就不妨再提一下消费者组的位移提交机制；

**2、** 如果你擅长Kafka Broker，可以提一下消费者组与Broker之间的交互；

**3、** 如果你擅长与消费者组完全不相关的Producer，那么就可以这么说：“消费者组要消费的数据完全来自于Producer端生产的消息，我对Producer还是比较熟悉的。”

总之，你总得对consumer group相关的方向有一定理解，然后才能像面试官表名你对某一块很理解。


### 11、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 12、在生产者中，何时发生QueueFullException？
### 13、副本和ISR扮演什么角色？
### 14、Apache Kafka是什么？
### 15、ZooKeeper在Kafka中的作用是什么？
### 16、什么是复制工具及其类型？
### 17、数据传输的事物定义有哪三种？
### 18、Kafka 中是怎么体现消息顺序性的？
### 19、Kafka一次reblance大概要多久
### 20、Kafka 的 ack 机制
### 21、怎么解决rebalance中遇到的问题呢？
### 22、Leader和Follower的概念是什么？
### 23、讲一讲Kafka的ack的三种机制
### 24、Kafka 创建 Topic 时如何将分区放置到不同的 Broker 中
### 25、如何估算Kafka集群的机器数量？
### 26、如果副本长时间不在ISR中，这意味着什么？
### 27、：12,15,20
### 28、consumer_offsets是做什么用的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
