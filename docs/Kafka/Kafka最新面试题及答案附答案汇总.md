# Kafka最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafa consumer 是否可以消费指定分区消息？

Kafa consumer 消费消息时，向 broker 发出"fetch"请求去消费特定分区的消息，consumer

指定消息在日志中的偏移量（offset），就可以消费从这个位置开始的消息，customer 拥有

了 offset 的控制权，可以向后回滚去重新消费之前的消息，这是很有意义的


### 2、为什么Kafka的复制至关重要？

由于复制，我们可以确保发布的消息不会丢失，并且可以在发生任何机器错误、程序错误或频繁的软件升级时使用。


### 3、没有zookeeper可以使用Kafka吗？

绕过Zookeeper并直接连接到Kafka服务器是不可以的，所以答案是否定的。如果以某种方式，使ZooKeeper关闭，则无法为任何客户端请求提供服务。


### 4、说明Kafka的一个最佳特征。

Kafka的最佳特性是“各种各样的用例”。这意味着Kafka能够管理各种各样的用例，这些用例对于数据湖来说非常常见。例如日志聚合、Web活动跟踪等。


### 5、Kafka 存储在硬盘上的消息格式是什么？

消息由一个固定长度的头部和可变长度的字节数组组成。头部包含了一个版本号和 CRC32

校验码。

**1、** 消息长度: 4 bytes (value: 1+4+n)

**2、** 版本号: 1 byte

**3、** CRC 校验码: 4 bytes

**4、** 具体的消息: n bytes


### 6、在Kafka中，ZooKeeper的作用是什么？

**1、** 这道题，也是我经常会问候选人的题，因为任何分布式系统中虽然都通过一些列的算法去除了传统的关系型数据存储，但是毕竟还是有些数据要存储的，同时分布式系统的特性往往是需要有一些中间人角色来统筹集群。比如我们在整个微服务框架中的Dubbo，它也是需要依赖一些注册中心或配置中心类的中间件的，以及云原生的Kubernetes使用etcd作为整个集群的枢纽。

**2、** 标准答案：目前，Kafka使用ZooKeeper存放集群元数据、成员管理、Controller选举，以及其他一些管理类任务。之后，等KIP-500提案完成后，Kafka将完全不再依赖于ZooKeeper。

**1、** “存放元数据”是指主题分区的所有数据都保存在 ZooKeeper 中，且以它保存的数据为权威，其他 “人” 都要与它保持对齐。

**2、** “成员管理” 是指 Broker 节点的注册、注销以及属性变更，等等。

**3、** “Controller 选举” 是指选举集群 Controller，而其他管理类任务包括但不限于主题删除、参数配置等。

KIP-500 思想，是使用社区自研的基于Raft的共识算法，替代ZooKeeper，实现Controller自选举。



### 7、能简单说一下rebalance过程吗？

主要的流程如下：

发送GCR请求寻找Coordinator：这个过程主要会向集群中负载最小的broker发起请求，等待成功返回后，那么该Broker将作为Coordinator，尝试连接该Coordinator

发送JGR请求加入该组：当成功找到Coordinator后，那么就要发起加入group的请求，表示该consumer是该组的成员，Coordinator会接收到该请求，会给集群分配一个Leader（通常是第一个），让其负责partition的分配

发送SGR请求：JGR请求成功后，如果发现当前Consumer是leader，那么会进行partition的分配，并发起SGR请求将分配结果发送给Coordinator;如果不是leader，那么也会发起SGR请求，不过分配结果为空


### 8、：41, 42, 43, 44, 45, 47, 49Apache Kafka对于有经验的人的面试
### 9、partition 的数据如何保存到硬盘

topic 中的多个 partition 以文件夹的形式保存到 broker，每个分区序号从 0 递增，

且消息有序

Partition 文件下有多个 segment（xxx.index，xxx.log）

segment 文件里的 大小和配置文件大小一致可以根据要求修改 默认为 1g

如果大小大于 1g 时，会滚动一个新的 segment 并且以上一个 segment 最后一条消息的偏移

量命名


### 10、消费者如何不自动提交偏移量，由应用提交？

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


### 11、简述Follower副本消息同步的完整流程
### 12、Kafka中有哪几个组件?
### 13、你能用Kafka做什么？
### 14、为什么要使用 Kafka？为什么要使用消息队列？
### 15、Kafka的高可用机制是什么？
### 16、如何控制消费的位置
### 17、解释偏移的作用。
### 18、Controller发生网络分区（Network Partitioning）时，Kafka会怎么样？
### 19、Kafka 的设计时什么样的呢？
### 20、LEO、LSO、AR、ISR、HW都表示什么含义？
### 21、为什么要使用Apache Kafka集群？
### 22、：21, 23, 25, 26, 27, 28, 29, 30Apache Kafka对于有经验的人的面试
### 23、解释下Kafka中位移（offset）的作用
### 24、Kafka的优点有那些？
### 25、解释Apache Kafka用例？
### 26、系统工具有哪些类型？
### 27、Kafka可以接收的消息最大为多少？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
