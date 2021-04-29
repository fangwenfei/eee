# RabbitMQ最新2021年面试题，高级面试题及附答案解析

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、如何避免消息重复投递或重复消费?

在消息生产时，MQ内部针对每条生产者发送的消息生成一个`inner-msg-id`，作为去重和幂等的依据（消息投递失败并重传），避免重复的消息进入队列；在消息消费时，要求消息体中必须要有一个`bizId`（对于同一业务全局唯一，如支付ID、订单ID、帖子ID等）作为去重和幂等的依据，避免同一条消息被重复消费。

这个问题针对业务场景来答分以下几点：

**1、** 拿到这个消息做数据库的insert操作。然后给这个消息做一个唯一主键，那么就算出现重复消费的情况，就会导致主键冲突，避免数据库出现脏数据。

**2、** 拿到这个消息做Redis的set的操作，因为你无论set几次结果都是一样的，set操作本来就算幂等操作。

**3、** 如果上面两种情况还不行。准备一个第三方介质,来做消费记录。以Redis为例，给消息分配一个全局id，只要消费过该消息，将<id,message>以K-V形式写入Redis。那消费者开始消费前，先去Redis中查询有没消费记录即可。


### 2、Broker服务节点？

Broker可以看做RabbitMQ的服务节点。一般请下一个Broker可以看做一个RabbitMQ服务器。


### 3、routing_key 和 binding_key 的最大长度是多少？

255 字节。


### 4、RabbitMQ消息确认过程？

1.
消费者收到的每一条消息都必须进行确认（自动确认和自行确认）

2.
消费者在声明队列时，可以置顶autoAck参数，当autoAck = false时，RabbitMQ会等待消费者显式发送回 ack 信号后才从内存（和磁盘，如果是持久化消息的话）中删除消息，否则RabbitMQ会在队列中消息被消费后立即删除它。

3.
采用消息确认机制后，只要使 autoAck = false，消费者就有足够的时间处理消息（任务），不用担心处理消息过程中消费者进程挂掉后消息丢失的问题，因为RabbitMQ会一直持有消息直到消费者显式调用basicAck为止。

4.
当autoAck = false时，对于RabbitMQ服务器端而言，队列中的消息分成了两部分：一部分是等待投递给消费者的消息；一部分是已经投递给消费者，但是还没有收到消费者ack信号的消息。如果服务器端一直没有收到消费者的ack信号，并且消费此消息的消费者已经断开连接，则服务器端会安排该消息 重新进入队列，等待投递给下一个消费者（也可能还是原来的那个消费者）。

5.
RabbitMQ不会为 ack消息设置超时时间，它判断此消息是否需要重新投递给消费者的唯一依据是消费该消息的消费者连接是否已经断开。这么设计的原因是RabbitMQ允许消费者消费一条消息的时间可以很久很久。



### 5、RabbitMQ事务机制？

**RabbitMQ 客户端中与事务机制相关的方法有三个:**

**1、** channel.txSelect 用于将当前的信道设置成事务模式。

**2、** channel.txCommit 用于提交事务 。

**3、** channel.txRollback 用于事务回滚,如果在事务提交执行之前由于 RabbitMQ 异常崩溃或者其他原因抛出异常,通过txRollback来回滚。


### 6、如何确保消息正确地发送至 RabbitMQ？ 如何确保消息接收方消费了消息？

**发送方确认模式**

**1、** 将信道设置成 confirm 模式（发送方确认模式），则所有在信道上发布的消息都会被指派一个唯一的 ID。

**2、** 一旦消息被投递到目的队列后，或者消息被写入磁盘后（可持久化的消息），信道会发送一个确认给生产者（包含消息唯一 ID）。

**3、** 如果 RabbitMQ 发生内部错误从而导致消息丢失，会发送一条 nack（notacknowledged，未确认）消息。

**4、** 发送方确认模式是异步的，生产者应用程序在等待确认的同时，可以继续发送消息。当确认消息到达生产者应用程序，生产者应用程序的回调方法就会被触发来处理确认消息。

**接收方确认机制**

**1、** 消费者接收每一条消息后都必须进行确认（消息接收和消息确认是两个不同操作）。只有消费者确认了消息，RabbitMQ 才能安全地把消息从队列中删除。

**2、** 这里并没有用到超时机制，RabbitMQ 仅通过 Consumer 的连接中断来确认是否需要重新发送消息。也就是说，只要连接不中断，RabbitMQ 给了 Consumer 足够长的时间来处理消息。保证数据的最终一致性；

**下面罗列几种特殊情况**

**1、** 如果消费者接收到消息，在确认之前断开了连接或取消订阅，RabbitMQ 会认为消息没有被分发，然后重新分发给下一个订阅的消费者。（可能存在消息重复消费的隐患，需要去重）

**2、** 如果消费者接收到消息却没有确认消息，连接也未断开，则 RabbitMQ 认为该消费者繁忙，将不会给该消费者分发更多的消息。


### 7、RabbitMQ 中的 Broker 是指什么？Cluster 又是指什么？

`broker` 是指一个或多个 `erlang node` 的逻辑分组，且 `node` 上运行着 `RabbitMQ` 应用程序。`cluster` 是在 `broker` 的基础之上，增加了 `node` 之间共享元数据的约束。


### 8、RabbitMQ特点?
### 9、什么是MQ
### 10、生产者Producer?
### 11、优先级队列？
### 12、Exchange交换器？
### 13、消费者获取消息的方式？
### 14、AMQP协议3层？
### 15、什么情况下会出现 blackholed 问题？
### 16、死信队列和延迟队列的使用?
### 17、延迟队列？
### 18、RabbitMQ消息是如何路由的？
### 19、RabbitMQ的特点?
### 20、消息怎么路由？
### 21、消息如何分发?
### 22、AMQP协议3层？
### 23、什么是生产者Producer?
### 24、RabbitMQ 包括哪些要素？
### 25、为什么说保证 message 被可靠持久化的条件是 queue 和 exchange 具有durable 属性，同时 message 具有 persistent 属性才行？
### 26、“dead letter”queue 的用途？
### 27、如何确保消息正确地发送至RabbitMQ?
### 28、如何确保消息不丢失？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
