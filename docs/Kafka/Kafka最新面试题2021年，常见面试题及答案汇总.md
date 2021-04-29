# Kafka最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？

Kafka是一个流处理平台。它可以完成以下工作：

**1、** 轻松推送记录

**2、** 可以存储大量记录，而不会出现任何存储问题

**3、** 它还可以在记录进入时对其进行处理。


### 2、Kafa consumer 是否可以消费指定分区消息？

Kafa consumer 消费消息时，向 broker 发出"fetch"请求去消费特定分区的消息，consumer

指定消息在日志中的偏移量（offset），就可以消费从这个位置开始的消息，customer 拥有

了 offset 的控制权，可以向后回滚去重新消费之前的消息，这是很有意义的


### 3、Kafka Follower如何与Leader同步数据?

Kafka 的复制机制既不是完全的同步复制，也不是单纯的异步复制。完全同步复制要求 All Alive Follower 都复制完，这条消息才会被认为 commit，这种复制方式极大的影响了吞吐率。而异步复制方式下，Follower 异步的从 Leader 复制数据，数据只要被 Leader 写入 log 就被认为已经 commit，这种情况下，如果 leader 挂掉，会丢失数据，Kafka 使用 ISR 的方式很好的均衡了确保数据不丢失以及吞吐率。Follower 可以批量的从 Leader 复制数据，而且 Leader 充分利用磁盘顺序读以及 send file(zero copy) 机制，这样极大的提高复制性能，内部批量写磁盘，大幅减少了 Follower 与 Leader 的消息量差。


### 4、流API的作用是什么？

一种允许应用程序充当流处理器的API，它还使用一个或多个主题的输入流，并生成一个输出流到一个或多个输出主题，此外，有效地将输入流转换为输出流，我们称之为流API。


### 5、在生产者中，何时发生QueueFullException？

每当Kafka生产者试图以代理的身份在当时无法处理的速度发送消息时，通常都会发生QueueFullException。但是，为了协作处理增加的负载，用户需要添加足够的代理，因为生产者不会阻止。


### 6、：1,2,4,7,8,9,10Apache Kafka对于有经验的人的面试
### 7、Apache Kafka是什么？

能问这道题，主要是想看候选人对于Kafka的使用场景以及定位认知理解有多深，同时候可以知道候选人对于这项技术的关注度。

我们都知道，在开源软件中，大部分软件随着用户量的增加，整个软件的功能和定位也有了新的变化，而Apache Kafka一路发展到现在，已经由最初的分布式提交日志系统逐渐演变成了实时流处理框架。

因此，这道题你最好这么回Apach Kafka是一款分布式流处理平台，用于实时构建流处理应用。它有一个核心的功能广为人知，即作为企业级的消息引擎被广泛使用（通常也会称之为消息总线message bus）。

关于分布式流处理平台，其实从它官方的Logo以及Slogan我们就很容易看出来。


### 8、怎么解决rebalance中遇到的问题呢？

要避免 Rebalance，还是要从 Rebalance 发生的时机入手。我们在前面说过，Rebalance 主要发生的时机有三个：

组成员数量发生变化

订阅主题数量发生变化

订阅主题的分区数发生变化

后两个我们大可以人为的避免，发生rebalance最常见的原因是消费组成员的变化。

消费者成员正常的添加和停掉导致rebalance，这种情况无法避免，但是时在某些情况下，Consumer 实例会被 Coordinator 错误地认为 “已停止” 从而被“踢出”Group。从而导致rebalance。

当 Consumer Group 完成 Rebalance 之后，每个 Consumer 实例都会定期地向 Coordinator 发送心跳请求，表明它还存活着。如果某个 Consumer 实例不能及时地发送这些心跳请求，Coordinator 就会认为该 Consumer 已经 “死” 了，从而将其从 Group 中移除，然后开启新一轮 Rebalance。这个时间可以通过Consumer 端的参数 session.timeout.ms进行配置。默认值是 10 秒。

除了这个参数，Consumer 还提供了一个控制发送心跳请求频率的参数，就是 heartbeat.interval.ms。这个值设置得越小，Consumer 实例发送心跳请求的频率就越高。频繁地发送心跳请求会额外消耗带宽资源，但好处是能够更加快速地知晓当前是否开启 Rebalance，因为，目前 Coordinator 通知各个 Consumer 实例开启 Rebalance 的方法，就是将 REBALANCE_NEEDED 标志封装进心跳请求的响应体中。

除了以上两个参数，Consumer 端还有一个参数，用于控制 Consumer 实际消费能力对 Rebalance 的影响，即 max.poll.interval.ms 参数。它限定了 Consumer 端应用程序两次调用 poll 方法的最大时间间隔。它的默认值是 5 分钟，表示你的 Consumer 程序如果在 5 分钟之内无法消费完 poll 方法返回的消息，那么 Consumer 会主动发起 “离开组” 的请求，Coordinator 也会开启新一轮 Rebalance。

通过上面的分析，我们可以看一下那些rebalance是可以避免的：

第一类非必要 Rebalance 是因为未能及时发送心跳，导致 Consumer 被 “踢出”Group 而引发的。这种情况下我们可以设置 session.timeout.ms 和 heartbeat.interval.ms 的值，来尽量避免rebalance的出现。（以下的配置是在网上找到的最佳实践，暂时还没测试过）

设置 session.timeout.ms = 6s。设置 heartbeat.interval.ms = 2s。要保证 Consumer 实例在被判定为 “dead” 之前，能够发送至少 3 轮的心跳请求，即 session.timeout.ms >= 3 * heartbeat.interval.ms。将 session.timeout.ms 设置成 6s 主要是为了让 Coordinator 能够更快地定位已经挂掉的 Consumer，早日把它们踢出 Group。

第二类非必要 Rebalance 是 Consumer 消费时间过长导致的。此时，max.poll.interval.ms 参数值的设置显得尤为关键。如果要避免非预期的 Rebalance，你最好将该参数值设置得大一点，比你的下游最大处理时间稍长一点。

总之，要为业务处理逻辑留下充足的时间。这样，Consumer 就不会因为处理这些消息的时间太长而引发 Rebalance 。


### 9、什么是消费者组？

消费者组的概念是Apache Kafka独有的。基本上，每个Kafka消费群体都由一个或多个共同消费一组订阅主题的消费者组成。


### 10、Kafka Unclean 配置代表什么？会对 spark streaming 消费有什么影响？

unclean.leader.election.enable 为 true 的话，意味着非 ISR 集合的 broker 也可以参与选举，这样有可能就会丢数据，spark streaming在消费过程中拿到的 end offset 会突然变小，导致 spark streaming job 挂掉。如果 unclean.leader.election.enable 参数设置为 true，就有可能发生数据丢失和数据不一致的情况，Kafka 的可靠性就会降低；而如果 unclean.leader.election.enable 参数设置为 false，Kafka 的可用性就会降低。


### 11、Kafka中有哪几个组件?
### 12、Broker的Heap Size如何设置？
### 13、是什么确保了Kafka中服务器的负载平衡？
### 14、如何控制消费的位置
### 15、如果 Leader Crash 时，ISR为空怎么办
### 16、Kafka 的 ack 机制
### 17、什么是生产者？
### 18、Kafka Producer 写数据，ACK 为 0，1，-1 时分别代表什么？
### 19、Kafka 如何判断节点是否存活
### 20、解释术语“Log Anatomy”
### 21、：12,15,20
### 22、：46, 48
### 23、Kafka Producer API的作用是什么？
### 24、Kafka的优点有那些？
### 25、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?
### 26、讲讲Kafka维护消费状态跟踪的方法
### 27、Kafka中的数据日志是什么？
### 28、Kafka如何不消费重复数据？比如扣款，我们不能重复的扣。




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
