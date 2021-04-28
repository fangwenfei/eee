# Kafka最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Rebalance有什么影响

Rebalance本身是Kafka集群的一个保护设定，用于剔除掉无法消费或者过慢的消费者，然后由于我们的数据量较大，同时后续消费后的数据写入需要走网络IO，很有可能存在依赖的第三方服务存在慢的情况而导致我们超时。Rebalance对我们数据的影响主要有以下几点：

数据重复消费: 消费过的数据由于提交offset任务也会失败，在partition被分配给其他消费者的时候，会造成重复消费，数据重复且增加集群压力

Rebalance扩散到整个ConsumerGroup的所有消费者，因为一个消费者的退出，导致整个Group进行了Rebalance，并在一个比较慢的时间内达到稳定状态，影响面较大

频繁的Rebalance反而降低了消息的消费速度，大部分时间都在重复消费和Rebalance

数据不能及时消费，会累积lag，在Kafka的TTL之后会丢弃数据 上面的影响对于我们系统来说，都是致命的。


### 2、为什么要使用Apache Kafka集群？

为了克服收集大量数据和分析收集数据的挑战，我们需要一个消息队列系统。因此Apache Kafka应运而生。其好处是：只需存储/发送事件以进行实时处理，就可以跟踪Web活动。通过这一点，我们可以发出警报并报告操作指标。此外，我们可以将数据转换为标准格式。此外，它允许对主题的流数据进行连续处理。由于它的广泛使用，它秒杀了竞品，如ActiveMQ，RabbitMQ等。


### 3、为什么需要消息系统，MySQL不能满足需求吗？

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


### 4、消费者如何不自动提交偏移量，由应用提交？

将auto.commit.offset设为false，然后在处理一批消息后commitSync() 或者异步提交commitAsync()

即：

```
ConsumerRecords<> records = consumer.poll();
for (ConsumerRecord<> record : records){
。。。
tyr{
consumer.commitSync()
}
。。。
}
```


### 5、：1,2,4,7,8,9,10Apache Kafka对于有经验的人的面试
### 6、什么是Kafka？

Kafka是**分布式-订阅消息系统**，它最初是由LinkedIn公司开发的，之后成为Apache项目的一部分，Kafka是一个分布式，可划分的，冗余备份的持久性的日志服务，它主要用于处理流式数据。


### 7、简述Follower副本消息同步的完整流程

**1、** 首先，Follower发送FETCH请求给Leader。

**2、** 接着，Leader会读取底层日志文件中的消息数据，再更新它内存中的Follower副本的LEO值，更新为FETCH请求中的fetchOffset值。

**3、** 最后，尝试更新分区高水位值。Follower接收到FETCH响应之后，会把消息写入到底层日志，接着更新LEO和HW值。

**4、** Leader和Follower的HW值更新时机是不同的，Follower的HW更新永远落后于Leader的HW。这种时间上的错配是造成各种不一致的原因。

**5、** 因此，对于消费者而言，消费到的消息永远是所有副本中最小的那个HW。


### 8、解释一些Kafka流实时用例。

《纽约时报》：该公司使用它来实时存储和分发已发布的内容到各种应用程序和系统，使其可供读者使用。基本上，它使用Apache Kafka和Kafka流。Zalando：作为ESB（企业服务总线）作为欧洲领先的在线时尚零售商，Zalando使用Kafka。LINE：基本上，为了相互通信，LINE应用程序使用Apache Kafka作为其服务的中心数据中心。


### 9、生产者和消费者的命令行是什么？

**生产者在主题上发布消息：**

**1、** bin/Kafka-console-producer.sh --broker-list 192.168.43.49:9092 --topic Hello-Kafka

**2、** 注意这里的IP是server.properties中的listeners的配置。接下来每个新行就是输入一条新消息。

**3、** 消费者接受消息：

**4、** bin/Kafka-console-consumer.sh --zookeeper localhost:2181 --topic Hello-Kafka --from-beginning


### 10、Kafka中有哪几个组件?

Kafka最重要的元素是：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_1.png#alt=9%5C_1.png)

主题：Kafka主题是一堆或一组消息。生产者：在Kafka，生产者发布通信以及向Kafka主题发布消息。消费者：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。经纪人：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 11、Kafka的一些最显著的应用。
### 12、Zookeeper对于Kafka的作用是什么？
### 13、什么是Apache Kafka?
### 14、Kafka的高可用机制是什么？
### 15、消费者API的作用是什么？
### 16、Kafka 与传统消息系统之间有三个关键区别
### 17、Kafka的哪些场景中使用了零拷贝（Zero Copy）？
### 18、在生产者中，何时发生QueueFullException？
### 19、Kafka 中是怎么体现消息顺序性的？
### 20、当ack为-1时，什么情况下，Leader 认为一条消息 Commit了？
### 21、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?
### 22、简单说一下ack机制
### 23、什么是生产者？
### 24、Kafka Producer API的作用是什么？
### 25、讲讲Kafka维护消费状态跟踪的方法
### 26、Kafka 创建 Topic 时如何将分区放置到不同的 Broker 中
### 27、Kafka 高效文件存储设计特点：
### 28、kafaka 生产数据时数据的分组策略




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
