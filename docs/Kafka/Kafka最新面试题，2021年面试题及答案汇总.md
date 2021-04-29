# Kafka最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka中的数据日志是什么？

我们知道，在Kafka中，消息会保留相当长的时间。此外，消费者还可以根据自己的方便进行阅读。尽管如此，有一种可能的情况是，如果将Kafka配置为将消息保留24小时，并且消费者可能停机超过24小时，则消费者可能会丢失这些消息。但是，我们仍然可以从上次已知的偏移中读取这些消息，但仅限于消费者的部分停机时间仅为60分钟的情况。此外，关于消费者从一个话题中读到什么，Kafka不会保持状态。


### 2、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？

毫无疑问，Kafka是一个流处理平台。它可以帮助：1.轻松推送记录2.可以存储大量记录，而不会出现任何存储
### 3、Kafka 中的消息是否会丢失和重复消费？

要确定Kafka的消息是否丢失或重复，从两个方面分析入手：消息发送和消息消费。

消息发送 Kafka消息发送有两种方式：**同步**（sync）和**异步**（async），默认是同步方式，可通过producer.type属性进行配置。Kafka通过配置request.required.acks属性来确认消息的生产：

综上所述，有6种消息生产的情况，下面分情况来分析消息丢失的场景：

acks=0；不和Kafka集群进行消息接收确认，则当网络异常、缓冲区满了等情况时，消息可能丢失；

acks=1；同步模式下，只有Leader确认接收成功后但挂掉了，副本没有同步，数据可能丢失；

0 表示不进行消息接收是否成功的确认；

1 表示当Leader接收成功时确认；

-1 表示Leader和Follower都接收成功时确认；

消息消费 Kafka消息消费有两个consumer接口，Low-level API和High-level API：

Low-level API：消费者自己维护offset等值，可以实现对Kafka的完全控制；

High-level API：封装了对parition和offset的管理，使用简单；如果使用高级接口High-level API，可能存在一个问题就是当消息消费者从集群中把消息取出来、并提交了新的消息offset值后，还没来得及消费就挂掉了，那么下次再消费时之前没消费成功的消息就“诡异”的消失了；

**解决办法：**

针对消息丢失： **同步模式下**，确认机制设置为-1，即让消息写入Leader和Follower之后再确认消息发送成功； **异步模式下**，为防止缓冲区满，可以在配置文件设置不限制阻塞超时时间，当缓冲区满时让生产者一直处于阻塞状态；

针对消息重复：将消息的唯一标识保存到外部介质中，每次消费时判断是否处理过即可。


### 4、生产者中，什么情况下会发生 QueueFullException？

每当Kafka生产者试图以代理的身份在当时无法处理的速度发送消息时，通常都会发生QueueFullException。但是，为了协作处理增加的负载，用户需要添加足够的代理，因为生产者不会阻止。


### 5、kafaka 生产数据时数据的分组策略

**1、** 生产者决定数据产生到集群的哪个 partition 中

**2、** 每一条消息都是以（key，value）格式

**3、** Key 是由生产者发送数据传入

**4、** 所以生产者（key）决定了数据产生到集群的哪个 partition


### 6、Kafka Producer API的作用是什么？

允许应用程序将记录流到一个或多个Kafka主题的API就是我们所说的Producer API。


### 7、Kafka 与传统MQ消息系统之间有三个关键区别

**1、** Kafka 持久化日志，这些日志可以被重复读取和无限期保留

**2、** Kafka 是一个分布式系统：它以集群的方式运行，可以灵活伸缩，在内部通过复制数据提升容错能力和高可用性

**3、** Kafka 支持实时的流式处理


### 8、没有ZooKeeper可以使用Kafka吗？

绕过Zookeeper并直接连接到Kafka服务器是不可能的，所以答案是否定的。如果以某种方式，使ZooKeeper关闭，则无法为任何客户端请求提供服务。


### 9、：24, 22


### 10、消费者提交消费位移时提交的是当前消费到的最新消息的offset还是offset+1?

offset+1


### 11、简单说一下ack机制
### 12、什么是Kafka？
### 13、Kafka存在那些局限性？
### 14、Kafka 消息是采用 Pull 模式，还是 Push 模式？
### 15、Kafka 如何实现延迟队列?
### 16、列出所有Apache Kafka业务
### 17、数据有序
### 18、Kafka中的 zookeeper 起到什么作用？可以不用zookeeper吗？
### 19、Kafka 高效文件存储设计特点：
### 20、流API的作用是什么？
### 21、Kafka为什么不支持读写分离？
### 22、解释流API的作用？
### 23、能说一下leader选举过程吗
### 24、Leader总是-1，怎么破？
### 25、讲讲Kafka维护消费状态跟踪的方法
### 26、是什么确保了Kafka中服务器的负载平衡？
### 27、：35, 36, 37
### 28、Broker的Heap Size如何设置？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
