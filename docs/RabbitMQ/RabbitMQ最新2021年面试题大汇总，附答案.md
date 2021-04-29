# RabbitMQ最新2021年面试题大汇总，附答案

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何保证高可用的？RabbitMQ 的集群

RabbitMQ 是比较有代表性的，因为是基于主从（非分布式）做高可用性的，我们就以 RabbitMQ 为例子讲解第一种 MQ 的高可用性怎么实现。RabbitMQ 有三种模式：单机模式、普通集群模式、镜像集群模式。

**1、** 单机模式，就是 Demo 级别的，一般就是你本地启动了玩玩儿的?，没人生产用单机模式

**2、** 普通集群模式：

意思就是在多台机器上启动多个 RabbitMQ 实例，每个机器启动一个。

你创建的 queue，只会放在一个 RabbitMQ 实例上，但是每个实例都同步 queue 的元数据（元数据可以认为是 queue 的一些配置信息，通过元数据，可以找到 queue 所在实例）。你消费的时候，实际上如果连接到了另外一个实例，那么那个实例会从 queue 所在实例上拉取数据过来。这方案主要是提高吞吐量的，就是说让集群中多个节点来服务某个 queue 的读写操作。

**3、** 镜像集群模式：

这种模式，才是所谓的 RabbitMQ 的高可用模式。跟普通集群模式不一样的是，在镜像集群模式下，你创建的 queue，无论元数据还是 queue 里的消息都会存在于多个实例上，就是说，每个 RabbitMQ 节点都有这个 queue 的一个完整镜像，包含 queue 的全部数据的意思。然后每次你写消息到 queue 的时候，都会自动把消息同步到多个实例的 queue 上。RabbitMQ 有很好的管理控制台，就是在后台新增一个策略，这个策略是镜像集群模式的策略，指定的时候是可以要求数据同步到所有节点的，也可以要求同步到指定数量的节点，再次创建 queue 的时候，应用这个策略，就会自动将数据同步到其他的节点上去了。

这样的好处在于，你任何一个机器宕机了，没事儿，其它机器（节点）还包含了这个 queue 的完整数据，别的 consumer 都可以到其它节点上去消费数据。坏处在于，第一，这个性能开销也太大了吧，消息需要同步到所有机器上，导致网络带宽压力和消耗很重！RabbitMQ 一个 queue 的数据都是放在一个节点里的，镜像集群下，也是每个节点都放这个 queue 的完整数据。


### 2、消息如何被优先消费？

生产者

```
Map<String, Object> argss = new HashMap<String, Object>();
argss.put("x-max-priority",10);
```

消费者

```
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
    .priority(5) // 优先级，默认为5，配合队列的 x-max-priority 属性使用
```


### 3、消费者某些原因无法处理当前接受的消息如何来拒绝？

channel.basicNack

channel.basicReject


### 4、RabbitMQ 中的 broker 是指什么？cluster 又是指什么？

broker 是指一个或多个 erlang node 的逻辑分组，且 node 上运行着 RabbitMQ 应用程序。cluster 是在 broker 的基础之上，增加了 node 之间共享元数据的约束。


### 5、消息怎么路由？

**1、** 消息提供方->路由->一至多个队列

**2、** 消息发布到交换器时，消息将拥有一个路由键（routing key），在消息创建时设定。

**3、** 通过队列路由键，可以把队列绑定到交换器上。

**4、** 消息到达交换器后，RabbitMQ会将消息的路由键与队列的路由键进行匹配（针对不同的交换器有不同的路由规则）；

**常用的交换器主要分为一下三种**

**1、** fanout：如果交换器收到消息，将会广播到所有绑定的队列上

**2、** direct：如果路由键完全匹配，消息就被投递到相应的队列

**3、** topic：可以使来自不同源头的消息能够到达同一个队列。 使用topic交换器时，可以使用通配符


### 6、RabbitMQ 概念里的 channel、exchange 和 queue 这些东东是逻辑概念，还是对应着进程实体？这些东东分别起什么作用？

queue 具有自己的 erlang 进程；exchange 内部实现为保存 binding 关系的查找表；channel 是实际进行路由工作的实体，即负责按照 routing_key 将 message 投递给queue 。由 AMQP 协议描述可知，channel 是真实 TCP 连接之上的虚拟连接，所有AMQP 命令都是通过 channel 发送的，且每一个 channel 有唯一的 ID。

一个 channel 只能被单独一个操作系统线程使用，故投递到特定 channel 上的 message 是有顺序的。但一个操作系统线程上允许使用多个 channel 。channel 号为 0 的 channel 用于处理所有对于当前 connection 全局有效的帧，而 1-65535 号 channel 用于处理和特定 channel 相关的帧。AMQP 协议给出的 channel ，其中每一个 channel 运行在一个独立的线程上，多线程共享同一个 socket。


### 7、Queue队列？

Queue:RabbitMQ的内部对象，用于存储消息。多个消费者可以订阅同一队列，这时队列中的消息会被平摊（轮询）给多个消费者进行处理。


### 8、如何保证消息的顺序性?
### 9、RabbitMQ队列结构？
### 10、RabbitMQ publish/subscribe发布订阅(共享资源)
### 11、如何避免消息重复投递或重复消费？
### 12、什么是Broker服务节点？
### 13、什么是Exchange交换器？
### 14、如何保证消息不被重复消费？或者说，如何保证消息消费时的幂等性？
### 15、RabbitMQ topic 主题模式(路由模式的一种)
### 16、生产者消息如何运转？
### 17、能够在地理上分开的不同数据中心使用 RabbitMQ cluster 么？
### 18、为什么不应该对所有的 message 都使用持久化机制？
### 19、消息传输保证层级？
### 20、RabbitMQ work工作模式(资源的竞争)
### 21、RabbitMQ的集群模式有几种？
### 22、如何保证消息的可靠性投递?
### 23、RabbitMQ 什么是信道？
### 24、向不存在的 exchange 发 publish 消息会发生什么？向不存在的 queue 执行consume 动作会发生什么？
### 25、RabbitMQ的工作模式有几种？
### 26、MQ 有哪些常见问题？如何解决这些问题？
### 27、如何自动删除长时间没有消费的消息？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
