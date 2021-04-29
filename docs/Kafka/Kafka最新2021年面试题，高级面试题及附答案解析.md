# Kafka最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka中有哪几个组件?

1. 主题(Topic)：Kafka主题是一堆或一组消息。
2. 生产者(Producer)：在Kafka，生产者通信以及向Kafka主题消息。
3. 消费者(Consumer)：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。
4. 经纪人(Brokers)：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 2、Apache Kafka的缺陷

Kafka的局限性是：1.没有完整的监控工具集2.消息调整的
### 3、解释Kafka Producer API的作用。

允许应用程序将记录流发布到一个或多个Kafka主题的API就是我们所说的Producer API。


### 4、生产者和消费者的命令行是什么？

**生产者在主题上发布消息：**

**1、** bin/Kafka-console-producer.sh --broker-list 192.168.43.49:9092 --topic Hello-Kafka

**2、** 注意这里的IP是server.properties中的listeners的配置。接下来每个新行就是输入一条新消息。

**3、** 消费者接受消息：

**4、** bin/Kafka-console-consumer.sh --zookeeper localhost:2181 --topic Hello-Kafka --from-beginning


### 5、Broker的Heap Size如何设置？

**1、** 其实对于SRE还是送分题，因为目前来讲大部分公司的业务系统都是使用Java开发，因此SRE对于基本的JVM相关的参数应该至少都是非常了解的，核心就在于JVM的配置以及GC相关的知识。

**2、** 标准答案：任何Java进程JVM堆大小的设置都需要仔细地进行考量和测试。一个常见的做法是，以默认的初始JVM堆大小运行程序，当系统达到稳定状态后，手动触发一次Full GC，然后通过JVM工具查看GC后的存活对象大小。之后，将堆大小设置成存活对象总大小的1.5~2倍。对于Kafka而言，这个方法也是适用的。不过，业界有个最佳实践，那就是将Broker的Heap Size固定为6GB。经过很多公司的验证，这个大小是足够且良好的。


### 6、什么是Kafka中的地域复制？

对于我们的集群，Kafka MirrorMaker提供地理复制。基本上，消息是通过MirrorMaker跨多个数据中心或云区域复制的。因此，它可以在主动/被动场景中用于备份和恢复；也可以将数据放在离用户更近的位置，或者支持数据位置要求。


### 7、Kafka 存储在硬盘上的消息格式是什么？

消息由一个固定长度的头部和可变长度的字节数组组成。头部包含了一个版本号和 CRC32

校验码。

**1、** 消息长度: 4 bytes (value: 1+4+n)

**2、** 版本号: 1 byte

**3、** CRC 校验码: 4 bytes

**4、** 具体的消息: n bytes


### 8、副本和ISR扮演什么角色？
### 9、列出所有Apache Kafka业务
### 10、3.它还可以在记录进入时对其进行处理。Apache Kafka对于新手的面试
### 11、什么是Apache Kafka?
### 12、Controller发生网络分区（Network Partitioning）时，Kafka会怎么样？
### 13、简述Follower副本消息同步的完整流程
### 14、当ack为-1时，什么情况下，Leader 认为一条消息 Commit了？
### 15、解释如何调整Kafka以获得最佳性能。
### 16、：3,5,6
### 17、Kafka的高可用机制是什么？
### 18、连接器API的作用是什么？
### 19、Kafka中的数据日志是什么？
### 20、：41, 42, 43, 44, 45, 47, 49Apache Kafka对于有经验的人的面试
### 21、Kafka为何这么快
### 22、Zookeeper对于Kafka的作用是什么？
### 23、：11,13,14,16,17,18,19Apache Kafka对于有经验的人的面试
### 24、能简单说一下rebalance过程吗？
### 25、怎么解决rebalance中遇到的问题呢？
### 26、Kafka Producer 写数据，ACK 为 0，1，-1 时分别代表什么？
### 27、：1,2,4,7,8,9,10Apache Kafka对于有经验的人的面试
### 28、什么是多租户？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
