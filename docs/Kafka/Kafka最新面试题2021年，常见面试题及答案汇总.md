# Kafka最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、副本和 ISR 扮演什么角色？

基本上，复制日志的节点列表就是副本。特别是对于特定的分区。但是，无论他们是否扮演leader的角色，他们都是如此。此外，ISR指的是同步副本。在定义ISR时，它是一组与leader同步的消息副本。


### 2、传统的消息传递方法有哪些类型？

基本上，传统的消息传递方法有两种，如：排队：这是一种消费者池可以从服务器读取消息并且每条消息转到其中一个消息的方法。发布-订阅：在发布-订阅中，消息被广播给所有消费者。


### 3、讲一讲Kafka的ack的三种机制

request.required.acks有三个值 0 1 -1(all)

0:生产者不会等待broker的ack，这个延迟最低但是存储的保证最弱当server挂掉的时候就会丢数据。

1：服务端会等待ack值 leader副本确认接收到消息后发送ack但是如果leader挂掉后他不确保是否复制完成新leader也会导致数据丢失。

-1(all)：服务端会等所有的follower的副本受到数据后才会受到leader发出的ack，这样数据不会丢失


### 4、简述Follower副本消息同步的完整流程

**1、** 首先，Follower发送FETCH请求给Leader。

**2、** 接着，Leader会读取底层日志文件中的消息数据，再更新它内存中的Follower副本的LEO值，更新为FETCH请求中的fetchOffset值。

**3、** 最后，尝试更新分区高水位值。Follower接收到FETCH响应之后，会把消息写入到底层日志，接着更新LEO和HW值。

**4、** Leader和Follower的HW值更新时机是不同的，Follower的HW更新永远落后于Leader的HW。这种时间上的错配是造成各种不一致的原因。

**5、** 因此，对于消费者而言，消费到的消息永远是所有副本中最小的那个HW。


### 5、Kafka的哪些场景中使用了零拷贝（Zero Copy）？

**1、** 其实这道题对于SRE来讲，有点超纲了，不过既然Zero Copy是Kafka高性能的保证，我们需要了解它。

**2、** Zero Copy是特别容易被问到的高阶题目。在Kafka中，体现Zero Copy使用场景的地方有两处：基于mmap的索引和日志文件读写所用的TransportLayer。

**3、** 先说第一个。索引都是基于MappedByteBuffer的，也就是让用户态和内核态共享内核态的数据缓冲区，此时，数据不需要复制到用户态空间。不过，mmap虽然避免了不必要的拷贝，但不一定就能保证很高的性能。在不同的操作系统下，mmap的创建和销毁成本可能是不一样的。很高的创建和销毁开销会抵消Zero Copy带来的性能优势。由于这种不确定性，在Kafka中，只有索引应用了mmap，最核心的日志并未使用mmap机制。

**4、** 再说第二个。TransportLayer是Kafka传输层的接口。它的某个实现类使用了FileChannel的transferTo方法。该方法底层使用sendfile实现了Zero Copy。对Kafka而言，如果I/O通道使用普通的PLAINTEXT，那么，Kafka就可以利用Zero Copy特性，直接将页缓存中的数据发送到网卡的Buffer中，避免中间的多次拷贝。相反，如果I/O通道启用了SSL，那么，Kafka便无法利用Zero Copy特性了。


### 6、Kafka流的特点。

Kafka流的一些最佳功能是Kafka Streams具有高度可扩展性和容错性。Kafka部署到容器，VM，裸机，云。我们可以说，Kafka流对于小型，中型和大型用例同样可行。此外，它完全与Kafka安全集成。编写标准Java应用程序。完全一次处理语义。而且，不需要单独的处理集群。


### 7、Kafka能手动删除消息吗？

**1、** Kafka不需要用户手动删除消息。它本身提供了留存策略，能够自动删除过期消息。当然，它是支持手动删除消息的。

**2、** 对于设置了Key且参数cleanup.policy=compact的主题而言，我们可以构造一条 的消息发送给Broker，依靠Log Cleaner组件提供的功能删除掉该 Key 的消息。

**3、** 对于普通主题而言，我们可以使用Kafka-delete-records命令，或编写程序调用Admin.deleteRecords方法来删除消息。这两种方法殊途同归，底层都是调用Admin的deleteRecords方法，通过将分区Log Start Offset值抬高的方式间接删除消息。


### 8、偏移的作用是什么？

给分区中的消息提供了一个顺序ID号，我们称之为偏移量。因此，为了唯一地识别分区中的每条消息，我们使用这些偏移量。


### 9、Kafka系统工具有哪些类型？

**1、** Kafka迁移工具：它有助于将代理从一个版本迁移到另一个版本。

**2、** Mirror Maker：Mirror Maker工具有助于将一个Kafka集群的镜像提供给另一个。

**3、** 消费者检查:对于指定的主题集和消费者组，它显示主题，分区，所有者。


### 10、LEO、LSO、AR、ISR、HW都表示什么含义？

讲真，我不认为这是炫技的题目，特别是作为SRE来讲，对于一个开源软件的原理以及概念的理解，是非常重要的。

**1、** LEO（Log End Offset）：日志末端位移值或末端偏移量，表示日志下一条待插入消息的位移值。举个例子，如果日志有10条消息，位移值从0开始，那么，第10条消息的位移值就是9。此时，LEO = 10。

**2、** LSO（Log Stable Offset）：这是Kafka事务的概念。如果你没有使用到事务，那么这个值不存在（其实也不是不存在，只是设置成一个无意义的值）。该值控制了事务型消费者能够看到的消息范围。它经常与Log Start Offset，即日志起始位移值相混淆，因为有些人将后者缩写成LSO，这是不对的。在Kafka中，LSO就是指代Log Stable Offset。

**3、** AR（Assigned Replicas）：AR是主题被创建后，分区创建时被分配的副本集合，副本个数由副本因子决定。

**4、** ISR（In-Sync Replicas）：Kafka中特别重要的概念，指代的是AR中那些与Leader保持同步的副本集合。在AR中的副本可能不在ISR中，但Leader副本天然就包含在ISR中。

**5、** HW（High watermark）：高水位值，这是控制消费者可读取消息范围的重要字段。一个普通消费者只能“看到”Leader副本上介于Log Start Offset和HW（不含）之间的所有消息。水位以上的消息是对消费者不可见的。

需要注意的是，通常在ISR中，可能会有人问到为什么有时候副本不在ISR中，这其实也就是上面说的Leader和Follower不同步的情况，为什么我们前面说，短暂的不同步我们可以关注，但是长时间的不同步，我们需要介入排查了，因为ISR里的副本后面都是通过replica.lag.time.max.ms，即Follower副本的LEO落后Leader LEO的时间是否超过阈值来决定副本是否在ISR内部的。


### 11、：24, 22
### 12、数据有序
### 13、Kafka中有哪几个组件?
### 14、ZooKeeper在Kafka中的作用是什么？
### 15、没有ZooKeeper可以使用Kafka吗？
### 16、Kafka可以接收的消息最大为多少？
### 17、解释如何调整Kafka以获得最佳性能。
### 18、Kafka 如何判断节点是否存活
### 19、Controller发生网络分区（Network Partitioning）时，Kafka会怎么样？
### 20、什么是消费者组？
### 21、什么是消费者或用户？
### 22、Kafka 与传统消息系统之间有三个关键区别
### 23、解释偏移的作用。
### 24、Kafka中有哪几个组件?
### 25、启动Kafka服务器的过程是什么？
### 26、Apache Kafka是什么？
### 27、没有zookeeper可以使用Kafka吗？
### 28、如何调优Kafka？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
