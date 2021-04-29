# Kafka最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、解释如何调整Kafka以获得最佳性能。

因此，调优Apache Kafka的方法是调优它的几个组件：1.调整Kafka生产者2.Kafka代理调优3.调整Kafka消费者


### 2、Java Consumer为什么采用单线程来获取消息？

**1、** 在回答之前，如果先把这句话说出来，一定会加分：Java Consumer是双线程的设计。一个线程是用户主线程，负责获取消息；另一个线程是心跳线程，负责向Kafka汇报消费者存活情况。将心跳单独放入专属的线程，能够有效地规避因消息处理速度慢而被视为下线的“假死”情况。

**2、** 单线程获取消息的设计能够避免阻塞式的消息获取方式。单线程轮询方式容易实现异步非阻塞式，这样便于将消费者扩展成支持实时流处理的操作算子。因为很多实时流处理操作算子都不能是阻塞式的。另外一个可能的好处是，可以简化代码的开发。多线程交互的代码是非常容易出错的。


### 3、生产者中，什么情况下会发生 QueueFullException？

每当Kafka生产者试图以代理的身份在当时无法处理的速度发送消息时，通常都会发生QueueFullException。但是，为了协作处理增加的负载，用户需要添加足够的代理，因为生产者不会阻止。


### 4、副本长时间不在ISR中，这意味着什么？

意味着 follower 不能像 leader 收集数据那样快速地获取数据。


### 5、Kafka一次reblance大概要多久

1个Topic，10个partition，3个consumer 测试结果 经过几轮测试发现每次rebalance所消耗的时间大概在 80ms~100ms平均耗时在87ms左右。


### 6、什么是消费者组？

**1、** 消费者组是Kafka独有的概念，如果面试官问这个，就说明他对此是有一定了解的。

**2、** 胡大给的标准答案是：官网上的介绍言简意赅，即消费者组是Kafka提供的可扩展且具有容错性的消费者机制。

**3、** 但实际上，消费者组（Consumer Group）其实包含两个概念，作为队列，消费者组允许你分割数据处理到一组进程集合上（即一个消费者组中可以包含多个消费者进程，他们共同消费该topic的数据），这有助于你的消费能力的动态调整；作为-订阅模型（publish-subscribe），Kafka允许你将同一份消息广播到多个消费者组里，以此来丰富多种数据使用场景。

**4、** 需要注意的是：在消费者组中，多个实例共同订阅若干个主题，实现共同消费。同一个组下的每个实例都配置有相同的组ID，被分配不同的订阅分区。当某个实例挂掉的时候，其他实例会自动地承担起它负责消费的分区。因此，消费者组在一定程度上也保证了消费者程序的高可用性。

注意：消费者组的题目，能够帮你在某种程度上掌控下面的面试方向。

**1、** 如果你擅长位移值原理（Offset），就不妨再提一下消费者组的位移提交机制；

**2、** 如果你擅长Kafka Broker，可以提一下消费者组与Broker之间的交互；

**3、** 如果你擅长与消费者组完全不相关的Producer，那么就可以这么说：“消费者组要消费的数据完全来自于Producer端生产的消息，我对Producer还是比较熟悉的。”

总之，你总得对consumer group相关的方向有一定理解，然后才能像面试官表名你对某一块很理解。


### 7、简述Follower副本消息同步的完整流程

**1、** 首先，Follower发送FETCH请求给Leader。

**2、** 接着，Leader会读取底层日志文件中的消息数据，再更新它内存中的Follower副本的LEO值，更新为FETCH请求中的fetchOffset值。

**3、** 最后，尝试更新分区高水位值。Follower接收到FETCH响应之后，会把消息写入到底层日志，接着更新LEO和HW值。

**4、** Leader和Follower的HW值更新时机是不同的，Follower的HW更新永远落后于Leader的HW。这种时间上的错配是造成各种不一致的原因。

**5、** 因此，对于消费者而言，消费到的消息永远是所有副本中最小的那个HW。


### 8、Kafka什么情况下会rebalance

rebalance 的触发条件有五个。

条件1：有新的consumer加入

条件2：旧的consumer挂了

条件3：coordinator挂了，集群选举出新的coordinator

条件4：topic的partition新加

条件5：consumer调用unsubscrible()，取消topic的订阅

rebalance 发生时，Group 下所有 consumer 实例都会协调在一起共同参与，Kafka 能够保证尽量达到最公平的分配。但是 Rebalance 过程对 consumer group 会造成比较严重的影响。在 Rebalance 的过程中 consumer group 下的所有消费者实例都会停止工作，等待 Rebalance 过程完成。


### 9、Rebalance有什么影响

Rebalance本身是Kafka集群的一个保护设定，用于剔除掉无法消费或者过慢的消费者，然后由于我们的数据量较大，同时后续消费后的数据写入需要走网络IO，很有可能存在依赖的第三方服务存在慢的情况而导致我们超时。Rebalance对我们数据的影响主要有以下几点：

数据重复消费: 消费过的数据由于提交offset任务也会失败，在partition被分配给其他消费者的时候，会造成重复消费，数据重复且增加集群压力

Rebalance扩散到整个ConsumerGroup的所有消费者，因为一个消费者的退出，导致整个Group进行了Rebalance，并在一个比较慢的时间内达到稳定状态，影响面较大

频繁的Rebalance反而降低了消息的消费速度，大部分时间都在重复消费和Rebalance

数据不能及时消费，会累积lag，在Kafka的TTL之后会丢弃数据 上面的影响对于我们系统来说，都是致命的。


### 10、消费者提交消费位移时提交的是当前消费到的最新消息的offset还是offset+1?

offset+1


### 11、副本和ISR扮演什么角色？
### 12、：24, 22
### 13、Kafka 创建 Topic 时如何将分区放置到不同的 Broker 中
### 14、什么情况下一个 Broker 会从ISR中踢出去?
### 15、没有ZooKeeper可以使用Kafka吗？
### 16、：11,13,14,16,17,18,19Apache Kafka对于有经验的人的面试
### 17、数据传输的事务定义有哪三种？
### 18、解释多租户是什么？
### 19、解释流API的作用？
### 20、Kafka提供的保证是什么？
### 21、：35, 36, 37
### 22、producer 是否直接将数据发送到 broker 的 leader(主节点)？
### 23、Kafka可以接收的消息最大为多少？
### 24、监控Kafka的框架都有哪些？
### 25、consumer是推还是拉？
### 26、讲一讲Kafka的ack的三种机制
### 27、生产者和消费者的命令行是什么？
### 28、Kafka能手动删除消息吗？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
