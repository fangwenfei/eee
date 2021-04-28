# Kafka最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Kafka判断一个节点是否还活着有那两个条件？

**1、** 节点必须可以维护和ZooKeeper的连接，Zookeeper通过心跳机制检查每个节点的连接

**2、** 如果节点是个follower,他必须能及时的同步leader的写操作，延时不能太久


### 2、Kafa consumer 是否可以消费指定分区消息？

Kafa consumer 消费消息时，向 broker 发出"fetch"请求去消费特定分区的消息，consumer

指定消息在日志中的偏移量（offset），就可以消费从这个位置开始的消息，customer 拥有

了 offset 的控制权，可以向后回滚去重新消费之前的消息，这是很有意义的


### 3、partition 的数据如何保存到硬盘

topic 中的多个 partition 以文件夹的形式保存到 broker，每个分区序号从 0 递增，

且消息有序

Partition 文件下有多个 segment（xxx.index，xxx.log）

segment 文件里的 大小和配置文件大小一致可以根据要求修改 默认为 1g

如果大小大于 1g 时，会滚动一个新的 segment 并且以上一个 segment 最后一条消息的偏移

量命名


### 4、Kafka如何不消费重复数据？比如扣款，我们不能重复的扣。

**其实还是得结合业务来思考，我这里给几个思路：**

**1、** 比如你拿个数据要写库，你先根据主键查一下，如果这数据都有了，你就别插入了，update 一下好吧。

**2、** 比如你是写 Redis，那没问题了，反正每次都是 set，天然幂等性。

**3、** 比如你不是上面两个场景，那做的稍微复杂一点，你需要让生产者发送每条数据的时候，里面加一个全局唯一的 id，类似订单 id 之类的东西，然后你这里消费到了之后，先根据这个 id 去比如 Redis 里查一下，之前消费过吗？如果没有消费过，你就处理，然后这个 id 写 Redis。如果消费过了，那你就别处理了，保证别重复处理相同的消息即可。

**4、** 比如基于数据库的唯一键来保证重复数据不会重复插入多条。因为有唯一键约束了，重复数据插入只会报错，不会导致数据库中出现脏数据。

### 5、Kafka的message格式是什么？

一个Kafka的Message由一个**固定长度的header**和一个**变长的消息体body**组成

1. header部分 由一个字节的magic(文件格式)和四个字节的CRC32(用于判断body消息体是否正常)构成。
2. 当magic的值为1的时候，会在magic和crc32之间多一个字节的数据：attributes(保存一些相关属性，比如是否压缩、压缩格式等等);
3. 如果magic的值为0，那么不存在attributes属性
4. body部分 由N个字节构成的一个消息体，包含了具体的key/value消息


### 6、在Kafka中，ZooKeeper的作用是什么？

**1、** 这道题，也是我经常会问候选人的题，因为任何分布式系统中虽然都通过一些列的算法去除了传统的关系型数据存储，但是毕竟还是有些数据要存储的，同时分布式系统的特性往往是需要有一些中间人角色来统筹集群。比如我们在整个微服务框架中的Dubbo，它也是需要依赖一些注册中心或配置中心类的中间件的，以及云原生的Kubernetes使用etcd作为整个集群的枢纽。

**2、** 标准答案：目前，Kafka使用ZooKeeper存放集群元数据、成员管理、Controller选举，以及其他一些管理类任务。之后，等KIP-500提案完成后，Kafka将完全不再依赖于ZooKeeper。

**1、** “存放元数据”是指主题分区的所有数据都保存在 ZooKeeper 中，且以它保存的数据为权威，其他 “人” 都要与它保持对齐。

**2、** “成员管理” 是指 Broker 节点的注册、注销以及属性变更，等等。

**3、** “Controller 选举” 是指选举集群 Controller，而其他管理类任务包括但不限于主题删除、参数配置等。

KIP-500 思想，是使用社区自研的基于Raft的共识算法，替代ZooKeeper，实现Controller自选举。



### 7、Kafka分布式（不是单机）的情况下，如何保证消息的顺序消费?

**1、** Kafka分布式的单位是partition，同一个partition用一个write ahead log组织，所以可以保证FIFO的顺序。不同partition之间不能保证顺序。但是绝大多数用户都可以通过message key来定义，因为同一个key的message可以保证只发送到同一个partition。

**2、** Kafka 中发送1条消息的时候，可以指定(topic, partition, key) 3个参数。partiton 和 key 是可选的。如果你指定了 partition，那就是所有消息发往同1个 partition，就是有序的。并且在消费端，Kafka 保证，1个 partition 只能被1个 consumer 消费。或者你指定 key（比如 order id），具有同1个 key 的所有消息，会发往同1个 partition。


### 8、为什么要使用Apache Kafka集群？

为了克服收集大量数据和分析收集数据的挑战，我们需要一个消息队列系统。因此Apache Kafka应运而生。其好处是：只需存储/发送事件以进行实时处理，就可以跟踪Web活动。通过这一点，我们可以发出警报并报告操作指标。此外，我们可以将数据转换为标准格式。此外，它允许对主题的流数据进行连续处理。由于它的广泛使用，它秒杀了竞品，如ActiveMQ，RabbitMQ等。


### 9、生产者中，什么情况下会发生 QueueFullException？

每当Kafka生产者试图以代理的身份在当时无法处理的速度发送消息时，通常都会发生QueueFullException。但是，为了协作处理增加的负载，用户需要添加足够的代理，因为生产者不会阻止。


### 10、解释偏移的作用。

给分区中的消息提供了一个顺序ID号，我们称之为偏移量。因此，为了唯一地识别分区中的每条消息，我们使用这些偏移量。


### 11、Kafka 的 ack 机制
### 12、解释如何调整Kafka以获得最佳性能。
### 13、Leader和Follower的概念是什么？
### 14、消费者API的作用是什么？
### 15、Kafka什么情况下会rebalance
### 16、Kafka 创建 Topic 时如何将分区放置到不同的 Broker 中
### 17、Kafka中有哪几个组件?
### 18、简述Follower副本消息同步的完整流程
### 19、Kafka 与传统MQ消息系统之间有三个关键区别
### 20、consumer_offsets是做什么用的？
### 21、监控Kafka的框架都有哪些？
### 22、什么是Apache Kafka?
### 23、Kafka一次reblance大概要多久
### 24、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 25、Kafka系统工具有哪些类型？
### 26、消息队列的作用
### 27、解释流API的作用？
### 28、Kafka 存储在硬盘上的消息格式是什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
