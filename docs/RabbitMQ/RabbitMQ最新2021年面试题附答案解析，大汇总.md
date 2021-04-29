# RabbitMQ最新2021年面试题附答案解析，大汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、消息如何保证幂等性？

生产者方面：可以对每条消息生成一个msgID，以控制消息重复投递

```
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
porperties.messageId(String.valueOF(UUID.randomUUID()))
```

消费者方面：消息体中必须携带一个业务ID，如银行流水号，消费者可以根据业务ID去重，避免重复消费


### 2、vhost 是什么? 起什么作用?

`vhost` 可以理解为虚拟 `broker` ，即 `mini-RabbitMQ server`。其内部均含有独立的 `queue`、`exchange` 和 `binding` 等，但最最重要的是，其拥有独立的权限系统，可以做到 `vhost` 范围的用户控制。当然，从 `RabbitMQ` 的全局角度，`vhost` 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 `vhost` 中）。


### 3、什么是Queue队列？

Queue 是 RabbitMQ 的内部对象，用于存储消息。多个消费者可以订阅同一队列，这时队列中的消息会被平摊（轮询）给多个消费者进行处理。


### 4、什么是消费者Consumer?

消费消息，也就是接收消息的一方。

消费者连接到RabbitMQ服务器，并订阅到队列上。消费消息时只消费消息体，丢弃标签。


### 5、如何确保消息不丢失？

消息持久化，当然前提是队列必须持久化

RabbitMQ 确保持久性消息能从服务器重启中恢复的方式是，将它们写入磁盘上的一个持久化日志文件，当一条持久性消息到持久交换器上时，RabbitMQ 会在消息提交到日志文件后才发送响应。

一旦消费者从持久队列中消费了一条持久化消息，RabbitMQ 会在持久化日志中把这条消息标记为等待垃圾收集。如果持久化消息在被消费之前 RabbitMQ 重启，那么 RabbitMQ 会自动重建交换器和队列（以及绑定），并重新持久化日志文件中的消息到合适的队列。


### 6、RabbitMQ simple模式（即最简单的收发模式）

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_4.png#alt=35%5C_4.png)

**1、** 消息产生消息，将消息放入队列

**2、** 消息的消费者(consumer) 监听 消息队列,如果队列中有消息,就消费掉,消息被拿走后,自动从队列中删除(隐患 消息可能没有被消费者正确处理,已经从队列中消失了,造成消息的丢失，这里可以设置成手动的ack,但如果设置成手动ack，处理完后要及时发送ack消息给队列，否则会造成内存溢出)。


### 7、AMQP是什么?

RabbitMQ就是 AMQP 协议的 Erlang 的实现(当然 RabbitMQ 还支持 STOMP2、 MQTT3 等协议 ) AMQP 的模型架构 和 RabbitMQ 的模型架构是一样的，生产者将消息发送给交换器，交换器和队列绑定 。

RabbitMQ 中的交换器、交换器类型、队列、绑定、路由键等都是遵循的 AMQP 协议中相 应的概念。目前 RabbitMQ 最新版本默认支持的是 AMQP 0-9-1。


### 8、消息队列有什么缺点
### 9、消费者某些原因无法处理当前接受的消息如何来拒绝？
### 10、消费者接收消息过程？
### 11、生产者消息运转？
### 12、使用RabbitMQ有什么好处？
### 13、死信队列？
### 14、交换器无法根据自身类型和路由键找到符合条件队列时，有哪些处理？
### 15、集群中的节点类型？
### 16、cluster 中 node 的失效会对 consumer 产生什么影响？若是在 cluster 中创建了mirrored queue ，这时 node 失效会对 consumer 产生什么影响？
### 17、rabbitmq的集群
### 18、交换器4种类型？
### 19、使用rabbitmq的场景
### 20、如何确保消息接收方消费了消息?
### 21、AMQP模型的几大组件？
### 22、你们公司生产环境用的是什么消息中间件？
### 23、Kafka、ActiveMQ、RabbitMQ、RocketMQ 有什么优缺点？
### 24、RabbitMQ是什么？
### 25、消息基于什么传输？
### 26、如何确保消息正确地发送至RabbitMQ？ 如何确保消息接收方消费了消息？
### 27、多个消费者监听一个队列时，消息如何分发?
### 28、Consumer Cancellation Notification 机制用于什么场景？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
