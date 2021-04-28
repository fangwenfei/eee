# RabbitMQ最新面试题2021年，常见面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png)



### 1、cluster 中 node 的失效会对 consumer 产生什么影响？若是在 cluster 中创建了mirrored queue ，这时 node 失效会对 consumer 产生什么影响？

若是 consumer 所连接的那个 node 失效（无论该 node 是否为 consumer 所订阅queue 的 owner node），则 consumer 会在发现 TCP 连接断开时，按标准行为执行重连逻辑，并根据“Assume Nothing”原则重建相应的 fabric 即可。

若是失效的 node 为consumer 订阅 queue 的 owner node，则 consumer 只能通过 Consumer CancellationNotification 机制来检测与该 queue 订阅关系的终止，否则会出现傻等却没有任何消息来到的问题。


### 2、你们公司生产环境用的是什么消息中间件？

这个首先你可以说下你们公司选用的是什么消息中间件，比如用的是RabbitMQ，然后可以初步给一些你对不同MQ中间件技术的选型分析。

**举个例子：**

比如说ActiveMQ是老牌的消息中间件，国内很多公司过去运用的还是非常广泛的，功能很强大。

**1、** 但是问题在于没法确认ActiveMQ可以支撑互联网公司的高并发、高负载以及高吞吐的复杂场景，在国内互联网公司落地较少。而且使用较多的是一些传统企业，用ActiveMQ做异步调用和系统解耦。

**2、** 然后你可以说说RabbitMQ，他的好处在于可以支撑高并发、高吞吐、性能很高，同时有非常完善便捷的后台管理界面可以使用。

**3、** 另外，他还支持集群化、高可用部署架构、消息高可靠支持，功能较为完善。

**4、** 而且经过调研，国内各大互联网公司落地大规模RabbitMQ集群支撑自身业务的case较多，国内各种中小型互联网公司使用RabbitMQ的实践也比较多。

**5、** 除此之外，RabbitMQ的开源社区很活跃，较高频率的迭代版本，来修复发现的bug以及进行各种优化，因此综合考虑过后，公司采取了RabbitMQ。

**6、** 但是RabbitMQ也有一点缺陷，就是他自身是基于erlang语言开发的，所以导致较为难以分析里面的源码，也较难进行深层次的源码定制和改造，毕竟需要较为扎实的erlang语言功底才可以。

**7、** 然后可以聊聊RocketMQ，是阿里开源的，经过阿里的生产环境的超高并发、高吞吐的考验，性能卓越，同时还支持分布式事务等特殊场景。

**8、** 而且RocketMQ是基于Java语言开发的，适合深入阅读源码，有需要可以站在源码层面解决线上生产问题，包括源码的二次开发和改造。

**9、** 另外就是Kafka。Kafka提供的消息中间件的功能明显较少一些，相对上述几款MQ中间件要少很多。

**10、** 但是Kafka的优势在于专为超高吞吐量的实时日志采集、实时数据同步、实时数据计算等场景来设计。

**11、** 因此Kafka在大数据领域中配合实时计算技术（比如Spark Streaming、Storm、Flink）使用的较多。但是在传统的MQ中间件使用场景中较少采用。


### 3、如何保证消息的可靠性投递?

发送方确认模式：将信道设置成confirm模式（发送方确认模式），则所有在信道上的消息都会被指派一个唯一的ID。

一旦消息被投递到目的队列后，或者消息被写入磁盘后（可持久化的消息），信道会发送一个确认给生产者（包含消息唯一ID）。如果RabbitMQ发生内部错误从而导致消息丢失，会发送一条nack（not acknowledged，未确认）消息。

发送方确认模式是异步的，生产者应用程序在等待确认的同时，可以继续发送消息。当确认消息到达生产者应用程序，生产者应用程序的回调方法就会被触发来处理确认消息。

接收方确认机制：消费者接收每一条消息后都必须进行确认（消息接收和消息确认是两个不同操作）。只有消费者确认了消息，RabbitMQ才能安全地把消息从队列中删除。

这里并没有用到超时机制，RabbitMQ仅通过Consumer的连接中断来确认是否需要重新发送消息。也就是说，只要连接不中断，RabbitMQ给了Consumer足够长的时间来处理消息。保证数据的最终一致性；下面罗列几种特殊情况：

如果消费者接收到消息，在确认之前断开了连接或取消订阅，RabbitMQ会认为消息没有被分发，然后重新分发给下一个订阅的消费者。（可能存在消息重复消费的隐患，需要去重）

如果消费者接收到消息却没有确认消息，连接也未断开，则RabbitMQ认为该消费者繁忙，将不会给该消费者分发更多的消息。


### 4、多个消费者监听一个队列时，消息如何分发?

轮询: 默认的策略，消费者轮流，平均地接收消息

公平分发: 根据消费者的能力来分发消息，给空闲的消费者发送更多消息

**当消费者有x条消息没有响应ACK时，不再给这个消费者发送消息**

```
channel.basicQos(int x)
```


### 5、RabbitMQ 什么是信道？

信道：是生产者、消费者与RabbitMQ通信的渠道，生产者publish或是消费者subscribe一个队列都是通过信道来通信的。信道是建立在TCP连接上的虚拟连接。就是说RabbitMQ在一条TCP上建立成百上千个信道来达到多个线程处理，这个TCP被多个线程共享，每个线程对应一个信道，信道在RabbitMQ都有一个唯一的ID，保证了信道私有性，对应上唯一的线程使用。

**疑问：为什么不建立多个TCP连接？**

原因是RabbitMQ需要保证性能，系统为每个线程开辟一个TCP是非常消耗性能的，美妙成百上千的建立销毁TCP会严重消耗系统性能；所以RabbitMQ选择建立多个信道（建立在TCP的虚拟连接）连接到RabbitMQ上


### 6、消息如何被优先消费？

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


### 7、routing_key 和 binding_key 的最大长度是多少？

255 字节。


### 8、如何自动删除长时间没有消费的消息？

```
// 通过队列属性设置消息过期时间
Map<String, Object> argss = new HashMap<String, Object>();
argss.put("x-message-ttl",6000);

// 对每条消息设置过期时间
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
    .expiration("10000") // TTL
```


### 9、RoutingKey路由键？

生产者将消息发送给交换器的时候，会指定一个RoutingKey,用来指定这个消息的路由规则，这个RoutingKey需要与交换器类型和绑定键(BindingKey)联合使用才能最终生效。


### 10、RabbitMQ队列结构？

**通常由以下两部分组成：**

rabbit_amqqueue_process：负责协议相关的消息处理，即接收生产者的消息、向消费者交付消息、处理消息的确认(包括生产端的 confirm 和消费端的 ack) 等。

backing_queue：是消息存储的具体形式和引擎，并向 rabbit amqqueue process 提供相关的接口以供调用。


### 11、RabbitMQ消息确认过程？
### 12、消息如何分发？
### 13、什么是Binding绑定？
### 14、使用rabbitmq的场景
### 15、AMQP协议3层？
### 16、消息怎么路由？
### 17、为什么 heavy RPC 的使用场景下不建议采用 disk node ？
### 18、AMQP是什么?
### 19、RabbitMQ的集群模式有几种？
### 20、RabbitMQ事务机制？
### 21、如何保证RabbitMQ消息的可靠传输？
### 22、延迟队列？
### 23、如何保证消息的顺序性?
### 24、为什么说保证 message 被可靠持久化的条件是 queue 和 exchange 具有durable 属性，同时 message 具有 persistent 属性才行？
### 25、如何确保消息正确地发送至 RabbitMQ？ 如何确保消息接收方消费了消息？
### 26、vhost?
### 27、如何防止出现 blackholed 问题？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)

### 一键直达：[https://www.souyunku.com/?p=67](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)


## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
