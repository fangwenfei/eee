# RabbitMQ最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)



### 1、如何保证消息的可靠性投递?

发送方确认模式：将信道设置成confirm模式（发送方确认模式），则所有在信道上的消息都会被指派一个唯一的ID。

一旦消息被投递到目的队列后，或者消息被写入磁盘后（可持久化的消息），信道会发送一个确认给生产者（包含消息唯一ID）。如果RabbitMQ发生内部错误从而导致消息丢失，会发送一条nack（not acknowledged，未确认）消息。

发送方确认模式是异步的，生产者应用程序在等待确认的同时，可以继续发送消息。当确认消息到达生产者应用程序，生产者应用程序的回调方法就会被触发来处理确认消息。

接收方确认机制：消费者接收每一条消息后都必须进行确认（消息接收和消息确认是两个不同操作）。只有消费者确认了消息，RabbitMQ才能安全地把消息从队列中删除。

这里并没有用到超时机制，RabbitMQ仅通过Consumer的连接中断来确认是否需要重新发送消息。也就是说，只要连接不中断，RabbitMQ给了Consumer足够长的时间来处理消息。保证数据的最终一致性；下面罗列几种特殊情况：

如果消费者接收到消息，在确认之前断开了连接或取消订阅，RabbitMQ会认为消息没有被分发，然后重新分发给下一个订阅的消费者。（可能存在消息重复消费的隐患，需要去重）

如果消费者接收到消息却没有确认消息，连接也未断开，则RabbitMQ认为该消费者繁忙，将不会给该消费者分发更多的消息。


### 2、消息基于什么传输？

由于 TCP 连接的创建和销毁开销较大，且并发数受系统资源限制，会造成性能瓶颈。RabbitMQ 使用信道的方式来传输数据。信道是建立在真实的 TCP 连接内的虚拟连接，且每条 TCP 连接上的信道数量没有限制。


### 3、什么是MQ

MQ就是消息队列。是软件和软件进行通信的中间件产品


### 4、发送确认机制？

生产者把信道设置为confirm确认模式,设置后，所有再改信道发布的消息都会被指定一个唯一的ID，一旦消息被投递到所有匹配的队列之后，RabbitMQ就会发送一个确认（Basic.Ack)给生产者（包含消息的唯一ID)，这样生产者就知道消息到达对应的目的地了。


### 5、交换器4种类型？

主要有以下4种。

fanout:把所有发送到该交换器的消息路由到所有与该交换器绑定的队列中。

direct:把消息路由到BindingKey和RoutingKey完全匹配的队列中。

topic:

匹配规则：

RoutingKey 为一个 点号'.': 分隔的字符串。 比如: java.xiaoka.show

BindingKey和RoutingKey一样也是点号“.“分隔的字符串。

BindingKey可使用 _ 和 # 用于做模糊匹配，_匹配一个单词，#匹配多个或者0个

headers:不依赖路由键匹配规则路由消息。是根据发送消息内容中的headers属性进行匹配。性能差，基本用不到。


### 6、rabbitmq 的使用场景

**1、** 服务间异步通信

**2、** 顺序消费

**3、** 定时任务

**4、** 请求削峰


### 7、RabbitMQ基本概念

**1、** Broker： 简单来说就是消息队列服务器实体

**2、** Exchange： 消息交换机，它指定消息按什么规则，路由到哪个队列

**3、** Queue： 消息队列载体，每个消息都会被投入到一个或多个队列

**4、** Binding： 绑定，它的作用就是把exchange和queue按照路由规则绑定起来

**5、** Routing Key： 路由关键字，exchange根据这个关键字进行消息投递

**6、** VHost： vhost 可以理解为虚拟 broker ，即 mini-RabbitMQ server。其内部均含有独立的 queue、exchange 和 binding 等，但最最重要的是，其拥有独立的权限系统，可以做到 vhost 范围的用户控制。当然，从 RabbitMQ 的全局角度，vhost 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 vhost 中）。

**7、** Producer： 消息生产者，就是投递消息的程序

**8、** Consumer： 消息消费者，就是接受消息的程序

**9、** Channel： 消息通道，在客户端的每个连接里，可建立多个channel，每个channel代表一个会话任务

由Exchange、Queue、RoutingKey三个才能决定一个从Exchange到Queue的唯一的线路。


### 8、RabbitMQ simple模式（即最简单的收发模式）

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_4.png#alt=35%5C_4.png)

**1、** 消息产生消息，将消息放入队列

**2、** 消息的消费者(consumer) 监听 消息队列,如果队列中有消息,就消费掉,消息被拿走后,自动从队列中删除(隐患 消息可能没有被消费者正确处理,已经从队列中消失了,造成消息的丢失，这里可以设置成手动的ack,但如果设置成手动ack，处理完后要及时发送ack消息给队列，否则会造成内存溢出)。


### 9、如何确保消息接收方消费了消息?

接收方消息确认机制：消费者接收每一条消息后都必须进行确认（消息接收和消息确认是两个不同操作）。只有消费者确认了消息，`RabbitMQ`才能安全地把消息从队列中删除。这里并没有用到超时机制，`RabbitMQ`仅通过`Consumer`的连接中断来确认是否需要重新发送消息。也就是说，只要连接不中断，`RabbitMQ`给了`Consumer`足够长的时间来处理消息。

下面罗列几种特殊情况：

- 如果消费者接收到消息，在确认之前断开了连接或取消订阅，RabbitMQ会认为消息没有被分发，然后重新分发给下一个订阅的消费者。（ 可能存在消息重复消费的隐患，需要根据bizId去重）
- 如果消费者接收到消息却没有确认消息，连接也未断开，则RabbitMQ认为该消费者繁忙，将不会给该消费者分发更多的消息。


### 10、集群节点类型有几种？

内存节点：保存状态到内存，但持久化的队列和消息还是会保存到磁盘；

磁盘节点：保存状态到内存和磁盘，一个集群中至少需要一个磁盘节点


### 11、Kafka、ActiveMQ、RabbitMQ、RocketMQ 有什么优缺点？
### 12、如何避免消息重复投递或重复消费？
### 13、Basic.Reject 的用法是什么？
### 14、RoutingKey路由键？
### 15、什么是rabbitmq
### 16、MQ的优点
### 17、使用RabbitMQ有什么好处？
### 18、导致的死信的几种原因？
### 19、cluster 中 node 的失效会对 consumer 产生什么影响？若是在 cluster 中创建了mirrored queue ，这时 node 失效会对 consumer 产生什么影响？
### 20、如何保证消息不被重复消费？或者说，如何保证消息消费时的幂等性？
### 21、如何防止出现 blackholed 问题？
### 22、消息如何保证幂等性？
### 23、AMQP是什么?
### 24、消费者某些原因无法处理当前接受的消息如何来拒绝？
### 25、什么是Broker服务节点？
### 26、RabbitMQ 中的 broker 是指什么？cluster 又是指什么？
### 27、RabbitMQ 包括哪些要素？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/?p=67)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/?p=67)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "大厂面试题")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png"大厂面试题")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
