# Kafka最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Kafka中的 zookeeper 起到什么作用？可以不用zookeeper吗？

zookeeper 是一个分布式的协调组件，早期版本的Kafka用zk做meta信息存储，consumer的消费状态，group 的管理以及 offset 的值。考虑到 zookeeper 本身的一些因素以及整个架构较大概率存在单点问题，新版本中逐渐弱化了 zookeeper 的作用。新的 consumer 使用了 Kafka 内部的 group coordination 协议，也减少了对 zookeeper 的依赖，

但是 broker 依然依赖于 zookeeper，zookeeper 在Kafka中还用来选举 controller 和检测 broker 是否存活等等。


### 2、传统的消息传递方法有哪些类型？

基本上，传统的消息传递方法有两种，如：排队：这是一种消费者池可以从服务器读取消息并且每条消息转到其中一个消息的方法。发布-订阅：在发布-订阅中，消息被广播给所有消费者。


### 3、Kafka Follower如何与Leader同步数据?

Kafka 的复制机制既不是完全的同步复制，也不是单纯的异步复制。完全同步复制要求 All Alive Follower 都复制完，这条消息才会被认为 commit，这种复制方式极大的影响了吞吐率。而异步复制方式下，Follower 异步的从 Leader 复制数据，数据只要被 Leader 写入 log 就被认为已经 commit，这种情况下，如果 leader 挂掉，会丢失数据，Kafka 使用 ISR 的方式很好的均衡了确保数据不丢失以及吞吐率。Follower 可以批量的从 Leader 复制数据，而且 Leader 充分利用磁盘顺序读以及 send file(zero copy) 机制，这样极大的提高复制性能，内部批量写磁盘，大幅减少了 Follower 与 Leader 的消息量差。


### 4、什么是Kafka？

Kafka是**分布式-订阅消息系统**，它最初是由LinkedIn公司开发的，之后成为Apache项目的一部分，Kafka是一个分布式，可划分的，冗余备份的持久性的日志服务，它主要用于处理流式数据。


### 5、Kafka的流处理是什么意思？

连续、实时、并发和以逐记录方式处理数据的类型，我们称之为Kafka流处理。


### 6、Kafka 的消费者如何消费数据

消费者每次消费数据的时候，消费者都会记录消费的物理偏移量（offset）的位置

等到下次消费时，他会接着上次位置继续消费


### 7、什么是消费者或用户？

Kafka消费者订阅一个主题，并读取和处理来自该主题的消息。此外，有了消费者组的名字，消费者就给自己贴上了标签。换句话说，在每个订阅使用者组中，到主题的每个记录都传递到一个使用者实例。确保使用者实例可能位于单独的进程或单独的计算机上。


### 8、如何调优Kafka？

**1、** 作为SRE来讲，任何生产环境的调优，首先需要识别问题和瓶颈点，而不是随意的进行臆想调优。随后，需要确定优化目标，并且定量给出目标。

**2、** 对于Kafka来讲，常见的调优方向基本为：吞吐量、延时、持久性和可用性，每种目标之前都是由冲突点，这也就要求了，我们在对业务接入使用时，要进行业务场景的了解，以对业务进行相对的集群隔离，因为每一个方向的优化思路都是不同的，甚至是相反的。

**3、** 确定了目标之后，还要明确优化的维度。有些调优属于通用的优化思路，比如对操作系统、JVM等的优化；有些则是有针对性的，比如要优化Kafka的TPS。我们需要从3个方向去考虑：

**1、** Producer端：增加batch.size和linger.ms，启用压缩，关闭重试

**2、** Broker端：增加num.replica.fetchers提升Follower同步TPS，避免Broker Full GC等。

**3、** Consumer：增加fetch.min.bytes


### 9、Kafka提供的保证是什么？

他们是生产者向特定主题分区发送的消息的顺序相同。此外，消费者实例按照它们存储在日志中的顺序查看记录。此外，即使不丢失任何提交给日志的记录，我们也可以容忍最多N-1个服务器故障。Apache Kafka对于新手的面试
### 10、LEO、LSO、AR、ISR、HW都表示什么含义？

讲真，我不认为这是炫技的题目，特别是作为SRE来讲，对于一个开源软件的原理以及概念的理解，是非常重要的。

**1、** LEO（Log End Offset）：日志末端位移值或末端偏移量，表示日志下一条待插入消息的位移值。举个例子，如果日志有10条消息，位移值从0开始，那么，第10条消息的位移值就是9。此时，LEO = 10。

**2、** LSO（Log Stable Offset）：这是Kafka事务的概念。如果你没有使用到事务，那么这个值不存在（其实也不是不存在，只是设置成一个无意义的值）。该值控制了事务型消费者能够看到的消息范围。它经常与Log Start Offset，即日志起始位移值相混淆，因为有些人将后者缩写成LSO，这是不对的。在Kafka中，LSO就是指代Log Stable Offset。

**3、** AR（Assigned Replicas）：AR是主题被创建后，分区创建时被分配的副本集合，副本个数由副本因子决定。

**4、** ISR（In-Sync Replicas）：Kafka中特别重要的概念，指代的是AR中那些与Leader保持同步的副本集合。在AR中的副本可能不在ISR中，但Leader副本天然就包含在ISR中。

**5、** HW（High watermark）：高水位值，这是控制消费者可读取消息范围的重要字段。一个普通消费者只能“看到”Leader副本上介于Log Start Offset和HW（不含）之间的所有消息。水位以上的消息是对消费者不可见的。

需要注意的是，通常在ISR中，可能会有人问到为什么有时候副本不在ISR中，这其实也就是上面说的Leader和Follower不同步的情况，为什么我们前面说，短暂的不同步我们可以关注，但是长时间的不同步，我们需要介入排查了，因为ISR里的副本后面都是通过replica.lag.time.max.ms，即Follower副本的LEO落后Leader LEO的时间是否超过阈值来决定副本是否在ISR内部的。


### 11、Kafka集群中保留期的目的是什么？
### 12、ISR在Kafka环境中代表什么？
### 13、怎么解决rebalance中遇到的问题呢？
### 14、：1,2,4,7,8,9,10Apache Kafka对于有经验的人的面试
### 15、消费者如何不自动提交偏移量，由应用提交？
### 16、Kafka 的设计时什么样的呢？
### 17、：41, 42, 43, 44, 45, 47, 49Apache Kafka对于有经验的人的面试
### 18、Kafka 高效文件存储设计特点：
### 19、：21, 23, 25, 26, 27, 28, 29, 30Apache Kafka对于有经验的人的面试
### 20、Kafka 中 Consumer Group 是什么概念？
### 21、3.不支持通配符主题选择4.速度###
### 22、如何估算Kafka集群的机器数量？
### 23、什么情况下一个 Broker 会从ISR中踢出去?
### 24、Kafka中的 ISR、AR 又代表什么？ISR 的伸缩又指什么？
### 25、什么是生产者？
### 26、解释生产者是什么？
### 27、没有ZooKeeper可以使用Kafka吗？
### 28、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
