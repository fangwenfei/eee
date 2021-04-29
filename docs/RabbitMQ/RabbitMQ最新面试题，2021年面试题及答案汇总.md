# RabbitMQ最新面试题，2021年面试题及答案汇总

### 其实，博主还整理了，更多大厂面试题，直接下载吧

### 下载链接：[高清172份，累计 7701 页大厂面试题  PDF](https://github.com/souyunku/DevBooks/blob/master/docs/index.md)



### 1、为什么要使用rabbitmq

**1、** 在分布式系统下具备异步,削峰,负载均衡等一系列高级功能;

**2、** 拥有持久化的机制，进程消息，队列中的信息也可以保存下来。

**3、** 实现消费者和生产者之间的解耦。

**4、** 对于高并发场景下，利用消息队列可以使得同步访问变为串行访问达到一定量的限流，利于数据库的操作。

5.可以使用消息队列达到异步下单的效果，排队中，后台进行逻辑下单。


### 2、如何确保消息不丢失？

消息持久化，当然前提是队列必须持久化

RabbitMQ 确保持久性消息能从服务器重启中恢复的方式是，将它们写入磁盘上的一个持久化日志文件，当一条持久性消息到持久交换器上时，RabbitMQ 会在消息提交到日志文件后才发送响应。

一旦消费者从持久队列中消费了一条持久化消息，RabbitMQ 会在持久化日志中把这条消息标记为等待垃圾收集。如果持久化消息在被消费之前 RabbitMQ 重启，那么 RabbitMQ 会自动重建交换器和队列（以及绑定），并重新持久化日志文件中的消息到合适的队列。


### 3、如何保证RabbitMQ消息的可靠传输？

消息不可靠的情况可能是消息丢失，劫持等原因；

丢失又分为：生产者丢失消息、消息列表丢失消息、消费者丢失消息；

**1、** 生产者丢失消息：

从生产者弄丢数据这个角度来看，RabbitMQ提供transaction和confirm模式来确保生产者不丢消息；

transaction机制就是说：发送消息前，开启事务（channel.txSelect()）,然后发送消息，如果发送过程中出现什么异常，事务就会回滚（channel.txRollback()）,如果发送成功则提交事务（channel.txCommit()）。然而，这种方式有个缺点：吞吐量下降；

confirm模式用的居多：一旦channel进入confirm模式，所有在该信道上发布的消息都将会被指派一个唯一的ID（从1开始），一旦消息被投递到所有匹配的队列之后；

rabbitMQ就会发送一个ACK给生产者（包含消息的唯一ID），这就使得生产者知道消息已经正确到达目的队列了；

如果rabbitMQ没能处理该消息，则会发送一个Nack消息给你，你可以进行重试操作。

**2、** 消息队列丢数据：

消息持久化。

处理消息队列丢数据的情况，一般是开启持久化磁盘的配置。

这个持久化配置可以和confirm机制配合使用，你可以在消息持久化磁盘后，再给生产者发送一个Ack信号。

这样，如果消息持久化磁盘之前，rabbitMQ阵亡了，那么生产者收不到Ack信号，生产者会自动重发。

那么如何持久化呢？

这里顺便说一下吧，其实也很容易，就下面两步

**1、** 将queue的持久化标识durable设置为true,则代表是一个持久的队列

**2、** 发送消息的时候将deliveryMode=2

这样设置以后，即使rabbitMQ挂了，重启后也能恢复数据

**3、** 消费者丢失消息：

消费者丢数据一般是因为采用了自动确认消息模式，改为手动确认消息即可！

消费者在收到消息之后，处理消息之前，会自动回复RabbitMQ已收到消息；

如果这时处理消息失败，就会丢失该消息；

解决方案：处理消息成功后，手动回复确认消息。


### 4、使用RabbitMQ有什么好处？

**1、** 服务间高度解耦

**2、** 异步通信性能高

**3、** 流量削峰


### 5、消息传输保证层级？

**1、** At most once：最多一次。消息可能会丢失，单不会重复传输。

**2、** At least once：最少一次。消息觉不会丢失，但可能会重复传输。

**3、** Exactly once：恰好一次，每条消息肯定仅传输一次。


### 6、cluster 中 node 的失效会对 consumer 产生什么影响？若是在 cluster 中创建了mirrored queue ，这时 node 失效会对 consumer 产生什么影响？

若是 consumer 所连接的那个 node 失效（无论该 node 是否为 consumer 所订阅queue 的 owner node），则 consumer 会在发现 TCP 连接断开时，按标准行为执行重连逻辑，并根据“Assume Nothing”原则重建相应的 fabric 即可。

若是失效的 node 为consumer 订阅 queue 的 owner node，则 consumer 只能通过 Consumer CancellationNotification 机制来检测与该 queue 订阅关系的终止，否则会出现傻等却没有任何消息来到的问题。


### 7、RoutingKey路由键？

生产者将消息发送给交换器的时候，会指定一个RoutingKey,用来指定这个消息的路由规则，这个RoutingKey需要与交换器类型和绑定键(BindingKey)联合使用才能最终生效。


### 8、MQ 有哪些常见问题？如何解决这些问题？

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


### 9、消息如何保证幂等性？

生产者方面：可以对每条消息生成一个msgID，以控制消息重复投递

```
AMQP.BasicProperties properties = new AMQP.BasicProperties.Builder()
porperties.messageId(String.valueOF(UUID.randomUUID()))
```

消费者方面：消息体中必须携带一个业务ID，如银行流水号，消费者可以根据业务ID去重，避免重复消费


### 10、RabbitMQ routing路由模式

![](https://gitee.com/souyunkutech/souyunku-home/raw/master/images/souyunku-web/2020/5/2/030/5/35_7.png#alt=35%5C_7.png)

**1、** 消息生产者将消息发送给交换机按照路由判断,路由是字符串(info) 当前产生的消息携带路由字符(对象的方法),交换机根据路由的key,只能匹配上路由key对应的消息队列,对应的消费者才能消费消息;

**2、** 根据业务功能定义路由字符串

**3、** 从系统的代码逻辑中获取对应的功能字符串,将消息任务扔到对应的队列中。

**4、** 业务场景:error 通知;EXCEPTION;错误通知的功能;传统意义的错误通知;客户通知;利用key路由,可以将程序中的错误封装成消息传入到消息队列中,开发者可以自定义消费者,实时接收错误;


### 11、消息如何被优先消费？
### 12、RabbitMQ中消息可能有的几种状态?
### 13、多个消费者监听一个队列时，消息如何分发?
### 14、如何保证RabbitMQ消息的顺序性？
### 15、什么是元数据？元数据分为哪些类型？包括哪些内容？与 cluster 相关的元数据有哪些？元数据是如何保存的？元数据在 cluster 中是如何分布的？
### 16、在单 node 系统和多 node 构成的 cluster 系统中声明 queue、exchange ，以及进行 binding 会有什么不同？
### 17、Queue队列？
### 18、什么情况下 producer 不主动创建 queue 是安全的？
### 19、Consumer Cancellation Notification 机制用于什么场景？
### 20、RabbitMQ 包括哪些要素？
### 21、为什么 heavy RPC 的使用场景下不建议采用 disk node ？
### 22、什么是RabbitMQ？
### 23、消息在什么时候会变成死信?
### 24、使用rabbitmq的场景
### 25、mq的缺点
### 26、集群中的节点类型？
### 27、vhost 是什么? 起什么作用?




## 全部答案，整理好了，直接下载吧

### 下载链接：[全部答案，整理好了](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin-2.png)




## 最新，高清PDF：172份，7701页，最新整理

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/mst.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")

[![大厂面试题](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")](https://www.souyunku.com/wp-content/uploads/weixin/githup-weixin.png "架构师专栏")
