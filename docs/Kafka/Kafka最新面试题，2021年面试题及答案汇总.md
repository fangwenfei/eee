# Kafka最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、在Kafka集群中保留期的目的是什么？

保留期限保留了Kafka群集中的所有已发布记录。它不会检查它们是否已被消耗。此外，可以通过使用保留期的配置设置来丢弃记录。而且，它可以释放一些空间。


### 2、Kafka的message格式是什么？

一个Kafka的Message由一个**固定长度的header**和一个**变长的消息体body**组成

1. header部分 由一个字节的magic(文件格式)和四个字节的CRC32(用于判断body消息体是否正常)构成。
2. 当magic的值为1的时候，会在magic和crc32之间多一个字节的数据：attributes(保存一些相关属性，比如是否压缩、压缩格式等等);
3. 如果magic的值为0，那么不存在attributes属性
4. body部分 由N个字节构成的一个消息体，包含了具体的key/value消息


### 3、Kafka的高可用机制是什么？

这个问题比较系统，回答出Kafka的系统特点，leader和follower的关系，消息读写的顺序即可。

[https://www.cnblogs.com/qingyunzong/p/9004703.html](https://www.cnblogs.com/qingyunzong/p/9004703.html)

[https://www.tuicool.com/articles/BNRza2E](https://www.tuicool.com/articles/BNRza2E)

[https://yq.aliyun.com/articles/64703](https://yq.aliyun.com/articles/64703)


### 4、3.不支持通配符主题选择4.速度###


### 5、Kafka中有哪几个组件?

主题：Kafka主题是一堆或一组消息。

生产者：在Kafka，生产者发布通信以及向Kafka主题发布消息。

消费者：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。

经纪人：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 6、如果副本长时间不在ISR中，这意味着什么？

简单地说，这意味着跟随者不能像领导者收集数据那样快速地获取数据。


### 7、比较RabbitMQ与Apache Kafka

Apache Kafka的另一个选择是RabbitMQ。那么，让我们比较两者：功能Apache Kafka– Kafka是分布式的、持久的和高度可用的，这里共享和复制数据RabbitMQ中没有此类功能性能速度Apache Kafka–达到每秒100000条消息。RabbitMQ–每秒20000条消息。


### 8、consumer_offsets是做什么用的？

这是一个内部主题，主要用于存储消费者的偏移量，以及消费者的元数据信息（消费者实例，消费者id等等）

需要注意的是：Kafka的GroupCoordinator组件提供对该主题完整的管理功能，包括该主题的创建、写入、读取和Leader维护等。


### 9、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？

毫无疑问，Kafka是一个流处理平台。它可以帮助：1.轻松推送记录2.可以存储大量记录，而不会出现任何存储
### 10、Kafka和Flume之间的主要区别是什么？

**工具类型**

Apache Kafka 是面向多个生产商和消费者的通用工具。

Apache Flume 是特定应用程序的专用工具。

**复制功能**

Apache Kafka 可以复制事件；

Apache Flume 不复制事件。


### 11、Kafka的流处理是什么意思？
### 12、连接器API的作用是什么？
### 13、什么是消费者或用户？
### 14、LEO、LSO、AR、ISR、HW都表示什么含义？
### 15、Kafka 中的消息是否会丢失和重复消费？
### 16、数据有序
### 17、Kafka的哪些场景中使用了零拷贝（Zero Copy）？
### 18、Kafka 的设计时什么样的呢？
### 19、当ack为-1时，什么情况下，Leader 认为一条消息 Commit了？
### 20、Kafka 中 Consumer Group 是什么概念？
### 21、列出所有Apache Kafka业务
### 22、3.它还可以在记录进入时对其进行处理。Apache Kafka对于新手的面试
### 23、Kafka为何这么快
### 24、Kafka 与传统MQ消息系统之间有三个关键区别
### 25、Kafka中的 Broker 是干什么的？
### 26、：21, 23, 25, 26, 27, 28, 29, 30Apache Kafka对于有经验的人的面试
### 27、你能用Kafka做什么？
### 28、Kafka 中是怎么体现消息顺序性的？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
