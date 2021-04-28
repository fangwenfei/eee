# Kafka最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、副本长时间不在ISR中，这意味着什么？

意味着 follower 不能像 leader 收集数据那样快速地获取数据。


### 2、：46, 48

### 3、：11,13,14,16,17,18,19Apache Kafka对于有经验的人的面试
### 4、如何保证Kafka顺序消费

这个在我看来是一个伪命题，如果要保证顺序消费为啥要用Kafka呢，只是需要做到异步或者解耦？如果一定要做到顺序消费，肯定是可以的，但是这个浪费资源，因为Kafka就是针对高并发大吞吐量而生，下面说一下顺序消费方案：

**1、** 一个topic、一个partition、一个线程

**2、** 一个topic、n个partition、n个线程，这里生产时需要根据需求将需要排序的数据发送到指定的message key


### 5、说明Kafka的一个最佳特征。

Kafka的最佳特性是“各种各样的用例”。这意味着Kafka能够管理各种各样的用例，这些用例对于数据湖来说非常常见。例如日志聚合、Web活动跟踪等。


### 6、解释术语“主题复制因子”。

在设计Kafka系统时，考虑主题复制是非常重要的。


### 7、Leader总是-1，怎么破？

**1、** 对于有经验的SRE来讲，早期的Kafka版本应该多多少少都遇到过该种情况，通常情况下就是Controller不工作了，导致无法分配leader，那既然知道问题后，解决方案也就很简单了。重启Controller节点上的Kafka进程，让其他节点重新注册Controller角色，但是如上面ZooKeeper的作用，你要知道为什么Controller可以自动注册。

**2、** 当然了，当你知道controller的注册机制后，你也可以说：删除ZooKeeper节点/controller，触发Controller重选举。Controller重选举能够为所有主题分区重刷分区状态，可以有效解决因不一致导致的 Leader 不可用问题。但是，需要注意的是，直接操作ZooKeeper是一件风险很大的操作，就好比在Linux中执行了rm -rf /xxx一样，如果在/和xxx之间不小心多了几个空格，那”恭喜你”，今年白干了。


### 8、：12,15,20


### 9、能说一下leader选举过程吗

我们知道ZooKeeper集群中也有选举机制，是通过Paxos算法，通过不同节点向其他节点发送信息来投票选举出leader，但是Kafka的leader的选举就没有这么复杂了。

Kafka的Leader选举是通过在ZooKeeper上创建/controller临时节点来实现leader选举，并在该节点中写入当前broker的信息 {“version”:1,”brokerid”:1,”timestamp”:”1512018424988”} 利用ZooKeeper的强一致性特性，一个节点只能被一个客户端创建成功，创建成功的broker即为leader，即先到先得原则，leader也就是集群中的controller，负责集群中所有大小事务。当leader和ZooKeeper失去连接时，临时节点会删除，而其他broker会监听该节点的变化，当节点删除时，其他broker会收到事件通知，重新发起leader选举。


### 10、Kafka的哪些场景中使用了零拷贝（Zero Copy）？

**1、** 其实这道题对于SRE来讲，有点超纲了，不过既然Zero Copy是Kafka高性能的保证，我们需要了解它。

**2、** Zero Copy是特别容易被问到的高阶题目。在Kafka中，体现Zero Copy使用场景的地方有两处：基于mmap的索引和日志文件读写所用的TransportLayer。

**3、** 先说第一个。索引都是基于MappedByteBuffer的，也就是让用户态和内核态共享内核态的数据缓冲区，此时，数据不需要复制到用户态空间。不过，mmap虽然避免了不必要的拷贝，但不一定就能保证很高的性能。在不同的操作系统下，mmap的创建和销毁成本可能是不一样的。很高的创建和销毁开销会抵消Zero Copy带来的性能优势。由于这种不确定性，在Kafka中，只有索引应用了mmap，最核心的日志并未使用mmap机制。

**4、** 再说第二个。TransportLayer是Kafka传输层的接口。它的某个实现类使用了FileChannel的transferTo方法。该方法底层使用sendfile实现了Zero Copy。对Kafka而言，如果I/O通道使用普通的PLAINTEXT，那么，Kafka就可以利用Zero Copy特性，直接将页缓存中的数据发送到网卡的Buffer中，避免中间的多次拷贝。相反，如果I/O通道启用了SSL，那么，Kafka便无法利用Zero Copy特性了。


### 11、Java Consumer为什么采用单线程来获取消息？
### 12、解释多租户是什么？
### 13、Kafka Unclean 配置代表什么？会对 spark streaming 消费有什么影响？
### 14、Kafka 与传统消息系统之间有三个关键区别
### 15、生产者和消费者的命令行是什么？
### 16、：3,5,6
### 17、什么是消费者组？
### 18、Kafka能手动删除消息吗？
### 19、简单说一下ack机制
### 20、为什么Kafka不支持读写分离？
### 21、启动Kafka服务器的过程是什么？
### 22、为什么Kafka的复制至关重要？
### 23、为什么Kafka的复制至关重要？
### 24、Zookeeper对于Kafka的作用是什么？
### 25、producer 是否直接将数据发送到 broker 的 leader(主节点)？
### 26、什么是消费者或用户？
### 27、比较传统队列系统与Apache Kafka




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 其他，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://souyunku.lanzous.com/b0alp9b9g "大厂面试题")

## 关注公众号：架构师专栏，回复：“面试题”，即可

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/jiagoushi.png "架构师专栏")](https://souyunku.lanzous.com/b0alp9b9g "架构师专栏")

## 关注公众号：架构师专栏，回复：“面试题”，即可
