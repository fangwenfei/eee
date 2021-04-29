# Kafka最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka流的特点。

Kafka流的一些最佳功能是Kafka Streams具有高度可扩展性和容错性。Kafka部署到容器，VM，裸机，云。我们可以说，Kafka流对于小型，中型和大型用例同样可行。此外，它完全与Kafka安全集成。编写标准Java应用程序。完全一次处理语义。而且，不需要单独的处理集群。


### 2、解释领导者和追随者的概念。

在Kafka的每个分区中，都有一个服务器充当领导者，0到多个服务器充当追随者的角色。


### 3、什么情况下一个 Broker 会从ISR中踢出去?

leader 会维护一个与其基本保持同步的 Replica 列表，该列表称为 ISR(in-sync Replica)，每个 Partition 都会有一个 ISR，而且是由 leader 动态维护 ，如果一个 follower 比一个 leader 落后太多，或者超过一定时间未发起数据复制请求，则 leader 将其重 ISR 中移除 。


### 4、Kafka Follower如何与Leader同步数据?

Kafka 的复制机制既不是完全的同步复制，也不是单纯的异步复制。完全同步复制要求 All Alive Follower 都复制完，这条消息才会被认为 commit，这种复制方式极大的影响了吞吐率。而异步复制方式下，Follower 异步的从 Leader 复制数据，数据只要被 Leader 写入 log 就被认为已经 commit，这种情况下，如果 leader 挂掉，会丢失数据，Kafka 使用 ISR 的方式很好的均衡了确保数据不丢失以及吞吐率。Follower 可以批量的从 Leader 复制数据，而且 Leader 充分利用磁盘顺序读以及 send file(zero copy) 机制，这样极大的提高复制性能，内部批量写磁盘，大幅减少了 Follower 与 Leader 的消息量差。


### 5、Kafka 的消费者如何消费数据

消费者每次消费数据的时候，消费者都会记录消费的物理偏移量（offset）的位置

等到下次消费时，他会接着上次位置继续消费


### 6、解释一些Kafka流实时用例。

《纽约时报》：该公司使用它来实时存储和分发已发布的内容到各种应用程序和系统，使其可供读者使用。基本上，它使用Apache Kafka和Kafka流。Zalando：作为ESB（企业服务总线）作为欧洲领先的在线时尚零售商，Zalando使用Kafka。LINE：基本上，为了相互通信，LINE应用程序使用Apache Kafka作为其服务的中心数据中心。


### 7、解释下Kafka中位移（offset）的作用

标准答案：在Kafka中，每个主题分区下的每条消息都被赋予了一个唯一的ID数值，用于标识它在分区中的位置。这个ID数值，就被称为位移，或者叫偏移量。一旦消息被写入到分区日志，它的位移值将不能被修改。

答完这些之后，你还可以把整个面试方向转移到你希望的地方：

**1、** 如果你深谙Broker底层日志写入的逻辑，可以强调下消息在日志中的存放格式

**2、** 如果你明白位移值一旦被确定不能修改，可以强调下“Log Cleaner组件都不能影响位移值”这件事情

**3、** 如果你对消费者的概念还算熟悉，可以再详细说说位移值和消费者位移值之间的区别


### 8、：12,15,20
### 9、阐述下 Kafka 中的领导者副本（Leader Replica）和追随者副本（Follower Replica）的区别
### 10、Kafka什么情况下会rebalance
### 11、能说一下leader选举过程吗
### 12、如何调优Kafka？
### 13、Kafka的流处理是什么意思？
### 14、3.不支持通配符主题选择4.速度###
### 15、简单说一下ack机制
### 16、Kafka集群中保留期的目的是什么？
### 17、partition 的数据如何保存到硬盘
### 18、Kafka 判断一个节点是否还活着有那两个条件？
### 19、解释术语“主题复制因子”。
### 20、如何控制消费的位置
### 21、说明Kafka的一个最佳特征。
### 22、Leader和Follower的概念是什么？
### 23、解释生产者是什么？
### 24、Apache Kafka是什么？
### 25、Kafka判断一个节点是否还活着有那两个条件？
### 26、Kafka提供的保证是什么？
### 27、为什么要使用 Kafka？为什么要使用消息队列？
### 28、解释偏移的作用。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
