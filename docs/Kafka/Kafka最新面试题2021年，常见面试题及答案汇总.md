# Kafka最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、列出所有Apache Kafka业务

Apache Kafka的业务包括：添加和删除Kafka主题如何修改Kafka主题如何关机在Kafka集群之间镜像数据找到消费者的位置扩展您的Kafka群集自动迁移数据退出服务器数据中心


### 2、是什么确保了Kafka中服务器的负载平衡？

由于领导者的主要角色是执行分区的所有读写请求的任务，而追随者被动地复制领导者。因此，在领导者失败时，其中一个追随者接管了领导者的角色。基本上，整个过程可确保服务器的负载平衡。


### 3、解释一些Kafka流实时用例。

《纽约时报》：该公司使用它来实时存储和分发已发布的内容到各种应用程序和系统，使其可供读者使用。基本上，它使用Apache Kafka和Kafka流。Zalando：作为ESB（企业服务总线）作为欧洲领先的在线时尚零售商，Zalando使用Kafka。LINE：基本上，为了相互通信，LINE应用程序使用Apache Kafka作为其服务的中心数据中心。


### 4、Kafka Producer API的作用是什么？

允许应用程序将记录流到一个或多个Kafka主题的API就是我们所说的Producer API。


### 5、ISR在Kafka环境中代表什么？

ISR指的是同步副本。这些通常被分类为一组消息副本，它们被同步为领导者。


### 6、解释术语“Log Anatomy”

我们将日志视为分区。基本上，数据源将消息写入日志。其优点之一是，在任何时候，都有一个或多个消费者从他们选择的日志中读取数据。下面的图表显示，数据源正在写入一个日志，而用户正在以不同的偏移量读取该日志。

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/1/27/0/9_3.png#alt=9%5C_3.png)


### 7、为什么要使用 Kafka？为什么要使用消息队列？

1. 缓冲和削峰：上游数据时有突发流量，下游可能扛不住，或者下游没有足够多的机器来保证冗余，Kafka在中间可以起到一个缓冲的作用，把消息暂存在Kafka中，下游服务就可以按照自己的节奏进行慢慢处理。
2. 解耦和扩展性：项目开始的时候，并不能确定具体需求。消息队列可以作为一个接口层，解耦重要的业务流程。只需要遵守约定，针对数据编程即可获取扩展能力。
3. 冗余：可以采用一对多的方式，一个生产者消息，可以被多个订阅topic的服务消费到，供多个毫无关联的业务使用。
4. 健壮性：消息队列可以堆积请求，所以消费端业务即使短时间死掉，也不会影响主要业务的正常进行。
5. 异步通信：很多时候，用户不想也不需要立即处理消息。消息队列提供了异步处理机制，允许用户把一个消息放入队列，但并不立即处理它。想向队列中放入多少消息就放多少，然后在需要的时候再去处理它们。


### 8、partition 的数据如何保存到硬盘

topic 中的多个 partition 以文件夹的形式保存到 broker，每个分区序号从 0 递增，

且消息有序

Partition 文件下有多个 segment（xxx.index，xxx.log）

segment 文件里的 大小和配置文件大小一致可以根据要求修改 默认为 1g

如果大小大于 1g 时，会滚动一个新的 segment 并且以上一个 segment 最后一条消息的偏移

量命名


### 9、什么是Apache Kafka?

Apache Kafka是一个发布 - 订阅开源消息代理应用程序。这个消息传递应用程序是用“scala”编码的。基本上，这个项目是由Apache软件启动的。Kafka的设计模式主要基于事务日志设计。


### 10、：24, 22


### 11、ZooKeeper在Kafka中的作用是什么？
### 12、3.不支持通配符主题选择4.速度###
### 13、Kafka集群中保留期的目的是什么？
### 14、：1,2,4,7,8,9,10Apache Kafka对于有经验的人的面试
### 15、你能用Kafka做什么？
### 16、Apache Kafka是分布式流处理平台吗？如果是，你能用它做什么？
### 17、什么是消费者组？
### 18、为什么Kafka不支持读写分离？
### 19、Kafka 中 Consumer Group 是什么概念？
### 20、Kafka 与传统MQ消息系统之间有三个关键区别
### 21、consumer是推还是拉？
### 22、简述Follower副本消息同步的完整流程
### 23、启动Kafka服务器的过程是什么？
### 24、解释领导者和追随者的概念。
### 25、消费者故障，出现活锁问题如何解决？
### 26、偏移的作用是什么？
### 27、Kafka中的 ISR、AR 又代表什么？ISR 的伸缩又指什么？
### 28、为什么Kafka的复制至关重要？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
