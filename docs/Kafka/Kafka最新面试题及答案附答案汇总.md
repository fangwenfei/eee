# Kafka最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka中的 zookeeper 起到什么作用？可以不用zookeeper吗？

zookeeper 是一个分布式的协调组件，早期版本的Kafka用zk做meta信息存储，consumer的消费状态，group 的管理以及 offset 的值。考虑到 zookeeper 本身的一些因素以及整个架构较大概率存在单点问题，新版本中逐渐弱化了 zookeeper 的作用。新的 consumer 使用了 Kafka 内部的 group coordination 协议，也减少了对 zookeeper 的依赖，

但是 broker 依然依赖于 zookeeper，zookeeper 在Kafka中还用来选举 controller 和检测 broker 是否存活等等。


### 2、Kafka 创建 Topic 时如何将分区放置到不同的 Broker 中

副本因子不能大于 Broker 的个数；

**1、** 第一个分区（编号为 0）的第一个副本放置位置是随机从 brokerList 选择的；

**2、** 其他分区的第一个副本放置位置相对于第 0 个分区依次往后移。也就是如果我们有 5 个

**3、** Broker，5 个分区，假设第一个分区放在第四个 Broker 上，那么第二个分区将会放在第五

**4、** 个 Broker 上；第三个分区将会放在第一个 Broker 上；第四个分区将会放在第二个

**5、** Broker 上，依次类推；

**6、** 剩余的副本相对于第一个副本放置位置其实是由 nextReplicaShift 决定的，而这个数也是

**7、** 随机产生的


### 3、消费者提交消费位移时提交的是当前消费到的最新消息的offset还是offset+1?

offset+1


### 4、Kafka的优点有那些？

1. 高吞吐量：我们在Kafka中不需要任何大型硬件，因为它能够处理高速和大容量数据。此外，它还可以支持每秒数千条消息的消息吞吐量。
2. 低延迟：Kafka可以轻松处理这些消息，具有毫秒级的极低延迟，这是大多数新用例所要求的。
3. 容错：Kafka能够抵抗集群中的节点/机器故障。
4. 耐久性：由于Kafka支持消息复制，因此消息永远不会丢失。这是耐久性背后的原因之一。
5. 可扩展性：Kafka可以扩展，而不需要通过添加额外的节点而在运行中造成任何停机。


### 5、Java在Apache Kafka中的重要性是什么？

为了满足Kafka标准的高处理速率需求，我们可以使用java语言。此外，对于Kafka的消费者客户，Java也提供了良好的社区支持。所以，我们可以说在Java中实现Kafka是一个正确的选择。


### 6、消费者API的作用是什么？

允许应用程序订阅一个或多个主题并处理生成给它们的记录流的API，我们称之为消费者API。


### 7、如何获取topic主题的列表

bin/Kafka-topics.sh --list --zookeeper localhost:2181


### 8、在Kafka中，ZooKeeper的作用是什么？
### 9、在Kafka集群中保留期的目的是什么？
### 10、比较RabbitMQ与Apache Kafka
### 11、Kafka 中是怎么体现消息顺序性的？
### 12、什么是消费者或用户？
### 13、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 14、Kafka中有哪几个组件?
### 15、讲讲Kafka维护消费状态跟踪的方法
### 16、分区Leader选举策略有几种？
### 17、没有ZooKeeper可以使用Kafka吗？
### 18、副本长时间不在ISR中，这意味着什么？
### 19、Kafka一次reblance大概要多久
### 20、如何设置Kafka能接收的最大消息的大小？
### 21、Kafka中有哪几个组件?
### 22、比较传统队列系统与Apache Kafka
### 23、解释Apache Kafka用例？
### 24、consumer是推还是拉？
### 25、Kafka中的 ISR、AR 又代表什么？ISR 的伸缩又指什么？
### 26、生产者中，什么情况下会发生 QueueFullException？
### 27、LEO、LSO、AR、ISR、HW都表示什么含义？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
