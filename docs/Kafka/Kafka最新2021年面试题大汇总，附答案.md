# Kafka最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、producer 是否直接将数据发送到 broker 的 leader(主节点)？

producer 直接将数据发送到 broker 的 leader(主节点)，不需要在多个节点进行分发，为了

帮助 producer 做到这点，所有的 Kafka 节点都可以及时的告知:哪些节点是活动的，目标

topic 目标分区的 leader 在哪。这样 producer 就可以直接将消息发送到目的地了


### 2、Kafka的高可用机制是什么？

这个问题比较系统，回答出Kafka的系统特点，leader和follower的关系，消息读写的顺序即可。

[https://www.cnblogs.com/qingyunzong/p/9004703.html](https://www.cnblogs.com/qingyunzong/p/9004703.html)

[https://www.tuicool.com/articles/BNRza2E](https://www.tuicool.com/articles/BNRza2E)

[https://yq.aliyun.com/articles/64703](https://yq.aliyun.com/articles/64703)


### 3、解释术语“主题复制因子”。

在设计Kafka系统时，考虑主题复制是非常重要的。


### 4、连接器API的作用是什么？

一个允许运行和构建可重用的生产者或消费者的API，将Kafka主题连接到现有的应用程序或数据系统，我们称之为连接器API。Apache Kafka对于新手的面试
### 5、什么是Apache Kafka?

Apache Kafka是一个发布 - 订阅开源消息代理应用程序。这个消息传递应用程序是用“scala”编码的。基本上，这个项目是由Apache软件启动的。Kafka的设计模式主要基于事务日志设计。


### 6、消费者负载均衡策略

一个消费者组中的一个分片对应一个消费者成员，他能保证每个消费者成员都能访问，如

果组中成员太多会有空闲的成员


### 7、Kafka的一些最显著的应用。

Netflix，Mozilla，Oracle


### 8、简单说一下ack机制

ack：producer收到多少broker的答复才算真的发送成功

0表示producer无需等待leader的确认(吞吐最高、数据可靠性最差)

1代表需要leader确认写入它的本地log并立即确认

-1/all 代表所有的ISR都完成后确认(吞吐最低、数据可靠性最高)


### 9、Zookeeper对于Kafka的作用是什么？

**1、** Zookeeper是一个开放源码的、高性能的协调服务，它用于Kafka的分布式应用。

**2、** Zookeeper主要用于在集群中不同节点之间进行通信

**3、** 在Kafka中，它被用于提交偏移量，因此如果节点在任何情况下都失败了，它都可以从之前提交的偏移量中获取

**4、** 除此之外，它还执行其他活动，如: leader检测、分布式同步、配置管理、识别新节点何时离开或连接、集群、节点实时状态等等。


### 10、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?

**1、** Kafka分布式的单位是partition，同一个partition用一个write ahead log组织，所以可以保证FIFO的顺序。不同partition之间不能保证顺序。但是绝大多数用户都可以通过message key来定义，因为同一个key的message可以保证只发送到同一个partition。

**2、** Kafka 中发送1条消息的时候，可以指定(topic, partition, key) 3个参数。partiton 和 key 是可选的。如果你指定了 partition，那就是所有消息发往同1个 partition，就是有序的。并且在消费端，Kafka 保证，1个 partition 只能被1个 consumer 消费。或者你指定 key（比如 order id），具有同1个 key 的所有消息，会发往同1个 partition。


### 11、讲讲Kafka维护消费状态跟踪的方法
### 12、你能用Kafka做什么？
### 13、监控Kafka的框架都有哪些？
### 14、Rebalance有什么影响
### 15、：12,15,20
### 16、Kafka中的 ISR、AR 又代表什么？ISR 的伸缩又指什么？
### 17、消费者API的作用是什么？
### 18、生产者和消费者的命令行是什么？
### 19、consumer是推还是拉？
### 20、Kafka Follower如何与Leader同步数据?
### 21、Kafka Producer 写数据，ACK 为 0，1，-1 时分别代表什么？
### 22、Java在Apache Kafka中的重要性是什么？
### 23、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 24、Kafka Unclean 配置代表什么？会对 spark streaming 消费有什么影响？
### 25、Apache Kafka的缺陷
### 26、如何估算Kafka集群的机器数量？
### 27、如果副本长时间不在ISR中，这意味着什么？
### 28、解释术语“Log Anatomy”




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
