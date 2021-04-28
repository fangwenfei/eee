# Kafka最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、Kafka中有哪几个组件?

主题：Kafka主题是一堆或一组消息。

生产者：在Kafka，生产者发布通信以及向Kafka主题发布消息。

消费者：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。

经纪人：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 2、3.不支持通配符主题选择4.速度###


### 3、Kafka提供的保证是什么？

他们是生产者向特定主题分区发送的消息的顺序相同。此外，消费者实例按照它们存储在日志中的顺序查看记录。此外，即使不丢失任何提交给日志的记录，我们也可以容忍最多N-1个服务器故障。Apache Kafka对于新手的面试
### 4、讲一讲Kafka的ack的三种机制

request.required.acks有三个值 0 1 -1(all)

0:生产者不会等待broker的ack，这个延迟最低但是存储的保证最弱当server挂掉的时候就会丢数据。

1：服务端会等待ack值 leader副本确认接收到消息后发送ack但是如果leader挂掉后他不确保是否复制完成新leader也会导致数据丢失。

-1(all)：服务端会等所有的follower的副本受到数据后才会受到leader发出的ack，这样数据不会丢失


### 5、如何控制消费的位置

Kafka使用seek(TopicPartition, long)指定新的消费位置。用于查找服务器保留的最早和最新的offset的特殊的方法也可用（seekToBeginning(Collection) 和 seekToEnd(Collection)）


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


### 7、Leader和Follower的概念是什么？

在Kafka的每个分区中，都有一个服务器充当leader，0到多个服务器充当follower的角色。


### 8、如何保证Kafka顺序消费

这个在我看来是一个伪命题，如果要保证顺序消费为啥要用Kafka呢，只是需要做到异步或者解耦？如果一定要做到顺序消费，肯定是可以的，但是这个浪费资源，因为Kafka就是针对高并发大吞吐量而生，下面说一下顺序消费方案：

**1、** 一个topic、一个partition、一个线程

**2、** 一个topic、n个partition、n个线程，这里生产时需要根据需求将需要排序的数据发送到指定的message key


### 9、解释流API的作用？

一种允许应用程序充当流处理器的API，它还使用一个或多个主题的输入流，并生成一个输出流到一个或多个输出主题，此外，有效地将输入流转换为输出流，我们称之为流API。


### 10、如果副本长时间不在ISR中，这意味着什么？

简单地说，这意味着跟随者不能像领导者收集数据那样快速地获取数据。


### 11、：11,13,14,16,17,18,19Apache Kafka对于有经验的人的面试
### 12、Kafka 新建的分区会在哪个目录下创建
### 13、ZooKeeper在Kafka中的作用是什么？
### 14、解释Kafka可以接收的消息最大为多少？
### 15、Kafka 的消费者如何消费数据
### 16、生产者中，什么情况下会发生 QueueFullException？
### 17、流API的作用是什么？
### 18、Kafka中的数据日志是什么？
### 19、Controller发生网络分区（Network Partitioning）时，Kafka会怎么样？
### 20、传统的消息传递方法有哪些类型？
### 21、Kafka和Flume之间的主要区别是什么？
### 22、什么是消费者或用户？
### 23、Kafka能手动删除消息吗？
### 24、：12,15,20
### 25、Kafka中的 Broker 是干什么的？
### 26、消息队列的作用
### 27、偏移的作用是什么？
### 28、什么是复制工具及其类型？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
