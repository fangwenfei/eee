# RabbitMQ最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、如何避免消息重复投递或重复消费?

在消息生产时，MQ内部针对每条生产者发送的消息生成一个`inner-msg-id`，作为去重和幂等的依据（消息投递失败并重传），避免重复的消息进入队列；在消息消费时，要求消息体中必须要有一个`bizId`（对于同一业务全局唯一，如支付ID、订单ID、帖子ID等）作为去重和幂等的依据，避免同一条消息被重复消费。

这个问题针对业务场景来答分以下几点：

**1、** 拿到这个消息做数据库的insert操作。然后给这个消息做一个唯一主键，那么就算出现重复消费的情况，就会导致主键冲突，避免数据库出现脏数据。

**2、** 拿到这个消息做Redis的set的操作，因为你无论set几次结果都是一样的，set操作本来就算幂等操作。

**3、** 如果上面两种情况还不行。准备一个第三方介质,来做消费记录。以Redis为例，给消息分配一个全局id，只要消费过该消息，将<id,message>以K-V形式写入Redis。那消费者开始消费前，先去Redis中查询有没消费记录即可。


### 2、什么情况下会出现 blackholed 问题？

blackholed 问题是指，向 exchange 投递了 message ，而由于各种原因导致该message 丢失，但发送者却不知道。可导致 blackholed 的情况：1.向未绑定 queue 的exchange 发送 message；2.exchange 以 binding_key key_A 绑定了 queue queue_A，但向该 exchange 发送 message 使用的 routing_key 却是 key_B。


### 3、什么是生产者Producer?

消息生产者，就是投递消息的一方。

消息一般包含两个部分：`消息体`（payload)和`标签`(Label)。


### 4、AMQP协议3层？

Module Layer:协议最高层，主要定义了一些客户端调用的命令，客户端可以用这些命令实现自己的业务逻辑。

Session Layer:中间层，主要负责客户端命令发送给服务器，再将服务端应答返回客户端，提供可靠性同步机制和错误处理。

TransportLayer:最底层，主要传输二进制数据流，提供帧的处理、信道服用、错误检测和数据表示等。


### 5、为什么要使用rabbitmq

**1、** 在分布式系统下具备异步,削峰,负载均衡等一系列高级功能;

**2、** 拥有持久化的机制，进程消息，队列中的信息也可以保存下来。

**3、** 实现消费者和生产者之间的解耦。

**4、** 对于高并发场景下，利用消息队列可以使得同步访问变为串行访问达到一定量的限流，利于数据库的操作。

5.可以使用消息队列达到异步下单的效果，排队中，后台进行逻辑下单。


### 6、消息如何分发?

若该队列至少有一个消费者订阅，消息将以循环（round-robin）的方式发送给消费者。每条消息只会分发给一个订阅的消费者（前提是消费者能够正常处理消息并进行确认）。


### 7、Binding绑定？

通过绑定将交换器和队列关联起来，一般会指定一个BindingKey,这样RabbitMq就知道如何正确路由消息到队列了。


### 8、如何确保消息正确地发送至RabbitMQ?

RabbitMQ使用发送方确认模式，确保消息正确地发送到RabbitMQ。发送方确认模式：将信道设置成`confirm`模式（发送方确认模式），则所有在信道上的消息都会被指派一个唯一的ID。一旦消息被投递到目的队列后，或者消息被写入磁盘后（可持久化的消息），信道会发送一个确认给生产者（包含消息唯一ID）。如果`RabbitMQ`发生内部错误从而导致消息丢失，会发送一条`nack`（not acknowledged，未确认）消息。发送方确认模式是异步的，生产者应用程序在等待确认的同时，可以继续发送消息。当确认消息到达生产者应用程序，生产者应用程序的回调方法就会被触发来处理确认消息。


### 9、如何确保消息接收方消费了消息?

接收方消息确认机制：消费者接收每一条消息后都必须进行确认（消息接收和消息确认是两个不同操作）。只有消费者确认了消息，`RabbitMQ`才能安全地把消息从队列中删除。这里并没有用到超时机制，`RabbitMQ`仅通过`Consumer`的连接中断来确认是否需要重新发送消息。也就是说，只要连接不中断，`RabbitMQ`给了`Consumer`足够长的时间来处理消息。

下面罗列几种特殊情况：

- 如果消费者接收到消息，在确认之前断开了连接或取消订阅，RabbitMQ会认为消息没有被分发，然后重新分发给下一个订阅的消费者。（ 可能存在消息重复消费的隐患，需要根据bizId去重）
- 如果消费者接收到消息却没有确认消息，连接也未断开，则RabbitMQ认为该消费者繁忙，将不会给该消费者分发更多的消息。


### 10、“dead letter”queue 的用途？

当消息被 RabbitMQ server 投递到 consumer 后，但 consumer 却通过 Basic.Reject进行了拒绝时（同时设置 requeue=false），那么该消息会被放入“dead letter”queue 中。该 queue 可用于排查 message 被 reject 或 undeliver 的原因。


### 11、AMQP模型的几大组件？
### 12、在单 node 系统和多 node 构成的 cluster 系统中声明 queue、exchange ，以及进行 binding 会有什么不同？
### 13、Consumer Cancellation Notification 机制用于什么场景？
### 14、mq的缺点
### 15、rabbitmq的集群
### 16、交换器4种类型？
### 17、生产者消息如何运转？
### 18、RabbitMQ基本概念
### 19、RabbitMQ 允许发送的 message 最大可达多大？
### 20、RabbitMQ 中的 Broker 是指什么？Cluster 又是指什么？
### 21、什么是RoutingKey路由键？
### 22、消费者某些原因无法处理当前接受的消息如何来拒绝？
### 23、RabbitMQ routing路由模式
### 24、RabbitMQ 中的 broker 是指什么？cluster 又是指什么？
### 25、RabbitMQ的特点?
### 26、Queue队列？
### 27、客户端连接到 cluster 中的任意 node 上是否都能正常工作？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
