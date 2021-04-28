# Kafka最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Kafka中有哪几个组件?

主题：Kafka主题是一堆或一组消息。

生产者：在Kafka，生产者发布通信以及向Kafka主题发布消息。

消费者：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。

经纪人：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 2、流API的作用是什么？

一种允许应用程序充当流处理器的API，它还使用一个或多个主题的输入流，并生成一个输出流到一个或多个输出主题，此外，有效地将输入流转换为输出流，我们称之为流API。


### 3、你能用Kafka做什么？

它可以以多种方式执行，例如：>>为了在两个系统之间传输数据，我们可以用它构建实时的数据流管道。>>另外，我们可以用Kafka构建一个实时流处理平台，它可以对数据快速做出反应。


### 4、列出所有Apache Kafka业务

Apache Kafka的业务包括：添加和删除Kafka主题如何修改Kafka主题如何关机在Kafka集群之间镜像数据找到消费者的位置扩展您的Kafka群集自动迁移数据退出服务器数据中心


### 5、当ack为-1时，什么情况下，Leader 认为一条消息 Commit了？

当ISR中所有Replica都向Leader发送ACK时，leader才commit，这时候producer才能认为一个请求中的消息都commit了。


### 6、Apache Kafka是什么？

能问这道题，主要是想看候选人对于Kafka的使用场景以及定位认知理解有多深，同时候可以知道候选人对于这项技术的关注度。

我们都知道，在开源软件中，大部分软件随着用户量的增加，整个软件的功能和定位也有了新的变化，而Apache Kafka一路发展到现在，已经由最初的分布式提交日志系统逐渐演变成了实时流处理框架。

因此，这道题你最好这么回Apach Kafka是一款分布式流处理平台，用于实时构建流处理应用。它有一个核心的功能广为人知，即作为企业级的消息引擎被广泛使用（通常也会称之为消息总线message bus）。

关于分布式流处理平台，其实从它官方的Logo以及Slogan我们就很容易看出来。


### 7、在生产者中，何时发生QueueFullException？

每当Kafka生产者试图以代理的身份在当时无法处理的速度发送消息时，通常都会发生QueueFullException。但是，为了协作处理增加的负载，用户需要添加足够的代理，因为生产者不会阻止。


### 8、Kafka Producer API的作用是什么？

允许应用程序将记录流到一个或多个Kafka主题的API就是我们所说的Producer API。


### 9、解释Kafka可以接收的消息最大为多少？

Kafka可以接收的最大消息大小约为1000000字节。


### 10、3.它还可以在记录进入时对其进行处理。Apache Kafka对于新手的面试
### 11、Java在Apache Kafka中的重要性是什么？
### 12、kafaka 生产数据时数据的分组策略
### 13、消费者提交消费位移时提交的是当前消费到的最新消息的offset还是offset+1?
### 14、解释下Kafka中位移（offset）的作用
### 15、如果副本长时间不在ISR中，这意味着什么？
### 16、分区Leader选举策略有几种？
### 17、解释一些Kafka流实时用例。
### 18、讲一讲Kafka的ack的三种机制
### 19、Kafka中的数据日志是什么？
### 20、Rebalance有什么影响
### 21、Kafka Producer 写数据，ACK 为 0，1，-1 时分别代表什么？
### 22、Kafka的优点有那些？
### 23、Kafka 判断一个节点是否还活着有那两个条件？
### 24、Kafka存在那些局限性？
### 25、Kafka 中是怎么体现消息顺序性的？
### 26、连接器API的作用是什么？
### 27、解释Kafka Producer API的作用。
### 28、Kafka 如何实现延迟队列?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
