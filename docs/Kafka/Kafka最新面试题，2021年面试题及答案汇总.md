# Kafka最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Kafka 如何判断节点是否存活

节点必须可以维护和 ZooKeeper 的连接，ZooKeeper 通过心跳机制检查每个节点的连 接

如果节点是个 follower,他必须能及时的同步 leader 的写操作，延时不能太久

问题5：Kafka 消息是采用 Pull 模式，还是 Push 模式

Kafka 最初考虑的问题是，customer 应该从 brokes 拉取消息还是 brokers 将消息推送到 consumer，也就是 pull 还 push。

在这方面，Kafka 遵循了一种大部分消息系统共同的传统 的设计：producer 将消息推送到 broker，consumer 从 broker 拉取消息 一些消息系统比如 Scribe 和 Apache Flume 采用了 push 模式，将消息推送到下游的 consumer。

这样做有好处也有坏处：由 broker 决定消息推送的速率，对于不同消费速率的 consumer 就不太好处理了。

消息系统都致力于让 consumer 以最大的速率最快速的消费消 息，但不幸的是，push 模式下，当 broker 推送的速率远大于 consumer 消费的速率时， consumer 恐怕就要崩溃了。

最终 Kafka 还是选取了传统的 pull 模式 Pull 模式的另外一个好处是 consumer 可以自主决定是否批量的从 broker 拉取数据。Push 模式必须在不知道下游 consumer 消费能力和消费策略的情况下决定是立即推送每条消息还 是缓存之后批量推送。

如果为了避免 consumer 崩溃而采用较低的推送速率，将可能导致一 次只推送较少的消息而造成浪费。

Pull 模式下，consumer 就可以根据自己的消费能力去决 定这些策略 Pull 有个缺点是，如果 broker 没有可供消费的消息，将导致 consumer 不断在循环中轮询， 直到新消息到 t 达。为了避免这点，Kafka 有个参数可以让 consumer 阻塞知道新消息到达 (当然也可以阻塞知道消息的数量达到某个特定的量这样就可以批量发）


### 2、什么情况下一个 Broker 会从ISR中踢出去?

leader 会维护一个与其基本保持同步的 Replica 列表，该列表称为 ISR(in-sync Replica)，每个 Partition 都会有一个 ISR，而且是由 leader 动态维护 ，如果一个 follower 比一个 leader 落后太多，或者超过一定时间未发起数据复制请求，则 leader 将其重 ISR 中移除 。


### 3、Kafka的高可用机制是什么？

这个问题比较系统，回答出Kafka的系统特点，leader和follower的关系，消息读写的顺序即可。

[https://www.cnblogs.com/qingyunzong/p/9004703.html](https://www.cnblogs.com/qingyunzong/p/9004703.html)

[https://www.tuicool.com/articles/BNRza2E](https://www.tuicool.com/articles/BNRza2E)

[https://yq.aliyun.com/articles/64703](https://yq.aliyun.com/articles/64703)


### 4、Kafka中的 zookeeper 起到什么作用？可以不用zookeeper吗？

zookeeper 是一个分布式的协调组件，早期版本的Kafka用zk做meta信息存储，consumer的消费状态，group 的管理以及 offset 的值。考虑到 zookeeper 本身的一些因素以及整个架构较大概率存在单点问题，新版本中逐渐弱化了 zookeeper 的作用。新的 consumer 使用了 Kafka 内部的 group coordination 协议，也减少了对 zookeeper 的依赖，

但是 broker 依然依赖于 zookeeper，zookeeper 在Kafka中还用来选举 controller 和检测 broker 是否存活等等。


### 5、在Kafka中，ZooKeeper的作用是什么？

**1、** 这道题，也是我经常会问候选人的题，因为任何分布式系统中虽然都通过一些列的算法去除了传统的关系型数据存储，但是毕竟还是有些数据要存储的，同时分布式系统的特性往往是需要有一些中间人角色来统筹集群。比如我们在整个微服务框架中的Dubbo，它也是需要依赖一些注册中心或配置中心类的中间件的，以及云原生的Kubernetes使用etcd作为整个集群的枢纽。

**2、** 标准答案：目前，Kafka使用ZooKeeper存放集群元数据、成员管理、Controller选举，以及其他一些管理类任务。之后，等KIP-500提案完成后，Kafka将完全不再依赖于ZooKeeper。

**1、** “存放元数据”是指主题分区的所有数据都保存在 ZooKeeper 中，且以它保存的数据为权威，其他 “人” 都要与它保持对齐。

**2、** “成员管理” 是指 Broker 节点的注册、注销以及属性变更，等等。

**3、** “Controller 选举” 是指选举集群 Controller，而其他管理类任务包括但不限于主题删除、参数配置等。

KIP-500 思想，是使用社区自研的基于Raft的共识算法，替代ZooKeeper，实现Controller自选举。



### 6、阐述下 Kafka 中的领导者副本（Leader Replica）和追随者副本（Follower Replica）的区别

推荐的答案：Kafka副本当前分为领导者副本和追随者副本。只有Leader副本才能对外提供读写服务，响应Clients端的请求。Follower副本只是采用拉（PULL）的方式，被动地同步Leader副本中的数据，并且在Leader副本所在的Broker宕机后，随时准备应聘Leader副本。

加分点：

**1、** 强调Follower副本也能对外提供读服务。自Kafka 2.4版本开始，社区通过引入新的Broker端参数，允许Follower副本有限度地提供读服务。

**2、** 强调Leader和Follower的消息序列在实际场景中不一致。通常情况下，很多因素可能造成Leader和Follower之间的不同步，比如程序问题，网络问题，broker问题等，短暂的不同步我们可以关注（秒级别），但长时间的不同步可能就需要深入排查了，因为一旦Leader所在节点异常，可能直接影响可用性。

注意：之前确保一致性的主要手段是高水位机制（HW），但高水位值无法保证Leader连续变更场景下的数据一致性，因此，社区引入了Leader Epoch机制，来修复高水位值的弊端。


### 7、什么是复制工具及其类型？

为了增强持久性和更高的可用性，这里提供了复制工具。其类型为创建主题工具列表主题工具添加分区工具


### 8、为什么Kafka技术很重要？

Kafka有一些优点，因此使用起来很重要：

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_2.png#alt=9%5C_2.png)

高吞吐量：我们在Kafka中不需要任何大型硬件，因为它能够处理高速和大容量数据。此外，它还可以支持每秒数千条消息的消息吞吐量。低延迟：Kafka可以轻松处理这些消息，具有毫秒级的极低延迟，这是大多数新用例所要求的。容错：Kafka能够抵抗集群中的节点/机器故障。耐久性：由于Kafka支持消息复制，因此消息永远不会丢失。这是耐久性背后的原因之一。可扩展性：卡夫卡可以扩展，而不需要通过添加额外的节点而在运行中造成任何停机。


### 9、Kafa consumer 是否可以消费指定分区消息？

Kafa consumer 消费消息时，向 broker 发出"fetch"请求去消费特定分区的消息，consumer

指定消息在日志中的偏移量（offset），就可以消费从这个位置开始的消息，customer 拥有

了 offset 的控制权，可以向后回滚去重新消费之前的消息，这是很有意义的


### 10、Kafka 新建的分区会在哪个目录下创建

在启动 Kafka 集群之前，我们需要配置好 log.dirs 参数，其值是 Kafka 数据的存放目录，

这个参数可以配置多个目录，目录之间使用逗号分隔，通常这些目录是分布在不同的磁盘

上用于提高读写性能。

**1、** 当然我们也可以配置 log.dir 参数，含义一样。只需要设置其中一个即可。

**2、** 如果 log.dirs 参数只配置了一个目录，那么分配到各个 Broker 上的分区肯定只能在这个

**3、** 目录下创建文件夹用于存放数据。

**1、** 但是如果 log.dirs 参数配置了多个目录，那么 Kafka 会在哪个文件夹中创建分区目录呢？

**2、** 答案是：Kafka 会在含有分区目录最少的文件夹中创建新的分区目录，分区目录名为 Topic

**3、** 名+分区 ID。注意，是分区文件夹总数最少的目录，而不是磁盘使用量最少的目录！也就

**4、** 是说，如果你给 log.dirs 参数新增了一个新的磁盘，新的分区目录肯定是先在这个新的磁

**5、** 盘上创建直到这个新的磁盘目录拥有的分区目录不是最少为止。


### 11、Kafka 高效文件存储设计特点：
### 12、什么是Kafka中的地域复制？
### 13、解释多租户是什么？
### 14、Kafka Follower如何与Leader同步数据?
### 15、Kafka提供的保证是什么？
### 16、流API的作用是什么？
### 17、如果副本长时间不在ISR中，这意味着什么？
### 18、Kafka中有哪几个组件?
### 19、Apache Kafka的缺陷
### 20、分区Leader选举策略有几种？
### 21、解释生产者是什么？
### 22、Kafka如何不消费重复数据？比如扣款，我们不能重复的扣。
### 23、消费者负载均衡策略
### 24、能说一下leader选举过程吗
### 25、Kafka的优点有那些？
### 26、Kafka什么情况下会rebalance
### 27、消费者API的作用是什么？
### 28、生产者中，什么情况下会发生 QueueFullException？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
