# Kafka最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、启动Kafka服务器的过程是什么？

初始化ZooKeeper服务器是非常重要的一步，因为Kafka使用ZooKeeper，所以启动Kafka服务器的过程是：要启动ZooKeeper服务器：>bin/zooKeeper-server-start.sh config/zooKeeper.properties接下来，启动Kafka服务器：>bin/Kafka-server-start.sh config/server.properties


### 2、Kafka的流处理是什么意思？

连续、实时、并发和以逐记录方式处理数据的类型，我们称之为Kafka流处理。


### 3、Java在Apache Kafka中的重要性是什么？

为了满足Kafka标准的高处理速率需求，我们可以使用java语言。此外，对于Kafka的消费者客户，Java也提供了良好的社区支持。所以，我们可以说在Java中实现Kafka是一个正确的选择。


### 4、数据传输的事务定义有哪三种？

**和MQTT的事务定义一样都是3种**

**1、** 最多一次: 消息不会被重复发送，最多被传输一次，但也有可能一次不传输

**2、** 最少一次: 消息不会被漏发送，最少被传输一次，但也有可能被重复传输.

**3、** 精确的一次（Exactly once）: 不会漏传输也不会重复传输,每个消息都传输被一次而且仅仅被传输一次，这是大家所期望的


### 5、Kafka为何这么快

Kafka 实现了零拷贝原理来快速移动数据，避免了内核之间的切换。Kafka 可以将数据记录分批发送，从生产者到文件系统（Kafka 主题日志）到消费者，可以端到端的查看这些批次的数据。

批处理能够进行更有效的数据压缩并减少 I/O 延迟，Kafka 采取顺序写入磁盘的方式，避免了随机磁盘寻址的浪费，更多关于磁盘寻址的了解，请参阅 程序员需要了解的硬核知识之磁盘 。总结一下其实就是四个要点

顺序读写

零拷贝

消息压缩

分批发送


### 6、Java Consumer为什么采用单线程来获取消息？

**1、** 在回答之前，如果先把这句话说出来，一定会加分：Java Consumer是双线程的设计。一个线程是用户主线程，负责获取消息；另一个线程是心跳线程，负责向Kafka汇报消费者存活情况。将心跳单独放入专属的线程，能够有效地规避因消息处理速度慢而被视为下线的“假死”情况。

**2、** 单线程获取消息的设计能够避免阻塞式的消息获取方式。单线程轮询方式容易实现异步非阻塞式，这样便于将消费者扩展成支持实时流处理的操作算子。因为很多实时流处理操作算子都不能是阻塞式的。另外一个可能的好处是，可以简化代码的开发。多线程交互的代码是非常容易出错的。


### 7、消费者提交消费位移时提交的是当前消费到的最新消息的offset还是offset+1?

offset+1


### 8、你能用Kafka做什么？

它可以以多种方式执行，例如：>>为了在两个系统之间传输数据，我们可以用它构建实时的数据流管道。>>另外，我们可以用Kafka构建一个实时流处理平台，它可以对数据快速做出反应。


### 9、副本和 ISR 扮演什么角色？

基本上，复制日志的节点列表就是副本。特别是对于特定的分区。但是，无论他们是否扮演leader的角色，他们都是如此。此外，ISR指的是同步副本。在定义ISR时，它是一组与leader同步的消息副本。


### 10、：24, 22


### 11、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 12、系统工具有哪些类型？
### 13、解释多租户是什么？
### 14、解释生产者是什么？
### 15、如何获取topic主题的列表
### 16、Kafka 存储在硬盘上的消息格式是什么？
### 17、Broker的Heap Size如何设置？
### 18、producer 是否直接将数据发送到 broker 的 leader(主节点)？
### 19、Kafka和Flume之间的主要区别是什么？
### 20、什么是Kafka中的地域复制？
### 21、数据有序
### 22、Kafka的message格式是什么？
### 23、解释Apache Kafka用例？
### 24、副本和ISR扮演什么角色？
### 25、Apache Kafka是什么？
### 26、Kafka 的 ack 机制
### 27、Kafka中的 zookeeper 起到什么作用？可以不用zookeeper吗？
### 28、Kafka什么情况下会rebalance




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
