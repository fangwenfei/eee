# RabbitMQ最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、RabbitMQ如何实现延时队列?

利用TTL（队列的消息存活时间或者消息存活时间），加上死信交换机

```
// 设置属性，消息10秒钟过期
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
.expiration("10000") // TTL

// 指定队列的死信交换机
Map<String,Object> arguments = new HashMap<String,Object>();
arguments.put("x-dead-letter-exchange","DLX_EXCHANGE");
```


### 2、RabbitMQ 上的一个 queue 中存放的 message 是否有数量限制？

可以认为是无限制，因为限制取决于机器的内存，但是消息过多会导致处理效率的下降。


### 3、为什么要使用rabbitmq

**1、** 在分布式系统下具备异步,削峰,负载均衡等一系列高级功能;

**2、** 拥有持久化的机制，进程消息，队列中的信息也可以保存下来。

**3、** 实现消费者和生产者之间的解耦。

**4、** 对于高并发场景下，利用消息队列可以使得同步访问变为串行访问达到一定量的限流，利于数据库的操作。

5.可以使用消息队列达到异步下单的效果，排队中，后台进行逻辑下单。


### 4、如何保证RabbitMQ消息的顺序性？

**1、** 拆分多个 queue(消息队列)，每个 queue(消息队列) 一个 consumer(消费者)，就是多一些 queue (消息队列)而已，确实是麻烦点；

**2、** 或者就一个 queue (消息队列)但是对应一个 consumer(消费者)，然后这个 consumer(消费者)内部用内存队列做排队，然后分发给底层不同的 worker 来处理。


### 5、设计MQ思路

**1、** 比如说这个消息队列系统，我们从以下几个角度来考虑一下：

**2、** 首先这个 mq 得支持可伸缩性吧，就是需要的时候快速扩容，就可以增加吞吐量和容量，那怎么搞？设计个分布式的系统呗，参照一下 Kafka 的设计理念，broker -> topic -> partition，每个 partition 放一个机器，就存一部分数据。如果现在资源不够了，简单啊，给 topic 增加 partition，然后做数据迁移，增加机器，不就可以存放更多数据，提供更高的吞吐量了？

**3、** 其次你得考虑一下这个 mq 的数据要不要落地磁盘吧？那肯定要了，落磁盘才能保证别进程挂了数据就丢了。那落磁盘的时候怎么落啊？顺序写，这样就没有磁盘随机读写的寻址开销，磁盘顺序读写的性能是很高的，这就是 Kafka 的思路。

**4、** 其次你考虑一下你的 mq 的可用性啊？这个事儿，具体参考之前可用性那个环节讲解的 Kafka 的高可用保障机制。多副本 -> leader & follower -> broker 挂了重新选举 leader 即可对外服务。

**5、** 能不能支持数据 0 丢失啊？可以呀，有点复杂的。



### 6、vhost 是什么？起什么作用？

vhost 可以理解为虚拟 broker ，即 mini-RabbitMQ server。其内部均含有独立的queue、exchange 和 binding 等，但最最重要的是，其拥有独立的权限系统，可以做到vhost 范围的用户控制。

当然，从 RabbitMQ 的全局角度，vhost 可以作为不同权限隔离的手段（一个典型的例子就是不同的应用可以跑在不同的 vhost 中）。


### 7、RoutingKey路由键？

生产者将消息发送给交换器的时候，会指定一个RoutingKey,用来指定这个消息的路由规则，这个RoutingKey需要与交换器类型和绑定键(BindingKey)联合使用才能最终生效。


### 8、消息如何分发？
### 9、消息在什么时候会变成死信?
### 10、Basic.Reject 的用法是什么？
### 11、RabbitMQ有那些基本概念？
### 12、无法被路由的消息去了哪里?
### 13、队列结构？
### 14、RabbitMQ基本概念
### 15、什么是rabbitmq
### 16、消费者接收消息过程？
### 17、在单 node 系统和多 node 构成的 cluster 系统中声明 queue、exchange ，以及进行 binding 会有什么不同？
### 18、RabbitMQ routing路由模式
### 19、消息如何分发？
### 20、如何保证RabbitMQ消息的可靠传输？
### 21、RabbitMQ 允许发送的 message 最大可达多大？
### 22、什么是Binding绑定？
### 23、什么是元数据？元数据分为哪些类型？包括哪些内容？与 cluster 相关的元数据有哪些？元数据是如何保存的？元数据在 cluster 中是如何分布的？
### 24、消息传输保证层级？
### 25、mq的缺点
### 26、AMQP模型的几大组件？
### 27、如何保证RabbitMQ消息的可靠传输？




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
