# Kafka最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、消费者如何不自动提交偏移量，由应用提交？

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


### 2、Kafka Producer API的作用是什么？

允许应用程序将记录流到一个或多个Kafka主题的API就是我们所说的Producer API。


### 3、：46, 48

### 4、Kafka可以接收的消息最大为多少？

Kafka可以接收的最大消息大小约为1000000字节。


### 5、Kafka 中的消息是否会丢失和重复消费？

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


### 6、Leader总是-1，怎么破？

**1、** 对于有经验的SRE来讲，早期的Kafka版本应该多多少少都遇到过该种情况，通常情况下就是Controller不工作了，导致无法分配leader，那既然知道问题后，解决方案也就很简单了。重启Controller节点上的Kafka进程，让其他节点重新注册Controller角色，但是如上面ZooKeeper的作用，你要知道为什么Controller可以自动注册。

**2、** 当然了，当你知道controller的注册机制后，你也可以说：删除ZooKeeper节点/controller，触发Controller重选举。Controller重选举能够为所有主题分区重刷分区状态，可以有效解决因不一致导致的 Leader 不可用问题。但是，需要注意的是，直接操作ZooKeeper是一件风险很大的操作，就好比在Linux中执行了rm -rf /xxx一样，如果在/和xxx之间不小心多了几个空格，那”恭喜你”，今年白干了。


### 7、：24, 22


### 8、Rebalance有什么影响
### 9、Kafka Unclean 配置代表什么？会对 spark streaming 消费有什么影响？
### 10、如果副本长时间不在ISR中，这意味着什么？
### 11、数据传输的事务定义有哪三种？
### 12、Kafka 的 ack 机制
### 13、什么是生产者？
### 14、Kafka 与传统MQ消息系统之间有三个关键区别
### 15、Java Consumer为什么采用单线程来获取消息？
### 16、Kafka 的设计时什么样的呢？
### 17、Kafa consumer 是否可以消费指定分区消息？
### 18、Kafka和Flume之间的主要区别是什么？
### 19、：21, 23, 25, 26, 27, 28, 29, 30Apache Kafka对于有经验的人的面试
### 20、Kafka能手动删除消息吗？
### 21、Kafka的message格式是什么？
### 22、消息队列的作用
### 23、副本和 ISR 扮演什么角色？
### 24、流API的作用是什么？
### 25、解释术语“Log Anatomy”
### 26、没有zookeeper可以使用Kafka吗？
### 27、为什么要使用Apache Kafka集群？
### 28、在生产者中，何时发生QueueFullException？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
