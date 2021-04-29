# Kafka最新面试题及答案附答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、Kafka Producer如何优化写入速度?

1. 增加线程
2. 提高 batch.size
3. 增加更多 producer 实例
4. 增加 partition 数
5. 设置 acks=-1 时，如果延迟增大：可以增大 num.replica.fetchers（follower 同步数据的线程数）来调解；
6. 跨数据中心的传输：增加 socket 缓冲区设置以及 OS tcp 缓冲区设置。


### 2、在Kafka中，ZooKeeper的作用是什么？

**1、** 这道题，也是我经常会问候选人的题，因为任何分布式系统中虽然都通过一些列的算法去除了传统的关系型数据存储，但是毕竟还是有些数据要存储的，同时分布式系统的特性往往是需要有一些中间人角色来统筹集群。比如我们在整个微服务框架中的Dubbo，它也是需要依赖一些注册中心或配置中心类的中间件的，以及云原生的Kubernetes使用etcd作为整个集群的枢纽。

**2、** 标准答案：目前，Kafka使用ZooKeeper存放集群元数据、成员管理、Controller选举，以及其他一些管理类任务。之后，等KIP-500提案完成后，Kafka将完全不再依赖于ZooKeeper。

**1、** “存放元数据”是指主题分区的所有数据都保存在 ZooKeeper 中，且以它保存的数据为权威，其他 “人” 都要与它保持对齐。

**2、** “成员管理” 是指 Broker 节点的注册、注销以及属性变更，等等。

**3、** “Controller 选举” 是指选举集群 Controller，而其他管理类任务包括但不限于主题删除、参数配置等。

KIP-500 思想，是使用社区自研的基于Raft的共识算法，替代ZooKeeper，实现Controller自选举。



### 3、：3,5,6


### 4、连接器API的作用是什么？

一个允许运行和构建可重用的生产者或消费者的API，将Kafka主题连接到现有的应用程序或数据系统，我们称之为连接器API。


### 5、ZooKeeper在Kafka中的作用是什么？

Apache Kafka是一个使用Zookeeper构建的分布式系统。虽然，Zookeeper的主要作用是在集群中的不同节点之间建立协调。但是，如果任何节点失败，我们还使用Zookeeper从先前提交的偏移量中恢复，因为它做周期性提交偏移量工作。


### 6、解释一些Kafka流实时用例。

《纽约时报》：该公司使用它来实时存储和分发已发布的内容到各种应用程序和系统，使其可供读者使用。基本上，它使用Apache Kafka和Kafka流。Zalando：作为ESB（企业服务总线）作为欧洲领先的在线时尚零售商，Zalando使用Kafka。LINE：基本上，为了相互通信，LINE应用程序使用Apache Kafka作为其服务的中心数据中心。


### 7、Kafka中有哪几个组件?

1. 主题(Topic)：Kafka主题是一堆或一组消息。
2. 生产者(Producer)：在Kafka，生产者通信以及向Kafka主题消息。
3. 消费者(Consumer)：Kafka消费者订阅了一个主题，并且还从主题中读取和处理消息。
4. 经纪人(Brokers)：在管理主题中的消息存储时，我们使用Kafka Brokers。


### 8、什么是复制工具及其类型？

为了增强持久性和更高的可用性，这里提供了复制工具。其类型为创建主题工具列表主题工具添加分区工具


### 9、ISR在Kafka环境中代表什么？

ISR指的是同步副本。这些通常被分类为一组消息副本，它们被同步为领导者。


### 10、启动Kafka服务器的过程是什么？

初始化ZooKeeper服务器是非常重要的一步，因为Kafka使用ZooKeeper，所以启动Kafka服务器的过程是：要启动ZooKeeper服务器：>bin/zooKeeper-server-start.sh config/zooKeeper.properties接下来，启动Kafka服务器：>bin/Kafka-server-start.sh config/server.properties


### 11、说明Kafka的一个最佳特征。
### 12、Kafka 新建的分区会在哪个目录下创建
### 13、Kafka系统工具有哪些类型？
### 14、Leader和Follower的概念是什么？
### 15、partition 的数据如何保存到硬盘
### 16、解释Kafka可以接收的消息最大为多少？
### 17、消费者负载均衡策略
### 18、什么是多租户？
### 19、如何设置Kafka能接收的最大消息的大小？
### 20、Leader总是-1，怎么破？
### 21、消息队列的作用
### 22、解释下Kafka中位移（offset）的作用
### 23、数据传输的事物定义有哪三种？
### 24、解释领导者和追随者的概念。
### 25、kafaka 生产数据时数据的分组策略
### 26、如何调优Kafka？
### 27、系统工具有哪些类型？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
