# RabbitMQ最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、消息如何保证幂等性？

生产者方面：可以对每条消息生成一个msgID，以控制消息重复投递

```
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
porperties.messageId(String.valueOF(UUID.randomUUID()))
```

消费者方面：消息体中必须携带一个业务ID，如银行流水号，消费者可以根据业务ID去重，避免重复消费


### 2、RoutingKey路由键？

生产者将消息发送给交换器的时候，会指定一个RoutingKey,用来指定这个消息的路由规则，这个RoutingKey需要与交换器类型和绑定键(BindingKey)联合使用才能最终生效。


### 3、MQ 有哪些常见问题？如何解决这些问题？

MQ 的常见问题有：

**1、** 消息的顺序问题

**2、** 消息的重复问题

**消息的顺序问题**

消息有序指的是可以按照消息的发送顺序来消费。

假如生产者产生了 2 条消息：M1、M2，假定 M1 发送到 S1，M2 发送到 S2，如果要保证 M1 先于 M2 被消费，怎么做？

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_2.png#alt=35%5C_2.png)

**解决方案：**

**1、** 保证生产者 - MQServer - 消费者是一对一对一的关系

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_3.png#alt=35%5C_3.png)

**缺陷：**

**1、** 并行度就会成为消息系统的瓶颈（吞吐量不够）

**2、** 更多的异常处理，比如：只要消费端出现问题，就会导致整个处理流程阻塞，我们不得不花费更多的精力来解决阻塞的问题。 （2）通过合理的设计或者将问题分解来规避。

**3、** 不关注乱序的应用实际大量存在

**4、** 队列无序并不意味着消息无序 所以从业务层面来保证消息的顺序而不仅仅是依赖于消息系统，是一种更合理的方式。

**消息的重复问题**

造成消息重复的根本原因是：网络不可达。

**1、** 所以解决这个问题的办法就是绕过这个问题。那么问题就变成了：如果消费端收到两条一样的消息，应该怎样处理？

**2、** 消费端处理消息的业务逻辑保持幂等性。只要保持幂等性，不管来多少条重复消息，最后处理的结果都一样。保证每条消息都有唯一编号且保证消息处理成功与去重表的日志同时出现。利用一张日志表来记录已经处理成功的消息的 ID，如果新到的消息 ID 已经在日志表中，那么就不再处理这条消息。


### 4、优先级队列？

优先级高的队列会先被消费。

可以通过x-max-priority参数来实现。

当消费速度大于生产速度且Broker没有堆积的情况下，优先级显得没有意义。


### 5、RabbitMQ如何实现延时队列?

利用TTL（队列的消息存活时间或者消息存活时间），加上死信交换机

```
// 设置属性，消息10秒钟过期
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
.expiration("10000") // TTL

// 指定队列的死信交换机
Map<String,Object> arguments = new HashMap<String,Object>();
arguments.put("x-dead-letter-exchange","DLX_EXCHANGE");
```


### 6、RabbitMQ publish/subscribe发布订阅(共享资源)

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_6.png#alt=35%5C_6.png)

**1、** 每个消费者监听自己的队列；

**2、** 生产者将消息发给broker，由交换机将消息转发到绑定此交换机的每个队列，每个绑定交换机的队列都将接收到消息。


### 7、RabbitMQ的集群模式有几种？

RabbitMQ 是比较有代表性的，因为是基于主从（非分布式）做高可用性的，我们就以 RabbitMQ 为例子讲解第一种 MQ 的高可用性怎么实现。RabbitMQ 有三种模式：`单机模式`、`普通集群模式`、`镜像集群模式`。

**1、** 单机模式，就是 Demo 级别的，一般就是你本地启动了玩玩儿的?，没人生产用单机模式

**2、** 普通模式：以两个节点（rabbit01，rabbit02）为例来进行说明，对于Queue来说，消息实体只存在于其中一个节点rabbit01（或者rabbit02），rabbit01和rabbit02两个节点仅有相同的元数据，即队列结构。当消息进入rabbit01节点的Queue后，consumer从rabbit02节点消费时，RabbitMQ会临时在rabbit01，rabbit02间进行消息传输，把A中的消息实体取出并经过B发送给consumer，所以consumer应尽量连接每一个节点，从中取消息。即对于同一个逻辑队列，要在多个节点建立物理Queue。否则无论consumer连rabbit01或rabbit02，出口总在rabbit01，会产生瓶颈。当rabbit01节点故障后，rabbit02节点无法取到rabbit01节点中还未消费的消息实体。如果做了消息持久化，那么等到rabbit01节点恢复，然后才可被消费。如果没有消息持久化，就会产生消息丢失的现象。

**3、** 镜像模式：把需要的队列做成镜像队列，存在与多个节点属于RabibitMQ的HA方案，该模式解决了普通模式中的问题，其实质和普通模式不同之处在于，消息体会主动在镜像节点间同步，而不是在客户端取数据时临时拉取，该模式带来的副作用也很明显，除了降低系统性能外，如果镜像队列数量过多，加之大量的消息进入，集群内部的网络带宽将会被这种同步通讯大大消耗掉，所以在对可靠性要求比较高的场合中适用


### 8、cluster 中 node 的失效会对 consumer 产生什么影响？若是在 cluster 中创建了mirrored queue ，这时 node 失效会对 consumer 产生什么影响？

若是 consumer 所连接的那个 node 失效（无论该 node 是否为 consumer 所订阅queue 的 owner node），则 consumer 会在发现 TCP 连接断开时，按标准行为执行重连逻辑，并根据“Assume Nothing”原则重建相应的 fabric 即可。

若是失效的 node 为consumer 订阅 queue 的 owner node，则 consumer 只能通过 Consumer CancellationNotification 机制来检测与该 queue 订阅关系的终止，否则会出现傻等却没有任何消息来到的问题。


### 9、如何保证RabbitMQ消息的可靠传输？

消息不可靠的情况可能是消息丢失，劫持等原因；

**丢失可能又分为：**

1. 生产者丢失消息
2. 消息队列丢失消息
3. 消费者丢失消息

**生产者丢失消息：**

1. 从生产者弄丢数据来看，RabbitMQ提供了 transaction 机制 和 confirm 模式 来确保生产者不丢失消息；
2. transaction机制： 发送消息前，开启事务（channel.exSelect()），然后发送消息，如果发送过程中出现异常，事务就会回滚（channel.txRollback()），如果发送成功则提交事务（channel.txCommit()）。
3. confirm模式：一般这种模式居多，一旦channel进入confirm模式，所有在该信道上发布的消息都将会被指派一个唯一的ID（从1开始），一旦消息被投递到所有匹配的队列后；RabbitMQ就会发送一个ACK给生产者（包含消息的唯一ID），这就使得生产者知道消息已经正确到达目的队列了。

如果RabbitMQ没能处理该消息，则会发送一个Nack消息回来，这样可以进行重试操作。

**消息队列丢失消息：**

1. 针对消息队列丢失数据的情况，一般是开启持久化磁盘的配置：
2. 将队列的持久化标识 durable 设置为 true ， 则代表是一个持久的队列，发送消息的时候讲 deliveryMode=2 这样设置以后，即使RabbitMQ挂了，重启后也能恢复数据。

**消费者丢失消息：**

1. 消费者丢失消息一般是因为采用了自动确认消息模式，改为手动确认消息即可。
2. 消费者在收到消息之后，处理消息之前，会自动回复RabbitMQ已收到消息；如果这时候处理消息失败，就会丢失该消息；
3. 解决方案：处理消息成功后，手动回复确认消息。


### 10、导致的死信的几种原因？

**1、** 消息被拒（Basic.Reject /Basic.Nack) 且 requeue = false。

**2、** 消息TTL过期。

**3、** 队列满了，无法再添加。


### 11、交换器4种类型？
### 12、为什么 heavy RPC 的使用场景下不建议采用 disk node ？
### 13、发送确认机制？
### 14、向不存在的 exchange 发 publish 消息会发生什么？向不存在的 queue 执行consume 动作会发生什么？
### 15、什么是rabbitmq
### 16、什么是消费者Consumer?
### 17、如何保证消息的可靠性投递?
### 18、RabbitMQ routing路由模式
### 19、消息怎么路由？
### 20、RabbitMQ消息确认过程？
### 21、生产者Producer?
### 22、什么情况下会出现 blackholed 问题？
### 23、什么是MQ
### 24、消费者某些原因无法处理当前接受的消息如何来拒绝？
### 25、消息基于什么传输？
### 26、RabbitMQ特点?
### 27、消息队列有什么缺点
### 28、什么是Broker服务节点？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
