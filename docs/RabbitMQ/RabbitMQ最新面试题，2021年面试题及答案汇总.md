# RabbitMQ最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、消费者接收消息过程？

1.Producer先连接到Broker,建立连接Connection,开启一个信道(Channel)。

2.向Broker请求消费响应的队列中消息，可能会设置响应的回调函数。

3.等待Broker回应并投递相应队列中的消息，接收消息。

4.消费者确认收到的消息,ack。

5.RabbitMq从队列中删除已经确定的消息。

6.关闭信道。

7.关闭连接。


### 2、消费者接收消息过程？

**1、** Producer 先连接到 Broker,建立连接 Connection,开启一个信道(Channel)。

**2、** 向 Broker 请求消费响应的队列中消息，可能会设置响应的回调函数。

**3、** 等待 Broker 回应并投递相应队列中的消息，接收消息。

**4、** 消费者确认收到的消息,ack。

**5、** RabbitMq 从队列中删除已经确定的消息。

**6、** 关闭信道。

**7、** 关闭连接


### 3、如何保证高可用的？RabbitMQ 的集群

RabbitMQ 是比较有代表性的，因为是基于主从（非分布式）做高可用性的，我们就以 RabbitMQ 为例子讲解第一种 MQ 的高可用性怎么实现。RabbitMQ 有三种模式：单机模式、普通集群模式、镜像集群模式。

**1、** 单机模式，就是 Demo 级别的，一般就是你本地启动了玩玩儿的?，没人生产用单机模式

**2、** 普通集群模式：

意思就是在多台机器上启动多个 RabbitMQ 实例，每个机器启动一个。

你创建的 queue，只会放在一个 RabbitMQ 实例上，但是每个实例都同步 queue 的元数据（元数据可以认为是 queue 的一些配置信息，通过元数据，可以找到 queue 所在实例）。你消费的时候，实际上如果连接到了另外一个实例，那么那个实例会从 queue 所在实例上拉取数据过来。这方案主要是提高吞吐量的，就是说让集群中多个节点来服务某个 queue 的读写操作。

**3、** 镜像集群模式：

这种模式，才是所谓的 RabbitMQ 的高可用模式。跟普通集群模式不一样的是，在镜像集群模式下，你创建的 queue，无论元数据还是 queue 里的消息都会存在于多个实例上，就是说，每个 RabbitMQ 节点都有这个 queue 的一个完整镜像，包含 queue 的全部数据的意思。然后每次你写消息到 queue 的时候，都会自动把消息同步到多个实例的 queue 上。RabbitMQ 有很好的管理控制台，就是在后台新增一个策略，这个策略是镜像集群模式的策略，指定的时候是可以要求数据同步到所有节点的，也可以要求同步到指定数量的节点，再次创建 queue 的时候，应用这个策略，就会自动将数据同步到其他的节点上去了。

这样的好处在于，你任何一个机器宕机了，没事儿，其它机器（节点）还包含了这个 queue 的完整数据，别的 consumer 都可以到其它节点上去消费数据。坏处在于，第一，这个性能开销也太大了吧，消息需要同步到所有机器上，导致网络带宽压力和消耗很重！RabbitMQ 一个 queue 的数据都是放在一个节点里的，镜像集群下，也是每个节点都放这个 queue 的完整数据。


### 4、“dead letter”queue 的用途？

当消息被 RabbitMQ server 投递到 consumer 后，但 consumer 却通过 Basic.Reject进行了拒绝时（同时设置 requeue=false），那么该消息会被放入“dead letter”queue 中。该 queue 可用于排查 message 被 reject 或 undeliver 的原因。


### 5、RAM node 和 disk node 的区别？

RAM node 仅将 fabric（即 queue、exchange 和 binding 等 RabbitMQ 基础构件）相关元数据保存到内存中，但 disk node 会在内存和磁盘中均进行存储。RAM node 上唯一会存储到磁盘上的元数据是 cluster 中使用的 disk node 的地址。要求在 RabbitMQ cluster中至少存在一个 disk node 。


### 6、RabbitMQ 中的 Broker 是指什么？Cluster 又是指什么？

`broker` 是指一个或多个 `erlang node` 的逻辑分组，且 `node` 上运行着 `RabbitMQ` 应用程序。`cluster` 是在 `broker` 的基础之上，增加了 `node` 之间共享元数据的约束。


### 7、消费者Consumer?

消费消息，也就是接收消息的一方。

消费者连接到RabbitMQ服务器，并订阅到队列上。消费消息时只消费消息体，丢弃标签。


### 8、RabbitMQ有那些基本概念？

**1、** Broker：简单来说就是消息队列服务器实体

**2、** Exchange：消息交换机，它指定消息按什么规则，路由到哪个队列

**3、** Queue：消息队列载体，每个消息都会被投入到一个或多个队列

**4、** Binding：绑定，它的作用就是把exchange和queue按照路由规则绑定起来

**5、** Routing Key：路由关键字，exchange根据这个关键字进行消息投递

**6、** VHost：vhost 可以理解为虚拟 broker ，即 mini-RabbitMQ server。其内部均含有独立的 queue、exchange 和 binding 等，但最最重要的是，其拥有独立的权限系统，可以做到 vhost 范围的用户控制。当然，从 RabbitMQ 的全局角度，vhost 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 vhost 中）。

**7、** Producer：消息生产者，就是投递消息的程序

**8、** Consumer：消息消费者，就是接受消息的程序

**9、** Channel：消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务

由`Exchange`、`Queue`、`RoutingKey`三个才能决定一个从Exchange到Queue的唯一的线路。


### 9、什么是RabbitMQ？

RabbitMQ是一款开源的，Erlang编写的，消息中间件； 最大的特点就是消费并不需要确保提供方存在,实现了服务之间的高度解耦 可以用它来：解耦、异步、削峰。


### 10、如何确保消息不丢失？

**1、** 消息持久化，当然前提是队列必须持久化

**2、** RabbitMQ确保持久性消息能从服务器重启中恢复的方式是，将它们写入磁盘上的一个持久化日志文件，当发布一条持久性消息到持久交换器上时，Rabbit会在消息提交到日志文件后才发送响应。

**3、** 一旦消费者从持久队列中消费了一条持久化消息，RabbitMQ会在持久化日志中把这条消息标记为等待垃圾收集。如果持久化消息在被消费之前RabbitMQ重启，那么Rabbit会自动重建交换器和队列（以及绑定），并重新发布持久化日志文件中的消息到合适的队列。


### 11、消息传输保证层级？
### 12、使用RabbitMQ有什么好处？
### 13、RabbitMQ消息确认过程？
### 14、能够在地理上分开的不同数据中心使用 RabbitMQ cluster 么？
### 15、AMQP模型的几大组件？
### 16、RabbitMQ概念里的channel、exchange 和 queue是逻辑概念，还是对应着进程实体？作用分别是什么？
### 17、如何保证RabbitMQ消息的可靠传输？
### 18、如何自动删除长时间没有消费的消息？
### 19、为什么要使用rabbitmq
### 20、消息队列有什么缺点
### 21、为什么不应该对所有的 message 都使用持久化机制？
### 22、RabbitMQ topic 主题模式(路由模式的一种)
### 23、消息如何分发？
### 24、消息怎么路由？
### 25、无法被路由的消息去了哪里?
### 26、事务机制？
### 27、消息如何被优先消费？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
